package com.igexin.push.extension.distribution.gbd.p076i;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.lang.reflect.Method;

/* renamed from: com.igexin.push.extension.distribution.gbd.i.r */
public class C1129r {
    /* renamed from: a */
    private static Object m4635a(int i, String str, Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (Build.VERSION.SDK_INT >= 21) {
                Method method = telephonyManager.getClass().getMethod(str, m4638a(str));
                if (i >= 0) {
                    return method.invoke(telephonyManager, Integer.valueOf(i));
                }
            }
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
        return null;
    }

    /* renamed from: a */
    public static String m4636a(int i, Context context) {
        try {
            Object a = m4635a(i, "getDeviceId", context);
            if (a != null) {
                return (String) a;
            }
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
        return "";
    }

    /* renamed from: a */
    public static String m4637a(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (!TextUtils.isEmpty(telephonyManager.getDeviceId())) {
                return telephonyManager.getDeviceId();
            }
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
        return "";
    }

    /* renamed from: a */
    private static Class[] m4638a(String str) {
        Throwable th;
        Class<?>[] clsArr;
        try {
            Method[] declaredMethods = TelephonyManager.class.getDeclaredMethods();
            clsArr = null;
            for (int i = 0; i < declaredMethods.length; i++) {
                try {
                    if (str.equals(declaredMethods[i].getName())) {
                        clsArr = declaredMethods[i].getParameterTypes();
                        if (clsArr.length >= 1) {
                            break;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    C1115d.m4558a(th);
                    return clsArr;
                }
            }
        } catch (Throwable th3) {
            clsArr = null;
            th = th3;
            C1115d.m4558a(th);
            return clsArr;
        }
        return clsArr;
    }

    /* renamed from: b */
    public static String m4639b(int i, Context context) {
        try {
            Object a = m4635a(i, "getSubscriberId", context);
            if (a != null) {
                return (String) a;
            }
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
        return "";
    }

    /* renamed from: b */
    public static String m4640b(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (!TextUtils.isEmpty(telephonyManager.getSubscriberId())) {
                return telephonyManager.getSubscriberId();
            }
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
        return "";
    }

    /* renamed from: c */
    public static String m4641c(int i, Context context) {
        Throwable th;
        String str;
        try {
            Object a = m4635a(i, "getSimSerialNumber", context);
            str = a != null ? (String) a : "";
            try {
                return (TextUtils.isEmpty(str) || str.length() >= 20) ? str : "";
            } catch (Throwable th2) {
                th = th2;
                C1115d.m4558a(th);
                return str;
            }
        } catch (Throwable th3) {
            str = "";
            th = th3;
            C1115d.m4558a(th);
            return str;
        }
    }

    /* renamed from: c */
    public static String m4642c(Context context) {
        Throwable th;
        String str;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            str = !TextUtils.isEmpty(telephonyManager.getSimSerialNumber()) ? telephonyManager.getSimSerialNumber() : "";
            try {
                return (TextUtils.isEmpty(str) || str.length() >= 20) ? str : "";
            } catch (Throwable th2) {
                th = th2;
                C1115d.m4558a(th);
                return str;
            }
        } catch (Throwable th3) {
            str = "";
            th = th3;
            C1115d.m4558a(th);
            return str;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0056  */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m4643d(int r8, android.content.Context r9) {
        /*
            r6 = 0
            java.lang.String r0 = "content://telephony/siminfo"
            android.net.Uri r1 = android.net.Uri.parse(r0)
            android.content.ContentResolver r0 = r9.getContentResolver()
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ Throwable -> 0x0048, all -> 0x0053 }
            r3 = 0
            java.lang.String r4 = "_id"
            r2[r3] = r4     // Catch:{ Throwable -> 0x0048, all -> 0x0053 }
            r3 = 1
            java.lang.String r4 = "sim_id"
            r2[r3] = r4     // Catch:{ Throwable -> 0x0048, all -> 0x0053 }
            java.lang.String r3 = "sim_id = ?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ Throwable -> 0x0048, all -> 0x0053 }
            r5 = 0
            java.lang.String r7 = java.lang.String.valueOf(r8)     // Catch:{ Throwable -> 0x0048, all -> 0x0053 }
            r4[r5] = r7     // Catch:{ Throwable -> 0x0048, all -> 0x0053 }
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch:{ Throwable -> 0x0048, all -> 0x0053 }
            if (r1 == 0) goto L_0x0041
            boolean r0 = r1.moveToFirst()     // Catch:{ Throwable -> 0x005d }
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = "_id"
            int r0 = r1.getColumnIndex(r0)     // Catch:{ Throwable -> 0x005d }
            int r0 = r1.getInt(r0)     // Catch:{ Throwable -> 0x005d }
            if (r1 == 0) goto L_0x0040
            r1.close()
        L_0x0040:
            return r0
        L_0x0041:
            if (r1 == 0) goto L_0x0046
            r1.close()
        L_0x0046:
            r0 = -1
            goto L_0x0040
        L_0x0048:
            r0 = move-exception
            r1 = r6
        L_0x004a:
            com.igexin.push.extension.distribution.gbd.p076i.C1115d.m4558a(r0)     // Catch:{ all -> 0x005a }
            if (r1 == 0) goto L_0x0046
            r1.close()
            goto L_0x0046
        L_0x0053:
            r0 = move-exception
        L_0x0054:
            if (r6 == 0) goto L_0x0059
            r6.close()
        L_0x0059:
            throw r0
        L_0x005a:
            r0 = move-exception
            r6 = r1
            goto L_0x0054
        L_0x005d:
            r0 = move-exception
            goto L_0x004a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.gbd.p076i.C1129r.m4643d(int, android.content.Context):int");
    }
}
