package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Keyframe;
import java.util.ArrayList;
import java.util.Arrays;

/* access modifiers changed from: package-private */
public class KeyframeSet {
    TypeEvaluator mEvaluator;
    Keyframe mFirstKeyframe;
    Interpolator mInterpolator;
    ArrayList<Keyframe> mKeyframes = new ArrayList<>();
    Keyframe mLastKeyframe;
    int mNumKeyframes;

    public KeyframeSet(Keyframe... keyframes) {
        this.mNumKeyframes = keyframes.length;
        this.mKeyframes.addAll(Arrays.asList(keyframes));
        this.mFirstKeyframe = this.mKeyframes.get(0);
        this.mLastKeyframe = this.mKeyframes.get(this.mNumKeyframes - 1);
        this.mInterpolator = this.mLastKeyframe.getInterpolator();
    }

    public static KeyframeSet ofFloat(float... values) {
        int length = values.length;
        Keyframe.FloatKeyframe[] floatKeyframeArr = new Keyframe.FloatKeyframe[Math.max(length, 2)];
        if (length == 1) {
            floatKeyframeArr[0] = (Keyframe.FloatKeyframe) Keyframe.ofFloat(0.0f);
            floatKeyframeArr[1] = (Keyframe.FloatKeyframe) Keyframe.ofFloat(1.0f, values[0]);
        } else {
            floatKeyframeArr[0] = (Keyframe.FloatKeyframe) Keyframe.ofFloat(0.0f, values[0]);
            for (int i = 1; i < length; i++) {
                floatKeyframeArr[i] = (Keyframe.FloatKeyframe) Keyframe.ofFloat(((float) i) / ((float) (length - 1)), values[i]);
            }
        }
        return new FloatKeyframeSet(floatKeyframeArr);
    }

    public static KeyframeSet ofInt(int... values) {
        int length = values.length;
        Keyframe.IntKeyframe[] intKeyframeArr = new Keyframe.IntKeyframe[Math.max(length, 2)];
        if (length == 1) {
            intKeyframeArr[0] = (Keyframe.IntKeyframe) Keyframe.ofInt(0.0f);
            intKeyframeArr[1] = (Keyframe.IntKeyframe) Keyframe.ofInt(1.0f, values[0]);
        } else {
            intKeyframeArr[0] = (Keyframe.IntKeyframe) Keyframe.ofInt(0.0f, values[0]);
            for (int i = 1; i < length; i++) {
                intKeyframeArr[i] = (Keyframe.IntKeyframe) Keyframe.ofInt(((float) i) / ((float) (length - 1)), values[i]);
            }
        }
        return new IntKeyframeSet(intKeyframeArr);
    }

