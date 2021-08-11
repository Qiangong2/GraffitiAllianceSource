package com.j256.ormlite.android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.GeneratedKeyHolder;
import java.sql.SQLException;
import java.sql.Savepoint;

public class AndroidDatabaseConnection implements DatabaseConnection {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$j256$ormlite$field$SqlType;
    private static final String[] NO_STRING_ARGS = new String[0];
    private static Logger logger = LoggerFactory.getLogger(AndroidDatabaseConnection.class);

    /* renamed from: db */
    private final SQLiteDatabase f3084db;
    private final boolean readWrite;

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

    public AndroidDatabaseConnection(SQLiteDatabase db, boolean readWrite2) {
        this.f3084db = db;
        this.readWrite = readWrite2;
        logger.trace("{}: db {} opened, read-write = {}", this, db, Boolean.valueOf(readWrite2));
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public boolean isAutoCommitSupported() {
        return true;
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public boolean isAutoCommit() throws SQLException {
        try {
            boolean inTransaction = this.f3084db.inTransaction();
            logger.trace("{}: in transaction is {}", this, Boolean.valueOf(inTransaction));
            return !inTransaction;
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems getting auto-commit from database", e);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void setAutoCommit(boolean autoCommit) {
        if (autoCommit) {
            if (this.f3084db.inTransaction()) {
                this.f3084db.setTransactionSuccessful();
                this.f3084db.endTransaction();
            }
        } else if (!this.f3084db.inTransaction()) {
            this.f3084db.beginTransaction();
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public Savepoint setSavePoint(String name) throws SQLException {
        try {
            this.f3084db.beginTransaction();
            logger.trace("{}: save-point set with name {}", this, name);
            return new OurSavePoint(name);
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems beginning transaction " + name, e);
        }
    }

    public boolean isReadWrite() {
        return this.readWrite;
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void commit(Savepoint savepoint) throws SQLException {
        try {
            this.f3084db.setTransactionSuccessful();
            this.f3084db.endTransaction();
            if (savepoint == null) {
                logger.trace("{}: transaction is successfuly ended", this);
            } else {
                logger.trace("{}: transaction {} is successfuly ended", this, savepoint.getSavepointName());
            }
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems commiting transaction " + savepoint.getSavepointName(), e);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void rollback(Savepoint savepoint) throws SQLException {
        try {
            this.f3084db.endTransaction();
            if (savepoint == null) {
                logger.trace("{}: transaction is ended, unsuccessfuly", this);
            } else {
                logger.trace("{}: transaction {} is ended, unsuccessfuly", this, savepoint.getSavepointName());
            }
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems rolling back transaction " + savepoint.getSavepointName(), e);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public int executeStatement(String statementStr, int resultFlags) throws SQLException {
        return AndroidCompiledStatement.execSql(this.f3084db, statementStr, statementStr, NO_STRING_ARGS);
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public CompiledStatement compileStatement(String statement, StatementBuilder.StatementType type, FieldType[] argFieldTypes) {
        CompiledStatement stmt = new AndroidCompiledStatement(statement, this.f3084db, type);
        logger.trace("{}: compiled statement got {}: {}", this, stmt, statement);
        return stmt;
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public CompiledStatement compileStatement(String statement, StatementBuilder.StatementType type, FieldType[] argFieldTypes, int resultFlags) {
        return compileStatement(statement, type, argFieldTypes);
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public int insert(String statement, Object[] args, FieldType[] argFieldTypes, GeneratedKeyHolder keyHolder) throws SQLException {
        SQLiteStatement stmt = null;
        try {
            SQLiteStatement stmt2 = this.f3084db.compileStatement(statement);
            bindArgs(stmt2, args, argFieldTypes);
            long rowId = stmt2.executeInsert();
            if (keyHolder != null) {
                keyHolder.addKey(Long.valueOf(rowId));
            }
            logger.trace("{}: insert statement is compiled and executed, changed {}: {}", (Object) this, (Object) 1, (Object) statement);
            if (stmt2 != null) {
                stmt2.close();
            }
            return 1;
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("inserting to database failed: " + statement, e);
        } catch (Throwable th) {
            if (0 != 0) {
                stmt.close();
            }
            throw th;
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public int update(String statement, Object[] args, FieldType[] argFieldTypes) throws SQLException {
        return update(statement, args, argFieldTypes, "updated");
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public int delete(String statement, Object[] args, FieldType[] argFieldTypes) throws SQLException {
        return update(statement, args, argFieldTypes, "deleted");
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public <T> Object queryForOne(String statement, Object[] args, FieldType[] argFieldTypes, GenericRowMapper<T> rowMapper, ObjectCache objectCache) throws SQLException {
        Cursor cursor = null;
        try {
            cursor = this.f3084db.rawQuery(statement, toStrings(args));
            AndroidDatabaseResults results = new AndroidDatabaseResults(cursor, objectCache);
            logger.trace("{}: queried for one result: {}", this, statement);
            if (!results.first()) {
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
            T mapRow = rowMapper.mapRow(results);
            if (results.next()) {
                Object obj = MORE_THAN_ONE;
                if (cursor == null) {
                    return obj;
                }
                cursor.close();
                return obj;
            } else if (cursor == null) {
                return mapRow;
            } else {
                cursor.close();
                return mapRow;
            }
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("queryForOne from database failed: " + statement, e);
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public long queryForLong(String statement) throws SQLException {
        SQLiteStatement stmt = null;
        try {
            stmt = this.f3084db.compileStatement(statement);
            long result = stmt.simpleQueryForLong();
            logger.trace("{}: query for long simple query returned {}: {}", this, Long.valueOf(result), statement);
            if (stmt != null) {
                stmt.close();
            }
            return result;
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("queryForLong from database failed: " + statement, e);
        } catch (Throwable th) {
            if (stmt != null) {
                stmt.close();
            }
            throw th;
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public long queryForLong(String statement, Object[] args, FieldType[] argFieldTypes) throws SQLException {
        long result;
        Cursor cursor = null;
        try {
            Cursor cursor2 = this.f3084db.rawQuery(statement, toStrings(args));
            AndroidDatabaseResults results = new AndroidDatabaseResults(cursor2, null);
            if (results.first()) {
                result = results.getLong(0);
            } else {
                result = 0;
            }
            logger.trace("{}: query for long raw query returned {}: {}", this, Long.valueOf(result), statement);
            if (cursor2 != null) {
                cursor2.close();
            }
            return result;
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("queryForLong from database failed: " + statement, e);
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void close() throws SQLException {
        try {
            this.f3084db.close();
            logger.trace("{}: db {} closed", this, this.f3084db);
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems closing the database connection", e);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void closeQuietly() {
        try {
            close();
        } catch (SQLException e) {
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public boolean isClosed() throws SQLException {
        try {
            boolean isOpen = this.f3084db.isOpen();
            logger.trace("{}: db {} isOpen returned {}", this, this.f3084db, Boolean.valueOf(isOpen));
            return !isOpen;
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems detecting if the database is closed", e);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public boolean isTableExists(String tableName) {
        boolean result;
        Cursor cursor = this.f3084db.rawQuery("SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name = '" + tableName + "'", null);
        if (cursor != null) {
            try {
                if (cursor.getCount() > 0) {
                    result = true;
                    logger.trace("{}: isTableExists '{}' returned {}", this, tableName, Boolean.valueOf(result));
                    cursor.close();
                    return result;
                }
            } catch (Throwable th) {
                cursor.close();
                throw th;
            }
        }
        result = false;
        logger.trace("{}: isTableExists '{}' returned {}", this, tableName, Boolean.valueOf(result));
        cursor.close();
        return result;
    }

    private int update(String statement, Object[] args, FieldType[] argFieldTypes, String label) throws SQLException {
        int result;
        SQLiteStatement stmt = null;
        try {
            stmt = this.f3084db.compileStatement(statement);
            bindArgs(stmt, args, argFieldTypes);
            stmt.execute();
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
            try {
                stmt = this.f3084db.compileStatement("SELECT CHANGES()");
                result = (int) stmt.simpleQueryForLong();
                if (stmt != null) {
                    stmt.close();
                }
            } catch (android.database.SQLException e) {
                result = 1;
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Throwable th) {
                if (stmt != null) {
                    stmt.close();
                }
                throw th;
            }
            logger.trace("{} statement is compiled and executed, changed {}: {}", label, Integer.valueOf(result), statement);
            return result;
        } catch (android.database.SQLException e2) {
            throw SqlExceptionUtil.create("updating database failed: " + statement, e2);
        } catch (Throwable th2) {
            if (stmt != null) {
                stmt.close();
            }
            throw th2;
        }
    }

    private void bindArgs(SQLiteStatement stmt, Object[] args, FieldType[] argFieldTypes) throws SQLException {
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                Object arg = args[i];
                if (arg == null) {
                    stmt.bindNull(i + 1);
                } else {
                    SqlType sqlType = argFieldTypes[i].getSqlType();
                    switch ($SWITCH_TABLE$com$j256$ormlite$field$SqlType()[sqlType.ordinal()]) {
                        case 1:
                        case 2:
                        case 5:
                            stmt.bindString(i + 1, arg.toString());
                            continue;
                        case 3:
                        case 14:
                        case 15:
                            throw new SQLException("Invalid Android type: " + sqlType);
                        case 4:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                            stmt.bindLong(i + 1, ((Number) arg).longValue());
                            continue;
                        case 7:
                        case 13:
                            stmt.bindBlob(i + 1, (byte[]) arg);
                            continue;
                        case 11:
                        case 12:
                            stmt.bindDouble(i + 1, ((Number) arg).doubleValue());
                            continue;
                        default:
                            throw new SQLException("Unknown sql argument type: " + sqlType);
                    }
                }
            }
        }
    }

    private String[] toStrings(Object[] args) {
        if (args == null || args.length == 0) {
            return null;
        }
        String[] strings = new String[args.length];
        for (int i = 0; i < args.length; i++) {
            Object arg = args[i];
            if (arg == null) {
                strings[i] = null;
            } else {
                strings[i] = arg.toString();
            }
        }
        return strings;
    }

    public String toString() {
        return String.valueOf(getClass().getSimpleName()) + "@" + Integer.toHexString(super.hashCode());
    }

    private static class OurSavePoint implements Savepoint {
        private String name;

        public OurSavePoint(String name2) {
            this.name = name2;
        }

        @Override // java.sql.Savepoint
        public int getSavepointId() {
            return 0;
        }

        @Override // java.sql.Savepoint
        public String getSavepointName() {
            return this.name;
        }
    }
}
