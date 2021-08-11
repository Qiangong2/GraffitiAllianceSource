package com.igexin.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.config.C0514k;
import com.igexin.push.config.C0515l;
import com.igexin.push.core.C0519a;
import com.igexin.push.core.C0617f;
import com.igexin.push.core.C0618g;
import com.igexin.push.util.C1152b;
import com.igexin.push.util.C1155e;
import com.igexin.push.util.C1167q;
import com.igexin.push.util.EncryptUtils;
import com.igexin.sdk.p082a.C1171a;
import com.igexin.sdk.p082a.C1174d;
import java.util.concurrent.atomic.AtomicBoolean;

public class GTServiceManager {
    public static final String TAG = GTServiceManager.class.getName();
    public static Context context;

    /* renamed from: a */
    private IPushCore f3047a;

    /* renamed from: b */
    private final AtomicBoolean f3048b;

    private GTServiceManager() {
        this.f3048b = new AtomicBoolean(false);
    }

    /* synthetic */ GTServiceManager(C1170a aVar) {
        this();
    }

    /* renamed from: a */
    private int m4804a(Service service) {
        ActivityC0460a.m1698b(TAG + "|start by system ####");
        if (m4809a((Context) service, false)) {
            ActivityC0460a.m1698b(TAG + "|intent = null");
            if (this.f3048b.getAndSet(true)) {
                return 1;
            }
            m4807a(service, (Intent) null);
            return 1;
        }
        ActivityC0460a.m1698b(TAG + "|start by system, needLook = " + C0514k.f1329u + ", firstInit = true or (ss = 1 switchOn = false), stop");
        service.stopSelf();
        return 2;
    }

    /* renamed from: a */
    private int m4805a(Service service, Intent intent, int i, int i2) {
        ActivityC0460a.m1698b(TAG + "|start from initialize...");
        m4807a(service, intent);
        if (this.f3047a != null) {
            return this.f3047a.onServiceStartCommand(intent, i, i2);
        }
        return 1;
    }

    /* renamed from: a */
    private int m4806a(Intent intent, int i, int i2) {
        if (this.f3047a == null) {
            return 1;
        }
        ActivityC0460a.m1698b(TAG + "|inInit = true, call onServiceStartCommand...");
        return this.f3047a.onServiceStartCommand(intent, i, i2);
    }

    /* renamed from: a */
    private void m4807a(Service service, Intent intent) {
        ActivityC0460a.m1698b(TAG + "|startPushCore ++++");
        if (EncryptUtils.isLoadSuccess()) {
            C1171a.m4817a().mo5963a(service);
            this.f3047a = C1171a.m4817a().mo5964b();
            if (this.f3047a != null) {
                this.f3047a.start(service);
                return;
            }
            return;
        }
        C1152b.m4754a(new C1170a(this, service), service);
    }

    /* renamed from: a */
    private void m4808a(Intent intent) {
        try {
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                Message obtain = Message.obtain();
                obtain.what = C0519a.f1346j;
                obtain.obj = intent;
                C0617f.m2395a().mo4618a(obtain);
            }
        } catch (Throwable th) {
            ActivityC0460a.m1698b(TAG + "|" + th.toString());
        }
    }

    /* renamed from: a */
    private boolean m4809a(Context context2, boolean z) {
        if (C1155e.m4763a(context2)) {
            return false;
        }
        if (z) {
            C0515l.m1967b(context2);
            if (!C0514k.f1329u) {
                return false;
            }
        }
        C0515l.m1965a(context2);
        return !"1".equals(C0618g.m2427b().get("ss")) || new C1174d(context2).mo5972c();
    }

    /* renamed from: b */
    private int m4810b(Service service, Intent intent, int i, int i2) {
        if (m4809a((Context) service, true)) {
            m4808a(intent);
            m4807a(service, intent);
            if (this.f3047a != null) {
                return this.f3047a.onServiceStartCommand(intent, i, i2);
            }
        } else {
            ActivityC0460a.m1698b(TAG + "|start by guard, needLook = " + C0514k.f1329u + ", firstInit = true or (ss = 1 switchOn = false), stop");
            service.stopSelf();
        }
        return 2;
    }

    public static GTServiceManager getInstance() {
        return C1177b.m4830a();
    }

    public Class getUserIntentService(Context context2) {
        try {
            String str = (String) C1167q.m4793b(context2, "uis", "");
            if (!TextUtils.isEmpty(str)) {
                return Class.forName(str);
            }
        } catch (Throwable th) {
            ActivityC0460a.m1698b(TAG + "|" + th.toString());
        }
        return null;
    }

    public Class getUserPushService(Context context2) {
        try {
            String str = (String) C1167q.m4793b(context2, "us", "");
            return TextUtils.isEmpty(str) ? PushService.class : Class.forName(str);
        } catch (Throwable th) {
            ActivityC0460a.m1698b(TAG + "|" + th.toString());
            return PushService.class;
        }
    }

    public boolean isUserPushServiceSet(Context context2) {
        try {
            String str = (String) C1167q.m4793b(context2, "us", "");
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Class.forName(str);
            return true;
        } catch (Exception e) {
            ActivityC0460a.m1698b(TAG + "|" + e.toString());
            return false;
        }
    }

    public IBinder onBind(Intent intent) {
        ActivityC0460a.m1698b(TAG + "|onBind...");
        if (this.f3047a != null) {
            return this.f3047a.onServiceBind(intent);
        }
        return null;
    }

    public void onCreate(Context context2) {
        context = context2;
    }

    public void onDestroy() {
        ActivityC0460a.m1698b(TAG + "|onDestroy...");
        if (this.f3047a != null) {
            this.f3047a.onServiceDestroy();
        }
        Process.killProcess(Process.myPid());
    }

    public void onLowMemory() {
        ActivityC0460a.m1698b(TAG + "|onLowMemory...");
    }

    public int onStartCommand(Service service, Intent intent, int i, int i2) {
        if (intent == null) {
            try {
                return m4804a(service);
            } catch (Throwable th) {
                ActivityC0460a.m1698b(TAG + "|" + th.toString());
                return 2;
            }
        } else {
            String stringExtra = intent.getStringExtra(PushConsts.CMD_ACTION);
            if (PushConsts.ACTION_SERVICE_INITIALIZE.equals(stringExtra)) {
                C1155e.m4767b(service);
            }
            if (this.f3048b.get()) {
                return m4806a(intent, i, i2);
            }
            this.f3048b.set(true);
            return PushConsts.ACTION_SERVICE_INITIALIZE.equals(stringExtra) ? m4805a(service, intent, i, i2) : m4810b(service, intent, i, i2);
        }
    }
}
