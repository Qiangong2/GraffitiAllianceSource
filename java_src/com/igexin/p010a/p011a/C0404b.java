package com.igexin.p010a.p011a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.igexin.a.a.b */
public class C0404b extends AbstractC0406d {
    public C0404b(C0412j jVar, AbstractC0407e eVar, long j, int i) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(eVar.f985a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = ((long) (i * 16)) + j;
        this.f983a = jVar.mo4069b(allocate, j2);
        this.f984b = jVar.mo4069b(allocate, j2 + 8);
    }
}
