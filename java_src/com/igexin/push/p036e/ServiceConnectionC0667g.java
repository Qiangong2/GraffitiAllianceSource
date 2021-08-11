package com.igexin.push.p036e;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.igexin.push.core.C0617f;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.EnumC0613d;
import com.igexin.push.p032d.p035c.AbstractC0642e;
import com.igexin.push.p032d.p035c.C0651n;
import com.igexin.sdk.aidl.AbstractBinderC1175a;
import java.util.List;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.e.g */
public class ServiceConnectionC0667g implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ C0662b f1806a;

    /* renamed from: b */
    final /* synthetic */ String f1807b;

    /* renamed from: c */
    final /* synthetic */ C0663c f1808c;

    ServiceConnectionC0667g(C0663c cVar, C0662b bVar, String str) {
        this.f1808c = cVar;
        this.f1806a = bVar;
        this.f1807b = str;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (this.f1808c.f1795b == EnumC0613d.active) {
            try {
                this.f1806a.mo4705a(AbstractBinderC1175a.m4829a(iBinder));
                this.f1808c.f1800g.put(this.f1807b, this.f1806a);
                if (this.f1806a.mo4709c().onASNLConnected(this.f1806a.mo4703a(), this.f1806a.mo4707b(), this.f1807b, 0) == -1) {
                    this.f1808c.f1800g.remove(this.f1807b);
                } else if (C0618g.f1641l) {
                    this.f1806a.mo4709c().onASNLNetworkConnected();
                }
            } catch (Exception e) {
                this.f1808c.f1800g.remove(this.f1807b);
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (this.f1808c.f1795b == EnumC0613d.active) {
            this.f1808c.f1800g.remove(this.f1807b);
            List list = this.f1808c.m2561c(((C0662b) this.f1808c.f1800g.get(this.f1807b)).mo4712e());
            if (list.size() != 0) {
                for (int i = 0; i < list.size(); i++) {
                    String str = (String) list.get(i);
                    if (str.startsWith("S-")) {
                        C0651n nVar = new C0651n();
                        nVar.f1765a = Long.valueOf(str.substring(2)).longValue();
                        C0617f.m2395a().mo4628g().mo4737a("S-" + String.valueOf(nVar.f1765a), (AbstractC0642e) nVar, true);
                    }
                    this.f1808c.f1801h.remove(str);
                }
            }
        }
    }
}
