package com.igexin.p010a;

import java.io.File;
import java.io.FilenameFilter;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.a.i */
public class C0424i implements FilenameFilter {

    /* renamed from: a */
    final /* synthetic */ String f1009a;

    /* renamed from: b */
    final /* synthetic */ C0423h f1010b;

    C0424i(C0423h hVar, String str) {
        this.f1010b = hVar;
        this.f1009a = str;
    }

    public boolean accept(File file, String str) {
        return str.startsWith(this.f1009a);
    }
}
