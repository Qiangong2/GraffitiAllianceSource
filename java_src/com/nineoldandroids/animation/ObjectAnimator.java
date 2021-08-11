package com.nineoldandroids.animation;

import android.view.View;
import com.nineoldandroids.util.Property;
import com.nineoldandroids.view.p084a.C1217a;
import java.util.HashMap;
import java.util.Map;

public final class ObjectAnimator extends ValueAnimator {
    private static final boolean DBG = false;
    private static final Map<String, Property> PROXY_PROPERTIES;
    private Property mProperty;
    private String mPropertyName;
    private Object mTarget;

    static {
        HashMap hashMap = new HashMap();
        PROXY_PROPERTIES = hashMap;
        hashMap.put("alpha", PreHoneycombCompat.ALPHA);
        PROXY_PROPERTIES.put("pivotX", PreHoneycombCompat.PIVOT_X);
        PROXY_PROPERTIES.put("pivotY", PreHoneycombCompat.PIVOT_Y);
        PROXY_PROPERTIES.put("translationX", PreHoneycombCompat.TRANSLATION_X);
        PROXY_PROPERTIES.put("translationY", PreHoneycombCompat.TRANSLATION_Y);
        PROXY_PROPERTIES.put("rotation", PreHoneycombCompat.ROTATION);
        PROXY_PROPERTIES.put("rotationX", PreHoneycombCompat.ROTATION_X);
        PROXY_PROPERTIES.put("rotationY", PreHoneycombCompat.ROTATION_Y);
        PROXY_PROPERTIES.put("scaleX", PreHoneycombCompat.SCALE_X);
        PROXY_PROPERTIES.put("scaleY", PreHoneycombCompat.SCALE_Y);
        PROXY_PROPERTIES.put("scrollX", PreHoneycombCompat.SCROLL_X);
        PROXY_PROPERTIES.put("scrollY", PreHoneycombCompat.SCROLL_Y);
        PROXY_PROPERTIES.put("x", PreHoneycombCompat.f3089X);
        PROXY_PROPERTIES.put("y", PreHoneycombCompat.f3090Y);
    }

    public ObjectAnimator() {
    }

    private <T> ObjectAnimator(T target, Property<T, ?> property) {
        this.mTarget = target;
        setProperty(property);
    }

    private ObjectAnimator(Object target, String propertyName) {
        this.mTarget = target;
        setPropertyName(propertyName);
    }

    public static <T> ObjectAnimator ofFloat(T target, Property<T, Float> property, float... values) {
        ObjectAnimator objectAnimator = new ObjectAnimator(target, property);
        objectAnimator.setFloatValues(values);
        return objectAnimator;
    }

    public static ObjectAnimator ofFloat(Object target, String propertyName, float... values) {
        ObjectAnimator objectAnimator = new ObjectAnimator(target, propertyName);
        objectAnimator.setFloatValues(values);
        return objectAnimator;
    }

    public static <T> ObjectAnimator ofInt(T target, Property<T, Integer> property, int... values) {
        ObjectAnimator objectAnimator = new ObjectAnimator(target, property);
        objectAnimator.setIntValues(values);
        return objectAnimator;
    }

    public static ObjectAnimator ofInt(Object target, String propertyName, int... values) {
        ObjectAnimator objectAnimator = new ObjectAnimator(target, propertyName);
        objectAnimator.setIntValues(values);
        return objectAnimator;
    }

    public static <T, V> ObjectAnimator ofObject(T target, Property<T, V> property, TypeEvaluator<V> evaluator, V... values) {
        ObjectAnimator objectAnimator = new ObjectAnimator(target, property);
        objectAnimator.setObjectValues(values);
        objectAnimator.setEvaluator(evaluator);
        return objectAnimator;
    }

    public static ObjectAnimator ofObject(Object target, String propertyName, TypeEvaluator evaluator, Object... values) {
        ObjectAnimator objectAnimator = new ObjectAnimator(target, propertyName);
        objectAnimator.setObjectValues(values);
        objectAnimator.setEvaluator(evaluator);
        return objectAnimator;
    }

