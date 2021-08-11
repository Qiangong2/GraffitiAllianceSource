package com.umeng.analytics.p092c;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.umeng.p085a.C1343e;

/* renamed from: com.umeng.analytics.c.g */
/* compiled from: ImeiTracker */
public class C1456g extends AbstractC1449a {

    /* renamed from: a */
    private static final String f3568a = "imei";

    /* renamed from: b */
    private Context f3569b;

    public C1456g(Context context) {
        super(f3568a);
        this.f3569b = context;
    }

    @Override // com.umeng.analytics.p092c.AbstractC1449a
    /* renamed from: f */
    public String mo8554f() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f3569b.getSystemService("phone");
        if (telephonyManager == null) {
        }
        try {
            if (C1343e.m4938a(this.f3569b, "android.permission.READ_PHONE_STATE")) {
                return telephonyManager.getDeviceId();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
