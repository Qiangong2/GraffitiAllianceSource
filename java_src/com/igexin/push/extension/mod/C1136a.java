package com.igexin.push.extension.mod;

import com.igexin.p010a.AbstractC0421f;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;

/* renamed from: com.igexin.push.extension.mod.a */
final class C1136a implements AbstractC0421f {
    C1136a() {
    }

    @Override // com.igexin.p010a.AbstractC0421f
    /* renamed from: a */
    public void mo4080a() {
        ActivityC0460a.m1698b(SecurityUtils.f2987a + "|load so by new success ^_^");
        SecurityUtils.f2988b = true;
        SecurityUtils.f2989c = "";
    }

    @Override // com.igexin.p010a.AbstractC0421f
    /* renamed from: a */
    public void mo4081a(Throwable th) {
        ActivityC0460a.m1698b(SecurityUtils.f2987a + "|load so by new error = " + th.getMessage());
        SecurityUtils.f2988b = false;
        SecurityUtils.f2989c += th.toString() + " + " + th.getMessage();
    }
}
