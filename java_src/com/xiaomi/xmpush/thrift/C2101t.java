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

/* renamed from: com.xiaomi.xmpush.thrift.t */
public class C2101t implements Serializable, Cloneable, AbstractC2158b<C2101t, EnumC2102a> {

    /* renamed from: k */
    public static final Map<EnumC2102a, C2167b> f6121k;

    /* renamed from: l */
    private static final C2185k f6122l = new C2185k("XmPushActionUnSubscriptionResult");

    /* renamed from: m */
    private static final C2177c f6123m = new C2177c("debug", (byte) 11, 1);

    /* renamed from: n */
    private static final C2177c f6124n = new C2177c("target", (byte) 12, 2);

    /* renamed from: o */
    private static final C2177c f6125o = new C2177c("id", (byte) 11, 3);

    /* renamed from: p */
    private static final C2177c f6126p = new C2177c(AppState.APP_ID, (byte) 11, 4);

    /* renamed from: q */
    private static final C2177c f6127q = new C2177c("request", (byte) 12, 5);

    /* renamed from: r */
    private static final C2177c f6128r = new C2177c("errorCode", (byte) 10, 6);

    /* renamed from: s */
    private static final C2177c f6129s = new C2177c("reason", (byte) 11, 7);

    /* renamed from: t */
    private static final C2177c f6130t = new C2177c("topic", (byte) 11, 8);

    /* renamed from: u */
    private static final C2177c f6131u = new C2177c("packageName", (byte) 11, 9);

    /* renamed from: v */
    private static final C2177c f6132v = new C2177c("category", (byte) 11, 10);

    /* renamed from: a */
    public String f6133a;

    /* renamed from: b */
    public C2069d f6134b;

    /* renamed from: c */
    public String f6135c;

    /* renamed from: d */
    public String f6136d;

    /* renamed from: e */
    public C2099s f6137e;

    /* renamed from: f */
    public long f6138f;

    /* renamed from: g */
    public String f6139g;

    /* renamed from: h */
    public String f6140h;

    /* renamed from: i */
    public String f6141i;

    /* renamed from: j */
    public String f6142j;

    /* renamed from: w */
    private BitSet f6143w = new BitSet(1);

    /* renamed from: com.xiaomi.xmpush.thrift.t$a */
    public enum EnumC2102a {
        DEBUG(1, "debug"),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, AppState.APP_ID),
        REQUEST(5, "request"),
        ERROR_CODE(6, "errorCode"),
        REASON(7, "reason"),
        TOPIC(8, "topic"),
        PACKAGE_NAME(9, "packageName"),
        CATEGORY(10, "category");
        

        /* renamed from: k */
        private static final Map<String, EnumC2102a> f6154k = new HashMap();

        /* renamed from: l */
        private final short f6156l;

        /* renamed from: m */
        private final String f6157m;

        static {
            Iterator it = EnumSet.allOf(EnumC2102a.class).iterator();
            while (it.hasNext()) {
                EnumC2102a aVar = (EnumC2102a) it.next();
                f6154k.put(aVar.mo11105a(), aVar);
            }
        }

        private EnumC2102a(short s, String str) {
            this.f6156l = s;
            this.f6157m = str;
        }

