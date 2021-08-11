package com.wanmei.push.p102e;

import com.tencent.qcloud.core.http.HttpConstants;
import com.tencent.qcloud.core.util.IOUtils;
import com.wanmei.push.p104g.C1712d;
import com.wanmei.push.p104g.C1714f;
import com.wanmei.push.p104g.C1719k;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.UUID;
import java.util.zip.GZIPInputStream;

/* renamed from: com.wanmei.push.e.c */
public final class C1698c {

    /* renamed from: a */
    private static final byte[] f4313a = new byte[0];

    /* renamed from: b */
    private static String f4314b = UUID.randomUUID().toString();

    /* renamed from: c */
    private static String f4315c = "--";

    /* renamed from: d */
    private static String f4316d = IOUtils.LINE_SEPARATOR_WINDOWS;

    /* renamed from: e */
    private static String f4317e = HttpConstants.ContentType.MULTIPART_FORM_DATA;

    /* renamed from: f */
    private static String f4318f = "image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, application/x-shockwave-flash, application/x-quickviewplus, */*";

    /* renamed from: g */
    private static AbstractC1701a f4319g;

    /* renamed from: com.wanmei.push.e.c$a */
    public interface AbstractC1701a {
        /* renamed from: a */
        boolean mo9352a() throws IOException;
    }

    /* renamed from: a */
    private static String m6334a(HttpURLConnection httpURLConnection) {
        String str = null;
        InputStream errorStream = httpURLConnection.getErrorStream();
        if (errorStream != null) {
            try {
                str = C1712d.m6374b(errorStream);
            } catch (IOException e) {
                str = "";
                if (errorStream != null) {
                    try {
                        errorStream.close();
                    } catch (IOException e2) {
                    }
                }
            } catch (Throwable th) {
                if (errorStream != null) {
                    try {
                        errorStream.close();
                    } catch (IOException e3) {
                    }
                }
                throw th;
            }
        }
        if (errorStream != null) {
            try {
                errorStream.close();
            } catch (IOException e4) {
            }
        }
        return str;
    }

    /* renamed from: b */
    private byte[] m6335b(C1702d dVar) {
        try {
            InputStream d = m6337d(dVar);
            if (d == null) {
                return f4313a;
            }
            byte[] a = C1712d.m6373a(d);
            d.close();
            if (a.length != 0) {
                return a;
            }
            return f4313a;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x024b  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.net.HttpURLConnection m6336c(com.wanmei.push.p102e.C1702d r11) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 748
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wanmei.push.p102e.C1698c.m6336c(com.wanmei.push.e.d):java.net.HttpURLConnection");
    }

    /* renamed from: d */
    private InputStream m6337d(C1702d dVar) {
        HttpURLConnection httpURLConnection;
        try {
            httpURLConnection = m6336c(dVar);
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    dVar.mo9358b(httpURLConnection.getContentType());
                    String contentEncoding = httpURLConnection.getContentEncoding();
                    InputStream inputStream = (C1719k.m6394a(contentEncoding) || !contentEncoding.equals("gzip")) ? httpURLConnection.getInputStream() : new GZIPInputStream(httpURLConnection.getInputStream());
                    if (inputStream != null) {
                        return inputStream;
                    }
                } else if (responseCode == 301 || responseCode == 302) {
                    if (dVar != null) {
                        dVar.mo9355a(httpURLConnection.getHeaderField("location"));
                        return m6337d(dVar);
                    }
                } else if (responseCode == 401) {
                    dVar.mo9358b("tokenError");
                    return new ByteArrayInputStream("tokenError".getBytes());
                }
            } catch (IOException e) {
                e = e;
                m6334a(httpURLConnection);
                C1714f.m6382b("PERFECT_PUSH_CONNECTION", "error when getStream:" + dVar.mo9359c() + IOUtils.LINE_SEPARATOR_UNIX + e.getMessage());
                return null;
            }
        } catch (IOException e2) {
            e = e2;
            httpURLConnection = null;
            m6334a(httpURLConnection);
            C1714f.m6382b("PERFECT_PUSH_CONNECTION", "error when getStream:" + dVar.mo9359c() + IOUtils.LINE_SEPARATOR_UNIX + e.getMessage());
            return null;
        }
        return null;
    }

    /* renamed from: a */
    public final String mo9347a(C1702d dVar) {
        byte[] b = m6335b(dVar);
        if (b == null || b.length == 0) {
            return "";
        }
        if (dVar.mo9365i().equals("tokenError")) {
            return "tokenError";
        }
        String str = "";
        String i = dVar.mo9365i();
        if (i != null && (i.contains("text") || i.contains("json"))) {
            try {
                String a = C1719k.m6393a("(?<=charset=)[\\w-]+", i);
                if (!C1719k.m6394a(a)) {
                    str = new String(b, a);
                } else {
                    String str2 = new String(b, "UTF-8");
                    try {
                        if (i.contains("html")) {
                            String a2 = C1719k.m6393a("<meta[^>]*?charset=[a-zA-Z0-9-]+", str2);
                            if (!C1719k.m6394a(a2)) {
                                String a3 = C1719k.m6393a("(?<=charset=)[\\w-]+", a2);
                                if (!C1719k.m6394a(a3)) {
                                    str = new String(str2.getBytes("UTF-8"), a3);
                                }
                            }
                            str = str2;
                        } else {
                            if (i.contains("xml")) {
                                String a4 = C1719k.m6393a("(?<=encoding=\")[\\w-]+", str2);
                                if (!C1719k.m6394a(a4)) {
                                    str2 = new String(str2.getBytes("UTF-8"), a4);
                                }
                            }
                            str = str2;
                        }
                    } catch (Exception e) {
                        str = str2;
                        e = e;
                        e.printStackTrace();
                        C1714f.m6379a("PERFECT_PUSH_CONNECTION", "Response content-- \n" + str);
                        return str;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                C1714f.m6379a("PERFECT_PUSH_CONNECTION", "Response content-- \n" + str);
                return str;
            }
        }
        C1714f.m6379a("PERFECT_PUSH_CONNECTION", "Response content-- \n" + str);
        return str;
    }
}
