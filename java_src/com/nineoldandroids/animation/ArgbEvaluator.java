package com.nineoldandroids.animation;

public class ArgbEvaluator implements TypeEvaluator {
    @Override // com.nineoldandroids.animation.TypeEvaluator
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        int intValue = ((Integer) startValue).intValue();
        int i = intValue >> 24;
        int i2 = (intValue >> 16) & 255;
        int i3 = (intValue >> 8) & 255;
        int i4 = intValue & 255;
        int intValue2 = ((Integer) endValue).intValue();
        return Integer.valueOf((i4 + ((int) (((float) ((intValue2 & 255) - i4)) * fraction))) | ((i + ((int) (((float) ((intValue2 >> 24) - i)) * fraction))) << 24) | ((i2 + ((int) (((float) (((intValue2 >> 16) & 255) - i2)) * fraction))) << 16) | ((((int) (((float) (((intValue2 >> 8) & 255) - i3)) * fraction)) + i3) << 8));
    }
}
