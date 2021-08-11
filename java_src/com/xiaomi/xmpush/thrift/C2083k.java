package com.xiaomi.xmpush.thrift;

import com.wanmei.push.bean.AppState;
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
import org.apache.thrift.meta_data.C2172g;
import org.apache.thrift.protocol.AbstractC2180f;
import org.apache.thrift.protocol.C2177c;
import org.apache.thrift.protocol.C2181g;
import org.apache.thrift.protocol.C2183i;
import org.apache.thrift.protocol.C2185k;

/* renamed from: com.xiaomi.xmpush.thrift.k */
public class C2083k implements Serializable, Cloneable, AbstractC2158b<C2083k, EnumC2084a> {

    /* renamed from: k */
    public static final Map<EnumC2084a, C2167b> f5828k;

    /* renamed from: l */
    private static final C2185k f5829l = new C2185k("XmPushActionRegistrationResult");

    /* renamed from: m */
    private static final C2177c f5830m = new C2177c("debug", (byte) 11, 1);

    /* renamed from: n */
    private static final C2177c f5831n = new C2177c("target", (byte) 12, 2);

    /* renamed from: o */
    private static final C2177c f5832o = new C2177c("id", (byte) 11, 3);

    /* renamed from: p */
    private static final C2177c f5833p = new C2177c(AppState.APP_ID, (byte) 11, 4);

    /* renamed from: q */
    private static final C2177c f5834q = new C2177c("request", (byte) 12, 5);

    /* renamed from: r */
    private static final C2177c f5835r = new C2177c("errorCode", (byte) 10, 6);

    /* renamed from: s */
    private static final C2177c f5836s = new C2177c("reason", (byte) 11, 7);

    /* renamed from: t */
    private static final C2177c f5837t = new C2177c("regId", (byte) 11, 8);

    /* renamed from: u */
    private static final C2177c f5838u = new C2177c("regSecret", (byte) 11, 9);

    /* renamed from: v */
    private static final C2177c f5839v = new C2177c("packageName", (byte) 11, 10);

    /* renamed from: a */
    public String f5840a;

    /* renamed from: b */
    public C2069d f5841b;

    /* renamed from: c */
    public String f5842c;

    /* renamed from: d */
    public String f5843d;

    /* renamed from: e */
    public C2081j f5844e;

    /* renamed from: f */
    public long f5845f;

    /* renamed from: g */
    public String f5846g;

    /* renamed from: h */
    public String f5847h;

    /* renamed from: i */
    public String f5848i;

    /* renamed from: j */
    public String f5849j;

    /* renamed from: w */
    private BitSet f5850w = new BitSet(1);

    /* renamed from: com.xiaomi.xmpush.thrift.k$a */
    public enum EnumC2084a {
        DEBUG(1, "debug"),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, AppState.APP_ID),
        REQUEST(5, "request"),
        ERROR_CODE(6, "errorCode"),
        REASON(7, "reason"),
        REG_ID(8, "regId"),
        REG_SECRET(9, "regSecret"),
        PACKAGE_NAME(10, "packageName");
        

        /* renamed from: k */
        private static final Map<String, EnumC2084a> f5861k = new HashMap();

        /* renamed from: l */
        private final short f5863l;

        /* renamed from: m */
        private final String f5864m;

        static {
            Iterator it = EnumSet.allOf(EnumC2084a.class).iterator();
            while (it.hasNext()) {
                EnumC2084a aVar = (EnumC2084a) it.next();
                f5861k.put(aVar.mo10924a(), aVar);
            }
        }

        private EnumC2084a(short s, String str) {
            this.f5863l = s;
            this.f5864m = str;
        }

