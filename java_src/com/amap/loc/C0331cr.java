package com.amap.loc;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.location.Location;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.Base64;
import com.amap.api.location.AMapLocation;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import org.json.JSONObject;

/* renamed from: com.amap.loc.cr */
/* compiled from: Utils */
public class C0331cr {

    /* renamed from: a */
    private static int f788a = 0;

    /* renamed from: b */
    private static String[] f789b = null;

    /* renamed from: c */
    private static Hashtable<String, Long> f790c = new Hashtable<>();

    /* renamed from: d */
    private static DecimalFormat f791d = null;

    /* renamed from: e */
    private static SimpleDateFormat f792e = null;

    /* renamed from: f */
    private static String[] f793f = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};

    /* renamed from: a */
    public static double m1149a(double d) {
        return ((double) ((long) (d * 1000000.0d))) / 1000000.0d;
    }

    /* renamed from: a */
    public static float m1150a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        return m1151a(new double[]{aMapLocation.getLatitude(), aMapLocation.getLongitude(), aMapLocation2.getLatitude(), aMapLocation2.getLongitude()});
    }

    /* renamed from: a */
    public static float m1151a(double[] dArr) {
        if (dArr.length != 4) {
            return 0.0f;
        }
        float[] fArr = new float[1];
        Location.distanceBetween(dArr[0], dArr[1], dArr[2], dArr[3], fArr);
        return fArr[0];
    }

    /* renamed from: a */
    public static int m1152a(int i) {
        return (i * 2) - 113;
    }

    /* renamed from: a */
    public static int m1153a(int i, int i2) {
        return new Random().nextInt((i2 - i) + 1) + i;
    }

    /* renamed from: a */
    public static int m1154a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return networkInfo.getType();
        }
        return -1;
    }

    /* renamed from: a */
    public static int m1155a(boolean z, CellLocation cellLocation, Context context) {
        if (z || cellLocation == null) {
            return 9;
        }
        if (cellLocation instanceof GsmCellLocation) {
            return 1;
        }
        try {
            Class.forName("android.telephony.cdma.CdmaCellLocation");
            return 2;
        } catch (Throwable th) {
            C0310c.m956a(th, "Utils", "getCellLocT");
            return 9;
        }
    }

    /* renamed from: a */
    public static long m1156a() {
        return System.currentTimeMillis();
    }

    /* renamed from: a */
    public static Object m1157a(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getApplicationContext().getSystemService(str);
        } catch (Throwable th) {
            C0310c.m956a(th, "Utils", "getServ");
            return null;
        }
    }

    /* renamed from: a */
    public static String m1158a(String str, int i) {
        byte[] bArr = null;
        try {
            bArr = str.getBytes("UTF-8");
        } catch (Throwable th) {
            C0310c.m956a(th, "Utils", "str2Base64");
        }
        return Base64.encodeToString(bArr, i);
    }

    /* renamed from: a */
    public static synchronized void m1159a(Context context, int i) {
        synchronized (C0331cr.class) {
            if (context != null) {
                try {
                    C0228ac acVar = new C0228ac(context, C0228ac.m465a((Class<? extends AbstractC0227ab>) C0317cf.class), m1197k());
                    C0313cb cbVar = new C0313cb();
                    cbVar.mo3864a(i);
                    acVar.mo3645a(cbVar, "_id=1");
                } catch (Throwable th) {
                    C0310c.m956a(th, "Utils", "getDBConfigVersion");
                }
            }
        }
        return;
    }

    /* renamed from: a */
    public static synchronized boolean m1160a(long j, long j2) {
        boolean z;
        synchronized (C0331cr.class) {
            z = false;
            if (f792e == null) {
                try {
                    f792e = new SimpleDateFormat("yyyyMMddHH", Locale.CHINA);
                } catch (Throwable th) {
                    C0310c.m956a(th, "Utils", "isSameDay part1");
                }
            } else {
                f792e.applyPattern("yyyyMMddHH");
            }
            try {
                if (f792e != null) {
                    z = f792e.format(Long.valueOf(j)).equals(f792e.format(Long.valueOf(j2)));
                }
            } catch (Throwable th2) {
                C0310c.m956a(th2, "Utils", "isSameHour");
            }
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m1161a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return m1178c() < 17 ? m1182c(context, "android.provider.Settings$System") : m1182c(context, "android.provider.Settings$Global");
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m1162a(ScanResult scanResult) {
        return scanResult != null && !TextUtils.isEmpty(scanResult.BSSID) && !scanResult.BSSID.equals("00:00:00:00:00:00") && !scanResult.BSSID.contains(" :");
    }

    /* renamed from: a */
    public static boolean m1163a(AMapLocation aMapLocation) {
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            return m1176b(aMapLocation);
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m1164a(AMapLocationServer aMapLocationServer) {
        if (aMapLocationServer != null && !aMapLocationServer.mo3963c().equals("8") && !aMapLocationServer.mo3963c().equals("5") && !aMapLocationServer.mo3963c().equals("6")) {
            return m1176b(aMapLocationServer);
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m1165a(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
            return ",111,123,134,199,202,204,206,208,212,213,214,216,218,219,220,222,225,226,228,230,231,232,234,235,238,240,242,244,246,247,248,250,255,257,259,260,262,266,268,270,272,274,276,278,280,282,283,284,286,288,289,290,292,293,294,295,297,302,308,310,311,312,313,314,315,316,310,330,332,334,338,340,342,344,346,348,350,352,354,356,358,360,362,363,364,365,366,368,370,372,374,376,400,401,402,404,405,406,410,412,413,414,415,416,417,418,419,420,421,422,424,425,426,427,428,429,430,431,432,434,436,437,438,440,441,450,452,454,455,456,457,466,467,470,472,502,505,510,514,515,520,525,528,530,534,535,536,537,539,540,541,542,543,544,545,546,547,548,549,550,551,552,553,555,560,598,602,603,604,605,606,607,608,609,610,611,612,613,614,615,616,617,618,619,620,621,622,623,624,625,626,627,628,629,630,631,632,633,634,635,636,637,638,639,640,641,642,643,645,646,647,648,649,650,651,652,653,654,655,657,659,665,702,704,706,708,710,712,714,716,722,724,730,732,734,736,738,740,742,744,746,748,750,850,901,".contains(MiPushClient.ACCEPT_TIME_SEPARATOR + str + MiPushClient.ACCEPT_TIME_SEPARATOR);
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m1166a(JSONObject jSONObject, String str) {
        return C0363r.m1356a(jSONObject, str);
    }

    /* renamed from: a */
    public static byte[] m1167a(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) ((int) ((j >> (i * 8)) & 255));
        }
        return bArr;
    }

    /* renamed from: a */
    public static byte[] m1168a(byte[] bArr) {
        try {
            return C0363r.m1361b(bArr);
        } catch (Throwable th) {
            C0310c.m956a(th, "Utils", "gz");
            return null;
        }
    }

    /* renamed from: a */
    public static String[] m1169a(TelephonyManager telephonyManager) {
        int i;
        String str = null;
        if (telephonyManager != null) {
            str = telephonyManager.getNetworkOperator();
        }
        String[] strArr = {"0", "0"};
        if (TextUtils.isEmpty(str) ? false : !TextUtils.isDigitsOnly(str) ? false : str.length() > 4) {
            strArr[0] = str.substring(0, 3);
            char[] charArray = str.substring(3).toCharArray();
            int i2 = 0;
            while (i2 < charArray.length && Character.isDigit(charArray[i2])) {
                i2++;
            }
            strArr[1] = str.substring(3, i2 + 3);
        }
        try {
            i = Integer.parseInt(strArr[0]);
        } catch (Throwable th) {
            C0310c.m956a(th, "Utils", "getMccMnc");
            i = 0;
        }
        if (i == 0) {
            strArr[0] = "0";
        }
        if (strArr[0].equals("0") || strArr[1].equals("0")) {
            return (!strArr[0].equals("0") || !strArr[1].equals("0") || f789b == null) ? strArr : f789b;
        }
        f789b = strArr;
        return strArr;
    }

    /* renamed from: b */
    public static long m1170b() {
        return SystemClock.elapsedRealtime();
    }

    /* renamed from: b */
    public static String m1171b(Context context) {
        PackageInfo packageInfo;
        CharSequence charSequence = null;
        if (!TextUtils.isEmpty(C0310c.f630f)) {
            return C0310c.f630f;
        }
        if (context == null) {
            return null;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 64);
        } catch (Throwable th) {
            C0310c.m956a(th, "Utils", "getAppName part");
            packageInfo = null;
        }
        try {
            if (TextUtils.isEmpty(C0310c.f631g)) {
                C0310c.f631g = null;
            }
        } catch (Throwable th2) {
            C0310c.m956a(th2, "Utils", "getAppName");
        }
        StringBuilder sb = new StringBuilder();
        if (packageInfo != null) {
            if (packageInfo.applicationInfo != null) {
                charSequence = packageInfo.applicationInfo.loadLabel(context.getPackageManager());
            }
            if (charSequence != null) {
                sb.append(charSequence.toString());
            }
            if (!TextUtils.isEmpty(packageInfo.versionName)) {
                sb.append(packageInfo.versionName);
            }
        }
        String c = C0342i.m1232c(context);
        if (!TextUtils.isEmpty(c)) {
            sb.append(MiPushClient.ACCEPT_TIME_SEPARATOR).append(c);
        }
        if (!TextUtils.isEmpty(C0310c.f631g)) {
            sb.append(MiPushClient.ACCEPT_TIME_SEPARATOR).append(C0310c.f631g);
        }
        String sb2 = sb.toString();
        C0310c.f630f = sb2;
        return sb2;
    }

    /* renamed from: b */
    public static String m1172b(TelephonyManager telephonyManager) {
        int i = 0;
        if (telephonyManager != null) {
            i = telephonyManager.getNetworkType();
        }
        return C0310c.f637m.get(i, "UNKWN");
    }

    /* renamed from: b */
    public static String m1173b(String str) {
        return m1158a(str, 0);
    }

    /* renamed from: b */
    public static synchronized boolean m1174b(long j, long j2) {
        boolean z;
        synchronized (C0331cr.class) {
            z = false;
            if (f792e == null) {
                try {
                    f792e = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
                } catch (Throwable th) {
                    C0310c.m956a(th, "Utils", "isSameDay part1");
                }
            } else {
                f792e.applyPattern("yyyyMMdd");
            }
            try {
                if (f792e != null) {
                    z = f792e.format(Long.valueOf(j)).equals(f792e.format(Long.valueOf(j2)));
                }
            } catch (Throwable th2) {
                C0310c.m956a(th2, "Utils", "isSameDay");
            }
        }
        return z;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean m1175b(android.content.Context r4, java.lang.String r5) {
        /*
            r0 = 0
            java.lang.Class<com.amap.loc.cr> r1 = com.amap.loc.C0331cr.class
            monitor-enter(r1)
            android.content.pm.PackageManager r2 = r4.getPackageManager()     // Catch:{ Throwable -> 0x0015, all -> 0x0012 }
            r3 = 0
            android.content.pm.PackageInfo r2 = r2.getPackageInfo(r5, r3)     // Catch:{ Throwable -> 0x0015, all -> 0x0012 }
            if (r2 == 0) goto L_0x0010
            r0 = 1
        L_0x0010:
            monitor-exit(r1)
            return r0
        L_0x0012:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        L_0x0015:
            r2 = move-exception
            goto L_0x0010
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0331cr.m1175b(android.content.Context, java.lang.String):boolean");
    }

    /* renamed from: b */
    private static boolean m1176b(AMapLocation aMapLocation) {
        double longitude = aMapLocation.getLongitude();
        double latitude = aMapLocation.getLatitude();
        return !(longitude == 0.0d && latitude == 0.0d && ((double) aMapLocation.getAccuracy()) == 0.0d) && longitude <= 180.0d && latitude <= 90.0d && longitude >= -180.0d && latitude >= -90.0d;
    }

    /* renamed from: b */
    public static byte[] m1177b(int i) {
        byte[] bArr = new byte[2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = (byte) ((i >> (i2 * 8)) & 255);
        }
        return bArr;
    }

    /* renamed from: c */
    public static int m1178c() {
        if (f788a > 0) {
            return f788a;
        }
        try {
            return C0325cm.m1114b("android.os.Build$VERSION", "SDK_INT");
        } catch (Throwable th) {
            return 0;
        }
    }

    /* renamed from: c */
    public static NetworkInfo m1179c(Context context) {
        try {
            return C0353l.m1281n(context);
        } catch (Throwable th) {
            C0310c.m956a(th, "Utils", "getNetWorkInfo");
            return null;
        }
    }

    /* renamed from: c */
    public static String m1180c(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        try {
            return new String(Base64.decode(str, 0), "UTF-8");
        } catch (Throwable th) {
            C0310c.m956a(th, "Utils", "base642Str");
            return null;
        }
    }

    /* renamed from: c */
    public static synchronized boolean m1181c(long j, long j2) {
        boolean z = true;
        boolean z2 = false;
        synchronized (C0331cr.class) {
            if (m1174b(j, j2)) {
                Calendar instance = Calendar.getInstance(Locale.CHINA);
                instance.setTimeInMillis(j);
                int i = instance.get(11);
                instance.setTimeInMillis(j2);
                int i2 = instance.get(11);
                if (i <= 12 ? i2 > 12 : i2 <= 12) {
                    z = false;
                }
                z2 = z;
            }
        }
        return z2;
    }

    /* renamed from: c */
    private static boolean m1182c(Context context, String str) throws Throwable {
        return ((Integer) C0325cm.m1112a(str, "getInt", new Object[]{context.getContentResolver(), ((String) C0325cm.m1111a(str, "AIRPLANE_MODE_ON")).toString()}, new Class[]{ContentResolver.class, String.class})).intValue() == 1;
    }

    /* renamed from: c */
    public static byte[] m1183c(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = (byte) ((i >> (i2 * 8)) & 255);
        }
        return bArr;
    }

    /* renamed from: d */
    public static String m1184d() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    /* renamed from: d */
    public static synchronized String m1185d(int i) {
        String str;
        synchronized (C0331cr.class) {
            str = "其他错误";
            switch (i) {
                case 0:
                    str = "success";
                    break;
                case 1:
                    str = "重要参数为空";
                    break;
                case 2:
                    str = "WIFI信息不足";
                    break;
                case 3:
                    str = "请求参数获取出现异常";
                    break;
                case 4:
                    str = "网络连接异常";
                    break;
                case 5:
                    str = "解析数据异常";
                    break;
                case 6:
                    str = "定位结果错误";
                    break;
                case 7:
                    str = "KEY错误";
                    break;
                case 8:
                    str = "其他错误";
                    break;
                case 9:
                    str = "初始化异常";
                    break;
                case 10:
                    str = "定位服务启动失败";
                    break;
                case 11:
                    str = "错误的基站信息，请检查是否插入SIM卡";
                    break;
                case 12:
                    str = "缺少定位权限";
                    break;
                case 13:
                    str = "网络定位失败，请检查设备是否插入sim卡，是否开启移动网络或开启了wifi模块";
                    break;
            }
        }
        return str;
    }

    /* renamed from: d */
    public static boolean m1186d(Context context) {
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                    return runningAppProcessInfo.importance != 100;
                }
            }
            return false;
        } catch (Throwable th) {
            C0310c.m956a(th, "Utils", "isApplicationBroughtToBackground");
            return true;
        }
    }

    /* renamed from: d */
    public static byte[] m1187d(String str) {
        return m1177b(Integer.parseInt(str));
    }

    /* renamed from: e */
    public static synchronized int m1188e(Context context) {
        int i;
        synchronized (C0331cr.class) {
            try {
                List b = new C0228ac(context, C0228ac.m465a((Class<? extends AbstractC0227ab>) C0317cf.class), m1197k()).mo3650b("_id=1", C0313cb.class);
                if (b != null && b.size() > 0) {
                    i = ((C0313cb) b.get(0)).mo3863a();
                }
            } catch (Throwable th) {
                C0310c.m956a(th, "Utils", "getDBConfigVersion");
            }
            i = -1;
        }
        return i;
    }

    /* renamed from: e */
    public static String m1189e() {
        return Build.MODEL;
    }

    /* renamed from: e */
    public static byte[] m1190e(String str) {
        return m1183c(Integer.parseInt(str));
    }

    /* renamed from: f */
    public static String m1191f() {
        return Build.VERSION.RELEASE;
    }

    /* renamed from: f */
    public static synchronized boolean m1192f(Context context) {
        int i;
        boolean z = false;
        synchronized (C0331cr.class) {
            if (Build.VERSION.SDK_INT >= 23 && context.getApplicationInfo().targetSdkVersion >= 23) {
                Application application = (Application) context;
                String[] strArr = f793f;
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    try {
                        i = C0325cm.m1113b(application.getBaseContext(), "checkSelfPermission", strArr[i2]);
                    } catch (Throwable th) {
                        i = 0;
                    }
                    if (i != 0) {
                        break;
                    }
                    i2++;
                }
            } else {
                String[] strArr2 = f793f;
                int length2 = strArr2.length;
                int i3 = 0;
                while (true) {
                    if (i3 < length2) {
                        if (context.checkCallingOrSelfPermission(strArr2[i3]) != 0) {
                            break;
                        }
                        i3++;
                    } else {
                        break;
                    }
                }
                z = true;
            }
        }
        return z;
    }

    /* renamed from: g */
    public static boolean m1193g() {
        return m1153a(0, 1) == 1;
    }

    /* renamed from: h */
    public static void m1194h() {
        f790c.clear();
    }

    /* renamed from: i */
    public static String m1195i() {
        try {
            return C0355m.m1295a("S128DF1572465B890OE3F7A13167KLEI".getBytes("UTF-8")).substring(20);
        } catch (Throwable th) {
            return "";
        }
    }

    /* renamed from: j */
    public static boolean m1196j() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    /* renamed from: k */
    public static String m1197k() {
        if (!m1196j()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(m1184d()).append(File.separator);
        sb.append("amap").append(File.separator);
        sb.append("openamaplocationsdk").append(File.separator);
        return sb.toString();
    }
}
