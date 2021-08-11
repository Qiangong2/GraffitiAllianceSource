package com.igexin.push.extension.distribution.basic.p054i.p055a;

import com.igexin.push.extension.distribution.basic.p054i.AbstractC0820c;
import com.igexin.push.extension.distribution.basic.p054i.AbstractC0975e;
import com.igexin.push.extension.distribution.basic.p054i.EnumC0933d;
import com.igexin.push.extension.distribution.basic.p054i.p057c.C0825ad;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* renamed from: com.igexin.push.extension.distribution.basic.i.a.h */
public class C0800h extends AbstractC0799g<AbstractC0975e> implements AbstractC0975e {

    /* renamed from: e */
    private int f2250e;

    /* renamed from: f */
    private boolean f2251f;

    /* renamed from: g */
    private Collection<AbstractC0820c> f2252g;

    /* renamed from: h */
    private boolean f2253h;

    /* renamed from: i */
    private boolean f2254i;

    /* renamed from: j */
    private C0825ad f2255j;

    private C0800h() {
        super();
        this.f2253h = false;
        this.f2254i = false;
        this.f2250e = 3000;
        this.f2251f = true;
        this.f2252g = new ArrayList();
        this.f2247b = EnumC0933d.GET;
        this.f2248c.put("Accept-Encoding", "gzip");
        this.f2255j = C0825ad.m3581b();
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p055a.AbstractC0799g
    /* renamed from: a */
    public /* bridge */ /* synthetic */ String mo5255a(String str) {
        return super.mo5255a(str);
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p055a.AbstractC0799g, com.igexin.push.extension.distribution.basic.p054i.AbstractC0804b
    /* renamed from: a */
    public /* bridge */ /* synthetic */ URL mo5256a() {
        return super.mo5256a();
    }

    /* renamed from: b */
    public C0800h mo5264a(int i) {
        C0803k.m3398a(i >= 0, "Timeout milliseconds must be 0 (infinite) or greater");
        this.f2250e = i;
        return this;
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p055a.AbstractC0799g, com.igexin.push.extension.distribution.basic.p054i.AbstractC0804b
    /* renamed from: b */
    public /* bridge */ /* synthetic */ EnumC0933d mo5258b() {
        return super.mo5258b();
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p055a.AbstractC0799g
    /* renamed from: b */
    public /* bridge */ /* synthetic */ boolean mo5259b(String str) {
        return super.mo5259b(str);
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p055a.AbstractC0799g, com.igexin.push.extension.distribution.basic.p054i.AbstractC0804b
    /* renamed from: c */
    public /* bridge */ /* synthetic */ Map mo5261c() {
        return super.mo5261c();
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p055a.AbstractC0799g, com.igexin.push.extension.distribution.basic.p054i.AbstractC0804b
    /* renamed from: d */
    public /* bridge */ /* synthetic */ Map mo5262d() {
        return super.mo5262d();
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p055a.AbstractC0799g
    /* renamed from: d */
    public /* bridge */ /* synthetic */ boolean mo5263d(String str) {
        return super.mo5263d(str);
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.AbstractC0975e
    /* renamed from: e */
    public int mo5266e() {
        return this.f2250e;
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.AbstractC0975e
    /* renamed from: f */
    public boolean mo5267f() {
        return this.f2251f;
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.AbstractC0975e
    /* renamed from: g */
    public boolean mo5268g() {
        return this.f2253h;
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.AbstractC0975e
    /* renamed from: h */
    public boolean mo5269h() {
        return this.f2254i;
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.AbstractC0975e
    /* renamed from: i */
    public Collection<AbstractC0820c> mo5270i() {
        return this.f2252g;
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.AbstractC0975e
    /* renamed from: j */
    public C0825ad mo5271j() {
        return this.f2255j;
    }
}
