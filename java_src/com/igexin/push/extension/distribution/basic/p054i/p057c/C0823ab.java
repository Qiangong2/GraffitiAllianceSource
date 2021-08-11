package com.igexin.push.extension.distribution.basic.p054i.p057c;

/* renamed from: com.igexin.push.extension.distribution.basic.i.c.ab */
public class C0823ab {

    /* renamed from: a */
    private int f2307a;

    /* renamed from: b */
    private String f2308b;

    C0823ab(int i, String str) {
        this.f2307a = i;
        this.f2308b = str;
    }

    C0823ab(int i, String str, Object... objArr) {
        this.f2308b = String.format(str, objArr);
        this.f2307a = i;
    }

    public String toString() {
        return this.f2307a + ": " + this.f2308b;
    }
}
