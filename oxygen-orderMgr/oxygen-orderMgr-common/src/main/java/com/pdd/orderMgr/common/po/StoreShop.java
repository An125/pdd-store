package com.pdd.orderMgr.common.po;

import java.util.Date;

public class StoreShop {
    private String id;

    private String shopName;

    private String generated;

    private Date createDate;

    private String password;

    private String identityCard;

    private Integer status;

    private String phoneNumber;

    private Integer level;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getGenerated() {
        return generated;
    }

    public void setGenerated(String generated) {
        this.generated = generated == null ? null : generated.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard == null ? null : identityCard.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}