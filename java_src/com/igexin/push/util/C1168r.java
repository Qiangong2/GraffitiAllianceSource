package com.igexin.push.util;

import java.util.Random;

/* renamed from: com.igexin.push.util.r */
public class C1168r {

    /* renamed from: a */
    private static char[] f3045a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz`~!@#$%^&*()-_=+[{}];:'/?.>,<".toCharArray();

    /* renamed from: a */
    public static long m4794a() {
        return ((long) (new Random().nextInt(6) + 2)) * 60000;
    }

    /* renamed from: a */
    public static String m4795a(int i) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(random.nextInt("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".length())));
        }
        return sb.toString();
    }
}
