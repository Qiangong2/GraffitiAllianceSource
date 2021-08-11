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
import org.apache.thrift.meta_data.C2170e;
import org.apache.thrift.protocol.AbstractC2180f;
import org.apache.thrift.protocol.C2177c;
import org.apache.thrift.protocol.C2179e;
import org.apache.thrift.protocol.C2181g;
import org.apache.thrift.protocol.C2183i;
import org.apache.thrift.protocol.C2185k;

/* renamed from: com.xiaomi.common.logger.thrift.mfs.d */
public class C1882d implements Serializable, Cloneable, AbstractC2158b<C1882d, EnumC1883a> {

    /* renamed from: a */
    public static final Map<EnumC1883a, C2167b> f4733a;

    /* renamed from: b */
    private static final C2185k f4734b = new C2185k("LandNodeInfo");

    /* renamed from: c */
    private static final C2177c f4735c = new C2177c("ip", (byte) 11, 1);

    /* renamed from: d */
    private static final C2177c f4736d = new C2177c("failed_count", (byte) 8, 2);

    /* renamed from: e */
    private static final C2177c f4737e = new C2177c("success_count", (byte) 8, 3);

    /* renamed from: f */
    private static final C2177c f4738f = new C2177c("duration", (byte) 10, 4);

    /* renamed from: g */
    private static final C2177c f4739g = new C2177c("size", (byte) 8, 5);

    /* renamed from: h */
    private static final C2177c f4740h = new C2177c("exp_info", (byte) 13, 6);

    /* renamed from: i */
    private static final C2177c f4741i = new C2177c("http_info", (byte) 13, 7);

    /* renamed from: j */
    private String f4742j;

    /* renamed from: k */
    private int f4743k;

    /* renamed from: l */
    private int f4744l;

    /* renamed from: m */
    private long f4745m;

    /* renamed from: n */
    private int f4746n;

    /* renamed from: o */
    private Map<String, Integer> f4747o;

    /* renamed from: p */
    private Map<Integer, Integer> f4748p;

    /* renamed from: q */
    private BitSet f4749q = new BitSet(4);

    /* renamed from: com.xiaomi.common.logger.thrift.mfs.d$a */
    public enum EnumC1883a {
        IP(1, "ip"),
        FAILED_COUNT(2, "failed_count"),
        SUCCESS_COUNT(3, "success_count"),
        DURATION(4, "duration"),
        SIZE(5, "size"),
        EXP_INFO(6, "exp_info"),
        HTTP_INFO(7, "http_info");
        

        /* renamed from: h */
        private static final Map<String, EnumC1883a> f4757h = new HashMap();

        /* renamed from: i */
        private final short f4759i;

        /* renamed from: j */
        private final String f4760j;

        static {
            Iterator it = EnumSet.allOf(EnumC1883a.class).iterator();
            while (it.hasNext()) {
                EnumC1883a aVar = (EnumC1883a) it.next();
                f4757h.put(aVar.mo10041a(), aVar);
            }
        }

        private EnumC1883a(short s, String str) {
            this.f4759i = s;
            this.f4760j = str;
        }

        /* renamed from: a */
        public String mo10041a() {
            return this.f4760j;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC1883a.class);
        enumMap.put((Object) EnumC1883a.IP, (Object) new C2167b("ip", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC1883a.FAILED_COUNT, (Object) new C2167b("failed_count", (byte) 1, new C2168c((byte) 8)));
        enumMap.put((Object) EnumC1883a.SUCCESS_COUNT, (Object) new C2167b("success_count", (byte) 1, new C2168c((byte) 8)));
        enumMap.put((Object) EnumC1883a.DURATION, (Object) new C2167b("duration", (byte) 1, new C2168c((byte) 10)));
        enumMap.put((Object) EnumC1883a.SIZE, (Object) new C2167b("size", (byte) 1, new C2168c((byte) 8)));
        enumMap.put((Object) EnumC1883a.EXP_INFO, (Object) new C2167b("exp_info", (byte) 2, new C2170e((byte) 13, new C2168c((byte) 11), new C2168c((byte) 8))));
        enumMap.put((Object) EnumC1883a.HTTP_INFO, (Object) new C2167b("http_info", (byte) 2, new C2170e((byte) 13, new C2168c((byte) 8), new C2168c((byte) 8))));
        f4733a = Collections.unmodifiableMap(enumMap);
        C2167b.m8203a(C1882d.class, f4733a);
    }

    /* renamed from: a */
    public C1882d mo10017a(int i) {
        this.f4743k = i;
        mo10021a(true);
        return this;
    }

    /* renamed from: a */
    public C1882d mo10018a(long j) {
        this.f4745m = j;
        mo10029c(true);
        return this;
    }

    /* renamed from: a */
    public C1882d mo10019a(String str) {
        this.f4742j = str;
        return this;
    }

