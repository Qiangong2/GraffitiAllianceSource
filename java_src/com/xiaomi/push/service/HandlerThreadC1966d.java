package com.xiaomi.push.service;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.xiaomi.push.service.d */
public class HandlerThreadC1966d extends HandlerThread {

    /* renamed from: a */
    private volatile long f5064a = 0;

    /* renamed from: b */
    private volatile boolean f5065b = false;

    /* renamed from: c */
    private volatile Handler f5066c;

    /* renamed from: d */
    private List<Pair<XMPushService.AbstractC1937e, Long>> f5067d = new ArrayList();

    public HandlerThreadC1966d(String str) {
        super(str);
    }

    /* renamed from: a */
    public void mo10406a() {
        for (int i = 1; i < 15; i++) {
            mo10407a(i);
        }
    }

    /* renamed from: a */
    public void mo10407a(int i) {
        if (this.f5066c != null) {
            this.f5066c.removeMessages(i);
        }
    }

    /* renamed from: a */
    public void mo10408a(int i, Object obj) {
        if (this.f5066c != null) {
            this.f5066c.removeMessages(i, obj);
        }
    }

    /* renamed from: a */
    public void mo10409a(XMPushService.AbstractC1937e eVar, long j) {
        synchronized (this.f5067d) {
            if (this.f5066c != null) {
                Message obtain = Message.obtain();
                obtain.what = eVar.f5010e;
                obtain.obj = eVar;
                this.f5066c.sendMessageDelayed(obtain, j);
            } else {
                AbstractC1855b.m6718a("the job is pended, the controller is not ready.");
                this.f5067d.add(new Pair<>(eVar, Long.valueOf(j)));
            }
        }
    }

    /* renamed from: b */
    public boolean mo10410b() {
        return this.f5065b && System.currentTimeMillis() - this.f5064a > 600000;
    }

    /* renamed from: b */
    public boolean mo10411b(int i) {
        if (this.f5066c != null) {
            return this.f5066c.hasMessages(i);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLooperPrepared() {
        this.f5066c = new HandlerC1967e(this, getLooper());
        synchronized (this.f5067d) {
            for (Pair<XMPushService.AbstractC1937e, Long> pair : this.f5067d) {
                AbstractC1855b.m6718a("executing the pending job.");
                mo10409a((XMPushService.AbstractC1937e) pair.first, ((Long) pair.second).longValue());
            }
            this.f5067d.clear();
        }
    }
}
