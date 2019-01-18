package com.pdd.shoppingCart.webServer.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdd.common.core.params.page.Page;
import com.pdd.common.core.params.returns.MsgReturn;
import com.pdd.shoppingCart.api.service.StoreUserShoppingCartService;
import com.pdd.shoppingCart.common.params.StoreUserShoppingCartParams;
import com.pdd.shoppingCart.webServer.exception.CustomException;
import com.pdd.userMgr.common.vo.StoreUserShoppingCartVo;

/**
 * 
 * @作者： zhaoxin
 * @日期：2018年2月27日
 * @描述：查询购物车--分页
 */
@RestController
@RequestMapping("/shoppingCart")
public class CartQueryController {
	private static Logger LOG = Logger.getLogger(CartQueryController.class);
	@Autowired
	private StoreUserShoppingCartService storeUserShoppingCartService;

	@PostMapping("/cartQuery")
	public MsgReturn<Page<StoreUserShoppingCartVo>> cartQuery(StoreUserShoppingCartParams storeUserShoppingCartParams) throws Exception{
		// 1.创建新的返回对象（这里泛型指返回消息中带的对象是购物车Vo）
		MsgReturn<Page<StoreUserShoppingCartVo>> msg = new MsgReturn<Page<StoreUserShoppingCartVo>>();
		
/*			// 2、参数校验
			if(storeUserShoppingCartParams.getPageNo()==0) {
				storeUserShoppingCartParams.setPageNo(1);
			}else if(storeUserShoppingCartParams.getPageSize()==0) {
				storeUserShoppingCartParams.setPageSize(10);
			}*/
			
			// 3.处理业务逻辑
			Page<StoreUserShoppingCartVo> cartPage = storeUserShoppingCartService.cartPageSelect(storeUserShoppingCartParams);
			// 4.把对象设置进返回消息中
			if (cartPage != null) {
				msg.setReturnObj(cartPage);
				msg.success();
			} else {
				throw new CustomException("查询不到该购物车信息");
			}
	
		// 5.将返回的对象返回， 框架自动转成 JSON 对象
		return msg;

	}
}
