package com.amap.loc;

import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import p000a.p001a.p002a.p004b.C0027o;

/* renamed from: com.amap.loc.bz */
/* compiled from: Encrypt */
public class C0309bz {

    /* renamed from: a */
    private static final char[] f622a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b */
    private static final byte[] f623b = {0, 1, 1, 2, 3, 5, 8, 13, 8, 7, 6, 5, 4, 3, 2, 1};

    /* renamed from: c */
    private static final IvParameterSpec f624c = new IvParameterSpec(f623b);

    /* renamed from: a */
    public static String m938a(String str) {
        if (str == null) {
            return null;
        }
        try {
            if (str.length() == 0) {
                return null;
            }
            return m939a("MD5", m939a("SHA1", str) + str);
        } catch (Throwable th) {
            C0310c.m956a(th, "Encrypt", "generatorKey");
            return null;
        }
    }

    /* renamed from: a */
    public static String m939a(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        try {
            return m944b(C0356n.m1304a(str2.getBytes("UTF-8"), str));
        } catch (Throwable th) {
            C0310c.m956a(th, "Encrypt", "encode");
            return null;
        }
    }

    /* renamed from: a */
    private static byte[] m940a() {
        return C0363r.m1357a();
    }

    /* renamed from: a */
    public static byte[] m941a(byte[] bArr) {
        try {
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[(bArr.length - 16)];
            System.arraycopy(bArr, 0, bArr2, 0, 16);
            System.arraycopy(bArr, 16, bArr3, 0, bArr.length - 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, new IvParameterSpec(C0363r.m1357a()));
            return instance.doFinal(bArr3);
        } catch (Throwable th) {
            C0310c.m956a(th, "Encrypt", "decryptRsponse");
            return null;
        }
    }

    /* renamed from: a */
    public static synchronized byte[] m942a(byte[] bArr, String str) throws Exception {
        byte[] byteArray;
        int i = 0;
        synchronized (C0309bz.class) {
            PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(C0355m.m1299b(str)));
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, generatePrivate);
            int length = bArr.length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i2 = 0;
            while (length - i > 0) {
                byte[] doFinal = length - i > 245 ? instance.doFinal(bArr, i, 245) : instance.doFinal(bArr, i, length - i);
                byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                int i3 = i2 + 1;
                i = i3 * 245;
                i2 = i3;
            }
            byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        }
        return byteArray;
    }

    /* renamed from: a */
    public static byte[] m943a(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, new SecretKeySpec(bArr, "AES"), f624c);
        return instance.doFinal(bArr2);
    }

    /* renamed from: b */
    private static String m944b(byte[] bArr) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length * 2);
        for (int i = 0; i < length; i++) {
            sb.append(f622a[(bArr[i] >> 4) & 15]);
            sb.append(f622a[bArr[i] & C0027o.f104m]);
        }
        return sb.toString();
    }

    /* renamed from: b */
    private static SecretKeySpec m945b(String str) {
        byte[] bArr = null;
        if (str == null) {
            str = "";
        }
        StringBuffer stringBuffer = new StringBuffer(16);
        stringBuffer.append(str);
        while (stringBuffer.length() < 16) {
            stringBuffer.append("0");
        }
        if (stringBuffer.length() > 16) {
            stringBuffer.setLength(16);
        }
        try {
            bArr = stringBuffer.toString().getBytes("UTF-8");
        } catch (Throwable th) {
            C0310c.m956a(th, "Encrypt", "createKey");
        }
        return new SecretKeySpec(bArr, "AES");
    }

    /* renamed from: b */
    public static synchronized byte[] m946b(byte[] bArr, String str) throws Exception {
        byte[] byteArray;
        int i = 0;
        synchronized (C0309bz.class) {
            PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(C0355m.m1299b(str)));
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(2, generatePrivate);
            int length = bArr.length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i2 = 0;
            while (length - i > 0) {
                byte[] doFinal = length - i > 256 ? instance.doFinal(bArr, i, 256) : instance.doFinal(bArr, i, length - i);
                byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                int i3 = i2 + 1;
                i = i3 * 256;
                i2 = i3;
            }
            byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        }
        return byteArray;
    }

    /* renamed from: c */
    public static byte[] m947c(byte[] bArr, String str) {
        try {
            SecretKeySpec b = m945b(str);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(m940a());
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, b, ivParameterSpec);
            return instance.doFinal(bArr);
        } catch (Throwable th) {
            C0310c.m956a(th, "Encrypt", "aesEncrypt");
            return null;
        }
    }

    /* renamed from: d */
    public static byte[] m948d(byte[] bArr, String str) {
        try {
            SecretKeySpec b = m945b(str);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(m940a());
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, b, ivParameterSpec);
            return instance.doFinal(bArr);
        } catch (Throwable th) {
            C0310c.m956a(th, "Encrypt", "aesDecrypt");
            return null;
        }
    }
}
