package com.igexin.push.p079f.p081b;

import com.igexin.p012b.p013a.p020d.AbstractC0470d;
import java.util.concurrent.TimeUnit;

/* renamed from: com.igexin.push.f.b.h */
public abstract class AbstractC1150h extends AbstractC0470d {

    /* renamed from: d */
    long f3012d;

    public AbstractC1150h(long j) {
        this(0, j);
    }

    public AbstractC1150h(long j, long j2) {
        super(5);
        this.f3012d = j > 0 ? j2 + (j - System.currentTimeMillis()) : j2;
        mo4193a(this.f3012d, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo4304a();

    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: b_ */
    public final void mo4137b_() {
        super.mo4137b_();
        mo4304a();
    }

    /* access modifiers changed from: protected */
    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: e */
    public void mo4127e() {
    }
}
