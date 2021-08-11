package com.igexin.p010a.p011a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.igexin.a.a.i */
public class C0411i extends AbstractC0407e {

    /* renamed from: j */
    private final C0412j f1000j;

    public C0411i(boolean z, C0412j jVar) {
        this.f985a = z;
        this.f1000j = jVar;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.f986b = jVar.mo4073d(allocate, 16);
        this.f987c = jVar.mo4069b(allocate, 32);
        this.f988d = jVar.mo4069b(allocate, 40);
        this.f989e = jVar.mo4073d(allocate, 54);
        this.f990f = jVar.mo4073d(allocate, 56);
        this.f991g = jVar.mo4073d(allocate, 58);
        this.f992h = jVar.mo4073d(allocate, 60);
        this.f993i = jVar.mo4073d(allocate, 62);
    }

    @Override // com.igexin.p010a.p011a.AbstractC0407e
    /* renamed from: a */
    public AbstractC0406d mo4063a(long j, int i) {
        return new C0404b(this.f1000j, this, j, i);
    }

    @Override // com.igexin.p010a.p011a.AbstractC0407e
    /* renamed from: a */
    public AbstractC0408f mo4064a(long j) {
        return new C0414l(this.f1000j, this, j);
    }

    @Override // com.igexin.p010a.p011a.AbstractC0407e
    /* renamed from: a */
    public AbstractC0409g mo4065a(int i) {
        return new C0416n(this.f1000j, this, i);
    }
}
