package com.igexin.push.util;

import android.content.Context;
import com.igexin.p012b.p013a.p015b.C0459f;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.p012b.p022b.C0476a;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.sdk.PushConsts;
import org.json.JSONObject;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.util.c */
public final class RunnableC1153c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f3019a;

    /* renamed from: b */
    final /* synthetic */ AbstractC1154d f3020b;

    RunnableC1153c(Context context, AbstractC1154d dVar) {
        this.f3019a = context;
        this.f3020b = dVar;
    }

    public void run() {
        boolean z = false;
        try {
            if (C1152b.m4757c(this.f3019a)) {
                C1155e.m4762a(String.valueOf(System.currentTimeMillis()).getBytes(), this.f3019a.getFilesDir().getPath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + "init_er.pid", false);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(PushConsts.CMD_ACTION, "upload_BI");
                jSONObject.put("BIType", "25");
                jSONObject.put("cid", "0");
                jSONObject.put("BIData", new String(C0459f.m1695f(C1152b.m4758d(this.f3019a).getBytes(), 0), "UTF-8"));
                byte[] a = C1169s.m4801a(SDKUrlConfig.getBiUploadServiceUrl(), C0476a.m1776b(jSONObject.toString().getBytes()), 10000, 10000);
                if (a != null) {
                    new String(a);
                }
                z = true;
            }
        } catch (Throwable th) {
            ActivityC0460a.m1698b("ErrorReport|report 25 ex = " + th.toString());
        }
        if (this.f3020b != null) {
            this.f3020b.mo5905a(z);
        }
    }
}
