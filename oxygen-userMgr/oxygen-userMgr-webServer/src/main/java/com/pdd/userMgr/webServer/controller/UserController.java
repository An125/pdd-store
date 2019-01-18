package com.pdd.userMgr.webServer.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pdd.common.core.params.returns.MsgReturn;
import com.pdd.userMgr.api.Vo.UserVo;
import com.pdd.userMgr.api.params.UserParams;
import com.pdd.userMgr.api.service.StoreUserService;

/**
 * @描述：用户注册
 * @作者： wu.liang
 * @日期：Feb 26, 2018
 */
@RestController
@RequestMapping("/userMgr")
public class UserController {

	private static Logger LOG = Logger.getLogger(UserController.class);
	@Autowired
	private StoreUserService storeUserService;

	/**
	 * @描述：用户注册
	 * @作者：Wu.Liang
	 * @param userParams
	 * @return
	 */
	@PostMapping("/userRegister")
	public MsgReturn<UserVo> register(UserParams userParams) {
		// 1、创建新的返回对象（这里泛型指返回消息中带的对象是商品 VO）
		MsgReturn<UserVo> msg = new MsgReturn<UserVo>();
		try {
			
			// 2、参数验证
			if (userParams.getMobile() == null || "".equals(userParams.getMobile())) {
				msg.failed("手机号码不得为空");
			} else if (userParams.getPassword() == null || "".equals(userParams.getPassword())) {
				msg.failed("密码不得为空");
			} else if (!userParams.getPassword().equals(userParams.getRepeatPassword())) {
				msg.failed("两次密码输入不一致");
			} else if (!storeUserService.isMobileCanUse(userParams.getMobile())) {
				msg.failed("该手机已被注册过");
			} else {

				// 3、处理业务逻辑
				UserVo vo = storeUserService.addStoreUser(userParams);

				// 4、把对象设置进返回消息中
				if (vo == null) {
					msg.failed("注册未成功，请确认您的邀请码是否填写正确，如没有可不填");
				} else {
					msg.setReturnObj(vo);
					msg.success("注册成功");
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
	 * @描述：传入手机号，验证一下用户是否存在
	 * @作者：Wu.Liang
	 * @param mobile
	 * @return
	 */
	@PostMapping("/userCheck")
	public MsgReturn<UserVo> userCheck(String mobile) {
		// 1、创建新的返回对象（这里泛型指返回消息中带的对象是商品 VO）
		MsgReturn<UserVo> msg = new MsgReturn<UserVo>();
		try {
			
			// 2、参数验证
			if (mobile == null || "".equals(mobile)) {
				msg.failed("手机号码不得为空");
			} else {

				// 3、处理业务逻辑
				boolean canUse = storeUserService.isMobileCanUse(mobile);

				// 4、把对象设置进返回消息中
				if (canUse == true) {
					msg.success("该手机号码可以注册");
				} else {
					msg.failed("该手机号码已被注册");
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
	 * @描述：用户登录
	 * @作者：Wu.Liang
	 * @param userParams
	 * @return
	 */
	@PostMapping("/userLogin")
	public MsgReturn<UserVo> userLogin(UserParams userParams) {
		// 1、创建新的返回对象（这里泛型指返回消息中带的对象是商品 VO）
		MsgReturn<UserVo> msg = new MsgReturn<UserVo>();
		try {
			
			// 2、参数验证
			if (userParams.getMobile() == null || "".equals(userParams.getMobile())) {
				msg.failed("手机号码不得为空");
			} else if (userParams.getPassword() == null || "".equals(userParams.getPassword())) {
				msg.failed("密码不得为空");
			} else if (!userParams.getPassword().equals(userParams.getRepeatPassword())) {
				msg.failed("两次密码输入不一致");
			} else {

				// 3、处理业务逻辑
				UserVo vo = storeUserService.checkUser(userParams.getMobile(), userParams.getPassword());

				// 4、把对象设置进返回消息中
				if (vo == null) {
					msg.failed("用户名或密码错误");
				} else {
					msg.setReturnObj(vo);
					msg.success("登录成功");
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
