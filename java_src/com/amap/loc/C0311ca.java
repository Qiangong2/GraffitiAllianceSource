package com.amap.loc;

import android.content.Context;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.amap.loc.ca */
/* compiled from: Cache */
public class C0311ca {

    /* renamed from: a */
    private static C0311ca f646a = null;

    /* renamed from: b */
    private Hashtable<String, ArrayList<C0312a>> f647b = new Hashtable<>();

    /* renamed from: c */
    private long f648c = 0;

    /* renamed from: d */
    private boolean f649d = false;

    /* access modifiers changed from: package-private */
    /* renamed from: com.amap.loc.ca$a */
    /* compiled from: Cache */
    public static class C0312a {

        /* renamed from: a */
        private AMapLocationServer f650a = null;

        /* renamed from: b */
        private String f651b = null;

        protected C0312a() {
        }

        /* renamed from: a */
        public AMapLocationServer mo3859a() {
            return this.f650a;
        }

        /* renamed from: a */
        public void mo3860a(AMapLocationServer aMapLocationServer) {
            this.f650a = aMapLocationServer;
        }

        /* renamed from: a */
        public void mo3861a(String str) {
            if (TextUtils.isEmpty(str)) {
                this.f651b = null;
            } else {
                this.f651b = str.replace("##", MqttTopic.MULTI_LEVEL_WILDCARD);
            }
        }

        /* renamed from: b */
        public String mo3862b() {
            return this.f651b;
        }
    }

    private C0311ca() {
    }

