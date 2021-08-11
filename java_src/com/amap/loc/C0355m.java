package com.amap.loc;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.tencent.qcloud.core.util.IOUtils;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.amap.loc.m */
/* compiled from: Encrypt */
public class C0355m {

    /* renamed from: a */
    private static final char[] f887a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', IOUtils.DIR_SEPARATOR_UNIX};

    /* renamed from: b */
    private static final byte[] f888b = new byte[128];

    static {
        for (int i = 0; i < 128; i++) {
            f888b[i] = -1;
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            f888b[i2] = (byte) (i2 - 65);
        }
        for (int i3 = 97; i3 <= 122; i3++) {
            f888b[i3] = (byte) ((i3 - 97) + 26);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            f888b[i4] = (byte) ((i4 - 48) + 52);
        }
        f888b[43] = 62;
        f888b[47] = 63;
    }

    /* renamed from: a */
    public static String m1294a(String str) {
        return C0363r.m1351a(m1299b(str));
    }

    /* renamed from: a */
    public static String m1295a(byte[] bArr) {
        try {
            return m1301c(bArr);
        } catch (Throwable th) {
            C0365t.m1372a(th, "Encrypt", "encodeBase64");
            return null;
        }
    }

    /* renamed from: a */
    static byte[] m1296a(byte[] bArr, Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(1, key);
        return instance.doFinal(bArr);
    }

    /* renamed from: a */
    static byte[] m1297a(byte[] bArr, byte[] bArr2) {
        try {
            return m1300b(bArr, bArr2);
        } catch (Throwable th) {
            C0365t.m1372a(th, "Encrypt", "aesEncrypt");
            return null;
        }
    }

    /* renamed from: b */
    public static String m1298b(byte[] bArr) {
        try {
            return m1301c(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0029 A[LOOP:2: B:11:0x0029->B:10:0x0028, LOOP_START, PHI: r1 
      PHI: (r1v1 int) = (r1v0 int), (r1v11 int) binds: [B:8:0x0021, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0077 A[LOOP:0: B:4:0x0013->B:31:0x0077, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0023 A[EDGE_INSN: B:37:0x0023->B:9:0x0023 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0023 A[EDGE_INSN: B:38:0x0023->B:9:0x0023 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0023 A[EDGE_INSN: B:40:0x0023->B:9:0x0023 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0023 A[EDGE_INSN: B:41:0x0023->B:9:0x0023 ?: BREAK  , SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] m1299b(java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 134
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0355m.m1299b(java.lang.String):byte[]");
    }

    /* renamed from: b */
    private static byte[] m1300b(byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(C0363r.m1357a());
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        try {
            instance.init(1, secretKeySpec, ivParameterSpec);
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return instance.doFinal(bArr2);
    }

    /* renamed from: c */
    private static String m1301c(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            int i3 = bArr[i] & 255;
            if (i2 == length) {
                stringBuffer.append(f887a[i3 >>> 2]);
                stringBuffer.append(f887a[(i3 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i4 = i2 + 1;
            int i5 = bArr[i2] & 255;
            if (i4 == length) {
                stringBuffer.append(f887a[i3 >>> 2]);
                stringBuffer.append(f887a[((i3 & 3) << 4) | ((i5 & 240) >>> 4)]);
                stringBuffer.append(f887a[(i5 & 15) << 2]);
                stringBuffer.append(SimpleComparison.EQUAL_TO_OPERATION);
                break;
            }
            i = i4 + 1;
            int i6 = bArr[i4] & 255;
            stringBuffer.append(f887a[i3 >>> 2]);
            stringBuffer.append(f887a[((i3 & 3) << 4) | ((i5 & 240) >>> 4)]);
            stringBuffer.append(f887a[((i5 & 15) << 2) | ((i6 & 192) >>> 6)]);
            stringBuffer.append(f887a[i6 & 63]);
        }
        return stringBuffer.toString();
    }
}
