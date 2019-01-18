package com.pdd.community.common.po;

import java.io.Serializable;

public class StoreTopicUserLike implements Serializable {
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