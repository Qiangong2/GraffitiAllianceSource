package p000a.p001a.p002a.p003a;

import java.io.Serializable;

/* renamed from: a.a.a.a.c */
/* compiled from: FieldValueMetaData */
public class C0003c implements Serializable {

    /* renamed from: a */
    private final boolean f5a;

    /* renamed from: b */
    public final byte f6b;

    /* renamed from: c */
    private final String f7c;

    /* renamed from: d */
    private final boolean f8d;

    public C0003c(byte b, boolean z) {
        this.f6b = b;
        this.f5a = false;
        this.f7c = null;
        this.f8d = z;
    }

    public C0003c(byte b) {
        this(b, false);
    }

    public C0003c(byte b, String str) {
        this.f6b = b;
        this.f5a = true;
        this.f7c = str;
        this.f8d = false;
    }

    /* renamed from: a */
    public boolean mo1a() {
        return this.f5a;
    }

    /* renamed from: b */
    public String mo2b() {
        return this.f7c;
    }

    /* renamed from: c */
    public boolean mo3c() {
        return this.f6b == 12;
    }

    /* renamed from: d */
    public boolean mo4d() {
        return this.f6b == 15 || this.f6b == 13 || this.f6b == 14;
    }

    /* renamed from: e */
    public boolean mo5e() {
        return this.f8d;
    }
}
