package com.igexin.push.p079f.p080a;

import android.os.Process;
import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.p012b.p013a.p020d.AbstractC0470d;
import com.igexin.push.config.C0514k;
import java.net.HttpURLConnection;

/* renamed from: com.igexin.push.f.a.a */
public class C1138a extends AbstractC0470d {

    /* renamed from: a */
    public static final String f2990a = C1138a.class.getName();

    /* renamed from: b */
    public AbstractC1139b f2991b;

    /* renamed from: c */
    private HttpURLConnection f2992c;

    public C1138a(AbstractC1139b bVar) {
        super(0);
        this.f2991b = bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0053 A[SYNTHETIC, Splitter:B:15:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058 A[SYNTHETIC, Splitter:B:18:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0084 A[SYNTHETIC, Splitter:B:40:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0089 A[SYNTHETIC, Splitter:B:43:0x0089] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] m4672a(java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 173
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.p079f.p080a.C1138a.m4672a(java.lang.String):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0089 A[SYNTHETIC, Splitter:B:19:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008e A[SYNTHETIC, Splitter:B:22:0x008e] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0093 A[SYNTHETIC, Splitter:B:25:0x0093] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ca A[SYNTHETIC, Splitter:B:53:0x00ca] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00cf A[SYNTHETIC, Splitter:B:56:0x00cf] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00d4 A[SYNTHETIC, Splitter:B:59:0x00d4] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] m4673a(java.lang.String r8, byte[] r9) {
        /*
        // Method dump skipped, instructions count: 267
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.p079f.p080a.C1138a.m4673a(java.lang.String, byte[]):byte[]");
    }

    /* renamed from: g */
    private void m4674g() {
        if (this.f2992c != null) {
            try {
                this.f2992c.disconnect();
                this.f2992c = null;
            } catch (Exception e) {
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
        super.mo4137b_();
        Process.setThreadPriority(10);
        if (this.f2991b == null || this.f2991b.f2993b == null || (this.f2991b.f2994c != null && this.f2991b.f2994c.length > C0514k.f1303I * 1024)) {
            mo4202p();
            ActivityC0460a.m1698b(f2990a + "|run return ###");
            return;
        }
        try {
            byte[] a = this.f2991b.f2994c == null ? m4672a(this.f2991b.f2993b) : m4673a(this.f2991b.f2993b, this.f2991b.f2994c);
            if (a != null) {
                try {
                    this.f2991b.mo4588a(a);
                    C0456c.m1661b().mo4218a(this.f2991b);
                    C0456c.m1661b().mo4171c();
                } catch (Exception e) {
                    this.f2991b.mo4590a(e);
                    throw e;
                }
            } else {
                Exception exc = new Exception("Http response ＝＝ null");
                this.f2991b.mo4590a(exc);
                throw exc;
            }
        } catch (Exception e2) {
            this.f2991b.mo4590a(e2);
            throw e2;
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
        m4674g();
    }
}
