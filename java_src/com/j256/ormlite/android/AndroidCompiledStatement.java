package com.j256.ormlite.android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AndroidCompiledStatement implements CompiledStatement {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$j256$ormlite$field$SqlType;
    private static final String[] NO_STRING_ARGS = new String[0];
    private static Logger logger = LoggerFactory.getLogger(AndroidCompiledStatement.class);
    private List<Object> args;
    private Cursor cursor;

    /* renamed from: db */
    private final SQLiteDatabase f3083db;
    private Integer max;
    private final String sql;
    private final StatementBuilder.StatementType type;

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

    public AndroidCompiledStatement(String sql2, SQLiteDatabase db, StatementBuilder.StatementType type2) {
        this.sql = sql2;
        this.f3083db = db;
        this.type = type2;
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public int getColumnCount() throws SQLException {
        return getCursor().getColumnCount();
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public String getColumnName(int column) throws SQLException {
        return getCursor().getColumnName(column);
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public DatabaseResults runQuery(ObjectCache objectCache) throws SQLException {
        if (this.type.isOkForQuery()) {
            return new AndroidDatabaseResults(getCursor(), objectCache);
        }
        throw new IllegalArgumentException("Cannot call query on a " + this.type + " statement");
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public int runUpdate() throws SQLException {
        String finalSql;
        if (!this.type.isOkForUpdate()) {
            throw new IllegalArgumentException("Cannot call update on a " + this.type + " statement");
        }
        if (this.max == null) {
            finalSql = this.sql;
        } else {
            finalSql = String.valueOf(this.sql) + " " + this.max;
        }
        return execSql(this.f3083db, "runUpdate", finalSql, getArgArray());
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public int runExecute() throws SQLException {
        if (this.type.isOkForExecute()) {
            return execSql(this.f3083db, "runExecute", this.sql, getArgArray());
        }
        throw new IllegalArgumentException("Cannot call execute on a " + this.type + " statement");
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public void close() throws SQLException {
        if (this.cursor != null) {
            try {
                this.cursor.close();
            } catch (android.database.SQLException e) {
                throw SqlExceptionUtil.create("Problems closing Android cursor", e);
            }
        }
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public void closeQuietly() {
        try {
            close();
        } catch (SQLException e) {
        }
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public void setObject(int parameterIndex, Object obj, SqlType sqlType) throws SQLException {
        isInPrep();
        if (this.args == null) {
            this.args = new ArrayList();
        }
        if (obj == null) {
            this.args.add(parameterIndex, null);
            return;
        }
        switch ($SWITCH_TABLE$com$j256$ormlite$field$SqlType()[sqlType.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                this.args.add(parameterIndex, obj.toString());
                return;
            case 7:
            case 13:
                this.args.add(parameterIndex, obj);
                return;
            case 14:
            case 15:
                throw new SQLException("Invalid Android type: " + sqlType);
            default:
                throw new SQLException("Unknown sql argument type: " + sqlType);
        }
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public void setMaxRows(int max2) throws SQLException {
        isInPrep();
        this.max = Integer.valueOf(max2);
    }

    @Override // com.j256.ormlite.support.CompiledStatement
    public void setQueryTimeout(long millis) {
    }

    public Cursor getCursor() throws SQLException {
        String finalSql;
        if (this.cursor == null) {
            try {
                if (this.max == null) {
                    finalSql = this.sql;
                } else {
                    finalSql = String.valueOf(this.sql) + " " + this.max;
                }
                this.cursor = this.f3083db.rawQuery(finalSql, getStringArray());
                this.cursor.moveToFirst();
                logger.trace("{}: started rawQuery cursor for: {}", this, finalSql);
            } catch (android.database.SQLException e) {
                throw SqlExceptionUtil.create("Problems executing Android query: " + ((String) null), e);
            }
        }
        return this.cursor;
    }

    public String toString() {
        return String.valueOf(getClass().getSimpleName()) + "@" + Integer.toHexString(super.hashCode());
    }

    static int execSql(SQLiteDatabase db, String label, String finalSql, Object[] argArray) throws SQLException {
        int result;
        try {
            db.execSQL(finalSql, argArray);
            SQLiteStatement stmt = null;
            try {
                stmt = db.compileStatement("SELECT CHANGES()");
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
            logger.trace("executing statement {} changed {} rows: {}", label, Integer.valueOf(result), finalSql);
            return result;
        } catch (android.database.SQLException e2) {
            throw SqlExceptionUtil.create("Problems executing " + label + " Android statement: " + finalSql, e2);
        }
    }

    private void isInPrep() throws SQLException {
        if (this.cursor != null) {
            throw new SQLException("Query already run. Cannot add argument values.");
        }
    }

    private Object[] getArgArray() {
        if (this.args == null) {
            return NO_STRING_ARGS;
        }
        return this.args.toArray(new Object[this.args.size()]);
    }

    private String[] getStringArray() {
        if (this.args == null) {
            return NO_STRING_ARGS;
        }
        return (String[]) this.args.toArray(new String[this.args.size()]);
    }
}
