package com.j256.ormlite.p083db;

import com.j256.ormlite.field.BaseFieldConverter;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldConverter;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.List;

/* renamed from: com.j256.ormlite.db.BaseDatabaseType */
public abstract class BaseDatabaseType implements DatabaseType {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$j256$ormlite$field$SqlType;
    protected static String DEFAULT_SEQUENCE_SUFFIX = "_id_seq";
    protected Driver driver;

    /* access modifiers changed from: protected */
    public abstract String getDriverClassName();

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

    @Override // com.j256.ormlite.p083db.DatabaseType
    public void loadDriver() throws SQLException {
        String className = getDriverClassName();
        if (className != null) {
            try {
                Class.forName(className);
            } catch (ClassNotFoundException e) {
                throw SqlExceptionUtil.create("Driver class was not found for " + getDatabaseName() + " database.  Missing jar with class " + className + ".", e);
            }
        }
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public void setDriver(Driver driver2) {
        this.driver = driver2;
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public void appendColumnArg(String tableName, StringBuilder sb, FieldType fieldType, List<String> additionalArgs, List<String> statementsBefore, List<String> statementsAfter, List<String> queriesAfter) throws SQLException {
        appendEscapedEntityName(sb, fieldType.getColumnName());
        sb.append(' ');
        DataPersister dataPersister = fieldType.getDataPersister();
        int fieldWidth = fieldType.getWidth();
        if (fieldWidth == 0) {
            fieldWidth = dataPersister.getDefaultWidth();
        }
        switch ($SWITCH_TABLE$com$j256$ormlite$field$SqlType()[dataPersister.getSqlType().ordinal()]) {
            case 1:
                appendStringType(sb, fieldType, fieldWidth);
                break;
            case 2:
                appendLongStringType(sb, fieldType, fieldWidth);
                break;
            case 3:
                appendDateType(sb, fieldType, fieldWidth);
                break;
            case 4:
                appendBooleanType(sb, fieldType, fieldWidth);
                break;
            case 5:
                appendCharType(sb, fieldType, fieldWidth);
                break;
            case 6:
                appendByteType(sb, fieldType, fieldWidth);
                break;
            case 7:
                appendByteArrayType(sb, fieldType, fieldWidth);
                break;
            case 8:
                appendShortType(sb, fieldType, fieldWidth);
                break;
            case 9:
                appendIntegerType(sb, fieldType, fieldWidth);
                break;
            case 10:
                appendLongType(sb, fieldType, fieldWidth);
                break;
            case 11:
                appendFloatType(sb, fieldType, fieldWidth);
                break;
            case 12:
                appendDoubleType(sb, fieldType, fieldWidth);
                break;
            case 13:
                appendSerializableType(sb, fieldType, fieldWidth);
                break;
            case 14:
            default:
                throw new IllegalArgumentException("Unknown SQL-type " + dataPersister.getSqlType());
            case 15:
                appendBigDecimalNumericType(sb, fieldType, fieldWidth);
                break;
        }
        sb.append(' ');
        if (fieldType.isGeneratedIdSequence() && !fieldType.isSelfGeneratedId()) {
            configureGeneratedIdSequence(sb, fieldType, statementsBefore, additionalArgs, queriesAfter);
        } else if (fieldType.isGeneratedId() && !fieldType.isSelfGeneratedId()) {
            configureGeneratedId(tableName, sb, fieldType, statementsBefore, statementsAfter, additionalArgs, queriesAfter);
        } else if (fieldType.isId()) {
            configureId(sb, fieldType, statementsBefore, additionalArgs, queriesAfter);
        }
        if (!fieldType.isGeneratedId()) {
            Object defaultValue = fieldType.getDefaultValue();
            if (defaultValue != null) {
                sb.append("DEFAULT ");
                appendDefaultValue(sb, fieldType, defaultValue);
                sb.append(' ');
            }
            if (fieldType.isCanBeNull()) {
                appendCanBeNull(sb, fieldType);
            } else {
                sb.append("NOT NULL ");
            }
            if (fieldType.isUnique()) {
                addSingleUnique(sb, fieldType, additionalArgs, statementsAfter);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void appendStringType(StringBuilder sb, FieldType fieldType, int fieldWidth) {
        if (isVarcharFieldWidthSupported()) {
            sb.append("VARCHAR(").append(fieldWidth).append(")");
        } else {
            sb.append("VARCHAR");
        }
    }

    /* access modifiers changed from: protected */
    public void appendLongStringType(StringBuilder sb, FieldType fieldType, int fieldWidth) {
        sb.append("TEXT");
    }

    /* access modifiers changed from: protected */
    public void appendDateType(StringBuilder sb, FieldType fieldType, int fieldWidth) {
        sb.append("TIMESTAMP");
    }

    /* access modifiers changed from: protected */
    public void appendBooleanType(StringBuilder sb, FieldType fieldType, int fieldWidth) {
        sb.append("BOOLEAN");
    }

    /* access modifiers changed from: protected */
    public void appendCharType(StringBuilder sb, FieldType fieldType, int fieldWidth) {
        sb.append("CHAR");
    }

    /* access modifiers changed from: protected */
    public void appendByteType(StringBuilder sb, FieldType fieldType, int fieldWidth) {
        sb.append("TINYINT");
    }

    /* access modifiers changed from: protected */
    public void appendShortType(StringBuilder sb, FieldType fieldType, int fieldWidth) {
        sb.append("SMALLINT");
    }

    private void appendIntegerType(StringBuilder sb, FieldType fieldType, int fieldWidth) {
        sb.append("INTEGER");
    }

    /* access modifiers changed from: protected */
    public void appendLongType(StringBuilder sb, FieldType fieldType, int fieldWidth) {
        sb.append("BIGINT");
    }

    private void appendFloatType(StringBuilder sb, FieldType fieldType, int fieldWidth) {
        sb.append("FLOAT");
    }

    private void appendDoubleType(StringBuilder sb, FieldType fieldType, int fieldWidth) {
        sb.append("DOUBLE PRECISION");
    }

    /* access modifiers changed from: protected */
    public void appendByteArrayType(StringBuilder sb, FieldType fieldType, int fieldWidth) {
        sb.append("BLOB");
    }

    /* access modifiers changed from: protected */
    public void appendSerializableType(StringBuilder sb, FieldType fieldType, int fieldWidth) {
        sb.append("BLOB");
    }

    /* access modifiers changed from: protected */
    public void appendBigDecimalNumericType(StringBuilder sb, FieldType fieldType, int fieldWidth) {
        sb.append("NUMERIC");
    }

    private void appendDefaultValue(StringBuilder sb, FieldType fieldType, Object defaultValue) {
        if (fieldType.isEscapedDefaultValue()) {
            appendEscapedWord(sb, defaultValue.toString());
        } else {
            sb.append(defaultValue);
        }
    }

    /* access modifiers changed from: protected */
    public void configureGeneratedIdSequence(StringBuilder sb, FieldType fieldType, List<String> list, List<String> list2, List<String> list3) throws SQLException {
        throw new SQLException("GeneratedIdSequence is not supported by database " + getDatabaseName() + " for field " + fieldType);
    }

    /* access modifiers changed from: protected */
    public void configureGeneratedId(String tableName, StringBuilder sb, FieldType fieldType, List<String> list, List<String> list2, List<String> list3, List<String> list4) {
        throw new IllegalStateException("GeneratedId is not supported by database " + getDatabaseName() + " for field " + fieldType);
    }

    /* access modifiers changed from: protected */
    public void configureId(StringBuilder sb, FieldType fieldType, List<String> list, List<String> list2, List<String> list3) {
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public void addPrimaryKeySql(FieldType[] fieldTypes, List<String> additionalArgs, List<String> list, List<String> list2, List<String> list3) {
        StringBuilder sb = null;
        for (FieldType fieldType : fieldTypes) {
            if ((!fieldType.isGeneratedId() || generatedIdSqlAtEnd() || fieldType.isSelfGeneratedId()) && fieldType.isId()) {
                if (sb == null) {
                    sb = new StringBuilder(48);
                    sb.append("PRIMARY KEY (");
                } else {
                    sb.append(',');
                }
                appendEscapedEntityName(sb, fieldType.getColumnName());
            }
        }
        if (sb != null) {
            sb.append(") ");
            additionalArgs.add(sb.toString());
        }
    }

    /* access modifiers changed from: protected */
    public boolean generatedIdSqlAtEnd() {
        return true;
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public void addUniqueComboSql(FieldType[] fieldTypes, List<String> additionalArgs, List<String> list, List<String> list2, List<String> list3) {
        StringBuilder sb = null;
        for (FieldType fieldType : fieldTypes) {
            if (fieldType.isUniqueCombo()) {
                if (sb == null) {
                    sb = new StringBuilder(48);
                    sb.append("UNIQUE (");
                } else {
                    sb.append(',');
                }
                appendEscapedEntityName(sb, fieldType.getColumnName());
            }
        }
        if (sb != null) {
            sb.append(") ");
            additionalArgs.add(sb.toString());
        }
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public void dropColumnArg(FieldType fieldType, List<String> list, List<String> list2) {
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public void appendEscapedWord(StringBuilder sb, String word) {
        sb.append('\'').append(word).append('\'');
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public void appendEscapedEntityName(StringBuilder sb, String name) {
        sb.append('`').append(name).append('`');
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public String generateIdSequenceName(String tableName, FieldType idFieldType) {
        String name = String.valueOf(tableName) + DEFAULT_SEQUENCE_SUFFIX;
        if (isEntityNamesMustBeUpCase()) {
            return name.toUpperCase();
        }
        return name;
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public String getCommentLinePrefix() {
        return "-- ";
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public FieldConverter getFieldConverter(DataPersister dataPersister) {
        return dataPersister;
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public boolean isIdSequenceNeeded() {
        return false;
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public boolean isVarcharFieldWidthSupported() {
        return true;
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public boolean isLimitSqlSupported() {
        return true;
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public boolean isOffsetSqlSupported() {
        return true;
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public boolean isOffsetLimitArgument() {
        return false;
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public boolean isLimitAfterSelect() {
        return false;
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public void appendLimitValue(StringBuilder sb, long limit, Long offset) {
        sb.append("LIMIT ").append(limit).append(' ');
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public void appendOffsetValue(StringBuilder sb, long offset) {
        sb.append("OFFSET ").append(offset).append(' ');
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public void appendSelectNextValFromSequence(StringBuilder sb, String sequenceName) {
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public void appendCreateTableSuffix(StringBuilder sb) {
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public boolean isCreateTableReturnsZero() {
        return true;
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public boolean isCreateTableReturnsNegative() {
        return false;
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public boolean isEntityNamesMustBeUpCase() {
        return false;
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public boolean isNestedSavePointsSupported() {
        return true;
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public String getPingStatement() {
        return "SELECT 1";
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public boolean isBatchUseTransaction() {
        return false;
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public boolean isTruncateSupported() {
        return false;
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public boolean isCreateIfNotExistsSupported() {
        return false;
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public boolean isCreateIndexIfNotExistsSupported() {
        return isCreateIfNotExistsSupported();
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public boolean isSelectSequenceBeforeInsert() {
        return false;
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public boolean isAllowGeneratedIdInsertSupported() {
        return true;
    }

    @Override // com.j256.ormlite.p083db.DatabaseType
    public <T> DatabaseTableConfig<T> extractDatabaseTableConfig(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        return null;
    }

    private void appendCanBeNull(StringBuilder sb, FieldType fieldType) {
    }

    private void addSingleUnique(StringBuilder sb, FieldType fieldType, List<String> additionalArgs, List<String> list) {
        StringBuilder alterSb = new StringBuilder();
        alterSb.append(" UNIQUE (");
        appendEscapedEntityName(alterSb, fieldType.getColumnName());
        alterSb.append(")");
        additionalArgs.add(alterSb.toString());
    }

    /* renamed from: com.j256.ormlite.db.BaseDatabaseType$BooleanNumberFieldConverter */
    protected static class BooleanNumberFieldConverter extends BaseFieldConverter implements FieldConverter {
        protected BooleanNumberFieldConverter() {
        }

        @Override // com.j256.ormlite.field.FieldConverter
        public SqlType getSqlType() {
            return SqlType.BOOLEAN;
        }

        @Override // com.j256.ormlite.field.FieldConverter
        public Object parseDefaultString(FieldType fieldType, String defaultStr) {
            return Boolean.parseBoolean(defaultStr) ? (byte) (byte) 1 : (byte) 0;
        }

        @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
        public Object javaToSqlArg(FieldType fieldType, Object obj) {
            return ((Boolean) obj).booleanValue() ? (byte) (byte) 1 : (byte) 0;
        }

        @Override // com.j256.ormlite.field.FieldConverter
        public Object resultToSqlArg(FieldType fieldType, DatabaseResults results, int columnPos) throws SQLException {
            return Byte.valueOf(results.getByte(columnPos));
        }

        @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
        public Object sqlArgToJava(FieldType fieldType, Object sqlArg, int columnPos) {
            return ((Byte) sqlArg).byteValue() == 1;
        }

        @Override // com.j256.ormlite.field.FieldConverter
        public Object resultStringToJava(FieldType fieldType, String stringValue, int columnPos) {
            return sqlArgToJava(fieldType, Byte.valueOf(Byte.parseByte(stringValue)), columnPos);
        }
    }
}
