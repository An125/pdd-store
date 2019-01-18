package com.pdd.community.common.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class StoreGoodsPrice implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 商品id
     */
    private String goodId;

    /**
     * 商铺id
     */
    private String shopId;

    /**
     * 报价/推荐价格
     */
    private BigDecimal quotePrice;

    /**
     * 进价
     */
    private BigDecimal bidPrice;

    /**
     * 
     */
    private String createBy;

    /**
     * 
     */
    private Date createDate;

    /**
     * 
     */
    private String updateBy;

    /**
     * 
     */
    private Date updateDate;

    private static final long serialVersionUID = 1L;

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

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public BigDecimal getQuotePrice() {
        return quotePrice;
    }

    public void setQuotePrice(BigDecimal quotePrice) {
        this.quotePrice = quotePrice;
    }

    public BigDecimal getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(BigDecimal bidPrice) {
        this.bidPrice = bidPrice;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}