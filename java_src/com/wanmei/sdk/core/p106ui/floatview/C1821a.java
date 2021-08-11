package com.wanmei.sdk.core.p106ui.floatview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import com.wanmei.sdk.core.p106ui.floatview.p108b.AbstractC1833b;
import com.wanmei.sdk.core.p106ui.floatview.p108b.C1835c;
import com.wanmei.sdk.core.p106ui.floatview.p108b.C1837d;
import com.wanmei.sdk.core.util.C1849j;
import java.math.BigDecimal;

/* renamed from: com.wanmei.sdk.core.ui.floatview.a */
public class C1821a {

    /* renamed from: a */
    private Context f4537a;

    /* renamed from: b */
    private FloatViewItem[] f4538b;

    /* renamed from: c */
    private WindowManager f4539c;

    /* renamed from: d */
    private ImageView f4540d;

    /* renamed from: e */
    private AbstractC1833b f4541e;

    /* renamed from: f */
    private C1837d f4542f;

    /* renamed from: g */
    private C1835c f4543g;

    /* renamed from: h */
    private WindowManager.LayoutParams f4544h = new WindowManager.LayoutParams();

    /* renamed from: i */
    private WindowManager.LayoutParams f4545i = new WindowManager.LayoutParams();

    public C1821a(Context context, int i, FloatViewItem[] floatViewItemArr) {
        this.f4537a = context.getApplicationContext();
        this.f4538b = floatViewItemArr;
        this.f4539c = (WindowManager) context.getSystemService("window");
        this.f4540d = (ImageView) LayoutInflater.from(context).inflate(C1849j.m6697a(context, "comm_view_floatview_axis", "layout"), (ViewGroup) null);
        this.f4544h.format = 1;
        this.f4544h.type = 2002;
        this.f4544h.flags = 8;
        this.f4544h.gravity = 51;
        this.f4544h.width = -2;
        this.f4544h.height = -2;
        WindowManager windowManager = this.f4539c;
        WindowManager.LayoutParams layoutParams = this.f4544h;
        int height = windowManager.getDefaultDisplay().getHeight();
        int width = windowManager.getDefaultDisplay().getWidth();
        switch (i) {
            case 0:
                layoutParams.x = 0;
                layoutParams.y = 0;
                break;
            case 1:
                layoutParams.x = 0;
                layoutParams.y = new BigDecimal(height).multiply(new BigDecimal(0.5d)).intValue();
                break;
            case 2:
                layoutParams.x = 0;
                layoutParams.y = height;
                break;
            case 3:
                layoutParams.x = width;
                layoutParams.y = 0;
                break;
            case 4:
                layoutParams.x = width;
                layoutParams.y = new BigDecimal(height).multiply(new BigDecimal(0.5d)).intValue();
                break;
            case 5:
                layoutParams.x = width;
                layoutParams.y = height;
                break;
        }
        this.f4540d.setVisibility(4);
        this.f4545i.format = 1;
        this.f4545i.type = 2002;
        this.f4545i.flags = 8;
        this.f4545i.width = -2;
        this.f4545i.height = -2;
        this.f4542f = new C1837d(this.f4537a, this, this.f4538b);
        this.f4543g = new C1835c(this.f4537a, this, this.f4538b);
        this.f4539c.addView(this.f4542f.mo9905e(), this.f4545i);
        this.f4539c.addView(this.f4543g.mo9905e(), this.f4545i);
        this.f4539c.addView(this.f4540d, this.f4544h);
    }

    /* renamed from: a */
    public void mo9865a() {
        int width = this.f4539c.getDefaultDisplay().getWidth();
        int[] iArr = new int[2];
        this.f4540d.getLocationOnScreen(iArr);
        if (iArr[0] <= width / 2) {
            this.f4541e = this.f4542f;
            this.f4545i.gravity = 51;
        } else {
            this.f4541e = this.f4543g;
            this.f4545i.gravity = 53;
        }
        this.f4541e.mo9901a(0);
        this.f4545i.x = 0;
        this.f4545i.y = this.f4544h.y;
        this.f4539c.updateViewLayout(this.f4541e.mo9905e(), this.f4545i);
        this.f4539c.updateViewLayout(this.f4540d, this.f4544h);
        this.f4541e.mo9903c();
    }

    /* renamed from: a */
    public void mo9866a(int i) {
        this.f4540d.setBackgroundResource(i);
    }

    /* renamed from: a */
    public synchronized void mo9867a(int i, int i2) {
        this.f4544h.x = i;
        this.f4544h.y = i2;
        if (this.f4540d != null) {
            this.f4539c.updateViewLayout(this.f4540d, this.f4544h);
        }
    }

    /* renamed from: a */
    public void mo9868a(View.OnTouchListener onTouchListener) {
        this.f4540d.setOnTouchListener(onTouchListener);
    }

    /* renamed from: b */
    public void mo9869b() {
        this.f4541e.mo9904d();
    }

    /* renamed from: c */
    public int mo9870c() {
        return this.f4540d.getMeasuredWidth();
    }

    /* renamed from: d */
    public int mo9871d() {
        return this.f4540d.getMeasuredHeight();
    }

    /* renamed from: e */
    public int mo9872e() {
        return this.f4540d.getWidth();
    }

    /* renamed from: f */
    public void mo9873f() {
        this.f4540d.setVisibility(0);
    }

    /* renamed from: g */
    public void mo9874g() {
        if (this.f4543g != null) {
            this.f4543g.mo9901a(4);
        }
        if (this.f4542f != null) {
            this.f4542f.mo9901a(4);
        }
        if (this.f4540d != null) {
            this.f4540d.setVisibility(4);
        }
    }

    /* renamed from: h */
    public void mo9875h() {
        this.f4539c.removeViewImmediate(this.f4543g.mo9905e());
        this.f4539c.removeViewImmediate(this.f4542f.mo9905e());
        this.f4541e = null;
        if (this.f4540d != null && this.f4540d.getParent() != null) {
            this.f4539c.removeViewImmediate(this.f4540d);
            this.f4540d = null;
        }
    }
}
