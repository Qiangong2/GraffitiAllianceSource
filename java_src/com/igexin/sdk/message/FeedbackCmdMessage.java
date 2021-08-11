package com.igexin.sdk.message;

public class FeedbackCmdMessage extends GTCmdMessage {

    /* renamed from: a */
    private String f3072a;

    /* renamed from: b */
    private String f3073b;

    /* renamed from: c */
    private String f3074c;

    /* renamed from: d */
    private long f3075d;

    public FeedbackCmdMessage() {
    }

    public FeedbackCmdMessage(String str, String str2, String str3, long j, int i) {
        super(i);
        this.f3072a = str;
        this.f3073b = str2;
        this.f3074c = str3;
        this.f3075d = j;
    }

    public String getActionId() {
        return this.f3073b;
    }

    public String getResult() {
        return this.f3074c;
    }

    public String getTaskId() {
        return this.f3072a;
    }

    public long getTimeStamp() {
        return this.f3075d;
    }

    public void setActionId(String str) {
        this.f3073b = str;
    }

    public void setResult(String str) {
        this.f3074c = str;
    }

    public void setTaskId(String str) {
        this.f3072a = str;
    }

    public void setTimeStamp(long j) {
        this.f3075d = j;
    }
}
