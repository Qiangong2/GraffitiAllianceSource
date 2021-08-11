package com.igexin.push.core.p029b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.b.c */
public class C0564c {

    /* renamed from: b */
    private static final Object f1405b = new Object();

    /* renamed from: a */
    private SharedPreferences f1406a;

    public C0564c(Context context) {
        if (context != null) {
            this.f1406a = context.getSharedPreferences("gx_msg_sp", 0);
        }
    }

    /* renamed from: a */
    private void m2176a(JSONObject jSONObject) {
        boolean z;
        try {
            if (jSONObject.length() >= 150) {
                boolean z2 = false;
                Iterator<String> keys = jSONObject.keys();
                long j = Long.MAX_VALUE;
                String str = null;
                while (keys.hasNext()) {
                    String next = keys.next();
                    long j2 = jSONObject.getLong(next);
                    if (j > j2) {
                        str = next;
                        j = j2;
                    }
                    if (j2 < System.currentTimeMillis() - 432000000) {
                        keys.remove();
                        z = true;
                    } else {
                        z = z2;
                    }
                    z2 = z;
                }
                if (!z2 && str != null) {
                    jSONObject.remove(str);
                }
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    public JSONObject mo4433a() {
        try {
            String string = this.f1406a.getString("taskIdList", "");
            if (!TextUtils.isEmpty(string)) {
                return new JSONObject(string);
            }
        } catch (Throwable th) {
        }
        return null;
    }

    /* renamed from: a */
    public boolean mo4434a(String str) {
        if (this.f1406a == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject a = mo4433a();
            if (a == null || !a.has(str)) {
                return false;
            }
            ActivityC0460a.m1698b("sp task " + str + " already exists");
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: b */
    public void mo4435b(String str) {
        if (this.f1406a != null && !TextUtils.isEmpty(str)) {
            synchronized (f1405b) {
                try {
                    JSONObject a = mo4433a();
                    if (a == null) {
                        a = new JSONObject();
                    }
                    if (a.length() > 0) {
                        m2176a(a);
                    }
                    a.put(str, System.currentTimeMillis());
                    SharedPreferences.Editor edit = this.f1406a.edit();
                    edit.putString("taskIdList", a.toString());
                    edit.apply();
                } catch (Throwable th) {
                }
            }
        }
    }
}
