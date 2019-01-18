package com.pdd.shoppingCart.webServer.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdd.common.core.params.returns.MsgReturn;
import com.pdd.shoppingCart.api.service.StoreUserShoppingCartService;
import com.pdd.shoppingCart.common.params.StoreUserShoppingCartParams;
import com.pdd.shoppingCart.webServer.exception.CustomException;
import com.pdd.userMgr.common.vo.StoreUserShoppingCartVo;

/**
 * 
 * @作者： zhaoxin
 * 
 * @日期：2018年2月27日 
 * 
 * @描述：修改购物车
 */
@RestController
@RequestMapping("/shoppingCart")
public class CartUpdateController {
	private static Logger LOG = Logger.getLogger(CartUpdateController.class);
	@Autowired
	private StoreUserShoppingCartService storeUserShoppingCartService;
	@PostMapping("/cartUpdate")
	public MsgReturn<StoreUserShoppingCartVo> cartUpdate(StoreUserShoppingCartParams storeUserShoppingCartParams) throws Exception{
		// 1.创建新的返回对象（这里泛型指返回消息中带的对象是购物车Vo）
		MsgReturn<StoreUserShoppingCartVo> msg = new MsgReturn<StoreUserShoppingCartVo>();
		
		//2.处理业务逻辑
			StoreUserShoppingCartVo cartVo = storeUserShoppingCartService.cartModify(storeUserShoppingCartParams);
		// 3.把对象设置进返回消息中	
			if(cartVo!=null) {
				msg.setReturnObj(cartVo);
				msg.success("修改购物车成功");
			}else {
				throw new CustomException("修改失败");
			}
	
		// 4.将返回的对象返回， 框架自动转成 JSON 对象
		return msg;

	}
}
