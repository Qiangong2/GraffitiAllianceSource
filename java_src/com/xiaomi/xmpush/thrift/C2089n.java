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
import org.apache.thrift.meta_data.C2170e;
import org.apache.thrift.meta_data.C2172g;
import org.apache.thrift.protocol.AbstractC2180f;
import org.apache.thrift.protocol.C2177c;
import org.apache.thrift.protocol.C2179e;
import org.apache.thrift.protocol.C2181g;
import org.apache.thrift.protocol.C2183i;
import org.apache.thrift.protocol.C2185k;

/* renamed from: com.xiaomi.xmpush.thrift.n */
public class C2089n implements Serializable, Cloneable, AbstractC2158b<C2089n, EnumC2090a> {

    /* renamed from: m */
    public static final Map<EnumC2090a, C2167b> f5920m;

    /* renamed from: n */
    private static final C2185k f5921n = new C2185k("XmPushActionSendMessage");

    /* renamed from: o */
    private static final C2177c f5922o = new C2177c("debug", (byte) 11, 1);

    /* renamed from: p */
    private static final C2177c f5923p = new C2177c("target", (byte) 12, 2);

    /* renamed from: q */
    private static final C2177c f5924q = new C2177c("id", (byte) 11, 3);

    /* renamed from: r */
    private static final C2177c f5925r = new C2177c(AppState.APP_ID, (byte) 11, 4);

    /* renamed from: s */
    private static final C2177c f5926s = new C2177c("packageName", (byte) 11, 5);

    /* renamed from: t */
    private static final C2177c f5927t = new C2177c("topic", (byte) 11, 6);

    /* renamed from: u */
    private static final C2177c f5928u = new C2177c("aliasName", (byte) 11, 7);

    /* renamed from: v */
    private static final C2177c f5929v = new C2177c("message", (byte) 12, 8);

    /* renamed from: w */
    private static final C2177c f5930w = new C2177c("needAck", (byte) 2, 9);

    /* renamed from: x */
    private static final C2177c f5931x = new C2177c("params", (byte) 13, 10);

    /* renamed from: y */
    private static final C2177c f5932y = new C2177c("category", (byte) 11, 11);

    /* renamed from: z */
    private static final C2177c f5933z = new C2177c("userAccount", (byte) 11, 12);

    /* renamed from: A */
    private BitSet f5934A = new BitSet(1);

    /* renamed from: a */
    public String f5935a;

    /* renamed from: b */
    public C2069d f5936b;

    /* renamed from: c */
    public String f5937c;

    /* renamed from: d */
    public String f5938d;

    /* renamed from: e */
    public String f5939e;

    /* renamed from: f */
    public String f5940f;

    /* renamed from: g */
    public String f5941g;

    /* renamed from: h */
    public C2065b f5942h;

    /* renamed from: i */
    public boolean f5943i = true;

    /* renamed from: j */
    public Map<String, String> f5944j;

    /* renamed from: k */
    public String f5945k;

    /* renamed from: l */
    public String f5946l;

    /* renamed from: com.xiaomi.xmpush.thrift.n$a */
    public enum EnumC2090a {
        DEBUG(1, "debug"),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, AppState.APP_ID),
        PACKAGE_NAME(5, "packageName"),
        TOPIC(6, "topic"),
        ALIAS_NAME(7, "aliasName"),
        MESSAGE(8, "message"),
        NEED_ACK(9, "needAck"),
        PARAMS(10, "params"),
        CATEGORY(11, "category"),
        USER_ACCOUNT(12, "userAccount");
        

        /* renamed from: m */
        private static final Map<String, EnumC2090a> f5959m = new HashMap();

        /* renamed from: n */
        private final short f5961n;

        /* renamed from: o */
        private final String f5962o;

        static {
            Iterator it = EnumSet.allOf(EnumC2090a.class).iterator();
            while (it.hasNext()) {
                EnumC2090a aVar = (EnumC2090a) it.next();
                f5959m.put(aVar.mo10983a(), aVar);
            }
        }

