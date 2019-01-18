package com.pdd.shopMgr.service.po;

import java.math.BigDecimal;

public class StoreGoods {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_goods.id
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_goods.good_name
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    private String goodName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_goods.high_price
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    private BigDecimal highPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_goods.low_price
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    private BigDecimal lowPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_goods.pic_url
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    private String picUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_goods.inventory
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    private Integer inventory;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_goods.good_introduce
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    private String goodIntroduce;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store_goods.id
     *
     * @return the value of store_goods.id
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store_goods.id
     *
     * @param id the value for store_goods.id
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store_goods.good_name
     *
     * @return the value of store_goods.good_name
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public String getGoodName() {
        return goodName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store_goods.good_name
     *
     * @param goodName the value for store_goods.good_name
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public void setGoodName(String goodName) {
        this.goodName = goodName == null ? null : goodName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store_goods.high_price
     *
     * @return the value of store_goods.high_price
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public BigDecimal getHighPrice() {
        return highPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store_goods.high_price
     *
     * @param highPrice the value for store_goods.high_price
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public void setHighPrice(BigDecimal highPrice) {
        this.highPrice = highPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store_goods.low_price
     *
     * @return the value of store_goods.low_price
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public BigDecimal getLowPrice() {
        return lowPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store_goods.low_price
     *
     * @param lowPrice the value for store_goods.low_price
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public void setLowPrice(BigDecimal lowPrice) {
        this.lowPrice = lowPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store_goods.pic_url
     *
     * @return the value of store_goods.pic_url
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store_goods.pic_url
     *
     * @param picUrl the value for store_goods.pic_url
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store_goods.inventory
     *
     * @return the value of store_goods.inventory
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public Integer getInventory() {
        return inventory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store_goods.inventory
     *
     * @param inventory the value for store_goods.inventory
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store_goods.good_introduce
     *
     * @return the value of store_goods.good_introduce
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public String getGoodIntroduce() {
        return goodIntroduce;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store_goods.good_introduce
     *
     * @param goodIntroduce the value for store_goods.good_introduce
     *
     * @mbggenerated Mon Mar 26 13:00:16 CST 2018
     */
    public void setGoodIntroduce(String goodIntroduce) {
        this.goodIntroduce = goodIntroduce == null ? null : goodIntroduce.trim();
    }
}