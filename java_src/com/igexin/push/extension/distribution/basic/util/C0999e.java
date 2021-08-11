package com.igexin.push.extension.distribution.basic.util;

import android.os.Build;
import com.igexin.push.core.C0618g;

/* renamed from: com.igexin.push.extension.distribution.basic.util.e */
public class C0999e {
    /* renamed from: a */
    public static boolean m4016a() {
        return Build.VERSION.SDK_INT >= 21 && m4018c() >= 21;
    }

    /* renamed from: b */
    public static boolean m4017b() {
        return !C1000f.m4019a() && !C1000f.m4021c() && !C1000f.m4022d() && !C1000f.m4023e() && !C1000f.m4024f() && !C1000f.m4025g() && !C1000f.m4020b() && !C1000f.m4027i();
    }

    /* renamed from: c */
    private static int m4018c() {
        try {
            return C0618g.f1635f.getPackageManager().getPackageInfo(C0618g.f1635f.getPackageName(), 0).applicationInfo.targetSdkVersion;
        } catch (Exception e) {
            return 0;
        }
    }
}
