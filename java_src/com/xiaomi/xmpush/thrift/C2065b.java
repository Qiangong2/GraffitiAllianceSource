package com.xiaomi.xmpush.thrift;

import com.igexin.assist.sdk.AssistPushConsts;
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

/* renamed from: com.xiaomi.xmpush.thrift.b */
public class C2065b implements Serializable, Cloneable, AbstractC2158b<C2065b, EnumC2066a> {

    /* renamed from: i */
    public static final Map<EnumC2066a, C2167b> f5521i;

    /* renamed from: j */
    private static final C2185k f5522j = new C2185k("PushMessage");

    /* renamed from: k */
    private static final C2177c f5523k = new C2177c("to", (byte) 12, 1);

    /* renamed from: l */
    private static final C2177c f5524l = new C2177c("id", (byte) 11, 2);

    /* renamed from: m */
    private static final C2177c f5525m = new C2177c(AppState.APP_ID, (byte) 11, 3);

    /* renamed from: n */
    private static final C2177c f5526n = new C2177c(AssistPushConsts.MSG_TYPE_PAYLOAD, (byte) 11, 4);

    /* renamed from: o */
    private static final C2177c f5527o = new C2177c("createAt", (byte) 10, 5);

    /* renamed from: p */
    private static final C2177c f5528p = new C2177c("ttl", (byte) 10, 6);

    /* renamed from: q */
    private static final C2177c f5529q = new C2177c("collapseKey", (byte) 11, 7);

    /* renamed from: r */
    private static final C2177c f5530r = new C2177c("packageName", (byte) 11, 8);

    /* renamed from: a */
    public C2069d f5531a;

    /* renamed from: b */
    public String f5532b;

    /* renamed from: c */
    public String f5533c;

    /* renamed from: d */
    public String f5534d;

    /* renamed from: e */
    public long f5535e;

    /* renamed from: f */
    public long f5536f;

    /* renamed from: g */
    public String f5537g;

    /* renamed from: h */
    public String f5538h;

    /* renamed from: s */
    private BitSet f5539s = new BitSet(2);

    /* renamed from: com.xiaomi.xmpush.thrift.b$a */
    public enum EnumC2066a {
        TO(1, "to"),
        ID(2, "id"),
        APP_ID(3, AppState.APP_ID),
        PAYLOAD(4, AssistPushConsts.MSG_TYPE_PAYLOAD),
        CREATE_AT(5, "createAt"),
        TTL(6, "ttl"),
        COLLAPSE_KEY(7, "collapseKey"),
        PACKAGE_NAME(8, "packageName");
        

        /* renamed from: i */
        private static final Map<String, EnumC2066a> f5548i = new HashMap();

        /* renamed from: j */
        private final short f5550j;

        /* renamed from: k */
        private final String f5551k;

        static {
            Iterator it = EnumSet.allOf(EnumC2066a.class).iterator();
            while (it.hasNext()) {
                EnumC2066a aVar = (EnumC2066a) it.next();
                f5548i.put(aVar.mo10693a(), aVar);
            }
        }

        private EnumC2066a(short s, String str) {
            this.f5550j = s;
            this.f5551k = str;
        }

