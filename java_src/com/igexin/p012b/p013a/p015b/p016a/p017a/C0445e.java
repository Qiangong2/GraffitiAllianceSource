package com.igexin.p012b.p013a.p015b.p016a.p017a;

import android.os.Message;
import com.igexin.p012b.p013a.p015b.AbstractC0458e;
import com.igexin.p012b.p013a.p015b.p016a.p017a.p018a.AbstractC0441d;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import java.net.Socket;

/* renamed from: com.igexin.b.a.b.a.a.e */
class C0445e implements AbstractC0441d {

    /* renamed from: a */
    final /* synthetic */ C0444d f1056a;

    C0445e(C0444d dVar) {
        this.f1056a = dVar;
    }

    @Override // com.igexin.p012b.p013a.p015b.p016a.p017a.p018a.AbstractC0438a
    /* renamed from: a */
    public void mo4129a(AbstractC0458e eVar) {
        this.f1056a.f1053o.sendEmptyMessage(3);
    }

    @Override // com.igexin.p012b.p013a.p015b.p016a.p017a.p018a.AbstractC0441d
    /* renamed from: a */
    public void mo4133a(Exception exc) {
        ActivityC0460a.m1698b(C0444d.f1039e + "|c ex = " + exc.toString());
        this.f1056a.mo4144b();
    }

    @Override // com.igexin.p012b.p013a.p015b.p016a.p017a.p018a.AbstractC0441d
    /* renamed from: a */
    public void mo4134a(String str) {
        this.f1056a.f1053o.sendEmptyMessage(1);
    }

    @Override // com.igexin.p012b.p013a.p015b.p016a.p017a.p018a.AbstractC0441d
    /* renamed from: a */
    public void mo4135a(Socket socket) {
        Message obtain = Message.obtain();
        obtain.obj = socket;
        obtain.what = 2;
        this.f1056a.f1053o.sendMessage(obtain);
    }
}
