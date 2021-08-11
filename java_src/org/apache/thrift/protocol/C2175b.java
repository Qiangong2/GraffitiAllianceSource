package org.apache.thrift.protocol;

import android.support.p007v4.media.TransportMediator;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.apache.thrift.C2157a;
import org.apache.thrift.C2164f;
import org.apache.thrift.transport.AbstractC2191d;
import p000a.p001a.p002a.p004b.C0027o;

/* renamed from: org.apache.thrift.protocol.b */
public final class C2175b extends AbstractC2180f {

    /* renamed from: d */
    private static final C2185k f6198d = new C2185k("");

    /* renamed from: f */
    private static final C2177c f6199f = new C2177c("", (byte) 0, 0);

    /* renamed from: g */
    private static final byte[] f6200g = new byte[16];

    /* renamed from: a */
    byte[] f6201a = new byte[5];

    /* renamed from: b */
    byte[] f6202b = new byte[10];

    /* renamed from: c */
    byte[] f6203c = new byte[1];

    /* renamed from: h */
    private C2157a f6204h = new C2157a(15);

    /* renamed from: i */
    private short f6205i = 0;

    /* renamed from: j */
    private C2177c f6206j = null;

    /* renamed from: k */
    private Boolean f6207k = null;

    /* renamed from: l */
    private byte[] f6208l = new byte[1];

    /* renamed from: org.apache.thrift.protocol.b$a */
    public static class C2176a implements AbstractC2182h {
        @Override // org.apache.thrift.protocol.AbstractC2182h
        /* renamed from: a */
        public AbstractC2180f mo12163a(AbstractC2191d dVar) {
            return new C2175b(dVar);
        }
    }

    static {
        f6200g[0] = 0;
        f6200g[2] = 1;
        f6200g[3] = 3;
        f6200g[6] = 4;
        f6200g[8] = 5;
        f6200g[10] = 6;
        f6200g[4] = 7;
        f6200g[11] = 8;
        f6200g[15] = 9;
        f6200g[14] = 10;
        f6200g[13] = 11;
        f6200g[12] = 12;
    }

    public C2175b(AbstractC2191d dVar) {
        super(dVar);
    }

    /* renamed from: A */
    private long m8245A() {
        int i = 0;
        long j = 0;
        if (this.f6217e.mo12175c() >= 10) {
            byte[] a = this.f6217e.mo12173a();
            int b = this.f6217e.mo12174b();
            int i2 = 0;
            while (true) {
                byte b2 = a[b + i];
                j |= ((long) (b2 & Byte.MAX_VALUE)) << i2;
                if ((b2 & 128) != 128) {
                    break;
                }
                i2 += 7;
                i++;
            }
            this.f6217e.mo12171a(i + 1);
        } else {
            while (true) {
                byte r = mo12156r();
                j |= ((long) (r & Byte.MAX_VALUE)) << i;
                if ((r & 128) != 128) {
                    break;
                }
                i += 7;
            }
        }
        return j;
    }

    /* renamed from: a */
    private long m8246a(byte[] bArr) {
        return ((((long) bArr[7]) & 255) << 56) | ((((long) bArr[6]) & 255) << 48) | ((((long) bArr[5]) & 255) << 40) | ((((long) bArr[4]) & 255) << 32) | ((((long) bArr[3]) & 255) << 24) | ((((long) bArr[2]) & 255) << 16) | ((((long) bArr[1]) & 255) << 8) | (((long) bArr[0]) & 255);
    }

    /* renamed from: a */
    private void m8247a(C2177c cVar, byte b) {
        if (b == -1) {
            b = m8258e(cVar.f6210b);
        }
        if (cVar.f6211c <= this.f6205i || cVar.f6211c - this.f6205i > 15) {
            m8249b(b);
            mo12165a(cVar.f6211c);
        } else {
            m8257d(((cVar.f6211c - this.f6205i) << 4) | b);
        }
        this.f6205i = cVar.f6211c;
    }

    /* renamed from: a */
    private void m8248a(byte[] bArr, int i, int i2) {
        m8250b(i2);
        this.f6217e.mo12169b(bArr, i, i2);
    }

