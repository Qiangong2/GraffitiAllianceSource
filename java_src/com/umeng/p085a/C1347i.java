package com.umeng.p085a;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: com.umeng.a.i */
/* compiled from: QueuedWork */
public class C1347i {

    /* renamed from: a */
    private static List<WeakReference<ScheduledFuture<?>>> f3153a = new ArrayList();

    /* renamed from: b */
    private static ExecutorService f3154b = Executors.newSingleThreadExecutor();

    /* renamed from: c */
    private static long f3155c = 5;

    /* renamed from: d */
    private static ScheduledExecutorService f3156d = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: a */
    public static void m5016a(Runnable runnable) {
        if (f3154b.isShutdown()) {
            f3154b = Executors.newSingleThreadExecutor();
        }
        f3154b.execute(runnable);
    }

    /* renamed from: a */
    public static void m5015a() {
        try {
            for (WeakReference<ScheduledFuture<?>> weakReference : f3153a) {
                ScheduledFuture<?> scheduledFuture = weakReference.get();
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
            }
            f3153a.clear();
            if (!f3154b.isShutdown()) {
                f3154b.shutdown();
            }
            if (!f3156d.isShutdown()) {
                f3156d.shutdown();
            }
            f3154b.awaitTermination(f3155c, TimeUnit.SECONDS);
            f3156d.awaitTermination(f3155c, TimeUnit.SECONDS);
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    public static synchronized void m5018b(Runnable runnable) {
        synchronized (C1347i.class) {
            if (f3156d.isShutdown()) {
                f3156d = Executors.newSingleThreadScheduledExecutor();
            }
            f3156d.execute(runnable);
        }
    }

    /* renamed from: a */
    public static synchronized void m5017a(Runnable runnable, long j) {
        synchronized (C1347i.class) {
            if (f3156d.isShutdown()) {
                f3156d = Executors.newSingleThreadScheduledExecutor();
            }
            f3153a.add(new WeakReference<>(f3156d.schedule(runnable, j, TimeUnit.MILLISECONDS)));
        }
    }

    /* renamed from: c */
    public static synchronized void m5019c(Runnable runnable) {
        synchronized (C1347i.class) {
            if (f3156d.isShutdown()) {
                f3156d = Executors.newSingleThreadScheduledExecutor();
            }
            try {
                f3156d.submit(runnable).get(5, TimeUnit.SECONDS);
            } catch (Exception e) {
            }
        }
    }
}
