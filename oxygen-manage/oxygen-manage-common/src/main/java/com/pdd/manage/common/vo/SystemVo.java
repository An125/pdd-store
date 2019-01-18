package com.pdd.manage.common.vo;

import java.io.Serializable;
import java.util.Date;

public class SystemVo implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = -6365328023518329875L;

	private String systemId;

	    private String icon;

	    private String banner;

	    private String theme;

	    private String basepath;

	    private Byte status;

	    private String name;

	    private String title;

	    private String description;

	    private Long orders;

	    private String createBy;

	    private Date createDate;

	    private String updateBy;

	    private Date updateDate;

	    private String remarks;

	    private Byte delFlag;

		public String getSystemId() {
			return systemId;
		}

		public void setSystemId(String systemId) {
			this.systemId = systemId;
		}

		public String getIcon() {
			return icon;
		}

		public void setIcon(String icon) {
			this.icon = icon;
		}

		public String getBanner() {
			return banner;
		}

		public void setBanner(String banner) {
			this.banner = banner;
		}

		public String getTheme() {
			return theme;
		}

		public void setTheme(String theme) {
			this.theme = theme;
		}

		public String getBasepath() {
			return basepath;
		}

		public void setBasepath(String basepath) {
			this.basepath = basepath;
		}

		public Byte getStatus() {
			return status;
		}

		public void setStatus(Byte status) {
			this.status = status;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Long getOrders() {
			return orders;
		}

		public void setOrders(Long orders) {
			this.orders = orders;
		}

		public String getCreateBy() {
			return createBy;
		}

		public void setCreateBy(String createBy) {
			this.createBy = createBy;
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
			this.updateBy = updateBy;
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
			this.remarks = remarks;
		}

		public Byte getDelFlag() {
			return delFlag;
		}

		public void setDelFlag(Byte delFlag) {
			this.delFlag = delFlag;
		}

}
