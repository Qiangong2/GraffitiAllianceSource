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

/* renamed from: com.xiaomi.xmpush.thrift.s */
public class C2099s implements Serializable, Cloneable, AbstractC2158b<C2099s, EnumC2100a> {

    /* renamed from: h */
    public static final Map<EnumC2100a, C2167b> f6094h;

    /* renamed from: i */
    private static final C2185k f6095i = new C2185k("XmPushActionUnSubscription");

    /* renamed from: j */
    private static final C2177c f6096j = new C2177c("debug", (byte) 11, 1);

    /* renamed from: k */
    private static final C2177c f6097k = new C2177c("target", (byte) 12, 2);

    /* renamed from: l */
    private static final C2177c f6098l = new C2177c("id", (byte) 11, 3);

    /* renamed from: m */
    private static final C2177c f6099m = new C2177c(AppState.APP_ID, (byte) 11, 4);

    /* renamed from: n */
    private static final C2177c f6100n = new C2177c("topic", (byte) 11, 5);

    /* renamed from: o */
    private static final C2177c f6101o = new C2177c("packageName", (byte) 11, 6);

    /* renamed from: p */
    private static final C2177c f6102p = new C2177c("category", (byte) 11, 7);

    /* renamed from: a */
    public String f6103a;

    /* renamed from: b */
    public C2069d f6104b;

    /* renamed from: c */
    public String f6105c;

    /* renamed from: d */
    public String f6106d;

    /* renamed from: e */
    public String f6107e;

    /* renamed from: f */
    public String f6108f;

    /* renamed from: g */
    public String f6109g;

    /* renamed from: com.xiaomi.xmpush.thrift.s$a */
    public enum EnumC2100a {
        DEBUG(1, "debug"),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, AppState.APP_ID),
        TOPIC(5, "topic"),
        PACKAGE_NAME(6, "packageName"),
        CATEGORY(7, "category");
        

        /* renamed from: h */
        private static final Map<String, EnumC2100a> f6117h = new HashMap();

        /* renamed from: i */
        private final short f6119i;

        /* renamed from: j */
        private final String f6120j;

        static {
            Iterator it = EnumSet.allOf(EnumC2100a.class).iterator();
            while (it.hasNext()) {
                EnumC2100a aVar = (EnumC2100a) it.next();
                f6117h.put(aVar.mo11084a(), aVar);
            }
        }

        private EnumC2100a(short s, String str) {
            this.f6119i = s;
            this.f6120j = str;
        }

        /* renamed from: a */
        public String mo11084a() {
            return this.f6120j;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC2100a.class);
        enumMap.put((Object) EnumC2100a.DEBUG, (Object) new C2167b("debug", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2100a.TARGET, (Object) new C2167b("target", (byte) 2, new C2172g((byte) 12, C2069d.class)));
        enumMap.put((Object) EnumC2100a.ID, (Object) new C2167b("id", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2100a.APP_ID, (Object) new C2167b(AppState.APP_ID, (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2100a.TOPIC, (Object) new C2167b("topic", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2100a.PACKAGE_NAME, (Object) new C2167b("packageName", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2100a.CATEGORY, (Object) new C2167b("category", (byte) 2, new C2168c((byte) 11)));
        f6094h = Collections.unmodifiableMap(enumMap);
        C2167b.m8203a(C2099s.class, f6094h);
    }

    /* renamed from: a */
    public C2099s mo11065a(String str) {
        this.f6105c = str;
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
                mo11081h();
                return;
            }
            switch (i.f6211c) {
                case 1:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6103a = fVar.mo12161w();
                        break;
                    }
                case 2:
                    if (i.f6210b != 12) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6104b = new C2069d();
                        this.f6104b.mo9945a(fVar);
                        break;
                    }
                case 3:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6105c = fVar.mo12161w();
                        break;
                    }
                case 4:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6106d = fVar.mo12161w();
                        break;
                    }
                case 5:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6107e = fVar.mo12161w();
                        break;
                    }
                case 6:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6108f = fVar.mo12161w();
                        break;
                    }
                case 7:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f6109g = fVar.mo12161w();
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
    public boolean mo11066a() {
        return this.f6103a != null;
    }

    /* renamed from: a */
    public boolean mo11067a(C2099s sVar) {
        if (sVar == null) {
            return false;
        }
        boolean a = mo11066a();
        boolean a2 = sVar.mo11066a();
        if ((a || a2) && (!a || !a2 || !this.f6103a.equals(sVar.f6103a))) {
            return false;
        }
        boolean b = mo11070b();
        boolean b2 = sVar.mo11070b();
        if ((b || b2) && (!b || !b2 || !this.f6104b.mo10741a(sVar.f6104b))) {
            return false;
        }
        boolean c = mo11072c();
        boolean c2 = sVar.mo11072c();
        if ((c || c2) && (!c || !c2 || !this.f6105c.equals(sVar.f6105c))) {
            return false;
        }
        boolean d = mo11075d();
        boolean d2 = sVar.mo11075d();
        if ((d || d2) && (!d || !d2 || !this.f6106d.equals(sVar.f6106d))) {
            return false;
        }
        boolean e = mo11077e();
        boolean e2 = sVar.mo11077e();
        if ((e || e2) && (!e || !e2 || !this.f6107e.equals(sVar.f6107e))) {
            return false;
        }
        boolean f = mo11079f();
        boolean f2 = sVar.mo11079f();
        if ((f || f2) && (!f || !f2 || !this.f6108f.equals(sVar.f6108f))) {
            return false;
        }
        boolean g = mo11080g();
        boolean g2 = sVar.mo11080g();
        return (!g && !g2) || (g && g2 && this.f6109g.equals(sVar.f6109g));
    }

