package com.pdd.manage.common.po;

import java.util.Date;

public class UpmsLog {
    private String logId;

    private String description;

    private String username;

    private Date startTime;

    private Integer spendTime;

    private String basePath;

    private String uri;

    private String url;

    private String method;

    private String parameter;

    private String userAgent;

    private String ip;

    private String result;

    private String permissions;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId == null ? null : logId.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(Integer spendTime) {
        this.spendTime = spendTime;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath == null ? null : basePath.trim();
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter == null ? null : parameter.trim();
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent == null ? null : userAgent.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions == null ? null : permissions.trim();
    }
}