package com.igexin.p012b.p013a.p015b.p016a.p017a;

import android.text.TextUtils;
import com.igexin.p012b.p013a.p015b.AbstractC0455b;
import com.igexin.p012b.p013a.p015b.C0457d;
import com.igexin.p012b.p013a.p015b.p016a.p017a.p018a.AbstractC0440c;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;

/* renamed from: com.igexin.b.a.b.a.a.l */
public final class C0452l extends AbstractC0437a {

    /* renamed from: L */
    private static final String f1067L = C0452l.class.getName();

    /* renamed from: M */
    private AbstractC0440c f1068M;

    /* renamed from: N */
    private C0457d f1069N;

    /* renamed from: i */
    public AbstractC0455b f1070i;

    /* renamed from: j */
    C0454n f1071j;

    public C0452l(C0454n nVar, AbstractC0455b bVar, C0457d dVar) {
        super(-2036, null, bVar);
        this.f1070i = bVar;
        this.f1069N = dVar;
        this.f1071j = nVar;
    }

    /* renamed from: a */
    public void mo4152a(AbstractC0440c cVar) {
        this.f1068M = cVar;
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public final int mo4136b() {
        return -2036;
    }

    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: b_ */
    public void mo4137b_() {
        super.mo4137b_();
        Thread currentThread = Thread.currentThread();
        ActivityC0460a.m1698b(f1067L + "|" + currentThread + " running");
        C0444d a = C0444d.m1594a();
        while (this.f1031h && !currentThread.isInterrupted() && !this.f1028e) {
            try {
                a.f1042a.lock();
                if (a.f1044c.isEmpty()) {
                    a.f1043b.await();
                }
                C0451k poll = a.f1044c.poll();
                if (poll != null) {
                    poll.f1089d = this.f1069N;
                    if (!(this.f1069N == null || this.f1071j == null || this.f1028e)) {
                        this.f1029f = EnumC0442b.NORMAL;
                        this.f1071j.mo4157a((byte[]) this.f1070i.mo4162d(null, this.f1069N, poll.f1088c));
                        ActivityC0460a.m1698b(f1067L + "|" + poll.toString() + " --> " + poll.f1088c.getClass().getName() + "-- send success");
                        if (this.f1068M != null && !this.f1028e) {
                            this.f1068M.mo4131a(poll);
                        }
                    }
                }
                try {
                    a.f1042a.unlock();
                } catch (Exception e) {
                }
            } catch (Throwable th) {
                try {
                    a.f1042a.unlock();
                } catch (Exception e2) {
                }
                throw th;
            }
        }
        this.f1028e = true;
        ActivityC0460a.m1698b(f1067L + "|finish ~~~~~~");
    }

    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d, com.igexin.p012b.p013a.p015b.AbstractC0458e
    /* renamed from: f */
    public void mo4138f() {
        super.mo4138f();
        ActivityC0460a.m1698b(f1067L + "|dispose");
        if (this.f1068M != null) {
            if (this.f1029f != EnumC0442b.EXCEPTION) {
                this.f1068M.mo4129a(this);
            } else if (!TextUtils.isEmpty(this.f1030g)) {
                this.f1068M.mo4132a(new Exception(this.f1030g));
            }
        }
        this.f1068M = null;
    }

    /* renamed from: h */
    public void mo4153h() {
        this.f1031h = false;
        this.f1029f = EnumC0442b.INTERRUPT;
        C0444d a = C0444d.m1594a();
        try {
            if (!this.f1028e) {
                a.f1042a.lock();
                C0444d.m1594a().f1043b.signalAll();
            }
            try {
                a.f1042a.unlock();
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            try {
                a.f1042a.unlock();
            } catch (Exception e3) {
            }
        } catch (Throwable th) {
            try {
                a.f1042a.unlock();
            } catch (Exception e4) {
            }
            throw th;
        }
    }
}
