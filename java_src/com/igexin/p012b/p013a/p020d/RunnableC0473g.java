package com.igexin.p012b.p013a.p020d;

import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.b.a.d.g */
public final class RunnableC0473g implements Runnable {

    /* renamed from: a */
    final BlockingQueue<AbstractC0470d> f1163a = new LinkedBlockingQueue();

    /* renamed from: b */
    AbstractC0470d f1164b;

    /* renamed from: c */
    AbstractC0470d f1165c;

    /* renamed from: d */
    volatile int f1166d;

    /* renamed from: e */
    final /* synthetic */ C0472f f1167e;

    public RunnableC0473g(C0472f fVar, AbstractC0470d dVar) {
        this.f1167e = fVar;
        this.f1164b = dVar;
    }

    /* renamed from: a */
    public final void mo4233a() {
        this.f1163a.clear();
        this.f1165c = null;
    }

    /* renamed from: a */
    public final void mo4234a(AbstractC0470d dVar) {
        if (this.f1166d == 0) {
            this.f1166d = dVar.f1137z;
        }
        boolean z = true;
        while (z) {
            try {
                dVar.mo4137b_();
                dVar.mo4206t();
                dVar.mo4208v();
                if (!dVar.f1131t) {
                    dVar.mo4199c();
                }
                ActivityC0460a.m1698b("TaskService|Worker|runTask = " + dVar + "|isDone = " + dVar.f1123k + "|isCycle = " + dVar.f1126o + "|doTime = " + dVar.f1132u);
                if (!dVar.f1123k && dVar.f1126o && dVar.f1132u != 0) {
                }
            } catch (Exception e) {
                ActivityC0460a.m1698b("TaskService" + e.toString());
                dVar.f1131t = true;
                dVar.f1113B = e;
                dVar.mo4209w();
                dVar.mo4202p();
                this.f1167e.f1162i.mo4218a(dVar);
                this.f1167e.f1162i.mo4222f();
                if (!dVar.f1131t) {
                    dVar.mo4199c();
                }
                ActivityC0460a.m1698b("TaskService|Worker|runTask = " + dVar + "|isDone = " + dVar.f1123k + "|isCycle = " + dVar.f1126o + "|doTime = " + dVar.f1132u);
                if (!dVar.f1123k && dVar.f1126o && dVar.f1132u != 0) {
                }
            } catch (Throwable th) {
                if (!dVar.f1131t) {
                    dVar.mo4199c();
                }
                ActivityC0460a.m1698b("TaskService|Worker|runTask = " + dVar + "|isDone = " + dVar.f1123k + "|isCycle = " + dVar.f1126o + "|doTime = " + dVar.f1132u);
                if (dVar.f1123k || !dVar.f1126o || dVar.f1132u == 0) {
                    throw th;
                }
            }
            z = false;
            dVar = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final AbstractC0470d mo4235b() {
        while (this.f1166d != 0) {
            try {
                AbstractC0470d poll = this.f1163a.poll(this.f1167e.f1158e, TimeUnit.NANOSECONDS);
                if (poll != null) {
                    return poll;
                }
                if (this.f1163a.isEmpty()) {
                    ReentrantLock reentrantLock = this.f1167e.f1156c;
                    reentrantLock.lock();
                    try {
                        if (this.f1163a.isEmpty()) {
                            this.f1167e.f1155b.remove(Integer.valueOf(this.f1166d));
                            this.f1165c.mo4127e();
                            this.f1166d = 0;
                            reentrantLock.unlock();
                            return null;
                        }
                    } finally {
                        reentrantLock.unlock();
                    }
                } else {
                    continue;
                }
            } catch (InterruptedException e) {
            }
        }
        return null;
    }

    public final void run() {
        boolean z = true;
        while (z) {
            try {
                AbstractC0470d dVar = this.f1164b;
                this.f1164b = null;
                while (true) {
                    if (dVar == null) {
                        dVar = mo4235b();
                        if (dVar == null && (dVar = this.f1167e.mo4225a()) == null) {
                            break;
                        }
                    }
                    this.f1165c = null;
                    mo4234a(dVar);
                    this.f1165c = dVar;
                    dVar = null;
                }
                z = this.f1167e.mo4227a(this);
                if (!z) {
                    mo4233a();
                }
            } catch (Exception e) {
                ActivityC0460a.m1698b("TaskService|Worker|run()|error" + e.toString());
                z = this.f1167e.mo4227a(this);
                if (!z) {
                    mo4233a();
                }
            } catch (Throwable th) {
                if (!this.f1167e.mo4227a(this)) {
                    mo4233a();
                }
                throw th;
            }
        }
    }
}
