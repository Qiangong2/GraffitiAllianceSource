package com.igexin.push.extension.distribution.basic.p037a;

import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.p028a.AbstractC0521a;
import com.igexin.push.extension.distribution.basic.p041b.C0714b;
import com.igexin.push.extension.distribution.basic.p042c.C0741g;
import com.igexin.push.extension.distribution.basic.p042c.C0744j;
import com.igexin.push.extension.distribution.basic.p053h.C0768a;
import com.igexin.push.extension.distribution.basic.p053h.C0771d;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.igexin.push.extension.distribution.basic.a.c */
public class C0687c implements AbstractC0521a {

    /* renamed from: a */
    private static final String f1853a = ("EXT-" + C0687c.class.getName());

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public EnumC0554b mo4352a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        C0714b bVar = (C0714b) baseAction;
        String b = bVar.mo4791b();
        if (b != null && (b.startsWith("http://") || b.startsWith("https://"))) {
            String a = C0741g.m3010a().mo5015a(b);
            if (a.equals("")) {
                mo4768a(b, pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseAction, 4);
                return EnumC0554b.wait;
            }
            bVar.mo4795c(a);
        }
        return EnumC0554b.success;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public BaseAction mo4353a(JSONObject jSONObject) {
        if (jSONObject.has("url")) {
            try {
                String string = jSONObject.getString("url");
                if (string == null || (!string.startsWith("http://") && !string.startsWith("https://"))) {
                    return null;
                }
                C0714b bVar = new C0714b();
                bVar.setType("appdownload");
                bVar.setActionId(jSONObject.getString("actionid"));
                bVar.setDoActionId(jSONObject.getString("do"));
                bVar.mo4789a(jSONObject.getString("url"));
                bVar.mo4798d(jSONObject.getString("name"));
                bVar.mo4803f(jSONObject.getJSONObject("appstartupid").getString("android"));
                if (jSONObject.has("logo")) {
                    bVar.mo4792b(jSONObject.getString("logo"));
                }
                if (jSONObject.has("appstartupid")) {
                    bVar.mo4801e(jSONObject.getString("appstartupid"));
                }
                bVar.mo4793b(jSONObject.getBoolean("is_autoinstall"));
                bVar.mo4790a(jSONObject.getBoolean("is_autostart"));
                if (jSONObject.has("is_wifi_autodownload")) {
                    bVar.mo4796c(jSONObject.getBoolean("is_wifi_autodownload"));
                }
                if (jSONObject.has("is_no_forcedownload")) {
                    bVar.mo4799d(jSONObject.getBoolean("is_no_forcedownload"));
                }
                if (jSONObject.has("is_showprogress")) {
                    bVar.mo4802e(jSONObject.getBoolean("is_showprogress"));
                }
                if (!jSONObject.has("is_silentdownload")) {
                    return bVar;
                }
                bVar.mo4804f(jSONObject.getBoolean("is_silentdownload"));
                return bVar;
            } catch (JSONException e) {
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo4768a(String str, String str2, String str3, BaseAction baseAction, int i) {
        String str4 = "width=" + C0744j.f2044c + "&height=" + C0744j.f2043b;
        C0768a aVar = new C0768a(new C0771d(!str.contains(str4) ? str.indexOf("?") > 0 ? str + "&" + str4 : str + "?" + str4 : str, str, str2, baseAction, i, new C0690d(this, baseAction, str, str2, str3, i)));
        ((C0714b) baseAction).mo4787a(((C0714b) baseAction).mo4813l() + 1);
        C0456c.m1661b().mo4216a(aVar, false, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0161  */
    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo4354b(com.igexin.push.core.bean.PushTaskBean r11, com.igexin.push.core.bean.BaseAction r12) {
        /*
        // Method dump skipped, instructions count: 366
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.p037a.C0687c.mo4354b(com.igexin.push.core.bean.PushTaskBean, com.igexin.push.core.bean.BaseAction):boolean");
    }
}
