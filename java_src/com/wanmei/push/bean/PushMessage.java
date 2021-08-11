package com.wanmei.push.bean;

import com.pwrd.google.gson.annotations.Expose;
import com.pwrd.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

public class PushMessage implements Serializable {
    public static final String EXTRA_KEY = "userExtra";
    @SerializedName(AppState.APP_ID)
    @Expose
    private String appId;
    @SerializedName("bundleId")
    @Expose
    private String bundleId;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("extra")
    @Expose
    private Map<String, Object> extra;
    @SerializedName(Notice.MSG_ID)
    @Expose
    private String msgId;
    @SerializedName("offline")
    @Expose
    private String offline;
    @SerializedName("productionMode")
    @Expose
    private String productionMode;
    @SerializedName("title")
    @Expose
    private String title;

    public String getAppId() {
        return this.appId;
    }

    public String getBundleId() {
        return this.bundleId;
    }

    public String getContent() {
        return this.content;
    }

    public Map<String, Object> getExtra() {
        return this.extra;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public String getOffline() {
        return this.offline;
    }

    public String getProductionMode() {
        return this.productionMode;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAppId(String appId2) {
        this.appId = appId2;
    }

    public void setBundleId(String bundleId2) {
        this.bundleId = bundleId2;
    }

    public void setContent(String content2) {
        this.content = content2;
    }

    public void setExtra(Map<String, Object> extra2) {
        this.extra = extra2;
    }

    public void setMsgId(String msgId2) {
        this.msgId = msgId2;
    }

    public void setOffline(String offline2) {
        this.offline = offline2;
    }

    public void setProductionMode(String productionMode2) {
        this.productionMode = productionMode2;
    }

    public void setTitle(String title2) {
        this.title = title2;
    }

    public String toString() {
        return "PushMessage {msgId=" + this.msgId + ", appId=" + this.appId + ", bundleId=" + this.bundleId + ", title=" + this.title + ", content=" + this.content + ", offline=" + this.offline + ", productionMode=" + this.productionMode + ", extra=" + this.extra + "}";
    }
}
