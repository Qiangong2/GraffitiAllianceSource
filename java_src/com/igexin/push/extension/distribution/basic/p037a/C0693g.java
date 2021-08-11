package com.igexin.push.extension.distribution.basic.p037a;

import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.config.C0514k;
import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.core.p027a.p028a.AbstractC0521a;
import org.json.JSONObject;

/* renamed from: com.igexin.push.extension.distribution.basic.a.g */
public class C0693g implements AbstractC0521a {

    /* renamed from: a */
    private static final String f1861a = ("EXT-" + C0693g.class.getName());

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
        } catch (Exception e) {
        }
        return null;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    public boolean mo4354b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        String type = baseAction.getType();
        if (type.equals("reportbindapp")) {
            ActivityC0460a.m1698b(f1861a + "bindAppid not support from sdk2.5");
        } else if (type.equals("reportaddphoneinfo")) {
            C0535e.m2034a().mo4408j();
        } else if (type.equals("reportapplist") && C0514k.f1315g) {
            C0535e.m2034a().mo4412n();
        }
        if (baseAction.getDoActionId().equals("")) {
            return true;
        }
        C0535e.m2034a().mo4379a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseAction.getDoActionId());
        return true;
    }
}
