package com.google.protobuf.micro;

import java.io.InputStream;
import java.util.Vector;

/* renamed from: com.google.protobuf.micro.a */
public final class C0396a {

    /* renamed from: a */
    private final byte[] f965a;

    /* renamed from: b */
    private int f966b;

    /* renamed from: c */
    private int f967c;

    /* renamed from: d */
    private int f968d;

    /* renamed from: e */
    private final InputStream f969e;

    /* renamed from: f */
    private int f970f;

    /* renamed from: g */
    private int f971g;

    /* renamed from: h */
    private int f972h;

    /* renamed from: i */
    private int f973i;

    /* renamed from: j */
    private int f974j;

    private C0396a(InputStream inputStream) {
        this.f972h = Integer.MAX_VALUE;
        this.f973i = 64;
        this.f974j = 67108864;
        this.f965a = new byte[4096];
        this.f966b = 0;
        this.f968d = 0;
        this.f969e = inputStream;
    }

    private C0396a(byte[] bArr, int i, int i2) {
        this.f972h = Integer.MAX_VALUE;
        this.f973i = 64;
        this.f974j = 67108864;
        this.f965a = bArr;
        this.f966b = i + i2;
        this.f968d = i;
        this.f969e = null;
    }

    /* renamed from: a */
    public static C0396a m1434a(InputStream inputStream) {
        return new C0396a(inputStream);
    }

    /* renamed from: a */
    public static C0396a m1435a(byte[] bArr, int i, int i2) {
        return new C0396a(bArr, i, i2);
    }

