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

/* renamed from: com.xiaomi.xmpush.thrift.e */
public class C2071e implements Serializable, Cloneable, AbstractC2158b<C2071e, EnumC2072a> {

    /* renamed from: k */
    public static final Map<EnumC2072a, C2167b> f5617k;

    /* renamed from: l */
    private static final C2185k f5618l = new C2185k("XmPushActionAckMessage");

    /* renamed from: m */
    private static final C2177c f5619m = new C2177c("debug", (byte) 11, 1);

    /* renamed from: n */
    private static final C2177c f5620n = new C2177c("target", (byte) 12, 2);

    /* renamed from: o */
    private static final C2177c f5621o = new C2177c("id", (byte) 11, 3);

    /* renamed from: p */
    private static final C2177c f5622p = new C2177c(AppState.APP_ID, (byte) 11, 4);

    /* renamed from: q */
    private static final C2177c f5623q = new C2177c("messageTs", (byte) 10, 5);

    /* renamed from: r */
    private static final C2177c f5624r = new C2177c("topic", (byte) 11, 6);

    /* renamed from: s */
    private static final C2177c f5625s = new C2177c("aliasName", (byte) 11, 7);

    /* renamed from: t */
    private static final C2177c f5626t = new C2177c("request", (byte) 12, 8);

    /* renamed from: u */
    private static final C2177c f5627u = new C2177c("packageName", (byte) 11, 9);

    /* renamed from: v */
    private static final C2177c f5628v = new C2177c("category", (byte) 11, 10);

    /* renamed from: a */
    public String f5629a;

    /* renamed from: b */
    public C2069d f5630b;

    /* renamed from: c */
    public String f5631c;

    /* renamed from: d */
    public String f5632d;

    /* renamed from: e */
    public long f5633e;

    /* renamed from: f */
    public String f5634f;

    /* renamed from: g */
    public String f5635g;

    /* renamed from: h */
    public C2089n f5636h;

    /* renamed from: i */
    public String f5637i;

    /* renamed from: j */
    public String f5638j;

    /* renamed from: w */
    private BitSet f5639w = new BitSet(1);

    /* renamed from: com.xiaomi.xmpush.thrift.e$a */
    public enum EnumC2072a {
        DEBUG(1, "debug"),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, AppState.APP_ID),
        MESSAGE_TS(5, "messageTs"),
        TOPIC(6, "topic"),
        ALIAS_NAME(7, "aliasName"),
        REQUEST(8, "request"),
        PACKAGE_NAME(9, "packageName"),
        CATEGORY(10, "category");
        

        /* renamed from: k */
        private static final Map<String, EnumC2072a> f5650k = new HashMap();

        /* renamed from: l */
        private final short f5652l;

        /* renamed from: m */
        private final String f5653m;

        static {
            Iterator it = EnumSet.allOf(EnumC2072a.class).iterator();
            while (it.hasNext()) {
                EnumC2072a aVar = (EnumC2072a) it.next();
                f5650k.put(aVar.mo10777a(), aVar);
            }
        }

        private EnumC2072a(short s, String str) {
            this.f5652l = s;
            this.f5653m = str;
        }

