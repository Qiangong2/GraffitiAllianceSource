package com.igexin.push.extension.distribution.gbd.p068d;

import com.igexin.push.extension.distribution.gbd.p061a.p063b.C1032d;
import com.igexin.push.extension.distribution.gbd.p061a.p063b.C1036h;
import com.igexin.push.extension.distribution.gbd.p074h.p075a.C1101c;
import com.igexin.push.extension.distribution.gbd.p074h.p075a.C1105g;
import com.igexin.push.extension.distribution.gbd.p074h.p075a.C1109k;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.igexin.push.p079f.p081b.AbstractC1150h;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.gbd.d.e */
public class C1074e extends AbstractC1150h {

    /* renamed from: a */
    final /* synthetic */ C1071b f2860a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1074e(C1071b bVar, long j) {
        super(j);
        this.f2860a = bVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.igexin.push.p079f.p081b.AbstractC1150h
    /* renamed from: a */
    public void mo4304a() {
        try {
            C1115d.m4559b(this.f1093l, "gbd guard task init");
            C1032d.m4159a().mo5687b();
            C1036h.m4187a().mo5691b();
            this.f2860a.f2857h.mo5869a(C1101c.m4508d());
            this.f2860a.f2857h.mo5869a(C1105g.m4523d());
            this.f2860a.f2857h.mo5869a(C1109k.m4539d());
            this.f2860a.m4360m();
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
