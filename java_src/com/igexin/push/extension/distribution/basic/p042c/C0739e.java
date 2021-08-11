package com.igexin.push.extension.distribution.basic.p042c;

import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.p012b.p013a.p020d.AbstractC0470d;
import com.igexin.p012b.p013a.p020d.C0471e;
import com.igexin.p012b.p013a.p020d.p021a.AbstractC0463b;
import com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e;
import com.igexin.push.extension.distribution.basic.p059j.AbstractC0980c;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.igexin.push.extension.distribution.basic.c.e */
public class C0739e implements AbstractC0463b {

    /* renamed from: a */
    private List<AbstractC0980c> f2028a = new ArrayList();

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0463b
    /* renamed from: a */
    public boolean mo4177a(AbstractC0466e eVar, C0471e eVar2) {
        for (AbstractC0980c cVar : this.f2028a) {
            if (cVar.mo5628b()) {
                cVar.mo5627a(System.currentTimeMillis());
                ActivityC0460a.m1698b("--> " + cVar.getClass().getName() + " isMatched...");
                try {
                    cVar.mo5626a();
                } catch (Throwable th) {
                    ActivityC0460a.m1698b("ExtensionCronTask|" + th.toString());
                }
            }
        }
        ActivityC0460a.m1698b("--> ExtensionCronTask ioHandle==================");
        return false;
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0463b
    /* renamed from: a */
    public boolean mo4178a(AbstractC0470d dVar, C0471e eVar) {
        return false;
    }

    /* renamed from: a */
    public boolean mo5013a(AbstractC0980c cVar) {
        return !this.f2028a.contains(cVar) && this.f2028a.add(cVar);
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0463b
    /* renamed from: n */
    public boolean mo4179n() {
        return true;
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0463b
    /* renamed from: o */
    public long mo4180o() {
        return 139859;
    }
}
