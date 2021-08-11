package com.igexin.p012b.p013a.p020d;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;
import com.igexin.p012b.p013a.p015b.p016a.p017a.C0444d;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.p012b.p013a.p020d.p021a.AbstractC0463b;
import com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e;
import com.igexin.push.p032d.p035c.C0653p;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.igexin.b.a.d.e */
public class C0471e extends BroadcastReceiver implements Comparator<AbstractC0470d> {

    /* renamed from: g */
    public static final String f1138g = C0471e.class.getName();

    /* renamed from: u */
    public static final long f1139u = TimeUnit.SECONDS.toMillis(2);

    /* renamed from: a */
    private boolean f1140a = false;

    /* renamed from: h */
    final C0475i f1141h = new C0475i(this);

    /* renamed from: i */
    final HashMap<Long, AbstractC0463b> f1142i = new HashMap<>(7);

    /* renamed from: j */
    final ConcurrentLinkedQueue<AbstractC0466e> f1143j = new ConcurrentLinkedQueue<>();

    /* renamed from: k */
    final C0469c<AbstractC0470d> f1144k = new C0469c<>(this, this);

    /* renamed from: l */
    final ReentrantLock f1145l = new ReentrantLock();

    /* renamed from: m */
    PowerManager f1146m;

    /* renamed from: n */
    AlarmManager f1147n;

    /* renamed from: o */
    Intent f1148o;

    /* renamed from: p */
    PendingIntent f1149p;

    /* renamed from: q */
    Intent f1150q;

    /* renamed from: r */
    PendingIntent f1151r;

    /* renamed from: s */
    String f1152s;

    /* renamed from: t */
    volatile boolean f1153t;

    protected C0471e() {
        AbstractC0470d.f1111E = this;
    }

    /* renamed from: a */
    public final int compare(AbstractC0470d dVar, AbstractC0470d dVar2) {
        int i = dVar.f1112A > dVar2.f1112A ? -1 : dVar.f1112A < dVar2.f1112A ? 1 : dVar.f1133v < dVar2.f1133v ? -1 : dVar.f1133v > dVar2.f1133v ? 1 : 0;
        if (dVar.f1132u != dVar2.f1132u) {
            i = dVar.f1132u < dVar2.f1132u ? -1 : 1;
        }
        return i == 0 ? dVar.hashCode() - dVar2.hashCode() : i;
    }

