package com.amap.loc;

import android.content.Context;
import android.os.Build;
import com.umeng.analytics.C1370a;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/* renamed from: com.amap.loc.bp */
/* compiled from: StatisticsManager */
public class C0289bp {

    /* renamed from: a */
    private static boolean f481a = true;

    /* renamed from: a */
    public static void m778a(Context context) {
        try {
            if (m787g(context)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date()));
                stringBuffer.append(" ");
                stringBuffer.append(UUID.randomUUID().toString());
                stringBuffer.append(" ");
                if (stringBuffer.length() == 53) {
                    byte[] a = C0363r.m1358a(stringBuffer.toString());
                    byte[] b = m782b(context);
                    byte[] bArr = new byte[(a.length + b.length)];
                    System.arraycopy(a, 0, bArr, 0, a.length);
                    System.arraycopy(b, 0, bArr, a.length, b.length);
                    C0275bf.m719a().mo3748a(new C0370v(C0363r.m1364c(bArr), "2"));
                }
            }
        } catch (Throwable th) {
            C0365t.m1372a(th, "StatisticsManager", "updateStaticsData");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003a A[SYNTHETIC, Splitter:B:16:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004a A[SYNTHETIC, Splitter:B:24:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0054 A[SYNTHETIC, Splitter:B:30:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m779a(android.content.Context r5, long r6) {
        /*
        // Method dump skipped, instructions count: 101
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0289bp.m779a(android.content.Context, long):void");
    }

    /* renamed from: a */
    public static synchronized void m780a(final C0288bo boVar, final Context context) {
        synchronized (C0289bp.class) {
            C0371w.m1393b().submit(new Runnable() {
                /* class com.amap.loc.C0289bp.RunnableC02901 */

                /* JADX WARNING: Removed duplicated region for block: B:22:0x0071 A[SYNTHETIC, Splitter:B:22:0x0071] */
                /* JADX WARNING: Removed duplicated region for block: B:25:0x0076 A[SYNTHETIC, Splitter:B:25:0x0076] */
                /* JADX WARNING: Removed duplicated region for block: B:35:0x0086 A[SYNTHETIC, Splitter:B:35:0x0086] */
                /* JADX WARNING: Removed duplicated region for block: B:38:0x008b A[SYNTHETIC, Splitter:B:38:0x008b] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                    // Method dump skipped, instructions count: 172
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0289bp.RunnableC02901.run():void");
                }
            });
        }
    }

    /* renamed from: a */
    private static byte[] m781a(Context context, byte[] bArr) {
        try {
            return C0350k.m1256a(context, bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    private static byte[] m782b(Context context) {
        byte[] c = m783c(context);
        byte[] e = m785e(context);
        byte[] bArr = new byte[(c.length + e.length)];
        System.arraycopy(c, 0, bArr, 0, c.length);
        System.arraycopy(e, 0, bArr, c.length, e.length);
        return m781a(context, bArr);
    }

    /* renamed from: c */
    private static byte[] m783c(Context context) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        try {
            C0363r.m1355a(byteArrayOutputStream, "1.2.13.6");
            C0363r.m1355a(byteArrayOutputStream, "Android");
            C0363r.m1355a(byteArrayOutputStream, C0353l.m1284q(context));
            C0363r.m1355a(byteArrayOutputStream, C0353l.m1276i(context));
            C0363r.m1355a(byteArrayOutputStream, C0353l.m1273f(context));
            C0363r.m1355a(byteArrayOutputStream, Build.MANUFACTURER);
            C0363r.m1355a(byteArrayOutputStream, Build.MODEL);
            C0363r.m1355a(byteArrayOutputStream, Build.DEVICE);
            C0363r.m1355a(byteArrayOutputStream, C0353l.m1285r(context));
            C0363r.m1355a(byteArrayOutputStream, C0342i.m1232c(context));
            C0363r.m1355a(byteArrayOutputStream, C0342i.m1233d(context));
            C0363r.m1355a(byteArrayOutputStream, C0342i.m1235f(context));
            byteArrayOutputStream.write(new byte[]{0});
            bArr = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                return bArr;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        return bArr;
    }

    /* renamed from: d */
    private static int m784d(Context context) {
        try {
            File file = new File(C0366u.m1378a(context, C0366u.f926e));
            if (!file.exists()) {
                return 0;
            }
            return file.list().length;
        } catch (Throwable th) {
            C0365t.m1372a(th, "StatisticsManager", "getFileNum");
            return 0;
        }
    }

    /* renamed from: e */
    private static byte[] m785e(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        String a = C0366u.m1378a(context, C0366u.f926e);
        C0264bb bbVar = null;
        try {
            C0264bb a2 = C0264bb.m664a(new File(a), 1, 1, 102400);
            File file = new File(a);
            if (file != null && file.exists()) {
                String[] list = file.list();
                for (String str : list) {
                    if (str.contains(".0")) {
                        byteArrayOutputStream.write(C0291bq.m788a(a2, str.split("\\.")[0]));
                    }
                }
            }
            bArr = byteArrayOutputStream.toByteArray();
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (a2 != null) {
                try {
                    a2.close();
                } catch (Throwable th) {
                    th = th;
                }
            }
        } catch (IOException e2) {
            C0365t.m1372a(e2, "StatisticsManager", "getContent");
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            if (0 != 0) {
                bbVar.close();
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return bArr;
        th.printStackTrace();
        return bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0041 A[SYNTHETIC, Splitter:B:19:0x0041] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0052 A[SYNTHETIC, Splitter:B:26:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0063 A[SYNTHETIC, Splitter:B:33:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006e A[SYNTHETIC, Splitter:B:38:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007c A[SYNTHETIC, Splitter:B:45:0x007c] */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long m786f(android.content.Context r7) {
        /*
        // Method dump skipped, instructions count: 142
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0289bp.m786f(android.content.Context):long");
    }

    /* renamed from: g */
    private static boolean m787g(Context context) {
        try {
            if (C0353l.m1280m(context) != 1 || !f481a || m784d(context) < 100) {
                return false;
            }
            long f = m786f(context);
            long time = new Date().getTime();
            if (time - f < C1370a.f3218j) {
                return false;
            }
            m779a(context, time);
            f481a = false;
            return true;
        } catch (Throwable th) {
            C0365t.m1372a(th, "StatisticsManager", "isUpdate");
            return false;
        }
    }
}
