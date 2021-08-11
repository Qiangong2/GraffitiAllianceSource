package com.igexin.push.extension.mod;

import com.igexin.p010a.C0418c;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.sdk.GTServiceManager;

public class SecurityUtils {

    /* renamed from: a */
    public static final String f2987a = SecurityUtils.class.getName();

    /* renamed from: b */
    public static boolean f2988b;

    /* renamed from: c */
    public static String f2989c;

    static {
        f2989c = "";
        try {
            ActivityC0460a.m1698b(f2987a + "|load so by system start #######");
            System.loadLibrary("getuiext2");
            f2988b = true;
            ActivityC0460a.m1698b(f2987a + "|load so by system success ^_^");
        } catch (UnsatisfiedLinkError e) {
            ActivityC0460a.m1698b(f2987a + "|load so by system error = " + e.toString());
            f2989c = e.getMessage() + " + ";
            ActivityC0460a.m1698b(f2987a + "|load so by new start !!");
            if (GTServiceManager.context == null) {
                ActivityC0460a.m1698b(f2987a + "|load so by new context = null ~~~~");
                f2988b = false;
                f2989c = e.getMessage();
                return;
            }
            C0418c.m1523a(null).mo4083a().mo4091b().mo4088a(GTServiceManager.context, "getuiext2", null, new C1136a());
        } catch (Throwable th) {
            ActivityC0460a.m1698b(f2987a + "|load so error not UnsatisfiedLinkError");
            ActivityC0460a.m1698b(f2987a + "|load so error e = " + th.toString());
            f2988b = false;
            f2989c += th.toString() + " + " + th.getMessage();
        }
    }

    /* renamed from: a */
    public static native byte[] m4651a();

    /* renamed from: b */
    public static native byte[] m4652b(byte[] bArr, byte[] bArr2, byte[] bArr3);

    /* renamed from: c */
    public static native byte[] m4653c(byte[] bArr, byte[] bArr2, byte[] bArr3);

    /* renamed from: d */
    public static native byte[] m4654d(byte[] bArr);

    /* renamed from: e */
    public static native byte[] m4655e();

    /* renamed from: f */
    public static native byte[] m4656f(byte[] bArr, byte[] bArr2, byte[] bArr3);

    /* renamed from: g */
    public static native byte[] m4657g(byte[] bArr, byte[] bArr2, byte[] bArr3);

    /* renamed from: h */
    public static native byte[] m4658h(byte[] bArr);

    /* renamed from: i */
    public static native byte[] m4659i(byte[] bArr);

    /* renamed from: j */
    public static native byte[] m4660j();

    /* renamed from: k */
    public static native byte[] m4661k();

    /* renamed from: l */
    public static native byte[] m4662l(byte[] bArr, byte[] bArr2);

    /* renamed from: m */
    public static native byte[] m4663m(byte[] bArr, byte[] bArr2);
}
