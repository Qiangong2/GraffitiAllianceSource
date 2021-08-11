package com.umeng.analytics.p095f;

import com.umeng.analytics.p091b.C1447g;
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
import p000a.p001a.p002a.p003a.C0007g;
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

/* renamed from: com.umeng.analytics.f.g */
/* compiled from: Response */
public class C1535g implements AbstractC0033d<C1535g, EnumC1541e>, Serializable, Cloneable {

    /* renamed from: d */
    public static final Map<EnumC1541e, C0002b> f3851d;

    /* renamed from: e */
    private static final long f3852e = -4549277923241195391L;

    /* renamed from: f */
    private static final C0024m f3853f = new C0024m("Response");

    /* renamed from: g */
    private static final C0014c f3854g = new C0014c("resp_code", (byte) 8, 1);

    /* renamed from: h */
    private static final C0014c f3855h = new C0014c("msg", (byte) 11, 2);

    /* renamed from: i */
    private static final C0014c f3856i = new C0014c(C1447g.f3450N, (byte) 12, 3);

    /* renamed from: j */
    private static final Map<Class<? extends AbstractC0029a>, AbstractC0030b> f3857j = new HashMap();

    /* renamed from: k */
    private static final int f3858k = 0;

    /* renamed from: a */
    public int f3859a;

    /* renamed from: b */
    public String f3860b;

    /* renamed from: c */
    public C1521e f3861c;

    /* renamed from: l */
    private byte f3862l;

    /* renamed from: m */
    private EnumC1541e[] f3863m;

    static {
        f3857j.put(AbstractC0031c.class, new C1538b());
        f3857j.put(AbstractC0032d.class, new C1540d());
        EnumMap enumMap = new EnumMap(EnumC1541e.class);
        enumMap.put((Object) EnumC1541e.RESP_CODE, (Object) new C0002b("resp_code", (byte) 1, new C0003c((byte) 8)));
        enumMap.put((Object) EnumC1541e.MSG, (Object) new C0002b("msg", (byte) 2, new C0003c((byte) 11)));
        enumMap.put((Object) EnumC1541e.IMPRINT, (Object) new C0002b(C1447g.f3450N, (byte) 2, new C0007g((byte) 12, C1521e.class)));
        f3851d = Collections.unmodifiableMap(enumMap);
        C0002b.m17a(C1535g.class, f3851d);
    }

    /* renamed from: com.umeng.analytics.f.g$e */
    /* compiled from: Response */
    public enum EnumC1541e implements AbstractC0047k {
        RESP_CODE(1, "resp_code"),
        MSG(2, "msg"),
        IMPRINT(3, C1447g.f3450N);
        

        /* renamed from: d */
        private static final Map<String, EnumC1541e> f3867d = new HashMap();

        /* renamed from: e */
        private final short f3869e;

        /* renamed from: f */
        private final String f3870f;

        static {
            Iterator it = EnumSet.allOf(EnumC1541e.class).iterator();
            while (it.hasNext()) {
                EnumC1541e eVar = (EnumC1541e) it.next();
                f3867d.put(eVar.mo114b(), eVar);
            }
        }

