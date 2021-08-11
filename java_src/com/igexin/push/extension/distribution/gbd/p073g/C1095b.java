package com.igexin.push.extension.distribution.gbd.p073g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.sdk.PushConsts;

/* renamed from: com.igexin.push.extension.distribution.gbd.g.b */
public class C1095b extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (C1069c.f2826c == null) {
            return;
        }
        if (PushConsts.ACTION_BROADCAST_USER_PRESENT.equals(intent.getAction())) {
            Message obtain = Message.obtain();
            obtain.what = 5;
            obtain.arg1 = 51;
            obtain.obj = intent;
            C1069c.f2826c.sendMessage(obtain);
        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            Message obtain2 = Message.obtain();
            obtain2.what = 5;
            obtain2.arg1 = 52;
            C1069c.f2826c.sendMessage(obtain2);
        }
    }
}
