package com.umeng.analytics.p092c;

import android.content.Context;
import com.umeng.p085a.C1335a;

/* renamed from: com.umeng.analytics.c.d */
/* compiled from: IDFATracker */
public class C1452d extends AbstractC1449a {

    /* renamed from: a */
    private static final String f3554a = "idfa";

    /* renamed from: b */
    private Context f3555b;

    public C1452d(Context context) {
        super(f3554a);
        this.f3555b = context;
    }

    @Override // com.umeng.analytics.p092c.AbstractC1449a
    /* renamed from: f */
    public String mo8554f() {
        String a = C1335a.m4903a(this.f3555b);
        return a == null ? "" : a;
    }
}
