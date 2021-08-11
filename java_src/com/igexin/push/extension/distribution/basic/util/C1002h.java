package com.igexin.push.extension.distribution.basic.util;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import java.math.BigInteger;
import java.security.MessageDigest;

/* renamed from: com.igexin.push.extension.distribution.basic.util.h */
public class C1002h {
    /* renamed from: a */
    public static String m4030a(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            return "cantgetimei";
        }
    }

    /* renamed from: a */
    public static String m4031a(String str) {
        if (str != null && !"".equals(str)) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(str.getBytes());
                str = new BigInteger(1, instance.digest()).toString(16);
                while (str.length() < 32) {
                    str = "0" + str;
                }
            } catch (Exception e) {
            }
        }
        return str;
    }

    /* renamed from: b */
    public static String m4032b(Context context) {
        WifiInfo connectionInfo;
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            return (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) ? "" : connectionInfo.getMacAddress();
        } catch (Exception e) {
            return "";
        }
    }

    /* renamed from: c */
    public static String m4033c(Context context) {
        return m4031a(m4032b(context));
    }

    /* renamed from: d */
    public static String m4034d(Context context) {
        return m4031a(m4030a(context));
    }
}
