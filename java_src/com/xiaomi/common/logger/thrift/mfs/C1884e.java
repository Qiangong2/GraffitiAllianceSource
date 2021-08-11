package com.xiaomi.common.logger.thrift.mfs;

import java.io.Serializable;
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
import org.apache.thrift.protocol.C2183i;
import org.apache.thrift.protocol.C2185k;

/* renamed from: com.xiaomi.common.logger.thrift.mfs.e */
public class C1884e implements Serializable, Cloneable, AbstractC2158b<C1884e, EnumC1885a> {

    /* renamed from: a */
    public static final Map<EnumC1885a, C2167b> f4761a;

    /* renamed from: b */
    private static final C2185k f4762b = new C2185k("Location");

    /* renamed from: c */
    private static final C2177c f4763c = new C2177c("contry", (byte) 11, 1);

    /* renamed from: d */
    private static final C2177c f4764d = new C2177c("province", (byte) 11, 2);

    /* renamed from: e */
    private static final C2177c f4765e = new C2177c("city", (byte) 11, 3);

    /* renamed from: f */
    private static final C2177c f4766f = new C2177c("isp", (byte) 11, 4);

    /* renamed from: g */
    private String f4767g;

    /* renamed from: h */
    private String f4768h;

    /* renamed from: i */
    private String f4769i;

    /* renamed from: j */
    private String f4770j;

    /* renamed from: com.xiaomi.common.logger.thrift.mfs.e$a */
    public enum EnumC1885a {
        CONTRY(1, "contry"),
        PROVINCE(2, "province"),
        CITY(3, "city"),
        ISP(4, "isp");
        

        /* renamed from: e */
        private static final Map<String, EnumC1885a> f4775e = new HashMap();

        /* renamed from: f */
        private final short f4777f;

        /* renamed from: g */
        private final String f4778g;

        static {
            Iterator it = EnumSet.allOf(EnumC1885a.class).iterator();
            while (it.hasNext()) {
                EnumC1885a aVar = (EnumC1885a) it.next();
                f4775e.put(aVar.mo10057a(), aVar);
            }
        }

        private EnumC1885a(short s, String str) {
            this.f4777f = s;
            this.f4778g = str;
        }

        /* renamed from: a */
        public String mo10057a() {
            return this.f4778g;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC1885a.class);
        enumMap.put((Object) EnumC1885a.CONTRY, (Object) new C2167b("contry", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC1885a.PROVINCE, (Object) new C2167b("province", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC1885a.CITY, (Object) new C2167b("city", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC1885a.ISP, (Object) new C2167b("isp", (byte) 2, new C2168c((byte) 11)));
        f4761a = Collections.unmodifiableMap(enumMap);
        C2167b.m8203a(C1884e.class, f4761a);
    }

    /* renamed from: a */
    public C1884e mo10042a(String str) {
        this.f4767g = str;
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
                mo10053e();
                return;
            }
            switch (i.f6211c) {
                case 1:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f4767g = fVar.mo12161w();
                        break;
                    }
                case 2:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f4768h = fVar.mo12161w();
                        break;
                    }
                case 3:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f4769i = fVar.mo12161w();
                        break;
                    }
                case 4:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f4770j = fVar.mo12161w();
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
    public boolean mo10043a() {
        return this.f4767g != null;
    }

    /* renamed from: a */
    public boolean mo10044a(C1884e eVar) {
        if (eVar == null) {
            return false;
        }
        boolean a = mo10043a();
        boolean a2 = eVar.mo10043a();
        if ((a || a2) && (!a || !a2 || !this.f4767g.equals(eVar.f4767g))) {
            return false;
        }
        boolean b = mo10047b();
        boolean b2 = eVar.mo10047b();
        if ((b || b2) && (!b || !b2 || !this.f4768h.equals(eVar.f4768h))) {
            return false;
        }
        boolean c = mo10049c();
        boolean c2 = eVar.mo10049c();
        if ((c || c2) && (!c || !c2 || !this.f4769i.equals(eVar.f4769i))) {
            return false;
        }
        boolean d = mo10052d();
        boolean d2 = eVar.mo10052d();
        return (!d && !d2) || (d && d2 && this.f4770j.equals(eVar.f4770j));
    }

