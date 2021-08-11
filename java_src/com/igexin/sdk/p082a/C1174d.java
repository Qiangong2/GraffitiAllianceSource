package com.igexin.sdk.p082a;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.igexin.sdk.a.d */
public class C1174d {

    /* renamed from: a */
    private String f3063a;

    /* renamed from: b */
    private String f3064b;

    /* renamed from: c */
    private Context f3065c;

    public C1174d(Context context) {
        if (context != null) {
            this.f3065c = context;
            this.f3063a = context.getFilesDir().getPath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + "run.pid";
            this.f3064b = context.getFilesDir().getPath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + "stop.lock";
        }
    }

    /* renamed from: a */
    public void mo5970a() {
        if (!mo5972c() && this.f3063a != null) {
            try {
                new File(this.f3063a).createNewFile();
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: b */
    public void mo5971b() {
        if (mo5972c() && this.f3063a != null) {
            new File(this.f3063a).delete();
        }
    }

    /* renamed from: c */
    public boolean mo5972c() {
        File file = null;
        File file2 = this.f3063a != null ? new File(this.f3063a) : null;
        if (this.f3064b != null) {
            file = new File(this.f3064b);
        }
        if (file2 != null && file2.exists()) {
            if (file != null && file.exists()) {
                file.delete();
            }
            return true;
        } else if (file == null || !file.exists() || !file.renameTo(new File(this.f3063a))) {
            return false;
        } else {
            new C1173c(this.f3065c).mo5967a();
            return true;
        }
    }
}
