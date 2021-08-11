package com.amap.loc;

import android.content.Context;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import org.json.JSONObject;

/* renamed from: com.amap.loc.co */
/* compiled from: ReportUtil */
public class C0327co {
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002e  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void m1121a(android.content.Context r6, int r7, com.amap.api.location.AMapLocation r8) {
        /*
        // Method dump skipped, instructions count: 116
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0327co.m1121a(android.content.Context, int, com.amap.api.location.AMapLocation):void");
    }

    /* renamed from: a */
    public static synchronized void m1122a(Context context, C0326cn cnVar) {
        int i;
        boolean z = true;
        boolean z2 = false;
        synchronized (C0327co.class) {
            if (context != null) {
                try {
                    if (C0322ck.m1087o()) {
                        AMapLocationServer c = cnVar.mo3910c();
                        int intValue = Long.valueOf(cnVar.mo3908b() - cnVar.mo3905a()).intValue();
                        String str = "net";
                        if (c != null) {
                            i = Long.valueOf(c.mo3977j()).intValue();
                            switch (c.getLocationType()) {
                                case 1:
                                    z = false;
                                    break;
                                case 2:
                                case 4:
                                    str = "cache";
                                    z2 = true;
                                    break;
                                case 5:
                                case 6:
                                    str = "net";
                                    break;
                            }
                        } else {
                            i = 0;
                        }
                        if (z) {
                            if (!z2) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("param_int_first", i);
                                jSONObject.put("param_int_second", intValue);
                                m1126a(context, "O003", jSONObject);
                            }
                            m1125a(context, "O002", intValue, str);
                        }
                    }
                } catch (Throwable th) {
                    C0310c.m956a(th, "ReportUtil", "reportLBSLocUseTime");
                }
            }
        }
        return;
    }

    /* renamed from: a */
    public static synchronized void m1123a(Context context, String str) {
        synchronized (C0327co.class) {
            try {
                m1125a(context, "O007", Integer.MAX_VALUE, str);
            } catch (Throwable th) {
                C0310c.m956a(th, "ReportUtil", "reportDex_triggerDownload");
            }
        }
        return;
    }

    /* renamed from: a */
    public static synchronized void m1124a(Context context, String str, int i) {
        synchronized (C0327co.class) {
            try {
                m1125a(context, "O009", i, str);
            } catch (Throwable th) {
                C0310c.m956a(th, "ReportUtil", "reportDex_dexLoadClass");
            }
        }
        return;
    }

    /* renamed from: a */
    private static synchronized void m1125a(Context context, String str, int i, String str2) {
        synchronized (C0327co.class) {
            if (context != null) {
                try {
                    if (C0322ck.m1087o()) {
                        JSONObject jSONObject = new JSONObject();
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject.put("param_string_first", str2);
                        }
                        if (i != Integer.MAX_VALUE) {
                            jSONObject.put("param_int_first", i);
                        }
                        m1126a(context, str, jSONObject);
                    }
                } catch (Throwable th) {
                    C0310c.m956a(th, "ReportUtil", "applyStatisticsEx");
                }
            }
        }
        return;
    }

    /* renamed from: a */
    private static synchronized void m1126a(Context context, String str, JSONObject jSONObject) {
        synchronized (C0327co.class) {
            if (context != null) {
                try {
                    if (C0322ck.m1087o()) {
                        C0288bo boVar = new C0288bo(context, "loc", "3.0.0", str);
                        boVar.mo3774a(jSONObject.toString());
                        C0289bp.m780a(boVar, context);
                    }
                } catch (Throwable th) {
                    C0310c.m956a(th, "ReportUtil", "applyStatistics");
                }
            }
        }
        return;
    }

    /* renamed from: a */
    public static synchronized void m1127a(String str, String str2) {
        synchronized (C0327co.class) {
            try {
                C0371w.m1394b(C0310c.m950a("loc", "3.0.0"), str2, str);
            } catch (Throwable th) {
                C0310c.m956a(th, "ReportUtil", "reportLog");
            }
        }
        return;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean m1128a(android.content.Context r3, com.amap.loc.C0360q r4) {
        /*
            java.lang.Class<com.amap.loc.co> r1 = com.amap.loc.C0327co.class
            monitor-enter(r1)
            r0 = 0
            boolean r0 = com.amap.loc.C0244ar.m541a(r3, r4)     // Catch:{ Throwable -> 0x000a, all -> 0x000c }
        L_0x0008:
            monitor-exit(r1)
            return r0
        L_0x000a:
            r2 = move-exception
            goto L_0x0008
        L_0x000c:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0327co.m1128a(android.content.Context, com.amap.loc.q):boolean");
    }

    /* renamed from: b */
    public static synchronized void m1129b(Context context, C0326cn cnVar) {
        synchronized (C0327co.class) {
            if (context != null) {
                try {
                    if (C0322ck.m1087o()) {
                        m1125a(context, "O004", Long.valueOf(cnVar.mo3908b() - cnVar.mo3905a()).intValue(), null);
                    }
                } catch (Throwable th) {
                    C0310c.m956a(th, "ReportUtil", "reportGPSLocUseTime");
                }
            }
        }
        return;
    }

    /* renamed from: b */
    public static synchronized void m1130b(Context context, String str, int i) {
        synchronized (C0327co.class) {
            try {
                m1125a(context, "O010", i, str);
            } catch (Throwable th) {
                C0310c.m956a(th, "ReportUtil", "reportDex_dexFunction");
            }
        }
        return;
    }
}
