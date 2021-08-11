package com.igexin.sdk.message;

public class GTTransmitMessage extends GTPushMessage {

    /* renamed from: a */
    private String f3077a;

    /* renamed from: b */
    private String f3078b;

    /* renamed from: c */
    private String f3079c;

    /* renamed from: d */
    private byte[] f3080d;

    public GTTransmitMessage() {
    }

    public GTTransmitMessage(String str, String str2, String str3, byte[] bArr) {
        this.f3077a = str;
        this.f3078b = str2;
        this.f3079c = str3;
        this.f3080d = bArr;
    }

    public String getMessageId() {
        return this.f3078b;
    }

    public byte[] getPayload() {
        return this.f3080d;
    }

    public String getPayloadId() {
        return this.f3079c;
    }

    public String getTaskId() {
        return this.f3077a;
    }

    public void setMessageId(String str) {
        this.f3078b = str;
    }

    public void setPayload(byte[] bArr) {
        this.f3080d = bArr;
    }

    public void setPayloadId(String str) {
        this.f3079c = str;
    }

    public void setTaskId(String str) {
        this.f3077a = str;
    }
}
