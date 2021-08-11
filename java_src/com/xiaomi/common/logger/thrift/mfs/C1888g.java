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

/* renamed from: com.xiaomi.common.logger.thrift.mfs.g */
public class C1888g implements Serializable, Cloneable, AbstractC2158b<C1888g, EnumC1889a> {

    /* renamed from: a */
    public static final Map<EnumC1889a, C2167b> f4806a;

    /* renamed from: b */
    private static final C2185k f4807b = new C2185k("PassportHostInfo");

    /* renamed from: c */
    private static final C2177c f4808c = new C2177c("host", (byte) 11, 1);

    /* renamed from: d */
    private static final C2177c f4809d = new C2177c("land_node_info", C0027o.f104m, 2);

    /* renamed from: e */
    private String f4810e;

    /* renamed from: f */
    private List<C1890h> f4811f;

    /* renamed from: com.xiaomi.common.logger.thrift.mfs.g$a */
    public enum EnumC1889a {
        HOST(1, "host"),
        LAND_NODE_INFO(2, "land_node_info");
        

        /* renamed from: c */
        private static final Map<String, EnumC1889a> f4814c = new HashMap();

        /* renamed from: d */
        private final short f4816d;

        /* renamed from: e */
        private final String f4817e;

        static {
            Iterator it = EnumSet.allOf(EnumC1889a.class).iterator();
            while (it.hasNext()) {
                EnumC1889a aVar = (EnumC1889a) it.next();
                f4814c.put(aVar.mo10082a(), aVar);
            }
        }

        private EnumC1889a(short s, String str) {
            this.f4816d = s;
            this.f4817e = str;
        }

        /* renamed from: a */
        public String mo10082a() {
            return this.f4817e;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC1889a.class);
        enumMap.put((Object) EnumC1889a.HOST, (Object) new C2167b("host", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC1889a.LAND_NODE_INFO, (Object) new C2167b("land_node_info", (byte) 1, new C2169d(C0027o.f104m, new C2172g((byte) 12, C1890h.class))));
        f4806a = Collections.unmodifiableMap(enumMap);
        C2167b.m8203a(C1888g.class, f4806a);
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: a */
    public void mo9945a(AbstractC2180f fVar) {
        fVar.mo12145g();
        while (true) {
            C2177c i = fVar.mo12147i();
            if (i.f6210b == 0) {
                fVar.mo12146h();
                mo10077c();
                return;
            }
            switch (i.f6211c) {
                case 1:
                    if (i.f6210b == 11) {
                        this.f4810e = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 2:
                    if (i.f6210b == 15) {
                        C2178d m = fVar.mo12151m();
                        this.f4811f = new ArrayList(m.f6213b);
                        for (int i2 = 0; i2 < m.f6213b; i2++) {
                            C1890h hVar = new C1890h();
                            hVar.mo9945a(fVar);
                            this.f4811f.add(hVar);
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
    public boolean mo10073a() {
        return this.f4810e != null;
    }

    /* renamed from: a */
    public boolean mo10074a(C1888g gVar) {
        if (gVar == null) {
            return false;
        }
        boolean a = mo10073a();
        boolean a2 = gVar.mo10073a();
        if ((a || a2) && (!a || !a2 || !this.f4810e.equals(gVar.f4810e))) {
            return false;
        }
        boolean b = mo10076b();
        boolean b2 = gVar.mo10076b();
        return (!b && !b2) || (b && b2 && this.f4811f.equals(gVar.f4811f));
    }

    /* renamed from: b */
    public int compareTo(C1888g gVar) {
        int a;
        int a2;
        if (!getClass().equals(gVar.getClass())) {
            return getClass().getName().compareTo(gVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo10073a()).compareTo(Boolean.valueOf(gVar.mo10073a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo10073a() && (a2 = C2159c.m8187a(this.f4810e, gVar.f4810e)) != 0) {
            return a2;
        }
        int compareTo2 = Boolean.valueOf(mo10076b()).compareTo(Boolean.valueOf(gVar.mo10076b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (!mo10076b() || (a = C2159c.m8189a(this.f4811f, gVar.f4811f)) == 0) {
            return 0;
        }
        return a;
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: b */
    public void mo9950b(AbstractC2180f fVar) {
        mo10077c();
        fVar.mo12134a(f4807b);
        if (this.f4810e != null) {
            fVar.mo12130a(f4808c);
            fVar.mo12128a(this.f4810e);
            fVar.mo12138b();
        }
        if (this.f4811f != null) {
            fVar.mo12130a(f4809d);
            fVar.mo12131a(new C2178d((byte) 12, this.f4811f.size()));
            for (C1890h hVar : this.f4811f) {
                hVar.mo9950b(fVar);
            }
            fVar.mo12143e();
            fVar.mo12138b();
        }
        fVar.mo12139c();
        fVar.mo12124a();
    }

    /* renamed from: b */
    public boolean mo10076b() {
        return this.f4811f != null;
    }

    /* renamed from: c */
    public void mo10077c() {
        if (this.f4810e == null) {
            throw new C2181g("Required field 'host' was not present! Struct: " + toString());
        } else if (this.f4811f == null) {
            throw new C2181g("Required field 'land_node_info' was not present! Struct: " + toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1888g)) {
            return mo10074a((C1888g) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PassportHostInfo(");
        sb.append("host:");
        if (this.f4810e == null) {
            sb.append("null");
        } else {
            sb.append(this.f4810e);
        }
        sb.append(", ");
        sb.append("land_node_info:");
        if (this.f4811f == null) {
            sb.append("null");
        } else {
            sb.append(this.f4811f);
        }
        sb.append(")");
        return sb.toString();
    }
}
