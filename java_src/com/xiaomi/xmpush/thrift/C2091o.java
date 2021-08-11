package com.xiaomi.xmpush.thrift;

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

/* renamed from: com.xiaomi.xmpush.thrift.o */
public class C2091o implements Serializable, Cloneable, AbstractC2158b<C2091o, EnumC2092a> {

    /* renamed from: h */
    public static final Map<EnumC2092a, C2167b> f5963h;

    /* renamed from: i */
    private static final C2185k f5964i = new C2185k("XmPushActionSubscription");

    /* renamed from: j */
    private static final C2177c f5965j = new C2177c("debug", (byte) 11, 1);

    /* renamed from: k */
    private static final C2177c f5966k = new C2177c("target", (byte) 12, 2);

    /* renamed from: l */
    private static final C2177c f5967l = new C2177c("id", (byte) 11, 3);

    /* renamed from: m */
    private static final C2177c f5968m = new C2177c(AppState.APP_ID, (byte) 11, 4);

    /* renamed from: n */
    private static final C2177c f5969n = new C2177c("topic", (byte) 11, 5);

    /* renamed from: o */
    private static final C2177c f5970o = new C2177c("packageName", (byte) 11, 6);

    /* renamed from: p */
    private static final C2177c f5971p = new C2177c("category", (byte) 11, 7);

    /* renamed from: a */
    public String f5972a;

    /* renamed from: b */
    public C2069d f5973b;

    /* renamed from: c */
    public String f5974c;

    /* renamed from: d */
    public String f5975d;

    /* renamed from: e */
    public String f5976e;

    /* renamed from: f */
    public String f5977f;

    /* renamed from: g */
    public String f5978g;

    /* renamed from: com.xiaomi.xmpush.thrift.o$a */
    public enum EnumC2092a {
        DEBUG(1, "debug"),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, AppState.APP_ID),
        TOPIC(5, "topic"),
        PACKAGE_NAME(6, "packageName"),
        CATEGORY(7, "category");
        

        /* renamed from: h */
        private static final Map<String, EnumC2092a> f5986h = new HashMap();

        /* renamed from: i */
        private final short f5988i;

        /* renamed from: j */
        private final String f5989j;

        static {
            Iterator it = EnumSet.allOf(EnumC2092a.class).iterator();
            while (it.hasNext()) {
                EnumC2092a aVar = (EnumC2092a) it.next();
                f5986h.put(aVar.mo11003a(), aVar);
            }
        }

        private EnumC2092a(short s, String str) {
            this.f5988i = s;
            this.f5989j = str;
        }

        /* renamed from: a */
        public String mo11003a() {
            return this.f5989j;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC2092a.class);
        enumMap.put((Object) EnumC2092a.DEBUG, (Object) new C2167b("debug", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2092a.TARGET, (Object) new C2167b("target", (byte) 2, new C2172g((byte) 12, C2069d.class)));
        enumMap.put((Object) EnumC2092a.ID, (Object) new C2167b("id", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2092a.APP_ID, (Object) new C2167b(AppState.APP_ID, (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2092a.TOPIC, (Object) new C2167b("topic", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2092a.PACKAGE_NAME, (Object) new C2167b("packageName", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2092a.CATEGORY, (Object) new C2167b("category", (byte) 2, new C2168c((byte) 11)));
        f5963h = Collections.unmodifiableMap(enumMap);
        C2167b.m8203a(C2091o.class, f5963h);
    }

    /* renamed from: a */
    public C2091o mo10984a(String str) {
        this.f5974c = str;
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
                mo11000h();
                return;
            }
            switch (i.f6211c) {
                case 1:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5972a = fVar.mo12161w();
                        break;
                    }
                case 2:
                    if (i.f6210b != 12) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5973b = new C2069d();
                        this.f5973b.mo9945a(fVar);
                        break;
                    }
                case 3:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5974c = fVar.mo12161w();
                        break;
                    }
                case 4:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5975d = fVar.mo12161w();
                        break;
                    }
                case 5:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5976e = fVar.mo12161w();
                        break;
                    }
                case 6:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5977f = fVar.mo12161w();
                        break;
                    }
                case 7:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5978g = fVar.mo12161w();
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
    public boolean mo10985a() {
        return this.f5972a != null;
    }

    /* renamed from: a */
    public boolean mo10986a(C2091o oVar) {
        if (oVar == null) {
            return false;
        }
        boolean a = mo10985a();
        boolean a2 = oVar.mo10985a();
        if ((a || a2) && (!a || !a2 || !this.f5972a.equals(oVar.f5972a))) {
            return false;
        }
        boolean b = mo10989b();
        boolean b2 = oVar.mo10989b();
        if ((b || b2) && (!b || !b2 || !this.f5973b.mo10741a(oVar.f5973b))) {
            return false;
        }
        boolean c = mo10991c();
        boolean c2 = oVar.mo10991c();
        if ((c || c2) && (!c || !c2 || !this.f5974c.equals(oVar.f5974c))) {
            return false;
        }
        boolean d = mo10994d();
        boolean d2 = oVar.mo10994d();
        if ((d || d2) && (!d || !d2 || !this.f5975d.equals(oVar.f5975d))) {
            return false;
        }
        boolean e = mo10996e();
        boolean e2 = oVar.mo10996e();
        if ((e || e2) && (!e || !e2 || !this.f5976e.equals(oVar.f5976e))) {
            return false;
        }
        boolean f = mo10998f();
        boolean f2 = oVar.mo10998f();
        if ((f || f2) && (!f || !f2 || !this.f5977f.equals(oVar.f5977f))) {
            return false;
        }
        boolean g = mo10999g();
        boolean g2 = oVar.mo10999g();
        return (!g && !g2) || (g && g2 && this.f5978g.equals(oVar.f5978g));
    }

