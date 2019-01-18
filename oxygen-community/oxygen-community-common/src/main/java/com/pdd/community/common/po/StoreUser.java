package com.pdd.community.common.po;

import java.io.Serializable;
import java.util.Date;

public class StoreUser implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 账号
     */
    private String username;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 密码
     */
    private String password;

    /**
     * 深度
     */
    private String depth;

    /**
     * 从根节点到当前节点的路径的字符串
     */
    private String path;

    /**
     * 邀请码
     */
    private String invitation;

    /**
     * 生成码
     */
    private String generated;

    /**
     * 头像路径
     */
    private String txpath;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 用户身份 默认0表示普通用户
     */
    private Integer type;

    /**
     * 
     */
    private String salt;

    /**
     * 用户关联商铺ID
     */
    private String shopId;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth == null ? null : depth.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getInvitation() {
        return invitation;
    }

    public void setInvitation(String invitation) {
        this.invitation = invitation == null ? null : invitation.trim();
    }

    public String getGenerated() {
        return generated;
    }

    public void setGenerated(String generated) {
        this.generated = generated == null ? null : generated.trim();
    }

    public String getTxpath() {
        return txpath;
    }

    public void setTxpath(String txpath) {
        this.txpath = txpath == null ? null : txpath.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}