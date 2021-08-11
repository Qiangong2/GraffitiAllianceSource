package android.support.p007v4.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;

/* renamed from: android.support.v4.animation.HoneycombMr1AnimatorCompatProvider */
class HoneycombMr1AnimatorCompatProvider implements AnimatorProvider {
    private TimeInterpolator mDefaultInterpolator;

    HoneycombMr1AnimatorCompatProvider() {
    }

    @Override // android.support.p007v4.animation.AnimatorProvider
    public ValueAnimatorCompat emptyValueAnimator() {
        return new HoneycombValueAnimatorCompat(ValueAnimator.ofFloat(0.0f, 1.0f));
    }

    /* renamed from: android.support.v4.animation.HoneycombMr1AnimatorCompatProvider$HoneycombValueAnimatorCompat */
    static class HoneycombValueAnimatorCompat implements ValueAnimatorCompat {
        final Animator mWrapped;

        public HoneycombValueAnimatorCompat(Animator wrapped) {
            this.mWrapped = wrapped;
        }

        @Override // android.support.p007v4.animation.ValueAnimatorCompat
        public void setTarget(View view) {
            this.mWrapped.setTarget(view);
        }

        @Override // android.support.p007v4.animation.ValueAnimatorCompat
        public void addListener(AnimatorListenerCompat listener) {
            this.mWrapped.addListener(new AnimatorListenerCompatWrapper(listener, this));
        }

        @Override // android.support.p007v4.animation.ValueAnimatorCompat
        public void setDuration(long duration) {
            this.mWrapped.setDuration(duration);
        }

        @Override // android.support.p007v4.animation.ValueAnimatorCompat
        public void start() {
            this.mWrapped.start();
        }

        @Override // android.support.p007v4.animation.ValueAnimatorCompat
        public void cancel() {
            this.mWrapped.cancel();
        }

        @Override // android.support.p007v4.animation.ValueAnimatorCompat
        public void addUpdateListener(final AnimatorUpdateListenerCompat animatorUpdateListener) {
            if (this.mWrapped instanceof ValueAnimator) {
                ((ValueAnimator) this.mWrapped).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class android.support.p007v4.animation.HoneycombMr1AnimatorCompatProvider.HoneycombValueAnimatorCompat.C00591 */

                    public void onAnimationUpdate(ValueAnimator animation) {
                        animatorUpdateListener.onAnimationUpdate(HoneycombValueAnimatorCompat.this);
                    }
                });
            }
        }

        @Override // android.support.p007v4.animation.ValueAnimatorCompat
        public float getAnimatedFraction() {
            return ((ValueAnimator) this.mWrapped).getAnimatedFraction();
        }
    }

    /* renamed from: android.support.v4.animation.HoneycombMr1AnimatorCompatProvider$AnimatorListenerCompatWrapper */
    static class AnimatorListenerCompatWrapper implements Animator.AnimatorListener {
        final ValueAnimatorCompat mValueAnimatorCompat;
        final AnimatorListenerCompat mWrapped;

        public AnimatorListenerCompatWrapper(AnimatorListenerCompat wrapped, ValueAnimatorCompat valueAnimatorCompat) {
            this.mWrapped = wrapped;
            this.mValueAnimatorCompat = valueAnimatorCompat;
        }

        public void onAnimationStart(Animator animation) {
            this.mWrapped.onAnimationStart(this.mValueAnimatorCompat);
        }

        public void onAnimationEnd(Animator animation) {
            this.mWrapped.onAnimationEnd(this.mValueAnimatorCompat);
        }

        public void onAnimationCancel(Animator animation) {
            this.mWrapped.onAnimationCancel(this.mValueAnimatorCompat);
        }

        public void onAnimationRepeat(Animator animation) {
            this.mWrapped.onAnimationRepeat(this.mValueAnimatorCompat);
        }
    }

    @Override // android.support.p007v4.animation.AnimatorProvider
    public void clearInterpolator(View view) {
        if (this.mDefaultInterpolator == null) {
            this.mDefaultInterpolator = new ValueAnimator().getInterpolator();
        }
        view.animate().setInterpolator(this.mDefaultInterpolator);
    }
}
