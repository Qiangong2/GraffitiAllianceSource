package com.wanmei.sdk.core.util;

import java.io.File;

/* renamed from: com.wanmei.sdk.core.util.e */
public class C1844e {

    /* renamed from: a */
    public static String f4594a = "";

    /* renamed from: a */
    public static void m6690a(File file) {
        if (file != null) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        m6690a(file2);
                    } else {
                        file2.delete();
                    }
                }
                file.delete();
            }
        }
    }
}
