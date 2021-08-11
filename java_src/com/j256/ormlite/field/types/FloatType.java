package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

public class FloatType extends FloatObjectType {
    private static final FloatType singleTon = new FloatType();

    public static FloatType getSingleton() {
        return singleTon;
    }

    private FloatType() {
        super(SqlType.FLOAT, new Class[]{Float.TYPE});
    }

    protected FloatType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isPrimitive() {
        return true;
    }
}
