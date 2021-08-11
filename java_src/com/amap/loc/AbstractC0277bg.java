package com.amap.loc;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.amap.loc.bg */
/* compiled from: BinaryRequest */
public abstract class AbstractC0277bg extends AbstractC0283bk {

    /* renamed from: a */
    protected Context f448a;

    /* renamed from: b */
    protected C0360q f449b;

    public AbstractC0277bg(Context context, C0360q qVar) {
        if (context != null) {
            this.f448a = context.getApplicationContext();
        }
        this.f449b = qVar;
    }

    /* renamed from: k */
    private byte[] m724k() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(C0363r.m1358a("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                C0365t.m1372a(th, "BinaryRequest", "getBinaryHead");
                return byteArray;
            }
        } catch (Throwable th2) {
            C0365t.m1372a(th2, "BinaryRequest", "getBinaryHead");
        }
        return null;
    }

    /* renamed from: l */
    private byte[] m725l() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] a_ = mo3752a_();
            if (a_ == null || a_.length == 0) {
                byteArrayOutputStream.write(new byte[]{0});
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                    return byteArray;
                } catch (Throwable th) {
                    C0365t.m1372a(th, "BinaryRequest", "getRequestRawData");
                    return byteArray;
                }
            } else {
                byteArrayOutputStream.write(new byte[]{1});
                byteArrayOutputStream.write(mo3751a(a_));
                byteArrayOutputStream.write(a_);
                byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                    return byteArray2;
                } catch (Throwable th2) {
                    C0365t.m1372a(th2, "BinaryRequest", "getRequestRawData");
                    return byteArray2;
                }
            }
        } catch (Throwable th3) {
            C0365t.m1372a(th3, "BinaryRequest", "getRequestRawData");
        }
        return new byte[]{0};
    }

    /* renamed from: m */
    private byte[] m726m() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] b_ = mo3753b_();
            if (b_ == null || b_.length == 0) {
                byteArrayOutputStream.write(new byte[]{0});
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                    return byteArray;
                } catch (Throwable th) {
                    C0365t.m1372a(th, "BinaryRequest", "getRequestEncryptData");
                    return byteArray;
                }
            } else {
                byteArrayOutputStream.write(new byte[]{1});
                byte[] a = C0350k.m1256a(this.f448a, b_);
                byteArrayOutputStream.write(mo3751a(a));
                byteArrayOutputStream.write(a);
                byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                    return byteArray2;
                } catch (Throwable th2) {
                    C0365t.m1372a(th2, "BinaryRequest", "getRequestEncryptData");
                    return byteArray2;
                }
            }
        } catch (Throwable th3) {
            C0365t.m1372a(th3, "BinaryRequest", "getRequestEncryptData");
        }
        return new byte[]{0};
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public byte[] mo3751a(byte[] bArr) {
        int length = bArr.length;
        return new byte[]{(byte) (length / 256), (byte) (length % 256)};
    }

    /* renamed from: a_ */
    public abstract byte[] mo3752a_();

    /* renamed from: b_ */
    public abstract byte[] mo3753b_();

    @Override // com.amap.loc.AbstractC0283bk
    /* renamed from: c */
    public Map<String, String> mo3698c() {
        String f = C0342i.m1235f(this.f448a);
        String a = C0350k.m1250a();
        String a2 = C0350k.m1251a(this.f448a, a, "key=" + f);
        HashMap hashMap = new HashMap();
        hashMap.put("ts", a);
        hashMap.put("key", f);
        hashMap.put("scode", a2);
        return hashMap;
    }

    @Override // com.amap.loc.AbstractC0283bk
    /* renamed from: d */
    public final byte[] mo3754d() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(m724k());
            byteArrayOutputStream.write(mo3757g());
            byteArrayOutputStream.write(m725l());
            byteArrayOutputStream.write(m726m());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                C0365t.m1372a(th, "BinaryRequest", "getEntityBytes");
                return byteArray;
            }
        } catch (Throwable th2) {
            C0365t.m1372a(th2, "BinaryRequest", "getEntityBytes");
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public String mo3755e() {
        return "2.1";
    }

    /* renamed from: f */
    public boolean mo3756f() {
        return true;
    }

    /* renamed from: g */
    public byte[] mo3757g() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            if (mo3756f()) {
                byte[] a = C0350k.m1255a(this.f448a, false);
                byteArrayOutputStream.write(mo3751a(a));
                byteArrayOutputStream.write(a);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            byte[] a2 = C0363r.m1358a(mo3755e());
            if (a2 == null || a2.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(mo3751a(a2));
                byteArrayOutputStream.write(a2);
            }
            byte[] a3 = C0363r.m1358a(mo3758h());
            if (a3 == null || a3.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(mo3751a(a3));
                byteArrayOutputStream.write(a3);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                C0365t.m1372a(th, "BinaryRequest", "getRequestEncryptData");
                return byteArray;
            }
        } catch (Throwable th2) {
            C0365t.m1372a(th2, "BinaryRequest", "getRequestEncryptData");
        }
        return new byte[]{0};
    }

    /* renamed from: h */
    public String mo3758h() {
        return String.format("platform=Android&sdkversion=%s&product=%s", this.f449b.mo3941b(), this.f449b.mo3939a());
    }
}
