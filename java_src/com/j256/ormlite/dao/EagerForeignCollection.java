package com.j256.ormlite.dao;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.support.DatabaseResults;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class EagerForeignCollection<T, ID> extends BaseForeignCollection<T, ID> implements ForeignCollection<T>, CloseableWrappedIterable<T>, Serializable {
    private static final long serialVersionUID = -2523335606983317721L;
    private List<T> results;

    public EagerForeignCollection(Dao<T, ID> dao, Object parent, Object parentId, FieldType foreignFieldType, String orderColumn, boolean orderAscending) throws SQLException {
        super(dao, parent, parentId, foreignFieldType, orderColumn, orderAscending);
        if (parentId == null) {
            this.results = new ArrayList();
        } else {
            this.results = dao.query(getPreparedQuery());
        }
    }

    @Override // java.util.Collection, java.lang.Iterable
    public CloseableIterator<T> iterator() {
        return iteratorThrow();
    }

    @Override // com.j256.ormlite.dao.CloseableIterable
    public CloseableIterator<T> closeableIterator() {
        return iteratorThrow();
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public CloseableIterator<T> iteratorThrow() {
        return new CloseableIterator<T>() {
            /* class com.j256.ormlite.dao.EagerForeignCollection.C11861 */
            private int offset = -1;

            public boolean hasNext() {
                return this.offset + 1 < EagerForeignCollection.this.results.size();
            }

            @Override // com.j256.ormlite.dao.CloseableIterator
            public T first() {
                this.offset = 0;
                if (this.offset >= EagerForeignCollection.this.results.size()) {
                    return null;
                }
                return (T) EagerForeignCollection.this.results.get(0);
            }

            @Override // java.util.Iterator
            public T next() {
                this.offset++;
                return (T) EagerForeignCollection.this.results.get(this.offset);
            }

            @Override // com.j256.ormlite.dao.CloseableIterator
            public T nextThrow() {
                this.offset++;
                if (this.offset >= EagerForeignCollection.this.results.size()) {
                    return null;
                }
                return (T) EagerForeignCollection.this.results.get(this.offset);
            }

            @Override // com.j256.ormlite.dao.CloseableIterator
            public T current() {
                if (this.offset < 0) {
                    this.offset = 0;
                }
                if (this.offset >= EagerForeignCollection.this.results.size()) {
                    return null;
                }
                return (T) EagerForeignCollection.this.results.get(this.offset);
            }

            @Override // com.j256.ormlite.dao.CloseableIterator
            public T previous() {
                this.offset--;
                if (this.offset < 0 || this.offset >= EagerForeignCollection.this.results.size()) {
                    return null;
                }
                return (T) EagerForeignCollection.this.results.get(this.offset);
            }

            @Override // com.j256.ormlite.dao.CloseableIterator
            public T moveRelative(int relativeOffset) {
                this.offset += relativeOffset;
                if (this.offset < 0 || this.offset >= EagerForeignCollection.this.results.size()) {
                    return null;
                }
                return (T) EagerForeignCollection.this.results.get(this.offset);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: com.j256.ormlite.dao.Dao */
            /* JADX WARN: Multi-variable type inference failed */
            public void remove() {
                if (this.offset < 0) {
                    throw new IllegalStateException("next() must be called before remove()");
                } else if (this.offset >= EagerForeignCollection.this.results.size()) {
                    throw new IllegalStateException("current results position (" + this.offset + ") is out of bounds");
                } else {
                    Object remove = EagerForeignCollection.this.results.remove(this.offset);
                    if (EagerForeignCollection.this.dao != null) {
                        try {
                            EagerForeignCollection.this.dao.delete(remove);
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }

            @Override // com.j256.ormlite.dao.CloseableIterator
            public void close() {
            }

            @Override // com.j256.ormlite.dao.CloseableIterator
            public void closeQuietly() {
            }

            @Override // com.j256.ormlite.dao.CloseableIterator
            public DatabaseResults getRawResults() {
                return null;
            }

            @Override // com.j256.ormlite.dao.CloseableIterator
            public void moveToNext() {
                this.offset++;
            }
        };
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public CloseableWrappedIterable<T> getWrappedIterable() {
        return this;
    }

    @Override // com.j256.ormlite.dao.CloseableWrappedIterable
    public void close() {
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public void closeLastIterator() {
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public boolean isEager() {
        return true;
    }

    public int size() {
        return this.results.size();
    }

    public boolean isEmpty() {
        return this.results.isEmpty();
    }

    public boolean contains(Object o) {
        return this.results.contains(o);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> c) {
        return this.results.containsAll(c);
    }

    public Object[] toArray() {
        return this.results.toArray();
    }

    @Override // java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        return (E[]) this.results.toArray(eArr);
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, com.j256.ormlite.dao.ForeignCollection, java.util.Collection
    public boolean add(T data) {
        if (this.results.add(data)) {
            return super.add(data);
        }
        return false;
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        if (this.results.addAll(collection)) {
            return super.addAll(collection);
        }
        return false;
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection
    public boolean remove(Object data) {
        if (!this.results.remove(data) || this.dao == null) {
            return false;
        }
        try {
            return this.dao.delete(data) == 1;
        } catch (SQLException e) {
            throw new IllegalStateException("Could not delete data element from dao", e);
        }
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        boolean changed = false;
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (remove(it.next())) {
                changed = true;
            }
        }
        return changed;
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return super.retainAll(collection);
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection
    public void clear() {
        this.results.clear();
        super.clear();
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public int updateAll() throws SQLException {
        int updatedC = 0;
        for (T data : this.results) {
            updatedC += this.dao.update((Object) data);
        }
        return updatedC;
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public int refreshAll() throws SQLException {
        int updatedC = 0;
        for (T data : this.results) {
            updatedC += this.dao.refresh(data);
        }
        return updatedC;
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public int refreshCollection() throws SQLException {
        this.results = this.dao.query(getPreparedQuery());
        return this.results.size();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof EagerForeignCollection)) {
            return false;
        }
        return this.results.equals(((EagerForeignCollection) obj).results);
    }

    public int hashCode() {
        return this.results.hashCode();
    }
}
