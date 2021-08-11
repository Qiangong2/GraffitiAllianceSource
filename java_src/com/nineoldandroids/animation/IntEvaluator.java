package com.nineoldandroids.animation;

public class IntEvaluator implements TypeEvaluator<Integer> {
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        int intValue = startValue.intValue();
        return Integer.valueOf((int) ((((float) (endValue.intValue() - intValue)) * fraction) + ((float) intValue)));
    }
}
