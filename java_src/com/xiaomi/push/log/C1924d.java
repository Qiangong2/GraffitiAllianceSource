package com.xiaomi.push.log;

import com.xiaomi.channel.commonutils.misc.C1857b;
import com.xiaomi.push.log.C1919b;

/* renamed from: com.xiaomi.push.log.d */
class C1924d extends C1857b.AbstractC1859b {

    /* renamed from: a */
    C1857b.AbstractC1859b f4958a;

    /* renamed from: b */
    final /* synthetic */ C1919b f4959b;

    C1924d(C1919b bVar) {
        this.f4959b = bVar;
    }

    @Override // com.xiaomi.channel.commonutils.misc.C1857b.AbstractC1859b
    /* renamed from: b */
    public void mo9932b() {
        C1919b.C1921b bVar = (C1919b.C1921b) C1919b.m7109b(this.f4959b).peek();
        if (bVar != null && bVar.mo10309d()) {
            this.f4958a = (C1857b.AbstractC1859b) C1919b.m7109b(this.f4959b).remove();
            this.f4958a.mo9932b();
        }
    }

    @Override // com.xiaomi.channel.commonutils.misc.C1857b.AbstractC1859b
    /* renamed from: c */
    public void mo9933c() {
        if (this.f4958a != null) {
            this.f4958a.mo9933c();
        }
    }
}
