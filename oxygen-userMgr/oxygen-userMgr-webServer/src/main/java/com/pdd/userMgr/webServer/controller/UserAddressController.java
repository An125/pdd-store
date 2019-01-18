package com.pdd.userMgr.webServer.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pdd.common.core.params.returns.MsgReturn;
import com.pdd.userMgr.api.Vo.UserAddressVo;
import com.pdd.userMgr.api.params.UserAddressParams;
import com.pdd.userMgr.api.service.StoreUserAddressService;

/**
 * @描述：用户地址管理控制器
 * @作者： wu.liang
 * @日期：Feb 26, 2018
 */
@RestController
@RequestMapping("/userMgr")
public class UserAddressController {
	private static Logger LOG = Logger.getLogger(UserAddressController.class);
	
	@Autowired
	private StoreUserAddressService storeUserAddressService;
	
	/**
	 * 
	 * @描述：新增用户收货地址
	 * @作者：Wu.Liang
	 * @param userAddressParams
	 * @return
	 */
	@PostMapping("/userAddressAdd")
	public MsgReturn<UserAddressVo> userAddressAdd(UserAddressParams userAddressParams) {
		// 1、创建新的返回对象（这里泛型指返回消息中带的对象是商品 VO）
		MsgReturn<UserAddressVo> msg = new MsgReturn<UserAddressVo>();
		try {
			
			// 2、参数验证
			if (userAddressParams.getUserId() == null || userAddressParams.getUserId() == 0) {
				msg.failed("用户ID不得为空");
			} else {

				// 3、处理业务逻辑
				UserAddressVo addressVo= storeUserAddressService.addUserAddressByUserId(userAddressParams);

				// 4、把对象设置进返回消息中
				if (addressVo == null) {
					msg.failed("添加收货地址失败");
				} else {
					msg.setReturnObj(addressVo);
					msg.success("添加收货地址成功");
				}
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			msg.exception();
		}

		// 5、将返回的对象返回， 框架自动转成 JSON 对象
		return msg;
	}
	
	/**
	 * @描述：收货地址查询
	 * @作者：Wu.Liang
	 * @param userAddressParams
	 * @return
	 */
	@PostMapping("/userAddressQuery")
	public MsgReturn<List<UserAddressVo>> userAddressQuery(UserAddressParams userAddressParams) {
		
		// 1、创建新的返回对象（这里泛型指返回消息中带的对象是商品 VO）
		MsgReturn<List<UserAddressVo>> msg = new MsgReturn<List<UserAddressVo>>();
		try {
			
			// 2、参数验证
			if (userAddressParams.getUserId() == null || userAddressParams.getUserId() == 0) {
				msg.failed("用户ID不得为空");
			} else {

				// 3、处理业务逻辑
				List<UserAddressVo> vos= storeUserAddressService.findUserAddresses(userAddressParams);

				// 4、把对象设置进返回消息中
				if (vos == null) {
					msg.failed();
				} else {
					msg.setReturnObj(vos);
					msg.success();
				}
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			msg.exception();
		}

		// 5、将返回的对象返回， 框架自动转成 JSON 对象
		return msg;
	}
	
	/**
	 * @描述：收货地址修改默认
	 * @作者：Wu.Liang
	 * @param userAddressParams
	 * @return
	 */
	@PostMapping("/userAddressChangeDefault")
	public MsgReturn<UserAddressVo> userAddressChangeDefault(UserAddressParams userAddressParams) {
		
		// 1、创建新的返回对象（这里泛型指返回消息中带的对象是商品 VO）
		MsgReturn<UserAddressVo> msg = new MsgReturn<UserAddressVo>();
		try {
			
			// 2、参数验证
			if (userAddressParams.getId() == null || userAddressParams.getId() == 0) {
				msg.failed("ID不得为空");
			}else if (userAddressParams.getUserId() == null || userAddressParams.getUserId() == 0) {
				msg.failed("用户ID不得为空");
			} else {

				// 3、处理业务逻辑
				int result = storeUserAddressService.updateForChangeDefaultAddress(userAddressParams);

				// 4、把对象设置进返回消息中
				if (result > 0) {
					msg.success();
				} else {
					msg.failed();
				}
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			msg.exception();
		}

		// 5、将返回的对象返回， 框架自动转成 JSON 对象
		return msg;
	}
	
	/**
	 * 
	 * @描述：修改用户收货地址
	 * @作者：Wu.Liang
	 * @param userAddressParams
	 * @return
	 */
	@PostMapping("/userAddressUpdate")
	public MsgReturn<UserAddressVo> userAddressUpdate(UserAddressParams userAddressParams) {
		// 1、创建新的返回对象（这里泛型指返回消息中带的对象是商品 VO）
		MsgReturn<UserAddressVo> msg = new MsgReturn<UserAddressVo>();
		try {
			
			// 2、参数验证
			if (userAddressParams.getId() == null || userAddressParams.getId() == 0) {
				msg.failed("ID标识不得为空");
			} else {

				// 3、处理业务逻辑
				int result = storeUserAddressService.updateUserAddressById(userAddressParams);

				// 4、把对象设置进返回消息中
				if (result > 0) {
					msg.success();
				} else {
					msg.failed();
				}
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			msg.exception();
		}

		// 5、将返回的对象返回， 框架自动转成 JSON 对象
		return msg;
	}
	
	/**
	 * 
	 * @描述：删除用户收货地址
	 * @作者：Wu.Liang
	 * @param userAddressParams
	 * @return
	 */
	@PostMapping("/userAddressDelete")
	public MsgReturn<UserAddressVo> userAddressDelete(UserAddressParams userAddressParams) {
		// 1、创建新的返回对象（这里泛型指返回消息中带的对象是商品 VO）
		MsgReturn<UserAddressVo> msg = new MsgReturn<UserAddressVo>();
		try {
			
			// 2、参数验证
			if (userAddressParams.getId() == null || userAddressParams.getId() == 0) {
				msg.failed("ID标识不得为空");
			} else {

				// 3、处理业务逻辑
				int result = storeUserAddressService.deleteUserAddressById(userAddressParams);

				// 4、把对象设置进返回消息中
				if (result > 0) {
					msg.success();
				} else {
					msg.failed();
				}
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			msg.exception();
		}

		// 5、将返回的对象返回， 框架自动转成 JSON 对象
		return msg;
	}
}
