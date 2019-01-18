package com.pdd.userMgr.api.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pdd.userMgr.common.constants.Constants;
import com.oxygen.common.util.AESUtil;
import com.oxygen.common.util.StringUtil;
import com.pdd.common.core.exceptions.BizException;
import com.pdd.userMgr.api.Vo.UserVo;
import com.pdd.userMgr.api.params.UserParams;
import com.pdd.userMgr.api.service.StoreUserService;
import com.pdd.userMgr.service.mapper.StoreShopMapper;
import com.pdd.userMgr.service.mapper.StoreShopUserMapper;
import com.pdd.userMgr.service.mapper.StoreUserMapper;
import com.pdd.userMgr.service.po.StoreShop;
import com.pdd.userMgr.service.po.StoreShopExample;
import com.pdd.userMgr.service.po.StoreShopUser;
import com.pdd.userMgr.service.po.StoreUser;
import com.pdd.userMgr.service.po.StoreUserExample;

/**
 * 用户业务实现 @描述： @作者： wu.liang
 * 
 * @日期：Feb 26, 2018
 */
@Service("storeUserService")
@Transactional
public class StoreUserServiceImpl implements StoreUserService {

	@Autowired
	private StoreShopMapper storeShopMapper;

	@Autowired
	private StoreShopUserMapper storeShopUserMapper;

	@Autowired
	private StoreUserMapper storeUserMapper;

	/**
	 * @描述：用户注册
	 * @作者：Wu.Liang
	 * @param userParams
	 * @return
	 * @throws Exception
	 */
	@Override
	public UserVo addStoreUser(UserParams userParams) throws Exception {
		// 根据邀请码获取用户/店铺
		String invitation = userParams.getInvitation();

		// 新数据库User对象
		StoreUser newUser = new StoreUser();
		BeanUtils.copyProperties(userParams, newUser);

		// 判断邀请码
		if (invitation == null || "".equals(invitation)) {

			// 邀请码为空则默认为总公司下用户
			newUser.setInvitation(Constants.DB_ROOT_PDD_GENERATED);
			newUser.setShopId(Constants.DB_ROOT_PDD_SHOP_ID);
		} else if (invitation.startsWith(Constants.DB_GENERATED_FLAG_STORESHOP)) {

			// 如果邀请码为商铺邀请码，以“SH”开头
			StoreShopExample example = new StoreShopExample();
			StoreShopExample.Criteria criteria = example.createCriteria();
			criteria.andGeneratedEqualTo(invitation); // 店铺邀请码等于传入的邀请码
			List<StoreShop> list = storeShopMapper.selectByExample(example);
			if (list == null || list.isEmpty()) {
				newUser.setInvitation(Constants.DB_ROOT_PDD_GENERATED);
				newUser.setShopId(Constants.DB_ROOT_PDD_SHOP_ID);
			} else {
				newUser.setInvitation(invitation);
				newUser.setShopId(list.get(0).getId());
			}
		} else if (invitation.startsWith(Constants.DB_GENERATED_FLAG_STOREUSER)) {

			// 如果邀请码为用户邀请码，以“YH”开头
			StoreUserExample example = new StoreUserExample();
			StoreUserExample.Criteria criteria = example.createCriteria();
			criteria.andGeneratedEqualTo(invitation); // 传入的邀请码等于某用户的邀请码
			List<StoreUser> list = storeUserMapper.selectByExample(example);
			if (list == null || list.isEmpty()) {
				newUser.setInvitation(Constants.DB_ROOT_PDD_GENERATED);
				newUser.setShopId(Constants.DB_ROOT_PDD_SHOP_ID);
			} else {

				// 找到用户后，他关联的店铺成为新注册用户关联的店铺
				newUser.setInvitation(invitation);
				newUser.setShopId(list.get(0).getShopId());
			}
		}else {
			return null;
		}

		Date date = new Date();
		newUser.setCreateTime(date);
		newUser.setGenerated(StringUtil.generateUUIDByPrefix(Constants.DB_GENERATED_FLAG_STOREUSER));
		newUser.setType(0);
		newUser.setUpdateDate(date);
		newUser.setPassword(AESUtil.AESEncode(userParams.getPassword()));
		if (newUser.getUsername() == null || "".equals(newUser.getUsername())) {
			newUser.setUsername(newUser.getMobile());
		}

		int insertSelective = storeUserMapper.insertSelective(newUser);
		if (insertSelective > 0) {

			// 保存用户 -- 商铺 关系表
			StoreShopUser ssu = new StoreShopUser();
			ssu.setId(StringUtil.generateUUID());
			ssu.setShopId(newUser.getShopId());
			ssu.setUserId(newUser.getId());
			int result = storeShopUserMapper.insertSelective(ssu);
			if (result > 0) {

				UserVo vo = new UserVo();
				BeanUtils.copyProperties(newUser, vo);
				return vo;
			} else {
				throw BizException.DB_INSERT_RESULT_0;
			}
		} else {
			return null;
		}
	}

	/**
	 * @描述：手机号是否可以使用
	 * @作者：Wu.Liang
	 * @param mobile
	 * @return
	 */
	@Override
	public boolean isMobileCanUse(String mobile) throws Exception {
		StoreUserExample example = new StoreUserExample();
		StoreUserExample.Criteria criteria = example.createCriteria();
		criteria.andMobileEqualTo(mobile);
		List<StoreUser> users = storeUserMapper.selectByExample(example);
		if (users == null || users.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @描述：验证用户是否存在
	 * @作者：Wu.Liang
	 * @param mobile 手机号
	 * @param password 密码
	 * @return
	 * @throws Exception
	 */
	@Override
	public UserVo checkUser(String mobile, String password) throws Exception {
		// TODO Auto-generated method stubstoreUserMapper
		StoreUserExample example = new StoreUserExample();
		StoreUserExample.Criteria criteria = example.createCriteria();
		criteria.andMobileEqualTo(mobile);
		criteria.andPasswordEqualTo(AESUtil.AESEncode(password));
		List<StoreUser> users = storeUserMapper.selectByExample(example);
		if(users==null||users.isEmpty()) {
			return null;
		}else {
			UserVo vo = new UserVo();
			
			BeanUtils.copyProperties(users.get(0), vo);
			return vo;
		}
	}
	
	/**
	 * 图片上传（存储到数据库）
	 * @param fastDFS_Id 图片存储在服务器的路径
	 * @return 
	 */
	@Override
	public UserVo pictureUpload(String mobile,String fastDFS_Id) throws Exception {
		StoreUser storeUser = new StoreUser();
		StoreUserExample example = new StoreUserExample();
		example.createCriteria().andMobileEqualTo(mobile);
		storeUser.setTxpath(fastDFS_Id);
		storeUser.setUpdateDate(new Date());
		int result = storeUserMapper.updateByExampleSelective(storeUser, example);
		if(result>0) {
			UserVo vo = new UserVo();
			BeanUtils.copyProperties(storeUser, vo);
			return vo;
		}else {
			throw BizException.DB_UPDATE_RESULT_0;
		}
		
	}

}
