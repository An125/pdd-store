package com.pdd.userMgr.api.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pdd.userMgr.api.Vo.UserAddressVo;
import com.pdd.userMgr.api.params.UserAddressParams;
import com.pdd.userMgr.service.mapper.StoreUserAddressMapper;
import com.pdd.userMgr.service.mapper.StoreUserMapper;
import com.pdd.userMgr.service.po.StoreUser;
import com.pdd.userMgr.service.po.StoreUserAddress;
import com.pdd.userMgr.service.po.StoreUserAddressExample;
import com.pdd.userMgr.service.po.StoreUserAddressExample.Criteria;

/**
 * 
 * @描述：用户收货地址处理 @作者： wu.liang
 * @日期：Feb 27, 2018
 */
@Service("storeUserAddressService")
public class StoreUserAddressServiceImpl implements com.pdd.userMgr.api.service.StoreUserAddressService {

	@Autowired
	private StoreUserMapper storeUserMapper;

	@Autowired
	private StoreUserAddressMapper storeUserAddressMapper;

	/**
	 * @描述：新增收货地址
	 * @作者：Wu.Liang
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@Override
	public UserAddressVo addUserAddressByUserId(UserAddressParams userAddressParams) throws Exception {
		StoreUser user = storeUserMapper.selectByPrimaryKey(userAddressParams.getUserId());
		if (user == null) {
			// 找不到用户返回null
			return null;
		} else {
			StoreUserAddress addr = new StoreUserAddress();
			BeanUtils.copyProperties(userAddressParams, addr);
			Date date = new Date();
			addr.setCreateDate(date);
			addr.setUpdateDate(date);

			// 查找用户下面所有地址信息，如果没有，新增的地址为默认
			StoreUserAddressExample example = new StoreUserAddressExample();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andUserIdEqualTo(userAddressParams.getUserId());
			List<StoreUserAddress> addresses = storeUserAddressMapper.selectByExample(example);
			if (addresses == null || addresses.isEmpty()) {
				addr.setIsChoice((byte) 1);
			} else {
				addr.setIsChoice((byte) 0);
			}
			// 插入对象
			int insert = storeUserAddressMapper.insert(addr);

			if (insert > 0) {
				UserAddressVo vo = new UserAddressVo();
				BeanUtils.copyProperties(addr, vo);

				return vo;
			} else {
				return null;
			}
		}
	}

	/**
	 * @描述：查找用户收货地址
	 * @作者：Wu.Liang
	 * @param userAddressParams
	 * @return
	 */
	@Override
	public List<UserAddressVo> findUserAddresses(UserAddressParams userAddressParams) throws Exception {
		StoreUserAddressExample example = new StoreUserAddressExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUserIdEqualTo(userAddressParams.getUserId());
		List<StoreUserAddress> addresses = storeUserAddressMapper.selectByExample(example);
		if (addresses == null || addresses.isEmpty()) {

			return null;
		}else {
			List<UserAddressVo> vos = new ArrayList<UserAddressVo>(addresses.size());
			Iterator<StoreUserAddress> iterator = addresses.iterator();
			StoreUserAddress address = null;
			UserAddressVo vo = null;
			while(iterator.hasNext()) {
				vo = new UserAddressVo();
				address = iterator.next();
				BeanUtils.copyProperties(address, vo);
				vos.add(vo);
			}
			return vos;
		}
	}

	/**
	 * @描述：修改默认收货地址
	 * @作者：Wu.Liang
	 * @param userAddressParams
	 * @return
	 * @throws Exception
	 */
	@Override
	public int updateForChangeDefaultAddress(UserAddressParams userAddressParams) throws Exception {
		StoreUserAddress result = new StoreUserAddress();
		result.setIsChoice((byte)0);
		StoreUserAddressExample example = new StoreUserAddressExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUserIdEqualTo(userAddressParams.getUserId());
		//同一个userid下所有地址都改为非默认
		storeUserAddressMapper.updateByExampleSelective(result, example);
		
		// 将指定ID地址改为默认的
		result.setIsChoice((byte)1);
		StoreUserAddressExample example1 = new StoreUserAddressExample();
		Criteria createCriteria2 = example1.createCriteria();
		createCriteria2.andIdEqualTo(userAddressParams.getId());
		return storeUserAddressMapper.updateByExampleSelective(result, example1);
		
	}

	/**
	 * @描述：修改用户收货地址
	 * @作者：Wu.Liang
	 * @param userAddressParams
	 * @return
	 */
	@Override
	public int updateUserAddressById(UserAddressParams userAddressParams) throws Exception {
		StoreUserAddress result = new StoreUserAddress();
		BeanUtils.copyProperties(userAddressParams, result);
		
		StoreUserAddressExample example = new StoreUserAddressExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andIdEqualTo(userAddressParams.getId());
		return storeUserAddressMapper.updateByExampleSelective(result, example);
	}

	/**
	 * @描述：删除用户收货地址
	 * @作者：Wu.Liang
	 * @param userAddressParams
	 * @return
	 * @throws Exception
	 */
	@Override
	public int deleteUserAddressById(UserAddressParams userAddressParams) throws Exception {
		return storeUserAddressMapper.deleteByPrimaryKey(userAddressParams.getId());
	}
}
