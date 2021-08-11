package com.igexin.push.core.p027a;

import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.p012b.p022b.C0476a;
import com.igexin.push.core.C0519a;
import com.igexin.push.core.C0618g;
import com.igexin.push.p079f.AbstractC1137a;
import com.igexin.push.util.C1155e;
import com.igexin.sdk.GTServiceManager;
import java.io.File;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.core.a.f */
public class C0536f extends AbstractC1137a {

    /* renamed from: a */
    final /* synthetic */ C0535e f1369a;

    C0536f(C0535e eVar) {
        this.f1369a = eVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.igexin.push.p079f.AbstractC1137a
    /* renamed from: a */
    public void mo4251a() {
        String name = GTServiceManager.getInstance().getUserPushService(C0618g.f1635f).getName();
        if (name != null && !name.equals(C0519a.f1350n)) {
            byte[] b = C0476a.m1776b(name.getBytes());
            if (b != null) {
                C1155e.m4762a(b, C0618g.f1607ac, false);
            }
        } else if (new File(C0618g.f1607ac).delete()) {
            ActivityC0460a.m1698b("del " + C0618g.f1607ac + " success ~~~");
        }
    }
}
