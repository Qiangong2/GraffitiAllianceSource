package com.umeng.analytics.p092c;

import android.content.Context;
import com.umeng.p085a.C1343e;

/* renamed from: com.umeng.analytics.c.i */
/* compiled from: MacTracker */
public class C1459i extends AbstractC1449a {

    /* renamed from: a */
    private static final String f3592a = "mac";

    /* renamed from: b */
    private Context f3593b;

    public C1459i(Context context) {
        super(f3592a);
        this.f3593b = context;
    }

    @Override // com.umeng.analytics.p092c.AbstractC1449a
    /* renamed from: f */
    public String mo8554f() {
        try {
            return C1343e.m4961q(this.f3593b);
        } catch (Exception e) {
            return null;
        }
    }
}