        /* renamed from: a */
        public String mo10693a() {
            return this.f5551k;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC2066a.class);
        enumMap.put((Object) EnumC2066a.TO, (Object) new C2167b("to", (byte) 2, new C2172g((byte) 12, C2069d.class)));
        enumMap.put((Object) EnumC2066a.ID, (Object) new C2167b("id", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2066a.APP_ID, (Object) new C2167b(AppState.APP_ID, (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2066a.PAYLOAD, (Object) new C2167b(AssistPushConsts.MSG_TYPE_PAYLOAD, (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2066a.CREATE_AT, (Object) new C2167b("createAt", (byte) 2, new C2168c((byte) 10)));
        enumMap.put((Object) EnumC2066a.TTL, (Object) new C2167b("ttl", (byte) 2, new C2168c((byte) 10)));
        enumMap.put((Object) EnumC2066a.COLLAPSE_KEY, (Object) new C2167b("collapseKey", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2066a.PACKAGE_NAME, (Object) new C2167b("packageName", (byte) 2, new C2168c((byte) 11)));
        f5521i = Collections.unmodifiableMap(enumMap);
        C2167b.m8203a(C2065b.class, f5521i);
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: a */
    public void mo9945a(AbstractC2180f fVar) {
        fVar.mo12145g();
        while (true) {
            C2177c i = fVar.mo12147i();
            if (i.f6210b == 0) {
                fVar.mo12146h();
                mo10691m();
                return;
            }
            switch (i.f6211c) {
                case 1:
                    if (i.f6210b != 12) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5531a = new C2069d();
                        this.f5531a.mo9945a(fVar);
                        break;
                    }
                case 2:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5532b = fVar.mo12161w();
                        break;
                    }
                case 3:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5533c = fVar.mo12161w();
                        break;
                    }
                case 4:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5534d = fVar.mo12161w();
                        break;
                    }
                case 5:
                    if (i.f6210b != 10) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5535e = fVar.mo12159u();
                        mo10672a(true);
                        break;
                    }
                case 6:
                    if (i.f6210b != 10) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5536f = fVar.mo12159u();
                        mo10677b(true);
                        break;
                    }
                case 7:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5537g = fVar.mo12161w();
                        break;
                    }
                case 8:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5538h = fVar.mo12161w();
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
    public void mo10672a(boolean z) {
        this.f5539s.set(0, z);
    }

    /* renamed from: a */
    public boolean mo10673a() {
        return this.f5531a != null;
    }

    /* renamed from: a */
    public boolean mo10674a(C2065b bVar) {
        if (bVar == null) {
            return false;
        }
        boolean a = mo10673a();
        boolean a2 = bVar.mo10673a();
        if ((a || a2) && (!a || !a2 || !this.f5531a.mo10741a(bVar.f5531a))) {
            return false;
        }
        boolean c = mo10678c();
        boolean c2 = bVar.mo10678c();
        if ((c || c2) && (!c || !c2 || !this.f5532b.equals(bVar.f5532b))) {
            return false;
        }
        boolean e = mo10681e();
        boolean e2 = bVar.mo10681e();
        if ((e || e2) && (!e || !e2 || !this.f5533c.equals(bVar.f5533c))) {
            return false;
        }
        boolean g = mo10684g();
        boolean g2 = bVar.mo10684g();
        if ((g || g2) && (!g || !g2 || !this.f5534d.equals(bVar.f5534d))) {
            return false;
        }
        boolean i = mo10687i();
        boolean i2 = bVar.mo10687i();
        if ((i || i2) && (!i || !i2 || this.f5535e != bVar.f5535e)) {
            return false;
        }
        boolean j = mo10688j();
        boolean j2 = bVar.mo10688j();
        if ((j || j2) && (!j || !j2 || this.f5536f != bVar.f5536f)) {
            return false;
        }
        boolean k = mo10689k();
        boolean k2 = bVar.mo10689k();
        if ((k || k2) && (!k || !k2 || !this.f5537g.equals(bVar.f5537g))) {
            return false;
        }
        boolean l = mo10690l();
        boolean l2 = bVar.mo10690l();
        return (!l && !l2) || (l && l2 && this.f5538h.equals(bVar.f5538h));
    }

    /* renamed from: b */
    public int compareTo(C2065b bVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (!getClass().equals(bVar.getClass())) {
            return getClass().getName().compareTo(bVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo10673a()).compareTo(Boolean.valueOf(bVar.mo10673a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo10673a() && (a8 = C2159c.m8186a(this.f5531a, bVar.f5531a)) != 0) {
            return a8;
        }
        int compareTo2 = Boolean.valueOf(mo10678c()).compareTo(Boolean.valueOf(bVar.mo10678c()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo10678c() && (a7 = C2159c.m8187a(this.f5532b, bVar.f5532b)) != 0) {
            return a7;
        }
        int compareTo3 = Boolean.valueOf(mo10681e()).compareTo(Boolean.valueOf(bVar.mo10681e()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo10681e() && (a6 = C2159c.m8187a(this.f5533c, bVar.f5533c)) != 0) {
            return a6;
        }
        int compareTo4 = Boolean.valueOf(mo10684g()).compareTo(Boolean.valueOf(bVar.mo10684g()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo10684g() && (a5 = C2159c.m8187a(this.f5534d, bVar.f5534d)) != 0) {
            return a5;
        }
        int compareTo5 = Boolean.valueOf(mo10687i()).compareTo(Boolean.valueOf(bVar.mo10687i()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo10687i() && (a4 = C2159c.m8185a(this.f5535e, bVar.f5535e)) != 0) {
            return a4;
        }
        int compareTo6 = Boolean.valueOf(mo10688j()).compareTo(Boolean.valueOf(bVar.mo10688j()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo10688j() && (a3 = C2159c.m8185a(this.f5536f, bVar.f5536f)) != 0) {
            return a3;
        }
        int compareTo7 = Boolean.valueOf(mo10689k()).compareTo(Boolean.valueOf(bVar.mo10689k()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo10689k() && (a2 = C2159c.m8187a(this.f5537g, bVar.f5537g)) != 0) {
            return a2;
        }
        int compareTo8 = Boolean.valueOf(mo10690l()).compareTo(Boolean.valueOf(bVar.mo10690l()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!mo10690l() || (a = C2159c.m8187a(this.f5538h, bVar.f5538h)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: b */
    public String mo10676b() {
        return this.f5532b;
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: b */
    public void mo9950b(AbstractC2180f fVar) {
        mo10691m();
        fVar.mo12134a(f5522j);
        if (this.f5531a != null && mo10673a()) {
            fVar.mo12130a(f5523k);
            this.f5531a.mo9950b(fVar);
            fVar.mo12138b();
        }
        if (this.f5532b != null) {
            fVar.mo12130a(f5524l);
            fVar.mo12128a(this.f5532b);
            fVar.mo12138b();
        }
        if (this.f5533c != null) {
            fVar.mo12130a(f5525m);
            fVar.mo12128a(this.f5533c);
            fVar.mo12138b();
        }
        if (this.f5534d != null) {
            fVar.mo12130a(f5526n);
            fVar.mo12128a(this.f5534d);
            fVar.mo12138b();
        }
        if (mo10687i()) {
            fVar.mo12130a(f5527o);
            fVar.mo12127a(this.f5535e);
            fVar.mo12138b();
        }
        if (mo10688j()) {
            fVar.mo12130a(f5528p);
            fVar.mo12127a(this.f5536f);
            fVar.mo12138b();
        }
        if (this.f5537g != null && mo10689k()) {
            fVar.mo12130a(f5529q);
            fVar.mo12128a(this.f5537g);
            fVar.mo12138b();
        }
        if (this.f5538h != null && mo10690l()) {
            fVar.mo12130a(f5530r);
            fVar.mo12128a(this.f5538h);
            fVar.mo12138b();
        }
        fVar.mo12139c();
        fVar.mo12124a();
    }

    /* renamed from: b */
    public void mo10677b(boolean z) {
        this.f5539s.set(1, z);
    }

    /* renamed from: c */
    public boolean mo10678c() {
        return this.f5532b != null;
    }

    /* renamed from: d */
    public String mo10680d() {
        return this.f5533c;
    }

    /* renamed from: e */
    public boolean mo10681e() {
        return this.f5533c != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C2065b)) {
            return mo10674a((C2065b) obj);
        }
        return false;
    }

    /* renamed from: f */
    public String mo10683f() {
        return this.f5534d;
    }

    /* renamed from: g */
    public boolean mo10684g() {
        return this.f5534d != null;
    }

    /* renamed from: h */
    public long mo10685h() {
        return this.f5535e;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean mo10687i() {
        return this.f5539s.get(0);
    }

    /* renamed from: j */
    public boolean mo10688j() {
        return this.f5539s.get(1);
    }

    /* renamed from: k */
    public boolean mo10689k() {
        return this.f5537g != null;
    }

    /* renamed from: l */
    public boolean mo10690l() {
        return this.f5538h != null;
    }

    /* renamed from: m */
    public void mo10691m() {
        if (this.f5532b == null) {
            throw new C2181g("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f5533c == null) {
            throw new C2181g("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f5534d == null) {
            throw new C2181g("Required field 'payload' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMessage(");
        boolean z = true;
        if (mo10673a()) {
            sb.append("to:");
            if (this.f5531a == null) {
                sb.append("null");
            } else {
                sb.append(this.f5531a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f5532b == null) {
            sb.append("null");
        } else {
            sb.append(this.f5532b);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f5533c == null) {
            sb.append("null");
        } else {
            sb.append(this.f5533c);
        }
        sb.append(", ");
        sb.append("payload:");
        if (this.f5534d == null) {
            sb.append("null");
        } else {
            sb.append(this.f5534d);
        }
        if (mo10687i()) {
            sb.append(", ");
            sb.append("createAt:");
            sb.append(this.f5535e);
        }
        if (mo10688j()) {
            sb.append(", ");
            sb.append("ttl:");
            sb.append(this.f5536f);
        }
        if (mo10689k()) {
            sb.append(", ");
            sb.append("collapseKey:");
            if (this.f5537g == null) {
                sb.append("null");
            } else {
                sb.append(this.f5537g);
            }
        }
        if (mo10690l()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f5538h == null) {
                sb.append("null");
            } else {
                sb.append(this.f5538h);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
