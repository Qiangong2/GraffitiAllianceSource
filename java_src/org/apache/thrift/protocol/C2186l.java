package org.apache.thrift.protocol;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.apache.thrift.C2164f;
import org.apache.thrift.protocol.C2173a;
import org.apache.thrift.transport.AbstractC2191d;

/* renamed from: org.apache.thrift.protocol.l */
public class C2186l extends C2173a {

    /* renamed from: f */
    private static int f6223f = 10000;

    /* renamed from: g */
    private static int f6224g = 10000;

    /* renamed from: h */
    private static int f6225h = 10000;

    /* renamed from: i */
    private static int f6226i = 10485760;

    /* renamed from: j */
    private static int f6227j = 104857600;

    /* renamed from: org.apache.thrift.protocol.l$a */
    public static class C2187a extends C2173a.C2174a {
        public C2187a() {
            super(false, true);
        }

        public C2187a(boolean z, boolean z2, int i) {
            super(z, z2, i);
        }

        @Override // org.apache.thrift.protocol.AbstractC2182h, org.apache.thrift.protocol.C2173a.C2174a
        /* renamed from: a */
        public AbstractC2180f mo12163a(AbstractC2191d dVar) {
            C2186l lVar = new C2186l(dVar, this.f6195a, this.f6196b);
            if (this.f6197c != 0) {
                lVar.mo12140c(this.f6197c);
            }
            return lVar;
        }
    }

    public C2186l(AbstractC2191d dVar, boolean z, boolean z2) {
        super(dVar, z, z2);
    }

    @Override // org.apache.thrift.protocol.C2173a, org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: k */
    public C2179e mo12149k() {
        byte r = mo12156r();
        byte r2 = mo12156r();
        int t = mo12158t();
        if (t <= f6223f) {
            return new C2179e(r, r2, t);
        }
        throw new C2181g(3, "Thrift map size " + t + " out of range!");
    }

    @Override // org.apache.thrift.protocol.C2173a, org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: m */
    public C2178d mo12151m() {
        byte r = mo12156r();
        int t = mo12158t();
        if (t <= f6224g) {
            return new C2178d(r, t);
        }
        throw new C2181g(3, "Thrift list size " + t + " out of range!");
    }

    @Override // org.apache.thrift.protocol.C2173a, org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: o */
    public C2184j mo12153o() {
        byte r = mo12156r();
        int t = mo12158t();
        if (t <= f6225h) {
            return new C2184j(r, t);
        }
        throw new C2181g(3, "Thrift set size " + t + " out of range!");
    }

    @Override // org.apache.thrift.protocol.C2173a, org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: w */
    public String mo12161w() {
        int t = mo12158t();
        if (t > f6226i) {
            throw new C2181g(3, "Thrift string size " + t + " out of range!");
        } else if (this.f6217e.mo12175c() < t) {
            return mo12137b(t);
        } else {
            try {
                String str = new String(this.f6217e.mo12173a(), this.f6217e.mo12174b(), t, "UTF-8");
                this.f6217e.mo12171a(t);
                return str;
            } catch (UnsupportedEncodingException e) {
                throw new C2164f("JVM DOES NOT SUPPORT UTF-8");
            }
        }
    }

    @Override // org.apache.thrift.protocol.C2173a, org.apache.thrift.protocol.AbstractC2180f
    /* renamed from: x */
    public ByteBuffer mo12162x() {
        int t = mo12158t();
        if (t > f6227j) {
            throw new C2181g(3, "Thrift binary size " + t + " out of range!");
        }
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
