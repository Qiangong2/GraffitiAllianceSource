package com.wanmei.sdk.core.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

/* renamed from: com.wanmei.sdk.core.util.f */
public class C1845f {

    /* renamed from: a */
    public static final char f4595a = File.separatorChar;

    /* renamed from: b */
    public static final String f4596b;

    static {
        C1847h hVar = new C1847h((byte) 0);
        PrintWriter printWriter = new PrintWriter(hVar);
        printWriter.println();
        f4596b = hVar.toString();
        printWriter.close();
    }

    /* renamed from: a */
    private static long m6691a(Reader reader, Writer writer) throws IOException {
        char[] cArr = new char[4096];
        long j = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return j;
            }
            writer.write(cArr, 0, read);
            j += (long) read;
        }
    }

    /* renamed from: a */
    public static byte[] m6692a(InputStream inputStream) throws IOException {
        C1842c cVar = new C1842c();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return cVar.mo9913a();
            }
            cVar.write(bArr, 0, read);
        }
    }

    /* renamed from: b */
    public static String m6693b(InputStream inputStream) throws IOException {
        C1847h hVar = new C1847h();
        m6691a(new InputStreamReader(inputStream), hVar);
        return hVar.toString();
    }
}
