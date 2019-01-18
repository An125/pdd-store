package com.pdd.common.core.params.page;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * @ClassName: Page
 * @Description: 分页数据模型对象.
 * @Author WuLiang
 * @Date 2013-11-12 上午10:23:53
 * @Copyright: 版权归 HundSun 所有
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Page<T> implements Serializable {
	private static final long serialVersionUID = 9054350764314191312L;
	/**
	 * 设定缺省每页的记录数
	 */
	private int pageSize = 10;

	/**
	 * 每页中存放的记录列表
	 */
	private List<T> list = null;

	/**
	 * 总记录数
	 */
	private int rowCount = 0;
	
	/**
	 * 跳转的页码数,缺省值为第1页
	 */
	private int pageNo = 1;
	
	/**
	 * 总页数... 计算公式：rowCount/pageSize 或 (rowCount/pageSize) +1
	 */
	private int pageCount;
	/**
	 * 构造方法
	 * @param rowCount
	 */
	public Page(int rowCount) {
		this.rowCount = rowCount;
		this.pageCount = countTotalPage();
	}

	/**
	 * 构造方法
	 * @param pageNo
	 * @param pageSize 
	 * @param rowCount
	 */
	public Page(int pageNo, int pageSize, int rowCount) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.rowCount = rowCount;
		this.pageCount = countTotalPage();
	}

	/**
	 * 构造方法
	 * @param pageNo 页码
	 * @param pageSize 每页条数
	 * @param rowCount 总条数
	 * @param list 当前页码，页面中所有数据对象
	 */
	public Page(int pageNo, int pageSize, int rowCount, List<T> list) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.rowCount = rowCount;
		this.pageCount = countTotalPage();
		this.list = list;
	}

	/**
	 * 计算总页数
	 * @return
	 */
	private final int countTotalPage() {

		if (rowCount % pageSize == 0)
			return rowCount / pageSize;
		else
			return rowCount / pageSize + 1;
	}

	/**
	 * 每页多少条数据
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
		this.pageCount = countTotalPage();
	}

	public int getPageCount() {
		return pageCount;
	}

	

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	/**
	 * 获取跳转页第一条数据所在数据集的位置
	 * @return
	 */
	public int getRowStartIndex() {
		if(pageNo > pageCount) pageNo = pageCount;
		if(pageNo <= 1) return 0;
		else return (pageNo - 1) * pageSize; //跳转页第一条数据所在数据集的位置等于之前所有页面数乘以页面大小  
	}

	/**
	 * 输出本页统计信息
	 */
	@Override
	public String toString() {
		return "Page [pageSize=" + pageSize + ", list=" + list + ", rowCount="
				+ rowCount + ", pageNo=" + pageNo + ", pageCount=" + pageCount
				+ "]";
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	

}
