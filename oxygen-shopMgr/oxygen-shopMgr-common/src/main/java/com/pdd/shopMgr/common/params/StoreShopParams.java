package com.pdd.shopMgr.common.params;

import java.io.Serializable;

/**
 * 商铺的参数对象
 * @描述：
 * @作者： wu.liang
 * @日期：Feb 11, 2018
 */
public class StoreShopParams implements Serializable {
	private static final long serialVersionUID = 5787703470733089800L;
	private String id;
    private String shopName;
    private String generated;
    private String password;
    private String repeatPassword;
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
	public String getRepeatPassword() {
		return repeatPassword;
	}
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
    
}
