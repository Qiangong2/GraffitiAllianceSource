package com.igexin.push.extension.distribution.gbd.p071f.p072a;

import com.igexin.push.extension.distribution.gbd.p071f.AbstractC1092c;
import com.igexin.push.extension.distribution.gbd.p071f.AbstractC1093d;
import com.igexin.push.extension.distribution.gbd.p076i.C1114c;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import java.util.List;
import java.util.Map;

/* renamed from: com.igexin.push.extension.distribution.gbd.f.a.a */
public class C1086a extends AbstractC1093d {
    public C1086a(AbstractC1092c cVar) {
        this.f2949d = cVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0035  */
    /* renamed from: n */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m4448n() {
        /*
            r4 = this;
            java.lang.String r1 = "d69998bb013e45f2"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0059 }
            r0.<init>()     // Catch:{ Exception -> 0x0059 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x0059 }
            android.content.Context r2 = com.igexin.push.extension.distribution.gbd.p067c.C1069c.f2824a     // Catch:{ Exception -> 0x0059 }
            java.lang.String r2 = r2.getPackageName()     // Catch:{ Exception -> 0x0059 }
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ Exception -> 0x0059 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0059 }
            java.lang.String r0 = com.igexin.p012b.p022b.C0476a.m1773a(r0)     // Catch:{ Exception -> 0x0059 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0061 }
            if (r1 != 0) goto L_0x002f
            r1 = 10
            int r2 = r0.length()     // Catch:{ Exception -> 0x0061 }
            int r2 = r2 + -10
            java.lang.String r0 = r0.substring(r1, r2)     // Catch:{ Exception -> 0x0061 }
        L_0x002f:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0037
            java.lang.String r0 = "d69998bb013e45f2"
        L_0x0037:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            android.content.Context r2 = com.igexin.push.extension.distribution.gbd.p067c.C1069c.f2824a
            java.io.File r2 = r2.getFilesDir()
            java.lang.String r2 = r2.getPath()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = "/"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            return r0
        L_0x0059:
            r0 = move-exception
            r3 = r0
            r0 = r1
            r1 = r3
        L_0x005d:
            com.igexin.push.extension.distribution.gbd.p076i.C1115d.m4558a(r1)
            goto L_0x002f
        L_0x0061:
            r1 = move-exception
            goto L_0x005d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.gbd.p071f.p072a.C1086a.m4448n():java.lang.String");
    }

    @Override // com.igexin.push.extension.distribution.gbd.p071f.AbstractC1093d
    /* renamed from: a */
    public void mo5840a(int i) {
        if (this.f2949d != null) {
            try {
                this.f2949d.mo5672a(null);
            } catch (Throwable th) {
                C1115d.m4558a(th);
            }
        }
    }

    @Override // com.igexin.push.extension.distribution.gbd.p071f.AbstractC1093d
    /* renamed from: a */
    public void mo5841a(Throwable th) {
        if (this.f2949d != null) {
            try {
                this.f2949d.mo5672a(null);
            } catch (Throwable th2) {
                C1115d.m4558a(th2);
            }
        }
    }

    @Override // com.igexin.push.extension.distribution.gbd.p071f.AbstractC1093d
    /* renamed from: a */
    public void mo5842a(Map<String, List<String>> map, byte[] bArr) {
        try {
            if (this.f2949d == null) {
                return;
            }
            if (bArr == null) {
                this.f2949d.mo5672a(null);
                return;
            }
            C1114c.m4555a(bArr, m4448n(), false);
            this.f2949d.mo5672a(bArr);
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
    }
}
