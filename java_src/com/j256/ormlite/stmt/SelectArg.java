package com.j256.ormlite.stmt;

import com.j256.ormlite.field.SqlType;

public class SelectArg extends BaseArgumentHolder implements ArgumentHolder {
    private boolean hasBeenSet = false;
    private Object value = null;

    public SelectArg() {
    }

    public SelectArg(String columnName, Object value2) {
        super(columnName);
        setValue(value2);
    }

    public SelectArg(SqlType sqlType, Object value2) {
        super(sqlType);
        setValue(value2);
    }

    public SelectArg(Object value2) {
        setValue(value2);
    }

    /* access modifiers changed from: protected */
    @Override // com.j256.ormlite.stmt.BaseArgumentHolder
    public Object getValue() {
        return this.value;
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder, com.j256.ormlite.stmt.BaseArgumentHolder
    public void setValue(Object value2) {
        this.hasBeenSet = true;
        this.value = value2;
    }

    /* access modifiers changed from: protected */
    @Override // com.j256.ormlite.stmt.BaseArgumentHolder
    public boolean isValueSet() {
        return this.hasBeenSet;
    }
}
