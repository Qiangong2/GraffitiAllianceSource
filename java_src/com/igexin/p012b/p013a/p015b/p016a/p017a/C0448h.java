package com.igexin.p012b.p013a.p015b.p016a.p017a;

import java.util.Comparator;

/* renamed from: com.igexin.b.a.b.a.a.h */
class C0448h implements Comparator<C0451k> {

    /* renamed from: a */
    final /* synthetic */ C0444d f1059a;

    C0448h(C0444d dVar) {
        this.f1059a = dVar;
    }

    /* renamed from: a */
    public int compare(C0451k kVar, C0451k kVar2) {
        if (kVar == null) {
            return 1;
        }
        if (kVar2 == null) {
            return -1;
        }
        if (((long) kVar.f1136y) + kVar.f1134w <= ((long) kVar2.f1136y) + kVar2.f1134w) {
            return ((long) kVar.f1136y) + kVar.f1134w < ((long) kVar2.f1136y) + kVar2.f1134w ? -1 : 0;
        }
        return 1;
    }
}
