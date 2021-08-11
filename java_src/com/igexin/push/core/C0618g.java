package com.igexin.push.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.p012b.p022b.C0476a;
import com.igexin.push.config.C0518o;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.p032d.p035c.C0640c;
import com.igexin.push.p079f.p081b.AbstractC1150h;
import com.igexin.sdk.p082a.C1173c;
import com.igexin.sdk.p082a.C1174d;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.igexin.push.core.g */
public class C0618g {

    /* renamed from: A */
    public static String f1576A;

    /* renamed from: B */
    public static String f1577B;

    /* renamed from: C */
    public static String f1578C = "";

    /* renamed from: D */
    public static long f1579D = -1;

    /* renamed from: E */
    public static long f1580E = -1;

    /* renamed from: F */
    public static long f1581F = 0;

    /* renamed from: G */
    public static long f1582G = 0;

    /* renamed from: H */
    public static long f1583H = 0;

    /* renamed from: I */
    public static long f1584I = 0;

    /* renamed from: J */
    public static long f1585J = 0;

    /* renamed from: K */
    public static long f1586K = 0;

    /* renamed from: L */
    public static long f1587L = 0;

    /* renamed from: M */
    public static String f1588M = null;

    /* renamed from: N */
    public static boolean f1589N = C0518o.f1336a.equals("debug");

    /* renamed from: O */
    public static long f1590O = 0;

    /* renamed from: P */
    public static long f1591P = 0;

    /* renamed from: Q */
    public static String f1592Q;

    /* renamed from: R */
    public static long f1593R = 0;

    /* renamed from: S */
    public static int f1594S = 0;

    /* renamed from: T */
    public static long f1595T;

    /* renamed from: U */
    public static String f1596U;

    /* renamed from: V */
    public static String f1597V;

    /* renamed from: W */
    public static String f1598W;

    /* renamed from: X */
    public static String f1599X;

    /* renamed from: Y */
    public static String f1600Y;

    /* renamed from: Z */
    public static String f1601Z;

    /* renamed from: a */
    public static String f1602a = "";

    /* renamed from: aA */
    private static HashMap<String, String> f1603aA = new HashMap<>();

    /* renamed from: aB */
    private static Map<String, Integer> f1604aB;

    /* renamed from: aa */
    public static String f1605aa;

    /* renamed from: ab */
    public static String f1606ab;

    /* renamed from: ac */
    public static String f1607ac;

    /* renamed from: ad */
    public static byte[] f1608ad;

    /* renamed from: ae */
    public static boolean f1609ae;

    /* renamed from: af */
    public static boolean f1610af;

    /* renamed from: ag */
    public static boolean f1611ag;

    /* renamed from: ah */
    public static Map<String, PushTaskBean> f1612ah;

    /* renamed from: ai */
    public static Map<String, Integer> f1613ai;

    /* renamed from: aj */
    public static HashMap<String, Timer> f1614aj;

    /* renamed from: ak */
    public static HashMap<String, C0640c> f1615ak;

    /* renamed from: al */
    public static HashMap<String, Long> f1616al;

    /* renamed from: am */
    public static int f1617am = 0;

    /* renamed from: an */
    public static Map<String, String> f1618an;

    /* renamed from: ao */
    public static int f1619ao = 0;

    /* renamed from: ap */
    public static int f1620ap = 0;

    /* renamed from: aq */
    public static int f1621aq = 0;

    /* renamed from: ar */
    public static String f1622ar;

    /* renamed from: as */
    public static AbstractC1150h f1623as;

    /* renamed from: at */
    public static long f1624at;

    /* renamed from: au */
    public static String f1625au;

    /* renamed from: av */
    public static String f1626av;

    /* renamed from: aw */
    public static String f1627aw;

    /* renamed from: ax */
    public static String f1628ax;

    /* renamed from: ay */
    public static boolean f1629ay;

    /* renamed from: az */
    public static int f1630az;

    /* renamed from: b */
    public static String f1631b = "";

    /* renamed from: c */
    public static String f1632c = "";

    /* renamed from: d */
    public static String f1633d = "";

    /* renamed from: e */
    public static String f1634e = "";

    /* renamed from: f */
    public static Context f1635f;

    /* renamed from: g */
    public static AtomicBoolean f1636g = new AtomicBoolean(false);

    /* renamed from: h */
    public static boolean f1637h = true;

    /* renamed from: i */
    public static volatile boolean f1638i;

    /* renamed from: j */
    public static volatile boolean f1639j;

    /* renamed from: k */
    public static boolean f1640k = true;

    /* renamed from: l */
    public static volatile boolean f1641l;

    /* renamed from: m */
    public static volatile boolean f1642m;

    /* renamed from: n */
    public static boolean f1643n = true;

    /* renamed from: o */
    public static int f1644o = 0;

    /* renamed from: p */
    public static int f1645p = 0;

    /* renamed from: q */
    public static long f1646q = 0;

    /* renamed from: r */
    public static String f1647r;

    /* renamed from: s */
    public static String f1648s;

    /* renamed from: t */
    public static String f1649t;

    /* renamed from: u */
    public static String f1650u;

    /* renamed from: v */
    public static String f1651v;

    /* renamed from: w */
    public static String f1652w;

    /* renamed from: x */
    public static String f1653x;

    /* renamed from: y */
    public static String f1654y;

    /* renamed from: z */
    public static String f1655z;

    /* renamed from: a */
    public static int m2422a(String str, boolean z) {
        int intValue;
        synchronized (C0618g.class) {
            if (f1604aB.get(str) == null) {
                f1604aB.put(str, 0);
            }
            intValue = f1604aB.get(str).intValue();
            if (z) {
                intValue--;
                f1604aB.put(str, Integer.valueOf(intValue));
                if (intValue == 0) {
                    f1604aB.remove(str);
                }
            }
        }
        return intValue;
    }

