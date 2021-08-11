package com.wanmei.sdk.core.p106ui.floatview;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

/* renamed from: com.wanmei.sdk.core.ui.floatview.FloatViewService */
public class FloatViewService extends Service {

    /* renamed from: c */
    private static FloatViewItem[] f4533c;

    /* renamed from: a */
    public BroadcastReceiver f4534a = new BroadcastReceiver() {
        /* class com.wanmei.sdk.core.p106ui.floatview.FloatViewService.C18201 */

        public void onReceive(Context context, Intent myIntent) {
            if (myIntent.getAction().equals("android.intent.action.CONFIGURATION_CHANGED")) {
                FloatViewService.this.f4535b.mo9887a(context);
            }
        }
    };

    /* renamed from: b */
    private C1827b f4535b;

    /* renamed from: a */
    public static void m6605a(FloatViewItem[] floatViewItemArr) {
        f4533c = floatViewItemArr;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CONFIGURATION_CHANGED");
        registerReceiver(this.f4534a, intentFilter);
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.f4535b != null) {
            this.f4535b.mo9890c();
        }
        unregisterReceiver(this.f4534a);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        switch (intent.getIntExtra("floatViewAction", 0)) {
            case 0:
                if (this.f4535b == null) {
                    this.f4535b = new C1827b(getApplication(), intent.getIntExtra("floatViewPlace", 1), f4533c);
                }
                this.f4535b.mo9885a();
                return 3;
            case 1:
                if (this.f4535b == null) {
                    return 3;
                }
                this.f4535b.mo9889b();
                return 3;
            default:
                return 3;
        }
    }
}
