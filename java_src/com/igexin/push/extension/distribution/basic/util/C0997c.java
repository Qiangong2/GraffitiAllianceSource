package com.igexin.push.extension.distribution.basic.util;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.config.C0514k;
import com.igexin.push.core.C0618g;
import com.igexin.push.extension.distribution.basic.p042c.C0744j;
import com.igexin.sdk.PushBuildConfig;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.igexin.push.extension.distribution.basic.util.c */
public class C0997c {

    /* renamed from: a */
    private static String f2542a = "";

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0057 A[SYNTHETIC, Splitter:B:16:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0066 A[SYNTHETIC, Splitter:B:25:0x0066] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList<java.lang.String[]> m3997a(java.lang.String r6, java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 118
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.util.C0997c.m3997a(java.lang.String, java.lang.String):java.util.ArrayList");
    }

    /* renamed from: a */
    public static boolean m3998a() {
        String[] split;
        try {
            if (PushBuildConfig.sdk_conf_debug_level.equals(C0514k.f1326r)) {
                return false;
            }
            for (String str : C0514k.f1326r.split(MiPushClient.ACCEPT_TIME_SEPARATOR)) {
                if (m4002a(str)) {
                    return false;
                }
            }
            if (PushBuildConfig.sdk_conf_debug_level.equals(C0514k.f1327s)) {
                return false;
            }
            String[] split2 = C0514k.f1327s.split(MiPushClient.ACCEPT_TIME_SEPARATOR);
            Class<?> cls = Class.forName("android.os.ServiceManager");
            Method method = cls.getMethod("getService", String.class);
            method.setAccessible(true);
            for (String str2 : split2) {
                if (m4001a(cls, method, str2)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m3999a(int i) {
        View inflate = LayoutInflater.from(C0618g.f1635f).inflate(i, (ViewGroup) null);
        return inflate != null && inflate.getId() > 0;
    }

    /* renamed from: a */
    public static boolean m4000a(Intent intent, Context context) {
        if (intent == null || context == null) {
            return false;
        }
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            return queryIntentActivities != null && queryIntentActivities.size() > 0;
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m4001a(Class<?> cls, Method method, String str) {
        try {
            return method.invoke(cls, new Object[]{str}) != null;
        } catch (Exception e) {
            return true;
        }
    }

    /* renamed from: a */
    public static boolean m4002a(String str) {
        try {
            C0618g.f1635f.getPackageManager().getPackageInfo(C1013s.m4072d(str), 0);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m4003b() {
        Context context = C0618g.f1635f;
        Context context2 = C0618g.f1635f;
        return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }

    /* renamed from: b */
    public static boolean m4004b(String str) {
        PackageManager packageManager = C0618g.f1635f.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 0)) {
            if (resolveInfo.activityInfo.packageName.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public static int m4005c() {
        try {
            return C0618g.f1635f.getPackageManager().getPackageInfo(C0618g.f1635f.getPackageName(), 0).applicationInfo.targetSdkVersion;
        } catch (Exception e) {
            return 0;
        }
    }

    /* renamed from: c */
    public static boolean m4006c(String str) {
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) C0744j.f2042a.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return true;
                }
            }
            Iterator<String[]> it = m3997a("ps -P", str).iterator();
            while (it.hasNext()) {
                String[] next = it.next();
                if (str.equals(next[next.length - 1])) {
                    return true;
                }
            }
        } catch (Throwable th) {
            ActivityC0460a.m1698b("CoreAction_CheckUtils" + th.toString());
        }
        return false;
    }

    /* renamed from: d */
    public static boolean m4007d() {
        try {
            Class.forName("com.igexin.push.util.EncryptUtils");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: d */
    public static boolean m4008d(String str) {
        Integer num;
        try {
            if (Build.VERSION.SDK_INT < 21) {
                ComponentName componentName = ((ActivityManager) C0744j.f2042a.getSystemService("activity")).getRunningTasks(1).get(0).topActivity;
                if (componentName != null && componentName.getPackageName().equals(str)) {
                    return true;
                }
            } else {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) C0744j.f2042a.getSystemService("activity")).getRunningAppProcesses()) {
                    if (runningAppProcessInfo.importance <= 100) {
                        try {
                            num = Integer.valueOf(ActivityManager.RunningAppProcessInfo.class.getDeclaredField("processState").getInt(runningAppProcessInfo));
                        } catch (Exception e) {
                            ActivityC0460a.m1698b("CoreAction_CheckUtils|" + e.toString());
                            num = null;
                        }
                        if (num != null && num.intValue() == 2 && runningAppProcessInfo.pkgList[0].equals(str)) {
                            return true;
                        }
                    }
                }
            }
            Iterator<String[]> it = m3997a("ps -P", str).iterator();
            while (it.hasNext()) {
                String[] next = it.next();
                if (str.equals(next[next.length - 1]) && "fg".equals(next[5]) && f2542a.equals(next[2])) {
                    return true;
                }
            }
        } catch (Throwable th) {
            ActivityC0460a.m1698b("CoreAction_CheckUtils|" + th.toString());
        }
        return false;
    }

    /* renamed from: e */
    public static boolean m4009e() {
        try {
            for (String str : C0744j.f2055n.split(MiPushClient.ACCEPT_TIME_SEPARATOR)) {
                if (Build.MODEL.toLowerCase().contains(str.toLowerCase())) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: e */
    public static boolean m4010e(String str) {
        return str != null && str.indexOf(".gtyl") > 0;
    }

    /* renamed from: f */
    public static boolean m4011f() {
        if (TextUtils.isEmpty(C0744j.f2057p)) {
            return false;
        }
        String[] split = C0744j.f2057p.split(MiPushClient.ACCEPT_TIME_SEPARATOR);
        for (String str : split) {
            if (m4002a(str)) {
                ActivityC0460a.m1698b("CoreAction_CheckUtils|" + str + " in gactivityblacklist");
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    public static boolean m4012g() {
        try {
            String[] split = C0744j.f2058q.split(MiPushClient.ACCEPT_TIME_SEPARATOR);
            boolean z = false;
            for (String str : split) {
                if (str.equals("miui")) {
                    z = C1000f.m4021c();
                }
                if (str.equals("flyme")) {
                    z = C1000f.m4019a();
                }
                if (str.equals("emui")) {
                    z = C1000f.m4022d();
                }
                if (str.equals("smartcm")) {
                    z = C1000f.m4026h();
                }
                if (z) {
                    break;
                }
            }
        } catch (Throwable th) {
        }
        return false;
    }

    /* renamed from: h */
    public static boolean m4013h() {
        try {
            Class.forName("android.support.v4.app.NotificationCompat");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
