package com.xiaomi.channel.commonutils.misc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.channel.commonutils.misc.C1857b;

/* renamed from: com.xiaomi.channel.commonutils.misc.c */
class HandlerC1860c extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1857b f4623a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HandlerC1860c(C1857b bVar, Looper looper) {
        super(looper);
        this.f4623a = bVar;
    }

    public void handleMessage(Message message) {
        C1857b.AbstractC1859b bVar = (C1857b.AbstractC1859b) message.obj;
        if (message.what == 0) {
            bVar.mo9931a();
        } else if (message.what == 1) {
            bVar.mo9933c();
        }
        super.handleMessage(message);
    }
}
