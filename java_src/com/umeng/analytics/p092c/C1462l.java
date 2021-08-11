package com.umeng.analytics.p092c;

import android.os.Build;

/* renamed from: com.umeng.analytics.c.l */
/* compiled from: SerialTracker */
public class C1462l extends AbstractC1449a {

    /* renamed from: a */
    private static final String f3600a = "serial";

    public C1462l() {
        super(f3600a);
    }

    @Override // com.umeng.analytics.p092c.AbstractC1449a
    /* renamed from: f */
    public String mo8554f() {
        if (Build.VERSION.SDK_INT >= 9) {
            return Build.SERIAL;
        }
        return null;
    }
}
