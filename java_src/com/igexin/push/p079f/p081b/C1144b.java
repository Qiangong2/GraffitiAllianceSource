package com.igexin.push.p079f.p081b;

import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;

/* renamed from: com.igexin.push.f.b.b */
public class C1144b extends AbstractC1150h {

    /* renamed from: a */
    private PushTaskBean f3005a;

    /* renamed from: b */
    private String f3006b;

    public C1144b(PushTaskBean pushTaskBean, String str, long j) {
        super(j);
        this.f1126o = false;
        this.f3005a = pushTaskBean;
        this.f3006b = str;
    }

    /* access modifiers changed from: protected */
    @Override // com.igexin.push.p079f.p081b.AbstractC1150h
    /* renamed from: a */
    public void mo4304a() {
        C0535e.m2034a().mo4386b(this.f3005a, this.f3006b);
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public int mo4136b() {
        return 0;
    }

    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: c */
    public void mo4199c() {
        super.mo4199c();
    }
}
