package com.igexin.push.extension.distribution.basic.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.List;

/* renamed from: com.igexin.push.extension.distribution.basic.util.a */
public class C0995a {

    /* renamed from: a */
    private static final int f2541a = Color.parseColor("#CCFF0000");

    /* renamed from: a */
    public static String m3991a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        try {
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 0)) {
                if (resolveInfo.activityInfo.applicationInfo.packageName.equalsIgnoreCase(context.getPackageName())) {
                    return resolveInfo.activityInfo.name;
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    public static void m3992a(Context context, Class<?> cls, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        } else {
            int intValue = Integer.valueOf(str).intValue();
            if (intValue <= 0) {
                str = "0";
            } else if (intValue > 99) {
                str = "99";
            }
        }
        try {
            Object newInstance = Class.forName("android.app.MiuiNotification").newInstance();
            Field declaredField = newInstance.getClass().getDeclaredField("messageCount");
            declaredField.setAccessible(true);
            declaredField.set(newInstance, str);
        } catch (Exception e) {
            Intent intent = new Intent("android.intent.action.APPLICATION_MESSAGE_UPDATE");
            intent.putExtra("android.intent.extra.update_application_component_name", context.getPackageName() + "/." + cls.getSimpleName());
            intent.putExtra("android.intent.extra.update_application_message_text", str);
            context.sendBroadcast(intent);
        }
    }

    /* renamed from: a */
    public static void m3993a(Context context, boolean z, String str, boolean z2) {
        if (m3994a(context, "com.miui.gallery")) {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                for (int i = 0; i < queryIntentActivities.size(); i++) {
                    try {
                        if (queryIntentActivities.get(i).activityInfo.packageName.equals(context.getPackageName())) {
                            m3992a(context, Class.forName(queryIntentActivities.get(i).activityInfo.name), str);
                        }
                    } catch (ClassNotFoundException e) {
                    }
                }
            }
        } else if (Build.MANUFACTURER.equalsIgnoreCase("Samsung")) {
            m3995b(context, str);
        }
    }

    /* renamed from: a */
    public static boolean m3994a(Context context, String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: b */
    public static void m3995b(Context context, String str) {
        int intValue = Integer.valueOf(str).intValue();
        if (intValue < 1) {
            str = "0";
        } else if (intValue > 99) {
            str = "99";
        }
        String a = m3991a(context);
        Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        intent.putExtra("badge_count", Integer.parseInt(str));
        intent.putExtra("badge_count_package_name", context.getPackageName());
        intent.putExtra("badge_count_class_name", a);
        context.sendBroadcast(intent);
    }
}
