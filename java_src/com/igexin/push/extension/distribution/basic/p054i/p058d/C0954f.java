package com.igexin.push.extension.distribution.basic.p054i.p058d;

import com.igexin.push.extension.distribution.basic.p054i.p056b.C0813i;
import com.tencent.qcloud.core.util.IOUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* renamed from: com.igexin.push.extension.distribution.basic.i.d.f */
public class C0954f implements Cloneable, List<C0813i> {

    /* renamed from: a */
    private List<C0813i> f2491a;

    public C0954f() {
        this.f2491a = new ArrayList();
    }

    public C0954f(List<C0813i> list) {
        this.f2491a = list;
    }

    /* renamed from: a */
    public C0813i get(int i) {
        return this.f2491a.get(i);
    }

    /* renamed from: a */
    public C0813i set(int i, C0813i iVar) {
        return this.f2491a.set(i, iVar);
    }

    /* renamed from: a */
    public C0954f clone() {
        ArrayList arrayList = new ArrayList();
        for (C0813i iVar : this.f2491a) {
            arrayList.add(iVar.mo5315g());
        }
        return new C0954f(arrayList);
    }

    /* renamed from: a */
    public boolean add(C0813i iVar) {
        return this.f2491a.add(iVar);
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends C0813i> collection) {
        return this.f2491a.addAll(i, collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends C0813i> collection) {
        return this.f2491a.addAll(collection);
    }

    /* renamed from: b */
    public C0813i remove(int i) {
        return this.f2491a.remove(i);
    }

    /* renamed from: b */
    public String mo5583b() {
        StringBuilder sb = new StringBuilder();
        for (C0813i iVar : this.f2491a) {
            if (sb.length() != 0) {
                sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            sb.append(iVar.mo5313e_());
        }
        return sb.toString();
    }

    /* renamed from: b */
    public void add(int i, C0813i iVar) {
        this.f2491a.add(i, iVar);
    }

    /* renamed from: c */
    public C0813i mo5585c() {
        if (this.f2491a.isEmpty()) {
            return null;
        }
        return this.f2491a.get(0);
    }

    public void clear() {
        this.f2491a.clear();
    }

    public boolean contains(Object obj) {
        return this.f2491a.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.f2491a.containsAll(collection);
    }

    public boolean equals(Object obj) {
        return this.f2491a.equals(obj);
    }

    public int hashCode() {
        return this.f2491a.hashCode();
    }

    public int indexOf(Object obj) {
        return this.f2491a.indexOf(obj);
    }

    public boolean isEmpty() {
        return this.f2491a.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<C0813i> iterator() {
        return this.f2491a.iterator();
    }

    public int lastIndexOf(Object obj) {
        return this.f2491a.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<C0813i> listIterator() {
        return this.f2491a.listIterator();
    }

    @Override // java.util.List
    public ListIterator<C0813i> listIterator(int i) {
        return this.f2491a.listIterator(i);
    }

    @Override // java.util.List
    public boolean remove(Object obj) {
        return this.f2491a.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        return this.f2491a.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return this.f2491a.retainAll(collection);
    }

    public int size() {
        return this.f2491a.size();
    }

    @Override // java.util.List
    public List<C0813i> subList(int i, int i2) {
        return this.f2491a.subList(i, i2);
    }

    public Object[] toArray() {
        return this.f2491a.toArray();
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.f2491a.toArray(tArr);
    }

    public String toString() {
        return mo5583b();
    }
}
