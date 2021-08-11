package com.wanmei.sdk.core.bean;

import com.pwrd.google.gson.annotations.Expose;
import com.wanmei.sdk.core.LibCoreCode;

public class CommResp {
    @Expose
    protected int code = -1;
    @Expose
    protected String msg = LibCoreCode.MSG_ERROR;

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int code2) {
        this.code = code2;
    }

    public void setMsg(String msg2) {
        this.msg = msg2;
    }
}
