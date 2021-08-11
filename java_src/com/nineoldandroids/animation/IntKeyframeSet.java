package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Keyframe;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
public class IntKeyframeSet extends KeyframeSet {
    private int deltaValue;
    private boolean firstTime = true;
    private int firstValue;
    private int lastValue;

    public IntKeyframeSet(Keyframe.IntKeyframe... keyframes) {
        super(keyframes);
    }

    @Override // com.nineoldandroids.animation.KeyframeSet, com.nineoldandroids.animation.KeyframeSet
    public IntKeyframeSet clone() {
        ArrayList arrayList = this.mKeyframes;
        int size = this.mKeyframes.size();
        Keyframe.IntKeyframe[] intKeyframeArr = new Keyframe.IntKeyframe[size];
        for (int i = 0; i < size; i++) {
            intKeyframeArr[i] = (Keyframe.IntKeyframe) ((Keyframe) arrayList.get(i)).clone();
        }
        return new IntKeyframeSet(intKeyframeArr);
    }

    public int getIntValue(float fraction) {
        if (this.mNumKeyframes == 2) {
            if (this.firstTime) {
                this.firstTime = false;
                this.firstValue = ((Keyframe.IntKeyframe) this.mKeyframes.get(0)).getIntValue();
                this.lastValue = ((Keyframe.IntKeyframe) this.mKeyframes.get(1)).getIntValue();
                this.deltaValue = this.lastValue - this.firstValue;
            }
            if (this.mInterpolator != null) {
                fraction = this.mInterpolator.getInterpolation(fraction);
            }
            return this.mEvaluator == null ? this.firstValue + ((int) (((float) this.deltaValue) * fraction)) : ((Number) this.mEvaluator.evaluate(fraction, Integer.valueOf(this.firstValue), Integer.valueOf(this.lastValue))).intValue();
        } else if (fraction <= 0.0f) {
            Keyframe.IntKeyframe intKeyframe = (Keyframe.IntKeyframe) this.mKeyframes.get(0);
            Keyframe.IntKeyframe intKeyframe2 = (Keyframe.IntKeyframe) this.mKeyframes.get(1);
            int intValue = intKeyframe.getIntValue();
            int intValue2 = intKeyframe2.getIntValue();
            float fraction2 = intKeyframe.getFraction();
            float fraction3 = intKeyframe2.getFraction();
            Interpolator interpolator = intKeyframe2.getInterpolator();
            if (interpolator != null) {
                fraction = interpolator.getInterpolation(fraction);
            }
            float f = (fraction - fraction2) / (fraction3 - fraction2);
            return this.mEvaluator == null ? ((int) (f * ((float) (intValue2 - intValue)))) + intValue : ((Number) this.mEvaluator.evaluate(f, Integer.valueOf(intValue), Integer.valueOf(intValue2))).intValue();
        } else if (fraction >= 1.0f) {
            Keyframe.IntKeyframe intKeyframe3 = (Keyframe.IntKeyframe) this.mKeyframes.get(this.mNumKeyframes - 2);
            Keyframe.IntKeyframe intKeyframe4 = (Keyframe.IntKeyframe) this.mKeyframes.get(this.mNumKeyframes - 1);
            int intValue3 = intKeyframe3.getIntValue();
            int intValue4 = intKeyframe4.getIntValue();
            float fraction4 = intKeyframe3.getFraction();
            float fraction5 = intKeyframe4.getFraction();
            Interpolator interpolator2 = intKeyframe4.getInterpolator();
            if (interpolator2 != null) {
                fraction = interpolator2.getInterpolation(fraction);
            }
            float f2 = (fraction - fraction4) / (fraction5 - fraction4);
            return this.mEvaluator == null ? ((int) (f2 * ((float) (intValue4 - intValue3)))) + intValue3 : ((Number) this.mEvaluator.evaluate(f2, Integer.valueOf(intValue3), Integer.valueOf(intValue4))).intValue();
        } else {
            Keyframe.IntKeyframe intKeyframe5 = (Keyframe.IntKeyframe) this.mKeyframes.get(0);
            for (int i = 1; i < this.mNumKeyframes; i++) {
                intKeyframe5 = (Keyframe.IntKeyframe) this.mKeyframes.get(i);
                if (fraction < intKeyframe5.getFraction()) {
                    Interpolator interpolator3 = intKeyframe5.getInterpolator();
                    if (interpolator3 != null) {
                        fraction = interpolator3.getInterpolation(fraction);
                    }
                    float fraction6 = (fraction - intKeyframe5.getFraction()) / (intKeyframe5.getFraction() - intKeyframe5.getFraction());
                    int intValue5 = intKeyframe5.getIntValue();
                    int intValue6 = intKeyframe5.getIntValue();
                    return this.mEvaluator == null ? ((int) (((float) (intValue6 - intValue5)) * fraction6)) + intValue5 : ((Number) this.mEvaluator.evaluate(fraction6, Integer.valueOf(intValue5), Integer.valueOf(intValue6))).intValue();
                }
            }
            return ((Number) ((Keyframe) this.mKeyframes.get(this.mNumKeyframes - 1)).getValue()).intValue();
        }
    }

    @Override // com.nineoldandroids.animation.KeyframeSet
    public Object getValue(float fraction) {
        return Integer.valueOf(getIntValue(fraction));
    }
}
