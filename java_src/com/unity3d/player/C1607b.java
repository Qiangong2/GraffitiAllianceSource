package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.SurfaceView;
import android.view.View;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.pwrd.paho.client.mqttv3.internal.ClientDefaults;

/* access modifiers changed from: package-private */
/* renamed from: com.unity3d.player.b */
public final class C1607b {

    /* renamed from: a */
    private C1627m f4117a = null;

    /* renamed from: b */
    private boolean f4118b = false;

    /* renamed from: c */
    private boolean f4119c = false;

    /* renamed from: d */
    private boolean f4120d = false;

    /* renamed from: e */
    private boolean f4121e = false;

    /* renamed from: f */
    private Context f4122f = null;

    /* renamed from: g */
    private AbstractC1613d f4123g = null;

    /* renamed from: h */
    private String f4124h = "";

    /* renamed from: i */
    private SurfaceView f4125i = null;

    public C1607b(AbstractC1613d dVar) {
        this.f4123g = dVar;
    }

    /* renamed from: a */
    private void m6102a(Runnable runnable) {
        if (this.f4122f instanceof Activity) {
            ((Activity) this.f4122f).runOnUiThread(runnable);
        } else {
            C1614e.Log(5, "Not running Google VR from an Activity; Ignoring execution request...");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: a */
    private void m6103a(String str) {
        if (this.f4123g != null) {
            this.f4123g.reportError("Google VR Error [" + this.f4124h + "]", str);
        } else {
            C1614e.Log(6, "Google VR Error [" + this.f4124h + "]: " + str);
        }
    }

    /* renamed from: a */
    private static boolean m6104a(int i) {
        return Build.VERSION.SDK_INT >= i;
    }

    /* renamed from: a */
    private boolean m6105a(ClassLoader classLoader) {
        try {
            Class<?> loadClass = classLoader.loadClass("com.unity3d.unitygvr.GoogleVR");
            this.f4117a = new C1627m(loadClass, loadClass.getConstructor(new Class[0]).newInstance(new Object[0]));
            this.f4117a.mo9124a("initialize", new Class[]{Activity.class, Context.class, SurfaceView.class, Boolean.TYPE});
            this.f4117a.mo9124a("deinitialize", new Class[0]);
            this.f4117a.mo9124a("load", new Class[]{Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Runnable.class});
            this.f4117a.mo9124a("enable", new Class[]{Boolean.TYPE});
            this.f4117a.mo9124a("unload", new Class[0]);
            this.f4117a.mo9124a("pause", new Class[0]);
            this.f4117a.mo9124a("resume", new Class[0]);
            this.f4117a.mo9124a("getGvrLayout", new Class[0]);
            return true;
        } catch (Exception e) {
            m6103a("Exception initializing GoogleVR from Unity library. " + e.getLocalizedMessage());
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: b */
    private void m6106b(boolean z) {
        this.f4119c = z;
    }

    /* renamed from: b */
    private boolean m6108b(final Runnable runnable) {
        final Semaphore semaphore = new Semaphore(0);
        m6102a(new Runnable() {
            /* class com.unity3d.player.C1607b.RunnableC16081 */

            public final void run() {
                try {
                    runnable.run();
                } catch (Exception e) {
                    C1607b.this.m6103a((C1607b) ("Exception unloading Google VR on UI Thread. " + e.getLocalizedMessage()));
                } finally {
                    semaphore.release();
                }
            }
        });
        try {
            if (semaphore.tryAcquire(4, TimeUnit.SECONDS)) {
                return true;
            }
            m6103a("Timeout waiting for vr state change!");
            return false;
        } catch (InterruptedException e) {
            m6103a("Interrupted while trying to acquire sync lock. " + e.getLocalizedMessage());
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: f */
    private boolean m6111f() {
        return this.f4119c;
    }

    /* renamed from: g */
    private void m6112g() {
        Activity activity = (Activity) this.f4122f;
        if (this.f4121e && !this.f4118b && activity != null) {
            this.f4118b = true;
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
            activity.startActivity(intent);
        }
    }

    /* renamed from: a */
    public final long mo9084a(final boolean z, final boolean z2, final boolean z3, final Runnable runnable) {
        final AtomicLong atomicLong = new AtomicLong(0);
        this.f4124h = (z || z2) ? "Daydream" : "Cardboard";
        if (!m6108b(new Runnable() {
            /* class com.unity3d.player.C1607b.RunnableC16092 */

            public final void run() {
                try {
                    atomicLong.set(((Long) C1607b.this.f4117a.mo9123a("load", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), runnable)).longValue());
                    C1607b.this.mo9089b();
                } catch (Exception e) {
                    C1607b.this.m6103a((C1607b) ("Exception caught while loading GoogleVR. " + e.getLocalizedMessage()));
                    atomicLong.set(0);
                }
            }
        }) || atomicLong.longValue() == 0) {
            m6103a("Google VR had a fatal issue while loading. VR will not be available.");
        }
        return atomicLong.longValue();
    }

    /* renamed from: a */
    public final void mo9085a() {
        if (this.f4117a != null) {
            this.f4117a.mo9123a("pause", new Object[0]);
        }
    }

    /* renamed from: a */
    public final void mo9086a(Intent intent) {
        if (intent != null && intent.getBooleanExtra("android.intent.extra.VR_LAUNCH", false)) {
            this.f4121e = true;
        }
    }

    /* renamed from: a */
    public final void mo9087a(final boolean z) {
        if (this.f4123g != null && this.f4122f != null) {
            if (!z && (this.f4123g == null || this.f4123g.isAppQuiting())) {
                m6112g();
            }
            m6102a(new Runnable() {
                /* class com.unity3d.player.C1607b.RunnableC16103 */

                public final void run() {
                    if (z != C1607b.this.m6111f()) {
                        try {
                            if (!z || C1607b.this.m6111f()) {
                                if (!z && C1607b.this.m6111f()) {
                                    C1607b.this.m6106b((C1607b) false);
                                    if (C1607b.this.f4117a != null) {
                                        C1607b.this.f4117a.mo9123a("enable", false);
                                    }
                                    if (C1607b.this.f4117a != null && C1607b.this.f4123g != null) {
                                        C1607b.this.f4123g.removeViewFromPlayer((View) C1607b.this.f4117a.mo9123a("getGvrLayout", new Object[0]));
                                    }
                                }
                            } else if (C1607b.this.f4117a == null || C1607b.this.f4123g == null || C1607b.this.f4123g.addViewToPlayer((View) C1607b.this.f4117a.mo9123a("getGvrLayout", new Object[0]), true)) {
                                if (C1607b.this.f4117a != null) {
                                    C1607b.this.f4117a.mo9123a("enable", true);
                                }
                                C1607b.this.m6106b((C1607b) true);
                            } else {
                                C1607b.this.m6103a((C1607b) "Unable to add Google VR to view hierarchy.");
                            }
                        } catch (Exception e) {
                            C1607b.this.m6103a((C1607b) ("Exception enabling Google VR on UI Thread. " + e.getLocalizedMessage()));
                        }
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public final boolean mo9088a(Activity activity, Context context, SurfaceView surfaceView) {
        boolean z;
        if (activity == null || context == null || surfaceView == null) {
            m6103a("Invalid parameters passed to Google VR initiialization.");
            return false;
        }
        this.f4122f = context;
        if (!m6104a(19)) {
            m6103a("Google VR requires a device that supports an api version of 19 (KitKat) or better.");
            return false;
        } else if (this.f4121e && !m6104a(24)) {
            m6103a("Daydream requires a device that supports an api version of 24 (Nougat) or better.");
            return false;
        } else if (!m6105a(UnityPlayer.class.getClassLoader())) {
            return false;
        } else {
            try {
                z = ((Boolean) this.f4117a.mo9123a("initialize", activity, context, surfaceView, Boolean.valueOf(this.f4121e))).booleanValue();
            } catch (Exception e) {
                m6103a("Exception while trying to intialize Unity Google VR Library. " + e.getLocalizedMessage());
                z = false;
            }
            if (!z) {
                m6103a("Unable to initialize GoogleVR library.");
            }
            m6106b(false);
            this.f4125i = surfaceView;
            this.f4118b = false;
            this.f4120d = true;
            this.f4124h = "";
            return true;
        }
    }

    /* renamed from: b */
    public final void mo9089b() {
        if (this.f4117a != null) {
            this.f4117a.mo9123a("resume", new Object[0]);
        }
    }

    /* renamed from: c */
    public final boolean mo9090c() {
        return this.f4120d;
    }

    /* renamed from: d */
    public final void mo9091d() {
        mo9087a(false);
        this.f4120d = false;
        this.f4125i = null;
        m6102a(new Runnable() {
            /* class com.unity3d.player.C1607b.RunnableC16114 */

            public final void run() {
                try {
                    if (C1607b.this.f4117a != null) {
                        C1607b.this.f4117a.mo9123a("unload", new Object[0]);
                        C1607b.this.f4117a.mo9123a("deinitialize", new Object[0]);
                        C1607b.this.f4117a = null;
                    }
                    C1607b.this.m6106b((C1607b) false);
                } catch (Exception e) {
                    C1607b.this.m6103a((C1607b) ("Exception unloading Google VR on UI Thread. " + e.getLocalizedMessage()));
                }
            }
        });
    }

    /* renamed from: e */
    public final void mo9092e() {
        if (this.f4125i != null) {
            this.f4125i.getHolder().setSizeFromLayout();
        }
    }
}
