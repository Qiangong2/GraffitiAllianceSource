package com.xiaomi.push.service;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.channel.commonutils.string.C1873d;

/* renamed from: com.xiaomi.push.service.f */
public class C1968f {

    /* renamed from: a */
    private static String f5069a = null;

    /* renamed from: b */
    private static String f5070b = null;

    /* renamed from: c */
    private static String f5071c = null;

    /* renamed from: a */
    public static String m7322a(Context context) {
        String str;
        String str2 = null;
        if (f5070b == null) {
            String b = m7323b(context);
            try {
                str = Settings.Secure.getString(context.getContentResolver(), "android_id");
            } catch (Throwable th) {
                AbstractC1855b.m6720a(th);
                str = null;
            }
            if (Build.VERSION.SDK_INT > 8) {
                str2 = Build.SERIAL;
            }
            f5070b = "a-" + C1873d.m6785b(b + str + str2);
        }
        return f5070b;
    }

    /* renamed from: b */
    public static String m7323b(Context context) {
        if (f5069a != null) {
            return f5069a;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            String deviceId = telephonyManager.getDeviceId();
            int i = 10;
            while (deviceId == null) {
                int i2 = i - 1;
                if (i <= 0) {
                    break;
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
                deviceId = telephonyManager.getDeviceId();
                i = i2;
            }
            if (deviceId != null) {
                f5069a = deviceId;
            }
            return deviceId;
        } catch (Throwable th) {
            AbstractC1855b.m6720a(th);
            return null;
        }
    }

    /* renamed from: c */
    public static synchronized String m7324c(Context context) {
        String str;
        String str2;
        synchronized (C1968f.class) {
            if (f5071c != null) {
                str2 = f5071c;
            } else {
                try {
                    str = Settings.Secure.getString(context.getContentResolver(), "android_id");
                } catch (Throwable th) {
                    AbstractC1855b.m6720a(th);
                    str = null;
                }
                f5071c = C1873d.m6785b(str + (Build.VERSION.SDK_INT > 8 ? Build.SERIAL : null));
                str2 = f5071c;
            }
        }
        return str2;
    }

    /* renamed from: d */
    public static String m7325d(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
    }
}
