package com.igexin.push.core.p031d;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.Menu;

/* renamed from: com.igexin.push.core.d.a */
public abstract class AbstractC0614a {

    /* renamed from: a */
    protected Long f1555a = Long.valueOf(System.currentTimeMillis());

    /* renamed from: b */
    protected Activity f1556b;

    /* renamed from: c */
    protected String f1557c;

    /* renamed from: a */
    public Long mo4595a() {
        return this.f1555a;
    }

    /* renamed from: a */
    public void mo4596a(Activity activity) {
        this.f1556b = activity;
    }

    /* renamed from: a */
    public abstract void mo4597a(Intent intent);

    /* renamed from: a */
    public abstract void mo4598a(Configuration configuration);

    /* renamed from: a */
    public void mo4599a(Long l) {
        this.f1555a = l;
    }

    /* renamed from: a */
    public void mo4600a(String str) {
        this.f1557c = str;
    }

    /* renamed from: a */
    public abstract boolean mo4601a(int i, KeyEvent keyEvent);

    /* renamed from: a */
    public abstract boolean mo4602a(Menu menu);

    /* renamed from: b */
    public String mo4603b() {
        return this.f1557c;
    }

    /* renamed from: c */
    public abstract void mo4604c();

    /* renamed from: d */
    public abstract void mo4605d();

    /* renamed from: e */
    public abstract void mo4606e();

    /* renamed from: f */
    public abstract void mo4607f();

    /* renamed from: g */
    public abstract void mo4608g();

    /* renamed from: h */
    public abstract void mo4609h();

    /* renamed from: i */
    public abstract void mo4610i();
}
