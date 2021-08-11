package com.amap.loc;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/* renamed from: com.amap.loc.ch */
/* compiled from: LocationRequest */
public class C0319ch extends AbstractC0277bg {

    /* renamed from: f */
    Map<String, String> f673f = null;

    /* renamed from: g */
    String f674g = "";

    /* renamed from: h */
    byte[] f675h = null;

    /* renamed from: i */
    byte[] f676i = null;

    /* renamed from: j */
    boolean f677j = false;

    /* renamed from: k */
    String f678k = null;

    /* renamed from: l */
    Map<String, String> f679l = null;

    public C0319ch(Context context, C0360q qVar) {
        super(context, qVar);
    }

    /* renamed from: a */
    private static void m1013a(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, byte[] bArr2) {
        try {
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(bArr2);
        } catch (IOException e) {
        }
    }

    @Override // com.amap.loc.AbstractC0283bk
    /* renamed from: a */
    public Map<String, String> mo3696a() {
        return this.f673f;
    }

    /* renamed from: a */
    public void mo3880a(String str) {
        this.f678k = str;
    }

    /* renamed from: a */
    public void mo3881a(Map<String, String> map) {
        this.f679l = map;
    }

    /* renamed from: a */
    public void mo3882a(boolean z) {
        this.f677j = z;
    }

    @Override // com.amap.loc.AbstractC0277bg
    /* renamed from: a_ */
    public byte[] mo3752a_() {
        return this.f675h;
    }

    @Override // com.amap.loc.AbstractC0283bk
    /* renamed from: b */
    public String mo3697b() {
        return this.f674g;
    }

    /* renamed from: b */
    public void mo3883b(String str) {
        this.f674g = str;
    }

    /* renamed from: b */
    public void mo3884b(Map<String, String> map) {
        this.f673f = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0022 A[SYNTHETIC, Splitter:B:15:0x0022] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x002f A[SYNTHETIC, Splitter:B:22:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo3885b(byte[] r4) {
        /*
            r3 = this;
            r2 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Throwable -> 0x001b, all -> 0x002b }
            r1.<init>()     // Catch:{ Throwable -> 0x001b, all -> 0x002b }
            if (r4 == 0) goto L_0x000f
            byte[] r0 = r3.mo3751a(r4)     // Catch:{ Throwable -> 0x003c }
            m1013a(r1, r0, r4)     // Catch:{ Throwable -> 0x003c }
        L_0x000f:
            byte[] r0 = r1.toByteArray()     // Catch:{ Throwable -> 0x003c }
            r3.f676i = r0     // Catch:{ Throwable -> 0x003c }
            if (r1 == 0) goto L_0x001a
            r1.close()     // Catch:{ IOException -> 0x0038 }
        L_0x001a:
            return
        L_0x001b:
            r0 = move-exception
            r1 = r2
        L_0x001d:
            r0.printStackTrace()     // Catch:{ all -> 0x003a }
            if (r1 == 0) goto L_0x001a
            r1.close()     // Catch:{ IOException -> 0x0026 }
            goto L_0x001a
        L_0x0026:
            r0 = move-exception
        L_0x0027:
            r0.printStackTrace()
            goto L_0x001a
        L_0x002b:
            r0 = move-exception
            r1 = r2
        L_0x002d:
            if (r1 == 0) goto L_0x0032
            r1.close()     // Catch:{ IOException -> 0x0033 }
        L_0x0032:
            throw r0
        L_0x0033:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x0032
        L_0x0038:
            r0 = move-exception
            goto L_0x0027
        L_0x003a:
            r0 = move-exception
            goto L_0x002d
        L_0x003c:
            r0 = move-exception
            goto L_0x001d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0319ch.mo3885b(byte[]):void");
    }

    @Override // com.amap.loc.AbstractC0277bg
    /* renamed from: b_ */
    public byte[] mo3753b_() {
        return this.f676i;
    }

    @Override // com.amap.loc.AbstractC0283bk, com.amap.loc.AbstractC0277bg
    /* renamed from: c */
    public Map<String, String> mo3698c() {
        return this.f679l;
    }

    /* renamed from: c */
    public void mo3886c(byte[] bArr) {
        this.f675h = bArr;
    }

    @Override // com.amap.loc.AbstractC0277bg
    /* renamed from: f */
    public boolean mo3756f() {
        return this.f677j;
    }

    @Override // com.amap.loc.AbstractC0277bg
    /* renamed from: h */
    public String mo3758h() {
        return this.f678k;
    }
}
