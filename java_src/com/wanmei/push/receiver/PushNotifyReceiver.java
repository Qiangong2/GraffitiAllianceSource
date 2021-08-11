package com.wanmei.push.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.wanmei.push.bean.Notice;
import com.wanmei.push.p104g.C1714f;
import com.wanmei.push.service.HandlePushNotifyService;

public class PushNotifyReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        C1714f.m6383c(context, "PERFECT_PUSH", "[" + context.getPackageName() + "] PushNotifyReceiver onReceive()");
        if ((context.getApplicationContext().getPackageName() + ".intent.action.PERFECT_PUSH_CLICKED").equals(intent.getAction())) {
            Intent intent2 = new Intent(context.getApplicationContext(), HandlePushNotifyService.class);
            intent2.setAction(intent.getAction());
            intent2.putExtra(Notice.MSG_ID, intent.getStringExtra(Notice.MSG_ID));
            context.getApplicationContext().startService(intent2);
            C1714f.m6383c(context, "PERFECT_PUSH", "[" + context.getPackageName() + "] PushNotifyReceiver Start HandlePushNotifyService, Msg : " + intent.getStringExtra("message"));
        }
    }
}
