package com.pdd.shoppingCart.common.params;

import java.util.Date;

import com.pdd.common.core.params.page.PageParam;


/**
 * 
 * @作者： zhaoxin
 * @日期：2018年2月26日
 * @描述：购物车的参数对象
 */
public class StoreUserShoppingCartParams extends PageParam{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 2050431001990901722L;

	private Integer id;

	    private Integer userId;

	    private String goodsId;

	    private Integer quantity;

	    private Integer status;

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

	    public String getGoodsId() {
	        return goodsId;
	    }

	    public void setGoodsId(String goodsId) {
	        this.goodsId = goodsId == null ? null : goodsId.trim();
	    }

	    public Integer getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(Integer quantity) {
	        this.quantity = quantity;
	    }

	    public Integer getStatus() {
	        return status;
	    }

	    public void setStatus(Integer status) {
	        this.status = status;
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
