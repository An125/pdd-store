package com.pdd.orderMgr.api.service;

import com.pdd.common.core.params.page.Page;
import com.pdd.orderMgr.common.params.OrderFormParams;
import com.pdd.orderMgr.common.vo.OrderFormVo;

public interface StoreOrderFormService {

	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年3月5日
	 * @描述：生成订单（一种商品对应一条订单）
	 */
	public OrderFormVo orderAdd(OrderFormParams orderFormParams) throws Exception;

	
	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月22日
	 * @描述：生成订单（购物车多件商品生成一条订单）
	 */
	public int orderBatchAdd(OrderFormParams orderFormParams) throws Exception;
	
	
	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年3月12日
	 * @描述：取消订单
	 */
	public int orderDelete(OrderFormParams orderFormParams) throws Exception;

	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年3月12日
	 * @描述：提交订单
	 */
	public int orderSubmit(OrderFormParams orderFormParams) throws Exception;


	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年3月12日
	 * @描述：修改订单
	 */
	public int orderModify(OrderFormParams orderFormParams) throws Exception;


	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年3月12日
	 * @描述：修改订单价格（实付款）---后台
	 */
	public int orderPriceModify(OrderFormParams orderFormParams) throws Exception;


	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年3月13日
	 * @描述：查询一条订单
	 */
	public OrderFormVo orderSelectOne(OrderFormParams orderFormParams) throws Exception;


	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年3月13日
	 * @描述：分页查询该用户下所有订单
	 */
	public Page<OrderFormVo> orderSelectPaging(OrderFormParams orderFormParams) throws Exception;

	
	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年7月17日
	 * @描述：商家发货---后台操作
	 */
	public int orderDeliver(OrderFormParams orderFormParams) throws Exception;

	
	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年7月17日
	 * @描述：用户确认收货
	 */
	public int orderReceipt(OrderFormParams orderFormParams) throws Exception;


	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年7月17日
	 * @描述：商品评价
	 */
	public int orderEvaluate(OrderFormParams orderFormParams) throws Exception;


	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年7月17日
	 * @描述：申请退货
	 */
	public int orderReturnApply(OrderFormParams orderFormParams) throws Exception;

	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年7月17日
	 * @描述：取消退货
	 */
	public int orderReturnCancel(OrderFormParams orderFormParams) throws Exception;

	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年7月17日
	 * @描述：商家同意退货---后台操作
	 */
	public int orderReturnAgree(OrderFormParams orderFormParams) throws Exception;


	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年7月17日
	 * @描述：商家确认收到退货---后台操作
	 */
	public int orderReturnReceive(OrderFormParams orderFormParams) throws Exception;


	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年7月17日
	 * @描述：商家退款---后台操作
	 */
	public int orderMerchantRefund(OrderFormParams orderFormParams) throws Exception;


	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月22日
	 * @描述：删除订单
	 */
	public int orderRemove(OrderFormParams orderFormParams) throws Exception;







	
	

}
