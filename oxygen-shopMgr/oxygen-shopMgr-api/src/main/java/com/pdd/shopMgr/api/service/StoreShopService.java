package com.pdd.shopMgr.api.service;

import com.pdd.shopMgr.common.params.StoreShopParams;
import com.pdd.shopMgr.common.vo.StoreShopVo;

/**
 * 
 * @描述：商铺 Dubbo 服务接口 
 * @作者： wu.liang
 * @日期：Feb 6, 2018
 */
public interface StoreShopService {

	/**
	 * 商户登录
	 * @param storeShopParams
	 * @return 手机号或密码为空则返回 null 
	 */
	public StoreShopVo getForLogin(StoreShopParams storeShopParams) throws Exception;

	/**
	 * 注册
	 * @param storeShopParams
	 * @return
	 */
	public StoreShopVo saveForRegister(StoreShopParams storeShopParams) throws Exception;

	/**
	 * 根据手机号获取商铺
	 * @描述：
	 * @作者：Wu.Liang
	 * @param phoneNumber
	 * @return
	 * @throws Exception
	 */
	public StoreShopVo getByPhoneNumber(String phoneNumber) throws Exception;

	/**
	 * 根据身份证号获取商铺
	 * @描述：
	 * @作者：Wu.Liang
	 * @param identityCard
	 * @return
	 * @throws Exception
	 */
	public StoreShopVo getByIdentityCard(String identityCard) throws Exception;

}
