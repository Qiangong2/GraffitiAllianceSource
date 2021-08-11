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
import org.apache.thrift.meta_data.C2170e;
import org.apache.thrift.meta_data.C2172g;
import org.apache.thrift.protocol.AbstractC2180f;
import org.apache.thrift.protocol.C2177c;
import org.apache.thrift.protocol.C2179e;
import org.apache.thrift.protocol.C2181g;
import org.apache.thrift.protocol.C2183i;
import org.apache.thrift.protocol.C2185k;

/* renamed from: com.xiaomi.xmpush.thrift.l */
public class C2085l implements Serializable, Cloneable, AbstractC2158b<C2085l, EnumC2086a> {

    /* renamed from: g */
    public static final Map<EnumC2086a, C2167b> f5865g;

    /* renamed from: h */
    private static final C2185k f5866h = new C2185k("XmPushActionSendFeedback");

    /* renamed from: i */
    private static final C2177c f5867i = new C2177c("debug", (byte) 11, 1);

    /* renamed from: j */
    private static final C2177c f5868j = new C2177c("target", (byte) 12, 2);

    /* renamed from: k */
    private static final C2177c f5869k = new C2177c("id", (byte) 11, 3);

    /* renamed from: l */
    private static final C2177c f5870l = new C2177c(AppState.APP_ID, (byte) 11, 4);

    /* renamed from: m */
    private static final C2177c f5871m = new C2177c("feedbacks", (byte) 13, 5);

    /* renamed from: n */
    private static final C2177c f5872n = new C2177c("category", (byte) 11, 6);

    /* renamed from: a */
    public String f5873a;

    /* renamed from: b */
    public C2069d f5874b;

    /* renamed from: c */
    public String f5875c;

    /* renamed from: d */
    public String f5876d;

    /* renamed from: e */
    public Map<String, String> f5877e;

    /* renamed from: f */
    public String f5878f;

    /* renamed from: com.xiaomi.xmpush.thrift.l$a */
    public enum EnumC2086a {
        DEBUG(1, "debug"),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, AppState.APP_ID),
        FEEDBACKS(5, "feedbacks"),
        CATEGORY(6, "category");
        

        /* renamed from: g */
        private static final Map<String, EnumC2086a> f5885g = new HashMap();

        /* renamed from: h */
        private final short f5887h;

        /* renamed from: i */
        private final String f5888i;

        static {
            Iterator it = EnumSet.allOf(EnumC2086a.class).iterator();
            while (it.hasNext()) {
                EnumC2086a aVar = (EnumC2086a) it.next();
                f5885g.put(aVar.mo10938a(), aVar);
            }
        }

        private EnumC2086a(short s, String str) {
            this.f5887h = s;
            this.f5888i = str;
        }

