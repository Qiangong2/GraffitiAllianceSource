package com.igexin.push.p023a.p024a;

import android.text.TextUtils;
import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.p030c.C0611i;
import com.igexin.push.p079f.AbstractC1137a;
import com.igexin.push.p079f.p080a.C1140c;
import com.igexin.push.util.C1155e;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.a.a.e */
public class C0481e extends AbstractC1137a {

    /* renamed from: a */
    final /* synthetic */ C0480d f1184a;

    C0481e(C0480d dVar) {
        this.f1184a = dVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.igexin.push.p079f.AbstractC1137a
    /* renamed from: a */
    public void mo4251a() {
        try {
            String h = C1155e.m4774h();
            if (!TextUtils.isEmpty(h)) {
                C0456c.m1661b().mo4216a(new C1140c(new C0611i(SDKUrlConfig.getBiUploadServiceUrl(), h.getBytes(), 10, false)), false, true);
            }
        } catch (Throwable th) {
            ActivityC0460a.m1698b("UploadBITask|" + th.toString());
        }
    }
}
