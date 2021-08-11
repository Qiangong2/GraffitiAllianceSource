package com.umeng.analytics.p092c;

import android.content.Context;
import com.umeng.p085a.C1343e;

/* renamed from: com.umeng.analytics.c.m */
/* compiled from: UMIdTracker */
public class C1463m extends AbstractC1449a {

    /* renamed from: a */
    private static final String f3601a = "idmd5";

    /* renamed from: b */
    private Context f3602b;

    public C1463m(Context context) {
        super("idmd5");
        this.f3602b = context;
    }

    @Override // com.umeng.analytics.p092c.AbstractC1449a
    /* renamed from: f */
    public String mo8554f() {
        return C1343e.m4946d(this.f3602b);
    }
}
