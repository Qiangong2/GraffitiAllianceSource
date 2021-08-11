package com.xiaomi.common.logger.thrift.mfs;

import com.xiaomi.common.logger.thrift.C1874a;
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
import org.apache.thrift.meta_data.C2172g;
import org.apache.thrift.protocol.AbstractC2180f;
import org.apache.thrift.protocol.C2177c;
import org.apache.thrift.protocol.C2181g;
import org.apache.thrift.protocol.C2183i;
import org.apache.thrift.protocol.C2185k;

/* renamed from: com.xiaomi.common.logger.thrift.mfs.c */
public class C1880c implements Serializable, Cloneable, AbstractC2158b<C1880c, EnumC1881a> {

    /* renamed from: a */
    public static final Map<EnumC1881a, C2167b> f4715a;

    /* renamed from: b */
    private static final C2185k f4716b = new C2185k("HttpLog");

    /* renamed from: c */
    private static final C2177c f4717c = new C2177c("common", (byte) 12, 1);

    /* renamed from: d */
    private static final C2177c f4718d = new C2177c("category", (byte) 11, 2);

    /* renamed from: e */
    private static final C2177c f4719e = new C2177c("httpApi", (byte) 12, 3);

    /* renamed from: f */
    private static final C2177c f4720f = new C2177c("passport", (byte) 12, 4);

    /* renamed from: g */
    private C1874a f4721g;

    /* renamed from: h */
    private String f4722h = "";

    /* renamed from: i */
    private C1878b f4723i;

    /* renamed from: j */
    private C1886f f4724j;

    /* renamed from: com.xiaomi.common.logger.thrift.mfs.c$a */
    public enum EnumC1881a {
        COMMON(1, "common"),
        CATEGORY(2, "category"),
        HTTP_API(3, "httpApi"),
        PASSPORT(4, "passport");
        

        /* renamed from: e */
        private static final Map<String, EnumC1881a> f4729e = new HashMap();

        /* renamed from: f */
        private final short f4731f;

        /* renamed from: g */
        private final String f4732g;

        static {
            Iterator it = EnumSet.allOf(EnumC1881a.class).iterator();
            while (it.hasNext()) {
                EnumC1881a aVar = (EnumC1881a) it.next();
                f4729e.put(aVar.mo10016a(), aVar);
            }
        }

        private EnumC1881a(short s, String str) {
            this.f4731f = s;
            this.f4732g = str;
        }

        /* renamed from: a */
        public String mo10016a() {
            return this.f4732g;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC1881a.class);
        enumMap.put((Object) EnumC1881a.COMMON, (Object) new C2167b("common", (byte) 1, new C2172g((byte) 12, C1874a.class)));
        enumMap.put((Object) EnumC1881a.CATEGORY, (Object) new C2167b("category", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC1881a.HTTP_API, (Object) new C2167b("httpApi", (byte) 2, new C2172g((byte) 12, C1878b.class)));
        enumMap.put((Object) EnumC1881a.PASSPORT, (Object) new C2167b("passport", (byte) 2, new C2172g((byte) 12, C1886f.class)));
        f4715a = Collections.unmodifiableMap(enumMap);
        C2167b.m8203a(C1880c.class, f4715a);
    }

    /* renamed from: a */
    public C1880c mo10002a(C1874a aVar) {
        this.f4721g = aVar;
        return this;
    }

    /* renamed from: a */
    public C1880c mo10003a(C1878b bVar) {
        this.f4723i = bVar;
        return this;
    }

