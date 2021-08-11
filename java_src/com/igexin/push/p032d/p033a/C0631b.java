package com.igexin.push.p032d.p033a;

import com.igexin.p012b.p013a.p015b.AbstractC0455b;
import com.igexin.p012b.p013a.p015b.AbstractC0458e;
import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.p012b.p013a.p015b.C0457d;
import com.igexin.p012b.p013a.p015b.C0459f;
import com.igexin.p012b.p013a.p015b.p016a.p017a.C0453m;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e;
import com.igexin.push.p032d.p035c.C0639b;
import com.igexin.push.p032d.p035c.C0644g;
import com.igexin.push.util.EncryptUtils;

/* renamed from: com.igexin.push.d.a.b */
public class C0631b extends AbstractC0455b {

    /* renamed from: a */
    public static final String f1680a = C0631b.class.getName();

    /* renamed from: b */
    public static int f1681b = -1;

    /* renamed from: g */
    private byte[] f1682g;

    C0631b(String str) {
        super(str, true);
    }

    /* renamed from: a */
    private byte m2454a(C0453m mVar) {
        return (byte) m2459b(mVar, 1);
    }

    /* renamed from: a */
    public static AbstractC0455b m2455a() {
        C0631b bVar = new C0631b("socketProtocol");
        new C0630a("command", bVar);
        return bVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ea, code lost:
        if (r13.f1736g == 0) goto L_0x00a2;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e m2456a(com.igexin.p012b.p013a.p015b.AbstractC0458e r10, com.igexin.p012b.p013a.p015b.C0457d r11, com.igexin.p012b.p013a.p015b.p016a.p017a.C0453m r12, com.igexin.push.p032d.p035c.C0644g r13) {
        /*
        // Method dump skipped, instructions count: 293
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.p032d.p033a.C0631b.m2456a(com.igexin.b.a.b.e, com.igexin.b.a.b.d, com.igexin.b.a.b.a.a.m, com.igexin.push.d.c.g):com.igexin.b.a.d.a.e");
    }

    /* renamed from: a */
    static C0644g m2457a(C0639b bVar) {
        C0644g gVar = new C0644g();
        gVar.f1730a = 1944742139;
        gVar.mo4698a(bVar.f1703c);
        gVar.f1734e = bVar.f1702b > 0 ? 1 : 0;
        gVar.f1732c = 7;
        gVar.f1731b = 11;
        gVar.f1735f = bVar.f1704d;
        gVar.f1731b += EncryptUtils.getRSAKeyId().length;
        if (bVar.f1701a > 0) {
            gVar.f1745p = EncryptUtils.getPacketId();
            gVar.f1746q = (int) (System.currentTimeMillis() / 1000);
            gVar.f1743n = EncryptUtils.getSocketSignature(bVar, gVar.f1745p, gVar.f1746q);
            gVar.f1744o = gVar.f1743n.length;
            gVar.f1731b += gVar.f1744o;
        } else if (gVar.f1737h == 0) {
            gVar.f1744o = 0;
            gVar.f1731b += gVar.f1744o;
        }
        C0456c.m1662d();
        return gVar;
    }

    /* renamed from: a */
    private byte[] m2458a(C0453m mVar, int i) {
        byte[] bArr = new byte[i];
        mVar.mo4154a(bArr);
        return bArr;
    }

    /* renamed from: b */
    private int m2459b(C0453m mVar, int i) {
        byte[] a = m2458a(mVar, i);
        if (i == 1) {
            return C0459f.m1677a(a, 0);
        }
        if (i == 2) {
            return C0459f.m1686b(a, 0);
        }
        if (i == 4) {
            return C0459f.m1692d(a, 0);
        }
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009d, code lost:
        if (r10.f1736g == 0) goto L_0x0072;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e m2460b(com.igexin.p012b.p013a.p015b.AbstractC0458e r7, com.igexin.p012b.p013a.p015b.C0457d r8, com.igexin.p012b.p013a.p015b.p016a.p017a.C0453m r9, com.igexin.push.p032d.p035c.C0644g r10) {
        /*
        // Method dump skipped, instructions count: 160
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.p032d.p033a.C0631b.m2460b(com.igexin.b.a.b.e, com.igexin.b.a.b.d, com.igexin.b.a.b.a.a.m, com.igexin.push.d.c.g):com.igexin.b.a.d.a.e");
    }

    @Override // com.igexin.p012b.p013a.p015b.AbstractC0455b
    /* renamed from: a */
    public Object mo4158a(AbstractC0458e eVar, C0457d dVar, Object obj) {
        int c;
        if (!(obj instanceof C0639b)) {
            return null;
        }
        C0639b bVar = (C0639b) obj;
        C0644g a = m2457a(bVar);
        if (bVar.f1702b > 0 && bVar.f1701a > 0) {
            if ((a.f1736g & 192) == 128) {
                bVar.mo4686a(C0459f.m1691c(bVar.f1705e));
            }
            if ((a.f1737h & 48) == 16) {
                byte[] iv = EncryptUtils.getIV(C0459f.m1687b(a.f1746q));
                if ((a.f1735f & 16) != 16) {
                    bVar.mo4686a(EncryptUtils.aesEncSocket(bVar.f1705e, iv));
                }
            } else if ((a.f1737h & 48) != 0) {
                if ((a.f1737h & 48) == 48) {
                    ActivityC0460a.m1698b(f1680a + "|encry type = 0x30 not support");
                    return null;
                } else if ((a.f1737h & 48) == 32) {
                    ActivityC0460a.m1698b(f1680a + "|encry type = 0x20 reserved");
                } else {
                    ActivityC0460a.m1698b(f1680a + "|encry type = " + (a.f1737h & 48) + " not support");
                    return null;
                }
            }
        }
        byte[] bArr = new byte[((bVar.f1702b > 0 ? bVar.f1701a + 11 : 0) + a.f1731b)];
        int a2 = C0459f.m1675a(1944742139, bArr, 0);
        int c2 = a2 + C0459f.m1689c(a.f1731b, bArr, a2);
        int c3 = c2 + C0459f.m1689c(a.f1732c, bArr, c2);
        int c4 = c3 + C0459f.m1689c(a.mo4697a(), bArr, c3);
        int c5 = c4 + C0459f.m1689c(a.f1734e, bArr, c4);
        byte[] rSAKeyId = EncryptUtils.getRSAKeyId();
        int c6 = c5 + C0459f.m1689c(rSAKeyId.length, bArr, c5);
        int a3 = c6 + C0459f.m1678a(rSAKeyId, 0, bArr, c6, rSAKeyId.length);
        int c7 = a3 + C0459f.m1689c(a.mo4699b(), bArr, a3);
        if (bVar.f1701a > 0) {
            int c8 = c7 + C0459f.m1689c(a.f1744o, bArr, c7);
            c = c8 + C0459f.m1678a(a.f1743n, 0, bArr, c8, a.f1744o);
        } else {
            c = c7 + C0459f.m1689c(0, bArr, c7);
        }
        if (bVar.f1702b > 0) {
            int a4 = c + C0459f.m1675a(a.f1745p, bArr, c);
            int a5 = a4 + C0459f.m1675a(a.f1746q, bArr, a4);
            int b = a5 + C0459f.m1685b(bVar.f1701a, bArr, a5);
            int c9 = b + C0459f.m1689c(bVar.f1702b, bArr, b);
            if (bVar.f1701a > 0) {
                int a6 = c9 + C0459f.m1678a(bVar.f1705e, 0, bArr, c9, bVar.f1701a);
                return bArr;
            }
        }
        return bArr;
    }

    /* renamed from: b */
    public AbstractC0466e mo4161c(AbstractC0458e eVar, C0457d dVar, Object obj) {
        C0453m mVar = obj instanceof C0453m ? (C0453m) obj : null;
        if (mVar == null) {
            ActivityC0460a.m1698b(f1680a + "|syncIns is null");
            return null;
        }
        byte[] a = m2458a(mVar, 8);
        if (C0459f.m1692d(a, 0) != 1944742139) {
            return null;
        }
        C0644g gVar = new C0644g();
        gVar.f1731b = a[4] & 255;
        gVar.f1732c = a[5] & 255;
        gVar.mo4698a(a[6]);
        gVar.f1734e = a[7] & 255;
        if (gVar.f1732c == 7) {
            return m2456a(eVar, dVar, mVar, gVar);
        }
        if (gVar.f1732c == 1) {
            return m2460b(eVar, dVar, mVar, gVar);
        }
        ActivityC0460a.m1698b(f1680a + "|server socket resp version = " + gVar.f1732c + ", not support !!!");
        return null;
    }
}