    public static ObjectAnimator ofPropertyValuesHolder(Object target, PropertyValuesHolder... values) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.mTarget = target;
        objectAnimator.setValues(values);
        return objectAnimator;
    }

    /* access modifiers changed from: package-private */
    @Override // com.nineoldandroids.animation.ValueAnimator
    public void animateValue(float fraction) {
        super.animateValue(fraction);
        int length = this.mValues.length;
        for (int i = 0; i < length; i++) {
            this.mValues[i].setAnimatedValue(this.mTarget);
        }
    }

    @Override // com.nineoldandroids.animation.ValueAnimator, com.nineoldandroids.animation.ValueAnimator, com.nineoldandroids.animation.ValueAnimator, com.nineoldandroids.animation.Animator, com.nineoldandroids.animation.Animator, java.lang.Object
    public ObjectAnimator clone() {
        return (ObjectAnimator) super.clone();
    }

    public String getPropertyName() {
        return this.mPropertyName;
    }

    public Object getTarget() {
        return this.mTarget;
    }

    /* access modifiers changed from: package-private */
    @Override // com.nineoldandroids.animation.ValueAnimator
    public void initAnimation() {
        if (!this.mInitialized) {
            if (this.mProperty == null && C1217a.f3095a && (this.mTarget instanceof View) && PROXY_PROPERTIES.containsKey(this.mPropertyName)) {
                setProperty(PROXY_PROPERTIES.get(this.mPropertyName));
            }
            int length = this.mValues.length;
            for (int i = 0; i < length; i++) {
                this.mValues[i].setupSetterAndGetter(this.mTarget);
            }
            super.initAnimation();
        }
    }

    @Override // com.nineoldandroids.animation.ValueAnimator, com.nineoldandroids.animation.ValueAnimator, com.nineoldandroids.animation.Animator
    public ObjectAnimator setDuration(long duration) {
        super.setDuration(duration);
        return this;
    }

    @Override // com.nineoldandroids.animation.ValueAnimator
    public void setFloatValues(float... values) {
        if (this.mValues != null && this.mValues.length != 0) {
            super.setFloatValues(values);
        } else if (this.mProperty != null) {
            setValues(PropertyValuesHolder.ofFloat(this.mProperty, values));
        } else {
            setValues(PropertyValuesHolder.ofFloat(this.mPropertyName, values));
        }
    }

    @Override // com.nineoldandroids.animation.ValueAnimator
    public void setIntValues(int... values) {
        if (this.mValues != null && this.mValues.length != 0) {
            super.setIntValues(values);
        } else if (this.mProperty != null) {
            setValues(PropertyValuesHolder.ofInt(this.mProperty, values));
        } else {
            setValues(PropertyValuesHolder.ofInt(this.mPropertyName, values));
        }
    }

    @Override // com.nineoldandroids.animation.ValueAnimator
    public void setObjectValues(Object... values) {
        if (this.mValues != null && this.mValues.length != 0) {
            super.setObjectValues(values);
        } else if (this.mProperty != null) {
            setValues(PropertyValuesHolder.ofObject(this.mProperty, (TypeEvaluator) null, values));
        } else {
            setValues(PropertyValuesHolder.ofObject(this.mPropertyName, (TypeEvaluator) null, values));
        }
    }

    public void setProperty(Property property) {
        if (this.mValues != null) {
            PropertyValuesHolder propertyValuesHolder = this.mValues[0];
            String propertyName = propertyValuesHolder.getPropertyName();
            propertyValuesHolder.setProperty(property);
            this.mValuesMap.remove(propertyName);
            this.mValuesMap.put(this.mPropertyName, propertyValuesHolder);
        }
        if (this.mProperty != null) {
            this.mPropertyName = property.getName();
        }
        this.mProperty = property;
        this.mInitialized = false;
    }

    public void setPropertyName(String propertyName) {
        if (this.mValues != null) {
            PropertyValuesHolder propertyValuesHolder = this.mValues[0];
            String propertyName2 = propertyValuesHolder.getPropertyName();
            propertyValuesHolder.setPropertyName(propertyName);
            this.mValuesMap.remove(propertyName2);
            this.mValuesMap.put(propertyName, propertyValuesHolder);
        }
        this.mPropertyName = propertyName;
        this.mInitialized = false;
    }

    @Override // com.nineoldandroids.animation.Animator
    public void setTarget(Object target) {
        if (this.mTarget != target) {
            Object obj = this.mTarget;
            this.mTarget = target;
            if (obj == null || target == null || obj.getClass() != target.getClass()) {
                this.mInitialized = false;
            }
        }
    }

    @Override // com.nineoldandroids.animation.Animator
    public void setupEndValues() {
        initAnimation();
        int length = this.mValues.length;
        for (int i = 0; i < length; i++) {
            this.mValues[i].setupEndValue(this.mTarget);
        }
    }

    @Override // com.nineoldandroids.animation.Animator
    public void setupStartValues() {
        initAnimation();
        int length = this.mValues.length;
        for (int i = 0; i < length; i++) {
            this.mValues[i].setupStartValue(this.mTarget);
        }
    }

    @Override // com.nineoldandroids.animation.ValueAnimator, com.nineoldandroids.animation.Animator
    public void start() {
        super.start();
    }

    @Override // com.nineoldandroids.animation.ValueAnimator
    public String toString() {
        String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.mTarget;
        if (this.mValues != null) {
            for (int i = 0; i < this.mValues.length; i++) {
                str = str + "\n    " + this.mValues[i].toString();
            }
        }
        return str;
    }
}
