package com.umeng.analytics.social;

/* renamed from: com.umeng.analytics.social.a */
/* compiled from: UMException */
public class C1568a extends RuntimeException {

    /* renamed from: b */
    private static final long f3976b = -4656673116019167471L;

    /* renamed from: a */
    protected int f3977a = 5000;

    /* renamed from: c */
    private String f3978c = "";

    /* renamed from: a */
    public int mo8962a() {
        return this.f3977a;
    }

    public C1568a(int i, String str) {
        super(str);
        this.f3977a = i;
        this.f3978c = str;
    }

    public C1568a(String str, Throwable th) {
        super(str, th);
        this.f3978c = str;
    }

    public C1568a(String str) {
        super(str);
        this.f3978c = str;
    }

    public String getMessage() {
        return this.f3978c;
    }
}
