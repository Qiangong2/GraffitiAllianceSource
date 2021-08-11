package com.igexin.push.core.p027a.p028a;

import com.igexin.push.core.C0618g;
import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.C0589b;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.a.b */
public class C0522b implements AbstractC0521a {
    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public EnumC0554b mo4352a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return EnumC0554b.success;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public BaseAction mo4353a(JSONObject jSONObject) {
        try {
            if (jSONObject.has("type") && jSONObject.has("actionid")) {
                C0589b bVar = new C0589b();
                bVar.setType("checkapp");
                bVar.setActionId(jSONObject.getString("actionid"));
                if (jSONObject.has("appstartupid")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("appstartupid");
                    if (jSONObject2.has("android")) {
                        bVar.mo4508a(jSONObject2.getString("android"));
                        if (jSONObject.has("do_installed") || jSONObject.has("do_uninstalled")) {
                            if (jSONObject.has("do_installed")) {
                                bVar.mo4510b(jSONObject.getString("do_installed"));
                            }
                            if (!jSONObject.has("do_uninstalled")) {
                                return bVar;
                            }
                            bVar.mo4512c(jSONObject.getString("do_uninstalled"));
                            return bVar;
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    /* renamed from: a */
    public boolean mo4355a(String str) {
        try {
            return C0618g.f1635f.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    public boolean mo4354b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        C0589b bVar = (C0589b) baseAction;
        String taskId = pushTaskBean.getTaskId();
        String messageId = pushTaskBean.getMessageId();
        if (mo4355a(bVar.mo4507a())) {
            if (bVar.mo4509b() == null || bVar.mo4509b().equals("")) {
                return true;
            }
            C0535e.m2034a().mo4379a(taskId, messageId, bVar.mo4509b());
            return true;
        } else if (bVar.mo4511c() == null || bVar.mo4511c().equals("")) {
            return true;
        } else {
            C0535e.m2034a().mo4379a(taskId, messageId, bVar.mo4511c());
            return true;
        }
    }
}
