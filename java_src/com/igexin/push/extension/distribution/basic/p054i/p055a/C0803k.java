package com.igexin.push.extension.distribution.basic.p054i.p055a;

/* renamed from: com.igexin.push.extension.distribution.basic.i.a.k */
public final class C0803k {
    /* renamed from: a */
    public static void m3393a(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object must not be null");
        }
    }

    /* renamed from: a */
    public static void m3394a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    /* renamed from: a */
    public static void m3395a(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("String must not be empty");
        }
    }

    /* renamed from: a */
    public static void m3396a(String str, String str2) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException(str2);
        }
    }

    /* renamed from: a */
    public static void m3397a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException("Must be true");
        }
    }

    /* renamed from: a */
    public static void m3398a(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    /* renamed from: a */
    public static void m3399a(Object[] objArr) {
        m3400a(objArr, "Array must not contain any null objects");
    }

    /* renamed from: a */
    public static void m3400a(Object[] objArr, String str) {
        for (Object obj : objArr) {
            if (obj == null) {
                throw new IllegalArgumentException(str);
            }
        }
    }

    /* renamed from: b */
    public static void m3401b(String str) {
        throw new IllegalArgumentException(str);
    }

    /* renamed from: b */
    public static void m3402b(boolean z) {
        if (z) {
            throw new IllegalArgumentException("Must be false");
        }
    }

    /* renamed from: b */
    public static void m3403b(boolean z, String str) {
        if (z) {
            throw new IllegalArgumentException(str);
        }
    }
}
