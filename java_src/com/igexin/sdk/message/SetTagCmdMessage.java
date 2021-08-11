package com.igexin.sdk.message;

public class SetTagCmdMessage extends GTCmdMessage {

    /* renamed from: a */
    private String f3081a;

    /* renamed from: b */
    private String f3082b;

    public SetTagCmdMessage() {
    }

    public SetTagCmdMessage(String str, String str2, int i) {
        super(i);
        this.f3081a = str;
        this.f3082b = str2;
    }

    public String getCode() {
        return this.f3082b;
    }

    public String getSn() {
        return this.f3081a;
    }

    public void setCode(String str) {
        this.f3082b = str;
    }

    public void setSn(String str) {
        this.f3081a = str;
    }
}
