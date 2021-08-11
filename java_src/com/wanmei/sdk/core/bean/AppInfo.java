package com.wanmei.sdk.core.bean;

public class AppInfo {
    private int appId;
    private String appKey;
    private int channelId;
    private String loginSchemeVersion;
    private String paySchemeVersion;

    public int getAppId() {
        return this.appId;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public int getChannelId() {
        return this.channelId;
    }

    public String getLoginSchemeVersion() {
        return this.loginSchemeVersion;
    }

    public String getPaySchemeVersion() {
        return this.paySchemeVersion;
    }

    public void setAppId(int appId2) {
        this.appId = appId2;
    }

    public void setAppKey(String appKey2) {
        this.appKey = appKey2;
    }

    public void setChannelId(int channelId2) {
        this.channelId = channelId2;
    }

    public void setLoginSchemeVersion(String loginSchemeVersion2) {
        this.loginSchemeVersion = loginSchemeVersion2;
    }

    public void setPaySchemeVersion(String paySchemeVersion2) {
        this.paySchemeVersion = paySchemeVersion2;
    }
}
