package com.igexin.p010a.p011a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.igexin.a.a.a */
public class C0403a extends AbstractC0406d {
    public C0403a(C0412j jVar, AbstractC0407e eVar, long j, int i) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(eVar.f985a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = ((long) (i * 8)) + j;
        this.f983a = jVar.mo4071c(allocate, j2);
        this.f984b = jVar.mo4071c(allocate, j2 + 4);
    }
}
