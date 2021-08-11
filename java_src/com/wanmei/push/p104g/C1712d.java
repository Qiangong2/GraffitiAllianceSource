package com.wanmei.push.p104g;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

/* renamed from: com.wanmei.push.g.d */
public final class C1712d {

    /* renamed from: a */
    public static final char f4351a = File.separatorChar;

    /* renamed from: b */
    public static final String f4352b;

    static {
        C1718j jVar = new C1718j((byte) 0);
        PrintWriter printWriter = new PrintWriter(jVar);
        printWriter.println();
        f4352b = jVar.toString();
        printWriter.close();
    }

    /* renamed from: a */
    private static long m6372a(Reader reader, Writer writer) throws IOException {
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
    public static byte[] m6373a(InputStream inputStream) throws IOException {
        C1709a aVar = new C1709a();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return aVar.mo9374a();
            }
            aVar.write(bArr, 0, read);
        }
    }

    /* renamed from: b */
    public static String m6374b(InputStream inputStream) throws IOException {
        C1718j jVar = new C1718j();
        m6372a(new InputStreamReader(inputStream), jVar);
        return jVar.toString();
    }
}
