package com.igexin.push.extension.distribution.basic.p037a;

import android.content.pm.PackageInfo;
import java.util.Comparator;

/* renamed from: com.igexin.push.extension.distribution.basic.a.m */
final class C0699m implements Comparator<PackageInfo> {
    C0699m() {
    }

    /* renamed from: a */
    public int compare(PackageInfo packageInfo, PackageInfo packageInfo2) {
        if (packageInfo.firstInstallTime - packageInfo2.firstInstallTime > 0) {
            return 1;
        }
        return packageInfo.firstInstallTime - packageInfo2.firstInstallTime < 0 ? -1 : 0;
    }
}
