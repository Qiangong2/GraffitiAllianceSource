package p000a.p001a.p002a;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import p000a.p001a.p002a.p004b.AbstractC0019h;
import p000a.p001a.p002a.p004b.AbstractC0021j;
import p000a.p001a.p002a.p004b.C0011b;
import p000a.p001a.p002a.p004b.C0014c;
import p000a.p001a.p002a.p004b.C0022k;
import p000a.p001a.p002a.p006d.C0035b;

/* renamed from: a.a.a.g */
/* compiled from: TDeserializer */
public class C0043g {

    /* renamed from: a */
    private final AbstractC0019h f132a;

    /* renamed from: b */
    private final C0035b f133b;

    public C0043g() {
        this(new C0011b.C0012a());
    }

    public C0043g(AbstractC0021j jVar) {
        this.f133b = new C0035b();
        this.f132a = jVar.mo55a(this.f133b);
    }

    /* renamed from: a */
    public void mo102a(AbstractC0033d dVar, byte[] bArr) throws C0046j {
        try {
            this.f133b.mo85a(bArr);
            dVar.mo73a(this.f132a);
        } finally {
            this.f133b.mo87e();
            this.f132a.mo56B();
        }
    }

    /* renamed from: a */
    public void mo101a(AbstractC0033d dVar, String str, String str2) throws C0046j {
        try {
            mo102a(dVar, str.getBytes(str2));
            this.f132a.mo56B();
        } catch (UnsupportedEncodingException e) {
            throw new C0046j("JVM DOES NOT SUPPORT ENCODING: " + str2);
        } catch (Throwable th) {
            this.f132a.mo56B();
            throw th;
        }
    }

    /* renamed from: a */
    public void mo103a(AbstractC0033d dVar, byte[] bArr, AbstractC0047k kVar, AbstractC0047k... kVarArr) throws C0046j {
        try {
            if (m263j(bArr, kVar, kVarArr) != null) {
                dVar.mo73a(this.f132a);
            }
            this.f133b.mo87e();
            this.f132a.mo56B();
        } catch (Exception e) {
            throw new C0046j(e);
        } catch (Throwable th) {
            this.f133b.mo87e();
            this.f132a.mo56B();
            throw th;
        }
    }

    /* renamed from: a */
    public Boolean mo99a(byte[] bArr, AbstractC0047k kVar, AbstractC0047k... kVarArr) throws C0046j {
        return (Boolean) m262a((byte) 2, bArr, kVar, kVarArr);
    }

    /* renamed from: b */
    public Byte mo104b(byte[] bArr, AbstractC0047k kVar, AbstractC0047k... kVarArr) throws C0046j {
        return (Byte) m262a((byte) 3, bArr, kVar, kVarArr);
    }

    /* renamed from: c */
    public Double mo105c(byte[] bArr, AbstractC0047k kVar, AbstractC0047k... kVarArr) throws C0046j {
        return (Double) m262a((byte) 4, bArr, kVar, kVarArr);
    }

    /* renamed from: d */
    public Short mo106d(byte[] bArr, AbstractC0047k kVar, AbstractC0047k... kVarArr) throws C0046j {
        return (Short) m262a((byte) 6, bArr, kVar, kVarArr);
    }

    /* renamed from: e */
    public Integer mo107e(byte[] bArr, AbstractC0047k kVar, AbstractC0047k... kVarArr) throws C0046j {
        return (Integer) m262a((byte) 8, bArr, kVar, kVarArr);
    }

    /* renamed from: f */
    public Long mo108f(byte[] bArr, AbstractC0047k kVar, AbstractC0047k... kVarArr) throws C0046j {
        return (Long) m262a((byte) 10, bArr, kVar, kVarArr);
    }

    /* renamed from: g */
    public String mo109g(byte[] bArr, AbstractC0047k kVar, AbstractC0047k... kVarArr) throws C0046j {
        return (String) m262a((byte) 11, bArr, kVar, kVarArr);
    }

    /* renamed from: h */
    public ByteBuffer mo110h(byte[] bArr, AbstractC0047k kVar, AbstractC0047k... kVarArr) throws C0046j {
        return (ByteBuffer) m262a((byte) 100, bArr, kVar, kVarArr);
    }

