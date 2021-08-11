package com.xiaomi.common.logger.thrift.mfs;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.thrift.AbstractC2158b;
import org.apache.thrift.C2159c;
import org.apache.thrift.meta_data.C2167b;
import org.apache.thrift.meta_data.C2168c;
import org.apache.thrift.meta_data.C2171f;
import org.apache.thrift.meta_data.C2172g;
import org.apache.thrift.protocol.AbstractC2180f;
import org.apache.thrift.protocol.C2177c;
import org.apache.thrift.protocol.C2181g;
import org.apache.thrift.protocol.C2183i;
import org.apache.thrift.protocol.C2184j;
import org.apache.thrift.protocol.C2185k;

/* renamed from: com.xiaomi.common.logger.thrift.mfs.f */
public class C1886f implements Serializable, Cloneable, AbstractC2158b<C1886f, EnumC1887a> {

    /* renamed from: a */
    public static final Map<EnumC1887a, C2167b> f4779a;

    /* renamed from: b */
    private static final C2185k f4780b = new C2185k("Passport");

    /* renamed from: c */
    private static final C2177c f4781c = new C2177c("category", (byte) 11, 1);

    /* renamed from: d */
    private static final C2177c f4782d = new C2177c("uuid", (byte) 11, 2);

    /* renamed from: e */
    private static final C2177c f4783e = new C2177c("version", (byte) 11, 3);

    /* renamed from: f */
    private static final C2177c f4784f = new C2177c("network", (byte) 11, 4);

    /* renamed from: g */
    private static final C2177c f4785g = new C2177c("rid", (byte) 11, 5);

    /* renamed from: h */
    private static final C2177c f4786h = new C2177c("location", (byte) 12, 6);

    /* renamed from: i */
    private static final C2177c f4787i = new C2177c("host_info", (byte) 14, 7);

    /* renamed from: j */
    private String f4788j = "";

    /* renamed from: k */
    private String f4789k;

    /* renamed from: l */
    private String f4790l;

    /* renamed from: m */
    private String f4791m;

    /* renamed from: n */
    private String f4792n;

    /* renamed from: o */
    private C1884e f4793o;

    /* renamed from: p */
    private Set<C1888g> f4794p;

    /* renamed from: com.xiaomi.common.logger.thrift.mfs.f$a */
    public enum EnumC1887a {
        CATEGORY(1, "category"),
        UUID(2, "uuid"),
        VERSION(3, "version"),
        NETWORK(4, "network"),
        RID(5, "rid"),
        LOCATION(6, "location"),
        HOST_INFO(7, "host_info");
        

        /* renamed from: h */
        private static final Map<String, EnumC1887a> f4802h = new HashMap();

        /* renamed from: i */
        private final short f4804i;

        /* renamed from: j */
        private final String f4805j;

        static {
            Iterator it = EnumSet.allOf(EnumC1887a.class).iterator();
            while (it.hasNext()) {
                EnumC1887a aVar = (EnumC1887a) it.next();
                f4802h.put(aVar.mo10072a(), aVar);
            }
        }

        private EnumC1887a(short s, String str) {
            this.f4804i = s;
            this.f4805j = str;
        }

