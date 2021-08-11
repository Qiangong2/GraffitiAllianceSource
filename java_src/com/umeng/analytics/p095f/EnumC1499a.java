package com.umeng.analytics.p095f;

import p000a.p001a.p002a.AbstractC0044h;

/* renamed from: com.umeng.analytics.f.a */
/* compiled from: Gender */
public enum EnumC1499a implements AbstractC0044h {
    MALE(0),
    FEMALE(1),
    UNKNOWN(2);
    

    /* renamed from: d */
    private final int f3750d;

    private EnumC1499a(int i) {
        this.f3750d = i;
    }

    @Override // p000a.p001a.p002a.AbstractC0044h
    /* renamed from: a */
    public int mo112a() {
        return this.f3750d;
    }

    /* renamed from: a */
    public static EnumC1499a m5594a(int i) {
        switch (i) {
            case 0:
                return MALE;
            case 1:
                return FEMALE;
            case 2:
                return UNKNOWN;
            default:
                return null;
        }
    }
}
