package com.pdd.orderMgr.webServer.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdd.common.core.params.returns.MsgReturn;
import com.pdd.orderMgr.api.service.StoreOrderFormService;
import com.pdd.orderMgr.common.params.OrderFormParams;
import com.pdd.orderMgr.common.vo.OrderFormVo;
/**
 * 
 * @作者： ppx
 * @日期：2018年8月22日
 * @描述：删除订单
 */
@RestController
@RequestMapping("/orderMgr")
public class OrderDeleteController {
	private static Logger LOG = Logger.getLogger(OrderDeleteController.class);
	
	@Autowired
	private StoreOrderFormService storeOrderFormService;

	@PostMapping("/orderDelete")
	public MsgReturn<OrderFormVo> orderDelete(OrderFormParams orderFormParams) {
		// 1.创建新的返回对象（这里泛型指返回消息中带的对象是订单Vo）
		MsgReturn<OrderFormVo> msg = new MsgReturn<OrderFormVo>();
		try {
			// 2.处理业务逻辑
			int count = storeOrderFormService.orderRemove(orderFormParams);
			// 3.把对象设置进返回消息中
			if (count > 0) {
				msg.success("删除成功");
			} else {
				msg.failed("删除失败");
			}
		} catch (Exception e) {
			LOG.info(e.getMessage());
			msg.exception();
		}

		// 4.将返回的对象返回， 框架自动转成 JSON 对象
		return msg;

	}
}
