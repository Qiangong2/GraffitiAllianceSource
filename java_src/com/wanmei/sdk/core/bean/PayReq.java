package com.wanmei.sdk.core.bean;

import com.pwrd.google.gson.annotations.Expose;

public class PayReq extends CommReq {
    @Expose
    private int amount;
    @Expose
    private String appOrder;
    @Expose
    private String ext = "";
    @Expose
    private int serverId;
    @Expose
    private String uid;
    @Expose
    private String version;

    public int getAmount() {
        return this.amount;
    }

    public String getAppOrder() {
        return this.appOrder;
    }

    public String getExt() {
        return this.ext;
    }

    public String getPaySchemeVersion() {
        return this.version;
    }

    public int getServerId() {
        return this.serverId;
    }

    public String getUid() {
        return this.uid;
    }

    public void setAmount(int amount2) {
        this.amount = amount2;
    }

    public void setAppOrder(String appOrder2) {
        this.appOrder = appOrder2;
    }

    public void setExt(String ext2) {
        if (ext2 != null) {
            this.ext = ext2.trim();
        }
    }

    public void setPaySchemeVersion(String paySchemeVersion) {
        this.version = paySchemeVersion;
    }

    public void setServerId(int serverId2) {
        this.serverId = serverId2;
    }

    public void setUid(String uid2) {
        this.uid = uid2;
    }
}
