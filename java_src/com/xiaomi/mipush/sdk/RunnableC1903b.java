package com.xiaomi.mipush.sdk;

import android.content.Context;

/* access modifiers changed from: package-private */
/* renamed from: com.xiaomi.mipush.sdk.b */
public final class RunnableC1903b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f4866a;

    /* renamed from: b */
    final /* synthetic */ String f4867b;

    /* renamed from: c */
    final /* synthetic */ String f4868c;

    RunnableC1903b(Context context, String str, String str2) {
        this.f4866a = context;
        this.f4867b = str;
        this.f4868c = str2;
    }

    public void run() {
        MiPushClient.initialize(this.f4866a, this.f4867b, this.f4868c, null);
    }
}
