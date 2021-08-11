package com.amap.api.location;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.amap.loc.C0244ar;
import com.amap.loc.C0258b;
import com.amap.loc.C0310c;
import com.amap.loc.C0328cp;

public class APSService extends Service {

    /* renamed from: a */
    APSServiceBase f206a;

    public IBinder onBind(Intent intent) {
        try {
            return this.f206a.onBind(intent);
        } catch (Throwable th) {
            C0310c.m956a(th, "APSService", "onBind");
            return null;
        }
    }

    public void onCreate() {
        onCreate(this);
    }

    public void onCreate(Context context) {
        try {
            if (C0328cp.m1137d(context)) {
                this.f206a = (APSServiceBase) C0244ar.m536a(context, C0310c.m950a("loc", "3.0.0"), "com.amap.api.location.APSServiceWrapper", C0258b.class, new Class[]{Context.class}, new Object[]{context});
            } else if (this.f206a == null) {
                this.f206a = new C0258b(this);
            }
        } catch (Throwable th) {
        }
        try {
            if (this.f206a == null) {
                this.f206a = new C0258b(this);
            }
            this.f206a.onCreate();
        } catch (Throwable th2) {
            C0310c.m956a(th2, "APSService", "onCreate");
        }
        super.onCreate();
    }

    public void onDestroy() {
        try {
            this.f206a.onDestroy();
        } catch (Throwable th) {
            C0310c.m956a(th, "APSService", "onDestroy");
        }
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            return this.f206a.onStartCommand(intent, i, i2);
        } catch (Throwable th) {
            C0310c.m956a(th, "APSService", "onStartCommand");
            return super.onStartCommand(intent, i, i2);
        }
    }
}
