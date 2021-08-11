package com.wanmei.push.bean;

import com.pwrd.google.gson.annotations.Expose;
import com.pwrd.google.gson.annotations.SerializedName;

public class StandardBaseResult<T> {
    @SerializedName("code")
    @Expose
    protected int code = 0;
    @SerializedName("message")
    @Expose
    protected String message;
    @SerializedName("result")
    @Expose
    protected T result;

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public T getResult() {
        return this.result;
    }

    public void setCode(int code2) {
        this.code = code2;
    }

    public void setMessage(String message2) {
        this.message = message2;
    }

    public void setResult(T result2) {
        this.result = result2;
    }

    public String toString() {
        return "StandardBaseResult{code=" + this.code + ", message='" + this.message + '\'' + ", result=" + ((Object) this.result) + '}';
    }
}
