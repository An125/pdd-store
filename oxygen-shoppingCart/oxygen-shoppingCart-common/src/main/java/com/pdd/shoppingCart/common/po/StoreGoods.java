package com.pdd.shoppingCart.common.po;

import java.math.BigDecimal;

public class StoreGoods {
    private String id;

    private String goodName;

    private BigDecimal highPrice;

    private BigDecimal lowPrice;

    private String picUrl;

    private Integer inventory;

    private String goodIntroduce;

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