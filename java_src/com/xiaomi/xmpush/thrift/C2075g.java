package com.xiaomi.xmpush.thrift;

import com.wanmei.push.bean.AppState;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
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

/* renamed from: com.xiaomi.xmpush.thrift.g */
public class C2075g implements Serializable, Cloneable, AbstractC2158b<C2075g, EnumC2076a> {

    /* renamed from: l */
    public static final Map<EnumC2076a, C2167b> f5684l;

    /* renamed from: m */
    private static final C2185k f5685m = new C2185k("XmPushActionCommandResult");

    /* renamed from: n */
    private static final C2177c f5686n = new C2177c("debug", (byte) 11, 1);

    /* renamed from: o */
    private static final C2177c f5687o = new C2177c("target", (byte) 12, 2);

    /* renamed from: p */
    private static final C2177c f5688p = new C2177c("id", (byte) 11, 3);

    /* renamed from: q */
    private static final C2177c f5689q = new C2177c(AppState.APP_ID, (byte) 11, 4);

    /* renamed from: r */
    private static final C2177c f5690r = new C2177c("cmdName", (byte) 11, 5);

    /* renamed from: s */
    private static final C2177c f5691s = new C2177c("request", (byte) 12, 6);

    /* renamed from: t */
    private static final C2177c f5692t = new C2177c("errorCode", (byte) 10, 7);

    /* renamed from: u */
    private static final C2177c f5693u = new C2177c("reason", (byte) 11, 8);

    /* renamed from: v */
    private static final C2177c f5694v = new C2177c("packageName", (byte) 11, 9);

    /* renamed from: w */
    private static final C2177c f5695w = new C2177c("cmdArgs", C0027o.f104m, 10);

    /* renamed from: x */
    private static final C2177c f5696x = new C2177c("category", (byte) 11, 12);

    /* renamed from: a */
    public String f5697a;

    /* renamed from: b */
    public C2069d f5698b;

    /* renamed from: c */
    public String f5699c;

    /* renamed from: d */
    public String f5700d;

    /* renamed from: e */
    public String f5701e;

    /* renamed from: f */
    public C2073f f5702f;

    /* renamed from: g */
    public long f5703g;

    /* renamed from: h */
    public String f5704h;

    /* renamed from: i */
    public String f5705i;

    /* renamed from: j */
    public List<String> f5706j;

    /* renamed from: k */
    public String f5707k;

    /* renamed from: y */
    private BitSet f5708y = new BitSet(1);

    /* renamed from: com.xiaomi.xmpush.thrift.g$a */
    public enum EnumC2076a {
        DEBUG(1, "debug"),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, AppState.APP_ID),
        CMD_NAME(5, "cmdName"),
        REQUEST(6, "request"),
        ERROR_CODE(7, "errorCode"),
        REASON(8, "reason"),
        PACKAGE_NAME(9, "packageName"),
        CMD_ARGS(10, "cmdArgs"),
        CATEGORY(12, "category");
        

        /* renamed from: l */
        private static final Map<String, EnumC2076a> f5720l = new HashMap();

        /* renamed from: m */
        private final short f5722m;

        /* renamed from: n */
        private final String f5723n;

        static {
            Iterator it = EnumSet.allOf(EnumC2076a.class).iterator();
            while (it.hasNext()) {
                EnumC2076a aVar = (EnumC2076a) it.next();
                f5720l.put(aVar.mo10822a(), aVar);
            }
        }

        private EnumC2076a(short s, String str) {
            this.f5722m = s;
            this.f5723n = str;
        }

