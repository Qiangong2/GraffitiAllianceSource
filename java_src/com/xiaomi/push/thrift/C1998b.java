package com.xiaomi.push.thrift;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.thrift.AbstractC2158b;
import org.apache.thrift.C2159c;
import org.apache.thrift.meta_data.C2167b;
import org.apache.thrift.meta_data.C2168c;
import org.apache.thrift.protocol.AbstractC2180f;
import org.apache.thrift.protocol.C2177c;
import org.apache.thrift.protocol.C2181g;
import org.apache.thrift.protocol.C2183i;
import org.apache.thrift.protocol.C2185k;

/* renamed from: com.xiaomi.push.thrift.b */
public class C1998b implements Serializable, Cloneable, AbstractC2158b<C1998b, EnumC1999a> {

    /* renamed from: k */
    public static final Map<EnumC1999a, C2167b> f5236k;

    /* renamed from: l */
    private static final C2185k f5237l = new C2185k("StatsEvent");

    /* renamed from: m */
    private static final C2177c f5238m = new C2177c("chid", (byte) 3, 1);

    /* renamed from: n */
    private static final C2177c f5239n = new C2177c("type", (byte) 8, 2);

    /* renamed from: o */
    private static final C2177c f5240o = new C2177c("value", (byte) 8, 3);

    /* renamed from: p */
    private static final C2177c f5241p = new C2177c("connpt", (byte) 11, 4);

    /* renamed from: q */
    private static final C2177c f5242q = new C2177c("host", (byte) 11, 5);

    /* renamed from: r */
    private static final C2177c f5243r = new C2177c("subvalue", (byte) 8, 6);

    /* renamed from: s */
    private static final C2177c f5244s = new C2177c("annotation", (byte) 11, 7);

    /* renamed from: t */
    private static final C2177c f5245t = new C2177c("user", (byte) 11, 8);

    /* renamed from: u */
    private static final C2177c f5246u = new C2177c("time", (byte) 8, 9);

    /* renamed from: v */
    private static final C2177c f5247v = new C2177c("clientIp", (byte) 8, 10);

    /* renamed from: a */
    public byte f5248a;

    /* renamed from: b */
    public int f5249b;

    /* renamed from: c */
    public int f5250c;

    /* renamed from: d */
    public String f5251d;

    /* renamed from: e */
    public String f5252e;

    /* renamed from: f */
    public int f5253f;

    /* renamed from: g */
    public String f5254g;

    /* renamed from: h */
    public String f5255h;

    /* renamed from: i */
    public int f5256i;

    /* renamed from: j */
    public int f5257j;

    /* renamed from: w */
    private BitSet f5258w = new BitSet(6);

    /* renamed from: com.xiaomi.push.thrift.b$a */
    public enum EnumC1999a {
        CHID(1, "chid"),
        TYPE(2, "type"),
        VALUE(3, "value"),
        CONNPT(4, "connpt"),
        HOST(5, "host"),
        SUBVALUE(6, "subvalue"),
        ANNOTATION(7, "annotation"),
        USER(8, "user"),
        TIME(9, "time"),
        CLIENT_IP(10, "clientIp");
        

        /* renamed from: k */
        private static final Map<String, EnumC1999a> f5269k = new HashMap();

        /* renamed from: l */
        private final short f5271l;

        /* renamed from: m */
        private final String f5272m;

        static {
            Iterator it = EnumSet.allOf(EnumC1999a.class).iterator();
            while (it.hasNext()) {
                EnumC1999a aVar = (EnumC1999a) it.next();
                f5269k.put(aVar.mo10481a(), aVar);
            }
        }

        private EnumC1999a(short s, String str) {
            this.f5271l = s;
            this.f5272m = str;
        }

