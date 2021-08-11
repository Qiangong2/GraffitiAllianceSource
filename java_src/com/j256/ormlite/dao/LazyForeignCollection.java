package com.j256.ormlite.dao;

import com.j256.ormlite.field.FieldType;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LazyForeignCollection<T, ID> extends BaseForeignCollection<T, ID> implements ForeignCollection<T>, Serializable {
    private static final long serialVersionUID = -5460708106909626233L;
    private transient CloseableIterator<T> lastIterator;

    public LazyForeignCollection(Dao<T, ID> dao, Object parent, Object parentId, FieldType foreignFieldType, String orderColumn, boolean orderAscending) {
        super(dao, parent, parentId, foreignFieldType, orderColumn, orderAscending);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public CloseableIterator<T> iterator() {
        return closeableIterator();
    }

    @Override // com.j256.ormlite.dao.CloseableIterable
    public CloseableIterator<T> closeableIterator() {
        try {
            return iteratorThrow();
        } catch (SQLException e) {
            throw new IllegalStateException("Could not build lazy iterator for " + this.dao.getDataClass(), e);
        }
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public CloseableIterator<T> iteratorThrow() throws SQLException {
        this.lastIterator = seperateIteratorThrow();
        return this.lastIterator;
    }

    public CloseableIterator<T> seperateIteratorThrow() throws SQLException {
        if (this.dao != null) {
            return this.dao.iterator(getPreparedQuery());
        }
        throw new IllegalStateException("Internal DAO object is null.  Lazy collections cannot be used if they have been deserialized.");
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public CloseableWrappedIterable<T> getWrappedIterable() {
        return new CloseableWrappedIterableImpl(new CloseableIterable<T>() {
            /* class com.j256.ormlite.dao.LazyForeignCollection.C11871 */

            @Override // java.lang.Iterable
            public CloseableIterator<T> iterator() {
                return closeableIterator();
            }

            @Override // com.j256.ormlite.dao.CloseableIterable
            public CloseableIterator<T> closeableIterator() {
                try {
                    return LazyForeignCollection.this.seperateIteratorThrow();
                } catch (Exception e) {
                    throw new IllegalStateException("Could not build lazy iterator for " + LazyForeignCollection.this.dao.getDataClass(), e);
                }
            }
        });
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public void closeLastIterator() throws SQLException {
        if (this.lastIterator != null) {
            this.lastIterator.close();
            this.lastIterator = null;
        }
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public boolean isEager() {
        return false;
    }

    public int size() {
        CloseableIterator<T> iterator = iterator();
        int sizeC = 0;
        while (iterator.hasNext()) {
            try {
                iterator.moveToNext();
                sizeC++;
            } finally {
                try {
                    iterator.close();
                } catch (SQLException e) {
                }
            }
        }
        return sizeC;
    }

    public boolean isEmpty() {
        CloseableIterator<T> iterator = iterator();
        try {
            return !iterator.hasNext();
        } finally {
            try {
                iterator.close();
            } catch (SQLException e) {
            }
        }
    }

    public boolean contains(Object obj) {
        CloseableIterator<T> iterator = iterator();
        do {
            try {
                if (!iterator.hasNext()) {
                    return false;
                }
            } finally {
                try {
                    iterator.close();
                } catch (SQLException e) {
                }
            }
        } while (!iterator.next().equals(obj));
        try {
            iterator.close();
        } catch (SQLException e2) {
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        Set<Object> leftOvers = new HashSet<>((Collection<? extends Object>) collection);
        CloseableIterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            try {
                leftOvers.remove(iterator.next());
            } finally {
                try {
                    iterator.close();
                } catch (SQLException e) {
                }
            }
        }
        return leftOvers.isEmpty();
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection
    public boolean remove(Object data) {
        CloseableIterator<T> iterator = iterator();
        do {
            try {
                if (!iterator.hasNext()) {
                    return false;
                }
            } finally {
                try {
                    iterator.close();
                } catch (SQLException e) {
                }
            }
        } while (!iterator.next().equals(data));
        iterator.remove();
        try {
            iterator.close();
        } catch (SQLException e2) {
        }
        return true;
    }

    @Override // com.j256.ormlite.dao.BaseForeignCollection, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        boolean changed = false;
        CloseableIterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            try {
                if (collection.contains(iterator.next())) {
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
        return changed;
    }

    public Object[] toArray() {
        ArrayList arrayList = new ArrayList();
        CloseableIterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            try {
                arrayList.add(iterator.next());
            } finally {
                try {
                    iterator.close();
                } catch (SQLException e) {
                }
            }
        }
        return arrayList.toArray();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x0030 */
    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: E[] */
    /* JADX DEBUG: Multi-variable search result rejected for r3v5, resolved type: java.util.List */
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        Throwable th;
        List list;
        int itemC = 0;
        CloseableIterator<T> iterator = iterator();
        List list2 = null;
        while (iterator.hasNext()) {
            try {
                Object next = iterator.next();
                if (itemC >= eArr.length) {
                    if (list2 == null) {
                        list = new ArrayList();
                        try {
                            for (Object[] objArr : eArr) {
                                list.add(objArr);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                iterator.close();
                            } catch (SQLException e) {
                            }
                            throw th;
                        }
                    } else {
                        list = list2;
                    }
                    list.add(next);
                } else {
                    eArr[itemC] = next;
                    list = list2;
                }
                itemC++;
                list2 = list;
            } catch (Throwable th3) {
                th = th3;
                iterator.close();
                throw th;
            }
        }
        try {
            iterator.close();
        } catch (SQLException e2) {
        }
        if (list2 != null) {
            return (E[]) list2.toArray(eArr);
        }
        if (itemC >= eArr.length - 1) {
            return eArr;
        }
        eArr[itemC] = 0;
        return eArr;
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public int updateAll() {
        throw new UnsupportedOperationException("Cannot call updateAll() on a lazy collection.");
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public int refreshAll() {
        throw new UnsupportedOperationException("Cannot call updateAll() on a lazy collection.");
    }

    @Override // com.j256.ormlite.dao.ForeignCollection
    public int refreshCollection() {
        return 0;
    }

    public boolean equals(Object other) {
        return super.equals(other);
    }

    public int hashCode() {
        return super.hashCode();
    }
}
