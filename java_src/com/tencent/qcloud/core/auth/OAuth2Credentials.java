package com.tencent.qcloud.core.auth;

import java.util.Date;

public class OAuth2Credentials implements QCloudCredentials {
    private String accessToken;
    private String authorizationCode;
    private String openId;
    private String platform;
    private String refreshToken;
    private String scope;
    private Date tokenStartTime;
    private Date validFromDate;

    private OAuth2Credentials(Builder builder) {
        this.platform = builder.platform;
        this.accessToken = builder.accessToken;
        this.tokenStartTime = new Date(builder.tokenStartTime);
        this.validFromDate = new Date(builder.tokenStartTime + (builder.expiresIn * 1000));
        this.refreshToken = builder.refreshToken;
        this.openId = builder.openId;
        this.scope = builder.scope;
        this.authorizationCode = builder.authorizationCode;
    }

    public String getPlatform() {
        return this.platform;
    }

    @Override // com.tencent.qcloud.core.auth.QCloudCredentials
    public String getSecretId() {
        return this.openId;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getOpenId() {
        return this.openId;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > this.validFromDate.getTime();
    }

    public long getExpiresInSeconds() {
        return (this.validFromDate.getTime() - this.tokenStartTime.getTime()) / 1000;
    }

    public Date getValidFromDate() {
        return this.validFromDate;
    }

    public Date getTokenStartTime() {
        return this.tokenStartTime;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public String getScope() {
        return this.scope;
    }

    public String getAuthorizationCode() {
        return this.authorizationCode;
    }

    public static final class Builder {
        private String accessToken;
        private String authorizationCode;
        private long expiresIn;
        private String openId;
        private String platform;
        private String refreshToken;
        private String scope;
        private long tokenStartTime;

        public Builder platform(String val) {
            this.platform = val;
            return this;
        }

        public Builder accessToken(String val) {
            this.accessToken = val;
            return this;
        }

        public Builder expiresInSeconds(long val) {
            this.expiresIn = val;
            return this;
        }

        public Builder tokenStartTime(long val) {
            this.tokenStartTime = val;
            return this;
        }

        public Builder refreshToken(String val) {
            this.refreshToken = val;
            return this;
        }

        public Builder openId(String val) {
            this.openId = val;
            return this;
        }

        public Builder authorizationCode(String authorizationCode2) {
            this.authorizationCode = authorizationCode2;
            return this;
        }

        public Builder scope(String val) {
            this.scope = val;
            return this;
        }

        public OAuth2Credentials build() {
            return new OAuth2Credentials(this);
        }
    }
}
