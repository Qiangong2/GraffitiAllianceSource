package com.umeng.p085a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.C1370a;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.p092c.C1457h;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Locale;
import java.util.Properties;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.umeng.a.e */
/* compiled from: DeviceConfig */
public class C1343e {

    /* renamed from: a */
    protected static final String f3137a = C1343e.class.getName();

    /* renamed from: b */
    public static final String f3138b = "";

    /* renamed from: c */
    public static final String f3139c = "2G/3G";

    /* renamed from: d */
    public static final String f3140d = "Wi-Fi";

    /* renamed from: e */
    public static final int f3141e = 8;

    /* renamed from: f */
    private static final String f3142f = "ro.miui.ui.version.name";

    /* renamed from: a */
    public static String m4934a(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            return "";
        }
    }

    /* renamed from: b */
    public static String m4941b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "";
        }
    }

    /* renamed from: a */
    public static boolean m4938a(Context context, String str) {
        boolean z;
        if (Build.VERSION.SDK_INT < 23) {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        }
        try {
            if (((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() == 0) {
                z = true;
            } else {
                z = false;
            }
            return z;
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: a */
    public static String[] m4939a(GL10 gl10) {
        try {
            return new String[]{gl10.glGetString(7936), gl10.glGetString(7937)};
        } catch (Throwable th) {
            return new String[0];
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x000c A[Catch:{ Throwable -> 0x0072 }] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m4940b() {
        /*
        // Method dump skipped, instructions count: 117
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.p085a.C1343e.m4940b():java.lang.String");
    }

    /* renamed from: c */
    private static String m4943c() {
        try {
            String[] strArr = {"/sys/class/net/wlan0/address", "/sys/class/net/eth0/address", "/sys/devices/virtual/net/wlan0/address"};
            for (int i = 0; i < strArr.length; i++) {
                try {
                    String a = m4935a(strArr[i]);
                    if (a != null) {
                        return a;
                    }
                } catch (Throwable th) {
                }
            }
        } catch (Throwable th2) {
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0022 A[SYNTHETIC, Splitter:B:18:0x0022] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0027 A[SYNTHETIC, Splitter:B:21:0x0027] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m4935a(java.lang.String r4) {
        /*
            r0 = 0
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Throwable -> 0x002b }
            r3.<init>(r4)     // Catch:{ Throwable -> 0x002b }
            if (r3 == 0) goto L_0x001d
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x001e }
            r1 = 1024(0x400, float:1.435E-42)
            r2.<init>(r3, r1)     // Catch:{ all -> 0x001e }
            java.lang.String r0 = r2.readLine()     // Catch:{ all -> 0x0035 }
            if (r3 == 0) goto L_0x0018
            r3.close()     // Catch:{ Throwable -> 0x002d }
        L_0x0018:
            if (r2 == 0) goto L_0x001d
            r2.close()     // Catch:{ Throwable -> 0x002f }
        L_0x001d:
            return r0
        L_0x001e:
            r1 = move-exception
            r2 = r0
        L_0x0020:
            if (r3 == 0) goto L_0x0025
            r3.close()     // Catch:{ Throwable -> 0x0031 }
        L_0x0025:
            if (r2 == 0) goto L_0x002a
            r2.close()     // Catch:{ Throwable -> 0x0033 }
        L_0x002a:
            throw r1
        L_0x002b:
            r1 = move-exception
            goto L_0x001d
        L_0x002d:
            r1 = move-exception
            goto L_0x0018
        L_0x002f:
            r1 = move-exception
            goto L_0x001d
        L_0x0031:
            r3 = move-exception
            goto L_0x0025
        L_0x0033:
            r2 = move-exception
            goto L_0x002a
        L_0x0035:
            r1 = move-exception
            goto L_0x0020
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.p085a.C1343e.m4935a(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044 A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001d  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m4933a() {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x0047 }
            java.lang.String r2 = "/proc/cpuinfo"
            r1.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0047 }
            if (r1 == 0) goto L_0x001b
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Throwable -> 0x002e }
            r3 = 1024(0x400, float:1.435E-42)
            r2.<init>(r1, r3)     // Catch:{ Throwable -> 0x002e }
            java.lang.String r0 = r2.readLine()     // Catch:{ Throwable -> 0x002e }
            r2.close()     // Catch:{ FileNotFoundException -> 0x0037 }
            r1.close()     // Catch:{ FileNotFoundException -> 0x0037 }
        L_0x001b:
            if (r0 == 0) goto L_0x0044
            r1 = 58
            int r1 = r0.indexOf(r1)
            int r1 = r1 + 1
            java.lang.String r0 = r0.substring(r1)
            java.lang.String r0 = r0.trim()
        L_0x002d:
            return r0
        L_0x002e:
            r1 = move-exception
            java.lang.String r2 = com.umeng.p085a.C1343e.f3137a
            java.lang.String r3 = "Could not read from file /proc/cpuinfo"
            com.umeng.p085a.C1346h.m5010e(r2, r3, r1)
            goto L_0x001b
        L_0x0037:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x003b:
            java.lang.String r2 = com.umeng.p085a.C1343e.f3137a
            java.lang.String r3 = "Could not open file /proc/cpuinfo"
            com.umeng.p085a.C1346h.m5010e(r2, r3, r0)
            r0 = r1
            goto L_0x001b
        L_0x0044:
            java.lang.String r0 = ""
            goto L_0x002d
        L_0x0047:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x003b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.p085a.C1343e.m4933a():java.lang.String");
    }

    /* renamed from: c */
    public static String m4944c(Context context) {
        if (MobclickAgent.EScenarioType.E_UM_ANALYTICS_OEM.toValue() == AnalyticsConfig.getVerticalType(context) || MobclickAgent.EScenarioType.E_UM_GAME_OEM.toValue() == AnalyticsConfig.getVerticalType(context)) {
            return m4930E(context);
        }
        return m4929D(context);
    }

    /* renamed from: d */
    public static String m4946d(Context context) {
        return C1344f.m4979b(m4944c(context));
    }

    /* renamed from: e */
    public static String m4947e(Context context) {
        if (m4949f(context) == null) {
            return null;
        }
        int i = context.getResources().getConfiguration().mcc;
        int i2 = context.getResources().getConfiguration().mnc;
        if (i == 0) {
            return null;
        }
        String valueOf = String.valueOf(i2);
        if (i2 < 10) {
            valueOf = String.format("%02d", Integer.valueOf(i2));
        }
        return new StringBuffer().append(String.valueOf(i)).append(valueOf).toString();
    }

    /* renamed from: f */
    public static String m4949f(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (m4938a(context, "android.permission.READ_PHONE_STATE")) {
            return telephonyManager.getSubscriberId();
        }
        return null;
    }

    /* renamed from: g */
    public static String m4951g(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (m4938a(context, "android.permission.READ_PHONE_STATE")) {
            return telephonyManager.getNetworkOperator();
        }
        return null;
    }

    /* renamed from: h */
    public static String m4952h(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (m4938a(context, "android.permission.READ_PHONE_STATE") && telephonyManager != null) {
                return telephonyManager.getNetworkOperatorName();
            }
        } catch (Throwable th) {
        }
        return "";
    }

    /* renamed from: i */
    public static String m4953i(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            return String.valueOf(displayMetrics.heightPixels) + "*" + String.valueOf(i);
        } catch (Throwable th) {
            return "";
        }
    }

    /* renamed from: j */
    public static String[] m4954j(Context context) {
        String[] strArr = {"", ""};
        try {
            if (!m4938a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                strArr[0] = "";
                return strArr;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                strArr[0] = "";
                return strArr;
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo == null || networkInfo.getState() != NetworkInfo.State.CONNECTED) {
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                if (networkInfo2 != null && networkInfo2.getState() == NetworkInfo.State.CONNECTED) {
                    strArr[0] = f3139c;
                    strArr[1] = networkInfo2.getSubtypeName();
                    return strArr;
                }
                return strArr;
            }
            strArr[0] = f3140d;
            return strArr;
        } catch (Throwable th) {
        }
    }

    /* renamed from: k */
    public static boolean m4955k(Context context) {
        return f3140d.equals(m4954j(context)[0]);
    }

    /* renamed from: l */
    public static boolean m4956l(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            if (!(!m4938a(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null)) {
                return activeNetworkInfo.isConnectedOrConnecting();
            }
        } catch (Throwable th) {
        }
        return false;
    }

    /* renamed from: m */
    public static int m4957m(Context context) {
        try {
            Calendar instance = Calendar.getInstance(m4927B(context));
            if (instance != null) {
                return instance.getTimeZone().getRawOffset() / 3600000;
            }
        } catch (Throwable th) {
            C1346h.m4998c(f3137a, "error in getTimeZone", th);
        }
        return 8;
    }

    /* renamed from: n */
    public static boolean m4958n(Context context) {
        String e = C1457h.m5380a(context).mo8580b().mo8598e("");
        if (!TextUtils.isEmpty(e)) {
            return e.equals("cn");
        }
        if (m4949f(context) == null) {
            String str = m4959o(context)[0];
            if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("cn")) {
                return true;
            }
        } else {
            int i = context.getResources().getConfiguration().mcc;
            if (i == 460 || i == 461) {
                return true;
            }
            if (i == 0) {
                String str2 = m4959o(context)[0];
                if (!TextUtils.isEmpty(str2) && str2.equalsIgnoreCase("cn")) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: o */
    public static String[] m4959o(Context context) {
        String[] strArr = new String[2];
        try {
            Locale B = m4927B(context);
            if (B != null) {
                strArr[0] = B.getCountry();
                strArr[1] = B.getLanguage();
            }
            if (TextUtils.isEmpty(strArr[0])) {
                strArr[0] = "Unknown";
            }
            if (TextUtils.isEmpty(strArr[1])) {
                strArr[1] = "Unknown";
            }
        } catch (Throwable th) {
            C1346h.m5010e(f3137a, "error in getLocaleInfo", th);
        }
        return strArr;
    }

    /* renamed from: B */
    private static Locale m4927B(Context context) {
        Locale locale = null;
        try {
            Configuration configuration = new Configuration();
            configuration.setToDefaults();
            Settings.System.getConfiguration(context.getContentResolver(), configuration);
            if (configuration != null) {
                locale = configuration.locale;
            }
        } catch (Throwable th) {
            C1346h.m5000c(f3137a, "fail to read user config locale");
        }
        if (locale == null) {
            return Locale.getDefault();
        }
        return locale;
    }

    /* renamed from: p */
    public static String m4960p(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                String string = applicationInfo.metaData.getString("UMENG_APPKEY");
                if (string != null) {
                    return string.trim();
                }
                C1346h.m5000c(f3137a, "getAppkey failed. the applicationinfo is null!");
            }
        } catch (Throwable th) {
            C1346h.m5010e(f3137a, "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.", th);
        }
        return null;
    }

    /* renamed from: q */
    public static String m4961q(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return m4928C(context);
        }
        if (Build.VERSION.SDK_INT == 23) {
            String b = m4940b();
            if (!TextUtils.isEmpty(b)) {
                return b;
            }
            if (C1370a.f3212d) {
                return m4943c();
            }
            return m4928C(context);
        }
        String b2 = m4940b();
        if (TextUtils.isEmpty(b2)) {
            return m4928C(context);
        }
        return b2;
    }

    /* renamed from: C */
    private static String m4928C(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (m4938a(context, "android.permission.ACCESS_WIFI_STATE")) {
                return wifiManager.getConnectionInfo().getMacAddress();
            }
            return "";
        } catch (Throwable th) {
            return "";
        }
    }

    /* renamed from: r */
    public static int[] m4962r(Context context) {
        int i;
        int i2;
        int i3;
        int i4;
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            if ((context.getApplicationInfo().flags & 8192) == 0) {
                i2 = m4932a(displayMetrics, "noncompatWidthPixels");
                i = m4932a(displayMetrics, "noncompatHeightPixels");
            } else {
                i = -1;
                i2 = -1;
            }
            if (i2 == -1 || i == -1) {
                i3 = displayMetrics.widthPixels;
                i4 = displayMetrics.heightPixels;
            } else {
                i3 = i2;
                i4 = i;
            }
            int[] iArr = new int[2];
            if (i3 > i4) {
                iArr[0] = i4;
                iArr[1] = i3;
                return iArr;
            }
            iArr[0] = i3;
            iArr[1] = i4;
            return iArr;
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: a */
    private static int m4932a(Object obj, String str) {
        try {
            Field declaredField = DisplayMetrics.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getInt(obj);
        } catch (Throwable th) {
            return -1;
        }
    }

    /* renamed from: s */
    public static String m4963s(Context context) {
        Object obj;
        String obj2;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null || (obj = applicationInfo.metaData.get("UMENG_CHANNEL")) == null || (obj2 = obj.toString()) == null) {
                return "Unknown";
            }
            return obj2;
        } catch (Throwable th) {
            return "Unknown";
        }
    }

    /* renamed from: t */
    public static String m4964t(Context context) {
        return context.getPackageName();
    }

    /* renamed from: u */
    public static String m4965u(Context context) {
        try {
            return m4937a(MessageDigest.getInstance("MD5").digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(m4964t(context), 64).signatures[0].toByteArray()))).getEncoded()));
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: a */
    private static String m4937a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            String hexString = Integer.toHexString(bArr[i]);
            int length = hexString.length();
            if (length == 1) {
                hexString = "0" + hexString;
            }
            if (length > 2) {
                hexString = hexString.substring(length - 2, length);
            }
            sb.append(hexString.toUpperCase(Locale.getDefault()));
            if (i < bArr.length - 1) {
                sb.append(':');
            }
        }
        return sb.toString();
    }

    /* renamed from: v */
    public static String m4966v(Context context) {
        return context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
    }

    /* renamed from: w */
    public static String m4967w(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: D */
    private static String m4929D(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            String F = m4931F(context);
            if (!TextUtils.isEmpty(F)) {
                return F;
            }
            String C = m4928C(context);
            if (!TextUtils.isEmpty(C)) {
                return C;
            }
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (TextUtils.isEmpty(string)) {
                return m4945d();
            }
            return string;
        } else if (Build.VERSION.SDK_INT == 23) {
            String F2 = m4931F(context);
            if (!TextUtils.isEmpty(F2)) {
                return F2;
            }
            String b = m4940b();
            if (TextUtils.isEmpty(b)) {
                if (C1370a.f3212d) {
                    b = m4943c();
                } else {
                    b = m4928C(context);
                }
            }
            if (!TextUtils.isEmpty(b)) {
                return b;
            }
            String string2 = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (TextUtils.isEmpty(string2)) {
                return m4945d();
            }
            return string2;
        } else {
            String F3 = m4931F(context);
            if (!TextUtils.isEmpty(F3)) {
                return F3;
            }
            String d = m4945d();
            if (!TextUtils.isEmpty(d)) {
                return d;
            }
            String string3 = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (!TextUtils.isEmpty(string3)) {
                return string3;
            }
            String b2 = m4940b();
            if (TextUtils.isEmpty(b2)) {
                return m4928C(context);
            }
            return b2;
        }
    }

    /* renamed from: E */
    private static String m4930E(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            String C = m4928C(context);
            if (!TextUtils.isEmpty(C)) {
                return C;
            }
            String d = m4945d();
            if (TextUtils.isEmpty(d)) {
                return m4931F(context);
            }
            return d;
        } else if (Build.VERSION.SDK_INT == 23) {
            String string2 = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (!TextUtils.isEmpty(string2)) {
                return string2;
            }
            String b = m4940b();
            if (TextUtils.isEmpty(b)) {
                if (C1370a.f3212d) {
                    b = m4943c();
                } else {
                    b = m4928C(context);
                }
            }
            if (!TextUtils.isEmpty(b)) {
                return b;
            }
            String d2 = m4945d();
            if (TextUtils.isEmpty(d2)) {
                return m4931F(context);
            }
            return d2;
        } else {
            String string3 = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (!TextUtils.isEmpty(string3)) {
                return string3;
            }
            String d3 = m4945d();
            if (!TextUtils.isEmpty(d3)) {
                return d3;
            }
            String F = m4931F(context);
            if (!TextUtils.isEmpty(F)) {
                return F;
            }
            String b2 = m4940b();
            if (TextUtils.isEmpty(b2)) {
                return m4928C(context);
            }
            return b2;
        }
    }

    /* renamed from: F */
    private static String m4931F(Context context) {
        String str;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        try {
            if (m4938a(context, "android.permission.READ_PHONE_STATE")) {
                str = telephonyManager.getDeviceId();
            } else {
                str = "";
            }
            return str;
        } catch (Throwable th) {
            return "";
        }
    }

    /* renamed from: d */
    private static String m4945d() {
        if (Build.VERSION.SDK_INT >= 9) {
            return Build.SERIAL;
        }
        return "";
    }

    /* renamed from: x */
    public static String m4968x(Context context) {
        Properties e = m4948e();
        try {
            String property = e.getProperty(f3142f);
            if (!TextUtils.isEmpty(property)) {
                return "MIUI";
            }
            if (m4950f()) {
                return "Flyme";
            }
            if (!TextUtils.isEmpty(m4936a(e))) {
                return "YunOS";
            }
            return property;
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: y */
    public static String m4969y(Context context) {
        Properties e = m4948e();
        try {
            String property = e.getProperty(f3142f);
            if (!TextUtils.isEmpty(property)) {
                return property;
            }
            if (m4950f()) {
                try {
                    return m4942b(e);
                } catch (Throwable th) {
                    return property;
                }
            } else {
                try {
                    return m4936a(e);
                } catch (Throwable th2) {
                    return property;
                }
            }
        } catch (Throwable th3) {
            return null;
        }
    }

    /* renamed from: a */
    private static String m4936a(Properties properties) {
        String property = properties.getProperty("ro.yunos.version");
        if (!TextUtils.isEmpty(property)) {
            return property;
        }
        return null;
    }

    /* renamed from: b */
    private static String m4942b(Properties properties) {
        try {
            String lowerCase = properties.getProperty("ro.build.display.id").toLowerCase(Locale.getDefault());
            if (lowerCase.contains("flyme os")) {
                return lowerCase.split(" ")[2];
            }
        } catch (Throwable th) {
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0023 A[SYNTHETIC, Splitter:B:12:0x0023] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002c A[SYNTHETIC, Splitter:B:17:0x002c] */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.Properties m4948e() {
        /*
            java.util.Properties r2 = new java.util.Properties
            r2.<init>()
            r1 = 0
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x001f, all -> 0x0029 }
            java.io.File r3 = new java.io.File     // Catch:{ Throwable -> 0x001f, all -> 0x0029 }
            java.io.File r4 = android.os.Environment.getRootDirectory()     // Catch:{ Throwable -> 0x001f, all -> 0x0029 }
            java.lang.String r5 = "build.prop"
            r3.<init>(r4, r5)     // Catch:{ Throwable -> 0x001f, all -> 0x0029 }
            r0.<init>(r3)     // Catch:{ Throwable -> 0x001f, all -> 0x0029 }
            r2.load(r0)     // Catch:{ Throwable -> 0x0039, all -> 0x0034 }
            if (r0 == 0) goto L_0x001e
            r0.close()     // Catch:{ Throwable -> 0x0030 }
        L_0x001e:
            return r2
        L_0x001f:
            r0 = move-exception
            r0 = r1
        L_0x0021:
            if (r0 == 0) goto L_0x001e
            r0.close()     // Catch:{ Throwable -> 0x0027 }
            goto L_0x001e
        L_0x0027:
            r0 = move-exception
            goto L_0x001e
        L_0x0029:
            r0 = move-exception
        L_0x002a:
            if (r1 == 0) goto L_0x002f
            r1.close()     // Catch:{ Throwable -> 0x0032 }
        L_0x002f:
            throw r0
        L_0x0030:
            r0 = move-exception
            goto L_0x001e
        L_0x0032:
            r1 = move-exception
            goto L_0x002f
        L_0x0034:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x002a
        L_0x0039:
            r1 = move-exception
            goto L_0x0021
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.p085a.C1343e.m4948e():java.util.Properties");
    }

    /* renamed from: f */
    private static boolean m4950f() {
        try {
            Build.class.getMethod("hasSmartBar", new Class[0]);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: z */
    public static String m4970z(Context context) {
        if (context == null) {
            return "Phone";
        }
        if ((context.getResources().getConfiguration().screenLayout & 15) >= 3) {
            return "Tablet";
        }
        return "Phone";
    }

    /* renamed from: A */
    public static String m4926A(Context context) {
        String str;
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null || !m4938a(context, "android.permission.READ_PHONE_STATE")) {
                str = null;
            } else {
                str = telephonyManager.getDeviceId();
            }
            try {
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
                String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                if (!TextUtils.isEmpty(string) || Build.VERSION.SDK_INT < 9) {
                    return string;
                }
                return Build.SERIAL;
            } catch (Throwable th) {
                return str;
            }
        } catch (Throwable th2) {
            return null;
        }
    }
}
