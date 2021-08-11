package p000a.p001a.p002a;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p000a.p001a.p002a.AbstractC0047k;
import p000a.p001a.p002a.AbstractC0050n;
import p000a.p001a.p002a.p004b.AbstractC0019h;
import p000a.p001a.p002a.p004b.C0014c;
import p000a.p001a.p002a.p004b.C0020i;
import p000a.p001a.p002a.p004b.C0024m;
import p000a.p001a.p002a.p005c.AbstractC0029a;
import p000a.p001a.p002a.p005c.AbstractC0030b;
import p000a.p001a.p002a.p005c.AbstractC0031c;
import p000a.p001a.p002a.p005c.AbstractC0032d;

/* renamed from: a.a.a.n */
/* compiled from: TUnion */
public abstract class AbstractC0050n<T extends AbstractC0050n<?, ?>, F extends AbstractC0047k> implements AbstractC0033d<T, F> {

    /* renamed from: c */
    private static final Map<Class<? extends AbstractC0029a>, AbstractC0030b> f141c = new HashMap();

    /* renamed from: a */
    protected Object f142a;

    /* renamed from: b */
    protected F f143b;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract F mo119a(short s);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Object mo121a(AbstractC0019h hVar, C0014c cVar) throws C0046j;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Object mo122a(AbstractC0019h hVar, short s) throws C0046j;

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo126b(F f, Object obj) throws ClassCastException;

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract C0014c mo128c(F f);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo130c(AbstractC0019h hVar) throws C0046j;

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract void mo132d(AbstractC0019h hVar) throws C0046j;

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public abstract C0024m mo134e();

    protected AbstractC0050n() {
        this.f143b = null;
        this.f142a = null;
    }

    static {
        f141c.put(AbstractC0031c.class, new C0053b());
        f141c.put(AbstractC0032d.class, new C0055d());
    }

    protected AbstractC0050n(F f, Object obj) {
        mo125a(f, obj);
    }

    protected AbstractC0050n(AbstractC0050n<T, F> nVar) {
        if (!nVar.getClass().equals(getClass())) {
            throw new ClassCastException();
        }
        this.f143b = nVar.f143b;
        this.f142a = m284a(nVar.f142a);
    }

    /* renamed from: a */
    private static Object m284a(Object obj) {
        if (obj instanceof AbstractC0033d) {
            return ((AbstractC0033d) obj).mo77p();
        }
        if (obj instanceof ByteBuffer) {
            return C0039e.m259d((ByteBuffer) obj);
        }
        if (obj instanceof List) {
            return m285a((List) obj);
        }
        if (obj instanceof Set) {
            return m287a((Set) obj);
        }
        if (obj instanceof Map) {
            return m286a((Map<Object, Object>) ((Map) obj));
        }
        return obj;
    }

