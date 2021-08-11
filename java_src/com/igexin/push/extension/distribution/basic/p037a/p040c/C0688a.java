package com.igexin.push.extension.distribution.basic.p037a.p040c;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.core.p027a.p028a.AbstractC0521a;
import org.json.JSONObject;
import org.pwrd.paho.client.mqttv3.internal.ClientDefaults;

/* renamed from: com.igexin.push.extension.distribution.basic.a.c.a */
public class C0688a implements AbstractC0521a {
    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public EnumC0554b mo4352a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return EnumC0554b.success;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public BaseAction mo4353a(JSONObject jSONObject) {
        try {
            return C0689b.m2682a(jSONObject.toString());
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    public boolean mo4354b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }
        Context context = C0618g.f1635f;
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
        intent.addCategory("android.intent.category.HOME");
        context.startActivity(intent);
        if (TextUtils.isEmpty(baseAction.getDoActionId())) {
            return true;
        }
        C0535e.m2034a().mo4379a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseAction.getDoActionId());
        return true;
    }
}
