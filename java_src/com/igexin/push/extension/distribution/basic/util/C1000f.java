package com.igexin.push.extension.distribution.basic.util;

import android.os.Build;

/* renamed from: com.igexin.push.extension.distribution.basic.util.f */
public class C1000f {

    /* renamed from: a */
    private static C0998d f2544a = null;

    /* renamed from: a */
    public static boolean m4019a() {
        try {
            String a = m4028j().mo5647a("ro.build.user", null);
            return a != null && a.trim().equals("flyme");
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    public static boolean m4020b() {
        try {
            return m4028j().mo5647a("ro.letv.eui", null) != null;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: c */
    public static boolean m4021c() {
        try {
            C0998d j = m4028j();
            return (j.mo5647a("ro.miui.ui.version.code", null) == null && j.mo5647a("ro.miui.ui.version.name", null) == null && j.mo5647a("ro.miui.internal.storage", null) == null) ? false : true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: d */
    public static boolean m4022d() {
        try {
            C0998d j = m4028j();
            String a = j.mo5647a("ro.product.manufacturer", null);
            return (a != null && a.trim().equals("HUAWEI")) || j.mo5647a("ro.build.version.emui", null) != null;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: e */
    public static boolean m4023e() {
        try {
            String a = m4028j().mo5647a("ro.product.manufacturer", null);
            return a != null && a.trim().equals("samsung") && Build.VERSION.SDK_INT >= 22;
        } catch (Exception e) {
        }
    }

    /* renamed from: f */
    public static boolean m4024f() {
        try {
            return m4028j().mo5647a("ro.build.version.opporom", null) != null;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: g */
    public static boolean m4025g() {
        try {
            return m4028j().mo5647a("ro.vivo.os.version", null) != null;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: h */
    public static boolean m4026h() {
        try {
            String a = m4028j().mo5647a("ro.build.user", null);
            return a != null && a.trim().equals("smartcm");
        } catch (Throwable th) {
        }
    }

    /* renamed from: i */
    public static boolean m4027i() {
        try {
            String a = m4028j().mo5647a("ro.product.manufacturer", null);
            return a != null && a.trim().equals("nubia");
        } catch (Throwable th) {
        }
    }

    /* renamed from: j */
    private static C0998d m4028j() {
        try {
            if (f2544a == null) {
                f2544a = C0998d.m4014a();
            }
        } catch (Exception e) {
        }
        return f2544a;
    }
}
