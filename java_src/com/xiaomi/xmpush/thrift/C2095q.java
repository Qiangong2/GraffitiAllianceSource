package com.xiaomi.xmpush.thrift;

import com.igexin.assist.sdk.AssistPushConsts;
import com.wanmei.push.bean.AppState;
import java.io.Serializable;
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

/* renamed from: com.xiaomi.xmpush.thrift.q */
public class C2095q implements Serializable, Cloneable, AbstractC2158b<C2095q, EnumC2096a> {

    /* renamed from: k */
    public static final Map<EnumC2096a, C2167b> f6027k;

    /* renamed from: l */
    private static final C2185k f6028l = new C2185k("XmPushActionUnRegistration");

    /* renamed from: m */
    private static final C2177c f6029m = new C2177c("debug", (byte) 11, 1);

    /* renamed from: n */
    private static final C2177c f6030n = new C2177c("target", (byte) 12, 2);

    /* renamed from: o */
    private static final C2177c f6031o = new C2177c("id", (byte) 11, 3);

    /* renamed from: p */
    private static final C2177c f6032p = new C2177c(AppState.APP_ID, (byte) 11, 4);

    /* renamed from: q */
    private static final C2177c f6033q = new C2177c("regId", (byte) 11, 5);

    /* renamed from: r */
    private static final C2177c f6034r = new C2177c("appVersion", (byte) 11, 6);

    /* renamed from: s */
    private static final C2177c f6035s = new C2177c("packageName", (byte) 11, 7);

    /* renamed from: t */
    private static final C2177c f6036t = new C2177c(AssistPushConsts.MSG_TYPE_TOKEN, (byte) 11, 8);

    /* renamed from: u */
    private static final C2177c f6037u = new C2177c("deviceId", (byte) 11, 9);

    /* renamed from: v */
    private static final C2177c f6038v = new C2177c("aliasName", (byte) 11, 10);

    /* renamed from: a */
    public String f6039a;

    /* renamed from: b */
    public C2069d f6040b;

    /* renamed from: c */
    public String f6041c;

    /* renamed from: d */
    public String f6042d;

    /* renamed from: e */
    public String f6043e;

    /* renamed from: f */
    public String f6044f;

    /* renamed from: g */
    public String f6045g;

    /* renamed from: h */
    public String f6046h;

    /* renamed from: i */
    public String f6047i;

    /* renamed from: j */
    public String f6048j;

    /* renamed from: com.xiaomi.xmpush.thrift.q$a */
    public enum EnumC2096a {
        DEBUG(1, "debug"),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, AppState.APP_ID),
        REG_ID(5, "regId"),
        APP_VERSION(6, "appVersion"),
        PACKAGE_NAME(7, "packageName"),
        TOKEN(8, AssistPushConsts.MSG_TYPE_TOKEN),
        DEVICE_ID(9, "deviceId"),
        ALIAS_NAME(10, "aliasName");
        

        /* renamed from: k */
        private static final Map<String, EnumC2096a> f6059k = new HashMap();

        /* renamed from: l */
        private final short f6061l;

        /* renamed from: m */
        private final String f6062m;

        static {
            Iterator it = EnumSet.allOf(EnumC2096a.class).iterator();
            while (it.hasNext()) {
                EnumC2096a aVar = (EnumC2096a) it.next();
                f6059k.put(aVar.mo11047a(), aVar);
            }
        }

        private EnumC2096a(short s, String str) {
            this.f6061l = s;
            this.f6062m = str;
        }

