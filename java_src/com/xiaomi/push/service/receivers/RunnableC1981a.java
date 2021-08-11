package com.xiaomi.push.service.receivers;

import android.content.Context;

/* renamed from: com.xiaomi.push.service.receivers.a */
class RunnableC1981a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f5110a;

    /* renamed from: b */
    final /* synthetic */ NetworkStatusReceiver f5111b;

    RunnableC1981a(NetworkStatusReceiver networkStatusReceiver, Context context) {
        this.f5111b = networkStatusReceiver;
        this.f5110a = context;
    }

    public void run() {
        this.f5111b.m7374a(this.f5110a);
    }
}
