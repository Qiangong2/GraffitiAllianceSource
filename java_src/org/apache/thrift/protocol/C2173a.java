package org.apache.thrift.protocol;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.apache.thrift.C2164f;
import org.apache.thrift.transport.AbstractC2191d;

/* renamed from: org.apache.thrift.protocol.a */
public class C2173a extends AbstractC2180f {

    /* renamed from: f */
    private static final C2185k f6182f = new C2185k();

    /* renamed from: a */
    protected boolean f6183a = false;

    /* renamed from: b */
    protected boolean f6184b = true;

    /* renamed from: c */
    protected int f6185c;

    /* renamed from: d */
    protected boolean f6186d = false;

    /* renamed from: g */
    private byte[] f6187g = new byte[1];

    /* renamed from: h */
    private byte[] f6188h = new byte[2];

    /* renamed from: i */
    private byte[] f6189i = new byte[4];

    /* renamed from: j */
    private byte[] f6190j = new byte[8];

    /* renamed from: k */
    private byte[] f6191k = new byte[1];

    /* renamed from: l */
    private byte[] f6192l = new byte[2];

    /* renamed from: m */
    private byte[] f6193m = new byte[4];

    /* renamed from: n */
    private byte[] f6194n = new byte[8];

    /* renamed from: org.apache.thrift.protocol.a$a */
    public static class C2174a implements AbstractC2182h {

        /* renamed from: a */
        protected boolean f6195a;

        /* renamed from: b */
        protected boolean f6196b;

        /* renamed from: c */
        protected int f6197c;

        public C2174a() {
            this(false, true);
        }

        public C2174a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public C2174a(boolean z, boolean z2, int i) {
            this.f6195a = false;
            this.f6196b = true;
            this.f6195a = z;
            this.f6196b = z2;
            this.f6197c = i;
        }

        @Override // org.apache.thrift.protocol.AbstractC2182h
        /* renamed from: a */
        public AbstractC2180f mo12163a(AbstractC2191d dVar) {
            C2173a aVar = new C2173a(dVar, this.f6195a, this.f6196b);
            if (this.f6197c != 0) {
                aVar.mo12140c(this.f6197c);
            }
            return aVar;
        }
    }

    public C2173a(AbstractC2191d dVar, boolean z, boolean z2) {
        super(dVar);
        this.f6183a = z;
        this.f6184b = z2;
    }

