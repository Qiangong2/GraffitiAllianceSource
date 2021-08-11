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

/* renamed from: com.xiaomi.xmpush.thrift.m */
public class C2087m implements Serializable, Cloneable, AbstractC2158b<C2087m, EnumC2088a> {

    /* renamed from: i */
    public static final Map<EnumC2088a, C2167b> f5889i;

    /* renamed from: j */
    private static final C2185k f5890j = new C2185k("XmPushActionSendFeedbackResult");

    /* renamed from: k */
    private static final C2177c f5891k = new C2177c("debug", (byte) 11, 1);

    /* renamed from: l */
    private static final C2177c f5892l = new C2177c("target", (byte) 12, 2);

    /* renamed from: m */
    private static final C2177c f5893m = new C2177c("id", (byte) 11, 3);

    /* renamed from: n */
    private static final C2177c f5894n = new C2177c(AppState.APP_ID, (byte) 11, 4);

    /* renamed from: o */
    private static final C2177c f5895o = new C2177c("request", (byte) 12, 5);

    /* renamed from: p */
    private static final C2177c f5896p = new C2177c("errorCode", (byte) 10, 6);

    /* renamed from: q */
    private static final C2177c f5897q = new C2177c("reason", (byte) 11, 7);

    /* renamed from: r */
    private static final C2177c f5898r = new C2177c("category", (byte) 11, 8);

    /* renamed from: a */
    public String f5899a;

    /* renamed from: b */
    public C2069d f5900b;

    /* renamed from: c */
    public String f5901c;

    /* renamed from: d */
    public String f5902d;

    /* renamed from: e */
    public C2085l f5903e;

    /* renamed from: f */
    public long f5904f;

    /* renamed from: g */
    public String f5905g;

    /* renamed from: h */
    public String f5906h;

    /* renamed from: s */
    private BitSet f5907s = new BitSet(1);

    /* renamed from: com.xiaomi.xmpush.thrift.m$a */
    public enum EnumC2088a {
        DEBUG(1, "debug"),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, AppState.APP_ID),
        REQUEST(5, "request"),
        ERROR_CODE(6, "errorCode"),
        REASON(7, "reason"),
        CATEGORY(8, "category");
        

        /* renamed from: i */
        private static final Map<String, EnumC2088a> f5916i = new HashMap();

        /* renamed from: j */
        private final short f5918j;

        /* renamed from: k */
        private final String f5919k;

        static {
            Iterator it = EnumSet.allOf(EnumC2088a.class).iterator();
            while (it.hasNext()) {
                EnumC2088a aVar = (EnumC2088a) it.next();
                f5916i.put(aVar.mo10955a(), aVar);
            }
        }

        private EnumC2088a(short s, String str) {
            this.f5918j = s;
            this.f5919k = str;
        }

