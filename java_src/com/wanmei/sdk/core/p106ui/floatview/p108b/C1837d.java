package com.wanmei.sdk.core.p106ui.floatview.p108b;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;
import com.wanmei.sdk.core.p106ui.floatview.C1821a;
import com.wanmei.sdk.core.p106ui.floatview.FloatViewItem;
import com.wanmei.sdk.core.util.C1849j;
import com.wanmei.sdk.core.util.Util;

/* renamed from: com.wanmei.sdk.core.ui.floatview.b.d */
public class C1837d extends AbstractC1833b {
    public C1837d(Context context, C1821a aVar, FloatViewItem[] floatViewItemArr) {
        super(context, aVar, "comm_view_floatview_spreadtoright", floatViewItemArr);
        for (int i = 0; i < this.f4573f.length; i++) {
            this.f4571d.addView(this.f4573f[i], new ViewGroup.LayoutParams(-2, -2));
            if (i != this.f4573f.length - 1) {
                ImageView imageView = new ImageView(this.f4568a);
                imageView.setBackgroundDrawable(C1849j.m6698a(this.f4568a, "comm_floatview_seperater"));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(Util.dip2px(this.f4568a, 1.0f), Util.dip2px(this.f4568a, 30.0f));
                layoutParams.setMargins(0, 0, 0, Util.dip2px(this.f4568a, 2.0f));
                this.f4571d.addView(imageView, layoutParams);
            }
        }
    }

    @Override // com.wanmei.sdk.core.p106ui.floatview.p108b.AbstractC1833b
    /* renamed from: a */
    public void mo9900a() {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.f4571d, "paddingLeft", this.f4572e, (this.f4569b.mo9872e() / 2) + 0);
        ofInt.setDuration(500L);
        ofInt.start();
    }

    @Override // com.wanmei.sdk.core.p106ui.floatview.p108b.AbstractC1833b
    /* renamed from: b */
    public void mo9902b() {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.f4571d, "paddingLeft", (this.f4569b.mo9872e() / 2) + 0, this.f4572e);
        ofInt.setDuration(500L);
        ofInt.start();
        ofInt.addListener(new Animator.AnimatorListener() {
            /* class com.wanmei.sdk.core.p106ui.floatview.p108b.C1837d.C18381 */

            @Override // com.nineoldandroids.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
            }

            @Override // com.nineoldandroids.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                C1837d.this.f4570c.setVisibility(4);
            }

            @Override // com.nineoldandroids.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
            }

            @Override // com.nineoldandroids.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
            }
        });
    }
}
