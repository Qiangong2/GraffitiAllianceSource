package com.xiaomi.common.logger.thrift.mfs;

import com.umeng.analytics.p091b.C1447g;
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

/* renamed from: com.xiaomi.common.logger.thrift.mfs.b */
public class C1878b implements Serializable, Cloneable, AbstractC2158b<C1878b, EnumC1879a> {

    /* renamed from: a */
    public static final Map<EnumC1879a, C2167b> f4679a;

    /* renamed from: b */
    private static final C2185k f4680b = new C2185k("HttpApi");

    /* renamed from: c */
    private static final C2177c f4681c = new C2177c("category", (byte) 11, 1);

    /* renamed from: d */
    private static final C2177c f4682d = new C2177c("uuid", (byte) 11, 2);

    /* renamed from: e */
    private static final C2177c f4683e = new C2177c("version", (byte) 11, 3);

    /* renamed from: f */
    private static final C2177c f4684f = new C2177c("network", (byte) 11, 4);

    /* renamed from: g */
    private static final C2177c f4685g = new C2177c("client_ip", (byte) 11, 5);

    /* renamed from: h */
    private static final C2177c f4686h = new C2177c("location", (byte) 12, 6);

    /* renamed from: i */
    private static final C2177c f4687i = new C2177c("host_info", (byte) 14, 7);

    /* renamed from: j */
    private static final C2177c f4688j = new C2177c("version_type", (byte) 11, 8);

    /* renamed from: k */
    private static final C2177c f4689k = new C2177c("app_name", (byte) 11, 9);

    /* renamed from: l */
    private static final C2177c f4690l = new C2177c(C1447g.f3509d, (byte) 11, 10);

    /* renamed from: m */
    private String f4691m = "";

    /* renamed from: n */
    private String f4692n;

    /* renamed from: o */
    private String f4693o;

    /* renamed from: p */
    private String f4694p;

    /* renamed from: q */
    private String f4695q;

    /* renamed from: r */
    private C1884e f4696r;

    /* renamed from: s */
    private Set<C1876a> f4697s;

    /* renamed from: t */
    private String f4698t = "";

    /* renamed from: u */
    private String f4699u = "";

    /* renamed from: v */
    private String f4700v = "";

    /* renamed from: com.xiaomi.common.logger.thrift.mfs.b$a */
    public enum EnumC1879a {
        CATEGORY(1, "category"),
        UUID(2, "uuid"),
        VERSION(3, "version"),
        NETWORK(4, "network"),
        CLIENT_IP(5, "client_ip"),
        LOCATION(6, "location"),
        HOST_INFO(7, "host_info"),
        VERSION_TYPE(8, "version_type"),
        APP_NAME(9, "app_name"),
        APP_VERSION(10, C1447g.f3509d);
        

        /* renamed from: k */
        private static final Map<String, EnumC1879a> f4711k = new HashMap();

        /* renamed from: l */
        private final short f4713l;

        /* renamed from: m */
        private final String f4714m;

        static {
            Iterator it = EnumSet.allOf(EnumC1879a.class).iterator();
            while (it.hasNext()) {
                EnumC1879a aVar = (EnumC1879a) it.next();
                f4711k.put(aVar.mo10001a(), aVar);
            }
        }

        private EnumC1879a(short s, String str) {
            this.f4713l = s;
            this.f4714m = str;
        }

