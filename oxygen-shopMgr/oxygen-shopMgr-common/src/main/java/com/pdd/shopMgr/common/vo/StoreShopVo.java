package com.pdd.shopMgr.common.vo;

import java.util.Date;

/**
 * @描述：店铺信息实体对象 @作者： wu.liang
 * @日期：Feb 11, 2018
 */
public class StoreShopVo implements java.io.Serializable{
	private static final long serialVersionUID = -1712301764751285687L;
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
		this.id = id;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getGenerated() {
		return generated;
	}

	public void setGenerated(String generated) {
		this.generated = generated;
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
		this.password = password;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
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
		this.phoneNumber = phoneNumber;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
}
