package com.igexin.push.util;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.util.o */
public final class ServiceConnectionC1165o implements ServiceConnection {

    /* renamed from: a */
    boolean f3042a;

    /* renamed from: b */
    private final LinkedBlockingQueue<IBinder> f3043b;

    private ServiceConnectionC1165o() {
        this.f3042a = false;
        this.f3043b = new LinkedBlockingQueue<>(1);
    }

    /* renamed from: a */
    public IBinder mo5909a() {
        if (this.f3042a) {
            throw new IllegalStateException();
        }
        this.f3042a = true;
        return this.f3043b.take();
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f3043b.put(iBinder);
        } catch (Exception e) {
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
