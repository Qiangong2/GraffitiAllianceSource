package com.igexin.p012b.p013a.p020d;

import com.igexin.p012b.p013a.p020d.p021a.AbstractC0464c;
import com.igexin.p012b.p013a.p020d.p021a.AbstractC0467f;
import com.igexin.p012b.p013a.p020d.p021a.EnumC0465d;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import p000a.p001a.p002a.p004b.C0027o;

/* renamed from: com.igexin.b.a.d.d */
public abstract class AbstractC0470d extends AbstractC0461a {

    /* renamed from: E */
    protected static C0471e f1111E;

    /* renamed from: A */
    public int f1112A;

    /* renamed from: B */
    public Exception f1113B;

    /* renamed from: C */
    public Object f1114C;

    /* renamed from: D */
    public AbstractC0467f f1115D;

    /* renamed from: F */
    protected final ReentrantLock f1116F;

    /* renamed from: G */
    protected final Condition f1117G;

    /* renamed from: H */
    Thread f1118H;

    /* renamed from: I */
    protected volatile boolean f1119I;

    /* renamed from: J */
    int f1120J;

    /* renamed from: K */
    protected AbstractC0464c f1121K;

    /* renamed from: a */
    private byte f1122a;

    /* renamed from: k */
    protected volatile boolean f1123k;

    /* renamed from: m */
    protected volatile boolean f1124m;

    /* renamed from: n */
    protected volatile boolean f1125n;

    /* renamed from: o */
    protected volatile boolean f1126o;

    /* renamed from: p */
    protected volatile boolean f1127p;

    /* renamed from: q */
    protected volatile boolean f1128q;

    /* renamed from: r */
    protected volatile boolean f1129r;

    /* renamed from: s */
    protected volatile boolean f1130s;

    /* renamed from: t */
    protected volatile boolean f1131t;

    /* renamed from: u */
    protected volatile long f1132u;

    /* renamed from: v */
    volatile int f1133v;

    /* renamed from: w */
    public long f1134w;

    /* renamed from: x */
    public int f1135x;

    /* renamed from: y */
    public int f1136y;

    /* renamed from: z */
    public int f1137z;

    public AbstractC0470d(int i) {
        this(i, null);
    }

    public AbstractC0470d(int i, AbstractC0464c cVar) {
        this.f1137z = i;
        this.f1121K = cVar;
        this.f1116F = new ReentrantLock();
        this.f1117G = this.f1116F.newCondition();
    }

    /* renamed from: a */
    public final int mo4193a(long j, TimeUnit timeUnit) {
        if (j <= 0) {
            return 0;
        }
        switch (f1111E.f1144k.mo4186a(this, j, timeUnit)) {
            case -2:
                return -2;
            case -1:
                this.f1132u = System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(j, timeUnit);
                return -1;
            case 0:
            default:
                return 0;
            case 1:
                return 1;
        }
    }

    /* renamed from: a */
    public long mo4194a(TimeUnit timeUnit) {
        return timeUnit.convert(mo4201o(), TimeUnit.MILLISECONDS);
    }

    /* renamed from: a */
    public final void mo4195a(int i) {
        this.f1122a = (byte) (this.f1122a & C0027o.f104m);
        this.f1122a = (byte) (this.f1122a | ((i & 15) << 4));
    }

    /* renamed from: a */
    public final void mo4196a(int i, AbstractC0467f fVar) {
        if (i < 0) {
            throw new IllegalArgumentException("second must > 0");
        }
        this.f1136y = i;
        this.f1115D = fVar;
    }

    /* renamed from: a */
    public final void mo4197a(AbstractC0464c cVar) {
        this.f1121K = cVar;
    }

    /* renamed from: b */
    public final void mo4198b(long j) {
        this.f1134w = j;
    }

    /* renamed from: b_ */
    public void mo4137b_() {
        this.f1118H = Thread.currentThread();
        this.f1127p = true;
    }

    /* renamed from: c */
    public void mo4199c() {
        if (this.f1123k || this.f1124m) {
            mo4138f();
        }
    }

    /* renamed from: d */
    public void mo4126d() {
        this.f1130s = true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public abstract void mo4127e();

    /* renamed from: f */
    public void mo4138f() {
        this.f1114C = null;
        this.f1113B = null;
        this.f1118H = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public final void mo4200n() {
        this.f1120J++;
        this.f1120J &= 1090519038;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public long mo4201o() {
        return this.f1132u - System.currentTimeMillis();
    }

    /* renamed from: p */
    public final void mo4202p() {
        this.f1123k = true;
    }

    /* renamed from: q */
    public final boolean mo4203q() {
        return this.f1125n;
    }

    /* renamed from: r */
    public final boolean mo4204r() {
        return this.f1124m;
    }

    /* renamed from: s */
    public final boolean mo4205s() {
        return this.f1123k;
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public void mo4206t() {
    }

    /* renamed from: u */
    public final void mo4207u() {
        this.f1124m = true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public void mo4208v() {
        if (!this.f1126o && !this.f1128q && !this.f1129r) {
            this.f1123k = true;
            this.f1127p = false;
        } else if (this.f1128q && !this.f1123k) {
            this.f1127p = false;
        } else if (this.f1126o && !this.f1125n && !this.f1123k) {
            this.f1127p = false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public void mo4209w() {
        if (this.f1121K != null) {
            this.f1121K.mo4181a(EnumC0465d.error);
        }
    }
}
