package com.xiaomi.push.service.timers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.push.service.AbstractC1993y;
import com.xiaomi.smack.C2014j;

/* renamed from: com.xiaomi.push.service.timers.a */
public class C1984a {

    /* renamed from: c */
    private static volatile long f5116c = 0;

    /* renamed from: a */
    private PendingIntent f5117a = null;

    /* renamed from: b */
    private Context f5118b = null;

    public C1984a(Context context) {
        this.f5118b = context;
    }

    /* renamed from: a */
    private void m7397a(AlarmManager alarmManager, long j, PendingIntent pendingIntent) {
        try {
            AlarmManager.class.getMethod("setExact", Integer.TYPE, Long.TYPE, PendingIntent.class).invoke(alarmManager, 0, Long.valueOf(j), pendingIntent);
        } catch (Exception e) {
            AbstractC1855b.m6720a(e);
        }
    }

    /* renamed from: a */
    public synchronized void mo10424a() {
        if (this.f5117a != null) {
            ((AlarmManager) this.f5118b.getSystemService("alarm")).cancel(this.f5117a);
            this.f5117a = null;
            AbstractC1855b.m6722c("unregister timer");
            f5116c = 0;
        }
    }

    /* renamed from: a */
    public synchronized void mo10425a(Intent intent, long j) {
        if (this.f5117a == null) {
            AlarmManager alarmManager = (AlarmManager) this.f5118b.getSystemService("alarm");
            this.f5117a = PendingIntent.getBroadcast(this.f5118b, 0, intent, 0);
            if (Build.VERSION.SDK_INT >= 19) {
                m7397a(alarmManager, j, this.f5117a);
            } else {
                alarmManager.set(0, j, this.f5117a);
            }
            AbstractC1855b.m6722c("register timer " + f5116c);
        }
    }

    /* renamed from: a */
    public synchronized void mo10426a(boolean z) {
        Intent intent = new Intent(AbstractC1993y.f5166o);
        intent.setPackage(this.f5118b.getPackageName());
        long c = (long) C2014j.m7558c();
        if (z || f5116c == 0) {
            f5116c = (c - (SystemClock.elapsedRealtime() % c)) + System.currentTimeMillis();
        } else {
            f5116c += c;
            if (f5116c < System.currentTimeMillis()) {
                f5116c = c + System.currentTimeMillis();
            }
        }
        mo10425a(intent, f5116c);
    }

    /* renamed from: b */
    public synchronized boolean mo10427b() {
        return this.f5117a != null;
    }
}
