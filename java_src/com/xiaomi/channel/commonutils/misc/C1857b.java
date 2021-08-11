package com.xiaomi.channel.commonutils.misc;

import android.os.Handler;
import android.os.Looper;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: com.xiaomi.channel.commonutils.misc.b */
public class C1857b {

    /* renamed from: a */
    private C1858a f4615a;

    /* renamed from: b */
    private Handler f4616b;

    /* renamed from: c */
    private volatile boolean f4617c;

    /* renamed from: d */
    private final boolean f4618d;

    /* renamed from: e */
    private int f4619e;

    /* renamed from: f */
    private volatile AbstractC1859b f4620f;

    /* access modifiers changed from: private */
    /* renamed from: com.xiaomi.channel.commonutils.misc.b$a */
    public class C1858a extends Thread {

        /* renamed from: b */
        private final LinkedBlockingQueue<AbstractC1859b> f4622b = new LinkedBlockingQueue<>();

        public C1858a() {
            super("PackageProcessor");
        }

        /* renamed from: a */
        public void mo9929a(AbstractC1859b bVar) {
            this.f4622b.add(bVar);
        }

        public void run() {
            int i = C1857b.this.f4619e > 0 ? C1857b.this.f4619e : 1;
            while (!C1857b.this.f4617c) {
                try {
                    C1857b.this.f4620f = this.f4622b.poll((long) i, TimeUnit.SECONDS);
                    if (C1857b.this.f4620f != null) {
                        C1857b.this.f4616b.sendMessage(C1857b.this.f4616b.obtainMessage(0, C1857b.this.f4620f));
                        C1857b.this.f4620f.mo9932b();
                        C1857b.this.f4616b.sendMessage(C1857b.this.f4616b.obtainMessage(1, C1857b.this.f4620f));
                    } else if (C1857b.this.f4619e > 0) {
                        C1857b.this.m6731a();
                    }
                } catch (InterruptedException e) {
                    AbstractC1855b.m6720a(e);
                }
            }
        }
    }

    /* renamed from: com.xiaomi.channel.commonutils.misc.b$b */
    public static abstract class AbstractC1859b {
        /* renamed from: a */
        public void mo9931a() {
        }

        /* renamed from: b */
        public abstract void mo9932b();

        /* renamed from: c */
        public void mo9933c() {
        }
    }

    public C1857b() {
        this(false);
    }

    public C1857b(boolean z) {
        this(z, 0);
    }

    public C1857b(boolean z, int i) {
        this.f4616b = null;
        this.f4617c = false;
        this.f4619e = 0;
        this.f4616b = new HandlerC1860c(this, Looper.getMainLooper());
        this.f4618d = z;
        this.f4619e = i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: a */
    private synchronized void m6731a() {
        this.f4615a = null;
        this.f4617c = true;
    }

    /* renamed from: a */
    public synchronized void mo9927a(AbstractC1859b bVar) {
        if (this.f4615a == null) {
            this.f4615a = new C1858a();
            this.f4615a.setDaemon(this.f4618d);
            this.f4617c = false;
            this.f4615a.start();
        }
        this.f4615a.mo9929a(bVar);
    }

    /* renamed from: a */
    public void mo9928a(AbstractC1859b bVar, long j) {
        this.f4616b.postDelayed(new RunnableC1861d(this, bVar), j);
    }
}
