package p000a.p001a.p002a.p004b;

import com.j256.ormlite.stmt.query.SimpleComparison;

/* renamed from: a.a.a.b.c */
/* compiled from: TField */
public class C0014c {

    /* renamed from: a */
    public final String f64a;

    /* renamed from: b */
    public final byte f65b;

    /* renamed from: c */
    public final short f66c;

    public C0014c() {
        this("", (byte) 0, 0);
    }

    public C0014c(String str, byte b, short s) {
        this.f64a = str;
        this.f65b = b;
        this.f66c = s;
    }

    public String toString() {
        return "<TField name:'" + this.f64a + "' type:" + ((int) this.f65b) + " field-id:" + ((int) this.f66c) + SimpleComparison.GREATER_THAN_OPERATION;
    }

    /* renamed from: a */
    public boolean mo58a(C0014c cVar) {
        return this.f65b == cVar.f65b && this.f66c == cVar.f66c;
    }
}
