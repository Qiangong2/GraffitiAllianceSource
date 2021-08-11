package com.amap.loc;

import android.os.Build;
import com.amap.loc.C0275bf;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import org.pwrd.paho.client.mqttv3.internal.security.SSLSocketFactoryFactory;

/* renamed from: com.amap.loc.bi */
/* compiled from: HttpUrlUtil */
public class C0280bi {

    /* renamed from: a */
    private static AbstractC0282bj f452a;

    /* renamed from: b */
    private int f453b;

    /* renamed from: c */
    private int f454c;

    /* renamed from: d */
    private boolean f455d;

    /* renamed from: e */
    private SSLContext f456e;

    /* renamed from: f */
    private Proxy f457f;

    /* renamed from: g */
    private volatile boolean f458g;

    /* renamed from: h */
    private long f459h;

    /* renamed from: i */
    private long f460i;

    /* renamed from: j */
    private String f461j;

    /* renamed from: k */
    private C0275bf.AbstractC0276a f462k;

    /* renamed from: l */
    private HostnameVerifier f463l;

    C0280bi(int i, int i2, Proxy proxy) {
        this(i, i2, proxy, false);
    }

    C0280bi(int i, int i2, Proxy proxy, boolean z) {
        this(i, i2, proxy, z, null);
    }