        /* renamed from: a */
        public String mo11105a() {
            return this.f6157m;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC2102a.class);
        enumMap.put((Object) EnumC2102a.DEBUG, (Object) new C2167b("debug", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2102a.TARGET, (Object) new C2167b("target", (byte) 2, new C2172g((byte) 12, C2069d.class)));
        enumMap.put((Object) EnumC2102a.ID, (Object) new C2167b("id", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2102a.APP_ID, (Object) new C2167b(AppState.APP_ID, (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2102a.REQUEST, (Object) new C2167b("request", (byte) 2, new C2172g((byte) 12, C2099s.class)));
        enumMap.put((Object) EnumC2102a.ERROR_CODE, (Object) new C2167b("errorCode", (byte) 2, new C2168c((byte) 10)));
        enumMap.put((Object) EnumC2102a.REASON, (Object) new C2167b("reason", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2102a.TOPIC, (Object) new C2167b("topic", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2102a.PACKAGE_NAME, (Object) new C2167b("packageName", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2102a.CATEGORY, (Object) new C2167b("category", (byte) 2, new C2168c((byte) 11)));
        f6121k = Collections.unmodifiableMap(enumMap);
        C2167b.m8203a(C2101t.class, f6121k);
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: a */
    public void mo9945a(AbstractC2180f fVar) {
        fVar.mo12145g();
        while (true) {
            C2177c i = fVar.mo12147i();
            if (i.f6210b == 0) {
                fVar.mo12146h();
                mo11103m();
                return;
            }
            switch (i.f6211c) {
                case 1:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6133a = fVar.mo12161w();
                        break;
                    }
                case 2:
                    if (i.f6210b != 12) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6134b = new C2069d();
                        this.f6134b.mo9945a(fVar);
                        break;
                    }
                case 3:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6135c = fVar.mo12161w();
                        break;
                    }
                case 4:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6136d = fVar.mo12161w();
                        break;
                    }
                case 5:
                    if (i.f6210b != 12) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6137e = new C2099s();
                        this.f6137e.mo9945a(fVar);
                        break;
                    }
                case 6:
                    if (i.f6210b != 10) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6138f = fVar.mo12159u();
                        mo11085a(true);
                        break;
                    }
                case 7:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6139g = fVar.mo12161w();
                        break;
                    }
                case 8:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6140h = fVar.mo12161w();
                        break;
                    }
                case 9:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6141i = fVar.mo12161w();
                        break;
                    }
                case 10:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6142j = fVar.mo12161w();
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
    public void mo11085a(boolean z) {
        this.f6143w.set(0, z);
    }

    /* renamed from: a */
    public boolean mo11086a() {
        return this.f6133a != null;
    }

    /* renamed from: a */
    public boolean mo11087a(C2101t tVar) {
        if (tVar == null) {
            return false;
        }
        boolean a = mo11086a();
        boolean a2 = tVar.mo11086a();
        if ((a || a2) && (!a || !a2 || !this.f6133a.equals(tVar.f6133a))) {
            return false;
        }
        boolean b = mo11089b();
        boolean b2 = tVar.mo11089b();
        if ((b || b2) && (!b || !b2 || !this.f6134b.mo10741a(tVar.f6134b))) {
            return false;
        }
        boolean c = mo11090c();
        boolean c2 = tVar.mo11090c();
        if ((c || c2) && (!c || !c2 || !this.f6135c.equals(tVar.f6135c))) {
            return false;
        }
        boolean d = mo11092d();
        boolean d2 = tVar.mo11092d();
        if ((d || d2) && (!d || !d2 || !this.f6136d.equals(tVar.f6136d))) {
            return false;
        }
        boolean e = mo11093e();
        boolean e2 = tVar.mo11093e();
        if ((e || e2) && (!e || !e2 || !this.f6137e.mo11067a(tVar.f6137e))) {
            return false;
        }
        boolean f = mo11095f();
        boolean f2 = tVar.mo11095f();
        if ((f || f2) && (!f || !f2 || this.f6138f != tVar.f6138f)) {
            return false;
        }
        boolean g = mo11096g();
        boolean g2 = tVar.mo11096g();
        if ((g || g2) && (!g || !g2 || !this.f6139g.equals(tVar.f6139g))) {
            return false;
        }
        boolean i = mo11099i();
        boolean i2 = tVar.mo11099i();
        if ((i || i2) && (!i || !i2 || !this.f6140h.equals(tVar.f6140h))) {
            return false;
        }
        boolean j = mo11100j();
        boolean j2 = tVar.mo11100j();
        if ((j || j2) && (!j || !j2 || !this.f6141i.equals(tVar.f6141i))) {
            return false;
        }
        boolean l = mo11102l();
        boolean l2 = tVar.mo11102l();
        return (!l && !l2) || (l && l2 && this.f6142j.equals(tVar.f6142j));
    }

    /* renamed from: b */
    public int compareTo(C2101t tVar) {
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
        if (!getClass().equals(tVar.getClass())) {
            return getClass().getName().compareTo(tVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo11086a()).compareTo(Boolean.valueOf(tVar.mo11086a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo11086a() && (a10 = C2159c.m8187a(this.f6133a, tVar.f6133a)) != 0) {
            return a10;
        }
        int compareTo2 = Boolean.valueOf(mo11089b()).compareTo(Boolean.valueOf(tVar.mo11089b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo11089b() && (a9 = C2159c.m8186a(this.f6134b, tVar.f6134b)) != 0) {
            return a9;
        }
        int compareTo3 = Boolean.valueOf(mo11090c()).compareTo(Boolean.valueOf(tVar.mo11090c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo11090c() && (a8 = C2159c.m8187a(this.f6135c, tVar.f6135c)) != 0) {
            return a8;
        }
        int compareTo4 = Boolean.valueOf(mo11092d()).compareTo(Boolean.valueOf(tVar.mo11092d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo11092d() && (a7 = C2159c.m8187a(this.f6136d, tVar.f6136d)) != 0) {
            return a7;
        }
        int compareTo5 = Boolean.valueOf(mo11093e()).compareTo(Boolean.valueOf(tVar.mo11093e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo11093e() && (a6 = C2159c.m8186a(this.f6137e, tVar.f6137e)) != 0) {
            return a6;
        }
        int compareTo6 = Boolean.valueOf(mo11095f()).compareTo(Boolean.valueOf(tVar.mo11095f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo11095f() && (a5 = C2159c.m8185a(this.f6138f, tVar.f6138f)) != 0) {
            return a5;
        }
        int compareTo7 = Boolean.valueOf(mo11096g()).compareTo(Boolean.valueOf(tVar.mo11096g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo11096g() && (a4 = C2159c.m8187a(this.f6139g, tVar.f6139g)) != 0) {
            return a4;
        }
        int compareTo8 = Boolean.valueOf(mo11099i()).compareTo(Boolean.valueOf(tVar.mo11099i()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (mo11099i() && (a3 = C2159c.m8187a(this.f6140h, tVar.f6140h)) != 0) {
            return a3;
        }
        int compareTo9 = Boolean.valueOf(mo11100j()).compareTo(Boolean.valueOf(tVar.mo11100j()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (mo11100j() && (a2 = C2159c.m8187a(this.f6141i, tVar.f6141i)) != 0) {
            return a2;
        }
        int compareTo10 = Boolean.valueOf(mo11102l()).compareTo(Boolean.valueOf(tVar.mo11102l()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!mo11102l() || (a = C2159c.m8187a(this.f6142j, tVar.f6142j)) == 0) {
            return 0;
        }
        return a;
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: b */
    public void mo9950b(AbstractC2180f fVar) {
        mo11103m();
        fVar.mo12134a(f6122l);
        if (this.f6133a != null && mo11086a()) {
            fVar.mo12130a(f6123m);
            fVar.mo12128a(this.f6133a);
            fVar.mo12138b();
        }
        if (this.f6134b != null && mo11089b()) {
            fVar.mo12130a(f6124n);
            this.f6134b.mo9950b(fVar);
            fVar.mo12138b();
        }
        if (this.f6135c != null) {
            fVar.mo12130a(f6125o);
            fVar.mo12128a(this.f6135c);
            fVar.mo12138b();
        }
        if (this.f6136d != null && mo11092d()) {
            fVar.mo12130a(f6126p);
            fVar.mo12128a(this.f6136d);
            fVar.mo12138b();
        }
        if (this.f6137e != null && mo11093e()) {
            fVar.mo12130a(f6127q);
            this.f6137e.mo9950b(fVar);
            fVar.mo12138b();
        }
        if (mo11095f()) {
            fVar.mo12130a(f6128r);
            fVar.mo12127a(this.f6138f);
            fVar.mo12138b();
        }
        if (this.f6139g != null && mo11096g()) {
            fVar.mo12130a(f6129s);
            fVar.mo12128a(this.f6139g);
            fVar.mo12138b();
        }
        if (this.f6140h != null && mo11099i()) {
            fVar.mo12130a(f6130t);
            fVar.mo12128a(this.f6140h);
            fVar.mo12138b();
        }
        if (this.f6141i != null && mo11100j()) {
            fVar.mo12130a(f6131u);
            fVar.mo12128a(this.f6141i);
            fVar.mo12138b();
        }
        if (this.f6142j != null && mo11102l()) {
            fVar.mo12130a(f6132v);
            fVar.mo12128a(this.f6142j);
            fVar.mo12138b();
        }
        fVar.mo12139c();
        fVar.mo12124a();
    }

    /* renamed from: b */
    public boolean mo11089b() {
        return this.f6134b != null;
    }

    /* renamed from: c */
    public boolean mo11090c() {
        return this.f6135c != null;
    }

    /* renamed from: d */
    public boolean mo11092d() {
        return this.f6136d != null;
    }

    /* renamed from: e */
    public boolean mo11093e() {
        return this.f6137e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C2101t)) {
            return mo11087a((C2101t) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo11095f() {
        return this.f6143w.get(0);
    }

    /* renamed from: g */
    public boolean mo11096g() {
        return this.f6139g != null;
    }

    /* renamed from: h */
    public String mo11097h() {
        return this.f6140h;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean mo11099i() {
        return this.f6140h != null;
    }

    /* renamed from: j */
    public boolean mo11100j() {
        return this.f6141i != null;
    }

    /* renamed from: k */
    public String mo11101k() {
        return this.f6142j;
    }

    /* renamed from: l */
    public boolean mo11102l() {
        return this.f6142j != null;
    }

    /* renamed from: m */
    public void mo11103m() {
        if (this.f6135c == null) {
            throw new C2181g("Required field 'id' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        boolean z2 = true;
        if (mo11086a()) {
            sb.append("debug:");
            if (this.f6133a == null) {
                sb.append("null");
            } else {
                sb.append(this.f6133a);
            }
            z2 = false;
        }
        if (mo11089b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f6134b == null) {
                sb.append("null");
            } else {
                sb.append(this.f6134b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f6135c == null) {
            sb.append("null");
        } else {
            sb.append(this.f6135c);
        }
        if (mo11092d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f6136d == null) {
                sb.append("null");
            } else {
                sb.append(this.f6136d);
            }
        }
        if (mo11093e()) {
            sb.append(", ");
            sb.append("request:");
            if (this.f6137e == null) {
                sb.append("null");
            } else {
                sb.append(this.f6137e);
            }
        }
        if (mo11095f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f6138f);
        }
        if (mo11096g()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f6139g == null) {
                sb.append("null");
            } else {
                sb.append(this.f6139g);
            }
        }
        if (mo11099i()) {
            sb.append(", ");
            sb.append("topic:");
            if (this.f6140h == null) {
                sb.append("null");
            } else {
                sb.append(this.f6140h);
            }
        }
        if (mo11100j()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f6141i == null) {
                sb.append("null");
            } else {
                sb.append(this.f6141i);
            }
        }
        if (mo11102l()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f6142j == null) {
                sb.append("null");
            } else {
                sb.append(this.f6142j);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
