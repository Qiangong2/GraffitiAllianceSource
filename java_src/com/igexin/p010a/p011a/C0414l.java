package com.igexin.p010a.p011a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.igexin.a.a.l */
public class C0414l extends AbstractC0408f {
    public C0414l(C0412j jVar, AbstractC0407e eVar, long j) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(eVar.f985a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = eVar.f987c + (((long) eVar.f989e) * j);
        this.f994a = jVar.mo4071c(allocate, j2);
        this.f995b = jVar.mo4069b(allocate, 8 + j2);
        this.f996c = jVar.mo4069b(allocate, 16 + j2);
        this.f997d = jVar.mo4069b(allocate, j2 + 40);
    }
}
