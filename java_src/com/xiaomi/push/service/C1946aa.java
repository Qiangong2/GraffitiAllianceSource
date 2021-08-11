package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;

/* renamed from: com.xiaomi.push.service.aa */
public class C1946aa {

    /* renamed from: a */
    private static C1946aa f5026a;

    /* renamed from: b */
    private Context f5027b;

    /* renamed from: c */
    private int f5028c = 0;

    private C1946aa(Context context) {
        this.f5027b = context.getApplicationContext();
    }

    /* renamed from: a */
    public static C1946aa m7251a(Context context) {
        if (f5026a == null) {
            f5026a = new C1946aa(context);
        }
        return f5026a;
    }

    /* renamed from: a */
    public boolean mo10381a() {
        return "@SHIP.TO.2A2FE0D7@".contains("xmsf") || "@SHIP.TO.2A2FE0D7@".contains("xiaomi") || "@SHIP.TO.2A2FE0D7@".contains("miui");
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    public int mo10382b() {
        if (this.f5028c != 0) {
            return this.f5028c;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.f5028c = Settings.Global.getInt(this.f5027b.getContentResolver(), "device_provisioned", 0);
            return this.f5028c;
        }
        this.f5028c = Settings.Secure.getInt(this.f5027b.getContentResolver(), "device_provisioned", 0);
        return this.f5028c;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: c */
    public Uri mo10383c() {
        return Build.VERSION.SDK_INT >= 17 ? Settings.Global.getUriFor("device_provisioned") : Settings.Secure.getUriFor("device_provisioned");
    }
}
