package com.nineoldandroids.util;

public abstract class FloatProperty<T> extends Property<T, Float> {
    public FloatProperty(String name) {
        super(Float.class, name);
    }

    public final void set(T object, Float value) {
        setValue(object, value.floatValue());
    }

    public abstract void setValue(T t, float f);
}
