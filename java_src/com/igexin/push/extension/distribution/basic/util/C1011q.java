package com.igexin.push.extension.distribution.basic.util;

import android.app.Service;
import com.igexin.push.core.C0618g;
import com.igexin.push.p079f.p081b.AbstractC1150h;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.basic.util.q */
public final class C1011q extends AbstractC1150h {
    C1011q(long j) {
        super(j);
    }

    /* access modifiers changed from: protected */
    @Override // com.igexin.push.p079f.p081b.AbstractC1150h
    /* renamed from: a */
    public void mo4304a() {
        try {
            ((Service) C0618g.f1635f).stopForeground(false);
        } catch (Exception e) {
        }
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public int mo4136b() {
        return 0;
    }
}
