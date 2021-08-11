package com.xiaomi.push.thrift;

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

/* renamed from: com.xiaomi.push.thrift.c */
public class C2000c implements Serializable, Cloneable, AbstractC2158b<C2000c, EnumC2001a> {

    /* renamed from: d */
    public static final Map<EnumC2001a, C2167b> f5273d;

    /* renamed from: e */
    private static final C2185k f5274e = new C2185k("StatsEvents");

    /* renamed from: f */
    private static final C2177c f5275f = new C2177c("uuid", (byte) 11, 1);

    /* renamed from: g */
    private static final C2177c f5276g = new C2177c("operator", (byte) 11, 2);

    /* renamed from: h */
    private static final C2177c f5277h = new C2177c("events", C0027o.f104m, 3);

    /* renamed from: a */
    public String f5278a;

    /* renamed from: b */
    public String f5279b;

    /* renamed from: c */
    public List<C1998b> f5280c;

    /* renamed from: com.xiaomi.push.thrift.c$a */
    public enum EnumC2001a {
        UUID(1, "uuid"),
        OPERATOR(2, "operator"),
        EVENTS(3, "events");
        

        /* renamed from: d */
        private static final Map<String, EnumC2001a> f5284d = new HashMap();

        /* renamed from: e */
        private final short f5286e;

        /* renamed from: f */
        private final String f5287f;

        static {
            Iterator it = EnumSet.allOf(EnumC2001a.class).iterator();
            while (it.hasNext()) {
                EnumC2001a aVar = (EnumC2001a) it.next();
                f5284d.put(aVar.mo10493a(), aVar);
            }
        }

        private EnumC2001a(short s, String str) {
            this.f5286e = s;
            this.f5287f = str;
        }

        /* renamed from: a */
        public String mo10493a() {
            return this.f5287f;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC2001a.class);
        enumMap.put((Object) EnumC2001a.UUID, (Object) new C2167b("uuid", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2001a.OPERATOR, (Object) new C2167b("operator", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2001a.EVENTS, (Object) new C2167b("events", (byte) 1, new C2169d(C0027o.f104m, new C2172g((byte) 12, C1998b.class))));
        f5273d = Collections.unmodifiableMap(enumMap);
        C2167b.m8203a(C2000c.class, f5273d);
    }

    public C2000c() {
    }

    public C2000c(String str, List<C1998b> list) {
        this();
        this.f5278a = str;
        this.f5280c = list;
    }

    /* renamed from: a */
    public C2000c mo10482a(String str) {
        this.f5279b = str;
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
                mo10489d();
                return;
            }
            switch (i.f6211c) {
                case 1:
                    if (i.f6210b == 11) {
                        this.f5278a = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 2:
                    if (i.f6210b == 11) {
                        this.f5279b = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 3:
                    if (i.f6210b == 15) {
                        C2178d m = fVar.mo12151m();
                        this.f5280c = new ArrayList(m.f6213b);
                        for (int i2 = 0; i2 < m.f6213b; i2++) {
                            C1998b bVar = new C1998b();
                            bVar.mo9945a(fVar);
                            this.f5280c.add(bVar);
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
    public boolean mo10483a() {
        return this.f5278a != null;
    }

    /* renamed from: a */
    public boolean mo10484a(C2000c cVar) {
        if (cVar == null) {
            return false;
        }
        boolean a = mo10483a();
        boolean a2 = cVar.mo10483a();
        if ((a || a2) && (!a || !a2 || !this.f5278a.equals(cVar.f5278a))) {
            return false;
        }
        boolean b = mo10486b();
        boolean b2 = cVar.mo10486b();
        if ((b || b2) && (!b || !b2 || !this.f5279b.equals(cVar.f5279b))) {
            return false;
        }
        boolean c = mo10487c();
        boolean c2 = cVar.mo10487c();
        return (!c && !c2) || (c && c2 && this.f5280c.equals(cVar.f5280c));
    }

    /* renamed from: b */
    public int compareTo(C2000c cVar) {
        int a;
        int a2;
        int a3;
        if (!getClass().equals(cVar.getClass())) {
            return getClass().getName().compareTo(cVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo10483a()).compareTo(Boolean.valueOf(cVar.mo10483a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo10483a() && (a3 = C2159c.m8187a(this.f5278a, cVar.f5278a)) != 0) {
            return a3;
        }
        int compareTo2 = Boolean.valueOf(mo10486b()).compareTo(Boolean.valueOf(cVar.mo10486b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo10486b() && (a2 = C2159c.m8187a(this.f5279b, cVar.f5279b)) != 0) {
            return a2;
        }
        int compareTo3 = Boolean.valueOf(mo10487c()).compareTo(Boolean.valueOf(cVar.mo10487c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (!mo10487c() || (a = C2159c.m8189a(this.f5280c, cVar.f5280c)) == 0) {
            return 0;
        }
        return a;
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: b */
    public void mo9950b(AbstractC2180f fVar) {
        mo10489d();
        fVar.mo12134a(f5274e);
        if (this.f5278a != null) {
            fVar.mo12130a(f5275f);
            fVar.mo12128a(this.f5278a);
            fVar.mo12138b();
        }
        if (this.f5279b != null && mo10486b()) {
            fVar.mo12130a(f5276g);
            fVar.mo12128a(this.f5279b);
            fVar.mo12138b();
        }
        if (this.f5280c != null) {
            fVar.mo12130a(f5277h);
            fVar.mo12131a(new C2178d((byte) 12, this.f5280c.size()));
            for (C1998b bVar : this.f5280c) {
                bVar.mo9950b(fVar);
            }
            fVar.mo12143e();
            fVar.mo12138b();
        }
        fVar.mo12139c();
        fVar.mo12124a();
    }

    /* renamed from: b */
    public boolean mo10486b() {
        return this.f5279b != null;
    }

    /* renamed from: c */
    public boolean mo10487c() {
        return this.f5280c != null;
    }

    /* renamed from: d */
    public void mo10489d() {
        if (this.f5278a == null) {
            throw new C2181g("Required field 'uuid' was not present! Struct: " + toString());
        } else if (this.f5280c == null) {
            throw new C2181g("Required field 'events' was not present! Struct: " + toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C2000c)) {
            return mo10484a((C2000c) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        if (this.f5278a == null) {
            sb.append("null");
        } else {
            sb.append(this.f5278a);
        }
        if (mo10486b()) {
            sb.append(", ");
            sb.append("operator:");
            if (this.f5279b == null) {
                sb.append("null");
            } else {
                sb.append(this.f5279b);
            }
        }
        sb.append(", ");
        sb.append("events:");
        if (this.f5280c == null) {
            sb.append("null");
        } else {
            sb.append(this.f5280c);
        }
        sb.append(")");
        return sb.toString();
    }
}