    /* renamed from: i */
    public Short mo111i(byte[] bArr, AbstractC0047k kVar, AbstractC0047k... kVarArr) throws C0046j {
        try {
            if (m263j(bArr, kVar, kVarArr) != null) {
                this.f132a.mo38j();
                Short valueOf = Short.valueOf(this.f132a.mo40l().f66c);
                this.f133b.mo87e();
                this.f132a.mo56B();
                return valueOf;
            }
            this.f133b.mo87e();
            this.f132a.mo56B();
            return null;
        } catch (Exception e) {
            throw new C0046j(e);
        } catch (Throwable th) {
            this.f133b.mo87e();
            this.f132a.mo56B();
            throw th;
        }
    }

    /* renamed from: a */
    private Object m262a(byte b, byte[] bArr, AbstractC0047k kVar, AbstractC0047k... kVarArr) throws C0046j {
        try {
            C0014c j = m263j(bArr, kVar, kVarArr);
            if (j != null) {
                switch (b) {
                    case 2:
                        if (j.f65b == 2) {
                            Boolean valueOf = Boolean.valueOf(this.f132a.mo48t());
                            this.f133b.mo87e();
                            this.f132a.mo56B();
                            return valueOf;
                        }
                        break;
                    case 3:
                        if (j.f65b == 3) {
                            Byte valueOf2 = Byte.valueOf(this.f132a.mo49u());
                            this.f133b.mo87e();
                            this.f132a.mo56B();
                            return valueOf2;
                        }
                        break;
                    case 4:
                        if (j.f65b == 4) {
                            Double valueOf3 = Double.valueOf(this.f132a.mo53y());
                            this.f133b.mo87e();
                            this.f132a.mo56B();
                            return valueOf3;
                        }
                        break;
                    case 6:
                        if (j.f65b == 6) {
                            Short valueOf4 = Short.valueOf(this.f132a.mo50v());
                            this.f133b.mo87e();
                            this.f132a.mo56B();
                            return valueOf4;
                        }
                        break;
                    case 8:
                        if (j.f65b == 8) {
                            Integer valueOf5 = Integer.valueOf(this.f132a.mo51w());
                            this.f133b.mo87e();
                            this.f132a.mo56B();
                            return valueOf5;
                        }
                        break;
                    case 10:
                        if (j.f65b == 10) {
                            Long valueOf6 = Long.valueOf(this.f132a.mo52x());
                            this.f133b.mo87e();
                            this.f132a.mo56B();
                            return valueOf6;
                        }
                        break;
                    case 11:
                        if (j.f65b == 11) {
                            String z = this.f132a.mo54z();
                            this.f133b.mo87e();
                            this.f132a.mo56B();
                            return z;
                        }
                        break;
                    case 100:
                        if (j.f65b == 11) {
                            ByteBuffer A = this.f132a.mo11A();
                            this.f133b.mo87e();
                            this.f132a.mo56B();
                            return A;
                        }
                        break;
                }
            }
            this.f133b.mo87e();
            this.f132a.mo56B();
            return null;
        } catch (Exception e) {
            throw new C0046j(e);
        } catch (Throwable th) {
            this.f133b.mo87e();
            this.f132a.mo56B();
            throw th;
        }
    }

    /* renamed from: j */
    private C0014c m263j(byte[] bArr, AbstractC0047k kVar, AbstractC0047k... kVarArr) throws C0046j {
        int i = 0;
        this.f133b.mo85a(bArr);
        AbstractC0047k[] kVarArr2 = new AbstractC0047k[(kVarArr.length + 1)];
        kVarArr2[0] = kVar;
        for (int i2 = 0; i2 < kVarArr.length; i2++) {
            kVarArr2[i2 + 1] = kVarArr[i2];
        }
        this.f132a.mo38j();
        C0014c cVar = null;
        while (i < kVarArr2.length) {
            cVar = this.f132a.mo40l();
            if (cVar.f65b == 0 || cVar.f66c > kVarArr2[i].mo113a()) {
                return null;
            }
            if (cVar.f66c != kVarArr2[i].mo113a()) {
                C0022k.m187a(this.f132a, cVar.f65b);
                this.f132a.mo41m();
            } else {
                i++;
                if (i < kVarArr2.length) {
                    this.f132a.mo38j();
                }
            }
        }
        return cVar;
    }

    /* renamed from: a */
    public void mo100a(AbstractC0033d dVar, String str) throws C0046j {
        mo102a(dVar, str.getBytes());
    }
}
