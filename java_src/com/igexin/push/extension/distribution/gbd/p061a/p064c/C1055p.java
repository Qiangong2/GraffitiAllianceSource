package com.igexin.push.extension.distribution.gbd.p061a.p064c;

import android.net.wifi.ScanResult;
import java.util.Comparator;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.gbd.a.c.p */
public class C1055p implements Comparator<ScanResult> {

    /* renamed from: a */
    final /* synthetic */ C1054o f2715a;

    C1055p(C1054o oVar) {
        this.f2715a = oVar;
    }

    /* renamed from: a */
    public int compare(ScanResult scanResult, ScanResult scanResult2) {
        return scanResult2.level - scanResult.level;
    }
}