    /* renamed from: b */
    public int compareTo(C2091o oVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        if (!getClass().equals(oVar.getClass())) {
            return getClass().getName().compareTo(oVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo10985a()).compareTo(Boolean.valueOf(oVar.mo10985a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo10985a() && (a7 = C2159c.m8187a(this.f5972a, oVar.f5972a)) != 0) {
            return a7;
        }
        int compareTo2 = Boolean.valueOf(mo10989b()).compareTo(Boolean.valueOf(oVar.mo10989b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo10989b() && (a6 = C2159c.m8186a(this.f5973b, oVar.f5973b)) != 0) {
            return a6;
        }
        int compareTo3 = Boolean.valueOf(mo10991c()).compareTo(Boolean.valueOf(oVar.mo10991c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo10991c() && (a5 = C2159c.m8187a(this.f5974c, oVar.f5974c)) != 0) {
            return a5;
        }
        int compareTo4 = Boolean.valueOf(mo10994d()).compareTo(Boolean.valueOf(oVar.mo10994d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo10994d() && (a4 = C2159c.m8187a(this.f5975d, oVar.f5975d)) != 0) {
            return a4;
        }
        int compareTo5 = Boolean.valueOf(mo10996e()).compareTo(Boolean.valueOf(oVar.mo10996e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo10996e() && (a3 = C2159c.m8187a(this.f5976e, oVar.f5976e)) != 0) {
            return a3;
        }
        int compareTo6 = Boolean.valueOf(mo10998f()).compareTo(Boolean.valueOf(oVar.mo10998f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo10998f() && (a2 = C2159c.m8187a(this.f5977f, oVar.f5977f)) != 0) {
            return a2;
        }
        int compareTo7 = Boolean.valueOf(mo10999g()).compareTo(Boolean.valueOf(oVar.mo10999g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (!mo10999g() || (a = C2159c.m8187a(this.f5978g, oVar.f5978g)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: b */
    public C2091o mo10988b(String str) {
        this.f5975d = str;
        return this;
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: b */
    public void mo9950b(AbstractC2180f fVar) {
        mo11000h();
        fVar.mo12134a(f5964i);
        if (this.f5972a != null && mo10985a()) {
            fVar.mo12130a(f5965j);
            fVar.mo12128a(this.f5972a);
            fVar.mo12138b();
        }
        if (this.f5973b != null && mo10989b()) {
            fVar.mo12130a(f5966k);
            this.f5973b.mo9950b(fVar);
            fVar.mo12138b();
        }
        if (this.f5974c != null) {
            fVar.mo12130a(f5967l);
            fVar.mo12128a(this.f5974c);
            fVar.mo12138b();
        }
        if (this.f5975d != null) {
            fVar.mo12130a(f5968m);
            fVar.mo12128a(this.f5975d);
            fVar.mo12138b();
        }
        if (this.f5976e != null) {
            fVar.mo12130a(f5969n);
            fVar.mo12128a(this.f5976e);
            fVar.mo12138b();
        }
        if (this.f5977f != null && mo10998f()) {
            fVar.mo12130a(f5970o);
            fVar.mo12128a(this.f5977f);
            fVar.mo12138b();
        }
        if (this.f5978g != null && mo10999g()) {
            fVar.mo12130a(f5971p);
            fVar.mo12128a(this.f5978g);
            fVar.mo12138b();
        }
        fVar.mo12139c();
        fVar.mo12124a();
    }

    /* renamed from: b */
    public boolean mo10989b() {
        return this.f5973b != null;
    }

    /* renamed from: c */
    public C2091o mo10990c(String str) {
        this.f5976e = str;
        return this;
    }

    /* renamed from: c */
    public boolean mo10991c() {
        return this.f5974c != null;
    }

    /* renamed from: d */
    public C2091o mo10993d(String str) {
        this.f5977f = str;
        return this;
    }

    /* renamed from: d */
    public boolean mo10994d() {
        return this.f5975d != null;
    }

    /* renamed from: e */
    public C2091o mo10995e(String str) {
        this.f5978g = str;
        return this;
    }

    /* renamed from: e */
    public boolean mo10996e() {
        return this.f5976e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C2091o)) {
            return mo10986a((C2091o) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo10998f() {
        return this.f5977f != null;
    }

    /* renamed from: g */
    public boolean mo10999g() {
        return this.f5978g != null;
    }

    /* renamed from: h */
    public void mo11000h() {
        if (this.f5974c == null) {
            throw new C2181g("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f5975d == null) {
            throw new C2181g("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f5976e == null) {
            throw new C2181g("Required field 'topic' was not present! Struct: " + toString());
        }
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        boolean z2 = true;
        if (mo10985a()) {
            sb.append("debug:");
            if (this.f5972a == null) {
                sb.append("null");
            } else {
                sb.append(this.f5972a);
            }
            z2 = false;
        }
        if (mo10989b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f5973b == null) {
                sb.append("null");
            } else {
                sb.append(this.f5973b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f5974c == null) {
            sb.append("null");
        } else {
            sb.append(this.f5974c);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f5975d == null) {
            sb.append("null");
        } else {
            sb.append(this.f5975d);
        }
        sb.append(", ");
        sb.append("topic:");
        if (this.f5976e == null) {
            sb.append("null");
        } else {
            sb.append(this.f5976e);
        }
        if (mo10998f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f5977f == null) {
                sb.append("null");
            } else {
                sb.append(this.f5977f);
            }
        }
        if (mo10999g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f5978g == null) {
                sb.append("null");
            } else {
                sb.append(this.f5978g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
