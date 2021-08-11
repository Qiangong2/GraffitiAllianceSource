package com.amap.loc;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import com.amap.loc.C0264bb;
import com.amap.loc.C0360q;
import com.tencent.qcloud.core.util.IOUtils;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.loc.aa */
/* compiled from: LogProcessor */
public abstract class AbstractC0225aa {

    /* renamed from: a */
    private C0360q f276a;

    /* renamed from: b */
    private int f277b;

    /* renamed from: c */
    private AbstractC0271bc f278c;

    /* renamed from: d */
    private C0264bb f279d;

    /* access modifiers changed from: package-private */
    /* renamed from: com.amap.loc.aa$a */
    /* compiled from: LogProcessor */
    public class C0226a implements AbstractC0271bc {

        /* renamed from: b */
        private C0237ak f281b;

        C0226a(C0237ak akVar) {
            this.f281b = akVar;
        }

        @Override // com.amap.loc.AbstractC0271bc
        /* renamed from: a */
        public void mo3638a(String str) {
            try {
                this.f281b.mo3664b(str, C0366u.m1377a(AbstractC0225aa.this.mo3634b()));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    protected AbstractC0225aa(int i) {
        this.f277b = i;
    }

    /* renamed from: a */
    public static String m423a(Context context, C0360q qVar) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"sim\":\"").append(C0353l.m1272e(context)).append("\",\"sdkversion\":\"").append(qVar.mo3941b()).append("\",\"product\":\"").append(qVar.mo3939a()).append("\",\"ed\":\"").append(qVar.mo3942c()).append("\",\"nt\":\"").append(C0353l.m1270c(context)).append("\",\"np\":\"").append(C0353l.m1262a(context)).append("\",\"mnc\":\"").append(C0353l.m1268b(context)).append("\",\"ant\":\"").append(C0353l.m1271d(context)).append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    /* renamed from: a */
    private String m424a(Context context, String str) {
        try {
            return C0350k.m1261e(context, C0363r.m1358a(str));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private String m425a(String str, String str2, String str3, int i, String str4, String str5) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str2).append(MiPushClient.ACCEPT_TIME_SEPARATOR).append("\"timestamp\":\"");
        stringBuffer.append(str3);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str4);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str5);
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private String m426a(List<? extends AbstractC0238al> list, Context context) {
        boolean z;
        StringBuilder sb = new StringBuilder();
        sb.append("{\"pinfo\":\"").append(m443g(context)).append("\",\"els\":[");
        boolean z2 = true;
        Iterator<? extends AbstractC0238al> it = list.iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            AbstractC0238al alVar = (AbstractC0238al) it.next();
            String d = m440d(alVar.mo3668b());
            if (d != null && !"".equals(d)) {
                String str = d + "||" + alVar.mo3671c();
                if (z) {
                    z = false;
                } else {
                    sb.append(MiPushClient.ACCEPT_TIME_SEPARATOR);
                }
                sb.append("{\"log\":\"").append(str).append("\"}");
            }
            z2 = z;
        }
        if (z) {
            return null;
        }
        sb.append("]}");
        return sb.toString();
    }

    /* renamed from: a */
    private void m427a(C0237ak akVar, int i) {
        try {
            m429a(akVar.mo3660a(2, C0366u.m1377a(i)), akVar, i);
        } catch (Throwable th) {
            C0365t.m1372a(th, "LogProcessor", "processDeleteFail");
        }
    }

