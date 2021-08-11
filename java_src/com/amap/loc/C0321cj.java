package com.amap.loc;

import android.text.TextUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.umeng.analytics.p091b.C1447g;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.zip.CRC32;

/* renamed from: com.amap.loc.cj */
/* compiled from: Req */
public class C0321cj {

    /* renamed from: A */
    public String f681A = null;

    /* renamed from: B */
    public String f682B = null;

    /* renamed from: C */
    public String f683C = null;

    /* renamed from: D */
    public String f684D = null;

    /* renamed from: E */
    public String f685E = null;

    /* renamed from: F */
    public String f686F = null;

    /* renamed from: G */
    public byte[] f687G = null;

    /* renamed from: a */
    public String f688a = "1";

    /* renamed from: b */
    public short f689b = 0;

    /* renamed from: c */
    public String f690c = null;

    /* renamed from: d */
    public String f691d = null;

    /* renamed from: e */
    public String f692e = null;

    /* renamed from: f */
    public String f693f = null;

    /* renamed from: g */
    public String f694g = null;

    /* renamed from: h */
    public String f695h = null;

    /* renamed from: i */
    public String f696i = null;

    /* renamed from: j */
    public String f697j = null;

    /* renamed from: k */
    public String f698k = null;

    /* renamed from: l */
    public String f699l = null;

    /* renamed from: m */
    public String f700m = null;

    /* renamed from: n */
    public String f701n = null;

    /* renamed from: o */
    public String f702o = null;

    /* renamed from: p */
    public String f703p = null;

    /* renamed from: q */
    public String f704q = null;

    /* renamed from: r */
    public String f705r = null;

    /* renamed from: s */
    public String f706s = null;

    /* renamed from: t */
    public String f707t = null;

    /* renamed from: u */
    public String f708u = null;

    /* renamed from: v */
    public String f709v = null;

    /* renamed from: w */
    public String f710w = null;

    /* renamed from: x */
    public String f711x = null;

    /* renamed from: y */
    public String f712y = null;

    /* renamed from: z */
    public String f713z = null;

    /* renamed from: a */
    private String m1032a(String str, int i) {
        String[] split = this.f682B.split("\\*")[i].split(MiPushClient.ACCEPT_TIME_SEPARATOR);
        if (str.equals("lac")) {
            return split[0];
        }
        if (str.equals("cellid")) {
            return split[1];
        }
        if (str.equals("signal")) {
            return split[2];
        }
        return null;
    }

