package com.igexin.p012b.p013a.p015b.p016a.p017a;

import android.text.TextUtils;
import com.igexin.p012b.p013a.p015b.AbstractC0455b;
import com.igexin.p012b.p013a.p015b.C0457d;
import com.igexin.p012b.p013a.p015b.p016a.p017a.p018a.AbstractC0439b;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;

/* renamed from: com.igexin.b.a.b.a.a.j */
public final class C0450j extends AbstractC0437a {

    /* renamed from: L */
    private static final String f1061L = C0450j.class.getName();

    /* renamed from: M */
    private AbstractC0439b f1062M;

    /* renamed from: N */
    private byte[] f1063N;

    /* renamed from: O */
    private C0457d f1064O;

    /* renamed from: i */
    C0453m f1065i;

    /* renamed from: j */
    AbstractC0455b f1066j;

    public C0450j(C0453m mVar, AbstractC0455b bVar, C0457d dVar) {
        super(-2035, null, bVar);
        this.f1066j = bVar;
        this.f1065i = mVar;
        this.f1064O = dVar;
    }

    /* renamed from: a */
    public void mo4150a(AbstractC0439b bVar) {
        this.f1062M = bVar;
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public final int mo4136b() {
        return -2035;
    }

    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: b_ */
    public void mo4137b_() {
        super.mo4137b_();
        Thread currentThread = Thread.currentThread();
        ActivityC0460a.m1698b(f1061L + "|" + currentThread + " running");
        while (this.f1031h && !currentThread.isInterrupted() && !this.f1028e) {
            try {
                this.f1066j.mo4161c(null, this.f1064O, this.f1065i);
                this.f1029f = EnumC0442b.NORMAL;
            } catch (Throwable th) {
                this.f1031h = false;
                if (this.f1029f != EnumC0442b.INTERRUPT) {
                    this.f1029f = EnumC0442b.EXCEPTION;
                    if (th.getMessage() == null || !th.getMessage().equals("read = -1, end of stream !")) {
                        this.f1030g = th.toString();
                    } else {
                        this.f1030g = "end of stream";
                    }
                }
            }
        }
        this.f1028e = true;
        ActivityC0460a.m1698b(f1061L + "|finish ~~~~~~");
    }

    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d, com.igexin.p012b.p013a.p015b.AbstractC0458e
    /* renamed from: f */
    public void mo4138f() {
        super.mo4138f();
        ActivityC0460a.m1698b(f1061L + "|dispose");
        if (this.f1062M != null) {
            if (this.f1029f != EnumC0442b.EXCEPTION) {
                this.f1062M.mo4129a(this);
            } else if (!TextUtils.isEmpty(this.f1030g)) {
                this.f1062M.mo4130a(new Exception(this.f1030g));
            }
        }
        if (this.f1063N != null) {
            this.f1063N = null;
        }
        this.f1062M = null;
    }

    /* renamed from: h */
    public void mo4151h() {
        this.f1031h = false;
        this.f1029f = EnumC0442b.INTERRUPT;
        try {
            if (!this.f1028e && this.f1065i.f1072a != null) {
                this.f1065i.f1072a.notifyAll();
            }
        } catch (Exception e) {
        }
    }
}
