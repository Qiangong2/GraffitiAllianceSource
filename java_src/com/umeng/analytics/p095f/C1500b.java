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

/* renamed from: com.umeng.analytics.f.b */
/* compiled from: IdJournal */
public class C1500b implements AbstractC0033d<C1500b, EnumC1506e>, Serializable, Cloneable {

    /* renamed from: e */
    public static final Map<EnumC1506e, C0002b> f3751e;

    /* renamed from: f */
    private static final long f3752f = 9132678615281394583L;

    /* renamed from: g */
    private static final C0024m f3753g = new C0024m("IdJournal");

    /* renamed from: h */
    private static final C0014c f3754h = new C0014c("domain", (byte) 11, 1);

    /* renamed from: i */
    private static final C0014c f3755i = new C0014c("old_id", (byte) 11, 2);

    /* renamed from: j */
    private static final C0014c f3756j = new C0014c("new_id", (byte) 11, 3);

    /* renamed from: k */
    private static final C0014c f3757k = new C0014c("ts", (byte) 10, 4);

    /* renamed from: l */
    private static final Map<Class<? extends AbstractC0029a>, AbstractC0030b> f3758l = new HashMap();

    /* renamed from: m */
    private static final int f3759m = 0;

    /* renamed from: a */
    public String f3760a;

    /* renamed from: b */
    public String f3761b;

    /* renamed from: c */
    public String f3762c;

    /* renamed from: d */
    public long f3763d;

    /* renamed from: n */
    private byte f3764n;

    /* renamed from: o */
    private EnumC1506e[] f3765o;

    static {
        f3758l.put(AbstractC0031c.class, new C1503b());
        f3758l.put(AbstractC0032d.class, new C1505d());
        EnumMap enumMap = new EnumMap(EnumC1506e.class);
        enumMap.put((Object) EnumC1506e.DOMAIN, (Object) new C0002b("domain", (byte) 1, new C0003c((byte) 11)));
        enumMap.put((Object) EnumC1506e.OLD_ID, (Object) new C0002b("old_id", (byte) 2, new C0003c((byte) 11)));
        enumMap.put((Object) EnumC1506e.NEW_ID, (Object) new C0002b("new_id", (byte) 1, new C0003c((byte) 11)));
        enumMap.put((Object) EnumC1506e.TS, (Object) new C0002b("ts", (byte) 1, new C0003c((byte) 10)));
        f3751e = Collections.unmodifiableMap(enumMap);
        C0002b.m17a(C1500b.class, f3751e);
    }

    /* renamed from: com.umeng.analytics.f.b$e */
    /* compiled from: IdJournal */
    public enum EnumC1506e implements AbstractC0047k {
        DOMAIN(1, "domain"),
        OLD_ID(2, "old_id"),
        NEW_ID(3, "new_id"),
        TS(4, "ts");
        

        /* renamed from: e */
        private static final Map<String, EnumC1506e> f3770e = new HashMap();

        /* renamed from: f */
        private final short f3772f;

        /* renamed from: g */
        private final String f3773g;

        static {
            Iterator it = EnumSet.allOf(EnumC1506e.class).iterator();
            while (it.hasNext()) {
                EnumC1506e eVar = (EnumC1506e) it.next();
                f3770e.put(eVar.mo114b(), eVar);
            }
        }

