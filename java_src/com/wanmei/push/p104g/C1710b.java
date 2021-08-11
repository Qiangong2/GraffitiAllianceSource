package com.wanmei.push.p104g;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.wanmei.push.g.b */
public final class C1710b {
    /* renamed from: a */
    public static String m6369a(String str, String str2) {
        return m6370a(Base64.decode(str2, 2), str.substring(2, 5) + str.substring(10, 16) + str.substring(18, 20) + str.substring(14, 19));
    }

    /* renamed from: a */
    private static String m6370a(byte[] bArr, String str) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
            Cipher instance = Cipher.getInstance("AES");
            instance.init(2, secretKeySpec);
            return new String(instance.doFinal(bArr), "UTF-8");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (InvalidKeyException e3) {
            e3.printStackTrace();
        } catch (IllegalBlockSizeException e4) {
            e4.printStackTrace();
        } catch (BadPaddingException e5) {
            e5.printStackTrace();
        } catch (UnsupportedEncodingException e6) {
            e6.printStackTrace();
        }
        return null;
    }
}
