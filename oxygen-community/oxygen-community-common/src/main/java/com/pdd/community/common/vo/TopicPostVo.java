package com.pdd.community.common.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @作者： ppx
 * @日期：2018年8月14日
 * @描述：展示对象
 */
public class TopicPostVo implements Serializable{


	 /**
	 * 
	 */
	private static final long serialVersionUID = -5227245163347326188L;

	/**
     * 自增主键
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 帖子类型（0主帖，1跟帖）
     */
    private Integer type;

    /**
     * 主帖id（如果type=0，则为-1,表示该帖子为主帖；如果type=1，则为id，表示主帖为id下的跟帖）
     */
    private Integer topicId;

    /**
     * 帖子状态（0待发布，1已发布，2已删除）
     */
    private Integer status;

    /**
     * 置顶状态（0不置顶，1置顶）
     */
    private Integer top;

    /**
     * 回帖数
     */
    private Integer replyCount;
   
    /**
     * 点赞数
     */
    private Integer likeCount;

    /**
     * 帖子所关联的商品id
     */
    private String goodId;

    /**
     * 帖子标题
     */
    private String title;

    /**
     * 帖子内容
     */
    private String content;

    /**
     * 图片
     */
    private String pics;

    /**
     * 视频，暂时不用
     */
    private String video;

    /**
     * 创建时间
     */
    private Date createTime;
    
    /**
     * 用户名
     */
    private String username;
    
    /**
     * 用户头像
     */
    private String txpath;
    
    /**
     * 商品名称
     */
    private String goodName;
    
    /**
     * 报价/推荐价格
     */
    private BigDecimal quotePrice;

    
    /**
     * 商品图片链接
     */
    private String picUrl;
    
    /**
     * 商品介绍
     */
    private String goodIntroduce;
    

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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getTop() {
		return top;
	}

	public void setTop(Integer top) {
		this.top = top;
	}

	public Integer getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}

	public String getGoodId() {
		return goodId;
	}

	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPics() {
		return pics;
	}

	public void setPics(String pics) {
		this.pics = pics;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTxpath() {
		return txpath;
	}

	public void setTxpath(String txpath) {
		this.txpath = txpath;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getGoodIntroduce() {
		return goodIntroduce;
	}

	public void setGoodIntroduce(String goodIntroduce) {
		this.goodIntroduce = goodIntroduce;
	}

	public BigDecimal getQuotePrice() {
		return quotePrice;
	}

	public void setQuotePrice(BigDecimal quotePrice) {
		this.quotePrice = quotePrice;
	}



	
    
}
