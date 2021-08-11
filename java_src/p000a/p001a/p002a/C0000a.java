package p000a.p001a.p002a;

/* renamed from: a.a.a.a */
/* compiled from: EncodingUtils */
public class C0000a {
    /* renamed from: a */
    public static final void m6a(int i, byte[] bArr) {
        m7a(i, bArr, 0);
    }

    /* renamed from: a */
    public static final void m7a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) ((i >> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
    }

    /* renamed from: a */
    public static final int m2a(byte[] bArr) {
        return m3a(bArr, 0);
    }

    /* renamed from: a */
    public static final int m3a(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8) | (bArr[i + 3] & 255);
    }

    /* renamed from: a */
    public static final boolean m8a(byte b, int i) {
        return m9a((int) b, i);
    }

    /* renamed from: a */
    public static final boolean m11a(short s, int i) {
        return m9a((int) s, i);
    }

    /* renamed from: a */
    public static final boolean m9a(int i, int i2) {
        return ((1 << i2) & i) != 0;
    }

    /* renamed from: a */
    public static final boolean m10a(long j, int i) {
        return ((1 << i) & j) != 0;
    }

    /* renamed from: b */
    public static final byte m12b(byte b, int i) {
        return (byte) m13b((int) b, i);
    }

    /* renamed from: b */
    public static final short m15b(short s, int i) {
        return (short) m13b((int) s, i);
    }

    /* renamed from: b */
    public static final int m13b(int i, int i2) {
        return ((1 << i2) ^ -1) & i;
    }

    /* renamed from: b */
    public static final long m14b(long j, int i) {
        return ((1 << i) ^ -1) & j;
    }

    /* renamed from: a */
    public static final byte m0a(byte b, int i, boolean z) {
        return (byte) m1a((int) b, i, z);
    }

    /* renamed from: a */
    public static final short m5a(short s, int i, boolean z) {
        return (short) m1a((int) s, i, z);
    }

    /* renamed from: a */
    public static final int m1a(int i, int i2, boolean z) {
        if (z) {
            return (1 << i2) | i;
        }
        return m13b(i, i2);
    }

    /* renamed from: a */
    public static final long m4a(long j, int i, boolean z) {
        if (z) {
            return (1 << i) | j;
        }
        return m14b(j, i);
    }
}
