package com.xiaomi.push.service;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.xiaomi.channel.commonutils.string.C1870a;
import p000a.p001a.p002a.p004b.C0027o;

/* renamed from: com.xiaomi.push.service.ac */
public class C1948ac {

    /* renamed from: a */
    private static int f5030a = 8;

    /* renamed from: b */
    private byte[] f5031b = new byte[256];

    /* renamed from: c */
    private int f5032c = 0;

    /* renamed from: d */
    private int f5033d = 0;

    /* renamed from: e */
    private int f5034e = -666;

    /* renamed from: a */
    public static int m7255a(byte b) {
        return b >= 0 ? b : b + C0027o.f92a;
    }

    /* renamed from: a */
    public static String m7256a(byte[] bArr, String str) {
        return String.valueOf(C1870a.m6774a(m7261a(bArr, str.getBytes())));
    }

    /* renamed from: a */
    private void m7257a(int i, byte[] bArr, boolean z) {
        int length = bArr.length;
        for (int i2 = 0; i2 < 256; i2++) {
            this.f5031b[i2] = (byte) i2;
        }
        this.f5033d = 0;
        this.f5032c = 0;
        while (this.f5032c < i) {
            this.f5033d = ((this.f5033d + m7255a(this.f5031b[this.f5032c])) + m7255a(bArr[this.f5032c % length])) % 256;
            m7259a(this.f5031b, this.f5032c, this.f5033d);
            this.f5032c++;
        }
        if (i != 256) {
            this.f5034e = ((this.f5033d + m7255a(this.f5031b[i])) + m7255a(bArr[i % length])) % 256;
        }
        if (z) {
            System.out.print("S_" + (i - 1) + ":");
            for (int i3 = 0; i3 <= i; i3++) {
                System.out.print(" " + m7255a(this.f5031b[i3]));
            }
            System.out.print("   j_" + (i - 1) + SimpleComparison.EQUAL_TO_OPERATION + this.f5033d);
            System.out.print("   j_" + i + SimpleComparison.EQUAL_TO_OPERATION + this.f5034e);
            System.out.print("   S_" + (i - 1) + "[j_" + (i - 1) + "]=" + m7255a(this.f5031b[this.f5033d]));
            System.out.print("   S_" + (i - 1) + "[j_" + i + "]=" + m7255a(this.f5031b[this.f5034e]));
            if (this.f5031b[1] != 0) {
                System.out.print("   S[1]!=0");
            }
            System.out.println();
        }
    }

    /* renamed from: a */
    private void m7258a(byte[] bArr) {
        m7257a(256, bArr, false);
    }

    /* renamed from: a */
    private static void m7259a(byte[] bArr, int i, int i2) {
        byte b = bArr[i];
        bArr[i] = bArr[i2];
        bArr[i2] = b;
    }

    /* renamed from: a */
    public static byte[] m7260a(String str, String str2) {
        byte[] a = C1870a.m6771a(str);
        byte[] bytes = str2.getBytes();
        byte[] bArr = new byte[(a.length + 1 + bytes.length)];
        for (int i = 0; i < a.length; i++) {
            bArr[i] = a[i];
        }
        bArr[a.length] = 95;
        for (int i2 = 0; i2 < bytes.length; i2++) {
            bArr[a.length + 1 + i2] = bytes[i2];
        }
        return bArr;
    }

    /* renamed from: a */
    public static byte[] m7261a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr2.length];
        C1948ac acVar = new C1948ac();
        acVar.m7258a(bArr);
        acVar.m7262b();
        for (int i = 0; i < bArr2.length; i++) {
            bArr3[i] = (byte) (bArr2[i] ^ acVar.mo10384a());
        }
        return bArr3;
    }

    /* renamed from: b */
    private void m7262b() {
        this.f5033d = 0;
        this.f5032c = 0;
    }

    /* renamed from: b */
    public static byte[] m7263b(byte[] bArr, String str) {
        return m7261a(bArr, C1870a.m6771a(str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public byte mo10384a() {
        this.f5032c = (this.f5032c + 1) % 256;
        this.f5033d = (this.f5033d + m7255a(this.f5031b[this.f5032c])) % 256;
        m7259a(this.f5031b, this.f5032c, this.f5033d);
        return this.f5031b[(m7255a(this.f5031b[this.f5032c]) + m7255a(this.f5031b[this.f5033d])) % 256];
    }
}
