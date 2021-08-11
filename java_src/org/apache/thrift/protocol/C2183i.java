package org.apache.thrift.protocol;

import org.apache.thrift.C2164f;

/* renamed from: org.apache.thrift.protocol.i */
public class C2183i {

    /* renamed from: a */
    private static int f6219a = Integer.MAX_VALUE;

    /* renamed from: a */
    public static void m8338a(AbstractC2180f fVar, byte b) {
        m8339a(fVar, b, f6219a);
    }

    /* renamed from: a */
    public static void m8339a(AbstractC2180f fVar, byte b, int i) {
        int i2 = 0;
        if (i <= 0) {
            throw new C2164f("Maximum skip depth exceeded");
        }
        switch (b) {
            case 2:
                fVar.mo12155q();
                return;
            case 3:
                fVar.mo12156r();
                return;
            case 4:
                fVar.mo12160v();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                fVar.mo12157s();
                return;
            case 8:
                fVar.mo12158t();
                return;
            case 10:
                fVar.mo12159u();
                return;
            case 11:
                fVar.mo12162x();
                return;
            case 12:
                fVar.mo12145g();
                while (true) {
                    C2177c i3 = fVar.mo12147i();
                    if (i3.f6210b == 0) {
                        fVar.mo12146h();
                        return;
                    } else {
                        m8339a(fVar, i3.f6210b, i - 1);
                        fVar.mo12148j();
                    }
                }
            case 13:
                C2179e k = fVar.mo12149k();
                while (i2 < k.f6216c) {
                    m8339a(fVar, k.f6214a, i - 1);
                    m8339a(fVar, k.f6215b, i - 1);
                    i2++;
                }
                fVar.mo12150l();
                return;
            case 14:
                C2184j o = fVar.mo12153o();
                while (i2 < o.f6221b) {
                    m8339a(fVar, o.f6220a, i - 1);
                    i2++;
                }
                fVar.mo12154p();
                return;
            case 15:
                C2178d m = fVar.mo12151m();
                while (i2 < m.f6213b) {
                    m8339a(fVar, m.f6212a, i - 1);
                    i2++;
                }
                fVar.mo12152n();
                return;
        }
    }
}
