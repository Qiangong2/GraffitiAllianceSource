package com.igexin.push.p026c;

import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.util.C1151a;
import java.util.List;

/* renamed from: com.igexin.push.c.i */
public class C0494i {

    /* renamed from: a */
    public static boolean f1231a;

    /* renamed from: b */
    private static final String f1232b = C0494i.class.getName();

    /* renamed from: c */
    private static C0494i f1233c;

    /* renamed from: d */
    private static EnumC0493h f1234d;

    private C0494i() {
        mo4278b();
        if (C1151a.m4751d()) {
            f1234d = EnumC0493h.WIFI;
        } else {
            f1234d = EnumC0493h.MOBILE;
        }
    }

    /* renamed from: a */
    public static synchronized C0494i m1834a() {
        C0494i iVar;
        synchronized (C0494i.class) {
            if (f1233c == null) {
                f1233c = new C0494i();
            }
            iVar = f1233c;
        }
        return iVar;
    }

    /* renamed from: b */
    public void mo4278b() {
        f1231a = SDKUrlConfig.realXfrListIsOnly();
    }

    /* renamed from: c */
    public void mo4279c() {
        if (f1231a) {
            ActivityC0460a.m1698b(f1232b + "|xfr len = 1, detect = false");
        } else {
            C0456c.m1661b().mo4216a(C0496k.m1863c_(), false, true);
        }
    }

    /* renamed from: d */
    public void mo4280d() {
        try {
            mo4285i().mo4314d();
        } catch (Throwable th) {
            ActivityC0460a.m1698b(f1232b + "|" + th.toString());
        }
    }

    /* renamed from: e */
    public C0486a mo4281e() {
        return mo4285i().f1255d;
    }

    /* renamed from: f */
    public boolean mo4282f() {
        if (f1231a) {
            return false;
        }
        AbstractC0498m i = mo4285i();
        if (!i.mo4323m()) {
            ActivityC0460a.m1698b(f1232b + "|startDetect detect = false");
            return false;
        }
        ActivityC0460a.m1698b(f1232b + "|network changed detect = true, reset detect delay");
        i.mo4316f();
        return true;
    }

    /* renamed from: g */
    public String mo4283g() {
        C0495j g;
        if (f1231a) {
            return SDKUrlConfig.getXfrAddress()[0];
        }
        AbstractC0498m i = mo4285i();
        if (i == null || (g = i.mo4317g()) == null) {
            return null;
        }
        return g.mo4301g();
    }

    /* renamed from: h */
    public void mo4284h() {
        mo4278b();
        if (f1231a) {
            C0496k.m1863c_().mo4306g();
            try {
                C0497l.m1868a().f1255d.mo4263a((List<C0490e>) null);
                C0503r.m1935a().f1255d.mo4263a((List<C0490e>) null);
                C0503r.m1935a().mo4319i();
                C0497l.m1868a().mo4319i();
                C0503r.m1935a().mo4322l();
            } catch (Throwable th) {
                ActivityC0460a.m1698b(f1232b + "|" + th.toString());
            }
        } else {
            try {
                C0503r.m1935a().mo4322l();
                C0503r.m1935a().mo4318h();
                C0497l.m1868a().mo4318h();
                AbstractC0498m i = mo4285i();
                if (i != null) {
                    i.mo4320j();
                }
            } catch (Throwable th2) {
                ActivityC0460a.m1698b(f1232b + "|" + th2.toString());
            }
        }
    }

    /* renamed from: i */
    public AbstractC0498m mo4285i() {
        AbstractC0498m a;
        if (C1151a.m4751d()) {
            ActivityC0460a.m1698b(f1232b + "|wifi state");
            a = C0503r.m1935a();
        } else {
            ActivityC0460a.m1698b(f1232b + "|mobile state");
            a = C0497l.m1868a();
        }
        EnumC0493h b = a.mo4309b();
        if (b != f1234d) {
            if (b == EnumC0493h.WIFI) {
                C0497l.m1868a().mo4315e();
            } else if (b == EnumC0493h.MOBILE) {
                C0503r.m1935a().mo4315e();
            }
        }
        f1234d = b;
        return a;
    }
}
