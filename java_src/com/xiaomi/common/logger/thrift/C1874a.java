package com.xiaomi.common.logger.thrift;

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
import org.apache.thrift.protocol.C2183i;
import org.apache.thrift.protocol.C2185k;

/* renamed from: com.xiaomi.common.logger.thrift.a */
public class C1874a implements Serializable, Cloneable, AbstractC2158b<C1874a, EnumC1875a> {

    /* renamed from: f */
    public static final Map<EnumC1875a, C2167b> f4645f;

    /* renamed from: g */
    private static final C2185k f4646g = new C2185k("Common");

    /* renamed from: h */
    private static final C2177c f4647h = new C2177c("uuid", (byte) 10, 1);

    /* renamed from: i */
    private static final C2177c f4648i = new C2177c("time", (byte) 11, 2);

    /* renamed from: j */
    private static final C2177c f4649j = new C2177c("clientIp", (byte) 11, 3);

    /* renamed from: k */
    private static final C2177c f4650k = new C2177c("serverIp", (byte) 11, 4);

    /* renamed from: l */
    private static final C2177c f4651l = new C2177c("serverHost", (byte) 11, 5);

    /* renamed from: a */
    public long f4652a = 0;

    /* renamed from: b */
    public String f4653b = "";

    /* renamed from: c */
    public String f4654c = "";

    /* renamed from: d */
    public String f4655d = "";

    /* renamed from: e */
    public String f4656e = "";

    /* renamed from: m */
    private BitSet f4657m = new BitSet(1);

    /* renamed from: com.xiaomi.common.logger.thrift.a$a */
    public enum EnumC1875a {
        UUID(1, "uuid"),
        TIME(2, "time"),
        CLIENT_IP(3, "clientIp"),
        SERVER_IP(4, "serverIp"),
        SERVER_HOST(5, "serverHost");
        

        /* renamed from: f */
        private static final Map<String, EnumC1875a> f4663f = new HashMap();

        /* renamed from: g */
        private final short f4665g;

        /* renamed from: h */
        private final String f4666h;

        static {
            Iterator it = EnumSet.allOf(EnumC1875a.class).iterator();
            while (it.hasNext()) {
                EnumC1875a aVar = (EnumC1875a) it.next();
                f4663f.put(aVar.mo9960a(), aVar);
            }
        }

        private EnumC1875a(short s, String str) {
            this.f4665g = s;
            this.f4666h = str;
        }

