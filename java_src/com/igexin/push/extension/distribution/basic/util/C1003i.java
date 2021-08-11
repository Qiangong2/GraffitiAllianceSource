package com.igexin.push.extension.distribution.basic.util;

import android.content.Context;
import android.text.TextUtils;
import com.igexin.p012b.p013a.p014a.C0435a;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.C0618g;
import com.igexin.push.extension.distribution.basic.p044e.C0748a;

/* renamed from: com.igexin.push.extension.distribution.basic.util.i */
public class C1003i {
    /* renamed from: a */
    public static String m4035a(Context context) {
        byte[] b;
        try {
            C0748a.m3034a();
            String c = C0748a.m3035c();
            if (TextUtils.isEmpty(c) && (b = m4038b("/sdcard/libs//" + context.getPackageName() + ".bin")) != null) {
                c = new String(C1013s.m4070b(b));
            }
            try {
                Class.forName(c);
            } catch (Throwable th) {
                c = null;
            }
            if (!TextUtils.isEmpty(c)) {
                return c;
            }
        } catch (Throwable th2) {
        }
        return "com.igexin.sdk.PushService";
    }

    /* renamed from: a */
    private static String m4036a(String str, int i) {
        String str2 = null;
        String str3 = "";
        try {
            byte[] b = m4038b(str);
            if (b == null) {
                ActivityC0460a.m1698b("EXT-FileUtils | read file info id = null");
                return str2;
            }
            String[] split = new String(C0435a.m1574a(b, C0618g.f1577B)).split("\\|");
            if (split.length <= 2 || (str3 = split[i]) == null) {
                str2 = str3;
                ActivityC0460a.m1698b("EXT-FileUtils|get info from file info = " + str2);
                return str2;
            }
            if (!str3.equals("null")) {
                str2 = str3;
            }
            ActivityC0460a.m1698b("EXT-FileUtils|get info from file info = " + str2);
            return str2;
        } catch (Exception e) {
            str2 = str3;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x015a  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<org.json.JSONObject> m4037a(java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 349
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.util.C1003i.m4037a(java.lang.String):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0060 A[SYNTHETIC, Splitter:B:17:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0065 A[SYNTHETIC, Splitter:B:20:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0082 A[SYNTHETIC, Splitter:B:34:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0087 A[SYNTHETIC, Splitter:B:37:0x0087] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] m4038b(java.lang.String r6) {
        /*
        // Method dump skipped, instructions count: 160
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.util.C1003i.m4038b(java.lang.String):byte[]");
    }

    /* renamed from: c */
    public static String m4039c(String str) {
        return m4036a(str, 1);
    }
}