        /* renamed from: a */
        public String mo10938a() {
            return this.f5888i;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC2086a.class);
        enumMap.put((Object) EnumC2086a.DEBUG, (Object) new C2167b("debug", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2086a.TARGET, (Object) new C2167b("target", (byte) 2, new C2172g((byte) 12, C2069d.class)));
        enumMap.put((Object) EnumC2086a.ID, (Object) new C2167b("id", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2086a.APP_ID, (Object) new C2167b(AppState.APP_ID, (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2086a.FEEDBACKS, (Object) new C2167b("feedbacks", (byte) 2, new C2170e((byte) 13, new C2168c((byte) 11), new C2168c((byte) 11))));
        enumMap.put((Object) EnumC2086a.CATEGORY, (Object) new C2167b("category", (byte) 2, new C2168c((byte) 11)));
        f5865g = Collections.unmodifiableMap(enumMap);
        C2167b.m8203a(C2085l.class, f5865g);
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: a */
    public void mo9945a(AbstractC2180f fVar) {
        fVar.mo12145g();
        while (true) {
            C2177c i = fVar.mo12147i();
            if (i.f6210b == 0) {
                fVar.mo12146h();
                mo10935g();
                return;
            }
            switch (i.f6211c) {
                case 1:
                    if (i.f6210b == 11) {
                        this.f5873a = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 2:
                    if (i.f6210b == 12) {
                        this.f5874b = new C2069d();
                        this.f5874b.mo9945a(fVar);
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 3:
                    if (i.f6210b == 11) {
                        this.f5875c = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 4:
                    if (i.f6210b == 11) {
                        this.f5876d = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 5:
                    if (i.f6210b == 13) {
                        C2179e k = fVar.mo12149k();
                        this.f5877e = new HashMap(k.f6216c * 2);
                        for (int i2 = 0; i2 < k.f6216c; i2++) {
                            this.f5877e.put(fVar.mo12161w(), fVar.mo12161w());
                        }
                        fVar.mo12150l();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 6:
                    if (i.f6210b == 11) {
                        this.f5878f = fVar.mo12161w();
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
    public boolean mo10925a() {
        return this.f5873a != null;
    }

    /* renamed from: a */
    public boolean mo10926a(C2085l lVar) {
        if (lVar == null) {
            return false;
        }
        boolean a = mo10925a();
        boolean a2 = lVar.mo10925a();
        if ((a || a2) && (!a || !a2 || !this.f5873a.equals(lVar.f5873a))) {
            return false;
        }
        boolean b = mo10928b();
        boolean b2 = lVar.mo10928b();
        if ((b || b2) && (!b || !b2 || !this.f5874b.mo10741a(lVar.f5874b))) {
            return false;
        }
        boolean c = mo10929c();
        boolean c2 = lVar.mo10929c();
        if ((c || c2) && (!c || !c2 || !this.f5875c.equals(lVar.f5875c))) {
            return false;
        }
        boolean d = mo10931d();
        boolean d2 = lVar.mo10931d();
        if ((d || d2) && (!d || !d2 || !this.f5876d.equals(lVar.f5876d))) {
            return false;
        }
        boolean e = mo10932e();
        boolean e2 = lVar.mo10932e();
        if ((e || e2) && (!e || !e2 || !this.f5877e.equals(lVar.f5877e))) {
            return false;
        }
        boolean f = mo10934f();
        boolean f2 = lVar.mo10934f();
        return (!f && !f2) || (f && f2 && this.f5878f.equals(lVar.f5878f));
    }

    /* renamed from: b */
    public int compareTo(C2085l lVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        if (!getClass().equals(lVar.getClass())) {
            return getClass().getName().compareTo(lVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo10925a()).compareTo(Boolean.valueOf(lVar.mo10925a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo10925a() && (a6 = C2159c.m8187a(this.f5873a, lVar.f5873a)) != 0) {
            return a6;
        }
        int compareTo2 = Boolean.valueOf(mo10928b()).compareTo(Boolean.valueOf(lVar.mo10928b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo10928b() && (a5 = C2159c.m8186a(this.f5874b, lVar.f5874b)) != 0) {
            return a5;
        }
        int compareTo3 = Boolean.valueOf(mo10929c()).compareTo(Boolean.valueOf(lVar.mo10929c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo10929c() && (a4 = C2159c.m8187a(this.f5875c, lVar.f5875c)) != 0) {
            return a4;
        }
        int compareTo4 = Boolean.valueOf(mo10931d()).compareTo(Boolean.valueOf(lVar.mo10931d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo10931d() && (a3 = C2159c.m8187a(this.f5876d, lVar.f5876d)) != 0) {
            return a3;
        }
        int compareTo5 = Boolean.valueOf(mo10932e()).compareTo(Boolean.valueOf(lVar.mo10932e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo10932e() && (a2 = C2159c.m8190a(this.f5877e, lVar.f5877e)) != 0) {
            return a2;
        }
        int compareTo6 = Boolean.valueOf(mo10934f()).compareTo(Boolean.valueOf(lVar.mo10934f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (!mo10934f() || (a = C2159c.m8187a(this.f5878f, lVar.f5878f)) == 0) {
            return 0;
        }
        return a;
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: b */
    public void mo9950b(AbstractC2180f fVar) {
        mo10935g();
        fVar.mo12134a(f5866h);
        if (this.f5873a != null && mo10925a()) {
            fVar.mo12130a(f5867i);
            fVar.mo12128a(this.f5873a);
            fVar.mo12138b();
        }
        if (this.f5874b != null && mo10928b()) {
            fVar.mo12130a(f5868j);
            this.f5874b.mo9950b(fVar);
            fVar.mo12138b();
        }
        if (this.f5875c != null) {
            fVar.mo12130a(f5869k);
            fVar.mo12128a(this.f5875c);
            fVar.mo12138b();
        }
        if (this.f5876d != null) {
            fVar.mo12130a(f5870l);
            fVar.mo12128a(this.f5876d);
            fVar.mo12138b();
        }
        if (this.f5877e != null && mo10932e()) {
            fVar.mo12130a(f5871m);
            fVar.mo12132a(new C2179e((byte) 11, (byte) 11, this.f5877e.size()));
            for (Map.Entry<String, String> entry : this.f5877e.entrySet()) {
                fVar.mo12128a(entry.getKey());
                fVar.mo12128a(entry.getValue());
            }
            fVar.mo12141d();
            fVar.mo12138b();
        }
        if (this.f5878f != null && mo10934f()) {
            fVar.mo12130a(f5872n);
            fVar.mo12128a(this.f5878f);
            fVar.mo12138b();
        }
        fVar.mo12139c();
        fVar.mo12124a();
    }

    /* renamed from: b */
    public boolean mo10928b() {
        return this.f5874b != null;
    }

    /* renamed from: c */
    public boolean mo10929c() {
        return this.f5875c != null;
    }

    /* renamed from: d */
    public boolean mo10931d() {
        return this.f5876d != null;
    }

    /* renamed from: e */
    public boolean mo10932e() {
        return this.f5877e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C2085l)) {
            return mo10926a((C2085l) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo10934f() {
        return this.f5878f != null;
    }

    /* renamed from: g */
    public void mo10935g() {
        if (this.f5875c == null) {
            throw new C2181g("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f5876d == null) {
            throw new C2181g("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedback(");
        boolean z2 = true;
        if (mo10925a()) {
            sb.append("debug:");
            if (this.f5873a == null) {
                sb.append("null");
            } else {
                sb.append(this.f5873a);
            }
            z2 = false;
        }
        if (mo10928b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f5874b == null) {
                sb.append("null");
            } else {
                sb.append(this.f5874b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f5875c == null) {
            sb.append("null");
        } else {
            sb.append(this.f5875c);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f5876d == null) {
            sb.append("null");
        } else {
            sb.append(this.f5876d);
        }
        if (mo10932e()) {
            sb.append(", ");
            sb.append("feedbacks:");
            if (this.f5877e == null) {
                sb.append("null");
            } else {
                sb.append(this.f5877e);
            }
        }
        if (mo10934f()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f5878f == null) {
                sb.append("null");
            } else {
                sb.append(this.f5878f);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
