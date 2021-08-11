package com.igexin.push.extension.distribution.basic.p046g.p047a;

import android.content.Context;
import com.igexin.push.extension.distribution.basic.p046g.p050d.AbstractC0762a;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* renamed from: com.igexin.push.extension.distribution.basic.g.a.e */
public class RunnableC0757e implements Runnable {

    /* renamed from: a */
    private final C0753a f2108a;

    /* renamed from: b */
    private final AbstractC0762a f2109b;

    /* renamed from: c */
    private byte[] f2110c = new byte[4096];

    /* renamed from: d */
    private HttpURLConnection f2111d;

    /* renamed from: e */
    private InputStream f2112e;

    /* renamed from: f */
    private FileOutputStream f2113f;

    /* renamed from: g */
    private Context f2114g;

    /* renamed from: h */
    private long f2115h;

    public RunnableC0757e(Context context, C0753a aVar) {
        this.f2108a = aVar;
        this.f2114g = context;
        this.f2109b = aVar.mo5077h();
    }

    /* renamed from: a */
    private boolean m3086a(int i) {
        return i == 200 || i == 206;
    }

    /* renamed from: b */
    private void m3087b(int i) {
        this.f2108a.mo5072c((long) i);
        if (System.currentTimeMillis() - this.f2115h >= 1000) {
            this.f2109b.mo5096c(this.f2108a);
            this.f2115h = System.currentTimeMillis();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:123:0x030c A[Catch:{ Throwable -> 0x0325 }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0315 A[Catch:{ Throwable -> 0x0325 }] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x031e A[Catch:{ Throwable -> 0x0325 }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0328  */
    /* JADX WARNING: Removed duplicated region for block: B:154:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00fe  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        // Method dump skipped, instructions count: 855
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.p046g.p047a.RunnableC0757e.run():void");
    }
}
