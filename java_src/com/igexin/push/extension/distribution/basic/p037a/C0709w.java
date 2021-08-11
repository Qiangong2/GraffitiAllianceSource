package com.igexin.push.extension.distribution.basic.p037a;

import android.net.wifi.ScanResult;
import java.util.Comparator;

/* renamed from: com.igexin.push.extension.distribution.basic.a.w */
class C0709w implements Comparator<ScanResult> {

    /* renamed from: a */
    final /* synthetic */ C0708v f1890a;

    C0709w(C0708v vVar) {
        this.f1890a = vVar;
    }

    /* renamed from: a */
    public int compare(ScanResult scanResult, ScanResult scanResult2) {
        return scanResult2.level - scanResult.level;
    }
}
