package com.igexin.p012b.p013a.p020d;

import com.igexin.p012b.p013a.p020d.p021a.AbstractC0467f;
import java.util.concurrent.TimeUnit;

/* renamed from: com.igexin.b.a.d.b */
public abstract class AbstractC0468b implements AbstractC0467f {

    /* renamed from: a */
    protected boolean f1101a = true;

    /* renamed from: a */
    public void mo4185a() {
        this.f1101a = false;
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0467f
    /* renamed from: a */
    public boolean mo4183a(long j, AbstractC0470d dVar) {
        return TimeUnit.SECONDS.toMillis((long) dVar.f1136y) < j - dVar.f1134w;
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0467f
    /* renamed from: b */
    public long mo4184b(long j, AbstractC0470d dVar) {
        return (TimeUnit.SECONDS.toMillis((long) dVar.f1136y) + dVar.f1134w) - j;
    }
}
