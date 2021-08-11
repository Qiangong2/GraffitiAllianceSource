package com.umeng.analytics.p092c;

import android.content.Context;
import android.provider.Settings;

/* renamed from: com.umeng.analytics.c.b */
/* compiled from: AndroidIdTracker */
public class C1450b extends AbstractC1449a {

    /* renamed from: a */
    private static final String f3538a = "android_id";

    /* renamed from: b */
    private Context f3539b;

    public C1450b(Context context) {
        super(f3538a);
        this.f3539b = context;
    }

    @Override // com.umeng.analytics.p092c.AbstractC1449a
    /* renamed from: f */
    public String mo8554f() {
        try {
            return Settings.Secure.getString(this.f3539b.getContentResolver(), f3538a);
        } catch (Exception e) {
            return null;
        }
    }
}
