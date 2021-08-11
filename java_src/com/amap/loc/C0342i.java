package com.amap.loc;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import java.security.MessageDigest;
import java.util.Locale;

/* renamed from: com.amap.loc.i */
/* compiled from: AppInfo */
public class C0342i {

    /* renamed from: a */
    private static String f820a = "";

    /* renamed from: b */
    private static String f821b = "";

    /* renamed from: c */
    private static String f822c = "";

    /* renamed from: d */
    private static String f823d = "";

    /* renamed from: e */
    private static String f824e = null;

    /* renamed from: a */
    public static String m1228a(Context context) {
        try {
            return m1236g(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return f823d;
        }
    }

    /* renamed from: a */
    public static void m1229a(String str) {
        f821b = str;
    }

    /* renamed from: b */
    public static String m1230b(Context context) {
        try {
            if (!"".equals(f820a)) {
                return f820a;
            }
            PackageManager packageManager = context.getPackageManager();
            f820a = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
            return f820a;
        } catch (Throwable th) {
            C0365t.m1372a(th, "AppInfo", "getApplicationName");
        }
    }

    /* renamed from: b */
    static void m1231b(String str) {
        f823d = str;
    }

    /* renamed from: c */
    public static String m1232c(Context context) {
        try {
            if (f821b != null && !"".equals(f821b)) {
                return f821b;
            }
            f821b = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            return f821b;
        } catch (Throwable th) {
            C0365t.m1372a(th, "AppInfo", "getpckn");
        }
    }

    /* renamed from: d */
    public static String m1233d(Context context) {
        try {
            if (!"".equals(f822c)) {
                return f822c;
            }
            f822c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            return f822c == null ? "" : f822c;
        } catch (Throwable th) {
            C0365t.m1372a(th, "AppInfo", "getApplicationVersion");
        }
    }

    /* renamed from: e */
    public static String m1234e(Context context) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String upperCase = Integer.toHexString(b & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(":");
            }
            stringBuffer.append(m1232c(context));
            f824e = stringBuffer.toString();
            return f824e;
        } catch (Throwable th) {
            C0365t.m1372a(th, "AppInfo", "getpck");
            return f824e;
        }
    }

    /* renamed from: f */
    public static String m1235f(Context context) {
        try {
            return m1236g(context);
        } catch (Throwable th) {
            C0365t.m1372a(th, "AppInfo", "getKey");
            return f823d;
        }
    }

    /* renamed from: g */
    private static String m1236g(Context context) throws PackageManager.NameNotFoundException {
        if (f823d == null || f823d.equals("")) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return f823d;
            }
            f823d = applicationInfo.metaData.getString("com.amap.api.v2.apikey");
            if (f823d == null) {
                f823d = "";
            }
        }
        return f823d;
    }
}
