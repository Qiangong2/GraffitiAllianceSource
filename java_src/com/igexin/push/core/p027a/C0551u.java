package com.igexin.push.core.p027a;

import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.config.C0513j;
import com.igexin.push.core.C0617f;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.p029b.C0568g;
import com.igexin.sdk.PushConsts;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.u */
public class C0551u extends AbstractC0532b {

    /* renamed from: a */
    private static final String f1384a = C0513j.f1294a;

    @Override // com.igexin.push.core.p027a.AbstractC0532b
    /* renamed from: a */
    public boolean mo4357a(Object obj, JSONObject jSONObject) {
        try {
            if (!jSONObject.has(PushConsts.CMD_ACTION) || !jSONObject.getString(PushConsts.CMD_ACTION).equals("response_deviceid")) {
                return true;
            }
            String string = jSONObject.getString("deviceid");
            ActivityC0460a.m1698b(f1384a + " get devid resp, devid : " + string + ", save 2db and file");
            C0568g.m2192a().mo4448b(string);
            if (C0618g.f1623as != null) {
                ActivityC0460a.m1698b(f1384a + " deviceid arrived cancel addPhoneInfoTimerTask...");
                C0618g.f1623as.mo4207u();
                C0618g.f1623as = null;
            }
            if (C0618g.f1653x != null) {
                C0617f.m2395a().mo4630i().mo4408j();
            }
            ActivityC0460a.m1698b("deviceidRsp|" + C0618g.f1653x);
            return true;
        } catch (Exception e) {
            return true;
        }
    }
}
