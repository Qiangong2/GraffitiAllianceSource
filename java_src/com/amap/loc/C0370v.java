package com.amap.loc;

import com.tencent.qcloud.core.http.HttpConstants;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.amap.loc.v */
/* compiled from: LogUpdateRequest */
public class C0370v extends AbstractC0283bk {

    /* renamed from: a */
    private byte[] f938a;

    /* renamed from: b */
    private String f939b = "1";

    public C0370v(byte[] bArr) {
        this.f938a = (byte[]) bArr.clone();
    }

    public C0370v(byte[] bArr, String str) {
        this.f938a = (byte[]) bArr.clone();
        this.f939b = str;
    }

    /* renamed from: e */
    private String m1385e() {
        byte[] a = C0363r.m1358a(C0364s.f917a);
        byte[] bArr = new byte[(a.length + 50)];
        System.arraycopy(this.f938a, 0, bArr, 0, 50);
        System.arraycopy(a, 0, bArr, 50, a.length);
        return C0356n.m1303a(bArr);
    }

    @Override // com.amap.loc.AbstractC0283bk
    /* renamed from: a */
    public Map<String, String> mo3696a() {
        HashMap hashMap = new HashMap();
        hashMap.put(HttpConstants.Header.CONTENT_TYPE, "application/zip");
        hashMap.put(HttpConstants.Header.CONTENT_LENGTH, String.valueOf(this.f938a.length));
        return hashMap;
    }

    @Override // com.amap.loc.AbstractC0283bk
    /* renamed from: b */
    public String mo3697b() {
        return String.format(C0364s.f918b, "1", this.f939b, "1", "open", m1385e());
    }

    @Override // com.amap.loc.AbstractC0283bk
    /* renamed from: c */
    public Map<String, String> mo3698c() {
        return null;
    }

    @Override // com.amap.loc.AbstractC0283bk
    /* renamed from: d */
    public byte[] mo3754d() {
        return this.f938a;
    }
}
