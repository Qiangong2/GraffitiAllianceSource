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

/* renamed from: com.xiaomi.xmpush.thrift.p */
public class C2093p implements Serializable, Cloneable, AbstractC2158b<C2093p, EnumC2094a> {

    /* renamed from: k */
    public static final Map<EnumC2094a, C2167b> f5990k;

    /* renamed from: l */
    private static final C2185k f5991l = new C2185k("XmPushActionSubscriptionResult");

    /* renamed from: m */
    private static final C2177c f5992m = new C2177c("debug", (byte) 11, 1);

    /* renamed from: n */
    private static final C2177c f5993n = new C2177c("target", (byte) 12, 2);

    /* renamed from: o */
    private static final C2177c f5994o = new C2177c("id", (byte) 11, 3);

    /* renamed from: p */
    private static final C2177c f5995p = new C2177c(AppState.APP_ID, (byte) 11, 4);

    /* renamed from: q */
    private static final C2177c f5996q = new C2177c("request", (byte) 12, 5);

    /* renamed from: r */
    private static final C2177c f5997r = new C2177c("errorCode", (byte) 10, 6);

    /* renamed from: s */
    private static final C2177c f5998s = new C2177c("reason", (byte) 11, 7);

    /* renamed from: t */
    private static final C2177c f5999t = new C2177c("topic", (byte) 11, 8);

    /* renamed from: u */
    private static final C2177c f6000u = new C2177c("packageName", (byte) 11, 9);

    /* renamed from: v */
    private static final C2177c f6001v = new C2177c("category", (byte) 11, 10);

    /* renamed from: a */
    public String f6002a;

    /* renamed from: b */
    public C2069d f6003b;

    /* renamed from: c */
    public String f6004c;

    /* renamed from: d */
    public String f6005d;

    /* renamed from: e */
    public C2091o f6006e;

    /* renamed from: f */
    public long f6007f;

    /* renamed from: g */
    public String f6008g;

    /* renamed from: h */
    public String f6009h;

    /* renamed from: i */
    public String f6010i;

    /* renamed from: j */
    public String f6011j;

    /* renamed from: w */
    private BitSet f6012w = new BitSet(1);

    /* renamed from: com.xiaomi.xmpush.thrift.p$a */
    public enum EnumC2094a {
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
        private static final Map<String, EnumC2094a> f6023k = new HashMap();

        /* renamed from: l */
        private final short f6025l;

        /* renamed from: m */
        private final String f6026m;

        static {
            Iterator it = EnumSet.allOf(EnumC2094a.class).iterator();
            while (it.hasNext()) {
                EnumC2094a aVar = (EnumC2094a) it.next();
                f6023k.put(aVar.mo11024a(), aVar);
            }
        }

        private EnumC2094a(short s, String str) {
            this.f6025l = s;
            this.f6026m = str;
        }

