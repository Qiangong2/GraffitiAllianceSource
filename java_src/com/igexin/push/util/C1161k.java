package com.igexin.push.util;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.util.k */
public class C1161k extends AbstractC1160j {

    /* renamed from: c */
    private static final int[] f3027c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    /* renamed from: d */
    private static final int[] f3028d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    /* renamed from: e */
    private int f3029e;

    /* renamed from: f */
    private int f3030f;

    /* renamed from: g */
    private final int[] f3031g;

    public C1161k(int i, byte[] bArr) {
        this.f3025a = bArr;
        this.f3031g = (i & 8) == 0 ? f3027c : f3028d;
        this.f3029e = 0;
        this.f3030f = 0;
    }

    /* renamed from: a */
    public boolean mo5907a(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        int i4;
        if (this.f3029e == 6) {
            return false;
        }
        int i5 = i2 + i;
        int i6 = this.f3029e;
        int i7 = this.f3030f;
        int i8 = 0;
        byte[] bArr2 = this.f3025a;
        int[] iArr = this.f3031g;
        int i9 = i;
        while (true) {
            if (i9 < i5) {
                if (i6 == 0) {
                    while (i9 + 4 <= i5 && (i7 = (iArr[bArr[i9] & 255] << 18) | (iArr[bArr[i9 + 1] & 255] << 12) | (iArr[bArr[i9 + 2] & 255] << 6) | iArr[bArr[i9 + 3] & 255]) >= 0) {
                        bArr2[i8 + 2] = (byte) i7;
                        bArr2[i8 + 1] = (byte) (i7 >> 8);
                        bArr2[i8] = (byte) (i7 >> 16);
                        i8 += 3;
                        i9 += 4;
                    }
                    if (i9 >= i5) {
                        i3 = i7;
                    }
                }
                int i10 = i9 + 1;
                int i11 = iArr[bArr[i9] & 255];
                switch (i6) {
                    case 0:
                        if (i11 >= 0) {
                            i4 = i6 + 1;
                            i7 = i11;
                            continue;
                            i6 = i4;
                            i9 = i10;
                        } else if (i11 != -1) {
                            this.f3029e = 6;
                            return false;
                        }
                        break;
                    case 1:
                        if (i11 >= 0) {
                            i7 = (i7 << 6) | i11;
                            i4 = i6 + 1;
                            continue;
                            i6 = i4;
                            i9 = i10;
                        } else if (i11 != -1) {
                            this.f3029e = 6;
                            return false;
                        }
                        break;
                    case 2:
                        if (i11 >= 0) {
                            i7 = (i7 << 6) | i11;
                            i4 = i6 + 1;
                            continue;
                        } else if (i11 == -2) {
                            bArr2[i8] = (byte) (i7 >> 4);
                            i4 = 4;
                            i8++;
                        } else if (i11 != -1) {
                            this.f3029e = 6;
                            return false;
                        }
                        i6 = i4;
                        i9 = i10;
                        break;
                    case 3:
                        if (i11 >= 0) {
                            i7 = (i7 << 6) | i11;
                            bArr2[i8 + 2] = (byte) i7;
                            bArr2[i8 + 1] = (byte) (i7 >> 8);
                            bArr2[i8] = (byte) (i7 >> 16);
                            i8 += 3;
                            i4 = 0;
                            continue;
                        } else if (i11 == -2) {
                            bArr2[i8 + 1] = (byte) (i7 >> 2);
                            bArr2[i8] = (byte) (i7 >> 10);
                            i8 += 2;
                            i4 = 5;
                        } else if (i11 != -1) {
                            this.f3029e = 6;
                            return false;
                        }
                        i6 = i4;
                        i9 = i10;
                        break;
                    case 4:
                        if (i11 == -2) {
                            i4 = i6 + 1;
                            continue;
                            i6 = i4;
                            i9 = i10;
                        } else if (i11 != -1) {
                            this.f3029e = 6;
                            return false;
                        }
                        break;
                    case 5:
                        if (i11 != -1) {
                            this.f3029e = 6;
                            return false;
                        }
                        break;
                }
                i4 = i6;
                i6 = i4;
                i9 = i10;
            } else {
                i3 = i7;
            }
        }
        if (!z) {
            this.f3029e = i6;
            this.f3030f = i3;
            this.f3026b = i8;
            return true;
        }
        switch (i6) {
            case 1:
                this.f3029e = 6;
                return false;
            case 2:
                bArr2[i8] = (byte) (i3 >> 4);
                i8++;
                break;
            case 3:
                int i12 = i8 + 1;
                bArr2[i8] = (byte) (i3 >> 10);
                i8 = i12 + 1;
                bArr2[i12] = (byte) (i3 >> 2);
                break;
            case 4:
                this.f3029e = 6;
                return false;
        }
        this.f3029e = i6;
        this.f3026b = i8;
        return true;
    }
}
