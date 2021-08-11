package com.igexin.push.extension.distribution.basic.p037a;

import com.igexin.push.core.C0618g;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.extension.distribution.basic.util.webview.AbstractC1018e;
import com.igexin.push.extension.distribution.basic.util.webview.EnumC1019f;

/* renamed from: com.igexin.push.extension.distribution.basic.a.t */
class C0706t implements AbstractC1018e {

    /* renamed from: a */
    final /* synthetic */ C0705s f1884a;

    C0706t(C0705s sVar) {
        this.f1884a = sVar;
    }

    @Override // com.igexin.push.extension.distribution.basic.util.webview.AbstractC1018e
    /* renamed from: a */
    public void mo4779a(EnumC1019f fVar, String str, String str2, String str3, String str4, String str5, Exception exc) {
        if (fVar == EnumC1019f.OK || fVar == EnumC1019f.OK_SOME_RES_FAILED) {
            C0705s.m2746a(this.f1884a).mo4974b("file://" + str3);
            if (C0618g.m2422a(str4, true) == 0) {
                try {
                    C0535e.m2034a().mo4379a(str4, str5, "1");
                } catch (Exception e) {
                }
            }
        }
    }
}
