package com.igexin.push.extension.distribution.gbd.p061a.p064c;

import java.util.Comparator;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.gbd.a.c.q */
public class C1056q implements Comparator<Long> {

    /* renamed from: a */
    final /* synthetic */ C1054o f2716a;

    C1056q(C1054o oVar) {
        this.f2716a = oVar;
    }

    /* renamed from: a */
    public int compare(Long l, Long l2) {
        if (l.longValue() == l2.longValue()) {
            return 0;
        }
        return l.longValue() > l2.longValue() ? 1 : -1;
    }
}
