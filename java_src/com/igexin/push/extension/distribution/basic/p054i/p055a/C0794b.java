package com.igexin.push.extension.distribution.basic.p054i.p055a;

import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.igexin.push.extension.distribution.basic.i.a.b */
public class C0794b<E> extends LinkedList<E> {
    @Override // java.util.LinkedList, java.util.Deque
    public Iterator<E> descendingIterator() {
        return new C0796d(this, size());
    }

    @Override // java.util.LinkedList, java.util.Deque
    public E peekLast() {
        if (size() == 0) {
            return null;
        }
        return getLast();
    }

    @Override // java.util.LinkedList, java.util.Deque
    public E pollLast() {
        if (size() == 0) {
            return null;
        }
        return removeLast();
    }

    @Override // java.util.LinkedList, java.util.Deque
    public void push(E e) {
        addFirst(e);
    }
}