        /* renamed from: a */
        public String mo11047a() {
            return this.f6062m;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC2096a.class);
        enumMap.put((Object) EnumC2096a.DEBUG, (Object) new C2167b("debug", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2096a.TARGET, (Object) new C2167b("target", (byte) 2, new C2172g((byte) 12, C2069d.class)));
        enumMap.put((Object) EnumC2096a.ID, (Object) new C2167b("id", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2096a.APP_ID, (Object) new C2167b(AppState.APP_ID, (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2096a.REG_ID, (Object) new C2167b("regId", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2096a.APP_VERSION, (Object) new C2167b("appVersion", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2096a.PACKAGE_NAME, (Object) new C2167b("packageName", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2096a.TOKEN, (Object) new C2167b(AssistPushConsts.MSG_TYPE_TOKEN, (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2096a.DEVICE_ID, (Object) new C2167b("deviceId", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2096a.ALIAS_NAME, (Object) new C2167b("aliasName", (byte) 2, new C2168c((byte) 11)));
        f6027k = Collections.unmodifiableMap(enumMap);
        C2167b.m8203a(C2095q.class, f6027k);
    }

    /* renamed from: a */
    public C2095q mo11025a(String str) {
        this.f6041c = str;
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
                mo11045k();
                return;
            }
            switch (i.f6211c) {
                case 1:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6039a = fVar.mo12161w();
                        break;
                    }
                case 2:
                    if (i.f6210b != 12) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6040b = new C2069d();
                        this.f6040b.mo9945a(fVar);
                        break;
                    }
                case 3:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6041c = fVar.mo12161w();
                        break;
                    }
                case 4:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6042d = fVar.mo12161w();
                        break;
                    }
                case 5:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6043e = fVar.mo12161w();
                        break;
                    }
                case 6:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6044f = fVar.mo12161w();
                        break;
                    }
                case 7:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6045g = fVar.mo12161w();
                        break;
                    }
                case 8:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6046h = fVar.mo12161w();
                        break;
                    }
                case 9:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6047i = fVar.mo12161w();
                        break;
                    }
                case 10:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6048j = fVar.mo12161w();
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
    public boolean mo11026a() {
        return this.f6039a != null;
    }

    /* renamed from: a */
    public boolean mo11027a(C2095q qVar) {
        if (qVar == null) {
            return false;
        }
        boolean a = mo11026a();
        boolean a2 = qVar.mo11026a();
        if ((a || a2) && (!a || !a2 || !this.f6039a.equals(qVar.f6039a))) {
            return false;
        }
        boolean b = mo11030b();
        boolean b2 = qVar.mo11030b();
        if ((b || b2) && (!b || !b2 || !this.f6040b.mo10741a(qVar.f6040b))) {
            return false;
        }
        boolean c = mo11032c();
        boolean c2 = qVar.mo11032c();
        if ((c || c2) && (!c || !c2 || !this.f6041c.equals(qVar.f6041c))) {
            return false;
        }
        boolean d = mo11035d();
        boolean d2 = qVar.mo11035d();
        if ((d || d2) && (!d || !d2 || !this.f6042d.equals(qVar.f6042d))) {
            return false;
        }
        boolean e = mo11037e();
        boolean e2 = qVar.mo11037e();
        if ((e || e2) && (!e || !e2 || !this.f6043e.equals(qVar.f6043e))) {
            return false;
        }
        boolean f = mo11039f();
        boolean f2 = qVar.mo11039f();
        if ((f || f2) && (!f || !f2 || !this.f6044f.equals(qVar.f6044f))) {
            return false;
        }
        boolean g = mo11040g();
        boolean g2 = qVar.mo11040g();
        if ((g || g2) && (!g || !g2 || !this.f6045g.equals(qVar.f6045g))) {
            return false;
        }
        boolean h = mo11041h();
        boolean h2 = qVar.mo11041h();
        if ((h || h2) && (!h || !h2 || !this.f6046h.equals(qVar.f6046h))) {
            return false;
        }
        boolean i = mo11043i();
        boolean i2 = qVar.mo11043i();
        if ((i || i2) && (!i || !i2 || !this.f6047i.equals(qVar.f6047i))) {
            return false;
        }
        boolean j = mo11044j();
        boolean j2 = qVar.mo11044j();
        return (!j && !j2) || (j && j2 && this.f6048j.equals(qVar.f6048j));
    }

    /* renamed from: b */
    public int compareTo(C2095q qVar) {
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
        if (!getClass().equals(qVar.getClass())) {
            return getClass().getName().compareTo(qVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo11026a()).compareTo(Boolean.valueOf(qVar.mo11026a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo11026a() && (a10 = C2159c.m8187a(this.f6039a, qVar.f6039a)) != 0) {
            return a10;
        }
        int compareTo2 = Boolean.valueOf(mo11030b()).compareTo(Boolean.valueOf(qVar.mo11030b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo11030b() && (a9 = C2159c.m8186a(this.f6040b, qVar.f6040b)) != 0) {
            return a9;
        }
        int compareTo3 = Boolean.valueOf(mo11032c()).compareTo(Boolean.valueOf(qVar.mo11032c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo11032c() && (a8 = C2159c.m8187a(this.f6041c, qVar.f6041c)) != 0) {
            return a8;
        }
        int compareTo4 = Boolean.valueOf(mo11035d()).compareTo(Boolean.valueOf(qVar.mo11035d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo11035d() && (a7 = C2159c.m8187a(this.f6042d, qVar.f6042d)) != 0) {
            return a7;
        }
        int compareTo5 = Boolean.valueOf(mo11037e()).compareTo(Boolean.valueOf(qVar.mo11037e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo11037e() && (a6 = C2159c.m8187a(this.f6043e, qVar.f6043e)) != 0) {
            return a6;
        }
        int compareTo6 = Boolean.valueOf(mo11039f()).compareTo(Boolean.valueOf(qVar.mo11039f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo11039f() && (a5 = C2159c.m8187a(this.f6044f, qVar.f6044f)) != 0) {
            return a5;
        }
        int compareTo7 = Boolean.valueOf(mo11040g()).compareTo(Boolean.valueOf(qVar.mo11040g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo11040g() && (a4 = C2159c.m8187a(this.f6045g, qVar.f6045g)) != 0) {
            return a4;
        }
        int compareTo8 = Boolean.valueOf(mo11041h()).compareTo(Boolean.valueOf(qVar.mo11041h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (mo11041h() && (a3 = C2159c.m8187a(this.f6046h, qVar.f6046h)) != 0) {
            return a3;
        }
        int compareTo9 = Boolean.valueOf(mo11043i()).compareTo(Boolean.valueOf(qVar.mo11043i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (mo11043i() && (a2 = C2159c.m8187a(this.f6047i, qVar.f6047i)) != 0) {
            return a2;
        }
        int compareTo10 = Boolean.valueOf(mo11044j()).compareTo(Boolean.valueOf(qVar.mo11044j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!mo11044j() || (a = C2159c.m8187a(this.f6048j, qVar.f6048j)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: b */
    public C2095q mo11029b(String str) {
        this.f6042d = str;
        return this;
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: b */
    public void mo9950b(AbstractC2180f fVar) {
        mo11045k();
        fVar.mo12134a(f6028l);
        if (this.f6039a != null && mo11026a()) {
            fVar.mo12130a(f6029m);
            fVar.mo12128a(this.f6039a);
            fVar.mo12138b();
        }
        if (this.f6040b != null && mo11030b()) {
            fVar.mo12130a(f6030n);
            this.f6040b.mo9950b(fVar);
            fVar.mo12138b();
        }
        if (this.f6041c != null) {
            fVar.mo12130a(f6031o);
            fVar.mo12128a(this.f6041c);
            fVar.mo12138b();
        }
        if (this.f6042d != null) {
            fVar.mo12130a(f6032p);
            fVar.mo12128a(this.f6042d);
            fVar.mo12138b();
        }
        if (this.f6043e != null && mo11037e()) {
            fVar.mo12130a(f6033q);
            fVar.mo12128a(this.f6043e);
            fVar.mo12138b();
        }
        if (this.f6044f != null && mo11039f()) {
            fVar.mo12130a(f6034r);
            fVar.mo12128a(this.f6044f);
            fVar.mo12138b();
        }
        if (this.f6045g != null && mo11040g()) {
            fVar.mo12130a(f6035s);
            fVar.mo12128a(this.f6045g);
            fVar.mo12138b();
        }
        if (this.f6046h != null && mo11041h()) {
            fVar.mo12130a(f6036t);
            fVar.mo12128a(this.f6046h);
            fVar.mo12138b();
        }
        if (this.f6047i != null && mo11043i()) {
            fVar.mo12130a(f6037u);
            fVar.mo12128a(this.f6047i);
            fVar.mo12138b();
        }
        if (this.f6048j != null && mo11044j()) {
            fVar.mo12130a(f6038v);
            fVar.mo12128a(this.f6048j);
            fVar.mo12138b();
        }
        fVar.mo12139c();
        fVar.mo12124a();
    }

    /* renamed from: b */
    public boolean mo11030b() {
        return this.f6040b != null;
    }

    /* renamed from: c */
    public C2095q mo11031c(String str) {
        this.f6043e = str;
        return this;
    }

    /* renamed from: c */
    public boolean mo11032c() {
        return this.f6041c != null;
    }

    /* renamed from: d */
    public C2095q mo11034d(String str) {
        this.f6045g = str;
        return this;
    }

    /* renamed from: d */
    public boolean mo11035d() {
        return this.f6042d != null;
    }

    /* renamed from: e */
    public C2095q mo11036e(String str) {
        this.f6046h = str;
        return this;
    }

    /* renamed from: e */
    public boolean mo11037e() {
        return this.f6043e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C2095q)) {
            return mo11027a((C2095q) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo11039f() {
        return this.f6044f != null;
    }

    /* renamed from: g */
    public boolean mo11040g() {
        return this.f6045g != null;
    }

    /* renamed from: h */
    public boolean mo11041h() {
        return this.f6046h != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean mo11043i() {
        return this.f6047i != null;
    }

    /* renamed from: j */
    public boolean mo11044j() {
        return this.f6048j != null;
    }

    /* renamed from: k */
    public void mo11045k() {
        if (this.f6041c == null) {
            throw new C2181g("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f6042d == null) {
            throw new C2181g("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        boolean z2 = true;
        if (mo11026a()) {
            sb.append("debug:");
            if (this.f6039a == null) {
                sb.append("null");
            } else {
                sb.append(this.f6039a);
            }
            z2 = false;
        }
        if (mo11030b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f6040b == null) {
                sb.append("null");
            } else {
                sb.append(this.f6040b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f6041c == null) {
            sb.append("null");
        } else {
            sb.append(this.f6041c);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f6042d == null) {
            sb.append("null");
        } else {
            sb.append(this.f6042d);
        }
        if (mo11037e()) {
            sb.append(", ");
            sb.append("regId:");
            if (this.f6043e == null) {
                sb.append("null");
            } else {
                sb.append(this.f6043e);
            }
        }
        if (mo11039f()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f6044f == null) {
                sb.append("null");
            } else {
                sb.append(this.f6044f);
            }
        }
        if (mo11040g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f6045g == null) {
                sb.append("null");
            } else {
                sb.append(this.f6045g);
            }
        }
        if (mo11041h()) {
            sb.append(", ");
            sb.append("token:");
            if (this.f6046h == null) {
                sb.append("null");
            } else {
                sb.append(this.f6046h);
            }
        }
        if (mo11043i()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f6047i == null) {
                sb.append("null");
            } else {
                sb.append(this.f6047i);
            }
        }
        if (mo11044j()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f6048j == null) {
                sb.append("null");
            } else {
                sb.append(this.f6048j);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
