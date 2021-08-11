package com.igexin.push.core.p030c;

import com.igexin.push.core.C0618g;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.p032d.p035c.C0638a;
import java.util.TimerTask;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.core.c.e */
public class C0607e extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ PushTaskBean f1539a;

    /* renamed from: b */
    final /* synthetic */ C0638a f1540b;

    /* renamed from: c */
    final /* synthetic */ C0605c f1541c;

    C0607e(C0605c cVar, PushTaskBean pushTaskBean, C0638a aVar) {
        this.f1541c = cVar;
        this.f1539a = pushTaskBean;
        this.f1540b = aVar;
    }

    public void run() {
        if (C0618g.f1614aj.containsKey(this.f1539a.getTaskId())) {
            C0618g.f1614aj.get(this.f1539a.getTaskId()).cancel();
            C0618g.f1614aj.remove(this.f1539a.getTaskId());
        }
        this.f1541c.mo4589a(this.f1539a, this.f1540b);
        this.f1540b.mo4683b(this.f1540b.mo4684c() + 1);
    }
}