        /* renamed from: a */
        public String mo10822a() {
            return this.f5723n;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC2076a.class);
        enumMap.put((Object) EnumC2076a.DEBUG, (Object) new C2167b("debug", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2076a.TARGET, (Object) new C2167b("target", (byte) 2, new C2172g((byte) 12, C2069d.class)));
        enumMap.put((Object) EnumC2076a.ID, (Object) new C2167b("id", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2076a.APP_ID, (Object) new C2167b(AppState.APP_ID, (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2076a.CMD_NAME, (Object) new C2167b("cmdName", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2076a.REQUEST, (Object) new C2167b("request", (byte) 2, new C2172g((byte) 12, C2073f.class)));
        enumMap.put((Object) EnumC2076a.ERROR_CODE, (Object) new C2167b("errorCode", (byte) 1, new C2168c((byte) 10)));
        enumMap.put((Object) EnumC2076a.REASON, (Object) new C2167b("reason", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2076a.PACKAGE_NAME, (Object) new C2167b("packageName", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2076a.CMD_ARGS, (Object) new C2167b("cmdArgs", (byte) 2, new C2169d(C0027o.f104m, new C2168c((byte) 11))));
        enumMap.put((Object) EnumC2076a.CATEGORY, (Object) new C2167b("category", (byte) 2, new C2168c((byte) 11)));
        f5684l = Collections.unmodifiableMap(enumMap);
        C2167b.m8203a(C2075g.class, f5684l);
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: a */
    public void mo9945a(AbstractC2180f fVar) {
        fVar.mo12145g();
        while (true) {
            C2177c i = fVar.mo12147i();
            if (i.f6210b == 0) {
                fVar.mo12146h();
                if (!mo10812h()) {
                    throw new C2181g("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                mo10820o();
                return;
            }
            switch (i.f6211c) {
                case 1:
                    if (i.f6210b == 11) {
                        this.f5697a = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 2:
                    if (i.f6210b == 12) {
                        this.f5698b = new C2069d();
                        this.f5698b.mo9945a(fVar);
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 3:
                    if (i.f6210b == 11) {
                        this.f5699c = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 4:
                    if (i.f6210b == 11) {
                        this.f5700d = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 5:
                    if (i.f6210b == 11) {
                        this.f5701e = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 6:
                    if (i.f6210b == 12) {
                        this.f5702f = new C2073f();
                        this.f5702f.mo9945a(fVar);
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 7:
                    if (i.f6210b == 10) {
                        this.f5703g = fVar.mo12159u();
                        mo10800a(true);
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 8:
                    if (i.f6210b == 11) {
                        this.f5704h = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 9:
                    if (i.f6210b == 11) {
                        this.f5705i = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 10:
                    if (i.f6210b == 15) {
                        C2178d m = fVar.mo12151m();
                        this.f5706j = new ArrayList(m.f6213b);
                        for (int i2 = 0; i2 < m.f6213b; i2++) {
                            this.f5706j.add(fVar.mo12161w());
                        }
                        fVar.mo12152n();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 11:
                default:
                    C2183i.m8338a(fVar, i.f6210b);
                    break;
                case 12:
                    if (i.f6210b == 11) {
                        this.f5707k = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
            }
            fVar.mo12148j();
        }
    }

    /* renamed from: a */
    public void mo10800a(boolean z) {
        this.f5708y.set(0, z);
    }

    /* renamed from: a */
    public boolean mo10801a() {
        return this.f5697a != null;
    }

    /* renamed from: a */
    public boolean mo10802a(C2075g gVar) {
        if (gVar == null) {
            return false;
        }
        boolean a = mo10801a();
        boolean a2 = gVar.mo10801a();
        if ((a || a2) && (!a || !a2 || !this.f5697a.equals(gVar.f5697a))) {
            return false;
        }
        boolean b = mo10804b();
        boolean b2 = gVar.mo10804b();
        if ((b || b2) && (!b || !b2 || !this.f5698b.mo10741a(gVar.f5698b))) {
            return false;
        }
        boolean c = mo10805c();
        boolean c2 = gVar.mo10805c();
        if ((c || c2) && (!c || !c2 || !this.f5699c.equals(gVar.f5699c))) {
            return false;
        }
        boolean d = mo10807d();
        boolean d2 = gVar.mo10807d();
        if ((d || d2) && (!d || !d2 || !this.f5700d.equals(gVar.f5700d))) {
            return false;
        }
        boolean f = mo10810f();
        boolean f2 = gVar.mo10810f();
        if ((f || f2) && (!f || !f2 || !this.f5701e.equals(gVar.f5701e))) {
            return false;
        }
        boolean g = mo10811g();
        boolean g2 = gVar.mo10811g();
        if (((g || g2) && (!g || !g2 || !this.f5702f.mo10780a(gVar.f5702f))) || this.f5703g != gVar.f5703g) {
            return false;
        }
        boolean i = mo10814i();
        boolean i2 = gVar.mo10814i();
        if ((i || i2) && (!i || !i2 || !this.f5704h.equals(gVar.f5704h))) {
            return false;
        }
        boolean j = mo10815j();
        boolean j2 = gVar.mo10815j();
        if ((j || j2) && (!j || !j2 || !this.f5705i.equals(gVar.f5705i))) {
            return false;
        }
        boolean l = mo10817l();
        boolean l2 = gVar.mo10817l();
        if ((l || l2) && (!l || !l2 || !this.f5706j.equals(gVar.f5706j))) {
            return false;
        }
        boolean n = mo10819n();
        boolean n2 = gVar.mo10819n();
        return (!n && !n2) || (n && n2 && this.f5707k.equals(gVar.f5707k));
    }

    /* renamed from: b */
    public int compareTo(C2075g gVar) {
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
        if (!getClass().equals(gVar.getClass())) {
            return getClass().getName().compareTo(gVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo10801a()).compareTo(Boolean.valueOf(gVar.mo10801a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo10801a() && (a11 = C2159c.m8187a(this.f5697a, gVar.f5697a)) != 0) {
            return a11;
        }
        int compareTo2 = Boolean.valueOf(mo10804b()).compareTo(Boolean.valueOf(gVar.mo10804b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo10804b() && (a10 = C2159c.m8186a(this.f5698b, gVar.f5698b)) != 0) {
            return a10;
        }
        int compareTo3 = Boolean.valueOf(mo10805c()).compareTo(Boolean.valueOf(gVar.mo10805c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo10805c() && (a9 = C2159c.m8187a(this.f5699c, gVar.f5699c)) != 0) {
            return a9;
        }
        int compareTo4 = Boolean.valueOf(mo10807d()).compareTo(Boolean.valueOf(gVar.mo10807d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo10807d() && (a8 = C2159c.m8187a(this.f5700d, gVar.f5700d)) != 0) {
            return a8;
        }
        int compareTo5 = Boolean.valueOf(mo10810f()).compareTo(Boolean.valueOf(gVar.mo10810f()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo10810f() && (a7 = C2159c.m8187a(this.f5701e, gVar.f5701e)) != 0) {
            return a7;
        }
        int compareTo6 = Boolean.valueOf(mo10811g()).compareTo(Boolean.valueOf(gVar.mo10811g()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo10811g() && (a6 = C2159c.m8186a(this.f5702f, gVar.f5702f)) != 0) {
            return a6;
        }
        int compareTo7 = Boolean.valueOf(mo10812h()).compareTo(Boolean.valueOf(gVar.mo10812h()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo10812h() && (a5 = C2159c.m8185a(this.f5703g, gVar.f5703g)) != 0) {
            return a5;
        }
        int compareTo8 = Boolean.valueOf(mo10814i()).compareTo(Boolean.valueOf(gVar.mo10814i()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (mo10814i() && (a4 = C2159c.m8187a(this.f5704h, gVar.f5704h)) != 0) {
            return a4;
        }
        int compareTo9 = Boolean.valueOf(mo10815j()).compareTo(Boolean.valueOf(gVar.mo10815j()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (mo10815j() && (a3 = C2159c.m8187a(this.f5705i, gVar.f5705i)) != 0) {
            return a3;
        }
        int compareTo10 = Boolean.valueOf(mo10817l()).compareTo(Boolean.valueOf(gVar.mo10817l()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (mo10817l() && (a2 = C2159c.m8189a(this.f5706j, gVar.f5706j)) != 0) {
            return a2;
        }
        int compareTo11 = Boolean.valueOf(mo10819n()).compareTo(Boolean.valueOf(gVar.mo10819n()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (!mo10819n() || (a = C2159c.m8187a(this.f5707k, gVar.f5707k)) == 0) {
            return 0;
        }
        return a;
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: b */
    public void mo9950b(AbstractC2180f fVar) {
        mo10820o();
        fVar.mo12134a(f5685m);
        if (this.f5697a != null && mo10801a()) {
            fVar.mo12130a(f5686n);
            fVar.mo12128a(this.f5697a);
            fVar.mo12138b();
        }
        if (this.f5698b != null && mo10804b()) {
            fVar.mo12130a(f5687o);
            this.f5698b.mo9950b(fVar);
            fVar.mo12138b();
        }
        if (this.f5699c != null) {
            fVar.mo12130a(f5688p);
            fVar.mo12128a(this.f5699c);
            fVar.mo12138b();
        }
        if (this.f5700d != null) {
            fVar.mo12130a(f5689q);
            fVar.mo12128a(this.f5700d);
            fVar.mo12138b();
        }
        if (this.f5701e != null) {
            fVar.mo12130a(f5690r);
            fVar.mo12128a(this.f5701e);
            fVar.mo12138b();
        }
        if (this.f5702f != null && mo10811g()) {
            fVar.mo12130a(f5691s);
            this.f5702f.mo9950b(fVar);
            fVar.mo12138b();
        }
        fVar.mo12130a(f5692t);
        fVar.mo12127a(this.f5703g);
        fVar.mo12138b();
        if (this.f5704h != null && mo10814i()) {
            fVar.mo12130a(f5693u);
            fVar.mo12128a(this.f5704h);
            fVar.mo12138b();
        }
        if (this.f5705i != null && mo10815j()) {
            fVar.mo12130a(f5694v);
            fVar.mo12128a(this.f5705i);
            fVar.mo12138b();
        }
        if (this.f5706j != null && mo10817l()) {
            fVar.mo12130a(f5695w);
            fVar.mo12131a(new C2178d((byte) 11, this.f5706j.size()));
            for (String str : this.f5706j) {
                fVar.mo12128a(str);
            }
            fVar.mo12143e();
            fVar.mo12138b();
        }
        if (this.f5707k != null && mo10819n()) {
            fVar.mo12130a(f5696x);
            fVar.mo12128a(this.f5707k);
            fVar.mo12138b();
        }
        fVar.mo12139c();
        fVar.mo12124a();
    }

    /* renamed from: b */
    public boolean mo10804b() {
        return this.f5698b != null;
    }

    /* renamed from: c */
    public boolean mo10805c() {
        return this.f5699c != null;
    }

    /* renamed from: d */
    public boolean mo10807d() {
        return this.f5700d != null;
    }

    /* renamed from: e */
    public String mo10808e() {
        return this.f5701e;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C2075g)) {
            return mo10802a((C2075g) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo10810f() {
        return this.f5701e != null;
    }

    /* renamed from: g */
    public boolean mo10811g() {
        return this.f5702f != null;
    }

    /* renamed from: h */
    public boolean mo10812h() {
        return this.f5708y.get(0);
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean mo10814i() {
        return this.f5704h != null;
    }

    /* renamed from: j */
    public boolean mo10815j() {
        return this.f5705i != null;
    }

    /* renamed from: k */
    public List<String> mo10816k() {
        return this.f5706j;
    }

    /* renamed from: l */
    public boolean mo10817l() {
        return this.f5706j != null;
    }

    /* renamed from: m */
    public String mo10818m() {
        return this.f5707k;
    }

    /* renamed from: n */
    public boolean mo10819n() {
        return this.f5707k != null;
    }

    /* renamed from: o */
    public void mo10820o() {
        if (this.f5699c == null) {
            throw new C2181g("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f5700d == null) {
            throw new C2181g("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f5701e == null) {
            throw new C2181g("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        boolean z2 = true;
        if (mo10801a()) {
            sb.append("debug:");
            if (this.f5697a == null) {
                sb.append("null");
            } else {
                sb.append(this.f5697a);
            }
            z2 = false;
        }
        if (mo10804b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f5698b == null) {
                sb.append("null");
            } else {
                sb.append(this.f5698b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f5699c == null) {
            sb.append("null");
        } else {
            sb.append(this.f5699c);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f5700d == null) {
            sb.append("null");
        } else {
            sb.append(this.f5700d);
        }
        sb.append(", ");
        sb.append("cmdName:");
        if (this.f5701e == null) {
            sb.append("null");
        } else {
            sb.append(this.f5701e);
        }
        if (mo10811g()) {
            sb.append(", ");
            sb.append("request:");
            if (this.f5702f == null) {
                sb.append("null");
            } else {
                sb.append(this.f5702f);
            }
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f5703g);
        if (mo10814i()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f5704h == null) {
                sb.append("null");
            } else {
                sb.append(this.f5704h);
            }
        }
        if (mo10815j()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f5705i == null) {
                sb.append("null");
            } else {
                sb.append(this.f5705i);
            }
        }
        if (mo10817l()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            if (this.f5706j == null) {
                sb.append("null");
            } else {
                sb.append(this.f5706j);
            }
        }
        if (mo10819n()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f5707k == null) {
                sb.append("null");
            } else {
                sb.append(this.f5707k);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
