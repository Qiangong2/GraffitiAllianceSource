package com.igexin.push.extension.distribution.basic.p060k;

import android.graphics.Rect;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.basic.k.a */
public class C0981a {

    /* renamed from: a */
    public final Rect f2509a = new Rect();

    /* renamed from: b */
    public int[] f2510b;

    /* renamed from: c */
    public int[] f2511c;

    /* renamed from: d */
    public int[] f2512d;

    C0981a() {
    }

    /* renamed from: a */
    public static C0981a m3940a(byte[] bArr) {
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.nativeOrder());
        if (order.get() == 0) {
            return null;
        }
        C0981a aVar = new C0981a();
        aVar.f2510b = new int[order.get()];
        aVar.f2511c = new int[order.get()];
        aVar.f2512d = new int[order.get()];
        m3941a(aVar.f2510b.length);
        m3941a(aVar.f2511c.length);
        order.getInt();
        order.getInt();
        aVar.f2509a.left = order.getInt();
        aVar.f2509a.right = order.getInt();
        aVar.f2509a.top = order.getInt();
        aVar.f2509a.bottom = order.getInt();
        order.getInt();
        m3942a(aVar.f2510b, order);
        m3942a(aVar.f2511c, order);
        m3942a(aVar.f2512d, order);
        return aVar;
    }

    /* renamed from: a */
    private static void m3941a(int i) {
        if (i == 0 || (i & 1) != 0) {
            throw new RuntimeException("invalid nine-patch: " + i);
        }
    }

    /* renamed from: a */
    private static void m3942a(int[] iArr, ByteBuffer byteBuffer) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = byteBuffer.getInt();
        }
    }
}
