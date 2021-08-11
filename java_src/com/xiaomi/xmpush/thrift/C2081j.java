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

/* renamed from: com.xiaomi.xmpush.thrift.j */
public class C2081j implements Serializable, Cloneable, AbstractC2158b<C2081j, EnumC2082a> {

    /* renamed from: k */
    public static final Map<EnumC2082a, C2167b> f5792k;

    /* renamed from: l */
    private static final C2185k f5793l = new C2185k("XmPushActionRegistration");

    /* renamed from: m */
    private static final C2177c f5794m = new C2177c("debug", (byte) 11, 1);

    /* renamed from: n */
    private static final C2177c f5795n = new C2177c("target", (byte) 12, 2);

    /* renamed from: o */
    private static final C2177c f5796o = new C2177c("id", (byte) 11, 3);

    /* renamed from: p */
    private static final C2177c f5797p = new C2177c(AppState.APP_ID, (byte) 11, 4);

    /* renamed from: q */
    private static final C2177c f5798q = new C2177c("appVersion", (byte) 11, 5);

    /* renamed from: r */
    private static final C2177c f5799r = new C2177c("packageName", (byte) 11, 6);

    /* renamed from: s */
    private static final C2177c f5800s = new C2177c(AssistPushConsts.MSG_TYPE_TOKEN, (byte) 11, 7);

    /* renamed from: t */
    private static final C2177c f5801t = new C2177c("deviceId", (byte) 11, 8);

    /* renamed from: u */
    private static final C2177c f5802u = new C2177c("aliasName", (byte) 11, 9);

    /* renamed from: v */
    private static final C2177c f5803v = new C2177c("sdkVersion", (byte) 11, 10);

    /* renamed from: a */
    public String f5804a;

    /* renamed from: b */
    public C2069d f5805b;

    /* renamed from: c */
    public String f5806c;

    /* renamed from: d */
    public String f5807d;

    /* renamed from: e */
    public String f5808e;

    /* renamed from: f */
    public String f5809f;

    /* renamed from: g */
    public String f5810g;

    /* renamed from: h */
    public String f5811h;

    /* renamed from: i */
    public String f5812i;

    /* renamed from: j */
    public String f5813j;

    /* renamed from: com.xiaomi.xmpush.thrift.j$a */
    public enum EnumC2082a {
        DEBUG(1, "debug"),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, AppState.APP_ID),
        APP_VERSION(5, "appVersion"),
        PACKAGE_NAME(6, "packageName"),
        TOKEN(7, AssistPushConsts.MSG_TYPE_TOKEN),
        DEVICE_ID(8, "deviceId"),
        ALIAS_NAME(9, "aliasName"),
        SDK_VERSION(10, "sdkVersion");
        

        /* renamed from: k */
        private static final Map<String, EnumC2082a> f5824k = new HashMap();

        /* renamed from: l */
        private final short f5826l;

        /* renamed from: m */
        private final String f5827m;

        static {
            Iterator it = EnumSet.allOf(EnumC2082a.class).iterator();
            while (it.hasNext()) {
                EnumC2082a aVar = (EnumC2082a) it.next();
                f5824k.put(aVar.mo10905a(), aVar);
            }
        }

        private EnumC2082a(short s, String str) {
            this.f5826l = s;
            this.f5827m = str;
        }

