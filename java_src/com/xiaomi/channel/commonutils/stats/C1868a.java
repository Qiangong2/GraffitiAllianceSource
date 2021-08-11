package com.xiaomi.channel.commonutils.stats;

import java.util.LinkedList;

/* renamed from: com.xiaomi.channel.commonutils.stats.a */
public class C1868a {

    /* renamed from: a */
    private LinkedList<C1869a> f4637a = new LinkedList<>();

    /* renamed from: com.xiaomi.channel.commonutils.stats.a$a */
    public static class C1869a {

        /* renamed from: d */
        private static final C1868a f4638d = new C1868a();

        /* renamed from: a */
        public int f4639a;

        /* renamed from: b */
        public String f4640b;

        /* renamed from: c */
        public Object f4641c;

        C1869a(int i, Object obj) {
            this.f4639a = i;
            this.f4641c = obj;
        }
    }

    /* renamed from: a */
    public static C1868a m6765a() {
        return C1869a.f4638d;
    }

    /* renamed from: d */
    private void m6766d() {
        if (this.f4637a.size() > 100) {
            this.f4637a.removeFirst();
        }
    }

    /* renamed from: a */
    public synchronized void mo9942a(Object obj) {
        this.f4637a.add(new C1869a(0, obj));
        m6766d();
    }

    /* renamed from: b */
    public synchronized int mo9943b() {
        return this.f4637a.size();
    }

    /* renamed from: c */
    public synchronized LinkedList<C1869a> mo9944c() {
        LinkedList<C1869a> linkedList;
        linkedList = this.f4637a;
        this.f4637a = new LinkedList<>();
        return linkedList;
    }
}
