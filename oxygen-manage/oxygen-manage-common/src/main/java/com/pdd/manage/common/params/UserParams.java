package com.pdd.manage.common.params;

import java.io.Serializable;
import java.util.Date;

public class UserParams implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 5908170328497854408L;

	private String userId;

	    private String username;

	    private String password;

	    private String salt;

	    private String realname;

	    private String avatar;

	    private String phone;

	    private String email;

	    private Byte sex;

	    private Byte locked;

	    private String createBy;

	    private Date createDate;

	    private String updateBy;

	    private Date updateDate;

	    private String remarks;

	    private Boolean delFlag;
	    
	    //记住我
	    private String rememberMe;

	    public String getUserId() {
	        return userId;
	    }

	    public void setUserId(String userId) {
	        this.userId = userId == null ? null : userId.trim();
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username == null ? null : username.trim();
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password == null ? null : password.trim();
	    }

	    public String getSalt() {
	        return salt;
	    }

	    public void setSalt(String salt) {
	        this.salt = salt == null ? null : salt.trim();
	    }

	    public String getRealname() {
	        return realname;
	    }

	    public void setRealname(String realname) {
	        this.realname = realname == null ? null : realname.trim();
	    }

	    public String getAvatar() {
	        return avatar;
	    }

	    public void setAvatar(String avatar) {
	        this.avatar = avatar == null ? null : avatar.trim();
	    }

	    public String getPhone() {
	        return phone;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone == null ? null : phone.trim();
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email == null ? null : email.trim();
	    }

	    public Byte getSex() {
	        return sex;
	    }

	    public void setSex(Byte sex) {
	        this.sex = sex;
	    }

	    public Byte getLocked() {
	        return locked;
	    }

	    public void setLocked(Byte locked) {
	        this.locked = locked;
	    }

	    public String getCreateBy() {
	        return createBy;
	    }

	    public void setCreateBy(String createBy) {
	        this.createBy = createBy == null ? null : createBy.trim();
	    }

	    public Date getCreateDate() {
	        return createDate;
	    }

	    public void setCreateDate(Date createDate) {
	        this.createDate = createDate;
	    }

	    public String getUpdateBy() {
	        return updateBy;
	    }

	    public void setUpdateBy(String updateBy) {
	        this.updateBy = updateBy == null ? null : updateBy.trim();
	    }

	    public Date getUpdateDate() {
	        return updateDate;
	    }

	    public void setUpdateDate(Date updateDate) {
	        this.updateDate = updateDate;
	    }

	    public String getRemarks() {
	        return remarks;
	    }

	    public void setRemarks(String remarks) {
	        this.remarks = remarks == null ? null : remarks.trim();
	    }

	    public Boolean getDelFlag() {
	        return delFlag;
	    }

	    public void setDelFlag(Boolean delFlag) {
	        this.delFlag = delFlag;
	    }

		public String getRememberMe() {
			return rememberMe;
		}

		public void setRememberMe(String rememberMe) {
			this.rememberMe = rememberMe;
		}
	    
}
