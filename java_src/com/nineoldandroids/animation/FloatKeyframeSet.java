package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Keyframe;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
public class FloatKeyframeSet extends KeyframeSet {
    private float deltaValue;
    private boolean firstTime = true;
    private float firstValue;
    private float lastValue;

    public FloatKeyframeSet(Keyframe.FloatKeyframe... keyframes) {
        super(keyframes);
    }

    @Override // com.nineoldandroids.animation.KeyframeSet, com.nineoldandroids.animation.KeyframeSet
    public FloatKeyframeSet clone() {
        ArrayList arrayList = this.mKeyframes;
        int size = this.mKeyframes.size();
        Keyframe.FloatKeyframe[] floatKeyframeArr = new Keyframe.FloatKeyframe[size];
        for (int i = 0; i < size; i++) {
            floatKeyframeArr[i] = (Keyframe.FloatKeyframe) ((Keyframe) arrayList.get(i)).clone();
        }
        return new FloatKeyframeSet(floatKeyframeArr);
    }

    public float getFloatValue(float fraction) {
        if (this.mNumKeyframes == 2) {
            if (this.firstTime) {
                this.firstTime = false;
                this.firstValue = ((Keyframe.FloatKeyframe) this.mKeyframes.get(0)).getFloatValue();
                this.lastValue = ((Keyframe.FloatKeyframe) this.mKeyframes.get(1)).getFloatValue();
                this.deltaValue = this.lastValue - this.firstValue;
            }
            if (this.mInterpolator != null) {
                fraction = this.mInterpolator.getInterpolation(fraction);
            }
            return this.mEvaluator == null ? this.firstValue + (this.deltaValue * fraction) : ((Number) this.mEvaluator.evaluate(fraction, Float.valueOf(this.firstValue), Float.valueOf(this.lastValue))).floatValue();
        } else if (fraction <= 0.0f) {
            Keyframe.FloatKeyframe floatKeyframe = (Keyframe.FloatKeyframe) this.mKeyframes.get(0);
            Keyframe.FloatKeyframe floatKeyframe2 = (Keyframe.FloatKeyframe) this.mKeyframes.get(1);
            float floatValue = floatKeyframe.getFloatValue();
            float floatValue2 = floatKeyframe2.getFloatValue();
            float fraction2 = floatKeyframe.getFraction();
            float fraction3 = floatKeyframe2.getFraction();
            Interpolator interpolator = floatKeyframe2.getInterpolator();
            if (interpolator != null) {
                fraction = interpolator.getInterpolation(fraction);
            }
            float f = (fraction - fraction2) / (fraction3 - fraction2);
            return this.mEvaluator == null ? (f * (floatValue2 - floatValue)) + floatValue : ((Number) this.mEvaluator.evaluate(f, Float.valueOf(floatValue), Float.valueOf(floatValue2))).floatValue();
        } else if (fraction >= 1.0f) {
            Keyframe.FloatKeyframe floatKeyframe3 = (Keyframe.FloatKeyframe) this.mKeyframes.get(this.mNumKeyframes - 2);
            Keyframe.FloatKeyframe floatKeyframe4 = (Keyframe.FloatKeyframe) this.mKeyframes.get(this.mNumKeyframes - 1);
            float floatValue3 = floatKeyframe3.getFloatValue();
            float floatValue4 = floatKeyframe4.getFloatValue();
            float fraction4 = floatKeyframe3.getFraction();
            float fraction5 = floatKeyframe4.getFraction();
            Interpolator interpolator2 = floatKeyframe4.getInterpolator();
            if (interpolator2 != null) {
                fraction = interpolator2.getInterpolation(fraction);
            }
            float f2 = (fraction - fraction4) / (fraction5 - fraction4);
            return this.mEvaluator == null ? (f2 * (floatValue4 - floatValue3)) + floatValue3 : ((Number) this.mEvaluator.evaluate(f2, Float.valueOf(floatValue3), Float.valueOf(floatValue4))).floatValue();
        } else {
            Keyframe.FloatKeyframe floatKeyframe5 = (Keyframe.FloatKeyframe) this.mKeyframes.get(0);
            for (int i = 1; i < this.mNumKeyframes; i++) {
                floatKeyframe5 = (Keyframe.FloatKeyframe) this.mKeyframes.get(i);
                if (fraction < floatKeyframe5.getFraction()) {
                    Interpolator interpolator3 = floatKeyframe5.getInterpolator();
                    if (interpolator3 != null) {
                        fraction = interpolator3.getInterpolation(fraction);
                    }
                    float fraction6 = (fraction - floatKeyframe5.getFraction()) / (floatKeyframe5.getFraction() - floatKeyframe5.getFraction());
                    float floatValue5 = floatKeyframe5.getFloatValue();
                    float floatValue6 = floatKeyframe5.getFloatValue();
                    return this.mEvaluator == null ? ((floatValue6 - floatValue5) * fraction6) + floatValue5 : ((Number) this.mEvaluator.evaluate(fraction6, Float.valueOf(floatValue5), Float.valueOf(floatValue6))).floatValue();
                }
            }
            return ((Number) ((Keyframe) this.mKeyframes.get(this.mNumKeyframes - 1)).getValue()).floatValue();
        }
    }

    @Override // com.nineoldandroids.animation.KeyframeSet
    public Object getValue(float fraction) {
        return Float.valueOf(getFloatValue(fraction));
    }
}
