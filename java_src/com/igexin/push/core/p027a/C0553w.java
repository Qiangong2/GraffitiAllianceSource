package com.igexin.push.core.p027a;

import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.config.C0513j;
import com.igexin.sdk.PushConsts;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.w */
public class C0553w extends AbstractC0532b {

    /* renamed from: a */
    private static final String f1385a = (C0513j.f1294a + "_SetTagResultAction");

    @Override // com.igexin.push.core.p027a.AbstractC0532b
    /* renamed from: a */
    public boolean mo4357a(Object obj, JSONObject jSONObject) {
        ActivityC0460a.m1698b(f1385a + "|set tag result resp data = " + jSONObject);
        if (jSONObject == null) {
            return true;
        }
        try {
            if (!jSONObject.has(PushConsts.CMD_ACTION) || !jSONObject.getString(PushConsts.CMD_ACTION).equals("settag_result")) {
                return true;
            }
            C0535e.m2034a().mo4388b(jSONObject.getString("sn"), jSONObject.getString("error_code"));
            return true;
        } catch (Exception e) {
            ActivityC0460a.m1698b(f1385a + "|" + e.toString());
            return true;
        }
    }
}