    /* renamed from: b */
    public int compareTo(C2099s sVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        if (!getClass().equals(sVar.getClass())) {
            return getClass().getName().compareTo(sVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo11066a()).compareTo(Boolean.valueOf(sVar.mo11066a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo11066a() && (a7 = C2159c.m8187a(this.f6103a, sVar.f6103a)) != 0) {
            return a7;
        }
        int compareTo2 = Boolean.valueOf(mo11070b()).compareTo(Boolean.valueOf(sVar.mo11070b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo11070b() && (a6 = C2159c.m8186a(this.f6104b, sVar.f6104b)) != 0) {
            return a6;
        }
        int compareTo3 = Boolean.valueOf(mo11072c()).compareTo(Boolean.valueOf(sVar.mo11072c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo11072c() && (a5 = C2159c.m8187a(this.f6105c, sVar.f6105c)) != 0) {
            return a5;
        }
        int compareTo4 = Boolean.valueOf(mo11075d()).compareTo(Boolean.valueOf(sVar.mo11075d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo11075d() && (a4 = C2159c.m8187a(this.f6106d, sVar.f6106d)) != 0) {
            return a4;
        }
        int compareTo5 = Boolean.valueOf(mo11077e()).compareTo(Boolean.valueOf(sVar.mo11077e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo11077e() && (a3 = C2159c.m8187a(this.f6107e, sVar.f6107e)) != 0) {
            return a3;
        }
        int compareTo6 = Boolean.valueOf(mo11079f()).compareTo(Boolean.valueOf(sVar.mo11079f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo11079f() && (a2 = C2159c.m8187a(this.f6108f, sVar.f6108f)) != 0) {
            return a2;
        }
        int compareTo7 = Boolean.valueOf(mo11080g()).compareTo(Boolean.valueOf(sVar.mo11080g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (!mo11080g() || (a = C2159c.m8187a(this.f6109g, sVar.f6109g)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: b */
    public C2099s mo11069b(String str) {
        this.f6106d = str;
        return this;
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: b */
    public void mo9950b(AbstractC2180f fVar) {
        mo11081h();
        fVar.mo12134a(f6095i);
        if (this.f6103a != null && mo11066a()) {
            fVar.mo12130a(f6096j);
            fVar.mo12128a(this.f6103a);
            fVar.mo12138b();
        }
        if (this.f6104b != null && mo11070b()) {
            fVar.mo12130a(f6097k);
            this.f6104b.mo9950b(fVar);
            fVar.mo12138b();
        }
        if (this.f6105c != null) {
            fVar.mo12130a(f6098l);
            fVar.mo12128a(this.f6105c);
            fVar.mo12138b();
        }
        if (this.f6106d != null) {
            fVar.mo12130a(f6099m);
            fVar.mo12128a(this.f6106d);
            fVar.mo12138b();
        }
        if (this.f6107e != null) {
            fVar.mo12130a(f6100n);
            fVar.mo12128a(this.f6107e);
            fVar.mo12138b();
        }
        if (this.f6108f != null && mo11079f()) {
            fVar.mo12130a(f6101o);
            fVar.mo12128a(this.f6108f);
            fVar.mo12138b();
        }
        if (this.f6109g != null && mo11080g()) {
            fVar.mo12130a(f6102p);
            fVar.mo12128a(this.f6109g);
            fVar.mo12138b();
        }
        fVar.mo12139c();
        fVar.mo12124a();
    }

    /* renamed from: b */
    public boolean mo11070b() {
        return this.f6104b != null;
    }

    /* renamed from: c */
    public C2099s mo11071c(String str) {
        this.f6107e = str;
        return this;
    }

    /* renamed from: c */
    public boolean mo11072c() {
        return this.f6105c != null;
    }

    /* renamed from: d */
    public C2099s mo11074d(String str) {
        this.f6108f = str;
        return this;
    }

    /* renamed from: d */
    public boolean mo11075d() {
        return this.f6106d != null;
    }

    /* renamed from: e */
    public C2099s mo11076e(String str) {
        this.f6109g = str;
        return this;
    }

    /* renamed from: e */
    public boolean mo11077e() {
        return this.f6107e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C2099s)) {
            return mo11067a((C2099s) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo11079f() {
        return this.f6108f != null;
    }

    /* renamed from: g */
    public boolean mo11080g() {
        return this.f6109g != null;
    }

    /* renamed from: h */
    public void mo11081h() {
        if (this.f6105c == null) {
            throw new C2181g("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f6106d == null) {
            throw new C2181g("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f6107e == null) {
            throw new C2181g("Required field 'topic' was not present! Struct: " + toString());
        }
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
        boolean z2 = true;
        if (mo11066a()) {
            sb.append("debug:");
            if (this.f6103a == null) {
                sb.append("null");
            } else {
                sb.append(this.f6103a);
            }
            z2 = false;
        }
        if (mo11070b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f6104b == null) {
                sb.append("null");
            } else {
                sb.append(this.f6104b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f6105c == null) {
            sb.append("null");
        } else {
            sb.append(this.f6105c);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f6106d == null) {
            sb.append("null");
        } else {
            sb.append(this.f6106d);
        }
        sb.append(", ");
        sb.append("topic:");
        if (this.f6107e == null) {
            sb.append("null");
        } else {
            sb.append(this.f6107e);
        }
        if (mo11079f()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f6108f == null) {
                sb.append("null");
            } else {
                sb.append(this.f6108f);
            }
        }
        if (mo11080g()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f6109g == null) {
                sb.append("null");
            } else {
                sb.append(this.f6109g);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