    /* renamed from: a */
    private int m8204a(byte[] bArr, int i, int i2) {
        mo12142d(i2);
        return this.f6217e.mo12178d(bArr, i, i2);
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: a */
    public void mo12124a() {
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: a */
    public void mo12125a(byte b) {
        this.f6187g[0] = b;
        this.f6217e.mo12169b(this.f6187g, 0, 1);
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: a */
    public void mo12126a(int i) {
        this.f6189i[0] = (byte) ((i >> 24) & 255);
        this.f6189i[1] = (byte) ((i >> 16) & 255);
        this.f6189i[2] = (byte) ((i >> 8) & 255);
        this.f6189i[3] = (byte) (i & 255);
        this.f6217e.mo12169b(this.f6189i, 0, 4);
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: a */
    public void mo12127a(long j) {
        this.f6190j[0] = (byte) ((int) ((j >> 56) & 255));
        this.f6190j[1] = (byte) ((int) ((j >> 48) & 255));
        this.f6190j[2] = (byte) ((int) ((j >> 40) & 255));
        this.f6190j[3] = (byte) ((int) ((j >> 32) & 255));
        this.f6190j[4] = (byte) ((int) ((j >> 24) & 255));
        this.f6190j[5] = (byte) ((int) ((j >> 16) & 255));
        this.f6190j[6] = (byte) ((int) ((j >> 8) & 255));
        this.f6190j[7] = (byte) ((int) (255 & j));
        this.f6217e.mo12169b(this.f6190j, 0, 8);
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: a */
    public void mo12128a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            mo12126a(bytes.length);
            this.f6217e.mo12169b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new C2164f("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: a */
    public void mo12129a(ByteBuffer byteBuffer) {
        int limit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
        mo12126a(limit);
        this.f6217e.mo12169b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: a */
    public void mo12130a(C2177c cVar) {
        mo12125a(cVar.f6210b);
        mo12135a(cVar.f6211c);
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: a */
    public void mo12131a(C2178d dVar) {
        mo12125a(dVar.f6212a);
        mo12126a(dVar.f6213b);
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: a */
    public void mo12132a(C2179e eVar) {
        mo12125a(eVar.f6214a);
        mo12125a(eVar.f6215b);
        mo12126a(eVar.f6216c);
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: a */
    public void mo12133a(C2184j jVar) {
        mo12125a(jVar.f6220a);
        mo12126a(jVar.f6221b);
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: a */
    public void mo12134a(C2185k kVar) {
    }

    /* renamed from: a */
    public void mo12135a(short s) {
        this.f6188h[0] = (byte) ((s >> 8) & 255);
        this.f6188h[1] = (byte) (s & 255);
        this.f6217e.mo12169b(this.f6188h, 0, 2);
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: a */
    public void mo12136a(boolean z) {
        mo12125a(z ? (byte) 1 : 0);
    }

    /* renamed from: b */
    public String mo12137b(int i) {
        try {
            mo12142d(i);
            byte[] bArr = new byte[i];
            this.f6217e.mo12178d(bArr, 0, i);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new C2164f("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: b */
    public void mo12138b() {
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: c */
    public void mo12139c() {
        mo12125a((byte) 0);
    }

    /* renamed from: c */
    public void mo12140c(int i) {
        this.f6185c = i;
        this.f6186d = true;
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: d */
    public void mo12141d() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo12142d(int i) {
        if (i < 0) {
            throw new C2164f("Negative length: " + i);
        } else if (this.f6186d) {
            this.f6185c -= i;
            if (this.f6185c < 0) {
                throw new C2164f("Message length exceeded: " + i);
            }
        }
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: e */
    public void mo12143e() {
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: f */
    public void mo12144f() {
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: g */
    public C2185k mo12145g() {
        return f6182f;
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: h */
    public void mo12146h() {
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: i */
    public C2177c mo12147i() {
        byte r = mo12156r();
        return new C2177c("", r, r == 0 ? 0 : mo12157s());
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: j */
    public void mo12148j() {
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: k */
    public C2179e mo12149k() {
        return new C2179e(mo12156r(), mo12156r(), mo12158t());
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: l */
    public void mo12150l() {
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: m */
    public C2178d mo12151m() {
        return new C2178d(mo12156r(), mo12158t());
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: n */
    public void mo12152n() {
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: o */
    public C2184j mo12153o() {
        return new C2184j(mo12156r(), mo12158t());
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: p */
    public void mo12154p() {
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: q */
    public boolean mo12155q() {
        return mo12156r() == 1;
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: r */
    public byte mo12156r() {
        if (this.f6217e.mo12175c() >= 1) {
            byte b = this.f6217e.mo12173a()[this.f6217e.mo12174b()];
            this.f6217e.mo12171a(1);
            return b;
        }
        m8204a(this.f6191k, 0, 1);
        return this.f6191k[0];
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: s */
    public short mo12157s() {
        int i = 0;
        byte[] bArr = this.f6192l;
        if (this.f6217e.mo12175c() >= 2) {
            bArr = this.f6217e.mo12173a();
            i = this.f6217e.mo12174b();
            this.f6217e.mo12171a(2);
        } else {
            m8204a(this.f6192l, 0, 2);
        }
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: t */
    public int mo12158t() {
        int i = 0;
        byte[] bArr = this.f6193m;
        if (this.f6217e.mo12175c() >= 4) {
            bArr = this.f6217e.mo12173a();
            i = this.f6217e.mo12174b();
            this.f6217e.mo12171a(4);
        } else {
            m8204a(this.f6193m, 0, 4);
        }
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: u */
    public long mo12159u() {
        int i = 0;
        byte[] bArr = this.f6194n;
        if (this.f6217e.mo12175c() >= 8) {
            bArr = this.f6217e.mo12173a();
            i = this.f6217e.mo12174b();
            this.f6217e.mo12171a(8);
        } else {
            m8204a(this.f6194n, 0, 8);
        }
        return ((long) (bArr[i + 7] & 255)) | (((long) (bArr[i] & 255)) << 56) | (((long) (bArr[i + 1] & 255)) << 48) | (((long) (bArr[i + 2] & 255)) << 40) | (((long) (bArr[i + 3] & 255)) << 32) | (((long) (bArr[i + 4] & 255)) << 24) | (((long) (bArr[i + 5] & 255)) << 16) | (((long) (bArr[i + 6] & 255)) << 8);
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: v */
    public double mo12160v() {
        return Double.longBitsToDouble(mo12159u());
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: w */
    public String mo12161w() {
        int t = mo12158t();
        if (this.f6217e.mo12175c() < t) {
            return mo12137b(t);
        }
        try {
            String str = new String(this.f6217e.mo12173a(), this.f6217e.mo12174b(), t, "UTF-8");
            this.f6217e.mo12171a(t);
            return str;
        } catch (UnsupportedEncodingException e) {
            throw new C2164f("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: x */
    public ByteBuffer mo12162x() {
        int t = mo12158t();
        mo12142d(t);
        if (this.f6217e.mo12175c() >= t) {
            ByteBuffer wrap = ByteBuffer.wrap(this.f6217e.mo12173a(), this.f6217e.mo12174b(), t);
            this.f6217e.mo12171a(t);
            return wrap;
        }
        byte[] bArr = new byte[t];
        this.f6217e.mo12178d(bArr, 0, t);
        return ByteBuffer.wrap(bArr);
    }
}
