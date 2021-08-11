package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.channel.commonutils.network.C1865d;
import com.xiaomi.mipush.sdk.C1900a;
import com.xiaomi.mipush.sdk.C1910g;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NetworkStatusReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static int f5105a = 1;

    /* renamed from: b */
    private static int f5106b = 1;

    /* renamed from: c */
    private static int f5107c = 2;

    /* renamed from: d */
    private static BlockingQueue<Runnable> f5108d = new LinkedBlockingQueue();

    /* renamed from: e */
    private static ThreadPoolExecutor f5109e = new ThreadPoolExecutor(f5105a, f5106b, (long) f5107c, TimeUnit.SECONDS, f5108d);

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7374a(Context context) {
        if (!C1910g.m6998a(context).mo10212b() && C1900a.m6949a(context).mo10182i() && !C1900a.m6949a(context).mo10187n()) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context, "com.xiaomi.push.service.XMPushService"));
                intent.setAction("com.xiaomi.push.network_status_changed");
                context.startService(intent);
            } catch (Exception e) {
                AbstractC1855b.m6720a(e);
            }
        }
        if (C1865d.m6762d(context) && C1910g.m6998a(context).mo10216f()) {
            C1910g.m6998a(context).mo10213c();
        }
    }

    public void onReceive(Context context, Intent intent) {
        f5109e.execute(new RunnableC1981a(this, context));
    }
}
