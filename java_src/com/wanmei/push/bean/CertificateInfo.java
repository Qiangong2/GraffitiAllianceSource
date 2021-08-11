package com.wanmei.push.bean;

import com.pwrd.google.gson.annotations.Expose;
import com.pwrd.google.gson.annotations.SerializedName;

public class CertificateInfo {
    @SerializedName(AppState.APP_ID)
    @Expose
    private String appId;
    @SerializedName("xmAppId")
    @Expose
    private String xmAppId = "";
    @SerializedName("xmAppKey")
    @Expose
    private String xmAppKey = "";

    public String getAppId() {
        return this.appId;
    }

    public String getXmAppId() {
        return this.xmAppId;
    }

    public String getXmAppKey() {
        return this.xmAppKey;
    }

    public void setAppId(String appId2) {
        this.appId = appId2;
    }

    public void setXmAppId(String xmAppId2) {
        this.xmAppId = xmAppId2;
    }

    public void setXmAppKey(String xmAppKey2) {
        this.xmAppKey = xmAppKey2;
    }

    public String toString() {
        return "CertificateInfo{appId='" + this.appId + '\'' + ", xmAppId='" + this.xmAppId + '\'' + ", xmAppKey='" + this.xmAppKey + '\'' + '}';
    }
}
