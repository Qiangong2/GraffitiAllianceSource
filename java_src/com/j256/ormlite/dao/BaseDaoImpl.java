package com.j256.ormlite.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.p083db.DatabaseType;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.stmt.StatementExecutor;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.ObjectFactory;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public abstract class BaseDaoImpl<T, ID> implements Dao<T, ID> {
    private static final ThreadLocal<DaoConfigArray> daoConfigLevelLocal = new ThreadLocal<DaoConfigArray>() {
        /* class com.j256.ormlite.dao.BaseDaoImpl.C11811 */

        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public DaoConfigArray initialValue() {
            return new DaoConfigArray(null);
        }
    };
    private static ReferenceObjectCache defaultObjectCache;
    protected ConnectionSource connectionSource;
    protected final Class<T> dataClass;
    protected DatabaseType databaseType;
    private boolean initialized;
    protected CloseableIterator<T> lastIterator;
    private ObjectCache objectCache;
    protected ObjectFactory<T> objectFactory;
    protected StatementExecutor<T, ID> statementExecutor;
    protected DatabaseTableConfig<T> tableConfig;
    protected TableInfo<T, ID> tableInfo;

    protected BaseDaoImpl(Class<T> dataClass2) throws SQLException {
        this(null, dataClass2, null);
    }

    protected BaseDaoImpl(ConnectionSource connectionSource2, Class<T> dataClass2) throws SQLException {
        this(connectionSource2, dataClass2, null);
    }

    protected BaseDaoImpl(ConnectionSource connectionSource2, DatabaseTableConfig<T> tableConfig2) throws SQLException {
        this(connectionSource2, tableConfig2.getDataClass(), tableConfig2);
    }

    private BaseDaoImpl(ConnectionSource connectionSource2, Class<T> dataClass2, DatabaseTableConfig<T> tableConfig2) throws SQLException {
        this.dataClass = dataClass2;
        this.tableConfig = tableConfig2;
        if (connectionSource2 != null) {
            this.connectionSource = connectionSource2;
            initialize();
        }
    }

    public void initialize() throws SQLException {
        if (!this.initialized) {
            if (this.connectionSource == null) {
                throw new IllegalStateException("connectionSource was never set on " + getClass().getSimpleName());
            }
            this.databaseType = this.connectionSource.getDatabaseType();
            if (this.databaseType == null) {
                throw new IllegalStateException("connectionSource is getting a null DatabaseType in " + getClass().getSimpleName());
            }
            if (this.tableConfig == null) {
                this.tableInfo = new TableInfo<>(this.connectionSource, this, this.dataClass);
            } else {
                this.tableConfig.extractFieldTypes(this.connectionSource);
                this.tableInfo = new TableInfo<>(this.databaseType, this, this.tableConfig);
            }
            this.statementExecutor = new StatementExecutor<>(this.databaseType, this.tableInfo, this);
            DaoConfigArray daoConfigLevel = daoConfigLevelLocal.get();
            if (daoConfigLevel.size() > 0) {
                daoConfigLevel.addDao(this);
                return;
            }
            daoConfigLevel.addDao(this);
            for (int i = 0; i < daoConfigLevel.size(); i++) {
                try {
                    BaseDaoImpl<?, ?> dao = daoConfigLevel.get(i);
                    DaoManager.registerDao(this.connectionSource, dao);
                    try {
                        for (FieldType fieldType : dao.getTableInfo().getFieldTypes()) {
                            fieldType.configDaoInformation(this.connectionSource, dao.getDataClass());
                        }
                        dao.initialized = true;
                    } catch (SQLException e) {
                        DaoManager.unregisterDao(this.connectionSource, dao);
                        throw e;
                    }
                } finally {
                    daoConfigLevel.clear();
                }
            }
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public T queryForId(ID id) throws SQLException {
        checkForInitialized();
        DatabaseConnection connection = this.connectionSource.getReadOnlyConnection();
        try {
            return this.statementExecutor.queryForId(connection, id, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(connection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public T queryForFirst(PreparedQuery<T> preparedQuery) throws SQLException {
        checkForInitialized();
        DatabaseConnection connection = this.connectionSource.getReadOnlyConnection();
        try {
            return this.statementExecutor.queryForFirst(connection, preparedQuery, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(connection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public List<T> queryForAll() throws SQLException {
        checkForInitialized();
        return this.statementExecutor.queryForAll(this.connectionSource, this.objectCache);
    }

    @Override // com.j256.ormlite.dao.Dao
    public List<T> queryForEq(String fieldName, Object value) throws SQLException {
        return queryBuilder().where().mo6812eq(fieldName, value).query();
    }

    @Override // com.j256.ormlite.dao.Dao
    public QueryBuilder<T, ID> queryBuilder() {
        checkForInitialized();
        return new QueryBuilder<>(this.databaseType, this.tableInfo, this);
    }

    @Override // com.j256.ormlite.dao.Dao
    public UpdateBuilder<T, ID> updateBuilder() {
        checkForInitialized();
        return new UpdateBuilder<>(this.databaseType, this.tableInfo, this);
    }

    @Override // com.j256.ormlite.dao.Dao
    public DeleteBuilder<T, ID> deleteBuilder() {
        checkForInitialized();
        return new DeleteBuilder<>(this.databaseType, this.tableInfo, this);
    }

    @Override // com.j256.ormlite.dao.Dao
    public List<T> query(PreparedQuery<T> preparedQuery) throws SQLException {
        checkForInitialized();
        return this.statementExecutor.query(this.connectionSource, preparedQuery, this.objectCache);
    }

    @Override // com.j256.ormlite.dao.Dao
    public List<T> queryForMatching(T matchObj) throws SQLException {
        return queryForMatching(matchObj, false);
    }

    @Override // com.j256.ormlite.dao.Dao
    public List<T> queryForMatchingArgs(T matchObj) throws SQLException {
        return queryForMatching(matchObj, true);
    }

    @Override // com.j256.ormlite.dao.Dao
    public List<T> queryForFieldValues(Map<String, Object> fieldValues) throws SQLException {
        return queryForFieldValues(fieldValues, false);
    }

    @Override // com.j256.ormlite.dao.Dao
    public List<T> queryForFieldValuesArgs(Map<String, Object> fieldValues) throws SQLException {
        return queryForFieldValues(fieldValues, true);
    }

    @Override // com.j256.ormlite.dao.Dao
    public T queryForSameId(T data) throws SQLException {
        ID id;
        checkForInitialized();
        if (data == null || (id = extractId(data)) == null) {
            return null;
        }
        return queryForId(id);
    }

    @Override // com.j256.ormlite.dao.Dao
    public int create(T data) throws SQLException {
        checkForInitialized();
        if (data == null) {
            return 0;
        }
        if (data instanceof BaseDaoEnabled) {
            data.setDao(this);
        }
        DatabaseConnection connection = this.connectionSource.getReadWriteConnection();
        try {
            return this.statementExecutor.create(connection, data, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(connection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public T createIfNotExists(T data) throws SQLException {
        if (data == null) {
            return null;
        }
        T existing = queryForSameId(data);
        if (existing != null) {
            return existing;
        }
        create(data);
        return data;
    }

    @Override // com.j256.ormlite.dao.Dao
    public Dao.CreateOrUpdateStatus createOrUpdate(T data) throws SQLException {
        if (data == null) {
            return new Dao.CreateOrUpdateStatus(false, false, 0);
        }
        ID id = extractId(data);
        if (id == null || !idExists(id)) {
            return new Dao.CreateOrUpdateStatus(true, false, create(data));
        }
        return new Dao.CreateOrUpdateStatus(false, true, update((Object) data));
    }

    @Override // com.j256.ormlite.dao.Dao
    public int update(T data) throws SQLException {
        checkForInitialized();
        if (data == null) {
            return 0;
        }
        DatabaseConnection connection = this.connectionSource.getReadWriteConnection();
        try {
            return this.statementExecutor.update(connection, data, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(connection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int updateId(T data, ID newId) throws SQLException {
        checkForInitialized();
        if (data == null) {
            return 0;
        }
        DatabaseConnection connection = this.connectionSource.getReadWriteConnection();
        try {
            return this.statementExecutor.updateId(connection, data, newId, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(connection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int update(PreparedUpdate<T> preparedUpdate) throws SQLException {
        checkForInitialized();
        DatabaseConnection connection = this.connectionSource.getReadWriteConnection();
        try {
            return this.statementExecutor.update(connection, preparedUpdate);
        } finally {
            this.connectionSource.releaseConnection(connection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int refresh(T data) throws SQLException {
        checkForInitialized();
        if (data == null) {
            return 0;
        }
        if (data instanceof BaseDaoEnabled) {
            data.setDao(this);
        }
        DatabaseConnection connection = this.connectionSource.getReadOnlyConnection();
        try {
            return this.statementExecutor.refresh(connection, data, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(connection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int delete(T data) throws SQLException {
        checkForInitialized();
        if (data == null) {
            return 0;
        }
        DatabaseConnection connection = this.connectionSource.getReadWriteConnection();
        try {
            return this.statementExecutor.delete(connection, data, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(connection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int deleteById(ID id) throws SQLException {
        checkForInitialized();
        if (id == null) {
            return 0;
        }
        DatabaseConnection connection = this.connectionSource.getReadWriteConnection();
        try {
            return this.statementExecutor.deleteById(connection, id, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(connection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int delete(Collection<T> datas) throws SQLException {
        checkForInitialized();
        if (datas == null || datas.isEmpty()) {
            return 0;
        }
        DatabaseConnection connection = this.connectionSource.getReadWriteConnection();
        try {
            return this.statementExecutor.deleteObjects(connection, datas, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(connection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int deleteIds(Collection<ID> ids) throws SQLException {
        checkForInitialized();
        if (ids == null || ids.isEmpty()) {
            return 0;
        }
        DatabaseConnection connection = this.connectionSource.getReadWriteConnection();
        try {
            return this.statementExecutor.deleteIds(connection, ids, this.objectCache);
        } finally {
            this.connectionSource.releaseConnection(connection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int delete(PreparedDelete<T> preparedDelete) throws SQLException {
        checkForInitialized();
        DatabaseConnection connection = this.connectionSource.getReadWriteConnection();
        try {
            return this.statementExecutor.delete(connection, preparedDelete);
        } finally {
            this.connectionSource.releaseConnection(connection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao, java.lang.Iterable
    public CloseableIterator<T> iterator() {
        return iterator(-1);
    }

    @Override // com.j256.ormlite.dao.CloseableIterable
    public CloseableIterator<T> closeableIterator() {
        return iterator(-1);
    }

    @Override // com.j256.ormlite.dao.Dao
    public CloseableIterator<T> iterator(int resultFlags) {
        checkForInitialized();
        this.lastIterator = createIterator(resultFlags);
        return this.lastIterator;
    }

    @Override // com.j256.ormlite.dao.Dao
    public CloseableWrappedIterable<T> getWrappedIterable() {
        checkForInitialized();
        return new CloseableWrappedIterableImpl(new CloseableIterable<T>() {
            /* class com.j256.ormlite.dao.BaseDaoImpl.C11822 */

            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                return closeableIterator();
            }

            @Override // com.j256.ormlite.dao.CloseableIterable
            public CloseableIterator<T> closeableIterator() {
                try {
                    return BaseDaoImpl.this.createIterator(-1);
                } catch (Exception e) {
                    throw new IllegalStateException("Could not build iterator for " + BaseDaoImpl.this.dataClass, e);
                }
            }
        });
    }

    @Override // com.j256.ormlite.dao.Dao
    public CloseableWrappedIterable<T> getWrappedIterable(final PreparedQuery<T> preparedQuery) {
        checkForInitialized();
        return new CloseableWrappedIterableImpl(new CloseableIterable<T>() {
            /* class com.j256.ormlite.dao.BaseDaoImpl.C11833 */

            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                return closeableIterator();
            }

            @Override // com.j256.ormlite.dao.CloseableIterable
            public CloseableIterator<T> closeableIterator() {
                try {
                    return BaseDaoImpl.this.createIterator(preparedQuery, -1);
                } catch (Exception e) {
                    throw new IllegalStateException("Could not build prepared-query iterator for " + BaseDaoImpl.this.dataClass, e);
                }
            }
        });
    }

    @Override // com.j256.ormlite.dao.Dao
    public void closeLastIterator() throws SQLException {
        if (this.lastIterator != null) {
            this.lastIterator.close();
            this.lastIterator = null;
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public CloseableIterator<T> iterator(PreparedQuery<T> preparedQuery) throws SQLException {
        return iterator(preparedQuery, -1);
    }

    @Override // com.j256.ormlite.dao.Dao
    public CloseableIterator<T> iterator(PreparedQuery<T> preparedQuery, int resultFlags) throws SQLException {
        checkForInitialized();
        this.lastIterator = createIterator(preparedQuery, resultFlags);
        return this.lastIterator;
    }

    @Override // com.j256.ormlite.dao.Dao
    public GenericRawResults<String[]> queryRaw(String query, String... arguments) throws SQLException {
        checkForInitialized();
        try {
            return this.statementExecutor.queryRaw(this.connectionSource, query, arguments, this.objectCache);
        } catch (SQLException e) {
            throw SqlExceptionUtil.create("Could not perform raw query for " + query, e);
        }
    }

    /* JADX DEBUG: Type inference failed for r0v5. Raw type applied. Possible types: com.j256.ormlite.dao.GenericRawResults<UO>, com.j256.ormlite.dao.GenericRawResults<GR> */
    @Override // com.j256.ormlite.dao.Dao
    public <GR> GenericRawResults<GR> queryRaw(String query, RawRowMapper<GR> mapper, String... arguments) throws SQLException {
        checkForInitialized();
        try {
            return (GenericRawResults<UO>) this.statementExecutor.queryRaw(this.connectionSource, query, mapper, arguments, this.objectCache);
        } catch (SQLException e) {
            throw SqlExceptionUtil.create("Could not perform raw query for " + query, e);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public GenericRawResults<Object[]> queryRaw(String query, DataType[] columnTypes, String... arguments) throws SQLException {
        checkForInitialized();
        try {
            return this.statementExecutor.queryRaw(this.connectionSource, query, columnTypes, arguments, this.objectCache);
        } catch (SQLException e) {
            throw SqlExceptionUtil.create("Could not perform raw query for " + query, e);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public long queryRawValue(String query, String... arguments) throws SQLException {
        checkForInitialized();
        DatabaseConnection connection = this.connectionSource.getReadOnlyConnection();
        try {
            long queryForLong = this.statementExecutor.queryForLong(connection, query, arguments);
            this.connectionSource.releaseConnection(connection);
            return queryForLong;
        } catch (SQLException e) {
            throw SqlExceptionUtil.create("Could not perform raw value query for " + query, e);
        } catch (Throwable th) {
            this.connectionSource.releaseConnection(connection);
            throw th;
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int executeRaw(String statement, String... arguments) throws SQLException {
        checkForInitialized();
        DatabaseConnection connection = this.connectionSource.getReadWriteConnection();
        try {
            int executeRaw = this.statementExecutor.executeRaw(connection, statement, arguments);
            this.connectionSource.releaseConnection(connection);
            return executeRaw;
        } catch (SQLException e) {
            throw SqlExceptionUtil.create("Could not run raw execute statement " + statement, e);
        } catch (Throwable th) {
            this.connectionSource.releaseConnection(connection);
            throw th;
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int executeRawNoArgs(String statement) throws SQLException {
        checkForInitialized();
        DatabaseConnection connection = this.connectionSource.getReadWriteConnection();
        try {
            int executeRawNoArgs = this.statementExecutor.executeRawNoArgs(connection, statement);
            this.connectionSource.releaseConnection(connection);
            return executeRawNoArgs;
        } catch (SQLException e) {
            throw SqlExceptionUtil.create("Could not run raw execute statement " + statement, e);
        } catch (Throwable th) {
            this.connectionSource.releaseConnection(connection);
            throw th;
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public int updateRaw(String statement, String... arguments) throws SQLException {
        checkForInitialized();
        DatabaseConnection connection = this.connectionSource.getReadWriteConnection();
        try {
            int updateRaw = this.statementExecutor.updateRaw(connection, statement, arguments);
            this.connectionSource.releaseConnection(connection);
            return updateRaw;
        } catch (SQLException e) {
            throw SqlExceptionUtil.create("Could not run raw update statement " + statement, e);
        } catch (Throwable th) {
            this.connectionSource.releaseConnection(connection);
            throw th;
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public <CT> CT callBatchTasks(Callable<CT> callable) throws SQLException {
        checkForInitialized();
        DatabaseConnection connection = this.connectionSource.getReadWriteConnection();
        try {
            return (CT) this.statementExecutor.callBatchTasks(connection, this.connectionSource.saveSpecialConnection(connection), callable);
        } finally {
            this.connectionSource.clearSpecialConnection(connection);
            this.connectionSource.releaseConnection(connection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public String objectToString(T data) {
        checkForInitialized();
        return this.tableInfo.objectToString(data);
    }

    @Override // com.j256.ormlite.dao.Dao
    public boolean objectsEqual(T data1, T data2) throws SQLException {
        checkForInitialized();
        FieldType[] fieldTypes = this.tableInfo.getFieldTypes();
        for (FieldType fieldType : fieldTypes) {
            if (!fieldType.getDataPersister().dataIsEqual(fieldType.extractJavaFieldValue(data1), fieldType.extractJavaFieldValue(data2))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.j256.ormlite.dao.Dao
    public ID extractId(T data) throws SQLException {
        checkForInitialized();
        FieldType idField = this.tableInfo.getIdField();
        if (idField != null) {
            return (ID) idField.extractJavaFieldValue(data);
        }
        throw new SQLException("Class " + this.dataClass + " does not have an id field");
    }

    @Override // com.j256.ormlite.dao.Dao
    public Class<T> getDataClass() {
        return this.dataClass;
    }

    @Override // com.j256.ormlite.dao.Dao
    public FieldType findForeignFieldType(Class<?> clazz) {
        checkForInitialized();
        FieldType[] fieldTypes = this.tableInfo.getFieldTypes();
        for (FieldType fieldType : fieldTypes) {
            if (fieldType.getType() == clazz) {
                return fieldType;
            }
        }
        return null;
    }

    @Override // com.j256.ormlite.dao.Dao
    public boolean isUpdatable() {
        return this.tableInfo.isUpdatable();
    }

    @Override // com.j256.ormlite.dao.Dao
    public boolean isTableExists() throws SQLException {
        checkForInitialized();
        DatabaseConnection connection = this.connectionSource.getReadOnlyConnection();
        try {
            return connection.isTableExists(this.tableInfo.getTableName());
        } finally {
            this.connectionSource.releaseConnection(connection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public long countOf() throws SQLException {
        checkForInitialized();
        DatabaseConnection connection = this.connectionSource.getReadOnlyConnection();
        try {
            return this.statementExecutor.queryForCountStar(connection);
        } finally {
            this.connectionSource.releaseConnection(connection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public long countOf(PreparedQuery<T> preparedQuery) throws SQLException {
        checkForInitialized();
        if (preparedQuery.getType() != StatementBuilder.StatementType.SELECT_LONG) {
            throw new IllegalArgumentException("Prepared query is not of type " + StatementBuilder.StatementType.SELECT_LONG + ", did you call QueryBuilder.setCountOf(true)?");
        }
        DatabaseConnection connection = this.connectionSource.getReadOnlyConnection();
        try {
            return this.statementExecutor.queryForLong(connection, preparedQuery);
        } finally {
            this.connectionSource.releaseConnection(connection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public void assignEmptyForeignCollection(T parent, String fieldName) throws SQLException {
        makeEmptyForeignCollection(parent, fieldName);
    }

    @Override // com.j256.ormlite.dao.Dao
    public <FT> ForeignCollection<FT> getEmptyForeignCollection(String fieldName) throws SQLException {
        return makeEmptyForeignCollection(null, fieldName);
    }

    @Override // com.j256.ormlite.dao.Dao
    public void setObjectCache(boolean enabled) throws SQLException {
        if (enabled) {
            if (this.objectCache != null) {
                return;
            }
            if (this.tableInfo.getIdField() == null) {
                throw new SQLException("Class " + this.dataClass + " must have an id field to enable the object cache");
            }
            synchronized (getClass()) {
                if (defaultObjectCache == null) {
                    defaultObjectCache = ReferenceObjectCache.makeWeakCache();
                }
                this.objectCache = defaultObjectCache;
            }
            this.objectCache.registerClass(this.dataClass);
        } else if (this.objectCache != null) {
            this.objectCache.clear(this.dataClass);
            this.objectCache = null;
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public void setObjectCache(ObjectCache objectCache2) throws SQLException {
        if (objectCache2 != null) {
            if (!(this.objectCache == null || this.objectCache == objectCache2)) {
                this.objectCache.clear(this.dataClass);
            }
            if (this.tableInfo.getIdField() == null) {
                throw new SQLException("Class " + this.dataClass + " must have an id field to enable the object cache");
            }
            this.objectCache = objectCache2;
            this.objectCache.registerClass(this.dataClass);
        } else if (this.objectCache != null) {
            this.objectCache.clear(this.dataClass);
            this.objectCache = null;
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public ObjectCache getObjectCache() {
        return this.objectCache;
    }

    @Override // com.j256.ormlite.dao.Dao
    public void clearObjectCache() {
        if (this.objectCache != null) {
            this.objectCache.clear(this.dataClass);
        }
    }

    public static synchronized void clearAllInternalObjectCaches() {
        synchronized (BaseDaoImpl.class) {
            if (defaultObjectCache != null) {
                defaultObjectCache.clearAll();
                defaultObjectCache = null;
            }
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public T mapSelectStarRow(DatabaseResults results) throws SQLException {
        return this.statementExecutor.getSelectStarRowMapper().mapRow(results);
    }

    @Override // com.j256.ormlite.dao.Dao
    public GenericRowMapper<T> getSelectStarRowMapper() throws SQLException {
        return this.statementExecutor.getSelectStarRowMapper();
    }

    @Override // com.j256.ormlite.dao.Dao
    public RawRowMapper<T> getRawRowMapper() {
        return this.statementExecutor.getRawRowMapper();
    }

    @Override // com.j256.ormlite.dao.Dao
    public boolean idExists(ID id) throws SQLException {
        DatabaseConnection connection = this.connectionSource.getReadOnlyConnection();
        try {
            return this.statementExecutor.ifExists(connection, id);
        } finally {
            this.connectionSource.releaseConnection(connection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public DatabaseConnection startThreadConnection() throws SQLException {
        DatabaseConnection connection = this.connectionSource.getReadWriteConnection();
        this.connectionSource.saveSpecialConnection(connection);
        return connection;
    }

    @Override // com.j256.ormlite.dao.Dao
    public void endThreadConnection(DatabaseConnection connection) throws SQLException {
        this.connectionSource.clearSpecialConnection(connection);
        this.connectionSource.releaseConnection(connection);
    }

    @Override // com.j256.ormlite.dao.Dao
    public void setAutoCommit(boolean autoCommit) throws SQLException {
        DatabaseConnection connection = this.connectionSource.getReadWriteConnection();
        try {
            setAutoCommit(connection, autoCommit);
        } finally {
            this.connectionSource.releaseConnection(connection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public void setAutoCommit(DatabaseConnection connection, boolean autoCommit) throws SQLException {
        connection.setAutoCommit(autoCommit);
    }

    @Override // com.j256.ormlite.dao.Dao
    public boolean isAutoCommit() throws SQLException {
        DatabaseConnection connection = this.connectionSource.getReadWriteConnection();
        try {
            return isAutoCommit(connection);
        } finally {
            this.connectionSource.releaseConnection(connection);
        }
    }

    @Override // com.j256.ormlite.dao.Dao
    public boolean isAutoCommit(DatabaseConnection connection) throws SQLException {
        return connection.isAutoCommit();
    }

    @Override // com.j256.ormlite.dao.Dao
    public void commit(DatabaseConnection connection) throws SQLException {
        connection.commit(null);
    }

    @Override // com.j256.ormlite.dao.Dao
    public void rollBack(DatabaseConnection connection) throws SQLException {
        connection.rollback(null);
    }

    public ObjectFactory<T> getObjectFactory() {
        return this.objectFactory;
    }

    @Override // com.j256.ormlite.dao.Dao
    public void setObjectFactory(ObjectFactory<T> objectFactory2) {
        checkForInitialized();
        this.objectFactory = objectFactory2;
    }

    public DatabaseTableConfig<T> getTableConfig() {
        return this.tableConfig;
    }

    public TableInfo<T, ID> getTableInfo() {
        return this.tableInfo;
    }

    @Override // com.j256.ormlite.dao.Dao
    public ConnectionSource getConnectionSource() {
        return this.connectionSource;
    }

    public void setConnectionSource(ConnectionSource connectionSource2) {
        this.connectionSource = connectionSource2;
    }

    public void setTableConfig(DatabaseTableConfig<T> tableConfig2) {
        this.tableConfig = tableConfig2;
    }

    static <T, ID> Dao<T, ID> createDao(ConnectionSource connectionSource2, Class<T> clazz) throws SQLException {
        return new BaseDaoImpl<T, ID>(connectionSource2, clazz) {
            /* class com.j256.ormlite.dao.BaseDaoImpl.C11844 */
        };
    }

    static <T, ID> Dao<T, ID> createDao(ConnectionSource connectionSource2, DatabaseTableConfig<T> tableConfig2) throws SQLException {
        return new BaseDaoImpl<T, ID>(connectionSource2, tableConfig2) {
            /* class com.j256.ormlite.dao.BaseDaoImpl.C11855 */
        };
    }

    /* access modifiers changed from: protected */
    public void checkForInitialized() {
        if (!this.initialized) {
            throw new IllegalStateException("you must call initialize() before you can use the dao");
        }
    }

    private <FT> ForeignCollection<FT> makeEmptyForeignCollection(T parent, String fieldName) throws SQLException {
        ID extractId;
        checkForInitialized();
        if (parent == null) {
            extractId = null;
        } else {
            extractId = extractId(parent);
        }
        FieldType[] fieldTypes = this.tableInfo.getFieldTypes();
        for (FieldType fieldType : fieldTypes) {
            if (fieldType.getColumnName().equals(fieldName)) {
                ForeignCollection<FT> collection = fieldType.buildForeignCollection(parent, extractId);
                if (parent != null) {
                    fieldType.assignField(parent, collection, true, null);
                }
                return collection;
            }
        }
        throw new IllegalArgumentException("Could not find a field named " + fieldName);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private CloseableIterator<T> createIterator(int resultFlags) {
        try {
            return this.statementExecutor.buildIterator(this, this.connectionSource, resultFlags, this.objectCache);
        } catch (Exception e) {
            throw new IllegalStateException("Could not build iterator for " + this.dataClass, e);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private CloseableIterator<T> createIterator(PreparedQuery<T> preparedQuery, int resultFlags) throws SQLException {
        try {
            return this.statementExecutor.buildIterator(this, this.connectionSource, preparedQuery, this.objectCache, resultFlags);
        } catch (SQLException e) {
            throw SqlExceptionUtil.create("Could not build prepared-query iterator for " + this.dataClass, e);
        }
    }

    private List<T> queryForMatching(T matchObj, boolean useArgs) throws SQLException {
        checkForInitialized();
        QueryBuilder<T, ID> qb = queryBuilder();
        Where<T, ID> where = qb.where();
        int fieldC = 0;
        FieldType[] fieldTypes = this.tableInfo.getFieldTypes();
        for (FieldType fieldType : fieldTypes) {
            Object fieldValue = fieldType.getFieldValueIfNotDefault(matchObj);
            if (fieldValue != null) {
                if (useArgs) {
                    fieldValue = new SelectArg(fieldValue);
                }
                where.mo6812eq(fieldType.getColumnName(), fieldValue);
                fieldC++;
            }
        }
        if (fieldC == 0) {
            return Collections.emptyList();
        }
        where.and(fieldC);
        return qb.query();
    }

    private List<T> queryForFieldValues(Map<String, Object> fieldValues, boolean useArgs) throws SQLException {
        checkForInitialized();
        QueryBuilder<T, ID> qb = queryBuilder();
        Where<T, ID> where = qb.where();
        for (Map.Entry<String, Object> entry : fieldValues.entrySet()) {
            Object fieldValue = entry.getValue();
            if (useArgs) {
                fieldValue = new SelectArg(fieldValue);
            }
            where.mo6812eq(entry.getKey(), fieldValue);
        }
        if (fieldValues.size() == 0) {
            return Collections.emptyList();
        }
        where.and(fieldValues.size());
        return qb.query();
    }

    /* access modifiers changed from: private */
    public static class DaoConfigArray {
        private BaseDaoImpl<?, ?>[] daoArray;
        private int daoArrayC;

        private DaoConfigArray() {
            this.daoArray = new BaseDaoImpl[10];
            this.daoArrayC = 0;
        }

        /* synthetic */ DaoConfigArray(DaoConfigArray daoConfigArray) {
            this();
        }

        public void addDao(BaseDaoImpl<?, ?> dao) {
            if (this.daoArrayC == this.daoArray.length) {
                BaseDaoImpl[] newDaoArray = new BaseDaoImpl[(this.daoArray.length * 2)];
                for (int i = 0; i < this.daoArray.length; i++) {
                    newDaoArray[i] = this.daoArray[i];
                    this.daoArray[i] = null;
                }
                this.daoArray = newDaoArray;
            }
            BaseDaoImpl<?, ?>[] baseDaoImplArr = this.daoArray;
            int i2 = this.daoArrayC;
            this.daoArrayC = i2 + 1;
            baseDaoImplArr[i2] = dao;
        }

        public int size() {
            return this.daoArrayC;
        }

        public BaseDaoImpl<?, ?> get(int i) {
            return this.daoArray[i];
        }

        public void clear() {
            for (int i = 0; i < this.daoArrayC; i++) {
                this.daoArray[i] = null;
            }
            this.daoArrayC = 0;
        }
    }
}
