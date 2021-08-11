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

/* renamed from: com.xiaomi.xmpush.thrift.r */
public class C2097r implements Serializable, Cloneable, AbstractC2158b<C2097r, EnumC2098a> {

    /* renamed from: i */
    public static final Map<EnumC2098a, C2167b> f6063i;

    /* renamed from: j */
    private static final C2185k f6064j = new C2185k("XmPushActionUnRegistrationResult");

    /* renamed from: k */
    private static final C2177c f6065k = new C2177c("debug", (byte) 11, 1);

    /* renamed from: l */
    private static final C2177c f6066l = new C2177c("target", (byte) 12, 2);

    /* renamed from: m */
    private static final C2177c f6067m = new C2177c("id", (byte) 11, 3);

    /* renamed from: n */
    private static final C2177c f6068n = new C2177c(AppState.APP_ID, (byte) 11, 4);

    /* renamed from: o */
    private static final C2177c f6069o = new C2177c("request", (byte) 12, 5);

    /* renamed from: p */
    private static final C2177c f6070p = new C2177c("errorCode", (byte) 10, 6);

    /* renamed from: q */
    private static final C2177c f6071q = new C2177c("reason", (byte) 11, 7);

    /* renamed from: r */
    private static final C2177c f6072r = new C2177c("packageName", (byte) 11, 8);

    /* renamed from: a */
    public String f6073a;

    /* renamed from: b */
    public C2069d f6074b;

    /* renamed from: c */
    public String f6075c;

    /* renamed from: d */
    public String f6076d;

    /* renamed from: e */
    public C2095q f6077e;

    /* renamed from: f */
    public long f6078f;

    /* renamed from: g */
    public String f6079g;

    /* renamed from: h */
    public String f6080h;

    /* renamed from: s */
    private BitSet f6081s = new BitSet(1);

    /* renamed from: com.xiaomi.xmpush.thrift.r$a */
    public enum EnumC2098a {
        DEBUG(1, "debug"),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, AppState.APP_ID),
        REQUEST(5, "request"),
        ERROR_CODE(6, "errorCode"),
        REASON(7, "reason"),
        PACKAGE_NAME(8, "packageName");
        

        /* renamed from: i */
        private static final Map<String, EnumC2098a> f6090i = new HashMap();

        /* renamed from: j */
        private final short f6092j;

        /* renamed from: k */
        private final String f6093k;

        static {
            Iterator it = EnumSet.allOf(EnumC2098a.class).iterator();
            while (it.hasNext()) {
                EnumC2098a aVar = (EnumC2098a) it.next();
                f6090i.put(aVar.mo11064a(), aVar);
            }
        }

        private EnumC2098a(short s, String str) {
            this.f6092j = s;
            this.f6093k = str;
        }

