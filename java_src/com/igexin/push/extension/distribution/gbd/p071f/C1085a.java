package com.igexin.push.extension.distribution.gbd.p071f;

import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.igexin.p012b.p013a.p015b.C0459f;
import com.igexin.p012b.p013a.p020d.AbstractC0470d;
import com.igexin.p012b.p022b.C0476a;
import com.igexin.push.extension.distribution.gbd.p067c.C1067a;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.util.HashMap;

/* renamed from: com.igexin.push.extension.distribution.gbd.f.a */
public class C1085a extends AbstractC0470d {

    /* renamed from: a */
    public AbstractC1093d f2941a;

    /* renamed from: b */
    private HttpURLConnection f2942b;

    /* renamed from: c */
    private boolean f2943c = false;

    public C1085a(AbstractC1093d dVar) {
        super(0);
        this.f2941a = dVar;
    }

    /* renamed from: a */
    private Method m4436a(String str, Class<?>... clsArr) {
        try {
            return Class.forName("com.igexin.push.util.EncryptUtils").getMethod(str, clsArr);
        } catch (Throwable th) {
            C1115d.m4558a(th);
            return null;
        }
    }

    /* renamed from: a */
    private void m4437a(HttpURLConnection httpURLConnection, byte[] bArr) {
        if (httpURLConnection != null) {
            try {
                byte[] bArr2 = new byte[0];
                if (bArr == null) {
                    bArr = bArr2;
                }
                httpURLConnection.addRequestProperty("GT_C_T", String.valueOf(1));
                httpURLConnection.addRequestProperty("GT_C_K", new String((byte[]) m4436a("getRSAKeyId", new Class[0]).invoke(null, new Object[0])));
                httpURLConnection.addRequestProperty("GT_C_V", (String) m4436a("getHttpGTCV", new Class[0]).invoke(null, new Object[0]));
                String valueOf = String.valueOf(System.currentTimeMillis());
                httpURLConnection.addRequestProperty("GT_T", valueOf);
                httpURLConnection.addRequestProperty("GT_C_S", (String) m4436a("getHttpSignature", String.class, byte[].class).invoke(null, valueOf, bArr));
            } catch (Throwable th) {
                C1115d.m4558a(th);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0094 A[Catch:{ all -> 0x020e }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01eb A[SYNTHETIC, Splitter:B:128:0x01eb] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01f0 A[Catch:{ Throwable -> 0x01fc, all -> 0x0204 }] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x01f5 A[Catch:{ Throwable -> 0x01fc, all -> 0x0204 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00a7 A[SYNTHETIC, Splitter:B:14:0x00a7] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00ac A[Catch:{ Throwable -> 0x01d8, all -> 0x01e1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00b1 A[Catch:{ Throwable -> 0x01d8, all -> 0x01e1 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] m4438a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r9) {
        /*
        // Method dump skipped, instructions count: 538
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.gbd.p071f.C1085a.m4438a(java.util.Map):byte[]");
    }

    /* renamed from: a */
    private byte[] m4439a(byte[] bArr) {
        byte[] a = C0459f.m1683a(bArr);
        m4437a(this.f2942b, a);
        String requestProperty = this.f2942b.getRequestProperty("GT_C_S");
        if (requestProperty == null) {
            return a;
        }
        return (byte[]) m4436a("aesEncHttp", byte[].class, byte[].class).invoke(null, a, m4436a("md5", byte[].class).invoke(null, requestProperty.getBytes()));
    }

    /* renamed from: b */
    private byte[] m4440b(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            if (!this.f2941a.mo5861j()) {
                return this.f2941a.mo5852b() ? C0476a.m1777c(Base64.decode(bArr, 0)) : bArr;
            }
            String headerField = httpURLConnection.getHeaderField("GT_ERR");
            if (headerField == null || !headerField.equals("0")) {
                return null;
            }
            String headerField2 = httpURLConnection.getHeaderField("GT_T");
            if (headerField2 == null) {
                return null;
            }
            String headerField3 = httpURLConnection.getHeaderField("GT_C_S");
            if (headerField3 == null) {
                return null;
            }
            byte[] bArr2 = (byte[]) m4436a("aesDecHttp", byte[].class, byte[].class).invoke(null, bArr, m4436a("md5", byte[].class).invoke(null, headerField2.getBytes()));
            String str = (String) m4436a("getHttpSignature", String.class, byte[].class).invoke(null, headerField2, bArr2);
            if (str == null || !str.equals(headerField3)) {
                return null;
            }
            return bArr2;
        } catch (Throwable th) {
            C1115d.m4558a(th);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0087 A[Catch:{ all -> 0x018d }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0091 A[SYNTHETIC, Splitter:B:14:0x0091] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0096 A[Catch:{ Throwable -> 0x0160, all -> 0x0169 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0172 A[SYNTHETIC, Splitter:B:96:0x0172] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0177 A[Catch:{ Throwable -> 0x017e, all -> 0x0186 }] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] m4441b(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r8) {
        /*
        // Method dump skipped, instructions count: 404
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.gbd.p071f.C1085a.m4441b(java.util.Map):byte[]");
    }

    /* renamed from: g */
    private void m4442g() {
        if (this.f2942b != null) {
            try {
                this.f2942b.disconnect();
                this.f2942b = null;
            } catch (Throwable th) {
                C1115d.m4558a(th);
                C1115d.m4559b("GBDAsyncHttpTask", th.toString());
            }
        }
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public final int mo4136b() {
        return -2147483639;
    }

    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: b_ */
    public final void mo4137b_() {
        try {
            Process.setThreadPriority(10);
            if (this.f2943c) {
                mo4202p();
                return;
            }
            this.f2943c = true;
            if (this.f2941a == null) {
                return;
            }
            if (this.f2941a.f2947b == null || this.f2941a.f2947b.length <= C1067a.f2782af * 1024) {
                this.f2941a.mo5864m();
                if (!TextUtils.isEmpty(this.f2941a.f2946a)) {
                    C1115d.m4557a("GBDAsyncHttpTask", "-----------" + this.f2941a.f2946a + "-----------");
                    HashMap hashMap = new HashMap();
                    byte[] b = this.f2941a.f2947b == null ? m4441b(hashMap) : m4438a(hashMap);
                    if (b != null) {
                        this.f2941a.mo5842a(hashMap, b);
                        return;
                    }
                    return;
                }
                return;
            }
            C1115d.m4559b("GBDAsyncHttpTask", "http data size (" + this.f2941a.f2947b.length + ") > max size (" + (C1067a.f2782af * 1024) + ")");
        } catch (Throwable th) {
            C1115d.m4558a(th);
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
        m4442g();
    }
}
