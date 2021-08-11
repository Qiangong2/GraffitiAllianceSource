package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.p083db.DatabaseType;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

public class MappedRefresh<T, ID> extends MappedQueryForId<T, ID> {
    private MappedRefresh(TableInfo<T, ID> tableInfo, String statement, FieldType[] argFieldTypes, FieldType[] resultFieldTypes) {
        super(tableInfo, statement, argFieldTypes, resultFieldTypes, "refresh");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.j256.ormlite.stmt.mapped.MappedRefresh<T, ID> */
    /* JADX WARN: Multi-variable type inference failed */
    public int executeRefresh(DatabaseConnection databaseConnection, T data, ObjectCache objectCache) throws SQLException {
        Object execute = super.execute(databaseConnection, this.idField.extractJavaFieldValue(data), null);
        if (execute == null) {
            return 0;
        }
        FieldType[] fieldTypeArr = this.resultsFieldTypes;
        for (FieldType fieldType : fieldTypeArr) {
            if (fieldType != this.idField) {
                fieldType.assignField(data, fieldType.extractJavaFieldValue(execute), false, objectCache);
            }
        }
        return 1;
    }

    public static <T, ID> MappedRefresh<T, ID> build(DatabaseType databaseType, TableInfo<T, ID> tableInfo) throws SQLException {
        FieldType idField = tableInfo.getIdField();
        if (idField == null) {
            throw new SQLException("Cannot refresh " + tableInfo.getDataClass() + " because it doesn't have an id field");
        }
        return new MappedRefresh<>(tableInfo, buildStatement(databaseType, tableInfo, idField), new FieldType[]{tableInfo.getIdField()}, tableInfo.getFieldTypes());
    }
}