        /* renamed from: a */
        public String mo9960a() {
            return this.f4666h;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC1875a.class);
        enumMap.put((Object) EnumC1875a.UUID, (Object) new C2167b("uuid", (byte) 2, new C2168c((byte) 10)));
        enumMap.put((Object) EnumC1875a.TIME, (Object) new C2167b("time", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC1875a.CLIENT_IP, (Object) new C2167b("clientIp", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC1875a.SERVER_IP, (Object) new C2167b("serverIp", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC1875a.SERVER_HOST, (Object) new C2167b("serverHost", (byte) 2, new C2168c((byte) 11)));
        f4645f = Collections.unmodifiableMap(enumMap);
        C2167b.m8203a(C1874a.class, f4645f);
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: a */
    public void mo9945a(AbstractC2180f fVar) {
        fVar.mo12145g();
        while (true) {
            C2177c i = fVar.mo12147i();
            if (i.f6210b == 0) {
                fVar.mo12146h();
                mo9957f();
                return;
            }
            switch (i.f6211c) {
                case 1:
                    if (i.f6210b != 10) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f4652a = fVar.mo12159u();
                        mo9946a(true);
                        break;
                    }
                case 2:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f4653b = fVar.mo12161w();
                        break;
                    }
                case 3:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f4654c = fVar.mo12161w();
                        break;
                    }
                case 4:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f4655d = fVar.mo12161w();
                        break;
                    }
                case 5:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f4656e = fVar.mo12161w();
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
    public void mo9946a(boolean z) {
        this.f4657m.set(0, z);
    }

    /* renamed from: a */
    public boolean mo9947a() {
        return this.f4657m.get(0);
    }

    /* renamed from: a */
    public boolean mo9948a(C1874a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean a = mo9947a();
        boolean a2 = aVar.mo9947a();
        if ((a || a2) && (!a || !a2 || this.f4652a != aVar.f4652a)) {
            return false;
        }
        boolean b = mo9951b();
        boolean b2 = aVar.mo9951b();
        if ((b || b2) && (!b || !b2 || !this.f4653b.equals(aVar.f4653b))) {
            return false;
        }
        boolean c = mo9952c();
        boolean c2 = aVar.mo9952c();
        if ((c || c2) && (!c || !c2 || !this.f4654c.equals(aVar.f4654c))) {
            return false;
        }
        boolean d = mo9954d();
        boolean d2 = aVar.mo9954d();
        if ((d || d2) && (!d || !d2 || !this.f4655d.equals(aVar.f4655d))) {
            return false;
        }
        boolean e = mo9955e();
        boolean e2 = aVar.mo9955e();
        return (!e && !e2) || (e && e2 && this.f4656e.equals(aVar.f4656e));
    }

    /* renamed from: b */
    public int compareTo(C1874a aVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        if (!getClass().equals(aVar.getClass())) {
            return getClass().getName().compareTo(aVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo9947a()).compareTo(Boolean.valueOf(aVar.mo9947a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo9947a() && (a5 = C2159c.m8185a(this.f4652a, aVar.f4652a)) != 0) {
            return a5;
        }
        int compareTo2 = Boolean.valueOf(mo9951b()).compareTo(Boolean.valueOf(aVar.mo9951b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo9951b() && (a4 = C2159c.m8187a(this.f4653b, aVar.f4653b)) != 0) {
            return a4;
        }
        int compareTo3 = Boolean.valueOf(mo9952c()).compareTo(Boolean.valueOf(aVar.mo9952c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo9952c() && (a3 = C2159c.m8187a(this.f4654c, aVar.f4654c)) != 0) {
            return a3;
        }
        int compareTo4 = Boolean.valueOf(mo9954d()).compareTo(Boolean.valueOf(aVar.mo9954d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo9954d() && (a2 = C2159c.m8187a(this.f4655d, aVar.f4655d)) != 0) {
            return a2;
        }
        int compareTo5 = Boolean.valueOf(mo9955e()).compareTo(Boolean.valueOf(aVar.mo9955e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (!mo9955e() || (a = C2159c.m8187a(this.f4656e, aVar.f4656e)) == 0) {
            return 0;
        }
        return a;
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: b */
    public void mo9950b(AbstractC2180f fVar) {
        mo9957f();
        fVar.mo12134a(f4646g);
        if (mo9947a()) {
            fVar.mo12130a(f4647h);
            fVar.mo12127a(this.f4652a);
            fVar.mo12138b();
        }
        if (this.f4653b != null && mo9951b()) {
            fVar.mo12130a(f4648i);
            fVar.mo12128a(this.f4653b);
            fVar.mo12138b();
        }
        if (this.f4654c != null && mo9952c()) {
            fVar.mo12130a(f4649j);
            fVar.mo12128a(this.f4654c);
            fVar.mo12138b();
        }
        if (this.f4655d != null && mo9954d()) {
            fVar.mo12130a(f4650k);
            fVar.mo12128a(this.f4655d);
            fVar.mo12138b();
        }
        if (this.f4656e != null && mo9955e()) {
            fVar.mo12130a(f4651l);
            fVar.mo12128a(this.f4656e);
            fVar.mo12138b();
        }
        fVar.mo12139c();
        fVar.mo12124a();
    }

    /* renamed from: b */
    public boolean mo9951b() {
        return this.f4653b != null;
    }

    /* renamed from: c */
    public boolean mo9952c() {
        return this.f4654c != null;
    }

    /* renamed from: d */
    public boolean mo9954d() {
        return this.f4655d != null;
    }

    /* renamed from: e */
    public boolean mo9955e() {
        return this.f4656e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C1874a)) {
            return mo9948a((C1874a) obj);
        }
        return false;
    }

    /* renamed from: f */
    public void mo9957f() {
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("Common(");
        boolean z2 = true;
        if (mo9947a()) {
            sb.append("uuid:");
            sb.append(this.f4652a);
            z2 = false;
        }
        if (mo9951b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("time:");
            if (this.f4653b == null) {
                sb.append("null");
            } else {
                sb.append(this.f4653b);
            }
            z2 = false;
        }
        if (mo9952c()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("clientIp:");
            if (this.f4654c == null) {
                sb.append("null");
            } else {
                sb.append(this.f4654c);
            }
            z2 = false;
        }
        if (mo9954d()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("serverIp:");
            if (this.f4655d == null) {
                sb.append("null");
            } else {
                sb.append(this.f4655d);
            }
        } else {
            z = z2;
        }
        if (mo9955e()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("serverHost:");
            if (this.f4656e == null) {
                sb.append("null");
            } else {
                sb.append(this.f4656e);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
