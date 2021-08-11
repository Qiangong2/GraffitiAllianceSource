package com.wanmei.sdk.core.open;

import com.pwrd.google.gson.annotations.Expose;
import com.pwrd.google.gson.annotations.SerializedName;

public class Channel {
    @SerializedName("biName")
    @Expose
    private String mBiName;
    @SerializedName("channelDesc")
    @Expose
    private String mChannelDesc;
    @SerializedName("channelName")
    @Expose
    private String mChannelName;

    public String getBiName() {
        return this.mBiName;
    }

    public String getChannelDesc() {
        return this.mChannelDesc;
    }

    public String getChannelName() {
        return this.mChannelName;
    }

    public String toString() {
        return "Channel{mChannelName='" + this.mChannelName + '\'' + ", mChannelDesc='" + this.mChannelDesc + '\'' + ", mBiName='" + this.mBiName + '\'' + '}';
    }
}
