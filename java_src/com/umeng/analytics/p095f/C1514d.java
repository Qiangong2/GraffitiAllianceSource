package com.umeng.analytics.p095f;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p000a.p001a.p002a.AbstractC0033d;
import p000a.p001a.p002a.AbstractC0047k;
import p000a.p001a.p002a.C0046j;
import p000a.p001a.p002a.p003a.C0002b;
import p000a.p001a.p002a.p003a.C0003c;
import p000a.p001a.p002a.p003a.C0004d;
import p000a.p001a.p002a.p003a.C0005e;
import p000a.p001a.p002a.p003a.C0007g;
import p000a.p001a.p002a.p004b.AbstractC0019h;
import p000a.p001a.p002a.p004b.C0011b;
import p000a.p001a.p002a.p004b.C0014c;
import p000a.p001a.p002a.p004b.C0015d;
import p000a.p001a.p002a.p004b.C0016e;
import p000a.p001a.p002a.p004b.C0020i;
import p000a.p001a.p002a.p004b.C0022k;
import p000a.p001a.p002a.p004b.C0024m;
import p000a.p001a.p002a.p004b.C0025n;
import p000a.p001a.p002a.p004b.C0027o;
import p000a.p001a.p002a.p005c.AbstractC0029a;
import p000a.p001a.p002a.p005c.AbstractC0030b;
import p000a.p001a.p002a.p005c.AbstractC0031c;
import p000a.p001a.p002a.p005c.AbstractC0032d;
import p000a.p001a.p002a.p006d.C0034a;

/* renamed from: com.umeng.analytics.f.d */
/* compiled from: IdTracking */
public class C1514d implements AbstractC0033d<C1514d, EnumC1520e>, Serializable, Cloneable {

    /* renamed from: d */
    public static final Map<EnumC1520e, C0002b> f3794d;

    /* renamed from: e */
    private static final long f3795e = -5764118265293965743L;

    /* renamed from: f */
    private static final C0024m f3796f = new C0024m("IdTracking");

    /* renamed from: g */
    private static final C0014c f3797g = new C0014c("snapshots", (byte) 13, 1);

    /* renamed from: h */
    private static final C0014c f3798h = new C0014c("journals", C0027o.f104m, 2);

    /* renamed from: i */
    private static final C0014c f3799i = new C0014c("checksum", (byte) 11, 3);

    /* renamed from: j */
    private static final Map<Class<? extends AbstractC0029a>, AbstractC0030b> f3800j = new HashMap();

    /* renamed from: a */
    public Map<String, C1507c> f3801a;

    /* renamed from: b */
    public List<C1500b> f3802b;

    /* renamed from: c */
    public String f3803c;

    /* renamed from: k */
    private EnumC1520e[] f3804k;

    static {
        f3800j.put(AbstractC0031c.class, new C1517b());
        f3800j.put(AbstractC0032d.class, new C1519d());
        EnumMap enumMap = new EnumMap(EnumC1520e.class);
        enumMap.put((Object) EnumC1520e.SNAPSHOTS, (Object) new C0002b("snapshots", (byte) 1, new C0005e((byte) 13, new C0003c((byte) 11), new C0007g((byte) 12, C1507c.class))));
        enumMap.put((Object) EnumC1520e.JOURNALS, (Object) new C0002b("journals", (byte) 2, new C0004d(C0027o.f104m, new C0007g((byte) 12, C1500b.class))));
        enumMap.put((Object) EnumC1520e.CHECKSUM, (Object) new C0002b("checksum", (byte) 2, new C0003c((byte) 11)));
        f3794d = Collections.unmodifiableMap(enumMap);
        C0002b.m17a(C1514d.class, f3794d);
    }

    /* renamed from: com.umeng.analytics.f.d$e */
    /* compiled from: IdTracking */
    public enum EnumC1520e implements AbstractC0047k {
        SNAPSHOTS(1, "snapshots"),
        JOURNALS(2, "journals"),
        CHECKSUM(3, "checksum");
        

        /* renamed from: d */
        private static final Map<String, EnumC1520e> f3808d = new HashMap();

        /* renamed from: e */
        private final short f3810e;

        /* renamed from: f */
        private final String f3811f;

