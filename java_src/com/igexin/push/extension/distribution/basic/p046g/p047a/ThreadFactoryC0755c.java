package com.igexin.push.extension.distribution.basic.p046g.p047a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.basic.g.a.c */
public class ThreadFactoryC0755c implements ThreadFactory {

    /* renamed from: a */
    private static final AtomicInteger f2099a = new AtomicInteger(1);

    /* renamed from: b */
    private final ThreadGroup f2100b = Thread.currentThread().getThreadGroup();

    /* renamed from: c */
    private final AtomicInteger f2101c = new AtomicInteger(1);

    /* renamed from: d */
    private final String f2102d = ("download-" + f2099a.getAndIncrement() + "-");

    ThreadFactoryC0755c() {
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f2100b, runnable, this.f2102d + this.f2101c.getAndIncrement(), 0);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        return thread;
    }
}