    @TargetApi(19)
    /* renamed from: a */
    public final void mo4211a(long j) {
        if (this.f1153t) {
            ActivityC0460a.m1698b("setalarm|" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(j)));
            if (j < 0) {
                j = System.currentTimeMillis() + f1139u;
            }
            try {
                if (this.f1149p == null) {
                    return;
                }
                if (Build.VERSION.SDK_INT < 19) {
                    this.f1147n.set(0, j, this.f1149p);
                    return;
                }
                try {
                    this.f1147n.setExact(0, j, this.f1149p);
                } catch (Throwable th) {
                    this.f1147n.set(0, j, this.f1149p);
                }
            } catch (Throwable th2) {
                ActivityC0460a.m1698b("TaskService" + th2.toString());
            }
        }
    }

    /* renamed from: a */
    public final void mo4212a(Context context) {
        if (!this.f1140a) {
            this.f1146m = (PowerManager) context.getSystemService("power");
            this.f1153t = true;
            this.f1147n = (AlarmManager) context.getSystemService("alarm");
            context.registerReceiver(this, new IntentFilter("AlarmTaskSchedule." + context.getPackageName()));
            context.registerReceiver(this, new IntentFilter("AlarmTaskScheduleBak." + context.getPackageName()));
            context.registerReceiver(this, new IntentFilter("android.intent.action.SCREEN_OFF"));
            context.registerReceiver(this, new IntentFilter("android.intent.action.SCREEN_ON"));
            this.f1152s = "AlarmNioTaskSchedule." + context.getPackageName();
            context.registerReceiver(this, new IntentFilter(this.f1152s));
            this.f1148o = new Intent("AlarmTaskSchedule." + context.getPackageName());
            this.f1149p = PendingIntent.getBroadcast(context, hashCode(), this.f1148o, 134217728);
            this.f1150q = new Intent(this.f1152s);
            this.f1151r = PendingIntent.getBroadcast(context, hashCode() + 2, this.f1150q, 134217728);
            this.f1141h.start();
            try {
                Thread.yield();
            } catch (Throwable th) {
            }
            this.f1140a = true;
        }
    }

    /* renamed from: a */
    public final boolean mo4213a(AbstractC0463b bVar) {
        if (bVar == null) {
            throw new NullPointerException();
        }
        ReentrantLock reentrantLock = this.f1145l;
        if (!reentrantLock.tryLock()) {
            return false;
        }
        try {
            if (this.f1142i.keySet().contains(Long.valueOf(bVar.mo4180o()))) {
                return false;
            }
            this.f1142i.put(Long.valueOf(bVar.mo4180o()), bVar);
            reentrantLock.unlock();
            return true;
        } catch (Throwable th) {
            ActivityC0460a.m1698b("TaskService|" + th.toString());
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo4214a(AbstractC0466e eVar, AbstractC0463b bVar) {
        int b = eVar.mo4136b();
        if (b > Integer.MIN_VALUE && b < 0) {
            AbstractC0470d dVar = (AbstractC0470d) eVar;
            boolean a = dVar.f1131t ? bVar.mo4178a(dVar, this) : bVar.mo4177a(eVar, this);
            if (a) {
                dVar.mo4199c();
            }
            return a;
        } else if (b < 0 || b >= Integer.MAX_VALUE) {
            return false;
        } else {
            return bVar.mo4177a(eVar, this);
        }
    }

    /* renamed from: a */
    public final boolean mo4215a(AbstractC0470d dVar, boolean z) {
        int i = 0;
        if (dVar == null) {
            throw new NullPointerException();
        } else if (dVar.f1127p || dVar.f1123k) {
            return false;
        } else {
            C0469c<AbstractC0470d> cVar = this.f1144k;
            if (z) {
                i = cVar.f1107e.incrementAndGet();
            }
            dVar.f1112A = i;
            return cVar.mo4188a(dVar);
        }
    }

    /* renamed from: a */
    public final boolean mo4216a(AbstractC0470d dVar, boolean z, boolean z2) {
        boolean z3 = true;
        if (dVar == null) {
            throw new NullPointerException();
        } else if (dVar.f1124m) {
            return false;
        } else {
            if (!z || z2) {
                if (!z2 || !z) {
                    z3 = false;
                }
                return mo4215a(dVar, z3);
            }
            dVar.mo4126d();
            try {
                dVar.mo4137b_();
                dVar.mo4206t();
                dVar.mo4208v();
                if (!dVar.f1131t) {
                    dVar.mo4199c();
                }
                return true;
            } catch (Exception e) {
                dVar.f1131t = true;
                dVar.f1113B = e;
                dVar.mo4202p();
                dVar.mo4209w();
                mo4218a(dVar);
                mo4222f();
                if (dVar.f1131t) {
                    return false;
                }
                dVar.mo4199c();
                return false;
            } catch (Throwable th) {
                if (!dVar.f1131t) {
                    dVar.mo4199c();
                }
                throw th;
            }
        }
    }

    /* renamed from: a */
    public final boolean mo4217a(Class cls) {
        C0469c<AbstractC0470d> cVar = this.f1144k;
        return cVar != null && cVar.mo4189a(cls);
    }

    /* renamed from: a */
    public final boolean mo4218a(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            if (obj instanceof C0653p) {
                ActivityC0460a.m1696a("TaskService|responseTask|" + obj.getClass().getName() + "|" + obj.hashCode() + "|" + ((String) ((C0653p) obj).f1776e));
            }
        } catch (Exception e) {
        }
        ActivityC0460a.m1698b("TaskService|responseQueue ++ task = " + obj.getClass().getName() + "@" + obj.hashCode());
        if (!(obj instanceof AbstractC0466e)) {
            throw new ClassCastException("response Obj is not a TaskResult ");
        }
        AbstractC0466e eVar = (AbstractC0466e) obj;
        if (eVar.mo4174l()) {
            return false;
        }
        eVar.mo4173b(false);
        this.f1143j.offer(eVar);
        return true;
    }

    @TargetApi(19)
    /* renamed from: b */
    public final void mo4219b(long j) {
        ActivityC0460a.m1698b("setnioalarm|" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(j)));
        if (j < 0) {
            j = System.currentTimeMillis() + f1139u;
        }
        try {
            if (Build.VERSION.SDK_INT < 19) {
                this.f1147n.set(0, j, this.f1151r);
                return;
            }
            try {
                this.f1147n.setExact(0, j, this.f1151r);
            } catch (Exception e) {
                this.f1147n.set(0, j, this.f1151r);
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: e */
    public final void mo4221e() {
        try {
            if (this.f1151r != null) {
                this.f1147n.cancel(this.f1151r);
            }
        } catch (Throwable th) {
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public final void mo4222f() {
        if (this.f1141h != null && !this.f1141h.isInterrupted()) {
            this.f1141h.interrupt();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final void mo4223g() {
        int b;
        int b2;
        int b3;
        ActivityC0460a.m1698b("TaskService|call notifyObserver ~~~~");
        while (!this.f1143j.isEmpty()) {
            AbstractC0466e poll = this.f1143j.poll();
            ActivityC0460a.m1698b("TaskService|notifyObserver responseQueue -- task = " + poll);
            poll.mo4173b(true);
            boolean z = false;
            ReentrantLock reentrantLock = this.f1145l;
            reentrantLock.lock();
            try {
                if (!this.f1142i.isEmpty()) {
                    long m = poll.mo4175m();
                    if (m == 0) {
                        for (AbstractC0463b bVar : this.f1142i.values()) {
                            if (bVar.mo4179n() && (z = mo4214a(poll, bVar))) {
                                break;
                            }
                        }
                    } else {
                        AbstractC0463b bVar2 = this.f1142i.get(Long.valueOf(m));
                        z = (bVar2 == null || !bVar2.mo4179n()) ? false : mo4214a(poll, bVar2);
                    }
                }
                if (!z && (b3 = poll.mo4136b()) > Integer.MIN_VALUE && b3 < 0) {
                    ((AbstractC0470d) poll).mo4199c();
                }
                reentrantLock.unlock();
            } catch (Throwable th) {
                if (0 == 0 && (b = poll.mo4136b()) > Integer.MIN_VALUE && b < 0) {
                    ((AbstractC0470d) poll).mo4199c();
                }
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.f1153t = true;
            ActivityC0460a.m1698b("screenoff");
            if (this.f1144k.f1110h.get() > 0) {
                mo4211a(this.f1144k.f1110h.get());
            }
        } else if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
            this.f1153t = false;
            ActivityC0460a.m1698b("screenon");
        } else if (intent.getAction().startsWith("AlarmTaskSchedule.") || intent.getAction().startsWith("AlarmTaskScheduleBak.")) {
            ActivityC0460a.m1698b("receivealarm|" + this.f1153t);
            mo4222f();
        } else if (this.f1152s.equals(intent.getAction())) {
            ActivityC0460a.m1698b("receive nioalarm");
            try {
                ActivityC0460a.m1698b("TaskService|alarm time out #######");
                C0444d.m1594a().mo4146d();
            } catch (Exception e) {
            }
        }
    }
}
