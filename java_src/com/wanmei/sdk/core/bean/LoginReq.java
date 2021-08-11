package com.wanmei.sdk.core.bean;

import com.pwrd.google.gson.annotations.Expose;

public class LoginReq extends CommReq {
    @Expose
    private String platToken;
    @Expose
    private String platUid;
    @Expose
    private String version;

    public String getLoginSchemeVersion() {
        return this.version;
    }

    public String getPlatToken() {
        return this.platToken;
    }

    public String getPlatUid() {
        return this.platUid;
    }

    public void setLoginSchemeVersion(String loginSchemeVersion) {
        this.version = loginSchemeVersion;
    }

    public void setPlatToken(String platToken2) {
        this.platToken = platToken2;
    }

    public void setPlatUid(String platUid2) {
        this.platUid = platUid2;
    }
}