    /* renamed from: a */
    private synchronized C0312a m965a(StringBuilder sb, String str) {
        C0312a aVar;
        boolean z;
        if (this.f647b.isEmpty() || TextUtils.isEmpty(sb)) {
            aVar = null;
        } else if (!this.f647b.containsKey(str)) {
            aVar = null;
        } else {
            Hashtable<String, String> hashtable = new Hashtable<>();
            Hashtable<String, String> hashtable2 = new Hashtable<>();
            Hashtable hashtable3 = new Hashtable();
            ArrayList<C0312a> arrayList = this.f647b.get(str);
            int size = arrayList.size() - 1;
            while (true) {
                if (size < 0) {
                    aVar = null;
                    break;
                }
                C0312a aVar2 = arrayList.get(size);
                if (!TextUtils.isEmpty(aVar2.mo3862b())) {
                    if (m969b(aVar2.mo3862b(), sb)) {
                        if (mo3856a(aVar2.mo3862b(), sb)) {
                            aVar = aVar2;
                            break;
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                    m967a(aVar2.mo3862b(), hashtable);
                    m967a(sb.toString(), hashtable2);
                    hashtable3.clear();
                    for (String str2 : hashtable.keySet()) {
                        hashtable3.put(str2, "");
                    }
                    for (String str3 : hashtable2.keySet()) {
                        hashtable3.put(str3, "");
                    }
                    Set keySet = hashtable3.keySet();
                    double[] dArr = new double[keySet.size()];
                    double[] dArr2 = new double[keySet.size()];
                    Iterator it = keySet.iterator();
                    int i = 0;
                    while (it != null && it.hasNext()) {
                        String str4 = (String) it.next();
                        dArr[i] = hashtable.containsKey(str4) ? 1.0d : 0.0d;
                        dArr2[i] = hashtable2.containsKey(str4) ? 1.0d : 0.0d;
                        i++;
                    }
                    keySet.clear();
                    double[] a = m968a(dArr, dArr2);
                    if (a[0] < 0.800000011920929d) {
                        if (a[1] < 0.618d) {
                            if (z && a[0] >= 0.618d) {
                                aVar = aVar2;
                                break;
                            }
                        } else {
                            aVar = aVar2;
                            break;
                        }
                    } else {
                        aVar = aVar2;
                        break;
                    }
                }
                size--;
            }
            hashtable.clear();
            hashtable2.clear();
            hashtable3.clear();
        }
        return aVar;
    }

    /* renamed from: a */
    public static synchronized C0311ca m966a() {
        C0311ca caVar;
        synchronized (C0311ca.class) {
            if (f646a == null) {
                f646a = new C0311ca();
            }
            caVar = f646a;
        }
        return caVar;
    }

    /* renamed from: a */
    private void m967a(String str, Hashtable<String, String> hashtable) {
        if (!TextUtils.isEmpty(str)) {
            hashtable.clear();
            String[] split = str.split(MqttTopic.MULTI_LEVEL_WILDCARD);
            for (String str2 : split) {
                if (!TextUtils.isEmpty(str2) && !str2.contains("|")) {
                    hashtable.put(str2, "");
                }
            }
        }
    }

    /* renamed from: a */
    private double[] m968a(double[] dArr, double[] dArr2) {
        double[] dArr3 = new double[3];
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < dArr.length; i3++) {
            d2 += dArr[i3] * dArr[i3];
            d3 += dArr2[i3] * dArr2[i3];
            d += dArr[i3] * dArr2[i3];
            if (dArr2[i3] == 1.0d) {
                i++;
                if (dArr[i3] == 1.0d) {
                    i2++;
                }
            }
        }
        dArr3[0] = d / (Math.sqrt(d3) * Math.sqrt(d2));
        dArr3[1] = (1.0d * ((double) i2)) / ((double) i);
        dArr3[2] = (double) i2;
        for (int i4 = 0; i4 < dArr3.length - 1; i4++) {
            if (dArr3[i4] > 1.0d) {
                dArr3[i4] = 1.0d;
            }
        }
        return dArr3;
    }

    /* renamed from: b */
    private boolean m969b(String str, StringBuilder sb) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(sb)) {
            return false;
        }
        if (!str.contains(",access") || sb.indexOf(",access") == -1) {
            return false;
        }
        String[] split = str.split(",access");
        String substring = split[0].contains(MqttTopic.MULTI_LEVEL_WILDCARD) ? split[0].substring(split[0].lastIndexOf(MqttTopic.MULTI_LEVEL_WILDCARD) + 1) : split[0];
        if (TextUtils.isEmpty(substring)) {
            return false;
        }
        return sb.toString().contains(substring + ",access");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006b, code lost:
        if (com.amap.loc.C0322ck.m1052b(r0.getTime()) == false) goto L_0x006d;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.autonavi.aps.amapapi.model.AMapLocationServer mo3852a(java.lang.String r5, java.lang.StringBuilder r6, boolean r7) {
        /*
        // Method dump skipped, instructions count: 171
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0311ca.mo3852a(java.lang.String, java.lang.StringBuilder, boolean):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    /* renamed from: a */
    public void mo3853a(Context context) {
        if (!this.f649d) {
            C0331cr.m1170b();
            try {
                C0314cc.m983a().mo3865a(context);
            } catch (Throwable th) {
                C0310c.m956a(th, "Cache", "loadDB");
            }
            this.f649d = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0082, code lost:
        if (r0 < 8) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0118, code lost:
        if (r9.getAccuracy() <= 10.0f) goto L_0x0008;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0137, code lost:
        if (r9.mo3963c().equals("4") != false) goto L_0x0008;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo3854a(java.lang.String r7, java.lang.StringBuilder r8, com.autonavi.aps.amapapi.model.AMapLocationServer r9, android.content.Context r10, boolean r11) {
        /*
        // Method dump skipped, instructions count: 334
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0311ca.mo3854a(java.lang.String, java.lang.StringBuilder, com.autonavi.aps.amapapi.model.AMapLocationServer, android.content.Context, boolean):void");
    }

    /* renamed from: a */
    public boolean mo3855a(String str, AMapLocationServer aMapLocationServer) {
        return !TextUtils.isEmpty(str) && C0331cr.m1164a(aMapLocationServer) && !str.startsWith(MqttTopic.MULTI_LEVEL_WILDCARD) && str.contains("network");
    }

    /* renamed from: a */
    public boolean mo3856a(String str, StringBuilder sb) {
        String[] split = str.split(MqttTopic.MULTI_LEVEL_WILDCARD);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < split.length; i++) {
            if (split[i].contains(",nb") || split[i].contains(",access")) {
                arrayList.add(split[i]);
            }
        }
        String[] split2 = sb.toString().split(MqttTopic.MULTI_LEVEL_WILDCARD);
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < split2.length; i4++) {
            if (split2[i4].contains(",nb") || split2[i4].contains(",access")) {
                i2++;
                if (arrayList.contains(split2[i4])) {
                    i3++;
                }
            }
        }
        return ((double) (i3 * 2)) >= ((double) (arrayList.size() + i2)) * 0.618d;
    }

    /* renamed from: b */
    public boolean mo3857b() {
        long b = C0331cr.m1170b() - this.f648c;
        if (this.f648c == 0) {
            return false;
        }
        if (this.f647b.size() > 360) {
            return true;
        }
        return b > 36000000;
    }

    /* renamed from: c */
    public void mo3858c() {
        this.f648c = 0;
        if (!this.f647b.isEmpty()) {
            this.f647b.clear();
        }
        this.f649d = false;
    }
}
