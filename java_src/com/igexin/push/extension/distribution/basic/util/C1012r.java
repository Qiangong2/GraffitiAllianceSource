package com.igexin.push.extension.distribution.basic.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import java.security.MessageDigest;
import p000a.p001a.p002a.p004b.C0027o;

/* renamed from: com.igexin.push.extension.distribution.basic.util.r */
public class C1012r {

    /* renamed from: a */
    private static final char[] f2566a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: a */
    public static String m4066a(Context context, String str) {
        if (C1013s.m4071c(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(packageInfo.signatures[0].toByteArray());
            byte[] digest = instance.digest();
            char[] cArr = new char[32];
            int i = 0;
            for (int i2 = 0; i2 < 16; i2++) {
                byte b = digest[i2];
                int i3 = i + 1;
                cArr[i] = f2566a[(b >>> 4) & 15];
                i = i3 + 1;
                cArr[i3] = f2566a[b & C0027o.f104m];
            }
            return new String(cArr);
        } catch (Exception e) {
            return "";
        }
    }
}
