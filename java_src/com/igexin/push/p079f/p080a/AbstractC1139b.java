package com.igexin.push.p079f.p080a;

import com.igexin.p012b.p013a.p020d.AbstractC0461a;
import java.io.InputStream;

/* renamed from: com.igexin.push.f.a.b */
public abstract class AbstractC1139b extends AbstractC0461a {

    /* renamed from: b */
    String f2993b;

    /* renamed from: c */
    byte[] f2994c;

    /* renamed from: d */
    InputStream f2995d;

    /* renamed from: e */
    long f2996e;

    /* renamed from: f */
    public boolean f2997f;

    public AbstractC1139b(String str) {
        this.f2993b = str;
    }

    /* renamed from: a */
    public void mo4590a(Exception exc) {
    }

    /* renamed from: a */
    public void mo4588a(byte[] bArr) {
        this.f2997f = false;
        if (bArr != null && bArr.length >= 7 && bArr[5] == 111 && bArr[6] == 107) {
            this.f2997f = true;
        }
    }

    /* renamed from: b */
    public void mo5893b(byte[] bArr) {
        this.f2994c = bArr;
    }

    /* renamed from: c */
    public String mo5894c() {
        return this.f2993b;
    }

    /* renamed from: d */
    public byte[] mo5895d() {
        return this.f2994c;
    }

    /* renamed from: e */
    public InputStream mo5896e() {
        return this.f2995d;
    }

    /* renamed from: f */
    public long mo5897f() {
        return this.f2996e;
    }
}
