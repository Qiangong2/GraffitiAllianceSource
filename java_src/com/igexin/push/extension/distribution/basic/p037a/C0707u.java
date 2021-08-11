package com.igexin.push.extension.distribution.basic.p037a;

import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.core.p027a.p028a.AbstractC0521a;
import com.igexin.push.extension.distribution.basic.p041b.C0728p;
import com.igexin.push.extension.distribution.basic.p042c.C0741g;
import com.igexin.push.extension.distribution.basic.p053h.C0768a;
import com.igexin.push.extension.distribution.basic.p053h.C0775h;
import com.igexin.push.extension.distribution.basic.util.C0997c;
import com.xiaomi.mipush.sdk.MiPushClient;
import org.json.JSONObject;

/* renamed from: com.igexin.push.extension.distribution.basic.a.u */
public class C0707u implements AbstractC0521a {
    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public EnumC0554b mo4352a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return EnumC0554b.success;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public BaseAction mo4353a(JSONObject jSONObject) {
        try {
            if (jSONObject.has("do") && jSONObject.has("actionid") && jSONObject.has("appstartupid")) {
                C0728p pVar = new C0728p();
                pVar.setType(jSONObject.getString("type"));
                pVar.setActionId(jSONObject.getString("actionid"));
                pVar.setDoActionId(jSONObject.getString("do"));
                JSONObject jSONObject2 = jSONObject.getJSONObject("appstartupid");
                if (jSONObject2.has("android")) {
                    pVar.mo4978a(jSONObject2.getString("android"));
                    return pVar;
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    public boolean mo4354b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        boolean z;
        boolean z2 = false;
        String a = ((C0728p) baseAction).mo4977a();
        if (a.equals("99999")) {
            String b = C0741g.m3010a().mo5018b(pushTaskBean.getTaskId());
            if (b != null && !b.equals("")) {
                C0456c.m1661b().mo4216a(new C0768a(new C0775h(b.getBytes(), 4)), false, true);
            }
        } else if (a.equals("99998")) {
            String h = C0741g.m3010a().mo5026h();
            if (h != null && !h.equals("")) {
                C0456c.m1661b().mo4216a(new C0768a(new C0775h(h.getBytes(), 5)), false, true);
            }
        } else {
            if (!C0535e.m2034a().mo4413o().contains(a)) {
                z = false;
            } else if (C0997c.m4006c(a)) {
                z = true;
                z2 = true;
            } else {
                z = false;
                z2 = true;
            }
            C0535e.m2034a().mo4369a(pushTaskBean, baseAction.getDoActionId(), z2 + MiPushClient.ACCEPT_TIME_SEPARATOR + z);
        }
        if (!baseAction.getDoActionId().equals("")) {
            C0535e.m2034a().mo4379a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseAction.getDoActionId());
        }
        return true;
    }
}
