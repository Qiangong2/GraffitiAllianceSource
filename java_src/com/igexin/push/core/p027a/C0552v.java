package com.igexin.push.core.p027a;

import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.sdk.PushConsts;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.v */
public class C0552v extends AbstractC0532b {
    @Override // com.igexin.push.core.p027a.AbstractC0532b
    /* renamed from: a */
    public boolean mo4357a(Object obj, JSONObject jSONObject) {
        try {
            if (!jSONObject.has(PushConsts.CMD_ACTION) || !jSONObject.getString(PushConsts.CMD_ACTION).equals("sendmessage_feedback")) {
                return true;
            }
            String string = jSONObject.getString("appid");
            String string2 = jSONObject.getString("taskid");
            String string3 = jSONObject.getString("actionid");
            String string4 = jSONObject.getString("result");
            long j = jSONObject.getLong("timestamp");
            ActivityC0460a.m1698b("SendMessageFeedbackAction|appid:" + string + "|taskid:" + string2 + "|actionid:" + string3);
            C0535e.m2034a().mo4374a(string, string2, string3, string4, j);
            return true;
        } catch (Exception e) {
            return true;
        }
    }
}
