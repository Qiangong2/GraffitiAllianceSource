package com.j256.ormlite.dao;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.stmt.mapped.MappedPreparedStmt;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

public abstract class BaseForeignCollection<T, ID> implements ForeignCollection<T>, Serializable {
    private static final long serialVersionUID = -5158840898186237589L;
    protected final transient Dao<T, ID> dao;
    private final transient FieldType foreignFieldType;
    private final transient boolean orderAscending;
    private final transient String orderColumn;
    private final transient Object parent;
    private final transient Object parentId;
    private transient PreparedQuery<T> preparedQuery;

    public abstract boolean remove(Object obj);

    @Override // java.util.Collection
    public abstract boolean removeAll(Collection<?> collection);

    protected BaseForeignCollection(Dao<T, ID> dao2, Object parent2, Object parentId2, FieldType foreignFieldType2, String orderColumn2, boolean orderAscending2) {
        this.dao = dao2;
        this.foreignFieldType = foreignFieldType2;
        this.parentId = parentId2;
        this.orderColumn = orderColumn2;
        this.orderAscending = orderAscending2;
        this.parent = parent2;
    }

    @Override // com.j256.ormlite.dao.ForeignCollection, java.util.Collection
    public boolean add(T data) {
        try {
            if (this.parent != null && this.foreignFieldType.getFieldValueIfNotDefault(data) == null) {
                this.foreignFieldType.assignField(data, this.parent, true, null);
            }
            if (this.dao == null) {
                return false;
            }
            this.dao.create(data);
            return true;
        } catch (SQLException e) {
            throw new IllegalStateException("Could not create data element in dao", e);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: com.j256.ormlite.dao.Dao<T, ID> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        if (this.dao == null) {
            return false;
        }
        boolean changed = false;
        Iterator<? extends T> it = collection.iterator();
        while (it.hasNext()) {
            try {
                this.dao.create(it.next());
                changed = true;
            } catch (SQLException e) {
                throw new IllegalStateException("Could not create data elements in dao", e);
            }
        }
        return changed;
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        if (this.dao == null) {
            return false;
        }
        boolean changed = false;
        CloseableIterator<T> iterator = closeableIterator();
        while (iterator.hasNext()) {
            try {
                if (!collection.contains(iterator.next())) {
                    iterator.remove();
                    changed = true;
                }
            } finally {
                try {
                    iterator.close();
                } catch (SQLException e) {
                }
            }
        }
        try {
            return changed;
        } catch (SQLException e2) {
            return changed;
        }
    }

    public void clear() {
        if (this.dao != null) {
            CloseableIterator<T> iterator = closeableIterator();
            while (iterator.hasNext()) {
                try {
                    iterator.next();
                    iterator.remove();
                } finally {
                    try {
                        iterator.close();
                    } catch (SQLException e) {
                    }
                }
            }
        }
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public int update(T data) throws SQLException {
        if (this.dao == null) {
            return 0;
        }
        return this.dao.update((Object) data);
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public int refresh(T data) throws SQLException {
        if (this.dao == null) {
            return 0;
        }
        return this.dao.refresh(data);
    }

    /* access modifiers changed from: protected */
    public PreparedQuery<T> getPreparedQuery() throws SQLException {
        if (this.dao == null) {
            return null;
        }
        if (this.preparedQuery == null) {
            SelectArg fieldArg = new SelectArg();
            fieldArg.setValue(this.parentId);
            QueryBuilder<T, ID> qb = this.dao.queryBuilder();
            if (this.orderColumn != null) {
                qb.orderBy(this.orderColumn, this.orderAscending);
            }
            this.preparedQuery = qb.where().mo6812eq(this.foreignFieldType.getColumnName(), fieldArg).prepare();
            if (this.preparedQuery instanceof MappedPreparedStmt) {
                ((MappedPreparedStmt) this.preparedQuery).setParentInformation(this.parent, this.parentId);
            }
        }
        return this.preparedQuery;
    }
}
