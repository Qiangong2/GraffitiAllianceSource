package com.igexin.push.extension.distribution.basic.p043d;

import android.content.Context;
import android.os.Process;
import com.igexin.p012b.p013a.p015b.C0459f;
import com.igexin.push.extension.distribution.basic.util.C1003i;
import com.tencent.gcloud.voice.GCloudVoiceErrno;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.igexin.push.extension.distribution.basic.d.b */
public class C0747b {

    /* renamed from: a */
    private String f2061a;

    /* renamed from: b */
    private String f2062b;

    /* renamed from: c */
    private String f2063c;

    /* renamed from: d */
    private int f2064d;

    /* renamed from: e */
    private int f2065e;

    public C0747b(Context context) {
        String packageName = context.getPackageName();
        this.f2062b = "/data/data/" + packageName + "/files/gdaemon_20161017";
        this.f2063c = packageName + MqttTopic.TOPIC_LEVEL_SEPARATOR + C1003i.m4035a(context);
        this.f2064d = m3030a(packageName);
        try {
            Object systemService = context.getSystemService("user");
            if (systemService != null) {
                Object invoke = Process.class.getMethod("myUserHandle", null).invoke(null, new Object[0]);
                this.f2061a = systemService.getClass().getMethod("getSerialNumberForUser", invoke.getClass()).invoke(systemService, invoke).toString();
            }
        } catch (Exception e) {
        }
        this.f2065e = GCloudVoiceErrno.GCLOUD_VOICE_TVE_CREATE;
    }

    /* renamed from: a */
    private int m3030a(String str) {
        byte[] bytes;
        short s = 0;
        for (byte b : str.getBytes()) {
            s = (short) (s + b);
        }
        return (s % 40000) + 23000;
    }

    /* renamed from: a */
    private int m3031a(String str, int i, int i2, String str2) {
        try {
            Runtime.getRuntime().exec(this.f2061a == null ? this.f2062b + " " + 0 + " " + str + " " + i + " " + i2 : this.f2062b + " " + 0 + " " + str + " " + i + " " + i2 + " " + str2);
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }

    /* renamed from: b */
    private int m3032b() {
        File file = new File(this.f2062b);
        if (file.exists()) {
            return 0;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < C0746a.f2060a.length; i++) {
            byteArrayOutputStream.write(C0746a.f2060a[i]);
        }
        byte[] b = C0459f.m1688b(byteArrayOutputStream.toByteArray());
        if (b == null) {
            return -1;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(b);
            fileOutputStream.close();
            try {
                Runtime.getRuntime().exec("chmod 700 " + file.getAbsolutePath());
                return 0;
            } catch (Exception e) {
                return 0;
            }
        } catch (Exception e2) {
            return -1;
        }
    }

    /* renamed from: a */
    public int mo5032a() {
        if (m3032b() < 0) {
            return -1;
        }
        try {
            return m3031a(this.f2063c, this.f2064d, this.f2065e, this.f2061a);
        } catch (Throwable th) {
            return -1;
        }
    }
}
