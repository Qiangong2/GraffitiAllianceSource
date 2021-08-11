package com.igexin.push.extension.distribution.basic.headsup;

import android.animation.Animator;

/* renamed from: com.igexin.push.extension.distribution.basic.headsup.d */
class C0780d implements Animator.AnimatorListener {

    /* renamed from: a */
    final /* synthetic */ float f2193a;

    /* renamed from: b */
    final /* synthetic */ C0778b f2194b;

    C0780d(C0778b bVar, float f) {
        this.f2194b = bVar;
        this.f2193a = f;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        if (this.f2193a == 0.0f) {
            C0789m.m3318a(this.f2194b.getContext()).mo5232b();
            this.f2194b.f2191z = -1;
            if (this.f2194b.f2181p != null) {
                this.f2194b.f2181p.clear();
                try {
                    this.f2194b.f2181p.recycle();
                } catch (IllegalStateException e) {
                }
            }
        }
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
