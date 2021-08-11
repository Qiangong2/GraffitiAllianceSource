package org.apache.thrift.protocol;

import com.j256.ormlite.stmt.query.SimpleComparison;

/* renamed from: org.apache.thrift.protocol.c */
public class C2177c {

    /* renamed from: a */
    public final String f6209a;

    /* renamed from: b */
    public final byte f6210b;

    /* renamed from: c */
    public final short f6211c;

    public C2177c() {
        this("", (byte) 0, 0);
    }

    public C2177c(String str, byte b, short s) {
        this.f6209a = str;
        this.f6210b = b;
        this.f6211c = s;
    }

    public String toString() {
        return "<TField name:'" + this.f6209a + "' type:" + ((int) this.f6210b) + " field-id:" + ((int) this.f6211c) + SimpleComparison.GREATER_THAN_OPERATION;
    }
}
