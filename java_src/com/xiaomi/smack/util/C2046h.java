package com.xiaomi.smack.util;

import android.content.Context;
import android.util.Base64;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.push.service.C1968f;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.xiaomi.smack.util.h */
public class C2046h {

    /* renamed from: a */
    private static Context f5465a;

    /* renamed from: b */
    private static String f5466b;

    /* renamed from: a */
    public static Context m7706a() {
        return f5465a;
    }

    /* renamed from: a */
    public static void m7707a(Context context) {
        f5465a = context;
    }

    /* renamed from: b */
    public static String m7708b() {
        String b;
        if (f5466b == null && (b = C1968f.m7323b(f5465a)) != null) {
            try {
                f5466b = Base64.encodeToString(MessageDigest.getInstance("SHA1").digest(b.getBytes()), 8).substring(0, 16);
            } catch (NoSuchAlgorithmException e) {
                AbstractC1855b.m6720a(e);
            }
        }
        return f5466b;
    }
}
