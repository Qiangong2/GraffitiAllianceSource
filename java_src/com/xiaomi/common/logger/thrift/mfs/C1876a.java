package com.xiaomi.common.logger.thrift.mfs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.thrift.AbstractC2158b;
import org.apache.thrift.C2159c;
import org.apache.thrift.meta_data.C2167b;
import org.apache.thrift.meta_data.C2168c;
import org.apache.thrift.meta_data.C2169d;
import org.apache.thrift.meta_data.C2172g;
import org.apache.thrift.protocol.AbstractC2180f;
import org.apache.thrift.protocol.C2177c;
import org.apache.thrift.protocol.C2178d;
import org.apache.thrift.protocol.C2181g;
import org.apache.thrift.protocol.C2183i;
import org.apache.thrift.protocol.C2185k;
import p000a.p001a.p002a.p004b.C0027o;

/* renamed from: com.xiaomi.common.logger.thrift.mfs.a */
public class C1876a implements Serializable, Cloneable, AbstractC2158b<C1876a, EnumC1877a> {

    /* renamed from: a */
    public static final Map<EnumC1877a, C2167b> f4667a;

    /* renamed from: b */
    private static final C2185k f4668b = new C2185k("HostInfo");

    /* renamed from: c */
    private static final C2177c f4669c = new C2177c("host", (byte) 11, 1);

    /* renamed from: d */
    private static final C2177c f4670d = new C2177c("land_node_info", C0027o.f104m, 2);

    /* renamed from: e */
    private String f4671e;

    /* renamed from: f */
    private List<C1882d> f4672f;

    /* renamed from: com.xiaomi.common.logger.thrift.mfs.a$a */
    public enum EnumC1877a {
        HOST(1, "host"),
        LAND_NODE_INFO(2, "land_node_info");
        

        /* renamed from: c */
        private static final Map<String, EnumC1877a> f4675c = new HashMap();

        /* renamed from: d */
        private final short f4677d;

        /* renamed from: e */
        private final String f4678e;

        static {
            Iterator it = EnumSet.allOf(EnumC1877a.class).iterator();
            while (it.hasNext()) {
                EnumC1877a aVar = (EnumC1877a) it.next();
                f4675c.put(aVar.mo9972a(), aVar);
            }
        }

        private EnumC1877a(short s, String str) {
            this.f4677d = s;
            this.f4678e = str;
        }

        /* renamed from: a */
        public String mo9972a() {
            return this.f4678e;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC1877a.class);
        enumMap.put((Object) EnumC1877a.HOST, (Object) new C2167b("host", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC1877a.LAND_NODE_INFO, (Object) new C2167b("land_node_info", (byte) 1, new C2169d(C0027o.f104m, new C2172g((byte) 12, C1882d.class))));
        f4667a = Collections.unmodifiableMap(enumMap);
        C2167b.m8203a(C1876a.class, f4667a);
    }

    /* renamed from: a */
    public C1876a mo9961a(String str) {
        this.f4671e = str;
        return this;
    }

    /* renamed from: a */
    public C1876a mo9962a(List<C1882d> list) {
        this.f4672f = list;
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
                mo9967c();
                return;
            }
            switch (i.f6211c) {
                case 1:
                    if (i.f6210b == 11) {
                        this.f4671e = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 2:
                    if (i.f6210b == 15) {
                        C2178d m = fVar.mo12151m();
                        this.f4672f = new ArrayList(m.f6213b);
                        for (int i2 = 0; i2 < m.f6213b; i2++) {
                            C1882d dVar = new C1882d();
                            dVar.mo9945a(fVar);
                            this.f4672f.add(dVar);
                        }
                        fVar.mo12152n();
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
    public boolean mo9963a() {
        return this.f4671e != null;
    }

    /* renamed from: a */
    public boolean mo9964a(C1876a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean a = mo9963a();
        boolean a2 = aVar.mo9963a();
        if ((a || a2) && (!a || !a2 || !this.f4671e.equals(aVar.f4671e))) {
            return false;
        }
        boolean b = mo9966b();
        boolean b2 = aVar.mo9966b();
        return (!b && !b2) || (b && b2 && this.f4672f.equals(aVar.f4672f));
    }

    /* renamed from: b */
    public int compareTo(C1876a aVar) {
        int a;
        int a2;
        if (!getClass().equals(aVar.getClass())) {
            return getClass().getName().compareTo(aVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo9963a()).compareTo(Boolean.valueOf(aVar.mo9963a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo9963a() && (a2 = C2159c.m8187a(this.f4671e, aVar.f4671e)) != 0) {
            return a2;
        }
        int compareTo2 = Boolean.valueOf(mo9966b()).compareTo(Boolean.valueOf(aVar.mo9966b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (!mo9966b() || (a = C2159c.m8189a(this.f4672f, aVar.f4672f)) == 0) {
            return 0;
        }
        return a;
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: b */
    public void mo9950b(AbstractC2180f fVar) {
        mo9967c();
        fVar.mo12134a(f4668b);
        if (this.f4671e != null) {
            fVar.mo12130a(f4669c);
            fVar.mo12128a(this.f4671e);
            fVar.mo12138b();
        }
        if (this.f4672f != null) {
            fVar.mo12130a(f4670d);
            fVar.mo12131a(new C2178d((byte) 12, this.f4672f.size()));
            for (C1882d dVar : this.f4672f) {
                dVar.mo9950b(fVar);
            }
            fVar.mo12143e();
            fVar.mo12138b();
        }
        fVar.mo12139c();
        fVar.mo12124a();
    }

    /* renamed from: b */
    public boolean mo9966b() {
        return this.f4672f != null;
    }

    /* renamed from: c */
    public void mo9967c() {
        if (this.f4671e == null) {
            throw new C2181g("Required field 'host' was not present! Struct: " + toString());
        } else if (this.f4672f == null) {
            throw new C2181g("Required field 'land_node_info' was not present! Struct: " + toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1876a)) {
            return mo9964a((C1876a) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HostInfo(");
        sb.append("host:");
        if (this.f4671e == null) {
            sb.append("null");
        } else {
            sb.append(this.f4671e);
        }
        sb.append(", ");
        sb.append("land_node_info:");
        if (this.f4672f == null) {
            sb.append("null");
        } else {
            sb.append(this.f4672f);
        }
        sb.append(")");
        return sb.toString();
    }
}
