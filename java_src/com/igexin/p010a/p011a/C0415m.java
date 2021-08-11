package com.igexin.p010a.p011a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.igexin.a.a.m */
public class C0415m extends AbstractC0409g {
    public C0415m(C0412j jVar, AbstractC0407e eVar, int i) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(eVar.f985a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f998a = jVar.mo4071c(allocate, eVar.f988d + ((long) (eVar.f991g * i)) + 28);
    }
}
