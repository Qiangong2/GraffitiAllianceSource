package com.wanmei.sdk.core.bean;

import com.pwrd.google.gson.annotations.Expose;

public class PayResp extends CommResp {
    @Expose
    private String orderId;

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String orderId2) {
        this.orderId = orderId2;
    }
}
