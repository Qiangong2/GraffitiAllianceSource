package com.umeng.analytics.p092c;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.p091b.C1447g;
import com.umeng.analytics.p093d.C1488m;
import com.umeng.analytics.p096g.C1542a;
import com.umeng.p085a.C1341c;
import com.umeng.p085a.C1342d;
import com.umeng.p085a.C1343e;
import com.umeng.p085a.C1344f;
import java.io.File;
import org.json.JSONObject;
import p000a.p001a.p002a.C0049m;

/* renamed from: com.umeng.analytics.c.c */
/* compiled from: Envelope */
public class C1451c {

    /* renamed from: a */
    private final byte[] f3540a = {0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: b */
    private final int f3541b = 1;

    /* renamed from: c */
    private final int f3542c = 0;

    /* renamed from: d */
    private String f3543d = "1.0";

    /* renamed from: e */
    private String f3544e = null;

    /* renamed from: f */
    private byte[] f3545f = null;

    /* renamed from: g */
    private byte[] f3546g = null;

    /* renamed from: h */
    private byte[] f3547h = null;

    /* renamed from: i */
    private int f3548i = 0;

    /* renamed from: j */
    private int f3549j = 0;

    /* renamed from: k */
    private int f3550k = 0;

    /* renamed from: l */
    private byte[] f3551l = null;

    /* renamed from: m */
    private byte[] f3552m = null;

    /* renamed from: n */
    private boolean f3553n = false;

    private C1451c(byte[] bArr, String str, byte[] bArr2) throws Exception {
        if (bArr == null || bArr.length == 0) {
            throw new Exception("entity is null or empty");
        }
        this.f3544e = str;
        this.f3550k = bArr.length;
        this.f3551l = C1342d.m4924a(bArr);
        this.f3549j = (int) (System.currentTimeMillis() / 1000);
        this.f3552m = bArr2;
    }

    /* renamed from: a */
    public static String m5348a(Context context) {
        SharedPreferences a = C1488m.m5522a(context);
        if (a == null) {
            return null;
        }
        return a.getString("signature", null);
    }

    /* renamed from: a */
    public void mo8557a(String str) {
        this.f3545f = C1341c.m4915a(str);
    }

    /* renamed from: a */
    public String mo8555a() {
        return C1341c.m4913a(this.f3545f);
    }

    /* renamed from: a */
    public void mo8556a(int i) {
        this.f3548i = i;
    }

    /* renamed from: a */
    public void mo8558a(boolean z) {
        this.f3553n = z;
    }

    /* renamed from: a */
    public static C1451c m5347a(Context context, String str, byte[] bArr) {
        try {
            String q = C1343e.m4961q(context);
            String c = C1343e.m4944c(context);
            SharedPreferences a = C1488m.m5522a(context);
            String string = a.getString("signature", null);
            int i = a.getInt("serial", 1);
            C1451c cVar = new C1451c(bArr, str, (c + q).getBytes());
            cVar.mo8557a(string);
            cVar.mo8556a(i);
            cVar.mo8559b();
            a.edit().putInt("serial", i + 1).putString("signature", cVar.mo8555a()).commit();
            cVar.mo8560b(context);
            return cVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public static C1451c m5350b(Context context, String str, byte[] bArr) {
        try {
            String q = C1343e.m4961q(context);
            String c = C1343e.m4944c(context);
            SharedPreferences a = C1488m.m5522a(context);
            String string = a.getString("signature", null);
            int i = a.getInt("serial", 1);
            C1451c cVar = new C1451c(bArr, str, (c + q).getBytes());
            cVar.mo8558a(true);
            cVar.mo8557a(string);
            cVar.mo8556a(i);
            cVar.mo8559b();
            a.edit().putInt("serial", i + 1).putString("signature", cVar.mo8555a()).commit();
            cVar.mo8560b(context);
            return cVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public void mo8559b() {
        if (this.f3545f == null) {
            this.f3545f = m5351d();
        }
        if (this.f3553n) {
            byte[] bArr = new byte[16];
            try {
                System.arraycopy(this.f3545f, 1, bArr, 0, 16);
                this.f3551l = C1341c.m4916a(this.f3551l, bArr);
            } catch (Exception e) {
            }
        }
        this.f3546g = m5349a(this.f3545f, this.f3549j);
        this.f3547h = m5352e();
    }

    /* renamed from: a */
    private byte[] m5349a(byte[] bArr, int i) {
        byte[] b = C1341c.m4918b(this.f3552m);
        byte[] b2 = C1341c.m4918b(this.f3551l);
        int length = b.length;
        byte[] bArr2 = new byte[(length * 2)];
        for (int i2 = 0; i2 < length; i2++) {
            bArr2[i2 * 2] = b2[i2];
            bArr2[(i2 * 2) + 1] = b[i2];
        }
        for (int i3 = 0; i3 < 2; i3++) {
            bArr2[i3] = bArr[i3];
            bArr2[(bArr2.length - i3) - 1] = bArr[(bArr.length - i3) - 1];
        }
        byte[] bArr3 = {(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) (i >>> 24)};
        for (int i4 = 0; i4 < bArr2.length; i4++) {
            bArr2[i4] = (byte) (bArr2[i4] ^ bArr3[i4 % 4]);
        }
        return bArr2;
    }

    /* renamed from: d */
    private byte[] m5351d() {
        return m5349a(this.f3540a, (int) (System.currentTimeMillis() / 1000));
    }

    /* renamed from: e */
    private byte[] m5352e() {
        return C1341c.m4918b((C1341c.m4913a(this.f3545f) + this.f3548i + this.f3549j + this.f3550k + C1341c.m4913a(this.f3546g)).getBytes());
    }

    /* renamed from: c */
    public byte[] mo8561c() {
        C1542a aVar = new C1542a();
        aVar.mo8860a(this.f3543d);
        aVar.mo8864b(this.f3544e);
        aVar.mo8867c(C1341c.m4913a(this.f3545f));
        aVar.mo8859a(this.f3548i);
        aVar.mo8866c(this.f3549j);
        aVar.mo8870d(this.f3550k);
        aVar.mo8862a(this.f3551l);
        aVar.mo8874e(this.f3553n ? 1 : 0);
        aVar.mo8871d(C1341c.m4913a(this.f3546g));
        aVar.mo8875e(C1341c.m4913a(this.f3547h));
        try {
            return new C0049m().mo116a(aVar);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public void mo8560b(Context context) {
        String str = this.f3544e;
        String g = C1457h.m5380a(context).mo8580b().mo8600g(null);
        String a = C1341c.m4913a(this.f3545f);
        byte[] bArr = new byte[16];
        System.arraycopy(this.f3545f, 2, bArr, 0, 16);
        String a2 = C1341c.m4913a(C1341c.m4918b(bArr));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(C1447g.f3463a, str);
            if (g != null) {
                jSONObject.put("umid", g);
            }
            jSONObject.put("signature", a);
            jSONObject.put("checksum", a2);
            File file = new File(context.getFilesDir(), ".umeng");
            if (!file.exists()) {
                file.mkdir();
            }
            C1344f.m4975a(new File(file, "exchangeIdentity.json"), jSONObject.toString());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(C1447g.f3463a, str);
            jSONObject2.put(C1447g.f3507b, AnalyticsConfig.getChannel(context));
            if (g != null) {
                jSONObject2.put("umid", C1344f.m4979b(g));
            }
            C1344f.m4975a(new File(context.getFilesDir(), "exid.dat"), jSONObject2.toString());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public String toString() {
        int i = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("version : %s\n", this.f3543d));
        sb.append(String.format("address : %s\n", this.f3544e));
        sb.append(String.format("signature : %s\n", C1341c.m4913a(this.f3545f)));
        sb.append(String.format("serial : %s\n", Integer.valueOf(this.f3548i)));
        sb.append(String.format("timestamp : %d\n", Integer.valueOf(this.f3549j)));
        sb.append(String.format("length : %d\n", Integer.valueOf(this.f3550k)));
        sb.append(String.format("guid : %s\n", C1341c.m4913a(this.f3546g)));
        sb.append(String.format("checksum : %s ", C1341c.m4913a(this.f3547h)));
        Object[] objArr = new Object[1];
        if (!this.f3553n) {
            i = 0;
        }
        objArr[0] = Integer.valueOf(i);
        sb.append(String.format("codex : %d", objArr));
        return sb.toString();
    }
}
