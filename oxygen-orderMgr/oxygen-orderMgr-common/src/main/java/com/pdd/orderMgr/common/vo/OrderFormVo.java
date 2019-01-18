package com.pdd.orderMgr.common.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @作者： zhaoxin
 * @日期：2018年3月5日
 * @描述：订单展现对象
 */
public class OrderFormVo  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4626738148085937083L;
	
	/**
	 * 自增主键
	 */
	private Integer id;

	/**
	 * 产品id
	 */
    private String goodId;

    /**
	 * 用户id
	 */
    private Integer userId;

    /**
	 * 商铺id
	 */
    private String shopId;

    /**
	 * 用户地址id
	 */
    private Integer userAddressId;

    /**
	 * 商铺商品中间表
	 */
    private Integer shopGoodsRelationId;

    /**
	 * 与微信对接订单号
	 */
    private String orderFormWx;

    /**
	 * 与支付宝对接订单号
	 */
    private String orderFormAl;

    /**
	 * 数量
	 */
    private Integer quantity;

    /**
	 * 状态：-1已删除；0失效；1待付款；2待发货；3待收货；4待评价；5已评价；6退货审核；7退货中；8已退货；9已退款
	 */
    private Byte state;

    /**
	 * 支付方式（0：支付宝余额；1：余额宝；2：花呗；3：微信；4：银联支付） 
	 */
    private Integer payMethod;

    /**
	 * 产品图片路径
	 */
    private String path;

    /**
	 * 订单价格，实付款
	 */
    private BigDecimal orderPrice;

    /**
	 * 创建时间
	 */
    private Date createDate;
    
    /**
     * 商品名称
     */
    private String goodName;
    
    /**
     * 商品介绍
     */
    private String goodIntroduce;
    
    /**
     * 报价/推荐价格
     */
    private BigDecimal quotePrice;
    
    /**
     * 详细收货地址
     */
    private String address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGoodId() {
		return goodId;
	}

	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public Integer getUserAddressId() {
		return userAddressId;
	}

	public void setUserAddressId(Integer userAddressId) {
		this.userAddressId = userAddressId;
	}

	public Integer getShopGoodsRelationId() {
		return shopGoodsRelationId;
	}

	public void setShopGoodsRelationId(Integer shopGoodsRelationId) {
		this.shopGoodsRelationId = shopGoodsRelationId;
	}

	public String getOrderFormWx() {
		return orderFormWx;
	}

	public void setOrderFormWx(String orderFormWx) {
		this.orderFormWx = orderFormWx;
	}

	public String getOrderFormAl() {
		return orderFormAl;
	}

	public void setOrderFormAl(String orderFormAl) {
		this.orderFormAl = orderFormAl;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Byte getState() {
		return state;
	}

	public void setState(Byte state) {
		this.state = state;
	}

	public Integer getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(Integer payMethod) {
		this.payMethod = payMethod;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public BigDecimal getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}


	public String getGoodIntroduce() {
		return goodIntroduce;
	}

	public void setGoodIntroduce(String goodIntroduce) {
		this.goodIntroduce = goodIntroduce;
	}

	public BigDecimal getQuotePrice() {
		return quotePrice;
	}

	public void setQuotePrice(BigDecimal quotePrice) {
		this.quotePrice = quotePrice;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
    
    
}
