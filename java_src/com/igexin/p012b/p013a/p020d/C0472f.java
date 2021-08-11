package com.igexin.p012b.p013a.p020d;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.b.a.d.f */
public final class C0472f {

    /* renamed from: a */
    final BlockingQueue<AbstractC0470d> f1154a = new SynchronousQueue();

    /* renamed from: b */
    final HashMap<Integer, RunnableC0473g> f1155b = new HashMap<>();

    /* renamed from: c */
    final ReentrantLock f1156c = new ReentrantLock();

    /* renamed from: d */
    ThreadFactory f1157d = new ThreadFactoryC0474h(this);

    /* renamed from: e */
    volatile long f1158e = TimeUnit.SECONDS.toNanos(60);

    /* renamed from: f */
    volatile int f1159f = 0;

    /* renamed from: g */
    volatile int f1160g;

    /* renamed from: h */
    volatile int f1161h = Integer.MAX_VALUE;

    /* renamed from: i */
    final /* synthetic */ C0471e f1162i;

    public C0472f(C0471e eVar) {
        this.f1162i = eVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final AbstractC0470d mo4225a() {
        while (true) {
            try {
                AbstractC0470d poll = this.f1160g > this.f1159f ? this.f1154a.poll(this.f1158e, TimeUnit.NANOSECONDS) : this.f1154a.take();
                if (poll != null) {
                    return poll;
                }
                if (this.f1154a.isEmpty()) {
                    return null;
                }
            } catch (InterruptedException e) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo4226a(AbstractC0470d dVar) {
        if (dVar == null) {
            throw new NullPointerException();
        }
        if (dVar.f1137z != 0) {
            ReentrantLock reentrantLock = this.f1156c;
            reentrantLock.lock();
            try {
                RunnableC0473g gVar = this.f1155b.get(Integer.valueOf(dVar.f1137z));
                if (gVar != null) {
                    gVar.f1163a.offer(dVar);
                    return;
                }
                reentrantLock.unlock();
            } finally {
                reentrantLock.unlock();
            }
        }
        mo4228b(dVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo4227a(RunnableC0473g gVar) {
        ReentrantLock reentrantLock = this.f1156c;
        reentrantLock.lock();
        try {
            int i = this.f1160g - 1;
            this.f1160g = i;
            if (i == 0 && !this.f1154a.isEmpty()) {
                Thread f = mo4232f(null);
                if (f != null) {
                    f.start();
                }
            } else if (!gVar.f1163a.isEmpty()) {
                reentrantLock.unlock();
                return true;
            }
            this.f1155b.remove(Integer.valueOf(gVar.f1166d));
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo4228b(AbstractC0470d dVar) {
        if (this.f1160g < this.f1159f && mo4229c(dVar)) {
            return;
        }
        if (!this.f1154a.offer(dVar)) {
            if (!mo4230d(dVar)) {
            }
        } else if (this.f1160g == 0) {
            mo4231e(dVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final boolean mo4229c(AbstractC0470d dVar) {
        Thread thread = null;
        ReentrantLock reentrantLock = this.f1156c;
        reentrantLock.lock();
        try {
            if (this.f1160g < this.f1159f) {
                thread = mo4232f(dVar);
            }
            if (thread == null) {
                return false;
            }
            thread.start();
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final boolean mo4230d(AbstractC0470d dVar) {
        Thread thread = null;
        ReentrantLock reentrantLock = this.f1156c;
        reentrantLock.lock();
        try {
            if (this.f1160g < this.f1161h) {
                thread = mo4232f(dVar);
            }
            if (thread == null) {
                return false;
            }
            thread.start();
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final void mo4231e(AbstractC0470d dVar) {
        Thread thread = null;
        ReentrantLock reentrantLock = this.f1156c;
        reentrantLock.lock();
        try {
            if (this.f1160g < Math.max(this.f1159f, 1) && !this.f1154a.isEmpty()) {
                thread = mo4232f(null);
            }
            if (thread != null) {
                thread.start();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final Thread mo4232f(AbstractC0470d dVar) {
        RunnableC0473g gVar = new RunnableC0473g(this, dVar);
        if (!(dVar == null || dVar.f1137z == 0)) {
            this.f1155b.put(Integer.valueOf(dVar.f1137z), gVar);
        }
        Thread newThread = this.f1157d.newThread(gVar);
        if (newThread != null) {
            this.f1160g++;
        }
        return newThread;
    }
}