    /* renamed from: b */
    private void m8249b(byte b) {
        this.f6208l[0] = b;
        this.f6217e.mo12177b(this.f6208l);
    }

    /* renamed from: b */
    private void m8250b(int i) {
        int i2 = 0;
        while ((i & -128) != 0) {
            this.f6201a[i2] = (byte) ((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            i >>>= 7;
            i2++;
        }
        this.f6201a[i2] = (byte) i;
        this.f6217e.mo12169b(this.f6201a, 0, i2 + 1);
    }

    /* renamed from: b */
    private void m8251b(long j) {
        int i = 0;
        while ((-128 & j) != 0) {
            this.f6202b[i] = (byte) ((int) ((127 & j) | 128));
            j >>>= 7;
            i++;
        }
        this.f6202b[i] = (byte) ((int) j);
        this.f6217e.mo12169b(this.f6202b, 0, i + 1);
    }

    /* renamed from: c */
    private int m8252c(int i) {
        return (i << 1) ^ (i >> 31);
    }

    /* renamed from: c */
    private long m8253c(long j) {
        return (j << 1) ^ (j >> 63);
    }

    /* renamed from: c */
    private boolean m8254c(byte b) {
        int i = b & C0027o.f104m;
        return i == 1 || i == 2;
    }

    /* renamed from: d */
    private byte m8255d(byte b) {
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
                throw new C2181g("don't know what type: " + ((int) ((byte) (b & C0027o.f104m))));
        }
    }

    /* renamed from: d */
    private long m8256d(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    /* renamed from: d */
    private void m8257d(int i) {
        m8249b((byte) i);
    }

    /* renamed from: e */
    private byte m8258e(byte b) {
        return f6200g[b];
    }

    /* renamed from: e */
    private byte[] m8259e(int i) {
        if (i == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i];
        this.f6217e.mo12178d(bArr, 0, i);
        return bArr;
    }

    /* renamed from: f */
    private int m8260f(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    /* renamed from: z */
    private int m8261z() {
        int i = 0;
        if (this.f6217e.mo12175c() >= 5) {
            byte[] a = this.f6217e.mo12173a();
            int b = this.f6217e.mo12174b();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                byte b2 = a[b + i];
                i3 |= (b2 & Byte.MAX_VALUE) << i2;
                if ((b2 & 128) != 128) {
                    this.f6217e.mo12171a(i + 1);
                    return i3;
                }
                i2 += 7;
                i++;
            }
        } else {
            int i4 = 0;
            while (true) {
                byte r = mo12156r();
                i4 |= (r & Byte.MAX_VALUE) << i;
                if ((r & 128) != 128) {
                    return i4;
                }
                i += 7;
            }
        }
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: a */
    public void mo12124a() {
        this.f6205i = this.f6204h.mo12115a();
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: a */
    public void mo12125a(byte b) {
        m8249b(b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo12164a(byte b, int i) {
        if (i <= 14) {
            m8257d((i << 4) | m8258e(b));
            return;
        }
        m8257d(m8258e(b) | 240);
        m8250b(i);
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: a */
    public void mo12126a(int i) {
        m8250b(m8252c(i));
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: a */
    public void mo12127a(long j) {
        m8251b(m8253c(j));
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: a */
    public void mo12128a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            m8248a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new C2164f("UTF-8 not supported!");
        }
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: a */
    public void mo12129a(ByteBuffer byteBuffer) {
        m8248a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset());
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: a */
    public void mo12130a(C2177c cVar) {
        if (cVar.f6210b == 2) {
            this.f6206j = cVar;
        } else {
            m8247a(cVar, (byte) -1);
        }
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: a */
    public void mo12131a(C2178d dVar) {
        mo12164a(dVar.f6212a, dVar.f6213b);
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: a */
    public void mo12132a(C2179e eVar) {
        if (eVar.f6216c == 0) {
            m8257d(0);
            return;
        }
        m8250b(eVar.f6216c);
        m8257d((m8258e(eVar.f6214a) << 4) | m8258e(eVar.f6215b));
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: a */
    public void mo12133a(C2184j jVar) {
        mo12164a(jVar.f6220a, jVar.f6221b);
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: a */
    public void mo12134a(C2185k kVar) {
        this.f6204h.mo12116a(this.f6205i);
        this.f6205i = 0;
    }

    /* renamed from: a */
    public void mo12165a(short s) {
        m8250b(m8252c((int) s));
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: a */
    public void mo12136a(boolean z) {
        byte b = 1;
        if (this.f6206j != null) {
            C2177c cVar = this.f6206j;
            if (!z) {
                b = 2;
            }
            m8247a(cVar, b);
            this.f6206j = null;
            return;
        }
        if (!z) {
            b = 2;
        }
        m8249b(b);
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: b */
    public void mo12138b() {
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: c */
    public void mo12139c() {
        m8249b((byte) 0);
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: d */
    public void mo12141d() {
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
        this.f6204h.mo12116a(this.f6205i);
        this.f6205i = 0;
        return f6198d;
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: h */
    public void mo12146h() {
        this.f6205i = this.f6204h.mo12115a();
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: i */
    public C2177c mo12147i() {
        byte r = mo12156r();
        if (r == 0) {
            return f6199f;
        }
        short s = (short) ((r & 240) >> 4);
        C2177c cVar = new C2177c("", m8255d((byte) (r & C0027o.f104m)), s == 0 ? mo12157s() : (short) (s + this.f6205i));
        if (m8254c(r)) {
            this.f6207k = ((byte) (r & C0027o.f104m)) == 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.f6205i = cVar.f6211c;
        return cVar;
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: j */
    public void mo12148j() {
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: k */
    public C2179e mo12149k() {
        int z = m8261z();
        byte r = z == 0 ? 0 : mo12156r();
        return new C2179e(m8255d((byte) (r >> 4)), m8255d((byte) (r & C0027o.f104m)), z);
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: l */
    public void mo12150l() {
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: m */
    public C2178d mo12151m() {
        byte r = mo12156r();
        int i = (r >> 4) & 15;
        if (i == 15) {
            i = m8261z();
        }
        return new C2178d(m8255d(r), i);
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: n */
    public void mo12152n() {
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: o */
    public C2184j mo12153o() {
        return new C2184j(mo12151m());
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: p */
    public void mo12154p() {
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: q */
    public boolean mo12155q() {
        if (this.f6207k == null) {
            return mo12156r() == 1;
        }
        boolean booleanValue = this.f6207k.booleanValue();
        this.f6207k = null;
        return booleanValue;
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: r */
    public byte mo12156r() {
        if (this.f6217e.mo12175c() > 0) {
            byte b = this.f6217e.mo12173a()[this.f6217e.mo12174b()];
            this.f6217e.mo12171a(1);
            return b;
        }
        this.f6217e.mo12178d(this.f6203c, 0, 1);
        return this.f6203c[0];
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: s */
    public short mo12157s() {
        return (short) m8260f(m8261z());
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: t */
    public int mo12158t() {
        return m8260f(m8261z());
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: u */
    public long mo12159u() {
        return m8256d(m8245A());
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: v */
    public double mo12160v() {
        byte[] bArr = new byte[8];
        this.f6217e.mo12178d(bArr, 0, 8);
        return Double.longBitsToDouble(m8246a(bArr));
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: w */
    public String mo12161w() {
        int z = m8261z();
        if (z == 0) {
            return "";
        }
        try {
            if (this.f6217e.mo12175c() < z) {
                return new String(m8259e(z), "UTF-8");
            }
            String str = new String(this.f6217e.mo12173a(), this.f6217e.mo12174b(), z, "UTF-8");
            this.f6217e.mo12171a(z);
            return str;
        } catch (UnsupportedEncodingException e) {
            throw new C2164f("UTF-8 not supported!");
        }
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: x */
    public ByteBuffer mo12162x() {
        int z = m8261z();
        if (z == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[z];
        this.f6217e.mo12178d(bArr, 0, z);
        return ByteBuffer.wrap(bArr);
    }

    @Override // org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: y */
    public void mo12166y() {
        this.f6204h.mo12117b();
        this.f6205i = 0;
    }
}
