package com.wanmei.sdk.core.config;

import com.pwrd.google.gson.annotations.SerializedName;

public class InitConfig implements NeedValidate {
    @SerializedName("custom_service")
    private boolean enableCustomService;
    @SerializedName("share_weixin_id")
    private String shareWeixinId;

    public String getShareWeixinId() {
        return this.shareWeixinId;
    }

    public boolean isEnableCustomService() {
        return this.enableCustomService;
    }

    public void setEnableCustomService(boolean enableCustomService2) {
        this.enableCustomService = enableCustomService2;
    }

    public void setShareWeixinId(String shareWeixinId2) {
        this.shareWeixinId = shareWeixinId2;
    }

    public String toString() {
        return "Common{shareWeixinId='" + this.shareWeixinId + '\'' + ", enableCustomService=" + this.enableCustomService + '}';
    }

    @Override // com.wanmei.sdk.core.config.NeedValidate
    public void validate() throws ConfigFileException {
    }
}
