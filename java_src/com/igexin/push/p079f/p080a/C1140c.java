package com.igexin.push.p079f.p080a;

import android.os.Process;
import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.p012b.p013a.p015b.C0459f;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.p012b.p013a.p020d.AbstractC0470d;
import com.igexin.push.config.C0514k;
import com.igexin.push.util.EncryptUtils;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.igexin.push.f.a.c */
public class C1140c extends AbstractC0470d {

    /* renamed from: a */
    public AbstractC1139b f2998a;

    /* renamed from: b */
    private HttpURLConnection f2999b;

    public C1140c(AbstractC1139b bVar) {
        super(0);
        this.f2998a = bVar;
    }

    /* renamed from: a */
    private C1141d m4687a(String str) {
        try {
            this.f2999b = m4694b(str);
            byte[] a = m4691a(this.f2999b);
            if (a != null) {
                return m4693b(this.f2999b, a);
            }
            m4696g();
            return new C1141d(this, false, null);
        } catch (Throwable th) {
        } finally {
            m4696g();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0062 A[SYNTHETIC, Splitter:B:26:0x0062] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006c A[SYNTHETIC, Splitter:B:31:0x006c] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.igexin.push.p079f.p080a.C1141d m4688a(java.lang.String r7, byte[] r8) {
        /*
        // Method dump skipped, instructions count: 131
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.p079f.p080a.C1140c.m4688a(java.lang.String, byte[]):com.igexin.push.f.a.d");
    }

    /* renamed from: a */
    private void m4689a(HttpURLConnection httpURLConnection, byte[] bArr) {
        if (httpURLConnection != null) {
            byte[] bArr2 = new byte[0];
            if (bArr == null) {
                bArr = bArr2;
            }
            httpURLConnection.addRequestProperty("GT_C_T", String.valueOf(1));
            httpURLConnection.addRequestProperty("GT_C_K", new String(EncryptUtils.getRSAKeyId()));
            httpURLConnection.addRequestProperty("GT_C_V", EncryptUtils.getHttpGTCV());
            String valueOf = String.valueOf(System.currentTimeMillis());
            String httpSignature = EncryptUtils.getHttpSignature(valueOf, bArr);
            httpURLConnection.addRequestProperty("GT_T", valueOf);
            httpURLConnection.addRequestProperty("GT_C_S", httpSignature);
        }
    }

    /* renamed from: a */
    private void m4690a(byte[] bArr) {
        this.f2998a.mo4588a(bArr);
        C0456c.m1661b().mo4218a(this.f2998a);
        C0456c.m1661b().mo4171c();
    }

    /* renamed from: a */
    private byte[] m4691a(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        Exception e;
        Throwable th;
        byte[] bArr = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (httpURLConnection.getResponseCode() == 200) {
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e2) {
                        }
                    }
                } else if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e3) {
                    }
                }
                return bArr;
            } catch (Exception e4) {
                e = e4;
                try {
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Exception e5) {
            inputStream = null;
            e = e5;
            throw e;
        } catch (Throwable th3) {
            inputStream = null;
            th = th3;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e6) {
                }
            }
            throw th;
        }
    }

    /* renamed from: a */
    private byte[] m4692a(byte[] bArr, HttpURLConnection httpURLConnection) {
        String requestProperty;
        try {
            if (httpURLConnection.getRequestProperties().containsKey("GT_C_S") && (requestProperty = httpURLConnection.getRequestProperty("GT_C_S")) != null) {
                return EncryptUtils.aesEncHttp(bArr, EncryptUtils.md5(requestProperty.getBytes()));
            }
        } catch (Throwable th) {
            ActivityC0460a.m1698b("_HttpTask|" + th.toString());
        }
        return null;
    }

    /* renamed from: b */
    private C1141d m4693b(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            String headerField = httpURLConnection.getHeaderField("GT_ERR");
            ActivityC0460a.m1698b("_HttpTask|GT_ERR = " + headerField);
            if (headerField == null || !headerField.equals("0")) {
                return new C1141d(this, true, null);
            }
            String headerField2 = httpURLConnection.getHeaderField("GT_T");
            if (headerField2 == null) {
                ActivityC0460a.m1698b("_HttpTask|GT_T = null");
                return new C1141d(this, true, null);
            }
            String headerField3 = httpURLConnection.getHeaderField("GT_C_S");
            if (headerField3 == null) {
                ActivityC0460a.m1698b("_HttpTask|GT_C_S = null");
                return new C1141d(this, true, null);
            }
            byte[] aesDecHttp = EncryptUtils.aesDecHttp(bArr, EncryptUtils.md5(headerField2.getBytes()));
            String httpSignature = EncryptUtils.getHttpSignature(headerField2, aesDecHttp);
            if (httpSignature != null && httpSignature.equals(headerField3)) {
                return new C1141d(this, false, aesDecHttp);
            }
            ActivityC0460a.m1698b("_HttpTask|signature = null or error");
            return new C1141d(this, true, null);
        } catch (Throwable th) {
            ActivityC0460a.m1698b("_HttpTask|" + th.toString());
            return new C1141d(this, true, null);
        }
    }

    /* renamed from: b */
    private HttpURLConnection m4694b(String str) {
        this.f2999b = (HttpURLConnection) new URL(str).openConnection();
        this.f2999b.setConnectTimeout(20000);
        this.f2999b.setReadTimeout(20000);
        this.f2999b.setRequestMethod("GET");
        this.f2999b.setDoInput(true);
        m4689a(this.f2999b, (byte[]) null);
        return this.f2999b;
    }

    /* renamed from: b */
    private HttpURLConnection m4695b(String str, byte[] bArr) {
        this.f2999b = (HttpURLConnection) new URL(str).openConnection();
        this.f2999b.setDoInput(true);
        this.f2999b.setDoOutput(true);
        this.f2999b.setRequestMethod("POST");
        this.f2999b.setUseCaches(false);
        this.f2999b.setInstanceFollowRedirects(true);
        this.f2999b.setRequestProperty(HttpConstants.Header.CONTENT_TYPE, COSRequestHeaderKey.APPLICATION_OCTET_STREAM);
        this.f2999b.setConnectTimeout(20000);
        this.f2999b.setReadTimeout(20000);
        m4689a(this.f2999b, bArr);
        return this.f2999b;
    }

    /* renamed from: g */
    private void m4696g() {
        if (this.f2999b != null) {
            try {
                this.f2999b.disconnect();
                this.f2999b = null;
            } catch (Exception e) {
            }
        }
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public final int mo4136b() {
        return -2147483638;
    }

    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: b_ */
    public final void mo4137b_() {
        super.mo4137b_();
        Process.setThreadPriority(10);
        if (this.f2998a == null || this.f2998a.f2993b == null || (this.f2998a.f2994c != null && this.f2998a.f2994c.length > C0514k.f1303I * 1024)) {
            mo4202p();
            ActivityC0460a.m1698b("_HttpTask|run return ###");
            return;
        }
        if (this.f2998a.f2994c != null && this.f2998a.f2994c.length > 0) {
            this.f2998a.f2994c = C0459f.m1691c(this.f2998a.f2994c);
        }
        for (int i = 0; i < 3; i++) {
            C1141d a = this.f2998a.f2994c == null ? m4687a(this.f2998a.f2993b) : m4688a(this.f2998a.f2993b, this.f2998a.f2994c);
            if (a.f3000a) {
                throw new Exception("http server resp decode header error");
            } else if (a.f3001b != null) {
                m4690a(a.f3001b);
                return;
            } else if (i == 2) {
                this.f2998a.mo4590a(new Exception("try up to limit"));
                throw new Exception("http request exception, try times = " + (i + 1));
            }
        }
    }

    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: d */
    public void mo4126d() {
        this.f1125n = true;
    }

    /* access modifiers changed from: protected */
    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: e */
    public void mo4127e() {
    }

    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: f */
    public void mo4138f() {
        super.mo4138f();
        m4696g();
    }
}
