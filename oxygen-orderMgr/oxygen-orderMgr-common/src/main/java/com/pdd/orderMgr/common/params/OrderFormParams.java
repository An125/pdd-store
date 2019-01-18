package com.pdd.orderMgr.common.params;

import java.math.BigDecimal;

import com.pdd.common.core.params.page.PageParam;



/**
 * 
 * @作者： zhaoxin
 * @日期：2018年3月5日
 * @描述：订单参数
 * PageParam用来接受参数（pageNo、pageSize，已有默认值可以不传）
 */
public class OrderFormParams extends PageParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2953914463124882498L;

	 private Integer id;

	    private String goodId;

	    private Integer userId;

	    private String shopId;

	    private Integer userAddressId;

	    private Integer shopGoodsRelationId;

	    private String orderFormWx;

	    private String orderFormAl;

	    private Integer quantity;

	    private Byte state;

	    private Integer payMethod;

	    private String path;

	    private BigDecimal orderPrice;

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
	        this.goodId = goodId == null ? null : goodId.trim();
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
	        this.shopId = shopId == null ? null : shopId.trim();
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
	        this.orderFormWx = orderFormWx == null ? null : orderFormWx.trim();
	    }

	    public String getOrderFormAl() {
	        return orderFormAl;
	    }

	    public void setOrderFormAl(String orderFormAl) {
	        this.orderFormAl = orderFormAl == null ? null : orderFormAl.trim();
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
	        this.path = path == null ? null : path.trim();
	    }

	    public BigDecimal getOrderPrice() {
	        return orderPrice;
	    }

	    public void setOrderPrice(BigDecimal orderPrice) {
	        this.orderPrice = orderPrice;
	    }


	

	
    
}
