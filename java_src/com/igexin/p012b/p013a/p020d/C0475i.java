package com.igexin.p012b.p013a.p020d;

import android.os.Process;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.b.a.d.i */
public final class C0475i extends Thread {

    /* renamed from: a */
    volatile boolean f1170a = true;

    /* renamed from: b */
    C0472f f1171b;

    /* renamed from: c */
    final /* synthetic */ C0471e f1172c;

    public C0475i(C0471e eVar) {
        this.f1172c = eVar;
        setName("taskService-processor");
    }

    public final void run() {
        Process.setThreadPriority(-2);
        C0469c<AbstractC0470d> cVar = this.f1172c.f1144k;
        char c = 1;
        AbstractC0470d dVar = null;
        while (this.f1170a) {
            switch (c) {
                case 65535:
                    try {
                        dVar.mo4126d();
                        ActivityC0460a.m1698b("TaskService|TASK_INIT|initTask =" + dVar.getClass().getName() + "@" + dVar.hashCode() + "|isBlock = " + dVar.mo4203q() + "|isCycle = " + dVar.f1126o + "|doTime = " + dVar.f1132u);
                        if (!dVar.mo4203q()) {
                            if (dVar.f1126o && dVar.f1132u == 0) {
                                ActivityC0460a.m1698b("TaskService|" + dVar + "|isBlock = false|cycyle = true|doTime = 0, " + "invalid ###########");
                                c = 1;
                                break;
                            }
                        } else {
                            if (this.f1171b == null) {
                                this.f1171b = new C0472f(this.f1172c);
                            }
                            ActivityC0460a.m1698b(dVar.getClass().getName() + " is a block task!");
                            this.f1171b.mo4226a(dVar);
                            c = 1;
                            dVar = null;
                            break;
                        }
                    } catch (Exception e) {
                        ActivityC0460a.m1698b("TaskService|TASK_INIT|error|" + e.toString());
                        c = 1;
                        break;
                    }
                case 0:
                    try {
                        dVar.mo4137b_();
                        dVar.mo4206t();
                        dVar.mo4208v();
                        this.f1172c.mo4223g();
                        ActivityC0460a.m1698b("TaskService|SERVICE_PROCESSING|finally|hasError = " + dVar.f1131t + "|isDone = " + dVar.mo4205s() + "|isPending = " + dVar.f1127p + "|isCycle = " + dVar.f1126o + "|isBlcok = " + dVar.mo4203q());
                        if (!dVar.f1131t) {
                            dVar.mo4199c();
                        }
                        if (!dVar.f1123k && !dVar.f1127p) {
                            ActivityC0460a.m1698b("TaskService|SERVICE_PROCESSING|finally|mainQueue.offer task = " + dVar);
                            dVar.f1112A = 0;
                            cVar.mo4188a(dVar);
                        }
                        c = 1;
                        dVar = null;
                    } catch (Exception e2) {
                        ActivityC0460a.m1698b("TaskService|SERVICE_PROCESSING|error|" + e2.toString());
                        dVar.f1131t = true;
                        dVar.f1113B = e2;
                        dVar.mo4209w();
                        dVar.mo4202p();
                        this.f1172c.f1143j.offer(dVar);
                        this.f1172c.mo4223g();
                        ActivityC0460a.m1698b("TaskService|SERVICE_PROCESSING|finally|hasError = " + dVar.f1131t + "|isDone = " + dVar.mo4205s() + "|isPending = " + dVar.f1127p + "|isCycle = " + dVar.f1126o + "|isBlcok = " + dVar.mo4203q());
                        if (!dVar.f1131t) {
                            dVar.mo4199c();
                        }
                        if (!dVar.f1123k && !dVar.f1127p) {
                            ActivityC0460a.m1698b("TaskService|SERVICE_PROCESSING|finally|mainQueue.offer task = " + dVar);
                            dVar.f1112A = 0;
                            cVar.mo4188a(dVar);
                        }
                        c = 1;
                        dVar = null;
                    } catch (Throwable th) {
                        this.f1172c.mo4223g();
                        ActivityC0460a.m1698b("TaskService|SERVICE_PROCESSING|finally|hasError = " + dVar.f1131t + "|isDone = " + dVar.mo4205s() + "|isPending = " + dVar.f1127p + "|isCycle = " + dVar.f1126o + "|isBlcok = " + dVar.mo4203q());
                        if (!dVar.f1131t) {
                            dVar.mo4199c();
                        }
                        if (!dVar.f1123k && !dVar.f1127p) {
                            ActivityC0460a.m1698b("TaskService|SERVICE_PROCESSING|finally|mainQueue.offer task = " + dVar);
                            dVar.f1112A = 0;
                            cVar.mo4188a(dVar);
                        }
                        throw th;
                    }
                case 1:
                    try {
                        dVar = cVar.mo4191c();
                    } catch (InterruptedException e3) {
                    }
                    if (dVar != null) {
                        if (!dVar.f1123k && !dVar.f1124m) {
                            c = 65535;
                            break;
                        } else {
                            dVar = null;
                            break;
                        }
                    }
                    break;
                case 2:
                    this.f1172c.mo4223g();
                    dVar = dVar;
                    c = 1;
                    break;
            }
        }
        cVar.mo4192d();
    }
}