        static {
            Iterator it = EnumSet.allOf(EnumC1520e.class).iterator();
            while (it.hasNext()) {
                EnumC1520e eVar = (EnumC1520e) it.next();
                f3808d.put(eVar.mo114b(), eVar);
            }
        }

        /* renamed from: a */
        public static EnumC1520e m5740a(int i) {
            switch (i) {
                case 1:
                    return SNAPSHOTS;
                case 2:
                    return JOURNALS;
                case 3:
                    return CHECKSUM;
                default:
                    return null;
            }
        }

        /* renamed from: b */
        public static EnumC1520e m5742b(int i) {
            EnumC1520e a = m5740a(i);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        /* renamed from: a */
        public static EnumC1520e m5741a(String str) {
            return f3808d.get(str);
        }

        private EnumC1520e(short s, String str) {
            this.f3810e = s;
            this.f3811f = str;
        }

        @Override // p000a.p001a.p002a.AbstractC0047k
        /* renamed from: a */
        public short mo113a() {
            return this.f3810e;
        }

        @Override // p000a.p001a.p002a.AbstractC0047k
        /* renamed from: b */
        public String mo114b() {
            return this.f3811f;
        }
    }

    public C1514d() {
        this.f3804k = new EnumC1520e[]{EnumC1520e.JOURNALS, EnumC1520e.CHECKSUM};
    }

    public C1514d(Map<String, C1507c> map) {
        this();
        this.f3801a = map;
    }

    public C1514d(C1514d dVar) {
        this.f3804k = new EnumC1520e[]{EnumC1520e.JOURNALS, EnumC1520e.CHECKSUM};
        if (dVar.mo8755f()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, C1507c> entry : dVar.f3801a.entrySet()) {
                hashMap.put(entry.getKey(), new C1507c(entry.getValue()));
            }
            this.f3801a = hashMap;
        }
        if (dVar.mo8760k()) {
            ArrayList arrayList = new ArrayList();
            for (C1500b bVar : dVar.f3802b) {
                arrayList.add(new C1500b(bVar));
            }
            this.f3802b = arrayList;
        }
        if (dVar.mo8763n()) {
            this.f3803c = dVar.f3803c;
        }
    }

    /* renamed from: a */
    public C1514d mo77p() {
        return new C1514d(this);
    }

    @Override // p000a.p001a.p002a.AbstractC0033d
    /* renamed from: b */
    public void mo75b() {
        this.f3801a = null;
        this.f3802b = null;
        this.f3803c = null;
    }

    /* renamed from: c */
    public int mo8751c() {
        if (this.f3801a == null) {
            return 0;
        }
        return this.f3801a.size();
    }

    /* renamed from: a */
    public void mo8748a(String str, C1507c cVar) {
        if (this.f3801a == null) {
            this.f3801a = new HashMap();
        }
        this.f3801a.put(str, cVar);
    }

    /* renamed from: d */
    public Map<String, C1507c> mo8753d() {
        return this.f3801a;
    }

    /* renamed from: a */
    public C1514d mo8746a(Map<String, C1507c> map) {
        this.f3801a = map;
        return this;
    }

    /* renamed from: e */
    public void mo8754e() {
        this.f3801a = null;
    }

    /* renamed from: f */
    public boolean mo8755f() {
        return this.f3801a != null;
    }

    /* renamed from: a */
    public void mo8749a(boolean z) {
        if (!z) {
            this.f3801a = null;
        }
    }

    /* renamed from: g */
    public int mo8756g() {
        if (this.f3802b == null) {
            return 0;
        }
        return this.f3802b.size();
    }

    /* renamed from: h */
    public Iterator<C1500b> mo8757h() {
        if (this.f3802b == null) {
            return null;
        }
        return this.f3802b.iterator();
    }

    /* renamed from: a */
    public void mo8747a(C1500b bVar) {
        if (this.f3802b == null) {
            this.f3802b = new ArrayList();
        }
        this.f3802b.add(bVar);
    }

    /* renamed from: i */
    public List<C1500b> mo8758i() {
        return this.f3802b;
    }

    /* renamed from: a */
    public C1514d mo8745a(List<C1500b> list) {
        this.f3802b = list;
        return this;
    }

