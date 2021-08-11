package com.igexin.push.extension.distribution.basic.p037a;

import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.core.p027a.p028a.AbstractC0521a;
import com.igexin.push.extension.distribution.basic.p041b.C0733u;
import com.igexin.push.extension.distribution.basic.p042c.C0741g;
import org.json.JSONObject;

/* renamed from: com.igexin.push.extension.distribution.basic.a.ac */
public class C0680ac implements AbstractC0521a {
    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public EnumC0554b mo4352a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return EnumC0554b.success;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public BaseAction mo4353a(JSONObject jSONObject) {
        String string;
        try {
            if (jSONObject.has("do") && jSONObject.has("actionid") && jSONObject.has("date") && (string = jSONObject.getString("date")) != null && !string.equals("")) {
                C0733u uVar = new C0733u();
                uVar.setType("uploadlog");
                uVar.setActionId(jSONObject.getString("actionid"));
                uVar.setDoActionId(jSONObject.getString("do"));
                uVar.mo5002a(string);
                return uVar;
            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    public boolean mo4354b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        String a = ((C0733u) baseAction).mo5001a();
        C0741g.m3010a().mo5021c(a.substring(0, 4) + "-" + a.substring(4, 6) + "-" + a.substring(6, 8));
        if (baseAction.getDoActionId().equals("")) {
            return true;
        }
        C0535e.m2034a().mo4379a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseAction.getDoActionId());
        return true;
    }
}
