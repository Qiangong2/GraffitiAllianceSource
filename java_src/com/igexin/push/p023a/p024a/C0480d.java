package com.igexin.push.p023a.p024a;

import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.push.p079f.p081b.AbstractC1146d;

/* renamed from: com.igexin.push.a.a.d */
public class C0480d implements AbstractC1146d {

    /* renamed from: a */
    private static final String f1181a = C0480d.class.getName();

    /* renamed from: b */
    private long f1182b = 0;

    /* renamed from: c */
    private long f1183c = 0;

    /* renamed from: c */
    private void m1789c() {
        C0456c.m1661b().mo4216a(new C0481e(this), false, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0184, code lost:
        r0 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0187, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01fa, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01fb, code lost:
        if (0 != 0) goto L_0x01fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01fd, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0200, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01fa A[ExcHandler: all (r0v2 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x0008] */
    /* JADX WARNING: Removed duplicated region for block: B:66:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // com.igexin.push.p079f.p081b.AbstractC1146d
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo4247a() {
        /*
        // Method dump skipped, instructions count: 521
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.p023a.p024a.C0480d.mo4247a():void");
    }

    @Override // com.igexin.push.p079f.p081b.AbstractC1146d
    /* renamed from: a */
    public void mo4248a(long j) {
        this.f1182b = j;
    }

    @Override // com.igexin.push.p079f.p081b.AbstractC1146d
    /* renamed from: b */
    public boolean mo4249b() {
        return System.currentTimeMillis() - this.f1182b > 1800000;
    }
}