        private EnumC2090a(short s, String str) {
            this.f5961n = s;
            this.f5962o = str;
        }

        /* renamed from: a */
        public String mo10983a() {
            return this.f5962o;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC2090a.class);
        enumMap.put((Object) EnumC2090a.DEBUG, (Object) new C2167b("debug", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2090a.TARGET, (Object) new C2167b("target", (byte) 2, new C2172g((byte) 12, C2069d.class)));
        enumMap.put((Object) EnumC2090a.ID, (Object) new C2167b("id", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2090a.APP_ID, (Object) new C2167b(AppState.APP_ID, (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2090a.PACKAGE_NAME, (Object) new C2167b("packageName", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2090a.TOPIC, (Object) new C2167b("topic", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2090a.ALIAS_NAME, (Object) new C2167b("aliasName", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2090a.MESSAGE, (Object) new C2167b("message", (byte) 2, new C2172g((byte) 12, C2065b.class)));
        enumMap.put((Object) EnumC2090a.NEED_ACK, (Object) new C2167b("needAck", (byte) 2, new C2168c((byte) 2)));
        enumMap.put((Object) EnumC2090a.PARAMS, (Object) new C2167b("params", (byte) 2, new C2170e((byte) 13, new C2168c((byte) 11), new C2168c((byte) 11))));
        enumMap.put((Object) EnumC2090a.CATEGORY, (Object) new C2167b("category", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2090a.USER_ACCOUNT, (Object) new C2167b("userAccount", (byte) 2, new C2168c((byte) 11)));
        f5920m = Collections.unmodifiableMap(enumMap);
        C2167b.m8203a(C2089n.class, f5920m);
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: a */
    public void mo9945a(AbstractC2180f fVar) {
        fVar.mo12145g();
        while (true) {
            C2177c i = fVar.mo12147i();
            if (i.f6210b == 0) {
                fVar.mo12146h();
                mo10981t();
                return;
            }
            switch (i.f6211c) {
                case 1:
                    if (i.f6210b == 11) {
                        this.f5935a = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 2:
                    if (i.f6210b == 12) {
                        this.f5936b = new C2069d();
                        this.f5936b.mo9945a(fVar);
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 3:
                    if (i.f6210b == 11) {
                        this.f5937c = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 4:
                    if (i.f6210b == 11) {
                        this.f5938d = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 5:
                    if (i.f6210b == 11) {
                        this.f5939e = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 6:
                    if (i.f6210b == 11) {
                        this.f5940f = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 7:
                    if (i.f6210b == 11) {
                        this.f5941g = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 8:
                    if (i.f6210b == 12) {
                        this.f5942h = new C2065b();
                        this.f5942h.mo9945a(fVar);
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 9:
                    if (i.f6210b == 2) {
                        this.f5943i = fVar.mo12155q();
                        mo10956a(true);
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 10:
                    if (i.f6210b == 13) {
                        C2179e k = fVar.mo12149k();
                        this.f5944j = new HashMap(k.f6216c * 2);
                        for (int i2 = 0; i2 < k.f6216c; i2++) {
                            this.f5944j.put(fVar.mo12161w(), fVar.mo12161w());
                        }
                        fVar.mo12150l();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 11:
                    if (i.f6210b == 11) {
                        this.f5945k = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 12:
                    if (i.f6210b == 11) {
                        this.f5946l = fVar.mo12161w();
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
    public void mo10956a(boolean z) {
        this.f5934A.set(0, z);
    }

    /* renamed from: a */
    public boolean mo10957a() {
        return this.f5935a != null;
    }

    /* renamed from: a */
    public boolean mo10958a(C2089n nVar) {
        if (nVar == null) {
            return false;
        }
        boolean a = mo10957a();
        boolean a2 = nVar.mo10957a();
        if ((a || a2) && (!a || !a2 || !this.f5935a.equals(nVar.f5935a))) {
            return false;
        }
        boolean b = mo10960b();
        boolean b2 = nVar.mo10960b();
        if ((b || b2) && (!b || !b2 || !this.f5936b.mo10741a(nVar.f5936b))) {
            return false;
        }
        boolean d = mo10963d();
        boolean d2 = nVar.mo10963d();
        if ((d || d2) && (!d || !d2 || !this.f5937c.equals(nVar.f5937c))) {
            return false;
        }
        boolean f = mo10966f();
        boolean f2 = nVar.mo10966f();
        if ((f || f2) && (!f || !f2 || !this.f5938d.equals(nVar.f5938d))) {
            return false;
        }
        boolean g = mo10967g();
        boolean g2 = nVar.mo10967g();
        if ((g || g2) && (!g || !g2 || !this.f5939e.equals(nVar.f5939e))) {
            return false;
        }
        boolean i = mo10970i();
        boolean i2 = nVar.mo10970i();
        if ((i || i2) && (!i || !i2 || !this.f5940f.equals(nVar.f5940f))) {
            return false;
        }
        boolean k = mo10972k();
        boolean k2 = nVar.mo10972k();
        if ((k || k2) && (!k || !k2 || !this.f5941g.equals(nVar.f5941g))) {
            return false;
        }
        boolean m = mo10974m();
        boolean m2 = nVar.mo10974m();
        if ((m || m2) && (!m || !m2 || !this.f5942h.mo10674a(nVar.f5942h))) {
            return false;
        }
        boolean n = mo10975n();
        boolean n2 = nVar.mo10975n();
        if ((n || n2) && (!n || !n2 || this.f5943i != nVar.f5943i)) {
            return false;
        }
        boolean o = mo10976o();
        boolean o2 = nVar.mo10976o();
        if ((o || o2) && (!o || !o2 || !this.f5944j.equals(nVar.f5944j))) {
            return false;
        }
        boolean q = mo10978q();
        boolean q2 = nVar.mo10978q();
        if ((q || q2) && (!q || !q2 || !this.f5945k.equals(nVar.f5945k))) {
            return false;
        }
        boolean s = mo10980s();
        boolean s2 = nVar.mo10980s();
        return (!s && !s2) || (s && s2 && this.f5946l.equals(nVar.f5946l));
    }

    /* renamed from: b */
    public int compareTo(C2089n nVar) {
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
        int a11;
        int a12;
        if (!getClass().equals(nVar.getClass())) {
            return getClass().getName().compareTo(nVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo10957a()).compareTo(Boolean.valueOf(nVar.mo10957a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo10957a() && (a12 = C2159c.m8187a(this.f5935a, nVar.f5935a)) != 0) {
            return a12;
        }
        int compareTo2 = Boolean.valueOf(mo10960b()).compareTo(Boolean.valueOf(nVar.mo10960b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo10960b() && (a11 = C2159c.m8186a(this.f5936b, nVar.f5936b)) != 0) {
            return a11;
        }
        int compareTo3 = Boolean.valueOf(mo10963d()).compareTo(Boolean.valueOf(nVar.mo10963d()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo10963d() && (a10 = C2159c.m8187a(this.f5937c, nVar.f5937c)) != 0) {
            return a10;
        }
        int compareTo4 = Boolean.valueOf(mo10966f()).compareTo(Boolean.valueOf(nVar.mo10966f()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo10966f() && (a9 = C2159c.m8187a(this.f5938d, nVar.f5938d)) != 0) {
            return a9;
        }
        int compareTo5 = Boolean.valueOf(mo10967g()).compareTo(Boolean.valueOf(nVar.mo10967g()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo10967g() && (a8 = C2159c.m8187a(this.f5939e, nVar.f5939e)) != 0) {
            return a8;
        }
        int compareTo6 = Boolean.valueOf(mo10970i()).compareTo(Boolean.valueOf(nVar.mo10970i()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo10970i() && (a7 = C2159c.m8187a(this.f5940f, nVar.f5940f)) != 0) {
            return a7;
        }
        int compareTo7 = Boolean.valueOf(mo10972k()).compareTo(Boolean.valueOf(nVar.mo10972k()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo10972k() && (a6 = C2159c.m8187a(this.f5941g, nVar.f5941g)) != 0) {
            return a6;
        }
        int compareTo8 = Boolean.valueOf(mo10974m()).compareTo(Boolean.valueOf(nVar.mo10974m()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (mo10974m() && (a5 = C2159c.m8186a(this.f5942h, nVar.f5942h)) != 0) {
            return a5;
        }
        int compareTo9 = Boolean.valueOf(mo10975n()).compareTo(Boolean.valueOf(nVar.mo10975n()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (mo10975n() && (a4 = C2159c.m8192a(this.f5943i, nVar.f5943i)) != 0) {
            return a4;
        }
        int compareTo10 = Boolean.valueOf(mo10976o()).compareTo(Boolean.valueOf(nVar.mo10976o()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (mo10976o() && (a3 = C2159c.m8190a(this.f5944j, nVar.f5944j)) != 0) {
            return a3;
        }
        int compareTo11 = Boolean.valueOf(mo10978q()).compareTo(Boolean.valueOf(nVar.mo10978q()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (mo10978q() && (a2 = C2159c.m8187a(this.f5945k, nVar.f5945k)) != 0) {
            return a2;
        }
        int compareTo12 = Boolean.valueOf(mo10980s()).compareTo(Boolean.valueOf(nVar.mo10980s()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (!mo10980s() || (a = C2159c.m8187a(this.f5946l, nVar.f5946l)) == 0) {
            return 0;
        }
        return a;
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: b */
    public void mo9950b(AbstractC2180f fVar) {
        mo10981t();
        fVar.mo12134a(f5921n);
        if (this.f5935a != null && mo10957a()) {
            fVar.mo12130a(f5922o);
            fVar.mo12128a(this.f5935a);
            fVar.mo12138b();
        }
        if (this.f5936b != null && mo10960b()) {
            fVar.mo12130a(f5923p);
            this.f5936b.mo9950b(fVar);
            fVar.mo12138b();
        }
        if (this.f5937c != null) {
            fVar.mo12130a(f5924q);
            fVar.mo12128a(this.f5937c);
            fVar.mo12138b();
        }
        if (this.f5938d != null) {
            fVar.mo12130a(f5925r);
            fVar.mo12128a(this.f5938d);
            fVar.mo12138b();
        }
        if (this.f5939e != null && mo10967g()) {
            fVar.mo12130a(f5926s);
            fVar.mo12128a(this.f5939e);
            fVar.mo12138b();
        }
        if (this.f5940f != null && mo10970i()) {
            fVar.mo12130a(f5927t);
            fVar.mo12128a(this.f5940f);
            fVar.mo12138b();
        }
        if (this.f5941g != null && mo10972k()) {
            fVar.mo12130a(f5928u);
            fVar.mo12128a(this.f5941g);
            fVar.mo12138b();
        }
        if (this.f5942h != null && mo10974m()) {
            fVar.mo12130a(f5929v);
            this.f5942h.mo9950b(fVar);
            fVar.mo12138b();
        }
        if (mo10975n()) {
            fVar.mo12130a(f5930w);
            fVar.mo12136a(this.f5943i);
            fVar.mo12138b();
        }
        if (this.f5944j != null && mo10976o()) {
            fVar.mo12130a(f5931x);
            fVar.mo12132a(new C2179e((byte) 11, (byte) 11, this.f5944j.size()));
            for (Map.Entry<String, String> entry : this.f5944j.entrySet()) {
                fVar.mo12128a(entry.getKey());
                fVar.mo12128a(entry.getValue());
            }
            fVar.mo12141d();
            fVar.mo12138b();
        }
        if (this.f5945k != null && mo10978q()) {
            fVar.mo12130a(f5932y);
            fVar.mo12128a(this.f5945k);
            fVar.mo12138b();
        }
        if (this.f5946l != null && mo10980s()) {
            fVar.mo12130a(f5933z);
            fVar.mo12128a(this.f5946l);
            fVar.mo12138b();
        }
        fVar.mo12139c();
        fVar.mo12124a();
    }

    /* renamed from: b */
    public boolean mo10960b() {
        return this.f5936b != null;
    }

    /* renamed from: c */
    public String mo10961c() {
        return this.f5937c;
    }

    /* renamed from: d */
    public boolean mo10963d() {
        return this.f5937c != null;
    }

    /* renamed from: e */
    public String mo10964e() {
        return this.f5938d;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C2089n)) {
            return mo10958a((C2089n) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo10966f() {
        return this.f5938d != null;
    }

    /* renamed from: g */
    public boolean mo10967g() {
        return this.f5939e != null;
    }

    /* renamed from: h */
    public String mo10968h() {
        return this.f5940f;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean mo10970i() {
        return this.f5940f != null;
    }

    /* renamed from: j */
    public String mo10971j() {
        return this.f5941g;
    }

    /* renamed from: k */
    public boolean mo10972k() {
        return this.f5941g != null;
    }

    /* renamed from: l */
    public C2065b mo10973l() {
        return this.f5942h;
    }

    /* renamed from: m */
    public boolean mo10974m() {
        return this.f5942h != null;
    }

    /* renamed from: n */
    public boolean mo10975n() {
        return this.f5934A.get(0);
    }

    /* renamed from: o */
    public boolean mo10976o() {
        return this.f5944j != null;
    }

    /* renamed from: p */
    public String mo10977p() {
        return this.f5945k;
    }

    /* renamed from: q */
    public boolean mo10978q() {
        return this.f5945k != null;
    }

    /* renamed from: r */
    public String mo10979r() {
        return this.f5946l;
    }

    /* renamed from: s */
    public boolean mo10980s() {
        return this.f5946l != null;
    }

    /* renamed from: t */
    public void mo10981t() {
        if (this.f5937c == null) {
            throw new C2181g("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f5938d == null) {
            throw new C2181g("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        boolean z2 = true;
        if (mo10957a()) {
            sb.append("debug:");
            if (this.f5935a == null) {
                sb.append("null");
            } else {
                sb.append(this.f5935a);
            }
            z2 = false;
        }
        if (mo10960b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f5936b == null) {
                sb.append("null");
            } else {
                sb.append(this.f5936b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f5937c == null) {
            sb.append("null");
        } else {
            sb.append(this.f5937c);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f5938d == null) {
            sb.append("null");
        } else {
            sb.append(this.f5938d);
        }
        if (mo10967g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f5939e == null) {
                sb.append("null");
            } else {
                sb.append(this.f5939e);
            }
        }
        if (mo10970i()) {
            sb.append(", ");
            sb.append("topic:");
            if (this.f5940f == null) {
                sb.append("null");
            } else {
                sb.append(this.f5940f);
            }
        }
        if (mo10972k()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f5941g == null) {
                sb.append("null");
            } else {
                sb.append(this.f5941g);
            }
        }
        if (mo10974m()) {
            sb.append(", ");
            sb.append("message:");
            if (this.f5942h == null) {
                sb.append("null");
            } else {
                sb.append(this.f5942h);
            }
        }
        if (mo10975n()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f5943i);
        }
        if (mo10976o()) {
            sb.append(", ");
            sb.append("params:");
            if (this.f5944j == null) {
                sb.append("null");
            } else {
                sb.append(this.f5944j);
            }
        }
        if (mo10978q()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f5945k == null) {
                sb.append("null");
            } else {
                sb.append(this.f5945k);
            }
        }
        if (mo10980s()) {
            sb.append(", ");
            sb.append("userAccount:");
            if (this.f5946l == null) {
                sb.append("null");
            } else {
                sb.append(this.f5946l);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
