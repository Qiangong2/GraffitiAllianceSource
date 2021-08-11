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
import org.apache.thrift.meta_data.C2170e;
import org.apache.thrift.meta_data.C2172g;
import org.apache.thrift.protocol.AbstractC2180f;
import org.apache.thrift.protocol.C2177c;
import org.apache.thrift.protocol.C2179e;
import org.apache.thrift.protocol.C2181g;
import org.apache.thrift.protocol.C2183i;
import org.apache.thrift.protocol.C2185k;

/* renamed from: com.xiaomi.xmpush.thrift.i */
public class C2079i implements Serializable, Cloneable, AbstractC2158b<C2079i, EnumC2080a> {

    /* renamed from: k */
    public static final Map<EnumC2080a, C2167b> f5755k;

    /* renamed from: l */
    private static final C2185k f5756l = new C2185k("XmPushActionNotification");

    /* renamed from: m */
    private static final C2177c f5757m = new C2177c("debug", (byte) 11, 1);

    /* renamed from: n */
    private static final C2177c f5758n = new C2177c("target", (byte) 12, 2);

    /* renamed from: o */
    private static final C2177c f5759o = new C2177c("id", (byte) 11, 3);

    /* renamed from: p */
    private static final C2177c f5760p = new C2177c(AppState.APP_ID, (byte) 11, 4);

    /* renamed from: q */
    private static final C2177c f5761q = new C2177c("type", (byte) 11, 5);

    /* renamed from: r */
    private static final C2177c f5762r = new C2177c("requireAck", (byte) 2, 6);

    /* renamed from: s */
    private static final C2177c f5763s = new C2177c(AssistPushConsts.MSG_TYPE_PAYLOAD, (byte) 11, 7);

    /* renamed from: t */
    private static final C2177c f5764t = new C2177c("extra", (byte) 13, 8);

    /* renamed from: u */
    private static final C2177c f5765u = new C2177c("packageName", (byte) 11, 9);

    /* renamed from: v */
    private static final C2177c f5766v = new C2177c("category", (byte) 11, 10);

    /* renamed from: a */
    public String f5767a;

    /* renamed from: b */
    public C2069d f5768b;

    /* renamed from: c */
    public String f5769c;

    /* renamed from: d */
    public String f5770d;

    /* renamed from: e */
    public String f5771e;

    /* renamed from: f */
    public boolean f5772f = true;

    /* renamed from: g */
    public String f5773g;

    /* renamed from: h */
    public Map<String, String> f5774h;

    /* renamed from: i */
    public String f5775i;

    /* renamed from: j */
    public String f5776j;

    /* renamed from: w */
    private BitSet f5777w = new BitSet(1);

    /* renamed from: com.xiaomi.xmpush.thrift.i$a */
    public enum EnumC2080a {
        DEBUG(1, "debug"),
        TARGET(2, "target"),
        ID(3, "id"),
        APP_ID(4, AppState.APP_ID),
        TYPE(5, "type"),
        REQUIRE_ACK(6, "requireAck"),
        PAYLOAD(7, AssistPushConsts.MSG_TYPE_PAYLOAD),
        EXTRA(8, "extra"),
        PACKAGE_NAME(9, "packageName"),
        CATEGORY(10, "category");
        

        /* renamed from: k */
        private static final Map<String, EnumC2080a> f5788k = new HashMap();

        /* renamed from: l */
        private final short f5790l;

        /* renamed from: m */
        private final String f5791m;

        static {
            Iterator it = EnumSet.allOf(EnumC2080a.class).iterator();
            while (it.hasNext()) {
                EnumC2080a aVar = (EnumC2080a) it.next();
                f5788k.put(aVar.mo10879a(), aVar);
            }
        }

        private EnumC2080a(short s, String str) {
            this.f5790l = s;
            this.f5791m = str;
        }

