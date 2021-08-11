package com.igexin.push.extension.distribution.gbd.p076i;

import com.igexin.push.core.C0618g;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;

/* renamed from: com.igexin.push.extension.distribution.gbd.i.b */
public class C1113b {

    /* renamed from: a */
    private static String f2974a = "GBD-FeedbackUtils";

    /* renamed from: a */
    public static void m4554a(String str, String str2, String str3) {
        PushTaskBean pushTaskBean = new PushTaskBean();
        pushTaskBean.setTaskId(str);
        pushTaskBean.setMessageId(str2);
        pushTaskBean.setAppid(C0618g.f1602a);
        pushTaskBean.setAppKey(C0618g.f1631b);
        C1115d.m4557a(f2974a, "actionID = " + str3);
        C0535e.m2034a().mo4368a(pushTaskBean, str3);
    }
}
