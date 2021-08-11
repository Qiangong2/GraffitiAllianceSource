package com.igexin.push.extension.distribution.gbd.p069e.p070a;

import com.igexin.push.extension.distribution.gbd.p066b.C1064g;
import java.util.Comparator;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.gbd.e.a.c */
public class C1081c implements Comparator<C1064g> {

    /* renamed from: a */
    final /* synthetic */ C1080b f2936a;

    C1081c(C1080b bVar) {
        this.f2936a = bVar;
    }

    /* renamed from: a */
    public int compare(C1064g gVar, C1064g gVar2) {
        if (gVar.mo5774d() == gVar2.mo5774d()) {
            return 0;
        }
        return gVar.mo5774d() > gVar2.mo5774d() ? 1 : -1;
    }
}
