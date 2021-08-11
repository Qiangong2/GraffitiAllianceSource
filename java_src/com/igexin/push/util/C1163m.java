package com.igexin.push.util;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.igexin.push.core.C0618g;

/* renamed from: com.igexin.push.util.m */
public class C1163m {
    /* renamed from: a */
    public static String m4785a() {
        try {
            return Build.VERSION.SDK_INT < 21 ? Build.CPU_ABI : Build.SUPPORTED_ABIS[0];
        } catch (Throwable th) {
            return "";
        }
    }

    /* renamed from: a */
    public static String m4786a(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            return "";
        }
    }

    /* renamed from: b */
    public static int m4787b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
        } catch (Exception e) {
            return 0;
        }
    }

    /* renamed from: b */
    public static String m4788b() {
        try {
            return Settings.Secure.getString(C0618g.f1635f.getContentResolver(), "android_id");
        } catch (Throwable th) {
            return "";
        }
    }

    /* renamed from: c */
    public static String m4789c() {
        String str = "";
        try {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                try {
                    C0618g.f1635f.getPackageManager().getPackageInfo("com.android.vending", 0);
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    ServiceConnectionC1165o oVar = new ServiceConnectionC1165o();
                    if (C0618g.f1635f.bindService(intent, oVar, 1)) {
                        try {
                            str = new C1166p(oVar.mo5909a()).mo5912a();
                        } catch (Exception e) {
                        } finally {
                            C0618g.f1635f.unbindService(oVar);
                        }
                    }
                } catch (Exception e2) {
                }
            }
        } catch (Throwable th) {
        }
        return str;
    }
}
