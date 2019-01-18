package com.pdd.community.common.params;

import com.pdd.common.core.params.page.PageParam;

/**
 * 
 * @作者： ppx
 * @日期：2018年8月14日
 * @描述：参数对象
 */
public class TopicPostParams extends PageParam {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = -4758819517797800858L;

	/**
     * 自增主键
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

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
     * 视频
     */
    private String video;

    /**
     * 备用字段1
     */
    private String backupfield1;

    /**
     * 备用字段2
     */
    private String backupfield2;

    /**
     * 备用字段3
     */
    private String backupfield3;
    
    /**
     * 排序类型---0时间，1热度（回帖数+点赞数）
     */
    private Integer sortType;
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

	public String getBackupfield1() {
		return backupfield1;
	}

	public void setBackupfield1(String backupfield1) {
		this.backupfield1 = backupfield1;
	}

	public String getBackupfield2() {
		return backupfield2;
	}

	public void setBackupfield2(String backupfield2) {
		this.backupfield2 = backupfield2;
	}

	public String getBackupfield3() {
		return backupfield3;
	}

	public void setBackupfield3(String backupfield3) {
		this.backupfield3 = backupfield3;
	}

	public Integer getSortType() {
		return sortType;
	}

	public void setSortType(Integer sortType) {
		this.sortType = sortType;
	}
	
	
}
