package com.wanmei.push.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.wanmei.push.p104g.C1714f;
import com.wanmei.push.service.HandlePushArrivedService;

public class PushArrivedReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        C1714f.m6383c(context, "PERFECT_PUSH", "[" + context.getPackageName() + "] PushArrivedReceiver onReceive()");
        if ((context.getApplicationContext().getPackageName() + ".intent.action.PERFECT_PUSH_ARRIVED").equals(intent.getAction())) {
            Intent intent2 = new Intent(context.getApplicationContext(), HandlePushArrivedService.class);
            intent2.setAction(intent.getAction());
            Bundle bundle = new Bundle();
            bundle.putSerializable("message", intent.getSerializableExtra("message"));
            intent2.putExtras(bundle);
            context.getApplicationContext().startService(intent2);
            C1714f.m6383c(context, "PERFECT_PUSH", "[" + context.getPackageName() + "] PushArrivedReceiver Start HandlePushArrivedService, Msg : " + intent.getSerializableExtra("message").toString());
        }
    }
}
