package p000a.p001a.p002a.p004b;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import p000a.p001a.p002a.C0046j;
import p000a.p001a.p002a.p006d.AbstractC0036c;

/* renamed from: a.a.a.b.a */
/* compiled from: TBinaryProtocol */
public class C0009a extends AbstractC0019h {

    /* renamed from: a */
    protected static final int f16a = -65536;

    /* renamed from: b */
    protected static final int f17b = -2147418112;

    /* renamed from: h */
    private static final C0024m f18h = new C0024m();

    /* renamed from: c */
    protected boolean f19c;

    /* renamed from: d */
    protected boolean f20d;

    /* renamed from: e */
    protected int f21e;

    /* renamed from: f */
    protected boolean f22f;

    /* renamed from: i */
    private byte[] f23i;

    /* renamed from: j */
    private byte[] f24j;

    /* renamed from: k */
    private byte[] f25k;

    /* renamed from: l */
    private byte[] f26l;

    /* renamed from: m */
    private byte[] f27m;

    /* renamed from: n */
    private byte[] f28n;

    /* renamed from: o */
    private byte[] f29o;

    /* renamed from: p */
    private byte[] f30p;

    /* renamed from: a.a.a.b.a$a */
    /* compiled from: TBinaryProtocol */
    public static class C0010a implements AbstractC0021j {

        /* renamed from: a */
        protected boolean f31a;

        /* renamed from: b */
        protected boolean f32b;

        /* renamed from: c */
        protected int f33c;

        public C0010a() {
            this(false, true);
        }

        public C0010a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public C0010a(boolean z, boolean z2, int i) {
            this.f31a = false;
            this.f32b = true;
            this.f31a = z;
            this.f32b = z2;
            this.f33c = i;
        }

        @Override // p000a.p001a.p002a.p004b.AbstractC0021j
        /* renamed from: a */
        public AbstractC0019h mo55a(AbstractC0036c cVar) {
            C0009a aVar = new C0009a(cVar, this.f31a, this.f32b);
            if (this.f33c != 0) {
                aVar.mo30c(this.f33c);
            }
            return aVar;
        }
    }

    public C0009a(AbstractC0036c cVar) {
        this(cVar, false, true);
    }

