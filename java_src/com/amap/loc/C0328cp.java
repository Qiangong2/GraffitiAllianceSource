package com.amap.loc;

import android.content.Context;

/* renamed from: com.amap.loc.cp */
/* compiled from: RollBackDynamic */
public class C0328cp {

    /* renamed from: a */
    static boolean f778a = false;

    /* renamed from: b */
    static boolean f779b = false;

    /* renamed from: c */
    static boolean f780c = false;

    /* renamed from: d */
    static boolean f781d = false;

    /* renamed from: e */
    static int f782e = 0;

    /* renamed from: f */
    static int f783f = 0;

    /* renamed from: g */
    static boolean f784g = true;

    /* renamed from: h */
    static boolean f785h = false;

    /* renamed from: a */
    public static void m1131a(Context context) {
        try {
            if (f780c && !f778a) {
                C0329cq.m1138a(context, "loc", "startMark", C0329cq.m1143b(context, "loc", "startMark", 0) + 1);
                f778a = true;
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "RollBackDynamic", "AddStartMark");
        }
    }

    /* renamed from: a */
    public static void m1132a(Context context, int i) {
        try {
            if (f780c) {
                C0329cq.m1138a(context, "loc", "endMark", i);
                C0329cq.m1138a(context, "loc", "startMark", i);
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "RollBackDynamic", "resetMark");
        }
    }

    /* renamed from: a */
    public static void m1133a(Context context, C0360q qVar) {
        if (!f781d) {
            f780c = C0244ar.m541a(context, qVar);
            f781d = true;
            if (!f780c && C0310c.m963d()) {
                C0244ar.m540a(context, "loc");
                C0327co.m1127a("dexrollbackstatistics", "RollBack because of version error");
            }
        }
    }

    /* renamed from: a */
    public static void m1134a(Context context, String str, String str2) {
        try {
            C0244ar.m540a(context, str);
            C0327co.m1127a("dexrollbackstatistics", "RollBack because of " + str2);
        } catch (Throwable th) {
            C0310c.m956a(th, "RollBackDynamic", "rollBackDynamicFile");
        }
    }

    /* renamed from: b */
    public static void m1135b(Context context) {
        try {
            if (!f781d) {
                m1133a(context, C0310c.m950a("loc", "3.0.0"));
                f781d = true;
            }
            if (f780c && !f779b) {
                C0329cq.m1138a(context, "loc", "endMark", C0329cq.m1143b(context, "loc", "endMark", 0) + 1);
                f779b = true;
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "RollBackDynamic", "AddEndMark");
        }
    }

    /* renamed from: c */
    public static synchronized boolean m1136c(Context context) {
        boolean z = false;
        synchronized (C0328cp.class) {
            try {
                if (f780c) {
                    if (f785h) {
                        z = f784g;
                    } else {
                        if (f782e == 0) {
                            f782e = C0329cq.m1143b(context, "loc", "startMark", 0);
                        }
                        if (f783f == 0) {
                            f783f = C0329cq.m1143b(context, "loc", "endMark", 0);
                        }
                        if (!f778a && !f779b) {
                            if (f782e < f783f) {
                                m1132a(context, 0);
                                f784g = true;
                            }
                            if (f782e - f783f >= 1 && f782e > 99) {
                                m1132a(context, 0);
                                f784g = true;
                            }
                            if (f782e - f783f >= 1 && f782e < 99) {
                                m1132a(context, -2);
                                f784g = false;
                            }
                            if (f782e - f783f >= 1 && f783f < 0) {
                                m1134a(context, "loc", "checkMark");
                                f784g = false;
                            }
                        }
                        C0329cq.m1141a(context, "loc", "isload", f784g);
                        f785h = true;
                        z = f784g;
                    }
                }
            } catch (Throwable th) {
                C0310c.m956a(th, "RollBackDynamic", "checkMark");
            }
        }
        return z;
    }

    /* renamed from: d */
    public static boolean m1137d(Context context) {
        try {
            if (!f780c) {
                return false;
            }
            return C0329cq.m1147b(context, "loc", "isload", true);
        } catch (Throwable th) {
            C0310c.m956a(th, "RollBackDynamic", "isLoad");
            return true;
        }
    }
}
