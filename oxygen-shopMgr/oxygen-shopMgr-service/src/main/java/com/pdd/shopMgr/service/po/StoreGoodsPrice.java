package com.pdd.shopMgr.service.po;

import java.math.BigDecimal;
import java.util.Date;

public class StoreGoodsPrice {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_goods_price.id
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_goods_price.good_id
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    private String goodId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_goods_price.shop_id
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    private String shopId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_goods_price.quote_price
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    private BigDecimal quotePrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_goods_price.bid_price
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    private BigDecimal bidPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_goods_price.create_by
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    private String createBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_goods_price.create_date
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_goods_price.update_by
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    private String updateBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_goods_price.update_date
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    private Date updateDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store_goods_price.id
     *
     * @return the value of store_goods_price.id
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store_goods_price.id
     *
     * @param id the value for store_goods_price.id
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store_goods_price.good_id
     *
     * @return the value of store_goods_price.good_id
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public String getGoodId() {
        return goodId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store_goods_price.good_id
     *
     * @param goodId the value for store_goods_price.good_id
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public void setGoodId(String goodId) {
        this.goodId = goodId == null ? null : goodId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store_goods_price.shop_id
     *
     * @return the value of store_goods_price.shop_id
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public String getShopId() {
        return shopId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store_goods_price.shop_id
     *
     * @param shopId the value for store_goods_price.shop_id
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store_goods_price.quote_price
     *
     * @return the value of store_goods_price.quote_price
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public BigDecimal getQuotePrice() {
        return quotePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store_goods_price.quote_price
     *
     * @param quotePrice the value for store_goods_price.quote_price
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public void setQuotePrice(BigDecimal quotePrice) {
        this.quotePrice = quotePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store_goods_price.bid_price
     *
     * @return the value of store_goods_price.bid_price
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public BigDecimal getBidPrice() {
        return bidPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store_goods_price.bid_price
     *
     * @param bidPrice the value for store_goods_price.bid_price
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public void setBidPrice(BigDecimal bidPrice) {
        this.bidPrice = bidPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store_goods_price.create_by
     *
     * @return the value of store_goods_price.create_by
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store_goods_price.create_by
     *
     * @param createBy the value for store_goods_price.create_by
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store_goods_price.create_date
     *
     * @return the value of store_goods_price.create_date
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store_goods_price.create_date
     *
     * @param createDate the value for store_goods_price.create_date
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store_goods_price.update_by
     *
     * @return the value of store_goods_price.update_by
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store_goods_price.update_by
     *
     * @param updateBy the value for store_goods_price.update_by
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store_goods_price.update_date
     *
     * @return the value of store_goods_price.update_date
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store_goods_price.update_date
     *
     * @param updateDate the value for store_goods_price.update_date
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}