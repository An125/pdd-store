package com.pdd.userMgr.api.params;

import java.io.Serializable;
import java.util.Date;


/**
 * @描述：用户参数
 * @作者： wu.liang
 * @日期：Feb 26, 2018
 */
public class UserParams implements Serializable{
	private static final long serialVersionUID = 6778545531050545677L;

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_user.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_user.username
     *
     * @mbggenerated
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_user.mobile
     *
     * @mbggenerated
     */
    private String mobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_user.password
     *
     * @mbggenerated
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_user.depth
     *
     * @mbggenerated
     */
    private String depth;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_user.path
     *
     * @mbggenerated
     */
    private String path;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_user.invitation
     *
     * @mbggenerated
     */
    private String invitation;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_user.generated
     *
     * @mbggenerated
     */
    private String generated;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_user.txpath
     *
     * @mbggenerated
     */
    private String txpath;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_user.update_date
     *
     * @mbggenerated
     */
    private Date updateDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_user.type
     *
     * @mbggenerated
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_user.salt
     *
     * @mbggenerated
     */
    private String salt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_user.shop_id
     *
     * @mbggenerated
     */
    private String shopId;

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

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_user.create_time
     *
     * @mbggenerated
     */
    private Date createTime;
    
	private String repeatPassword;

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
