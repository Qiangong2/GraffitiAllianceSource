package com.xiaomi.xmpush.thrift;

import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import org.apache.thrift.AbstractC2158b;
import org.apache.thrift.C2163e;
import org.apache.thrift.C2164f;
import org.apache.thrift.C2165g;
import org.apache.thrift.protocol.C2173a;
import org.apache.thrift.protocol.C2186l;

/* renamed from: com.xiaomi.xmpush.thrift.u */
public class C2103u {
    /* renamed from: a */
    public static <T extends AbstractC2158b<T, ?>> void m8168a(T t, byte[] bArr) {
        if (bArr == null) {
            throw new C2164f("the message byte is empty.");
        }
        new C2163e(new C2186l.C2187a(true, true, bArr.length)).mo12122a(t, bArr);
    }

    /* renamed from: a */
    public static <T extends AbstractC2158b<T, ?>> byte[] m8169a(T t) {
        if (t == null) {
            return null;
        }
        try {
            return new C2165g(new C2173a.C2174a()).mo12123a(t);
        } catch (C2164f e) {
            AbstractC1855b.m6719a("convertThriftObjectToBytes catch TException.", e);
            return null;
        }
    }
}
