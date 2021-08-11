package org.apache.thrift;

import org.apache.thrift.protocol.AbstractC2180f;
import org.apache.thrift.protocol.AbstractC2182h;
import org.apache.thrift.protocol.C2173a;
import org.apache.thrift.transport.C2190c;

/* renamed from: org.apache.thrift.e */
public class C2163e {

    /* renamed from: a */
    private final AbstractC2180f f6164a;

    /* renamed from: b */
    private final C2190c f6165b;

    public C2163e() {
        this(new C2173a.C2174a());
    }

    public C2163e(AbstractC2182h hVar) {
        this.f6165b = new C2190c();
        this.f6164a = hVar.mo12163a(this.f6165b);
    }

    /* renamed from: a */
    public void mo12122a(AbstractC2158b bVar, byte[] bArr) {
        try {
            this.f6165b.mo12172a(bArr);
            bVar.mo9945a(this.f6164a);
        } finally {
            this.f6164a.mo12166y();
        }
    }
}