    public static KeyframeSet ofKeyframe(Keyframe... keyframes) {
        int length = keyframes.length;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i = 0; i < length; i++) {
            if (keyframes[i] instanceof Keyframe.FloatKeyframe) {
                z3 = true;
            } else if (keyframes[i] instanceof Keyframe.IntKeyframe) {
                z2 = true;
            } else {
                z = true;
            }
        }
        if (z3 && !z2 && !z) {
            Keyframe.FloatKeyframe[] floatKeyframeArr = new Keyframe.FloatKeyframe[length];
            for (int i2 = 0; i2 < length; i2++) {
                floatKeyframeArr[i2] = (Keyframe.FloatKeyframe) keyframes[i2];
            }
            return new FloatKeyframeSet(floatKeyframeArr);
        } else if (!z2 || z3 || z) {
            return new KeyframeSet(keyframes);
        } else {
            Keyframe.IntKeyframe[] intKeyframeArr = new Keyframe.IntKeyframe[length];
            for (int i3 = 0; i3 < length; i3++) {
                intKeyframeArr[i3] = (Keyframe.IntKeyframe) keyframes[i3];
            }
            return new IntKeyframeSet(intKeyframeArr);
        }
    }

    public static KeyframeSet ofObject(Object... values) {
        int length = values.length;
        Keyframe.ObjectKeyframe[] objectKeyframeArr = new Keyframe.ObjectKeyframe[Math.max(length, 2)];
        if (length == 1) {
            objectKeyframeArr[0] = (Keyframe.ObjectKeyframe) Keyframe.ofObject(0.0f);
            objectKeyframeArr[1] = (Keyframe.ObjectKeyframe) Keyframe.ofObject(1.0f, values[0]);
        } else {
            objectKeyframeArr[0] = (Keyframe.ObjectKeyframe) Keyframe.ofObject(0.0f, values[0]);
            for (int i = 1; i < length; i++) {
                objectKeyframeArr[i] = (Keyframe.ObjectKeyframe) Keyframe.ofObject(((float) i) / ((float) (length - 1)), values[i]);
            }
        }
        return new KeyframeSet(objectKeyframeArr);
    }

    public KeyframeSet clone() {
        ArrayList<Keyframe> arrayList = this.mKeyframes;
        int size = this.mKeyframes.size();
        Keyframe[] keyframeArr = new Keyframe[size];
        for (int i = 0; i < size; i++) {
            keyframeArr[i] = arrayList.get(i).clone();
        }
        return new KeyframeSet(keyframeArr);
    }

    public Object getValue(float fraction) {
        if (this.mNumKeyframes == 2) {
            if (this.mInterpolator != null) {
                fraction = this.mInterpolator.getInterpolation(fraction);
            }
            return this.mEvaluator.evaluate(fraction, this.mFirstKeyframe.getValue(), this.mLastKeyframe.getValue());
        } else if (fraction <= 0.0f) {
            Keyframe keyframe = this.mKeyframes.get(1);
            Interpolator interpolator = keyframe.getInterpolator();
            if (interpolator != null) {
                fraction = interpolator.getInterpolation(fraction);
            }
            float fraction2 = this.mFirstKeyframe.getFraction();
            return this.mEvaluator.evaluate((fraction - fraction2) / (keyframe.getFraction() - fraction2), this.mFirstKeyframe.getValue(), keyframe.getValue());
        } else if (fraction >= 1.0f) {
            Keyframe keyframe2 = this.mKeyframes.get(this.mNumKeyframes - 2);
            Interpolator interpolator2 = this.mLastKeyframe.getInterpolator();
            if (interpolator2 != null) {
                fraction = interpolator2.getInterpolation(fraction);
            }
            float fraction3 = keyframe2.getFraction();
            return this.mEvaluator.evaluate((fraction - fraction3) / (this.mLastKeyframe.getFraction() - fraction3), keyframe2.getValue(), this.mLastKeyframe.getValue());
        } else {
            Keyframe keyframe3 = this.mFirstKeyframe;
            int i = 1;
            while (i < this.mNumKeyframes) {
                Keyframe keyframe4 = this.mKeyframes.get(i);
                if (fraction < keyframe4.getFraction()) {
                    Interpolator interpolator3 = keyframe4.getInterpolator();
                    if (interpolator3 != null) {
                        fraction = interpolator3.getInterpolation(fraction);
                    }
                    float fraction4 = keyframe3.getFraction();
                    return this.mEvaluator.evaluate((fraction - fraction4) / (keyframe4.getFraction() - fraction4), keyframe3.getValue(), keyframe4.getValue());
                }
                i++;
                keyframe3 = keyframe4;
            }
            return this.mLastKeyframe.getValue();
        }
    }

    public void setEvaluator(TypeEvaluator evaluator) {
        this.mEvaluator = evaluator;
    }

    public String toString() {
        String str = " ";
        int i = 0;
        while (i < this.mNumKeyframes) {
            String str2 = str + this.mKeyframes.get(i).getValue() + "  ";
            i++;
            str = str2;
        }
        return str;
    }
}
