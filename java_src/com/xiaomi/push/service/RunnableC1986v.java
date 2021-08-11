package com.xiaomi.push.service;

import com.xiaomi.stats.C2062g;
import java.util.Iterator;
import java.util.List;

/* access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.service.v */
public final class RunnableC1986v implements Runnable {

    /* renamed from: a */
    final /* synthetic */ List f5122a;

    /* renamed from: b */
    final /* synthetic */ boolean f5123b;

    RunnableC1986v(List list, boolean z) {
        this.f5122a = list;
        this.f5123b = z;
    }

    public void run() {
        boolean z = C1985u.m7405b("www.baidu.com:80");
        Iterator it = this.f5122a.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = z;
                break;
            }
            z = z || (C1985u.m7405b((String) it.next()));
            if (z && !this.f5123b) {
                break;
            }
        }
        C2062g.m7760a(z ? 1 : 2);
    }
}
