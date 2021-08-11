package com.igexin.push.extension.distribution.basic.p054i.p056b;

import com.igexin.push.extension.distribution.basic.p054i.p055a.C0803k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.igexin.push.extension.distribution.basic.i.b.b */
public class C0806b implements Cloneable, Iterable<C0805a> {

    /* renamed from: a */
    private LinkedHashMap<String, C0805a> f2267a = null;

    /* renamed from: a */
    public int mo5287a() {
        if (this.f2267a == null) {
            return 0;
        }
        return this.f2267a.size();
    }

    /* renamed from: a */
    public String mo5288a(String str) {
        C0805a aVar;
        C0803k.m3395a(str);
        return (this.f2267a == null || (aVar = this.f2267a.get(str.toLowerCase())) == null) ? "" : aVar.getValue();
    }

    /* renamed from: a */
    public void mo5289a(C0805a aVar) {
        C0803k.m3393a(aVar);
        if (this.f2267a == null) {
            this.f2267a = new LinkedHashMap<>(2);
        }
        this.f2267a.put(aVar.getKey(), aVar);
    }

    /* renamed from: a */
    public void mo5290a(C0806b bVar) {
        if (bVar.mo5287a() != 0) {
            if (this.f2267a == null) {
                this.f2267a = new LinkedHashMap<>(bVar.mo5287a());
            }
            this.f2267a.putAll(bVar.f2267a);
        }
    }

    /* renamed from: a */
    public void mo5291a(String str, String str2) {
        mo5289a(new C0805a(str, str2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5292a(StringBuilder sb, C0810f fVar) {
        if (this.f2267a != null) {
            for (Map.Entry<String, C0805a> entry : this.f2267a.entrySet()) {
                sb.append(" ");
                entry.getValue().mo5276a(sb, fVar);
            }
        }
    }

    /* renamed from: b */
    public List<C0805a> mo5293b() {
        if (this.f2267a == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.f2267a.size());
        for (Map.Entry<String, C0805a> entry : this.f2267a.entrySet()) {
            arrayList.add(entry.getValue());
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: b */
    public boolean mo5294b(String str) {
        return this.f2267a != null && this.f2267a.containsKey(str.toLowerCase());
    }

    /* renamed from: c */
    public String mo5295c() {
        StringBuilder sb = new StringBuilder();
        mo5292a(sb, new C0809e("").mo5311d());
        return sb.toString();
    }

    /* renamed from: d */
    public C0806b clone() {
        if (this.f2267a == null) {
            return new C0806b();
        }
        try {
            C0806b bVar = (C0806b) super.clone();
            bVar.f2267a = new LinkedHashMap<>(this.f2267a.size());
            Iterator<C0805a> it = iterator();
            while (it.hasNext()) {
                C0805a next = it.next();
                bVar.f2267a.put(next.getKey(), next.clone());
            }
            return bVar;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0806b)) {
            return false;
        }
        C0806b bVar = (C0806b) obj;
        if (this.f2267a != null) {
            if (this.f2267a.equals(bVar.f2267a)) {
                return true;
            }
        } else if (bVar.f2267a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.f2267a != null) {
            return this.f2267a.hashCode();
        }
        return 0;
    }

    @Override // java.lang.Iterable
    public Iterator<C0805a> iterator() {
        return mo5293b().iterator();
    }

    public String toString() {
        return mo5295c();
    }
}
