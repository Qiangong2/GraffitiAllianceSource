package com.j256.ormlite.p083db;

import com.j256.ormlite.android.DatabaseTableConfigUtil;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldConverter;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.types.DateStringType;
import com.j256.ormlite.misc.VersionUtils;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;

/* renamed from: com.j256.ormlite.db.SqliteAndroidDatabaseType */
public class SqliteAndroidDatabaseType extends BaseSqliteDatabaseType implements DatabaseType {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$j256$ormlite$field$SqlType;

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

    public SqliteAndroidDatabaseType() {
        VersionUtils.checkCoreVersusAndroidVersions();
    }

    @Override // com.j256.ormlite.p083db.DatabaseType, com.j256.ormlite.p083db.BaseDatabaseType
    public void loadDriver() {
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public boolean isDatabaseUrlThisType(String url, String dbTypePart) {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.j256.ormlite.p083db.BaseDatabaseType
    public String getDriverClassName() {
        return null;
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public String getDatabaseName() {
        return "Android SQLite";
    }

    /* access modifiers changed from: protected */
    @Override // com.j256.ormlite.p083db.BaseDatabaseType
    public void appendDateType(StringBuilder sb, FieldType fieldType, int fieldWidth) {
        appendStringType(sb, fieldType, fieldWidth);
    }

    /* access modifiers changed from: protected */
    @Override // com.j256.ormlite.p083db.BaseDatabaseType
    public void appendBooleanType(StringBuilder sb, FieldType fieldType, int fieldWidth) {
        appendShortType(sb, fieldType, fieldWidth);
    }

    @Override // com.j256.ormlite.p083db.DatabaseType, com.j256.ormlite.p083db.BaseSqliteDatabaseType, com.j256.ormlite.p083db.BaseDatabaseType
    public FieldConverter getFieldConverter(DataPersister dataPersister) {
        switch ($SWITCH_TABLE$com$j256$ormlite$field$SqlType()[dataPersister.getSqlType().ordinal()]) {
            case 3:
                return DateStringType.getSingleton();
            default:
                return super.getFieldConverter(dataPersister);
        }
    }

    @Override // com.j256.ormlite.p083db.DatabaseType, com.j256.ormlite.p083db.BaseDatabaseType
    public boolean isNestedSavePointsSupported() {
        return false;
    }

    @Override // com.j256.ormlite.p083db.DatabaseType, com.j256.ormlite.p083db.BaseDatabaseType
    public boolean isBatchUseTransaction() {
        return true;
    }

    @Override // com.j256.ormlite.p083db.DatabaseType, com.j256.ormlite.p083db.BaseDatabaseType
    public <T> DatabaseTableConfig<T> extractDatabaseTableConfig(ConnectionSource connectionSource, Class<T> clazz) throws SQLException {
        return DatabaseTableConfigUtil.fromClass(connectionSource, clazz);
    }
}
