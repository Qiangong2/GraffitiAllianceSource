package com.igexin.assist.util;

import com.igexin.push.util.C1159i;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.igexin.assist.util.a */
public class C0434a {
    /* renamed from: a */
    public static String m1570a(String str, String str2) {
        try {
            byte[] a = C1159i.m4777a(str, 0);
            SecretKeySpec secretKeySpec = new SecretKeySpec(m1571a(new StringBuilder(str2).reverse().toString().getBytes()), "AES");
            Cipher instance = Cipher.getInstance("AES/CFB128/NoPadding");
            instance.init(2, secretKeySpec, new IvParameterSpec(m1571a("".getBytes())));
            byte[] doFinal = instance.doFinal(a);
            if (doFinal != null) {
                return new String(doFinal);
            }
        } catch (Throwable th) {
        }
        return null;
    }

    /* renamed from: a */
    public static byte[] m1571a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            return instance.digest();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
