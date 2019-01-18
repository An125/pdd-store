package com.pdd.manage.common.po;

public class UpmsUserOrganization {
    private String userOrganizationId;

    private String userId;

    private String organizationId;

    public String getUserOrganizationId() {
        return userOrganizationId;
    }

    public void setUserOrganizationId(String userOrganizationId) {
        this.userOrganizationId = userOrganizationId == null ? null : userOrganizationId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId == null ? null : organizationId.trim();
    }
}