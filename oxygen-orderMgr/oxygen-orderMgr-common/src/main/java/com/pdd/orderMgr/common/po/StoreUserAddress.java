package com.pdd.orderMgr.common.po;

import java.util.Date;

public class StoreUserAddress {
    private Integer id;

    private Integer userId;

    private String theConsignee;

    private String phone;

    private Integer areaId;

    private String address;

    private Byte isChoice;

    private Date createDate;

    private Date updateDate;

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

    public String getTheConsignee() {
        return theConsignee;
    }

    public void setTheConsignee(String theConsignee) {
        this.theConsignee = theConsignee == null ? null : theConsignee.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Byte getIsChoice() {
        return isChoice;
    }

    public void setIsChoice(Byte isChoice) {
        this.isChoice = isChoice;
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
}