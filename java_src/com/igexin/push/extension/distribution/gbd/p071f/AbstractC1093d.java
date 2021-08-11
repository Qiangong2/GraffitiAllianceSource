package com.igexin.push.extension.distribution.gbd.p071f;

import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.tencent.qcloud.core.http.HttpConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.igexin.push.extension.distribution.gbd.f.d */
public abstract class AbstractC1093d {

    /* renamed from: a */
    public String f2946a;

    /* renamed from: b */
    public byte[] f2947b;

    /* renamed from: c */
    public boolean f2948c;

    /* renamed from: d */
    public AbstractC1092c f2949d;

    /* renamed from: e */
    public boolean f2950e;

    /* renamed from: f */
    public boolean f2951f;

    /* renamed from: g */
    public int f2952g = 20000;

    /* renamed from: h */
    public int f2953h = 20000;

    /* renamed from: i */
    public boolean f2954i = true;

    /* renamed from: j */
    public boolean f2955j = true;

    /* renamed from: k */
    public boolean f2956k = false;

    /* renamed from: l */
    public boolean f2957l = true;

    /* renamed from: m */
    public HashMap<String, String> f2958m = new HashMap<>();

    public AbstractC1093d() {
    }

    public AbstractC1093d(String str) {
        C1115d.m4557a("HttpPlugin", "http url:" + str);
        this.f2946a = str;
        mo5847a(HttpConstants.Header.CONTENT_TYPE, HttpConstants.ContentType.X_WWW_FORM_URLENCODED);
    }

    /* renamed from: a */
    public void mo5840a(int i) {
    }

    /* renamed from: a */
    public void mo5845a(AbstractC1092c cVar) {
        this.f2949d = cVar;
    }

    /* renamed from: a */
    public void mo5846a(String str) {
        this.f2946a = str;
    }

    /* renamed from: a */
    public void mo5847a(String str, String str2) {
        this.f2958m.put(str, str2);
    }

    /* renamed from: a */
    public void mo5841a(Throwable th) {
    }

    /* renamed from: a */
    public void mo5842a(Map<String, List<String>> map, byte[] bArr) {
    }

    /* renamed from: a */
    public void mo5848a(boolean z) {
        this.f2950e = z;
    }

    /* renamed from: a */
    public void mo5849a(byte[] bArr) {
        this.f2947b = bArr;
    }

    /* renamed from: a */
    public boolean mo5850a() {
        return this.f2950e;
    }

    /* renamed from: b */
    public void mo5851b(boolean z) {
        this.f2951f = z;
    }

    /* renamed from: b */
    public boolean mo5852b() {
        return this.f2951f;
    }

    /* renamed from: c */
    public void mo5853c(boolean z) {
        this.f2948c = z;
    }

    /* renamed from: c */
    public boolean mo5854c() {
        return this.f2957l;
    }

    /* renamed from: d */
    public boolean mo5855d() {
        return this.f2956k;
    }

    /* renamed from: e */
    public int mo5856e() {
        return this.f2952g;
    }

    /* renamed from: f */
    public int mo5857f() {
        return this.f2953h;
    }

    /* renamed from: g */
    public boolean mo5858g() {
        return this.f2954i;
    }

    /* renamed from: h */
    public boolean mo5859h() {
        return this.f2955j;
    }

    /* renamed from: i */
    public HashMap<String, String> mo5860i() {
        return this.f2958m;
    }

    /* renamed from: j */
    public boolean mo5861j() {
        return this.f2948c;
    }

    /* renamed from: k */
    public String mo5862k() {
        return this.f2946a;
    }

    /* renamed from: l */
    public byte[] mo5863l() {
        return this.f2947b;
    }

    /* renamed from: m */
    public void mo5864m() {
    }
}
