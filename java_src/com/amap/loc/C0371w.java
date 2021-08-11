package com.amap.loc;

import android.content.Context;
import android.os.Looper;
import java.lang.Thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/* renamed from: com.amap.loc.w */
/* compiled from: SDKLogHandler */
public class C0371w extends C0365t implements Thread.UncaughtExceptionHandler {

    /* renamed from: e */
    private static ExecutorService f940e;

    /* renamed from: d */
    private Context f941d;

    /* renamed from: com.amap.loc.w$a */
    /* compiled from: SDKLogHandler */
    private static class C0373a implements AbstractC0282bj {

        /* renamed from: a */
        private Context f946a;

        C0373a(Context context) {
            this.f946a = context;
        }

        @Override // com.amap.loc.AbstractC0282bj
        /* renamed from: a */
        public void mo3766a() {
            try {
                C0366u.m1383b(this.f946a);
            } catch (Throwable th) {
                C0365t.m1372a(th, "LogNetListener", "onNetCompleted");
            }
        }
    }

    private C0371w(Context context, C0360q qVar) {
        this.f941d = context;
        C0280bi.m744a(new C0373a(context));
        m1396c();
    }

    /* renamed from: a */
    public static synchronized C0371w m1391a(Context context, C0360q qVar) throws C0341h {
        C0371w wVar;
        synchronized (C0371w.class) {
            if (qVar == null) {
                throw new C0341h("sdk info is null");
            } else if (qVar.mo3939a() == null || "".equals(qVar.mo3939a())) {
                throw new C0341h("sdk name is invalid");
            } else {
                try {
                    if (C0365t.f919a == null) {
                        C0365t.f919a = new C0371w(context, qVar);
                    } else {
                        C0365t.f919a.f921c = false;
                    }
                    C0365t.f919a.mo3947a(context, qVar, C0365t.f919a.f921c);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                wVar = (C0371w) C0365t.f919a;
            }
        }
        return wVar;
    }

    /* renamed from: a */
    public static synchronized void m1392a() {
        synchronized (C0371w.class) {
            try {
                if (f940e != null) {
                    f940e.shutdown();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                if (!(C0365t.f919a == null || Thread.getDefaultUncaughtExceptionHandler() != C0365t.f919a || C0365t.f919a.f920b == null)) {
                    Thread.setDefaultUncaughtExceptionHandler(C0365t.f919a.f920b);
                }
                C0365t.f919a = null;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return;
    }

    /* renamed from: b */
    public static synchronized ExecutorService m1393b() {
        ExecutorService executorService;
        synchronized (C0371w.class) {
            try {
                if (f940e == null || f940e.isShutdown()) {
                    f940e = Executors.newSingleThreadExecutor();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            executorService = f940e;
        }
        return executorService;
    }

    /* renamed from: b */
    public static void m1394b(C0360q qVar, String str, String str2) {
        if (C0365t.f919a != null) {
            C0365t.f919a.mo3948a(qVar, str, str2);
        }
    }

    /* renamed from: b */
    public static void m1395b(Throwable th, String str, String str2) {
        if (C0365t.f919a != null) {
            C0365t.f919a.mo3949a(th, 1, str, str2);
        }
    }

    /* renamed from: c */
    private void m1396c() {
        try {
            this.f920b = Thread.getDefaultUncaughtExceptionHandler();
            if (this.f920b == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f921c = true;
            } else if (this.f920b.toString().indexOf("com.amap.api") != -1) {
                this.f921c = false;
            } else {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f921c = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.loc.C0365t
    /* renamed from: a */
    public void mo3947a(final Context context, final C0360q qVar, final boolean z) {
        try {
            ExecutorService b = m1393b();
            if (b != null && !b.isShutdown()) {
                b.submit(new Runnable() {
                    /* class com.amap.loc.C0371w.RunnableC03721 */

                    public void run() {
                        try {
                            synchronized (Looper.getMainLooper()) {
                                new C0239am(context, true).mo3673a(qVar);
                            }
                            if (z) {
                                synchronized (Looper.getMainLooper()) {
                                    C0240an anVar = new C0240an(context);
                                    C0241ao aoVar = new C0241ao();
                                    aoVar.mo3680c(true);
                                    aoVar.mo3676a(true);
                                    aoVar.mo3678b(true);
                                    anVar.mo3675a(aoVar);
                                }
                                C0366u.m1379a(C0371w.this.f941d);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        } catch (RejectedExecutionException e) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.loc.C0365t
    /* renamed from: a */
    public void mo3948a(C0360q qVar, String str, String str2) {
        C0366u.m1380a(this.f941d, qVar, str, str2);
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.loc.C0365t
    /* renamed from: a */
    public void mo3949a(Throwable th, int i, String str, String str2) {
        C0366u.m1381a(this.f941d, th, i, str, str2);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (th != null) {
            mo3949a(th, 0, null, null);
            if (this.f920b != null) {
                try {
                    Thread.setDefaultUncaughtExceptionHandler(this.f920b);
                } catch (Throwable th2) {
                }
                this.f920b.uncaughtException(thread, th);
            }
        }
    }
}
