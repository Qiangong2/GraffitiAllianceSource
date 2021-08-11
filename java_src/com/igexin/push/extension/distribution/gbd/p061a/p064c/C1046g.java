package com.igexin.push.extension.distribution.gbd.p061a.p064c;

import android.os.Process;
import com.igexin.push.extension.distribution.gbd.p067c.C1068b;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.gbd.a.c.g */
public class C1046g extends Thread {

    /* renamed from: a */
    int f2686a;

    /* renamed from: b */
    final /* synthetic */ C1045f f2687b;

    public C1046g(C1045f fVar, int i) {
        this.f2687b = fVar;
        this.f2686a = i;
    }

    public void run() {
        synchronized (this.f2687b.f2680m) {
            try {
                Process.setThreadPriority(10);
                this.f2687b.f2683p.f2707a = EnumC1047h.SCAN_END;
                if (this.f2687b.f2682o != null) {
                    this.f2687b.f2682o.f2648a = EnumC1047h.SCAN_END;
                    this.f2687b.f2682o.mo5694a();
                }
                this.f2687b.f2683p.mo5718a(this.f2686a);
                Thread.sleep((long) C1068b.f2818c);
            } catch (Throwable th) {
                C1115d.m4558a(th);
            }
        }
    }
}
