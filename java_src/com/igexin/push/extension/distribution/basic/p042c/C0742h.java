package com.igexin.push.extension.distribution.basic.p042c;

import java.io.File;
import java.io.FileFilter;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.basic.c.h */
public class C0742h implements FileFilter {

    /* renamed from: a */
    long f2038a = System.currentTimeMillis();

    /* renamed from: b */
    long f2039b = 604800000;

    /* renamed from: c */
    final /* synthetic */ C0741g f2040c;

    C0742h(C0741g gVar) {
        this.f2040c = gVar;
    }

    public boolean accept(File file) {
        return this.f2038a - file.lastModified() >= this.f2039b;
    }
}
