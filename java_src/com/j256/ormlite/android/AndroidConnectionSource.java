package com.j256.ormlite.android;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.p083db.DatabaseType;
import com.j256.ormlite.p083db.SqliteAndroidDatabaseType;
import com.j256.ormlite.support.BaseConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import java.sql.SQLException;

public class AndroidConnectionSource extends BaseConnectionSource implements ConnectionSource {
    private static final Logger logger = LoggerFactory.getLogger(AndroidConnectionSource.class);
    private AndroidDatabaseConnection connection;
    private final DatabaseType databaseType;
    private final SQLiteOpenHelper helper;
    private volatile boolean isOpen;
    private final SQLiteDatabase sqliteDatabase;

    public AndroidConnectionSource(SQLiteOpenHelper helper2) {
        this.connection = null;
        this.isOpen = true;
        this.databaseType = new SqliteAndroidDatabaseType();
        this.helper = helper2;
        this.sqliteDatabase = null;
    }

    public AndroidConnectionSource(SQLiteDatabase sqliteDatabase2) {
        this.connection = null;
        this.isOpen = true;
        this.databaseType = new SqliteAndroidDatabaseType();
        this.helper = null;
        this.sqliteDatabase = sqliteDatabase2;
    }

    @Override // com.j256.ormlite.support.ConnectionSource
    public DatabaseConnection getReadOnlyConnection() throws SQLException {
        return getReadWriteConnection();
    }

    @Override // com.j256.ormlite.support.ConnectionSource
    public DatabaseConnection getReadWriteConnection() throws SQLException {
        SQLiteDatabase db;
        DatabaseConnection conn = getSavedConnection();
        if (conn != null) {
            return conn;
        }
        if (this.connection == null) {
            if (this.sqliteDatabase == null) {
                try {
                    db = this.helper.getWritableDatabase();
                } catch (android.database.SQLException e) {
                    throw SqlExceptionUtil.create("Getting a writable database from helper " + this.helper + " failed", e);
                }
            } else {
                db = this.sqliteDatabase;
            }
            this.connection = new AndroidDatabaseConnection(db, true);
            logger.trace("created connection {} for db {}, helper {}", this.connection, db, this.helper);
        } else {
            logger.trace("{}: returning read-write connection {}, helper {}", this, this.connection, this.helper);
        }
        return this.connection;
    }

    @Override // com.j256.ormlite.support.ConnectionSource
    public void releaseConnection(DatabaseConnection connection2) {
    }

    @Override // com.j256.ormlite.support.ConnectionSource
    public boolean saveSpecialConnection(DatabaseConnection connection2) throws SQLException {
        return saveSpecial(connection2);
    }

    @Override // com.j256.ormlite.support.ConnectionSource
    public void clearSpecialConnection(DatabaseConnection connection2) {
        clearSpecial(connection2, logger);
    }

    @Override // com.j256.ormlite.support.ConnectionSource
    public void close() {
        this.isOpen = false;
    }

    @Override // com.j256.ormlite.support.ConnectionSource
    public void closeQuietly() {
        close();
    }

    @Override // com.j256.ormlite.support.ConnectionSource
    public DatabaseType getDatabaseType() {
        return this.databaseType;
    }

    @Override // com.j256.ormlite.support.ConnectionSource
    public boolean isOpen() {
        return this.isOpen;
    }

    public String toString() {
        return String.valueOf(getClass().getSimpleName()) + "@" + Integer.toHexString(super.hashCode());
    }
}
