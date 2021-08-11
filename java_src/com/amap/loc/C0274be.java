package com.amap.loc;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* renamed from: com.amap.loc.be */
/* compiled from: Util */
public final class C0274be {

    /* renamed from: a */
    public static final Charset f445a = Charset.forName("US-ASCII");

    /* renamed from: b */
    static final Charset f446b = Charset.forName("UTF-8");

    /* renamed from: a */
    static void m717a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: a */
    static void m718a(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                m718a(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }
}
