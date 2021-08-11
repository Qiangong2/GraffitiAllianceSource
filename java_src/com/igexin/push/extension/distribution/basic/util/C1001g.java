package com.igexin.push.extension.distribution.basic.util;

import java.util.regex.Pattern;

/* renamed from: com.igexin.push.extension.distribution.basic.util.g */
public class C1001g {
    /* renamed from: a */
    public static int m4029a(String str, String str2) {
        try {
            Pattern compile = Pattern.compile("([a-zA-Z_-])*");
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            if (split == null || split.length < 4 || split2 == null || split2.length < 4) {
                return -1;
            }
            split[3] = compile.matcher(split[3]).replaceAll("");
            split2[3] = compile.matcher(split2[3]).replaceAll("");
            long j = 0;
            long j2 = 0;
            long j3 = 1;
            for (int i = 0; i < 4; i++) {
                for (int i2 = 0; i2 < 3 - i; i2++) {
                    j3 *= 100;
                }
                j += j3 * Long.parseLong(split[i]);
                j3 = 1;
            }
            for (int i3 = 0; i3 < 4; i3++) {
                for (int i4 = 0; i4 < 3 - i3; i4++) {
                    j3 *= 100;
                }
                j2 += j3 * Long.parseLong(split2[i3]);
                j3 = 1;
            }
            if (j > j2) {
                return 1;
            }
            return j == j2 ? 0 : -1;
        } catch (Exception e) {
            return -1;
        }
    }
}
