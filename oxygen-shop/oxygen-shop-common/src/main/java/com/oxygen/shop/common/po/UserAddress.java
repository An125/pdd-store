package com.oxygen.shop.common.po;

public class UserAddress {
    private Integer id;

    private Integer userId;

    private String theConsignee;

    private String telephone;

    private String inTheArea;

    private String detailedAddress;

    private String choice;

    private String date;

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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getInTheArea() {
        return inTheArea;
    }

    public void setInTheArea(String inTheArea) {
        this.inTheArea = inTheArea == null ? null : inTheArea.trim();
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress == null ? null : detailedAddress.trim();
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice == null ? null : choice.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }
}