    /* renamed from: a */
    public C1880c mo10004a(String str) {
        this.f4722h = str;
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
                mo10012e();
                return;
            }
            switch (i.f6211c) {
                case 1:
                    if (i.f6210b != 12) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f4721g = new C1874a();
                        this.f4721g.mo9945a(fVar);
                        break;
                    }
                case 2:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f4722h = fVar.mo12161w();
                        break;
                    }
                case 3:
                    if (i.f6210b != 12) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f4723i = new C1878b();
                        this.f4723i.mo9945a(fVar);
                        break;
                    }
                case 4:
                    if (i.f6210b != 12) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f4724j = new C1886f();
                        this.f4724j.mo9945a(fVar);
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
    public boolean mo10005a() {
        return this.f4721g != null;
    }

    /* renamed from: a */
    public boolean mo10006a(C1880c cVar) {
        if (cVar == null) {
            return false;
        }
        boolean a = mo10005a();
        boolean a2 = cVar.mo10005a();
        if ((a || a2) && (!a || !a2 || !this.f4721g.mo9948a(cVar.f4721g))) {
            return false;
        }
        boolean b = mo10008b();
        boolean b2 = cVar.mo10008b();
        if ((b || b2) && (!b || !b2 || !this.f4722h.equals(cVar.f4722h))) {
            return false;
        }
        boolean c = mo10009c();
        boolean c2 = cVar.mo10009c();
        if ((c || c2) && (!c || !c2 || !this.f4723i.mo9977a(cVar.f4723i))) {
            return false;
        }
        boolean d = mo10011d();
        boolean d2 = cVar.mo10011d();
        return (!d && !d2) || (d && d2 && this.f4724j.mo10059a(cVar.f4724j));
    }

    /* renamed from: b */
    public int compareTo(C1880c cVar) {
        int a;
        int a2;
        int a3;
        int a4;
        if (!getClass().equals(cVar.getClass())) {
            return getClass().getName().compareTo(cVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo10005a()).compareTo(Boolean.valueOf(cVar.mo10005a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo10005a() && (a4 = C2159c.m8186a(this.f4721g, cVar.f4721g)) != 0) {
            return a4;
        }
        int compareTo2 = Boolean.valueOf(mo10008b()).compareTo(Boolean.valueOf(cVar.mo10008b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo10008b() && (a3 = C2159c.m8187a(this.f4722h, cVar.f4722h)) != 0) {
            return a3;
        }
        int compareTo3 = Boolean.valueOf(mo10009c()).compareTo(Boolean.valueOf(cVar.mo10009c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo10009c() && (a2 = C2159c.m8186a(this.f4723i, cVar.f4723i)) != 0) {
            return a2;
        }
        int compareTo4 = Boolean.valueOf(mo10011d()).compareTo(Boolean.valueOf(cVar.mo10011d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (!mo10011d() || (a = C2159c.m8186a(this.f4724j, cVar.f4724j)) == 0) {
            return 0;
        }
        return a;
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: b */
    public void mo9950b(AbstractC2180f fVar) {
        mo10012e();
        fVar.mo12134a(f4716b);
        if (this.f4721g != null) {
            fVar.mo12130a(f4717c);
            this.f4721g.mo9950b(fVar);
            fVar.mo12138b();
        }
        if (this.f4722h != null) {
            fVar.mo12130a(f4718d);
            fVar.mo12128a(this.f4722h);
            fVar.mo12138b();
        }
        if (this.f4723i != null && mo10009c()) {
            fVar.mo12130a(f4719e);
            this.f4723i.mo9950b(fVar);
            fVar.mo12138b();
        }
        if (this.f4724j != null && mo10011d()) {
            fVar.mo12130a(f4720f);
            this.f4724j.mo9950b(fVar);
            fVar.mo12138b();
        }
        fVar.mo12139c();
        fVar.mo12124a();
    }

    /* renamed from: b */
    public boolean mo10008b() {
        return this.f4722h != null;
    }

    /* renamed from: c */
    public boolean mo10009c() {
        return this.f4723i != null;
    }

    /* renamed from: d */
    public boolean mo10011d() {
        return this.f4724j != null;
    }

    /* renamed from: e */
    public void mo10012e() {
        if (this.f4721g == null) {
            throw new C2181g("Required field 'common' was not present! Struct: " + toString());
        } else if (this.f4722h == null) {
            throw new C2181g("Required field 'category' was not present! Struct: " + toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1880c)) {
            return mo10006a((C1880c) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HttpLog(");
        sb.append("common:");
        if (this.f4721g == null) {
            sb.append("null");
        } else {
            sb.append(this.f4721g);
        }
        sb.append(", ");
        sb.append("category:");
        if (this.f4722h == null) {
            sb.append("null");
        } else {
            sb.append(this.f4722h);
        }
        if (mo10009c()) {
            sb.append(", ");
            sb.append("httpApi:");
            if (this.f4723i == null) {
                sb.append("null");
            } else {
                sb.append(this.f4723i);
            }
        }
        if (mo10011d()) {
            sb.append(", ");
            sb.append("passport:");
            if (this.f4724j == null) {
                sb.append("null");
            } else {
                sb.append(this.f4724j);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
