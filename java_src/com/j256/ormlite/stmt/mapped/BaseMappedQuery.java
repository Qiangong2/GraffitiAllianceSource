package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.BaseForeignCollection;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseMappedQuery<T, ID> extends BaseMappedStatement<T, ID> implements GenericRowMapper<T> {
    private Map<String, Integer> columnPositions = null;
    private Object parent = null;
    private Object parentId = null;
    protected final FieldType[] resultsFieldTypes;

    protected BaseMappedQuery(TableInfo<T, ID> tableInfo, String statement, FieldType[] argFieldTypes, FieldType[] resultsFieldTypes2) {
        super(tableInfo, statement, argFieldTypes);
        this.resultsFieldTypes = resultsFieldTypes2;
    }

    @Override // com.j256.ormlite.stmt.GenericRowMapper
    public T mapRow(DatabaseResults results) throws SQLException {
        Map<String, Integer> colPosMap;
        BaseForeignCollection<?, ?> collection;
        if (this.columnPositions == null) {
            colPosMap = new HashMap<>();
        } else {
            colPosMap = this.columnPositions;
        }
        ObjectCache objectCache = results.getObjectCache();
        if (objectCache != null) {
            T cachedInstance = (T) objectCache.get(this.clazz, this.idField.resultToJava(results, colPosMap));
            if (cachedInstance != null) {
                return cachedInstance;
            }
        }
        T instance = (T) this.tableInfo.createObject();
        ID id = null;
        boolean foreignCollections = false;
        FieldType[] fieldTypeArr = this.resultsFieldTypes;
        for (FieldType fieldType : fieldTypeArr) {
            if (fieldType.isForeignCollection()) {
                foreignCollections = true;
            } else {
                Object val = fieldType.resultToJava(results, colPosMap);
                if (val == null || this.parent == null || fieldType.getField().getType() != this.parent.getClass() || !val.equals(this.parentId)) {
                    fieldType.assignField(instance, val, false, objectCache);
                } else {
                    fieldType.assignField(instance, this.parent, true, objectCache);
                }
                if (fieldType == this.idField) {
                    id = val;
                }
            }
        }
        if (foreignCollections) {
            FieldType[] fieldTypeArr2 = this.resultsFieldTypes;
            for (FieldType fieldType2 : fieldTypeArr2) {
                if (fieldType2.isForeignCollection() && (collection = fieldType2.buildForeignCollection(instance, id)) != null) {
                    fieldType2.assignField(instance, collection, false, objectCache);
                }
            }
        }
        if (!(objectCache == null || id == null)) {
            objectCache.put(this.clazz, id, instance);
        }
        if (this.columnPositions == null) {
            this.columnPositions = colPosMap;
        }
        return instance;
    }

    public void setParentInformation(Object parent2, Object parentId2) {
        this.parent = parent2;
        this.parentId = parentId2;
    }
}
