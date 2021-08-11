package com.igexin.push.extension.distribution.gbd.p076i;

import java.io.File;
import java.io.FilenameFilter;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.gbd.i.i */
public final class C1120i implements FilenameFilter {
    C1120i() {
    }

    public boolean accept(File file, String str) {
        return str.endsWith(".bin");
    }
}
