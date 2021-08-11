package com.igexin.p012b.p013a.p020d;

import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.p012b.p013a.p020d.AbstractC0470d;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.igexin.b.a.d.c */
public class C0469c<E extends AbstractC0470d> {

    /* renamed from: i */
    static final /* synthetic */ boolean f1102i = (!C0469c.class.desiredAssertionStatus());

    /* renamed from: a */
    public String f1103a = getClass().getName();

    /* renamed from: b */
    final transient ReentrantLock f1104b = new ReentrantLock();

    /* renamed from: c */
    final transient Condition f1105c = this.f1104b.newCondition();

    /* renamed from: d */
    final TreeSet<E> f1106d;

    /* renamed from: e */
    final AtomicInteger f1107e = new AtomicInteger(0);

    /* renamed from: f */
    int f1108f;

    /* renamed from: g */
    C0471e f1109g;

    /* renamed from: h */
    public final AtomicLong f1110h = new AtomicLong(-1);

    public C0469c(Comparator<? super E> comparator, C0471e eVar) {
        this.f1106d = new TreeSet<>(comparator);
        this.f1109g = eVar;
    }

    /* renamed from: e */
    private E m1719e() {
        E a = mo4187a();
        if (a != null && this.f1106d.remove(a)) {
            return a;
        }
        return null;
    }

    /* renamed from: a */
    public final int mo4186a(E e, long j, TimeUnit timeUnit) {
        ReentrantLock reentrantLock = this.f1104b;
        reentrantLock.lock();
        try {
            if (!this.f1106d.contains(e)) {
                return -1;
            }
            this.f1106d.remove(e);
            e.f1132u = System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(j, timeUnit);
            int i = mo4188a(e) ? 1 : -2;
            reentrantLock.unlock();
            return i;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public E mo4187a() {
        try {
            return this.f1106d.first();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    /* renamed from: a */
    public final boolean mo4188a(E e) {
        if (e == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.f1104b;
        reentrantLock.lock();
        try {
            E a = mo4187a();
            int i = this.f1108f + 1;
            this.f1108f = i;
            e.f1133v = i;
            if (!this.f1106d.add(e)) {
                e.f1133v--;
                return false;
            }
            e.mo4200n();
            if (a == null || this.f1106d.comparator().compare(e, a) < 0) {
                this.f1105c.signalAll();
            }
            reentrantLock.unlock();
            return true;
        } catch (Exception e2) {
            ActivityC0460a.m1698b("ScheduleQueue|offer|error");
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* renamed from: a */
    public final boolean mo4189a(Class cls) {
        if (cls == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.f1104b;
        reentrantLock.lock();
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<E> it = this.f1106d.iterator();
            while (it.hasNext()) {
                E next = it.next();
                if (next.getClass() == cls) {
                    arrayList.add(next);
                }
            }
            this.f1106d.removeAll(arrayList);
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean mo4190b() {
        ReentrantLock reentrantLock = this.f1104b;
        reentrantLock.lock();
        try {
            return this.f1106d.isEmpty();
        } finally {
            reentrantLock.unlock();
        }
    }

    /* renamed from: c */
    public final E mo4191c() {
        ReentrantLock reentrantLock = this.f1104b;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E a = mo4187a();
                if (a == null) {
                    this.f1107e.set(1);
                    this.f1108f = 0;
                    this.f1105c.await();
                } else {
                    long a2 = a.mo4194a(TimeUnit.NANOSECONDS);
                    boolean z = a.f1123k || a.f1124m;
                    if (a2 <= 0 || z) {
                        E e = m1719e();
                    } else {
                        this.f1110h.set(a.f1132u);
                        ActivityC0460a.m1698b("schedule take|needAlarm = " + this.f1109g.f1153t + "|" + a.getClass().getName() + "@" + a.hashCode());
                        if (this.f1109g.f1153t) {
                            this.f1109g.mo4211a(a.f1132u);
                        }
                        this.f1105c.awaitNanos(a2);
                    }
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        E e2 = m1719e();
        if (f1102i || e2 != null) {
            if (!mo4190b()) {
                this.f1105c.signalAll();
            }
            this.f1110h.set(-1);
            return e2;
        }
        throw new AssertionError();
    }

    /* renamed from: d */
    public final void mo4192d() {
        this.f1106d.clear();
    }
}