        /* renamed from: a */
        public String mo10905a() {
            return this.f5827m;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC2082a.class);
        enumMap.put((Object) EnumC2082a.DEBUG, (Object) new C2167b("debug", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2082a.TARGET, (Object) new C2167b("target", (byte) 2, new C2172g((byte) 12, C2069d.class)));
        enumMap.put((Object) EnumC2082a.ID, (Object) new C2167b("id", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2082a.APP_ID, (Object) new C2167b(AppState.APP_ID, (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2082a.APP_VERSION, (Object) new C2167b("appVersion", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2082a.PACKAGE_NAME, (Object) new C2167b("packageName", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2082a.TOKEN, (Object) new C2167b(AssistPushConsts.MSG_TYPE_TOKEN, (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2082a.DEVICE_ID, (Object) new C2167b("deviceId", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2082a.ALIAS_NAME, (Object) new C2167b("aliasName", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2082a.SDK_VERSION, (Object) new C2167b("sdkVersion", (byte) 2, new C2168c((byte) 11)));
        f5792k = Collections.unmodifiableMap(enumMap);
        C2167b.m8203a(C2081j.class, f5792k);
    }

    /* renamed from: a */
    public C2081j mo10880a(String str) {
        this.f5806c = str;
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
                mo10903m();
                return;
            }
            switch (i.f6211c) {
                case 1:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5804a = fVar.mo12161w();
                        break;
                    }
                case 2:
                    if (i.f6210b != 12) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5805b = new C2069d();
                        this.f5805b.mo9945a(fVar);
                        break;
                    }
                case 3:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5806c = fVar.mo12161w();
                        break;
                    }
                case 4:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5807d = fVar.mo12161w();
                        break;
                    }
                case 5:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5808e = fVar.mo12161w();
                        break;
                    }
                case 6:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5809f = fVar.mo12161w();
                        break;
                    }
                case 7:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5810g = fVar.mo12161w();
                        break;
                    }
                case 8:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5811h = fVar.mo12161w();
                        break;
                    }
                case 9:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5812i = fVar.mo12161w();
                        break;
                    }
                case 10:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5813j = fVar.mo12161w();
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
    public boolean mo10881a() {
        return this.f5804a != null;
    }

    /* renamed from: a */
    public boolean mo10882a(C2081j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean a = mo10881a();
        boolean a2 = jVar.mo10881a();
        if ((a || a2) && (!a || !a2 || !this.f5804a.equals(jVar.f5804a))) {
            return false;
        }
        boolean b = mo10885b();
        boolean b2 = jVar.mo10885b();
        if ((b || b2) && (!b || !b2 || !this.f5805b.mo10741a(jVar.f5805b))) {
            return false;
        }
        boolean c = mo10887c();
        boolean c2 = jVar.mo10887c();
        if ((c || c2) && (!c || !c2 || !this.f5806c.equals(jVar.f5806c))) {
            return false;
        }
        boolean e = mo10892e();
        boolean e2 = jVar.mo10892e();
        if ((e || e2) && (!e || !e2 || !this.f5807d.equals(jVar.f5807d))) {
            return false;
        }
        boolean f = mo10895f();
        boolean f2 = jVar.mo10895f();
        if ((f || f2) && (!f || !f2 || !this.f5808e.equals(jVar.f5808e))) {
            return false;
        }
        boolean g = mo10896g();
        boolean g2 = jVar.mo10896g();
        if ((g || g2) && (!g || !g2 || !this.f5809f.equals(jVar.f5809f))) {
            return false;
        }
        boolean i = mo10899i();
        boolean i2 = jVar.mo10899i();
        if ((i || i2) && (!i || !i2 || !this.f5810g.equals(jVar.f5810g))) {
            return false;
        }
        boolean j = mo10900j();
        boolean j2 = jVar.mo10900j();
        if ((j || j2) && (!j || !j2 || !this.f5811h.equals(jVar.f5811h))) {
            return false;
        }
        boolean k = mo10901k();
        boolean k2 = jVar.mo10901k();
        if ((k || k2) && (!k || !k2 || !this.f5812i.equals(jVar.f5812i))) {
            return false;
        }
        boolean l = mo10902l();
        boolean l2 = jVar.mo10902l();
        return (!l && !l2) || (l && l2 && this.f5813j.equals(jVar.f5813j));
    }

    /* renamed from: b */
    public int compareTo(C2081j jVar) {
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
        if (!getClass().equals(jVar.getClass())) {
            return getClass().getName().compareTo(jVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo10881a()).compareTo(Boolean.valueOf(jVar.mo10881a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo10881a() && (a10 = C2159c.m8187a(this.f5804a, jVar.f5804a)) != 0) {
            return a10;
        }
        int compareTo2 = Boolean.valueOf(mo10885b()).compareTo(Boolean.valueOf(jVar.mo10885b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo10885b() && (a9 = C2159c.m8186a(this.f5805b, jVar.f5805b)) != 0) {
            return a9;
        }
        int compareTo3 = Boolean.valueOf(mo10887c()).compareTo(Boolean.valueOf(jVar.mo10887c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo10887c() && (a8 = C2159c.m8187a(this.f5806c, jVar.f5806c)) != 0) {
            return a8;
        }
        int compareTo4 = Boolean.valueOf(mo10892e()).compareTo(Boolean.valueOf(jVar.mo10892e()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo10892e() && (a7 = C2159c.m8187a(this.f5807d, jVar.f5807d)) != 0) {
            return a7;
        }
        int compareTo5 = Boolean.valueOf(mo10895f()).compareTo(Boolean.valueOf(jVar.mo10895f()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo10895f() && (a6 = C2159c.m8187a(this.f5808e, jVar.f5808e)) != 0) {
            return a6;
        }
        int compareTo6 = Boolean.valueOf(mo10896g()).compareTo(Boolean.valueOf(jVar.mo10896g()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo10896g() && (a5 = C2159c.m8187a(this.f5809f, jVar.f5809f)) != 0) {
            return a5;
        }
        int compareTo7 = Boolean.valueOf(mo10899i()).compareTo(Boolean.valueOf(jVar.mo10899i()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo10899i() && (a4 = C2159c.m8187a(this.f5810g, jVar.f5810g)) != 0) {
            return a4;
        }
        int compareTo8 = Boolean.valueOf(mo10900j()).compareTo(Boolean.valueOf(jVar.mo10900j()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (mo10900j() && (a3 = C2159c.m8187a(this.f5811h, jVar.f5811h)) != 0) {
            return a3;
        }
        int compareTo9 = Boolean.valueOf(mo10901k()).compareTo(Boolean.valueOf(jVar.mo10901k()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (mo10901k() && (a2 = C2159c.m8187a(this.f5812i, jVar.f5812i)) != 0) {
            return a2;
        }
        int compareTo10 = Boolean.valueOf(mo10902l()).compareTo(Boolean.valueOf(jVar.mo10902l()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!mo10902l() || (a = C2159c.m8187a(this.f5813j, jVar.f5813j)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: b */
    public C2081j mo10884b(String str) {
        this.f5807d = str;
        return this;
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: b */
    public void mo9950b(AbstractC2180f fVar) {
        mo10903m();
        fVar.mo12134a(f5793l);
        if (this.f5804a != null && mo10881a()) {
            fVar.mo12130a(f5794m);
            fVar.mo12128a(this.f5804a);
            fVar.mo12138b();
        }
        if (this.f5805b != null && mo10885b()) {
            fVar.mo12130a(f5795n);
            this.f5805b.mo9950b(fVar);
            fVar.mo12138b();
        }
        if (this.f5806c != null) {
            fVar.mo12130a(f5796o);
            fVar.mo12128a(this.f5806c);
            fVar.mo12138b();
        }
        if (this.f5807d != null) {
            fVar.mo12130a(f5797p);
            fVar.mo12128a(this.f5807d);
            fVar.mo12138b();
        }
        if (this.f5808e != null && mo10895f()) {
            fVar.mo12130a(f5798q);
            fVar.mo12128a(this.f5808e);
            fVar.mo12138b();
        }
        if (this.f5809f != null && mo10896g()) {
            fVar.mo12130a(f5799r);
            fVar.mo12128a(this.f5809f);
            fVar.mo12138b();
        }
        if (this.f5810g != null) {
            fVar.mo12130a(f5800s);
            fVar.mo12128a(this.f5810g);
            fVar.mo12138b();
        }
        if (this.f5811h != null && mo10900j()) {
            fVar.mo12130a(f5801t);
            fVar.mo12128a(this.f5811h);
            fVar.mo12138b();
        }
        if (this.f5812i != null && mo10901k()) {
            fVar.mo12130a(f5802u);
            fVar.mo12128a(this.f5812i);
            fVar.mo12138b();
        }
        if (this.f5813j != null && mo10902l()) {
            fVar.mo12130a(f5803v);
            fVar.mo12128a(this.f5813j);
            fVar.mo12138b();
        }
        fVar.mo12139c();
        fVar.mo12124a();
    }

    /* renamed from: b */
    public boolean mo10885b() {
        return this.f5805b != null;
    }

    /* renamed from: c */
    public C2081j mo10886c(String str) {
        this.f5808e = str;
        return this;
    }

    /* renamed from: c */
    public boolean mo10887c() {
        return this.f5806c != null;
    }

    /* renamed from: d */
    public C2081j mo10889d(String str) {
        this.f5809f = str;
        return this;
    }

    /* renamed from: d */
    public String mo10890d() {
        return this.f5807d;
    }

    /* renamed from: e */
    public C2081j mo10891e(String str) {
        this.f5810g = str;
        return this;
    }

    /* renamed from: e */
    public boolean mo10892e() {
        return this.f5807d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C2081j)) {
            return mo10882a((C2081j) obj);
        }
        return false;
    }

    /* renamed from: f */
    public C2081j mo10894f(String str) {
        this.f5811h = str;
        return this;
    }

    /* renamed from: f */
    public boolean mo10895f() {
        return this.f5808e != null;
    }

    /* renamed from: g */
    public boolean mo10896g() {
        return this.f5809f != null;
    }

    /* renamed from: h */
    public String mo10897h() {
        return this.f5810g;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean mo10899i() {
        return this.f5810g != null;
    }

    /* renamed from: j */
    public boolean mo10900j() {
        return this.f5811h != null;
    }

    /* renamed from: k */
    public boolean mo10901k() {
        return this.f5812i != null;
    }

    /* renamed from: l */
    public boolean mo10902l() {
        return this.f5813j != null;
    }

    /* renamed from: m */
    public void mo10903m() {
        if (this.f5806c == null) {
            throw new C2181g("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f5807d == null) {
            throw new C2181g("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f5810g == null) {
            throw new C2181g("Required field 'token' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
        boolean z2 = true;
        if (mo10881a()) {
            sb.append("debug:");
            if (this.f5804a == null) {
                sb.append("null");
            } else {
                sb.append(this.f5804a);
            }
            z2 = false;
        }
        if (mo10885b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f5805b == null) {
                sb.append("null");
            } else {
                sb.append(this.f5805b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f5806c == null) {
            sb.append("null");
        } else {
            sb.append(this.f5806c);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f5807d == null) {
            sb.append("null");
        } else {
            sb.append(this.f5807d);
        }
        if (mo10895f()) {
            sb.append(", ");
            sb.append("appVersion:");
            if (this.f5808e == null) {
                sb.append("null");
            } else {
                sb.append(this.f5808e);
            }
        }
        if (mo10896g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f5809f == null) {
                sb.append("null");
            } else {
                sb.append(this.f5809f);
            }
        }
        sb.append(", ");
        sb.append("token:");
        if (this.f5810g == null) {
            sb.append("null");
        } else {
            sb.append(this.f5810g);
        }
        if (mo10900j()) {
            sb.append(", ");
            sb.append("deviceId:");
            if (this.f5811h == null) {
                sb.append("null");
            } else {
                sb.append(this.f5811h);
            }
        }
        if (mo10901k()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f5812i == null) {
                sb.append("null");
            } else {
                sb.append(this.f5812i);
            }
        }
        if (mo10902l()) {
            sb.append(", ");
            sb.append("sdkVersion:");
            if (this.f5813j == null) {
                sb.append("null");
            } else {
                sb.append(this.f5813j);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
