package p000a.p001a.p002a.p004b;

import android.support.p007v4.media.TransportMediator;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import p000a.p001a.p002a.C0008b;
import p000a.p001a.p002a.C0046j;
import p000a.p001a.p002a.p006d.AbstractC0036c;

/* renamed from: a.a.a.b.b */
/* compiled from: TCompactProtocol */
public class C0011b extends AbstractC0019h {

    /* renamed from: d */
    private static final C0024m f34d = new C0024m("");

    /* renamed from: e */
    private static final C0014c f35e = new C0014c("", (byte) 0, 0);

    /* renamed from: f */
    private static final byte[] f36f = new byte[16];

    /* renamed from: h */
    private static final byte f37h = -126;

    /* renamed from: i */
    private static final byte f38i = 1;

    /* renamed from: j */
    private static final byte f39j = 31;

    /* renamed from: k */
    private static final byte f40k = -32;

    /* renamed from: l */
    private static final int f41l = 5;

    /* renamed from: a */
    byte[] f42a;

    /* renamed from: b */
    byte[] f43b;

    /* renamed from: c */
    byte[] f44c;

    /* renamed from: m */
    private C0008b f45m;

    /* renamed from: n */
    private short f46n;

    /* renamed from: o */
    private C0014c f47o;

    /* renamed from: p */
    private Boolean f48p;

    /* renamed from: q */
    private final long f49q;

    /* renamed from: r */
    private byte[] f50r;

    static {
        f36f[0] = 0;
        f36f[2] = 1;
        f36f[3] = 3;
        f36f[6] = 4;
        f36f[8] = 5;
        f36f[10] = 6;
        f36f[4] = 7;
        f36f[11] = 8;
        f36f[15] = 9;
        f36f[14] = 10;
        f36f[13] = 11;
        f36f[12] = 12;
    }

    /* renamed from: a.a.a.b.b$a */
    /* compiled from: TCompactProtocol */
    public static class C0012a implements AbstractC0021j {

        /* renamed from: a */
        private final long f51a;

        public C0012a() {
            this.f51a = -1;
        }

        public C0012a(int i) {
            this.f51a = (long) i;
        }

        @Override // p000a.p001a.p002a.p004b.AbstractC0021j
        /* renamed from: a */
        public AbstractC0019h mo55a(AbstractC0036c cVar) {
            return new C0011b(cVar, this.f51a);
        }
    }

    /* renamed from: a.a.a.b.b$b */
    /* compiled from: TCompactProtocol */
    private static class C0013b {

        /* renamed from: a */
        public static final byte f52a = 1;

        /* renamed from: b */
        public static final byte f53b = 2;

        /* renamed from: c */
        public static final byte f54c = 3;

        /* renamed from: d */
        public static final byte f55d = 4;

        /* renamed from: e */
        public static final byte f56e = 5;

        /* renamed from: f */
        public static final byte f57f = 6;

        /* renamed from: g */
        public static final byte f58g = 7;

        /* renamed from: h */
        public static final byte f59h = 8;

        /* renamed from: i */
        public static final byte f60i = 9;

        /* renamed from: j */
        public static final byte f61j = 10;

        /* renamed from: k */
        public static final byte f62k = 11;

        /* renamed from: l */
        public static final byte f63l = 12;

        private C0013b() {
        }
    }

    public C0011b(AbstractC0036c cVar, long j) {
        super(cVar);
        this.f45m = new C0008b(15);
        this.f46n = 0;
        this.f47o = null;
        this.f48p = null;
        this.f42a = new byte[5];
        this.f43b = new byte[10];
        this.f50r = new byte[1];
        this.f44c = new byte[1];
        this.f49q = j;
    }