        /* renamed from: a */
        public String mo11024a() {
            return this.f6026m;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC2094a.class);
        enumMap.put((Object) EnumC2094a.DEBUG, (Object) new C2167b("debug", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2094a.TARGET, (Object) new C2167b("target", (byte) 2, new C2172g((byte) 12, C2069d.class)));
        enumMap.put((Object) EnumC2094a.ID, (Object) new C2167b("id", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2094a.APP_ID, (Object) new C2167b(AppState.APP_ID, (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2094a.REQUEST, (Object) new C2167b("request", (byte) 2, new C2172g((byte) 12, C2091o.class)));
        enumMap.put((Object) EnumC2094a.ERROR_CODE, (Object) new C2167b("errorCode", (byte) 2, new C2168c((byte) 10)));
        enumMap.put((Object) EnumC2094a.REASON, (Object) new C2167b("reason", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2094a.TOPIC, (Object) new C2167b("topic", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2094a.PACKAGE_NAME, (Object) new C2167b("packageName", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2094a.CATEGORY, (Object) new C2167b("category", (byte) 2, new C2168c((byte) 11)));
        f5990k = Collections.unmodifiableMap(enumMap);
        C2167b.m8203a(C2093p.class, f5990k);
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: a */
    public void mo9945a(AbstractC2180f fVar) {
        fVar.mo12145g();
        while (true) {
            C2177c i = fVar.mo12147i();
            if (i.f6210b == 0) {
                fVar.mo12146h();
                mo11022m();
                return;
            }
            switch (i.f6211c) {
                case 1:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6002a = fVar.mo12161w();
                        break;
                    }
                case 2:
                    if (i.f6210b != 12) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6003b = new C2069d();
                        this.f6003b.mo9945a(fVar);
                        break;
                    }
                case 3:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6004c = fVar.mo12161w();
                        break;
                    }
                case 4:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6005d = fVar.mo12161w();
                        break;
                    }
                case 5:
                    if (i.f6210b != 12) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6006e = new C2091o();
                        this.f6006e.mo9945a(fVar);
                        break;
                    }
                case 6:
                    if (i.f6210b != 10) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6007f = fVar.mo12159u();
                        mo11004a(true);
                        break;
                    }
                case 7:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6008g = fVar.mo12161w();
                        break;
                    }
                case 8:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6009h = fVar.mo12161w();
                        break;
                    }
                case 9:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6010i = fVar.mo12161w();
                        break;
                    }
                case 10:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6011j = fVar.mo12161w();
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
    public void mo11004a(boolean z) {
        this.f6012w.set(0, z);
    }

    /* renamed from: a */
    public boolean mo11005a() {
        return this.f6002a != null;
    }

    /* renamed from: a */
    public boolean mo11006a(C2093p pVar) {
        if (pVar == null) {
            return false;
        }
        boolean a = mo11005a();
        boolean a2 = pVar.mo11005a();
        if ((a || a2) && (!a || !a2 || !this.f6002a.equals(pVar.f6002a))) {
            return false;
        }
        boolean b = mo11008b();
        boolean b2 = pVar.mo11008b();
        if ((b || b2) && (!b || !b2 || !this.f6003b.mo10741a(pVar.f6003b))) {
            return false;
        }
        boolean c = mo11009c();
        boolean c2 = pVar.mo11009c();
        if ((c || c2) && (!c || !c2 || !this.f6004c.equals(pVar.f6004c))) {
            return false;
        }
        boolean d = mo11011d();
        boolean d2 = pVar.mo11011d();
        if ((d || d2) && (!d || !d2 || !this.f6005d.equals(pVar.f6005d))) {
            return false;
        }
        boolean e = mo11012e();
        boolean e2 = pVar.mo11012e();
        if ((e || e2) && (!e || !e2 || !this.f6006e.mo10986a(pVar.f6006e))) {
            return false;
        }
        boolean f = mo11014f();
        boolean f2 = pVar.mo11014f();
        if ((f || f2) && (!f || !f2 || this.f6007f != pVar.f6007f)) {
            return false;
        }
        boolean g = mo11015g();
        boolean g2 = pVar.mo11015g();
        if ((g || g2) && (!g || !g2 || !this.f6008g.equals(pVar.f6008g))) {
            return false;
        }
        boolean i = mo11018i();
        boolean i2 = pVar.mo11018i();
        if ((i || i2) && (!i || !i2 || !this.f6009h.equals(pVar.f6009h))) {
            return false;
        }
        boolean j = mo11019j();
        boolean j2 = pVar.mo11019j();
        if ((j || j2) && (!j || !j2 || !this.f6010i.equals(pVar.f6010i))) {
            return false;
        }
        boolean l = mo11021l();
        boolean l2 = pVar.mo11021l();
        return (!l && !l2) || (l && l2 && this.f6011j.equals(pVar.f6011j));
    }

    /* renamed from: b */
    public int compareTo(C2093p pVar) {
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
        if (!getClass().equals(pVar.getClass())) {
            return getClass().getName().compareTo(pVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo11005a()).compareTo(Boolean.valueOf(pVar.mo11005a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo11005a() && (a10 = C2159c.m8187a(this.f6002a, pVar.f6002a)) != 0) {
            return a10;
        }
        int compareTo2 = Boolean.valueOf(mo11008b()).compareTo(Boolean.valueOf(pVar.mo11008b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo11008b() && (a9 = C2159c.m8186a(this.f6003b, pVar.f6003b)) != 0) {
            return a9;
        }
        int compareTo3 = Boolean.valueOf(mo11009c()).compareTo(Boolean.valueOf(pVar.mo11009c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo11009c() && (a8 = C2159c.m8187a(this.f6004c, pVar.f6004c)) != 0) {
            return a8;
        }
        int compareTo4 = Boolean.valueOf(mo11011d()).compareTo(Boolean.valueOf(pVar.mo11011d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo11011d() && (a7 = C2159c.m8187a(this.f6005d, pVar.f6005d)) != 0) {
            return a7;
        }
        int compareTo5 = Boolean.valueOf(mo11012e()).compareTo(Boolean.valueOf(pVar.mo11012e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo11012e() && (a6 = C2159c.m8186a(this.f6006e, pVar.f6006e)) != 0) {
            return a6;
        }
        int compareTo6 = Boolean.valueOf(mo11014f()).compareTo(Boolean.valueOf(pVar.mo11014f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo11014f() && (a5 = C2159c.m8185a(this.f6007f, pVar.f6007f)) != 0) {
            return a5;
        }
        int compareTo7 = Boolean.valueOf(mo11015g()).compareTo(Boolean.valueOf(pVar.mo11015g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo11015g() && (a4 = C2159c.m8187a(this.f6008g, pVar.f6008g)) != 0) {
            return a4;
        }
        int compareTo8 = Boolean.valueOf(mo11018i()).compareTo(Boolean.valueOf(pVar.mo11018i()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (mo11018i() && (a3 = C2159c.m8187a(this.f6009h, pVar.f6009h)) != 0) {
            return a3;
        }
        int compareTo9 = Boolean.valueOf(mo11019j()).compareTo(Boolean.valueOf(pVar.mo11019j()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (mo11019j() && (a2 = C2159c.m8187a(this.f6010i, pVar.f6010i)) != 0) {
            return a2;
        }
        int compareTo10 = Boolean.valueOf(mo11021l()).compareTo(Boolean.valueOf(pVar.mo11021l()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!mo11021l() || (a = C2159c.m8187a(this.f6011j, pVar.f6011j)) == 0) {
            return 0;
        }
        return a;
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: b */
    public void mo9950b(AbstractC2180f fVar) {
        mo11022m();
        fVar.mo12134a(f5991l);
        if (this.f6002a != null && mo11005a()) {
            fVar.mo12130a(f5992m);
            fVar.mo12128a(this.f6002a);
            fVar.mo12138b();
        }
        if (this.f6003b != null && mo11008b()) {
            fVar.mo12130a(f5993n);
            this.f6003b.mo9950b(fVar);
            fVar.mo12138b();
        }
        if (this.f6004c != null) {
            fVar.mo12130a(f5994o);
            fVar.mo12128a(this.f6004c);
            fVar.mo12138b();
        }
        if (this.f6005d != null && mo11011d()) {
            fVar.mo12130a(f5995p);
            fVar.mo12128a(this.f6005d);
            fVar.mo12138b();
        }
        if (this.f6006e != null && mo11012e()) {
            fVar.mo12130a(f5996q);
            this.f6006e.mo9950b(fVar);
            fVar.mo12138b();
        }
        if (mo11014f()) {
            fVar.mo12130a(f5997r);
            fVar.mo12127a(this.f6007f);
            fVar.mo12138b();
        }
        if (this.f6008g != null && mo11015g()) {
            fVar.mo12130a(f5998s);
            fVar.mo12128a(this.f6008g);
            fVar.mo12138b();
        }
        if (this.f6009h != null && mo11018i()) {
            fVar.mo12130a(f5999t);
            fVar.mo12128a(this.f6009h);
            fVar.mo12138b();
        }
        if (this.f6010i != null && mo11019j()) {
            fVar.mo12130a(f6000u);
            fVar.mo12128a(this.f6010i);
            fVar.mo12138b();
        }
        if (this.f6011j != null && mo11021l()) {
            fVar.mo12130a(f6001v);
            fVar.mo12128a(this.f6011j);
            fVar.mo12138b();
        }
        fVar.mo12139c();
        fVar.mo12124a();
    }

    /* renamed from: b */
    public boolean mo11008b() {
        return this.f6003b != null;
    }

    /* renamed from: c */
    public boolean mo11009c() {
        return this.f6004c != null;
    }

    /* renamed from: d */
    public boolean mo11011d() {
        return this.f6005d != null;
    }

    /* renamed from: e */
    public boolean mo11012e() {
        return this.f6006e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C2093p)) {
            return mo11006a((C2093p) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo11014f() {
        return this.f6012w.get(0);
    }

    /* renamed from: g */
    public boolean mo11015g() {
        return this.f6008g != null;
    }

    /* renamed from: h */
    public String mo11016h() {
        return this.f6009h;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean mo11018i() {
        return this.f6009h != null;
    }

    /* renamed from: j */
    public boolean mo11019j() {
        return this.f6010i != null;
    }

    /* renamed from: k */
    public String mo11020k() {
        return this.f6011j;
    }

    /* renamed from: l */
    public boolean mo11021l() {
        return this.f6011j != null;
    }

    /* renamed from: m */
    public void mo11022m() {
        if (this.f6004c == null) {
            throw new C2181g("Required field 'id' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean z2 = true;
        if (mo11005a()) {
            sb.append("debug:");
            if (this.f6002a == null) {
                sb.append("null");
            } else {
                sb.append(this.f6002a);
            }
            z2 = false;
        }
        if (mo11008b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f6003b == null) {
                sb.append("null");
            } else {
                sb.append(this.f6003b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f6004c == null) {
            sb.append("null");
        } else {
            sb.append(this.f6004c);
        }
        if (mo11011d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f6005d == null) {
                sb.append("null");
            } else {
                sb.append(this.f6005d);
            }
        }
        if (mo11012e()) {
            sb.append(", ");
            sb.append("request:");
            if (this.f6006e == null) {
                sb.append("null");
            } else {
                sb.append(this.f6006e);
            }
        }
        if (mo11014f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f6007f);
        }
        if (mo11015g()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f6008g == null) {
                sb.append("null");
            } else {
                sb.append(this.f6008g);
            }
        }
        if (mo11018i()) {
            sb.append(", ");
            sb.append("topic:");
            if (this.f6009h == null) {
                sb.append("null");
            } else {
                sb.append(this.f6009h);
            }
        }
        if (mo11019j()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f6010i == null) {
                sb.append("null");
            } else {
                sb.append(this.f6010i);
            }
        }
        if (mo11021l()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f6011j == null) {
                sb.append("null");
            } else {
                sb.append(this.f6011j);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
