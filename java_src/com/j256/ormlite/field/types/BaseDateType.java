package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BaseDateType extends BaseDataType {
    protected static final DateStringFormatConfig defaultDateFormatConfig = new DateStringFormatConfig("yyyy-MM-dd HH:mm:ss.SSS");

    protected BaseDateType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    protected static DateStringFormatConfig convertDateStringConfig(FieldType fieldType, DateStringFormatConfig defaultDateFormatConfig2) {
        DateStringFormatConfig configObj;
        return (fieldType == null || (configObj = (DateStringFormatConfig) fieldType.getDataTypeConfigObj()) == null) ? defaultDateFormatConfig2 : configObj;
    }

    protected static Date parseDateString(DateStringFormatConfig formatConfig, String dateStr) throws ParseException {
        return formatConfig.getDateFormat().parse(dateStr);
    }

    protected static String normalizeDateString(DateStringFormatConfig formatConfig, String dateStr) throws ParseException {
        DateFormat dateFormat = formatConfig.getDateFormat();
        return dateFormat.format(dateFormat.parse(dateStr));
    }

    /* access modifiers changed from: protected */
    public static class DateStringFormatConfig {
        final String dateFormatStr;
        private final ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>() {
            /* class com.j256.ormlite.field.types.BaseDateType.DateStringFormatConfig.C11891 */

            /* access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            public DateFormat initialValue() {
                return new SimpleDateFormat(DateStringFormatConfig.this.dateFormatStr);
            }
        };

        public DateStringFormatConfig(String dateFormatStr2) {
            this.dateFormatStr = dateFormatStr2;
        }

        public DateFormat getDateFormat() {
            return this.threadLocal.get();
        }

        public String toString() {
            return this.dateFormatStr;
        }
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isValidForVersion() {
        return true;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Object moveToNextValue(Object currentValue) {
        long newVal = System.currentTimeMillis();
        if (currentValue == null) {
            return new Date(newVal);
        }
        if (newVal == ((Date) currentValue).getTime()) {
            return new Date(1 + newVal);
        }
        return new Date(newVal);
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isValidForField(Field field) {
        return field.getType() == Date.class;
    }
}
