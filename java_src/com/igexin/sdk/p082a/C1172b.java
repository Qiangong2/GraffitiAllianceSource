package com.igexin.sdk.p082a;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.igexin.sdk.a.b */
public class C1172b {

    /* renamed from: a */
    private String f3061a;

    public C1172b(Context context) {
        if (context != null) {
            this.f3061a = context.getFilesDir().getPath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + "init.pid";
        }
    }

    /* renamed from: a */
    public void mo5965a() {
        if (!mo5966b() && this.f3061a != null) {
            try {
                new File(this.f3061a).createNewFile();
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: b */
    public boolean mo5966b() {
        if (this.f3061a != null) {
            return new File(this.f3061a).exists();
        }
        return false;
    }
}
