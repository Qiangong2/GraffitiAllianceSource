package com.igexin.push.extension.distribution.basic.headsup;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.content.Context;
import android.view.WindowManager;
import com.igexin.push.extension.distribution.basic.util.C1010p;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

@TargetApi(11)
/* renamed from: com.igexin.push.extension.distribution.basic.headsup.m */
public class C0789m {

    /* renamed from: d */
    private static C0789m f2231d;

    /* renamed from: a */
    private WindowManager f2232a;

    /* renamed from: b */
    private C0778b f2233b;

    /* renamed from: c */
    private Queue<C0786j> f2234c;

    /* renamed from: e */
    private Context f2235e;

    /* renamed from: f */
    private boolean f2236f = false;

    /* renamed from: g */
    private Map<Integer, C0786j> f2237g;

    /* renamed from: h */
    private NotificationManager f2238h = null;

    private C0789m(Context context) {
        this.f2235e = context;
        this.f2237g = new HashMap();
        this.f2234c = new LinkedList();
        this.f2232a = (WindowManager) context.getSystemService("window");
        this.f2238h = (NotificationManager) context.getSystemService("notification");
    }

    /* renamed from: a */
    public static C0789m m3318a(Context context) {
        if (f2231d == null) {
            f2231d = new C0789m(context);
        }
        return f2231d;
    }

    /* access modifiers changed from: private */
    @TargetApi(4)
    /* renamed from: d */
    public synchronized void m3320d() {
        if (!this.f2234c.isEmpty()) {
            C0786j poll = this.f2234c.poll();
            this.f2237g.remove(Integer.valueOf(poll.mo5190m()));
            this.f2236f = true;
            m3321d(poll);
        } else {
            this.f2236f = false;
        }
    }

    /* renamed from: d */
    private void m3321d(C0786j jVar) {
        this.f2233b = new C0778b(this.f2235e, 20);
        WindowManager.LayoutParams layoutParams = C0778b.f2161h;
        layoutParams.flags = 1320;
        layoutParams.type = 2010;
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.gravity = 49;
        layoutParams.x = this.f2233b.f2169c;
        layoutParams.y = 0;
        layoutParams.alpha = 1.0f;
        this.f2232a.addView(this.f2233b, layoutParams);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f2233b.f2167a, "translationY", -700.0f, 0.0f);
        ofFloat.setDuration(600L);
        ofFloat.start();
        this.f2233b.mo5149a(jVar);
    }

    /* renamed from: a */
    public void mo5229a() {
        if (this.f2233b != null && this.f2233b.getParent() != null) {
            this.f2233b.mo5150a(false);
        }
    }

    /* renamed from: a */
    public synchronized void mo5230a(int i, C0786j jVar) {
        jVar.mo5173b(i);
        mo5231a(jVar);
    }

    /* renamed from: a */
    public synchronized void mo5231a(C0786j jVar) {
        if (this.f2237g.containsKey(Integer.valueOf(jVar.mo5190m()))) {
            this.f2234c.remove(this.f2237g.get(Integer.valueOf(jVar.mo5190m())));
        }
        this.f2237g.put(Integer.valueOf(jVar.mo5190m()), jVar);
        this.f2234c.add(jVar);
        if (!this.f2236f) {
            m3320d();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5232b() {
        if (this.f2233b.getParent() != null) {
            this.f2232a.removeView(this.f2233b);
            this.f2233b.postDelayed(new RunnableC0790n(this), 1000);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5233b(C0786j jVar) {
        if (this.f2233b.mo5145a().mo5190m() == jVar.mo5190m()) {
            mo5234c();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo5234c() {
        if (this.f2233b != null && this.f2233b.getParent() != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f2233b.f2167a, "translationY", 0.0f, -700.0f);
            ofFloat.setDuration(700L);
            ofFloat.start();
            ofFloat.addListener(new C0791o(this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo5235c(C0786j jVar) {
        if (jVar.mo5191n() != null) {
            C1010p.m4063a(this.f2238h, jVar.mo5190m(), jVar.mo5191n());
        }
    }
}
