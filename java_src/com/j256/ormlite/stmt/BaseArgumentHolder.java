package com.j256.ormlite.stmt;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.sql.SQLException;

public abstract class BaseArgumentHolder implements ArgumentHolder {
    private String columnName = null;
    private FieldType fieldType = null;
    private SqlType sqlType = null;

    /* access modifiers changed from: protected */
    public abstract Object getValue();

    /* access modifiers changed from: protected */
    public abstract boolean isValueSet();

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public abstract void setValue(Object obj);

    public BaseArgumentHolder() {
    }

    public BaseArgumentHolder(String columName) {
        this.columnName = columName;
    }

    public BaseArgumentHolder(SqlType sqlType2) {
        this.sqlType = sqlType2;
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public String getColumnName() {
        return this.columnName;
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public void setMetaInfo(String columnName2) {
        if (this.columnName == null || this.columnName.equals(columnName2)) {
            this.columnName = columnName2;
            return;
        }
        throw new IllegalArgumentException("Column name cannot be set twice from " + this.columnName + " to " + columnName2 + ".  Using a SelectArg twice in query with different columns?");
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public void setMetaInfo(FieldType fieldType2) {
        if (this.fieldType == null || this.fieldType == fieldType2) {
            this.fieldType = fieldType2;
            return;
        }
        throw new IllegalArgumentException("FieldType name cannot be set twice from " + this.fieldType + " to " + fieldType2 + ".  Using a SelectArg twice in query with different columns?");
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public void setMetaInfo(String columnName2, FieldType fieldType2) {
        setMetaInfo(columnName2);
        setMetaInfo(fieldType2);
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public Object getSqlArgValue() throws SQLException {
        if (!isValueSet()) {
            throw new SQLException("Column value has not been set for " + this.columnName);
        }
        Object value = getValue();
        if (value == null) {
            return null;
        }
        if (this.fieldType == null) {
            return value;
        }
        if (!this.fieldType.isForeign() || this.fieldType.getType() != value.getClass()) {
            return this.fieldType.convertJavaFieldToSqlArgValue(value);
        }
        return this.fieldType.getForeignIdField().extractJavaFieldValue(value);
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public FieldType getFieldType() {
        return this.fieldType;
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public SqlType getSqlType() {
        return this.sqlType;
    }

    public String toString() {
        if (!isValueSet()) {
            return "[unset]";
        }
        try {
            Object val = getSqlArgValue();
            if (val == null) {
                return "[null]";
            }
            return val.toString();
        } catch (SQLException e) {
            return "[could not get value: " + e + "]";
        }
    }
}
