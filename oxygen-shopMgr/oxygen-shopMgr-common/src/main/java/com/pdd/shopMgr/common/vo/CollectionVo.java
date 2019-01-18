package com.pdd.shopMgr.common.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class CollectionVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8086392153888879160L;

	
	/**
     * 自增主键
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 商品id
     */
    private String goodId;

    /**
     * 状态（0已取消；1已收藏）
     */
    private Integer status;
    
    /**
     * 商品名称
     */
    private String goodName;
    
    /**
     * 商品介绍
     */
    private String goodIntroduce;
    
    /**
     * 图片链接
     */
    private String picUrl;
    
    /**
     * 商品出售价格
     */
    private BigDecimal price;

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

	public String getGoodId() {
		return goodId;
	}

	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
    
}
