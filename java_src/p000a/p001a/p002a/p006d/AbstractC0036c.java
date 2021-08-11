package p000a.p001a.p002a.p006d;

/* renamed from: a.a.a.d.c */
/* compiled from: TTransport */
public abstract class AbstractC0036c {
    /* renamed from: a */
    public abstract int mo78a(byte[] bArr, int i, int i2) throws C0037d;

    /* renamed from: a */
    public abstract boolean mo79a();

    /* renamed from: b */
    public abstract void mo80b() throws C0037d;

    /* renamed from: b */
    public abstract void mo81b(byte[] bArr, int i, int i2) throws C0037d;

    /* renamed from: c */
    public abstract void mo82c();

    /* renamed from: i */
    public boolean mo93i() {
        return mo79a();
    }

    /* renamed from: d */
    public int mo92d(byte[] bArr, int i, int i2) throws C0037d {
        int i3 = 0;
        while (i3 < i2) {
            int a = mo78a(bArr, i + i3, i2 - i3);
            if (a <= 0) {
                throw new C0037d("Cannot read. Remote side has closed. Tried to read " + i2 + " bytes, but only got " + i3 + " bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)");
            }
            i3 += a;
        }
        return i3;
    }

    /* renamed from: b */
    public void mo91b(byte[] bArr) throws C0037d {
        mo81b(bArr, 0, bArr.length);
    }

    /* renamed from: d */
    public void mo83d() throws C0037d {
    }

    /* renamed from: f */
    public byte[] mo88f() {
        return null;
    }

    /* renamed from: g */
    public int mo89g() {
        return 0;
    }

    /* renamed from: h */
    public int mo90h() {
        return -1;
    }

    /* renamed from: a */
    public void mo84a(int i) {
    }
}
