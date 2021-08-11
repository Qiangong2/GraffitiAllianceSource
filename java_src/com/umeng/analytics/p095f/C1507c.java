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

/* renamed from: com.umeng.analytics.f.c */
/* compiled from: IdSnapshot */
public class C1507c implements AbstractC0033d<C1507c, EnumC1513e>, Serializable, Cloneable {

    /* renamed from: d */
    public static final Map<EnumC1513e, C0002b> f3774d;

    /* renamed from: e */
    private static final long f3775e = -6496538196005191531L;

    /* renamed from: f */
    private static final C0024m f3776f = new C0024m("IdSnapshot");

    /* renamed from: g */
    private static final C0014c f3777g = new C0014c("identity", (byte) 11, 1);

    /* renamed from: h */
    private static final C0014c f3778h = new C0014c("ts", (byte) 10, 2);

    /* renamed from: i */
    private static final C0014c f3779i = new C0014c("version", (byte) 8, 3);

    /* renamed from: j */
    private static final Map<Class<? extends AbstractC0029a>, AbstractC0030b> f3780j = new HashMap();

    /* renamed from: k */
    private static final int f3781k = 0;

    /* renamed from: l */
    private static final int f3782l = 1;

    /* renamed from: a */
    public String f3783a;

    /* renamed from: b */
    public long f3784b;

    /* renamed from: c */
    public int f3785c;

    /* renamed from: m */
    private byte f3786m;

    static {
        f3780j.put(AbstractC0031c.class, new C1510b());
        f3780j.put(AbstractC0032d.class, new C1512d());
        EnumMap enumMap = new EnumMap(EnumC1513e.class);
        enumMap.put((Object) EnumC1513e.IDENTITY, (Object) new C0002b("identity", (byte) 1, new C0003c((byte) 11)));
        enumMap.put((Object) EnumC1513e.TS, (Object) new C0002b("ts", (byte) 1, new C0003c((byte) 10)));
        enumMap.put((Object) EnumC1513e.VERSION, (Object) new C0002b("version", (byte) 1, new C0003c((byte) 8)));
        f3774d = Collections.unmodifiableMap(enumMap);
        C0002b.m17a(C1507c.class, f3774d);
    }

    /* renamed from: com.umeng.analytics.f.c$e */
    /* compiled from: IdSnapshot */
    public enum EnumC1513e implements AbstractC0047k {
        IDENTITY(1, "identity"),
        TS(2, "ts"),
        VERSION(3, "version");
        

        /* renamed from: d */
        private static final Map<String, EnumC1513e> f3790d = new HashMap();

        /* renamed from: e */
        private final short f3792e;

        /* renamed from: f */
        private final String f3793f;

        static {
            Iterator it = EnumSet.allOf(EnumC1513e.class).iterator();
            while (it.hasNext()) {
                EnumC1513e eVar = (EnumC1513e) it.next();
                f3790d.put(eVar.mo114b(), eVar);
            }
        }

