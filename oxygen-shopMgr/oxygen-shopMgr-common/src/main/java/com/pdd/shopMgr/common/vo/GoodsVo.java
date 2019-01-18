package com.pdd.shopMgr.common.vo;

import java.math.BigDecimal;

/**
 * @描述：商品实体对象
 * @作者： wu.liang
 * @日期：Feb 11, 2018
 */
public class GoodsVo implements java.io.Serializable{
	private static final long serialVersionUID = 5858139523893807340L;
	private String id;
	private String goodName;
	private BigDecimal highPrice;
	private BigDecimal lowPrice;
	/**
	 * 店铺id
	 */
	 private String shopId;
	/**
	 * 店铺中价格
	 */
    private BigDecimal price;
	private String picUrl;
	private Integer inventory;
	private String goodIntroduce;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public BigDecimal getHighPrice() {
		return highPrice;
	}
	public void setHighPrice(BigDecimal highPrice) {
		this.highPrice = highPrice;
	}
	public BigDecimal getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(BigDecimal lowPrice) {
		this.lowPrice = lowPrice;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public Integer getInventory() {
		return inventory;
	}
	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}
	public String getGoodIntroduce() {
		return goodIntroduce;
	}
	public void setGoodIntroduce(String goodIntroduce) {
		this.goodIntroduce = goodIntroduce;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	
}