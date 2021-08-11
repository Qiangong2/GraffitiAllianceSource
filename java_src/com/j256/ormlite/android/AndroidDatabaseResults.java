package com.j256.ormlite.android;

import android.database.Cursor;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.p083db.DatabaseType;
import com.j256.ormlite.p083db.SqliteAndroidDatabaseType;
import com.j256.ormlite.support.DatabaseResults;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AndroidDatabaseResults implements DatabaseResults {
    private static final int MIN_NUM_COLUMN_NAMES_MAP = 8;
    private static final DatabaseType databaseType = new SqliteAndroidDatabaseType();
    private final Map<String, Integer> columnNameMap;
    private final String[] columnNames;
    private final Cursor cursor;
    private final ObjectCache objectCache;

    public AndroidDatabaseResults(Cursor cursor2, ObjectCache objectCache2) {
        this.cursor = cursor2;
        this.columnNames = cursor2.getColumnNames();
        if (this.columnNames.length >= 8) {
            this.columnNameMap = new HashMap();
            for (int i = 0; i < this.columnNames.length; i++) {
                this.columnNameMap.put(this.columnNames[i], Integer.valueOf(i));
            }
        } else {
            this.columnNameMap = null;
        }
        this.objectCache = objectCache2;
    }

    @Deprecated
    public AndroidDatabaseResults(Cursor cursor2, boolean firstCall, ObjectCache objectCache2) {
        this(cursor2, objectCache2);
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public int getColumnCount() {
        return this.cursor.getColumnCount();
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public String[] getColumnNames() {
        int colN = getColumnCount();
        String[] columnNames2 = new String[colN];
        for (int colC = 0; colC < colN; colC++) {
            columnNames2[colC] = this.cursor.getColumnName(colC);
        }
        return columnNames2;
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public boolean first() {
        return this.cursor.moveToFirst();
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public boolean next() {
        return this.cursor.moveToNext();
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public boolean last() {
        return this.cursor.moveToLast();
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public boolean previous() {
        return this.cursor.moveToPrevious();
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public boolean moveRelative(int offset) {
        return this.cursor.move(offset);
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public boolean moveAbsolute(int position) {
        return this.cursor.moveToPosition(position);
    }

    public int getCount() {
        return this.cursor.getCount();
    }

    public int getPosition() {
        return this.cursor.getPosition();
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public int findColumn(String columnName) throws SQLException {
        int index = lookupColumn(columnName);
        if (index >= 0) {
            return index;
        }
        StringBuilder sb = new StringBuilder(columnName.length() + 4);
        databaseType.appendEscapedEntityName(sb, columnName);
        int index2 = lookupColumn(sb.toString());
        if (index2 >= 0) {
            return index2;
        }
        throw new SQLException("Unknown field '" + columnName + "' from the Android sqlite cursor, not in:" + Arrays.toString(this.cursor.getColumnNames()));
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public String getString(int columnIndex) {
        return this.cursor.getString(columnIndex);
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public boolean getBoolean(int columnIndex) {
        if (this.cursor.isNull(columnIndex) || this.cursor.getShort(columnIndex) == 0) {
            return false;
        }
        return true;
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public char getChar(int columnIndex) throws SQLException {
        String string = this.cursor.getString(columnIndex);
        if (string == null || string.length() == 0) {
            return 0;
        }
        if (string.length() == 1) {
            return string.charAt(0);
        }
        throw new SQLException("More than 1 character stored in database column: " + columnIndex);
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public byte getByte(int columnIndex) {
        return (byte) getShort(columnIndex);
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public byte[] getBytes(int columnIndex) {
        return this.cursor.getBlob(columnIndex);
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public short getShort(int columnIndex) {
        return this.cursor.getShort(columnIndex);
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public int getInt(int columnIndex) {
        return this.cursor.getInt(columnIndex);
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public long getLong(int columnIndex) {
        return this.cursor.getLong(columnIndex);
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public float getFloat(int columnIndex) {
        return this.cursor.getFloat(columnIndex);
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public double getDouble(int columnIndex) {
        return this.cursor.getDouble(columnIndex);
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public Timestamp getTimestamp(int columnIndex) throws SQLException {
        throw new SQLException("Android does not support timestamp.  Use JAVA_DATE_LONG or JAVA_DATE_STRING types");
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public InputStream getBlobStream(int columnIndex) {
        return new ByteArrayInputStream(this.cursor.getBlob(columnIndex));
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
        throw new SQLException("Android does not support BigDecimal type.  Use BIG_DECIMAL or BIG_DECIMAL_STRING types");
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public boolean wasNull(int columnIndex) {
        return this.cursor.isNull(columnIndex);
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public ObjectCache getObjectCache() {
        return this.objectCache;
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public void close() {
        this.cursor.close();
    }

    @Override // com.j256.ormlite.support.DatabaseResults
    public void closeQuietly() {
        close();
    }

    public Cursor getRawCursor() {
        return this.cursor;
    }

    public String toString() {
        return String.valueOf(getClass().getSimpleName()) + "@" + Integer.toHexString(super.hashCode());
    }

    private int lookupColumn(String columnName) {
        if (this.columnNameMap == null) {
            for (int i = 0; i < this.columnNames.length; i++) {
                if (this.columnNames[i].equals(columnName)) {
                    return i;
                }
            }
            return -1;
        }
        Integer index = this.columnNameMap.get(columnName);
        if (index == null) {
            return -1;
        }
        return index.intValue();
    }
}