        /* renamed from: a */
        public static EnumC1513e m5689a(int i) {
            switch (i) {
                case 1:
                    return IDENTITY;
                case 2:
                    return TS;
                case 3:
                    return VERSION;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static EnumC1513e m5691b(int i) {
            EnumC1513e a = m5689a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        /* renamed from: a */
        public static EnumC1513e m5690a(String str) {
            return f3790d.get(str);
        }

        private EnumC1513e(short s, String str) {
            this.f3792e = s;
            this.f3793f = str;
        }

        @Override // p000a.p001a.p002a.AbstractC0047k
        /* renamed from: a */
        public short mo113a() {
            return this.f3792e;
        }

        @Override // p000a.p001a.p002a.AbstractC0047k
        /* renamed from: b */
        public String mo114b() {
            return this.f3793f;
        }
    }

    public C1507c() {
        this.f3786m = 0;
    }

    public C1507c(String str, long j, int i) {
        this();
        this.f3783a = str;
        this.f3784b = j;
        mo8722b(true);
        this.f3785c = i;
        mo8725c(true);
    }

    public C1507c(C1507c cVar) {
        this.f3786m = 0;
        this.f3786m = cVar.f3786m;
        if (cVar.mo8727e()) {
            this.f3783a = cVar.f3783a;
        }
        this.f3784b = cVar.f3784b;
        this.f3785c = cVar.f3785c;
    }

    /* renamed from: a */
    public C1507c mo77p() {
        return new C1507c(this);
    }

    @Override // p000a.p001a.p002a.AbstractC0033d
    /* renamed from: b */
    public void mo75b() {
        this.f3783a = null;
        mo8722b(false);
        this.f3784b = 0;
        mo8725c(false);
        this.f3785c = 0;
    }

    /* renamed from: c */
    public String mo8724c() {
        return this.f3783a;
    }

    /* renamed from: a */
    public C1507c mo8720a(String str) {
        this.f3783a = str;
        return this;
    }

    /* renamed from: d */
    public void mo8726d() {
        this.f3783a = null;
    }

    /* renamed from: e */
    public boolean mo8727e() {
        return this.f3783a != null;
    }

    /* renamed from: a */
    public void mo8721a(boolean z) {
        if (!z) {
            this.f3783a = null;
        }
    }

    /* renamed from: f */
    public long mo8728f() {
        return this.f3784b;
    }

    /* renamed from: a */
    public C1507c mo8719a(long j) {
        this.f3784b = j;
        mo8722b(true);
        return this;
    }

    /* renamed from: g */
    public void mo8729g() {
        this.f3786m = C0000a.m12b(this.f3786m, 0);
    }

    /* renamed from: h */
    public boolean mo8730h() {
        return C0000a.m8a(this.f3786m, 0);
    }

    /* renamed from: b */
    public void mo8722b(boolean z) {
        this.f3786m = C0000a.m0a(this.f3786m, 0, z);
    }

    /* renamed from: i */
    public int mo8731i() {
        return this.f3785c;
    }

    /* renamed from: a */
    public C1507c mo8718a(int i) {
        this.f3785c = i;
        mo8725c(true);
        return this;
    }

    /* renamed from: j */
    public void mo8732j() {
        this.f3786m = C0000a.m12b(this.f3786m, 1);
    }

    /* renamed from: k */
    public boolean mo8733k() {
        return C0000a.m8a(this.f3786m, 1);
    }

    /* renamed from: c */
    public void mo8725c(boolean z) {
        this.f3786m = C0000a.m0a(this.f3786m, 1, z);
    }

    /* renamed from: c */
    public EnumC1513e mo74b(int i) {
        return EnumC1513e.m5689a(i);
    }

    @Override // p000a.p001a.p002a.AbstractC0033d
    /* renamed from: a */
    public void mo73a(AbstractC0019h hVar) throws C0046j {
        f3780j.get(hVar.mo64D()).mo72b().mo71b(hVar, this);
    }

    @Override // p000a.p001a.p002a.AbstractC0033d
    /* renamed from: b */
    public void mo76b(AbstractC0019h hVar) throws C0046j {
        f3780j.get(hVar.mo64D()).mo72b().mo70a(hVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdSnapshot(");
        sb.append("identity:");
        if (this.f3783a == null) {
            sb.append("null");
        } else {
            sb.append(this.f3783a);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f3784b);
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f3785c);
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: l */
    public void mo8734l() throws C0046j {
        if (this.f3783a == null) {
            throw new C0020i("Required field 'identity' was not present! Struct: " + toString());
        }
    }

    /* renamed from: a */
    private void m5649a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            mo76b(new C0011b(new C0034a(objectOutputStream)));
        } catch (C0046j e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m5648a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f3786m = 0;
            mo73a(new C0011b(new C0034a(objectInputStream)));
        } catch (C0046j e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: com.umeng.analytics.f.c$b */
    /* compiled from: IdSnapshot */
    private static class C1510b implements AbstractC0030b {
        private C1510b() {
        }

        /* renamed from: a */
        public C1509a mo72b() {
            return new C1509a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.umeng.analytics.f.c$a */
    /* compiled from: IdSnapshot */
    public static class C1509a extends AbstractC0031c<C1507c> {
        private C1509a() {
        }

        /* renamed from: a */
        public void mo71b(AbstractC0019h hVar, C1507c cVar) throws C0046j {
            hVar.mo38j();
            while (true) {
                C0014c l = hVar.mo40l();
                if (l.f65b == 0) {
                    hVar.mo39k();
                    if (!cVar.mo8730h()) {
                        throw new C0020i("Required field 'ts' was not found in serialized data! Struct: " + toString());
                    } else if (!cVar.mo8733k()) {
                        throw new C0020i("Required field 'version' was not found in serialized data! Struct: " + toString());
                    } else {
                        cVar.mo8734l();
                        return;
                    }
                } else {
                    switch (l.f66c) {
                        case 1:
                            if (l.f65b != 11) {
                                C0022k.m187a(hVar, l.f65b);
                                break;
                            } else {
                                cVar.f3783a = hVar.mo54z();
                                cVar.mo8721a(true);
                                break;
                            }
                        case 2:
                            if (l.f65b != 10) {
                                C0022k.m187a(hVar, l.f65b);
                                break;
                            } else {
                                cVar.f3784b = hVar.mo52x();
                                cVar.mo8722b(true);
                                break;
                            }
                        case 3:
                            if (l.f65b != 8) {
                                C0022k.m187a(hVar, l.f65b);
                                break;
                            } else {
                                cVar.f3785c = hVar.mo51w();
                                cVar.mo8725c(true);
                                break;
                            }
                        default:
                            C0022k.m187a(hVar, l.f65b);
                            break;
                    }
                    hVar.mo41m();
                }
            }
        }

        /* renamed from: b */
        public void mo70a(AbstractC0019h hVar, C1507c cVar) throws C0046j {
            cVar.mo8734l();
            hVar.mo22a(C1507c.f3776f);
            if (cVar.f3783a != null) {
                hVar.mo17a(C1507c.f3777g);
                hVar.mo23a(cVar.f3783a);
                hVar.mo29c();
            }
            hVar.mo17a(C1507c.f3778h);
            hVar.mo16a(cVar.f3784b);
            hVar.mo29c();
            hVar.mo17a(C1507c.f3779i);
            hVar.mo15a(cVar.f3785c);
            hVar.mo29c();
            hVar.mo31d();
            hVar.mo28b();
        }
    }

    /* renamed from: com.umeng.analytics.f.c$d */
    /* compiled from: IdSnapshot */
    private static class C1512d implements AbstractC0030b {
        private C1512d() {
        }

        /* renamed from: a */
        public C1511c mo72b() {
            return new C1511c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.umeng.analytics.f.c$c */
    /* compiled from: IdSnapshot */
    public static class C1511c extends AbstractC0032d<C1507c> {
        private C1511c() {
        }

        /* renamed from: a */
        public void mo70a(AbstractC0019h hVar, C1507c cVar) throws C0046j {
            C0025n nVar = (C0025n) hVar;
            nVar.mo23a(cVar.f3783a);
            nVar.mo16a(cVar.f3784b);
            nVar.mo15a(cVar.f3785c);
        }

        /* renamed from: b */
        public void mo71b(AbstractC0019h hVar, C1507c cVar) throws C0046j {
            C0025n nVar = (C0025n) hVar;
            cVar.f3783a = nVar.mo54z();
            cVar.mo8721a(true);
            cVar.f3784b = nVar.mo52x();
            cVar.mo8722b(true);
            cVar.f3785c = nVar.mo51w();
            cVar.mo8725c(true);
        }
    }
}
