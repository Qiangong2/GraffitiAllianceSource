package com.nineoldandroids.util;

public abstract class IntProperty<T> extends Property<T, Integer> {
    public IntProperty(String name) {
        super(Integer.class, name);
    }

    public final void set(T t, Integer value) {
        while (true) {
            value = Integer.valueOf(value.intValue());
        }
    }

    public abstract void setValue(T t, int i);
}
