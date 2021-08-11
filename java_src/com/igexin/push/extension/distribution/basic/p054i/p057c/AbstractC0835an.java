package com.igexin.push.extension.distribution.basic.p054i.p057c;

import com.igexin.push.extension.distribution.basic.p054i.p055a.C0803k;
import com.igexin.push.extension.distribution.basic.p054i.p056b.C0805a;
import com.igexin.push.extension.distribution.basic.p054i.p056b.C0806b;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.basic.i.c.an */
public abstract class AbstractC0835an extends AbstractC0827af {

    /* renamed from: b */
    protected String f2334b;

    /* renamed from: c */
    boolean f2335c = false;

    /* renamed from: d */
    C0806b f2336d = new C0806b();

    /* renamed from: e */
    private String f2337e;

    /* renamed from: f */
    private String f2338f;

    AbstractC0835an() {
        super();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public AbstractC0835an mo5440a(String str) {
        this.f2334b = str;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5441a(char c) {
        mo5443b(String.valueOf(c));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5442b(char c) {
        mo5445c(String.valueOf(c));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5443b(String str) {
        if (this.f2334b != null) {
            str = this.f2334b.concat(str);
        }
        this.f2334b = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5444c(char c) {
        mo5446d(String.valueOf(c));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5445c(String str) {
        if (this.f2337e != null) {
            str = this.f2337e.concat(str);
        }
        this.f2337e = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo5446d(String str) {
        if (this.f2338f != null) {
            str = this.f2338f.concat(str);
        }
        this.f2338f = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public void mo5447m() {
        if (this.f2337e != null) {
            if (this.f2338f == null) {
                this.f2338f = "";
            }
            this.f2336d.mo5289a(new C0805a(this.f2337e, this.f2338f));
        }
        this.f2337e = null;
        this.f2338f = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public void mo5448n() {
        if (this.f2337e != null) {
            mo5447m();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public String mo5449o() {
        C0803k.m3402b(this.f2334b.length() == 0);
        return this.f2334b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public boolean mo5450p() {
        return this.f2335c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public C0806b mo5451q() {
        return this.f2336d;
    }
}
