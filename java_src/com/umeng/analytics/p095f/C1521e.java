package com.umeng.analytics.p095f;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p000a.p001a.p002a.AbstractC0033d;
import p000a.p001a.p002a.AbstractC0047k;
import p000a.p001a.p002a.C0000a;
import p000a.p001a.p002a.C0046j;
import p000a.p001a.p002a.p003a.C0002b;
import p000a.p001a.p002a.p003a.C0003c;
import p000a.p001a.p002a.p003a.C0005e;
import p000a.p001a.p002a.p003a.C0007g;
import p000a.p001a.p002a.p004b.AbstractC0019h;
import p000a.p001a.p002a.p004b.C0011b;
import p000a.p001a.p002a.p004b.C0014c;
import p000a.p001a.p002a.p004b.C0016e;
import p000a.p001a.p002a.p004b.C0020i;
import p000a.p001a.p002a.p004b.C0022k;
import p000a.p001a.p002a.p004b.C0024m;
import p000a.p001a.p002a.p004b.C0025n;
import p000a.p001a.p002a.p005c.AbstractC0029a;
import p000a.p001a.p002a.p005c.AbstractC0030b;
import p000a.p001a.p002a.p005c.AbstractC0031c;
import p000a.p001a.p002a.p005c.AbstractC0032d;
import p000a.p001a.p002a.p006d.C0034a;

/* renamed from: com.umeng.analytics.f.e */
/* compiled from: Imprint */
public class C1521e implements AbstractC0033d<C1521e, EnumC1527e>, Serializable, Cloneable {

    /* renamed from: d */
    public static final Map<EnumC1527e, C0002b> f3812d;

    /* renamed from: e */
    private static final long f3813e = 2846460275012375038L;

    /* renamed from: f */
    private static final C0024m f3814f = new C0024m("Imprint");

    /* renamed from: g */
    private static final C0014c f3815g = new C0014c("property", (byte) 13, 1);

    /* renamed from: h */
    private static final C0014c f3816h = new C0014c("version", (byte) 8, 2);

    /* renamed from: i */
    private static final C0014c f3817i = new C0014c("checksum", (byte) 11, 3);

    /* renamed from: j */
    private static final Map<Class<? extends AbstractC0029a>, AbstractC0030b> f3818j = new HashMap();

    /* renamed from: k */
    private static final int f3819k = 0;

    /* renamed from: a */
    public Map<String, C1528f> f3820a;

    /* renamed from: b */
    public int f3821b;

    /* renamed from: c */
    public String f3822c;

    /* renamed from: l */
    private byte f3823l;

    static {
        f3818j.put(AbstractC0031c.class, new C1524b());
        f3818j.put(AbstractC0032d.class, new C1526d());
        EnumMap enumMap = new EnumMap(EnumC1527e.class);
        enumMap.put((Object) EnumC1527e.PROPERTY, (Object) new C0002b("property", (byte) 1, new C0005e((byte) 13, new C0003c((byte) 11), new C0007g((byte) 12, C1528f.class))));
        enumMap.put((Object) EnumC1527e.VERSION, (Object) new C0002b("version", (byte) 1, new C0003c((byte) 8)));
        enumMap.put((Object) EnumC1527e.CHECKSUM, (Object) new C0002b("checksum", (byte) 1, new C0003c((byte) 11)));
        f3812d = Collections.unmodifiableMap(enumMap);
        C0002b.m17a(C1521e.class, f3812d);
    }

    /* renamed from: com.umeng.analytics.f.e$e */
    /* compiled from: Imprint */
    public enum EnumC1527e implements AbstractC0047k {
        PROPERTY(1, "property"),
        VERSION(2, "version"),
        CHECKSUM(3, "checksum");
        

        /* renamed from: d */
        private static final Map<String, EnumC1527e> f3827d = new HashMap();

        /* renamed from: e */
        private final short f3829e;

        /* renamed from: f */
        private final String f3830f;

        static {
            Iterator it = EnumSet.allOf(EnumC1527e.class).iterator();
            while (it.hasNext()) {
                EnumC1527e eVar = (EnumC1527e) it.next();
                f3827d.put(eVar.mo114b(), eVar);
            }
        }

