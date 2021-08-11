package com.wanmei.sdk.core.bean;

import com.pwrd.google.gson.annotations.Expose;

public class LoginResp extends CommResp {
    @Expose
    private String password;
    @Expose
    private String token;
    @Expose
    private String uid;

    public String getPassord() {
        return this.password;
    }

    public String getToken() {
        return this.token;
    }

    public String getUid() {
        return this.uid;
    }

    public void setPassord(String passord) {
        this.password = passord;
    }

    public void setToken(String token2) {
        this.token = token2;
    }

    public void setUid(String uid2) {
        this.uid = uid2;
    }
}
