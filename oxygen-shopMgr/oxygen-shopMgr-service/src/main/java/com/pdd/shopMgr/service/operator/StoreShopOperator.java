package com.pdd.shopMgr.service.operator;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oxygen.common.util.AESUtil;
import com.oxygen.common.util.StringUtil;
import com.pdd.shopMgr.common.constants.Constants;
import com.pdd.shopMgr.common.params.StoreShopParams;
import com.pdd.shopMgr.common.vo.StoreShopVo;
import com.pdd.shopMgr.service.mapper.StoreGoodsMapper;
import com.pdd.shopMgr.service.mapper.StoreShopGoodsRelationMapper;
import com.pdd.shopMgr.service.mapper.StoreShopMapper;
import com.pdd.shopMgr.service.po.StoreGoods;
import com.pdd.shopMgr.service.po.StoreShop;
import com.pdd.shopMgr.service.po.StoreShopExample;
import com.pdd.shopMgr.service.po.StoreShopExample.Criteria;
import com.pdd.shopMgr.service.po.StoreShopGoodsRelation;

/**
 * 
 * @描述：商铺相关业务 ---- 服务层 @作者： wu.liang
 * @日期：Feb 7, 2018
 */
@Service("storeShopOperator")
public class StoreShopOperator {

	@Autowired
	private StoreShopMapper storeShopMapper;

	@Autowired
	private StoreGoodsMapper storeGoodsMapper;

	@Autowired
	private StoreShopGoodsRelationMapper storeShopGoodsRelationMapper;

	/**
	 * 登录
	 * 
	 * @param phoneNumber
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public StoreShopVo getForLogin(String phoneNumber, String password) throws Exception {
		StoreShopExample example = new StoreShopExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andPhoneNumberEqualTo(phoneNumber);
		createCriteria.andPasswordEqualTo(AESUtil.AESEncode(password));

		List<StoreShop> selectByExample = storeShopMapper.selectByExample(example);
		if (selectByExample.isEmpty() || selectByExample == null) {
			return null;
		}
		StoreShopVo vo = new StoreShopVo();
		BeanUtils.copyProperties(selectByExample.get(0), vo);
		return vo;
	}

	/**
	 * 注册
	 * 
	 * @param storeShopParams
	 * @return
	 * @throws Exception
	 */
	public StoreShopVo saveForRegister(StoreShopParams storeShopParams) throws Exception {
		StoreShop storeShop = new StoreShop();

		// 填数据
		storeShop.setCreateDate(new Date());
		storeShop.setGenerated(StringUtil.generateUUIDByPrefix(Constants.DB_STORESHOP_GENERATED_FLAG));
		storeShop.setId(StringUtil.generateUUID());
		storeShop.setIdentityCard(storeShopParams.getIdentityCard());
		storeShop.setPassword(AESUtil.AESEncode(storeShopParams.getPassword()));
		storeShop.setPhoneNumber(storeShopParams.getPhoneNumber());
		storeShop.setShopName(storeShopParams.getShopName());
		storeShop.setStatus(Constants.DB_STORESHOP_STATUS_ENABLED);
		storeShop.setLevel(Constants.DB_STORESHOP_LEVEL_CHILD);

		// 插入数据库
		int result = storeShopMapper.insertSelective(storeShop);

		// 循环批量插入商铺商品中间表
		StoreShopGoodsRelation ssgr = null;
		StoreGoods g = null;
		if (result > 0) {
			List<StoreGoods> goods = storeGoodsMapper.selectByExample(null);
			Iterator<StoreGoods> iterator = goods.iterator();
			while (iterator.hasNext()) {
				g = iterator.next();
				ssgr = new StoreShopGoodsRelation();
				ssgr.setIsEnable((byte) 1);
				// 把商品最高价格插入到中间表
				ssgr.setPrice(g.getHighPrice());
				ssgr.setGoodId(g.getId());
				ssgr.setShopId(storeShop.getId());
				storeShopGoodsRelationMapper.insert(ssgr);
			}
			StoreShopVo ssVo = new StoreShopVo();
			BeanUtils.copyProperties(storeShop, ssVo);
			return ssVo;
		} else {
			return null;
		}
	}

	public StoreShopVo getByPhoneNumber(String phoneNumber) throws Exception {
		StoreShopExample example = new StoreShopExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andPhoneNumberEqualTo(phoneNumber);
		List<StoreShop> selectByExample = storeShopMapper.selectByExample(example);
		if (selectByExample == null || selectByExample.isEmpty()) {
			return null;
		}
		StoreShop storeShop = selectByExample.get(0);
		StoreShopVo vo = new StoreShopVo();
		BeanUtils.copyProperties(storeShop, vo);
		return vo;
	}

	public StoreShopVo getByIdentityCard(String identityCard) throws Exception {
		StoreShopExample example = new StoreShopExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andIdentityCardEqualTo(identityCard);
		List<StoreShop> selectByExample = storeShopMapper.selectByExample(example);
		if (selectByExample == null || selectByExample.isEmpty()) {
			return null;
		}
		StoreShop storeShop = selectByExample.get(0);
		StoreShopVo vo = new StoreShopVo();
		BeanUtils.copyProperties(storeShop, vo);
		return vo;
	}
}