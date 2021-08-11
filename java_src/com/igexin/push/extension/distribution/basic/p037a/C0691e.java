package com.igexin.push.extension.distribution.basic.p037a;

import android.content.ContentValues;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.p012b.p022b.C0476a;
import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.core.p027a.p028a.AbstractC0521a;
import com.igexin.push.extension.distribution.basic.p041b.C0715c;
import com.igexin.push.extension.distribution.basic.p042c.C0741g;
import com.igexin.push.extension.distribution.basic.p059j.C0978a;
import com.igexin.push.extension.distribution.basic.util.C0997c;
import com.umeng.analytics.C1370a;
import com.xiaomi.mipush.sdk.MiPushClient;
import org.json.JSONObject;

/* renamed from: com.igexin.push.extension.distribution.basic.a.e */
public class C0691e implements AbstractC0521a {

    /* renamed from: a */
    public static final String f1860a = ("EXT-" + C0691e.class.getName());

    /* renamed from: a */
    private JSONObject m2685a(C0715c cVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", cVar.getType());
            jSONObject.put("actionid", cVar.getActionId());
            jSONObject.put("do", cVar.getDoActionId());
            jSONObject.put("pkgname", cVar.mo4817a());
            jSONObject.put("timeinterval", cVar.mo4821b());
            jSONObject.put("deadline", cVar.mo4823c());
        } catch (Exception e) {
        }
        return jSONObject;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public EnumC0554b mo4352a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        try {
            C0715c cVar = (C0715c) baseAction;
            ContentValues contentValues = new ContentValues();
            contentValues.put("messageid", pushTaskBean.getMessageId());
            contentValues.put("taskid", pushTaskBean.getTaskId());
            contentValues.put("appid", pushTaskBean.getAppid());
            contentValues.put("key", "APPFRONT");
            contentValues.put("createtime", Long.valueOf(System.currentTimeMillis()));
            cVar.mo4819a(System.currentTimeMillis());
            contentValues.put("info", C0476a.m1776b(m2685a(cVar).toString().getBytes()));
            C0741g.m3010a().mo5022d().mo5045a("message", contentValues);
            C0978a.f2504a.put(pushTaskBean.getTaskId() + MiPushClient.ACCEPT_TIME_SEPARATOR + pushTaskBean.getMessageId(), pushTaskBean);
            C0978a.f2505b.put(pushTaskBean.getTaskId() + MiPushClient.ACCEPT_TIME_SEPARATOR + pushTaskBean.getMessageId(), Long.valueOf(System.currentTimeMillis()));
            return EnumC0554b.success;
        } catch (Exception e) {
            ActivityC0460a.m1698b(f1860a + "prepareExecuteAction exeception");
            return EnumC0554b.stop;
        }
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public BaseAction mo4353a(JSONObject jSONObject) {
        try {
            if (!jSONObject.has("do") || !jSONObject.has("actionid") || !jSONObject.has("pkgname") || !jSONObject.has("timeinterval") || !jSONObject.has("deadline") || !C0997c.m4002a(jSONObject.getString("pkgname"))) {
                return null;
            }
            C0715c cVar = new C0715c();
            cVar.setType(jSONObject.getString("type"));
            cVar.setActionId(jSONObject.getString("actionid"));
            cVar.setDoActionId(jSONObject.getString("do"));
            cVar.mo4820a(jSONObject.getString("pkgname"));
            cVar.mo4818a(jSONObject.getInt("timeinterval"));
            cVar.mo4822b(jSONObject.getInt("deadline"));
            return cVar;
        } catch (Exception e) {
            ActivityC0460a.m1698b(f1860a + "|parseAction exception:" + e.toString());
            return null;
        }
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    public boolean mo4354b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        try {
            C0715c cVar = (C0715c) baseAction;
            if ((System.currentTimeMillis() - cVar.mo4824d()) / C1370a.f3217i >= ((long) cVar.mo4823c())) {
                ActivityC0460a.m1698b(f1860a + cVar.mo4817a() + " has over deadline . delete");
                C0741g.m3010a().mo5022d().mo5047a("message", new String[]{"taskid", "messageid"}, new String[]{pushTaskBean.getTaskId(), pushTaskBean.getMessageId()});
                C0978a.f2504a.remove(pushTaskBean.getTaskId() + MiPushClient.ACCEPT_TIME_SEPARATOR + pushTaskBean.getMessageId());
                C0978a.f2505b.remove(pushTaskBean.getTaskId() + MiPushClient.ACCEPT_TIME_SEPARATOR + pushTaskBean.getMessageId());
            } else if (C0997c.m4008d(cVar.mo4817a())) {
                ActivityC0460a.m1698b(f1860a + cVar.mo4817a() + " is front execute action");
                C0535e.m2034a().mo4379a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), cVar.getDoActionId());
                C0741g.m3010a().mo5022d().mo5047a("message", new String[]{"taskid", "messageid"}, new String[]{pushTaskBean.getTaskId(), pushTaskBean.getMessageId()});
                C0978a.f2504a.remove(pushTaskBean.getTaskId() + MiPushClient.ACCEPT_TIME_SEPARATOR + pushTaskBean.getMessageId());
                C0978a.f2505b.remove(pushTaskBean.getTaskId() + MiPushClient.ACCEPT_TIME_SEPARATOR + pushTaskBean.getMessageId());
            }
        } catch (Throwable th) {
            ActivityC0460a.m1698b(f1860a + th.toString());
        }
        return true;
    }
}
