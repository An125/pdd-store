package com.pdd.orderMgr.webServer.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdd.common.core.params.returns.MsgReturn;
import com.pdd.orderMgr.api.service.StoreOrderFormService;
import com.pdd.orderMgr.common.params.OrderFormParams;
import com.pdd.orderMgr.common.vo.OrderFormVo;
@RestController
@RequestMapping("/orderMgr")
public class OrderCreateController {
	private static Logger LOG = Logger.getLogger(OrderCreateController.class);
	@Autowired
	private StoreOrderFormService storeOrderFormService;
	
	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年3月5日
	 * @描述：生成订单（一种商品对应一条订单）
	 */
	@PostMapping("/orderCreate")
	public MsgReturn<OrderFormVo> orderCreate(OrderFormParams orderFormParams) {
		// 1.创建新的返回对象（这里泛型指返回消息中带的对象是订单Vo）
		MsgReturn<OrderFormVo> msg = new MsgReturn<OrderFormVo>();

			try {
				//	2.处理业务逻辑
				OrderFormVo orderFormVo = storeOrderFormService.orderAdd(orderFormParams);
				// 3.把对象设置进返回消息中
				if(orderFormVo!=null) {
					msg.setReturnObj(orderFormVo);
					msg.success("生成订单成功");
				}else {
					msg.failed("生成订单失败");
				}
			} catch (Exception e) {
				LOG.info(e.getMessage());
				msg.exception();
			}

		// 4.将返回的对象返回， 框架自动转成 JSON 对象
		return msg;
		
	}
	
	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月22日
	 * @描述：生成订单（购物车多件商品生成一条订单）
	 * @RequestBody 接受json数组对象
	 */
	@PostMapping(value = "/orderBatchCreate",consumes = "application/json;charset=utf-8")
	public MsgReturn<OrderFormVo> orderBatchCreate(@RequestBody OrderFormParams orderFormParams,HttpServletRequest request) {
		// 1.创建新的返回对象（这里泛型指返回消息中带的对象是订单Vo）
		MsgReturn<OrderFormVo> msg = new MsgReturn<OrderFormVo>();

			try {
				//	2.处理业务逻辑
				 int result = storeOrderFormService.orderBatchAdd(orderFormParams);
				// 3.把对象设置进返回消息中
				if(result>0) {
					msg.success("生成订单成功");
				}else {
					msg.failed("生成订单失败");
				}
			} catch (Exception e) {
				LOG.info(e.getMessage());
				msg.exception();
			}

		// 4.将返回的对象返回， 框架自动转成 JSON 对象
		return msg;
		
	}
}
