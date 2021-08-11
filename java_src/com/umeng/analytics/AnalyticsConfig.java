package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.p085a.C1340b;
import com.umeng.p085a.C1343e;
import com.umeng.p085a.C1346h;
import com.umeng.p085a.C1360l;

public class AnalyticsConfig {
    public static boolean ACTIVITY_DURATION_OPEN = true;
    public static boolean CATCH_EXCEPTION = true;
    public static String GPU_RENDERER = "";
    public static String GPU_VENDER = "";

    /* renamed from: a */
    static double[] f3194a = null;

    /* renamed from: b */
    private static String f3195b = null;

    /* renamed from: c */
    private static String f3196c = null;

    /* renamed from: d */
    private static String f3197d = null;

    /* renamed from: e */
    private static int f3198e = 0;
    public static long kContinueSessionMillis = 30000;
    public static String mWrapperType = null;
    public static String mWrapperVersion = null;
    public static boolean sEncrypt = false;
    public static int sLatentWindow;

    /* renamed from: a */
    static void m5070a(boolean z) {
        sEncrypt = z;
    }

    /* renamed from: a */
    static void m5068a(Context context, String str) {
        if (context == null) {
            f3195b = str;
            return;
        }
        String p = C1343e.m4960p(context);
        if (!TextUtils.isEmpty(p)) {
            f3195b = p;
            if (!p.equals(str)) {
                C1346h.m5003d("Appkey和AndroidManifest.xml中配置的不一致 ");
                return;
            }
            return;
        }
        String c = C1360l.m5038a(context).mo8383c();
        if (TextUtils.isEmpty(c)) {
            C1360l.m5038a(context).mo8377a(str);
        } else if (!c.equals(str)) {
            C1346h.m5003d("Appkey和上次配置的不一致 ");
            C1360l.m5038a(context).mo8377a(str);
        }
        f3195b = str;
    }

    /* renamed from: a */
    static void m5069a(String str) {
        f3196c = str;
    }

    public static String getAppkey(Context context) {
        if (TextUtils.isEmpty(f3195b)) {
            f3195b = C1343e.m4960p(context);
            if (TextUtils.isEmpty(f3195b)) {
                f3195b = C1360l.m5038a(context).mo8383c();
            }
        }
        return f3195b;
    }

    public static String getChannel(Context context) {
        if (TextUtils.isEmpty(f3196c)) {
            f3196c = C1343e.m4963s(context);
        }
        return f3196c;
    }

    public static double[] getLocation() {
        return f3194a;
    }

    /* renamed from: b */
    static void m5071b(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            f3197d = str;
            C1360l.m5038a(context).mo8384c(f3197d);
        }
    }

    public static String getSecretKey(Context context) {
        if (TextUtils.isEmpty(f3197d)) {
            f3197d = C1360l.m5038a(context).mo8386e();
        }
        return f3197d;
    }

    /* renamed from: a */
    static void m5067a(Context context, int i) {
        f3198e = i;
        C1360l.m5038a(context).mo8376a(f3198e);
    }

    public static int getVerticalType(Context context) {
        if (f3198e == 0) {
            f3198e = C1360l.m5038a(context).mo8387f();
        }
        return f3198e;
    }

    public static String getSDKVersion(Context context) {
        return C1340b.f3133a;
    }
}
