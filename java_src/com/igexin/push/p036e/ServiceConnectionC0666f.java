package com.igexin.push.p036e;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.igexin.push.core.C0617f;
import com.igexin.push.core.EnumC0602c;
import com.igexin.push.core.EnumC0613d;
import com.igexin.sdk.aidl.AbstractBinderC1175a;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.e.f */
public class ServiceConnectionC0666f implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ C0663c f1805a;

    ServiceConnectionC0666f(C0663c cVar) {
        this.f1805a = cVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (this.f1805a.f1795b == EnumC0613d.prepare) {
            this.f1805a.f1798e.mo4705a(AbstractBinderC1175a.m4829a(iBinder));
            C0661a aVar = new C0661a();
            aVar.mo4702a(EnumC0602c.connectASNL);
            this.f1805a.mo4719a(aVar);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (this.f1805a.f1795b == EnumC0613d.passive) {
            C0617f.m2395a().mo4628g().mo4743b(true);
            this.f1805a.m2562c();
        }
    }
}
