package com.oxygen.shop.rpc.api;

import com.oxygen.shop.common.vo.UserAddressVo;

import net.sf.json.JSONObject;

public interface UserAddressService {
//	保存一个地址
	public JSONObject addAddress(UserAddressVo userAddressVo) throws Exception;

//	查询改用户是否已有默认
	public JSONObject selectDefault(UserAddressVo userAddressVo) throws Exception;

//	把原先默认改成1
	public JSONObject changeDefaultToOne(UserAddressVo userAddressVo) throws Exception;

//	删除收货地址
	public JSONObject deleteAddress(UserAddressVo userAddressVo) throws Exception;

//	修改收货地址
	public JSONObject updateAddress(UserAddressVo userAddressVo) throws Exception;
	
//	查询收货地址
	public JSONObject selectAddress(UserAddressVo userAddressVo) throws Exception;
	
//	修改默认
	public JSONObject updateDefault(UserAddressVo userAddressVo) throws Exception;
	
//	public JSONObject select(String user_id, String mobile) throws Exception;
}
