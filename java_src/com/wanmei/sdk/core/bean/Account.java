package com.wanmei.sdk.core.bean;

public class Account {
    private String password = "";
    private String token = "";
    private String userId = "0";

    public String getPassword() {
        return this.password;
    }

    public String getToken() {
        return this.token;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setPassword(String password2) {
        this.password = password2;
    }

    public void setToken(String token2) {
        this.token = token2;
    }

    public void setUserId(String userId2) {
        this.userId = userId2;
    }

    public String toString() {
        return "LibAccount [userId=" + this.userId + ", token=" + this.token + ", password=" + this.password + "]";
    }
}