        /* renamed from: a */
        public static EnumC1527e m5788a(int i) {
            switch (i) {
                case 1:
                    return PROPERTY;
                case 2:
                    return VERSION;
                case 3:
                    return CHECKSUM;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static EnumC1527e m5790b(int i) {
            EnumC1527e a = m5788a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        /* renamed from: a */
        public static EnumC1527e m5789a(String str) {
            return f3827d.get(str);
        }

        private EnumC1527e(short s, String str) {
            this.f3829e = s;
            this.f3830f = str;
        }

        @Override // p000a.p001a.p002a.AbstractC0047k
        /* renamed from: a */
        public short mo113a() {
            return this.f3829e;
        }

        @Override // p000a.p001a.p002a.AbstractC0047k
        /* renamed from: b */
        public String mo114b() {
            return this.f3830f;
        }
    }

    public C1521e() {
        this.f3823l = 0;
    }

    public C1521e(Map<String, C1528f> map, int i, String str) {
        this();
        this.f3820a = map;
        this.f3821b = i;
        mo8778b(true);
        this.f3822c = str;
    }

    public C1521e(C1521e eVar) {
        this.f3823l = 0;
        this.f3823l = eVar.f3823l;
        if (eVar.mo8784f()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, C1528f> entry : eVar.f3820a.entrySet()) {
                hashMap.put(entry.getKey(), new C1528f(entry.getValue()));
            }
            this.f3820a = hashMap;
        }
        this.f3821b = eVar.f3821b;
        if (eVar.mo8790l()) {
            this.f3822c = eVar.f3822c;
        }
    }

    /* renamed from: a */
    public C1521e mo77p() {
        return new C1521e(this);
    }

    @Override // p000a.p001a.p002a.AbstractC0033d
    /* renamed from: b */
    public void mo75b() {
        this.f3820a = null;
        mo8778b(false);
        this.f3821b = 0;
        this.f3822c = null;
    }

    /* renamed from: c */
    public int mo8779c() {
        if (this.f3820a == null) {
            return 0;
        }
        return this.f3820a.size();
    }

    /* renamed from: a */
    public void mo8776a(String str, C1528f fVar) {
        if (this.f3820a == null) {
            this.f3820a = new HashMap();
        }
        this.f3820a.put(str, fVar);
    }

    /* renamed from: d */
    public Map<String, C1528f> mo8782d() {
        return this.f3820a;
    }

    /* renamed from: a */
    public C1521e mo8775a(Map<String, C1528f> map) {
        this.f3820a = map;
        return this;
    }

    /* renamed from: e */
    public void mo8783e() {
        this.f3820a = null;
    }

    /* renamed from: f */
    public boolean mo8784f() {
        return this.f3820a != null;
    }

    /* renamed from: a */
    public void mo8777a(boolean z) {
        if (!z) {
            this.f3820a = null;
        }
    }

    /* renamed from: g */
    public int mo8785g() {
        return this.f3821b;
    }

    /* renamed from: a */
    public C1521e mo8773a(int i) {
        this.f3821b = i;
        mo8778b(true);
        return this;
    }

    /* renamed from: h */
    public void mo8786h() {
        this.f3823l = C0000a.m12b(this.f3823l, 0);
    }

    /* renamed from: i */
    public boolean mo8787i() {
        return C0000a.m8a(this.f3823l, 0);
    }

    /* renamed from: b */
    public void mo8778b(boolean z) {
        this.f3823l = C0000a.m0a(this.f3823l, 0, z);
    }

    /* renamed from: j */
    public String mo8788j() {
        return this.f3822c;
    }

    /* renamed from: a */
    public C1521e mo8774a(String str) {
        this.f3822c = str;
        return this;
    }

    /* renamed from: k */
    public void mo8789k() {
        this.f3822c = null;
    }

    /* renamed from: l */
    public boolean mo8790l() {
        return this.f3822c != null;
    }

    /* renamed from: c */
    public void mo8781c(boolean z) {
        if (!z) {
            this.f3822c = null;
        }
    }

    /* renamed from: c */
    public EnumC1527e mo74b(int i) {
        return EnumC1527e.m5788a(i);
    }

    @Override // p000a.p001a.p002a.AbstractC0033d
    /* renamed from: a */
    public void mo73a(AbstractC0019h hVar) throws C0046j {
        f3818j.get(hVar.mo64D()).mo72b().mo71b(hVar, this);
    }

    @Override // p000a.p001a.p002a.AbstractC0033d
    /* renamed from: b */
    public void mo76b(AbstractC0019h hVar) throws C0046j {
        f3818j.get(hVar.mo64D()).mo72b().mo70a(hVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Imprint(");
        sb.append("property:");
        if (this.f3820a == null) {
            sb.append("null");
        } else {
            sb.append(this.f3820a);
        }
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f3821b);
        sb.append(", ");
        sb.append("checksum:");
        if (this.f3822c == null) {
            sb.append("null");
        } else {
            sb.append(this.f3822c);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: m */
    public void mo8791m() throws C0046j {
        if (this.f3820a == null) {
            throw new C0020i("Required field 'property' was not present! Struct: " + toString());
        } else if (this.f3822c == null) {
            throw new C0020i("Required field 'checksum' was not present! Struct: " + toString());
        }
    }

    /* renamed from: a */
    private void m5746a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            mo76b(new C0011b(new C0034a(objectOutputStream)));
        } catch (C0046j e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m5745a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f3823l = 0;
            mo73a(new C0011b(new C0034a(objectInputStream)));
        } catch (C0046j e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: com.umeng.analytics.f.e$b */
    /* compiled from: Imprint */
    private static class C1524b implements AbstractC0030b {
        private C1524b() {
        }

        /* renamed from: a */
        public C1523a mo72b() {
            return new C1523a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.umeng.analytics.f.e$a */
    /* compiled from: Imprint */
    public static class C1523a extends AbstractC0031c<C1521e> {
        private C1523a() {
        }

        /* renamed from: a */
        public void mo71b(AbstractC0019h hVar, C1521e eVar) throws C0046j {
            hVar.mo38j();
            while (true) {
                C0014c l = hVar.mo40l();
                if (l.f65b == 0) {
                    hVar.mo39k();
                    if (!eVar.mo8787i()) {
                        throw new C0020i("Required field 'version' was not found in serialized data! Struct: " + toString());
                    }
                    eVar.mo8791m();
                    return;
                }
                switch (l.f66c) {
                    case 1:
                        if (l.f65b == 13) {
                            C0016e n = hVar.mo42n();
                            eVar.f3820a = new HashMap(n.f71c * 2);
                            for (int i = 0; i < n.f71c; i++) {
                                String z = hVar.mo54z();
                                C1528f fVar = new C1528f();
                                fVar.mo73a(hVar);
                                eVar.f3820a.put(z, fVar);
                            }
                            hVar.mo43o();
                            eVar.mo8777a(true);
                            break;
                        } else {
                            C0022k.m187a(hVar, l.f65b);
                            break;
                        }
                    case 2:
                        if (l.f65b == 8) {
                            eVar.f3821b = hVar.mo51w();
                            eVar.mo8778b(true);
                            break;
                        } else {
                            C0022k.m187a(hVar, l.f65b);
                            break;
                        }
                    case 3:
                        if (l.f65b == 11) {
                            eVar.f3822c = hVar.mo54z();
                            eVar.mo8781c(true);
                            break;
                        } else {
                            C0022k.m187a(hVar, l.f65b);
                            break;
                        }
                    default:
                        C0022k.m187a(hVar, l.f65b);
                        break;
                }
                hVar.mo41m();
            }
        }

        /* renamed from: b */
        public void mo70a(AbstractC0019h hVar, C1521e eVar) throws C0046j {
            eVar.mo8791m();
            hVar.mo22a(C1521e.f3814f);
            if (eVar.f3820a != null) {
                hVar.mo17a(C1521e.f3815g);
                hVar.mo19a(new C0016e((byte) 11, (byte) 12, eVar.f3820a.size()));
                for (Map.Entry<String, C1528f> entry : eVar.f3820a.entrySet()) {
                    hVar.mo23a(entry.getKey());
                    entry.getValue().mo76b(hVar);
                }
                hVar.mo33e();
                hVar.mo29c();
            }
            hVar.mo17a(C1521e.f3816h);
            hVar.mo15a(eVar.f3821b);
            hVar.mo29c();
            if (eVar.f3822c != null) {
                hVar.mo17a(C1521e.f3817i);
                hVar.mo23a(eVar.f3822c);
                hVar.mo29c();
            }
            hVar.mo31d();
            hVar.mo28b();
        }
    }

    /* renamed from: com.umeng.analytics.f.e$d */
    /* compiled from: Imprint */
    private static class C1526d implements AbstractC0030b {
        private C1526d() {
        }

        /* renamed from: a */
        public C1525c mo72b() {
            return new C1525c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.umeng.analytics.f.e$c */
    /* compiled from: Imprint */
    public static class C1525c extends AbstractC0032d<C1521e> {
        private C1525c() {
        }

        /* renamed from: a */
        public void mo70a(AbstractC0019h hVar, C1521e eVar) throws C0046j {
            C0025n nVar = (C0025n) hVar;
            nVar.mo15a(eVar.f3820a.size());
            for (Map.Entry<String, C1528f> entry : eVar.f3820a.entrySet()) {
                nVar.mo23a(entry.getKey());
                entry.getValue().mo76b(nVar);
            }
            nVar.mo15a(eVar.f3821b);
            nVar.mo23a(eVar.f3822c);
        }

        /* renamed from: b */
        public void mo71b(AbstractC0019h hVar, C1521e eVar) throws C0046j {
            C0025n nVar = (C0025n) hVar;
            C0016e eVar2 = new C0016e((byte) 11, (byte) 12, nVar.mo51w());
            eVar.f3820a = new HashMap(eVar2.f71c * 2);
            for (int i = 0; i < eVar2.f71c; i++) {
                String z = nVar.mo54z();
                C1528f fVar = new C1528f();
                fVar.mo73a(nVar);
                eVar.f3820a.put(z, fVar);
            }
            eVar.mo8777a(true);
            eVar.f3821b = nVar.mo51w();
            eVar.mo8778b(true);
            eVar.f3822c = nVar.mo54z();
            eVar.mo8781c(true);
        }
    }
}
