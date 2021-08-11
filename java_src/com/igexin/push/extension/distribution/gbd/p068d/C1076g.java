package com.igexin.push.extension.distribution.gbd.p068d;

import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.p012b.p013a.p020d.p021a.AbstractC0463b;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.igexin.push.p079f.p081b.AbstractC1150h;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.gbd.d.g */
public class C1076g extends AbstractC1150h {

    /* renamed from: a */
    final /* synthetic */ C1071b f2862a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1076g(C1071b bVar, long j) {
        super(j);
        this.f2862a = bVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.igexin.push.p079f.p081b.AbstractC1150h
    /* renamed from: a */
    public void mo4304a() {
        try {
            C1115d.m4559b(this.f1093l, "gbd task add result = " + C0456c.m1661b().mo4213a((AbstractC0463b) this.f2862a.f2857h));
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public int mo4136b() {
        return 0;
    }
}
