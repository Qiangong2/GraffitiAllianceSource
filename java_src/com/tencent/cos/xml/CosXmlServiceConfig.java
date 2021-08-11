package com.tencent.cos.xml;

import com.tencent.cos.xml.common.VersionInfo;
import com.tencent.qcloud.core.http.HttpConstants;

public class CosXmlServiceConfig {
    public static final String DEFAULT_PROTOCOL = "http";
    public static final String DEFAULT_USER_AGENT = VersionInfo.getUserAgent();
    private String appid;
    private boolean isDebuggable;
    private String protocol;
    private String region;
    private String userAgent;

    public CosXmlServiceConfig(Builder builder) {
        this.protocol = builder.protocol;
        this.userAgent = builder.userAgent;
        this.appid = builder.appid;
        this.region = builder.region;
        this.isDebuggable = builder.isDebuggable;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public String getRegion() {
        return this.region;
    }

    public String getAppid() {
        return this.appid;
    }

    public boolean isDebuggable() {
        return this.isDebuggable;
    }

    public static final class Builder {
        private String appid;
        private boolean isDebuggable = false;
        private String protocol = "http";
        private String region;
        private String userAgent = CosXmlServiceConfig.DEFAULT_USER_AGENT;

        public Builder isHttps(boolean isHttps) {
            if (isHttps) {
                this.protocol = HttpConstants.Scheme.HTTPS;
            } else {
                this.protocol = "http";
            }
            return this;
        }

        public Builder setAppidAndRegion(String appid2, String region2) {
            this.appid = appid2;
            this.region = region2;
            return this;
        }

        public Builder setDebuggable(boolean isDebuggable2) {
            this.isDebuggable = isDebuggable2;
            return this;
        }

        public CosXmlServiceConfig builder() {
            return new CosXmlServiceConfig(this);
        }
    }
}
