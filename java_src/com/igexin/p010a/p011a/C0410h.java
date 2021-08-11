package com.igexin.p010a.p011a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.igexin.a.a.h */
public class C0410h extends AbstractC0407e {

    /* renamed from: j */
    private final C0412j f999j;

    public C0410h(boolean z, C0412j jVar) {
        this.f985a = z;
        this.f999j = jVar;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f986b = jVar.mo4073d(allocate, 16);
        this.f987c = jVar.mo4071c(allocate, 28);
        this.f988d = jVar.mo4071c(allocate, 32);
        this.f989e = jVar.mo4073d(allocate, 42);
        this.f990f = jVar.mo4073d(allocate, 44);
        this.f991g = jVar.mo4073d(allocate, 46);
        this.f992h = jVar.mo4073d(allocate, 48);
        this.f993i = jVar.mo4073d(allocate, 50);
    }

    @Override // com.igexin.p010a.p011a.AbstractC0407e
    /* renamed from: a */
    public AbstractC0406d mo4063a(long j, int i) {
        return new C0403a(this.f999j, this, j, i);
    }

    @Override // com.igexin.p010a.p011a.AbstractC0407e
    /* renamed from: a */
    public AbstractC0408f mo4064a(long j) {
        return new C0413k(this.f999j, this, j);
    }

    @Override // com.igexin.p010a.p011a.AbstractC0407e
    /* renamed from: a */
    public AbstractC0409g mo4065a(int i) {
        return new C0415m(this.f999j, this, i);
    }
}
