package com.igexin.push.core.stub;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.os.Message;
import android.view.KeyEvent;
import android.view.Menu;
import com.igexin.push.core.C0519a;
import com.igexin.push.core.C0617f;
import com.igexin.push.core.C0626o;
import com.igexin.push.core.p031d.AbstractC0614a;
import com.igexin.push.core.p031d.C0615b;
import com.igexin.sdk.IPushCore;
import java.util.HashMap;
import java.util.Map;

public class PushCore implements IPushCore {

    /* renamed from: a */
    private C0617f f1676a;

    /* renamed from: b */
    private Map<Activity, AbstractC0614a> f1677b = new HashMap();

    @Override // com.igexin.sdk.IPushCore
    public void onActivityConfigurationChanged(Activity activity, Configuration configuration) {
        AbstractC0614a aVar = this.f1677b.get(activity);
        if (aVar != null) {
            aVar.mo4598a(configuration);
        }
    }

    @Override // com.igexin.sdk.IPushCore
    public boolean onActivityCreateOptionsMenu(Activity activity, Menu menu) {
        AbstractC0614a aVar = this.f1677b.get(activity);
        return aVar != null && aVar.mo4602a(menu);
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityDestroy(Activity activity) {
        AbstractC0614a aVar = this.f1677b.get(activity);
        if (aVar != null) {
            aVar.mo4609h();
            this.f1677b.remove(activity);
            C0615b.m2387a().mo4614c(aVar);
        }
    }

    @Override // com.igexin.sdk.IPushCore
    public boolean onActivityKeyDown(Activity activity, int i, KeyEvent keyEvent) {
        AbstractC0614a aVar = this.f1677b.get(activity);
        return aVar != null && aVar.mo4601a(i, keyEvent);
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityNewIntent(Activity activity, Intent intent) {
        AbstractC0614a aVar = this.f1677b.get(activity);
        if (aVar != null) {
            aVar.mo4597a(intent);
        }
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityPause(Activity activity) {
        AbstractC0614a aVar = this.f1677b.get(activity);
        if (aVar != null) {
            aVar.mo4607f();
        }
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityRestart(Activity activity) {
        AbstractC0614a aVar = this.f1677b.get(activity);
        if (aVar != null) {
            aVar.mo4605d();
        }
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityResume(Activity activity) {
        AbstractC0614a aVar = this.f1677b.get(activity);
        if (aVar != null) {
            aVar.mo4606e();
        }
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityStart(Activity activity, Intent intent) {
        if (activity != null && intent != null && intent.hasExtra("activityid")) {
            AbstractC0614a a = C0615b.m2387a().mo4611a(Long.valueOf(intent.getLongExtra("activityid", 0)));
            if (a != null) {
                a.mo4596a(activity);
                this.f1677b.put(activity, a);
                a.mo4604c();
                return;
            }
            activity.finish();
        }
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityStop(Activity activity) {
        AbstractC0614a aVar = this.f1677b.get(activity);
        if (aVar != null) {
            aVar.mo4608g();
        }
    }

    @Override // com.igexin.sdk.IPushCore
    public IBinder onServiceBind(Intent intent) {
        return C0626o.m2445a();
    }

    @Override // com.igexin.sdk.IPushCore
    public void onServiceDestroy() {
        if (this.f1676a != null) {
            this.f1676a.mo4633l();
        }
    }

    @Override // com.igexin.sdk.IPushCore
    public int onServiceStartCommand(Intent intent, int i, int i2) {
        if (this.f1676a == null) {
            return 1;
        }
        Message obtain = Message.obtain();
        obtain.what = C0519a.f1339c;
        obtain.obj = intent;
        this.f1676a.mo4618a(obtain);
        return 1;
    }

    @Override // com.igexin.sdk.IPushCore
    public boolean start(Context context) {
        this.f1676a = C0617f.m2395a();
        this.f1676a.mo4617a(context);
        return true;
    }
}
