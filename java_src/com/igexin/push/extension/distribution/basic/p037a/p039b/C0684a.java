package com.igexin.push.extension.distribution.basic.p037a.p039b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.sdk.PushConsts;
import java.util.Random;

/* renamed from: com.igexin.push.extension.distribution.basic.a.b.a */
public class C0684a extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f1845a = ("EXT-" + C0684a.class.getName());

    /* renamed from: b */
    private static Handler f1846b = new Handler();

    public void onReceive(Context context, Intent intent) {
        try {
            Bundle extras = intent.getExtras();
            if (extras.getInt(PushConsts.CMD_ACTION) == 10007) {
                boolean z = extras.getBoolean(PushConsts.KEY_ONLINE_STATE);
                ActivityC0460a.m1698b(f1845a + "|ExtCidReceiver onlineState = " + z);
                f1846b.postDelayed(new RunnableC0685b(this, z), (long) ((new Random().nextInt(5) + 5) * 1000));
            }
        } catch (Exception e) {
            ActivityC0460a.m1698b(f1845a + "|exception = " + e.toString());
        }
    }
}
