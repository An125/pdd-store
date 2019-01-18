package com.pdd.userMgr.api.service;

import java.util.List;

import com.pdd.userMgr.api.Vo.UserAddressVo;
import com.pdd.userMgr.api.params.UserAddressParams;

/**
 * 
 * @描述：用户收货地址处理
 * @作者： wu.liang
 * @日期：Feb 27, 2018
 */
public interface StoreUserAddressService {

	/**
	 * @描述：新增收货地址
	 * @作者：Wu.Liang
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public UserAddressVo addUserAddressByUserId(UserAddressParams userAddressParams) throws Exception;

	/**
	 * @描述：查找用户收货地址
	 * @作者：Wu.Liang
	 * @param userAddressParams
	 * @return
	 */
	public List<UserAddressVo> findUserAddresses(UserAddressParams userAddressParams) throws Exception;

	/**
	 * @描述：修改默认收货地址
	 * @作者：Wu.Liang
	 * @param userAddressParams
	 * @return
	 * @throws Exception
	 */
	public int updateForChangeDefaultAddress(UserAddressParams userAddressParams) throws Exception;

	/**
	 * @描述：修改用户收货地址
	 * @作者：Wu.Liang
	 * @param userAddressParams
	 * @return
	 */
	public int updateUserAddressById(UserAddressParams userAddressParams) throws Exception;

	/**
	 * @描述：删除用户收货地址
	 * @作者：Wu.Liang
	 * @param userAddressParams
	 * @return
	 * @throws Exception
	 */
	public int deleteUserAddressById(UserAddressParams userAddressParams) throws Exception;

}
