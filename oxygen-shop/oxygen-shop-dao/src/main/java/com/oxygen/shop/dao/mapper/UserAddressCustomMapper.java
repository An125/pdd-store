package com.oxygen.shop.dao.mapper;

import java.util.List;

import com.oxygen.shop.common.po.UserAddress;
import com.oxygen.shop.common.vo.UserAddressVo;

public interface UserAddressCustomMapper {
	
//	保存一个地址
	public int addAddress(UserAddressVo userAddressVo) throws Exception;
	
//	查询该用户是否已有默认
	public List<UserAddress> selectDefault(UserAddressVo userAddressVo) throws Exception;

//	把原先默认改成1
	public int changeDefaultToOne(UserAddressVo userAddressVo) throws Exception;

//	删除收货地址  
	public int deleteAddress(UserAddressVo userAddressVo) throws Exception;

//	修改收货地址
	public int updateAddress(UserAddressVo userAddressVo) throws Exception;

//	查询收货地址
	public List<UserAddress> selectAddress(UserAddressVo userAddressVo) throws Exception;

//	修改默认
	public int updateDefault(UserAddressVo userAddressVo) throws Exception;

//	List<UserAddress> select(String user_id, String mobile) throws Exception;
}
