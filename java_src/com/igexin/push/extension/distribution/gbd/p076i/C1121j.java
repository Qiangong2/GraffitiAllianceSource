package com.igexin.push.extension.distribution.gbd.p076i;

import java.io.File;
import java.io.FilenameFilter;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.gbd.i.j */
public final class C1121j implements FilenameFilter {

    /* renamed from: a */
    final /* synthetic */ String f2979a;

    C1121j(String str) {
        this.f2979a = str;
    }

    public boolean accept(File file, String str) {
        return str.contains(this.f2979a) && str.endsWith(".db");
    }
}
