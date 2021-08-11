package com.igexin.push.extension.distribution.gbd.p073g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.push.extension.distribution.gbd.p069e.p070a.C1083e;
import com.igexin.push.extension.distribution.gbd.p076i.C1116e;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.igexin.push.extension.distribution.gbd.g.c */
public class C1096c extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (C1069c.f2849z < 50) {
            C1083e a = C1083e.m4408a();
            int i = C1069c.f2849z + 1;
            C1069c.f2849z = i;
            a.mo5817a(i);
            long k = C1116e.m4607k();
            if (!TextUtils.isEmpty(C1069c.f2819A)) {
                C1069c.f2819A += MqttTopic.MULTI_LEVEL_WILDCARD + k;
            } else {
                C1069c.f2819A += k;
            }
            C1083e.m4408a().mo5823b(C1069c.f2819A);
        }
    }
}
