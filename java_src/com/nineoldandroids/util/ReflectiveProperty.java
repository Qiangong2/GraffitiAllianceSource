package com.nineoldandroids.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ReflectiveProperty<T, V> extends Property<T, V> {
    private static final String PREFIX_GET = "get";
    private static final String PREFIX_IS = "is";
    private static final String PREFIX_SET = "set";
    private Field mField;
    private Method mGetter;
    private Method mSetter;

    public ReflectiveProperty(Class<T> propertyHolder, Class<V> valueType, String name) {
        super(valueType, name);
        String str = Character.toUpperCase(name.charAt(0)) + name.substring(1);
        String str2 = PREFIX_GET + str;
        try {
            this.mGetter = propertyHolder.getMethod(str2, null);
        } catch (NoSuchMethodException e) {
            try {
                this.mGetter = propertyHolder.getDeclaredMethod(str2, null);
                this.mGetter.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                String str3 = PREFIX_IS + str;
                try {
                    this.mGetter = propertyHolder.getMethod(str3, null);
                } catch (NoSuchMethodException e3) {
                    try {
                        this.mGetter = propertyHolder.getDeclaredMethod(str3, null);
                        this.mGetter.setAccessible(true);
                    } catch (NoSuchMethodException e4) {
                        this.mField = propertyHolder.getField(name);
                        Class<?> type = this.mField.getType();
                        if (!typesMatch(valueType, type)) {
                            throw new NoSuchPropertyException("Underlying type (" + type + ") does not match Property type (" + valueType + ")");
                        }
                        return;
                    } catch (NoSuchFieldException e5) {
                        throw new NoSuchPropertyException("No accessor method or field found for property with name " + name);
                    }
                }
            }
        }
        Class<?> returnType = this.mGetter.getReturnType();
        if (!typesMatch(valueType, returnType)) {
            throw new NoSuchPropertyException("Underlying type (" + returnType + ") does not match Property type (" + valueType + ")");
        }
        try {
            this.mSetter = propertyHolder.getDeclaredMethod(PREFIX_SET + str, returnType);
            this.mSetter.setAccessible(true);
        } catch (NoSuchMethodException e6) {
        }
    }

    private boolean typesMatch(Class<V> valueType, Class getterType) {
        if (getterType == valueType) {
            return true;
        }
        if (getterType.isPrimitive()) {
            return (getterType == Float.TYPE && valueType == Float.class) || (getterType == Integer.TYPE && valueType == Integer.class) || ((getterType == Boolean.TYPE && valueType == Boolean.class) || ((getterType == Long.TYPE && valueType == Long.class) || ((getterType == Double.TYPE && valueType == Double.class) || ((getterType == Short.TYPE && valueType == Short.class) || ((getterType == Byte.TYPE && valueType == Byte.class) || (getterType == Character.TYPE && valueType == Character.class))))));
        }
        return false;
    }

    @Override // com.nineoldandroids.util.Property
    public V get(T object) {
        if (this.mGetter != null) {
            try {
                return (V) this.mGetter.invoke(object, null);
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        } else if (this.mField != null) {
            try {
                return (V) this.mField.get(object);
            } catch (IllegalAccessException e3) {
                throw new AssertionError();
            }
        } else {
            throw new AssertionError();
        }
    }

    @Override // com.nineoldandroids.util.Property
    public boolean isReadOnly() {
        return this.mSetter == null && this.mField == null;
    }

    @Override // com.nineoldandroids.util.Property
    public void set(T object, V value) {
        if (this.mSetter != null) {
            try {
                this.mSetter.invoke(object, value);
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        } else if (this.mField != null) {
            try {
                this.mField.set(object, value);
            } catch (IllegalAccessException e3) {
                throw new AssertionError();
            }
        } else {
            throw new UnsupportedOperationException("Property " + getName() + " is read-only");
        }
    }
}
