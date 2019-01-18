package com.pdd.common.core.params.page;

import java.io.Serializable;

/**
 * @描述：分页参数实体 @作者： wu.liang
 * @日期：Feb 6, 2018
 */
public class PageParam implements Serializable {
	private static final long serialVersionUID = 6297178964005032338L;
	
	/**
	 * 当前页
	 */
	private int pageNo = 1;
	/**
	 * 每页行数
	 */
	private int pageSize = 10;

	
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
