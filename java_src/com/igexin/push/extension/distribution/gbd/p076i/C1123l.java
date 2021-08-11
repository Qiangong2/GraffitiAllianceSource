package com.igexin.push.extension.distribution.gbd.p076i;

import java.io.File;
import java.io.FilenameFilter;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.gbd.i.l */
public final class C1123l implements FilenameFilter {

    /* renamed from: a */
    final /* synthetic */ String f2980a;

    C1123l(String str) {
        this.f2980a = str;
    }

    public boolean accept(File file, String str) {
        return str.contains(this.f2980a) && str.endsWith(".db");
    }
}