    C0280bi(int i, int i2, Proxy proxy, boolean z, C0275bf.AbstractC0276a aVar) {
        this.f458g = false;
        this.f459h = -1;
        this.f460i = 0;
        this.f463l = new HostnameVerifier() {
            /* class com.amap.loc.C0280bi.C02811 */

            public boolean verify(String str, SSLSession sSLSession) {
                HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
                return defaultHostnameVerifier.verify("*.amap.com", sSLSession) || defaultHostnameVerifier.verify("*.apilocate.amap.com", sSLSession);
            }
        };
        this.f453b = i;
        this.f454c = i2;
        this.f457f = proxy;
        this.f455d = z;
        this.f462k = aVar;
        m743a();
        if (z) {
            try {
                SSLContext instance = SSLContext.getInstance(SSLSocketFactoryFactory.DEFAULT_PROTOCOL);
                instance.init(null, null, null);
                this.f456e = instance;
            } catch (Throwable th) {
                C0365t.m1372a(th, "HttpUtil", "HttpUtil");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006d A[SYNTHETIC, Splitter:B:19:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072 A[SYNTHETIC, Splitter:B:22:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0077 A[SYNTHETIC, Splitter:B:25:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007c A[SYNTHETIC, Splitter:B:28:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0081 A[SYNTHETIC, Splitter:B:31:0x0081] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.amap.loc.C0284bl m741a(java.net.HttpURLConnection r10) throws com.amap.loc.C0341h, java.io.IOException {
        /*
        // Method dump skipped, instructions count: 392
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0280bi.m741a(java.net.HttpURLConnection):com.amap.loc.bl");
    }

    /* renamed from: a */
    static String m742a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value == null) {
                value = "";
            }
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(URLEncoder.encode(key));
            sb.append(SimpleComparison.EQUAL_TO_OPERATION);
            sb.append(URLEncoder.encode(value));
        }
        return sb.toString();
    }

    /* renamed from: a */
    private void m743a() {
        try {
            this.f461j = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        } catch (Throwable th) {
            C0365t.m1372a(th, "HttpUrlUtil", "initCSID");
        }
    }

    /* renamed from: a */
    public static void m744a(AbstractC0282bj bjVar) {
        f452a = bjVar;
    }

    /* renamed from: a */
    private void m745a(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map != null) {
            for (String str : map.keySet()) {
                httpURLConnection.addRequestProperty(str, map.get(str));
            }
        }
        try {
            httpURLConnection.addRequestProperty("csid", this.f461j);
        } catch (Throwable th) {
            C0365t.m1372a(th, "HttpUrlUtil", "addHeaders");
        }
        httpURLConnection.setConnectTimeout(this.f453b);
        httpURLConnection.setReadTimeout(this.f454c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0284bl mo3760a(String str, Map<String, String> map, byte[] bArr) throws C0341h {
        try {
            HttpURLConnection a = mo3761a(str, map, true);
            if (bArr != null && bArr.length > 0) {
                DataOutputStream dataOutputStream = new DataOutputStream(a.getOutputStream());
                dataOutputStream.write(bArr);
                dataOutputStream.close();
            }
            a.connect();
            return m741a(a);
        } catch (ConnectException e) {
            e.printStackTrace();
            throw new C0341h("http连接失败 - ConnectionException");
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
            throw new C0341h("url异常 - MalformedURLException");
        } catch (UnknownHostException e3) {
            e3.printStackTrace();
            throw new C0341h("未知主机 - UnKnowHostException");
        } catch (SocketException e4) {
            e4.printStackTrace();
            throw new C0341h("socket 连接异常 - SocketException");
        } catch (SocketTimeoutException e5) {
            e5.printStackTrace();
            throw new C0341h("socket 连接超时 - SocketTimeoutException");
        } catch (InterruptedIOException e6) {
            throw new C0341h("未知的错误");
        } catch (IOException e7) {
            e7.printStackTrace();
            throw new C0341h("IO 操作异常 - IOException");
        } catch (C0341h e8) {
            C0365t.m1372a(e8, "HttpUrlUtil", "makePostReqeust");
            throw e8;
        } catch (Throwable th) {
            C0365t.m1372a(th, "HttpUrlUtil", "makePostReqeust");
            throw new C0341h("未知的错误");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public HttpURLConnection mo3761a(String str, Map<String, String> map, boolean z) throws IOException {
        HttpURLConnection httpURLConnection;
        C0353l.m1265a();
        URLConnection uRLConnection = null;
        URL url = new URL(str);
        if (this.f462k != null) {
            uRLConnection = this.f462k.mo3750a(this.f457f, url);
        }
        if (uRLConnection == null) {
            uRLConnection = this.f457f != null ? url.openConnection(this.f457f) : url.openConnection();
        }
        if (this.f455d) {
            httpURLConnection = (HttpsURLConnection) uRLConnection;
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.f456e.getSocketFactory());
            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(this.f463l);
        } else {
            httpURLConnection = (HttpURLConnection) uRLConnection;
        }
        if (Build.VERSION.SDK != null && Build.VERSION.SDK_INT > 13) {
            httpURLConnection.setRequestProperty(HttpConstants.Header.CONNECTION, "close");
        }
        m745a(map, httpURLConnection);
        if (z) {
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
        } else {
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
        }
        return httpURLConnection;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3762a(long j) {
        this.f460i = j;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:111:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00e4, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e5, code lost:
        r2 = r1;
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        r1.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00f7, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00f8, code lost:
        com.amap.loc.C0365t.m1372a(r0, "HttpUrlUtil", "makeDownloadGetRequest");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0114, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0153, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0154, code lost:
        com.amap.loc.C0365t.m1372a(r0, "HttpUrlUtil", "makeDownloadGetRequest");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x015c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x015d, code lost:
        com.amap.loc.C0365t.m1372a(r0, "HttpUrlUtil", "makeDownloadGetRequest");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ed A[SYNTHETIC, Splitter:B:50:0x00ed] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f2 A[SYNTHETIC, Splitter:B:53:0x00f2] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0114 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:19:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0117 A[SYNTHETIC, Splitter:B:62:0x0117] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x011c A[SYNTHETIC, Splitter:B:65:0x011c] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo3763a(java.lang.String r11, java.util.Map<java.lang.String, java.lang.String> r12, java.util.Map<java.lang.String, java.lang.String> r13, com.amap.loc.C0278bh.AbstractC0279a r14) {
        /*
        // Method dump skipped, instructions count: 402
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0280bi.mo3763a(java.lang.String, java.util.Map, java.util.Map, com.amap.loc.bh$a):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo3764b(long j) {
        this.f459h = j;
    }
}
