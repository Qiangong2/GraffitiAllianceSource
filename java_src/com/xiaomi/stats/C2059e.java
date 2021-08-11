package com.xiaomi.stats;

import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.channel.commonutils.network.C1865d;
import com.xiaomi.channel.commonutils.stats.C1868a;
import com.xiaomi.push.service.C1951af;
import com.xiaomi.push.service.C1968f;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.thrift.C1998b;
import com.xiaomi.push.thrift.C2000c;
import com.xiaomi.push.thrift.EnumC1997a;
import com.xiaomi.smack.C2019l;
import com.xiaomi.smack.util.C2046h;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import org.apache.thrift.C2164f;
import org.apache.thrift.protocol.AbstractC2180f;
import org.apache.thrift.protocol.C2186l;
import org.apache.thrift.transport.C2189b;

/* renamed from: com.xiaomi.stats.e */
public class C2059e {

    /* renamed from: a */
    private String f5496a;

    /* renamed from: b */
    private boolean f5497b = false;

    /* renamed from: c */
    private int f5498c;

    /* renamed from: d */
    private long f5499d;

    /* renamed from: e */
    private C2058d f5500e;

    /* renamed from: f */
    private C1868a f5501f = C1868a.m6765a();

    /* access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.stats.e$a */
    public static class C2060a {

        /* renamed from: a */
        static final C2059e f5502a = new C2059e();
    }

    /* renamed from: a */
    private C1998b m7745a(C1868a.C1869a aVar) {
        if (aVar.f4639a != 0) {
            C1998b f = mo10670f();
            f.mo10449a(EnumC1997a.CHANNEL_STATS_COUNTER.mo10447a());
            f.mo10459c(aVar.f4639a);
            f.mo10460c(aVar.f4640b);
            return f;
        } else if (aVar.f4641c instanceof C1998b) {
            return (C1998b) aVar.f4641c;
        } else {
            return null;
        }
    }

    /* renamed from: a */
    public static C2059e m7746a() {
        return C2060a.f5502a;
    }

    /* renamed from: b */
    private C2000c m7747b(int i) {
        ArrayList arrayList = new ArrayList();
        C2000c cVar = new C2000c(this.f5496a, arrayList);
        if (!C1865d.m6763e(this.f5500e.f5492a)) {
            cVar.mo10482a(C1968f.m7325d(this.f5500e.f5492a));
        }
        C2189b bVar = new C2189b(i);
        AbstractC2180f a = new C2186l.C2187a().mo12163a(bVar);
        try {
            cVar.mo9950b(a);
        } catch (C2164f e) {
        }
        LinkedList<C1868a.C1869a> c = this.f5501f.mo9944c();
        while (c.size() > 0) {
            try {
                C1998b a2 = m7745a(c.getLast());
                if (a2 != null) {
                    a2.mo9950b(a);
                }
                if (bVar.mo12170a_() > i) {
                    break;
                }
                if (a2 != null) {
                    arrayList.add(a2);
                }
                c.removeLast();
            } catch (NoSuchElementException | C2164f e2) {
            }
        }
        AbstractC1855b.m6718a("stat approximate size = " + bVar.mo12170a_());
        return cVar;
    }

    /* renamed from: b */
    static C2058d m7748b() {
        return C2060a.f5502a.f5500e;
    }

    /* renamed from: g */
    private void m7749g() {
        if (this.f5499d == 0) {
            this.f5499d = System.currentTimeMillis();
        }
    }

    /* renamed from: h */
    private void m7750h() {
        if (this.f5497b && System.currentTimeMillis() - this.f5499d > ((long) this.f5498c)) {
            this.f5497b = false;
            this.f5499d = 0;
        }
    }

    /* renamed from: a */
    public void mo10664a(int i) {
        int i2 = 604800000;
        if (i > 0) {
            this.f5497b = true;
            int i3 = i * 1000;
            if (i3 <= 604800000) {
                i2 = i3;
            }
            if (this.f5498c != i2) {
                this.f5498c = i2;
                m7749g();
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo10665a(XMPushService xMPushService, C2019l lVar) {
        this.f5500e = new C2058d(xMPushService);
        this.f5496a = "";
        if (lVar != null) {
            lVar.mo10497a(this.f5500e);
        }
        C1951af.m7272a().mo10388a(new C2061f(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo10666a(C1998b bVar) {
        this.f5501f.mo9942a(bVar);
    }

    /* renamed from: c */
    public boolean mo10667c() {
        return this.f5497b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo10668d() {
        m7750h();
        return this.f5497b && this.f5501f.mo9943b() > 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public synchronized C2000c mo10669e() {
        C2000c cVar;
        cVar = null;
        if (mo10668d()) {
            int i = 750;
            if (!C1865d.m6763e(C2046h.m7706a())) {
                i = 375;
            }
            cVar = m7747b(i);
        }
        return cVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public C1998b mo10670f() {
        C1998b bVar = new C1998b();
        bVar.mo10450a(C1865d.m6764f(this.f5500e.f5492a));
        bVar.f5248a = 0;
        bVar.f5250c = 1;
        bVar.mo10464d((int) (System.currentTimeMillis() / 1000));
        if (this.f5500e.f5493b != null) {
            bVar.mo10468e(this.f5500e.f5493b.mo10511e());
        }
        return bVar;
    }
}
