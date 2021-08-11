package com.umeng.analytics.social;

import com.tencent.qcloud.core.util.IOUtils;

/* renamed from: com.umeng.analytics.social.c */
/* compiled from: UMResult */
public class C1570c {

    /* renamed from: a */
    private int f3979a = -1;

    /* renamed from: b */
    private String f3980b = "";

    /* renamed from: c */
    private String f3981c = "";

    /* renamed from: d */
    private Exception f3982d = null;

    public C1570c(int i) {
        this.f3979a = i;
    }

    public C1570c(int i, Exception exc) {
        this.f3979a = i;
        this.f3982d = exc;
    }

    /* renamed from: a */
    public Exception mo8964a() {
        return this.f3982d;
    }

    /* renamed from: b */
    public int mo8967b() {
        return this.f3979a;
    }

    /* renamed from: a */
    public void mo8965a(int i) {
        this.f3979a = i;
    }

    /* renamed from: c */
    public String mo8969c() {
        return this.f3980b;
    }

    /* renamed from: a */
    public void mo8966a(String str) {
        this.f3980b = str;
    }

    /* renamed from: d */
    public String mo8970d() {
        return this.f3981c;
    }

    /* renamed from: b */
    public void mo8968b(String str) {
        this.f3981c = str;
    }

    public String toString() {
        return "status=" + this.f3979a + IOUtils.LINE_SEPARATOR_WINDOWS + "msg:  " + this.f3980b + IOUtils.LINE_SEPARATOR_WINDOWS + "data:  " + this.f3981c;
    }
}
