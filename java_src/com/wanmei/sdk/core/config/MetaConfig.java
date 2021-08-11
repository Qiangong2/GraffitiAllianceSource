package com.wanmei.sdk.core.config;

import android.text.TextUtils;
import com.pwrd.google.gson.annotations.Expose;

public class MetaConfig implements NeedValidate {
    @Expose
    private int channelId;
    @Expose
    private String packageName;
    @Expose
    private int platform;
    @Expose
    private String version;

    public int getChannelId() {
        return this.channelId;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getPlatform() {
        return this.platform;
    }

    public String getVersion() {
        return this.version;
    }

    public void setChannelId(int channelId2) {
        this.channelId = channelId2;
    }

    public void setPackageName(String packageName2) {
        this.packageName = packageName2;
    }

    public void setPlatform(int platform2) {
        this.platform = platform2;
    }

    public void setVersion(String version2) {
        this.version = version2;
    }

    public String toString() {
        return "MetaConfig [version=" + this.version + ", platform=" + this.platform + ", channelId=" + this.channelId + ", packageName=" + this.packageName + "]";
    }

    @Override // com.wanmei.sdk.core.config.NeedValidate
    public void validate() throws ConfigFileException {
        if (TextUtils.isEmpty(this.version)) {
            throw new ConfigFileException("meta error: version is empty");
        } else if (this.platform != 1) {
            throw new ConfigFileException("meta error: platform is not android");
        } else if (this.channelId <= 0) {
            throw new ConfigFileException("meta error: channelId is:" + this.channelId);
        } else if (TextUtils.isEmpty(this.packageName)) {
            throw new ConfigFileException("meta error: package is empty");
        }
    }
}
