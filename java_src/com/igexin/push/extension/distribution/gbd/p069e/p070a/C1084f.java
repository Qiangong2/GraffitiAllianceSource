package com.igexin.push.extension.distribution.gbd.p069e.p070a;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.igexin.push.extension.distribution.gbd.p067c.C1068b;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.push.extension.distribution.gbd.p076i.C1112a;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.igexin.push.extension.distribution.gbd.p076i.C1125n;
import org.json.JSONObject;

/* renamed from: com.igexin.push.extension.distribution.gbd.e.a.f */
public class C1084f {

    /* renamed from: a */
    public static C1084f f2939a;

    /* renamed from: b */
    private SharedPreferences f2940b = C1069c.f2824a.getSharedPreferences("gx_sp", 0);

    private C1084f() {
    }

    /* renamed from: a */
    public static C1084f m4433a() {
        if (f2939a == null) {
            f2939a = new C1084f();
        }
        return f2939a;
    }

    /* renamed from: a */
    public void mo5838a(byte[] bArr) {
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            C1115d.m4559b("GBD_SPM", "parseServiceConfig : " + jSONObject);
            if (jSONObject.has("result") && jSONObject.has("services")) {
                String string = jSONObject.getString("services");
                if (!TextUtils.isEmpty(string)) {
                    SharedPreferences.Editor edit = this.f2940b.edit();
                    edit.putString("sp_guard_services", C1112a.m4552a(C1125n.m4622b(string.getBytes("UTF-8"), C1068b.f2816a), 0, 102400));
                    edit.apply();
                }
            }
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
    }

    /* renamed from: b */
    public String mo5839b() {
        try {
            String string = this.f2940b.getString("sp_guard_services", "");
            if (TextUtils.isEmpty(string)) {
                return string;
            }
            String str = new String(C1125n.m4620a(C1112a.m4553a(string.toCharArray(), 0), C1068b.f2816a), "utf-8");
            C1115d.m4559b("GBD_SPM", "readServiceConfig : " + str);
            return str;
        } catch (Throwable th) {
            C1115d.m4558a(th);
            return "";
        }
    }
}
