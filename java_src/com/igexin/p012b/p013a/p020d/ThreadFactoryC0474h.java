package com.igexin.p012b.p013a.p020d;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.b.a.d.h */
public final class ThreadFactoryC0474h implements ThreadFactory {

    /* renamed from: a */
    final AtomicInteger f1168a = new AtomicInteger(0);

    /* renamed from: b */
    final /* synthetic */ C0472f f1169b;

    public ThreadFactoryC0474h(C0472f fVar) {
        this.f1169b = fVar;
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "TaskService-pool-" + this.f1168a.incrementAndGet());
    }
}
