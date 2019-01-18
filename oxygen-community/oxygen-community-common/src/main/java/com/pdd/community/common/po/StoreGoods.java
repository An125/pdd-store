package com.pdd.community.common.po;

import java.io.Serializable;
import java.math.BigDecimal;

public class StoreGoods implements Serializable {
    /**
     * 主键
     */
    private String id;

    /**
     * 商品名称
     */
    private String goodName;

    /**
     * 最高价格
     */
    private BigDecimal highPrice;

    /**
     * 最低价格
     */
    private BigDecimal lowPrice;

    /**
     * 图片链接
     */
    private String picUrl;

    /**
     * 库存
     */
    private Integer inventory;

    /**
     * 商品介绍
     */
    private String goodIntroduce;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName == null ? null : goodName.trim();
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
        this.picUrl = picUrl == null ? null : picUrl.trim();
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
        this.goodIntroduce = goodIntroduce == null ? null : goodIntroduce.trim();
    }
}