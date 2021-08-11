package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RawResultsImpl<T> implements GenericRawResults<T> {
    private final String[] columnNames = this.iterator.getRawResults().getColumnNames();
    private SelectIterator<T, Void> iterator;

    public RawResultsImpl(ConnectionSource connectionSource, DatabaseConnection connection, String query, Class<?> clazz, CompiledStatement compiledStmt, GenericRowMapper<T> rowMapper, ObjectCache objectCache) throws SQLException {
        this.iterator = new SelectIterator<>(clazz, null, rowMapper, connectionSource, connection, compiledStmt, query, objectCache);
    }

    @Override // com.j256.ormlite.dao.GenericRawResults
    public int getNumberColumns() {
        return this.columnNames.length;
    }

    @Override // com.j256.ormlite.dao.GenericRawResults
    public String[] getColumnNames() {
        return this.columnNames;
    }

    @Override // com.j256.ormlite.dao.GenericRawResults
    public List<T> getResults() throws SQLException {
        List<T> results = new ArrayList<>();
        while (this.iterator.hasNext()) {
            try {
                results.add(this.iterator.next());
            } finally {
                this.iterator.close();
            }
        }
        return results;
    }

    @Override // com.j256.ormlite.dao.GenericRawResults
    public T getFirstResult() throws SQLException {
        try {
            if (this.iterator.hasNextThrow()) {
                return this.iterator.nextThrow();
            }
            close();
            return null;
        } finally {
            close();
        }
    }

    @Override // java.lang.Iterable
    public CloseableIterator<T> iterator() {
        return this.iterator;
    }

    @Override // com.j256.ormlite.dao.CloseableIterable
    public CloseableIterator<T> closeableIterator() {
        return this.iterator;
    }

    @Override // com.j256.ormlite.dao.GenericRawResults, com.j256.ormlite.dao.CloseableWrappedIterable
    public void close() throws SQLException {
        if (this.iterator != null) {
            this.iterator.close();
            this.iterator = null;
        }
    }
}
