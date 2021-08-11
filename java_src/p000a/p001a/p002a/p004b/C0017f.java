package p000a.p001a.p002a.p004b;

import com.j256.ormlite.stmt.query.SimpleComparison;

/* renamed from: a.a.a.b.f */
/* compiled from: TMessage */
public final class C0017f {

    /* renamed from: a */
    public final String f72a;

    /* renamed from: b */
    public final byte f73b;

    /* renamed from: c */
    public final int f74c;

    public C0017f() {
        this("", (byte) 0, 0);
    }

    public C0017f(String str, byte b, int i) {
        this.f72a = str;
        this.f73b = b;
        this.f74c = i;
    }

    public String toString() {
        return "<TMessage name:'" + this.f72a + "' type: " + ((int) this.f73b) + " seqid:" + this.f74c + SimpleComparison.GREATER_THAN_OPERATION;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0017f) {
            return mo60a((C0017f) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo60a(C0017f fVar) {
        return this.f72a.equals(fVar.f72a) && this.f73b == fVar.f73b && this.f74c == fVar.f74c;
    }
}
