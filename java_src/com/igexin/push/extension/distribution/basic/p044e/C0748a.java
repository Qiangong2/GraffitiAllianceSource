package com.igexin.push.extension.distribution.basic.p044e;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.igexin.p012b.p013a.p014a.C0435a;
import com.igexin.push.extension.distribution.basic.p042c.C0744j;
import com.igexin.push.extension.distribution.basic.util.C0996b;
import org.json.JSONObject;

/* renamed from: com.igexin.push.extension.distribution.basic.e.a */
public class C0748a {

    /* renamed from: a */
    public static C0748a f2066a;

    /* renamed from: b */
    private SharedPreferences f2067b = C0744j.f2042a.getSharedPreferences("gx_sp", 0);

    private C0748a() {
    }

    /* renamed from: a */
    public static C0748a m3034a() {
        if (f2066a == null) {
            f2066a = new C0748a();
        }
        return f2066a;
    }

    /* renamed from: c */
    public static String m3035c() {
        return C0744j.f2042a.getSharedPreferences("getui_sp", 0).getString("us", "");
    }

    /* renamed from: a */
    public String mo5033a(String str) {
        try {
            String b = mo5034b();
            if (!TextUtils.isEmpty(b)) {
                String string = new JSONObject(b).getString(str);
                if (!TextUtils.isEmpty(string)) {
                    String[] split = string.split("\\|");
                    if (split.length > 0) {
                        return split[0];
                    }
                }
            }
        } catch (Throwable th) {
        }
        return null;
    }

    /* renamed from: b */
    public String mo5034b() {
        try {
            return new String(C0435a.m1574a(C0996b.m3996a(this.f2067b.getString("sp_guard_services", "").toCharArray(), 0), "dj1om0z0za9kwzxrphkqxsu9oc21tez1"), "utf-8");
        } catch (Throwable th) {
            return "";
        }
    }
}
