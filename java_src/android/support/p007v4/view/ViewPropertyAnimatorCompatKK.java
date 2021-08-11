package android.support.p007v4.view;

import android.animation.ValueAnimator;
import android.view.View;

/* renamed from: android.support.v4.view.ViewPropertyAnimatorCompatKK */
class ViewPropertyAnimatorCompatKK {
    ViewPropertyAnimatorCompatKK() {
    }

    public static void setUpdateListener(final View view, final ViewPropertyAnimatorUpdateListener listener) {
        ValueAnimator.AnimatorUpdateListener wrapped = null;
        if (listener != null) {
            wrapped = new ValueAnimator.AnimatorUpdateListener() {
                /* class android.support.p007v4.view.ViewPropertyAnimatorCompatKK.C01751 */

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    listener.onAnimationUpdate(view);
                }
            };
        }
        view.animate().setUpdateListener(wrapped);
    }
}
