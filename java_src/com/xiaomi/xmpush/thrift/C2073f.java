package com.xiaomi.xmpush.thrift;

import com.wanmei.push.bean.AppState;
import java.io.Serializable;
import java.util.ArrayList;
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

/* renamed from: com.xiaomi.xmpush.thrift.f */
public class C2073f implements Serializable, Cloneable, AbstractC2158b<C2073f, EnumC2074a> {

    /* renamed from: i */
    public static final Map<EnumC2074a, C2167b> f5654i;

    /* renamed from: j */
    private static final C2185k f5655j = new C2185k("XmPushActionCommand");

    /* renamed from: k */
    private static final C2177c f5656k = new C2177c("debug", (byte) 11, 1);

    /* renamed from: l */
    private static final C2177c f5657l = new C2177c("target", (byte) 12, 2);

    /* renamed from: m */
    private static final C2177c f5658m = new C2177c("id", (byte) 11, 3);

    /* renamed from: n */
    private static final C2177c f5659n = new C2177c(AppState.APP_ID, (byte) 11, 4);

    /* renamed from: o */
    private static final C2177c f5660o = new C2177c("cmdName", (byte) 11, 5);

    /* renamed from: p */
    private static final C2177c f5661p = new C2177c("cmdArgs", C0027o.f104m, 6);

    /* renamed from: q */
    private static final C2177c f5662q = new C2177c("packageName", (byte) 11, 7);

    /* renamed from: r */
    private static final C2177c f5663r = new C2177c("category", (byte) 11, 9);

    /* renamed from: a */
    public String f5664a;

    /* renamed from: b */
    public C2069d f5665b;

    /* renamed from: c */
    public String f5666c;

    /* renamed from: d */
    public String f5667d;

    /* renamed from: e */
    public String f5668e;

    /* renamed from: f */
    public List<String> f5669f;

    /* renamed from: g */
    public String f5670g;

    /* renamed from: h */
    public String f5671h;

    /* renamed from: com.xiaomi.xmpush.thrift.f$a */
    public enum EnumC2074a {
        DEBUG(1, "debug"),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, AppState.APP_ID),
        CMD_NAME(5, "cmdName"),
        CMD_ARGS(6, "cmdArgs"),
        PACKAGE_NAME(7, "packageName"),
        CATEGORY(9, "category");
        

        /* renamed from: i */
        private static final Map<String, EnumC2074a> f5680i = new HashMap();

        /* renamed from: j */
        private final short f5682j;

        /* renamed from: k */
        private final String f5683k;

        static {
            Iterator it = EnumSet.allOf(EnumC2074a.class).iterator();
            while (it.hasNext()) {
                EnumC2074a aVar = (EnumC2074a) it.next();
                f5680i.put(aVar.mo10799a(), aVar);
            }
        }

        private EnumC2074a(short s, String str) {
            this.f5682j = s;
            this.f5683k = str;
        }

