package com.pdd.shopMgr.service.po;

import java.io.Serializable;

public class StoreCollection implements Serializable {
    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 商品id
     */
    private String goodId;

    /**
     * 状态（0已取消；1已收藏）
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

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

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId == null ? null : goodId.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}