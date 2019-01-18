package com.pdd.community.common.po;

import java.io.Serializable;
import java.util.Date;

public class StoreTopicPost implements Serializable {
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
     * 视频
     */
    private String video;

    /**
     * 创建时间
     */
    private Date createTime;

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

    private static final long serialVersionUID = 1L;

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

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId == null ? null : goodId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics == null ? null : pics.trim();
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video == null ? null : video.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBackupfield1() {
        return backupfield1;
    }

    public void setBackupfield1(String backupfield1) {
        this.backupfield1 = backupfield1 == null ? null : backupfield1.trim();
    }

    public String getBackupfield2() {
        return backupfield2;
    }

    public void setBackupfield2(String backupfield2) {
        this.backupfield2 = backupfield2 == null ? null : backupfield2.trim();
    }

    public String getBackupfield3() {
        return backupfield3;
    }

    public void setBackupfield3(String backupfield3) {
        this.backupfield3 = backupfield3 == null ? null : backupfield3.trim();
    }
}