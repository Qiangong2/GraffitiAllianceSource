package com.igexin.push.extension.distribution.gbd.p074h;

import com.igexin.p012b.p013a.p020d.AbstractC0470d;
import com.igexin.p012b.p013a.p020d.C0471e;
import com.igexin.p012b.p013a.p020d.p021a.AbstractC0463b;
import com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.igexin.push.extension.distribution.gbd.h.a */
public class C1098a implements AbstractC0463b {

    /* renamed from: a */
    private List<AbstractC1111b> f2959a = new ArrayList();

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0463b
    /* renamed from: a */
    public boolean mo4177a(AbstractC0466e eVar, C0471e eVar2) {
        for (AbstractC1111b bVar : this.f2959a) {
            C1115d.m4557a("GBD_CronTask", bVar.getClass().getSimpleName() + "|step=" + bVar.f2973b + "|enable=" + bVar.mo5872c() + "|match=" + bVar.mo5876b());
            if (bVar.mo5872c() && bVar.mo5876b()) {
                C1115d.m4557a("GBD_CronTask", bVar.getClass().getSimpleName() + "|fresh and doTask");
                bVar.mo5871a(System.currentTimeMillis());
                bVar.mo5870a();
            }
        }
        return false;
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0463b
    /* renamed from: a */
    public boolean mo4178a(AbstractC0470d dVar, C0471e eVar) {
        return false;
    }

    /* renamed from: a */
    public boolean mo5869a(AbstractC1111b bVar) {
        return !this.f2959a.contains(bVar) && this.f2959a.add(bVar);
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0463b
    /* renamed from: n */
    public boolean mo4179n() {
        return true;
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0463b
    /* renamed from: o */
    public long mo4180o() {
        return -423462;
    }
}
