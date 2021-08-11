package com.igexin.push.extension.distribution.basic.p054i.p057c;

import com.igexin.push.extension.distribution.basic.p054i.p056b.C0809e;

/* renamed from: com.igexin.push.extension.distribution.basic.i.c.ad */
public class C0825ad {

    /* renamed from: a */
    private AbstractC0910dh f2310a;

    /* renamed from: b */
    private int f2311b = 0;

    /* renamed from: c */
    private C0824ac f2312c;

    public C0825ad(AbstractC0910dh dhVar) {
        this.f2310a = dhVar;
    }

    /* renamed from: b */
    public static C0825ad m3581b() {
        return new C0825ad(new C0848b());
    }

    /* renamed from: a */
    public C0809e mo5406a(String str, String str2) {
        this.f2312c = mo5407a() ? C0824ac.m3578a(this.f2311b) : C0824ac.m3579b();
        return this.f2310a.mo5490a(str, str2, this.f2312c);
    }

    /* renamed from: a */
    public boolean mo5407a() {
        return this.f2311b > 0;
    }
}
