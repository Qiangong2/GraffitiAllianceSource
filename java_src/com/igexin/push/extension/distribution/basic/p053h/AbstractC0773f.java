package com.igexin.push.extension.distribution.basic.p053h;

import com.igexin.p012b.p013a.p020d.AbstractC0461a;

/* renamed from: com.igexin.push.extension.distribution.basic.h.f */
public abstract class AbstractC0773f extends AbstractC0461a {

    /* renamed from: b */
    String f2140b;

    /* renamed from: c */
    byte[] f2141c;

    /* renamed from: d */
    protected boolean f2142d;

    /* renamed from: e */
    protected boolean f2143e;

    /* renamed from: f */
    protected boolean f2144f;

    /* renamed from: g */
    public boolean f2145g;

    public AbstractC0773f(String str) {
        this.f2140b = str;
    }

    /* renamed from: a */
    public void mo5108a(Exception exc) {
    }

    /* renamed from: a */
    public void mo4764a(byte[] bArr) {
        this.f2145g = false;
        if (bArr != null && bArr.length >= 7 && bArr[5] == 111 && bArr[6] == 107) {
            this.f2145g = true;
        }
    }

    /* renamed from: b */
    public void mo5110b(byte[] bArr) {
        this.f2141c = bArr;
    }

    /* renamed from: c */
    public String mo5111c() {
        return this.f2140b;
    }

    /* renamed from: d */
    public byte[] mo5112d() {
        return this.f2141c;
    }

    /* renamed from: e */
    public boolean mo5113e() {
        return this.f2142d;
    }

    /* renamed from: f */
    public boolean mo5114f() {
        return this.f2143e;
    }
}