        /* renamed from: a */
        public static EnumC1541e m5880a(int i) {
            switch (i) {
                case 1:
                    return RESP_CODE;
                case 2:
                    return MSG;
                case 3:
                    return IMPRINT;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static EnumC1541e m5882b(int i) {
            EnumC1541e a = m5880a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        /* renamed from: a */
        public static EnumC1541e m5881a(String str) {
            return f3867d.get(str);
        }

        private EnumC1541e(short s, String str) {
            this.f3869e = s;
            this.f3870f = str;
        }

        @Override // p000a.p001a.p002a.AbstractC0047k
        /* renamed from: a */
        public short mo113a() {
            return this.f3869e;
        }

        @Override // p000a.p001a.p002a.AbstractC0047k
        /* renamed from: b */
        public String mo114b() {
            return this.f3870f;
        }
    }

    public C1535g() {
        this.f3862l = 0;
        this.f3863m = new EnumC1541e[]{EnumC1541e.MSG, EnumC1541e.IMPRINT};
    }

    public C1535g(int i) {
        this();
        this.f3859a = i;
        mo8828a(true);
    }

    public C1535g(C1535g gVar) {
        this.f3862l = 0;
        this.f3863m = new EnumC1541e[]{EnumC1541e.MSG, EnumC1541e.IMPRINT};
        this.f3862l = gVar.f3862l;
        this.f3859a = gVar.f3859a;
        if (gVar.mo8837h()) {
            this.f3860b = gVar.f3860b;
        }
        if (gVar.mo8840k()) {
            this.f3861c = new C1521e(gVar.f3861c);
        }
    }

    /* renamed from: a */
    public C1535g mo77p() {
        return new C1535g(this);
    }

    @Override // p000a.p001a.p002a.AbstractC0033d
    /* renamed from: b */
    public void mo75b() {
        mo8828a(false);
        this.f3859a = 0;
        this.f3860b = null;
        this.f3861c = null;
    }

    /* renamed from: c */
    public int mo8830c() {
        return this.f3859a;
    }

    /* renamed from: a */
    public C1535g mo8825a(int i) {
        this.f3859a = i;
        mo8828a(true);
        return this;
    }

    /* renamed from: d */
    public void mo8833d() {
        this.f3862l = C0000a.m12b(this.f3862l, 0);
    }

    /* renamed from: e */
    public boolean mo8834e() {
        return C0000a.m8a(this.f3862l, 0);
    }

    /* renamed from: a */
    public void mo8828a(boolean z) {
        this.f3862l = C0000a.m0a(this.f3862l, 0, z);
    }

    /* renamed from: f */
    public String mo8835f() {
        return this.f3860b;
    }

    /* renamed from: a */
    public C1535g mo8827a(String str) {
        this.f3860b = str;
        return this;
    }

    /* renamed from: g */
    public void mo8836g() {
        this.f3860b = null;
    }

    /* renamed from: h */
    public boolean mo8837h() {
        return this.f3860b != null;
    }

    /* renamed from: b */
    public void mo8829b(boolean z) {
        if (!z) {
            this.f3860b = null;
        }
    }

    /* renamed from: i */
    public C1521e mo8838i() {
        return this.f3861c;
    }

    /* renamed from: a */
    public C1535g mo8826a(C1521e eVar) {
        this.f3861c = eVar;
        return this;
    }

    /* renamed from: j */
    public void mo8839j() {
        this.f3861c = null;
    }

    /* renamed from: k */
    public boolean mo8840k() {
        return this.f3861c != null;
    }

    /* renamed from: c */
    public void mo8832c(boolean z) {
        if (!z) {
            this.f3861c = null;
        }
    }

    /* renamed from: c */
    public EnumC1541e mo74b(int i) {
        return EnumC1541e.m5880a(i);
    }

    @Override // p000a.p001a.p002a.AbstractC0033d
    /* renamed from: a */
    public void mo73a(AbstractC0019h hVar) throws C0046j {
        f3857j.get(hVar.mo64D()).mo72b().mo71b(hVar, this);
    }

    @Override // p000a.p001a.p002a.AbstractC0033d
    /* renamed from: b */
    public void mo76b(AbstractC0019h hVar) throws C0046j {
        f3857j.get(hVar.mo64D()).mo72b().mo70a(hVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Response(");
        sb.append("resp_code:");
        sb.append(this.f3859a);
        if (mo8837h()) {
            sb.append(", ");
            sb.append("msg:");
            if (this.f3860b == null) {
                sb.append("null");
            } else {
                sb.append(this.f3860b);
            }
        }
        if (mo8840k()) {
            sb.append(", ");
            sb.append("imprint:");
            if (this.f3861c == null) {
                sb.append("null");
            } else {
                sb.append(this.f3861c);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: l */
    public void mo8841l() throws C0046j {
        if (this.f3861c != null) {
            this.f3861c.mo8791m();
        }
    }

    /* renamed from: a */
    private void m5840a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            mo76b(new C0011b(new C0034a(objectOutputStream)));
        } catch (C0046j e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m5839a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f3862l = 0;
            mo73a(new C0011b(new C0034a(objectInputStream)));
        } catch (C0046j e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: com.umeng.analytics.f.g$b */
    /* compiled from: Response */
    private static class C1538b implements AbstractC0030b {
        private C1538b() {
        }

        /* renamed from: a */
        public C1537a mo72b() {
            return new C1537a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.umeng.analytics.f.g$a */
    /* compiled from: Response */
    public static class C1537a extends AbstractC0031c<C1535g> {
        private C1537a() {
        }

        /* renamed from: a */
        public void mo71b(AbstractC0019h hVar, C1535g gVar) throws C0046j {
            hVar.mo38j();
            while (true) {
                C0014c l = hVar.mo40l();
                if (l.f65b == 0) {
                    hVar.mo39k();
                    if (!gVar.mo8834e()) {
                        throw new C0020i("Required field 'resp_code' was not found in serialized data! Struct: " + toString());
                    }
                    gVar.mo8841l();
                    return;
                }
                switch (l.f66c) {
                    case 1:
                        if (l.f65b != 8) {
                            C0022k.m187a(hVar, l.f65b);
                            break;
                        } else {
                            gVar.f3859a = hVar.mo51w();
                            gVar.mo8828a(true);
                            break;
                        }
                    case 2:
                        if (l.f65b != 11) {
                            C0022k.m187a(hVar, l.f65b);
                            break;
                        } else {
                            gVar.f3860b = hVar.mo54z();
                            gVar.mo8829b(true);
                            break;
                        }
                    case 3:
                        if (l.f65b != 12) {
                            C0022k.m187a(hVar, l.f65b);
                            break;
                        } else {
                            gVar.f3861c = new C1521e();
                            gVar.f3861c.mo73a(hVar);
                            gVar.mo8832c(true);
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
        public void mo70a(AbstractC0019h hVar, C1535g gVar) throws C0046j {
            gVar.mo8841l();
            hVar.mo22a(C1535g.f3853f);
            hVar.mo17a(C1535g.f3854g);
            hVar.mo15a(gVar.f3859a);
            hVar.mo29c();
            if (gVar.f3860b != null && gVar.mo8837h()) {
                hVar.mo17a(C1535g.f3855h);
                hVar.mo23a(gVar.f3860b);
                hVar.mo29c();
            }
            if (gVar.f3861c != null && gVar.mo8840k()) {
                hVar.mo17a(C1535g.f3856i);
                gVar.f3861c.mo76b(hVar);
                hVar.mo29c();
            }
            hVar.mo31d();
            hVar.mo28b();
        }
    }

    /* renamed from: com.umeng.analytics.f.g$d */
    /* compiled from: Response */
    private static class C1540d implements AbstractC0030b {
        private C1540d() {
        }

        /* renamed from: a */
        public C1539c mo72b() {
            return new C1539c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.umeng.analytics.f.g$c */
    /* compiled from: Response */
    public static class C1539c extends AbstractC0032d<C1535g> {
        private C1539c() {
        }

        /* renamed from: a */
        public void mo70a(AbstractC0019h hVar, C1535g gVar) throws C0046j {
            C0025n nVar = (C0025n) hVar;
            nVar.mo15a(gVar.f3859a);
            BitSet bitSet = new BitSet();
            if (gVar.mo8837h()) {
                bitSet.set(0);
            }
            if (gVar.mo8840k()) {
                bitSet.set(1);
            }
            nVar.mo66a(bitSet, 2);
            if (gVar.mo8837h()) {
                nVar.mo23a(gVar.f3860b);
            }
            if (gVar.mo8840k()) {
                gVar.f3861c.mo76b(nVar);
            }
        }

        /* renamed from: b */
        public void mo71b(AbstractC0019h hVar, C1535g gVar) throws C0046j {
            C0025n nVar = (C0025n) hVar;
            gVar.f3859a = nVar.mo51w();
            gVar.mo8828a(true);
            BitSet b = nVar.mo67b(2);
            if (b.get(0)) {
                gVar.f3860b = nVar.mo54z();
                gVar.mo8829b(true);
            }
            if (b.get(1)) {
                gVar.f3861c = new C1521e();
                gVar.f3861c.mo73a(nVar);
                gVar.mo8832c(true);
            }
        }
    }
}
