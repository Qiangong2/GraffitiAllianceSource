package com.igexin.push.extension.distribution.gbd.p076i;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.gbd.i.g */
public class ServiceConnectionC1118g implements ServiceConnection {

    /* renamed from: a */
    private boolean f2976a = false;

    /* renamed from: b */
    private final LinkedBlockingQueue<IBinder> f2977b = new LinkedBlockingQueue<>(1);

    ServiceConnectionC1118g() {
    }

    /* renamed from: a */
    public IBinder mo5878a() {
        if (this.f2976a) {
            throw new IllegalStateException();
        }
        this.f2976a = true;
        return this.f2977b.take();
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f2977b.put(iBinder);
        } catch (Exception e) {
            C1115d.m4558a(e);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
