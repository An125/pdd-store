package com.pdd.userMgr.common.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @作者： zhaoxin
 * 
 * @日期：2018年2月26日
 * 
 * 				@描述：购物车信息实体对象
 */
public class StoreUserShoppingCartVo implements Serializable {

	private static final long serialVersionUID = -3420449783134896117L;

	private Integer id;

	private Integer userId;

	private String goodsId;

	private Integer quantity;

	private Integer status;

	private Date createDate;

	private Date updateDate;
	
	/**
	 * 商品名称
	 */
	private String goodName;
	
	
	/**
	 * 图片链接
	 */
	private String picUrl;
	
    /**
     * 商品介绍
     */
    private String goodIntroduce;
    
    /**
     * 报价/推荐价格
     */
    private BigDecimal quotePrice;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
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





}
