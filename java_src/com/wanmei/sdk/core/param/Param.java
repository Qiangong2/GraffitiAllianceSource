package com.wanmei.sdk.core.param;

public class Param<T> {
    private String name;
    private boolean notNull;
    private String value;

    public Param(String name2, String value2, boolean notNull2) {
        this.name = name2;
        this.value = value2;
        this.notNull = notNull2;
    }

    public boolean getBooleanValue() {
        return Boolean.valueOf(this.value).booleanValue();
    }

    public double getDoubleValue() {
        return Double.valueOf(this.value).doubleValue();
    }

    public float getFloatValue() {
        return Float.valueOf(this.value).floatValue();
    }

    public int getIntValue() {
        return Integer.valueOf(this.value).intValue();
    }

    public long getLongValue() {
        return Long.valueOf(this.value).longValue();
    }

    public String getName() {
        return this.name;
    }

    public short getShortValue() {
        return Short.valueOf(this.value).shortValue();
    }

    public String getStringValue() {
        return String.valueOf(this.value);
    }

    public Object getValue() {
        return this.value;
    }

    public boolean isNotNull() {
        return this.notNull;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public void setNotNull(boolean notNull2) {
        this.notNull = notNull2;
    }

    public void setValue(String value2) {
        this.value = value2;
    }
}
