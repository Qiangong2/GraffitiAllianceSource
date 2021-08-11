package com.wanmei.sdk.core.p106ui.floatview.p108b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.wanmei.sdk.core.p106ui.floatview.C1821a;
import com.wanmei.sdk.core.p106ui.floatview.FloatViewItem;
import com.wanmei.sdk.core.p106ui.floatview.p107a.C1823b;
import com.wanmei.sdk.core.p106ui.floatview.p107a.C1826e;
import com.wanmei.sdk.core.util.C1849j;
import com.wanmei.sdk.core.util.Util;

/* renamed from: com.wanmei.sdk.core.ui.floatview.b.b */
public abstract class AbstractC1833b {

    /* renamed from: a */
    protected Context f4568a;

    /* renamed from: b */
    protected C1821a f4569b;

    /* renamed from: c */
    protected RelativeLayout f4570c;

    /* renamed from: d */
    protected C1832a f4571d;

    /* renamed from: e */
    protected int f4572e;

    /* renamed from: f */
    protected Button[] f4573f;

    public AbstractC1833b(Context context, C1821a aVar, String str, FloatViewItem[] floatViewItemArr) {
        this.f4568a = context;
        this.f4569b = aVar;
        this.f4570c = (RelativeLayout) LayoutInflater.from(context).inflate(C1849j.m6697a(context, str, "layout"), (ViewGroup) null);
        this.f4570c.setVisibility(4);
        this.f4571d = (C1832a) this.f4570c.findViewById(C1849j.m6697a(context, "spread_content", "id"));
        this.f4573f = new Button[floatViewItemArr.length];
        for (int i = 0; i < floatViewItemArr.length; i++) {
            final FloatViewItem floatViewItem = floatViewItemArr[i];
            Button button = new Button(this.f4568a);
            button.setText(floatViewItem.getText());
            button.setGravity(17);
            button.setPadding(0, 0, 0, 0);
            button.setTextSize((float) Util.sp2px(this.f4568a, 7.0f));
            Context context2 = this.f4568a;
            button.setTextColor(context2.getResources().getColor(C1849j.m6697a(context2, "comm_floatview_textcolor", "color")));
            button.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, C1849j.m6698a(this.f4568a, floatViewItem.getIconName()), (Drawable) null, (Drawable) null);
            button.setBackgroundColor(0);
            button.setOnClickListener(new View.OnClickListener() {
                /* class com.wanmei.sdk.core.p106ui.floatview.p108b.AbstractC1833b.View$OnClickListenerC18341 */

                public void onClick(View v) {
                    floatViewItem.getRunnable().run();
                    AbstractC1833b.this.f4569b.mo9869b();
                    C1823b.m6619a().mo9878a(new C1826e(C1823b.m6619a().mo9879b()));
                }
            });
            this.f4573f[i] = button;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo9900a();

    /* renamed from: a */
    public void mo9901a(int i) {
        this.f4570c.setVisibility(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo9902b();

    /* renamed from: c */
    public void mo9903c() {
        if (this.f4572e == 0) {
            this.f4572e = -this.f4570c.getWidth();
        }
        mo9900a();
    }

    /* renamed from: d */
    public void mo9904d() {
        mo9902b();
    }

    /* renamed from: e */
    public View mo9905e() {
        return this.f4570c;
    }
}
