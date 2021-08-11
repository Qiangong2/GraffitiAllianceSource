package com.igexin.push.extension.distribution.gbd.p061a.p063b;

import android.text.TextUtils;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.xiaomi.mipush.sdk.MiPushClient;

/* renamed from: com.igexin.push.extension.distribution.gbd.a.b.k */
class RunnableC1039k implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1038j f2646a;

    RunnableC1039k(C1038j jVar) {
        this.f2646a = jVar;
    }

    public void run() {
        try {
            if (this.f2646a.f2643a.get("pkgName") != null && this.f2646a.f2643a.get("srvName") != null && this.f2646a.f2643a.get("datetime") != null && !TextUtils.isEmpty(this.f2646a.f2643a.get("pkgName").toString()) && !TextUtils.isEmpty(this.f2646a.f2643a.get("srvName").toString()) && !TextUtils.isEmpty(this.f2646a.f2643a.get("datetime").toString())) {
                String str = this.f2646a.f2643a.get("pkgName").toString() + MiPushClient.ACCEPT_TIME_SEPARATOR + this.f2646a.f2643a.get("srvName").toString();
                C1037i.m4195a(str);
                C1037i.m4196a(str, this.f2646a.f2644b, this.f2646a.f2643a.get("datetime").toString(), 1);
                C1115d.m4559b("GBD_GTT", "guard success type = " + this.f2646a.f2644b + " pkg = " + this.f2646a.f2643a.get("pkgName").toString());
            }
        } catch (Exception e) {
            C1115d.m4558a(e);
        }
    }
}
