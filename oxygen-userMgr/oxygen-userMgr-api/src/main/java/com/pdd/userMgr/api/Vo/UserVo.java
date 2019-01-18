package com.pdd.userMgr.api.Vo;

import java.io.Serializable;
import java.util.Date;


/**
 * @描述：展示对象
 * @作者： wu.liang
 * @日期：Feb 26, 2018
 */
public class UserVo implements Serializable{
	private static final long serialVersionUID = 1L;

    private Integer id;
    private String username;
    private String mobile;
    private String password;
    private String depth;
    private String path;
    private String invitation;
    private String generated;
    private String txpath;
    private Date updateDate;
    private Integer type;
    private String salt;
    private String shopId;
    private Date createTime;
    


    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepth() {
		return depth;
	}

	public void setDepth(String depth) {
		this.depth = depth;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getInvitation() {
		return invitation;
	}

	public void setInvitation(String invitation) {
		this.invitation = invitation;
	}

	public String getGenerated() {
		return generated;
	}

	public void setGenerated(String generated) {
		this.generated = generated;
	}

	public String getTxpath() {
		return txpath;
	}

	public void setTxpath(String txpath) {
		this.txpath = txpath;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
