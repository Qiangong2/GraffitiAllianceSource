package com.igexin.push.extension.distribution.basic.p054i.p056b;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/* renamed from: com.igexin.push.extension.distribution.basic.i.b.f */
public class C0810f implements Cloneable {

    /* renamed from: a */
    private EnumC0815k f2270a = EnumC0815k.base;

    /* renamed from: b */
    private Charset f2271b = Charset.forName("UTF-8");

    /* renamed from: c */
    private CharsetEncoder f2272c = this.f2271b.newEncoder();

    /* renamed from: d */
    private boolean f2273d = true;

    /* renamed from: e */
    private int f2274e = 1;

    /* renamed from: a */
    public C0810f mo5316a(String str) {
        mo5317a(Charset.forName(str));
        return this;
    }

    /* renamed from: a */
    public C0810f mo5317a(Charset charset) {
        this.f2271b = charset;
        this.f2272c = charset.newEncoder();
        return this;
    }

    /* renamed from: a */
    public EnumC0815k mo5318a() {
        return this.f2270a;
    }

    /* renamed from: b */
    public Charset mo5319b() {
        return this.f2271b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public CharsetEncoder mo5320c() {
        return this.f2272c;
    }

    /* renamed from: d */
    public boolean mo5322d() {
        return this.f2273d;
    }

    /* renamed from: e */
    public int mo5323e() {
        return this.f2274e;
    }

    /* renamed from: f */
    public C0810f clone() {
        try {
            C0810f fVar = (C0810f) super.clone();
            fVar.mo5316a(this.f2271b.name());
            fVar.f2270a = EnumC0815k.m3498a(this.f2270a.name());
            return fVar;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