        /* renamed from: a */
        public String mo10879a() {
            return this.f5791m;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC2080a.class);
        enumMap.put((Object) EnumC2080a.DEBUG, (Object) new C2167b("debug", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2080a.TARGET, (Object) new C2167b("target", (byte) 2, new C2172g((byte) 12, C2069d.class)));
        enumMap.put((Object) EnumC2080a.ID, (Object) new C2167b("id", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2080a.APP_ID, (Object) new C2167b(AppState.APP_ID, (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2080a.TYPE, (Object) new C2167b("type", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2080a.REQUIRE_ACK, (Object) new C2167b("requireAck", (byte) 1, new C2168c((byte) 2)));
        enumMap.put((Object) EnumC2080a.PAYLOAD, (Object) new C2167b(AssistPushConsts.MSG_TYPE_PAYLOAD, (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2080a.EXTRA, (Object) new C2167b("extra", (byte) 2, new C2170e((byte) 13, new C2168c((byte) 11), new C2168c((byte) 11))));
        enumMap.put((Object) EnumC2080a.PACKAGE_NAME, (Object) new C2167b("packageName", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2080a.CATEGORY, (Object) new C2167b("category", (byte) 2, new C2168c((byte) 11)));
        f5755k = Collections.unmodifiableMap(enumMap);
        C2167b.m8203a(C2079i.class, f5755k);
    }

    /* renamed from: a */
    public C2079i mo10855a(String str) {
        this.f5769c = str;
        return this;
    }

    /* renamed from: a */
    public C2079i mo10856a(Map<String, String> map) {
        this.f5774h = map;
        return this;
    }

    /* renamed from: a */
    public C2079i mo10857a(boolean z) {
        this.f5772f = z;
        mo10862b(true);
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
                if (!mo10870f()) {
                    throw new C2181g("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
                }
                mo10877l();
                return;
            }
            switch (i.f6211c) {
                case 1:
                    if (i.f6210b == 11) {
                        this.f5767a = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 2:
                    if (i.f6210b == 12) {
                        this.f5768b = new C2069d();
                        this.f5768b.mo9945a(fVar);
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 3:
                    if (i.f6210b == 11) {
                        this.f5769c = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 4:
                    if (i.f6210b == 11) {
                        this.f5770d = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 5:
                    if (i.f6210b == 11) {
                        this.f5771e = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 6:
                    if (i.f6210b == 2) {
                        this.f5772f = fVar.mo12155q();
                        mo10862b(true);
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 7:
                    if (i.f6210b == 11) {
                        this.f5773g = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 8:
                    if (i.f6210b == 13) {
                        C2179e k = fVar.mo12149k();
                        this.f5774h = new HashMap(k.f6216c * 2);
                        for (int i2 = 0; i2 < k.f6216c; i2++) {
                            this.f5774h.put(fVar.mo12161w(), fVar.mo12161w());
                        }
                        fVar.mo12150l();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 9:
                    if (i.f6210b == 11) {
                        this.f5775i = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 10:
                    if (i.f6210b == 11) {
                        this.f5776j = fVar.mo12161w();
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
    public boolean mo10858a() {
        return this.f5767a != null;
    }

    /* renamed from: a */
    public boolean mo10859a(C2079i iVar) {
        if (iVar == null) {
            return false;
        }
        boolean a = mo10858a();
        boolean a2 = iVar.mo10858a();
        if ((a || a2) && (!a || !a2 || !this.f5767a.equals(iVar.f5767a))) {
            return false;
        }
        boolean b = mo10863b();
        boolean b2 = iVar.mo10863b();
        if ((b || b2) && (!b || !b2 || !this.f5768b.mo10741a(iVar.f5768b))) {
            return false;
        }
        boolean c = mo10865c();
        boolean c2 = iVar.mo10865c();
        if ((c || c2) && (!c || !c2 || !this.f5769c.equals(iVar.f5769c))) {
            return false;
        }
        boolean d = mo10867d();
        boolean d2 = iVar.mo10867d();
        if ((d || d2) && (!d || !d2 || !this.f5770d.equals(iVar.f5770d))) {
            return false;
        }
        boolean e = mo10868e();
        boolean e2 = iVar.mo10868e();
        if (((e || e2) && (!e || !e2 || !this.f5771e.equals(iVar.f5771e))) || this.f5772f != iVar.f5772f) {
            return false;
        }
        boolean g = mo10871g();
        boolean g2 = iVar.mo10871g();
        if ((g || g2) && (!g || !g2 || !this.f5773g.equals(iVar.f5773g))) {
            return false;
        }
        boolean i = mo10874i();
        boolean i2 = iVar.mo10874i();
        if ((i || i2) && (!i || !i2 || !this.f5774h.equals(iVar.f5774h))) {
            return false;
        }
        boolean j = mo10875j();
        boolean j2 = iVar.mo10875j();
        if ((j || j2) && (!j || !j2 || !this.f5775i.equals(iVar.f5775i))) {
            return false;
        }
        boolean k = mo10876k();
        boolean k2 = iVar.mo10876k();
        return (!k && !k2) || (k && k2 && this.f5776j.equals(iVar.f5776j));
    }

    /* renamed from: b */
    public int compareTo(C2079i iVar) {
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
        if (!getClass().equals(iVar.getClass())) {
            return getClass().getName().compareTo(iVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo10858a()).compareTo(Boolean.valueOf(iVar.mo10858a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo10858a() && (a10 = C2159c.m8187a(this.f5767a, iVar.f5767a)) != 0) {
            return a10;
        }
        int compareTo2 = Boolean.valueOf(mo10863b()).compareTo(Boolean.valueOf(iVar.mo10863b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo10863b() && (a9 = C2159c.m8186a(this.f5768b, iVar.f5768b)) != 0) {
            return a9;
        }
        int compareTo3 = Boolean.valueOf(mo10865c()).compareTo(Boolean.valueOf(iVar.mo10865c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo10865c() && (a8 = C2159c.m8187a(this.f5769c, iVar.f5769c)) != 0) {
            return a8;
        }
        int compareTo4 = Boolean.valueOf(mo10867d()).compareTo(Boolean.valueOf(iVar.mo10867d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo10867d() && (a7 = C2159c.m8187a(this.f5770d, iVar.f5770d)) != 0) {
            return a7;
        }
        int compareTo5 = Boolean.valueOf(mo10868e()).compareTo(Boolean.valueOf(iVar.mo10868e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo10868e() && (a6 = C2159c.m8187a(this.f5771e, iVar.f5771e)) != 0) {
            return a6;
        }
        int compareTo6 = Boolean.valueOf(mo10870f()).compareTo(Boolean.valueOf(iVar.mo10870f()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo10870f() && (a5 = C2159c.m8192a(this.f5772f, iVar.f5772f)) != 0) {
            return a5;
        }
        int compareTo7 = Boolean.valueOf(mo10871g()).compareTo(Boolean.valueOf(iVar.mo10871g()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo10871g() && (a4 = C2159c.m8187a(this.f5773g, iVar.f5773g)) != 0) {
            return a4;
        }
        int compareTo8 = Boolean.valueOf(mo10874i()).compareTo(Boolean.valueOf(iVar.mo10874i()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (mo10874i() && (a3 = C2159c.m8190a(this.f5774h, iVar.f5774h)) != 0) {
            return a3;
        }
        int compareTo9 = Boolean.valueOf(mo10875j()).compareTo(Boolean.valueOf(iVar.mo10875j()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (mo10875j() && (a2 = C2159c.m8187a(this.f5775i, iVar.f5775i)) != 0) {
            return a2;
        }
        int compareTo10 = Boolean.valueOf(mo10876k()).compareTo(Boolean.valueOf(iVar.mo10876k()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (!mo10876k() || (a = C2159c.m8187a(this.f5776j, iVar.f5776j)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: b */
    public C2079i mo10861b(String str) {
        this.f5770d = str;
        return this;
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: b */
    public void mo9950b(AbstractC2180f fVar) {
        mo10877l();
        fVar.mo12134a(f5756l);
        if (this.f5767a != null && mo10858a()) {
            fVar.mo12130a(f5757m);
            fVar.mo12128a(this.f5767a);
            fVar.mo12138b();
        }
        if (this.f5768b != null && mo10863b()) {
            fVar.mo12130a(f5758n);
            this.f5768b.mo9950b(fVar);
            fVar.mo12138b();
        }
        if (this.f5769c != null) {
            fVar.mo12130a(f5759o);
            fVar.mo12128a(this.f5769c);
            fVar.mo12138b();
        }
        if (this.f5770d != null && mo10867d()) {
            fVar.mo12130a(f5760p);
            fVar.mo12128a(this.f5770d);
            fVar.mo12138b();
        }
        if (this.f5771e != null && mo10868e()) {
            fVar.mo12130a(f5761q);
            fVar.mo12128a(this.f5771e);
            fVar.mo12138b();
        }
        fVar.mo12130a(f5762r);
        fVar.mo12136a(this.f5772f);
        fVar.mo12138b();
        if (this.f5773g != null && mo10871g()) {
            fVar.mo12130a(f5763s);
            fVar.mo12128a(this.f5773g);
            fVar.mo12138b();
        }
        if (this.f5774h != null && mo10874i()) {
            fVar.mo12130a(f5764t);
            fVar.mo12132a(new C2179e((byte) 11, (byte) 11, this.f5774h.size()));
            for (Map.Entry<String, String> entry : this.f5774h.entrySet()) {
                fVar.mo12128a(entry.getKey());
                fVar.mo12128a(entry.getValue());
            }
            fVar.mo12141d();
            fVar.mo12138b();
        }
        if (this.f5775i != null && mo10875j()) {
            fVar.mo12130a(f5765u);
            fVar.mo12128a(this.f5775i);
            fVar.mo12138b();
        }
        if (this.f5776j != null && mo10876k()) {
            fVar.mo12130a(f5766v);
            fVar.mo12128a(this.f5776j);
            fVar.mo12138b();
        }
        fVar.mo12139c();
        fVar.mo12124a();
    }

    /* renamed from: b */
    public void mo10862b(boolean z) {
        this.f5777w.set(0, z);
    }

    /* renamed from: b */
    public boolean mo10863b() {
        return this.f5768b != null;
    }

    /* renamed from: c */
    public C2079i mo10864c(String str) {
        this.f5771e = str;
        return this;
    }

    /* renamed from: c */
    public boolean mo10865c() {
        return this.f5769c != null;
    }

    /* renamed from: d */
    public boolean mo10867d() {
        return this.f5770d != null;
    }

    /* renamed from: e */
    public boolean mo10868e() {
        return this.f5771e != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C2079i)) {
            return mo10859a((C2079i) obj);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo10870f() {
        return this.f5777w.get(0);
    }

    /* renamed from: g */
    public boolean mo10871g() {
        return this.f5773g != null;
    }

    /* renamed from: h */
    public Map<String, String> mo10872h() {
        return this.f5774h;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean mo10874i() {
        return this.f5774h != null;
    }

    /* renamed from: j */
    public boolean mo10875j() {
        return this.f5775i != null;
    }

    /* renamed from: k */
    public boolean mo10876k() {
        return this.f5776j != null;
    }

    /* renamed from: l */
    public void mo10877l() {
        if (this.f5769c == null) {
            throw new C2181g("Required field 'id' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        boolean z = false;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        boolean z2 = true;
        if (mo10858a()) {
            sb.append("debug:");
            if (this.f5767a == null) {
                sb.append("null");
            } else {
                sb.append(this.f5767a);
            }
            z2 = false;
        }
        if (mo10863b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            if (this.f5768b == null) {
                sb.append("null");
            } else {
                sb.append(this.f5768b);
            }
        } else {
            z = z2;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        if (this.f5769c == null) {
            sb.append("null");
        } else {
            sb.append(this.f5769c);
        }
        if (mo10867d()) {
            sb.append(", ");
            sb.append("appId:");
            if (this.f5770d == null) {
                sb.append("null");
            } else {
                sb.append(this.f5770d);
            }
        }
        if (mo10868e()) {
            sb.append(", ");
            sb.append("type:");
            if (this.f5771e == null) {
                sb.append("null");
            } else {
                sb.append(this.f5771e);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f5772f);
        if (mo10871g()) {
            sb.append(", ");
            sb.append("payload:");
            if (this.f5773g == null) {
                sb.append("null");
            } else {
                sb.append(this.f5773g);
            }
        }
        if (mo10874i()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f5774h == null) {
                sb.append("null");
            } else {
                sb.append(this.f5774h);
            }
        }
        if (mo10875j()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f5775i == null) {
                sb.append("null");
            } else {
                sb.append(this.f5775i);
            }
        }
        if (mo10876k()) {
            sb.append(", ");
            sb.append("category:");
            if (this.f5776j == null) {
                sb.append("null");
            } else {
                sb.append(this.f5776j);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
