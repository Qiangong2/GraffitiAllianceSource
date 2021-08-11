package com.wanmei.sdk.core.net;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.qcloud.core.http.HttpConstants;
import com.tencent.qcloud.core.util.IOUtils;
import com.wanmei.sdk.core.util.C1845f;
import com.wanmei.sdk.core.util.C1848i;
import com.wanmei.sdk.core.util.LogUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* renamed from: com.wanmei.sdk.core.net.c */
public class C1770c {

    /* renamed from: a */
    private static final byte[] f4465a = new byte[0];

    /* renamed from: b */
    private static AbstractC1771a f4466b;

    /* renamed from: com.wanmei.sdk.core.net.c$a */
    public interface AbstractC1771a {
        /* renamed from: a */
        boolean mo9565a() throws IOException;
    }

    /* renamed from: a */
    public String mo9559a(C1772d dVar) {
        byte[] b = mo9562b(dVar);
        if (b == null || b.length == 0) {
            return "";
        }
        String str = "";
        String i = dVar.mo9578i();
        if (i != null && (i.contains("text") || i.contains("json"))) {
            try {
                String a = C1848i.m6695a("(?<=charset=)[\\w-]+", i);
                if (!C1848i.m6696a(a)) {
                    str = new String(b, a);
                } else {
                    String str2 = new String(b, "UTF-8");
                    try {
                        if (i.contains("html")) {
                            String a2 = C1848i.m6695a("<meta[^>]*?charset=[a-zA-Z0-9-]+", str2);
                            if (!C1848i.m6696a(a2)) {
                                String a3 = C1848i.m6695a("(?<=charset=)[\\w-]+", a2);
                                if (!C1848i.m6696a(a3)) {
                                    str = new String(str2.getBytes("UTF-8"), a3);
                                }
                            }
                            str = str2;
                        } else {
                            if (i.contains("xml")) {
                                String a4 = C1848i.m6695a("(?<=encoding=\")[\\w-]+", str2);
                                if (!C1848i.m6696a(a4)) {
                                    str2 = new String(str2.getBytes("UTF-8"), a4);
                                }
                            }
                            str = str2;
                        }
                    } catch (Exception e) {
                        str = str2;
                        e = e;
                        e.printStackTrace();
                        LogUtil.logcat("HttpConnection", "Response content-- \n" + str);
                        return str;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                LogUtil.logcat("HttpConnection", "Response content-- \n" + str);
                return str;
            }
        }
        LogUtil.logcat("HttpConnection", "Response content-- \n" + str);
        return str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo9560a(HttpURLConnection httpURLConnection) {
        String str = null;
        InputStream errorStream = httpURLConnection.getErrorStream();
        if (errorStream != null) {
            try {
                str = C1845f.m6693b(errorStream);
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

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9561a(HttpURLConnection httpURLConnection, String str) {
        OutputStream outputStream = null;
        boolean z = false;
        try {
            if (f4466b != null) {
                z = f4466b.mo9565a();
            }
            if (!z) {
                outputStream = httpURLConnection.getOutputStream();
                outputStream.write(str.getBytes("UTF-8"));
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* renamed from: b */
    public byte[] mo9562b(C1772d dVar) {
        try {
            InputStream d = mo9564d(dVar);
            if (d == null) {
                return f4465a;
            }
            byte[] a = C1845f.m6692a(d);
            d.close();
            if (a.length != 0) {
                return a;
            }
            return f4465a;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public HttpURLConnection mo9563c(C1772d dVar) throws IOException {
        String str = null;
        Proxy h = Build.VERSION.SDK_INT <= 16 ? dVar.mo9577h() : null;
        String c = dVar.mo9572c();
        HttpsURLConnection httpsURLConnection = c.toLowerCase().startsWith(HttpConstants.Scheme.HTTPS) ? h == null ? (HttpsURLConnection) new URL(c).openConnection() : (HttpsURLConnection) new URL(c).openConnection(h) : h == null ? (HttpURLConnection) new URL(c).openConnection() : (HttpURLConnection) new URL(c).openConnection(h);
        try {
            switch (dVar.mo9573d()) {
                case 0:
                    URL url = dVar.mo9579j() != null ? new URL(c + "?" + dVar.mo9580k()) : new URL(c);
                    httpsURLConnection = h == null ? (HttpURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection(h);
                    httpsURLConnection.setRequestMethod("GET");
                    break;
                case 1:
                    httpsURLConnection.setRequestMethod("POST");
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setRequestProperty(HttpConstants.Header.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=UTF-8");
                    break;
                default:
                    throw new IllegalArgumentException("Unknown HTTP method");
            }
            if (httpsURLConnection != null) {
                LogUtil.logcat("HttpConnection", "\n\n-- url:" + httpsURLConnection.getRequestMethod() + IOUtils.LINE_SEPARATOR_UNIX + httpsURLConnection.getURL());
                httpsURLConnection.setRequestProperty(HttpConstants.Header.USER_AGENT, "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET4.0C; .NET4.0E)");
                httpsURLConnection.setRequestProperty(HttpConstants.Header.CONNECTION, "Keep-Alive");
                if (!TextUtils.isEmpty(dVar.mo9574e())) {
                    httpsURLConnection.setChunkedStreamingMode(dVar.mo9574e().length());
                }
                httpsURLConnection.setConnectTimeout(dVar.mo9575f());
                httpsURLConnection.setReadTimeout(dVar.mo9576g());
                httpsURLConnection.setInstanceFollowRedirects(true);
                HttpURLConnection.setFollowRedirects(true);
                HashMap<String, String> b = dVar.mo9570b();
                LogUtil.logcat("HttpConnection", "-- Request head");
                if (b != null) {
                    for (String str2 : b.keySet()) {
                        String str3 = b.get(str2);
                        httpsURLConnection.addRequestProperty(str2, str3);
                        LogUtil.logcat("HttpConnection", "--------> " + str2 + " : " + str3);
                    }
                }
                if (!C1848i.m6696a(dVar.mo9566a())) {
                    httpsURLConnection.addRequestProperty("referer", dVar.mo9566a());
                }
            }
            if (httpsURLConnection.getDoOutput() && dVar.mo9579j() != null && !dVar.mo9579j().isEmpty()) {
                str = dVar.mo9580k();
                mo9561a(httpsURLConnection, str);
            }
            LogUtil.logcat("HttpConnection", "-- Request content：\n" + str);
            Map<String, List<String>> headerFields = httpsURLConnection.getHeaderFields();
            if (headerFields != null) {
                for (String str4 : headerFields.keySet()) {
                    Iterator<String> it = httpsURLConnection.getHeaderFields().get(str4).iterator();
                    while (it.hasNext()) {
                        LogUtil.logcat("HttpConnection", "--------> " + str4 + " : " + it.next());
                    }
                }
            }
            LogUtil.logcat("HttpConnection", "-- responseCode = " + httpsURLConnection.getResponseCode());
            return httpsURLConnection;
        } catch (ProtocolException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x000e A[SYNTHETIC, Splitter:B:7:0x000e] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.InputStream mo9564d(com.wanmei.sdk.core.net.C1772d r5) {
        /*
        // Method dump skipped, instructions count: 105
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wanmei.sdk.core.net.C1770c.mo9564d(com.wanmei.sdk.core.net.d):java.io.InputStream");
    }
}
