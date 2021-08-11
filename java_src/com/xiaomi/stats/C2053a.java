package com.xiaomi.stats;

import com.xiaomi.push.service.C1987w;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.thrift.C1998b;
import com.xiaomi.push.thrift.EnumC1997a;
import com.xiaomi.smack.AbstractC2002a;
import com.xiaomi.stats.C2056c;

/* access modifiers changed from: package-private */
/* renamed from: com.xiaomi.stats.a */
public class C2053a implements C1987w.C1989b.AbstractC1990a {

    /* renamed from: a */
    private XMPushService f5482a;

    /* renamed from: b */
    private C1987w.C1989b f5483b;

    /* renamed from: c */
    private AbstractC2002a f5484c;

    /* renamed from: d */
    private C1987w.EnumC1991c f5485d;

    /* renamed from: e */
    private int f5486e;

    /* renamed from: f */
    private boolean f5487f = false;

    C2053a(XMPushService xMPushService, C1987w.C1989b bVar) {
        this.f5482a = xMPushService;
        this.f5485d = C1987w.EnumC1991c.binding;
        this.f5483b = bVar;
    }

    /* renamed from: b */
    private void m7729b() {
        this.f5483b.mo10446b(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m7730c() {
        m7729b();
        if (this.f5487f && this.f5486e != 11) {
            C1998b f = C2059e.m7746a().mo10670f();
            switch (this.f5485d) {
                case unbind:
                    if (this.f5486e != 17) {
                        if (this.f5486e != 21) {
                            try {
                                C2056c.C2057a c = C2056c.m7737c(C2059e.m7748b().mo10663a());
                                f.f5249b = c.f5490a.mo10447a();
                                f.mo10460c(c.f5491b);
                                break;
                            } catch (NullPointerException e) {
                                f = null;
                                break;
                            }
                        } else {
                            f.f5249b = EnumC1997a.BIND_TIMEOUT.mo10447a();
                            break;
                        }
                    } else {
                        f.f5249b = EnumC1997a.BIND_TCP_READ_TIMEOUT.mo10447a();
                        break;
                    }
                case binded:
                    f.f5249b = EnumC1997a.BIND_SUCCESS.mo10447a();
                    break;
            }
            if (f != null) {
                f.mo10456b(this.f5484c.mo10509c());
                f.mo10465d(this.f5483b.f5128b);
                f.f5250c = 1;
                try {
                    f.mo10448a((byte) Integer.parseInt(this.f5483b.f5134h));
                } catch (NumberFormatException e2) {
                }
                C2059e.m7746a().mo10666a(f);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10662a() {
        this.f5483b.mo10444a(this);
        this.f5484c = this.f5482a.mo10369g();
    }

    @Override // com.xiaomi.push.service.C1987w.C1989b.AbstractC1990a
    /* renamed from: a */
    public void mo10396a(C1987w.EnumC1991c cVar, C1987w.EnumC1991c cVar2, int i) {
        if (!this.f5487f && cVar == C1987w.EnumC1991c.binding) {
            this.f5485d = cVar2;
            this.f5486e = i;
            this.f5487f = true;
        }
        this.f5482a.mo10350a(new C2055b(this, 4));
    }
}