        /* renamed from: a */
        public String mo10799a() {
            return this.f5683k;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC2074a.class);
        enumMap.put((Object) EnumC2074a.DEBUG, (Object) new C2167b("debug", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2074a.TARGET, (Object) new C2167b("target", (byte) 2, new C2172g((byte) 12, C2069d.class)));
        enumMap.put((Object) EnumC2074a.ID, (Object) new C2167b("id", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2074a.APP_ID, (Object) new C2167b(AppState.APP_ID, (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2074a.CMD_NAME, (Object) new C2167b("cmdName", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2074a.CMD_ARGS, (Object) new C2167b("cmdArgs", (byte) 2, new C2169d(C0027o.f104m, new C2168c((byte) 11))));
        enumMap.put((Object) EnumC2074a.PACKAGE_NAME, (Object) new C2167b("packageName", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2074a.CATEGORY, (Object) new C2167b("category", (byte) 2, new C2168c((byte) 11)));
        f5654i = Collections.unmodifiableMap(enumMap);
        C2167b.m8203a(C2073f.class, f5654i);
    }

    /* renamed from: a */
    public C2073f mo10778a(String str) {
        this.f5666c = str;
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
                mo10797i();
                return;
            }
            switch (i.f6211c) {
                case 1:
                    if (i.f6210b == 11) {
                        this.f5664a = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 2:
                    if (i.f6210b == 12) {
                        this.f5665b = new C2069d();
                        this.f5665b.mo9945a(fVar);
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 3:
                    if (i.f6210b == 11) {
                        this.f5666c = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 4:
                    if (i.f6210b == 11) {
                        this.f5667d = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 5:
                    if (i.f6210b == 11) {
                        this.f5668e = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 6:
                    if (i.f6210b == 15) {
                        C2178d m = fVar.mo12151m();
                        this.f5669f = new ArrayList(m.f6213b);
                        for (int i2 = 0; i2 < m.f6213b; i2++) {
                            this.f5669f.add(fVar.mo12161w());
                        }
                        fVar.mo12152n();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 7:
                    if (i.f6210b == 11) {
                        this.f5670g = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 8:
                default:
                    C2183i.m8338a(fVar, i.f6210b);
                    break;
                case 9:
                    if (i.f6210b == 11) {
                        this.f5671h = fVar.mo12161w();
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
    public boolean mo10779a() {
        return this.f5664a != null;
    }

    /* renamed from: a */
    public boolean mo10780a(C2073f fVar) {
        if (fVar == null) {
            return false;
        }
        boolean a = mo10779a();
        boolean a2 = fVar.mo10779a();
        if ((a || a2) && (!a || !a2 || !this.f5664a.equals(fVar.f5664a))) {
            return false;
        }
        boolean b = mo10783b();
        boolean b2 = fVar.mo10783b();
        if ((b || b2) && (!b || !b2 || !this.f5665b.mo10741a(fVar.f5665b))) {
            return false;
        }
        boolean c = mo10785c();
        boolean c2 = fVar.mo10785c();
        if ((c || c2) && (!c || !c2 || !this.f5666c.equals(fVar.f5666c))) {
            return false;
        }
        boolean d = mo10788d();
        boolean d2 = fVar.mo10788d();
        if ((d || d2) && (!d || !d2 || !this.f5667d.equals(fVar.f5667d))) {
            return false;
        }
        boolean e = mo10790e();
        boolean e2 = fVar.mo10790e();
        if ((e || e2) && (!e || !e2 || !this.f5668e.equals(fVar.f5668e))) {
            return false;
        }
        boolean f = mo10793f();
        boolean f2 = fVar.mo10793f();
        if ((f || f2) && (!f || !f2 || !this.f5669f.equals(fVar.f5669f))) {
            return false;
        }
        boolean g = mo10794g();
        boolean g2 = fVar.mo10794g();
        if ((g || g2) && (!g || !g2 || !this.f5670g.equals(fVar.f5670g))) {
            return false;
        }
        boolean h = mo10795h();
        boolean h2 = fVar.mo10795h();
        return (!h && !h2) || (h && h2 && this.f5671h.equals(fVar.f5671h));
    }

    /* renamed from: b */
    public int compareTo(C2073f fVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (!getClass().equals(fVar.getClass())) {
            return getClass().getName().compareTo(fVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo10779a()).compareTo(Boolean.valueOf(fVar.mo10779a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo10779a() && (a8 = C2159c.m8187a(this.f5664a, fVar.f5664a)) != 0) {
            return a8;
        }
        int compareTo2 = Boolean.valueOf(mo10783b()).compareTo(Boolean.valueOf(fVar.mo10783b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo10783b() && (a7 = C2159c.m8186a(this.f5665b, fVar.f5665b)) != 0) {
            return a7;
        }
        int compareTo3 = Boolean.valueOf(mo10785c()).compareTo(Boolean.valueOf(fVar.mo10785c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo10785c() && (a6 = C2159c.m8187a(this.f5666c, fVar.f5666c)) != 0) {
            return a6;
        }
        int compareTo4 = Boolean.valueOf(mo10788d()).compareTo(Boolean.valueOf(fVar.mo10788d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo10788d() && (a5 = C2159c.m8187a(this.f5667d, fVar.f5667d)) != 0) {
            return a5;
        }
        int compareTo5 = Boolean.valueOf(mo10790e()).compareTo(Boolean.valueOf(fVar.mo10790e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo10790e() && (a4 = C2159c.m8187a(this.f5668e, fVar.f5668e)) != 0) {
            return a4;
        }
        int compareTo6 = Boolean.valueOf(mo10793f()).compareTo(Boolean.valueOf(fVar.mo10793f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo10793f() && (a3 = C2159c.m8189a(this.f5669f, fVar.f5669f)) != 0) {
            return a3;
        }
        int compareTo7 = Boolean.valueOf(mo10794g()).compareTo(Boolean.valueOf(fVar.mo10794g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo10794g() && (a2 = C2159c.m8187a(this.f5670g, fVar.f5670g)) != 0) {
            return a2;
        }
        int compareTo8 = Boolean.valueOf(mo10795h()).compareTo(Boolean.valueOf(fVar.mo10795h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!mo10795h() || (a = C2159c.m8187a(this.f5671h, fVar.f5671h)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: b */
    public C2073f mo10782b(String str) {
        this.f5667d = str;
        return this;
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: b */
    public void mo9950b(AbstractC2180f fVar) {
        mo10797i();
        fVar.mo12134a(f5655j);
        if (this.f5664a != null && mo10779a()) {
            fVar.mo12130a(f5656k);
            fVar.mo12128a(this.f5664a);
            fVar.mo12138b();
        }
        if (this.f5665b != null && mo10783b()) {
            fVar.mo12130a(f5657l);
            this.f5665b.mo9950b(fVar);
            fVar.mo12138b();
        }
        if (this.f5666c != null) {
            fVar.mo12130a(f5658m);
            fVar.mo12128a(this.f5666c);
            fVar.mo12138b();
        }
        if (this.f5667d != null) {
            fVar.mo12130a(f5659n);
            fVar.mo12128a(this.f5667d);
            fVar.mo12138b();
        }
        if (this.f5668e != null) {
            fVar.mo12130a(f5660o);
            fVar.mo12128a(this.f5668e);
            fVar.mo12138b();
        }
        if (this.f5669f != null && mo10793f()) {
            fVar.mo12130a(f5661p);
            fVar.mo12131a(new C2178d((byte) 11, this.f5669f.size()));
            for (String str : this.f5669f) {
                fVar.mo12128a(str);
            }
            fVar.mo12143e();
            fVar.mo12138b();
        }
        if (this.f5670g != null && mo10794g()) {
            fVar.mo12130a(f5662q);
            fVar.mo12128a(this.f5670g);
            fVar.mo12138b();
        }
        if (this.f5671h != null && mo10795h()) {
            fVar.mo12130a(f5663r);
            fVar.mo12128a(this.f5671h);
            fVar.mo12138b();
        }
        fVar.mo12139c();
        fVar.mo12124a();
    }

    /* renamed from: b */
    public boolean mo10783b() {
        return this.f5665b != null;
    }

    /* renamed from: c */
    public C2073f mo10784c(String str) {
        this.f5668e = str;
        return this;
    }

    /* renamed from: c */
    public boolean mo10785c() {
        return this.f5666c != null;
    }

    /* renamed from: d */
    public void mo10787d(String str) {
        if (this.f5669f == null) {
            this.f5669f = new ArrayList();
        }
        this.f5669f.add(str);
    }

    /* renamed from: d */
    public boolean mo10788d() {
        return this.f5667d != null;
    }

    /* renamed from: e */
    public C2073f mo10789e(String str) {
        this.f5670g = str;
        return this;
    }

    /* renamed from: e */
    public boolean mo10790e() {
        return this.f5668e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C2073f)) {
            return mo10780a((C2073f) obj);
        }
        return false;
    }

    /* renamed from: f */
    public C2073f mo10792f(String str) {
        this.f5671h = str;
        return this;
    }

    /* renamed from: f */
    public boolean mo10793f() {
        return this.f5669f != null;
    }

    /* renamed from: g */
    public boolean mo10794g() {
        return this.f5670g != null;
    }

    /* renamed from: h */
    public boolean mo10795h() {
        return this.f5671h != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public void mo10797i() {
        if (this.f5666c == null) {
            throw new C2181g("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f5667d == null) {
            throw new C2181g("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f5668e == null) {
            throw new C2181g("Required field 'cmdName' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        boolean z2 = true;
        if (mo10779a()) {
            sb.append("debug:");
            if (this.f5664a == null) {
                sb.append("null");
            } else {
                sb.append(this.f5664a);
            }
            z2 = false;
        }
        if (mo10783b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f5665b == null) {
                sb.append("null");
            } else {
                sb.append(this.f5665b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f5666c == null) {
            sb.append("null");
        } else {
            sb.append(this.f5666c);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f5667d == null) {
            sb.append("null");
        } else {
            sb.append(this.f5667d);
        }
        sb.append(", ");
        sb.append("cmdName:");
        if (this.f5668e == null) {
            sb.append("null");
        } else {
            sb.append(this.f5668e);
        }
        if (mo10793f()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            if (this.f5669f == null) {
                sb.append("null");
            } else {
                sb.append(this.f5669f);
            }
        }
        if (mo10794g()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f5670g == null) {
                sb.append("null");
            } else {
                sb.append(this.f5670g);
            }
        }
        if (mo10795h()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f5671h == null) {
                sb.append("null");
            } else {
                sb.append(this.f5671h);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
