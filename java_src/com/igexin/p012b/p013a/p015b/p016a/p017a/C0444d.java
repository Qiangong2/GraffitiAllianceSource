package com.igexin.p012b.p013a.p015b.p016a.p017a;

import android.os.Message;
import com.igexin.p012b.p013a.p015b.AbstractC0455b;
import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.p012b.p013a.p015b.C0457d;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.p012b.p013a.p020d.AbstractC0470d;
import com.igexin.p012b.p013a.p020d.C0471e;
import com.igexin.push.core.p027a.C0535e;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.igexin.b.a.b.a.a.d */
public final class C0444d {

    /* renamed from: e */
    private static final String f1039e = C0444d.class.getName();

    /* renamed from: m */
    private static C0444d f1040m;

    /* renamed from: n */
    private static final Object f1041n = new Object();

    /* renamed from: a */
    public Lock f1042a = new ReentrantLock();

    /* renamed from: b */
    public Condition f1043b = this.f1042a.newCondition();

    /* renamed from: c */
    public ConcurrentLinkedQueue<C0451k> f1044c = new ConcurrentLinkedQueue<>();

    /* renamed from: d */
    public List<C0451k> f1045d = new ArrayList();

    /* renamed from: f */
    private AbstractC0455b f1046f;

    /* renamed from: g */
    private C0457d f1047g;

    /* renamed from: h */
    private Socket f1048h;

    /* renamed from: i */
    private C0450j f1049i;

    /* renamed from: j */
    private C0452l f1050j;

    /* renamed from: k */
    private C0443c f1051k;

    /* renamed from: l */
    private boolean f1052l;

    /* renamed from: o */
    private HandlerC0449i f1053o = new HandlerC0449i(this);

    /* renamed from: p */
    private long f1054p;

    /* renamed from: q */
    private final Comparator<C0451k> f1055q = new C0448h(this);

    private C0444d() {
    }