    /* renamed from: a */
    public static String m2423a() {
        return SDKUrlConfig.getConfigServiceUrl();
    }

    /* renamed from: a */
    public static void m2424a(long j) {
        f1646q = j;
        f1647r = C0476a.m1773a(String.valueOf(f1646q));
    }

    /* renamed from: a */
    public static boolean m2425a(Context context) {
        boolean z = false;
        f1635f = context;
        f1634e = context.getPackageName();
        if (!m2430e()) {
            ActivityC0460a.m1698b("CoreRuntimeInfo|parseManifests failed");
            return false;
        }
        f1608ad = C0476a.m1773a(f1602a + f1632c + f1631b + context.getPackageName()).getBytes();
        m2429d();
        m2428c();
        m2431f();
        ConnectivityManager j = C0617f.m2395a().mo4631j();
        if (j != null) {
            NetworkInfo activeNetworkInfo = j.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                z = true;
            }
            f1637h = z;
        } else {
            f1637h = false;
        }
        f1612ah = new HashMap();
        f1613ai = new HashMap();
        f1614aj = new HashMap<>();
        f1615ak = new HashMap<>();
        f1616al = new HashMap<>();
        f1618an = new HashMap();
        f1595T = System.currentTimeMillis();
        f1596U = "com.igexin.sdk.action.snlresponse." + f1634e;
        f1638i = new C1174d(context).mo5972c();
        f1639j = new C1173c(context).mo5969c();
        f1604aB = new HashMap();
        f1629ay = true;
        ActivityC0460a.m1699b("CoreRuntimeInfo", "getui sdk init success");
        ActivityC0460a.m1698b("CoreRuntimeInfo|getui sdk init success ##########");
        return true;
    }

    /* renamed from: a */
    public static boolean m2426a(String str, Integer num, boolean z) {
        boolean z2;
        synchronized (C0618g.class) {
            int intValue = num.intValue();
            if (!z || f1604aB.get(str) == null || (intValue = f1604aB.get(str).intValue() + num.intValue()) != 0) {
                f1604aB.put(str, Integer.valueOf(intValue));
                z2 = true;
            } else {
                f1604aB.remove(str);
                z2 = false;
            }
        }
        return z2;
    }

    /* renamed from: b */
    public static HashMap<String, String> m2427b() {
        return f1603aA;
    }

    /* renamed from: c */
    private static void m2428c() {
        try {
            File file = new File("/sdcard/libs/");
            if (file.exists() && file.isFile()) {
                ActivityC0460a.m1698b("CoreRuntimeInfo|libs is file not directory, delete libs file ++++");
                file.delete();
            }
            if (!file.exists() && !file.mkdir()) {
                ActivityC0460a.m1698b("CoreRuntimeInfo|create libs directory failed ++++++");
            }
            f1635f.getFilesDir();
            try {
                File file2 = new File(Environment.getExternalStorageDirectory().getPath() + "/system/tmp/local");
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                f1605aa = file2.getAbsolutePath();
            } catch (Throwable th) {
                ActivityC0460a.m1698b("CoreRuntimeInfo|" + th.toString());
            }
            f1606ab = f1635f.getFilesDir().getPath();
            f1598W = "/sdcard/libs//" + f1634e + ".db";
            f1599X = "/sdcard/libs//com.igexin.sdk.deviceId.db";
            f1600Y = "/sdcard/libs//app.db";
            f1601Z = "/sdcard/libs//imsi.db";
            f1597V = "/sdcard/libs//" + f1634e + ".properties";
            f1607ac = "/sdcard/libs//" + f1634e + ".bin";
        } catch (Throwable th2) {
            ActivityC0460a.m1698b("CoreRuntimeInfo|initFile exception = " + th2.toString());
        }
    }

    /* renamed from: d */
    private static void m2429d() {
        try {
            PackageInfo packageInfo = f1635f.getPackageManager().getPackageInfo(f1634e, 4096);
            if (!(packageInfo == null || packageInfo.requestedPermissions == null)) {
                String[] strArr = packageInfo.requestedPermissions;
                for (String str : strArr) {
                }
            }
        } catch (Exception e) {
            ActivityC0460a.m1698b("CoreRuntimeInfo|init exception : " + e.toString());
        }
    }

    /* renamed from: e */
    private static boolean m2430e() {
        try {
            ApplicationInfo applicationInfo = f1635f.getPackageManager().getApplicationInfo(f1634e, 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return false;
            }
            String string = applicationInfo.metaData.getString(AssistPushConsts.GETUI_APPID);
            String string2 = applicationInfo.metaData.getString(AssistPushConsts.GETUI_APPSECRET);
            String string3 = applicationInfo.metaData.getString(AssistPushConsts.GETUI_APPKEY);
            if (string != null) {
                string = string.trim();
            }
            if (string2 != null) {
                string2 = string2.trim();
            }
            if (string3 != null) {
                string3 = string3.trim();
            }
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                ActivityC0460a.m1698b("CoreRuntimeInfo|getui sdk init error, missing parm #####");
                return false;
            }
            f1602a = string;
            f1631b = string3;
            f1632c = string2;
            f1633d = SDKUrlConfig.getLocation();
            return true;
        } catch (Throwable th) {
            ActivityC0460a.m1698b("CoreRuntimeInfo|get ApplicationInfo meta data exception :" + th.toString());
            return false;
        }
    }

    /* renamed from: f */
    private static void m2431f() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) f1635f.getSystemService("phone");
            f1649t = telephonyManager.getDeviceId();
            f1650u = telephonyManager.getSubscriberId();
            f1651v = Build.MODEL;
        } catch (Throwable th) {
        }
    }
}
