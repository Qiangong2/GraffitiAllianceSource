package p000a.p001a.p002a.p006d;

/* renamed from: a.a.a.d.b */
/* compiled from: TMemoryInputTransport */
public final class C0035b extends AbstractC0036c {

    /* renamed from: a */
    private byte[] f121a;

    /* renamed from: b */
    private int f122b;

    /* renamed from: c */
    private int f123c;

    public C0035b() {
    }

    public C0035b(byte[] bArr) {
        mo85a(bArr);
    }

    public C0035b(byte[] bArr, int i, int i2) {
        mo86c(bArr, i, i2);
    }

    /* renamed from: a */
    public void mo85a(byte[] bArr) {
        mo86c(bArr, 0, bArr.length);
    }

    /* renamed from: c */
    public void mo86c(byte[] bArr, int i, int i2) {
        this.f121a = bArr;
        this.f122b = i;
        this.f123c = i + i2;
    }

    /* renamed from: e */
    public void mo87e() {
        this.f121a = null;
    }

    @Override // p000a.p001a.p002a.p006d.AbstractC0036c
    /* renamed from: c */
    public void mo82c() {
    }

    @Override // p000a.p001a.p002a.p006d.AbstractC0036c
    /* renamed from: a */
    public boolean mo79a() {
        return true;
    }

    @Override // p000a.p001a.p002a.p006d.AbstractC0036c
    /* renamed from: b */
    public void mo80b() throws C0037d {
    }

    @Override // p000a.p001a.p002a.p006d.AbstractC0036c
    /* renamed from: a */
    public int mo78a(byte[] bArr, int i, int i2) throws C0037d {
        int h = mo90h();
        if (i2 > h) {
            i2 = h;
        }
        if (i2 > 0) {
            System.arraycopy(this.f121a, this.f122b, bArr, i, i2);
            mo84a(i2);
        }
        return i2;
    }

    @Override // p000a.p001a.p002a.p006d.AbstractC0036c
    /* renamed from: b */
    public void mo81b(byte[] bArr, int i, int i2) throws C0037d {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // p000a.p001a.p002a.p006d.AbstractC0036c
    /* renamed from: f */
    public byte[] mo88f() {
        return this.f121a;
    }

    @Override // p000a.p001a.p002a.p006d.AbstractC0036c
    /* renamed from: g */
    public int mo89g() {
        return this.f122b;
    }

    @Override // p000a.p001a.p002a.p006d.AbstractC0036c
    /* renamed from: h */
    public int mo90h() {
        return this.f123c - this.f122b;
    }

    @Override // p000a.p001a.p002a.p006d.AbstractC0036c
    /* renamed from: a */
    public void mo84a(int i) {
        this.f122b += i;
    }
}
