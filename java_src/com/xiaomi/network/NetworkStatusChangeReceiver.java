package com.xiaomi.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.channel.commonutils.network.C1865d;

public class NetworkStatusChangeReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (C1865d.m6763e(context)) {
            context.startService(new Intent(context, HostRefreshService.class));
        }
    }
}