        /* renamed from: a */
        public String mo10955a() {
            return this.f5919k;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC2088a.class);
        enumMap.put((Object) EnumC2088a.DEBUG, (Object) new C2167b("debug", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2088a.TARGET, (Object) new C2167b("target", (byte) 2, new C2172g((byte) 12, C2069d.class)));
        enumMap.put((Object) EnumC2088a.ID, (Object) new C2167b("id", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2088a.APP_ID, (Object) new C2167b(AppState.APP_ID, (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2088a.REQUEST, (Object) new C2167b("request", (byte) 2, new C2172g((byte) 12, C2085l.class)));
        enumMap.put((Object) EnumC2088a.ERROR_CODE, (Object) new C2167b("errorCode", (byte) 1, new C2168c((byte) 10)));
        enumMap.put((Object) EnumC2088a.REASON, (Object) new C2167b("reason", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2088a.CATEGORY, (Object) new C2167b("category", (byte) 2, new C2168c((byte) 11)));
        f5889i = Collections.unmodifiableMap(enumMap);
        C2167b.m8203a(C2087m.class, f5889i);
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: a */
    public void mo9945a(AbstractC2180f fVar) {
        fVar.mo12145g();
        while (true) {
            C2177c i = fVar.mo12147i();
            if (i.f6210b == 0) {
                fVar.mo12146h();
                if (!mo10949f()) {
                    throw new C2181g("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
                }
                mo10953i();
                return;
            }
            switch (i.f6211c) {
                case 1:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5899a = fVar.mo12161w();
                        break;
                    }
                case 2:
                    if (i.f6210b != 12) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5900b = new C2069d();
                        this.f5900b.mo9945a(fVar);
                        break;
                    }
                case 3:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5901c = fVar.mo12161w();
                        break;
                    }
                case 4:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5902d = fVar.mo12161w();
                        break;
                    }
                case 5:
                    if (i.f6210b != 12) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5903e = new C2085l();
                        this.f5903e.mo9945a(fVar);
                        break;
                    }
                case 6:
                    if (i.f6210b != 10) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5904f = fVar.mo12159u();
                        mo10939a(true);
                        break;
                    }
                case 7:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5905g = fVar.mo12161w();
                        break;
                    }
                case 8:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5906h = fVar.mo12161w();
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
    public void mo10939a(boolean z) {
        this.f5907s.set(0, z);
    }

    /* renamed from: a */
    public boolean mo10940a() {
        return this.f5899a != null;
    }

    /* renamed from: a */
    public boolean mo10941a(C2087m mVar) {
        if (mVar == null) {
            return false;
        }
        boolean a = mo10940a();
        boolean a2 = mVar.mo10940a();
        if ((a || a2) && (!a || !a2 || !this.f5899a.equals(mVar.f5899a))) {
            return false;
        }
        boolean b = mo10943b();
        boolean b2 = mVar.mo10943b();
        if ((b || b2) && (!b || !b2 || !this.f5900b.mo10741a(mVar.f5900b))) {
            return false;
        }
        boolean c = mo10944c();
        boolean c2 = mVar.mo10944c();
        if ((c || c2) && (!c || !c2 || !this.f5901c.equals(mVar.f5901c))) {
            return false;
        }
        boolean d = mo10946d();
        boolean d2 = mVar.mo10946d();
        if ((d || d2) && (!d || !d2 || !this.f5902d.equals(mVar.f5902d))) {
            return false;
        }
        boolean e = mo10947e();
        boolean e2 = mVar.mo10947e();
        if (((e || e2) && (!e || !e2 || !this.f5903e.mo10926a(mVar.f5903e))) || this.f5904f != mVar.f5904f) {
            return false;
        }
        boolean g = mo10950g();
        boolean g2 = mVar.mo10950g();
        if ((g || g2) && (!g || !g2 || !this.f5905g.equals(mVar.f5905g))) {
            return false;
        }
        boolean h = mo10951h();
        boolean h2 = mVar.mo10951h();
        return (!h && !h2) || (h && h2 && this.f5906h.equals(mVar.f5906h));
    }

    /* renamed from: b */
    public int compareTo(C2087m mVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (!getClass().equals(mVar.getClass())) {
            return getClass().getName().compareTo(mVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo10940a()).compareTo(Boolean.valueOf(mVar.mo10940a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo10940a() && (a8 = C2159c.m8187a(this.f5899a, mVar.f5899a)) != 0) {
            return a8;
        }
        int compareTo2 = Boolean.valueOf(mo10943b()).compareTo(Boolean.valueOf(mVar.mo10943b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo10943b() && (a7 = C2159c.m8186a(this.f5900b, mVar.f5900b)) != 0) {
            return a7;
        }
        int compareTo3 = Boolean.valueOf(mo10944c()).compareTo(Boolean.valueOf(mVar.mo10944c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo10944c() && (a6 = C2159c.m8187a(this.f5901c, mVar.f5901c)) != 0) {
            return a6;
        }
        int compareTo4 = Boolean.valueOf(mo10946d()).compareTo(Boolean.valueOf(mVar.mo10946d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo10946d() && (a5 = C2159c.m8187a(this.f5902d, mVar.f5902d)) != 0) {
            return a5;
        }
        int compareTo5 = Boolean.valueOf(mo10947e()).compareTo(Boolean.valueOf(mVar.mo10947e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo10947e() && (a4 = C2159c.m8186a(this.f5903e, mVar.f5903e)) != 0) {
            return a4;
        }
        int compareTo6 = Boolean.valueOf(mo10949f()).compareTo(Boolean.valueOf(mVar.mo10949f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo10949f() && (a3 = C2159c.m8185a(this.f5904f, mVar.f5904f)) != 0) {
            return a3;
        }
        int compareTo7 = Boolean.valueOf(mo10950g()).compareTo(Boolean.valueOf(mVar.mo10950g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo10950g() && (a2 = C2159c.m8187a(this.f5905g, mVar.f5905g)) != 0) {
            return a2;
        }
        int compareTo8 = Boolean.valueOf(mo10951h()).compareTo(Boolean.valueOf(mVar.mo10951h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!mo10951h() || (a = C2159c.m8187a(this.f5906h, mVar.f5906h)) == 0) {
            return 0;
        }
        return a;
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: b */
    public void mo9950b(AbstractC2180f fVar) {
        mo10953i();
        fVar.mo12134a(f5890j);
        if (this.f5899a != null && mo10940a()) {
            fVar.mo12130a(f5891k);
            fVar.mo12128a(this.f5899a);
            fVar.mo12138b();
        }
        if (this.f5900b != null && mo10943b()) {
            fVar.mo12130a(f5892l);
            this.f5900b.mo9950b(fVar);
            fVar.mo12138b();
        }
        if (this.f5901c != null) {
            fVar.mo12130a(f5893m);
            fVar.mo12128a(this.f5901c);
            fVar.mo12138b();
        }
        if (this.f5902d != null) {
            fVar.mo12130a(f5894n);
            fVar.mo12128a(this.f5902d);
            fVar.mo12138b();
        }
        if (this.f5903e != null && mo10947e()) {
            fVar.mo12130a(f5895o);
            this.f5903e.mo9950b(fVar);
            fVar.mo12138b();
        }
        fVar.mo12130a(f5896p);
        fVar.mo12127a(this.f5904f);
        fVar.mo12138b();
        if (this.f5905g != null && mo10950g()) {
            fVar.mo12130a(f5897q);
            fVar.mo12128a(this.f5905g);
            fVar.mo12138b();
        }
        if (this.f5906h != null && mo10951h()) {
            fVar.mo12130a(f5898r);
            fVar.mo12128a(this.f5906h);
            fVar.mo12138b();
        }
        fVar.mo12139c();
        fVar.mo12124a();
    }

    /* renamed from: b */
    public boolean mo10943b() {
        return this.f5900b != null;
    }

    /* renamed from: c */
    public boolean mo10944c() {
        return this.f5901c != null;
    }

    /* renamed from: d */
    public boolean mo10946d() {
        return this.f5902d != null;
    }

    /* renamed from: e */
    public boolean mo10947e() {
        return this.f5903e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C2087m)) {
            return mo10941a((C2087m) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo10949f() {
        return this.f5907s.get(0);
    }

    /* renamed from: g */
    public boolean mo10950g() {
        return this.f5905g != null;
    }

    /* renamed from: h */
    public boolean mo10951h() {
        return this.f5906h != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public void mo10953i() {
        if (this.f5901c == null) {
            throw new C2181g("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f5902d == null) {
            throw new C2181g("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        boolean z2 = true;
        if (mo10940a()) {
            sb.append("debug:");
            if (this.f5899a == null) {
                sb.append("null");
            } else {
                sb.append(this.f5899a);
            }
            z2 = false;
        }
        if (mo10943b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f5900b == null) {
                sb.append("null");
            } else {
                sb.append(this.f5900b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f5901c == null) {
            sb.append("null");
        } else {
            sb.append(this.f5901c);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f5902d == null) {
            sb.append("null");
        } else {
            sb.append(this.f5902d);
        }
        if (mo10947e()) {
            sb.append(", ");
            sb.append("request:");
            if (this.f5903e == null) {
                sb.append("null");
            } else {
                sb.append(this.f5903e);
            }
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f5904f);
        if (mo10950g()) {
            sb.append(", ");
            sb.append("reason:");
            if (this.f5905g == null) {
                sb.append("null");
            } else {
                sb.append(this.f5905g);
            }
        }
        if (mo10951h()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f5906h == null) {
                sb.append("null");
            } else {
                sb.append(this.f5906h);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
