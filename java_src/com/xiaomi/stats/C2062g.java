package com.xiaomi.stats;

import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.channel.commonutils.string.C1870a;
import com.xiaomi.push.service.C1987w;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.thrift.C1998b;
import com.xiaomi.push.thrift.C2000c;
import com.xiaomi.push.thrift.EnumC1997a;
import com.xiaomi.stats.C2056c;
import com.xiaomi.xmpush.thrift.C2103u;
import java.util.Hashtable;

/* renamed from: com.xiaomi.stats.g */
public class C2062g {

    /* renamed from: a */
    private static final int f5504a = EnumC1997a.PING_RTT.mo10447a();

    /* access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.stats.g$a */
    public static class C2063a {

        /* renamed from: a */
        static Hashtable<Integer, Long> f5505a = new Hashtable<>();
    }

    /* renamed from: a */
    public static void m7759a() {
        m7761a(0, f5504a);
    }

    /* renamed from: a */
    public static void m7760a(int i) {
        C1998b f = C2059e.m7746a().mo10670f();
        f.mo10449a(EnumC1997a.CHANNEL_STATS_COUNTER.mo10447a());
        f.mo10459c(i);
        C2059e.m7746a().mo10666a(f);
    }

    /* renamed from: a */
    public static synchronized void m7761a(int i, int i2) {
        synchronized (C2062g.class) {
            if (i2 < 16777215) {
                C2063a.f5505a.put(Integer.valueOf((i << 24) | i2), Long.valueOf(System.currentTimeMillis()));
            } else {
                AbstractC1855b.m6723d("stats key should less than 16777215");
            }
        }
    }

    /* renamed from: a */
    public static void m7762a(int i, int i2, int i3, String str, int i4) {
        C1998b f = C2059e.m7746a().mo10670f();
        f.mo10448a((byte) i);
        f.mo10449a(i2);
        f.mo10455b(i3);
        f.mo10456b(str);
        f.mo10459c(i4);
        C2059e.m7746a().mo10666a(f);
    }

    /* renamed from: a */
    public static synchronized void m7763a(int i, int i2, String str, int i3) {
        synchronized (C2062g.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (C2063a.f5505a.containsKey(Integer.valueOf(i4))) {
                C1998b f = C2059e.m7746a().mo10670f();
                f.mo10449a(i2);
                f.mo10455b((int) (currentTimeMillis - C2063a.f5505a.get(Integer.valueOf(i4)).longValue()));
                f.mo10456b(str);
                if (i3 > -1) {
                    f.mo10459c(i3);
                }
                C2059e.m7746a().mo10666a(f);
                C2063a.f5505a.remove(Integer.valueOf(i2));
            } else {
                AbstractC1855b.m6723d("stats key not found");
            }
        }
    }

    /* renamed from: a */
    public static void m7764a(XMPushService xMPushService, C1987w.C1989b bVar) {
        new C2053a(xMPushService, bVar).mo10662a();
    }

    /* renamed from: a */
    public static void m7765a(String str, int i, Exception exc) {
        C1998b f = C2059e.m7746a().mo10670f();
        if (i > 0) {
            f.mo10449a(EnumC1997a.GSLB_REQUEST_SUCCESS.mo10447a());
            f.mo10456b(str);
            f.mo10455b(i);
            C2059e.m7746a().mo10666a(f);
            return;
        }
        try {
            C2056c.C2057a a = C2056c.m7735a(exc);
            f.mo10449a(a.f5490a.mo10447a());
            f.mo10460c(a.f5491b);
            f.mo10456b(str);
            C2059e.m7746a().mo10666a(f);
        } catch (NullPointerException e) {
        }
    }

    /* renamed from: a */
    public static void m7766a(String str, Exception exc) {
        try {
            C2056c.C2057a b = C2056c.m7736b(exc);
            C1998b f = C2059e.m7746a().mo10670f();
            f.mo10449a(b.f5490a.mo10447a());
            f.mo10460c(b.f5491b);
            f.mo10456b(str);
            C2059e.m7746a().mo10666a(f);
        } catch (NullPointerException e) {
        }
    }

    /* renamed from: b */
    public static void m7767b() {
        m7763a(0, f5504a, null, -1);
    }

    /* renamed from: b */
    public static void m7768b(String str, Exception exc) {
        try {
            C2056c.C2057a d = C2056c.m7738d(exc);
            C1998b f = C2059e.m7746a().mo10670f();
            f.mo10449a(d.f5490a.mo10447a());
            f.mo10460c(d.f5491b);
            f.mo10456b(str);
            C2059e.m7746a().mo10666a(f);
        } catch (NullPointerException e) {
        }
    }

    /* renamed from: c */
    public static String m7769c() {
        byte[] a;
        C2000c e = C2059e.m7746a().mo10669e();
        if (e == null || (a = C2103u.m8169a(e)) == null) {
            return null;
        }
        String str = new String(C1870a.m6774a(a));
        AbstractC1855b.m6718a("stat encoded size = " + str.length());
        AbstractC1855b.m6722c(str);
        return str;
    }
}
