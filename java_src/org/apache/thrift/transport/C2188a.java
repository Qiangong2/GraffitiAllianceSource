package org.apache.thrift.transport;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: org.apache.thrift.transport.a */
public class C2188a extends AbstractC2191d {

    /* renamed from: a */
    protected InputStream f6228a = null;

    /* renamed from: b */
    protected OutputStream f6229b = null;

    protected C2188a() {
    }

    public C2188a(OutputStream outputStream) {
        this.f6229b = outputStream;
    }

    @Override // org.apache.thrift.transport.AbstractC2191d
    /* renamed from: a */
    public int mo12168a(byte[] bArr, int i, int i2) {
        if (this.f6228a == null) {
            throw new C2192e(1, "Cannot read from null inputStream");
        }
        try {
            int read = this.f6228a.read(bArr, i, i2);
            if (read >= 0) {
                return read;
            }
            throw new C2192e(4);
        } catch (IOException e) {
            throw new C2192e(0, e);
        }
    }

    @Override // org.apache.thrift.transport.AbstractC2191d
    /* renamed from: b */
    public void mo12169b(byte[] bArr, int i, int i2) {
        if (this.f6229b == null) {
            throw new C2192e(1, "Cannot write to null outputStream");
        }
        try {
            this.f6229b.write(bArr, i, i2);
        } catch (IOException e) {
            throw new C2192e(0, e);
        }
    }
}