    /* renamed from: a */
    public static synchronized C0444d m1594a() {
        C0444d dVar;
        synchronized (C0444d.class) {
            if (f1040m == null) {
                f1040m = new C0444d();
            }
            dVar = f1040m;
        }
        return dVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1597a(Socket socket) {
        try {
            if (!this.f1051k.mo4128g()) {
                this.f1048h = socket;
                this.f1047g = new C0457d();
                m1602b(socket);
                m1603c(socket);
            }
        } catch (Exception e) {
            ActivityC0460a.m1698b(f1039e + "|" + e.toString());
            mo4144b();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: b */
    private void m1601b(C0451k kVar) {
        if (kVar.f1136y <= 0 || kVar.f1115D == null) {
            kVar.mo4202p();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        kVar.mo4198b(currentTimeMillis);
        synchronized (f1041n) {
            this.f1045d.add(kVar);
            Collections.sort(this.f1045d, this.f1055q);
            this.f1054p = TimeUnit.SECONDS.toMillis((long) this.f1045d.get(0).f1136y);
            if (this.f1054p > 0 && this.f1045d.size() == 1) {
                ActivityC0460a.m1698b(f1039e + "|add : " + kVar.toString() + " --- " + kVar.f1088c.getClass().getName() + " set alarm " + "delay = " + (this.f1054p + C0471e.f1139u));
                C0456c.m1661b().mo4219b(currentTimeMillis + this.f1054p + C0471e.f1139u);
            }
        }
    }

    /* renamed from: b */
    private void m1602b(Socket socket) {
        this.f1049i = new C0450j(new C0453m(socket.getInputStream()), this.f1046f, this.f1047g);
        this.f1049i.mo4150a(new C0446f(this));
        C0456c.m1661b().mo4215a((AbstractC0470d) this.f1049i, true);
    }

    /* renamed from: c */
    private void m1603c(Socket socket) {
        this.f1050j = new C0452l(new C0454n(socket.getOutputStream()), this.f1046f, this.f1047g);
        this.f1050j.mo4152a(new C0447g(this));
        C0456c.m1661b().mo4215a((AbstractC0470d) this.f1050j, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m1609f() {
        ActivityC0460a.m1698b(f1039e + "|disconnect = true, reconnect");
        this.f1051k = new C0443c(new C0445e(this));
        C0456c.m1661b().mo4215a((AbstractC0470d) this.f1051k, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m1611g() {
        ActivityC0460a.m1698b(f1039e + "|disconnect");
        if (this.f1051k != null) {
            this.f1051k.mo4139h();
        }
        if (this.f1050j != null) {
            this.f1050j.mo4153h();
            if (this.f1050j.f1071j != null) {
                try {
                    this.f1050j.f1071j.mo4156a();
                } catch (Exception e) {
                }
            }
        }
        if (this.f1049i != null) {
            this.f1049i.mo4151h();
            if (this.f1049i.f1065i != null) {
                try {
                    this.f1049i.f1065i.mo4155a();
                } catch (Exception e2) {
                }
            }
        }
        if (this.f1048h != null) {
            try {
                if (!this.f1048h.isClosed()) {
                    this.f1048h.close();
                }
            } catch (Exception e3) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m1613h() {
        if (!this.f1052l) {
            this.f1052l = true;
            m1614i();
            C0535e.m2034a().mo4390b(false);
        }
    }

    /* renamed from: i */
    private void m1614i() {
        if (this.f1050j != null) {
            this.f1050j.f1071j = null;
            this.f1050j = null;
        }
        if (this.f1049i != null) {
            this.f1049i.f1065i = null;
            this.f1049i = null;
        }
        this.f1051k = null;
        this.f1048h = null;
        this.f1047g = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public boolean m1617j() {
        return (this.f1051k == null || this.f1051k.f1028e) && (this.f1049i == null || this.f1049i.f1028e) && (this.f1050j == null || this.f1050j.f1028e);
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public boolean m1618k() {
        return this.f1048h != null && !this.f1048h.isClosed();
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m1619l() {
        C0456c.m1661b().mo4221e();
        ActivityC0460a.m1698b(f1039e + "|cancel alrm");
        synchronized (f1041n) {
            if (!this.f1045d.isEmpty()) {
                for (C0451k kVar : this.f1045d) {
                    kVar.mo4202p();
                }
                this.f1045d.clear();
            }
        }
        if (!f1040m.f1044c.isEmpty()) {
            Iterator<C0451k> it = f1040m.f1044c.iterator();
            while (it.hasNext()) {
                it.next().mo4202p();
            }
            f1040m.f1044c.clear();
        }
    }

    /* renamed from: a */
    public void mo4140a(C0451k kVar) {
        try {
            this.f1042a.lock();
            this.f1044c.offer(kVar);
            this.f1043b.signalAll();
            try {
                this.f1042a.unlock();
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            try {
                this.f1042a.unlock();
            } catch (Exception e3) {
            }
        } catch (Throwable th) {
            try {
                this.f1042a.unlock();
            } catch (Exception e4) {
            }
            throw th;
        }
    }

    /* renamed from: a */
    public void mo4141a(AbstractC0455b bVar) {
        this.f1046f = bVar;
        if (this.f1049i != null) {
            this.f1049i.f1066j = bVar;
        }
        if (this.f1050j != null) {
            this.f1050j.f1070i = bVar;
        }
    }

    /* renamed from: a */
    public void mo4142a(String str) {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (f1041n) {
            ActivityC0460a.m1698b(f1039e + "|" + str + " -- resp");
            Iterator<C0451k> it = this.f1045d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                C0451k next = it.next();
                if (next.f1115D.mo4183a(currentTimeMillis, next)) {
                    next.mo4202p();
                    next.f1115D.mo4182a(next);
                    z = true;
                    it.remove();
                    break;
                }
                long b = next.f1115D.mo4184b(currentTimeMillis, next);
                if (this.f1054p < 0 || this.f1054p > b) {
                    this.f1054p = b;
                }
            }
            C0456c.m1661b().mo4221e();
            if (z) {
                ActivityC0460a.m1698b(f1039e + "|time out");
                mo4146d();
                return;
            }
            if (this.f1045d.size() > 0) {
                C0451k kVar = this.f1045d.get(0);
                kVar.mo4202p();
                C0456c.m1661b().mo4218a(kVar);
                this.f1045d.remove(kVar);
                ActivityC0460a.m1698b(f1039e + "|remove : " + kVar.toString() + " -- " + kVar.f1088c.getClass().getSimpleName());
            }
            int size = this.f1045d.size();
            ActivityC0460a.m1698b(f1039e + "|r, size = " + size);
            if (size > 0 && this.f1054p > 0) {
                ActivityC0460a.m1698b(f1039e + "|set alarm = " + this.f1054p);
                C0456c.m1661b().mo4219b(currentTimeMillis + this.f1054p + C0471e.f1139u);
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo4143a(boolean z) {
        ActivityC0460a.m1698b(f1039e + "|reconnect, reset = " + z);
        Message obtain = Message.obtain();
        obtain.obj = Boolean.valueOf(z);
        obtain.what = 5;
        this.f1053o.sendMessage(obtain);
    }

    /* renamed from: b */
    public synchronized void mo4144b() {
        this.f1053o.sendEmptyMessage(4);
    }

    /* renamed from: c */
    public void mo4145c() {
        this.f1053o.sendEmptyMessage(0);
    }

    /* renamed from: d */
    public synchronized void mo4146d() {
        ActivityC0460a.m1698b(f1039e + "|alarm timeout disconnect");
        this.f1053o.sendEmptyMessage(4);
    }
}
