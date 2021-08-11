package com.umeng.analytics.game;

import android.content.Context;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.social.AbstractC1571d;
import com.umeng.analytics.social.UMPlatformData;
import com.umeng.analytics.social.UMSocialService;
import com.umeng.p085a.C1346h;

public class UMGameAgent extends MobclickAgent {

    /* renamed from: a */
    private static final String f3915a = "Input string is null or empty";

    /* renamed from: b */
    private static final String f3916b = "Input string must be less than 64 chars";

    /* renamed from: c */
    private static final String f3917c = "Input value type is negative";

    /* renamed from: d */
    private static final String f3918d = "The int value for 'Pay Channels' ranges between 1 ~ 99 ";

    /* renamed from: e */
    private static final C1552c f3919e = new C1552c();

    /* renamed from: f */
    private static Context f3920f;

    public static void init(Context context) {
        f3919e.mo8926a(context);
        f3920f = context.getApplicationContext();
    }

    public static void setTraceSleepTime(boolean z) {
        f3919e.mo8930a(z);
    }

    public static void setPlayerLevel(int i) {
        f3919e.mo8927a(String.valueOf(i));
    }

    public static void startLevel(String str) {
        if (m5975a(str)) {
            C1346h.m5009e(f3915a);
        } else if (str.length() > 64) {
            C1346h.m5009e(f3916b);
        } else {
            f3919e.mo8931b(str);
        }
    }

    public static void finishLevel(String str) {
        if (m5975a(str)) {
            C1346h.m5009e(f3915a);
        } else if (str.length() > 64) {
            C1346h.m5009e(f3916b);
        } else {
            f3919e.mo8933c(str);
        }
    }

    public static void failLevel(String str) {
        if (m5975a(str)) {
            C1346h.m5009e(f3915a);
        } else if (str.length() > 64) {
            C1346h.m5009e(f3916b);
        } else {
            f3919e.mo8934d(str);
        }
    }

    public static void pay(double d, double d2, int i) {
        if (i <= 0 || i >= 100) {
            C1346h.m5009e(f3918d);
        } else if (d < 0.0d || d2 < 0.0d) {
            C1346h.m5009e(f3917c);
        } else {
            f3919e.mo8922a(d, d2, i);
        }
    }

    public static void pay(double d, String str, int i, double d2, int i2) {
        if (i2 <= 0 || i2 >= 100) {
            C1346h.m5009e(f3918d);
        } else if (d < 0.0d || i < 0 || d2 < 0.0d) {
            C1346h.m5009e(f3917c);
        } else if (m5975a(str)) {
            C1346h.m5009e(f3915a);
        } else {
            f3919e.mo8925a(d, str, i, d2, i2);
        }
    }

    public static void exchange(double d, String str, double d2, int i, String str2) {
        if (d < 0.0d || d2 < 0.0d) {
            C1346h.m5009e(f3917c);
        } else if (i <= 0 || i >= 100) {
            C1346h.m5009e(f3918d);
        } else {
            f3919e.mo8924a(d, str, d2, i, str2);
        }
    }

    public static void buy(String str, int i, double d) {
        if (m5975a(str)) {
            C1346h.m5009e(f3915a);
        } else if (i < 0 || d < 0.0d) {
            C1346h.m5009e(f3917c);
        } else {
            f3919e.mo8928a(str, i, d);
        }
    }

    public static void use(String str, int i, double d) {
        if (m5975a(str)) {
            C1346h.m5009e(f3915a);
        } else if (i < 0 || d < 0.0d) {
            C1346h.m5009e(f3917c);
        } else {
            f3919e.mo8932b(str, i, d);
        }
    }

    public static void bonus(double d, int i) {
        if (d < 0.0d) {
            C1346h.m5009e(f3917c);
        } else if (i <= 0 || i >= 100) {
            C1346h.m5009e(f3918d);
        } else {
            f3919e.mo8923a(d, i);
        }
    }

    public static void bonus(String str, int i, double d, int i2) {
        if (m5975a(str)) {
            C1346h.m5009e(f3915a);
        } else if (i < 0 || d < 0.0d) {
            C1346h.m5009e(f3917c);
        } else if (i2 <= 0 || i2 >= 100) {
            C1346h.m5009e(f3918d);
        } else {
            f3919e.mo8929a(str, i, d, i2);
        }
    }

    /* renamed from: a */
    private static boolean m5975a(String str) {
        if (str != null && str.trim().length() > 0) {
            return false;
        }
        return true;
    }

    public static void onEvent(String str, String str2) {
        onEvent(f3920f, str, str2);
    }

    public static void onSocialEvent(Context context, String str, UMPlatformData... uMPlatformDataArr) {
        if (context == null) {
            C1346h.m5009e("context is null in onShareEvent");
            return;
        }
        AbstractC1571d.f3986d = "4";
        UMSocialService.share(context, str, uMPlatformDataArr);
    }

    public static void onSocialEvent(Context context, UMPlatformData... uMPlatformDataArr) {
        if (context == null) {
            C1346h.m5009e("context is null in onShareEvent");
            return;
        }
        AbstractC1571d.f3986d = "4";
        UMSocialService.share(context, uMPlatformDataArr);
    }
}
