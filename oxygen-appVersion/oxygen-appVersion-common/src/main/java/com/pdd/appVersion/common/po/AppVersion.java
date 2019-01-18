package com.pdd.appVersion.common.po;

import java.util.Date;

public class AppVersion {
    private Integer id;

    private Double number;

    private String remarks;

    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}