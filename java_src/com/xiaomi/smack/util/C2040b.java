package com.xiaomi.smack.util;

import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.xiaomi.smack.util.b */
public class C2040b extends Writer {

    /* renamed from: a */
    Writer f5455a = null;

    /* renamed from: b */
    List f5456b = new ArrayList();

    public C2040b(Writer writer) {
        this.f5455a = writer;
    }

    /* renamed from: a */
    private void m7683a(String str) {
        AbstractC2052m[] mVarArr;
        synchronized (this.f5456b) {
            mVarArr = new AbstractC2052m[this.f5456b.size()];
            this.f5456b.toArray(mVarArr);
        }
        for (AbstractC2052m mVar : mVarArr) {
            mVar.mo10104a(str);
        }
    }

    /* renamed from: a */
    public void mo10652a(AbstractC2052m mVar) {
        if (mVar != null) {
            synchronized (this.f5456b) {
                if (!this.f5456b.contains(mVar)) {
                    this.f5456b.add(mVar);
                }
            }
        }
    }

    /* renamed from: b */
    public void mo10653b(AbstractC2052m mVar) {
        synchronized (this.f5456b) {
            this.f5456b.remove(mVar);
        }
    }

    @Override // java.io.Closeable, java.io.Writer, java.lang.AutoCloseable
    public void close() {
        this.f5455a.close();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        this.f5455a.flush();
    }

    @Override // java.io.Writer
    public void write(int i) {
        this.f5455a.write(i);
    }

    @Override // java.io.Writer
    public void write(String str) {
        this.f5455a.write(str);
        m7683a(str);
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) {
        this.f5455a.write(str, i, i2);
        m7683a(str.substring(i, i + i2));
    }

    @Override // java.io.Writer
    public void write(char[] cArr) {
        this.f5455a.write(cArr);
        m7683a(new String(cArr));
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        this.f5455a.write(cArr, i, i2);
        m7683a(new String(cArr, i, i2));
    }
}