    /* renamed from: b */
    public int compareTo(C1884e eVar) {
        int a;
        int a2;
        int a3;
        int a4;
        if (!getClass().equals(eVar.getClass())) {
            return getClass().getName().compareTo(eVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo10043a()).compareTo(Boolean.valueOf(eVar.mo10043a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo10043a() && (a4 = C2159c.m8187a(this.f4767g, eVar.f4767g)) != 0) {
            return a4;
        }
        int compareTo2 = Boolean.valueOf(mo10047b()).compareTo(Boolean.valueOf(eVar.mo10047b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo10047b() && (a3 = C2159c.m8187a(this.f4768h, eVar.f4768h)) != 0) {
            return a3;
        }
        int compareTo3 = Boolean.valueOf(mo10049c()).compareTo(Boolean.valueOf(eVar.mo10049c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo10049c() && (a2 = C2159c.m8187a(this.f4769i, eVar.f4769i)) != 0) {
            return a2;
        }
        int compareTo4 = Boolean.valueOf(mo10052d()).compareTo(Boolean.valueOf(eVar.mo10052d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (!mo10052d() || (a = C2159c.m8187a(this.f4770j, eVar.f4770j)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: b */
    public C1884e mo10046b(String str) {
        this.f4768h = str;
        return this;
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: b */
    public void mo9950b(AbstractC2180f fVar) {
        mo10053e();
        fVar.mo12134a(f4762b);
        if (this.f4767g != null && mo10043a()) {
            fVar.mo12130a(f4763c);
            fVar.mo12128a(this.f4767g);
            fVar.mo12138b();
        }
        if (this.f4768h != null && mo10047b()) {
            fVar.mo12130a(f4764d);
            fVar.mo12128a(this.f4768h);
            fVar.mo12138b();
        }
        if (this.f4769i != null && mo10049c()) {
            fVar.mo12130a(f4765e);
            fVar.mo12128a(this.f4769i);
            fVar.mo12138b();
        }
        if (this.f4770j != null && mo10052d()) {
            fVar.mo12130a(f4766f);
            fVar.mo12128a(this.f4770j);
            fVar.mo12138b();
        }
        fVar.mo12139c();
        fVar.mo12124a();
    }

    /* renamed from: b */
    public boolean mo10047b() {
        return this.f4768h != null;
    }

    /* renamed from: c */
    public C1884e mo10048c(String str) {
        this.f4769i = str;
        return this;
    }

    /* renamed from: c */
    public boolean mo10049c() {
        return this.f4769i != null;
    }

    /* renamed from: d */
    public C1884e mo10051d(String str) {
        this.f4770j = str;
        return this;
    }

    /* renamed from: d */
    public boolean mo10052d() {
        return this.f4770j != null;
    }

    /* renamed from: e */
    public void mo10053e() {
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1884e)) {
            return mo10044a((C1884e) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("Location(");
        boolean z2 = true;
        if (mo10043a()) {
            sb.append("contry:");
            if (this.f4767g == null) {
                sb.append("null");
            } else {
                sb.append(this.f4767g);
            }
            z2 = false;
        }
        if (mo10047b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("province:");
            if (this.f4768h == null) {
                sb.append("null");
            } else {
                sb.append(this.f4768h);
            }
            z2 = false;
        }
        if (mo10049c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("city:");
            if (this.f4769i == null) {
                sb.append("null");
            } else {
                sb.append(this.f4769i);
            }
        } else {
            z = z2;
        }
        if (mo10052d()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("isp:");
            if (this.f4770j == null) {
                sb.append("null");
            } else {
                sb.append(this.f4770j);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