    /* renamed from: a */
    private void m428a(C0237ak akVar, String str, String str2, int i, boolean z) {
        AbstractC0238al b = C0366u.m1382b(i);
        b.mo3666a(0);
        b.mo3670b(str);
        b.mo3667a(str2);
        akVar.mo3661a(b);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.amap.loc.ak */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private void m429a(List<? extends AbstractC0238al> list, C0237ak akVar, int i) {
        if (list != null && list.size() > 0) {
            for (AbstractC0238al alVar : list) {
                if (m434b(alVar.mo3668b())) {
                    akVar.mo3662a(alVar.mo3668b(), (Class<? extends AbstractC0238al>) alVar.getClass());
                } else {
                    alVar.mo3666a(2);
                    akVar.mo3663b(alVar);
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m430a(Context context, String str, String str2, String str3, C0237ak akVar) {
        Throwable th;
        Throwable th2;
        boolean z;
        OutputStream outputStream = null;
        C0264bb bbVar = null;
        C0264bb.C0269b bVar = null;
        try {
            File file = new File(C0366u.m1378a(context, str2));
            if (file.exists() || file.mkdirs()) {
                C0264bb a = C0264bb.m664a(file, 1, 1, 20480);
                a.mo3722a(mo3624a(akVar));
                C0264bb.C0269b a2 = a.mo3721a(str);
                if (a2 != null) {
                    z = false;
                    if (0 != 0) {
                        try {
                            outputStream.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                    if (a2 != null) {
                        try {
                            a2.close();
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                        }
                    }
                    if (a == null || a.mo3723a()) {
                        return false;
                    }
                    try {
                        a.close();
                        return false;
                    } catch (Throwable th5) {
                        th2 = th5;
                    }
                } else {
                    byte[] a3 = C0363r.m1358a(str3);
                    C0264bb.C0267a b = a.mo3724b(str);
                    OutputStream a4 = b.mo3732a(0);
                    a4.write(a3);
                    b.mo3733a();
                    a.mo3725b();
                    z = true;
                    if (a4 != null) {
                        try {
                            a4.close();
                        } catch (Throwable th6) {
                            th6.printStackTrace();
                        }
                    }
                    if (a2 != null) {
                        try {
                            a2.close();
                        } catch (Throwable th7) {
                            th7.printStackTrace();
                        }
                    }
                    if (a == null || a.mo3723a()) {
                        return true;
                    }
                    try {
                        a.close();
                        return true;
                    } catch (Throwable th8) {
                        th2 = th8;
                    }
                }
            } else {
                z = false;
                if (0 != 0) {
                    try {
                        outputStream.close();
                    } catch (Throwable th9) {
                        th9.printStackTrace();
                    }
                }
                if (0 != 0) {
                    try {
                        bVar.close();
                    } catch (Throwable th10) {
                        th10.printStackTrace();
                    }
                }
                if (0 == 0 || bbVar.mo3723a()) {
                    return false;
                }
                try {
                    bbVar.close();
                    return false;
                } catch (Throwable th11) {
                    th2 = th11;
                }
            }
            th.printStackTrace();
            return false;
            if (0 != 0) {
                bVar.close();
            }
            if (0 != 0 && !bbVar.mo3723a()) {
                bbVar.close();
            }
            return false;
            if (0 != 0) {
                bVar.close();
            }
            if (0 != 0 && !bbVar.mo3723a()) {
                bbVar.close();
            }
            return false;
            bbVar.close();
            return false;
            th2.printStackTrace();
            return z;
            bbVar.close();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            if (0 != 0) {
                outputStream.close();
            }
        } catch (Throwable th12) {
            th = th12;
        }
    }

    /* renamed from: a */
    public static boolean m431a(String[] strArr, String str) {
        if (strArr == null || str == null) {
            return false;
        }
        try {
            for (String str2 : str.split(IOUtils.LINE_SEPARATOR_UNIX)) {
                if (m435b(strArr, str2.trim())) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    private C0264bb m432b(Context context, String str) {
        try {
            File file = new File(C0366u.m1378a(context, str));
            if (file.exists() || file.mkdirs()) {
                return C0264bb.m664a(file, 1, 1, 20480);
            }
            return null;
        } catch (IOException e) {
            C0365t.m1372a(e, "LogProcessor", "initDiskLru");
            return null;
        } catch (Throwable th) {
            C0365t.m1372a(th, "LogProcessor", "initDiskLru");
            return null;
        }
    }

    /* renamed from: b */
    public static String m433b(Throwable th) {
        return C0363r.m1349a(th);
    }

    /* renamed from: b */
    private boolean m434b(String str) {
        if (this.f279d == null) {
            return false;
        }
        try {
            return this.f279d.mo3727c(str);
        } catch (Throwable th) {
            C0365t.m1372a(th, "LogUpdateProcessor", "deleteLogData");
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m435b(String[] strArr, String str) {
        if (strArr == null || str == null) {
            return false;
        }
        try {
            for (String str2 : strArr) {
                str = str.trim();
                if (str.startsWith("at ") && str.contains(str2) && str.endsWith(")")) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: c */
    private int m436c(String str) {
        int i = 0;
        try {
            byte[] a = C0275bf.m719a().mo3748a(new C0370v(C0363r.m1364c(C0363r.m1358a(str))));
            if (a == null) {
                return 0;
            }
            try {
                JSONObject jSONObject = new JSONObject(C0363r.m1351a(a));
                if (jSONObject.has("code")) {
                    return jSONObject.getInt("code");
                }
                return 0;
            } catch (JSONException e) {
                C0365t.m1372a(e, "LogProcessor", "processUpdate");
                return 1;
            }
        } catch (C0341h e2) {
            if (e2.mo3933b() != 27) {
                i = 1;
            }
            C0365t.m1372a(e2, "LogProcessor", "processUpdate");
            return i;
        }
    }

    /* renamed from: c */
    private String m437c(Throwable th) {
        return th.toString();
    }

    /* renamed from: d */
    private String m438d() {
        return C0363r.m1348a(new Date().getTime());
    }

    /* renamed from: d */
    public static String m439d(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"key\":\"").append(C0342i.m1235f(context)).append("\",\"platform\":\"android\",\"diu\":\"").append(C0353l.m1284q(context)).append("\",\"pkg\":\"").append(C0342i.m1232c(context)).append("\",\"model\":\"").append(Build.MODEL).append("\",\"appname\":\"").append(C0342i.m1230b(context)).append("\",\"appversion\":\"").append(C0342i.m1233d(context)).append("\",\"sysversion\":\"").append(Build.VERSION.RELEASE).append("\",");
        } catch (Throwable th) {
            C0365t.m1372a(th, "CInfo", "getPublicJSONInfo");
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0052 A[SYNTHETIC, Splitter:B:36:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0057 A[SYNTHETIC, Splitter:B:39:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0080 A[SYNTHETIC, Splitter:B:55:0x0080] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0085 A[SYNTHETIC, Splitter:B:58:0x0085] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m440d(java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 215
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.AbstractC0225aa.m440d(java.lang.String):java.lang.String");
    }

    /* renamed from: e */
    private void m441e(Context context) {
        try {
            this.f279d = m432b(context, mo3625a());
        } catch (Throwable th) {
            C0365t.m1372a(th, "LogProcessor", "LogUpDateProcessor");
        }
    }

    /* renamed from: f */
    private List<C0360q> m442f(Context context) {
        List<C0360q> list;
        Throwable th;
        Throwable th2;
        List<C0360q> list2 = null;
        try {
            synchronized (Looper.getMainLooper()) {
                try {
                    list = new C0239am(context, false).mo3672a();
                    try {
                    } catch (Throwable th3) {
                        list2 = list;
                        th2 = th3;
                        try {
                            throw th2;
                        } catch (Throwable th4) {
                            list = list2;
                            th = th4;
                        }
                    }
                } catch (Throwable th5) {
                    th2 = th5;
                    throw th2;
                }
            }
        } catch (Throwable th6) {
            list = null;
            th = th6;
            th.printStackTrace();
            return list;
        }
    }

    /* renamed from: g */
    private String m443g(Context context) {
        try {
            String d = m439d(context);
            if ("".equals(d)) {
                return null;
            }
            return C0350k.m1258b(context, C0363r.m1358a(d));
        } catch (Throwable th) {
            C0365t.m1372a(th, "LogProcessor", "getPublicInfo");
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public AbstractC0271bc mo3624a(C0237ak akVar) {
        try {
            if (this.f278c == null) {
                this.f278c = new C0226a(akVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.f278c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo3625a() {
        return C0366u.m1384c(this.f277b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo3626a(String str) {
        return C0356n.m1307c(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo3627a(Throwable th) {
        try {
            return m433b(th);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract String mo3628a(List<C0360q> list);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3629a(Context context, Throwable th, String str, String str2) {
        String a;
        List<C0360q> f = m442f(context);
        if (f != null && f.size() != 0 && (a = mo3627a(th)) != null && !"".equals(a)) {
            for (C0360q qVar : f) {
                if (m431a(qVar.mo3944e(), a)) {
                    mo3632a(qVar, context, th, a.replaceAll(IOUtils.LINE_SEPARATOR_UNIX, "<br/>"), str, str2);
                    return;
                }
            }
            if (a.contains("com.amap.api.col")) {
                try {
                    mo3632a(new C0360q.C0362a("collection", "1.0", "AMap_collection_1.0").mo3945a(new String[]{"com.amap.api.collection"}).mo3946a(), context, th, a, str, str2);
                } catch (C0341h e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3630a(C0360q qVar) {
        this.f276a = qVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3631a(C0360q qVar, Context context, String str, String str2, String str3, String str4) {
        mo3630a(qVar);
        String d = m438d();
        String a = m423a(context, qVar);
        String a2 = C0342i.m1228a(context);
        if (str != null && !"".equals(str)) {
            int b = mo3634b();
            StringBuilder sb = new StringBuilder();
            if (str3 != null) {
                sb.append("class:").append(str3);
            }
            if (str4 != null) {
                sb.append(" method:").append(str4).append("$").append("<br/>");
            }
            sb.append(str2);
            String a3 = mo3626a(str2);
            String a4 = m425a(a2, a, d, b, str, sb.toString());
            if (a4 != null && !"".equals(a4)) {
                String a5 = m424a(context, a4);
                String a6 = mo3625a();
                synchronized (Looper.getMainLooper()) {
                    C0237ak akVar = new C0237ak(context);
                    m428a(akVar, qVar.mo3939a(), a3, b, m430a(context, a3, a6, a5, akVar));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3632a(C0360q qVar, Context context, Throwable th, String str, String str2, String str3) {
        mo3631a(qVar, context, m437c(th), str, str2, str3);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo3633a(Context context);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo3634b() {
        return this.f277b;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        r5 = m438d();
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo3635b(android.content.Context r18) {
        /*
        // Method dump skipped, instructions count: 127
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.AbstractC0225aa.mo3635b(android.content.Context):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo3636c() {
        try {
            if (this.f279d != null && !this.f279d.mo3723a()) {
                this.f279d.close();
            }
        } catch (IOException e) {
            C0365t.m1372a(e, "LogProcessor", "closeDiskLru");
        } catch (Throwable th) {
            C0365t.m1372a(th, "LogProcessor", "closeDiskLru");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo3637c(Context context) {
        try {
            m441e(context);
            if (mo3633a(context)) {
                synchronized (Looper.getMainLooper()) {
                    C0237ak akVar = new C0237ak(context);
                    m427a(akVar, mo3634b());
                    List<? extends AbstractC0238al> a = akVar.mo3660a(0, C0366u.m1377a(mo3634b()));
                    if (a != null && a.size() != 0) {
                        String a2 = m426a(a, context);
                        if (a2 != null) {
                            if (m436c(a2) == 1) {
                                m429a(a, akVar, mo3634b());
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            C0365t.m1372a(th, "LogProcessor", "processUpdateLog");
        }
    }
}
