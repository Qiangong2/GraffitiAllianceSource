package com.xiaomi.channel.commonutils.file;

import java.io.File;
import java.io.FileFilter;

/* renamed from: com.xiaomi.channel.commonutils.file.b */
final class C1852b implements FileFilter {
    C1852b() {
    }

    public boolean accept(File file) {
        return file.isDirectory();
    }
}
