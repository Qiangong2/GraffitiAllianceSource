package com.wanmei.sdk.core.util;

import java.io.Serializable;
import java.io.Writer;

/* renamed from: com.wanmei.sdk.core.util.h */
public class C1847h extends Writer implements Serializable {

    /* renamed from: a */
    private final StringBuilder f4597a;

    public C1847h() {
        this.f4597a = new StringBuilder();
    }

    public C1847h(byte b) {
        this.f4597a = new StringBuilder(4);
    }

    @Override // java.lang.Appendable, java.io.Writer, java.io.Writer
    public Writer append(char value) {
        this.f4597a.append(value);
        return this;
    }

    @Override // java.lang.Appendable, java.io.Writer, java.io.Writer
    public Writer append(CharSequence value) {
        this.f4597a.append(value);
        return this;
    }

    @Override // java.lang.Appendable, java.io.Writer, java.io.Writer
    public Writer append(CharSequence value, int start, int end) {
        this.f4597a.append(value, start, end);
        return this;
    }

    @Override // java.io.Closeable, java.io.Writer, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    public String toString() {
        return this.f4597a.toString();
    }

    @Override // java.io.Writer
    public void write(String value) {
        if (value != null) {
            this.f4597a.append(value);
        }
    }

    @Override // java.io.Writer
    public void write(char[] value, int offset, int length) {
        if (value != null) {
            this.f4597a.append(value, offset, length);
        }
    }
}
