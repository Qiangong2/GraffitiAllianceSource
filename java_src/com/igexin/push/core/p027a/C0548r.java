package com.igexin.push.core.p027a;

import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.p029b.C0565d;
import com.igexin.sdk.PushConsts;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.r */
public class C0548r extends AbstractC0532b {
    @Override // com.igexin.push.core.p027a.AbstractC0532b
    /* renamed from: a */
    public boolean mo4357a(Object obj, JSONObject jSONObject) {
        try {
            if (!jSONObject.has(PushConsts.CMD_ACTION) || !jSONObject.getString(PushConsts.CMD_ACTION).equals("received")) {
                return true;
            }
            String string = jSONObject.getString("id");
            ActivityC0460a.m1698b("ReceivedAction received, cmd id :" + string);
            try {
                if (!C0565d.m2181a().mo4437a(Long.parseLong(string))) {
                    return true;
                }
                C0535e.m2034a().mo4406h();
                return true;
            } catch (NumberFormatException e) {
                ActivityC0460a.m1698b("ReceivedAction|" + e.toString());
                return true;
            }
        } catch (Exception e2) {
            ActivityC0460a.m1698b("ReceivedAction|" + e2.toString());
            return true;
        }
    }
}
