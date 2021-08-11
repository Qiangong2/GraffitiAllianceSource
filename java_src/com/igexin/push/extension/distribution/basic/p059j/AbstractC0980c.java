package com.igexin.push.extension.distribution.basic.p059j;

/* renamed from: com.igexin.push.extension.distribution.basic.j.c */
public abstract class AbstractC0980c {

    /* renamed from: c */
    protected long f2507c = 0;

    /* renamed from: d */
    protected long f2508d = 0;

    /* renamed from: a */
    public abstract void mo5626a();

    /* renamed from: a */
    public void mo5627a(long j) {
        this.f2507c = j;
    }

    /* renamed from: b */
    public boolean mo5628b() {
        return System.currentTimeMillis() - this.f2507c > this.f2508d;
    }
}
