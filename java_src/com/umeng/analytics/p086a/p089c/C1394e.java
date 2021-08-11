package com.umeng.analytics.p086a.p089c;

import com.umeng.analytics.p086a.p090d.C1419e;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.umeng.analytics.a.c.e */
/* compiled from: UMCCVerbatimObject */
public class C1394e implements Serializable {

    /* renamed from: a */
    private static final long f3303a = 1;

    /* renamed from: b */
    private List<String> f3304b = new ArrayList();

    /* renamed from: c */
    private String f3305c;

    /* renamed from: d */
    private long f3306d;

    /* renamed from: e */
    private long f3307e;

    /* renamed from: f */
    private String f3308f;

    public C1394e(List<String> list, long j, String str, long j2) {
        this.f3304b = list;
        this.f3306d = j;
        this.f3305c = str;
        this.f3307e = j2;
        m5153f();
    }

    /* renamed from: f */
    private void m5153f() {
        this.f3308f = C1419e.m5243a(this.f3307e);
    }

    /* renamed from: a */
    public List<String> mo8455a() {
        return this.f3304b;
    }

    /* renamed from: b */
    public String mo8456b() {
        return this.f3305c;
    }

    /* renamed from: c */
    public long mo8457c() {
        return this.f3306d;
    }

    /* renamed from: d */
    public long mo8458d() {
        return this.f3307e;
    }

    /* renamed from: e */
    public String mo8459e() {
        return this.f3308f;
    }
}
