package com.amap.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amap.loc.C0343j;
import com.umeng.analytics.C1370a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.amap.loc.ck */
/* compiled from: AuthUtil */
public class C0322ck {

    /* renamed from: A */
    private static boolean f714A = true;

    /* renamed from: B */
    private static int f715B = -1;

    /* renamed from: C */
    private static long f716C = 0;

    /* renamed from: D */
    private static ArrayList<String> f717D = new ArrayList<>();

    /* renamed from: E */
    private static String f718E;

    /* renamed from: F */
    private static String f719F;

    /* renamed from: G */
    private static boolean f720G = false;

    /* renamed from: H */
    private static boolean f721H = false;

    /* renamed from: I */
    private static int f722I = 3000;

    /* renamed from: J */
    private static int f723J = 3000;

    /* renamed from: K */
    private static boolean f724K = true;

    /* renamed from: L */
    private static long f725L = 300000;

    /* renamed from: M */
    private static int f726M = -1;

    /* renamed from: N */
    private static boolean f727N = false;

    /* renamed from: O */
    private static boolean f728O = false;

    /* renamed from: P */
    private static boolean f729P = false;

    /* renamed from: Q */
    private static boolean f730Q = false;

    /* renamed from: R */
    private static List<C0324cl> f731R = new ArrayList();

    /* renamed from: S */
    private static boolean f732S = false;

    /* renamed from: T */
    private static long f733T = 0;

    /* renamed from: U */
    private static int f734U = 0;

    /* renamed from: V */
    private static int f735V = 0;

    /* renamed from: W */
    private static List<String> f736W = new ArrayList();

    /* renamed from: X */
    private static boolean f737X = true;

    /* renamed from: Y */
    private static int f738Y = 80;

    /* renamed from: a */
    static boolean f739a = false;

    /* renamed from: b */
    private static String f740b = "提示信息";

    /* renamed from: c */
    private static String f741c = "确认";

    /* renamed from: d */
    private static String f742d = "取消";

    /* renamed from: e */
    private static String f743e = "";

    /* renamed from: f */
    private static String f744f = "";

    /* renamed from: g */
    private static String f745g = "";

    /* renamed from: h */
    private static boolean f746h = false;

    /* renamed from: i */
    private static long f747i = 0;

    /* renamed from: j */
    private static long f748j = 0;

    /* renamed from: k */
    private static long f749k = 5000;

    /* renamed from: l */
    private static boolean f750l = false;

    /* renamed from: m */
    private static int f751m = 0;

    /* renamed from: n */
    private static boolean f752n = false;

    /* renamed from: o */
    private static int f753o = 0;

    /* renamed from: p */
    private static boolean f754p = false;

    /* renamed from: q */
    private static boolean f755q = true;

    /* renamed from: r */
    private static int f756r = 3600000;

    /* renamed from: s */
    private static int f757s = 0;

    /* renamed from: t */
    private static int f758t = 0;

    /* renamed from: u */
    private static boolean f759u = true;

    /* renamed from: v */
    private static boolean f760v = true;

    /* renamed from: w */
    private static boolean f761w = true;

    /* renamed from: x */
    private static int f762x = -1;

    /* renamed from: y */
    private static long f763y = 0;

    /* renamed from: z */
    private static ArrayList<String> f764z = new ArrayList<>();

    /* access modifiers changed from: package-private */
    /* renamed from: com.amap.loc.ck$a */
    /* compiled from: AuthUtil */
    public static class C0323a {

        /* renamed from: a */
        boolean f765a = false;

        /* renamed from: b */
        String f766b = "0";

        /* renamed from: c */
        boolean f767c = false;

        /* renamed from: d */
        int f768d = 5;

        C0323a() {
        }
    }