    /* renamed from: a */
    public C1882d mo10020a(Map<String, Integer> map) {
        this.f4747o = map;
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
                if (!mo10027b()) {
                    throw new C2181g("Required field 'failed_count' was not found in serialized data! Struct: " + toString());
                } else if (!mo10030c()) {
                    throw new C2181g("Required field 'success_count' was not found in serialized data! Struct: " + toString());
                } else if (!mo10033d()) {
                    throw new C2181g("Required field 'duration' was not found in serialized data! Struct: " + toString());
                } else if (!mo10034e()) {
                    throw new C2181g("Required field 'size' was not found in serialized data! Struct: " + toString());
                } else {
                    mo10038h();
                    return;
                }
            } else {
                switch (i.f6211c) {
                    case 1:
                        if (i.f6210b == 11) {
                            this.f4742j = fVar.mo12161w();
                            break;
                        } else {
                            C2183i.m8338a(fVar, i.f6210b);
                            break;
                        }
                    case 2:
                        if (i.f6210b == 8) {
                            this.f4743k = fVar.mo12158t();
                            mo10021a(true);
                            break;
                        } else {
                            C2183i.m8338a(fVar, i.f6210b);
                            break;
                        }
                    case 3:
                        if (i.f6210b == 8) {
                            this.f4744l = fVar.mo12158t();
                            mo10026b(true);
                            break;
                        } else {
                            C2183i.m8338a(fVar, i.f6210b);
                            break;
                        }
                    case 4:
                        if (i.f6210b == 10) {
                            this.f4745m = fVar.mo12159u();
                            mo10029c(true);
                            break;
                        } else {
                            C2183i.m8338a(fVar, i.f6210b);
                            break;
                        }
                    case 5:
                        if (i.f6210b == 8) {
                            this.f4746n = fVar.mo12158t();
                            mo10032d(true);
                            break;
                        } else {
                            C2183i.m8338a(fVar, i.f6210b);
                            break;
                        }
                    case 6:
                        if (i.f6210b == 13) {
                            C2179e k = fVar.mo12149k();
                            this.f4747o = new HashMap(k.f6216c * 2);
                            for (int i2 = 0; i2 < k.f6216c; i2++) {
                                this.f4747o.put(fVar.mo12161w(), Integer.valueOf(fVar.mo12158t()));
                            }
                            fVar.mo12150l();
                            break;
                        } else {
                            C2183i.m8338a(fVar, i.f6210b);
                            break;
                        }
                    case 7:
                        if (i.f6210b == 13) {
                            C2179e k2 = fVar.mo12149k();
                            this.f4748p = new HashMap(k2.f6216c * 2);
                            for (int i3 = 0; i3 < k2.f6216c; i3++) {
                                this.f4748p.put(Integer.valueOf(fVar.mo12158t()), Integer.valueOf(fVar.mo12158t()));
                            }
                            fVar.mo12150l();
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
    }

    /* renamed from: a */
    public void mo10021a(boolean z) {
        this.f4749q.set(0, z);
    }

    /* renamed from: a */
    public boolean mo10022a() {
        return this.f4742j != null;
    }

    /* renamed from: a */
    public boolean mo10023a(C1882d dVar) {
        if (dVar == null) {
            return false;
        }
        boolean a = mo10022a();
        boolean a2 = dVar.mo10022a();
        if (((a || a2) && (!a || !a2 || !this.f4742j.equals(dVar.f4742j))) || this.f4743k != dVar.f4743k || this.f4744l != dVar.f4744l || this.f4745m != dVar.f4745m || this.f4746n != dVar.f4746n) {
            return false;
        }
        boolean f = mo10036f();
        boolean f2 = dVar.mo10036f();
        if ((f || f2) && (!f || !f2 || !this.f4747o.equals(dVar.f4747o))) {
            return false;
        }
        boolean g = mo10037g();
        boolean g2 = dVar.mo10037g();
        return (!g && !g2) || (g && g2 && this.f4748p.equals(dVar.f4748p));
    }

    /* renamed from: b */
    public int compareTo(C1882d dVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        if (!getClass().equals(dVar.getClass())) {
            return getClass().getName().compareTo(dVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo10022a()).compareTo(Boolean.valueOf(dVar.mo10022a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo10022a() && (a7 = C2159c.m8187a(this.f4742j, dVar.f4742j)) != 0) {
            return a7;
        }
        int compareTo2 = Boolean.valueOf(mo10027b()).compareTo(Boolean.valueOf(dVar.mo10027b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo10027b() && (a6 = C2159c.m8184a(this.f4743k, dVar.f4743k)) != 0) {
            return a6;
        }
        int compareTo3 = Boolean.valueOf(mo10030c()).compareTo(Boolean.valueOf(dVar.mo10030c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo10030c() && (a5 = C2159c.m8184a(this.f4744l, dVar.f4744l)) != 0) {
            return a5;
        }
        int compareTo4 = Boolean.valueOf(mo10033d()).compareTo(Boolean.valueOf(dVar.mo10033d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo10033d() && (a4 = C2159c.m8185a(this.f4745m, dVar.f4745m)) != 0) {
            return a4;
        }
        int compareTo5 = Boolean.valueOf(mo10034e()).compareTo(Boolean.valueOf(dVar.mo10034e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo10034e() && (a3 = C2159c.m8184a(this.f4746n, dVar.f4746n)) != 0) {
            return a3;
        }
        int compareTo6 = Boolean.valueOf(mo10036f()).compareTo(Boolean.valueOf(dVar.mo10036f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo10036f() && (a2 = C2159c.m8190a(this.f4747o, dVar.f4747o)) != 0) {
            return a2;
        }
        int compareTo7 = Boolean.valueOf(mo10037g()).compareTo(Boolean.valueOf(dVar.mo10037g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (!mo10037g() || (a = C2159c.m8190a(this.f4748p, dVar.f4748p)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: b */
    public C1882d mo10025b(int i) {
        this.f4744l = i;
        mo10026b(true);
        return this;
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: b */
    public void mo9950b(AbstractC2180f fVar) {
        mo10038h();
        fVar.mo12134a(f4734b);
        if (this.f4742j != null) {
            fVar.mo12130a(f4735c);
            fVar.mo12128a(this.f4742j);
            fVar.mo12138b();
        }
        fVar.mo12130a(f4736d);
        fVar.mo12126a(this.f4743k);
        fVar.mo12138b();
        fVar.mo12130a(f4737e);
        fVar.mo12126a(this.f4744l);
        fVar.mo12138b();
        fVar.mo12130a(f4738f);
        fVar.mo12127a(this.f4745m);
        fVar.mo12138b();
        fVar.mo12130a(f4739g);
        fVar.mo12126a(this.f4746n);
        fVar.mo12138b();
        if (this.f4747o != null && mo10036f()) {
            fVar.mo12130a(f4740h);
            fVar.mo12132a(new C2179e((byte) 11, (byte) 8, this.f4747o.size()));
            for (Map.Entry<String, Integer> entry : this.f4747o.entrySet()) {
                fVar.mo12128a(entry.getKey());
                fVar.mo12126a(entry.getValue().intValue());
            }
            fVar.mo12141d();
            fVar.mo12138b();
        }
        if (this.f4748p != null && mo10037g()) {
            fVar.mo12130a(f4741i);
            fVar.mo12132a(new C2179e((byte) 8, (byte) 8, this.f4748p.size()));
            for (Map.Entry<Integer, Integer> entry2 : this.f4748p.entrySet()) {
                fVar.mo12126a(entry2.getKey().intValue());
                fVar.mo12126a(entry2.getValue().intValue());
            }
            fVar.mo12141d();
            fVar.mo12138b();
        }
        fVar.mo12139c();
        fVar.mo12124a();
    }

    /* renamed from: b */
    public void mo10026b(boolean z) {
        this.f4749q.set(1, z);
    }

    /* renamed from: b */
    public boolean mo10027b() {
        return this.f4749q.get(0);
    }

    /* renamed from: c */
    public C1882d mo10028c(int i) {
        this.f4746n = i;
        mo10032d(true);
        return this;
    }

    /* renamed from: c */
    public void mo10029c(boolean z) {
        this.f4749q.set(2, z);
    }

    /* renamed from: c */
    public boolean mo10030c() {
        return this.f4749q.get(1);
    }

    /* renamed from: d */
    public void mo10032d(boolean z) {
        this.f4749q.set(3, z);
    }

    /* renamed from: d */
    public boolean mo10033d() {
        return this.f4749q.get(2);
    }

    /* renamed from: e */
    public boolean mo10034e() {
        return this.f4749q.get(3);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1882d)) {
            return mo10023a((C1882d) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo10036f() {
        return this.f4747o != null;
    }

    /* renamed from: g */
    public boolean mo10037g() {
        return this.f4748p != null;
    }

    /* renamed from: h */
    public void mo10038h() {
        if (this.f4742j == null) {
            throw new C2181g("Required field 'ip' was not present! Struct: " + toString());
        }
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LandNodeInfo(");
        sb.append("ip:");
        if (this.f4742j == null) {
            sb.append("null");
        } else {
            sb.append(this.f4742j);
        }
        sb.append(", ");
        sb.append("failed_count:");
        sb.append(this.f4743k);
        sb.append(", ");
        sb.append("success_count:");
        sb.append(this.f4744l);
        sb.append(", ");
        sb.append("duration:");
        sb.append(this.f4745m);
        sb.append(", ");
        sb.append("size:");
        sb.append(this.f4746n);
        if (mo10036f()) {
            sb.append(", ");
            sb.append("exp_info:");
            if (this.f4747o == null) {
                sb.append("null");
            } else {
                sb.append(this.f4747o);
            }
        }
        if (mo10037g()) {
            sb.append(", ");
            sb.append("http_info:");
            if (this.f4748p == null) {
                sb.append("null");
            } else {
                sb.append(this.f4748p);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
