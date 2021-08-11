package com.igexin.push.p023a.p024a;

import android.os.Message;
import com.igexin.push.core.C0519a;
import com.igexin.push.core.C0617f;
import com.igexin.push.p079f.p081b.AbstractC1146d;

/* renamed from: com.igexin.push.a.a.a */
public class C0477a implements AbstractC1146d {

    /* renamed from: a */
    private long f1174a = 0;

    @Override // com.igexin.push.p079f.p081b.AbstractC1146d
    /* renamed from: a */
    public void mo4247a() {
        Message obtain = Message.obtain();
        obtain.what = C0519a.f1345i;
        C0617f.m2395a().mo4618a(obtain);
    }

    @Override // com.igexin.push.p079f.p081b.AbstractC1146d
    /* renamed from: a */
    public void mo4248a(long j) {
        this.f1174a = j;
    }

    @Override // com.igexin.push.p079f.p081b.AbstractC1146d
    /* renamed from: b */
    public boolean mo4249b() {
        return System.currentTimeMillis() - this.f1174a > 360000;
    }
}
