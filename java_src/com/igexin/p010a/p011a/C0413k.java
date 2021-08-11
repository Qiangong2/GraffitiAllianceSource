package com.igexin.p010a.p011a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.igexin.a.a.k */
public class C0413k extends AbstractC0408f {
    public C0413k(C0412j jVar, AbstractC0407e eVar, long j) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(eVar.f985a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = eVar.f987c + (((long) eVar.f989e) * j);
        this.f994a = jVar.mo4071c(allocate, j2);
        this.f995b = jVar.mo4071c(allocate, 4 + j2);
        this.f996c = jVar.mo4071c(allocate, 8 + j2);
        this.f997d = jVar.mo4071c(allocate, j2 + 20);
    }
}