        /* renamed from: a */
        public static EnumC1506e m5643a(int i) {
            switch (i) {
                case 1:
                    return DOMAIN;
                case 2:
                    return OLD_ID;
                case 3:
                    return NEW_ID;
                case 4:
                    return TS;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static EnumC1506e m5645b(int i) {
            EnumC1506e a = m5643a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        /* renamed from: a */
        public static EnumC1506e m5644a(String str) {
            return f3770e.get(str);
        }

        private EnumC1506e(short s, String str) {
            this.f3772f = s;
            this.f3773g = str;
        }

        @Override // p000a.p001a.p002a.AbstractC0047k
        /* renamed from: a */
        public short mo113a() {
            return this.f3772f;
        }

        @Override // p000a.p001a.p002a.AbstractC0047k
        /* renamed from: b */
        public String mo114b() {
            return this.f3773g;
        }
    }

    public C1500b() {
        this.f3764n = 0;
        this.f3765o = new EnumC1506e[]{EnumC1506e.OLD_ID};
    }

    public C1500b(String str, String str2, long j) {
        this();
        this.f3760a = str;
        this.f3762c = str2;
        this.f3763d = j;
        mo8698d(true);
    }

    public C1500b(C1500b bVar) {
        this.f3764n = 0;
        this.f3765o = new EnumC1506e[]{EnumC1506e.OLD_ID};
        this.f3764n = bVar.f3764n;
        if (bVar.mo8699e()) {
            this.f3760a = bVar.f3760a;
        }
        if (bVar.mo8702h()) {
            this.f3761b = bVar.f3761b;
        }
        if (bVar.mo8705k()) {
            this.f3762c = bVar.f3762c;
        }
        this.f3763d = bVar.f3763d;
    }

    /* renamed from: a */
    public C1500b mo77p() {
        return new C1500b(this);
    }

    @Override // p000a.p001a.p002a.AbstractC0033d
    /* renamed from: b */
    public void mo75b() {
        this.f3760a = null;
        this.f3761b = null;
        this.f3762c = null;
        mo8698d(false);
        this.f3763d = 0;
    }

    /* renamed from: c */
    public String mo8695c() {
        return this.f3760a;
    }

    /* renamed from: a */
    public C1500b mo8690a(String str) {
        this.f3760a = str;
        return this;
    }

    /* renamed from: d */
    public void mo8697d() {
        this.f3760a = null;
    }

    /* renamed from: e */
    public boolean mo8699e() {
        return this.f3760a != null;
    }

    /* renamed from: a */
    public void mo8691a(boolean z) {
        if (!z) {
            this.f3760a = null;
        }
    }

    /* renamed from: f */
    public String mo8700f() {
        return this.f3761b;
    }

    /* renamed from: b */
    public C1500b mo8692b(String str) {
        this.f3761b = str;
        return this;
    }

    /* renamed from: g */
    public void mo8701g() {
        this.f3761b = null;
    }

    /* renamed from: h */
    public boolean mo8702h() {
        return this.f3761b != null;
    }

    /* renamed from: b */
    public void mo8693b(boolean z) {
        if (!z) {
            this.f3761b = null;
        }
    }

    /* renamed from: i */
    public String mo8703i() {
        return this.f3762c;
    }

    /* renamed from: c */
    public C1500b mo8694c(String str) {
        this.f3762c = str;
        return this;
    }

    /* renamed from: j */
    public void mo8704j() {
        this.f3762c = null;
    }

    /* renamed from: k */
    public boolean mo8705k() {
        return this.f3762c != null;
    }

    /* renamed from: c */
    public void mo8696c(boolean z) {
        if (!z) {
            this.f3762c = null;
        }
    }

    /* renamed from: l */
    public long mo8706l() {
        return this.f3763d;
    }

    /* renamed from: a */
    public C1500b mo8689a(long j) {
        this.f3763d = j;
        mo8698d(true);
        return this;
    }

    /* renamed from: m */
    public void mo8707m() {
        this.f3764n = C0000a.m12b(this.f3764n, 0);
    }

    /* renamed from: n */
    public boolean mo8708n() {
        return C0000a.m8a(this.f3764n, 0);
    }

    /* renamed from: d */
    public void mo8698d(boolean z) {
        this.f3764n = C0000a.m0a(this.f3764n, 0, z);
    }

    /* renamed from: a */
    public EnumC1506e mo74b(int i) {
        return EnumC1506e.m5643a(i);
    }

    @Override // p000a.p001a.p002a.AbstractC0033d
    /* renamed from: a */
    public void mo73a(AbstractC0019h hVar) throws C0046j {
        f3758l.get(hVar.mo64D()).mo72b().mo71b(hVar, this);
    }

    @Override // p000a.p001a.p002a.AbstractC0033d
    /* renamed from: b */
    public void mo76b(AbstractC0019h hVar) throws C0046j {
        f3758l.get(hVar.mo64D()).mo72b().mo70a(hVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdJournal(");
        sb.append("domain:");
        if (this.f3760a == null) {
            sb.append("null");
        } else {
            sb.append(this.f3760a);
        }
        if (mo8702h()) {
            sb.append(", ");
            sb.append("old_id:");
            if (this.f3761b == null) {
                sb.append("null");
            } else {
                sb.append(this.f3761b);
            }
        }
        sb.append(", ");
        sb.append("new_id:");
        if (this.f3762c == null) {
            sb.append("null");
        } else {
            sb.append(this.f3762c);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f3763d);
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: o */
    public void mo8709o() throws C0046j {
        if (this.f3760a == null) {
            throw new C0020i("Required field 'domain' was not present! Struct: " + toString());
        } else if (this.f3762c == null) {
            throw new C0020i("Required field 'new_id' was not present! Struct: " + toString());
        }
    }

    /* renamed from: a */
    private void m5597a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            mo76b(new C0011b(new C0034a(objectOutputStream)));
        } catch (C0046j e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m5596a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f3764n = 0;
            mo73a(new C0011b(new C0034a(objectInputStream)));
        } catch (C0046j e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: com.umeng.analytics.f.b$b */
    /* compiled from: IdJournal */
    private static class C1503b implements AbstractC0030b {
        private C1503b() {
        }

        /* renamed from: a */
        public C1502a mo72b() {
            return new C1502a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.umeng.analytics.f.b$a */
    /* compiled from: IdJournal */
    public static class C1502a extends AbstractC0031c<C1500b> {
        private C1502a() {
        }

        /* renamed from: a */
        public void mo71b(AbstractC0019h hVar, C1500b bVar) throws C0046j {
            hVar.mo38j();
            while (true) {
                C0014c l = hVar.mo40l();
                if (l.f65b == 0) {
                    hVar.mo39k();
                    if (!bVar.mo8708n()) {
                        throw new C0020i("Required field 'ts' was not found in serialized data! Struct: " + toString());
                    }
                    bVar.mo8709o();
                    return;
                }
                switch (l.f66c) {
                    case 1:
                        if (l.f65b != 11) {
                            C0022k.m187a(hVar, l.f65b);
                            break;
                        } else {
                            bVar.f3760a = hVar.mo54z();
                            bVar.mo8691a(true);
                            break;
                        }
                    case 2:
                        if (l.f65b != 11) {
                            C0022k.m187a(hVar, l.f65b);
                            break;
                        } else {
                            bVar.f3761b = hVar.mo54z();
                            bVar.mo8693b(true);
                            break;
                        }
                    case 3:
                        if (l.f65b != 11) {
                            C0022k.m187a(hVar, l.f65b);
                            break;
                        } else {
                            bVar.f3762c = hVar.mo54z();
                            bVar.mo8696c(true);
                            break;
                        }
                    case 4:
                        if (l.f65b != 10) {
                            C0022k.m187a(hVar, l.f65b);
                            break;
                        } else {
                            bVar.f3763d = hVar.mo52x();
                            bVar.mo8698d(true);
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
        public void mo70a(AbstractC0019h hVar, C1500b bVar) throws C0046j {
            bVar.mo8709o();
            hVar.mo22a(C1500b.f3753g);
            if (bVar.f3760a != null) {
                hVar.mo17a(C1500b.f3754h);
                hVar.mo23a(bVar.f3760a);
                hVar.mo29c();
            }
            if (bVar.f3761b != null && bVar.mo8702h()) {
                hVar.mo17a(C1500b.f3755i);
                hVar.mo23a(bVar.f3761b);
                hVar.mo29c();
            }
            if (bVar.f3762c != null) {
                hVar.mo17a(C1500b.f3756j);
                hVar.mo23a(bVar.f3762c);
                hVar.mo29c();
            }
            hVar.mo17a(C1500b.f3757k);
            hVar.mo16a(bVar.f3763d);
            hVar.mo29c();
            hVar.mo31d();
            hVar.mo28b();
        }
    }

    /* renamed from: com.umeng.analytics.f.b$d */
    /* compiled from: IdJournal */
    private static class C1505d implements AbstractC0030b {
        private C1505d() {
        }

        /* renamed from: a */
        public C1504c mo72b() {
            return new C1504c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.umeng.analytics.f.b$c */
    /* compiled from: IdJournal */
    public static class C1504c extends AbstractC0032d<C1500b> {
        private C1504c() {
        }

        /* renamed from: a */
        public void mo70a(AbstractC0019h hVar, C1500b bVar) throws C0046j {
            C0025n nVar = (C0025n) hVar;
            nVar.mo23a(bVar.f3760a);
            nVar.mo23a(bVar.f3762c);
            nVar.mo16a(bVar.f3763d);
            BitSet bitSet = new BitSet();
            if (bVar.mo8702h()) {
                bitSet.set(0);
            }
            nVar.mo66a(bitSet, 1);
            if (bVar.mo8702h()) {
                nVar.mo23a(bVar.f3761b);
            }
        }

        /* renamed from: b */
        public void mo71b(AbstractC0019h hVar, C1500b bVar) throws C0046j {
            C0025n nVar = (C0025n) hVar;
            bVar.f3760a = nVar.mo54z();
            bVar.mo8691a(true);
            bVar.f3762c = nVar.mo54z();
            bVar.mo8696c(true);
            bVar.f3763d = nVar.mo52x();
            bVar.mo8698d(true);
            if (nVar.mo67b(1).get(0)) {
                bVar.f3761b = nVar.mo54z();
                bVar.mo8693b(true);
            }
        }
    }
}
