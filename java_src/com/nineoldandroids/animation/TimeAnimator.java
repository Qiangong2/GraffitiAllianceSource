package com.nineoldandroids.animation;

public class TimeAnimator extends ValueAnimator {
    private TimeListener mListener;
    private long mPreviousTime = -1;

    public interface TimeListener {
        void onTimeUpdate(TimeAnimator timeAnimator, long j, long j2);
    }

    /* access modifiers changed from: package-private */
    @Override // com.nineoldandroids.animation.ValueAnimator
    public void animateValue(float fraction) {
    }

    /* access modifiers changed from: package-private */
    @Override // com.nineoldandroids.animation.ValueAnimator
    public boolean animationFrame(long currentTime) {
        long j = 0;
        if (this.mPlayingState == 0) {
            this.mPlayingState = 1;
            if (this.mSeekTime < 0) {
                this.mStartTime = currentTime;
            } else {
                this.mStartTime = currentTime - this.mSeekTime;
                this.mSeekTime = -1;
            }
        }
        if (this.mListener == null) {
            return false;
        }
        long j2 = currentTime - this.mStartTime;
        if (this.mPreviousTime >= 0) {
            j = currentTime - this.mPreviousTime;
        }
        this.mPreviousTime = currentTime;
        this.mListener.onTimeUpdate(this, j2, j);
        return false;
    }

    /* access modifiers changed from: package-private */
    @Override // com.nineoldandroids.animation.ValueAnimator
    public void initAnimation() {
    }

    public void setTimeListener(TimeListener listener) {
        this.mListener = listener;
    }
}
