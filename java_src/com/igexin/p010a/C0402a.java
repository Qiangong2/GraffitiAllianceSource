package com.igexin.p010a;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.igexin.a.a */
public class C0402a implements AbstractC0419d {
    /* renamed from: a */
    private long m1502a(InputStream inputStream, OutputStream outputStream) {
        long j = 0;
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                outputStream.flush();
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    /* renamed from: a */
    private void m1503a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0086 A[SYNTHETIC, Splitter:B:34:0x0086] */
    @Override // com.igexin.p010a.AbstractC0419d
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo4062a(android.content.Context r14, java.lang.String[] r15, java.lang.String r16, java.io.File r17, com.igexin.p010a.C0423h r18) {
        /*
        // Method dump skipped, instructions count: 346
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.p010a.C0402a.mo4062a(android.content.Context, java.lang.String[], java.lang.String, java.io.File, com.igexin.a.h):void");
    }
}
