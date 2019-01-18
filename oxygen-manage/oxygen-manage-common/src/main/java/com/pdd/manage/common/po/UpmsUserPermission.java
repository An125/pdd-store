package com.pdd.manage.common.po;

public class UpmsUserPermission {
    private String userPermissionId;

    private String userId;

    private String permissionId;

    private Byte type;

    public String getUserPermissionId() {
        return userPermissionId;
    }

    public void setUserPermissionId(String userPermissionId) {
        this.userPermissionId = userPermissionId == null ? null : userPermissionId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId == null ? null : permissionId.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }
}