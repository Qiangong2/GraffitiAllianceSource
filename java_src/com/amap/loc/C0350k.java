package com.amap.loc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

/* renamed from: com.amap.loc.k */
/* compiled from: ClientInfo */
public class C0350k {

    /* access modifiers changed from: private */
    /* renamed from: com.amap.loc.k$a */
    /* compiled from: ClientInfo */
    public static class C0352a {

        /* renamed from: a */
        String f861a;

        /* renamed from: b */
        String f862b;

        /* renamed from: c */
        String f863c;

        /* renamed from: d */
        String f864d;

        /* renamed from: e */
        String f865e;

        /* renamed from: f */
        String f866f;

        /* renamed from: g */
        String f867g;

        /* renamed from: h */
        String f868h;

        /* renamed from: i */
        String f869i;

        /* renamed from: j */
        String f870j;

        /* renamed from: k */
        String f871k;

        /* renamed from: l */
        String f872l;

        /* renamed from: m */
        String f873m;

        /* renamed from: n */
        String f874n;

        /* renamed from: o */
        String f875o;

        /* renamed from: p */
        String f876p;

        /* renamed from: q */
        String f877q;

        /* renamed from: r */
        String f878r;

        /* renamed from: s */
        String f879s;

        /* renamed from: t */
        String f880t;

        private C0352a() {
        }
    }

    /* renamed from: a */
    public static String m1250a() {
        Throwable th;
        String str;
        try {
            String valueOf = String.valueOf(System.currentTimeMillis());
            try {
                int length = valueOf.length();
                return valueOf.substring(0, length - 2) + "1" + valueOf.substring(length - 1);
            } catch (Throwable th2) {
                str = valueOf;
                th = th2;
            }
        } catch (Throwable th3) {
            str = null;
            th = th3;
            C0365t.m1372a(th, "CInfo", "getTS");
            return str;
        }
    }

    /* renamed from: a */
    public static String m1251a(Context context, String str, String str2) {
        try {
            return C0356n.m1305b(C0342i.m1234e(context) + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            C0365t.m1372a(th, "CInfo", "Scode");
            return null;
        }
    }

    /* renamed from: a */
    public static void m1252a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (!TextUtils.isEmpty(str)) {
            C0363r.m1354a(byteArrayOutputStream, str.getBytes().length > 255 ? -1 : (byte) str.getBytes().length, C0363r.m1358a(str));
        } else {
            C0363r.m1354a(byteArrayOutputStream, (byte) 0, new byte[0]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0084 A[SYNTHETIC, Splitter:B:17:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0092 A[SYNTHETIC, Splitter:B:24:0x0092] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] m1253a(android.content.Context r5, com.amap.loc.C0350k.C0352a r6) {
        /*
        // Method dump skipped, instructions count: 159
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0350k.m1253a(android.content.Context, com.amap.loc.k$a):byte[]");
    }

    /* renamed from: a */
    private static byte[] m1254a(Context context, ByteArrayOutputStream byteArrayOutputStream) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return m1259c(context, C0363r.m1361b(byteArrayOutputStream.toByteArray()));
    }

    /* renamed from: a */
    public static byte[] m1255a(Context context, boolean z) {
        try {
            return m1253a(context, m1257b(context, z));
        } catch (Throwable th) {
            C0365t.m1372a(th, "CInfo", "getGZipXInfo");
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m1256a(Context context, byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        if (instance == null) {
            return null;
        }
        instance.init(256);
        byte[] encoded = instance.generateKey().getEncoded();
        PublicKey a = C0363r.m1352a(context);
        if (a == null) {
            return null;
        }
        byte[] a2 = C0355m.m1296a(encoded, a);
        byte[] a3 = C0355m.m1297a(encoded, bArr);
        byte[] bArr2 = new byte[(a2.length + a3.length)];
        System.arraycopy(a2, 0, bArr2, 0, a2.length);
        System.arraycopy(a3, 0, bArr2, a2.length, a3.length);
        return bArr2;
    }

    /* renamed from: b */
    private static C0352a m1257b(Context context, boolean z) {
        C0352a aVar = new C0352a();
        aVar.f861a = C0353l.m1284q(context);
        aVar.f862b = C0353l.m1276i(context);
        String f = C0353l.m1273f(context);
        if (f == null) {
            f = "";
        }
        aVar.f863c = f;
        aVar.f864d = C0342i.m1232c(context);
        aVar.f865e = Build.MODEL;
        aVar.f866f = Build.MANUFACTURER;
        aVar.f867g = Build.DEVICE;
        aVar.f868h = C0342i.m1230b(context);
        aVar.f869i = C0342i.m1233d(context);
        aVar.f870j = String.valueOf(Build.VERSION.SDK_INT);
        aVar.f871k = C0353l.m1285r(context);
        aVar.f872l = C0353l.m1283p(context);
        aVar.f873m = C0353l.m1280m(context) + "";
        aVar.f874n = C0353l.m1279l(context) + "";
        aVar.f875o = C0353l.m1286s(context);
        aVar.f876p = C0353l.m1278k(context);
        if (z) {
            aVar.f877q = "";
        } else {
            aVar.f877q = C0353l.m1275h(context);
        }
        if (z) {
            aVar.f878r = "";
        } else {
            aVar.f878r = C0353l.m1274g(context);
        }
        if (z) {
            aVar.f879s = "";
            aVar.f880t = "";
        } else {
            String[] j = C0353l.m1277j(context);
            aVar.f879s = j[0];
            aVar.f880t = j[1];
        }
        return aVar;
    }

    /* renamed from: b */
    public static String m1258b(Context context, byte[] bArr) {
        try {
            return m1260d(context, bArr);
        } catch (Throwable th) {
            C0365t.m1372a(th, "CInfo", "AESData");
            return "";
        }
    }

    /* renamed from: c */
    public static byte[] m1259c(Context context, byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        PublicKey a = C0363r.m1352a(context);
        if (bArr.length <= 117) {
            return C0355m.m1296a(bArr, a);
        }
        byte[] bArr2 = new byte[117];
        System.arraycopy(bArr, 0, bArr2, 0, 117);
        byte[] a2 = C0355m.m1296a(bArr2, a);
        byte[] bArr3 = new byte[((bArr.length + 128) - 117)];
        System.arraycopy(a2, 0, bArr3, 0, 128);
        System.arraycopy(bArr, 117, bArr3, 128, bArr.length - 117);
        return bArr3;
    }

    /* renamed from: d */
    static String m1260d(Context context, byte[] bArr) throws InvalidKeyException, IOException, InvalidKeySpecException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, CertificateException {
        byte[] b = C0363r.m1361b(m1256a(context, bArr));
        return b != null ? C0355m.m1295a(b) : "";
    }

    /* renamed from: e */
    public static String m1261e(Context context, byte[] bArr) {
        try {
            return m1260d(context, bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
