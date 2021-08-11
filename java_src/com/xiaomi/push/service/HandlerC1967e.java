package com.xiaomi.push.service;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.service.e */
class HandlerC1967e extends Handler {

    /* renamed from: a */
    final /* synthetic */ HandlerThreadC1966d f5068a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HandlerC1967e(HandlerThreadC1966d dVar, Looper looper) {
        super(looper);
        this.f5068a = dVar;
    }

    public void handleMessage(Message message) {
        this.f5068a.f5065b = true;
        this.f5068a.f5064a = System.currentTimeMillis();
        if (message.obj instanceof XMPushService.AbstractC1937e) {
            ((XMPushService.AbstractC1937e) message.obj).mo10380c();
        }
        this.f5068a.f5065b = false;
    }
}
