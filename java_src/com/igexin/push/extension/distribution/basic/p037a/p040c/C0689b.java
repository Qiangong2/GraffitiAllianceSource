package com.igexin.push.extension.distribution.basic.p037a.p040c;

import android.text.TextUtils;
import com.igexin.push.core.bean.BaseAction;
import org.json.JSONObject;

/* renamed from: com.igexin.push.extension.distribution.basic.a.c.b */
public class C0689b extends BaseAction {
    /* renamed from: a */
    public static C0689b m2682a(String str) {
        C0689b bVar = null;
        if (!TextUtils.isEmpty(str)) {
            bVar = new C0689b();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("actionid")) {
                bVar.setActionId(jSONObject.getString("actionid"));
            }
            if (jSONObject.has("type")) {
                bVar.setType(jSONObject.getString("type"));
            }
            if (jSONObject.has("do")) {
                bVar.setDoActionId(jSONObject.getString("do"));
            }
        }
        return bVar;
    }
}
