package com.nineoldandroids.util;

public abstract class Property<T, V> {
    private final String mName;
    private final Class<V> mType;

    public Property(Class<V> type, String name) {
        this.mName = name;
        this.mType = type;
    }

    /* renamed from: of */
    public static <T, V> Property<T, V> m4847of(Class<T> hostType, Class<V> valueType, String name) {
        return new ReflectiveProperty(hostType, valueType, name);
    }

    public abstract V get(T t);

    public String getName() {
        return this.mName;
    }

    public Class<V> getType() {
        return this.mType;
    }

    public boolean isReadOnly() {
        return false;
    }

    public void set(T t, V v) {
        throw new UnsupportedOperationException("Property " + getName() + " is read-only");
    }
}
