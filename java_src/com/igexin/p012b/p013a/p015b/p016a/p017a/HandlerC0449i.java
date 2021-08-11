package com.igexin.p012b.p013a.p015b.p016a.p017a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.p027a.C0535e;
import java.net.Socket;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.b.a.b.a.a.i */
public class HandlerC0449i extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0444d f1060a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HandlerC0449i(C0444d dVar) {
        super(Looper.getMainLooper());
        this.f1060a = dVar;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                if (!(this.f1060a.m1618k())) {
                    this.f1060a.m1609f();
                    return;
                }
                return;
            case 1:
                this.f1060a.f1052l = false;
                return;
            case 2:
                this.f1060a.m1597a((C0444d) ((Socket) message.obj));
                return;
            case 3:
                if (this.f1060a.m1617j()) {
                    this.f1060a.m1613h();
                    return;
                }
                return;
            case 4:
                this.f1060a.m1619l();
                if (this.f1060a.f1051k == null && this.f1060a.f1050j == null && this.f1060a.f1049i == null) {
                    C0535e.m2034a().mo4403e(false);
                    return;
                } else if (this.f1060a.m1617j()) {
                    this.f1060a.m1613h();
                    return;
                } else {
                    this.f1060a.m1611g();
                    return;
                }
            case 5:
                if (this.f1060a.m1617j()) {
                    ActivityC0460a.m1698b(C0444d.f1039e + "|tcp already close reconnect immediately");
                    C0535e.m2034a().mo4403e(((Boolean) message.obj).booleanValue());
                    return;
                }
                ActivityC0460a.m1698b(C0444d.f1039e + "|reconnect will run after close");
                this.f1060a.m1611g();
                return;
            default:
                return;
        }
    }
}
