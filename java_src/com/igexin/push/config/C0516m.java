package com.igexin.push.config;

import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.p026c.C0494i;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.igexin.push.config.m */
public class C0516m {
    /* renamed from: a */
    public static void m1968a(String str, boolean z) {
        JSONObject jSONObject;
        String[] a;
        String[] a2;
        String[] a3;
        String[] a4;
        String[] a5;
        String[] a6;
        String[] a7;
        String[] a8;
        String[] a9;
        ActivityC0460a.m1698b("IDCConfigParse parse idc config data : " + str);
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            if (jSONObject.has("N")) {
                try {
                    SDKUrlConfig.setLocation(jSONObject.getString("N"));
                } catch (JSONException e2) {
                }
            }
            if (jSONObject.has("X1") && (a9 = m1969a(jSONObject, "X1")) != null && a9.length > 0) {
                SDKUrlConfig.setXfrAddressIps(a9);
                ActivityC0460a.m1698b("Detect_IDCConfigParse parse idc success, set new xfr address, reset and redetect +++++++++++++++++");
                if (z) {
                    C0494i.m1834a().mo4284h();
                }
            }
            if (jSONObject.has("X2") && (a8 = m1969a(jSONObject, "X2")) != null && a8.length > 0) {
                SDKUrlConfig.XFR_ADDRESS_BAK = a8;
            }
            if (jSONObject.has("B") && (a7 = m1969a(jSONObject, "B")) != null && a7.length > 0) {
                SDKUrlConfig.BI_ADDRESS_IPS = a7;
            }
            if (jSONObject.has("C") && (a6 = m1969a(jSONObject, "C")) != null && a6.length > 0) {
                SDKUrlConfig.CONFIG_ADDRESS_IPS = a6;
            }
            if (jSONObject.has("S") && (a5 = m1969a(jSONObject, "S")) != null && a5.length > 0) {
                SDKUrlConfig.STATE_ADDRESS_IPS = a5;
            }
            if (jSONObject.has("LO") && (a4 = m1969a(jSONObject, "LO")) != null && a4.length > 0) {
                SDKUrlConfig.LOG_ADDRESS_IPS = a4;
            }
            if (jSONObject.has("A") && (a3 = m1969a(jSONObject, "A")) != null && a3.length > 0) {
                SDKUrlConfig.AMP_ADDRESS_IPS = a3;
            }
            if (jSONObject.has("LB") && (a2 = m1969a(jSONObject, "LB")) != null && a2.length > 0) {
                SDKUrlConfig.LBS_ADDRESS_IPS = a2;
            }
            if (jSONObject.has("I") && (a = m1969a(jSONObject, "I")) != null && a.length > 0) {
                SDKUrlConfig.INC_ADDRESS_IPS = a;
            }
        }
    }

    /* renamed from: a */
    private static String[] m1969a(JSONObject jSONObject, String str) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            int length = jSONArray.length();
            String[] strArr = new String[length];
            for (int i = 0; i < length; i++) {
                if (str.equals("X1") || str.equals("X2")) {
                    strArr[i] = "socket://" + jSONArray.getString(i);
                } else {
                    strArr[i] = "http://" + jSONArray.getString(i);
                }
            }
            return strArr;
        } catch (Exception e) {
            return null;
        }
    }
}
