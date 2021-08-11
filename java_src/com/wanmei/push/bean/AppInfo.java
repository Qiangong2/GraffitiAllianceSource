package com.wanmei.push.bean;

import com.pwrd.google.gson.annotations.Expose;
import com.pwrd.google.gson.annotations.SerializedName;

public class AppInfo {
    @SerializedName("appClientId")
    @Expose
    private String appClientId;
    private String appClientSecret = "";
    @SerializedName("packageName")
    @Expose
    private String packageName = "";

    public String getAppClientId() {
        return this.appClientId;
    }

    public String getAppClientSecret() {
        return this.appClientSecret;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setAppClientId(String appId) {
        this.appClientId = appId;
    }

    public void setAppClientSecret(String appKey) {
        this.appClientSecret = appKey;
    }

    public void setPackageName(String pkName) {
        this.packageName = pkName;
    }

    public String toString() {
        return "AppInfo{appClientId=" + this.appClientId + ", appClientSecret=" + this.appClientSecret + ", packageName='" + this.packageName + '\'' + "} " + super.toString();
    }
}
