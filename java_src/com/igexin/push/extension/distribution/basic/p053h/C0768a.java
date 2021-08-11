package com.igexin.push.extension.distribution.basic.p053h;

import android.os.Process;
import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.p012b.p013a.p015b.C0459f;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.p012b.p013a.p020d.AbstractC0470d;
import com.igexin.push.extension.distribution.basic.p042c.C0744j;
import com.igexin.push.extension.distribution.basic.util.C0997c;
import com.igexin.push.extension.distribution.basic.util.C1004j;
import com.igexin.push.extension.distribution.basic.util.C1013s;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.qcloud.core.http.HttpConstants;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.igexin.push.extension.distribution.basic.h.a */
public class C0768a extends AbstractC0470d {

    /* renamed from: a */
    public AbstractC0773f f2128a;

    /* renamed from: b */
    public HttpURLConnection f2129b;

    /* renamed from: c */
    public boolean f2130c;

    /* renamed from: d */
    private boolean f2131d;

    public C0768a(AbstractC0773f fVar) {
        super(0);
        this.f2128a = fVar;
        ActivityC0460a.m1698b("AsyncHttpTask|httpPlugin = " + fVar);
    }

    /* renamed from: a */
    private C0769b m3157a(String str) {
        try {
            this.f2129b = m3165b(str);
            byte[] a = m3162a(this.f2129b);
            if (a != null) {
                return m3164b(this.f2129b, a);
            }
            m3168g();
            return new C0769b(this, false, null);
        } catch (Exception e) {
        } finally {
            m3168g();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ed A[SYNTHETIC, Splitter:B:36:0x00ed] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f7 A[SYNTHETIC, Splitter:B:41:0x00f7] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.igexin.push.extension.distribution.basic.p053h.C0769b m3158a(java.lang.String r7, byte[] r8) {
        /*
        // Method dump skipped, instructions count: 273
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.p053h.C0768a.m3158a(java.lang.String, byte[]):com.igexin.push.extension.distribution.basic.h.b");
    }

    /* renamed from: a */
    private Method m3159a(String str, Class<?>... clsArr) {
        try {
            return Class.forName("com.igexin.push.util.EncryptUtils").getMethod(str, clsArr);
        } catch (Exception e) {
            ActivityC0460a.m1698b(this.f1093l + "invokeMethod error");
            return null;
        }
    }

    /* renamed from: a */
    private void m3160a(HttpURLConnection httpURLConnection, byte[] bArr) {
        if (httpURLConnection != null) {
            byte[] bArr2 = new byte[0];
            if (bArr == null) {
                bArr = bArr2;
            }
            httpURLConnection.addRequestProperty("GT_C_T", String.valueOf(1));
            httpURLConnection.addRequestProperty("GT_C_K", new String((byte[]) m3159a("getRSAKeyId", new Class[0]).invoke(null, new Object[0])));
            httpURLConnection.addRequestProperty("GT_C_V", (String) m3159a("getHttpGTCV", new Class[0]).invoke(null, new Object[0]));
            String valueOf = String.valueOf(System.currentTimeMillis());
            httpURLConnection.addRequestProperty("GT_T", valueOf);
            httpURLConnection.addRequestProperty("GT_C_S", (String) m3159a("getHttpSignature", String.class, byte[].class).invoke(null, valueOf, bArr));
        }
    }

    /* renamed from: a */
    private void m3161a(byte[] bArr) {
        this.f2128a.mo4764a(bArr);
        C0456c.m1661b().mo4218a(this.f2128a);
        C0456c.m1661b().mo4171c();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0027 A[SYNTHETIC, Splitter:B:17:0x0027] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002c A[SYNTHETIC, Splitter:B:20:0x002c] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] m3162a(java.net.HttpURLConnection r7) {
        /*
        // Method dump skipped, instructions count: 108
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.p053h.C0768a.m3162a(java.net.HttpURLConnection):byte[]");
    }

    /* renamed from: a */
    private byte[] m3163a(byte[] bArr, HttpURLConnection httpURLConnection) {
        try {
            ActivityC0460a.m1698b("AsyncHttpTask|getEncHttpData|isUseAES = |" + this.f2130c);
            if (!this.f2130c) {
                return C1013s.m4068a(bArr);
            }
            String requestProperty = httpURLConnection.getRequestProperty("GT_C_S");
            if (requestProperty != null) {
                return (byte[]) m3159a("aesEncHttp", byte[].class, byte[].class).invoke(null, bArr, m3159a("md5", byte[].class).invoke(null, requestProperty.getBytes()));
            }
            return null;
        } catch (Throwable th) {
            ActivityC0460a.m1698b("AsyncHttpTask|getEncHttpData|error|" + th.getMessage());
        }
    }

    /* renamed from: b */
    private C0769b m3164b(HttpURLConnection httpURLConnection, byte[] bArr) {
        ActivityC0460a.m1698b("AsyncHttpTask|authAndDecResp start ~~~");
        try {
            if (this.f2130c) {
                String headerField = httpURLConnection.getHeaderField("GT_ERR");
                ActivityC0460a.m1698b(this.f1093l + "|GT_ERR = " + headerField);
                if (headerField == null || !headerField.equals("0")) {
                    return new C0769b(this, true, null);
                }
                String headerField2 = httpURLConnection.getHeaderField("GT_T");
                if (headerField2 == null) {
                    ActivityC0460a.m1698b(this.f1093l + "|GT_T = null");
                    return new C0769b(this, true, null);
                }
                String headerField3 = httpURLConnection.getHeaderField("GT_C_S");
                if (headerField3 == null) {
                    ActivityC0460a.m1698b(this.f1093l + "|GT_C_S = null");
                    return new C0769b(this, true, null);
                }
                byte[] bArr2 = (byte[]) m3159a("aesDecHttp", byte[].class, byte[].class).invoke(null, bArr, m3159a("md5", byte[].class).invoke(null, headerField2.getBytes()));
                String str = (String) m3159a("getHttpSignature", String.class, byte[].class).invoke(null, headerField2, bArr2);
                if (str != null && str.equals(headerField3)) {
                    return new C0769b(this, false, bArr2);
                }
                ActivityC0460a.m1698b(this.f1093l + "|signature = null or error");
                return new C0769b(this, true, null);
            }
            byte[] a = this.f2128a.mo5114f() ? C1004j.m4040a(bArr, 0) : bArr;
            return new C0769b(this, false, this.f2128a.mo5113e() ? C1013s.m4070b(a) : a);
        } catch (Throwable th) {
            ActivityC0460a.m1698b("AsyncHttpTask|authAndDecResp|error|" + th.getMessage());
            return new C0769b(this, true, null);
        }
    }

    /* renamed from: b */
    private HttpURLConnection m3165b(String str) {
        this.f2129b = (HttpURLConnection) new URL(str).openConnection();
        this.f2129b.setConnectTimeout(20000);
        this.f2129b.setReadTimeout(20000);
        this.f2129b.setRequestMethod("GET");
        this.f2129b.setDoInput(true);
        if (this.f2130c) {
            m3160a(this.f2129b, (byte[]) null);
        }
        return this.f2129b;
    }

    /* renamed from: b */
    private HttpURLConnection m3166b(String str, byte[] bArr) {
        this.f2129b = (HttpURLConnection) new URL(str).openConnection();
        this.f2129b.setDoInput(true);
        this.f2129b.setDoOutput(true);
        this.f2129b.setRequestMethod("POST");
        this.f2129b.setUseCaches(false);
        this.f2129b.setInstanceFollowRedirects(true);
        this.f2129b.setRequestProperty(HttpConstants.Header.CONTENT_TYPE, COSRequestHeaderKey.APPLICATION_OCTET_STREAM);
        this.f2129b.setConnectTimeout(20000);
        this.f2129b.setReadTimeout(20000);
        if (this.f2130c) {
            m3160a(this.f2129b, bArr);
        }
        return this.f2129b;
    }

    /* renamed from: b */
    private boolean m3167b(byte[] bArr) {
        if (bArr == null || bArr.length / 1024 <= C0744j.f2056o) {
            return false;
        }
        ActivityC0460a.m1698b(this.f1093l + "|http body size exceed " + C0744j.f2056o);
        return true;
    }

    /* renamed from: g */
    private void m3168g() {
        ActivityC0460a.m1698b("AsyncHttpTask call closeHttpURLConnection");
        if (this.f2129b != null) {
            try {
                this.f2129b.disconnect();
                this.f2129b = null;
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: h */
    private boolean m3169h() {
        return this.f2128a.f2144f && C0997c.m4007d();
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public final int mo4136b() {
        return -2147483639;
    }

    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: b_ */
    public final void mo4137b_() {
        String c;
        super.mo4137b_();
        try {
            if (this.f2131d) {
                mo4202p();
                return;
            }
            this.f2131d = true;
            Process.setThreadPriority(10);
            if (this.f2128a != null && (c = this.f2128a.mo5111c()) != null) {
                this.f2130c = m3169h();
                if (!this.f2130c || ((Boolean) m3159a("isLoadSuccess", new Class[0]).invoke(null, new Object[0])).booleanValue()) {
                    if (this.f2130c && this.f2128a.mo5112d() != null && this.f2128a.mo5112d().length > 0) {
                        this.f2128a.mo5110b(C0459f.m1683a(this.f2128a.mo5112d()));
                    }
                    try {
                        C0769b a = this.f2128a.mo5112d() == null ? m3157a(c) : m3158a(c, this.f2128a.mo5112d());
                        if (a.f2132a) {
                            Exception exc = new Exception("http server resp decode header error");
                            this.f2128a.mo5108a(exc);
                            throw exc;
                        } else if (a.f2133b != null) {
                            m3161a(a.f2133b);
                        } else {
                            Exception exc2 = new Exception("Http response exception");
                            this.f2128a.mo5108a(exc2);
                            throw exc2;
                        }
                    } catch (Exception e) {
                        ActivityC0460a.m1698b("AsyncHttpTask|run() post or get error = " + e.getMessage());
                        this.f2128a.mo5108a(e);
                        throw e;
                    }
                } else {
                    ActivityC0460a.m1698b(this.f1093l + "|so load failed! AsyncHttpTask return!");
                }
            }
        } catch (Exception e2) {
            ActivityC0460a.m1698b("AsyncHttpTask|run() error = " + e2.getMessage());
            throw e2;
        }
    }

    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: d */
    public void mo4126d() {
        this.f1125n = true;
        ActivityC0460a.m1698b("AsyncHttpTask initTask()|isBloker = " + this.f1125n + "|isCycle = " + this.f1126o);
    }

    /* access modifiers changed from: protected */
    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: e */
    public void mo4127e() {
    }

    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: f */
    public void mo4138f() {
        ActivityC0460a.m1698b("AsyncHttpTask|dispose()|closeHttpURLConnection");
        super.mo4138f();
        m3168g();
    }
}
