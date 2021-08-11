package com.igexin.push.extension.distribution.gbd.p061a.p064c;

import com.igexin.push.extension.distribution.gbd.p067c.C1067a;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.igexin.push.extension.distribution.gbd.p076i.C1116e;
import java.util.ArrayList;
import java.util.HashMap;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.gbd.a.c.k */
public class RunnableC1050k implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1048i f2699a;

    private RunnableC1050k(C1048i iVar) {
        this.f2699a = iVar;
    }

    public void run() {
        try {
            if (C1048i.m4256c(this.f2699a) != null) {
                do {
                    Thread.sleep(8000);
                } while (C1048i.m4256c(this.f2699a).getCompletedTaskCount() != C1048i.m4256c(this.f2699a).getTaskCount() - 1);
                C1115d.m4559b("GBD_SLMA", "cn = " + C1067a.f2768S);
                HashMap<String, String> b = C1116e.m4578b(C1067a.f2768S);
                if (!b.isEmpty()) {
                    ArrayList arrayList = new ArrayList(b.keySet());
                    if (b.size() > 30) {
                        int size = arrayList.size() / 3;
                        C1048i.m4258d(this.f2699a).execute(new RunnableC1052m(this.f2699a, arrayList.subList(0, size), b));
                        C1048i.m4258d(this.f2699a).execute(new RunnableC1052m(this.f2699a, arrayList.subList(size, size * 2), b));
                        C1048i.m4258d(this.f2699a).execute(new RunnableC1052m(this.f2699a, arrayList.subList(size * 2, arrayList.size()), b));
                    } else {
                        C1048i.m4258d(this.f2699a).execute(new RunnableC1052m(this.f2699a, arrayList, b));
                    }
                    C1048i.m4258d(this.f2699a).execute(new RunnableC1051l(this.f2699a));
                } else if (C1048i.m4255b(this.f2699a) != null) {
                    try {
                        C1048i.m4255b(this.f2699a).close();
                        C1048i.m4251a(this.f2699a, null);
                        return;
                    } catch (Throwable th) {
                        C1115d.m4558a(th);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (C1048i.m4255b(this.f2699a) != null) {
                try {
                    C1048i.m4255b(this.f2699a).close();
                    C1048i.m4251a(this.f2699a, null);
                } catch (Throwable th2) {
                    C1115d.m4558a(th2);
                }
            }
        } catch (Throwable th3) {
            C1115d.m4558a(th3);
        }
    }
}
