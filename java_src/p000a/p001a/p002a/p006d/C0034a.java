package p000a.p001a.p002a.p006d;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: a.a.a.d.a */
/* compiled from: TIOStreamTransport */
public class C0034a extends AbstractC0036c {

    /* renamed from: a */
    protected InputStream f119a = null;

    /* renamed from: b */
    protected OutputStream f120b = null;

    protected C0034a() {
    }

    public C0034a(InputStream inputStream) {
        this.f119a = inputStream;
    }

    public C0034a(OutputStream outputStream) {
        this.f120b = outputStream;
    }

    public C0034a(InputStream inputStream, OutputStream outputStream) {
        this.f119a = inputStream;
        this.f120b = outputStream;
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
    /* renamed from: c */
    public void mo82c() {
        if (this.f119a != null) {
            try {
                this.f119a.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.f119a = null;
        }
        if (this.f120b != null) {
            try {
                this.f120b.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.f120b = null;
        }
    }

    @Override // p000a.p001a.p002a.p006d.AbstractC0036c
    /* renamed from: a */
    public int mo78a(byte[] bArr, int i, int i2) throws C0037d {
        if (this.f119a == null) {
            throw new C0037d(1, "Cannot read from null inputStream");
        }
        try {
            int read = this.f119a.read(bArr, i, i2);
            if (read >= 0) {
                return read;
            }
            throw new C0037d(4);
        } catch (IOException e) {
            throw new C0037d(0, e);
        }
    }

    @Override // p000a.p001a.p002a.p006d.AbstractC0036c
    /* renamed from: b */
    public void mo81b(byte[] bArr, int i, int i2) throws C0037d {
        if (this.f120b == null) {
            throw new C0037d(1, "Cannot write to null outputStream");
        }
        try {
            this.f120b.write(bArr, i, i2);
        } catch (IOException e) {
            throw new C0037d(0, e);
        }
    }

    @Override // p000a.p001a.p002a.p006d.AbstractC0036c
    /* renamed from: d */
    public void mo83d() throws C0037d {
        if (this.f120b == null) {
            throw new C0037d(1, "Cannot flush null outputStream");
        }
        try {
            this.f120b.flush();
        } catch (IOException e) {
            throw new C0037d(0, e);
        }
    }
}
