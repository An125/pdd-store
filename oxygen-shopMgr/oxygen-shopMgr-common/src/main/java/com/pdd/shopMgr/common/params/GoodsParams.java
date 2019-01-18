package com.pdd.shopMgr.common.params;

import com.pdd.common.core.params.page.PageParam;

/**
 * @描述：分页查询商品
 * @作者： wu.liang
 * @日期：Feb 6, 2018
 */
public class GoodsParams extends PageParam {
	private static final long serialVersionUID = -3949423524350440943L;
    private String shopId;
    private Byte isEnable;
    private String goodId; 
    /**
     * 关键词---用于搜索商品
     */
    private String keyWords;
    /**
     * 排序类型
     */
    private String sortType;
    
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public Byte getIsEnable() {
		return isEnable;
	}
	public void setIsEnable(Byte isEnable) {
		this.isEnable = isEnable;
	}
	public String getGoodId() {
		return goodId;
	}
	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}
	public String getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	public String getSortType() {
		return sortType;
	}
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	
}
