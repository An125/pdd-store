package com.pdd.orderMgr.common.constants;
/**
 * 
 * @作者： zhaoxin
 * @日期：2018年3月5日
 * @描述：用到的常量
 */
public class Constants {
	
	/**
	 * 据库字段--订单状态:已删除
	 */
	public static final Byte DB_STOREORDERFORM_STATE_DELETED=-1;
	
	/**
	 * 数据库字段--订单状态:失效
	 */
	public static final Byte DB_STOREORDERFORM_STATE_INVALID=0;
	/**
	 * 数据库字段--订单状态：待付款
	 */
	public static final Byte DB_STOREORDERFORM_STATE_UNPAID=1;
	/**
	 * 数据库字段--订单状态：待发货
	 */
	public static final Byte DB_STOREORDERFORM_STATE_UNDELIVERY=2;
	/**
	 * 数据库字段--订单状态：待收货
	 */
	public static final Byte DB_STOREORDERFORM_STATE_UNCOLLECTED=3;
	/**
	 * 数据库字段--订单状态：待评价
	 */
	public static final Byte DB_STOREORDERFORM_STATE_UNEVALUATE=4;
	/**
	 * 数据库字段--订单状态：已评价
	 */
	public static final Byte DB_STOREORDERFORM_STATE_BEENEVALUATE=5;
	/**
	 * 数据库字段--订单状态：退货审核
	 */
	public static final Byte DB_STOREORDERFORM_STATE_RETURNREVIEW=6;
	/**
	 * 数据库字段--订单状态：退货中
	 */
	public static final Byte DB_STOREORDERFORM_STATE_INRETURN=7;
	/**
	 * 数据库字段--订单状态：已退货
	 */
	public static final Byte DB_STOREORDERFORM_STATE_BEENRETURN=8;
	/**
	 * 数据库字段--订单状态：已退款
	 */
	public static final Byte DB_STOREORDERFORM_STATE_REFUNDED=9;
	/**
	 * 数据库字段--支付方式：支付宝余额
	 */
	public static final int DB_STOREORDERFORM_PAYMETHOD_BALANCE=0;
	/**
	 * 数据库字段--支付方式：余额宝
	 */
	public static final int DB_STOREORDERFORM_PAYMETHOD_TREASURE=1;
	/**
	 * 数据库字段--支付方式：花呗
	 */
	public static final int DB_STOREORDERFORM_PAYMETHOD_FLOWERS=2;
	/**
	 * 数据库字段--支付方式：微信
	 */
	public static final int DB_STOREORDERFORM_PAYMETHOD_WECHAT=3;
	/**
	 * 数据库字段--支付方式：银联
	 */
	public static final int DB_STOREORDERFORM_PAYMETHOD_UNIONPAY=4;
	
	/**
	 * 数据库字段--支付宝对接订单号前缀
	 */
	public static final String DB_ORDERFORM_FLAG="pdd";
	
	
	/**
	 * 数据库字段isEnable---是否可用：不可用
	 */
	public static final Byte DB_STORESHOPGOODSRELATION_ISENABLE_NO=0;
	/**
	 * 数据库字段isEnable---是否可用：可用
	 */
	public static final Byte DB_STORESHOPGOODSRELATION_ISENABLE_YES=1;
}
