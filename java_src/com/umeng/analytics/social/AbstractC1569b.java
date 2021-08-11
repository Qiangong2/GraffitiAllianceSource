package com.umeng.analytics.social;

import com.tencent.qcloud.core.util.IOUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* renamed from: com.umeng.analytics.social.b */
/* compiled from: UMNetwork */
public abstract class AbstractC1569b {
    /* JADX WARNING: Removed duplicated region for block: B:32:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0142  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static java.lang.String m6015a(java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 337
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.social.AbstractC1569b.m6015a(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    private static String m6014a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 8192);
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine + IOUtils.LINE_SEPARATOR_UNIX);
                } else {
                    try {
                        inputStream.close();
                        return sb.toString();
                    } catch (IOException e) {
                        return null;
                    }
                }
            } catch (IOException e2) {
                try {
                    inputStream.close();
                    return null;
                } catch (IOException e3) {
                    return null;
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                    throw th;
                } catch (IOException e4) {
                    return null;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x013b  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static java.lang.String m6016a(java.lang.String r8, java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 328
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.social.AbstractC1569b.m6016a(java.lang.String, java.lang.String):java.lang.String");
    }
}
