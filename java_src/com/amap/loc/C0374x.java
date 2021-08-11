package com.amap.loc;

import android.content.Context;
import android.os.Looper;

/* renamed from: com.amap.loc.x */
/* compiled from: AnrLogProcessor */
public class C0374x extends AbstractC0225aa {

    /* renamed from: a */
    private static boolean f947a = true;

    /* renamed from: b */
    private String[] f948b = new String[10];

    /* renamed from: c */
    private int f949c = 0;

    /* renamed from: d */
    private boolean f950d = false;

    /* renamed from: e */
    private int f951e = 0;

    protected C0374x(int i) {
        super(i);
    }

    /* renamed from: b */
    private void m1401b(String str) {
        try {
            if (this.f949c > 9) {
                this.f949c = 0;
            }
            this.f948b[this.f949c] = str;
            this.f949c++;
        } catch (Throwable th) {
            C0365t.m1372a(th, "ANRWriter", "addData");
        }
    }

    /* renamed from: d */
    private String m1402d() {
        StringBuilder sb = new StringBuilder();
        try {
            int i = this.f949c;
            while (i < 10 && i <= 9) {
                sb.append(this.f948b[i]);
                i++;
            }
            for (int i2 = 0; i2 < this.f949c; i2++) {
                sb.append(this.f948b[i2]);
            }
        } catch (Throwable th) {
            C0365t.m1372a(th, "ANRWriter", "getLogInfo");
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a0 A[SYNTHETIC, Splitter:B:51:0x00a0] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a5 A[SYNTHETIC, Splitter:B:54:0x00a5] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00be A[SYNTHETIC, Splitter:B:65:0x00be] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c3 A[SYNTHETIC, Splitter:B:68:0x00c3] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00d2 A[SYNTHETIC, Splitter:B:75:0x00d2] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00d7 A[SYNTHETIC, Splitter:B:78:0x00d7] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00db  */
    @Override // com.amap.loc.AbstractC0225aa
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String mo3628a(java.util.List<com.amap.loc.C0360q> r10) {
        /*
        // Method dump skipped, instructions count: 415
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0374x.mo3628a(java.util.List):java.lang.String");
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.loc.AbstractC0225aa
    /* renamed from: a */
    public boolean mo3633a(Context context) {
        if (C0353l.m1280m(context) != 1 || !f947a) {
            return false;
        }
        f947a = false;
        synchronized (Looper.getMainLooper()) {
            C0240an anVar = new C0240an(context);
            C0241ao a = anVar.mo3674a();
            if (a == null) {
                return true;
            }
            if (!a.mo3681c()) {
                return false;
            }
            a.mo3680c(false);
            anVar.mo3675a(a);
            return true;
        }
    }
}
