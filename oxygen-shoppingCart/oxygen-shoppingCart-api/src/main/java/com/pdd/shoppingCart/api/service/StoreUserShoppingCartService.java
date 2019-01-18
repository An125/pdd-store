package com.pdd.shoppingCart.api.service;

import com.pdd.common.core.params.page.Page;
import com.pdd.shoppingCart.common.params.StoreUserShoppingCartParams;
import com.pdd.userMgr.common.vo.StoreUserShoppingCartVo;

public interface StoreUserShoppingCartService {
	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年2月26日
	 * @描述：添加购物车
	 */
	public StoreUserShoppingCartVo cartAppend(StoreUserShoppingCartParams storeUserShoppingCartParams) throws Exception;

	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年2月27日
	 * @描述：删除购物车（不是物理上的删除，只是修改状态）
	 */
	public StoreUserShoppingCartVo cartRemove(StoreUserShoppingCartParams storeUserShoppingCartParams) throws Exception;

	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年2月27日
	 * @描述：修改购物车
	 */
	public StoreUserShoppingCartVo cartModify(StoreUserShoppingCartParams storeUserShoppingCartParams) throws Exception;
	
	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年2月27日
	 * @描述：分页查询购物车
	 */
	public Page<StoreUserShoppingCartVo> cartPageSelect(StoreUserShoppingCartParams storeUserShoppingCartParams) throws Exception;

}
