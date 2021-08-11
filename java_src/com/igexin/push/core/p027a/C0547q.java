package com.igexin.push.core.p027a;

import com.igexin.assist.sdk.C0431a;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.p029b.C0564c;
import com.igexin.push.p032d.p035c.C0653p;
import com.igexin.sdk.PushConsts;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.q */
public class C0547q extends AbstractC0532b {
    @Override // com.igexin.push.core.p027a.AbstractC0532b
    /* renamed from: a */
    public boolean mo4357a(Object obj, JSONObject jSONObject) {
        try {
            C0653p pVar = (C0653p) obj;
            if (jSONObject.has(PushConsts.CMD_ACTION) && jSONObject.getString(PushConsts.CMD_ACTION).equals("pushmessage")) {
                byte[] bArr = (pVar.f1777f == null || !(pVar.f1777f instanceof byte[])) ? null : (byte[]) pVar.f1777f;
                String string = jSONObject.getString("taskid");
                if (C0618g.f1614aj.containsKey(string)) {
                    C0618g.f1614aj.get(string).cancel();
                    C0618g.f1614aj.remove(string);
                }
                ActivityC0460a.m1698b("getui receive message : " + jSONObject.toString());
                if (bArr == null || !C0431a.m1568e(C0618g.f1635f)) {
                    C0535e.m2034a().mo4381a(jSONObject, bArr, true);
                } else {
                    C0564c cVar = new C0564c(C0618g.f1635f);
                    if (!cVar.mo4434a(string)) {
                        cVar.mo4435b(string);
                        C0535e.m2034a().mo4381a(jSONObject, bArr, true);
                    }
                }
            }
        } catch (Exception e) {
            ActivityC0460a.m1698b("PushmessageAction|" + e.toString());
        }
        return true;
    }
}
