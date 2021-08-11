package p000a.p001a.p002a;

import p000a.p001a.p002a.p004b.AbstractC0019h;
import p000a.p001a.p002a.p004b.C0014c;
import p000a.p001a.p002a.p004b.C0022k;
import p000a.p001a.p002a.p004b.C0024m;

/* renamed from: a.a.a.c */
/* compiled from: TApplicationException */
public class C0028c extends C0046j {

    /* renamed from: a */
    public static final int f106a = 0;

    /* renamed from: b */
    public static final int f107b = 1;

    /* renamed from: c */
    public static final int f108c = 2;

    /* renamed from: d */
    public static final int f109d = 3;

    /* renamed from: e */
    public static final int f110e = 4;

    /* renamed from: f */
    public static final int f111f = 5;

    /* renamed from: g */
    public static final int f112g = 6;

    /* renamed from: h */
    public static final int f113h = 7;

    /* renamed from: j */
    private static final C0024m f114j = new C0024m("TApplicationException");

    /* renamed from: k */
    private static final C0014c f115k = new C0014c("message", (byte) 11, 1);

    /* renamed from: l */
    private static final C0014c f116l = new C0014c("type", (byte) 8, 2);

    /* renamed from: m */
    private static final long f117m = 1;

    /* renamed from: i */
    protected int f118i = 0;

    public C0028c() {
    }

    public C0028c(int i) {
        this.f118i = i;
    }

    public C0028c(int i, String str) {
        super(str);
        this.f118i = i;
    }

    public C0028c(String str) {
        super(str);
    }

    /* renamed from: a */
    public int mo68a() {
        return this.f118i;
    }

    /* renamed from: a */
    public static C0028c m195a(AbstractC0019h hVar) throws C0046j {
        hVar.mo38j();
        String str = null;
        int i = 0;
        while (true) {
            C0014c l = hVar.mo40l();
            if (l.f65b == 0) {
                hVar.mo39k();
                return new C0028c(i, str);
            }
            switch (l.f66c) {
                case 1:
                    if (l.f65b != 11) {
                        C0022k.m187a(hVar, l.f65b);
                        break;
                    } else {
                        str = hVar.mo54z();
                        break;
                    }
                case 2:
                    if (l.f65b != 8) {
                        C0022k.m187a(hVar, l.f65b);
                        break;
                    } else {
                        i = hVar.mo51w();
                        break;
                    }
                default:
                    C0022k.m187a(hVar, l.f65b);
                    break;
            }
            hVar.mo41m();
        }
    }

    /* renamed from: b */
    public void mo69b(AbstractC0019h hVar) throws C0046j {
        hVar.mo22a(f114j);
        if (getMessage() != null) {
            hVar.mo17a(f115k);
            hVar.mo23a(getMessage());
            hVar.mo29c();
        }
        hVar.mo17a(f116l);
        hVar.mo15a(this.f118i);
        hVar.mo29c();
        hVar.mo31d();
        hVar.mo28b();
    }
}
