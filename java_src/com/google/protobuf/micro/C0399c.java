package com.google.protobuf.micro;

import java.io.IOException;

/* renamed from: com.google.protobuf.micro.c */
public class C0399c extends IOException {
    public C0399c(String str) {
        super(str);
    }

    /* renamed from: a */
    static C0399c m1484a() {
        return new C0399c("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    /* renamed from: b */
    static C0399c m1485b() {
        return new C0399c("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* renamed from: c */
    static C0399c m1486c() {
        return new C0399c("CodedInputStream encountered a malformed varint.");
    }

    /* renamed from: d */
    static C0399c m1487d() {
        return new C0399c("Protocol message contained an invalid tag (zero).");
    }

    /* renamed from: e */
    static C0399c m1488e() {
        return new C0399c("Protocol message end-group tag did not match expected tag.");
    }

    /* renamed from: f */
    static C0399c m1489f() {
        return new C0399c("Protocol message tag had invalid wire type.");
    }

    /* renamed from: g */
    static C0399c m1490g() {
        return new C0399c("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }
}
