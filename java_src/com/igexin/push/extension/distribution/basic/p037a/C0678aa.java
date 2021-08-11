package com.igexin.push.extension.distribution.basic.p037a;

import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.p028a.AbstractC0521a;
import com.igexin.push.extension.distribution.basic.p041b.C0732t;
import org.json.JSONObject;

/* renamed from: com.igexin.push.extension.distribution.basic.a.aa */
public class C0678aa implements AbstractC0521a {
    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public EnumC0554b mo4352a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return EnumC0554b.success;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public BaseAction mo4353a(JSONObject jSONObject) {
        try {
            if (jSONObject.has("do") && jSONObject.has("actionid") && jSONObject.has("taskid")) {
                C0732t tVar = new C0732t();
                tVar.setType("terminatetask");
                tVar.setActionId(jSONObject.getString("actionid"));
                tVar.setDoActionId(jSONObject.getString("do"));
                tVar.mo5000a(jSONObject.getString("taskid"));
                return tVar;
            }
        } catch (Exception e) {
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0167  */
    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo4354b(com.igexin.push.core.bean.PushTaskBean r11, com.igexin.push.core.bean.BaseAction r12) {
        /*
        // Method dump skipped, instructions count: 371
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.p037a.C0678aa.mo4354b(com.igexin.push.core.bean.PushTaskBean, com.igexin.push.core.bean.BaseAction):boolean");
    }
}
