package com.igexin.push.extension.distribution.basic.headsup;

import android.os.Handler;
import android.os.Message;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.basic.headsup.e */
public class HandlerC0781e extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0786j f2195a;

    /* renamed from: b */
    final /* synthetic */ C0778b f2196b;

    HandlerC0781e(C0778b bVar, C0786j jVar) {
        this.f2196b = bVar;
        this.f2195a = jVar;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f2195a.mo5193p() && this.f2195a.mo5194q()) {
            C0789m.m3318a(this.f2196b.getContext()).mo5235c(this.f2195a);
        }
        C0789m.m3318a(this.f2196b.getContext()).mo5233b(this.f2195a);
    }
}