        /* renamed from: a */
        public String mo10777a() {
            return this.f5653m;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC2072a.class);
        enumMap.put((Object) EnumC2072a.DEBUG, (Object) new C2167b("debug", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2072a.TARGET, (Object) new C2167b("target", (byte) 2, new C2172g((byte) 12, C2069d.class)));
        enumMap.put((Object) EnumC2072a.ID, (Object) new C2167b("id", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2072a.APP_ID, (Object) new C2167b(AppState.APP_ID, (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2072a.MESSAGE_TS, (Object) new C2167b("messageTs", (byte) 1, new C2168c((byte) 10)));
        enumMap.put((Object) EnumC2072a.TOPIC, (Object) new C2167b("topic", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2072a.ALIAS_NAME, (Object) new C2167b("aliasName", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2072a.REQUEST, (Object) new C2167b("request", (byte) 2, new C2172g((byte) 12, C2089n.class)));
        enumMap.put((Object) EnumC2072a.PACKAGE_NAME, (Object) new C2167b("packageName", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2072a.CATEGORY, (Object) new C2167b("category", (byte) 2, new C2168c((byte) 11)));
        f5617k = Collections.unmodifiableMap(enumMap);
        C2167b.m8203a(C2071e.class, f5617k);
    }

    /* renamed from: a */
    public C2071e mo10754a(long j) {
        this.f5633e = j;
        mo10756a(true);
        return this;
    }

    /* renamed from: a */
    public C2071e mo10755a(String str) {
        this.f5631c = str;
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
                if (!mo10767e()) {
                    throw new C2181g("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
                }
                mo10775k();
                return;
            }
            switch (i.f6211c) {
                case 1:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5629a = fVar.mo12161w();
                        break;
                    }
                case 2:
                    if (i.f6210b != 12) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5630b = new C2069d();
                        this.f5630b.mo9945a(fVar);
                        break;
                    }
                case 3:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5631c = fVar.mo12161w();
                        break;
                    }
                case 4:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5632d = fVar.mo12161w();
                        break;
                    }
                case 5:
                    if (i.f6210b != 10) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5633e = fVar.mo12159u();
                        mo10756a(true);
                        break;
                    }
                case 6:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5634f = fVar.mo12161w();
                        break;
                    }
                case 7:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5635g = fVar.mo12161w();
                        break;
                    }
                case 8:
                    if (i.f6210b != 12) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5636h = new C2089n();
                        this.f5636h.mo9945a(fVar);
                        break;
                    }
                case 9:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5637i = fVar.mo12161w();
                        break;
                    }
                case 10:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5638j = fVar.mo12161w();
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
    public void mo10756a(boolean z) {
        this.f5639w.set(0, z);
    }

    /* renamed from: a */
    public boolean mo10757a() {
        return this.f5629a != null;
    }

    /* renamed from: a */
    public boolean mo10758a(C2071e eVar) {
        if (eVar == null) {
            return false;
        }
        boolean a = mo10757a();
        boolean a2 = eVar.mo10757a();
        if ((a || a2) && (!a || !a2 || !this.f5629a.equals(eVar.f5629a))) {
            return false;
        }
        boolean b = mo10761b();
        boolean b2 = eVar.mo10761b();
        if ((b || b2) && (!b || !b2 || !this.f5630b.mo10741a(eVar.f5630b))) {
            return false;
        }
        boolean c = mo10763c();
        boolean c2 = eVar.mo10763c();
        if ((c || c2) && (!c || !c2 || !this.f5631c.equals(eVar.f5631c))) {
            return false;
        }
        boolean d = mo10766d();
        boolean d2 = eVar.mo10766d();
        if (((d || d2) && (!d || !d2 || !this.f5632d.equals(eVar.f5632d))) || this.f5633e != eVar.f5633e) {
            return false;
        }
        boolean f = mo10769f();
        boolean f2 = eVar.mo10769f();
        if ((f || f2) && (!f || !f2 || !this.f5634f.equals(eVar.f5634f))) {
            return false;
        }
        boolean g = mo10770g();
        boolean g2 = eVar.mo10770g();
        if ((g || g2) && (!g || !g2 || !this.f5635g.equals(eVar.f5635g))) {
            return false;
        }
        boolean h = mo10771h();
        boolean h2 = eVar.mo10771h();
        if ((h || h2) && (!h || !h2 || !this.f5636h.mo10958a(eVar.f5636h))) {
            return false;
        }
        boolean i = mo10773i();
        boolean i2 = eVar.mo10773i();
        if ((i || i2) && (!i || !i2 || !this.f5637i.equals(eVar.f5637i))) {
            return false;
        }
        boolean j = mo10774j();
        boolean j2 = eVar.mo10774j();
        return (!j && !j2) || (j && j2 && this.f5638j.equals(eVar.f5638j));
    }

    /* renamed from: b */
    public int compareTo(C2071e eVar) {
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
        if (!getClass().equals(eVar.getClass())) {
            return getClass().getName().compareTo(eVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo10757a()).compareTo(Boolean.valueOf(eVar.mo10757a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo10757a() && (a10 = C2159c.m8187a(this.f5629a, eVar.f5629a)) != 0) {
            return a10;
        }
        int compareTo2 = Boolean.valueOf(mo10761b()).compareTo(Boolean.valueOf(eVar.mo10761b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo10761b() && (a9 = C2159c.m8186a(this.f5630b, eVar.f5630b)) != 0) {
            return a9;
        }
        int compareTo3 = Boolean.valueOf(mo10763c()).compareTo(Boolean.valueOf(eVar.mo10763c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo10763c() && (a8 = C2159c.m8187a(this.f5631c, eVar.f5631c)) != 0) {
            return a8;
        }
        int compareTo4 = Boolean.valueOf(mo10766d()).compareTo(Boolean.valueOf(eVar.mo10766d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo10766d() && (a7 = C2159c.m8187a(this.f5632d, eVar.f5632d)) != 0) {
            return a7;
        }
        int compareTo5 = Boolean.valueOf(mo10767e()).compareTo(Boolean.valueOf(eVar.mo10767e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo10767e() && (a6 = C2159c.m8185a(this.f5633e, eVar.f5633e)) != 0) {
            return a6;
        }
        int compareTo6 = Boolean.valueOf(mo10769f()).compareTo(Boolean.valueOf(eVar.mo10769f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo10769f() && (a5 = C2159c.m8187a(this.f5634f, eVar.f5634f)) != 0) {
            return a5;
        }
        int compareTo7 = Boolean.valueOf(mo10770g()).compareTo(Boolean.valueOf(eVar.mo10770g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo10770g() && (a4 = C2159c.m8187a(this.f5635g, eVar.f5635g)) != 0) {
            return a4;
        }
        int compareTo8 = Boolean.valueOf(mo10771h()).compareTo(Boolean.valueOf(eVar.mo10771h()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (mo10771h() && (a3 = C2159c.m8186a(this.f5636h, eVar.f5636h)) != 0) {
            return a3;
        }
        int compareTo9 = Boolean.valueOf(mo10773i()).compareTo(Boolean.valueOf(eVar.mo10773i()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (mo10773i() && (a2 = C2159c.m8187a(this.f5637i, eVar.f5637i)) != 0) {
            return a2;
        }
        int compareTo10 = Boolean.valueOf(mo10774j()).compareTo(Boolean.valueOf(eVar.mo10774j()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!mo10774j() || (a = C2159c.m8187a(this.f5638j, eVar.f5638j)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: b */
    public C2071e mo10760b(String str) {
        this.f5632d = str;
        return this;
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: b */
    public void mo9950b(AbstractC2180f fVar) {
        mo10775k();
        fVar.mo12134a(f5618l);
        if (this.f5629a != null && mo10757a()) {
            fVar.mo12130a(f5619m);
            fVar.mo12128a(this.f5629a);
            fVar.mo12138b();
        }
        if (this.f5630b != null && mo10761b()) {
            fVar.mo12130a(f5620n);
            this.f5630b.mo9950b(fVar);
            fVar.mo12138b();
        }
        if (this.f5631c != null) {
            fVar.mo12130a(f5621o);
            fVar.mo12128a(this.f5631c);
            fVar.mo12138b();
        }
        if (this.f5632d != null) {
            fVar.mo12130a(f5622p);
            fVar.mo12128a(this.f5632d);
            fVar.mo12138b();
        }
        fVar.mo12130a(f5623q);
        fVar.mo12127a(this.f5633e);
        fVar.mo12138b();
        if (this.f5634f != null && mo10769f()) {
            fVar.mo12130a(f5624r);
            fVar.mo12128a(this.f5634f);
            fVar.mo12138b();
        }
        if (this.f5635g != null && mo10770g()) {
            fVar.mo12130a(f5625s);
            fVar.mo12128a(this.f5635g);
            fVar.mo12138b();
        }
        if (this.f5636h != null && mo10771h()) {
            fVar.mo12130a(f5626t);
            this.f5636h.mo9950b(fVar);
            fVar.mo12138b();
        }
        if (this.f5637i != null && mo10773i()) {
            fVar.mo12130a(f5627u);
            fVar.mo12128a(this.f5637i);
            fVar.mo12138b();
        }
        if (this.f5638j != null && mo10774j()) {
            fVar.mo12130a(f5628v);
            fVar.mo12128a(this.f5638j);
            fVar.mo12138b();
        }
        fVar.mo12139c();
        fVar.mo12124a();
    }

    /* renamed from: b */
    public boolean mo10761b() {
        return this.f5630b != null;
    }

    /* renamed from: c */
    public C2071e mo10762c(String str) {
        this.f5634f = str;
        return this;
    }

    /* renamed from: c */
    public boolean mo10763c() {
        return this.f5631c != null;
    }

    /* renamed from: d */
    public C2071e mo10765d(String str) {
        this.f5635g = str;
        return this;
    }

    /* renamed from: d */
    public boolean mo10766d() {
        return this.f5632d != null;
    }

    /* renamed from: e */
    public boolean mo10767e() {
        return this.f5639w.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C2071e)) {
            return mo10758a((C2071e) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo10769f() {
        return this.f5634f != null;
    }

    /* renamed from: g */
    public boolean mo10770g() {
        return this.f5635g != null;
    }

    /* renamed from: h */
    public boolean mo10771h() {
        return this.f5636h != null;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean mo10773i() {
        return this.f5637i != null;
    }

    /* renamed from: j */
    public boolean mo10774j() {
        return this.f5638j != null;
    }

    /* renamed from: k */
    public void mo10775k() {
        if (this.f5631c == null) {
            throw new C2181g("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f5632d == null) {
            throw new C2181g("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
        boolean z2 = true;
        if (mo10757a()) {
            sb.append("debug:");
            if (this.f5629a == null) {
                sb.append("null");
            } else {
                sb.append(this.f5629a);
            }
            z2 = false;
        }
        if (mo10761b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f5630b == null) {
                sb.append("null");
            } else {
                sb.append(this.f5630b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f5631c == null) {
            sb.append("null");
        } else {
            sb.append(this.f5631c);
        }
        sb.append(", ");
        sb.append("appId:");
        if (this.f5632d == null) {
            sb.append("null");
        } else {
            sb.append(this.f5632d);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f5633e);
        if (mo10769f()) {
            sb.append(", ");
            sb.append("topic:");
            if (this.f5634f == null) {
                sb.append("null");
            } else {
                sb.append(this.f5634f);
            }
        }
        if (mo10770g()) {
            sb.append(", ");
            sb.append("aliasName:");
            if (this.f5635g == null) {
                sb.append("null");
            } else {
                sb.append(this.f5635g);
            }
        }
        if (mo10771h()) {
            sb.append(", ");
            sb.append("request:");
            if (this.f5636h == null) {
                sb.append("null");
            } else {
                sb.append(this.f5636h);
            }
        }
        if (mo10773i()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f5637i == null) {
                sb.append("null");
            } else {
                sb.append(this.f5637i);
            }
        }
        if (mo10774j()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f5638j == null) {
                sb.append("null");
            } else {
                sb.append(this.f5638j);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
