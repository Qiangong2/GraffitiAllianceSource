package com.igexin.push.extension.distribution.basic.headsup;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.basic.headsup.g */
public class C0783g extends Thread {

    /* renamed from: a */
    final /* synthetic */ C0778b f2199a;

    private C0783g(C0778b bVar) {
        this.f2199a = bVar;
    }

    /* synthetic */ C0783g(C0778b bVar, C0779c cVar) {
        this(bVar);
    }

    public void run() {
        super.run();
        while (this.f2199a.f2191z > 0) {
            try {
                Thread.sleep(1000);
                C0778b.m3238h(this.f2199a);
            } catch (InterruptedException e) {
            }
        }
        if (this.f2199a.f2191z == 0) {
            this.f2199a.f2162A.sendEmptyMessage(0);
        }
    }
}
