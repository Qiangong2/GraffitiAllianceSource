package com.xiaomi.smack;

import com.xiaomi.network.HostManager;

/* access modifiers changed from: package-private */
/* renamed from: com.xiaomi.smack.o */
public class RunnableC2022o implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f5353a;

    /* renamed from: b */
    final /* synthetic */ C2019l f5354b;

    RunnableC2022o(C2019l lVar, String str) {
        this.f5354b = lVar;
        this.f5353a = str;
    }

    public void run() {
        HostManager.getInstance().getFallbacksByHost(this.f5353a, true);
    }
}
