package com.pdd.shopMgr.webServer.controller;

import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pdd.shopMgr.common.params.StoreShopParams;
import com.pdd.shopMgr.common.vo.StoreShopVo;
import com.pdd.common.core.params.returns.MsgReturn;
import com.pdd.shopMgr.api.service.StoreShopService;

/**
 * 店铺管理 @描述： @作者： wu.liang
 * 
 * @日期：Feb 9, 2018
 */
@RestController
@RequestMapping("/shopMgr")
public class ShopController {
	private static Logger LOG = Logger.getLogger(ShopController.class);

	@Autowired
	private StoreShopService storeShopService;

	/**
	 * 商铺登录
	 * 
	 * @param GoodsParams
	 */
	@PostMapping("/shopLogin")
	public MsgReturn<StoreShopVo> shopLogin(StoreShopParams storeShopParams, HttpServletResponse response) {
		// 1、创建新的返回对象（这里泛型指返回消息中带的对象是商品 VO）
		MsgReturn<StoreShopVo> msg = new MsgReturn<StoreShopVo>();
		try {
			
			// 2、参数验证
			if (storeShopParams.getPhoneNumber() == null || "".equals(storeShopParams.getPhoneNumber())) {
				msg.failed("手机号码不得为空");
			} else if (storeShopParams.getPassword() == null || "".equals(storeShopParams.getPassword())) {
				msg.failed("密码不得为空");
			} else {

				// 3、处理业务逻辑
				StoreShopVo vo = storeShopService.getForLogin(storeShopParams);

				// 4、把对象设置进返回消息中
				if (vo == null) {
					msg.failed();
				} else if (vo.getStatus() == 0) {
					msg.failed("您的商铺缺少身份信息，尚未激活");
				} else {
					msg.setReturnObj(vo);
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
	 * 商铺注册
	 * 
	 * @param GoodsParams
	 */
	@PostMapping("/shopRegister")
	public MsgReturn<StoreShopVo> shopRegister(StoreShopParams storeShopParams, HttpServletResponse response) {
		// 1、创建新的返回对象（这里泛型指返回消息中带的对象是商品 VO）
		MsgReturn<StoreShopVo> msg = new MsgReturn<StoreShopVo>();
		try {
			
			// 2、参数验证
			if (storeShopParams.getPhoneNumber() == null || "".equals(storeShopParams.getPhoneNumber())) {
				msg.failed("手机号码不得为空");
			} else if (storeShopParams.getPassword() == null || "".equals(storeShopParams.getPassword())) {
				msg.failed("密码不得为空");
			} else if (storeShopParams.getShopName() == null || "".equals(storeShopParams.getShopName())) {
				msg.failed("店铺名称不得为空");
			} else if (storeShopParams.getIdentityCard() == null || "".equals(storeShopParams.getIdentityCard())) {
				msg.failed("店主身份证号不得为空");
			} else if (!storeShopParams.getPassword().equals(storeShopParams.getRepeatPassword())) {
				msg.failed("两次密码输入不一致");
			} else if (storeShopService.getByPhoneNumber(storeShopParams.getPhoneNumber()) != null) {
				msg.failed("此手机号码已注册过商铺");
			} else if (storeShopService.getByIdentityCard(storeShopParams.getIdentityCard()) != null) {
				msg.failed("此身份证号码已注册过商铺");
			} else {

				// 3、处理业务逻辑
				StoreShopVo vo = storeShopService.saveForRegister(storeShopParams);

				// 4、把对象设置进返回消息中
				if (vo == null) {
					msg.failed();
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
}
