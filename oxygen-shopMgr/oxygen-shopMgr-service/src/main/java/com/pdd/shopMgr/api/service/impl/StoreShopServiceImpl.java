package com.pdd.shopMgr.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pdd.shopMgr.api.service.StoreShopService;
import com.pdd.shopMgr.common.params.StoreShopParams;
import com.pdd.shopMgr.common.vo.StoreShopVo;
import com.pdd.shopMgr.service.operator.StoreShopOperator;

@Service("storeShopService")
public class StoreShopServiceImpl implements StoreShopService {

	@Autowired
	private StoreShopOperator storeShopOperator;

	/**
	 * 商户登录
	 * @param storeShopParams
	 * @return 手机号或密码为空则返回 null 
	 * @throws Exception 
	 */
	@Override
	public StoreShopVo getForLogin(StoreShopParams storeShopParams) throws Exception {
		return storeShopOperator.getForLogin(storeShopParams.getPhoneNumber(), storeShopParams.getPassword());
	}

	/**
	 * 注册
	 * @param storeShopParams
	 * @return
	 * @throws Exception 
	 */
	@Override
	public StoreShopVo saveForRegister(StoreShopParams storeShopParams) throws Exception {
		return storeShopOperator.saveForRegister(storeShopParams);
	}

	@Override
	public StoreShopVo getByPhoneNumber(String phoneNumber) throws Exception {
		return storeShopOperator.getByPhoneNumber(phoneNumber);
	}

	@Override
	public StoreShopVo getByIdentityCard(String identityCard) throws Exception {
		return storeShopOperator.getByIdentityCard(identityCard);
	}
}
