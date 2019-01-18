package com.pdd.community.common.params;

import java.io.Serializable;
/**
 * 
 * @作者： ppx
 * @日期：2018年8月14日
 * @描述：参数对象
 */
public class UserLikeParams implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7092784761110697151L;
	
	  /**
     * 自增主键
     */
    private Integer id;

    /**
     * 帖子id(帖子表自增主键)
     */
    private Integer topicPostId;

    /**
     * 用户Id
     */
    private Integer userId;

    /**
     * 状态（0为取消点赞；1为已点赞）
     */
    private Integer status;
    

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTopicPostId() {
		return topicPostId;
	}

	public void setTopicPostId(Integer topicPostId) {
		this.topicPostId = topicPostId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

    
}
