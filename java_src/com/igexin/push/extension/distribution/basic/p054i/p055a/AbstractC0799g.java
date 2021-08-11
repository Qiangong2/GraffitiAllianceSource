package com.igexin.push.extension.distribution.basic.p054i.p055a;

import com.igexin.push.extension.distribution.basic.p054i.AbstractC0804b;
import com.igexin.push.extension.distribution.basic.p054i.EnumC0933d;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.basic.i.a.g */
public abstract class AbstractC0799g<T extends AbstractC0804b> implements AbstractC0804b<T> {

    /* renamed from: a */
    URL f2246a;

    /* renamed from: b */
    EnumC0933d f2247b;

    /* renamed from: c */
    Map<String, String> f2248c;

    /* renamed from: d */
    Map<String, String> f2249d;

    private AbstractC0799g() {
        this.f2248c = new LinkedHashMap();
        this.f2249d = new LinkedHashMap();
    }

    /* renamed from: e */
    private String m3340e(String str) {
        Map.Entry<String, String> f;
        C0803k.m3394a((Object) str, "Header name must not be null");
        String str2 = this.f2248c.get(str);
        if (str2 == null) {
            str2 = this.f2248c.get(str.toLowerCase());
        }
        return (str2 != null || (f = m3341f(str)) == null) ? str2 : f.getValue();
    }

    /* renamed from: f */
    private Map.Entry<String, String> m3341f(String str) {
        String lowerCase = str.toLowerCase();
        for (Map.Entry<String, String> entry : this.f2248c.entrySet()) {
            if (entry.getKey().toLowerCase().equals(lowerCase)) {
                return entry;
            }
        }
        return null;
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.AbstractC0804b
    /* renamed from: a */
    public T mo5252a(EnumC0933d dVar) {
        C0803k.m3394a(dVar, "Method must not be null");
        this.f2247b = dVar;
        return this;
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.AbstractC0804b
    /* renamed from: a */
    public T mo5253a(String str, String str2) {
        C0803k.m3396a(str, "Cookie name must not be empty");
        C0803k.m3394a((Object) str2, "Cookie value must not be null");
        this.f2249d.put(str, str2);
        return this;
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.AbstractC0804b
    /* renamed from: a */
    public T mo5254a(URL url) {
        C0803k.m3394a(url, "URL must not be null");
        this.f2246a = url;
        return this;
    }

    /* renamed from: a */
    public String mo5255a(String str) {
        C0803k.m3394a((Object) str, "Header name must not be null");
        return m3340e(str);
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.AbstractC0804b
    /* renamed from: a */
    public URL mo5256a() {
        return this.f2246a;
    }

    /* renamed from: b */
    public T mo5257b(String str, String str2) {
        C0803k.m3396a(str, "Header name must not be empty");
        C0803k.m3394a((Object) str2, "Header value must not be null");
        mo5260c(str);
        this.f2248c.put(str, str2);
        return this;
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.AbstractC0804b
    /* renamed from: b */
    public EnumC0933d mo5258b() {
        return this.f2247b;
    }

    /* renamed from: b */
    public boolean mo5259b(String str) {
        C0803k.m3396a(str, "Header name must not be empty");
        return m3340e(str) != null;
    }

    /* renamed from: c */
    public T mo5260c(String str) {
        C0803k.m3396a(str, "Header name must not be empty");
        Map.Entry<String, String> f = m3341f(str);
        if (f != null) {
            this.f2248c.remove(f.getKey());
        }
        return this;
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.AbstractC0804b
    /* renamed from: c */
    public Map<String, String> mo5261c() {
        return this.f2248c;
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.AbstractC0804b
    /* renamed from: d */
    public Map<String, String> mo5262d() {
        return this.f2249d;
    }

    /* renamed from: d */
    public boolean mo5263d(String str) {
        C0803k.m3395a("Cookie name must not be empty");
        return this.f2249d.containsKey(str);
    }
}
