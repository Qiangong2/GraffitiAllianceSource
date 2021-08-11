package com.umeng.analytics.p095f;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
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
import p000a.p001a.p002a.p004b.AbstractC0019h;
import p000a.p001a.p002a.p004b.C0011b;
import p000a.p001a.p002a.p004b.C0014c;
import p000a.p001a.p002a.p004b.C0020i;
import p000a.p001a.p002a.p004b.C0022k;
import p000a.p001a.p002a.p004b.C0024m;
import p000a.p001a.p002a.p004b.C0025n;
import p000a.p001a.p002a.p005c.AbstractC0029a;
import p000a.p001a.p002a.p005c.AbstractC0030b;
import p000a.p001a.p002a.p005c.AbstractC0031c;
import p000a.p001a.p002a.p005c.AbstractC0032d;
import p000a.p001a.p002a.p006d.C0034a;

/* renamed from: com.umeng.analytics.f.f */
/* compiled from: ImprintValue */
public class C1528f implements AbstractC0033d<C1528f, EnumC1534e>, Serializable, Cloneable {

    /* renamed from: d */
    public static final Map<EnumC1534e, C0002b> f3831d;

    /* renamed from: e */
    private static final long f3832e = 7501688097813630241L;

    /* renamed from: f */
    private static final C0024m f3833f = new C0024m("ImprintValue");

    /* renamed from: g */
    private static final C0014c f3834g = new C0014c("value", (byte) 11, 1);

    /* renamed from: h */
    private static final C0014c f3835h = new C0014c("ts", (byte) 10, 2);

    /* renamed from: i */
    private static final C0014c f3836i = new C0014c("guid", (byte) 11, 3);

    /* renamed from: j */
    private static final Map<Class<? extends AbstractC0029a>, AbstractC0030b> f3837j = new HashMap();

    /* renamed from: k */
    private static final int f3838k = 0;

    /* renamed from: a */
    public String f3839a;

    /* renamed from: b */
    public long f3840b;

    /* renamed from: c */
    public String f3841c;

    /* renamed from: l */
    private byte f3842l;

    /* renamed from: m */
    private EnumC1534e[] f3843m;

    static {
        f3837j.put(AbstractC0031c.class, new C1531b());
        f3837j.put(AbstractC0032d.class, new C1533d());
        EnumMap enumMap = new EnumMap(EnumC1534e.class);
        enumMap.put((Object) EnumC1534e.VALUE, (Object) new C0002b("value", (byte) 2, new C0003c((byte) 11)));
        enumMap.put((Object) EnumC1534e.TS, (Object) new C0002b("ts", (byte) 1, new C0003c((byte) 10)));
        enumMap.put((Object) EnumC1534e.GUID, (Object) new C0002b("guid", (byte) 1, new C0003c((byte) 11)));
        f3831d = Collections.unmodifiableMap(enumMap);
        C0002b.m17a(C1528f.class, f3831d);
    }

    /* renamed from: com.umeng.analytics.f.f$e */
    /* compiled from: ImprintValue */
    public enum EnumC1534e implements AbstractC0047k {
        VALUE(1, "value"),
        TS(2, "ts"),
        GUID(3, "guid");
        

        /* renamed from: d */
        private static final Map<String, EnumC1534e> f3847d = new HashMap();

        /* renamed from: e */
        private final short f3849e;

        /* renamed from: f */
        private final String f3850f;

        static {
            Iterator it = EnumSet.allOf(EnumC1534e.class).iterator();
            while (it.hasNext()) {
                EnumC1534e eVar = (EnumC1534e) it.next();
                f3847d.put(eVar.mo114b(), eVar);
            }
        }

