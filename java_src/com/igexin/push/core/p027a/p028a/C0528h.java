package com.igexin.push.core.p027a.p028a;

import android.content.Intent;
import android.net.Uri;
import com.igexin.push.config.C0513j;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.C0599l;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;
import com.j256.ormlite.stmt.query.SimpleComparison;
import org.json.JSONException;
import org.json.JSONObject;
import org.pwrd.paho.client.mqttv3.internal.ClientDefaults;

/* renamed from: com.igexin.push.core.a.a.h */
public class C0528h implements AbstractC0521a {

    /* renamed from: a */
    private static final String f1355a = C0513j.f1294a;

    /* renamed from: a */
    private void m1999a(C0599l lVar, String str) {
        int indexOf;
        String substring;
        String a = lVar.mo4562a();
        if (a != null && (indexOf = a.indexOf(str)) != -1) {
            String str2 = "";
            String str3 = null;
            int indexOf2 = a.indexOf("&");
            if (indexOf2 == -1) {
                str2 = a.substring(0, indexOf - 1);
                String substring2 = a.substring(indexOf);
                if (substring2.contains(SimpleComparison.EQUAL_TO_OPERATION)) {
                    str3 = substring2.substring(substring2.indexOf(SimpleComparison.EQUAL_TO_OPERATION) + 1);
                }
            } else if (a.charAt(indexOf - 1) == '?') {
                str2 = a.substring(0, indexOf) + a.substring(indexOf2 + 1);
                String substring3 = a.substring(indexOf, indexOf2);
                if (substring3.contains(SimpleComparison.EQUAL_TO_OPERATION)) {
                    str3 = substring3.substring(substring3.indexOf(SimpleComparison.EQUAL_TO_OPERATION) + 1);
                }
            } else if (a.charAt(indexOf - 1) == '&') {
                String substring4 = a.substring(0, indexOf - 1);
                String substring5 = a.substring(indexOf);
                String str4 = "";
                int indexOf3 = substring5.indexOf("&");
                if (indexOf3 != -1) {
                    str4 = substring5.substring(indexOf3);
                    String substring6 = substring5.substring(0, indexOf3);
                    substring = substring6.substring(substring6.indexOf(SimpleComparison.EQUAL_TO_OPERATION) + 1);
                } else {
                    substring = substring5.substring(substring5.indexOf(SimpleComparison.EQUAL_TO_OPERATION) + 1);
                }
                str2 = substring4 + str4;
                str3 = substring;
            }
            lVar.mo4563a(str2);
            lVar.mo4566b(str3);
        }
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public EnumC0554b mo4352a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return EnumC0554b.success;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public BaseAction mo4353a(JSONObject jSONObject) {
        try {
            if (jSONObject.has("url") && jSONObject.has("do") && jSONObject.has("actionid")) {
                String string = jSONObject.getString("url");
                if (!string.equals("")) {
                    C0599l lVar = new C0599l();
                    lVar.setType("startweb");
                    lVar.setActionId(jSONObject.getString("actionid"));
                    lVar.setDoActionId(jSONObject.getString("do"));
                    lVar.mo4563a(string);
                    if (jSONObject.has("is_withcid") && jSONObject.getString("is_withcid").equals("true")) {
                        lVar.mo4564a(true);
                    }
                    if (!jSONObject.has("is_withnettype") || !jSONObject.getString("is_withnettype").equals("true")) {
                        return lVar;
                    }
                    lVar.mo4567b(true);
                    return lVar;
                }
            }
        } catch (JSONException e) {
        }
        return null;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    public boolean mo4354b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        C0599l lVar = (C0599l) baseAction;
        m1999a(lVar, "targetpkgname");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
        intent.setPackage(lVar.mo4565b());
        intent.setData(Uri.parse(lVar.mo4568c()));
        try {
            C0618g.f1635f.startActivity(intent);
        } catch (Exception e) {
        }
        if (baseAction.getDoActionId().equals("")) {
            return true;
        }
        C0535e.m2034a().mo4379a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseAction.getDoActionId());
        return true;
    }
}
