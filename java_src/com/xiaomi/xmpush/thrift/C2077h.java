package com.xiaomi.xmpush.thrift;

import com.igexin.sdk.PushConsts;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.thrift.AbstractC2158b;
import org.apache.thrift.C2159c;
import org.apache.thrift.meta_data.C2166a;
import org.apache.thrift.meta_data.C2167b;
import org.apache.thrift.meta_data.C2168c;
import org.apache.thrift.meta_data.C2172g;
import org.apache.thrift.protocol.AbstractC2180f;
import org.apache.thrift.protocol.C2177c;
import org.apache.thrift.protocol.C2181g;
import org.apache.thrift.protocol.C2183i;
import org.apache.thrift.protocol.C2185k;
import p000a.p001a.p002a.p004b.C0027o;

/* renamed from: com.xiaomi.xmpush.thrift.h */
public class C2077h implements Serializable, Cloneable, AbstractC2158b<C2077h, EnumC2078a> {

    /* renamed from: i */
    public static final Map<EnumC2078a, C2167b> f5724i;

    /* renamed from: j */
    private static final C2185k f5725j = new C2185k("XmPushActionContainer");

    /* renamed from: k */
    private static final C2177c f5726k = new C2177c(PushConsts.CMD_ACTION, (byte) 8, 1);

    /* renamed from: l */
    private static final C2177c f5727l = new C2177c("encryptAction", (byte) 2, 2);

    /* renamed from: m */
    private static final C2177c f5728m = new C2177c("isRequest", (byte) 2, 3);

    /* renamed from: n */
    private static final C2177c f5729n = new C2177c("pushAction", (byte) 11, 4);

    /* renamed from: o */
    private static final C2177c f5730o = new C2177c("appid", (byte) 11, 5);

    /* renamed from: p */
    private static final C2177c f5731p = new C2177c("packageName", (byte) 11, 6);

    /* renamed from: q */
    private static final C2177c f5732q = new C2177c("target", (byte) 12, 7);

    /* renamed from: r */
    private static final C2177c f5733r = new C2177c("metaInfo", (byte) 12, 8);

    /* renamed from: a */
    public EnumC2064a f5734a;

    /* renamed from: b */
    public boolean f5735b = true;

    /* renamed from: c */
    public boolean f5736c = true;

    /* renamed from: d */
    public ByteBuffer f5737d;

    /* renamed from: e */
    public String f5738e;

    /* renamed from: f */
    public String f5739f;

    /* renamed from: g */
    public C2069d f5740g;

    /* renamed from: h */
    public C2067c f5741h;

    /* renamed from: s */
    private BitSet f5742s = new BitSet(2);

    /* renamed from: com.xiaomi.xmpush.thrift.h$a */
    public enum EnumC2078a {
        ACTION(1, PushConsts.CMD_ACTION),
        ENCRYPT_ACTION(2, "encryptAction"),
        IS_REQUEST(3, "isRequest"),
        PUSH_ACTION(4, "pushAction"),
        APPID(5, "appid"),
        PACKAGE_NAME(6, "packageName"),
        TARGET(7, "target"),
        META_INFO(8, "metaInfo");
        

        /* renamed from: i */
        private static final Map<String, EnumC2078a> f5751i = new HashMap();

        /* renamed from: j */
        private final short f5753j;

        /* renamed from: k */
        private final String f5754k;

        static {
            Iterator it = EnumSet.allOf(EnumC2078a.class).iterator();
            while (it.hasNext()) {
                EnumC2078a aVar = (EnumC2078a) it.next();
                f5751i.put(aVar.mo10854a(), aVar);
            }
        }

        private EnumC2078a(short s, String str) {
            this.f5753j = s;
            this.f5754k = str;
        }

