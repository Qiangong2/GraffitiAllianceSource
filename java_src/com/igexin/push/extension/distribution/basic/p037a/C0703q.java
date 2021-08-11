package com.igexin.push.extension.distribution.basic.p037a;

import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.p028a.AbstractC0521a;
import com.igexin.push.core.p031d.C0615b;
import com.igexin.push.extension.distribution.basic.p041b.C0718f;
import com.igexin.push.extension.distribution.basic.p041b.C0726n;
import com.igexin.push.extension.distribution.basic.p042c.C0741g;
import com.igexin.push.extension.distribution.basic.p042c.C0744j;
import com.igexin.push.extension.distribution.basic.p053h.C0768a;
import com.igexin.push.extension.distribution.basic.p053h.C0771d;
import com.igexin.push.extension.distribution.basic.p060k.C0982b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.igexin.push.extension.distribution.basic.a.q */
public class C0703q implements AbstractC0521a {
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0043 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x002d  */
    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.igexin.push.core.EnumC0554b mo4352a(com.igexin.push.core.bean.PushTaskBean r11, com.igexin.push.core.bean.BaseAction r12) {
        /*
        // Method dump skipped, instructions count: 101
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.p037a.C0703q.mo4352a(com.igexin.push.core.bean.PushTaskBean, com.igexin.push.core.bean.BaseAction):com.igexin.push.core.b");
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public BaseAction mo4353a(JSONObject jSONObject) {
        if (C0741g.m3010a().mo5023e() && jSONObject.has("title") && jSONObject.has("text")) {
            try {
                C0726n nVar = new C0726n();
                nVar.setType("popup");
                nVar.setActionId(jSONObject.getString("actionid"));
                nVar.setDoActionId(jSONObject.getString("do"));
                nVar.mo4951a(jSONObject.getString("title"));
                nVar.mo4956b(jSONObject.getString("text"));
                if (jSONObject.has("img") && jSONObject.getString("img").startsWith("http")) {
                    nVar.mo4959c(jSONObject.getString("img"));
                }
                if (jSONObject.has("buttons")) {
                    ArrayList arrayList = new ArrayList();
                    JSONArray jSONArray = jSONObject.getJSONArray("buttons");
                    if (jSONArray.length() > 0) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            C0718f fVar = new C0718f();
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            fVar.mo4832a(jSONObject2.getString("text"));
                            fVar.mo4834b(jSONObject2.getString("do"));
                            arrayList.add(fVar);
                        }
                    }
                    nVar.mo4952a(arrayList);
                }
                if (!jSONObject.has("banner_url") || !jSONObject.getString("banner_url").startsWith("http")) {
                    return nVar;
                }
                nVar.mo4961d(jSONObject.getString("banner_url"));
                return nVar;
            } catch (Exception e) {
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo4778a(String str, String str2, String str3, BaseAction baseAction, int i) {
        String str4 = "width=" + C0744j.f2044c + "&height=" + C0744j.f2043b;
        C0771d dVar = new C0771d(!str.contains(str4) ? str.indexOf("?") > 0 ? str + "&" + str4 : str + "?" + str4 : str, str, str2, baseAction, i, new C0704r(this, baseAction, str2, str3, str, i));
        C0726n nVar = (C0726n) baseAction;
        if (i == 1) {
            nVar.mo4950a(nVar.mo4967h() + 1);
        } else if (i == 7) {
            nVar.mo4955b(nVar.mo4968i() + 1);
        }
        C0456c.m1661b().mo4216a(new C0768a(dVar), false, true);
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    public boolean mo4354b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        C0615b.m2387a().mo4612a(new C0982b(pushTaskBean, (C0726n) baseAction));
        return true;
    }
}
