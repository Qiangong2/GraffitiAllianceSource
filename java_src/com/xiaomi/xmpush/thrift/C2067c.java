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
import org.apache.thrift.meta_data.C2170e;
import org.apache.thrift.protocol.AbstractC2180f;
import org.apache.thrift.protocol.C2177c;
import org.apache.thrift.protocol.C2179e;
import org.apache.thrift.protocol.C2181g;
import org.apache.thrift.protocol.C2183i;
import org.apache.thrift.protocol.C2185k;

/* renamed from: com.xiaomi.xmpush.thrift.c */
public class C2067c implements Serializable, Cloneable, AbstractC2158b<C2067c, EnumC2068a> {

    /* renamed from: m */
    public static final Map<EnumC2068a, C2167b> f5552m;

    /* renamed from: n */
    private static final C2185k f5553n = new C2185k("PushMetaInfo");

    /* renamed from: o */
    private static final C2177c f5554o = new C2177c("id", (byte) 11, 1);

    /* renamed from: p */
    private static final C2177c f5555p = new C2177c("messageTs", (byte) 10, 2);

    /* renamed from: q */
    private static final C2177c f5556q = new C2177c("topic", (byte) 11, 3);

    /* renamed from: r */
    private static final C2177c f5557r = new C2177c("title", (byte) 11, 4);

    /* renamed from: s */
    private static final C2177c f5558s = new C2177c("description", (byte) 11, 5);

    /* renamed from: t */
    private static final C2177c f5559t = new C2177c("notifyType", (byte) 8, 6);

    /* renamed from: u */
    private static final C2177c f5560u = new C2177c("url", (byte) 11, 7);

    /* renamed from: v */
    private static final C2177c f5561v = new C2177c("passThrough", (byte) 8, 8);

    /* renamed from: w */
    private static final C2177c f5562w = new C2177c("notifyId", (byte) 8, 9);

    /* renamed from: x */
    private static final C2177c f5563x = new C2177c("extra", (byte) 13, 10);

    /* renamed from: y */
    private static final C2177c f5564y = new C2177c("internal", (byte) 13, 11);

    /* renamed from: z */
    private static final C2177c f5565z = new C2177c("ignoreRegInfo", (byte) 2, 12);

    /* renamed from: A */
    private BitSet f5566A;

    /* renamed from: a */
    public String f5567a;

    /* renamed from: b */
    public long f5568b;

    /* renamed from: c */
    public String f5569c;

    /* renamed from: d */
    public String f5570d;

    /* renamed from: e */
    public String f5571e;

    /* renamed from: f */
    public int f5572f;

    /* renamed from: g */
    public String f5573g;

    /* renamed from: h */
    public int f5574h;

    /* renamed from: i */
    public int f5575i;

    /* renamed from: j */
    public Map<String, String> f5576j;

    /* renamed from: k */
    public Map<String, String> f5577k;

    /* renamed from: l */
    public boolean f5578l;

    /* renamed from: com.xiaomi.xmpush.thrift.c$a */
    public enum EnumC2068a {
        ID(1, "id"),
        MESSAGE_TS(2, "messageTs"),
        TOPIC(3, "topic"),
        TITLE(4, "title"),
        DESCRIPTION(5, "description"),
        NOTIFY_TYPE(6, "notifyType"),
        URL(7, "url"),
        PASS_THROUGH(8, "passThrough"),
        NOTIFY_ID(9, "notifyId"),
        EXTRA(10, "extra"),
        INTERNAL(11, "internal"),
        IGNORE_REG_INFO(12, "ignoreRegInfo");
        

        /* renamed from: m */
        private static final Map<String, EnumC2068a> f5591m = new HashMap();

        /* renamed from: n */
        private final short f5593n;

        /* renamed from: o */
        private final String f5594o;

        static {
            Iterator it = EnumSet.allOf(EnumC2068a.class).iterator();
            while (it.hasNext()) {
                EnumC2068a aVar = (EnumC2068a) it.next();
                f5591m.put(aVar.mo10738a(), aVar);
            }
        }

