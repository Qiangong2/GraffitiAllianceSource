package com.tencent.cos.xml.utils;

import p000a.p001a.p002a.p004b.C0027o;

public class StringUtils {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String toHexString(byte[] data) {
        StringBuilder result = new StringBuilder(data.length * 2);
        for (byte b : data) {
            result.append(HEX_DIGITS[(b & 240) >>> 4]);
            result.append(HEX_DIGITS[b & C0027o.f104m]);
        }
        return result.toString();
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
}
