package com.igexin.push.core.p027a;

import com.igexin.push.core.bean.C0600m;
import java.util.Comparator;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.core.a.h */
public class C0538h implements Comparator<C0600m> {

    /* renamed from: a */
    final /* synthetic */ C0535e f1371a;

    C0538h(C0535e eVar) {
        this.f1371a = eVar;
    }

    /* renamed from: a */
    public int compare(C0600m mVar, C0600m mVar2) {
        if (!mVar.mo4575d().equals(mVar2.mo4575d())) {
            return mVar.mo4575d().compareTo(mVar2.mo4575d());
        }
        return 0;
    }
}
