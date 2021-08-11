package com.igexin.push.extension.distribution.gbd.p073g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;

/* renamed from: com.igexin.push.extension.distribution.gbd.g.a */
public class C1094a extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (C1069c.f2826c != null) {
            Message message = new Message();
            message.what = 3;
            message.obj = intent;
            C1069c.f2826c.sendMessage(message);
        }
    }
}