        /* renamed from: a */
        public String mo10072a() {
            return this.f4805j;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC1887a.class);
        enumMap.put((Object) EnumC1887a.CATEGORY, (Object) new C2167b("category", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC1887a.UUID, (Object) new C2167b("uuid", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC1887a.VERSION, (Object) new C2167b("version", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC1887a.NETWORK, (Object) new C2167b("network", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC1887a.RID, (Object) new C2167b("rid", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC1887a.LOCATION, (Object) new C2167b("location", (byte) 2, new C2172g((byte) 12, C1884e.class)));
        enumMap.put((Object) EnumC1887a.HOST_INFO, (Object) new C2167b("host_info", (byte) 2, new C2171f((byte) 14, new C2172g((byte) 12, C1888g.class))));
        f4779a = Collections.unmodifiableMap(enumMap);
        C2167b.m8203a(C1886f.class, f4779a);
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: a */
    public void mo9945a(AbstractC2180f fVar) {
        fVar.mo12145g();
        while (true) {
            C2177c i = fVar.mo12147i();
            if (i.f6210b == 0) {
                fVar.mo12146h();
                mo10069h();
                return;
            }
            switch (i.f6211c) {
                case 1:
                    if (i.f6210b == 11) {
                        this.f4788j = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 2:
                    if (i.f6210b == 11) {
                        this.f4789k = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 3:
                    if (i.f6210b == 11) {
                        this.f4790l = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 4:
                    if (i.f6210b == 11) {
                        this.f4791m = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 5:
                    if (i.f6210b == 11) {
                        this.f4792n = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 6:
                    if (i.f6210b == 12) {
                        this.f4793o = new C1884e();
                        this.f4793o.mo9945a(fVar);
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 7:
                    if (i.f6210b == 14) {
                        C2184j o = fVar.mo12153o();
                        this.f4794p = new HashSet(o.f6221b * 2);
                        for (int i2 = 0; i2 < o.f6221b; i2++) {
                            C1888g gVar = new C1888g();
                            gVar.mo9945a(fVar);
                            this.f4794p.add(gVar);
                        }
                        fVar.mo12154p();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                default:
                    C2183i.m8338a(fVar, i.f6210b);
                    break;
            }
            fVar.mo12148j();
        }
    }

    /* renamed from: a */
    public boolean mo10058a() {
        return this.f4788j != null;
    }

    /* renamed from: a */
    public boolean mo10059a(C1886f fVar) {
        if (fVar == null) {
            return false;
        }
        boolean a = mo10058a();
        boolean a2 = fVar.mo10058a();
        if ((a || a2) && (!a || !a2 || !this.f4788j.equals(fVar.f4788j))) {
            return false;
        }
        boolean b = mo10061b();
        boolean b2 = fVar.mo10061b();
        if ((b || b2) && (!b || !b2 || !this.f4789k.equals(fVar.f4789k))) {
            return false;
        }
        boolean c = mo10062c();
        boolean c2 = fVar.mo10062c();
        if ((c || c2) && (!c || !c2 || !this.f4790l.equals(fVar.f4790l))) {
            return false;
        }
        boolean d = mo10064d();
        boolean d2 = fVar.mo10064d();
        if ((d || d2) && (!d || !d2 || !this.f4791m.equals(fVar.f4791m))) {
            return false;
        }
        boolean e = mo10065e();
        boolean e2 = fVar.mo10065e();
        if ((e || e2) && (!e || !e2 || !this.f4792n.equals(fVar.f4792n))) {
            return false;
        }
        boolean f = mo10067f();
        boolean f2 = fVar.mo10067f();
        if ((f || f2) && (!f || !f2 || !this.f4793o.mo10044a(fVar.f4793o))) {
            return false;
        }
        boolean g = mo10068g();
        boolean g2 = fVar.mo10068g();
        return (!g && !g2) || (g && g2 && this.f4794p.equals(fVar.f4794p));
    }

    /* renamed from: b */
    public int compareTo(C1886f fVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        if (!getClass().equals(fVar.getClass())) {
            return getClass().getName().compareTo(fVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo10058a()).compareTo(Boolean.valueOf(fVar.mo10058a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo10058a() && (a7 = C2159c.m8187a(this.f4788j, fVar.f4788j)) != 0) {
            return a7;
        }
        int compareTo2 = Boolean.valueOf(mo10061b()).compareTo(Boolean.valueOf(fVar.mo10061b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo10061b() && (a6 = C2159c.m8187a(this.f4789k, fVar.f4789k)) != 0) {
            return a6;
        }
        int compareTo3 = Boolean.valueOf(mo10062c()).compareTo(Boolean.valueOf(fVar.mo10062c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo10062c() && (a5 = C2159c.m8187a(this.f4790l, fVar.f4790l)) != 0) {
            return a5;
        }
        int compareTo4 = Boolean.valueOf(mo10064d()).compareTo(Boolean.valueOf(fVar.mo10064d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo10064d() && (a4 = C2159c.m8187a(this.f4791m, fVar.f4791m)) != 0) {
            return a4;
        }
        int compareTo5 = Boolean.valueOf(mo10065e()).compareTo(Boolean.valueOf(fVar.mo10065e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo10065e() && (a3 = C2159c.m8187a(this.f4792n, fVar.f4792n)) != 0) {
            return a3;
        }
        int compareTo6 = Boolean.valueOf(mo10067f()).compareTo(Boolean.valueOf(fVar.mo10067f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo10067f() && (a2 = C2159c.m8186a(this.f4793o, fVar.f4793o)) != 0) {
            return a2;
        }
        int compareTo7 = Boolean.valueOf(mo10068g()).compareTo(Boolean.valueOf(fVar.mo10068g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (!mo10068g() || (a = C2159c.m8191a(this.f4794p, fVar.f4794p)) == 0) {
            return 0;
        }
        return a;
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: b */
    public void mo9950b(AbstractC2180f fVar) {
        mo10069h();
        fVar.mo12134a(f4780b);
        if (this.f4788j != null) {
            fVar.mo12130a(f4781c);
            fVar.mo12128a(this.f4788j);
            fVar.mo12138b();
        }
        if (this.f4789k != null) {
            fVar.mo12130a(f4782d);
            fVar.mo12128a(this.f4789k);
            fVar.mo12138b();
        }
        if (this.f4790l != null) {
            fVar.mo12130a(f4783e);
            fVar.mo12128a(this.f4790l);
            fVar.mo12138b();
        }
        if (this.f4791m != null) {
            fVar.mo12130a(f4784f);
            fVar.mo12128a(this.f4791m);
            fVar.mo12138b();
        }
        if (this.f4792n != null) {
            fVar.mo12130a(f4785g);
            fVar.mo12128a(this.f4792n);
            fVar.mo12138b();
        }
        if (this.f4793o != null && mo10067f()) {
            fVar.mo12130a(f4786h);
            this.f4793o.mo9950b(fVar);
            fVar.mo12138b();
        }
        if (this.f4794p != null && mo10068g()) {
            fVar.mo12130a(f4787i);
            fVar.mo12133a(new C2184j((byte) 12, this.f4794p.size()));
            for (C1888g gVar : this.f4794p) {
                gVar.mo9950b(fVar);
            }
            fVar.mo12144f();
            fVar.mo12138b();
        }
        fVar.mo12139c();
        fVar.mo12124a();
    }

    /* renamed from: b */
    public boolean mo10061b() {
        return this.f4789k != null;
    }

    /* renamed from: c */
    public boolean mo10062c() {
        return this.f4790l != null;
    }

    /* renamed from: d */
    public boolean mo10064d() {
        return this.f4791m != null;
    }

    /* renamed from: e */
    public boolean mo10065e() {
        return this.f4792n != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1886f)) {
            return mo10059a((C1886f) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo10067f() {
        return this.f4793o != null;
    }

    /* renamed from: g */
    public boolean mo10068g() {
        return this.f4794p != null;
    }

    /* renamed from: h */
    public void mo10069h() {
        if (this.f4788j == null) {
            throw new C2181g("Required field 'category' was not present! Struct: " + toString());
        } else if (this.f4789k == null) {
            throw new C2181g("Required field 'uuid' was not present! Struct: " + toString());
        } else if (this.f4790l == null) {
            throw new C2181g("Required field 'version' was not present! Struct: " + toString());
        } else if (this.f4791m == null) {
            throw new C2181g("Required field 'network' was not present! Struct: " + toString());
        } else if (this.f4792n == null) {
            throw new C2181g("Required field 'rid' was not present! Struct: " + toString());
        }
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Passport(");
        sb.append("category:");
        if (this.f4788j == null) {
            sb.append("null");
        } else {
            sb.append(this.f4788j);
        }
        sb.append(", ");
        sb.append("uuid:");
        if (this.f4789k == null) {
            sb.append("null");
        } else {
            sb.append(this.f4789k);
        }
        sb.append(", ");
        sb.append("version:");
        if (this.f4790l == null) {
            sb.append("null");
        } else {
            sb.append(this.f4790l);
        }
        sb.append(", ");
        sb.append("network:");
        if (this.f4791m == null) {
            sb.append("null");
        } else {
            sb.append(this.f4791m);
        }
        sb.append(", ");
        sb.append("rid:");
        if (this.f4792n == null) {
            sb.append("null");
        } else {
            sb.append(this.f4792n);
        }
        if (mo10067f()) {
            sb.append(", ");
            sb.append("location:");
            if (this.f4793o == null) {
                sb.append("null");
            } else {
                sb.append(this.f4793o);
            }
        }
        if (mo10068g()) {
            sb.append(", ");
            sb.append("host_info:");
            if (this.f4794p == null) {
                sb.append("null");
            } else {
                sb.append(this.f4794p);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
