package com.wanmei.push.bean;

import com.pwrd.google.gson.annotations.Expose;
import com.pwrd.google.gson.annotations.SerializedName;

public class OneSDKInfo {
    @SerializedName("oneAppId")
    @Expose
    private String oneAppId;
    @SerializedName("oneAppKey")
    @Expose
    private String oneAppKey = "";

    public String getOneAppId() {
        return this.oneAppId;
    }

    public String getOneAppKey() {
        return this.oneAppKey;
    }

    public void setOneAppId(String oneAppId2) {
        this.oneAppId = oneAppId2;
    }

    public void setOneAppKey(String oneAppKey2) {
        this.oneAppKey = oneAppKey2;
    }

    public String toString() {
        return "OneSDKInfo{oneAppId='" + this.oneAppId + '\'' + ", oneAppKey='" + this.oneAppKey + '\'' + '}';
    }
}
