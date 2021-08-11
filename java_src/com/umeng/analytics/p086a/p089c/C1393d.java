package com.umeng.analytics.p086a.p089c;

import java.io.Serializable;

/* renamed from: com.umeng.analytics.a.c.d */
/* compiled from: UMCCSystemBuffer */
public class C1393d implements Serializable {

    /* renamed from: a */
    private static final long f3298a = 1;

    /* renamed from: b */
    private String f3299b;

    /* renamed from: c */
    private long f3300c;

    /* renamed from: d */
    private long f3301d;

    /* renamed from: e */
    private String f3302e;

    private C1393d() {
        this.f3299b = null;
        this.f3300c = 0;
        this.f3301d = 0;
        this.f3302e = null;
    }

    public C1393d(String str, long j, long j2) {
        this(str, j, j2, null);
    }

    public C1393d(String str, long j, long j2, String str2) {
        this.f3299b = null;
        this.f3300c = 0;
        this.f3301d = 0;
        this.f3302e = null;
        this.f3299b = str;
        this.f3300c = j;
        this.f3301d = j2;
        this.f3302e = str2;
    }

    /* renamed from: a */
    public C1393d mo8447a() {
        this.f3301d++;
        return this;
    }

    /* renamed from: b */
    public String mo8450b() {
        return this.f3302e;
    }

    /* renamed from: a */
    public void mo8449a(String str) {
        this.f3302e = str;
    }

    /* renamed from: c */
    public String mo8452c() {
        return this.f3299b;
    }

    /* renamed from: b */
    public void mo8451b(String str) {
        this.f3299b = str;
    }

    /* renamed from: d */
    public long mo8453d() {
        return this.f3300c;
    }

    /* renamed from: e */
    public long mo8454e() {
        return this.f3301d;
    }

    /* renamed from: a */
    public C1393d mo8448a(C1393d dVar) {
        this.f3301d = dVar.mo8454e() + this.f3301d;
        this.f3300c = dVar.mo8453d();
        return this;
    }
}
