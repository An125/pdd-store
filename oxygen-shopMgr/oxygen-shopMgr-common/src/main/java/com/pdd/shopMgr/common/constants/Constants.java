package com.pdd.shopMgr.common.constants;

/**
 * 用到的常量
 * @描述：
 * @作者： wu.liang
 * @日期：Feb 11, 2018
 */
public class Constants {
	/**
	 * 数据库字段--店铺状态：生效的
	 */
	public static final int DB_STORESHOP_STATUS_ENABLED = 1;
	/**
	 * 数据库字段--店铺状态：未生效的
	 */
	public static final int DB_STORESHOP_STATUS_DISABLED = 0;
	/**
	 * 数据库字段--店铺状态：撤销的
	 */
	public static final int DB_STORESHOP_STATUS_CANCELED = 2;
	/**
	 * 数据库字段--店铺等级：总公司级别
	 */
	public static final int DB_STORESHOP_LEVEL_ROOT = 1;
	/**
	 * 数据库字段--店铺等级：普通商铺级别
	 */
	public static final int DB_STORESHOP_LEVEL_CHILD = 0;
	/**
	 * 数据库字段--商户邀请码前缀标识
	 */
	public static final String DB_STORESHOP_GENERATED_FLAG = "SH";
	
	
	/**
	 * 请求参数 sortType--排序类型：按销量
	 */
	public static final int SORTTYPE_SALESVOLUME = 1;
	/**
	 * 请求参数 sortType--排序类型：价格升序
	 */
	public static final int SORTTYPE_PRICE_ASC = 2;
	/**
	 * 请求参数 sortType--排序类型：价格降序
	 */
	public static final int SORTTYPE_PRICE_DESC = 3;
	
	
	/**
	 * 排序参数（orderString）---排序类型:按销量
	 */
	public static final String ORDERSTRING_SALESVOLUME="sales_volume";
	/**
	 * 排序参数（orderString）---排序类型:按价格
	 */
	public static final String ORDERSTRING_PRICE="price";
	/**
	 * 排序参数（orderDirection）---排序方式：升序
	 */
	public static final String ORDERDIRECTION_ASC="asc";
	/**
	 * 排序参数（orderDirection）---排序方式：降序
	 */
	public static final String ORDERDIRECTION_DESC="desc";
}
