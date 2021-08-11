package com.wanmei.sdk.core.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.p007v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/* renamed from: com.wanmei.sdk.core.util.b */
public class C1841b {

    /* renamed from: a */
    private static final String f4587a = C1841b.class.getName();

    /* renamed from: a */
    public static String m6681a() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                            return nextElement.getHostAddress().toString();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "null";
    }

    /* renamed from: a */
    public static String m6682a(Context context) {
        boolean z;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return null;
        }
        if (activeNetworkInfo.getType() == 0) {
            switch (activeNetworkInfo.getType()) {
                case 0:
                    z = false;
                    break;
                case 1:
                    z = false;
                    break;
                case 2:
                    z = false;
                    break;
                case 3:
                    z = true;
                    break;
                case 4:
                    z = false;
                    break;
                case 5:
                    z = true;
                    break;
                case 6:
                    z = true;
                    break;
                case 7:
                    z = false;
                    break;
                case 8:
                    z = true;
                    break;
                case 9:
                    z = true;
                    break;
                case 10:
                    z = true;
                    break;
                case 11:
                    z = false;
                    break;
                case 12:
                    z = true;
                    break;
                case 13:
                    z = true;
                    break;
                case 14:
                    z = true;
                    break;
                case 15:
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            return z ? "3g" : "2g";
        } else if (activeNetworkInfo.getType() == 1) {
            return "wifi";
        } else {
            return null;
        }
    }

    /* renamed from: b */
    public static String m6683b() {
        IOException e;
        long j;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 10000);
            j = Long.valueOf(bufferedReader.readLine().split("\\s+")[1]).longValue() * PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            try {
                bufferedReader.close();
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                return String.valueOf(j);
            }
        } catch (IOException e3) {
            j = 0;
            e = e3;
            e.printStackTrace();
            return String.valueOf(j);
        }
        return String.valueOf(j);
    }

    /* renamed from: b */
    public static String m6684b(Context context) {
        String subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        if (subscriberId != null) {
            if (subscriberId.startsWith("46000") || subscriberId.startsWith("46002")) {
                return "cm";
            }
            if (subscriberId.startsWith("46001")) {
                return "cu";
            }
            if (subscriberId.startsWith("46003")) {
                return "ct";
            }
        }
        return null;
    }

    /* renamed from: c */
    public static String m6685c(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
    }
}
