package com.umeng.analytics.p093d;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.umeng.analytics.p091b.C1443f;
import com.umeng.analytics.p091b.C1447g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.umeng.analytics.d.b */
/* compiled from: AutoViewPageTracker */
public class C1469b {

    /* renamed from: a */
    public static String f3617a = null;

    /* renamed from: d */
    private static JSONObject f3618d = new JSONObject();

    /* renamed from: b */
    Application.ActivityLifecycleCallbacks f3619b = new Application.ActivityLifecycleCallbacks() {
        /* class com.umeng.analytics.p093d.C1469b.C14701 */

        public void onActivityStopped(Activity activity) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityResumed(Activity activity) {
            C1469b.this.m5434b((C1469b) activity);
        }

        public void onActivityPaused(Activity activity) {
            C1469b.this.m5437c(activity);
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }
    };

    /* renamed from: c */
    private final Map<String, Long> f3620c = new HashMap();

    /* renamed from: e */
    private Application f3621e = null;

    public C1469b(Activity activity) {
        if (activity != null) {
            this.f3621e = activity.getApplication();
            m5432a(activity);
        }
    }

    /* renamed from: a */
    private void m5432a(Activity activity) {
        this.f3621e.registerActivityLifecycleCallbacks(this.f3619b);
        if (f3617a == null) {
            m5434b(activity);
        }
    }

    /* renamed from: a */
    public void mo8608a() {
        if (this.f3621e != null) {
            this.f3621e.unregisterActivityLifecycleCallbacks(this.f3619b);
        }
    }

    /* renamed from: a */
    public void mo8609a(Context context) {
        m5437c(null);
        mo8608a();
    }

    /* renamed from: b */
    public static void m5435b(Context context) {
        try {
            synchronized (f3618d) {
                if (f3618d.length() > 0) {
                    C1443f.m5318a(context).mo8543a(C1493p.m5539a(), f3618d, C1443f.EnumC1445a.AUTOPAGE);
                    f3618d = new JSONObject();
                }
            }
        } catch (Throwable th) {
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: b */
    private void m5434b(Activity activity) {
        f3617a = activity.getPackageName() + "." + activity.getLocalClassName();
        synchronized (this.f3620c) {
            this.f3620c.put(f3617a, Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: c */
    private void m5437c(Activity activity) {
        long j = 0;
        try {
            synchronized (this.f3620c) {
                if (this.f3620c.containsKey(f3617a)) {
                    j = System.currentTimeMillis() - this.f3620c.get(f3617a).longValue();
                    this.f3620c.remove(f3617a);
                }
            }
            synchronized (f3618d) {
                try {
                    f3618d = new JSONObject();
                    f3618d.put(C1447g.f3482ab, f3617a);
                    f3618d.put("duration", j);
                } catch (Throwable th) {
                }
            }
        } catch (Throwable th2) {
        }
    }
}
