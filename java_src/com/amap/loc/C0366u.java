package com.amap.loc;

import android.content.Context;
import android.text.TextUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/* renamed from: com.amap.loc.u */
/* compiled from: Log */
public class C0366u {

    /* renamed from: a */
    public static final String f922a = "/a/";

    /* renamed from: b */
    static final String f923b = "b";

    /* renamed from: c */
    static final String f924c = "c";

    /* renamed from: d */
    static final String f925d = "d";

    /* renamed from: e */
    public static final String f926e = "e";

    /* renamed from: f */
    public static final String f927f = "f";

    /* renamed from: a */
    static AbstractC0225aa m1376a(Context context, int i) {
        switch (i) {
            case 0:
                return new C0375y(i);
            case 1:
                return new C0376z(i);
            case 2:
                return new C0374x(i);
            default:
                return null;
        }
    }

    /* renamed from: a */
    public static Class<? extends AbstractC0238al> m1377a(int i) {
        switch (i) {
            case 0:
                return C0232ag.class;
            case 1:
                return C0235ai.class;
            case 2:
                return C0231af.class;
            default:
                return null;
        }
    }

    /* renamed from: a */
    public static String m1378a(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + f922a + str;
    }

    /* renamed from: a */
    static void m1379a(Context context) {
        try {
            AbstractC0225aa a = m1376a(context, 2);
            if (a != null) {
                a.mo3635b(context);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    static void m1380a(final Context context, final C0360q qVar, final String str, final String str2) {
        ExecutorService b;
        try {
            if (qVar.mo3943d() && (b = C0371w.m1393b()) != null && !b.isShutdown()) {
                b.submit(new Runnable() {
                    /* class com.amap.loc.C0366u.RunnableC03671 */

                    public void run() {
                        try {
                            AbstractC0225aa a = C0366u.m1376a(context, 1);
                            if (TextUtils.isEmpty(str2)) {
                                a.mo3632a(qVar, context, new Throwable("gpsstatistics"), str, (String) null, (String) null);
                            } else {
                                a.mo3631a(qVar, context, str2, str, (String) null, (String) null);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        } catch (RejectedExecutionException e) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    static void m1381a(final Context context, final Throwable th, final int i, final String str, final String str2) {
        try {
            ExecutorService b = C0371w.m1393b();
            if (b != null && !b.isShutdown()) {
                b.submit(new Runnable() {
                    /* class com.amap.loc.C0366u.RunnableC03682 */

                    public void run() {
                        try {
                            AbstractC0225aa a = C0366u.m1376a(context, i);
                            if (a != null) {
                                a.mo3629a(context, th, str, str2);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        } catch (RejectedExecutionException e) {
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* renamed from: b */
    public static AbstractC0238al m1382b(int i) {
        switch (i) {
            case 0:
                return new C0232ag();
            case 1:
                return new C0235ai();
            case 2:
                return new C0231af();
            default:
                return null;
        }
    }

    /* renamed from: b */
    static void m1383b(final Context context) {
        try {
            ExecutorService b = C0371w.m1393b();
            if (b != null && !b.isShutdown()) {
                b.submit(new Runnable() {
                    /* class com.amap.loc.C0366u.RunnableC03693 */

                    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0089, code lost:
                        r3 = move-exception;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:45:0x008a, code lost:
                        r3 = r2;
                        r2 = r1;
                        r1 = null;
                        r0 = r3;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00a0, code lost:
                        r3 = move-exception;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00a1, code lost:
                        r3 = r2;
                        r2 = r1;
                        r1 = null;
                        r0 = r3;
                     */
                    /* JADX WARNING: Failed to process nested try/catch */
                    /* JADX WARNING: Removed duplicated region for block: B:21:0x004e  */
                    /* JADX WARNING: Removed duplicated region for block: B:23:0x0053  */
                    /* JADX WARNING: Removed duplicated region for block: B:25:0x0058  */
                    /* JADX WARNING: Removed duplicated region for block: B:29:0x0064  */
                    /* JADX WARNING: Removed duplicated region for block: B:31:0x0069  */
                    /* JADX WARNING: Removed duplicated region for block: B:33:0x006e  */
                    /* JADX WARNING: Removed duplicated region for block: B:38:0x0077  */
                    /* JADX WARNING: Removed duplicated region for block: B:40:0x007c  */
                    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b1 A[ExcHandler: RejectedExecutionException (e java.util.concurrent.RejectedExecutionException), Splitter:B:5:0x000f] */
                    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
                    /* JADX WARNING: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                        // Method dump skipped, instructions count: 179
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0366u.RunnableC03693.run():void");
                    }
                });
            }
        } catch (Throwable th) {
            C0365t.m1372a(th, "Log", "processLog");
        }
    }

    /* renamed from: c */
    public static String m1384c(int i) {
        switch (i) {
            case 0:
                return f924c;
            case 1:
                return f923b;
            case 2:
                return f925d;
            default:
                return "";
        }
    }
}
