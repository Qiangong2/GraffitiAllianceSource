package com.igexin.push.extension.distribution.basic.p054i.p055a;

import java.util.Iterator;
import java.util.ListIterator;

/* renamed from: com.igexin.push.extension.distribution.basic.i.a.d */
class C0796d<E> implements Iterator<E> {

    /* renamed from: a */
    final /* synthetic */ C0794b f2242a;

    /* renamed from: b */
    private final ListIterator<E> f2243b;

    private C0796d(C0794b bVar, int i) {
        this.f2242a = bVar;
        this.f2243b = bVar.listIterator(i);
    }

    public boolean hasNext() {
        return this.f2243b.hasPrevious();
    }

    @Override // java.util.Iterator
    public E next() {
        return this.f2243b.previous();
    }

    public void remove() {
        this.f2243b.remove();
    }
}
