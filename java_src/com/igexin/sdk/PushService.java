package com.igexin.sdk;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;

public class PushService extends Service {

    /* renamed from: a */
    private static String f3054a = "PushService";

    /* renamed from: a */
    private int m4814a(Intent intent) {
        Class userPushService = GTServiceManager.getInstance().getUserPushService(this);
        if (intent != null) {
            intent.setClass(getApplicationContext(), userPushService);
        } else {
            intent = new Intent(getApplicationContext(), userPushService);
        }
        getApplicationContext().startService(intent);
        stopSelf();
        return 1;
    }

    public IBinder onBind(Intent intent) {
        ActivityC0460a.m1698b(f3054a + "|onBind");
        return GTServiceManager.getInstance().onBind(intent);
    }

    public void onCreate() {
        super.onCreate();
        GTServiceManager.getInstance().onCreate(this);
    }

    public void onDestroy() {
        ActivityC0460a.m1698b(f3054a + "|onDestroy");
        if (!GTServiceManager.getInstance().isUserPushServiceSet(this)) {
            GTServiceManager.getInstance().onDestroy();
        }
        super.onDestroy();
    }

    public void onLowMemory() {
        super.onLowMemory();
        ActivityC0460a.m1698b(f3054a + "|onLowMemory");
        GTServiceManager.getInstance().onLowMemory();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        try {
            return GTServiceManager.getInstance().isUserPushServiceSet(this) ? m4814a(intent) : GTServiceManager.getInstance().onStartCommand(this, intent, i, i2);
        } catch (Throwable th) {
            ActivityC0460a.m1698b(f3054a + "|" + th.toString());
            return 1;
        }
    }
}
