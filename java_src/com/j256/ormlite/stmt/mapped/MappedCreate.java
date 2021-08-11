package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Log;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.p083db.DatabaseType;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.GeneratedKeyHolder;
import com.j256.ormlite.table.TableInfo;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.sql.SQLException;

public class MappedCreate<T, ID> extends BaseMappedStatement<T, ID> {
    private String dataClassName;
    private final String queryNextSequenceStmt;
    private int versionFieldTypeIndex;

    private MappedCreate(TableInfo<T, ID> tableInfo, String statement, FieldType[] argFieldTypes, String queryNextSequenceStmt2, int versionFieldTypeIndex2) {
        super(tableInfo, statement, argFieldTypes);
        this.dataClassName = tableInfo.getDataClass().getSimpleName();
        this.queryNextSequenceStmt = queryNextSequenceStmt2;
        this.versionFieldTypeIndex = versionFieldTypeIndex2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r24v0, resolved type: com.j256.ormlite.dao.ObjectCache */
    /* JADX WARN: Multi-variable type inference failed */
    public int insert(DatabaseType databaseType, DatabaseConnection databaseConnection, T data, ObjectCache objectCache) throws SQLException {
        Object foreignObj;
        boolean assignId;
        KeyHolder keyHolder = null;
        if (this.idField != null) {
            if (!this.idField.isAllowGeneratedIdInsert() || this.idField.isObjectsFieldValueDefault(data)) {
                assignId = true;
            } else {
                assignId = false;
            }
            if (!this.idField.isSelfGeneratedId() || !this.idField.isGeneratedId()) {
                if (!this.idField.isGeneratedIdSequence() || !databaseType.isSelectSequenceBeforeInsert()) {
                    if (this.idField.isGeneratedId() && assignId) {
                        keyHolder = new KeyHolder(null);
                    }
                } else if (assignId) {
                    assignSequenceId(databaseConnection, data, objectCache);
                }
            } else if (assignId) {
                this.idField.assignField(data, this.idField.generateId(), false, objectCache);
            }
        }
        try {
            if (this.tableInfo.isForeignAutoCreate()) {
                FieldType[] fieldTypes = this.tableInfo.getFieldTypes();
                for (FieldType fieldType : fieldTypes) {
                    if (fieldType.isForeignAutoCreate() && (foreignObj = fieldType.extractRawJavaFieldValue(data)) != null && fieldType.getForeignIdField().isObjectsFieldValueDefault(foreignObj)) {
                        fieldType.createWithForeignDao(foreignObj);
                    }
                }
            }
            Object[] args = getFieldObjects(data);
            Object versionDefaultValue = null;
            if (this.versionFieldTypeIndex >= 0 && args[this.versionFieldTypeIndex] == null) {
                FieldType versionFieldType = this.argFieldTypes[this.versionFieldTypeIndex];
                versionDefaultValue = versionFieldType.moveToNextValue(null);
                args[this.versionFieldTypeIndex] = versionFieldType.convertJavaFieldToSqlArgValue(versionDefaultValue);
            }
            int rowC = databaseConnection.insert(this.statement, args, this.argFieldTypes, keyHolder);
            logger.debug("insert data with statement '{}' and {} args, changed {} rows", this.statement, Integer.valueOf(args.length), Integer.valueOf(rowC));
            if (args.length > 0) {
                logger.trace("insert arguments: {}", (Object) args);
            }
            if (rowC > 0) {
                if (versionDefaultValue != null) {
                    this.argFieldTypes[this.versionFieldTypeIndex].assignField(data, versionDefaultValue, false, null);
                }
                if (keyHolder != null) {
                    Number key = keyHolder.getKey();
                    if (key == null) {
                        throw new SQLException("generated-id key was not set by the update call");
                    } else if (key.longValue() == 0) {
                        throw new SQLException("generated-id key must not be 0 value");
                    } else {
                        assignIdValue(data, key, "keyholder", objectCache);
                    }
                }
                if (objectCache != 0 && foreignCollectionsAreAssigned(this.tableInfo.getForeignCollections(), data)) {
                    objectCache.put(this.clazz, this.idField.extractJavaFieldValue(data), data);
                }
            }
            return rowC;
        } catch (SQLException e) {
            throw SqlExceptionUtil.create("Unable to run insert stmt on object " + ((Object) data) + ": " + this.statement, e);
        }
    }

    public static <T, ID> MappedCreate<T, ID> build(DatabaseType databaseType, TableInfo<T, ID> tableInfo) {
        int argFieldC;
        StringBuilder sb = new StringBuilder(128);
        appendTableName(databaseType, sb, "INSERT INTO ", tableInfo.getTableName());
        sb.append('(');
        int argFieldC2 = 0;
        int versionFieldTypeIndex2 = -1;
        FieldType[] fieldTypes = tableInfo.getFieldTypes();
        for (FieldType fieldType : fieldTypes) {
            if (isFieldCreatable(databaseType, fieldType)) {
                if (fieldType.isVersion()) {
                    versionFieldTypeIndex2 = argFieldC2;
                }
                argFieldC2++;
            }
        }
        FieldType[] argFieldTypes = new FieldType[argFieldC2];
        boolean first = true;
        FieldType[] fieldTypes2 = tableInfo.getFieldTypes();
        int length = fieldTypes2.length;
        int i = 0;
        int argFieldC3 = 0;
        while (i < length) {
            FieldType fieldType2 = fieldTypes2[i];
            if (!isFieldCreatable(databaseType, fieldType2)) {
                argFieldC = argFieldC3;
            } else {
                if (first) {
                    first = false;
                } else {
                    sb.append(MiPushClient.ACCEPT_TIME_SEPARATOR);
                }
                appendFieldColumnName(databaseType, sb, fieldType2, null);
                argFieldC = argFieldC3 + 1;
                argFieldTypes[argFieldC3] = fieldType2;
            }
            i++;
            argFieldC3 = argFieldC;
        }
        sb.append(") VALUES (");
        boolean first2 = true;
        for (FieldType fieldType3 : tableInfo.getFieldTypes()) {
            if (isFieldCreatable(databaseType, fieldType3)) {
                if (first2) {
                    first2 = false;
                } else {
                    sb.append(MiPushClient.ACCEPT_TIME_SEPARATOR);
                }
                sb.append("?");
            }
        }
        sb.append(")");
        return new MappedCreate<>(tableInfo, sb.toString(), argFieldTypes, buildQueryNextSequence(databaseType, tableInfo.getIdField()), versionFieldTypeIndex2);
    }

    private boolean foreignCollectionsAreAssigned(FieldType[] foreignCollections, Object data) throws SQLException {
        for (FieldType fieldType : foreignCollections) {
            if (fieldType.extractJavaFieldValue(data) == null) {
                return false;
            }
        }
        return true;
    }

    private static boolean isFieldCreatable(DatabaseType databaseType, FieldType fieldType) {
        if (fieldType.isForeignCollection()) {
            return false;
        }
        if (!databaseType.isIdSequenceNeeded() || !databaseType.isSelectSequenceBeforeInsert()) {
            return !fieldType.isGeneratedId() || fieldType.isSelfGeneratedId() || fieldType.isAllowGeneratedIdInsert();
        }
        return true;
    }

    private static String buildQueryNextSequence(DatabaseType databaseType, FieldType idField) {
        String seqName;
        if (idField == null || (seqName = idField.getGeneratedIdSequence()) == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(64);
        databaseType.appendSelectNextValFromSequence(sb, seqName);
        return sb.toString();
    }

    private void assignSequenceId(DatabaseConnection databaseConnection, T data, ObjectCache objectCache) throws SQLException {
        long seqVal = databaseConnection.queryForLong(this.queryNextSequenceStmt);
        logger.debug("queried for sequence {} using stmt: {}", Long.valueOf(seqVal), this.queryNextSequenceStmt);
        if (seqVal == 0) {
            throw new SQLException("Should not have returned 0 for stmt: " + this.queryNextSequenceStmt);
        }
        assignIdValue(data, Long.valueOf(seqVal), "sequence", objectCache);
    }

    private void assignIdValue(T data, Number val, String label, ObjectCache objectCache) throws SQLException {
        this.idField.assignIdValue(data, val, objectCache);
        if (logger.isLevelEnabled(Log.Level.DEBUG)) {
            logger.debug("assigned id '{}' from {} to '{}' in {} object", new Object[]{val, label, this.idField.getFieldName(), this.dataClassName});
        }
    }

    /* access modifiers changed from: private */
    public static class KeyHolder implements GeneratedKeyHolder {
        Number key;

        private KeyHolder() {
        }

        /* synthetic */ KeyHolder(KeyHolder keyHolder) {
            this();
        }

        public Number getKey() {
            return this.key;
        }

        @Override // com.j256.ormlite.support.GeneratedKeyHolder
        public void addKey(Number key2) throws SQLException {
            if (this.key == null) {
                this.key = key2;
                return;
            }
            throw new SQLException("generated key has already been set to " + this.key + ", now set to " + key2);
        }
    }
}