        /* renamed from: a */
        public String mo11064a() {
            return this.f6093k;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC2098a.class);
        enumMap.put((Object) EnumC2098a.DEBUG, (Object) new C2167b("debug", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2098a.TARGET, (Object) new C2167b("target", (byte) 2, new C2172g((byte) 12, C2069d.class)));
        enumMap.put((Object) EnumC2098a.ID, (Object) new C2167b("id", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2098a.APP_ID, (Object) new C2167b(AppState.APP_ID, (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2098a.REQUEST, (Object) new C2167b("request", (byte) 2, new C2172g((byte) 12, C2095q.class)));
        enumMap.put((Object) EnumC2098a.ERROR_CODE, (Object) new C2167b("errorCode", (byte) 1, new C2168c((byte) 10)));
        enumMap.put((Object) EnumC2098a.REASON, (Object) new C2167b("reason", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2098a.PACKAGE_NAME, (Object) new C2167b("packageName", (byte) 2, new C2168c((byte) 11)));
        f6063i = Collections.unmodifiableMap(enumMap);
        C2167b.m8203a(C2097r.class, f6063i);
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: a */
    public void mo9945a(AbstractC2180f fVar) {
        fVar.mo12145g();
        while (true) {
            C2177c i = fVar.mo12147i();
            if (i.f6210b == 0) {
                fVar.mo12146h();
                if (!mo11058f()) {
                    throw new C2181g("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                mo11062i();
                return;
            }
            switch (i.f6211c) {
                case 1:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6073a = fVar.mo12161w();
                        break;
                    }
                case 2:
                    if (i.f6210b != 12) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6074b = new C2069d();
                        this.f6074b.mo9945a(fVar);
                        break;
                    }
                case 3:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6075c = fVar.mo12161w();
                        break;
                    }
                case 4:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6076d = fVar.mo12161w();
                        break;
                    }
                case 5:
                    if (i.f6210b != 12) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6077e = new C2095q();
                        this.f6077e.mo9945a(fVar);
                        break;
                    }
                case 6:
                    if (i.f6210b != 10) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6078f = fVar.mo12159u();
                        mo11048a(true);
                        break;
                    }
                case 7:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6079g = fVar.mo12161w();
                        break;
                    }
                case 8:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6080h = fVar.mo12161w();
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
    public void mo11048a(boolean z) {
        this.f6081s.set(0, z);
    }

    /* renamed from: a */
    public boolean mo11049a() {
        return this.f6073a != null;
    }

    /* renamed from: a */
    public boolean mo11050a(C2097r rVar) {
        if (rVar == null) {
            return false;
        }
        boolean a = mo11049a();
        boolean a2 = rVar.mo11049a();
        if ((a || a2) && (!a || !a2 || !this.f6073a.equals(rVar.f6073a))) {
            return false;
        }
        boolean b = mo11052b();
        boolean b2 = rVar.mo11052b();
        if ((b || b2) && (!b || !b2 || !this.f6074b.mo10741a(rVar.f6074b))) {
            return false;
        }
        boolean c = mo11053c();
        boolean c2 = rVar.mo11053c();
        if ((c || c2) && (!c || !c2 || !this.f6075c.equals(rVar.f6075c))) {
            return false;
        }
        boolean d = mo11055d();
        boolean d2 = rVar.mo11055d();
        if ((d || d2) && (!d || !d2 || !this.f6076d.equals(rVar.f6076d))) {
            return false;
        }
        boolean e = mo11056e();
        boolean e2 = rVar.mo11056e();
        if (((e || e2) && (!e || !e2 || !this.f6077e.mo11027a(rVar.f6077e))) || this.f6078f != rVar.f6078f) {
            return false;
        }
        boolean g = mo11059g();
        boolean g2 = rVar.mo11059g();
        if ((g || g2) && (!g || !g2 || !this.f6079g.equals(rVar.f6079g))) {
            return false;
        }
        boolean h = mo11060h();
        boolean h2 = rVar.mo11060h();
        return (!h && !h2) || (h && h2 && this.f6080h.equals(rVar.f6080h));
    }

    /* renamed from: b */
    public int compareTo(C2097r rVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (!getClass().equals(rVar.getClass())) {
            return getClass().getName().compareTo(rVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo11049a()).compareTo(Boolean.valueOf(rVar.mo11049a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo11049a() && (a8 = C2159c.m8187a(this.f6073a, rVar.f6073a)) != 0) {
            return a8;
        }
        int compareTo2 = Boolean.valueOf(mo11052b()).compareTo(Boolean.valueOf(rVar.mo11052b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo11052b() && (a7 = C2159c.m8186a(this.f6074b, rVar.f6074b)) != 0) {
            return a7;
        }
        int compareTo3 = Boolean.valueOf(mo11053c()).compareTo(Boolean.valueOf(rVar.mo11053c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo11053c() && (a6 = C2159c.m8187a(this.f6075c, rVar.f6075c)) != 0) {
            return a6;
        }
        int compareTo4 = Boolean.valueOf(mo11055d()).compareTo(Boolean.valueOf(rVar.mo11055d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo11055d() && (a5 = C2159c.m8187a(this.f6076d, rVar.f6076d)) != 0) {
            return a5;
        }
        int compareTo5 = Boolean.valueOf(mo11056e()).compareTo(Boolean.valueOf(rVar.mo11056e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo11056e() && (a4 = C2159c.m8186a(this.f6077e, rVar.f6077e)) != 0) {
            return a4;
        }
        int compareTo6 = Boolean.valueOf(mo11058f()).compareTo(Boolean.valueOf(rVar.mo11058f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo11058f() && (a3 = C2159c.m8185a(this.f6078f, rVar.f6078f)) != 0) {
            return a3;
        }
        int compareTo7 = Boolean.valueOf(mo11059g()).compareTo(Boolean.valueOf(rVar.mo11059g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo11059g() && (a2 = C2159c.m8187a(this.f6079g, rVar.f6079g)) != 0) {
            return a2;
        }
        int compareTo8 = Boolean.valueOf(mo11060h()).compareTo(Boolean.valueOf(rVar.mo11060h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!mo11060h() || (a = C2159c.m8187a(this.f6080h, rVar.f6080h)) == 0) {
            return 0;
        }
        return a;
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: b */
    public void mo9950b(AbstractC2180f fVar) {
        mo11062i();
        fVar.mo12134a(f6064j);
        if (this.f6073a != null && mo11049a()) {
            fVar.mo12130a(f6065k);
            fVar.mo12128a(this.f6073a);
            fVar.mo12138b();
        }
        if (this.f6074b != null && mo11052b()) {
            fVar.mo12130a(f6066l);
            this.f6074b.mo9950b(fVar);
            fVar.mo12138b();
        }
        if (this.f6075c != null) {
            fVar.mo12130a(f6067m);
            fVar.mo12128a(this.f6075c);
            fVar.mo12138b();
        }
        if (this.f6076d != null) {
            fVar.mo12130a(f6068n);
            fVar.mo12128a(this.f6076d);
            fVar.mo12138b();
        }
        if (this.f6077e != null && mo11056e()) {
            fVar.mo12130a(f6069o);
            this.f6077e.mo9950b(fVar);
            fVar.mo12138b();
        }
        fVar.mo12130a(f6070p);
        fVar.mo12127a(this.f6078f);
        fVar.mo12138b();
        if (this.f6079g != null && mo11059g()) {
            fVar.mo12130a(f6071q);
            fVar.mo12128a(this.f6079g);
            fVar.mo12138b();
        }
        if (this.f6080h != null && mo11060h()) {
            fVar.mo12130a(f6072r);
            fVar.mo12128a(this.f6080h);
            fVar.mo12138b();
        }
        fVar.mo12139c();
        fVar.mo12124a();
    }

    /* renamed from: b */
    public boolean mo11052b() {
        return this.f6074b != null;
    }

    /* renamed from: c */
    public boolean mo11053c() {
        return this.f6075c != null;
    }

    /* renamed from: d */
    public boolean mo11055d() {
        return this.f6076d != null;
    }

    /* renamed from: e */
    public boolean mo11056e() {
        return this.f6077e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C2097r)) {
            return mo11050a((C2097r) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo11058f() {
        return this.f6081s.get(0);
    }

    /* renamed from: g */
    public boolean mo11059g() {
        return this.f6079g != null;
    }

    /* renamed from: h */
    public boolean mo11060h() {
        return this.f6080h != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public void mo11062i() {
        if (this.f6075c == null) {
            throw new C2181g("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f6076d == null) {
            throw new C2181g("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        boolean z2 = true;
        if (mo11049a()) {
            sb.append("debug:");
            if (this.f6073a == null) {
                sb.append("null");
            } else {
                sb.append(this.f6073a);
            }
            z2 = false;
        }
        if (mo11052b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f6074b == null) {
                sb.append("null");
            } else {
                sb.append(this.f6074b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f6075c == null) {
            sb.append("null");
        } else {
            sb.append(this.f6075c);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f6076d == null) {
            sb.append("null");
        } else {
            sb.append(this.f6076d);
        }
        if (mo11056e()) {
            sb.append(", ");
            sb.append("request:");
            if (this.f6077e == null) {
                sb.append("null");
            } else {
                sb.append(this.f6077e);
            }
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f6078f);
        if (mo11059g()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f6079g == null) {
                sb.append("null");
            } else {
                sb.append(this.f6079g);
            }
        }
        if (mo11060h()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f6080h == null) {
                sb.append("null");
            } else {
                sb.append(this.f6080h);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
