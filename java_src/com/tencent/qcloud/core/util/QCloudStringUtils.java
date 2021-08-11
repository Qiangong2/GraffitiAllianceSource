package com.tencent.qcloud.core.util;

import java.nio.charset.Charset;

public class QCloudStringUtils {
    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0015 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean equals(java.lang.CharSequence r6, java.lang.CharSequence r7) {
        /*
            r1 = 0
            if (r6 == r7) goto L_0x0015
            if (r6 == 0) goto L_0x0016
            if (r7 == 0) goto L_0x0016
            boolean r0 = r6 instanceof java.lang.String
            if (r0 == 0) goto L_0x0017
            boolean r0 = r7 instanceof java.lang.String
            if (r0 == 0) goto L_0x0017
            boolean r0 = r6.equals(r7)
            if (r0 == 0) goto L_0x0016
        L_0x0015:
            r1 = 1
        L_0x0016:
            return r1
        L_0x0017:
            int r0 = r6.length()
            int r2 = r7.length()
            int r5 = java.lang.Math.max(r0, r2)
            r0 = r6
            r2 = r1
            r3 = r7
            r4 = r1
            boolean r0 = regionMatches(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0016
            goto L_0x0015
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.core.util.QCloudStringUtils.equals(java.lang.CharSequence, java.lang.CharSequence):boolean");
    }

    public static byte[] getBytesUTF8(String string) {
        return string.getBytes(Charset.forName("UTF-8"));
    }

    public static String newStringUTF8(byte[] bytes) {
        return new String(bytes, Charset.forName("UTF-8"));
    }

    static boolean regionMatches(CharSequence cs, boolean ignoreCase, int thisStart, CharSequence substring, int start, int length) {
        if ((cs instanceof String) && (substring instanceof String)) {
            return ((String) cs).regionMatches(ignoreCase, thisStart, (String) substring, start, length);
        }
        int index1 = thisStart;
        int index2 = start;
        int tmpLen = length;
        while (true) {
            tmpLen--;
            if (tmpLen <= 0) {
                return true;
            }
            index1++;
            char c1 = cs.charAt(index1);
            index2++;
            char c2 = substring.charAt(index2);
            if (c1 != c2) {
                if (!ignoreCase) {
                    return false;
                }
                if (!(Character.toUpperCase(c1) == Character.toUpperCase(c2) || Character.toLowerCase(c1) == Character.toLowerCase(c2))) {
                    return false;
                }
            }
        }
    }
}