        private EnumC2068a(short s, String str) {
            this.f5593n = s;
            this.f5594o = str;
        }

        /* renamed from: a */
        public String mo10738a() {
            return this.f5594o;
        }
    }

    static {
        EnumMap enumMap = new EnumMap(EnumC2068a.class);
        enumMap.put((Object) EnumC2068a.ID, (Object) new C2167b("id", (byte) 1, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2068a.MESSAGE_TS, (Object) new C2167b("messageTs", (byte) 1, new C2168c((byte) 10)));
        enumMap.put((Object) EnumC2068a.TOPIC, (Object) new C2167b("topic", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2068a.TITLE, (Object) new C2167b("title", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2068a.DESCRIPTION, (Object) new C2167b("description", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2068a.NOTIFY_TYPE, (Object) new C2167b("notifyType", (byte) 2, new C2168c((byte) 8)));
        enumMap.put((Object) EnumC2068a.URL, (Object) new C2167b("url", (byte) 2, new C2168c((byte) 11)));
        enumMap.put((Object) EnumC2068a.PASS_THROUGH, (Object) new C2167b("passThrough", (byte) 2, new C2168c((byte) 8)));
        enumMap.put((Object) EnumC2068a.NOTIFY_ID, (Object) new C2167b("notifyId", (byte) 2, new C2168c((byte) 8)));
        enumMap.put((Object) EnumC2068a.EXTRA, (Object) new C2167b("extra", (byte) 2, new C2170e((byte) 13, new C2168c((byte) 11), new C2168c((byte) 11))));
        enumMap.put((Object) EnumC2068a.INTERNAL, (Object) new C2167b("internal", (byte) 2, new C2170e((byte) 13, new C2168c((byte) 11), new C2168c((byte) 11))));
        enumMap.put((Object) EnumC2068a.IGNORE_REG_INFO, (Object) new C2167b("ignoreRegInfo", (byte) 2, new C2168c((byte) 2)));
        f5552m = Collections.unmodifiableMap(enumMap);
        C2167b.m8203a(C2067c.class, f5552m);
    }

    public C2067c() {
        this.f5566A = new BitSet(5);
        this.f5578l = false;
    }

    public C2067c(C2067c cVar) {
        this.f5566A = new BitSet(5);
        this.f5566A.clear();
        this.f5566A.or(cVar.f5566A);
        if (cVar.mo10709c()) {
            this.f5567a = cVar.f5567a;
        }
        this.f5568b = cVar.f5568b;
        if (cVar.mo10718g()) {
            this.f5569c = cVar.f5569c;
        }
        if (cVar.mo10721i()) {
            this.f5570d = cVar.f5570d;
        }
        if (cVar.mo10723k()) {
            this.f5571e = cVar.f5571e;
        }
        this.f5572f = cVar.f5572f;
        if (cVar.mo10726n()) {
            this.f5573g = cVar.f5573g;
        }
        this.f5574h = cVar.f5574h;
        this.f5575i = cVar.f5575i;
        if (cVar.mo10732t()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : cVar.f5576j.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f5576j = hashMap;
        }
        if (cVar.mo10734u()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : cVar.f5577k.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f5577k = hashMap2;
        }
        this.f5578l = cVar.f5578l;
    }

    /* renamed from: a */
    public C2067c mo10694a() {
        return new C2067c(this);
    }

    /* renamed from: a */
    public C2067c mo10695a(int i) {
        this.f5572f = i;
        mo10705b(true);
        return this;
    }

    /* renamed from: a */
    public C2067c mo10696a(String str) {
        this.f5567a = str;
        return this;
    }

    /* renamed from: a */
    public C2067c mo10697a(Map<String, String> map) {
        this.f5576j = map;
        return this;
    }

    /* renamed from: a */
    public void mo10698a(String str, String str2) {
        if (this.f5576j == null) {
            this.f5576j = new HashMap();
        }
        this.f5576j.put(str, str2);
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: a */
    public void mo9945a(AbstractC2180f fVar) {
        fVar.mo12145g();
        while (true) {
            C2177c i = fVar.mo12147i();
            if (i.f6210b == 0) {
                fVar.mo12146h();
                if (!mo10715e()) {
                    throw new C2181g("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
                }
                mo10737x();
                return;
            }
            switch (i.f6211c) {
                case 1:
                    if (i.f6210b == 11) {
                        this.f5567a = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 2:
                    if (i.f6210b == 10) {
                        this.f5568b = fVar.mo12159u();
                        mo10699a(true);
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 3:
                    if (i.f6210b == 11) {
                        this.f5569c = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 4:
                    if (i.f6210b == 11) {
                        this.f5570d = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 5:
                    if (i.f6210b == 11) {
                        this.f5571e = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 6:
                    if (i.f6210b == 8) {
                        this.f5572f = fVar.mo12158t();
                        mo10705b(true);
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 7:
                    if (i.f6210b == 11) {
                        this.f5573g = fVar.mo12161w();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 8:
                    if (i.f6210b == 8) {
                        this.f5574h = fVar.mo12158t();
                        mo10708c(true);
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 9:
                    if (i.f6210b == 8) {
                        this.f5575i = fVar.mo12158t();
                        mo10713d(true);
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 10:
                    if (i.f6210b == 13) {
                        C2179e k = fVar.mo12149k();
                        this.f5576j = new HashMap(k.f6216c * 2);
                        for (int i2 = 0; i2 < k.f6216c; i2++) {
                            this.f5576j.put(fVar.mo12161w(), fVar.mo12161w());
                        }
                        fVar.mo12150l();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 11:
                    if (i.f6210b == 13) {
                        C2179e k2 = fVar.mo12149k();
                        this.f5577k = new HashMap(k2.f6216c * 2);
                        for (int i3 = 0; i3 < k2.f6216c; i3++) {
                            this.f5577k.put(fVar.mo12161w(), fVar.mo12161w());
                        }
                        fVar.mo12150l();
                        break;
                    } else {
                        C2183i.m8338a(fVar, i.f6210b);
                        break;
                    }
                case 12:
                    if (i.f6210b == 2) {
                        this.f5578l = fVar.mo12155q();
                        mo10714e(true);
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
    public void mo10699a(boolean z) {
        this.f5566A.set(0, z);
    }

    /* renamed from: a */
    public boolean mo10700a(C2067c cVar) {
        if (cVar == null) {
            return false;
        }
        boolean c = mo10709c();
        boolean c2 = cVar.mo10709c();
        if (((c || c2) && (!c || !c2 || !this.f5567a.equals(cVar.f5567a))) || this.f5568b != cVar.f5568b) {
            return false;
        }
        boolean g = mo10718g();
        boolean g2 = cVar.mo10718g();
        if ((g || g2) && (!g || !g2 || !this.f5569c.equals(cVar.f5569c))) {
            return false;
        }
        boolean i = mo10721i();
        boolean i2 = cVar.mo10721i();
        if ((i || i2) && (!i || !i2 || !this.f5570d.equals(cVar.f5570d))) {
            return false;
        }
        boolean k = mo10723k();
        boolean k2 = cVar.mo10723k();
        if ((k || k2) && (!k || !k2 || !this.f5571e.equals(cVar.f5571e))) {
            return false;
        }
        boolean m = mo10725m();
        boolean m2 = cVar.mo10725m();
        if ((m || m2) && (!m || !m2 || this.f5572f != cVar.f5572f)) {
            return false;
        }
        boolean n = mo10726n();
        boolean n2 = cVar.mo10726n();
        if ((n || n2) && (!n || !n2 || !this.f5573g.equals(cVar.f5573g))) {
            return false;
        }
        boolean p = mo10728p();
        boolean p2 = cVar.mo10728p();
        if ((p || p2) && (!p || !p2 || this.f5574h != cVar.f5574h)) {
            return false;
        }
        boolean r = mo10730r();
        boolean r2 = cVar.mo10730r();
        if ((r || r2) && (!r || !r2 || this.f5575i != cVar.f5575i)) {
            return false;
        }
        boolean t = mo10732t();
        boolean t2 = cVar.mo10732t();
        if ((t || t2) && (!t || !t2 || !this.f5576j.equals(cVar.f5576j))) {
            return false;
        }
        boolean u = mo10734u();
        boolean u2 = cVar.mo10734u();
        if ((u || u2) && (!u || !u2 || !this.f5577k.equals(cVar.f5577k))) {
            return false;
        }
        boolean w = mo10736w();
        boolean w2 = cVar.mo10736w();
        return (!w && !w2) || (w && w2 && this.f5578l == cVar.f5578l);
    }

    /* renamed from: b */
    public int compareTo(C2067c cVar) {
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
        int a11;
        int a12;
        if (!getClass().equals(cVar.getClass())) {
            return getClass().getName().compareTo(cVar.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo10709c()).compareTo(Boolean.valueOf(cVar.mo10709c()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo10709c() && (a12 = C2159c.m8187a(this.f5567a, cVar.f5567a)) != 0) {
            return a12;
        }
        int compareTo2 = Boolean.valueOf(mo10715e()).compareTo(Boolean.valueOf(cVar.mo10715e()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo10715e() && (a11 = C2159c.m8185a(this.f5568b, cVar.f5568b)) != 0) {
            return a11;
        }
        int compareTo3 = Boolean.valueOf(mo10718g()).compareTo(Boolean.valueOf(cVar.mo10718g()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo10718g() && (a10 = C2159c.m8187a(this.f5569c, cVar.f5569c)) != 0) {
            return a10;
        }
        int compareTo4 = Boolean.valueOf(mo10721i()).compareTo(Boolean.valueOf(cVar.mo10721i()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo10721i() && (a9 = C2159c.m8187a(this.f5570d, cVar.f5570d)) != 0) {
            return a9;
        }
        int compareTo5 = Boolean.valueOf(mo10723k()).compareTo(Boolean.valueOf(cVar.mo10723k()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo10723k() && (a8 = C2159c.m8187a(this.f5571e, cVar.f5571e)) != 0) {
            return a8;
        }
        int compareTo6 = Boolean.valueOf(mo10725m()).compareTo(Boolean.valueOf(cVar.mo10725m()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo10725m() && (a7 = C2159c.m8184a(this.f5572f, cVar.f5572f)) != 0) {
            return a7;
        }
        int compareTo7 = Boolean.valueOf(mo10726n()).compareTo(Boolean.valueOf(cVar.mo10726n()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo10726n() && (a6 = C2159c.m8187a(this.f5573g, cVar.f5573g)) != 0) {
            return a6;
        }
        int compareTo8 = Boolean.valueOf(mo10728p()).compareTo(Boolean.valueOf(cVar.mo10728p()));
        if (compareTo8 != 0) {
            return compareTo8;
        }
        if (mo10728p() && (a5 = C2159c.m8184a(this.f5574h, cVar.f5574h)) != 0) {
            return a5;
        }
        int compareTo9 = Boolean.valueOf(mo10730r()).compareTo(Boolean.valueOf(cVar.mo10730r()));
        if (compareTo9 != 0) {
            return compareTo9;
        }
        if (mo10730r() && (a4 = C2159c.m8184a(this.f5575i, cVar.f5575i)) != 0) {
            return a4;
        }
        int compareTo10 = Boolean.valueOf(mo10732t()).compareTo(Boolean.valueOf(cVar.mo10732t()));
        if (compareTo10 != 0) {
            return compareTo10;
        }
        if (mo10732t() && (a3 = C2159c.m8190a(this.f5576j, cVar.f5576j)) != 0) {
            return a3;
        }
        int compareTo11 = Boolean.valueOf(mo10734u()).compareTo(Boolean.valueOf(cVar.mo10734u()));
        if (compareTo11 != 0) {
            return compareTo11;
        }
        if (mo10734u() && (a2 = C2159c.m8190a(this.f5577k, cVar.f5577k)) != 0) {
            return a2;
        }
        int compareTo12 = Boolean.valueOf(mo10736w()).compareTo(Boolean.valueOf(cVar.mo10736w()));
        if (compareTo12 != 0) {
            return compareTo12;
        }
        if (!mo10736w() || (a = C2159c.m8192a(this.f5578l, cVar.f5578l)) == 0) {
            return 0;
        }
        return a;
    }

    /* renamed from: b */
    public C2067c mo10702b(int i) {
        this.f5574h = i;
        mo10708c(true);
        return this;
    }

    /* renamed from: b */
    public C2067c mo10703b(String str) {
        this.f5569c = str;
        return this;
    }

    /* renamed from: b */
    public String mo10704b() {
        return this.f5567a;
    }

    @Override // org.apache.thrift.AbstractC2158b
    /* renamed from: b */
    public void mo9950b(AbstractC2180f fVar) {
        mo10737x();
        fVar.mo12134a(f5553n);
        if (this.f5567a != null) {
            fVar.mo12130a(f5554o);
            fVar.mo12128a(this.f5567a);
            fVar.mo12138b();
        }
        fVar.mo12130a(f5555p);
        fVar.mo12127a(this.f5568b);
        fVar.mo12138b();
        if (this.f5569c != null && mo10718g()) {
            fVar.mo12130a(f5556q);
            fVar.mo12128a(this.f5569c);
            fVar.mo12138b();
        }
        if (this.f5570d != null && mo10721i()) {
            fVar.mo12130a(f5557r);
            fVar.mo12128a(this.f5570d);
            fVar.mo12138b();
        }
        if (this.f5571e != null && mo10723k()) {
            fVar.mo12130a(f5558s);
            fVar.mo12128a(this.f5571e);
            fVar.mo12138b();
        }
        if (mo10725m()) {
            fVar.mo12130a(f5559t);
            fVar.mo12126a(this.f5572f);
            fVar.mo12138b();
        }
        if (this.f5573g != null && mo10726n()) {
            fVar.mo12130a(f5560u);
            fVar.mo12128a(this.f5573g);
            fVar.mo12138b();
        }
        if (mo10728p()) {
            fVar.mo12130a(f5561v);
            fVar.mo12126a(this.f5574h);
            fVar.mo12138b();
        }
        if (mo10730r()) {
            fVar.mo12130a(f5562w);
            fVar.mo12126a(this.f5575i);
            fVar.mo12138b();
        }
        if (this.f5576j != null && mo10732t()) {
            fVar.mo12130a(f5563x);
            fVar.mo12132a(new C2179e((byte) 11, (byte) 11, this.f5576j.size()));
            for (Map.Entry<String, String> entry : this.f5576j.entrySet()) {
                fVar.mo12128a(entry.getKey());
                fVar.mo12128a(entry.getValue());
            }
            fVar.mo12141d();
            fVar.mo12138b();
        }
        if (this.f5577k != null && mo10734u()) {
            fVar.mo12130a(f5564y);
            fVar.mo12132a(new C2179e((byte) 11, (byte) 11, this.f5577k.size()));
            for (Map.Entry<String, String> entry2 : this.f5577k.entrySet()) {
                fVar.mo12128a(entry2.getKey());
                fVar.mo12128a(entry2.getValue());
            }
            fVar.mo12141d();
            fVar.mo12138b();
        }
        if (mo10736w()) {
            fVar.mo12130a(f5565z);
            fVar.mo12136a(this.f5578l);
            fVar.mo12138b();
        }
        fVar.mo12139c();
        fVar.mo12124a();
    }

    /* renamed from: b */
    public void mo10705b(boolean z) {
        this.f5566A.set(1, z);
    }

    /* renamed from: c */
    public C2067c mo10706c(int i) {
        this.f5575i = i;
        mo10713d(true);
        return this;
    }

    /* renamed from: c */
    public C2067c mo10707c(String str) {
        this.f5570d = str;
        return this;
    }

    /* renamed from: c */
    public void mo10708c(boolean z) {
        this.f5566A.set(2, z);
    }

    /* renamed from: c */
    public boolean mo10709c() {
        return this.f5567a != null;
    }

    /* renamed from: d */
    public long mo10711d() {
        return this.f5568b;
    }

    /* renamed from: d */
    public C2067c mo10712d(String str) {
        this.f5571e = str;
        return this;
    }

    /* renamed from: d */
    public void mo10713d(boolean z) {
        this.f5566A.set(3, z);
    }

    /* renamed from: e */
    public void mo10714e(boolean z) {
        this.f5566A.set(4, z);
    }

    /* renamed from: e */
    public boolean mo10715e() {
        return this.f5566A.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C2067c)) {
            return mo10700a((C2067c) obj);
        }
        return false;
    }

    /* renamed from: f */
    public String mo10717f() {
        return this.f5569c;
    }

    /* renamed from: g */
    public boolean mo10718g() {
        return this.f5569c != null;
    }

    /* renamed from: h */
    public String mo10719h() {
        return this.f5570d;
    }

    public int hashCode() {
        return 0;
    }

    /* renamed from: i */
    public boolean mo10721i() {
        return this.f5570d != null;
    }

    /* renamed from: j */
    public String mo10722j() {
        return this.f5571e;
    }

    /* renamed from: k */
    public boolean mo10723k() {
        return this.f5571e != null;
    }

    /* renamed from: l */
    public int mo10724l() {
        return this.f5572f;
    }

    /* renamed from: m */
    public boolean mo10725m() {
        return this.f5566A.get(1);
    }

    /* renamed from: n */
    public boolean mo10726n() {
        return this.f5573g != null;
    }

    /* renamed from: o */
    public int mo10727o() {
        return this.f5574h;
    }

    /* renamed from: p */
    public boolean mo10728p() {
        return this.f5566A.get(2);
    }

    /* renamed from: q */
    public int mo10729q() {
        return this.f5575i;
    }

    /* renamed from: r */
    public boolean mo10730r() {
        return this.f5566A.get(3);
    }

    /* renamed from: s */
    public Map<String, String> mo10731s() {
        return this.f5576j;
    }

    /* renamed from: t */
    public boolean mo10732t() {
        return this.f5576j != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        if (this.f5567a == null) {
            sb.append("null");
        } else {
            sb.append(this.f5567a);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f5568b);
        if (mo10718g()) {
            sb.append(", ");
            sb.append("topic:");
            if (this.f5569c == null) {
                sb.append("null");
            } else {
                sb.append(this.f5569c);
            }
        }
        if (mo10721i()) {
            sb.append(", ");
            sb.append("title:");
            if (this.f5570d == null) {
                sb.append("null");
            } else {
                sb.append(this.f5570d);
            }
        }
        if (mo10723k()) {
            sb.append(", ");
            sb.append("description:");
            if (this.f5571e == null) {
                sb.append("null");
            } else {
                sb.append(this.f5571e);
            }
        }
        if (mo10725m()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f5572f);
        }
        if (mo10726n()) {
            sb.append(", ");
            sb.append("url:");
            if (this.f5573g == null) {
                sb.append("null");
            } else {
                sb.append(this.f5573g);
            }
        }
        if (mo10728p()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f5574h);
        }
        if (mo10730r()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.f5575i);
        }
        if (mo10732t()) {
            sb.append(", ");
            sb.append("extra:");
            if (this.f5576j == null) {
                sb.append("null");
            } else {
                sb.append(this.f5576j);
            }
        }
        if (mo10734u()) {
            sb.append(", ");
            sb.append("internal:");
            if (this.f5577k == null) {
                sb.append("null");
            } else {
                sb.append(this.f5577k);
            }
        }
        if (mo10736w()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f5578l);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: u */
    public boolean mo10734u() {
        return this.f5577k != null;
    }

    /* renamed from: v */
    public boolean mo10735v() {
        return this.f5578l;
    }

    /* renamed from: w */
    public boolean mo10736w() {
        return this.f5566A.get(4);
    }

    /* renamed from: x */
    public void mo10737x() {
        if (this.f5567a == null) {
            throw new C2181g("Required field 'id' was not present! Struct: " + toString());
        }
    }
}
