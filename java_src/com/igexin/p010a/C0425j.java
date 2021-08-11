package com.igexin.p010a;

import android.os.Build;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.a.j */
public final class C0425j implements AbstractC0420e {
    C0425j() {
    }

    @Override // com.igexin.p010a.AbstractC0420e
    /* renamed from: a */
    public void mo4075a(String str) {
        System.loadLibrary(str);
    }

    @Override // com.igexin.p010a.AbstractC0420e
    /* renamed from: a */
    public String[] mo4076a() {
        if (Build.VERSION.SDK_INT >= 21 && Build.SUPPORTED_ABIS.length > 0) {
            return Build.SUPPORTED_ABIS;
        }
        return new String[]{Build.CPU_ABI};
    }

    @Override // com.igexin.p010a.AbstractC0420e
    /* renamed from: b */
    public void mo4077b(String str) {
        System.load(str);
    }

    @Override // com.igexin.p010a.AbstractC0420e
    /* renamed from: c */
    public String mo4078c(String str) {
        return (!str.startsWith("lib") || !str.endsWith(".so")) ? System.mapLibraryName(str) : str;
    }

    @Override // com.igexin.p010a.AbstractC0420e
    /* renamed from: d */
    public String mo4079d(String str) {
        return str.substring(3, str.length() - 3);
    }
}
