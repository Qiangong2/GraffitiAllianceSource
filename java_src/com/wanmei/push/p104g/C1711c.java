package com.wanmei.push.p104g;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.wanmei.push.p100d.C1679c;
import java.math.BigInteger;
import java.security.SecureRandom;

/* renamed from: com.wanmei.push.g.c */
public final class C1711c {
    /* renamed from: a */
    public static String m6371a(Context context) {
        String str;
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (string == null || string.equals("9774d56d682e549c") || string.length() < 15) {
            C1679c.m6277a();
            if (TextUtils.isEmpty(C1679c.m6287d(context))) {
                String bigInteger = new BigInteger(64, new SecureRandom()).toString(16);
                C1679c.m6277a();
                C1679c.m6281a(context, bigInteger);
            }
            C1679c.m6277a();
            str = C1679c.m6287d(context);
        } else {
            str = string;
        }
        String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        String lowerCase = (TextUtils.isEmpty(deviceId) || deviceId.equals("000000000000000") || deviceId.equals("0")) ? "" : deviceId.toLowerCase();
        C1679c.m6277a();
        String e = C1679c.m6289e(context);
        if (TextUtils.isEmpty(e)) {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null) {
                e = "";
            } else {
                String macAddress = wifiManager.getConnectionInfo().getMacAddress();
                if (TextUtils.isEmpty(macAddress)) {
                    e = "";
                } else {
                    e = macAddress.replace(":", "").toUpperCase();
                    C1679c.m6277a();
                    C1679c.m6284b(context, e);
                }
            }
        }
        C1714f.m6379a("PERFECT_PUSH", "androidId = " + str + "   deviceId=" + lowerCase + "   mac=" + e);
        return C1715g.m6384a(str + lowerCase + e);
    }
}
