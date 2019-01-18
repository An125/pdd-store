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
 * @日期：2018年2月27日
 * @描述：删除购物车（不是物理上的删除，只是修改状态）
 */
@RestController
@RequestMapping("/shoppingCart")
public class CartDeleteController {
	private static Logger LOG = Logger.getLogger(CartDeleteController.class);
	
	@Autowired
	private StoreUserShoppingCartService storeUserShoppingCartService;
	
	@PostMapping("/cartDelete")
	public MsgReturn<StoreUserShoppingCartVo> cartDelete(StoreUserShoppingCartParams storeUserShoppingCartParams) throws Exception{
		// 1.创建新的返回对象（这里泛型指返回消息中带的对象是购物车Vo）
		MsgReturn<StoreUserShoppingCartVo> msg = new MsgReturn<StoreUserShoppingCartVo>();
		
		//2.处理业务逻辑
			StoreUserShoppingCartVo cartVo = storeUserShoppingCartService.cartRemove(storeUserShoppingCartParams);
		// 3.把对象设置进返回消息中	
			if(cartVo!=null) {
				msg.setReturnObj(cartVo);
				msg.success("删除购物车成功");
			}else {
				throw new CustomException("无法删除购物车");
			}

		// 4.将返回的对象返回， 框架自动转成 JSON 对象
		return msg;

	}
}
