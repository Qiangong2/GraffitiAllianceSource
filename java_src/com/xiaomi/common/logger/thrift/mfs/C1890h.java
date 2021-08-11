package com.xiaomi.common.logger.thrift.mfs;

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

/* renamed from: com.xiaomi.common.logger.thrift.mfs.h */
public class C1890h implements Serializable, Cloneable, AbstractC2158b<C1890h, EnumC1891a> {

    /* renamed from: a */
    public static final Map<EnumC1891a, C2167b> f4818a;

    /* renamed from: b */
    private static final C2185k f4819b = new C2185k("PassportLandNodeInfo");

    /* renamed from: c */
    private static final C2177c f4820c = new C2177c("ip", (byte) 8, 1);

    /* renamed from: d */
    private static final C2177c f4821d = new C2177c("eid", (byte) 8, 2);

    /* renamed from: e */
    private static final C2177c f4822e = new C2177c("rt", (byte) 8, 3);

    /* renamed from: f */
    private int f4823f;

    /* renamed from: g */
    private int f4824g;

    /* renamed from: h */
    private int f4825h;

    /* renamed from: i */
    private BitSet f4826i = new BitSet(3);

    /* renamed from: com.xiaomi.common.logger.thrift.mfs.h$a */
    public enum EnumC1891a {
        IP(1, "ip"),
        EID(2, "eid"),
        RT(3, "rt");
        

        /* renamed from: d */
        private static final Map<String, EnumC1891a> f4830d = new HashMap();

        /* renamed from: e */
        private final short f4832e;

        /* renamed from: f */
        private final String f4833f;

        static {
            Iterator it = EnumSet.allOf(EnumC1891a.class).iterator();
            while (it.hasNext()) {
                EnumC1891a aVar = (EnumC1891a) it.next();
                f4830d.put(aVar.mo10096a(), aVar);
            }
        }

        private EnumC1891a(short s, String str) {
            this.f4832e = s;
            this.f4833f = str;
        }

        /* renamed from: a */
        public String mo10096a() {
            return this.f4833f;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC1891a.class);
        enumMap.put((Object) EnumC1891a.IP, (Object) new C2167b("ip", (byte) 1, new C2168c((byte) 8)));
        enumMap.put((Object) EnumC1891a.EID, (Object) new C2167b("eid", (byte) 1, new C2168c((byte) 8)));
        enumMap.put((Object) EnumC1891a.RT, (Object) new C2167b("rt", (byte) 1, new C2168c((byte) 8)));
        f4818a = Collections.unmodifiableMap(enumMap);
        C2167b.m8203a(C1890h.class, f4818a);
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: a */
    public void mo9945a(AbstractC2180f fVar) {
        fVar.mo12145g();
        while (true) {
            C2177c i = fVar.mo12147i();
            if (i.f6210b == 0) {
                fVar.mo12146h();
                if (!mo10084a()) {
                    throw new C2181g("Required field 'ip' was not found in serialized data! Struct: " + toString());
                } else if (!mo10088b()) {
                    throw new C2181g("Required field 'eid' was not found in serialized data! Struct: " + toString());
                } else if (!mo10090c()) {
                    throw new C2181g("Required field 'rt' was not found in serialized data! Struct: " + toString());
                } else {
                    mo10092d();
                    return;
                }
            } else {
                switch (i.f6211c) {
                    case 1:
                        if (i.f6210b != 8) {
                            C2183i.m8338a(fVar, i.f6210b);
                            break;
                        } else {
                            this.f4823f = fVar.mo12158t();
                            mo10083a(true);
                            break;
                        }
                    case 2:
                        if (i.f6210b != 8) {
                            C2183i.m8338a(fVar, i.f6210b);
                            break;
                        } else {
                            this.f4824g = fVar.mo12158t();
                            mo10087b(true);
                            break;
                        }
                    case 3:
                        if (i.f6210b != 8) {
                            C2183i.m8338a(fVar, i.f6210b);
                            break;
                        } else {
                            this.f4825h = fVar.mo12158t();
                            mo10089c(true);
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
    public void mo10083a(boolean z) {
        this.f4826i.set(0, z);
    }

    /* renamed from: a */
    public boolean mo10084a() {
        return this.f4826i.get(0);
    }

    /* renamed from: a */
    public boolean mo10085a(C1890h hVar) {
        return hVar != null && this.f4823f == hVar.f4823f && this.f4824g == hVar.f4824g && this.f4825h == hVar.f4825h;
    }

    /* renamed from: b */
    public int compareTo(C1890h hVar) {
        int a;
        int a2;
        int a3;
        if (!getClass().equals(hVar.getClass())) {
            return getClass().getName().compareTo(hVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo10084a()).compareTo(Boolean.valueOf(hVar.mo10084a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo10084a() && (a3 = C2159c.m8184a(this.f4823f, hVar.f4823f)) != 0) {
            return a3;
        }
        int compareTo2 = Boolean.valueOf(mo10088b()).compareTo(Boolean.valueOf(hVar.mo10088b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo10088b() && (a2 = C2159c.m8184a(this.f4824g, hVar.f4824g)) != 0) {
            return a2;
        }
        int compareTo3 = Boolean.valueOf(mo10090c()).compareTo(Boolean.valueOf(hVar.mo10090c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!mo10090c() || (a = C2159c.m8184a(this.f4825h, hVar.f4825h)) == 0) {
            return 0;
        }
        return a;
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: b */
    public void mo9950b(AbstractC2180f fVar) {
        mo10092d();
        fVar.mo12134a(f4819b);
        fVar.mo12130a(f4820c);
        fVar.mo12126a(this.f4823f);
        fVar.mo12138b();
        fVar.mo12130a(f4821d);
        fVar.mo12126a(this.f4824g);
        fVar.mo12138b();
        fVar.mo12130a(f4822e);
        fVar.mo12126a(this.f4825h);
        fVar.mo12138b();
        fVar.mo12139c();
        fVar.mo12124a();
    }

    /* renamed from: b */
    public void mo10087b(boolean z) {
        this.f4826i.set(1, z);
    }

    /* renamed from: b */
    public boolean mo10088b() {
        return this.f4826i.get(1);
    }

    /* renamed from: c */
    public void mo10089c(boolean z) {
        this.f4826i.set(2, z);
    }

    /* renamed from: c */
    public boolean mo10090c() {
        return this.f4826i.get(2);
    }

    /* renamed from: d */
    public void mo10092d() {
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1890h)) {
            return mo10085a((C1890h) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "PassportLandNodeInfo(" + "ip:" + this.f4823f + ", " + "eid:" + this.f4824g + ", " + "rt:" + this.f4825h + ")";
    }
}
