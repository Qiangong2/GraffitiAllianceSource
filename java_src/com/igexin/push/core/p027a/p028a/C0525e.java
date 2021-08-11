package com.igexin.push.core.p027a.p028a;

import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.a.e */
public class C0525e implements AbstractC0521a {
    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public EnumC0554b mo4352a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return EnumC0554b.success;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public BaseAction mo4353a(JSONObject jSONObject) {
        try {
            BaseAction baseAction = new BaseAction();
            baseAction.setType("null");
            baseAction.setActionId(jSONObject.getString("actionid"));
            return baseAction;
        } catch (JSONException e) {
            return null;
        }
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    public boolean mo4354b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        String c = C0535e.m2034a().mo4393c(pushTaskBean.getTaskId(), pushTaskBean.getMessageId());
        ActivityC0460a.m1698b("EndAction execute, remove pushMessage from pushMessageMap, key = " + c);
        try {
            C0618g.f1612ah.remove(c);
            return true;
        } catch (Exception e) {
            ActivityC0460a.m1698b("EndAction|" + e.toString());
            return true;
        }
    }
}
