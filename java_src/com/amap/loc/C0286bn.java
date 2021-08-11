package com.amap.loc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.io.File;
import java.io.IOException;

/* renamed from: com.amap.loc.bn */
/* compiled from: OfflineLocManager */
public class C0286bn {
    /* renamed from: a */
    private static String m764a(String str) {
        Throwable th;
        boolean z = true;
        StringBuilder sb = new StringBuilder();
        C0264bb bbVar = null;
        try {
            C0264bb a = C0264bb.m664a(new File(str), 1, 1, 204800);
            File file = new File(str);
            if (file != null && file.exists()) {
                String[] list = file.list();
                for (String str2 : list) {
                    if (str2.contains(".0")) {
                        String a2 = C0363r.m1351a(C0291bq.m788a(a, str2.split("\\.")[0]));
                        if (z) {
                            z = false;
                        } else {
                            sb.append(MiPushClient.ACCEPT_TIME_SEPARATOR);
                        }
                        sb.append("{\"log\":\"").append(a2).append("\"}");
                    }
                }
            }
            if (a != null) {
                try {
                    a.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (IOException e) {
            C0365t.m1372a(e, "StatisticsManager", "getContent");
            if (0 != 0) {
                bbVar.close();
            }
        } catch (Throwable th3) {
            th = th3;
        }
        return sb.toString();
        th.printStackTrace();
        return sb.toString();
    }

    /* renamed from: a */
    public static void m765a(Context context) {
        try {
            if (m771e(context)) {
                m766a(context, System.currentTimeMillis());
                String b = m768b(context);
                if (!TextUtils.isEmpty(b)) {
                    C0275bf.m719a().mo3748a(new C0370v(C0363r.m1364c(C0363r.m1358a(b)), "6"));
                }
            }
        } catch (Throwable th) {
            C0365t.m1372a(th, "OfflineLocManager", "updateOfflineLocData");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003d A[SYNTHETIC, Splitter:B:16:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0049 A[SYNTHETIC, Splitter:B:22:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m766a(android.content.Context r5, long r6) {
        /*
            r1 = 0
            java.lang.String r0 = "f.log"
            java.lang.String r0 = com.amap.loc.C0366u.m1378a(r5, r0)     // Catch:{ Throwable -> 0x0033 }
            java.io.File r3 = new java.io.File     // Catch:{ Throwable -> 0x0033 }
            r3.<init>(r0)     // Catch:{ Throwable -> 0x0033 }
            java.io.File r0 = r3.getParentFile()     // Catch:{ Throwable -> 0x0033 }
            boolean r0 = r0.exists()     // Catch:{ Throwable -> 0x0033 }
            if (r0 != 0) goto L_0x001d
            java.io.File r0 = r3.getParentFile()     // Catch:{ Throwable -> 0x0033 }
            r0.mkdirs()     // Catch:{ Throwable -> 0x0033 }
        L_0x001d:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Throwable -> 0x0033 }
            r2.<init>(r3)     // Catch:{ Throwable -> 0x0033 }
            java.lang.String r0 = java.lang.String.valueOf(r6)     // Catch:{ Throwable -> 0x0057, all -> 0x0054 }
            byte[] r0 = com.amap.loc.C0363r.m1358a(r0)     // Catch:{ Throwable -> 0x0057, all -> 0x0054 }
            r2.write(r0)     // Catch:{ Throwable -> 0x0057, all -> 0x0054 }
            if (r2 == 0) goto L_0x0032
            r2.close()     // Catch:{ Throwable -> 0x0052 }
        L_0x0032:
            return
        L_0x0033:
            r0 = move-exception
        L_0x0034:
            java.lang.String r2 = "OfflineLocManager"
            java.lang.String r3 = "updateLogUpdateTime"
            com.amap.loc.C0365t.m1372a(r0, r2, r3)     // Catch:{ all -> 0x0046 }
            if (r1 == 0) goto L_0x0032
            r1.close()     // Catch:{ Throwable -> 0x0041 }
            goto L_0x0032
        L_0x0041:
            r0 = move-exception
        L_0x0042:
            r0.printStackTrace()
            goto L_0x0032
        L_0x0046:
            r0 = move-exception
        L_0x0047:
            if (r1 == 0) goto L_0x004c
            r1.close()     // Catch:{ Throwable -> 0x004d }
        L_0x004c:
            throw r0
        L_0x004d:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x004c
        L_0x0052:
            r0 = move-exception
            goto L_0x0042
        L_0x0054:
            r0 = move-exception
            r1 = r2
            goto L_0x0047
        L_0x0057:
            r0 = move-exception
            r1 = r2
            goto L_0x0034
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0286bn.m766a(android.content.Context, long):void");
    }

    /* renamed from: a */
    public static synchronized void m767a(final C0285bm bmVar, final Context context) {
        synchronized (C0286bn.class) {
            C0371w.m1393b().submit(new Runnable() {
                /* class com.amap.loc.C0286bn.RunnableC02871 */

                /* JADX WARNING: Removed duplicated region for block: B:21:0x0051 A[SYNTHETIC, Splitter:B:21:0x0051] */
                /* JADX WARNING: Removed duplicated region for block: B:24:0x0056 A[SYNTHETIC, Splitter:B:24:0x0056] */
                /* JADX WARNING: Removed duplicated region for block: B:34:0x0066 A[SYNTHETIC, Splitter:B:34:0x0066] */
                /* JADX WARNING: Removed duplicated region for block: B:37:0x006b A[SYNTHETIC, Splitter:B:37:0x006b] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                    // Method dump skipped, instructions count: 140
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0286bn.RunnableC02871.run():void");
                }
            });
        }
    }

    /* renamed from: b */
    private static String m768b(Context context) {
        String a = m764a(C0366u.m1378a(context, C0366u.f927f));
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        String f = m772f(context);
        StringBuilder sb = new StringBuilder();
        sb.append("{\"pinfo\":\"").append(f).append("\",\"els\":[");
        sb.append(a);
        sb.append("]}");
        return sb.toString();
    }

    /* renamed from: c */
    private static int m769c(Context context) {
        try {
            File file = new File(C0366u.m1378a(context, C0366u.f927f));
            if (!file.exists()) {
                return 0;
            }
            return file.list().length;
        } catch (Throwable th) {
            C0365t.m1372a(th, "OfflineLocManager", "getFileNum");
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0040 A[SYNTHETIC, Splitter:B:18:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004b A[SYNTHETIC, Splitter:B:23:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005b A[SYNTHETIC, Splitter:B:30:0x005b] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long m770d(android.content.Context r5) {
        /*
        // Method dump skipped, instructions count: 111
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0286bn.m770d(android.content.Context):long");
    }

    /* renamed from: e */
    private static boolean m771e(Context context) {
        try {
            if (C0353l.m1280m(context) == 1) {
                return System.currentTimeMillis() - m770d(context) > 604800000 || m769c(context) >= 100;
            }
        } catch (Throwable th) {
            C0365t.m1372a(th, "StatisticsManager", "isUpdate");
        }
        return false;
    }

    /* renamed from: f */
    private static String m772f(Context context) {
        return C0350k.m1258b(context, C0363r.m1358a(m773g(context)));
    }

    /* renamed from: g */
    private static String m773g(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"key\":\"").append(C0342i.m1235f(context)).append("\",\"platform\":\"android\",\"diu\":\"").append(C0353l.m1284q(context)).append("\",\"mac\":\"").append(C0353l.m1276i(context)).append("\",\"tid\":\"").append(C0353l.m1273f(context)).append("\",\"manufacture\":\"").append(Build.MANUFACTURER).append("\",\"device\":\"").append(Build.DEVICE).append("\",\"sim\":\"").append(C0353l.m1285r(context)).append("\",\"pkg\":\"").append(C0342i.m1232c(context)).append("\",\"model\":\"").append(Build.MODEL).append("\",\"appversion\":\"").append(C0342i.m1233d(context)).append("\"");
        } catch (Throwable th) {
            C0365t.m1372a(th, "CInfo", "getPublicJSONInfo");
        }
        return sb.toString();
    }
}
