package com.igexin.sdk.p082a;

import android.content.Context;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import java.io.File;
import java.io.IOException;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.igexin.sdk.a.c */
public class C1173c {

    /* renamed from: a */
    private String f3062a;

    public C1173c(Context context) {
        if (context != null) {
            this.f3062a = context.getFilesDir().getPath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + "push.pid";
        }
    }

    /* renamed from: a */
    public void mo5967a() {
        if (!mo5969c() && this.f3062a != null) {
            try {
                new File(this.f3062a).createNewFile();
            } catch (IOException e) {
                ActivityC0460a.m1698b("SdkPushSwitch | switchOn, create file = " + this.f3062a + " exception, " + e.toString());
            }
        }
    }

    /* renamed from: b */
    public void mo5968b() {
        if (mo5969c() && this.f3062a != null && !new File(this.f3062a).delete()) {
            ActivityC0460a.m1698b("SdkPushSwitch | switchOff, delete file = " + this.f3062a + " failed !!!!!!!!!!!!");
        }
    }

    /* renamed from: c */
    public boolean mo5969c() {
        if (this.f3062a != null) {
            return new File(this.f3062a).exists();
        }
        return false;
    }
}