        /* renamed from: a */
        public String mo10481a() {
            return this.f5272m;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC1999a.class);
        enumMap.put((Object) EnumC1999a.CHID, (Object) new C2167b("chid", (byte) 1, new C2168c((byte) 3)));
        enumMap.put((Object) EnumC1999a.TYPE, (Object) new C2167b("type", (byte) 1, new C2168c((byte) 8)));
        enumMap.put((Object) EnumC1999a.VALUE, (Object) new C2167b("value", (byte) 1, new C2168c((byte) 8)));
        enumMap.put((Object) EnumC1999a.CONNPT, (Object) new C2167b("connpt", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC1999a.HOST, (Object) new C2167b("host", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC1999a.SUBVALUE, (Object) new C2167b("subvalue", (byte) 2, new C2168c((byte) 8)));
        enumMap.put((Object) EnumC1999a.ANNOTATION, (Object) new C2167b("annotation", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC1999a.USER, (Object) new C2167b("user", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC1999a.TIME, (Object) new C2167b("time", (byte) 2, new C2168c((byte) 8)));
        enumMap.put((Object) EnumC1999a.CLIENT_IP, (Object) new C2167b("clientIp", (byte) 2, new C2168c((byte) 8)));
        f5236k = Collections.unmodifiableMap(enumMap);
        C2167b.m8203a(C1998b.class, f5236k);
    }

    /* renamed from: a */
    public C1998b mo10448a(byte b) {
        this.f5248a = b;
        mo10451a(true);
        return this;
    }

    /* renamed from: a */
    public C1998b mo10449a(int i) {
        this.f5249b = i;
        mo10457b(true);
        return this;
    }

    /* renamed from: a */
    public C1998b mo10450a(String str) {
        this.f5251d = str;
        return this;
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: a */
    public void mo9945a(AbstractC2180f fVar) {
        fVar.mo12145g();
        while (true) {
            C2177c i = fVar.mo12147i();
            if (i.f6210b == 0) {
                fVar.mo12146h();
                if (!mo10452a()) {
                    throw new C2181g("Required field 'chid' was not found in serialized data! Struct: " + toString());
                } else if (!mo10458b()) {
                    throw new C2181g("Required field 'type' was not found in serialized data! Struct: " + toString());
                } else if (!mo10462c()) {
                    throw new C2181g("Required field 'value' was not found in serialized data! Struct: " + toString());
                } else {
                    mo10479k();
                    return;
                }
            } else {
                switch (i.f6211c) {
                    case 1:
                        if (i.f6210b != 3) {
                            C2183i.m8338a(fVar, i.f6210b);
                            break;
                        } else {
                            this.f5248a = fVar.mo12156r();
                            mo10451a(true);
                            break;
                        }
                    case 2:
                        if (i.f6210b != 8) {
                            C2183i.m8338a(fVar, i.f6210b);
                            break;
                        } else {
                            this.f5249b = fVar.mo12158t();
                            mo10457b(true);
                            break;
                        }
                    case 3:
                        if (i.f6210b != 8) {
                            C2183i.m8338a(fVar, i.f6210b);
                            break;
                        } else {
                            this.f5250c = fVar.mo12158t();
                            mo10461c(true);
                            break;
                        }
                    case 4:
                        if (i.f6210b != 11) {
                            C2183i.m8338a(fVar, i.f6210b);
                            break;
                        } else {
                            this.f5251d = fVar.mo12161w();
                            break;
                        }
                    case 5:
                        if (i.f6210b != 11) {
                            C2183i.m8338a(fVar, i.f6210b);
                            break;
                        } else {
                            this.f5252e = fVar.mo12161w();
                            break;
                        }
                    case 6:
                        if (i.f6210b != 8) {
                            C2183i.m8338a(fVar, i.f6210b);
                            break;
                        } else {
                            this.f5253f = fVar.mo12158t();
                            mo10466d(true);
                            break;
                        }
                    case 7:
                        if (i.f6210b != 11) {
                            C2183i.m8338a(fVar, i.f6210b);
                            break;
                        } else {
                            this.f5254g = fVar.mo12161w();
                            break;
                        }
                    case 8:
                        if (i.f6210b != 11) {
                            C2183i.m8338a(fVar, i.f6210b);
                            break;
                        } else {
                            this.f5255h = fVar.mo12161w();
                            break;
                        }
                    case 9:
                        if (i.f6210b != 8) {
                            C2183i.m8338a(fVar, i.f6210b);
                            break;
                        } else {
                            this.f5256i = fVar.mo12158t();
                            mo10469e(true);
                            break;
                        }
                    case 10:
                        if (i.f6210b != 8) {
                            C2183i.m8338a(fVar, i.f6210b);
                            break;
                        } else {
                            this.f5257j = fVar.mo12158t();
                            mo10472f(true);
                            break;
                        }
                    default:
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                }
                fVar.mo12148j();
            }
        }
    }

    /* renamed from: a */
    public void mo10451a(boolean z) {
        this.f5258w.set(0, z);
    }

    /* renamed from: a */
    public boolean mo10452a() {
        return this.f5258w.get(0);
    }

    /* renamed from: a */
    public boolean mo10453a(C1998b bVar) {
        if (bVar == null || this.f5248a != bVar.f5248a || this.f5249b != bVar.f5249b || this.f5250c != bVar.f5250c) {
            return false;
        }
        boolean d = mo10467d();
        boolean d2 = bVar.mo10467d();
        if ((d || d2) && (!d || !d2 || !this.f5251d.equals(bVar.f5251d))) {
            return false;
        }
        boolean e = mo10470e();
        boolean e2 = bVar.mo10470e();
        if ((e || e2) && (!e || !e2 || !this.f5252e.equals(bVar.f5252e))) {
            return false;
        }
        boolean f = mo10473f();
        boolean f2 = bVar.mo10473f();
        if ((f || f2) && (!f || !f2 || this.f5253f != bVar.f5253f)) {
            return false;
        }
        boolean g = mo10474g();
        boolean g2 = bVar.mo10474g();
        if ((g || g2) && (!g || !g2 || !this.f5254g.equals(bVar.f5254g))) {
            return false;
        }
        boolean h = mo10475h();
        boolean h2 = bVar.mo10475h();
        if ((h || h2) && (!h || !h2 || !this.f5255h.equals(bVar.f5255h))) {
            return false;
        }
        boolean i = mo10477i();
        boolean i2 = bVar.mo10477i();
        if ((i || i2) && (!i || !i2 || this.f5256i != bVar.f5256i)) {
            return false;
        }
        boolean j = mo10478j();
        boolean j2 = bVar.mo10478j();
        return (!j && !j2) || (j && j2 && this.f5257j == bVar.f5257j);
    }

    /* renamed from: b */
    public int compareTo(C1998b bVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (!getClass().equals(bVar.getClass())) {
            return getClass().getName().compareTo(bVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo10452a()).compareTo(Boolean.valueOf(bVar.mo10452a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo10452a() && (a10 = C2159c.m8183a(this.f5248a, bVar.f5248a)) != 0) {
            return a10;
        }
        int compareTo2 = Boolean.valueOf(mo10458b()).compareTo(Boolean.valueOf(bVar.mo10458b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo10458b() && (a9 = C2159c.m8184a(this.f5249b, bVar.f5249b)) != 0) {
            return a9;
        }
        int compareTo3 = Boolean.valueOf(mo10462c()).compareTo(Boolean.valueOf(bVar.mo10462c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo10462c() && (a8 = C2159c.m8184a(this.f5250c, bVar.f5250c)) != 0) {
            return a8;
        }
        int compareTo4 = Boolean.valueOf(mo10467d()).compareTo(Boolean.valueOf(bVar.mo10467d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo10467d() && (a7 = C2159c.m8187a(this.f5251d, bVar.f5251d)) != 0) {
            return a7;
        }
        int compareTo5 = Boolean.valueOf(mo10470e()).compareTo(Boolean.valueOf(bVar.mo10470e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo10470e() && (a6 = C2159c.m8187a(this.f5252e, bVar.f5252e)) != 0) {
            return a6;
        }
        int compareTo6 = Boolean.valueOf(mo10473f()).compareTo(Boolean.valueOf(bVar.mo10473f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo10473f() && (a5 = C2159c.m8184a(this.f5253f, bVar.f5253f)) != 0) {
            return a5;
        }
        int compareTo7 = Boolean.valueOf(mo10474g()).compareTo(Boolean.valueOf(bVar.mo10474g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo10474g() && (a4 = C2159c.m8187a(this.f5254g, bVar.f5254g)) != 0) {
            return a4;
        }
        int compareTo8 = Boolean.valueOf(mo10475h()).compareTo(Boolean.valueOf(bVar.mo10475h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (mo10475h() && (a3 = C2159c.m8187a(this.f5255h, bVar.f5255h)) != 0) {
            return a3;
        }
        int compareTo9 = Boolean.valueOf(mo10477i()).compareTo(Boolean.valueOf(bVar.mo10477i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (mo10477i() && (a2 = C2159c.m8184a(this.f5256i, bVar.f5256i)) != 0) {
            return a2;
        }
        int compareTo10 = Boolean.valueOf(mo10478j()).compareTo(Boolean.valueOf(bVar.mo10478j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!mo10478j() || (a = C2159c.m8184a(this.f5257j, bVar.f5257j)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: b */
    public C1998b mo10455b(int i) {
        this.f5250c = i;
        mo10461c(true);
        return this;
    }

    /* renamed from: b */
    public C1998b mo10456b(String str) {
        this.f5252e = str;
        return this;
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: b */
    public void mo9950b(AbstractC2180f fVar) {
        mo10479k();
        fVar.mo12134a(f5237l);
        fVar.mo12130a(f5238m);
        fVar.mo12125a(this.f5248a);
        fVar.mo12138b();
        fVar.mo12130a(f5239n);
        fVar.mo12126a(this.f5249b);
        fVar.mo12138b();
        fVar.mo12130a(f5240o);
        fVar.mo12126a(this.f5250c);
        fVar.mo12138b();
        if (this.f5251d != null) {
            fVar.mo12130a(f5241p);
            fVar.mo12128a(this.f5251d);
            fVar.mo12138b();
        }
        if (this.f5252e != null && mo10470e()) {
            fVar.mo12130a(f5242q);
            fVar.mo12128a(this.f5252e);
            fVar.mo12138b();
        }
        if (mo10473f()) {
            fVar.mo12130a(f5243r);
            fVar.mo12126a(this.f5253f);
            fVar.mo12138b();
        }
        if (this.f5254g != null && mo10474g()) {
            fVar.mo12130a(f5244s);
            fVar.mo12128a(this.f5254g);
            fVar.mo12138b();
        }
        if (this.f5255h != null && mo10475h()) {
            fVar.mo12130a(f5245t);
            fVar.mo12128a(this.f5255h);
            fVar.mo12138b();
        }
        if (mo10477i()) {
            fVar.mo12130a(f5246u);
            fVar.mo12126a(this.f5256i);
            fVar.mo12138b();
        }
        if (mo10478j()) {
            fVar.mo12130a(f5247v);
            fVar.mo12126a(this.f5257j);
            fVar.mo12138b();
        }
        fVar.mo12139c();
        fVar.mo12124a();
    }

    /* renamed from: b */
    public void mo10457b(boolean z) {
        this.f5258w.set(1, z);
    }

    /* renamed from: b */
    public boolean mo10458b() {
        return this.f5258w.get(1);
    }

    /* renamed from: c */
    public C1998b mo10459c(int i) {
        this.f5253f = i;
        mo10466d(true);
        return this;
    }

    /* renamed from: c */
    public C1998b mo10460c(String str) {
        this.f5254g = str;
        return this;
    }

    /* renamed from: c */
    public void mo10461c(boolean z) {
        this.f5258w.set(2, z);
    }

    /* renamed from: c */
    public boolean mo10462c() {
        return this.f5258w.get(2);
    }

    /* renamed from: d */
    public C1998b mo10464d(int i) {
        this.f5256i = i;
        mo10469e(true);
        return this;
    }

    /* renamed from: d */
    public C1998b mo10465d(String str) {
        this.f5255h = str;
        return this;
    }

    /* renamed from: d */
    public void mo10466d(boolean z) {
        this.f5258w.set(3, z);
    }

    /* renamed from: d */
    public boolean mo10467d() {
        return this.f5251d != null;
    }

    /* renamed from: e */
    public C1998b mo10468e(int i) {
        this.f5257j = i;
        mo10472f(true);
        return this;
    }

    /* renamed from: e */
    public void mo10469e(boolean z) {
        this.f5258w.set(4, z);
    }

    /* renamed from: e */
    public boolean mo10470e() {
        return this.f5252e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1998b)) {
            return mo10453a((C1998b) obj);
        }
        return false;
    }

    /* renamed from: f */
    public void mo10472f(boolean z) {
        this.f5258w.set(5, z);
    }

    /* renamed from: f */
    public boolean mo10473f() {
        return this.f5258w.get(3);
    }

    /* renamed from: g */
    public boolean mo10474g() {
        return this.f5254g != null;
    }

    /* renamed from: h */
    public boolean mo10475h() {
        return this.f5255h != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean mo10477i() {
        return this.f5258w.get(4);
    }

    /* renamed from: j */
    public boolean mo10478j() {
        return this.f5258w.get(5);
    }

    /* renamed from: k */
    public void mo10479k() {
        if (this.f5251d == null) {
            throw new C2181g("Required field 'connpt' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvent(");
        sb.append("chid:");
        sb.append((int) this.f5248a);
        sb.append(", ");
        sb.append("type:");
        sb.append(this.f5249b);
        sb.append(", ");
        sb.append("value:");
        sb.append(this.f5250c);
        sb.append(", ");
        sb.append("connpt:");
        if (this.f5251d == null) {
            sb.append("null");
        } else {
            sb.append(this.f5251d);
        }
        if (mo10470e()) {
            sb.append(", ");
            sb.append("host:");
            if (this.f5252e == null) {
                sb.append("null");
            } else {
                sb.append(this.f5252e);
            }
        }
        if (mo10473f()) {
            sb.append(", ");
            sb.append("subvalue:");
            sb.append(this.f5253f);
        }
        if (mo10474g()) {
            sb.append(", ");
            sb.append("annotation:");
            if (this.f5254g == null) {
                sb.append("null");
            } else {
                sb.append(this.f5254g);
            }
        }
        if (mo10475h()) {
            sb.append(", ");
            sb.append("user:");
            if (this.f5255h == null) {
                sb.append("null");
            } else {
                sb.append(this.f5255h);
            }
        }
        if (mo10477i()) {
            sb.append(", ");
            sb.append("time:");
            sb.append(this.f5256i);
        }
        if (mo10478j()) {
            sb.append(", ");
            sb.append("clientIp:");
            sb.append(this.f5257j);
        }
        sb.append(")");
        return sb.toString();
    }
}
