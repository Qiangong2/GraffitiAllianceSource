package com.wanmei.sdk.core.bean;

import com.pwrd.google.gson.annotations.Expose;
import java.util.HashMap;

public class CommReq {
    @Expose
    protected int appId;
    @Expose
    protected int channelId;
    @Expose
    protected HashMap<String, String> extraJson = new HashMap<>();
    @Expose
    protected int platform = 1;

    public int getAppId() {
        return this.appId;
    }

    public int getChannelId() {
        return this.channelId;
    }

    public HashMap<String, String> getExtraJson() {
        return this.extraJson;
    }

    public void setAppId(int appId2) {
        this.appId = appId2;
    }

    public void setChannelId(int channelId2) {
        this.channelId = channelId2;
    }

    public void setExtraMap(HashMap<String, String> extraMap) {
        this.extraJson = extraMap;
    }
}
