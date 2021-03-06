package com.pdd.userMgr.api.Vo;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * @描述：用户地址展现对象
 * @作者： wu.liang
 * @日期：Feb 26, 2018
 */
public class UserAddressVo implements Serializable{
	private static final long serialVersionUID = 5042321900788534479L;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_user_address.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_user_address.user_id
     *
     * @mbggenerated
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_user_address.the_consignee
     *
     * @mbggenerated
     */
    private String theConsignee;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_user_address.phone
     *
     * @mbggenerated
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_user_address.area_id
     *
     * @mbggenerated
     */
    private Integer areaId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_user_address.address
     *
     * @mbggenerated
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_user_address.is_choice
     *
     * @mbggenerated
     */
    private Byte isChoice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_user_address.create_date
     *
     * @mbggenerated
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store_user_address.update_date
     *
     * @mbggenerated
     */
    private Date updateDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTheConsignee() {
		return theConsignee;
	}

	public void setTheConsignee(String theConsignee) {
		this.theConsignee = theConsignee;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
		this.address = address;
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
