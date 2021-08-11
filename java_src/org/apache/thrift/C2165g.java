package org.apache.thrift;

import java.io.ByteArrayOutputStream;
import org.apache.thrift.protocol.AbstractC2180f;
import org.apache.thrift.protocol.AbstractC2182h;
import org.apache.thrift.protocol.C2173a;
import org.apache.thrift.transport.C2188a;

/* renamed from: org.apache.thrift.g */
public class C2165g {

    /* renamed from: a */
    private final ByteArrayOutputStream f6166a;

    /* renamed from: b */
    private final C2188a f6167b;

    /* renamed from: c */
    private AbstractC2180f f6168c;

    public C2165g() {
        this(new C2173a.C2174a());
    }

    public C2165g(AbstractC2182h hVar) {
        this.f6166a = new ByteArrayOutputStream();
        this.f6167b = new C2188a(this.f6166a);
        this.f6168c = hVar.mo12163a(this.f6167b);
    }

    /* renamed from: a */
    public byte[] mo12123a(AbstractC2158b bVar) {
        this.f6166a.reset();
        bVar.mo9950b(this.f6168c);
        return this.f6166a.toByteArray();
    }
}
