package com.igexin.push.core.bean;

import com.igexin.push.core.C0617f;
import com.igexin.push.core.C0618g;

/* renamed from: com.igexin.push.core.bean.l */
public class C0599l extends BaseAction {

    /* renamed from: a */
    private String f1513a;

    /* renamed from: b */
    private boolean f1514b;

    /* renamed from: c */
    private boolean f1515c;

    /* renamed from: d */
    private String f1516d;

    /* renamed from: a */
    public String mo4562a() {
        return this.f1513a;
    }

    /* renamed from: a */
    public void mo4563a(String str) {
        this.f1513a = str;
    }

    /* renamed from: a */
    public void mo4564a(boolean z) {
        this.f1514b = z;
    }

    /* renamed from: b */
    public String mo4565b() {
        return this.f1516d;
    }

    /* renamed from: b */
    public void mo4566b(String str) {
        this.f1516d = str;
    }

    /* renamed from: b */
    public void mo4567b(boolean z) {
        this.f1515c = z;
    }

    /* renamed from: c */
    public String mo4568c() {
        String m;
        String str = this.f1513a;
        if (this.f1514b) {
            str = str.indexOf("?") > 0 ? str + "&cid=" + C0618g.f1647r : str + "?cid=" + C0618g.f1647r;
        }
        return (!this.f1515c || (m = C0617f.m2395a().mo4634m()) == null) ? str : str.indexOf("?") > 0 ? str + "&nettype=" + m : str + "?nettype=" + m;
    }
}
