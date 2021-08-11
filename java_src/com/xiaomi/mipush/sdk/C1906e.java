package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.channel.commonutils.string.C1870a;
import com.xiaomi.xmpush.thrift.C2069d;
import com.xiaomi.xmpush.thrift.C2071e;
import com.xiaomi.xmpush.thrift.C2075g;
import com.xiaomi.xmpush.thrift.C2077h;
import com.xiaomi.xmpush.thrift.C2079i;
import com.xiaomi.xmpush.thrift.C2083k;
import com.xiaomi.xmpush.thrift.C2087m;
import com.xiaomi.xmpush.thrift.C2089n;
import com.xiaomi.xmpush.thrift.C2093p;
import com.xiaomi.xmpush.thrift.C2097r;
import com.xiaomi.xmpush.thrift.C2101t;
import com.xiaomi.xmpush.thrift.C2103u;
import com.xiaomi.xmpush.thrift.EnumC2064a;
import java.nio.ByteBuffer;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.thrift.AbstractC2158b;
import org.apache.thrift.C2164f;

/* renamed from: com.xiaomi.mipush.sdk.e */
public class C1906e {

    /* renamed from: a */
    private static final byte[] f4870a = {100, 23, 84, 114, 72, 0, 4, 97, 73, 97, 2, 52, 84, 102, 18, 32};

    /* renamed from: a */
    protected static <T extends AbstractC2158b<T, ?>> C2077h m6981a(Context context, T t, EnumC2064a aVar) {
        return m6982a(context, t, aVar, !aVar.equals(EnumC2064a.Registration), context.getPackageName(), C1900a.m6949a(context).mo10176c());
    }

    /* renamed from: a */
    protected static <T extends AbstractC2158b<T, ?>> C2077h m6982a(Context context, T t, EnumC2064a aVar, boolean z, String str, String str2) {
        byte[] a = C2103u.m8169a(t);
        if (a == null) {
            AbstractC1855b.m6718a("invoke convertThriftObjectToBytes method, return null.");
            return null;
        }
        C2077h hVar = new C2077h();
        if (z) {
            String f = C1900a.m6949a(context).mo10179f();
            if (TextUtils.isEmpty(f)) {
                AbstractC1855b.m6718a("regSecret is empty, return null");
                return null;
            }
            try {
                a = m6987b(C1870a.m6771a(f), a);
            } catch (Exception e) {
                AbstractC1855b.m6723d("encryption error. ");
            }
        }
        C2069d dVar = new C2069d();
        dVar.f5602a = 5;
        dVar.f5603b = "fakeid";
        hVar.mo10826a(dVar);
        hVar.mo10828a(ByteBuffer.wrap(a));
        hVar.mo10824a(aVar);
        hVar.mo10835c(true);
        hVar.mo10832b(str);
        hVar.mo10829a(z);
        hVar.mo10827a(str2);
        return hVar;
    }

    /* renamed from: a */
    private static Cipher m6983a(byte[] bArr, int i) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(f4870a);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(i, secretKeySpec, ivParameterSpec);
        return instance;
    }

    /* renamed from: a */
    protected static AbstractC2158b m6984a(Context context, C2077h hVar) {
        byte[] f;
        if (hVar.mo10836c()) {
            try {
                f = m6986a(C1870a.m6771a(C1900a.m6949a(context).mo10179f()), hVar.mo10842f());
            } catch (Exception e) {
                throw new C2164f("the aes decrypt failed.", e);
            }
        } else {
            f = hVar.mo10842f();
        }
        AbstractC2158b a = m6985a(hVar.mo10823a());
        if (a != null) {
            C2103u.m8168a(a, f);
        }
        return a;
    }

    /* renamed from: a */
    private static AbstractC2158b m6985a(EnumC2064a aVar) {
        switch (aVar) {
            case Registration:
                return new C2083k();
            case UnRegistration:
                return new C2097r();
            case Subscription:
                return new C2093p();
            case UnSubscription:
                return new C2101t();
            case SendMessage:
                return new C2089n();
            case AckMessage:
                return new C2071e();
            case SetConfig:
                return new C2075g();
            case ReportFeedback:
                return new C2087m();
            case Notification:
                return new C2079i();
            case Command:
                return new C2075g();
            default:
                return null;
        }
    }

    /* renamed from: a */
    public static byte[] m6986a(byte[] bArr, byte[] bArr2) {
        return m6983a(bArr, 2).doFinal(bArr2);
    }

    /* renamed from: b */
    public static byte[] m6987b(byte[] bArr, byte[] bArr2) {
        return m6983a(bArr, 1).doFinal(bArr2);
    }
}
