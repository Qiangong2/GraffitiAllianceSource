package com.wanmei.push.bean;

import com.pwrd.google.gson.annotations.Expose;
import com.pwrd.google.gson.annotations.SerializedName;

public class PullAppInfo {
    @SerializedName("pushAppId")
    @Expose
    private String pushAppId;
    @SerializedName("pushAppKey")
    @Expose
    private String pushAppKey;
    @SerializedName("sdkAppId")
    @Expose
    private String sdkAppId;

    public String getPushAppId() {
        return this.pushAppId;
    }

    public String getPushAppKey() {
        return this.pushAppKey;
    }

    public String getSdkAppId() {
        return this.sdkAppId;
    }

    public void setPushAppId(String pushAppId2) {
        this.pushAppId = pushAppId2;
    }

    public void setPushAppKey(String pushAppKey2) {
        this.pushAppKey = pushAppKey2;
    }

    public void setSdkAppId(String sdkAppId2) {
        this.sdkAppId = sdkAppId2;
    }

    public String toString() {
        return "PullAppInfo{sdkAppId='" + this.sdkAppId + '\'' + ", pushAppId='" + this.pushAppId + '\'' + ", pushAppKey='" + this.pushAppKey + '\'' + '}';
    }
}
