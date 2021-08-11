package com.wanmei.sdk.core.log.p105a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.support.p007v4.p009os.EnvironmentCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.qcloud.core.util.IOUtils;
import java.io.File;

/* renamed from: com.wanmei.sdk.core.log.a.a */
public final class C1760a {

    /* renamed from: a */
    private static String f4446a = "";

    /* renamed from: a */
    public static File m6480a(Context context, String str) {
        if (!m6482a()) {
            return null;
        }
        File file = new File(new File(Environment.getExternalStorageDirectory(), m6488e(context)), str);
        if (file.exists()) {
            return file;
        }
        file.mkdirs();
        return file;
    }

    /* renamed from: a */
    public static String m6481a(Context context) {
        NetworkInfo activeNetworkInfo;
        StringBuilder sb = new StringBuilder();
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append("#-------system info-------");
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append("version-name:");
        sb.append(m6487d(context));
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append("version-code:");
        sb.append(m6485c(context));
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append("system-version:");
        sb.append(Build.VERSION.RELEASE);
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append("model:");
        sb.append(m6486c());
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append("imei:");
        sb.append(((TelephonyManager) context.getSystemService("phone")).getDeviceId());
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append("mac:");
        sb.append(m6484b(context));
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append("CPU_ABI:");
        sb.append(Build.CPU_ABI);
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append("CPU_ABI2:");
        sb.append(Build.CPU_ABI2);
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append("mobile:");
        sb.append(((TelephonyManager) context.getSystemService("phone")).getLine1Number());
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append("imsi:");
        sb.append(((TelephonyManager) context.getSystemService("phone")).getSubscriberId());
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append("isWifi:");
        sb.append((context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || activeNetworkInfo.getType() != 1) ? false : true);
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        return sb.toString();
    }

    /* renamed from: a */
    public static boolean m6482a() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    /* renamed from: b */
    public static String m6483b() {
        return Build.VERSION.RELEASE;
    }

    /* renamed from: b */
    public static String m6484b(Context context) {
        if (context == null) {
            return null;
        }
        return ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
    }

    /* renamed from: c */
    public static int m6485c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 1;
        }
    }

    /* renamed from: c */
    public static String m6486c() {
        return Build.MODEL != null ? Build.MODEL.replace(" ", "") : EnvironmentCompat.MEDIA_UNKNOWN;
    }

    /* renamed from: d */
    private static String m6487d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: e */
    private static String m6488e(Context context) {
        if (TextUtils.isEmpty(f4446a)) {
            f4446a = "com.pwrd.onesdk";
            try {
                String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).packageName;
                if (!TextUtils.isEmpty(str)) {
                    f4446a = str;
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return f4446a;
    }
}
