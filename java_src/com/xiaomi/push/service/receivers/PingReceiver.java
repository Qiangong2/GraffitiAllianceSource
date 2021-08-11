package com.xiaomi.push.service.receivers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.push.service.AbstractC1993y;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.timers.C1984a;

public class PingReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        new C1984a(context).mo10426a(false);
        AbstractC1855b.m6722c(intent.getPackage() + " is the package name");
        if (!AbstractC1993y.f5166o.equals(intent.getAction())) {
            AbstractC1855b.m6718a("cancel the old ping timer");
            ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 0, new Intent(context, PingReceiver.class), 0));
        } else if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
            AbstractC1855b.m6722c("Ping XMChannelService on timer");
            try {
                Intent intent2 = new Intent(context, XMPushService.class);
                intent2.putExtra("time_stamp", System.currentTimeMillis());
                intent2.setAction("com.xiaomi.push.timer");
                context.startService(intent2);
            } catch (Exception e) {
                AbstractC1855b.m6720a(e);
            }
        }
    }
}
