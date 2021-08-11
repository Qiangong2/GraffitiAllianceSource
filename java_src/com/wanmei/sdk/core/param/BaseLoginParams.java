package com.wanmei.sdk.core.param;

public abstract class BaseLoginParams extends BaseParams {
    protected String channelToken;
    protected String channelUid;

    protected BaseLoginParams() {
    }

    public String getChannelToken() {
        return this.channelToken;
    }

    public String getChannelUid() {
        return this.channelUid;
    }

    public void setBasicParams(String channelUid2, String channelToken2) {
        this.channelUid = channelUid2;
        this.channelToken = channelToken2;
    }

    public String toString() {
        return "LoginParams{platUid='" + this.channelUid + '\'' + ", platToken='" + this.channelToken + '\'' + "} " + super.toString();
    }
}