    /* renamed from: a */
    public static void m1033a(byte[] bArr, int i) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        if (r0.length != 6) goto L_0x0010;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] m1034b(java.lang.String r8) {
        /*
            r7 = this;
            r6 = 2
            r4 = 6
            r2 = 0
            java.lang.String r0 = ":"
            java.lang.String[] r0 = r8.split(r0)
            byte[] r1 = new byte[r4]
            if (r0 == 0) goto L_0x0010
            int r3 = r0.length     // Catch:{ Throwable -> 0x0043 }
            if (r3 == r4) goto L_0x001e
        L_0x0010:
            r0 = 6
            java.lang.String[] r0 = new java.lang.String[r0]     // Catch:{ Throwable -> 0x0043 }
            r3 = r2
        L_0x0014:
            int r4 = r0.length     // Catch:{ Throwable -> 0x0043 }
            if (r3 >= r4) goto L_0x001e
            java.lang.String r4 = "0"
            r0[r3] = r4     // Catch:{ Throwable -> 0x0043 }
            int r3 = r3 + 1
            goto L_0x0014
        L_0x001e:
            int r3 = r0.length     // Catch:{ Throwable -> 0x0043 }
            if (r2 >= r3) goto L_0x0041
            r3 = r0[r2]     // Catch:{ Throwable -> 0x0043 }
            int r3 = r3.length()     // Catch:{ Throwable -> 0x0043 }
            if (r3 <= r6) goto L_0x0033
            r3 = r0[r2]     // Catch:{ Throwable -> 0x0043 }
            r4 = 0
            r5 = 2
            java.lang.String r3 = r3.substring(r4, r5)     // Catch:{ Throwable -> 0x0043 }
            r0[r2] = r3     // Catch:{ Throwable -> 0x0043 }
        L_0x0033:
            r3 = r0[r2]     // Catch:{ Throwable -> 0x0043 }
            r4 = 16
            int r3 = java.lang.Integer.parseInt(r3, r4)     // Catch:{ Throwable -> 0x0043 }
            byte r3 = (byte) r3     // Catch:{ Throwable -> 0x0043 }
            r1[r2] = r3     // Catch:{ Throwable -> 0x0043 }
            int r2 = r2 + 1
            goto L_0x001e
        L_0x0041:
            r0 = r1
        L_0x0042:
            return r0
        L_0x0043:
            r0 = move-exception
            java.lang.String r1 = "Req"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getMacBa "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r2 = r2.toString()
            com.amap.loc.C0310c.m956a(r0, r1, r2)
            java.lang.String r0 = "00:00:00:00:00:00"
            byte[] r0 = r7.m1034b(r0)
            goto L_0x0042
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0321cj.m1034b(java.lang.String):byte[]");
    }

    /* renamed from: a */
    public String mo3890a(String str) {
        if (!this.f681A.contains(str + SimpleComparison.GREATER_THAN_OPERATION)) {
            return "0";
        }
        int indexOf = this.f681A.indexOf(str + SimpleComparison.GREATER_THAN_OPERATION);
        return this.f681A.substring(indexOf + str.length() + 1, this.f681A.indexOf("</" + str));
    }

    /* renamed from: a */
    public byte[] mo3891a() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        byte[] b;
        int i19;
        int length;
        mo3892b();
        int i20 = 3072;
        if (this.f687G != null) {
            i20 = 3072 + this.f687G.length + 1;
        }
        byte[] bArr = new byte[i20];
        bArr[0] = Byte.parseByte(this.f688a);
        byte[] b2 = C0331cr.m1177b(this.f689b);
        System.arraycopy(b2, 0, bArr, 1, b2.length);
        int length2 = b2.length + 1;
        try {
            byte[] bytes = this.f690c.getBytes("GBK");
            bArr[length2] = (byte) bytes.length;
            length2++;
            System.arraycopy(bytes, 0, bArr, length2, bytes.length);
            i = length2 + bytes.length;
        } catch (Throwable th) {
            C0310c.m956a(th, "Req", "buildV4Dot2");
            bArr[length2] = 0;
            i = length2 + 1;
        }
        try {
            byte[] bytes2 = this.f691d.getBytes("GBK");
            bArr[i] = (byte) bytes2.length;
            i++;
            System.arraycopy(bytes2, 0, bArr, i, bytes2.length);
            i2 = i + bytes2.length;
        } catch (Throwable th2) {
            C0310c.m956a(th2, "Req", "buildV4Dot21");
            bArr[i] = 0;
            i2 = i + 1;
        }
        try {
            byte[] bytes3 = this.f702o.getBytes("GBK");
            bArr[i2] = (byte) bytes3.length;
            i2++;
            System.arraycopy(bytes3, 0, bArr, i2, bytes3.length);
            i3 = i2 + bytes3.length;
        } catch (Throwable th3) {
            C0310c.m956a(th3, "Req", "buildV4Dot22");
            bArr[i2] = 0;
            i3 = i2 + 1;
        }
        try {
            byte[] bytes4 = this.f692e.getBytes("GBK");
            bArr[i3] = (byte) bytes4.length;
            i3++;
            System.arraycopy(bytes4, 0, bArr, i3, bytes4.length);
            i4 = i3 + bytes4.length;
        } catch (Throwable th4) {
            C0310c.m956a(th4, "Req", "buildV4Dot23");
            bArr[i3] = 0;
            i4 = i3 + 1;
        }
        try {
            byte[] bytes5 = this.f693f.getBytes("GBK");
            bArr[i4] = (byte) bytes5.length;
            i4++;
            System.arraycopy(bytes5, 0, bArr, i4, bytes5.length);
            i5 = i4 + bytes5.length;
        } catch (Throwable th5) {
            C0310c.m956a(th5, "Req", "buildV4Dot24");
            bArr[i4] = 0;
            i5 = i4 + 1;
        }
        try {
            byte[] bytes6 = this.f694g.getBytes("GBK");
            bArr[i5] = (byte) bytes6.length;
            i5++;
            System.arraycopy(bytes6, 0, bArr, i5, bytes6.length);
            i6 = i5 + bytes6.length;
        } catch (Throwable th6) {
            C0310c.m956a(th6, "Req", "buildV4Dot25");
            bArr[i5] = 0;
            i6 = i5 + 1;
        }
        try {
            byte[] bytes7 = this.f708u.getBytes("GBK");
            bArr[i6] = (byte) bytes7.length;
            i6++;
            System.arraycopy(bytes7, 0, bArr, i6, bytes7.length);
            i7 = i6 + bytes7.length;
        } catch (Throwable th7) {
            C0310c.m956a(th7, "Req", "buildV4Dot26");
            bArr[i6] = 0;
            i7 = i6 + 1;
        }
        try {
            byte[] bytes8 = this.f695h.getBytes("GBK");
            bArr[i7] = (byte) bytes8.length;
            i7++;
            System.arraycopy(bytes8, 0, bArr, i7, bytes8.length);
            i8 = i7 + bytes8.length;
        } catch (Throwable th8) {
            C0310c.m956a(th8, "Req", "buildV4Dot27");
            bArr[i7] = 0;
            i8 = i7 + 1;
        }
        try {
            byte[] bytes9 = this.f703p.getBytes("GBK");
            bArr[i8] = (byte) bytes9.length;
            i8++;
            System.arraycopy(bytes9, 0, bArr, i8, bytes9.length);
            i9 = i8 + bytes9.length;
        } catch (Throwable th9) {
            C0310c.m956a(th9, "Req", "buildV4Dot28");
            bArr[i8] = 0;
            i9 = i8 + 1;
        }
        try {
            byte[] bytes10 = this.f704q.getBytes("GBK");
            bArr[i9] = (byte) bytes10.length;
            i9++;
            System.arraycopy(bytes10, 0, bArr, i9, bytes10.length);
            i10 = i9 + bytes10.length;
        } catch (Throwable th10) {
            C0310c.m956a(th10, "Req", "buildV4Dot29");
            bArr[i9] = 0;
            i10 = i9 + 1;
        }
        try {
            if (TextUtils.isEmpty(this.f707t)) {
                bArr[i10] = 0;
                length = i10 + 1;
            } else {
                byte[] b3 = m1034b(this.f707t);
                bArr[i10] = (byte) b3.length;
                int i21 = i10 + 1;
                System.arraycopy(b3, 0, bArr, i21, b3.length);
                length = b3.length + i21;
            }
            i11 = length;
        } catch (Throwable th11) {
            C0310c.m956a(th11, "Req", "buildV4Dot219");
            bArr[i10] = 0;
            i11 = i10 + 1;
        }
        try {
            byte[] bytes11 = this.f709v.getBytes("GBK");
            bArr[i11] = (byte) bytes11.length;
            i11++;
            System.arraycopy(bytes11, 0, bArr, i11, bytes11.length);
            i12 = i11 + bytes11.length;
        } catch (Throwable th12) {
            C0310c.m956a(th12, "Req", "buildV4Dot211");
            bArr[i11] = 0;
            i12 = i11 + 1;
        }
        try {
            byte[] bytes12 = this.f710w.getBytes("GBK");
            bArr[i12] = (byte) bytes12.length;
            i12++;
            System.arraycopy(bytes12, 0, bArr, i12, bytes12.length);
            i13 = i12 + bytes12.length;
        } catch (Throwable th13) {
            C0310c.m956a(th13, "Req", "buildV4Dot212");
            bArr[i12] = 0;
            i13 = i12 + 1;
        }
        try {
            byte[] bytes13 = this.f711x.getBytes("GBK");
            bArr[i13] = (byte) bytes13.length;
            i13++;
            System.arraycopy(bytes13, 0, bArr, i13, bytes13.length);
            i14 = bytes13.length + i13;
        } catch (Throwable th14) {
            C0310c.m956a(th14, "Req", "buildV4Dot213");
            bArr[i13] = 0;
            i14 = i13 + 1;
        }
        bArr[i14] = Byte.parseByte(this.f712y);
        int i22 = i14 + 1;
        bArr[i22] = Byte.parseByte(this.f697j);
        int i23 = i22 + 1;
        bArr[i23] = Byte.parseByte(this.f713z);
        int i24 = i23 + 1;
        if (this.f713z.equals("1")) {
            byte[] d = C0331cr.m1187d(mo3890a("mcc"));
            System.arraycopy(d, 0, bArr, i24, d.length);
            int length3 = i24 + d.length;
            byte[] d2 = C0331cr.m1187d(mo3890a("mnc"));
            System.arraycopy(d2, 0, bArr, length3, d2.length);
            int length4 = length3 + d2.length;
            byte[] d3 = C0331cr.m1187d(mo3890a("lac"));
            System.arraycopy(d3, 0, bArr, length4, d3.length);
            int length5 = length4 + d3.length;
            byte[] e = C0331cr.m1190e(mo3890a("cellid"));
            System.arraycopy(e, 0, bArr, length5, e.length);
            int length6 = e.length + length5;
            int parseInt = Integer.parseInt(mo3890a("signal"));
            if (parseInt > 127) {
                parseInt = 0;
            }
            bArr[length6] = (byte) parseInt;
            int i25 = length6 + 1;
            if (this.f682B.length() == 0) {
                bArr[i25] = 0;
                i24 = i25 + 1;
            } else {
                int length7 = this.f682B.split("\\*").length;
                bArr[i25] = (byte) length7;
                i24 = i25 + 1;
                int i26 = 0;
                while (i26 < length7) {
                    byte[] d4 = C0331cr.m1187d(m1032a("lac", i26));
                    System.arraycopy(d4, 0, bArr, i24, d4.length);
                    int length8 = i24 + d4.length;
                    byte[] e2 = C0331cr.m1190e(m1032a("cellid", i26));
                    System.arraycopy(e2, 0, bArr, length8, e2.length);
                    int length9 = e2.length + length8;
                    int parseInt2 = Integer.parseInt(m1032a("signal", i26));
                    if (parseInt2 > 127) {
                        parseInt2 = 0;
                    }
                    bArr[length9] = (byte) parseInt2;
                    i26++;
                    i24 = length9 + 1;
                }
            }
        } else if (this.f713z.equals("2")) {
            byte[] d5 = C0331cr.m1187d(mo3890a("mcc"));
            System.arraycopy(d5, 0, bArr, i24, d5.length);
            int length10 = i24 + d5.length;
            byte[] d6 = C0331cr.m1187d(mo3890a("sid"));
            System.arraycopy(d6, 0, bArr, length10, d6.length);
            int length11 = length10 + d6.length;
            byte[] d7 = C0331cr.m1187d(mo3890a("nid"));
            System.arraycopy(d7, 0, bArr, length11, d7.length);
            int length12 = length11 + d7.length;
            byte[] d8 = C0331cr.m1187d(mo3890a("bid"));
            System.arraycopy(d8, 0, bArr, length12, d8.length);
            int length13 = length12 + d8.length;
            byte[] e3 = C0331cr.m1190e(mo3890a("lon"));
            System.arraycopy(e3, 0, bArr, length13, e3.length);
            int length14 = length13 + e3.length;
            byte[] e4 = C0331cr.m1190e(mo3890a(C1447g.f3485ae));
            System.arraycopy(e4, 0, bArr, length14, e4.length);
            int length15 = e4.length + length14;
            int parseInt3 = Integer.parseInt(mo3890a("signal"));
            if (parseInt3 > 127) {
                parseInt3 = 0;
            }
            bArr[length15] = (byte) parseInt3;
            int i27 = length15 + 1;
            bArr[i27] = 0;
            i24 = i27 + 1;
        }
        if (this.f683C.length() == 0) {
            bArr[i24] = 0;
            i15 = i24 + 1;
        } else {
            bArr[i24] = 1;
            int i28 = i24 + 1;
            try {
                String[] split = this.f683C.split(MiPushClient.ACCEPT_TIME_SEPARATOR);
                byte[] b4 = m1034b(split[0]);
                System.arraycopy(b4, 0, bArr, i28, b4.length);
                int length16 = i28 + b4.length;
                try {
                    byte[] bytes14 = split[2].getBytes("GBK");
                    bArr[length16] = (byte) bytes14.length;
                    length16++;
                    System.arraycopy(bytes14, 0, bArr, length16, bytes14.length);
                    i16 = length16 + bytes14.length;
                } catch (Throwable th15) {
                    C0310c.m956a(th15, "Req", "buildV4Dot214");
                    bArr[length16] = 0;
                    i16 = length16 + 1;
                }
                int parseInt4 = Integer.parseInt(split[1]);
                if (parseInt4 > 127) {
                    parseInt4 = 0;
                }
                bArr[i16] = Byte.parseByte(String.valueOf(parseInt4));
                i15 = i16 + 1;
            } catch (Throwable th16) {
                C0310c.m956a(th16, "Req", "buildV4Dot216");
                byte[] b5 = m1034b("00:00:00:00:00:00");
                System.arraycopy(b5, 0, bArr, i28, b5.length);
                int length17 = b5.length + i28;
                bArr[length17] = 0;
                int i29 = length17 + 1;
                bArr[i29] = Byte.parseByte("0");
                i15 = i29 + 1;
            }
        }
        String[] split2 = this.f684D.split("\\*");
        if (TextUtils.isEmpty(this.f684D) || split2.length == 0) {
            bArr[i15] = 0;
            i17 = i15 + 1;
        } else {
            bArr[i15] = (byte) split2.length;
            int i30 = i15 + 1;
            for (String str : split2) {
                String[] split3 = str.split(MiPushClient.ACCEPT_TIME_SEPARATOR);
                try {
                    b = m1034b(split3[0]);
                } catch (Throwable th17) {
                    C0310c.m956a(th17, "Req", "buildV4Dot2110");
                    b = m1034b("00:00:00:00:00:00");
                }
                System.arraycopy(b, 0, bArr, i30, b.length);
                int length18 = i30 + b.length;
                try {
                    byte[] bytes15 = split3[2].getBytes("GBK");
                    bArr[length18] = (byte) bytes15.length;
                    length18++;
                    System.arraycopy(bytes15, 0, bArr, length18, bytes15.length);
                    i19 = bytes15.length + length18;
                } catch (Throwable th18) {
                    C0310c.m956a(th18, "Req", "buildV4Dot217");
                    bArr[length18] = 0;
                    i19 = length18 + 1;
                }
                int parseInt5 = Integer.parseInt(split3[1]);
                if (parseInt5 > 127) {
                    parseInt5 = 0;
                }
                bArr[i19] = Byte.parseByte(String.valueOf(parseInt5));
                i30 = i19 + 1;
            }
            byte[] b6 = C0331cr.m1177b(Integer.parseInt(this.f685E));
            System.arraycopy(b6, 0, bArr, i30, b6.length);
            i17 = i30 + b6.length;
        }
        try {
            byte[] bytes16 = this.f686F.getBytes("GBK");
            if (bytes16.length > 127) {
                bytes16 = null;
            }
            if (bytes16 == null) {
                bArr[i17] = 0;
                i18 = i17 + 1;
            } else {
                bArr[i17] = (byte) bytes16.length;
                int i31 = i17 + 1;
                System.arraycopy(bytes16, 0, bArr, i31, bytes16.length);
                i18 = bytes16.length + i31;
            }
        } catch (Throwable th19) {
            C0310c.m956a(th19, "Req", "buildV4Dot218");
            bArr[i17] = 0;
            i18 = i17 + 1;
        }
        int length19 = this.f687G != null ? this.f687G.length : 0;
        byte[] b7 = C0331cr.m1177b(length19);
        System.arraycopy(b7, 0, bArr, i18, b7.length);
        int length20 = i18 + b7.length;
        if (length19 > 0) {
            System.arraycopy(this.f687G, 0, bArr, length20, this.f687G.length);
            length20 += this.f687G.length;
        }
        byte[] bArr2 = new byte[length20];
        System.arraycopy(bArr, 0, bArr2, 0, length20);
        CRC32 crc32 = new CRC32();
        crc32.update(bArr2);
        byte[] a = C0331cr.m1167a(crc32.getValue());
        byte[] bArr3 = new byte[(a.length + length20)];
        System.arraycopy(bArr2, 0, bArr3, 0, length20);
        System.arraycopy(a, 0, bArr3, length20, a.length);
        int length21 = length20 + a.length;
        m1033a(bArr3, 0);
        return bArr3;
    }

    /* renamed from: b */
    public void mo3892b() {
        if (TextUtils.isEmpty(this.f688a)) {
            this.f688a = "";
        }
        if (TextUtils.isEmpty(this.f690c)) {
            this.f690c = "";
        }
        if (TextUtils.isEmpty(this.f691d)) {
            this.f691d = "";
        }
        if (TextUtils.isEmpty(this.f692e)) {
            this.f692e = "";
        }
        if (TextUtils.isEmpty(this.f693f)) {
            this.f693f = "";
        }
        if (TextUtils.isEmpty(this.f694g)) {
            this.f694g = "";
        }
        if (TextUtils.isEmpty(this.f695h)) {
            this.f695h = "";
        }
        if (TextUtils.isEmpty(this.f696i)) {
            this.f696i = "";
        }
        if (TextUtils.isEmpty(this.f697j)) {
            this.f697j = "0";
        } else if (!this.f697j.equals("1") && !this.f697j.equals("2")) {
            this.f697j = "0";
        }
        if (TextUtils.isEmpty(this.f698k)) {
            this.f698k = "0";
        } else if (!this.f698k.equals("0") && !this.f698k.equals("1")) {
            this.f698k = "0";
        }
        if (TextUtils.isEmpty(this.f699l)) {
            this.f699l = "";
        }
        if (TextUtils.isEmpty(this.f700m)) {
            this.f700m = "";
        }
        if (TextUtils.isEmpty(this.f701n)) {
            this.f701n = "";
        }
        if (TextUtils.isEmpty(this.f702o)) {
            this.f702o = "";
        }
        if (TextUtils.isEmpty(this.f703p)) {
            this.f703p = "";
        }
        if (TextUtils.isEmpty(this.f704q)) {
            this.f704q = "";
        }
        if (TextUtils.isEmpty(this.f705r)) {
            this.f705r = "";
        }
        if (TextUtils.isEmpty(this.f706s)) {
            this.f706s = "";
        }
        if (TextUtils.isEmpty(this.f707t)) {
            this.f707t = "";
        }
        if (TextUtils.isEmpty(this.f708u)) {
            this.f708u = "";
        }
        if (TextUtils.isEmpty(this.f709v)) {
            this.f709v = "";
        }
        if (TextUtils.isEmpty(this.f710w)) {
            this.f710w = "";
        }
        if (TextUtils.isEmpty(this.f711x)) {
            this.f711x = "";
        }
        if (TextUtils.isEmpty(this.f712y)) {
            this.f712y = "0";
        } else if (!this.f712y.equals("1") && !this.f712y.equals("2")) {
            this.f712y = "0";
        }
        if (TextUtils.isEmpty(this.f713z)) {
            this.f713z = "0";
        } else if (!this.f713z.equals("1") && !this.f713z.equals("2")) {
            this.f713z = "0";
        }
        if (TextUtils.isEmpty(this.f681A)) {
            this.f681A = "";
        }
        if (TextUtils.isEmpty(this.f682B)) {
            this.f682B = "";
        }
        if (TextUtils.isEmpty(this.f683C)) {
            this.f683C = "";
        }
        if (TextUtils.isEmpty(this.f684D)) {
            this.f684D = "";
        }
        if (TextUtils.isEmpty(this.f685E)) {
            this.f685E = "";
        }
        if (TextUtils.isEmpty(this.f686F)) {
            this.f686F = "";
        }
        if (this.f687G == null) {
            this.f687G = new byte[0];
        }
    }
}
