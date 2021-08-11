package com.igexin.push.config;

import android.text.TextUtils;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.C0618g;
import java.util.ArrayList;

public class SDKUrlConfig {
    public static String[] AMP_ADDRESS_IPS = {"http://sdk.open.amp.igexin.com/api.htm"};
    public static String[] BI_ADDRESS_IPS = {"http://sdk.open.phone.igexin.com/api.php"};
    public static String[] CONFIG_ADDRESS_IPS = {"http://c-hzgt2.getui.com/api.php"};
    public static String[] INC_ADDRESS_IPS = {"http://sdk.open.inc2.igexin.com/api.php"};
    public static String[] LBS_ADDRESS_IPS = {"http://sdk.open.lbs.igexin.com/api.htm"};
    public static String[] LOG_ADDRESS_IPS = {"http://d.gt.igexin.com/api.htm"};
    public static String[] STATE_ADDRESS_IPS = {"http://s-gt.getui.com/api.php"};
    public static String[] XFR_ADDRESS_BAK = {"socket://42.62.120.14:5224"};

    /* renamed from: a */
    private static final Object f1277a = new Object();

    /* renamed from: b */
    private static String[] f1278b;

    /* renamed from: c */
    private static String f1279c = "HZ";

    /* renamed from: d */
    private static String[] f1280d = {"socket://sdk.open.talk.igexin.com:5224", "socket://sdk.open.talk.getui.net:5224", "socket://sdk.open.talk.gepush.com:5224"};

    /* renamed from: e */
    private static volatile String f1281e;

    public static String getAmpServiceUrl() {
        return AMP_ADDRESS_IPS[0] + "?format=json&t=1";
    }

    public static String getBiUploadServiceUrl() {
        return BI_ADDRESS_IPS[0] + "?format=json&t=1";
    }

    public static String getCmAddress() {
        return f1281e == null ? f1280d[0] : f1281e;
    }

    public static String getConfigServiceUrl() {
        return CONFIG_ADDRESS_IPS[0] + "?format=json&t=1";
    }

    public static String[] getIdcConfigUrl() {
        return f1278b;
    }

    public static String getIncreaseServiceUrl() {
        return INC_ADDRESS_IPS[0] + "?format=json&t=1";
    }

    public static String getLbsServiceUrl() {
        return LBS_ADDRESS_IPS[0] + "?format=json&t=1";
    }

    public static String getLocation() {
        return f1279c;
    }

    public static String getLogServiceUrl() {
        return LOG_ADDRESS_IPS[0] + "?format=json&t=1";
    }

    public static String getStatServiceUrl() {
        return STATE_ADDRESS_IPS[0] + "?format=json&t=1";
    }

    public static String[] getXfrAddress() {
        String[] strArr;
        synchronized (f1277a) {
            strArr = f1280d;
        }
        return strArr;
    }

    public static boolean realXfrListIsOnly() {
        String[] xfrAddress = getXfrAddress();
        ArrayList arrayList = new ArrayList();
        for (String str : xfrAddress) {
            if (!arrayList.contains(str)) {
                arrayList.add(str);
            }
        }
        return arrayList.size() == 1;
    }

    public static void setCmAddress(String str) {
        ActivityC0460a.m1698b("set cm address : " + str);
        f1281e = str;
    }

    public static void setIdcConfigUrl(String[] strArr) {
        f1278b = strArr;
    }

    public static void setLocation(String str) {
        if (!TextUtils.isEmpty(str)) {
            C0618g.f1633d = str;
            f1279c = str;
        }
    }

    public static void setXfrAddressIps(String[] strArr) {
        synchronized (f1277a) {
            f1280d = strArr;
        }
    }
}
