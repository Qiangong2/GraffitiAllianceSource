package com.igexin.push.core.p027a.p028a;

import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.core.p029b.C0568g;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.a.c */
public class C0523c implements AbstractC0521a {
    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public EnumC0554b mo4352a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return EnumC0554b.success;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public BaseAction mo4353a(JSONObject jSONObject) {
        try {
            if (jSONObject.has("do") && jSONObject.has("actionid")) {
                BaseAction baseAction = new BaseAction();
                baseAction.setType(jSONObject.getString("type"));
                baseAction.setActionId(jSONObject.getString("actionid"));
                baseAction.setDoActionId(jSONObject.getString("do"));
                return baseAction;
            }
        } catch (JSONException e) {
        }
        return null;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    public boolean mo4354b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        C0568g.m2192a().mo4444a(false);
        if (baseAction.getDoActionId().equals("")) {
            return true;
        }
        C0535e.m2034a().mo4379a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseAction.getDoActionId());
        return true;
    }
}