    /* renamed from: j */
    public void mo8759j() {
        this.f3802b = null;
    }

    /* renamed from: k */
    public boolean mo8760k() {
        return this.f3802b != null;
    }

    /* renamed from: b */
    public void mo8750b(boolean z) {
        if (!z) {
            this.f3802b = null;
        }
    }

    /* renamed from: l */
    public String mo8761l() {
        return this.f3803c;
    }

    /* renamed from: a */
    public C1514d mo8744a(String str) {
        this.f3803c = str;
        return this;
    }

    /* renamed from: m */
    public void mo8762m() {
        this.f3803c = null;
    }

    /* renamed from: n */
    public boolean mo8763n() {
        return this.f3803c != null;
    }

    /* renamed from: c */
    public void mo8752c(boolean z) {
        if (!z) {
            this.f3803c = null;
        }
    }

    /* renamed from: a */
    public EnumC1520e mo74b(int i) {
        return EnumC1520e.m5740a(i);
    }

    @Override // p000a.p001a.p002a.AbstractC0033d
    /* renamed from: a */
    public void mo73a(AbstractC0019h hVar) throws C0046j {
        f3800j.get(hVar.mo64D()).mo72b().mo71b(hVar, this);
    }

    @Override // p000a.p001a.p002a.AbstractC0033d
    /* renamed from: b */
    public void mo76b(AbstractC0019h hVar) throws C0046j {
        f3800j.get(hVar.mo64D()).mo72b().mo70a(hVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdTracking(");
        sb.append("snapshots:");
        if (this.f3801a == null) {
            sb.append("null");
        } else {
            sb.append(this.f3801a);
        }
        if (mo8760k()) {
            sb.append(", ");
            sb.append("journals:");
            if (this.f3802b == null) {
                sb.append("null");
            } else {
                sb.append(this.f3802b);
            }
        }
        if (mo8763n()) {
            sb.append(", ");
            sb.append("checksum:");
            if (this.f3803c == null) {
                sb.append("null");
            } else {
                sb.append(this.f3803c);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: o */
    public void mo8764o() throws C0046j {
        if (this.f3801a == null) {
            throw new C0020i("Required field 'snapshots' was not present! Struct: " + toString());
        }
    }

    /* renamed from: a */
    private void m5695a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            mo76b(new C0011b(new C0034a(objectOutputStream)));
        } catch (C0046j e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m5694a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            mo73a(new C0011b(new C0034a(objectInputStream)));
        } catch (C0046j e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: com.umeng.analytics.f.d$b */
    /* compiled from: IdTracking */
    private static class C1517b implements AbstractC0030b {
        private C1517b() {
        }

        /* renamed from: a */
        public C1516a mo72b() {
            return new C1516a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.umeng.analytics.f.d$a */
    /* compiled from: IdTracking */
    public static class C1516a extends AbstractC0031c<C1514d> {
        private C1516a() {
        }

        /* renamed from: a */
        public void mo71b(AbstractC0019h hVar, C1514d dVar) throws C0046j {
            hVar.mo38j();
            while (true) {
                C0014c l = hVar.mo40l();
                if (l.f65b == 0) {
                    hVar.mo39k();
                    dVar.mo8764o();
                    return;
                }
                switch (l.f66c) {
                    case 1:
                        if (l.f65b == 13) {
                            C0016e n = hVar.mo42n();
                            dVar.f3801a = new HashMap(n.f71c * 2);
                            for (int i = 0; i < n.f71c; i++) {
                                String z = hVar.mo54z();
                                C1507c cVar = new C1507c();
                                cVar.mo73a(hVar);
                                dVar.f3801a.put(z, cVar);
                            }
                            hVar.mo43o();
                            dVar.mo8749a(true);
                            break;
                        } else {
                            C0022k.m187a(hVar, l.f65b);
                            break;
                        }
                    case 2:
                        if (l.f65b == 15) {
                            C0015d p = hVar.mo44p();
                            dVar.f3802b = new ArrayList(p.f68b);
                            for (int i2 = 0; i2 < p.f68b; i2++) {
                                C1500b bVar = new C1500b();
                                bVar.mo73a(hVar);
                                dVar.f3802b.add(bVar);
                            }
                            hVar.mo45q();
                            dVar.mo8750b(true);
                            break;
                        } else {
                            C0022k.m187a(hVar, l.f65b);
                            break;
                        }
                    case 3:
                        if (l.f65b == 11) {
                            dVar.f3803c = hVar.mo54z();
                            dVar.mo8752c(true);
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
        public void mo70a(AbstractC0019h hVar, C1514d dVar) throws C0046j {
            dVar.mo8764o();
            hVar.mo22a(C1514d.f3796f);
            if (dVar.f3801a != null) {
                hVar.mo17a(C1514d.f3797g);
                hVar.mo19a(new C0016e((byte) 11, (byte) 12, dVar.f3801a.size()));
                for (Map.Entry<String, C1507c> entry : dVar.f3801a.entrySet()) {
                    hVar.mo23a(entry.getKey());
                    entry.getValue().mo76b(hVar);
                }
                hVar.mo33e();
                hVar.mo29c();
            }
            if (dVar.f3802b != null && dVar.mo8760k()) {
                hVar.mo17a(C1514d.f3798h);
                hVar.mo18a(new C0015d((byte) 12, dVar.f3802b.size()));
                for (C1500b bVar : dVar.f3802b) {
                    bVar.mo76b(hVar);
                }
                hVar.mo34f();
                hVar.mo29c();
            }
            if (dVar.f3803c != null && dVar.mo8763n()) {
                hVar.mo17a(C1514d.f3799i);
                hVar.mo23a(dVar.f3803c);
                hVar.mo29c();
            }
            hVar.mo31d();
            hVar.mo28b();
        }
    }

    /* renamed from: com.umeng.analytics.f.d$d */
    /* compiled from: IdTracking */
    private static class C1519d implements AbstractC0030b {
        private C1519d() {
        }

        /* renamed from: a */
        public C1518c mo72b() {
            return new C1518c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.umeng.analytics.f.d$c */
    /* compiled from: IdTracking */
    public static class C1518c extends AbstractC0032d<C1514d> {
        private C1518c() {
        }

        /* renamed from: a */
        public void mo70a(AbstractC0019h hVar, C1514d dVar) throws C0046j {
            C0025n nVar = (C0025n) hVar;
            nVar.mo15a(dVar.f3801a.size());
            for (Map.Entry<String, C1507c> entry : dVar.f3801a.entrySet()) {
                nVar.mo23a(entry.getKey());
                entry.getValue().mo76b(nVar);
            }
            BitSet bitSet = new BitSet();
            if (dVar.mo8760k()) {
                bitSet.set(0);
            }
            if (dVar.mo8763n()) {
                bitSet.set(1);
            }
            nVar.mo66a(bitSet, 2);
            if (dVar.mo8760k()) {
                nVar.mo15a(dVar.f3802b.size());
                for (C1500b bVar : dVar.f3802b) {
                    bVar.mo76b(nVar);
                }
            }
            if (dVar.mo8763n()) {
                nVar.mo23a(dVar.f3803c);
            }
        }

        /* renamed from: b */
        public void mo71b(AbstractC0019h hVar, C1514d dVar) throws C0046j {
            C0025n nVar = (C0025n) hVar;
            C0016e eVar = new C0016e((byte) 11, (byte) 12, nVar.mo51w());
            dVar.f3801a = new HashMap(eVar.f71c * 2);
            for (int i = 0; i < eVar.f71c; i++) {
                String z = nVar.mo54z();
                C1507c cVar = new C1507c();
                cVar.mo73a(nVar);
                dVar.f3801a.put(z, cVar);
            }
            dVar.mo8749a(true);
            BitSet b = nVar.mo67b(2);
            if (b.get(0)) {
                C0015d dVar2 = new C0015d((byte) 12, nVar.mo51w());
                dVar.f3802b = new ArrayList(dVar2.f68b);
                for (int i2 = 0; i2 < dVar2.f68b; i2++) {
                    C1500b bVar = new C1500b();
                    bVar.mo73a(nVar);
                    dVar.f3802b.add(bVar);
                }
                dVar.mo8750b(true);
            }
            if (b.get(1)) {
                dVar.f3803c = nVar.mo54z();
                dVar.mo8752c(true);
            }
        }
    }
}
