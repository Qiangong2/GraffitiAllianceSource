package com.igexin.push.extension.distribution.basic.p054i.p056b;

import com.igexin.push.extension.distribution.basic.p054i.p055a.C0803k;
import java.util.Map;

/* renamed from: com.igexin.push.extension.distribution.basic.i.b.a */
public class C0805a implements Cloneable, Map.Entry<String, String> {

    /* renamed from: a */
    private String f2265a;

    /* renamed from: b */
    private String f2266b;

    public C0805a(String str, String str2) {
        C0803k.m3395a(str);
        C0803k.m3393a((Object) str2);
        this.f2265a = str.trim().toLowerCase();
        this.f2266b = str2;
    }

    /* renamed from: a */
    public String getKey() {
        return this.f2265a;
    }

    /* renamed from: a */
    public String setValue(String str) {
        C0803k.m3393a((Object) str);
        String str2 = this.f2266b;
        this.f2266b = str;
        return str2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5276a(StringBuilder sb, C0810f fVar) {
        sb.append(this.f2265a).append("=\"").append(C0814j.m3489a(this.f2266b, fVar)).append("\"");
    }

    /* renamed from: b */
    public String getValue() {
        return this.f2266b;
    }

    /* renamed from: c */
    public String mo5278c() {
        return this.f2265a + "=\"" + C0814j.m3489a(this.f2266b, new C0809e("").mo5311d()) + "\"";
    }

    /* renamed from: d */
    public C0805a clone() {
        try {
            return (C0805a) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0805a)) {
            return false;
        }
        C0805a aVar = (C0805a) obj;
        if (this.f2265a == null ? aVar.f2265a != null : !this.f2265a.equals(aVar.f2265a)) {
            return false;
        }
        if (this.f2266b != null) {
            if (this.f2266b.equals(aVar.f2266b)) {
                return true;
            }
        } else if (aVar.f2266b == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.f2265a != null ? this.f2265a.hashCode() : 0) * 31;
        if (this.f2266b != null) {
            i = this.f2266b.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return mo5278c();
    }
}