    /* renamed from: a */
    private static C0323a m1038a(JSONObject jSONObject, String str) {
        Throwable th;
        C0323a aVar;
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(str);
                if (jSONObject2 != null) {
                    aVar = new C0323a();
                    try {
                        aVar.f765a = C0343j.m1243a(jSONObject2.optString("b"), false);
                        aVar.f766b = jSONObject2.optString("t");
                        aVar.f767c = C0343j.m1243a(jSONObject2.getString("st"), false);
                        aVar.f768d = jSONObject2.optInt("i", 0);
                        return aVar;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Throwable th3) {
                aVar = null;
                th = th3;
                C0310c.m956a(th, "AuthUtil", "getLocateObj");
                return aVar;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static void m1039a(Context context, C0343j.C0344a.C0348d dVar, C0360q qVar) {
        if (dVar != null) {
            String str = dVar.f857b;
            String str2 = dVar.f856a;
            String str3 = dVar.f858c;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                C0244ar.m539a(context, (C0243aq) null, qVar);
            } else {
                C0244ar.m539a(context, new C0243aq(str2, str, str3), qVar);
            }
        } else {
            C0244ar.m539a(context, (C0243aq) null, qVar);
        }
    }

    /* renamed from: a */
    private static void m1040a(Context context, C0343j.C0344a aVar) {
        try {
            JSONObject jSONObject = aVar.f829c;
            if (jSONObject != null) {
                f761w = C0343j.m1243a(jSONObject.getString("callamapflag"), true);
                if (f761w) {
                    f762x = jSONObject.getInt("count");
                    f763y = jSONObject.getLong("sysTime");
                    JSONArray jSONArray = jSONObject.getJSONArray("sn");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            f764z.add(jSONArray.getString(i));
                        }
                    }
                    if (!(f762x == -1 || f763y == 0)) {
                        if (!C0331cr.m1174b(f763y, C0329cq.m1144b(context, "pref", "nowtime", 0L))) {
                            m1075h(context);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "AuthUtil", "loadConfigData_callAMapSer");
        }
    }

    /* renamed from: a */
    private static void m1041a(C0343j.C0344a aVar) {
        try {
            JSONObject jSONObject = aVar.f835i;
            if (jSONObject != null) {
                f755q = C0343j.m1243a(jSONObject.getString("opflag"), true);
                C0301bt.f576a = f755q;
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "AuthUtil", "loadConfigData_offlineLoc");
        }
    }

    /* renamed from: a */
    public static void m1042a(boolean z) {
        f760v = z;
    }

    /* renamed from: a */
    public static boolean m1043a() {
        return f750l;
    }

    /* renamed from: a */
    public static boolean m1044a(long j) {
        long b = C0331cr.m1170b();
        return f746h && b - f748j <= f747i && b - j >= f749k;
    }

    /* renamed from: a */
    public static synchronized boolean m1045a(Context context) {
        boolean z;
        synchronized (C0322ck.class) {
            z = false;
            f760v = true;
            try {
                C0343j.C0344a a = C0343j.m1237a(context, C0310c.m950a("loc", "3.0.0"), C0310c.m961c(context), null);
                if (a != null) {
                    f726M = a.f828b;
                    z = m1069f(context, a);
                }
            } catch (Throwable th) {
                C0310c.m956a(th, "AuthUtil", "getConfig");
            }
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m1046a(Context context, long j) {
        if (!f721H) {
            return false;
        }
        long a = C0331cr.m1156a();
        if (a - j < ((long) f722I)) {
            return false;
        }
        if (f723J == -1) {
            return true;
        }
        if (!C0331cr.m1181c(a, C0329cq.m1144b(context, "pref", "ngpsTime", 0L))) {
            m1049b(context, a);
            C0329cq.m1138a(context, "pref", "ngpsCount", 1);
            return true;
        }
        int b = C0329cq.m1143b(context, "pref", "ngpsCount", 0);
        if (b >= f723J) {
            return false;
        }
        C0329cq.m1138a(context, "pref", "ngpsCount", b + 1);
        return true;
    }

    /* renamed from: a */
    private static boolean m1047a(Context context, C0343j.C0344a.C0346b bVar, String str, String str2) {
        boolean z = false;
        if (bVar != null) {
            try {
                z = bVar.f850a;
                String str3 = bVar.f851b;
                String str4 = bVar.f852c;
                String str5 = bVar.f853d;
                if (z && !TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str5)) {
                    C0244ar.m539a(context, new C0243aq(str3, str4, str5), C0310c.m950a(str, str2));
                }
            } catch (Throwable th) {
                C0310c.m956a(th, "AuthUtil", "downLoadPluginDex");
            }
        }
        return z;
    }

    /* renamed from: b */
    public static int m1048b() {
        return f751m;
    }

    /* renamed from: b */
    private static void m1049b(Context context, long j) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("pref", 0).edit();
            edit.putLong("ngpsTime", j);
            edit.putInt("ngpsCount", 0);
            C0329cq.m1142a(edit);
        } catch (Throwable th) {
            C0310c.m956a(th, "AuthUtil", "resetPrefsNGPS");
        }
    }

    /* renamed from: b */
    private static void m1050b(Context context, C0343j.C0344a aVar) {
        try {
            JSONObject jSONObject = aVar.f832f;
            if (jSONObject != null) {
                f714A = C0343j.m1243a(jSONObject.getString("amappushflag"), false);
                if (f714A) {
                    f715B = jSONObject.getInt("count");
                    f716C = jSONObject.getLong("sysTime");
                    JSONArray jSONArray = jSONObject.getJSONArray("sn");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            f717D.add(jSONArray.getString(i));
                        }
                    }
                    if (!(f715B == -1 || f716C == 0)) {
                        if (!C0331cr.m1174b(f716C, C0329cq.m1144b(context, "pref", "pushSerTime", 0L))) {
                            m1078i(context);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "AuthUtil", "loadConfigData_callAMapPush");
        }
    }

    /* renamed from: b */
    private static void m1051b(C0343j.C0344a aVar) {
        try {
            JSONObject jSONObject = aVar.f833g;
            if (jSONObject != null) {
                f720G = C0343j.m1243a(jSONObject.getString("f"), false);
                f757s = jSONObject.optInt("mco", 0);
                f758t = jSONObject.optInt("co", 0);
                f756r = jSONObject.optInt("it", 3600) * 1000;
                if (f756r < 3600000) {
                    f756r = 3600000;
                }
                f740b = jSONObject.optString("a", "提示信息");
                f741c = jSONObject.optString("o", "确认");
                f742d = jSONObject.optString("c", "取消");
                f743e = jSONObject.optString("i", "");
                f744f = jSONObject.optString("u", "");
                f745g = jSONObject.optString("t", "");
                if (((TextUtils.isEmpty(f743e) || "null".equals(f743e)) && (TextUtils.isEmpty(f744f) || "null".equals(f744f))) || f758t > f757s) {
                    f720G = false;
                }
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "AuthUtil", "loadConfigData_openAMap");
        }
    }

    /* renamed from: b */
    public static boolean m1052b(long j) {
        if (!f724K) {
            return false;
        }
        return f725L < 0 || C0331cr.m1156a() - j < f725L;
    }

    /* renamed from: b */
    public static boolean m1053b(Context context) {
        if (!f761w) {
            return false;
        }
        if (f762x == -1 || f763y == 0) {
            return true;
        }
        if (!C0331cr.m1174b(f763y, C0329cq.m1144b(context, "pref", "nowtime", 0L))) {
            m1075h(context);
            C0329cq.m1138a(context, "pref", "count", 1);
            return true;
        }
        int b = C0329cq.m1143b(context, "pref", "count", 0);
        if (b >= f762x) {
            return false;
        }
        C0329cq.m1138a(context, "pref", "count", b + 1);
        return true;
    }

    /* renamed from: c */
    private static void m1054c(Context context, C0343j.C0344a aVar) {
        try {
            m1039a(context, aVar.f842p, C0310c.m950a("loc", "3.0.0"));
        } catch (Throwable th) {
            C0310c.m956a(th, "AuthUtil", "loadConfigData_sdkUpdate");
        }
    }

    /* renamed from: c */
    private static void m1055c(C0343j.C0344a aVar) {
        try {
            JSONObject jSONObject = aVar.f834h;
            if (jSONObject != null && C0343j.m1243a(jSONObject.getString("able"), false)) {
                C0323a a = m1038a(jSONObject, "fs");
                if (a != null) {
                    f750l = a.f767c;
                    try {
                        f751m = Integer.parseInt(a.f766b);
                    } catch (Throwable th) {
                        C0310c.m956a(th, "AuthUtil", "loadconfig part2");
                    }
                }
                C0323a a2 = m1038a(jSONObject, "us");
                if (a2 != null) {
                    f752n = a2.f767c;
                    f754p = a2.f765a;
                    try {
                        f753o = Integer.parseInt(a2.f766b);
                    } catch (Throwable th2) {
                        C0310c.m956a(th2, "AuthUtil", "loadconfig part1");
                    }
                    if (f753o < 2) {
                        f752n = false;
                    }
                }
                C0323a a3 = m1038a(jSONObject, "rs");
                if (a3 != null) {
                    f746h = a3.f767c;
                    if (f746h) {
                        f748j = C0331cr.m1170b();
                        f749k = (long) (a3.f768d * 1000);
                    }
                    try {
                        f747i = (long) (Integer.parseInt(a3.f766b) * 1000);
                    } catch (Throwable th3) {
                        C0310c.m956a(th3, "AuthUtil", "loadconfig part");
                    }
                }
            }
        } catch (Throwable th4) {
            C0310c.m956a(th4, "AuthUtil", "loadConfigData_locate");
        }
    }

    /* renamed from: c */
    public static boolean m1056c() {
        return f752n;
    }

    /* renamed from: c */
    public static boolean m1057c(Context context) {
        if (!f714A) {
            return false;
        }
        if (f715B == -1 || f716C == 0) {
            return true;
        }
        if (!C0331cr.m1174b(f716C, C0329cq.m1144b(context, "pref", "pushSerTime", 0L))) {
            m1078i(context);
            C0329cq.m1138a(context, "pref", "pushCount", 1);
            return true;
        }
        int b = C0329cq.m1143b(context, "pref", "pushCount", 0);
        if (b >= f715B) {
            return false;
        }
        C0329cq.m1138a(context, "pref", "pushCount", b + 1);
        return true;
    }

    /* renamed from: d */
    public static int m1058d() {
        return f753o;
    }

    /* renamed from: d */
    private static void m1059d(Context context, C0343j.C0344a aVar) {
        try {
            C0343j.C0344a.C0347c cVar = aVar.f843q;
            if (cVar != null) {
                f718E = cVar.f854a;
                f719F = cVar.f855b;
                if (!TextUtils.isEmpty(f718E) && !TextUtils.isEmpty(f719F)) {
                    new C0358p(context, "loc", f718E, f719F).mo3937a();
                }
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "AuthUtil", "loadConfigData_groupOffset");
        }
    }

    /* renamed from: d */
    private static void m1060d(C0343j.C0344a aVar) {
        try {
            JSONObject jSONObject = aVar.f836j;
            if (jSONObject != null) {
                f721H = C0343j.m1243a(jSONObject.getString("able"), false);
                if (f721H) {
                    int i = jSONObject.getInt("c");
                    if (i == 0) {
                        f722I = 3000;
                    } else {
                        f722I = i * 1000;
                    }
                    f723J = jSONObject.getInt("t") / 2;
                }
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "AuthUtil", "loadConfigData_ngps");
        }
    }

    /* renamed from: d */
    public static synchronized boolean m1061d(Context context) {
        int b;
        boolean z = false;
        synchronized (C0322ck.class) {
            if (f720G && f758t > 0 && f757s > 0 && f758t <= f757s) {
                long b2 = C0329cq.m1144b(context, "abcd", "lct", 0L);
                long b3 = C0329cq.m1144b(context, "abcd", "lst", 0L);
                long b4 = C0331cr.m1170b();
                if (b4 < b2) {
                    C0329cq.m1139a(context, "abcd", "lct", b4);
                } else {
                    if (b4 - b2 > C1370a.f3217i) {
                        C0329cq.m1139a(context, "abcd", "lct", b4);
                        C0329cq.m1138a(context, "abcd", "t", 0);
                    }
                    if (b4 - b3 >= ((long) f756r) && (b = C0329cq.m1143b(context, "abcd", "t", 0) + 1) <= f757s) {
                        C0329cq.m1139a(context, "abcd", "lst", b4);
                        C0329cq.m1138a(context, "abcd", "t", b);
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    /* renamed from: e */
    public static void m1062e(Context context) {
        try {
            f759u = C0329cq.m1147b(context, "pref", "exception", true);
            m1066f(context);
        } catch (Throwable th) {
            C0310c.m956a(th, "AuthUtil", "loadLastAbleState p1");
        }
        try {
            f728O = C0329cq.m1147b(context, "pref", "oAble", false);
        } catch (Throwable th2) {
            C0310c.m956a(th2, "AuthUtil", "loadLastAbleState p2");
        }
    }

    /* renamed from: e */
    private static void m1063e(Context context, C0343j.C0344a aVar) {
        try {
            C0343j.C0344a.C0345a aVar2 = aVar.f841o;
            if (aVar2 != null) {
                f759u = aVar2.f848a;
                C0329cq.m1141a(context, "pref", "exception", f759u);
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "AuthUtil", "loadConfigData_uploadException");
        }
    }

    /* renamed from: e */
    private static void m1064e(C0343j.C0344a aVar) {
        try {
            JSONObject jSONObject = aVar.f837k;
            if (jSONObject != null) {
                f724K = C0343j.m1243a(jSONObject.getString("able"), true);
                if (f724K) {
                    f725L = (long) (jSONObject.getInt("c") * 1000);
                }
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "AuthUtil", "loadConfigData_cacheAble");
        }
    }

    /* renamed from: e */
    public static boolean m1065e() {
        return f754p;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void m1066f(android.content.Context r3) {
        /*
            java.lang.Class<com.amap.loc.ck> r1 = com.amap.loc.C0322ck.class
            monitor-enter(r1)
            java.lang.String r0 = "loc"
            java.lang.String r2 = "3.0.0"
            com.amap.loc.q r0 = com.amap.loc.C0310c.m950a(r0, r2)     // Catch:{ Throwable -> 0x0018, all -> 0x0015 }
            boolean r2 = com.amap.loc.C0322ck.f759u     // Catch:{ Throwable -> 0x0018, all -> 0x0015 }
            r0.mo3940a(r2)     // Catch:{ Throwable -> 0x0018, all -> 0x0015 }
            com.amap.loc.C0371w.m1391a(r3, r0)     // Catch:{ Throwable -> 0x0018, all -> 0x0015 }
        L_0x0013:
            monitor-exit(r1)
            return
        L_0x0015:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        L_0x0018:
            r0 = move-exception
            goto L_0x0013
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0322ck.m1066f(android.content.Context):void");
    }

    /* renamed from: f */
    private static void m1067f(C0343j.C0344a aVar) {
        try {
            JSONObject jSONObject = aVar.f831e;
            if (jSONObject != null) {
                f732S = C0343j.m1243a(jSONObject.getString("able"), false);
                f733T = jSONObject.optLong("sysTime", C0331cr.m1156a());
                f734U = jSONObject.optInt("n", 1);
                f735V = jSONObject.optInt("nh", 1);
                if (!f732S) {
                    return;
                }
                if (f734U == -1 || f734U >= f735V) {
                    JSONArray jSONArray = jSONObject.getJSONArray("l");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            C0324cl clVar = new C0324cl();
                            boolean a = C0343j.m1243a(jSONObject2.optString("able", "false"), false);
                            clVar.mo3895a(a);
                            if (a) {
                                clVar.mo3893a(jSONObject2.optString("pn", ""));
                                clVar.mo3898b(jSONObject2.optString("cn", ""));
                                clVar.mo3901c(jSONObject2.optString("a", ""));
                                JSONArray optJSONArray = jSONObject2.optJSONArray("b");
                                if (optJSONArray != null) {
                                    ArrayList arrayList = new ArrayList();
                                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                        JSONObject jSONObject3 = optJSONArray.getJSONObject(i2);
                                        HashMap hashMap = new HashMap();
                                        try {
                                            hashMap.put(jSONObject3.getString("k"), jSONObject3.getString("v"));
                                            arrayList.add(hashMap);
                                        } catch (Throwable th) {
                                        }
                                    }
                                    clVar.mo3894a(arrayList);
                                }
                                clVar.mo3899b(C0343j.m1243a(jSONObject2.optString("is", "false"), false));
                                f731R.add(clVar);
                            }
                        } catch (Throwable th2) {
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("sl");
                    if (optJSONArray2 != null) {
                        for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                            String optString = optJSONArray2.getJSONObject(i3).optString("pan");
                            if (!TextUtils.isEmpty(optString)) {
                                f736W.add(optString);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            C0310c.m956a(th3, "AuthUtil", "loadConfigData_otherServiceList");
        }
    }

    /* renamed from: f */
    public static boolean m1068f() {
        C0301bt.f576a = f755q;
        return f755q;
    }

    /* renamed from: f */
    private static boolean m1069f(Context context, C0343j.C0344a aVar) {
        try {
            m1041a(aVar);
            if (f755q) {
                m1076h(context, aVar);
            }
            m1040a(context, aVar);
            m1050b(context, aVar);
            m1051b(aVar);
            m1054c(context, aVar);
            m1059d(context, aVar);
            m1063e(context, aVar);
            m1055c(aVar);
            m1060d(aVar);
            m1064e(aVar);
            m1071g(context, aVar);
            m1079i(context, aVar);
            m1082j(context, aVar);
            m1067f(aVar);
            m1072g(aVar);
            return true;
        } catch (Throwable th) {
            C0310c.m956a(th, "AuthUtil", "loadconfig");
            return false;
        }
    }

    /* renamed from: g */
    public static String m1070g() {
        return f740b;
    }

    /* renamed from: g */
    private static void m1071g(Context context, C0343j.C0344a aVar) {
        try {
            C0343j.C0344a.C0346b bVar = aVar.f844r;
            if (bVar != null) {
                f727N = m1047a(context, bVar, "Collection", "1.0.0");
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "AuthUtil", "loadConfigData_CollectorDex");
        }
    }

    /* renamed from: g */
    private static void m1072g(C0343j.C0344a aVar) {
        try {
            JSONObject jSONObject = aVar.f830d;
            if (jSONObject != null) {
                f737X = C0343j.m1243a(jSONObject.getString("able"), true);
                if (f737X) {
                    f738Y = jSONObject.getInt("c");
                }
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "AuthUtil", "loadConfigData_gpsGeoAble");
        }
    }

    /* renamed from: g */
    public static synchronized boolean m1073g(Context context) {
        boolean z;
        synchronized (C0322ck.class) {
            if (!f732S || f734U == 0 || f735V == 0 || f733T == 0 || (f734U != -1 && f734U < f735V)) {
                z = false;
            } else {
                if (f736W != null && f736W.size() > 0) {
                    Iterator<String> it = f736W.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (C0331cr.m1175b(context, it.next())) {
                                z = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (f734U == -1 && f735V == -1) {
                    z = true;
                } else {
                    long b = C0329cq.m1144b(context, "pref", "ots", 0L);
                    long b2 = C0329cq.m1144b(context, "pref", "otsh", 0L);
                    int b3 = C0329cq.m1143b(context, "pref", "otn", 0);
                    int b4 = C0329cq.m1143b(context, "pref", "otnh", 0);
                    if (f734U != -1) {
                        if (!C0331cr.m1174b(f733T, b)) {
                            m1081j(context);
                            C0329cq.m1138a(context, "pref", "otn", 1);
                            C0329cq.m1138a(context, "pref", "otnh", 1);
                            z = true;
                        } else if (b3 < f734U) {
                            if (f735V == -1) {
                                C0329cq.m1138a(context, "pref", "otn", b3 + 1);
                                C0329cq.m1138a(context, "pref", "otnh", 0);
                                z = true;
                            } else if (!C0331cr.m1160a(f733T, b2)) {
                                C0329cq.m1139a(context, "pref", "otsh", f733T);
                                C0329cq.m1138a(context, "pref", "otn", b3 + 1);
                                C0329cq.m1138a(context, "pref", "otnh", 1);
                                z = true;
                            } else if (b4 < f735V) {
                                C0329cq.m1138a(context, "pref", "otn", b3 + 1);
                                C0329cq.m1138a(context, "pref", "otnh", b4 + 1);
                                z = true;
                            }
                        }
                    }
                    if (f734U == -1) {
                        C0329cq.m1138a(context, "pref", "otn", 0);
                        if (f735V == -1) {
                            C0329cq.m1138a(context, "pref", "otnh", 0);
                            z = true;
                        } else if (!C0331cr.m1160a(f733T, b2)) {
                            C0329cq.m1139a(context, "pref", "otsh", f733T);
                            C0329cq.m1138a(context, "pref", "otnh", 1);
                            z = true;
                        } else if (b4 < f735V) {
                            C0329cq.m1138a(context, "pref", "otnh", b4 + 1);
                            z = true;
                        }
                    }
                    z = false;
                }
            }
        }
        return z;
    }

    /* renamed from: h */
    public static String m1074h() {
        return f741c;
    }

    /* renamed from: h */
    private static void m1075h(Context context) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("pref", 0).edit();
            edit.putLong("nowtime", f763y);
            edit.putInt("count", 0);
            C0329cq.m1142a(edit);
        } catch (Throwable th) {
            C0310c.m956a(th, "AuthUtil", "resetPrefsBind");
        }
    }

    /* renamed from: h */
    private static void m1076h(Context context, C0343j.C0344a aVar) {
        try {
            C0343j.C0344a.C0346b bVar = aVar.f845s;
            if (bVar != null) {
                f728O = m1047a(context, bVar, "OfflineLocation", "1.0.0");
                C0329cq.m1141a(context, "pref", "oAble", f728O);
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "AuthUtil", "loadConfigData_OfflineDex");
        }
    }

    /* renamed from: i */
    public static String m1077i() {
        return f742d;
    }

    /* renamed from: i */
    private static void m1078i(Context context) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("pref", 0).edit();
            edit.putLong("pushSerTime", f716C);
            edit.putInt("pushCount", 0);
            C0329cq.m1142a(edit);
        } catch (Throwable th) {
            C0310c.m956a(th, "AuthUtil", "resetPrefsBind");
        }
    }

    /* renamed from: i */
    private static void m1079i(Context context, C0343j.C0344a aVar) {
        try {
            C0343j.C0344a.C0346b bVar = aVar.f846t;
            if (bVar != null) {
                f729P = m1047a(context, bVar, "HttpDNS", "1.0.0");
                if (!f729P && C0327co.m1128a(context, C0310c.m950a("HttpDNS", "1.0.0"))) {
                    C0328cp.m1134a(context, "HttpDNS", "config|get dnsDex able is false");
                }
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "AuthUtil", "loadConfigData_dnsDex");
        }
    }

    /* renamed from: j */
    public static String m1080j() {
        return f743e;
    }

    /* renamed from: j */
    private static void m1081j(Context context) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("pref", 0).edit();
            edit.putLong("ots", f733T);
            edit.putLong("otsh", f733T);
            edit.putInt("otn", 0);
            edit.putInt("otnh", 0);
            C0329cq.m1142a(edit);
        } catch (Throwable th) {
            C0310c.m956a(th, "AuthUtil", "resetPrefsBind");
        }
    }

    /* renamed from: j */
    private static void m1082j(Context context, C0343j.C0344a aVar) {
        try {
            JSONObject jSONObject = aVar.f838l;
            if (jSONObject != null) {
                f739a = C0343j.m1243a(jSONObject.getString("able"), true);
                if (f739a) {
                    C0244ar.m540a(context, "loc");
                }
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "AuthUtil", "loadConfigData_CallBackDex");
        }
    }

    /* renamed from: k */
    public static String m1083k() {
        return f744f;
    }

    /* renamed from: l */
    public static String m1084l() {
        return f745g;
    }

    /* renamed from: m */
    public static ArrayList<String> m1085m() {
        return f764z;
    }

    /* renamed from: n */
    public static ArrayList<String> m1086n() {
        return f717D;
    }

    /* renamed from: o */
    public static boolean m1087o() {
        return f759u;
    }

    /* renamed from: p */
    public static boolean m1088p() {
        return f760v;
    }

    /* renamed from: q */
    public static boolean m1089q() {
        return f721H;
    }

    /* renamed from: r */
    public static boolean m1090r() {
        return f724K;
    }

    /* renamed from: s */
    public static synchronized int m1091s() {
        int i;
        synchronized (C0322ck.class) {
            i = f726M;
        }
        return i;
    }

    /* renamed from: t */
    public static boolean m1092t() {
        return f727N;
    }

    /* renamed from: u */
    public static boolean m1093u() {
        return f728O;
    }

    /* renamed from: v */
    public static synchronized List<C0324cl> m1094v() {
        List<C0324cl> list;
        synchronized (C0322ck.class) {
            list = f731R;
        }
        return list;
    }

    /* renamed from: w */
    public static boolean m1095w() {
        return f737X;
    }

    /* renamed from: x */
    public static int m1096x() {
        return f738Y;
    }
}