        /* renamed from: a */
        public static EnumC1534e m5834a(int i) {
            switch (i) {
                case 1:
                    return VALUE;
                case 2:
                    return TS;
                case 3:
                    return GUID;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static EnumC1534e m5836b(int i) {
            EnumC1534e a = m5834a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        /* renamed from: a */
        public static EnumC1534e m5835a(String str) {
            return f3847d.get(str);
        }

        private EnumC1534e(short s, String str) {
            this.f3849e = s;
            this.f3850f = str;
        }

        @Override // p000a.p001a.p002a.AbstractC0047k
        /* renamed from: a */
        public short mo113a() {
            return this.f3849e;
        }

        @Override // p000a.p001a.p002a.AbstractC0047k
        /* renamed from: b */
        public String mo114b() {
            return this.f3850f;
        }
    }

    public C1528f() {
        this.f3842l = 0;
        this.f3843m = new EnumC1534e[]{EnumC1534e.VALUE};
    }

    public C1528f(long j, String str) {
        this();
        this.f3840b = j;
        mo8805b(true);
        this.f3841c = str;
    }

    public C1528f(C1528f fVar) {
        this.f3842l = 0;
        this.f3843m = new EnumC1534e[]{EnumC1534e.VALUE};
        this.f3842l = fVar.f3842l;
        if (fVar.mo8809e()) {
            this.f3839a = fVar.f3839a;
        }
        this.f3840b = fVar.f3840b;
        if (fVar.mo8815k()) {
            this.f3841c = fVar.f3841c;
        }
    }

    /* renamed from: a */
    public C1528f mo77p() {
        return new C1528f(this);
    }

    @Override // p000a.p001a.p002a.AbstractC0033d
    /* renamed from: b */
    public void mo75b() {
        this.f3839a = null;
        mo8805b(false);
        this.f3840b = 0;
        this.f3841c = null;
    }

    /* renamed from: c */
    public String mo8806c() {
        return this.f3839a;
    }

    /* renamed from: a */
    public C1528f mo8802a(String str) {
        this.f3839a = str;
        return this;
    }

    /* renamed from: d */
    public void mo8808d() {
        this.f3839a = null;
    }

    /* renamed from: e */
    public boolean mo8809e() {
        return this.f3839a != null;
    }

    /* renamed from: a */
    public void mo8803a(boolean z) {
        if (!z) {
            this.f3839a = null;
        }
    }

    /* renamed from: f */
    public long mo8810f() {
        return this.f3840b;
    }

    /* renamed from: a */
    public C1528f mo8801a(long j) {
        this.f3840b = j;
        mo8805b(true);
        return this;
    }

    /* renamed from: g */
    public void mo8811g() {
        this.f3842l = C0000a.m12b(this.f3842l, 0);
    }

    /* renamed from: h */
    public boolean mo8812h() {
        return C0000a.m8a(this.f3842l, 0);
    }

    /* renamed from: b */
    public void mo8805b(boolean z) {
        this.f3842l = C0000a.m0a(this.f3842l, 0, z);
    }

    /* renamed from: i */
    public String mo8813i() {
        return this.f3841c;
    }

    /* renamed from: b */
    public C1528f mo8804b(String str) {
        this.f3841c = str;
        return this;
    }

    /* renamed from: j */
    public void mo8814j() {
        this.f3841c = null;
    }

    /* renamed from: k */
    public boolean mo8815k() {
        return this.f3841c != null;
    }

    /* renamed from: c */
    public void mo8807c(boolean z) {
        if (!z) {
            this.f3841c = null;
        }
    }

    /* renamed from: a */
    public EnumC1534e mo74b(int i) {
        return EnumC1534e.m5834a(i);
    }

    @Override // p000a.p001a.p002a.AbstractC0033d
    /* renamed from: a */
    public void mo73a(AbstractC0019h hVar) throws C0046j {
        f3837j.get(hVar.mo64D()).mo72b().mo71b(hVar, this);
    }

    @Override // p000a.p001a.p002a.AbstractC0033d
    /* renamed from: b */
    public void mo76b(AbstractC0019h hVar) throws C0046j {
        f3837j.get(hVar.mo64D()).mo72b().mo70a(hVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ImprintValue(");
        boolean z = true;
        if (mo8809e()) {
            sb.append("value:");
            if (this.f3839a == null) {
                sb.append("null");
            } else {
                sb.append(this.f3839a);
            }
            z = false;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("ts:");
        sb.append(this.f3840b);
        sb.append(", ");
        sb.append("guid:");
        if (this.f3841c == null) {
            sb.append("null");
        } else {
            sb.append(this.f3841c);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: l */
    public void mo8816l() throws C0046j {
        if (this.f3841c == null) {
            throw new C0020i("Required field 'guid' was not present! Struct: " + toString());
        }
    }

    /* renamed from: a */
    private void m5794a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            mo76b(new C0011b(new C0034a(objectOutputStream)));
        } catch (C0046j e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m5793a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f3842l = 0;
            mo73a(new C0011b(new C0034a(objectInputStream)));
        } catch (C0046j e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: com.umeng.analytics.f.f$b */
    /* compiled from: ImprintValue */
    private static class C1531b implements AbstractC0030b {
        private C1531b() {
        }

        /* renamed from: a */
        public C1530a mo72b() {
            return new C1530a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.umeng.analytics.f.f$a */
    /* compiled from: ImprintValue */
    public static class C1530a extends AbstractC0031c<C1528f> {
        private C1530a() {
        }

        /* renamed from: a */
        public void mo71b(AbstractC0019h hVar, C1528f fVar) throws C0046j {
            hVar.mo38j();
            while (true) {
                C0014c l = hVar.mo40l();
                if (l.f65b == 0) {
                    hVar.mo39k();
                    if (!fVar.mo8812h()) {
                        throw new C0020i("Required field 'ts' was not found in serialized data! Struct: " + toString());
                    }
                    fVar.mo8816l();
                    return;
                }
                switch (l.f66c) {
                    case 1:
                        if (l.f65b != 11) {
                            C0022k.m187a(hVar, l.f65b);
                            break;
                        } else {
                            fVar.f3839a = hVar.mo54z();
                            fVar.mo8803a(true);
                            break;
                        }
                    case 2:
                        if (l.f65b != 10) {
                            C0022k.m187a(hVar, l.f65b);
                            break;
                        } else {
                            fVar.f3840b = hVar.mo52x();
                            fVar.mo8805b(true);
                            break;
                        }
                    case 3:
                        if (l.f65b != 11) {
                            C0022k.m187a(hVar, l.f65b);
                            break;
                        } else {
                            fVar.f3841c = hVar.mo54z();
                            fVar.mo8807c(true);
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
        public void mo70a(AbstractC0019h hVar, C1528f fVar) throws C0046j {
            fVar.mo8816l();
            hVar.mo22a(C1528f.f3833f);
            if (fVar.f3839a != null && fVar.mo8809e()) {
                hVar.mo17a(C1528f.f3834g);
                hVar.mo23a(fVar.f3839a);
                hVar.mo29c();
            }
            hVar.mo17a(C1528f.f3835h);
            hVar.mo16a(fVar.f3840b);
            hVar.mo29c();
            if (fVar.f3841c != null) {
                hVar.mo17a(C1528f.f3836i);
                hVar.mo23a(fVar.f3841c);
                hVar.mo29c();
            }
            hVar.mo31d();
            hVar.mo28b();
        }
    }

    /* renamed from: com.umeng.analytics.f.f$d */
    /* compiled from: ImprintValue */
    private static class C1533d implements AbstractC0030b {
        private C1533d() {
        }

        /* renamed from: a */
        public C1532c mo72b() {
            return new C1532c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.umeng.analytics.f.f$c */
    /* compiled from: ImprintValue */
    public static class C1532c extends AbstractC0032d<C1528f> {
        private C1532c() {
        }

        /* renamed from: a */
        public void mo70a(AbstractC0019h hVar, C1528f fVar) throws C0046j {
            C0025n nVar = (C0025n) hVar;
            nVar.mo16a(fVar.f3840b);
            nVar.mo23a(fVar.f3841c);
            BitSet bitSet = new BitSet();
            if (fVar.mo8809e()) {
                bitSet.set(0);
            }
            nVar.mo66a(bitSet, 1);
            if (fVar.mo8809e()) {
                nVar.mo23a(fVar.f3839a);
            }
        }

        /* renamed from: b */
        public void mo71b(AbstractC0019h hVar, C1528f fVar) throws C0046j {
            C0025n nVar = (C0025n) hVar;
            fVar.f3840b = nVar.mo52x();
            fVar.mo8805b(true);
            fVar.f3841c = nVar.mo54z();
            fVar.mo8807c(true);
            if (nVar.mo67b(1).get(0)) {
                fVar.f3839a = nVar.mo54z();
                fVar.mo8803a(true);
            }
        }
    }
}
