package com.xiaomi.xmpush.thrift;

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
import org.apache.thrift.protocol.AbstractC2180f;
import org.apache.thrift.protocol.C2177c;
import org.apache.thrift.protocol.C2181g;
import org.apache.thrift.protocol.C2183i;
import org.apache.thrift.protocol.C2185k;

/* renamed from: com.xiaomi.xmpush.thrift.d */
public class C2069d implements Serializable, Cloneable, AbstractC2158b<C2069d, EnumC2070a> {

    /* renamed from: f */
    public static final Map<EnumC2070a, C2167b> f5595f;

    /* renamed from: g */
    private static final C2185k f5596g = new C2185k("Target");

    /* renamed from: h */
    private static final C2177c f5597h = new C2177c("channelId", (byte) 10, 1);

    /* renamed from: i */
    private static final C2177c f5598i = new C2177c("userId", (byte) 11, 2);

    /* renamed from: j */
    private static final C2177c f5599j = new C2177c("server", (byte) 11, 3);

    /* renamed from: k */
    private static final C2177c f5600k = new C2177c("resource", (byte) 11, 4);

    /* renamed from: l */
    private static final C2177c f5601l = new C2177c("isPreview", (byte) 2, 5);

    /* renamed from: a */
    public long f5602a = 5;

    /* renamed from: b */
    public String f5603b;

    /* renamed from: c */
    public String f5604c = "xiaomi.com";

    /* renamed from: d */
    public String f5605d = "";

    /* renamed from: e */
    public boolean f5606e = false;

    /* renamed from: m */
    private BitSet f5607m = new BitSet(2);

    /* renamed from: com.xiaomi.xmpush.thrift.d$a */
    public enum EnumC2070a {
        CHANNEL_ID(1, "channelId"),
        USER_ID(2, "userId"),
        SERVER(3, "server"),
        RESOURCE(4, "resource"),
        IS_PREVIEW(5, "isPreview");
        

        /* renamed from: f */
        private static final Map<String, EnumC2070a> f5613f = new HashMap();

        /* renamed from: g */
        private final short f5615g;

        /* renamed from: h */
        private final String f5616h;

        static {
            Iterator it = EnumSet.allOf(EnumC2070a.class).iterator();
            while (it.hasNext()) {
                EnumC2070a aVar = (EnumC2070a) it.next();
                f5613f.put(aVar.mo10753a(), aVar);
            }
        }

        private EnumC2070a(short s, String str) {
            this.f5615g = s;
            this.f5616h = str;
        }

