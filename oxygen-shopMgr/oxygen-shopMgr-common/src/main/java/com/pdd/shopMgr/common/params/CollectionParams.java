package com.pdd.shopMgr.common.params;

import com.pdd.common.core.params.page.PageParam;

public class CollectionParams extends PageParam{

	/**
	 * 
	 */
	private static final long serialVersionUID = 688515186987216175L;

	/**
     * 自增主键
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 商品id
     */
    private String goodId;
   
    /**
     * 类别（0失效；1低库存；2降价）
     */
    private Integer queryType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getGoodId() {
		return goodId;
	}

	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}

	public Integer getQueryType() {
		return queryType;
	}

	public void setQueryType(Integer queryType) {
		this.queryType = queryType;
	}
    
    
}
