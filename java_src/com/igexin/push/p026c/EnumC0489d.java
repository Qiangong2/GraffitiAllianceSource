package com.igexin.push.p026c;

/* renamed from: com.igexin.push.c.d */
public enum EnumC0489d {
    NORMAL(0),
    BACKUP(1),
    TRY_NORMAL(2);
    

    /* renamed from: d */
    private int f1219d = -1;

    private EnumC0489d(int i) {
        this.f1219d = i;
    }

    /* renamed from: a */
    public static EnumC0489d m1831a(int i) {
        EnumC0489d[] a = m1832a();
        for (EnumC0489d dVar : a) {
            if (dVar.mo4276b() == i) {
                return dVar;
            }
        }
        return null;
    }

    /* renamed from: b */
    public int mo4276b() {
        return this.f1219d;
    }
}
