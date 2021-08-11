package p000a.p001a.p002a;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import p000a.p001a.p002a.p004b.AbstractC0019h;
import p000a.p001a.p002a.p004b.AbstractC0021j;
import p000a.p001a.p002a.p004b.C0011b;
import p000a.p001a.p002a.p006d.C0034a;

/* renamed from: a.a.a.m */
/* compiled from: TSerializer */
public class C0049m {

    /* renamed from: a */
    private final ByteArrayOutputStream f138a;

    /* renamed from: b */
    private final C0034a f139b;

    /* renamed from: c */
    private AbstractC0019h f140c;

    public C0049m() {
        this(new C0011b.C0012a());
    }

    public C0049m(AbstractC0021j jVar) {
        this.f138a = new ByteArrayOutputStream();
        this.f139b = new C0034a(this.f138a);
        this.f140c = jVar.mo55a(this.f139b);
    }

    /* renamed from: a */
    public byte[] mo116a(AbstractC0033d dVar) throws C0046j {
        this.f138a.reset();
        dVar.mo76b(this.f140c);
        return this.f138a.toByteArray();
    }

    /* renamed from: a */
    public String mo115a(AbstractC0033d dVar, String str) throws C0046j {
        try {
            return new String(mo116a(dVar), str);
        } catch (UnsupportedEncodingException e) {
            throw new C0046j("JVM DOES NOT SUPPORT ENCODING: " + str);
        }
    }

    /* renamed from: b */
    public String mo117b(AbstractC0033d dVar) throws C0046j {
        return new String(mo116a(dVar));
    }
}
