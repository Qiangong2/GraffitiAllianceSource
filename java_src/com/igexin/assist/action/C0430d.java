package com.igexin.assist.action;

import android.content.Context;
import android.text.TextUtils;
import com.igexin.assist.MessageBean;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.assist.util.C0434a;
import java.util.UUID;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.assist.action.d */
public class C0430d {

    /* renamed from: a */
    private byte[] f1015a;

    /* renamed from: b */
    private String f1016b;

    /* renamed from: c */
    private String f1017c;

    /* renamed from: d */
    private String f1018d;

    /* renamed from: e */
    private String f1019e;

    /* renamed from: f */
    private String f1020f;

    C0430d() {
    }

    /* renamed from: a */
    public void mo4103a(MessageBean messageBean) {
        try {
            Context context = messageBean.getContext();
            String stringMessage = messageBean.getStringMessage();
            if (!TextUtils.isEmpty(stringMessage) && context != null) {
                this.f1018d = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString(AssistPushConsts.GETUI_APPID);
                if (!TextUtils.isEmpty(this.f1018d)) {
                    this.f1019e = context.getPackageName();
                    this.f1017c = (TextUtils.isEmpty(messageBean.getMessageSource()) ? "" : messageBean.getMessageSource()) + UUID.randomUUID().toString();
                    String a = C0434a.m1570a(stringMessage, this.f1018d);
                    if (!TextUtils.isEmpty(a)) {
                        JSONObject jSONObject = new JSONObject(a);
                        if (jSONObject.has(AssistPushConsts.MSG_KEY_TASKID)) {
                            this.f1016b = jSONObject.getString(AssistPushConsts.MSG_KEY_TASKID);
                        }
                        if (jSONObject.has(AssistPushConsts.MSG_KEY_ACTION)) {
                            this.f1020f = jSONObject.getString(AssistPushConsts.MSG_KEY_ACTION);
                        }
                        if (jSONObject.has(AssistPushConsts.MSG_KEY_CONTENT) && !TextUtils.isEmpty(jSONObject.getString(AssistPushConsts.MSG_KEY_CONTENT))) {
                            this.f1015a = jSONObject.getString(AssistPushConsts.MSG_KEY_CONTENT).getBytes();
                        }
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    public boolean mo4104a() {
        return this.f1015a != null && !TextUtils.isEmpty(this.f1016b) && !TextUtils.isEmpty(this.f1019e) && !TextUtils.isEmpty(this.f1018d) && !TextUtils.isEmpty(this.f1020f) && !TextUtils.isEmpty(this.f1017c);
    }

    /* renamed from: b */
    public byte[] mo4105b() {
        return this.f1015a;
    }

    /* renamed from: c */
    public String mo4106c() {
        return this.f1016b;
    }

    /* renamed from: d */
    public String mo4107d() {
        return this.f1017c;
    }

    /* renamed from: e */
    public String mo4108e() {
        return this.f1018d;
    }

    /* renamed from: f */
    public String mo4109f() {
        return this.f1020f;
    }

    /* renamed from: g */
    public String mo4110g() {
        return this.f1019e;
    }
}
