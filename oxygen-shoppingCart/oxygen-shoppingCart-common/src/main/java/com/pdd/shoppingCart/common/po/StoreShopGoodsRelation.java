package com.pdd.shoppingCart.common.po;

import java.math.BigDecimal;

public class StoreShopGoodsRelation {
    private Integer id;

    private String shopId;

    private String goodId;

    private Byte isEnable;

    private BigDecimal price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId == null ? null : goodId.trim();
    }

    public Byte getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Byte isEnable) {
        this.isEnable = isEnable;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}