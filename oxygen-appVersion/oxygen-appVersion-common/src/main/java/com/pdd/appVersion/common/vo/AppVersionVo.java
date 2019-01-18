package com.pdd.appVersion.common.vo;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="展示对象AppVersionVo",description="app版本展示对象")
public class AppVersionVo  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3029815159130757420L;
	
	@ApiModelProperty(value="自增主键",name="id")
	private Integer id;
	@ApiModelProperty(value="版本号",name="number")
    private Double number;
	@ApiModelProperty(value="备注",name="remarks")
    private String remarks;
	@ApiModelProperty(value="创建时间",name="createDate")
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
