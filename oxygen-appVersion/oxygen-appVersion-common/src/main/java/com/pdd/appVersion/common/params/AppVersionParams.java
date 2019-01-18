package com.pdd.appVersion.common.params;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value="参数对象AppVersionParams",description="app更新参数对象")
public class AppVersionParams implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1255794423628914386L;

	@ApiModelProperty(value="自增主键",name="id")
	private Integer id;
	@ApiModelProperty(value="版本号",name="number")
	private Double number;
	@ApiModelProperty(value="备注",name="remarks")
	private String remarks;

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
		this.remarks = remarks;
	}

}
