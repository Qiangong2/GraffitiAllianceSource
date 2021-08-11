package com.igexin.push.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.sdk.PushConsts;

/* renamed from: com.igexin.push.core.n */
public class C0625n extends BroadcastReceiver {

    /* renamed from: a */
    private static C0625n f1673a;

    private C0625n() {
    }

    /* renamed from: a */
    public static C0625n m2443a() {
        if (f1673a == null) {
            f1673a = new C0625n();
        }
        return f1673a;
    }

    /* renamed from: a */
    private void m2444a(Intent intent) {
        try {
            ActivityC0460a.m1698b("----------------------------------------------------------------------------------");
            ActivityC0460a.m1698b("InternalPublicReceiver|action = " + intent.getAction() + ", component = " + intent.getComponent());
            Bundle extras = intent.getExtras();
            if (extras != null) {
                for (String str : extras.keySet()) {
                    ActivityC0460a.m1698b("InternalPublicReceiver|key [" + str + "]: " + extras.get(str));
                }
                return;
            }
            ActivityC0460a.m1698b("InternalPublicReceiver|no extras");
        } catch (Exception e) {
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (!(intent == null || intent.getAction() == null || !intent.getAction().equals(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE))) {
            m2444a(intent);
        }
        ActivityC0460a.m1698b(new StringBuilder().append("InternalPublicReceiver InternalPublicReceiver:").append(intent).toString() != null ? intent.getAction() : "null");
        if (C0617f.m2395a() != null) {
            Message message = new Message();
            message.what = C0519a.f1340d;
            message.obj = intent;
            C0617f.m2395a().mo4618a(message);
        }
    }
}