    /* renamed from: a */
    private boolean m1436a(boolean z) {
        if (this.f968d < this.f966b) {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        } else if (this.f971g + this.f966b != this.f972h) {
            this.f971g += this.f966b;
            this.f968d = 0;
            this.f966b = this.f969e == null ? -1 : this.f969e.read(this.f965a);
            if (this.f966b == 0 || this.f966b < -1) {
                throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.f966b + "\nThe InputStream implementation is buggy.");
            } else if (this.f966b == -1) {
                this.f966b = 0;
                if (!z) {
                    return false;
                }
                throw C0399c.m1484a();
            } else {
                m1437l();
                int i = this.f971g + this.f966b + this.f967c;
                if (i <= this.f974j && i >= 0) {
                    return true;
                }
                throw C0399c.m1490g();
            }
        } else if (!z) {
            return false;
        } else {
            throw C0399c.m1484a();
        }
    }

    /* renamed from: l */
    private void m1437l() {
        this.f966b += this.f967c;
        int i = this.f971g + this.f966b;
        if (i > this.f972h) {
            this.f967c = i - this.f972h;
            this.f966b -= this.f967c;
            return;
        }
        this.f967c = 0;
    }

    /* renamed from: a */
    public int mo4021a() {
        if (mo4034j()) {
            this.f970f = 0;
            return 0;
        }
        this.f970f = mo4031g();
        if (this.f970f != 0) {
            return this.f970f;
        }
        throw C0399c.m1487d();
    }

    /* renamed from: a */
    public void mo4022a(int i) {
        if (this.f970f != i) {
            throw C0399c.m1488e();
        }
    }

    /* renamed from: b */
    public void mo4023b() {
        int a;
        do {
            a = mo4021a();
            if (a == 0) {
                return;
            }
        } while (mo4024b(a));
    }

    /* renamed from: b */
    public boolean mo4024b(int i) {
        switch (C0401e.m1499a(i)) {
            case 0:
                mo4025c();
                return true;
            case 1:
                mo4033i();
                return true;
            case 2:
                mo4027d(mo4031g());
                return true;
            case 3:
                mo4023b();
                mo4022a(C0401e.m1500a(C0401e.m1501b(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                mo4032h();
                return true;
            default:
                throw C0399c.m1489f();
        }
    }

    /* renamed from: c */
    public int mo4025c() {
        return mo4031g();
    }

    /* renamed from: c */
    public byte[] mo4026c(int i) {
        if (i < 0) {
            throw C0399c.m1485b();
        } else if (this.f971g + this.f968d + i > this.f972h) {
            mo4027d((this.f972h - this.f971g) - this.f968d);
            throw C0399c.m1484a();
        } else if (i <= this.f966b - this.f968d) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.f965a, this.f968d, bArr, 0, i);
            this.f968d += i;
            return bArr;
        } else if (i < 4096) {
            byte[] bArr2 = new byte[i];
            int i2 = this.f966b - this.f968d;
            System.arraycopy(this.f965a, this.f968d, bArr2, 0, i2);
            this.f968d = this.f966b;
            m1436a(true);
            while (i - i2 > this.f966b) {
                System.arraycopy(this.f965a, 0, bArr2, i2, this.f966b);
                i2 += this.f966b;
                this.f968d = this.f966b;
                m1436a(true);
            }
            System.arraycopy(this.f965a, 0, bArr2, i2, i - i2);
            this.f968d = i - i2;
            return bArr2;
        } else {
            int i3 = this.f968d;
            int i4 = this.f966b;
            this.f971g += this.f966b;
            this.f968d = 0;
            this.f966b = 0;
            Vector vector = new Vector();
            int i5 = i - (i4 - i3);
            while (i5 > 0) {
                byte[] bArr3 = new byte[Math.min(i5, 4096)];
                int i6 = 0;
                while (i6 < bArr3.length) {
                    int read = this.f969e == null ? -1 : this.f969e.read(bArr3, i6, bArr3.length - i6);
                    if (read == -1) {
                        throw C0399c.m1484a();
                    }
                    this.f971g += read;
                    i6 += read;
                }
                vector.addElement(bArr3);
                i5 -= bArr3.length;
            }
            byte[] bArr4 = new byte[i];
            int i7 = i4 - i3;
            System.arraycopy(this.f965a, i3, bArr4, 0, i7);
            int i8 = i7;
            for (int i9 = 0; i9 < vector.size(); i9++) {
                byte[] bArr5 = (byte[]) vector.elementAt(i9);
                System.arraycopy(bArr5, 0, bArr4, i8, bArr5.length);
                i8 += bArr5.length;
            }
            return bArr4;
        }
    }

    /* renamed from: d */
    public void mo4027d(int i) {
        if (i < 0) {
            throw C0399c.m1485b();
        } else if (this.f971g + this.f968d + i > this.f972h) {
            mo4027d((this.f972h - this.f971g) - this.f968d);
            throw C0399c.m1484a();
        } else if (i <= this.f966b - this.f968d) {
            this.f968d += i;
        } else {
            int i2 = this.f966b - this.f968d;
            this.f971g += this.f966b;
            this.f968d = 0;
            this.f966b = 0;
            int i3 = i2;
            while (i3 < i) {
                int skip = this.f969e == null ? -1 : (int) this.f969e.skip((long) (i - i3));
                if (skip <= 0) {
                    throw C0399c.m1484a();
                }
                i3 += skip;
                this.f971g = skip + this.f971g;
            }
        }
    }

    /* renamed from: d */
    public boolean mo4028d() {
        return mo4031g() != 0;
    }

    /* renamed from: e */
    public String mo4029e() {
        int g = mo4031g();
        if (g > this.f966b - this.f968d || g <= 0) {
            return new String(mo4026c(g), "UTF-8");
        }
        String str = new String(this.f965a, this.f968d, g, "UTF-8");
        this.f968d = g + this.f968d;
        return str;
    }

    /* renamed from: f */
    public int mo4030f() {
        return mo4031g();
    }

    /* renamed from: g */
    public int mo4031g() {
        byte k = mo4035k();
        if (k >= 0) {
            return k;
        }
        int i = k & Byte.MAX_VALUE;
        byte k2 = mo4035k();
        if (k2 >= 0) {
            return i | (k2 << 7);
        }
        int i2 = i | ((k2 & Byte.MAX_VALUE) << 7);
        byte k3 = mo4035k();
        if (k3 >= 0) {
            return i2 | (k3 << 14);
        }
        int i3 = i2 | ((k3 & Byte.MAX_VALUE) << 14);
        byte k4 = mo4035k();
        if (k4 >= 0) {
            return i3 | (k4 << 21);
        }
        int i4 = i3 | ((k4 & Byte.MAX_VALUE) << 21);
        byte k5 = mo4035k();
        int i5 = i4 | (k5 << 28);
        if (k5 >= 0) {
            return i5;
        }
        for (int i6 = 0; i6 < 5; i6++) {
            if (mo4035k() >= 0) {
                return i5;
            }
        }
        throw C0399c.m1486c();
    }

    /* renamed from: h */
    public int mo4032h() {
        return (mo4035k() & 255) | ((mo4035k() & 255) << 8) | ((mo4035k() & 255) << 16) | ((mo4035k() & 255) << 24);
    }

    /* renamed from: i */
    public long mo4033i() {
        byte k = mo4035k();
        byte k2 = mo4035k();
        return ((((long) k2) & 255) << 8) | (((long) k) & 255) | ((((long) mo4035k()) & 255) << 16) | ((((long) mo4035k()) & 255) << 24) | ((((long) mo4035k()) & 255) << 32) | ((((long) mo4035k()) & 255) << 40) | ((((long) mo4035k()) & 255) << 48) | ((((long) mo4035k()) & 255) << 56);
    }

    /* renamed from: j */
    public boolean mo4034j() {
        return this.f968d == this.f966b && !m1436a(false);
    }

    /* renamed from: k */
    public byte mo4035k() {
        if (this.f968d == this.f966b) {
            m1436a(true);
        }
        byte[] bArr = this.f965a;
        int i = this.f968d;
        this.f968d = i + 1;
        return bArr[i];
    }
}
