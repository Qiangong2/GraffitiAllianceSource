package com.xiaomi.smack.util;

import android.text.TextUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.xiaomi.channel.commonutils.string.C1870a;
import java.util.Random;

/* renamed from: com.xiaomi.smack.util.g */
public class C2045g {

    /* renamed from: a */
    private static final char[] f5458a = "&quot;".toCharArray();

    /* renamed from: b */
    private static final char[] f5459b = "&apos;".toCharArray();

    /* renamed from: c */
    private static final char[] f5460c = "&amp;".toCharArray();

    /* renamed from: d */
    private static final char[] f5461d = "&lt;".toCharArray();

    /* renamed from: e */
    private static final char[] f5462e = "&gt;".toCharArray();

    /* renamed from: f */
    private static Random f5463f = new Random();

    /* renamed from: g */
    private static char[] f5464g = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /* renamed from: a */
    public static String m7699a(int i) {
        if (i < 1) {
            return null;
        }
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < cArr.length; i2++) {
            cArr[i2] = f5464g[f5463f.nextInt(71)];
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public static String m7700a(String str) {
        int i = 0;
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        StringBuilder sb = new StringBuilder((int) (((double) length) * 1.3d));
        int i2 = 0;
        while (i2 < length) {
            char c = charArray[i2];
            if (c <= '>') {
                if (c == '<') {
                    if (i2 > i) {
                        sb.append(charArray, i, i2 - i);
                    }
                    i = i2 + 1;
                    sb.append(f5461d);
                } else if (c == '>') {
                    if (i2 > i) {
                        sb.append(charArray, i, i2 - i);
                    }
                    i = i2 + 1;
                    sb.append(f5462e);
                } else if (c == '&') {
                    if (i2 > i) {
                        sb.append(charArray, i, i2 - i);
                    }
                    if (length <= i2 + 5 || charArray[i2 + 1] != '#' || !Character.isDigit(charArray[i2 + 2]) || !Character.isDigit(charArray[i2 + 3]) || !Character.isDigit(charArray[i2 + 4]) || charArray[i2 + 5] != ';') {
                        i = i2 + 1;
                        sb.append(f5460c);
                    }
                } else if (c == '\"') {
                    if (i2 > i) {
                        sb.append(charArray, i, i2 - i);
                    }
                    i = i2 + 1;
                    sb.append(f5458a);
                } else if (c == '\'') {
                    if (i2 > i) {
                        sb.append(charArray, i, i2 - i);
                    }
                    i = i2 + 1;
                    sb.append(f5459b);
                }
            }
            i2++;
        }
        if (i == 0) {
            return str;
        }
        if (i2 > i) {
            sb.append(charArray, i, i2 - i);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static final String m7701a(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(str2, 0);
        if (indexOf < 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        char[] charArray2 = str3.toCharArray();
        int length = str2.length();
        StringBuilder sb = new StringBuilder(charArray.length);
        sb.append(charArray, 0, indexOf).append(charArray2);
        int i = indexOf + length;
        while (true) {
            int indexOf2 = str.indexOf(str2, i);
            if (indexOf2 > 0) {
                sb.append(charArray, i, indexOf2 - i).append(charArray2);
                i = indexOf2 + length;
            } else {
                sb.append(charArray, i, charArray.length - i);
                return sb.toString();
            }
        }
    }

    /* renamed from: a */
    public static String m7702a(byte[] bArr) {
        return String.valueOf(C1870a.m6774a(bArr));
    }

    /* renamed from: a */
    public static boolean m7703a(char c) {
        return (c >= ' ' && c <= 55295) || (c >= 57344 && c <= 65533) || ((c >= 0 && c <= 65535) || c == '\t' || c == '\n' || c == '\r');
    }

    /* renamed from: b */
    public static final String m7704b(String str) {
        return m7701a(m7701a(m7701a(m7701a(m7701a(str, "&lt;", SimpleComparison.LESS_THAN_OPERATION), "&gt;", SimpleComparison.GREATER_THAN_OPERATION), "&quot;", "\""), "&apos;", "'"), "&amp;", "&");
    }

    /* renamed from: c */
    public static String m7705c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (m7703a(charAt)) {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }
}
