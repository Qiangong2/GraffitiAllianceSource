package com.igexin.push.extension.distribution.gbd.p061a.p064c;

import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.xiaomi.mipush.sdk.MiPushClient;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.igexin.push.extension.distribution.gbd.a.c.l */
class RunnableC1051l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1048i f2700a;

    private RunnableC1051l(C1048i iVar) {
        this.f2700a = iVar;
    }

    public void run() {
        try {
            if (this.f2700a.f2696f != null) {
                do {
                    Thread.sleep(8000);
                } while (this.f2700a.f2696f.getCompletedTaskCount() != this.f2700a.f2696f.getTaskCount() - 1);
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                StringBuilder sb3 = new StringBuilder();
                for (String str : this.f2700a.f2697g.keySet()) {
                    sb.append((String) this.f2700a.f2697g.get(str));
                    sb.append(MiPushClient.ACCEPT_TIME_SEPARATOR);
                    sb2.append(str);
                    sb2.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                    sb2.append((String) this.f2700a.f2697g.get(str));
                    sb2.append(MiPushClient.ACCEPT_TIME_SEPARATOR);
                }
                if (sb.toString().endsWith(MiPushClient.ACCEPT_TIME_SEPARATOR)) {
                    sb = sb.deleteCharAt(sb.length() - 1);
                }
                StringBuilder deleteCharAt = sb2.toString().endsWith(MiPushClient.ACCEPT_TIME_SEPARATOR) ? sb2.deleteCharAt(sb2.length() - 1) : sb2;
                for (String str2 : this.f2700a.f2698h.keySet()) {
                    sb3.append(str2);
                    sb3.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                    sb3.append((String) this.f2700a.f2698h.get(str2));
                    sb3.append(MiPushClient.ACCEPT_TIME_SEPARATOR);
                }
                this.f2700a.m4253a(sb.toString(), deleteCharAt.toString(), (sb3.toString().endsWith(MiPushClient.ACCEPT_TIME_SEPARATOR) ? sb3.deleteCharAt(sb3.length() - 1) : sb3).toString());
                this.f2700a.f2698h.clear();
                this.f2700a.f2697g.clear();
            }
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
    }
}
