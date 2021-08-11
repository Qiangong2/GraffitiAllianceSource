package com.nineoldandroids.view;

import android.animation.Animator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import java.lang.ref.WeakReference;

class ViewPropertyAnimatorICS extends ViewPropertyAnimator {
    private static final long RETURN_WHEN_NULL = -1;
    private final WeakReference<ViewPropertyAnimator> mNative;

    ViewPropertyAnimatorICS(View view) {
        this.mNative = new WeakReference<>(view.animate());
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator alpha(float value) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alpha(value);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator alphaBy(float value) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alphaBy(value);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public void cancel() {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public long getDuration() {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            return viewPropertyAnimator.getDuration();
        }
        return -1;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public long getStartDelay() {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            return viewPropertyAnimator.getStartDelay();
        }
        return -1;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator rotation(float value) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotation(value);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator rotationBy(float value) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationBy(value);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator rotationX(float value) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationX(value);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator rotationXBy(float value) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationXBy(value);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator rotationY(float value) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationY(value);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator rotationYBy(float value) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationYBy(value);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator scaleX(float value) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleX(value);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator scaleXBy(float value) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleXBy(value);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator scaleY(float value) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleY(value);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator scaleYBy(float value) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleYBy(value);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator setDuration(long duration) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setDuration(duration);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator setInterpolator(Interpolator interpolator) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setInterpolator(interpolator);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator setListener(final Animator.AnimatorListener listener) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            if (listener == null) {
                viewPropertyAnimator.setListener(null);
            } else {
                viewPropertyAnimator.setListener(new Animator.AnimatorListener() {
                    /* class com.nineoldandroids.view.ViewPropertyAnimatorICS.C12151 */

                    public void onAnimationCancel(android.animation.Animator animation) {
                        listener.onAnimationCancel(null);
                    }

                    public void onAnimationEnd(android.animation.Animator animation) {
                        listener.onAnimationEnd(null);
                    }

                    public void onAnimationRepeat(android.animation.Animator animation) {
                        listener.onAnimationRepeat(null);
                    }

                    public void onAnimationStart(android.animation.Animator animation) {
                        listener.onAnimationStart(null);
                    }
                });
            }
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator setStartDelay(long startDelay) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setStartDelay(startDelay);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public void start() {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.start();
        }
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator translationX(float value) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationX(value);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator translationXBy(float value) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationXBy(value);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator translationY(float value) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationY(value);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator translationYBy(float value) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationYBy(value);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    /* renamed from: x */
    public ViewPropertyAnimator mo7071x(float value) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.x(value);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator xBy(float value) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.xBy(value);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    /* renamed from: y */
    public ViewPropertyAnimator mo7073y(float value) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.y(value);
        }
        return this;
    }

    @Override // com.nineoldandroids.view.ViewPropertyAnimator
    public ViewPropertyAnimator yBy(float value) {
        ViewPropertyAnimator viewPropertyAnimator = this.mNative.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.yBy(value);
        }
        return this;
    }
}