    public C0009a(AbstractC0036c cVar, boolean z, boolean z2) {
        super(cVar);
        this.f19c = false;
        this.f20d = true;
        this.f22f = false;
        this.f23i = new byte[1];
        this.f24j = new byte[2];
        this.f25k = new byte[4];
        this.f26l = new byte[8];
        this.f27m = new byte[1];
        this.f28n = new byte[2];
        this.f29o = new byte[4];
        this.f30p = new byte[8];
        this.f19c = z;
        this.f20d = z2;
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: a */
    public void mo20a(C0017f fVar) throws C0046j {
        if (this.f20d) {
            mo15a(f17b | fVar.f73b);
            mo23a(fVar.f72a);
            mo15a(fVar.f74c);
            return;
        }
        mo23a(fVar.f72a);
        mo13a(fVar.f73b);
        mo15a(fVar.f74c);
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: a */
    public void mo12a() {
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: a */
    public void mo22a(C0024m mVar) {
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: b */
    public void mo28b() {
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: a */
    public void mo17a(C0014c cVar) throws C0046j {
        mo13a(cVar.f65b);
        mo25a(cVar.f66c);
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: c */
    public void mo29c() {
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: d */
    public void mo31d() throws C0046j {
        mo13a((byte) 0);
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: a */
    public void mo19a(C0016e eVar) throws C0046j {
        mo13a(eVar.f69a);
        mo13a(eVar.f70b);
        mo15a(eVar.f71c);
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: e */
    public void mo33e() {
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: a */
    public void mo18a(C0015d dVar) throws C0046j {
        mo13a(dVar.f67a);
        mo15a(dVar.f68b);
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: f */
    public void mo34f() {
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: a */
    public void mo21a(C0023l lVar) throws C0046j {
        mo13a(lVar.f89a);
        mo15a(lVar.f90b);
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: g */
    public void mo35g() {
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: a */
    public void mo26a(boolean z) throws C0046j {
        mo13a(z ? (byte) 1 : 0);
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: a */
    public void mo13a(byte b) throws C0046j {
        this.f23i[0] = b;
        this.f79g.mo81b(this.f23i, 0, 1);
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: a */
    public void mo25a(short s) throws C0046j {
        this.f24j[0] = (byte) ((s >> 8) & 255);
        this.f24j[1] = (byte) (s & 255);
        this.f79g.mo81b(this.f24j, 0, 2);
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: a */
    public void mo15a(int i) throws C0046j {
        this.f25k[0] = (byte) ((i >> 24) & 255);
        this.f25k[1] = (byte) ((i >> 16) & 255);
        this.f25k[2] = (byte) ((i >> 8) & 255);
        this.f25k[3] = (byte) (i & 255);
        this.f79g.mo81b(this.f25k, 0, 4);
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: a */
    public void mo16a(long j) throws C0046j {
        this.f26l[0] = (byte) ((int) ((j >> 56) & 255));
        this.f26l[1] = (byte) ((int) ((j >> 48) & 255));
        this.f26l[2] = (byte) ((int) ((j >> 40) & 255));
        this.f26l[3] = (byte) ((int) ((j >> 32) & 255));
        this.f26l[4] = (byte) ((int) ((j >> 24) & 255));
        this.f26l[5] = (byte) ((int) ((j >> 16) & 255));
        this.f26l[6] = (byte) ((int) ((j >> 8) & 255));
        this.f26l[7] = (byte) ((int) (255 & j));
        this.f79g.mo81b(this.f26l, 0, 8);
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: a */
    public void mo14a(double d) throws C0046j {
        mo16a(Double.doubleToLongBits(d));
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: a */
    public void mo23a(String str) throws C0046j {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            mo15a(bytes.length);
            this.f79g.mo81b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new C0046j("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: a */
    public void mo24a(ByteBuffer byteBuffer) throws C0046j {
        int limit = byteBuffer.limit() - byteBuffer.position();
        mo15a(limit);
        this.f79g.mo81b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: h */
    public C0017f mo36h() throws C0046j {
        int w = mo51w();
        if (w < 0) {
            if ((-65536 & w) == f17b) {
                return new C0017f(mo54z(), (byte) (w & 255), mo51w());
            }
            throw new C0020i(4, "Bad version in readMessageBegin");
        } else if (!this.f19c) {
            return new C0017f(mo27b(w), mo49u(), mo51w());
        } else {
            throw new C0020i(4, "Missing version in readMessageBegin, old client?");
        }
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: i */
    public void mo37i() {
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: j */
    public C0024m mo38j() {
        return f18h;
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: k */
    public void mo39k() {
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: l */
    public C0014c mo40l() throws C0046j {
        byte u = mo49u();
        return new C0014c("", u, u == 0 ? 0 : mo50v());
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: m */
    public void mo41m() {
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: n */
    public C0016e mo42n() throws C0046j {
        return new C0016e(mo49u(), mo49u(), mo51w());
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: o */
    public void mo43o() {
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: p */
    public C0015d mo44p() throws C0046j {
        return new C0015d(mo49u(), mo51w());
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: q */
    public void mo45q() {
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: r */
    public C0023l mo46r() throws C0046j {
        return new C0023l(mo49u(), mo51w());
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: s */
    public void mo47s() {
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: t */
    public boolean mo48t() throws C0046j {
        return mo49u() == 1;
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: u */
    public byte mo49u() throws C0046j {
        if (this.f79g.mo90h() >= 1) {
            byte b = this.f79g.mo88f()[this.f79g.mo89g()];
            this.f79g.mo84a(1);
            return b;
        }
        m28a(this.f27m, 0, 1);
        return this.f27m[0];
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: v */
    public short mo50v() throws C0046j {
        int i = 0;
        byte[] bArr = this.f28n;
        if (this.f79g.mo90h() >= 2) {
            bArr = this.f79g.mo88f();
            i = this.f79g.mo89g();
            this.f79g.mo84a(2);
        } else {
            m28a(this.f28n, 0, 2);
        }
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: w */
    public int mo51w() throws C0046j {
        int i = 0;
        byte[] bArr = this.f29o;
        if (this.f79g.mo90h() >= 4) {
            bArr = this.f79g.mo88f();
            i = this.f79g.mo89g();
            this.f79g.mo84a(4);
        } else {
            m28a(this.f29o, 0, 4);
        }
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: x */
    public long mo52x() throws C0046j {
        int i = 0;
        byte[] bArr = this.f30p;
        if (this.f79g.mo90h() >= 8) {
            bArr = this.f79g.mo88f();
            i = this.f79g.mo89g();
            this.f79g.mo84a(8);
        } else {
            m28a(this.f30p, 0, 8);
        }
        return ((long) (bArr[i + 7] & 255)) | (((long) (bArr[i] & 255)) << 56) | (((long) (bArr[i + 1] & 255)) << 48) | (((long) (bArr[i + 2] & 255)) << 40) | (((long) (bArr[i + 3] & 255)) << 32) | (((long) (bArr[i + 4] & 255)) << 24) | (((long) (bArr[i + 5] & 255)) << 16) | (((long) (bArr[i + 6] & 255)) << 8);
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: y */
    public double mo53y() throws C0046j {
        return Double.longBitsToDouble(mo52x());
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: z */
    public String mo54z() throws C0046j {
        int w = mo51w();
        if (this.f79g.mo90h() < w) {
            return mo27b(w);
        }
        try {
            String str = new String(this.f79g.mo88f(), this.f79g.mo89g(), w, "UTF-8");
            this.f79g.mo84a(w);
            return str;
        } catch (UnsupportedEncodingException e) {
            throw new C0046j("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    /* renamed from: b */
    public String mo27b(int i) throws C0046j {
        try {
            mo32d(i);
            byte[] bArr = new byte[i];
            this.f79g.mo92d(bArr, 0, i);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new C0046j("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // p000a.p001a.p002a.p004b.AbstractC0019h
    /* renamed from: A */
    public ByteBuffer mo11A() throws C0046j {
        int w = mo51w();
        mo32d(w);
        if (this.f79g.mo90h() >= w) {
            ByteBuffer wrap = ByteBuffer.wrap(this.f79g.mo88f(), this.f79g.mo89g(), w);
            this.f79g.mo84a(w);
            return wrap;
        }
        byte[] bArr = new byte[w];
        this.f79g.mo92d(bArr, 0, w);
        return ByteBuffer.wrap(bArr);
    }

    /* renamed from: a */
    private int m28a(byte[] bArr, int i, int i2) throws C0046j {
        mo32d(i2);
        return this.f79g.mo92d(bArr, i, i2);
    }

    /* renamed from: c */
    public void mo30c(int i) {
        this.f21e = i;
        this.f22f = true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo32d(int i) throws C0046j {
        if (i < 0) {
            throw new C0020i("Negative length: " + i);
        } else if (this.f22f) {
            this.f21e -= i;
            if (this.f21e < 0) {
                throw new C0020i("Message length exceeded: " + i);
            }
        }
    }
}