        /* renamed from: a */
        public String mo10924a() {
            return this.f5864m;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC2084a.class);
        enumMap.put((Object) EnumC2084a.DEBUG, (Object) new C2167b("debug", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2084a.TARGET, (Object) new C2167b("target", (byte) 2, new C2172g((byte) 12, C2069d.class)));
        enumMap.put((Object) EnumC2084a.ID, (Object) new C2167b("id", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2084a.APP_ID, (Object) new C2167b(AppState.APP_ID, (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2084a.REQUEST, (Object) new C2167b("request", (byte) 2, new C2172g((byte) 12, C2081j.class)));
        enumMap.put((Object) EnumC2084a.ERROR_CODE, (Object) new C2167b("errorCode", (byte) 1, new C2168c((byte) 10)));
        enumMap.put((Object) EnumC2084a.REASON, (Object) new C2167b("reason", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2084a.REG_ID, (Object) new C2167b("regId", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2084a.REG_SECRET, (Object) new C2167b("regSecret", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2084a.PACKAGE_NAME, (Object) new C2167b("packageName", (byte) 2, new C2168c((byte) 11)));
        f5828k = Collections.unmodifiableMap(enumMap);
        C2167b.m8203a(C2083k.class, f5828k);
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: a */
    public void mo9945a(AbstractC2180f fVar) {
        fVar.mo12145g();
        while (true) {
            C2177c i = fVar.mo12147i();
            if (i.f6210b == 0) {
                fVar.mo12146h();
                if (!mo10916f()) {
                    throw new C2181g("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                mo10922k();
                return;
            }
            switch (i.f6211c) {
                case 1:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5840a = fVar.mo12161w();
                        break;
                    }
                case 2:
                    if (i.f6210b != 12) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5841b = new C2069d();
                        this.f5841b.mo9945a(fVar);
                        break;
                    }
                case 3:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5842c = fVar.mo12161w();
                        break;
                    }
                case 4:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5843d = fVar.mo12161w();
                        break;
                    }
                case 5:
                    if (i.f6210b != 12) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5844e = new C2081j();
                        this.f5844e.mo9945a(fVar);
                        break;
                    }
                case 6:
                    if (i.f6210b != 10) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5845f = fVar.mo12159u();
                        mo10906a(true);
                        break;
                    }
                case 7:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5846g = fVar.mo12161w();
                        break;
                    }
                case 8:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5847h = fVar.mo12161w();
                        break;
                    }
                case 9:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5848i = fVar.mo12161w();
                        break;
                    }
                case 10:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5849j = fVar.mo12161w();
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
    public void mo10906a(boolean z) {
        this.f5850w.set(0, z);
    }

    /* renamed from: a */
    public boolean mo10907a() {
        return this.f5840a != null;
    }

    /* renamed from: a */
    public boolean mo10908a(C2083k kVar) {
        if (kVar == null) {
            return false;
        }
        boolean a = mo10907a();
        boolean a2 = kVar.mo10907a();
        if ((a || a2) && (!a || !a2 || !this.f5840a.equals(kVar.f5840a))) {
            return false;
        }
        boolean b = mo10910b();
        boolean b2 = kVar.mo10910b();
        if ((b || b2) && (!b || !b2 || !this.f5841b.mo10741a(kVar.f5841b))) {
            return false;
        }
        boolean c = mo10911c();
        boolean c2 = kVar.mo10911c();
        if ((c || c2) && (!c || !c2 || !this.f5842c.equals(kVar.f5842c))) {
            return false;
        }
        boolean d = mo10913d();
        boolean d2 = kVar.mo10913d();
        if ((d || d2) && (!d || !d2 || !this.f5843d.equals(kVar.f5843d))) {
            return false;
        }
        boolean e = mo10914e();
        boolean e2 = kVar.mo10914e();
        if (((e || e2) && (!e || !e2 || !this.f5844e.mo10882a(kVar.f5844e))) || this.f5845f != kVar.f5845f) {
            return false;
        }
        boolean g = mo10917g();
        boolean g2 = kVar.mo10917g();
        if ((g || g2) && (!g || !g2 || !this.f5846g.equals(kVar.f5846g))) {
            return false;
        }
        boolean h = mo10918h();
        boolean h2 = kVar.mo10918h();
        if ((h || h2) && (!h || !h2 || !this.f5847h.equals(kVar.f5847h))) {
            return false;
        }
        boolean i = mo10920i();
        boolean i2 = kVar.mo10920i();
        if ((i || i2) && (!i || !i2 || !this.f5848i.equals(kVar.f5848i))) {
            return false;
        }
        boolean j = mo10921j();
        boolean j2 = kVar.mo10921j();
        return (!j && !j2) || (j && j2 && this.f5849j.equals(kVar.f5849j));
    }

    /* renamed from: b */
    public int compareTo(C2083k kVar) {
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
        if (!getClass().equals(kVar.getClass())) {
            return getClass().getName().compareTo(kVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo10907a()).compareTo(Boolean.valueOf(kVar.mo10907a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo10907a() && (a10 = C2159c.m8187a(this.f5840a, kVar.f5840a)) != 0) {
            return a10;
        }
        int compareTo2 = Boolean.valueOf(mo10910b()).compareTo(Boolean.valueOf(kVar.mo10910b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo10910b() && (a9 = C2159c.m8186a(this.f5841b, kVar.f5841b)) != 0) {
            return a9;
        }
        int compareTo3 = Boolean.valueOf(mo10911c()).compareTo(Boolean.valueOf(kVar.mo10911c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo10911c() && (a8 = C2159c.m8187a(this.f5842c, kVar.f5842c)) != 0) {
            return a8;
        }
        int compareTo4 = Boolean.valueOf(mo10913d()).compareTo(Boolean.valueOf(kVar.mo10913d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo10913d() && (a7 = C2159c.m8187a(this.f5843d, kVar.f5843d)) != 0) {
            return a7;
        }
        int compareTo5 = Boolean.valueOf(mo10914e()).compareTo(Boolean.valueOf(kVar.mo10914e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo10914e() && (a6 = C2159c.m8186a(this.f5844e, kVar.f5844e)) != 0) {
            return a6;
        }
        int compareTo6 = Boolean.valueOf(mo10916f()).compareTo(Boolean.valueOf(kVar.mo10916f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo10916f() && (a5 = C2159c.m8185a(this.f5845f, kVar.f5845f)) != 0) {
            return a5;
        }
        int compareTo7 = Boolean.valueOf(mo10917g()).compareTo(Boolean.valueOf(kVar.mo10917g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo10917g() && (a4 = C2159c.m8187a(this.f5846g, kVar.f5846g)) != 0) {
            return a4;
        }
        int compareTo8 = Boolean.valueOf(mo10918h()).compareTo(Boolean.valueOf(kVar.mo10918h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (mo10918h() && (a3 = C2159c.m8187a(this.f5847h, kVar.f5847h)) != 0) {
            return a3;
        }
        int compareTo9 = Boolean.valueOf(mo10920i()).compareTo(Boolean.valueOf(kVar.mo10920i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (mo10920i() && (a2 = C2159c.m8187a(this.f5848i, kVar.f5848i)) != 0) {
            return a2;
        }
        int compareTo10 = Boolean.valueOf(mo10921j()).compareTo(Boolean.valueOf(kVar.mo10921j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!mo10921j() || (a = C2159c.m8187a(this.f5849j, kVar.f5849j)) == 0) {
            return 0;
        }
        return a;
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: b */
    public void mo9950b(AbstractC2180f fVar) {
        mo10922k();
        fVar.mo12134a(f5829l);
        if (this.f5840a != null && mo10907a()) {
            fVar.mo12130a(f5830m);
            fVar.mo12128a(this.f5840a);
            fVar.mo12138b();
        }
        if (this.f5841b != null && mo10910b()) {
            fVar.mo12130a(f5831n);
            this.f5841b.mo9950b(fVar);
            fVar.mo12138b();
        }
        if (this.f5842c != null) {
            fVar.mo12130a(f5832o);
            fVar.mo12128a(this.f5842c);
            fVar.mo12138b();
        }
        if (this.f5843d != null) {
            fVar.mo12130a(f5833p);
            fVar.mo12128a(this.f5843d);
            fVar.mo12138b();
        }
        if (this.f5844e != null && mo10914e()) {
            fVar.mo12130a(f5834q);
            this.f5844e.mo9950b(fVar);
            fVar.mo12138b();
        }
        fVar.mo12130a(f5835r);
        fVar.mo12127a(this.f5845f);
        fVar.mo12138b();
        if (this.f5846g != null && mo10917g()) {
            fVar.mo12130a(f5836s);
            fVar.mo12128a(this.f5846g);
            fVar.mo12138b();
        }
        if (this.f5847h != null && mo10918h()) {
            fVar.mo12130a(f5837t);
            fVar.mo12128a(this.f5847h);
            fVar.mo12138b();
        }
        if (this.f5848i != null && mo10920i()) {
            fVar.mo12130a(f5838u);
            fVar.mo12128a(this.f5848i);
            fVar.mo12138b();
        }
        if (this.f5849j != null && mo10921j()) {
            fVar.mo12130a(f5839v);
            fVar.mo12128a(this.f5849j);
            fVar.mo12138b();
        }
        fVar.mo12139c();
        fVar.mo12124a();
    }

    /* renamed from: b */
    public boolean mo10910b() {
        return this.f5841b != null;
    }

    /* renamed from: c */
    public boolean mo10911c() {
        return this.f5842c != null;
    }

    /* renamed from: d */
    public boolean mo10913d() {
        return this.f5843d != null;
    }

    /* renamed from: e */
    public boolean mo10914e() {
        return this.f5844e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C2083k)) {
            return mo10908a((C2083k) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo10916f() {
        return this.f5850w.get(0);
    }

    /* renamed from: g */
    public boolean mo10917g() {
        return this.f5846g != null;
    }

    /* renamed from: h */
    public boolean mo10918h() {
        return this.f5847h != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean mo10920i() {
        return this.f5848i != null;
    }

    /* renamed from: j */
    public boolean mo10921j() {
        return this.f5849j != null;
    }

    /* renamed from: k */
    public void mo10922k() {
        if (this.f5842c == null) {
            throw new C2181g("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f5843d == null) {
            throw new C2181g("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        boolean z2 = true;
        if (mo10907a()) {
            sb.append("debug:");
            if (this.f5840a == null) {
                sb.append("null");
            } else {
                sb.append(this.f5840a);
            }
            z2 = false;
        }
        if (mo10910b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f5841b == null) {
                sb.append("null");
            } else {
                sb.append(this.f5841b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f5842c == null) {
            sb.append("null");
        } else {
            sb.append(this.f5842c);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f5843d == null) {
            sb.append("null");
        } else {
            sb.append(this.f5843d);
        }
        if (mo10914e()) {
            sb.append(", ");
            sb.append("request:");
            if (this.f5844e == null) {
                sb.append("null");
            } else {
                sb.append(this.f5844e);
            }
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f5845f);
        if (mo10917g()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f5846g == null) {
                sb.append("null");
            } else {
                sb.append(this.f5846g);
            }
        }
        if (mo10918h()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f5847h == null) {
                sb.append("null");
            } else {
                sb.append(this.f5847h);
            }
        }
        if (mo10920i()) {
            sb.append(", ");
            sb.append("regSecret:");
            if (this.f5848i == null) {
                sb.append("null");
            } else {
                sb.append(this.f5848i);
            }
        }
        if (mo10921j()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f5849j == null) {
                sb.append("null");
            } else {
                sb.append(this.f5849j);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
