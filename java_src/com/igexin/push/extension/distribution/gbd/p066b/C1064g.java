package com.igexin.push.extension.distribution.gbd.p066b;

import android.text.TextUtils;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;

/* renamed from: com.igexin.push.extension.distribution.gbd.b.g */
public class C1064g {

    /* renamed from: a */
    private int f2738a;

    /* renamed from: b */
    private int f2739b;

    /* renamed from: c */
    private String f2740c;

    /* renamed from: d */
    private long f2741d;

    /* renamed from: a */
    public int mo5767a() {
        return this.f2738a;
    }

    /* renamed from: a */
    public void mo5768a(int i) {
        this.f2738a = i;
    }

    /* renamed from: a */
    public void mo5769a(long j) {
        this.f2741d = j;
    }

    /* renamed from: a */
    public void mo5770a(String str) {
        this.f2740c = str;
    }

    /* renamed from: b */
    public int mo5771b() {
        return this.f2739b;
    }

    /* renamed from: b */
    public void mo5772b(int i) {
        this.f2739b = i;
    }

    /* renamed from: c */
    public String mo5773c() {
        return this.f2740c;
    }

    /* renamed from: d */
    public long mo5774d() {
        return this.f2741d;
    }

    public boolean equals(Object obj) {
        try {
            if (obj instanceof C1064g) {
                C1064g gVar = (C1064g) obj;
                return !TextUtils.isEmpty(gVar.mo5773c()) && !TextUtils.isEmpty(mo5773c()) && gVar.mo5773c().equals(mo5773c());
            }
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
    }

    public int hashCode() {
        return (((this.f2740c != null ? this.f2740c.hashCode() : 0) + (((this.f2738a * 31) + this.f2739b) * 31)) * 31) + ((int) (this.f2741d ^ (this.f2741d >>> 32)));
    }
}
