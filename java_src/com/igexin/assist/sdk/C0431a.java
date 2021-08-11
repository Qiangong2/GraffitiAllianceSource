package com.igexin.assist.sdk;

import android.content.Context;
import com.igexin.assist.control.AbstractPushManager;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.config.C0514k;
import com.igexin.push.core.p029b.C0568g;
import java.lang.reflect.Constructor;

/* renamed from: com.igexin.assist.sdk.a */
public class C0431a {
    /* renamed from: a */
    static AbstractPushManager m1564a(Context context) {
        try {
            if (m1565b(context) && C0514k.f1305K) {
                ActivityC0460a.m1698b("Assist_PushMangerFactory|MiuiPushManager checkDevice flag = true");
                try {
                    Constructor<?> constructor = Class.forName("com.igexin.assist.control.xiaomi.MiuiPushManager").getConstructor(Context.class);
                    if (constructor != null) {
                        return (AbstractPushManager) constructor.newInstance(context);
                    }
                } catch (Exception e) {
                }
                ActivityC0460a.m1698b("Assist_PushMangerFactory|OtherPushManager = null");
                return null;
            } else if (m1566c(context) && C0514k.f1306L) {
                ActivityC0460a.m1698b("Assist_PushMangerFactory|FlymePushManager checkDevice flag = true");
                try {
                    Constructor<?> constructor2 = Class.forName("com.igexin.assist.control.meizu.FlymePushManager").getConstructor(Context.class);
                    if (constructor2 != null) {
                        return (AbstractPushManager) constructor2.newInstance(context);
                    }
                } catch (Exception e2) {
                }
                ActivityC0460a.m1698b("Assist_PushMangerFactory|OtherPushManager = null");
                return null;
            } else if (!m1567d(context) || !C0514k.f1307M) {
                ActivityC0460a.m1698b("Assist_PushMangerFactory|getPushManager = null, setToken = false");
                C0568g.m2192a().mo4453c("false");
                ActivityC0460a.m1698b("Assist_PushMangerFactory|OtherPushManager = null");
                return null;
            } else {
                ActivityC0460a.m1698b("Assist_PushMangerFactory|HmsPushManager checkDevice flag = true");
                try {
                    Constructor<?> constructor3 = Class.forName("com.igexin.assist.control.huawei.HmsPushManager").getConstructor(Context.class);
                    if (constructor3 != null) {
                        return (AbstractPushManager) constructor3.newInstance(context);
                    }
                } catch (Exception e3) {
                }
                ActivityC0460a.m1698b("Assist_PushMangerFactory|OtherPushManager = null");
                return null;
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: b */
    public static boolean m1565b(Context context) {
        try {
            return ((Boolean) Class.forName("com.igexin.assist.control.xiaomi.MiuiPushManager").getMethod("checkXMDevice", Context.class).invoke(null, context)).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: c */
    public static boolean m1566c(Context context) {
        try {
            return ((Boolean) Class.forName("com.igexin.assist.control.meizu.FlymePushManager").getMethod("checkMZDevice", Context.class).invoke(null, context)).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: d */
    public static boolean m1567d(Context context) {
        try {
            return ((Boolean) Class.forName("com.igexin.assist.control.huawei.HmsPushManager").getMethod("checkHWDevice", Context.class).invoke(null, context)).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: e */
    public static boolean m1568e(Context context) {
        return m1566c(context) || m1565b(context) || m1567d(context);
    }
}
