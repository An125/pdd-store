package com.pdd.orderMgr.webServer.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdd.common.core.exceptions.BizException;
import com.pdd.common.core.params.returns.MsgReturn;
import com.pdd.orderMgr.api.service.StoreOrderFormService;
import com.pdd.orderMgr.common.params.OrderFormParams;
import com.pdd.orderMgr.common.vo.OrderFormVo;
/**
 * 
 * @作者： zhaoxin
 * @日期：2018年7月17日
 * @描述：商家发货---后台操作
 */
@RestController
@RequestMapping("/orderMgr")
public class OrderDeliverController {

	private static Logger LOG = Logger.getLogger(OrderDeliverController.class);
	
	@Autowired
	private StoreOrderFormService storeOrderFormService;
	@PostMapping("/orderDeliver")
	public MsgReturn<OrderFormVo> orderDeliver(OrderFormParams orderFormParams) throws Exception{
		// 1.创建新的返回对象（这里泛型指返回消息中带的对象是订单Vo）
		MsgReturn<OrderFormVo> msg = new MsgReturn<OrderFormVo>();
		// 2.处理业务逻辑
		int result = storeOrderFormService.orderDeliver(orderFormParams);
		// 3.把对象设置进返回消息中
		if(result>0) {
			msg.success("发货成功！");
		}else {
			throw BizException.DB_UPDATE_RESULT_0;
		}
		// 4.将返回的对象返回， 框架自动转成 JSON 对象
		return msg;
		
	}
}
