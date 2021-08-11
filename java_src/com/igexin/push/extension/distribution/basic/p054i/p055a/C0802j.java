package com.igexin.push.extension.distribution.basic.p054i.p055a;

import java.util.Collection;
import java.util.Iterator;

/* renamed from: com.igexin.push.extension.distribution.basic.i.a.j */
public final class C0802j {

    /* renamed from: a */
    private static final String[] f2264a = {"", " ", "  ", "   ", "    ", "     ", "      ", "       ", "        ", "         ", "          "};

    /* renamed from: a */
    public static String m3385a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("width must be > 0");
        } else if (i < f2264a.length) {
            return f2264a[i];
        } else {
            char[] cArr = new char[i];
            for (int i2 = 0; i2 < i; i2++) {
                cArr[i2] = ' ';
            }
            return String.valueOf(cArr);
        }
    }

    /* renamed from: a */
    public static String m3386a(Collection collection, String str) {
        return m3387a(collection.iterator(), str);
    }

    /* renamed from: a */
    public static String m3387a(Iterator it, String str) {
        if (!it.hasNext()) {
            return "";
        }
        String obj = it.next().toString();
        if (!it.hasNext()) {
            return obj;
        }
        StringBuilder append = new StringBuilder(64).append(obj);
        while (it.hasNext()) {
            append.append(str);
            append.append(it.next());
        }
        return append.toString();
    }

    /* renamed from: a */
    public static boolean m3388a(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!m3390b(str.codePointAt(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m3389a(String str, String... strArr) {
        for (String str2 : strArr) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m3390b(int i) {
        return i == 32 || i == 9 || i == 10 || i == 12 || i == 13;
    }

    /* renamed from: b */
    public static boolean m3391b(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(str.codePointAt(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    public static String m3392c(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < length; i++) {
            int codePointAt = str.codePointAt(i);
            if (!m3390b(codePointAt)) {
                sb.appendCodePoint(codePointAt);
                z2 = false;
            } else if (z2) {
                z = true;
            } else {
                if (codePointAt != 32) {
                    z = true;
                }
                sb.append(' ');
                z2 = true;
            }
        }
        return z ? sb.toString() : str;
    }
}
