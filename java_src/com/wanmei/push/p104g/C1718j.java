package com.wanmei.push.p104g;

import java.io.Serializable;
import java.io.Writer;

/* renamed from: com.wanmei.push.g.j */
public final class C1718j extends Writer implements Serializable {

    /* renamed from: a */
    private final StringBuilder f4360a;

    public C1718j() {
        this.f4360a = new StringBuilder();
    }

    public C1718j(byte b) {
        this.f4360a = new StringBuilder(4);
    }

    @Override // java.lang.Appendable, java.io.Writer, java.io.Writer
    public final Writer append(char value) {
        this.f4360a.append(value);
        return this;
    }

    @Override // java.lang.Appendable, java.io.Writer, java.io.Writer
    public final Writer append(CharSequence value) {
        this.f4360a.append(value);
        return this;
    }

    @Override // java.lang.Appendable, java.io.Writer, java.io.Writer
    public final Writer append(CharSequence value, int start, int end) {
        this.f4360a.append(value, start, end);
        return this;
    }

    @Override // java.io.Closeable, java.io.Writer, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
    }

    public final String toString() {
        return this.f4360a.toString();
    }

    @Override // java.io.Writer
    public final void write(String value) {
        if (value != null) {
            this.f4360a.append(value);
        }
    }

    @Override // java.io.Writer
    public final void write(char[] value, int offset, int length) {
        if (value != null) {
            this.f4360a.append(value, offset, length);
        }
    }
}
