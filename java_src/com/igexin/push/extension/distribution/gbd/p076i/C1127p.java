package com.igexin.push.extension.distribution.gbd.p076i;

import java.io.File;
import java.io.FileFilter;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.gbd.i.p */
public final class C1127p implements FileFilter {
    C1127p() {
    }

    public boolean accept(File file) {
        try {
            return file.isDirectory() && Integer.parseInt(file.getName()) >= 2000;
        } catch (Exception e) {
            return false;
        }
    }
}