    public C0011b(AbstractC0036c cVar) {
        this(cVar, -1);
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: B */
    public void mo56B() {
        this.f45m.mo9c();
        this.f46n = 0;
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: a */
    public void mo20a(C0017f fVar) throws C0046j {
        m80b(f37h);
        m88d(((fVar.f73b << 5) & -32) | 1);
        mo67b(fVar.f74c);
        mo23a(fVar.f72a);
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: a */
    public void mo22a(C0024m mVar) throws C0046j {
        this.f45m.mo7a(this.f46n);
        this.f46n = 0;
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: b */
    public void mo28b() throws C0046j {
        this.f46n = this.f45m.mo6a();
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: a */
    public void mo17a(C0014c cVar) throws C0046j {
        if (cVar.f65b == 2) {
            this.f47o = cVar;
        } else {
            m78a(cVar, (byte) -1);
        }
    }

    /* renamed from: a */
    private void m78a(C0014c cVar, byte b) throws C0046j {
        if (b == -1) {
            b = m89e(cVar.f65b);
        }
        if (cVar.f66c <= this.f46n || cVar.f66c - this.f46n > 15) {
            m80b(b);
            mo25a(cVar.f66c);
        } else {
            m88d(((cVar.f66c - this.f46n) << 4) | b);
        }
        this.f46n = cVar.f66c;
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: d */
    public void mo31d() throws C0046j {
        m80b((byte) 0);
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: a */
    public void mo19a(C0016e eVar) throws C0046j {
        if (eVar.f71c == 0) {
            m88d(0);
            return;
        }
        mo67b(eVar.f71c);
        m88d((m89e(eVar.f69a) << 4) | m89e(eVar.f70b));
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: a */
    public void mo18a(C0015d dVar) throws C0046j {
        mo57a(dVar.f67a, dVar.f68b);
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: a */
    public void mo21a(C0023l lVar) throws C0046j {
        mo57a(lVar.f89a, lVar.f90b);
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: a */
    public void mo26a(boolean z) throws C0046j {
        byte b = 1;
        if (this.f47o != null) {
            C0014c cVar = this.f47o;
            if (!z) {
                b = 2;
            }
            m78a(cVar, b);
            this.f47o = null;
            return;
        }
        if (!z) {
            b = 2;
        }
        m80b(b);
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: a */
    public void mo13a(byte b) throws C0046j {
        m80b(b);
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: a */
    public void mo25a(short s) throws C0046j {
        mo67b(m83c((int) s));
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: a */
    public void mo15a(int i) throws C0046j {
        mo67b(m83c(i));
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: a */
    public void mo16a(long j) throws C0046j {
        m82b(m84c(j));
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: a */
    public void mo14a(double d) throws C0046j {
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0};
        m77a(Double.doubleToLongBits(d), bArr, 0);
        this.f79g.mo91b(bArr);
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: a */
    public void mo23a(String str) throws C0046j {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            m79a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new C0046j("UTF-8 not supported!");
        }
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: a */
    public void mo24a(ByteBuffer byteBuffer) throws C0046j {
        m79a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    /* renamed from: a */
    private void m79a(byte[] bArr, int i, int i2) throws C0046j {
        mo67b(i2);
        this.f79g.mo81b(bArr, i, i2);
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: a */
    public void mo12a() throws C0046j {
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: e */
    public void mo33e() throws C0046j {
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: f */
    public void mo34f() throws C0046j {
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: g */
    public void mo35g() throws C0046j {
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: c */
    public void mo29c() throws C0046j {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo57a(byte b, int i) throws C0046j {
        if (i <= 14) {
            m88d((i << 4) | m89e(b));
            return;
        }
        m88d(m89e(b) | 240);
        mo67b(i);
    }

    /* renamed from: b */
    private void mo67b(int i) throws C0046j {
        int i2 = 0;
        while ((i & -128) != 0) {
            this.f42a[i2] = (byte) ((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            i >>>= 7;
            i2++;
        }
        this.f42a[i2] = (byte) i;
        this.f79g.mo81b(this.f42a, 0, i2 + 1);
    }

    /* renamed from: b */
    private void m82b(long j) throws C0046j {
        int i = 0;
        while ((-128 & j) != 0) {
            this.f43b[i] = (byte) ((int) ((127 & j) | 128));
            j >>>= 7;
            i++;
        }
        this.f43b[i] = (byte) ((int) j);
        this.f79g.mo81b(this.f43b, 0, i + 1);
    }

    /* renamed from: c */
    private long m84c(long j) {
        return (j << 1) ^ (j >> 63);
    }

    /* renamed from: c */
    private int m83c(int i) {
        return (i << 1) ^ (i >> 31);
    }

    /* renamed from: a */
    private void m77a(long j, byte[] bArr, int i) {
        bArr[i + 0] = (byte) ((int) (j & 255));
        bArr[i + 1] = (byte) ((int) ((j >> 8) & 255));
        bArr[i + 2] = (byte) ((int) ((j >> 16) & 255));
        bArr[i + 3] = (byte) ((int) ((j >> 24) & 255));
        bArr[i + 4] = (byte) ((int) ((j >> 32) & 255));
        bArr[i + 5] = (byte) ((int) ((j >> 40) & 255));
        bArr[i + 6] = (byte) ((int) ((j >> 48) & 255));
        bArr[i + 7] = (byte) ((int) ((j >> 56) & 255));
    }

    /* renamed from: b */
    private void m80b(byte b) throws C0046j {
        this.f50r[0] = b;
        this.f79g.mo91b(this.f50r);
    }

    /* renamed from: d */
    private void m88d(int i) throws C0046j {
        m80b((byte) i);
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: h */
    public C0017f mo36h() throws C0046j {
        byte u = mo49u();
        if (u != -126) {
            throw new C0020i("Expected protocol id " + Integer.toHexString(-126) + " but got " + Integer.toHexString(u));
        }
        byte u2 = mo49u();
        byte b = (byte) (u2 & f39j);
        if (b != 1) {
            throw new C0020i("Expected version 1 but got " + ((int) b));
        }
        int E = m74E();
        return new C0017f(mo54z(), (byte) ((u2 >> 5) & 3), E);
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: j */
    public C0024m mo38j() throws C0046j {
        this.f45m.mo7a(this.f46n);
        this.f46n = 0;
        return f34d;
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: k */
    public void mo39k() throws C0046j {
        this.f46n = this.f45m.mo6a();
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: l */
    public C0014c mo40l() throws C0046j {
        short s;
        byte u = mo49u();
        if (u == 0) {
            return f35e;
        }
        short s2 = (short) ((u & 240) >> 4);
        if (s2 == 0) {
            s = mo50v();
        } else {
            s = (short) (s2 + this.f46n);
        }
        C0014c cVar = new C0014c("", m86d((byte) (u & C0027o.f104m)), s);
        if (m85c(u)) {
            this.f48p = ((byte) (u & C0027o.f104m)) == 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.f46n = cVar.f66c;
        return cVar;
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: n */
    public C0016e mo42n() throws C0046j {
        int E = m74E();
        byte u = E == 0 ? 0 : mo49u();
        return new C0016e(m86d((byte) (u >> 4)), m86d((byte) (u & C0027o.f104m)), E);
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: p */
    public C0015d mo44p() throws C0046j {
        byte u = mo49u();
        int i = (u >> 4) & 15;
        if (i == 15) {
            i = m74E();
        }
        return new C0015d(m86d(u), i);
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: r */
    public C0023l mo46r() throws C0046j {
        return new C0023l(mo44p());
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: t */
    public boolean mo48t() throws C0046j {
        if (this.f48p != null) {
            boolean booleanValue = this.f48p.booleanValue();
            this.f48p = null;
            return booleanValue;
        } else if (mo49u() != 1) {
            return false;
        } else {
            return true;
        }
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: u */
    public byte mo49u() throws C0046j {
        if (this.f79g.mo90h() > 0) {
            byte b = this.f79g.mo88f()[this.f79g.mo89g()];
            this.f79g.mo84a(1);
            return b;
        }
        this.f79g.mo92d(this.f44c, 0, 1);
        return this.f44c[0];
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: v */
    public short mo50v() throws C0046j {
        return (short) m92g(m74E());
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: w */
    public int mo51w() throws C0046j {
        return m92g(m74E());
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: x */
    public long mo52x() throws C0046j {
        return m87d(m75F());
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: y */
    public double mo53y() throws C0046j {
        byte[] bArr = new byte[8];
        this.f79g.mo92d(bArr, 0, 8);
        return Double.longBitsToDouble(m76a(bArr));
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: z */
    public String mo54z() throws C0046j {
        int E = m74E();
        m91f(E);
        if (E == 0) {
            return "";
        }
        try {
            if (this.f79g.mo90h() < E) {
                return new String(m90e(E), "UTF-8");
            }
            String str = new String(this.f79g.mo88f(), this.f79g.mo89g(), E, "UTF-8");
            this.f79g.mo84a(E);
            return str;
        } catch (UnsupportedEncodingException e) {
            throw new C0046j("UTF-8 not supported!");
        }
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: A */
    public ByteBuffer mo11A() throws C0046j {
        int E = m74E();
        m91f(E);
        if (E == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[E];
        this.f79g.mo92d(bArr, 0, E);
        return ByteBuffer.wrap(bArr);
    }

    /* renamed from: e */
    private byte[] m90e(int i) throws C0046j {
        if (i == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i];
        this.f79g.mo92d(bArr, 0, i);
        return bArr;
    }

    /* renamed from: f */
    private void m91f(int i) throws C0020i {
        if (i < 0) {
            throw new C0020i("Negative length: " + i);
        } else if (this.f49q != -1 && ((long) i) > this.f49q) {
            throw new C0020i("Length exceeded max allowed: " + i);
        }
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: i */
    public void mo37i() throws C0046j {
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: m */
    public void mo41m() throws C0046j {
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: o */
    public void mo43o() throws C0046j {
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: q */
    public void mo45q() throws C0046j {
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: s */
    public void mo47s() throws C0046j {
    }

    /* renamed from: E */
    private int m74E() throws C0046j {
        int i = 0;
        if (this.f79g.mo90h() >= 5) {
            byte[] f = this.f79g.mo88f();
            int g = this.f79g.mo89g();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                byte b = f[g + i];
                i3 |= (b & Byte.MAX_VALUE) << i2;
                if ((b & 128) != 128) {
                    this.f79g.mo84a(i + 1);
                    return i3;
                }
                i2 += 7;
                i++;
            }
        } else {
            int i4 = 0;
            while (true) {
                byte u = mo49u();
                i4 |= (u & Byte.MAX_VALUE) << i;
                if ((u & 128) != 128) {
                    return i4;
                }
                i += 7;
            }
        }
    }

    /* renamed from: F */
    private long m75F() throws C0046j {
        int i = 0;
        long j = 0;
        if (this.f79g.mo90h() >= 10) {
            byte[] f = this.f79g.mo88f();
            int g = this.f79g.mo89g();
            int i2 = 0;
            while (true) {
                byte b = f[g + i];
                j |= ((long) (b & Byte.MAX_VALUE)) << i2;
                if ((b & 128) != 128) {
                    break;
                }
                i2 += 7;
                i++;
            }
            this.f79g.mo84a(i + 1);
        } else {
            while (true) {
                byte u = mo49u();
                j |= ((long) (u & Byte.MAX_VALUE)) << i;
                if ((u & 128) != 128) {
                    break;
                }
                i += 7;
            }
        }
        return j;
    }

    /* renamed from: g */
    private int m92g(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    /* renamed from: d */
    private long m87d(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    /* renamed from: a */
    private long m76a(byte[] bArr) {
        return ((((long) bArr[7]) & 255) << 56) | ((((long) bArr[6]) & 255) << 48) | ((((long) bArr[5]) & 255) << 40) | ((((long) bArr[4]) & 255) << 32) | ((((long) bArr[3]) & 255) << 24) | ((((long) bArr[2]) & 255) << 16) | ((((long) bArr[1]) & 255) << 8) | (((long) bArr[0]) & 255);
    }

    /* renamed from: c */
    private boolean m85c(byte b) {
        int i = b & C0027o.f104m;
        if (i == 1 || i == 2) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    private byte m86d(byte b) throws C0020i {
        switch ((byte) (b & C0027o.f104m)) {
            case 0:
                return 0;
            case 1:
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 6;
            case 5:
                return 8;
            case 6:
                return 10;
            case 7:
                return 4;
            case 8:
                return 11;
            case 9:
                return C0027o.f104m;
            case 10:
                return 14;
            case 11:
                return 13;
            case 12:
                return 12;
            default:
                throw new C0020i("don't know what type: " + ((int) ((byte) (b & C0027o.f104m))));
        }
    }

    /* renamed from: e */
    private byte m89e(byte b) {
        return f36f[b];
    }
}
