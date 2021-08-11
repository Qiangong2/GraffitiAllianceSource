package com.igexin.push.p026c;

import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.C0618g;
import com.igexin.push.p079f.p081b.AbstractC1150h;
import com.umeng.analytics.C1370a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.igexin.push.c.p */
public class C0501p extends AbstractC1150h {

    /* renamed from: a */
    public static final int f1263a = ((int) m1909a(20150601L));

    /* renamed from: b */
    private static final String f1264b = C0501p.class.getName();

    /* renamed from: L */
    private volatile boolean f1265L = true;

    /* renamed from: M */
    private volatile boolean f1266M;

    /* renamed from: c */
    private C0495j f1267c;

    /* renamed from: e */
    private Thread f1268e;

    /* renamed from: f */
    private AbstractC0500o f1269f;

    /* renamed from: g */
    private long f1270g = -1;

    /* renamed from: h */
    private Lock f1271h = new ReentrantLock();

    /* renamed from: i */
    private Condition f1272i = this.f1271h.newCondition();

    /* renamed from: j */
    private final List<Object> f1273j = new ArrayList(1);

    public C0501p() {
        super(604800000);
        this.f1126o = true;
    }

    /* renamed from: A */
    private void m1907A() {
        try {
            if (this.f1268e != null) {
                this.f1268e.interrupt();
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: B */
    private void m1908B() {
        try {
            this.f1271h.lock();
            this.f1273j.add(new Object());
            this.f1272i.signalAll();
            try {
                this.f1271h.unlock();
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            try {
                this.f1271h.unlock();
            } catch (Exception e3) {
            }
        } catch (Throwable th) {
            try {
                this.f1271h.unlock();
            } catch (Exception e4) {
            }
            throw th;
        }
    }

    /* renamed from: a */
    private static long m1909a(long j) {
        long j2 = j / 10;
        return ((long) (((Math.random() * ((double) j2)) * 2.0d) - ((double) j2))) + j;
    }

    /* renamed from: x */
    private void m1920x() {
        this.f1268e = new Thread(new RunnableC0502q(this));
        this.f1268e.start();
    }

    /* renamed from: y */
    private void m1921y() {
        mo4193a(1800000, TimeUnit.MILLISECONDS);
        if (this.f1268e == null) {
            this.f1265L = true;
            this.f1273j.add(new Object());
            m1920x();
            return;
        }
        try {
            this.f1271h.lock();
            ActivityC0460a.m1698b(f1264b + "|detect " + m1922z() + "running, start");
            this.f1273j.add(new Object());
            this.f1272i.signalAll();
            try {
                this.f1271h.unlock();
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            try {
                this.f1271h.unlock();
            } catch (Exception e3) {
            }
        } catch (Throwable th) {
            try {
                this.f1271h.unlock();
            } catch (Exception e4) {
            }
            throw th;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: z */
    private String m1922z() {
        return this.f1267c.mo4286a() + "[" + this.f1267c.mo4297c() + "] ";
    }

    /* access modifiers changed from: protected */
    @Override // com.igexin.push.p079f.p081b.AbstractC1150h
    /* renamed from: a */
    public void mo4304a() {
        if (!this.f1266M) {
            m1921y();
        }
    }

    /* renamed from: a */
    public void mo4330a(C0495j jVar) {
        this.f1267c = jVar;
    }

    /* renamed from: a */
    public void mo4331a(AbstractC0500o oVar) {
        this.f1269f = oVar;
    }

    /* renamed from: a */
    public void mo4332a(boolean z) {
        if (z) {
            mo4337j();
            ActivityC0460a.m1698b(f1264b + "|detect " + m1922z() + "reset delay = 0");
        }
        ActivityC0460a.m1698b(f1264b + "|network available : " + C0618g.f1637h);
        if (!C0618g.f1637h) {
            this.f1270g = 604800000;
        } else {
            if (this.f1270g <= 2000) {
                this.f1270g += 500;
            } else if (this.f1270g <= 15000) {
                this.f1270g += 5000;
            } else if (this.f1270g <= 60000) {
                this.f1270g += 15000;
            } else {
                this.f1270g += 120000;
            }
            if (this.f1270g > C1370a.f3218j) {
                this.f1270g = C1370a.f3218j;
            }
            this.f1270g = m1909a(this.f1270g);
            ActivityC0460a.m1698b(f1264b + "|detect " + m1922z() + "redetect delay = " + this.f1270g);
        }
        mo4193a(this.f1270g, TimeUnit.MILLISECONDS);
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public final int mo4136b() {
        return f1263a;
    }

    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: c */
    public void mo4199c() {
        super.mo4199c();
    }

    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: d */
    public void mo4126d() {
    }

    /* renamed from: d_ */
    public C0495j mo4333d_() {
        return this.f1267c;
    }

    /* renamed from: g */
    public void mo4334g() {
        ActivityC0460a.m1698b(f1264b + "|detect " + m1922z() + "finish, task stop");
        mo4193a(604800000, TimeUnit.MILLISECONDS);
    }

    /* renamed from: h */
    public void mo4335h() {
        this.f1266M = true;
        this.f1265L = false;
        this.f1126o = false;
        this.f1269f = null;
        m1908B();
        mo4202p();
        m1907A();
    }

    /* renamed from: i */
    public void mo4336i() {
        ActivityC0460a.m1698b(f1264b + "|detect " + m1922z() + "start");
        this.f1270g = 50;
        mo4193a(this.f1270g, TimeUnit.MILLISECONDS);
    }

    /* renamed from: j */
    public void mo4337j() {
        this.f1270g = 0;
    }
}
