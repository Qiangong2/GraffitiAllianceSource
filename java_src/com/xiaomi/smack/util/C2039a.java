package com.xiaomi.smack.util;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.xiaomi.smack.util.a */
public class C2039a extends Reader {

    /* renamed from: a */
    Reader f5453a = null;

    /* renamed from: b */
    List f5454b = new ArrayList();

    public C2039a(Reader reader) {
        this.f5453a = reader;
    }

    /* renamed from: a */
    public void mo10641a(AbstractC2044f fVar) {
        if (fVar != null) {
            synchronized (this.f5454b) {
                if (!this.f5454b.contains(fVar)) {
                    this.f5454b.add(fVar);
                }
            }
        }
    }

    /* renamed from: b */
    public void mo10642b(AbstractC2044f fVar) {
        synchronized (this.f5454b) {
            this.f5454b.remove(fVar);
        }
    }

    @Override // java.io.Closeable, java.io.Reader, java.lang.AutoCloseable
    public void close() {
        this.f5453a.close();
    }

    @Override // java.io.Reader
    public void mark(int i) {
        this.f5453a.mark(i);
    }

    public boolean markSupported() {
        return this.f5453a.markSupported();
    }

    @Override // java.io.Reader
    public int read() {
        return this.f5453a.read();
    }

    @Override // java.io.Reader
    public int read(char[] cArr) {
        return this.f5453a.read(cArr);
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) {
        AbstractC2044f[] fVarArr;
        int read = this.f5453a.read(cArr, i, i2);
        if (read > 0) {
            String str = new String(cArr, i, read);
            synchronized (this.f5454b) {
                fVarArr = new AbstractC2044f[this.f5454b.size()];
                this.f5454b.toArray(fVarArr);
            }
            for (AbstractC2044f fVar : fVarArr) {
                fVar.mo10103a(str);
            }
        }
        return read;
    }

    @Override // java.io.Reader
    public boolean ready() {
        return this.f5453a.ready();
    }

    @Override // java.io.Reader
    public void reset() {
        this.f5453a.reset();
    }

    @Override // java.io.Reader
    public long skip(long j) {
        return this.f5453a.skip(j);
    }
}
