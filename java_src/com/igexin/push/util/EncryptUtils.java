package com.igexin.push.util;

import android.text.TextUtils;
import com.igexin.p012b.p013a.p014a.C0435a;
import com.igexin.p012b.p013a.p015b.C0459f;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.C0618g;
import com.igexin.push.extension.mod.SecurityUtils;
import com.igexin.push.p032d.p035c.C0639b;
import com.tencent.gcloud.voice.GCloudVoiceErrno;
import java.security.MessageDigest;

public class EncryptUtils {

    /* renamed from: a */
    private static final String f3013a = EncryptUtils.class.getName();

    /* renamed from: b */
    private static boolean f3014b;

    /* renamed from: c */
    private static int f3015c;

    /* renamed from: d */
    private static byte[] f3016d;

    /* renamed from: e */
    private static byte[] f3017e;
    public static String errorMsg;

    static {
        errorMsg = "";
        try {
            if (SecurityUtils.f2988b) {
                f3016d = initSocketAESKey();
                f3017e = initHttpAESKey();
                f3014b = (f3016d == null || f3017e == null || getSocketAESKey() == null || getHttpAESKey() == null || getRSAKeyId() == null || getVersion() == null) ? false : true;
            }
        } catch (Throwable th) {
            ActivityC0460a.m1698b(f3013a + "|load so error = " + th.toString());
            f3014b = false;
            errorMsg = th.getMessage();
        }
        if (TextUtils.isEmpty(errorMsg)) {
            errorMsg = SecurityUtils.f2989c;
        }
        if (!f3014b) {
            ActivityC0460a.m1698b(f3013a + "|load so error ++++++++");
            if (TextUtils.isEmpty(errorMsg)) {
                errorMsg = "value = null, normal error";
                return;
            }
            return;
        }
        ActivityC0460a.m1698b(f3013a + "|load so success ~~~~~~~");
    }

    public static byte[] aesDecHttp(byte[] bArr, byte[] bArr2) {
        return SecurityUtils.m4653c(f3017e, bArr, bArr2);
    }

    public static byte[] aesDecSocket(byte[] bArr, byte[] bArr2) {
        return SecurityUtils.m4657g(f3016d, bArr, bArr2);
    }

    public static byte[] aesEncHttp(byte[] bArr, byte[] bArr2) {
        return SecurityUtils.m4652b(f3017e, bArr, bArr2);
    }

    public static byte[] aesEncSocket(byte[] bArr, byte[] bArr2) {
        return SecurityUtils.m4656f(f3016d, bArr, bArr2);
    }

    public static byte[] altAesDecSocket(byte[] bArr, byte[] bArr2) {
        return SecurityUtils.m4663m(bArr, bArr2);
    }

    public static byte[] altAesEncSocket(byte[] bArr, byte[] bArr2) {
        return SecurityUtils.m4662l(bArr, bArr2);
    }

    public static byte[] getBytesEncrypted(byte[] bArr) {
        return C0435a.m1578d(bArr, C0618g.f1577B);
    }

    public static byte[] getHttpAESKey() {
        return SecurityUtils.m4654d(f3017e);
    }

    public static String getHttpGTCV() {
        byte[] httpAESKey = getHttpAESKey();
        byte[] bytes = C1168r.m4795a(16).getBytes();
        byte[] bArr = new byte[(bytes.length + httpAESKey.length)];
        int a = C0459f.m1678a(bytes, 0, bArr, 0, bytes.length);
        int a2 = C0459f.m1678a(httpAESKey, 0, bArr, a, httpAESKey.length) + a;
        return C1159i.m4780b(bArr, 2);
    }

    public static String getHttpSignature(String str, byte[] bArr) {
        byte[] bytes = str.getBytes();
        byte[] bArr2 = new byte[(bytes.length + bArr.length)];
        int a = C0459f.m1678a(bytes, 0, bArr2, 0, bytes.length);
        if (bArr.length > 0) {
            int a2 = a + C0459f.m1678a(bArr, 0, bArr2, a, bArr.length);
        }
        return C1159i.m4780b(sha1(bArr2), 2);
    }

    public static byte[] getIV(byte[] bArr) {
        return md5(bArr);
    }

    public static int getPacketId() {
        int i = f3015c;
        f3015c = i + 1;
        return i;
    }

    public static byte[] getRSAKeyId() {
        return SecurityUtils.m4660j();
    }

    public static byte[] getSocketAESKey() {
        return SecurityUtils.m4658h(f3016d);
    }

    public static byte[] getSocketSignature(C0639b bVar, int i, int i2) {
        byte[] bArr = new byte[(bVar.f1701a + 11)];
        int a = C0459f.m1675a(i, bArr, 0);
        int a2 = a + C0459f.m1675a(i2, bArr, a);
        int b = a2 + C0459f.m1685b((short) bVar.f1701a, bArr, a2);
        int c = b + C0459f.m1689c(bVar.f1702b, bArr, b);
        int a3 = c + C0459f.m1678a(bVar.f1705e, 0, bArr, c, bVar.f1701a);
        return sha1(bArr);
    }

    public static String getVersion() {
        byte[] k = SecurityUtils.m4661k();
        if (k != null) {
            return new String(k);
        }
        return null;
    }

    public static byte[] initHttpAESKey() {
        return SecurityUtils.m4651a();
    }

    public static byte[] initSocketAESKey() {
        return SecurityUtils.m4655e();
    }

    public static boolean isLoadSuccess() {
        return f3014b;
    }

    public static byte[] md5(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            return instance.digest();
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean reset() {
        try {
            if (SecurityUtils.f2988b) {
                f3016d = initSocketAESKey();
                f3017e = initHttpAESKey();
                f3014b = (f3016d == null || f3017e == null || getSocketAESKey() == null || getHttpAESKey() == null || getRSAKeyId() == null || getVersion() == null) ? false : true;
            }
        } catch (Throwable th) {
            ActivityC0460a.m1698b(f3013a + "|load so error = " + th.toString());
            f3014b = false;
        }
        if (!f3014b) {
            ActivityC0460a.m1698b(f3013a + "|load so error ++++++++");
        } else {
            ActivityC0460a.m1698b(f3013a + "|load so success ~~~~~~~");
        }
        return f3014b;
    }

    public static byte[] rsaEnc(byte[] bArr) {
        int length = bArr.length;
        if (length <= 214) {
            return SecurityUtils.m4659i(bArr);
        }
        int i = length % GCloudVoiceErrno.GCLOUD_VOICE_PERMISSION_MIC == 0 ? length / GCloudVoiceErrno.GCLOUD_VOICE_PERMISSION_MIC : (length / GCloudVoiceErrno.GCLOUD_VOICE_PERMISSION_MIC) + 1;
        byte[] bArr2 = new byte[(i * 256)];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = i2 < i + -1 ? GCloudVoiceErrno.GCLOUD_VOICE_PERMISSION_MIC : length - (i2 * GCloudVoiceErrno.GCLOUD_VOICE_PERMISSION_MIC);
            byte[] bArr3 = new byte[i4];
            C0459f.m1678a(bArr, i2 * GCloudVoiceErrno.GCLOUD_VOICE_PERMISSION_MIC, bArr3, 0, i4);
            byte[] i5 = SecurityUtils.m4659i(bArr3);
            i3 += C0459f.m1678a(i5, 0, bArr2, i3, i5.length);
            i2++;
        }
        return bArr2;
    }

    public static byte[] sha1(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-1").digest(bArr);
        } catch (Exception e) {
            return null;
        }
    }
}
