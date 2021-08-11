package p000a.p001a.p002a.p004b;

import p000a.p001a.p002a.C0046j;
import p000a.p001a.p002a.p004b.C0011b;

/* renamed from: a.a.a.b.k */
/* compiled from: TProtocolUtil */
public class C0022k {

    /* renamed from: a */
    private static int f88a = Integer.MAX_VALUE;

    /* renamed from: a */
    public static void m186a(int i) {
        f88a = i;
    }

    /* renamed from: a */
    public static void m187a(AbstractC0019h hVar, byte b) throws C0046j {
        m188a(hVar, b, f88a);
    }

    /* renamed from: a */
    public static void m188a(AbstractC0019h hVar, byte b, int i) throws C0046j {
        int i2 = 0;
        if (i <= 0) {
            throw new C0046j("Maximum skip depth exceeded");
        }
        switch (b) {
            case 2:
                hVar.mo48t();
                return;
            case 3:
                hVar.mo49u();
                return;
            case 4:
                hVar.mo53y();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                hVar.mo50v();
                return;
            case 8:
                hVar.mo51w();
                return;
            case 10:
                hVar.mo52x();
                return;
            case 11:
                hVar.mo11A();
                return;
            case 12:
                hVar.mo38j();
                while (true) {
                    C0014c l = hVar.mo40l();
                    if (l.f65b == 0) {
                        hVar.mo39k();
                        return;
                    } else {
                        m188a(hVar, l.f65b, i - 1);
                        hVar.mo41m();
                    }
                }
            case 13:
                C0016e n = hVar.mo42n();
                while (i2 < n.f71c) {
                    m188a(hVar, n.f69a, i - 1);
                    m188a(hVar, n.f70b, i - 1);
                    i2++;
                }
                hVar.mo43o();
                return;
            case 14:
                C0023l r = hVar.mo46r();
                while (i2 < r.f90b) {
                    m188a(hVar, r.f89a, i - 1);
                    i2++;
                }
                hVar.mo47s();
                return;
            case 15:
                C0015d p = hVar.mo44p();
                while (i2 < p.f68b) {
                    m188a(hVar, p.f67a, i - 1);
                    i2++;
                }
                hVar.mo45q();
                return;
        }
    }

    /* renamed from: a */
    public static AbstractC0021j m185a(byte[] bArr, AbstractC0021j jVar) {
        if (bArr[0] > 16) {
            return new C0011b.C0012a();
        }
        if (bArr.length <= 1 || (bArr[1] & 128) == 0) {
            return jVar;
        }
        return new C0011b.C0012a();
    }
}
