package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.string.C1873d;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.xiaomi.push.service.i */
public class C1971i {

    /* renamed from: a */
    private static C1971i f5080a = null;

    /* renamed from: b */
    private Context f5081b;

    /* renamed from: c */
    private List<String> f5082c = new ArrayList();

    private C1971i(Context context) {
        this.f5081b = context.getApplicationContext();
        if (this.f5081b == null) {
            this.f5081b = context;
        }
        String[] split = this.f5081b.getSharedPreferences("mipush_app_info", 0).getString("unregistered_pkg_names", "").split(MiPushClient.ACCEPT_TIME_SEPARATOR);
        for (String str : split) {
            if (TextUtils.isEmpty(str)) {
                this.f5082c.add(str);
            }
        }
    }

    /* renamed from: a */
    public static C1971i m7334a(Context context) {
        if (f5080a == null) {
            f5080a = new C1971i(context);
        }
        return f5080a;
    }

    /* renamed from: a */
    public boolean mo10415a(String str) {
        boolean contains;
        synchronized (this.f5082c) {
            contains = this.f5082c.contains(str);
        }
        return contains;
    }

    /* renamed from: b */
    public void mo10416b(String str) {
        synchronized (this.f5082c) {
            if (!this.f5082c.contains(str)) {
                this.f5082c.add(str);
                this.f5081b.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", C1873d.m6783a(this.f5082c, MiPushClient.ACCEPT_TIME_SEPARATOR)).commit();
            }
        }
    }

    /* renamed from: c */
    public void mo10417c(String str) {
        synchronized (this.f5082c) {
            if (this.f5082c.contains(str)) {
                this.f5082c.remove(str);
                this.f5081b.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", C1873d.m6783a(this.f5082c, MiPushClient.ACCEPT_TIME_SEPARATOR)).commit();
            }
        }
    }
}