        /* renamed from: a */
        public String mo10854a() {
            return this.f5754k;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC2078a.class);
        enumMap.put((Object) EnumC2078a.ACTION, (Object) new C2167b(PushConsts.CMD_ACTION, (byte) 1, new C2166a(C0027o.f105n, EnumC2064a.class)));
        enumMap.put((Object) EnumC2078a.ENCRYPT_ACTION, (Object) new C2167b("encryptAction", (byte) 1, new C2168c((byte) 2)));
        enumMap.put((Object) EnumC2078a.IS_REQUEST, (Object) new C2167b("isRequest", (byte) 1, new C2168c((byte) 2)));
        enumMap.put((Object) EnumC2078a.PUSH_ACTION, (Object) new C2167b("pushAction", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2078a.APPID, (Object) new C2167b("appid", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2078a.PACKAGE_NAME, (Object) new C2167b("packageName", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2078a.TARGET, (Object) new C2167b("target", (byte) 1, new C2172g((byte) 12, C2069d.class)));
        enumMap.put((Object) EnumC2078a.META_INFO, (Object) new C2167b("metaInfo", (byte) 2, new C2172g((byte) 12, C2067c.class)));
        f5724i = Collections.unmodifiableMap(enumMap);
        C2167b.m8203a(C2077h.class, f5724i);
    }

    /* renamed from: a */
    public EnumC2064a mo10823a() {
        return this.f5734a;
    }

    /* renamed from: a */
    public C2077h mo10824a(EnumC2064a aVar) {
        this.f5734a = aVar;
        return this;
    }

    /* renamed from: a */
    public C2077h mo10825a(C2067c cVar) {
        this.f5741h = cVar;
        return this;
    }

    /* renamed from: a */
    public C2077h mo10826a(C2069d dVar) {
        this.f5740g = dVar;
        return this;
    }

    /* renamed from: a */
    public C2077h mo10827a(String str) {
        this.f5738e = str;
        return this;
    }

    /* renamed from: a */
    public C2077h mo10828a(ByteBuffer byteBuffer) {
        this.f5737d = byteBuffer;
        return this;
    }

    /* renamed from: a */
    public C2077h mo10829a(boolean z) {
        this.f5735b = z;
        mo10833b(true);
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
                if (!mo10839d()) {
                    throw new C2181g("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                } else if (!mo10840e()) {
                    throw new C2181g("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                } else {
                    mo10852o();
                    return;
                }
            } else {
                switch (i.f6211c) {
                    case 1:
                        if (i.f6210b != 8) {
                            C2183i.m8338a(fVar, i.f6210b);
                            break;
                        } else {
                            this.f5734a = EnumC2064a.m7770a(fVar.mo12158t());
                            break;
                        }
                    case 2:
                        if (i.f6210b != 2) {
                            C2183i.m8338a(fVar, i.f6210b);
                            break;
                        } else {
                            this.f5735b = fVar.mo12155q();
                            mo10833b(true);
                            break;
                        }
                    case 3:
                        if (i.f6210b != 2) {
                            C2183i.m8338a(fVar, i.f6210b);
                            break;
                        } else {
                            this.f5736c = fVar.mo12155q();
                            mo10838d(true);
                            break;
                        }
                    case 4:
                        if (i.f6210b != 11) {
                            C2183i.m8338a(fVar, i.f6210b);
                            break;
                        } else {
                            this.f5737d = fVar.mo12162x();
                            break;
                        }
                    case 5:
                        if (i.f6210b != 11) {
                            C2183i.m8338a(fVar, i.f6210b);
                            break;
                        } else {
                            this.f5738e = fVar.mo12161w();
                            break;
                        }
                    case 6:
                        if (i.f6210b != 11) {
                            C2183i.m8338a(fVar, i.f6210b);
                            break;
                        } else {
                            this.f5739f = fVar.mo12161w();
                            break;
                        }
                    case 7:
                        if (i.f6210b != 12) {
                            C2183i.m8338a(fVar, i.f6210b);
                            break;
                        } else {
                            this.f5740g = new C2069d();
                            this.f5740g.mo9945a(fVar);
                            break;
                        }
                    case 8:
                        if (i.f6210b != 12) {
                            C2183i.m8338a(fVar, i.f6210b);
                            break;
                        } else {
                            this.f5741h = new C2067c();
                            this.f5741h.mo9945a(fVar);
                            break;
                        }
                    default:
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                }
                fVar.mo12148j();
            }
        }
    }

    /* renamed from: a */
    public boolean mo10830a(C2077h hVar) {
        if (hVar == null) {
            return false;
        }
        boolean b = mo10834b();
        boolean b2 = hVar.mo10834b();
        if (((b || b2) && (!b || !b2 || !this.f5734a.equals(hVar.f5734a))) || this.f5735b != hVar.f5735b || this.f5736c != hVar.f5736c) {
            return false;
        }
        boolean g = mo10843g();
        boolean g2 = hVar.mo10843g();
        if ((g || g2) && (!g || !g2 || !this.f5737d.equals(hVar.f5737d))) {
            return false;
        }
        boolean i = mo10846i();
        boolean i2 = hVar.mo10846i();
        if ((i || i2) && (!i || !i2 || !this.f5738e.equals(hVar.f5738e))) {
            return false;
        }
        boolean k = mo10848k();
        boolean k2 = hVar.mo10848k();
        if ((k || k2) && (!k || !k2 || !this.f5739f.equals(hVar.f5739f))) {
            return false;
        }
        boolean l = mo10849l();
        boolean l2 = hVar.mo10849l();
        if ((l || l2) && (!l || !l2 || !this.f5740g.mo10741a(hVar.f5740g))) {
            return false;
        }
        boolean n = mo10851n();
        boolean n2 = hVar.mo10851n();
        return (!n && !n2) || (n && n2 && this.f5741h.mo10700a(hVar.f5741h));
    }

    /* renamed from: b */
    public int compareTo(C2077h hVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (!getClass().equals(hVar.getClass())) {
            return getClass().getName().compareTo(hVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo10834b()).compareTo(Boolean.valueOf(hVar.mo10834b()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo10834b() && (a8 = C2159c.m8186a(this.f5734a, hVar.f5734a)) != 0) {
            return a8;
        }
        int compareTo2 = Boolean.valueOf(mo10839d()).compareTo(Boolean.valueOf(hVar.mo10839d()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo10839d() && (a7 = C2159c.m8192a(this.f5735b, hVar.f5735b)) != 0) {
            return a7;
        }
        int compareTo3 = Boolean.valueOf(mo10840e()).compareTo(Boolean.valueOf(hVar.mo10840e()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo10840e() && (a6 = C2159c.m8192a(this.f5736c, hVar.f5736c)) != 0) {
            return a6;
        }
        int compareTo4 = Boolean.valueOf(mo10843g()).compareTo(Boolean.valueOf(hVar.mo10843g()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo10843g() && (a5 = C2159c.m8186a(this.f5737d, hVar.f5737d)) != 0) {
            return a5;
        }
        int compareTo5 = Boolean.valueOf(mo10846i()).compareTo(Boolean.valueOf(hVar.mo10846i()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo10846i() && (a4 = C2159c.m8187a(this.f5738e, hVar.f5738e)) != 0) {
            return a4;
        }
        int compareTo6 = Boolean.valueOf(mo10848k()).compareTo(Boolean.valueOf(hVar.mo10848k()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo10848k() && (a3 = C2159c.m8187a(this.f5739f, hVar.f5739f)) != 0) {
            return a3;
        }
        int compareTo7 = Boolean.valueOf(mo10849l()).compareTo(Boolean.valueOf(hVar.mo10849l()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo10849l() && (a2 = C2159c.m8186a(this.f5740g, hVar.f5740g)) != 0) {
            return a2;
        }
        int compareTo8 = Boolean.valueOf(mo10851n()).compareTo(Boolean.valueOf(hVar.mo10851n()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (!mo10851n() || (a = C2159c.m8186a(this.f5741h, hVar.f5741h)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: b */
    public C2077h mo10832b(String str) {
        this.f5739f = str;
        return this;
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: b */
    public void mo9950b(AbstractC2180f fVar) {
        mo10852o();
        fVar.mo12134a(f5725j);
        if (this.f5734a != null) {
            fVar.mo12130a(f5726k);
            fVar.mo12126a(this.f5734a.mo10671a());
            fVar.mo12138b();
        }
        fVar.mo12130a(f5727l);
        fVar.mo12136a(this.f5735b);
        fVar.mo12138b();
        fVar.mo12130a(f5728m);
        fVar.mo12136a(this.f5736c);
        fVar.mo12138b();
        if (this.f5737d != null) {
            fVar.mo12130a(f5729n);
            fVar.mo12129a(this.f5737d);
            fVar.mo12138b();
        }
        if (this.f5738e != null && mo10846i()) {
            fVar.mo12130a(f5730o);
            fVar.mo12128a(this.f5738e);
            fVar.mo12138b();
        }
        if (this.f5739f != null && mo10848k()) {
            fVar.mo12130a(f5731p);
            fVar.mo12128a(this.f5739f);
            fVar.mo12138b();
        }
        if (this.f5740g != null) {
            fVar.mo12130a(f5732q);
            this.f5740g.mo9950b(fVar);
            fVar.mo12138b();
        }
        if (this.f5741h != null && mo10851n()) {
            fVar.mo12130a(f5733r);
            this.f5741h.mo9950b(fVar);
            fVar.mo12138b();
        }
        fVar.mo12139c();
        fVar.mo12124a();
    }

    /* renamed from: b */
    public void mo10833b(boolean z) {
        this.f5742s.set(0, z);
    }

    /* renamed from: b */
    public boolean mo10834b() {
        return this.f5734a != null;
    }

    /* renamed from: c */
    public C2077h mo10835c(boolean z) {
        this.f5736c = z;
        mo10838d(true);
        return this;
    }

    /* renamed from: c */
    public boolean mo10836c() {
        return this.f5735b;
    }

    /* renamed from: d */
    public void mo10838d(boolean z) {
        this.f5742s.set(1, z);
    }

    /* renamed from: d */
    public boolean mo10839d() {
        return this.f5742s.get(0);
    }

    /* renamed from: e */
    public boolean mo10840e() {
        return this.f5742s.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C2077h)) {
            return mo10830a((C2077h) obj);
        }
        return false;
    }

    /* renamed from: f */
    public byte[] mo10842f() {
        mo10828a(C2159c.m8198c(this.f5737d));
        return this.f5737d.array();
    }

    /* renamed from: g */
    public boolean mo10843g() {
        return this.f5737d != null;
    }

    /* renamed from: h */
    public String mo10844h() {
        return this.f5738e;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean mo10846i() {
        return this.f5738e != null;
    }

    /* renamed from: j */
    public String mo10847j() {
        return this.f5739f;
    }

    /* renamed from: k */
    public boolean mo10848k() {
        return this.f5739f != null;
    }

    /* renamed from: l */
    public boolean mo10849l() {
        return this.f5740g != null;
    }

    /* renamed from: m */
    public C2067c mo10850m() {
        return this.f5741h;
    }

    /* renamed from: n */
    public boolean mo10851n() {
        return this.f5741h != null;
    }

    /* renamed from: o */
    public void mo10852o() {
        if (this.f5734a == null) {
            throw new C2181g("Required field 'action' was not present! Struct: " + toString());
        } else if (this.f5737d == null) {
            throw new C2181g("Required field 'pushAction' was not present! Struct: " + toString());
        } else if (this.f5740g == null) {
            throw new C2181g("Required field 'target' was not present! Struct: " + toString());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        if (this.f5734a == null) {
            sb.append("null");
        } else {
            sb.append(this.f5734a);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.f5735b);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.f5736c);
        sb.append(", ");
        sb.append("pushAction:");
        if (this.f5737d == null) {
            sb.append("null");
        } else {
            C2159c.m8195a(this.f5737d, sb);
        }
        if (mo10846i()) {
            sb.append(", ");
            sb.append("appid:");
            if (this.f5738e == null) {
                sb.append("null");
            } else {
                sb.append(this.f5738e);
            }
        }
        if (mo10848k()) {
            sb.append(", ");
            sb.append("packageName:");
            if (this.f5739f == null) {
                sb.append("null");
            } else {
                sb.append(this.f5739f);
            }
        }
        sb.append(", ");
        sb.append("target:");
        if (this.f5740g == null) {
            sb.append("null");
        } else {
            sb.append(this.f5740g);
        }
        if (mo10851n()) {
            sb.append(", ");
            sb.append("metaInfo:");
            if (this.f5741h == null) {
                sb.append("null");
            } else {
                sb.append(this.f5741h);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
