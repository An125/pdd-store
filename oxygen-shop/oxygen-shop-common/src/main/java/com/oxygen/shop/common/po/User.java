package com.oxygen.shop.common.po;

public class User {
    private Integer id;

    private String username;

    private String mobile;

    private String password;

    private String privilege;

    private String location;

    private String superior;

    private String depth;

    private String path;

    private String revenue;

    private String consume;

    private String generated;

    private String invitation;

    private String credits;

    private String date;

    private String txpath;

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

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege == null ? null : privilege.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getSuperior() {
        return superior;
    }

    public void setSuperior(String superior) {
        this.superior = superior == null ? null : superior.trim();
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

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue == null ? null : revenue.trim();
    }

    public String getConsume() {
        return consume;
    }

    public void setConsume(String consume) {
        this.consume = consume == null ? null : consume.trim();
    }

    public String getGenerated() {
        return generated;
    }

    public void setGenerated(String generated) {
        this.generated = generated == null ? null : generated.trim();
    }

    public String getInvitation() {
        return invitation;
    }

    public void setInvitation(String invitation) {
        this.invitation = invitation == null ? null : invitation.trim();
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits == null ? null : credits.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getTxpath() {
        return txpath;
    }

    public void setTxpath(String txpath) {
        this.txpath = txpath == null ? null : txpath.trim();
    }
}