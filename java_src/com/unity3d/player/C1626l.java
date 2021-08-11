package com.unity3d.player;

/* access modifiers changed from: package-private */
/* renamed from: com.unity3d.player.l */
public final class C1626l {

    /* renamed from: a */
    private static boolean f4163a = false;

    /* renamed from: b */
    private boolean f4164b;

    /* renamed from: c */
    private boolean f4165c;

    /* renamed from: d */
    private boolean f4166d;

    /* renamed from: e */
    private boolean f4167e;

    C1626l() {
        this.f4164b = !C1617h.f4142c;
        this.f4165c = false;
        this.f4166d = false;
        this.f4167e = true;
    }

    /* renamed from: a */
    static void m6135a() {
        f4163a = true;
    }

    /* renamed from: b */
    static void m6136b() {
        f4163a = false;
    }

    /* renamed from: c */
    static boolean m6137c() {
        return f4163a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo9115a(boolean z) {
        this.f4165c = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo9116b(boolean z) {
        this.f4167e = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo9117c(boolean z) {
        this.f4166d = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo9118d() {
        this.f4164b = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final boolean mo9119e() {
        return this.f4167e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final boolean mo9120f() {
        return f4163a && this.f4165c && this.f4164b && !this.f4167e && !this.f4166d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public final boolean mo9121g() {
        return this.f4166d;
    }

    public final String toString() {
        return super.toString();
    }
}
