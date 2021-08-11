package com.igexin.push.extension.distribution.gbd.p076i;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.support.p007v4.media.session.PlaybackStateCompat;
import android.support.p007v4.p009os.EnvironmentCompat;
import android.support.p007v4.view.ViewCompat;
import android.text.TextUtils;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.push.extension.distribution.gbd.p066b.C1065h;
import com.igexin.push.extension.distribution.gbd.p067c.C1067a;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.igexin.push.extension.distribution.gbd.i.e */
public class C1116e {

    /* renamed from: a */
    private static String f2975a = "eth0";

    /* renamed from: a */
    public static long m4560a(long j, int i) {
        int i2 = 32 - i;
        return i < 31 ? ((j >> i2) << i2) + 1 : (j >> i2) << i2;
    }

    /* renamed from: a */
    public static long m4561a(long j, long j2, long j3) {
        String[] split = m4564a(j).split("\\.");
        split[2] = String.valueOf(j2);
        split[3] = String.valueOf(j3);
        return m4575b(split[0] + "." + split[1] + "." + split[2] + "." + split[3]);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003c A[SYNTHETIC, Splitter:B:21:0x003c] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0050 A[SYNTHETIC, Splitter:B:31:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0055  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m4562a() {
        /*
        // Method dump skipped, instructions count: 104
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.gbd.p076i.C1116e.m4562a():java.lang.String");
    }

    /* renamed from: a */
    public static String m4563a(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    /* renamed from: a */
    public static String m4564a(long j) {
        StringBuilder sb = new StringBuilder();
        for (int i = 3; i > -1; i--) {
            sb.append((j >> (i * 8)) & 255).append(".");
        }
        return sb.substring(0, sb.length() - 1);
    }

    /* renamed from: a */
    public static String m4565a(Context context, int i) {
        StringBuilder sb;
        File[] listFiles;
        StringBuilder sb2 = new StringBuilder();
        try {
            for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(i)) {
                try {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(packageInfo.packageName, 128);
                    if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                        Bundle bundle = applicationInfo.metaData;
                        String str = (String) (bundle.get(AssistPushConsts.GETUI_APPID) == null ? "" : bundle.get(AssistPushConsts.GETUI_APPID));
                        String str2 = (String) (bundle.get(AssistPushConsts.GETUI_APPKEY) == null ? "" : bundle.get(AssistPushConsts.GETUI_APPKEY));
                        String str3 = (String) (bundle.get(AssistPushConsts.GETUI_APPSECRET) == null ? "" : bundle.get(AssistPushConsts.GETUI_APPSECRET));
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                            sb2.append(packageInfo.packageName);
                            sb2.append("|");
                        }
                    }
                } catch (Throwable th) {
                    C1115d.m4558a(th);
                }
            }
            File file = new File("/sdcard/libs/");
            if (file.exists() && (listFiles = file.listFiles(new C1117f())) != null) {
                for (File file2 : listFiles) {
                    File[] listFiles2 = file2.listFiles(new C1120i());
                    if (listFiles2 != null) {
                        for (File file3 : listFiles2) {
                            String name = file3.getName();
                            if (!TextUtils.isEmpty(name) && name.contains(".bin")) {
                                sb2.append(name.substring(0, name.lastIndexOf(".")));
                                sb2.append("|");
                            }
                        }
                    }
                }
            }
            if (!TextUtils.isEmpty(sb2.toString()) && sb2.toString().endsWith("|")) {
                sb = sb2.deleteCharAt(sb2.length() - 1);
                return sb.toString();
            }
        } catch (Throwable th2) {
            C1115d.m4558a(th2);
        }
        sb = sb2;
        return sb.toString();
    }

    /* renamed from: a */
    public static String m4566a(PackageInfo packageInfo) {
        int i = packageInfo.applicationInfo.uid;
        String str = TrafficStats.getUidTxBytes(i) + "";
        String str2 = TrafficStats.getUidRxBytes(i) + "";
        if (str.equals("-1")) {
            str = m4590d("cat  /proc/uid_stat/" + i + "/tcp_rcv");
        }
        if (str2.equals("-1")) {
            str2 = m4590d("cat  /proc/uid_stat/" + i + "/tcp_snd");
        }
        return str + "&" + str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x001c A[Catch:{ Exception -> 0x003b }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m4567a(java.lang.String r4, android.content.Context r5) {
        /*
            android.content.pm.PackageManager r0 = r5.getPackageManager()     // Catch:{ Exception -> 0x003b }
            r1 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r4, r1)     // Catch:{ Exception -> 0x003b }
            android.os.Bundle r1 = r0.metaData     // Catch:{ Exception -> 0x003b }
            if (r1 == 0) goto L_0x003f
            java.util.Set r0 = r1.keySet()     // Catch:{ Exception -> 0x003b }
            java.util.Iterator r2 = r0.iterator()     // Catch:{ Exception -> 0x003b }
        L_0x0016:
            boolean r0 = r2.hasNext()     // Catch:{ Exception -> 0x003b }
            if (r0 == 0) goto L_0x003f
            java.lang.Object r0 = r2.next()     // Catch:{ Exception -> 0x003b }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x003b }
            java.lang.String r3 = "PUSH_APPID"
            boolean r3 = r0.equals(r3)     // Catch:{ Exception -> 0x003b }
            if (r3 != 0) goto L_0x0032
            java.lang.String r3 = "appid"
            boolean r3 = r0.equals(r3)     // Catch:{ Exception -> 0x003b }
            if (r3 == 0) goto L_0x0016
        L_0x0032:
            java.lang.Object r0 = r1.get(r0)     // Catch:{ Exception -> 0x003b }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x003b }
        L_0x003a:
            return r0
        L_0x003b:
            r0 = move-exception
            com.igexin.push.extension.distribution.gbd.p076i.C1115d.m4558a(r0)
        L_0x003f:
            java.lang.String r0 = ""
            goto L_0x003a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.gbd.p076i.C1116e.m4567a(java.lang.String, android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x007f A[SYNTHETIC, Splitter:B:38:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0084 A[SYNTHETIC, Splitter:B:41:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0099 A[SYNTHETIC, Splitter:B:50:0x0099] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x009e A[SYNTHETIC, Splitter:B:53:0x009e] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m4568a(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 184
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.gbd.p076i.C1116e.m4568a(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static boolean m4569a(Context context) {
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            if ((memoryInfo.availMem / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID < ((long) C1067a.f2751B)) {
                return false;
            }
            return (((Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory()) + Runtime.getRuntime().freeMemory()) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID > ((long) C1067a.f2752C);
        } catch (Throwable th) {
            C1115d.m4558a(th);
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m4570a(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            C1115d.m4558a(th);
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m4571a(Intent intent, Context context) {
        if (intent == null || context == null) {
            return false;
        }
        try {
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
            return queryIntentServices != null && queryIntentServices.size() > 0;
        } catch (Throwable th) {
            C1115d.m4558a(th);
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m4572a(String str) {
        return Pattern.compile("^(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])$").matcher(str).matches();
    }

    /* renamed from: a */
    public static boolean m4573a(String str, String str2, List<ActivityManager.RunningServiceInfo> list) {
        boolean z;
        if (list == null) {
            return false;
        }
        try {
            if (list.size() <= 0) {
                return false;
            }
            int i = 0;
            while (true) {
                if (i < list.size()) {
                    if (list.get(i).service.getClassName().equals(str) && list.get(i).service.getPackageName().equals(str2)) {
                        z = true;
                        break;
                    }
                    i++;
                } else {
                    z = false;
                    break;
                }
            }
            return z;
        } catch (Throwable th) {
            C1115d.m4558a(th);
            return false;
        }
    }

    /* renamed from: b */
    public static long m4574b(long j, int i) {
        int i2 = 32 - i;
        return i < 31 ? (((long) ((1 << i2) - 1)) | j) - 1 : ((long) ((1 << i2) - 1)) | j;
    }

    /* renamed from: b */
    public static long m4575b(String str) {
        String[] split = str.split("\\.");
        return (long) (Integer.parseInt(split[3]) + (Integer.parseInt(split[0]) * ViewCompat.MEASURED_STATE_TOO_SMALL) + (Integer.parseInt(split[1]) * 65536) + (Integer.parseInt(split[2]) * 256));
    }

    /* renamed from: b */
    public static C1065h m4576b(Context context) {
        C1065h hVar = new C1065h();
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            hVar.mo5780b(connectionInfo.getMacAddress());
            hVar.mo5782c(connectionInfo.getSSID());
            hVar.mo5778a(connectionInfo.getBSSID());
            DhcpInfo dhcpInfo = wifiManager.getDhcpInfo();
            hVar.mo5784d(m4563a(dhcpInfo.gateway));
            hVar.mo5786e(m4563a(dhcpInfo.ipAddress));
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    if ("wlan0".equalsIgnoreCase(nextElement.getName())) {
                        byte[] bArr = new byte[0];
                        byte[] hardwareAddress = nextElement.getHardwareAddress();
                        if (!(hardwareAddress == null || hardwareAddress.length == 0)) {
                            StringBuilder sb = new StringBuilder();
                            int length = hardwareAddress.length;
                            for (int i = 0; i < length; i++) {
                                sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                            }
                            if (sb.length() > 0) {
                                sb.deleteCharAt(sb.length() - 1);
                            }
                            hVar.mo5780b(sb.toString());
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            C1115d.m4558a(th2);
        }
        return hVar;
    }

    /* renamed from: b */
    public static String m4577b(String str, Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(str, 128).metaData;
            StringBuilder sb = new StringBuilder();
            if (bundle != null) {
                Set<String> keySet = bundle.keySet();
                if (keySet != null && keySet.size() > 0) {
                    for (String str2 : keySet) {
                        sb.append(str2).append(SimpleComparison.EQUAL_TO_OPERATION).append(URLEncoder.encode(String.valueOf(bundle.get(str2)), "UTF-8")).append("&");
                    }
                    if (sb.toString().endsWith("&")) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }
                return sb.toString();
            }
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
        return "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0076 A[SYNTHETIC, Splitter:B:35:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x007b A[SYNTHETIC, Splitter:B:38:0x007b] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008e A[SYNTHETIC, Splitter:B:47:0x008e] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0093 A[SYNTHETIC, Splitter:B:50:0x0093] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.HashMap<java.lang.String, java.lang.String> m4578b(int r9) {
        /*
        // Method dump skipped, instructions count: 179
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.gbd.p076i.C1116e.m4578b(int):java.util.HashMap");
    }

    /* renamed from: b */
    public static boolean m4579b() {
        try {
            Class.forName("com.igexin.push.util.EncryptUtils");
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m4580b(Context context, String str) {
        try {
            for (String str2 : context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions) {
                if (str2.equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            C1115d.m4558a(th);
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m4581b(Intent intent, Context context) {
        if (intent == null || context == null) {
            return false;
        }
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
            return queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0;
        } catch (Throwable th) {
            C1115d.m4558a(th);
            return false;
        }
    }

    /* renamed from: c */
    public static long m4582c(long j, int i) {
        return (j >> (i * 8)) & 255;
    }

    /* renamed from: c */
    public static boolean m4583c() {
        try {
            return ((Boolean) Class.forName("com.igexin.push.util.EncryptUtils").getMethod("isLoadSuccess", new Class[0]).invoke(null, new Object[0])).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: c */
    public static boolean m4584c(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isScreenOn();
        } catch (Throwable th) {
            C1115d.m4558a(th);
            return false;
        }
    }

    /* renamed from: c */
    public static boolean m4585c(Intent intent, Context context) {
        if (intent == null || context == null) {
            return false;
        }
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            return queryIntentActivities != null && queryIntentActivities.size() > 0;
        } catch (Throwable th) {
            C1115d.m4558a(th);
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
        if (r3 == null) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0054, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0055, code lost:
        com.igexin.push.extension.distribution.gbd.p076i.C1115d.m4558a(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005f, code lost:
        com.igexin.push.extension.distribution.gbd.p076i.C1115d.m4558a(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        r1.destroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00a0, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00a1, code lost:
        com.igexin.push.extension.distribution.gbd.p076i.C1115d.m4558a(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00a5, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00a6, code lost:
        com.igexin.push.extension.distribution.gbd.p076i.C1115d.m4558a(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00ac, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00ad, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006a A[SYNTHETIC, Splitter:B:32:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006f A[SYNTHETIC, Splitter:B:35:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0097 A[SYNTHETIC, Splitter:B:55:0x0097] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x009c A[SYNTHETIC, Splitter:B:58:0x009c] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ac A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x002e] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m4586c(java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 180
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.gbd.p076i.C1116e.m4586c(java.lang.String):boolean");
    }

    /* renamed from: c */
    public static boolean m4587c(String str, Context context) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (Throwable th) {
            C1115d.m4558a(th);
            return false;
        }
    }

    /* renamed from: d */
    public static PackageInfo m4588d(String str, Context context) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (Throwable th) {
            C1115d.m4558a(th);
            return null;
        }
    }

    /* renamed from: d */
    public static String m4589d() {
        Exception exc;
        String str;
        String str2 = "";
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                try {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    str2 = str2;
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        String hostAddress = nextElement.getHostAddress();
                        str2 = (nextElement.isLoopbackAddress() || !m4572a(hostAddress)) ? str2 : hostAddress;
                    }
                } catch (Exception e) {
                    str = str2;
                    exc = e;
                    C1115d.m4558a(exc);
                    return str;
                }
            }
            return str2;
        } catch (Exception e2) {
            exc = e2;
            str = str2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x003f A[SYNTHETIC, Splitter:B:24:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0044 A[SYNTHETIC, Splitter:B:27:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0058 A[SYNTHETIC, Splitter:B:37:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x005d A[SYNTHETIC, Splitter:B:40:0x005d] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m4590d(java.lang.String r5) {
        /*
        // Method dump skipped, instructions count: 117
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.gbd.p076i.C1116e.m4590d(java.lang.String):java.lang.String");
    }

    /* renamed from: d */
    public static boolean m4591d(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    /* renamed from: e */
    public static int m4592e() {
        try {
            String a = m4568a("/system/xbin/ip", String.format(" -f inet addr show %s", f2975a), String.format("\\s*inet [0-9\\.]+\\/([0-9]+) brd [0-9\\.]+ scope global %s$", f2975a));
            if (a != null) {
                return Integer.parseInt(a);
            }
            String a2 = m4568a("/system/xbin/ip", String.format(" -f inet addr show %s", f2975a), String.format("\\s*inet [0-9\\.]+ peer [0-9\\.]+\\/([0-9]+) scope global %s$", f2975a));
            if (a2 != null) {
                return Integer.parseInt(a2);
            }
            String a3 = m4568a("/system/bin/ifconfig", " " + f2975a, String.format("^%s: ip [0-9\\.]+ mask ([0-9\\.]+) flags.*", f2975a));
            if (a3 == null) {
                return 24;
            }
            double d = -2.0d;
            for (String str : a3.split("\\.")) {
                d += 256.0d - Double.parseDouble(str);
            }
            return 32 - ((int) (Math.log(d) / Math.log(2.0d)));
        } catch (Exception e) {
            C1115d.m4558a(e);
            return 24;
        }
    }

    /* renamed from: e */
    public static PackageInfo m4593e(String str, Context context) {
        try {
            return context.getPackageManager().getPackageInfo(str, 4);
        } catch (Throwable th) {
            C1115d.m4558a(th);
            return null;
        }
    }

    /* renamed from: e */
    public static String m4594e(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
            C1115d.m4558a(e);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002d A[SYNTHETIC, Splitter:B:16:0x002d] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0032 A[SYNTHETIC, Splitter:B:19:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x005f A[SYNTHETIC, Splitter:B:39:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0064 A[SYNTHETIC, Splitter:B:42:0x0064] */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] m4595e(java.lang.String r6) {
        /*
        // Method dump skipped, instructions count: 127
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.gbd.p076i.C1116e.m4595e(java.lang.String):byte[]");
    }

    /* renamed from: f */
    public static String m4596f(Context context) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            ServiceConnectionC1118g gVar = new ServiceConnectionC1118g();
            if (context.bindService(intent, gVar, 1)) {
                try {
                    String a = new C1119h(gVar.mo5878a()).mo5881a();
                    context.unbindService(gVar);
                    return a;
                } catch (Exception e) {
                    throw e;
                } catch (Throwable th) {
                    context.unbindService(gVar);
                    throw th;
                }
            } else {
                throw new IOException("Google Play connection failed");
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0073 A[SYNTHETIC, Splitter:B:25:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0078 A[SYNTHETIC, Splitter:B:28:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00e3 A[SYNTHETIC, Splitter:B:67:0x00e3] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00e8 A[SYNTHETIC, Splitter:B:70:0x00e8] */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m4597f(java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 260
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.gbd.p076i.C1116e.m4597f(java.lang.String):java.lang.String");
    }

    /* renamed from: f */
    public static String m4598f(String str, Context context) {
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(C1067a.f2772W)) {
            String[] split = C1067a.f2772W.split(MiPushClient.ACCEPT_TIME_SEPARATOR);
            for (String str2 : split) {
                try {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
                    if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                        String str3 = (String) applicationInfo.metaData.get(str2);
                        if (!TextUtils.isEmpty(str3)) {
                            sb2.append(str2).append(SimpleComparison.EQUAL_TO_OPERATION).append(str3);
                            sb2.append("&");
                        }
                    }
                } catch (Throwable th) {
                    C1115d.m4558a(th);
                }
            }
            if (sb2.length() > 0 && sb2.toString().endsWith("&")) {
                sb = sb2.deleteCharAt(sb2.length() - 1);
                return sb.toString();
            }
        }
        sb = sb2;
        return sb.toString();
    }

    /* renamed from: f */
    public static boolean m4599f() {
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            return defaultAdapter != null && defaultAdapter.isEnabled();
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0061 A[SYNTHETIC, Splitter:B:25:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0066 A[SYNTHETIC, Splitter:B:28:0x0066] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008f A[SYNTHETIC, Splitter:B:48:0x008f] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0094 A[SYNTHETIC, Splitter:B:51:0x0094] */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<java.lang.Long> m4600g() {
        /*
        // Method dump skipped, instructions count: 179
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.gbd.p076i.C1116e.m4600g():java.util.ArrayList");
    }

    /* renamed from: g */
    public static boolean m4601g(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            return wifiManager != null && wifiManager.isWifiEnabled();
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
    }

    /* renamed from: h */
    public static boolean m4602h() {
        return m4611o() || m4612p() || m4613q();
    }

    /* renamed from: h */
    public static boolean m4603h(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "auto_time", 1) == 1;
    }

    /* renamed from: i */
    public static int m4604i(Context context) {
        if (Build.VERSION.SDK_INT < 19) {
            return -1;
        }
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String packageName = context.getApplicationContext().getPackageName();
        int i = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            return ((Integer) cls.getMethod("checkOpNoThrow", new Class[]{Integer.TYPE, Integer.TYPE, String.class}).invoke(appOpsManager, new Object[]{Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName})).intValue() == 0 ? 1 : 0;
        } catch (Throwable th) {
            C1115d.m4558a(th);
            return 0;
        }
    }

    /* renamed from: i */
    public static String m4605i() {
        try {
            String str = Build.BRAND;
            return (TextUtils.isEmpty(str) || str.equals(EnvironmentCompat.MEDIA_UNKNOWN)) ? Build.MANUFACTURER : str;
        } catch (Throwable th) {
            C1115d.m4558a(th);
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x01c0 A[SYNTHETIC, Splitter:B:102:0x01c0] */
    /* JADX WARNING: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01b1 A[SYNTHETIC, Splitter:B:95:0x01b1] */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m4606j() {
        /*
        // Method dump skipped, instructions count: 476
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.gbd.p076i.C1116e.m4606j():java.lang.String");
    }

    /* renamed from: k */
    public static long m4607k() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            return !m4603h(C1069c.f2824a) ? currentTimeMillis + C1069c.f2823E : currentTimeMillis;
        } catch (Throwable th) {
            C1115d.m4558a(th);
            return currentTimeMillis;
        }
    }

    /* renamed from: l */
    public static List<String> m4608l() {
        ArrayList arrayList = new ArrayList();
        try {
            String externalStorageState = Environment.getExternalStorageState();
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageState.equals("mounted") && externalStorageDirectory.exists() && externalStorageDirectory.isDirectory()) {
                arrayList.add(externalStorageDirectory.getAbsolutePath());
                C1115d.m4559b("getSDCardPathList", "primary sdcard path: " + externalStorageDirectory.getAbsolutePath());
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("mount").getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if ((readLine.contains("fat") || readLine.contains("fuse") || readLine.contains("storage")) && !readLine.contains("secure") && !readLine.contains("asec") && !readLine.contains("firmware") && !readLine.contains("tmpfs") && !readLine.contains("block") && !readLine.contains("shell") && !readLine.contains("obb") && !readLine.contains("data")) {
                    String[] split = readLine.split(" ");
                    if (split.length >= 3) {
                        for (int i = 1; i <= 2; i++) {
                            String str = split[i];
                            if (str.contains(MqttTopic.TOPIC_LEVEL_SEPARATOR) && !str.contains("data") && !str.contains("Data") && !str.contains("emulated")) {
                                File file = new File(str);
                                if (file.exists() && file.isDirectory() && !str.equals(externalStorageDirectory.getAbsolutePath()) && new StatFs(str).getBlockCount() != 0) {
                                    arrayList.add(str);
                                    C1115d.m4559b("getSDCardPathList", "tf sdcard path: " + str);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
        return arrayList;
    }

    /* renamed from: m */
    public static LinkedHashMap<Long, Long> m4609m() {
        long blockSize;
        long blockCount;
        long availableBlocks;
        List<String> l = m4608l();
        LinkedHashMap<Long, Long> linkedHashMap = new LinkedHashMap<>();
        if (l == null || l.isEmpty()) {
            return linkedHashMap;
        }
        for (String str : l) {
            try {
                StatFs statFs = new StatFs(str);
                if (Build.VERSION.SDK_INT >= 18) {
                    blockSize = statFs.getBlockSizeLong();
                    blockCount = statFs.getBlockCountLong();
                    availableBlocks = statFs.getAvailableBlocksLong();
                } else {
                    blockSize = (long) statFs.getBlockSize();
                    blockCount = (long) statFs.getBlockCount();
                    availableBlocks = (long) statFs.getAvailableBlocks();
                }
                long j = ((blockSize * blockCount) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                long j2 = ((blockSize * availableBlocks) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                linkedHashMap.put(Long.valueOf(j), Long.valueOf(j2));
                C1115d.m4559b("sd storage", "blockSize = " + blockSize + ", totalBlockCnt = " + blockCount + ", totalSize = " + j + " MB");
                C1115d.m4559b("sd storage", "available blockCnt = " + availableBlocks + ", availableSize  = " + j2 + " MB");
            } catch (Throwable th) {
                C1115d.m4558a(th);
            }
        }
        return linkedHashMap;
    }

    /* renamed from: n */
    public static String m4610n() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, "ro.serialno");
        } catch (Throwable th) {
            C1115d.m4558a(th);
            return null;
        }
    }

    /* renamed from: o */
    private static boolean m4611o() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    /* renamed from: p */
    private static boolean m4612p() {
        for (String str : new String[]{"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su"}) {
            if (new File(str).exists()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x005f A[SYNTHETIC, Splitter:B:32:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0064 A[SYNTHETIC, Splitter:B:35:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0077 A[SYNTHETIC, Splitter:B:45:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x007c A[SYNTHETIC, Splitter:B:48:0x007c] */
    /* renamed from: q */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m4613q() {
        /*
        // Method dump skipped, instructions count: 151
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.gbd.p076i.C1116e.m4613q():boolean");
    }
}