        /* renamed from: a */
        public String mo10001a() {
            return this.f4714m;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC1879a.class);
        enumMap.put((Object) EnumC1879a.CATEGORY, (Object) new C2167b("category", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC1879a.UUID, (Object) new C2167b("uuid", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC1879a.VERSION, (Object) new C2167b("version", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC1879a.NETWORK, (Object) new C2167b("network", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC1879a.CLIENT_IP, (Object) new C2167b("client_ip", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC1879a.LOCATION, (Object) new C2167b("location", (byte) 2, new C2172g((byte) 12, C1884e.class)));
        enumMap.put((Object) EnumC1879a.HOST_INFO, (Object) new C2167b("host_info", (byte) 2, new C2171f((byte) 14, new C2172g((byte) 12, C1876a.class))));
        enumMap.put((Object) EnumC1879a.VERSION_TYPE, (Object) new C2167b("version_type", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC1879a.APP_NAME, (Object) new C2167b("app_name", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC1879a.APP_VERSION, (Object) new C2167b(C1447g.f3509d, (byte) 2, new C2168c((byte) 11)));
        f4679a = Collections.unmodifiableMap(enumMap);
        C2167b.m8203a(C1878b.class, f4679a);
    }

    /* renamed from: a */
    public C1878b mo9973a(C1884e eVar) {
        this.f4696r = eVar;
        return this;
    }

    /* renamed from: a */
    public C1878b mo9974a(String str) {
        this.f4691m = str;
        return this;
    }

    /* renamed from: a */
    public void mo9975a(C1876a aVar) {
        if (this.f4697s == null) {
            this.f4697s = new HashSet();
        }
        this.f4697s.add(aVar);
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: a */
    public void mo9945a(AbstractC2180f fVar) {
        fVar.mo12145g();
        while (true) {
            C2177c i = fVar.mo12147i();
            if (i.f6210b == 0) {
                fVar.mo12146h();
                mo9999l();
                return;
            }
            switch (i.f6211c) {
                case 1:
                    if (i.f6210b == 11) {
                        this.f4691m = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 2:
                    if (i.f6210b == 11) {
                        this.f4692n = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 3:
                    if (i.f6210b == 11) {
                        this.f4693o = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 4:
                    if (i.f6210b == 11) {
                        this.f4694p = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 5:
                    if (i.f6210b == 11) {
                        this.f4695q = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 6:
                    if (i.f6210b == 12) {
                        this.f4696r = new C1884e();
                        this.f4696r.mo9945a(fVar);
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 7:
                    if (i.f6210b == 14) {
                        C2184j o = fVar.mo12153o();
                        this.f4697s = new HashSet(o.f6221b * 2);
                        for (int i2 = 0; i2 < o.f6221b; i2++) {
                            C1876a aVar = new C1876a();
                            aVar.mo9945a(fVar);
                            this.f4697s.add(aVar);
                        }
                        fVar.mo12154p();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 8:
                    if (i.f6210b == 11) {
                        this.f4698t = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 9:
                    if (i.f6210b == 11) {
                        this.f4699u = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 10:
                    if (i.f6210b == 11) {
                        this.f4700v = fVar.mo12161w();
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
    public boolean mo9976a() {
        return this.f4691m != null;
    }

    /* renamed from: a */
    public boolean mo9977a(C1878b bVar) {
        if (bVar == null) {
            return false;
        }
        boolean a = mo9976a();
        boolean a2 = bVar.mo9976a();
        if ((a || a2) && (!a || !a2 || !this.f4691m.equals(bVar.f4691m))) {
            return false;
        }
        boolean b = mo9980b();
        boolean b2 = bVar.mo9980b();
        if ((b || b2) && (!b || !b2 || !this.f4692n.equals(bVar.f4692n))) {
            return false;
        }
        boolean c = mo9982c();
        boolean c2 = bVar.mo9982c();
        if ((c || c2) && (!c || !c2 || !this.f4693o.equals(bVar.f4693o))) {
            return false;
        }
        boolean d = mo9985d();
        boolean d2 = bVar.mo9985d();
        if ((d || d2) && (!d || !d2 || !this.f4694p.equals(bVar.f4694p))) {
            return false;
        }
        boolean e = mo9987e();
        boolean e2 = bVar.mo9987e();
        if ((e || e2) && (!e || !e2 || !this.f4695q.equals(bVar.f4695q))) {
            return false;
        }
        boolean f = mo9990f();
        boolean f2 = bVar.mo9990f();
        if ((f || f2) && (!f || !f2 || !this.f4696r.mo10044a(bVar.f4696r))) {
            return false;
        }
        boolean h = mo9994h();
        boolean h2 = bVar.mo9994h();
        if ((h || h2) && (!h || !h2 || !this.f4697s.equals(bVar.f4697s))) {
            return false;
        }
        boolean i = mo9996i();
        boolean i2 = bVar.mo9996i();
        if ((i || i2) && (!i || !i2 || !this.f4698t.equals(bVar.f4698t))) {
            return false;
        }
        boolean j = mo9997j();
        boolean j2 = bVar.mo9997j();
        if ((j || j2) && (!j || !j2 || !this.f4699u.equals(bVar.f4699u))) {
            return false;
        }
        boolean k = mo9998k();
        boolean k2 = bVar.mo9998k();
        return (!k && !k2) || (k && k2 && this.f4700v.equals(bVar.f4700v));
    }

    /* renamed from: b */
    public int compareTo(C1878b bVar) {
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
        int compareTo = Boolean.valueOf(mo9976a()).compareTo(Boolean.valueOf(bVar.mo9976a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo9976a() && (a10 = C2159c.m8187a(this.f4691m, bVar.f4691m)) != 0) {
            return a10;
        }
        int compareTo2 = Boolean.valueOf(mo9980b()).compareTo(Boolean.valueOf(bVar.mo9980b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo9980b() && (a9 = C2159c.m8187a(this.f4692n, bVar.f4692n)) != 0) {
            return a9;
        }
        int compareTo3 = Boolean.valueOf(mo9982c()).compareTo(Boolean.valueOf(bVar.mo9982c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo9982c() && (a8 = C2159c.m8187a(this.f4693o, bVar.f4693o)) != 0) {
            return a8;
        }
        int compareTo4 = Boolean.valueOf(mo9985d()).compareTo(Boolean.valueOf(bVar.mo9985d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo9985d() && (a7 = C2159c.m8187a(this.f4694p, bVar.f4694p)) != 0) {
            return a7;
        }
        int compareTo5 = Boolean.valueOf(mo9987e()).compareTo(Boolean.valueOf(bVar.mo9987e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo9987e() && (a6 = C2159c.m8187a(this.f4695q, bVar.f4695q)) != 0) {
            return a6;
        }
        int compareTo6 = Boolean.valueOf(mo9990f()).compareTo(Boolean.valueOf(bVar.mo9990f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo9990f() && (a5 = C2159c.m8186a(this.f4696r, bVar.f4696r)) != 0) {
            return a5;
        }
        int compareTo7 = Boolean.valueOf(mo9994h()).compareTo(Boolean.valueOf(bVar.mo9994h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo9994h() && (a4 = C2159c.m8191a(this.f4697s, bVar.f4697s)) != 0) {
            return a4;
        }
        int compareTo8 = Boolean.valueOf(mo9996i()).compareTo(Boolean.valueOf(bVar.mo9996i()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (mo9996i() && (a3 = C2159c.m8187a(this.f4698t, bVar.f4698t)) != 0) {
            return a3;
        }
        int compareTo9 = Boolean.valueOf(mo9997j()).compareTo(Boolean.valueOf(bVar.mo9997j()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (mo9997j() && (a2 = C2159c.m8187a(this.f4699u, bVar.f4699u)) != 0) {
            return a2;
        }
        int compareTo10 = Boolean.valueOf(mo9998k()).compareTo(Boolean.valueOf(bVar.mo9998k()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!mo9998k() || (a = C2159c.m8187a(this.f4700v, bVar.f4700v)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: b */
    public C1878b mo9979b(String str) {
        this.f4692n = str;
        return this;
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: b */
    public void mo9950b(AbstractC2180f fVar) {
        mo9999l();
        fVar.mo12134a(f4680b);
        if (this.f4691m != null) {
            fVar.mo12130a(f4681c);
            fVar.mo12128a(this.f4691m);
            fVar.mo12138b();
        }
        if (this.f4692n != null) {
            fVar.mo12130a(f4682d);
            fVar.mo12128a(this.f4692n);
            fVar.mo12138b();
        }
        if (this.f4693o != null) {
            fVar.mo12130a(f4683e);
            fVar.mo12128a(this.f4693o);
            fVar.mo12138b();
        }
        if (this.f4694p != null) {
            fVar.mo12130a(f4684f);
            fVar.mo12128a(this.f4694p);
            fVar.mo12138b();
        }
        if (this.f4695q != null && mo9987e()) {
            fVar.mo12130a(f4685g);
            fVar.mo12128a(this.f4695q);
            fVar.mo12138b();
        }
        if (this.f4696r != null && mo9990f()) {
            fVar.mo12130a(f4686h);
            this.f4696r.mo9950b(fVar);
            fVar.mo12138b();
        }
        if (this.f4697s != null && mo9994h()) {
            fVar.mo12130a(f4687i);
            fVar.mo12133a(new C2184j((byte) 12, this.f4697s.size()));
            for (C1876a aVar : this.f4697s) {
                aVar.mo9950b(fVar);
            }
            fVar.mo12144f();
            fVar.mo12138b();
        }
        if (this.f4698t != null && mo9996i()) {
            fVar.mo12130a(f4688j);
            fVar.mo12128a(this.f4698t);
            fVar.mo12138b();
        }
        if (this.f4699u != null && mo9997j()) {
            fVar.mo12130a(f4689k);
            fVar.mo12128a(this.f4699u);
            fVar.mo12138b();
        }
        if (this.f4700v != null && mo9998k()) {
            fVar.mo12130a(f4690l);
            fVar.mo12128a(this.f4700v);
            fVar.mo12138b();
        }
        fVar.mo12139c();
        fVar.mo12124a();
    }

    /* renamed from: b */
    public boolean mo9980b() {
        return this.f4692n != null;
    }

    /* renamed from: c */
    public C1878b mo9981c(String str) {
        this.f4693o = str;
        return this;
    }

    /* renamed from: c */
    public boolean mo9982c() {
        return this.f4693o != null;
    }

    /* renamed from: d */
    public C1878b mo9984d(String str) {
        this.f4694p = str;
        return this;
    }

    /* renamed from: d */
    public boolean mo9985d() {
        return this.f4694p != null;
    }

    /* renamed from: e */
    public C1878b mo9986e(String str) {
        this.f4695q = str;
        return this;
    }

    /* renamed from: e */
    public boolean mo9987e() {
        return this.f4695q != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1878b)) {
            return mo9977a((C1878b) obj);
        }
        return false;
    }

    /* renamed from: f */
    public C1878b mo9989f(String str) {
        this.f4698t = str;
        return this;
    }

    /* renamed from: f */
    public boolean mo9990f() {
        return this.f4696r != null;
    }

    /* renamed from: g */
    public int mo9991g() {
        if (this.f4697s == null) {
            return 0;
        }
        return this.f4697s.size();
    }

    /* renamed from: g */
    public C1878b mo9992g(String str) {
        this.f4699u = str;
        return this;
    }

    /* renamed from: h */
    public C1878b mo9993h(String str) {
        this.f4700v = str;
        return this;
    }

    /* renamed from: h */
    public boolean mo9994h() {
        return this.f4697s != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean mo9996i() {
        return this.f4698t != null;
    }

    /* renamed from: j */
    public boolean mo9997j() {
        return this.f4699u != null;
    }

    /* renamed from: k */
    public boolean mo9998k() {
        return this.f4700v != null;
    }

    /* renamed from: l */
    public void mo9999l() {
        if (this.f4691m == null) {
            throw new C2181g("Required field 'category' was not present! Struct: " + toString());
        } else if (this.f4692n == null) {
            throw new C2181g("Required field 'uuid' was not present! Struct: " + toString());
        } else if (this.f4693o == null) {
            throw new C2181g("Required field 'version' was not present! Struct: " + toString());
        } else if (this.f4694p == null) {
            throw new C2181g("Required field 'network' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HttpApi(");
        sb.append("category:");
        if (this.f4691m == null) {
            sb.append("null");
        } else {
            sb.append(this.f4691m);
        }
        sb.append(", ");
        sb.append("uuid:");
        if (this.f4692n == null) {
            sb.append("null");
        } else {
            sb.append(this.f4692n);
        }
        sb.append(", ");
        sb.append("version:");
        if (this.f4693o == null) {
            sb.append("null");
        } else {
            sb.append(this.f4693o);
        }
        sb.append(", ");
        sb.append("network:");
        if (this.f4694p == null) {
            sb.append("null");
        } else {
            sb.append(this.f4694p);
        }
        if (mo9987e()) {
            sb.append(", ");
            sb.append("client_ip:");
            if (this.f4695q == null) {
                sb.append("null");
            } else {
                sb.append(this.f4695q);
            }
        }
        if (mo9990f()) {
            sb.append(", ");
            sb.append("location:");
            if (this.f4696r == null) {
                sb.append("null");
            } else {
                sb.append(this.f4696r);
            }
        }
        if (mo9994h()) {
            sb.append(", ");
            sb.append("host_info:");
            if (this.f4697s == null) {
                sb.append("null");
            } else {
                sb.append(this.f4697s);
            }
        }
        if (mo9996i()) {
            sb.append(", ");
            sb.append("version_type:");
            if (this.f4698t == null) {
                sb.append("null");
            } else {
                sb.append(this.f4698t);
            }
        }
        if (mo9997j()) {
            sb.append(", ");
            sb.append("app_name:");
            if (this.f4699u == null) {
                sb.append("null");
            } else {
                sb.append(this.f4699u);
            }
        }
        if (mo9998k()) {
            sb.append(", ");
            sb.append("app_version:");
            if (this.f4700v == null) {
                sb.append("null");
            } else {
                sb.append(this.f4700v);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
