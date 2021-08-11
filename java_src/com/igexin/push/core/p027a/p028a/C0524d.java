package com.igexin.push.core.p027a.p028a;

import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.C0591d;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p029b.C0568g;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.a.d */
public class C0524d implements AbstractC0521a {
    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public EnumC0554b mo4352a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return EnumC0554b.success;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public BaseAction mo4353a(JSONObject jSONObject) {
        try {
            if (jSONObject.has("do") && jSONObject.has("actionid") && jSONObject.has("duration")) {
                C0591d dVar = new C0591d();
                dVar.setType(jSONObject.getString("type"));
                dVar.setActionId(jSONObject.getString("actionid"));
                dVar.setDoActionId(jSONObject.getString("do"));
                if (!jSONObject.has("duration")) {
                    return dVar;
                }
                dVar.mo4521a(Long.valueOf(jSONObject.getString("duration")).longValue());
                return dVar;
            }
        } catch (JSONException e) {
        }
        return null;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    public boolean mo4354b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        long currentTimeMillis = System.currentTimeMillis() + (((C0591d) baseAction).mo4520a() * 1000);
        C0568g.m2192a().mo4444a(true);
        C0568g.m2192a().mo4460f(currentTimeMillis);
        return true;
    }
}
