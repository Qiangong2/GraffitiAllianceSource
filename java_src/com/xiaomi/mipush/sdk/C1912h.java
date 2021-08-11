package com.xiaomi.mipush.sdk;

import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.channel.commonutils.network.C1865d;
import com.xiaomi.push.service.C1946aa;

/* access modifiers changed from: package-private */
/* renamed from: com.xiaomi.mipush.sdk.h */
public class C1912h extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ C1910g f4887a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1912h(C1910g gVar, Handler handler) {
        super(handler);
        this.f4887a = gVar;
    }

    public void onChange(boolean z) {
        this.f4887a.f4883g = Integer.valueOf(C1946aa.m7251a(this.f4887a.f4880c).mo10382b());
        if (this.f4887a.f4883g.intValue() != 0) {
            this.f4887a.f4880c.getContentResolver().unregisterContentObserver(this);
            if (C1865d.m6762d(this.f4887a.f4880c)) {
                this.f4887a.mo10213c();
            }
        }
    }
}
