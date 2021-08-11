package com.igexin.push.p026c;

import java.util.Comparator;
import java.util.Map;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.c.n */
public class C0499n implements Comparator<Map.Entry<String, C0495j>> {

    /* renamed from: a */
    final /* synthetic */ AbstractC0498m f1262a;

    C0499n(AbstractC0498m mVar) {
        this.f1262a = mVar;
    }

    /* renamed from: a */
    public int compare(Map.Entry<String, C0495j> entry, Map.Entry<String, C0495j> entry2) {
        return (int) (entry.getValue().mo4299e() - entry2.getValue().mo4299e());
    }
}