    /* renamed from: a */
    private static Map m286a(Map<Object, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            hashMap.put(m284a(entry.getKey()), m284a(entry.getValue()));
        }
        return hashMap;
    }

    /* renamed from: a */
    private static Set m287a(Set set) {
        HashSet hashSet = new HashSet();
        for (Object obj : set) {
            hashSet.add(m284a(obj));
        }
        return hashSet;
    }

    /* renamed from: a */
    private static List m285a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Object obj : list) {
            arrayList.add(m284a(obj));
        }
        return arrayList;
    }

    /* renamed from: a */
    public F mo118a() {
        return this.f143b;
    }

    /* renamed from: c */
    public Object mo129c() {
        return this.f142a;
    }

    /* renamed from: a */
    public Object mo123a(F f) {
        if (f == this.f143b) {
            return mo129c();
        }
        throw new IllegalArgumentException("Cannot get the value of field " + f + " because union's set field is " + this.f143b);
    }

    /* renamed from: a */
    public Object mo120a(int i) {
        return mo123a((AbstractC0047k) mo119a((short) i));
    }

    /* renamed from: d */
    public boolean mo133d() {
        return this.f143b != null;
    }

    /* renamed from: b */
    public boolean mo127b(F f) {
        return this.f143b == f;
    }

    /* renamed from: c */
    public boolean mo131c(int i) {
        return mo127b(mo119a((short) i));
    }

    @Override // p000a.p001a.p002a.AbstractC0033d
    /* renamed from: a */
    public void mo73a(AbstractC0019h hVar) throws C0046j {
        f141c.get(hVar.mo64D()).mo72b().mo71b(hVar, this);
    }

    /* renamed from: a */
    public void mo125a(F f, Object obj) {
        mo126b(f, obj);
        this.f143b = f;
        this.f142a = obj;
    }

    /* renamed from: a */
    public void mo124a(int i, Object obj) {
        mo125a(mo119a((short) i), obj);
    }

    @Override // p000a.p001a.p002a.AbstractC0033d
    /* renamed from: b */
    public void mo76b(AbstractC0019h hVar) throws C0046j {
        f141c.get(hVar.mo64D()).mo72b().mo70a(hVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SimpleComparison.LESS_THAN_OPERATION);
        sb.append(getClass().getSimpleName());
        sb.append(" ");
        if (mo118a() != null) {
            Object c = mo129c();
            sb.append(mo128c(mo118a()).f64a);
            sb.append(":");
            if (c instanceof ByteBuffer) {
                C0039e.m254a((ByteBuffer) c, sb);
            } else {
                sb.append(c.toString());
            }
        }
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        return sb.toString();
    }

    @Override // p000a.p001a.p002a.AbstractC0033d
    /* renamed from: b */
    public final void mo75b() {
        this.f143b = null;
        this.f142a = null;
    }

    /* renamed from: a.a.a.n$b */
    /* compiled from: TUnion */
    private static class C0053b implements AbstractC0030b {
        private C0053b() {
        }

        /* renamed from: a */
        public C0052a mo72b() {
            return new C0052a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a.a.a.n$a */
    /* compiled from: TUnion */
    public static class C0052a extends AbstractC0031c<AbstractC0050n> {
        private C0052a() {
        }

        /* renamed from: a */
        public void mo71b(AbstractC0019h hVar, AbstractC0050n nVar) throws C0046j {
            nVar.f143b = null;
            nVar.f142a = null;
            hVar.mo38j();
            C0014c l = hVar.mo40l();
            nVar.f142a = nVar.mo121a(hVar, l);
            if (nVar.f142a != null) {
                nVar.f143b = (F) nVar.mo119a(l.f66c);
            }
            hVar.mo41m();
            hVar.mo40l();
            hVar.mo39k();
        }

        /* renamed from: b */
        public void mo70a(AbstractC0019h hVar, AbstractC0050n nVar) throws C0046j {
            if (nVar.mo118a() == null || nVar.mo129c() == null) {
                throw new C0020i("Cannot write a TUnion with no set value!");
            }
            hVar.mo22a(nVar.mo134e());
            hVar.mo17a(nVar.mo128c(nVar.f143b));
            nVar.mo130c(hVar);
            hVar.mo29c();
            hVar.mo31d();
            hVar.mo28b();
        }
    }

    /* renamed from: a.a.a.n$d */
    /* compiled from: TUnion */
    private static class C0055d implements AbstractC0030b {
        private C0055d() {
        }

        /* renamed from: a */
        public C0054c mo72b() {
            return new C0054c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a.a.a.n$c */
    /* compiled from: TUnion */
    public static class C0054c extends AbstractC0032d<AbstractC0050n> {
        private C0054c() {
        }

        /* renamed from: a */
        public void mo71b(AbstractC0019h hVar, AbstractC0050n nVar) throws C0046j {
            nVar.f143b = null;
            nVar.f142a = null;
            short v = hVar.mo50v();
            nVar.f142a = nVar.mo122a(hVar, v);
            if (nVar.f142a != null) {
                nVar.f143b = (F) nVar.mo119a(v);
            }
        }

        /* renamed from: b */
        public void mo70a(AbstractC0019h hVar, AbstractC0050n nVar) throws C0046j {
            if (nVar.mo118a() == null || nVar.mo129c() == null) {
                throw new C0020i("Cannot write a TUnion with no set value!");
            }
            hVar.mo25a(nVar.f143b.mo113a());
            nVar.mo132d(hVar);
        }
    }
}