        /* renamed from: a */
        public String mo10753a() {
            return this.f5616h;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC2070a.class);
        enumMap.put((Object) EnumC2070a.CHANNEL_ID, (Object) new C2167b("channelId", (byte) 1, new C2168c((byte) 10)));
        enumMap.put((Object) EnumC2070a.USER_ID, (Object) new C2167b("userId", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2070a.SERVER, (Object) new C2167b("server", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2070a.RESOURCE, (Object) new C2167b("resource", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2070a.IS_PREVIEW, (Object) new C2167b("isPreview", (byte) 2, new C2168c((byte) 2)));
        f5595f = Collections.unmodifiableMap(enumMap);
        C2167b.m8203a(C2069d.class, f5595f);
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: a */
    public void mo9945a(AbstractC2180f fVar) {
        fVar.mo12145g();
        while (true) {
            C2177c i = fVar.mo12147i();
            if (i.f6210b == 0) {
                fVar.mo12146h();
                if (!mo10740a()) {
                    throw new C2181g("Required field 'channelId' was not found in serialized data! Struct: " + toString());
                }
                mo10750f();
                return;
            }
            switch (i.f6211c) {
                case 1:
                    if (i.f6210b != 10) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5602a = fVar.mo12159u();
                        mo10739a(true);
                        break;
                    }
                case 2:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5603b = fVar.mo12161w();
                        break;
                    }
                case 3:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5604c = fVar.mo12161w();
                        break;
                    }
                case 4:
                    if (i.f6210b != 11) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5605d = fVar.mo12161w();
                        break;
                    }
                case 5:
                    if (i.f6210b != 2) {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    } else {
                        this.f5606e = fVar.mo12155q();
                        mo10743b(true);
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
    public void mo10739a(boolean z) {
        this.f5607m.set(0, z);
    }

    /* renamed from: a */
    public boolean mo10740a() {
        return this.f5607m.get(0);
    }

    /* renamed from: a */
    public boolean mo10741a(C2069d dVar) {
        if (dVar == null || this.f5602a != dVar.f5602a) {
            return false;
        }
        boolean b = mo10744b();
        boolean b2 = dVar.mo10744b();
        if ((b || b2) && (!b || !b2 || !this.f5603b.equals(dVar.f5603b))) {
            return false;
        }
        boolean c = mo10745c();
        boolean c2 = dVar.mo10745c();
        if ((c || c2) && (!c || !c2 || !this.f5604c.equals(dVar.f5604c))) {
            return false;
        }
        boolean d = mo10747d();
        boolean d2 = dVar.mo10747d();
        if ((d || d2) && (!d || !d2 || !this.f5605d.equals(dVar.f5605d))) {
            return false;
        }
        boolean e = mo10748e();
        boolean e2 = dVar.mo10748e();
        return (!e && !e2) || (e && e2 && this.f5606e == dVar.f5606e);
    }

    /* renamed from: b */
    public int compareTo(C2069d dVar) {
        int a;
        int a2;
        int a3;
        int a4;
        int a5;
        if (!getClass().equals(dVar.getClass())) {
            return getClass().getName().compareTo(dVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo10740a()).compareTo(Boolean.valueOf(dVar.mo10740a()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo10740a() && (a5 = C2159c.m8185a(this.f5602a, dVar.f5602a)) != 0) {
            return a5;
        }
        int compareTo2 = Boolean.valueOf(mo10744b()).compareTo(Boolean.valueOf(dVar.mo10744b()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo10744b() && (a4 = C2159c.m8187a(this.f5603b, dVar.f5603b)) != 0) {
            return a4;
        }
        int compareTo3 = Boolean.valueOf(mo10745c()).compareTo(Boolean.valueOf(dVar.mo10745c()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo10745c() && (a3 = C2159c.m8187a(this.f5604c, dVar.f5604c)) != 0) {
            return a3;
        }
        int compareTo4 = Boolean.valueOf(mo10747d()).compareTo(Boolean.valueOf(dVar.mo10747d()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo10747d() && (a2 = C2159c.m8187a(this.f5605d, dVar.f5605d)) != 0) {
            return a2;
        }
        int compareTo5 = Boolean.valueOf(mo10748e()).compareTo(Boolean.valueOf(dVar.mo10748e()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (!mo10748e() || (a = C2159c.m8192a(this.f5606e, dVar.f5606e)) == 0) {
            return 0;
        }
        return a;
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: b */
    public void mo9950b(AbstractC2180f fVar) {
        mo10750f();
        fVar.mo12134a(f5596g);
        fVar.mo12130a(f5597h);
        fVar.mo12127a(this.f5602a);
        fVar.mo12138b();
        if (this.f5603b != null) {
            fVar.mo12130a(f5598i);
            fVar.mo12128a(this.f5603b);
            fVar.mo12138b();
        }
        if (this.f5604c != null && mo10745c()) {
            fVar.mo12130a(f5599j);
            fVar.mo12128a(this.f5604c);
            fVar.mo12138b();
        }
        if (this.f5605d != null && mo10747d()) {
            fVar.mo12130a(f5600k);
            fVar.mo12128a(this.f5605d);
            fVar.mo12138b();
        }
        if (mo10748e()) {
            fVar.mo12130a(f5601l);
            fVar.mo12136a(this.f5606e);
            fVar.mo12138b();
        }
        fVar.mo12139c();
        fVar.mo12124a();
    }

    /* renamed from: b */
    public void mo10743b(boolean z) {
        this.f5607m.set(1, z);
    }

    /* renamed from: b */
    public boolean mo10744b() {
        return this.f5603b != null;
    }

    /* renamed from: c */
    public boolean mo10745c() {
        return this.f5604c != null;
    }

    /* renamed from: d */
    public boolean mo10747d() {
        return this.f5605d != null;
    }

    /* renamed from: e */
    public boolean mo10748e() {
        return this.f5607m.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C2069d)) {
            return mo10741a((C2069d) obj);
        }
        return false;
    }

    /* renamed from: f */
    public void mo10750f() {
        if (this.f5603b == null) {
            throw new C2181g("Required field 'userId' was not present! Struct: " + toString());
        }
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.f5602a);
        sb.append(", ");
        sb.append("userId:");
        if (this.f5603b == null) {
            sb.append("null");
        } else {
            sb.append(this.f5603b);
        }
        if (mo10745c()) {
            sb.append(", ");
            sb.append("server:");
            if (this.f5604c == null) {
                sb.append("null");
            } else {
                sb.append(this.f5604c);
            }
        }
        if (mo10747d()) {
            sb.append(", ");
            sb.append("resource:");
            if (this.f5605d == null) {
                sb.append("null");
            } else {
                sb.append(this.f5605d);
            }
        }
        if (mo10748e()) {
            sb.append(", ");
            sb.append("isPreview:");
            sb.append(this.f5606e);
        }
        sb.append(")");
        return sb.toString();
    }
}
