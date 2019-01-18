package com.pdd.orderMgr.webServer.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdd.common.core.exceptions.BizException;
import com.pdd.common.core.params.page.Page;
import com.pdd.common.core.params.returns.MsgReturn;
import com.pdd.orderMgr.api.service.StoreOrderFormService;
import com.pdd.orderMgr.common.params.OrderFormParams;
import com.pdd.orderMgr.common.vo.OrderFormVo;


/**
 * 
 * @作者： zhaoxin
 * @日期：2018年3月13日
 * @描述：分页查询该用户下所有订单号或者按类别分页查询（待付、待发、待收、待评）
 */
@RestController
@RequestMapping("/orderMgr")
public class OrderQueryPagingController {
	private static Logger LOG = Logger.getLogger(OrderQueryPagingController.class);
	@Autowired
	private StoreOrderFormService storeOrderFormService;
	
	@PostMapping("/orderQueryPaging")
	public MsgReturn<Page<OrderFormVo>> orderQueryPaging(OrderFormParams orderFormParams) {
		// 1.创建新的返回对象（这里泛型指返回消息中带的对象是订单Vo）
		MsgReturn<Page<OrderFormVo>> msg = new MsgReturn<Page<OrderFormVo>>();

			/*// 2、参数校验---PageParam里已有默认值，这里无需判断
			if(orderFormParams.getPageNo()==0) {
				orderFormParams.setPageNo(1);
			}else if(orderFormParams.getPageSize()==0){
				orderFormParams.setPageSize(10);
			}*/
			
			// 3.处理业务逻辑
			 Page<OrderFormVo> orderPage;
			try {
				orderPage = storeOrderFormService.orderSelectPaging(orderFormParams);
				// 4.把对象设置进返回消息中
				if (orderPage!=null) {
					msg.setReturnObj(orderPage);
					msg.success("请求成功");
				} else {
					msg.failed("查询不到您要的数据");
				}
			} catch (Exception e) {
				LOG.info(e.getMessage());
				msg.exception();
			}

		// 5.将返回的对象返回， 框架自动转成 JSON 对象
		return msg;

	}
	
}
