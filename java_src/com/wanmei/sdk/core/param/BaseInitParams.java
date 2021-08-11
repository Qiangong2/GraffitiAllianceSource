package com.wanmei.sdk.core.param;

public abstract class BaseInitParams extends BaseParams {
    protected int commonAppId;
    protected String commonAppKey;

    protected BaseInitParams() {
    }

    public int getCommonAppId() {
        return this.commonAppId;
    }

    public String getCommonAppKey() {
        return this.commonAppKey;
    }

    public void setCommonAppId(int commonAppId2) {
        this.commonAppId = commonAppId2;
    }

    public void setCommonAppKey(String commonAppKey2) {
        this.commonAppKey = commonAppKey2;
    }

    public String toString() {
        return "InitParams{appId=" + this.commonAppId + ", appKey='" + this.commonAppKey + '\'' + "} " + super.toString();
    }
}
