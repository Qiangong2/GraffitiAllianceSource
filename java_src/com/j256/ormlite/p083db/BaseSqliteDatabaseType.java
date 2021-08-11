package com.j256.ormlite.p083db;

import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldConverter;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.types.BigDecimalStringType;
import com.j256.ormlite.p083db.BaseDatabaseType;
import java.util.List;

/* renamed from: com.j256.ormlite.db.BaseSqliteDatabaseType */
public abstract class BaseSqliteDatabaseType extends BaseDatabaseType implements DatabaseType {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$j256$ormlite$field$SqlType;
    private static final FieldConverter booleanConverter = new BaseDatabaseType.BooleanNumberFieldConverter();

    static /* synthetic */ int[] $SWITCH_TABLE$com$j256$ormlite$field$SqlType() {
        int[] iArr = $SWITCH_TABLE$com$j256$ormlite$field$SqlType;
        if (iArr == null) {
            iArr = new int[SqlType.values().length];
            try {
                iArr[SqlType.BIG_DECIMAL.ordinal()] = 15;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[SqlType.BLOB.ordinal()] = 14;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[SqlType.BOOLEAN.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[SqlType.BYTE.ordinal()] = 6;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[SqlType.BYTE_ARRAY.ordinal()] = 7;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[SqlType.CHAR.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[SqlType.DATE.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[SqlType.DOUBLE.ordinal()] = 12;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[SqlType.FLOAT.ordinal()] = 11;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[SqlType.INTEGER.ordinal()] = 9;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[SqlType.LONG.ordinal()] = 10;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[SqlType.LONG_STRING.ordinal()] = 2;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr[SqlType.OTHER.ordinal()] = 16;
            } catch (NoSuchFieldError e13) {
            }
            try {
                iArr[SqlType.SERIALIZABLE.ordinal()] = 13;
            } catch (NoSuchFieldError e14) {
            }
            try {
                iArr[SqlType.SHORT.ordinal()] = 8;
            } catch (NoSuchFieldError e15) {
            }
            try {
                iArr[SqlType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError e16) {
            }
            try {
                iArr[SqlType.UNKNOWN.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            $SWITCH_TABLE$com$j256$ormlite$field$SqlType = iArr;
        }
        return iArr;
    }

    /* access modifiers changed from: protected */
    @Override // com.j256.ormlite.p083db.BaseDatabaseType
    public void appendLongType(StringBuilder sb, FieldType fieldType, int fieldWidth) {
        if (fieldType.getSqlType() != SqlType.LONG || !fieldType.isGeneratedId()) {
            sb.append("BIGINT");
        } else {
            sb.append("INTEGER");
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.j256.ormlite.p083db.BaseDatabaseType
    public void configureGeneratedId(String tableName, StringBuilder sb, FieldType fieldType, List<String> list, List<String> list2, List<String> list3, List<String> list4) {
        if (fieldType.getSqlType() == SqlType.INTEGER || fieldType.getSqlType() == SqlType.LONG) {
            sb.append("PRIMARY KEY AUTOINCREMENT ");
            return;
        }
        throw new IllegalArgumentException("Sqlite requires that auto-increment generated-id be integer or long type");
    }

    /* access modifiers changed from: protected */
    @Override // com.j256.ormlite.p083db.BaseDatabaseType
    public boolean generatedIdSqlAtEnd() {
        return false;
    }

    @Override // com.j256.ormlite.p083db.DatabaseType, com.j256.ormlite.p083db.BaseDatabaseType
    public boolean isVarcharFieldWidthSupported() {
        return false;
    }

    @Override // com.j256.ormlite.p083db.DatabaseType, com.j256.ormlite.p083db.BaseDatabaseType
    public boolean isCreateTableReturnsZero() {
        return false;
    }

    @Override // com.j256.ormlite.p083db.DatabaseType, com.j256.ormlite.p083db.BaseDatabaseType
    public boolean isCreateIfNotExistsSupported() {
        return true;
    }

    @Override // com.j256.ormlite.p083db.DatabaseType, com.j256.ormlite.p083db.BaseDatabaseType
    public FieldConverter getFieldConverter(DataPersister dataPersister) {
        switch ($SWITCH_TABLE$com$j256$ormlite$field$SqlType()[dataPersister.getSqlType().ordinal()]) {
            case 4:
                return booleanConverter;
            case 15:
                return BigDecimalStringType.getSingleton();
            default:
                return super.getFieldConverter(dataPersister);
        }
    }
}
