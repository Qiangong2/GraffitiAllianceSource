package com.nineoldandroids.animation;

public class FloatEvaluator implements TypeEvaluator<Number> {
    public Float evaluate(float fraction, Number startValue, Number endValue) {
        float floatValue = startValue.floatValue();
        return Float.valueOf(floatValue + ((endValue.floatValue() - floatValue) * fraction));
    }
}
