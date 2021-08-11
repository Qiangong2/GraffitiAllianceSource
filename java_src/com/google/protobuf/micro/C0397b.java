package com.google.protobuf.micro;

import android.support.p007v4.media.TransportMediator;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* renamed from: com.google.protobuf.micro.b */
public final class C0397b {

    /* renamed from: a */
    private final byte[] f975a;

    /* renamed from: b */
    private final int f976b;

    /* renamed from: c */
    private int f977c;

    /* renamed from: d */
    private final OutputStream f978d;

    /* renamed from: com.google.protobuf.micro.b$a */
    public static class C0398a extends IOException {
        C0398a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private C0397b(OutputStream outputStream, byte[] bArr) {
        this.f978d = outputStream;
        this.f975a = bArr;
        this.f977c = 0;
        this.f976b = bArr.length;
    }

    private C0397b(byte[] bArr, int i, int i2) {
        this.f978d = null;
        this.f975a = bArr;
        this.f977c = i;
        this.f976b = i + i2;
    }

    /* renamed from: a */
    public static C0397b m1453a(OutputStream outputStream) {
        return m1454a(outputStream, 4096);
    }

    /* renamed from: a */
    public static C0397b m1454a(OutputStream outputStream, int i) {
        return new C0397b(outputStream, new byte[i]);
    }

    /* renamed from: a */
    public static C0397b m1455a(byte[] bArr, int i, int i2) {
        return new C0397b(bArr, i, i2);
    }

    /* renamed from: b */
    public static int m1456b(int i, boolean z) {
        return m1464f(i) + m1458b(z);
    }

    /* renamed from: b */
    public static int m1457b(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return bytes.length + m1465h(bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    /* renamed from: b */
    public static int m1458b(boolean z) {
        return 1;
    }

    /* renamed from: c */
    public static int m1459c(int i) {
        if (i >= 0) {
            return m1465h(i);
        }
        return 10;
    }

    /* renamed from: c */
    public static int m1460c(int i, int i2) {
        return m1464f(i) + m1459c(i2);
    }

    /* renamed from: d */
    public static int m1461d(int i) {
        return m1465h(i);
    }

    /* renamed from: d */
    public static int m1462d(int i, int i2) {
        return m1464f(i) + m1461d(i2);
    }

    /* renamed from: d */
    private void m1463d() {
        if (this.f978d == null) {
            throw new C0398a();
        }
        this.f978d.write(this.f975a, 0, this.f977c);
        this.f977c = 0;
    }

    /* renamed from: f */
    public static int m1464f(int i) {
        return m1465h(C0401e.m1500a(i, 0));
    }

    /* renamed from: h */
    public static int m1465h(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (-268435456 & i) == 0 ? 4 : 5;
    }

    /* renamed from: a */
    public void mo4036a() {
        if (this.f978d != null) {
            m1463d();
        }
    }

    /* renamed from: a */
    public void mo4037a(byte b) {
        if (this.f977c == this.f976b) {
            m1463d();
        }
        byte[] bArr = this.f975a;
        int i = this.f977c;
        this.f977c = i + 1;
        bArr[i] = b;
    }

    /* renamed from: a */
    public void mo4038a(int i) {
        if (i >= 0) {
            mo4053g(i);
        } else {
            mo4042a((long) i);
        }
    }

    /* renamed from: a */
    public void mo4039a(int i, int i2) {
        mo4052e(i, 0);
        mo4038a(i2);
    }

    /* renamed from: a */
    public void mo4040a(int i, String str) {
        mo4052e(i, 2);
        mo4043a(str);
    }

    /* renamed from: a */
    public void mo4041a(int i, boolean z) {
        mo4052e(i, 0);
        mo4044a(z);
    }

    /* renamed from: a */
    public void mo4042a(long j) {
        while ((-128 & j) != 0) {
            mo4051e((((int) j) & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            j >>>= 7;
        }
        mo4051e((int) j);
    }

    /* renamed from: a */
    public void mo4043a(String str) {
        byte[] bytes = str.getBytes("UTF-8");
        mo4053g(bytes.length);
        mo4045a(bytes);
    }

    /* renamed from: a */
    public void mo4044a(boolean z) {
        mo4051e(z ? 1 : 0);
    }

    /* renamed from: a */
    public void mo4045a(byte[] bArr) {
        mo4049b(bArr, 0, bArr.length);
    }

    /* renamed from: b */
    public int mo4046b() {
        if (this.f978d == null) {
            return this.f976b - this.f977c;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    /* renamed from: b */
    public void mo4047b(int i) {
        mo4053g(i);
    }

    /* renamed from: b */
    public void mo4048b(int i, int i2) {
        mo4052e(i, 0);
        mo4047b(i2);
    }

    /* renamed from: b */
    public void mo4049b(byte[] bArr, int i, int i2) {
        if (this.f976b - this.f977c >= i2) {
            System.arraycopy(bArr, i, this.f975a, this.f977c, i2);
            this.f977c += i2;
            return;
        }
        int i3 = this.f976b - this.f977c;
        System.arraycopy(bArr, i, this.f975a, this.f977c, i3);
        int i4 = i + i3;
        int i5 = i2 - i3;
        this.f977c = this.f976b;
        m1463d();
        if (i5 <= this.f976b) {
            System.arraycopy(bArr, i4, this.f975a, 0, i5);
            this.f977c = i5;
            return;
        }
        this.f978d.write(bArr, i4, i5);
    }

    /* renamed from: c */
    public void mo4050c() {
        if (mo4046b() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: e */
    public void mo4051e(int i) {
        mo4037a((byte) i);
    }

    /* renamed from: e */
    public void mo4052e(int i, int i2) {
        mo4053g(C0401e.m1500a(i, i2));
    }

    /* renamed from: g */
    public void mo4053g(int i) {
        while ((i & -128) != 0) {
            mo4051e((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            i >>>= 7;
        }
        mo4051e(i);
    }
}
