package com.igexin.push.util;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.util.l */
public class C1162l extends AbstractC1160j {

    /* renamed from: g */
    static final /* synthetic */ boolean f3032g = (!C1159i.class.desiredAssertionStatus());

    /* renamed from: h */
    private static final byte[] f3033h = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: i */
    private static final byte[] f3034i = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: c */
    int f3035c;

    /* renamed from: d */
    public final boolean f3036d;

    /* renamed from: e */
    public final boolean f3037e;

    /* renamed from: f */
    public final boolean f3038f;

    /* renamed from: j */
    private final byte[] f3039j;

    /* renamed from: k */
    private int f3040k;

    /* renamed from: l */
    private final byte[] f3041l;

    public C1162l(int i, byte[] bArr) {
        boolean z = true;
        this.f3025a = bArr;
        this.f3036d = (i & 1) == 0;
        this.f3037e = (i & 2) == 0;
        this.f3038f = (i & 4) == 0 ? false : z;
        this.f3041l = (i & 8) == 0 ? f3033h : f3034i;
        this.f3039j = new byte[2];
        this.f3035c = 0;
        this.f3040k = this.f3037e ? 19 : -1;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    public boolean mo5908a(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        int i4;
        byte b;
        int i5;
        byte b2;
        int i6;
        byte b3;
        int i7;
        int i8;
        int i9;
        int i10;
        byte[] bArr2 = this.f3041l;
        byte[] bArr3 = this.f3025a;
        int i11 = 0;
        int i12 = this.f3040k;
        int i13 = i2 + i;
        int i14 = -1;
        switch (this.f3035c) {
            case 0:
                i3 = i;
                break;
            case 1:
                if (i + 2 <= i13) {
                    int i15 = i + 1;
                    i14 = ((this.f3039j[0] & 255) << 16) | ((bArr[i] & 255) << 8) | (bArr[i15] & 255);
                    this.f3035c = 0;
                    i3 = i15 + 1;
                    break;
                }
                i3 = i;
                break;
            case 2:
                if (i + 1 <= i13) {
                    i3 = i + 1;
                    i14 = ((this.f3039j[0] & 255) << 16) | ((this.f3039j[1] & 255) << 8) | (bArr[i] & 255);
                    this.f3035c = 0;
                    break;
                }
                i3 = i;
                break;
            default:
                i3 = i;
                break;
        }
        if (i14 != -1) {
            bArr3[0] = bArr2[(i14 >> 18) & 63];
            bArr3[1] = bArr2[(i14 >> 12) & 63];
            bArr3[2] = bArr2[(i14 >> 6) & 63];
            i11 = 4;
            bArr3[3] = bArr2[i14 & 63];
            i12--;
            if (i12 == 0) {
                if (this.f3038f) {
                    i10 = 5;
                    bArr3[4] = 13;
                } else {
                    i10 = 4;
                }
                i11 = i10 + 1;
                bArr3[i10] = 10;
                i12 = 19;
            }
        }
        while (true) {
            int i16 = i11;
            if (i3 + 3 <= i13) {
                int i17 = ((bArr[i3] & 255) << 16) | ((bArr[i3 + 1] & 255) << 8) | (bArr[i3 + 2] & 255);
                bArr3[i16] = bArr2[(i17 >> 18) & 63];
                bArr3[i16 + 1] = bArr2[(i17 >> 12) & 63];
                bArr3[i16 + 2] = bArr2[(i17 >> 6) & 63];
                bArr3[i16 + 3] = bArr2[i17 & 63];
                i3 += 3;
                i11 = i16 + 4;
                i12--;
                if (i12 == 0) {
                    if (this.f3038f) {
                        i9 = i11 + 1;
                        bArr3[i11] = 13;
                    } else {
                        i9 = i11;
                    }
                    i11 = i9 + 1;
                    bArr3[i9] = 10;
                    i12 = 19;
                }
            } else {
                if (z) {
                    if (i3 - this.f3035c == i13 - 1) {
                        if (this.f3035c > 0) {
                            i8 = 1;
                            b3 = this.f3039j[0];
                            i7 = i3;
                        } else {
                            b3 = bArr[i3];
                            i7 = i3 + 1;
                            i8 = 0;
                        }
                        int i18 = (b3 & 255) << 4;
                        this.f3035c -= i8;
                        int i19 = i16 + 1;
                        bArr3[i16] = bArr2[(i18 >> 6) & 63];
                        int i20 = i19 + 1;
                        bArr3[i19] = bArr2[i18 & 63];
                        if (this.f3036d) {
                            int i21 = i20 + 1;
                            bArr3[i20] = 61;
                            i20 = i21 + 1;
                            bArr3[i21] = 61;
                        }
                        if (this.f3037e) {
                            if (this.f3038f) {
                                bArr3[i20] = 13;
                                i20++;
                            }
                            bArr3[i20] = 10;
                            i20++;
                        }
                        i3 = i7;
                        i16 = i20;
                    } else if (i3 - this.f3035c == i13 - 2) {
                        if (this.f3035c > 1) {
                            i5 = 1;
                            b = this.f3039j[0];
                        } else {
                            b = bArr[i3];
                            i3++;
                            i5 = 0;
                        }
                        int i22 = (b & 255) << 10;
                        if (this.f3035c > 0) {
                            b2 = this.f3039j[i5];
                            i5++;
                        } else {
                            b2 = bArr[i3];
                            i3++;
                        }
                        int i23 = ((b2 & 255) << 2) | i22;
                        this.f3035c -= i5;
                        int i24 = i16 + 1;
                        bArr3[i16] = bArr2[(i23 >> 12) & 63];
                        int i25 = i24 + 1;
                        bArr3[i24] = bArr2[(i23 >> 6) & 63];
                        int i26 = i25 + 1;
                        bArr3[i25] = bArr2[i23 & 63];
                        if (this.f3036d) {
                            i6 = i26 + 1;
                            bArr3[i26] = 61;
                        } else {
                            i6 = i26;
                        }
                        if (this.f3037e) {
                            if (this.f3038f) {
                                bArr3[i6] = 13;
                                i6++;
                            }
                            bArr3[i6] = 10;
                            i6++;
                        }
                        i16 = i6;
                    } else if (this.f3037e && i16 > 0 && i12 != 19) {
                        if (this.f3038f) {
                            i4 = i16 + 1;
                            bArr3[i16] = 13;
                        } else {
                            i4 = i16;
                        }
                        i16 = i4 + 1;
                        bArr3[i4] = 10;
                    }
                    if (!f3032g && this.f3035c != 0) {
                        throw new AssertionError();
                    } else if (!f3032g && i3 != i13) {
                        throw new AssertionError();
                    }
                } else if (i3 == i13 - 1) {
                    byte[] bArr4 = this.f3039j;
                    int i27 = this.f3035c;
                    this.f3035c = i27 + 1;
                    bArr4[i27] = bArr[i3];
                } else if (i3 == i13 - 2) {
                    byte[] bArr5 = this.f3039j;
                    int i28 = this.f3035c;
                    this.f3035c = i28 + 1;
                    bArr5[i28] = bArr[i3];
                    byte[] bArr6 = this.f3039j;
                    int i29 = this.f3035c;
                    this.f3035c = i29 + 1;
                    bArr6[i29] = bArr[i3 + 1];
                }
                this.f3026b = i16;
                this.f3040k = i12;
                return true;
            }
        }
    }
}
