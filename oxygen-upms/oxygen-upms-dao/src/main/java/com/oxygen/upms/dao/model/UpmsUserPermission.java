package com.oxygen.upms.dao.model;

import java.io.Serializable;

public class UpmsUserPermission implements Serializable {
    /**
     * 编号
     *
     * @mbg.generated
     */
    private String userPermissionId;

    /**
     * 用户编号
     *
     * @mbg.generated
     */
    private String userId;

    /**
     * 权限编号
     *
     * @mbg.generated
     */
    private String permissionId;

    /**
     * 权限类型(-1:减权限,1:增权限)
     *
     * @mbg.generated
     */
    private Byte type;

    private static final long serialVersionUID = 1L;

    public String getUserPermissionId() {
        return userPermissionId;
    }

    public void setUserPermissionId(String userPermissionId) {
        this.userPermissionId = userPermissionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userPermissionId=").append(userPermissionId);
        sb.append(", userId=").append(userId);
        sb.append(", permissionId=").append(permissionId);
        sb.append(", type=").append(type);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UpmsUserPermission other = (UpmsUserPermission) that;
        return (this.getUserPermissionId() == null ? other.getUserPermissionId() == null : this.getUserPermissionId().equals(other.getUserPermissionId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPermissionId() == null ? other.getPermissionId() == null : this.getPermissionId().equals(other.getPermissionId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserPermissionId() == null) ? 0 : getUserPermissionId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPermissionId() == null) ? 0 : getPermissionId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        return result;
    }
}