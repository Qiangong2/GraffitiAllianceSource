package com.j256.ormlite.dao;

import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.lang.reflect.Constructor;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DaoManager {
    private static Map<ClassConnectionSource, Dao<?, ?>> classMap = null;
    private static Map<Class<?>, DatabaseTableConfig<?>> configMap = null;
    private static Logger logger = LoggerFactory.getLogger(DaoManager.class);
    private static Map<TableConfigConnectionSource, Dao<?, ?>> tableConfigMap = null;

    public static synchronized <D extends Dao<T, ?>, T> D createDao(ConnectionSource connectionSource, Class<T> clazz) throws SQLException {
        Dao<?, ?> dao;
        D castDao;
        Dao<?, ?> createDao;
        synchronized (DaoManager.class) {
            if (connectionSource == null) {
                throw new IllegalArgumentException("connectionSource argument cannot be null");
            }
            Dao<?, ?> dao2 = lookupDao(new ClassConnectionSource(connectionSource, clazz));
            if (dao2 != null) {
                castDao = (D) dao2;
            } else {
                Dao<?, ?> dao3 = (Dao) createDaoFromConfig(connectionSource, clazz);
                if (dao3 != null) {
                    castDao = (D) dao3;
                } else {
                    DatabaseTable databaseTable = (DatabaseTable) clazz.getAnnotation(DatabaseTable.class);
                    if (databaseTable == null || databaseTable.daoClass() == Void.class || databaseTable.daoClass() == BaseDaoImpl.class) {
                        DatabaseTableConfig<T> config = connectionSource.getDatabaseType().extractDatabaseTableConfig(connectionSource, clazz);
                        if (config == null) {
                            createDao = BaseDaoImpl.createDao(connectionSource, clazz);
                        } else {
                            createDao = BaseDaoImpl.createDao(connectionSource, config);
                        }
                        dao = createDao;
                        logger.debug("created dao for class {} with reflection", clazz);
                    } else {
                        Class<?> daoClass = databaseTable.daoClass();
                        Object[] arguments = {connectionSource, clazz};
                        Constructor<?> daoConstructor = findConstructor(daoClass, arguments);
                        if (daoConstructor == null && (daoConstructor = findConstructor(daoClass, (arguments = new Object[]{connectionSource}))) == null) {
                            throw new SQLException("Could not find public constructor with ConnectionSource and optional Class parameters " + daoClass + ".  Missing static on class?");
                        }
                        try {
                            dao = (Dao) daoConstructor.newInstance(arguments);
                            logger.debug("created dao for class {} from constructor", clazz);
                        } catch (Exception e) {
                            throw SqlExceptionUtil.create("Could not call the constructor in class " + daoClass, e);
                        }
                    }
                    registerDao(connectionSource, dao);
                    castDao = (D) dao;
                }
            }
        }
        return castDao;
    }

    public static synchronized <D extends Dao<T, ?>, T> D lookupDao(ConnectionSource connectionSource, Class<T> clazz) {
        D d;
        synchronized (DaoManager.class) {
            if (connectionSource == null) {
                throw new IllegalArgumentException("connectionSource argument cannot be null");
            }
            d = (D) lookupDao(new ClassConnectionSource(connectionSource, clazz));
        }
        return d;
    }

    public static synchronized <D extends Dao<T, ?>, T> D createDao(ConnectionSource connectionSource, DatabaseTableConfig<T> tableConfig) throws SQLException {
        D d;
        synchronized (DaoManager.class) {
            if (connectionSource == null) {
                throw new IllegalArgumentException("connectionSource argument cannot be null");
            }
            d = (D) doCreateDao(connectionSource, tableConfig);
        }
        return d;
    }

    public static synchronized <D extends Dao<T, ?>, T> D lookupDao(ConnectionSource connectionSource, DatabaseTableConfig<T> tableConfig) {
        D d;
        synchronized (DaoManager.class) {
            if (connectionSource == null) {
                throw new IllegalArgumentException("connectionSource argument cannot be null");
            }
            Dao<?, ?> dao = lookupDao(new TableConfigConnectionSource(connectionSource, tableConfig));
            d = dao == null ? null : (D) dao;
        }
        return d;
    }

    public static synchronized void registerDao(ConnectionSource connectionSource, Dao<?, ?> dao) {
        synchronized (DaoManager.class) {
            if (connectionSource == null) {
                throw new IllegalArgumentException("connectionSource argument cannot be null");
            }
            addDaoToClassMap(new ClassConnectionSource(connectionSource, dao.getDataClass()), dao);
        }
    }

    public static synchronized void unregisterDao(ConnectionSource connectionSource, Dao<?, ?> dao) {
        synchronized (DaoManager.class) {
            if (connectionSource == null) {
                throw new IllegalArgumentException("connectionSource argument cannot be null");
            }
            removeDaoToClassMap(new ClassConnectionSource(connectionSource, dao.getDataClass()), dao);
        }
    }

    public static synchronized void registerDaoWithTableConfig(ConnectionSource connectionSource, Dao<?, ?> dao) {
        DatabaseTableConfig<?> tableConfig;
        synchronized (DaoManager.class) {
            if (connectionSource == null) {
                throw new IllegalArgumentException("connectionSource argument cannot be null");
            } else if (!(dao instanceof BaseDaoImpl) || (tableConfig = ((BaseDaoImpl) dao).getTableConfig()) == null) {
                addDaoToClassMap(new ClassConnectionSource(connectionSource, dao.getDataClass()), dao);
            } else {
                addDaoToTableMap(new TableConfigConnectionSource(connectionSource, tableConfig), dao);
            }
        }
    }

    public static synchronized void clearCache() {
        synchronized (DaoManager.class) {
            if (configMap != null) {
                configMap.clear();
                configMap = null;
            }
            clearDaoCache();
        }
    }

    public static synchronized void clearDaoCache() {
        synchronized (DaoManager.class) {
            if (classMap != null) {
                classMap.clear();
                classMap = null;
            }
            if (tableConfigMap != null) {
                tableConfigMap.clear();
                tableConfigMap = null;
            }
        }
    }

    public static synchronized void addCachedDatabaseConfigs(Collection<DatabaseTableConfig<?>> configs) {
        Map<Class<?>, DatabaseTableConfig<?>> newMap;
        synchronized (DaoManager.class) {
            if (configMap == null) {
                newMap = new HashMap<>();
            } else {
                newMap = new HashMap<>(configMap);
            }
            for (DatabaseTableConfig<?> config : configs) {
                newMap.put(config.getDataClass(), config);
                logger.info("Loaded configuration for {}", config.getDataClass());
            }
            configMap = newMap;
        }
    }

    private static void addDaoToClassMap(ClassConnectionSource key, Dao<?, ?> dao) {
        if (classMap == null) {
            classMap = new HashMap();
        }
        classMap.put(key, dao);
    }

    private static void removeDaoToClassMap(ClassConnectionSource key, Dao<?, ?> dao) {
        if (classMap != null) {
            classMap.remove(key);
        }
    }

    private static void addDaoToTableMap(TableConfigConnectionSource key, Dao<?, ?> dao) {
        if (tableConfigMap == null) {
            tableConfigMap = new HashMap();
        }
        tableConfigMap.put(key, dao);
    }

    private static <T> Dao<?, ?> lookupDao(ClassConnectionSource key) {
        if (classMap == null) {
            classMap = new HashMap();
        }
        Dao<?, ?> dao = classMap.get(key);
        if (dao == null) {
            return null;
        }
        return dao;
    }

    private static <T> Dao<?, ?> lookupDao(TableConfigConnectionSource key) {
        if (tableConfigMap == null) {
            tableConfigMap = new HashMap();
        }
        Dao<?, ?> dao = tableConfigMap.get(key);
        if (dao == null) {
            return null;
        }
        return dao;
    }

    private static Constructor<?> findConstructor(Class<?> daoClass, Object[] params) {
        Constructor<?>[] constructors = daoClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            Class[] paramsTypes = constructor.getParameterTypes();
            if (paramsTypes.length == params.length) {
                boolean match = true;
                int i = 0;
                while (true) {
                    if (i >= paramsTypes.length) {
                        break;
                    } else if (!paramsTypes[i].isAssignableFrom(params[i].getClass())) {
                        match = false;
                        break;
                    } else {
                        i++;
                    }
                }
                if (match) {
                    return constructor;
                }
            }
        }
        return null;
    }

    private static <D, T> D createDaoFromConfig(ConnectionSource connectionSource, Class<T> clazz) throws SQLException {
        DatabaseTableConfig<?> databaseTableConfig;
        if (configMap == null || (databaseTableConfig = configMap.get(clazz)) == null) {
            return null;
        }
        return (D) doCreateDao(connectionSource, databaseTableConfig);
    }

    private static <D extends Dao<T, ?>, T> D doCreateDao(ConnectionSource connectionSource, DatabaseTableConfig<T> tableConfig) throws SQLException {
        D d;
        TableConfigConnectionSource tableKey = new TableConfigConnectionSource(connectionSource, tableConfig);
        D d2 = (D) lookupDao(tableKey);
        if (d2 != null) {
            return d2;
        }
        Class<T> dataClass = tableConfig.getDataClass();
        ClassConnectionSource classKey = new ClassConnectionSource(connectionSource, dataClass);
        D d3 = (D) lookupDao(classKey);
        if (d3 != null) {
            addDaoToTableMap(tableKey, d3);
            return d3;
        }
        DatabaseTable databaseTable = (DatabaseTable) tableConfig.getDataClass().getAnnotation(DatabaseTable.class);
        if (databaseTable == null || databaseTable.daoClass() == Void.class || databaseTable.daoClass() == BaseDaoImpl.class) {
            d = (D) BaseDaoImpl.createDao(connectionSource, tableConfig);
        } else {
            Class<?> daoClass = databaseTable.daoClass();
            Object[] arguments = {connectionSource, tableConfig};
            Constructor<?> constructor = findConstructor(daoClass, arguments);
            if (constructor == null) {
                throw new SQLException("Could not find public constructor with ConnectionSource, DatabaseTableConfig parameters in class " + daoClass);
            }
            try {
                d = (D) ((Dao) constructor.newInstance(arguments));
            } catch (Exception e) {
                throw SqlExceptionUtil.create("Could not call the constructor in class " + daoClass, e);
            }
        }
        addDaoToTableMap(tableKey, d);
        logger.debug("created dao for class {} from table config", dataClass);
        if (lookupDao(classKey) == null) {
            addDaoToClassMap(classKey, d);
        }
        return d;
    }

    /* access modifiers changed from: private */
    public static class ClassConnectionSource {
        Class<?> clazz;
        ConnectionSource connectionSource;

        public ClassConnectionSource(ConnectionSource connectionSource2, Class<?> clazz2) {
            this.connectionSource = connectionSource2;
            this.clazz = clazz2;
        }

        public int hashCode() {
            return ((this.clazz.hashCode() + 31) * 31) + this.connectionSource.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ClassConnectionSource other = (ClassConnectionSource) obj;
            if (!this.clazz.equals(other.clazz) || !this.connectionSource.equals(other.connectionSource)) {
                return false;
            }
            return true;
        }
    }

    /* access modifiers changed from: private */
    public static class TableConfigConnectionSource {
        ConnectionSource connectionSource;
        DatabaseTableConfig<?> tableConfig;

        public TableConfigConnectionSource(ConnectionSource connectionSource2, DatabaseTableConfig<?> tableConfig2) {
            this.connectionSource = connectionSource2;
            this.tableConfig = tableConfig2;
        }

        public int hashCode() {
            return ((this.tableConfig.hashCode() + 31) * 31) + this.connectionSource.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            TableConfigConnectionSource other = (TableConfigConnectionSource) obj;
            if (!this.tableConfig.equals(other.tableConfig) || !this.connectionSource.equals(other.connectionSource)) {
                return false;
            }
            return true;
        }
    }
}
