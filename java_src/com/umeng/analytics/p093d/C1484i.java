package com.umeng.analytics.p093d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.C1370a;
import com.umeng.analytics.p092c.C1457h;
import com.umeng.analytics.p094e.C1496a;
import com.umeng.p085a.C1340b;
import com.umeng.p085a.C1341c;
import com.umeng.p085a.C1343e;
import com.umeng.p085a.C1344f;
import java.net.URLEncoder;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.umeng.analytics.d.i */
/* compiled from: NetworkHelper */
public class C1484i {

    /* renamed from: a */
    private String f3671a;

    /* renamed from: b */
    private String f3672b = "10.0.0.172";

    /* renamed from: c */
    private int f3673c = 80;

    /* renamed from: d */
    private Context f3674d;

    /* renamed from: e */
    private AbstractC1483h f3675e;

    public C1484i(Context context) {
        this.f3674d = context;
        this.f3671a = m5509a(context);
    }

    /* renamed from: a */
    public void mo8643a(AbstractC1483h hVar) {
        this.f3675e = hVar;
    }

    /* renamed from: b */
    private void m5511b() {
        String d = C1457h.m5380a(this.f3674d).mo8580b().mo8597d("");
        String c = C1457h.m5380a(this.f3674d).mo8580b().mo8595c("");
        if (!TextUtils.isEmpty(d)) {
            C1370a.f3214f = C1341c.m4917b(d);
        }
        if (!TextUtils.isEmpty(c)) {
            C1370a.f3215g = C1341c.m4917b(c);
        }
        C1370a.f3216h = new String[]{C1370a.f3214f, C1370a.f3215g};
        int b = C1496a.m5568a(this.f3674d).mo8672b();
        if (b == -1) {
            return;
        }
        if (b == 0) {
            C1370a.f3216h = new String[]{C1370a.f3214f, C1370a.f3215g};
        } else if (b == 1) {
            C1370a.f3216h = new String[]{C1370a.f3215g, C1370a.f3214f};
        }
    }

    /* renamed from: a */
    public byte[] mo8644a(byte[] bArr) {
        byte[] bArr2 = null;
        m5511b();
        int i = 0;
        while (true) {
            if (i >= C1370a.f3216h.length) {
                break;
            }
            bArr2 = m5510a(bArr, C1370a.f3216h[i]);
            if (bArr2 == null) {
                if (this.f3675e != null) {
                    this.f3675e.mo8641d();
                }
                i++;
            } else if (this.f3675e != null) {
                this.f3675e.mo8640c();
            }
        }
        return bArr2;
    }

    /* renamed from: c */
    private boolean m5512c() {
        String extraInfo;
        if (this.f3674d.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.f3674d.getPackageName()) != 0) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f3674d.getSystemService("connectivity");
            if (!C1343e.m4938a(this.f3674d, "android.permission.ACCESS_NETWORK_STATE")) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (!(activeNetworkInfo == null || activeNetworkInfo.getType() == 1 || (extraInfo = activeNetworkInfo.getExtraInfo()) == null || (!extraInfo.equals("cmwap") && !extraInfo.equals("3gwap") && !extraInfo.equals("uniwap")))) {
                return true;
            }
            return false;
        } catch (Throwable th) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ff  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] m5510a(byte[] r9, java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 266
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.p093d.C1484i.m5510a(byte[], java.lang.String):byte[]");
    }

    /* renamed from: a */
    private String m5509a(Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Android");
        stringBuffer.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        stringBuffer.append(C1340b.f3133a);
        stringBuffer.append(" ");
        try {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(C1343e.m4966v(context));
            stringBuffer2.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
            stringBuffer2.append(C1343e.m4941b(context));
            stringBuffer2.append(" ");
            stringBuffer2.append(Build.MODEL);
            stringBuffer2.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
            stringBuffer2.append(Build.VERSION.RELEASE);
            stringBuffer2.append(" ");
            stringBuffer2.append(C1344f.m4973a(AnalyticsConfig.getAppkey(context)));
            stringBuffer.append(URLEncoder.encode(stringBuffer2.toString(), "UTF-8"));
        } catch (Throwable th) {
        }
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0090, code lost:
        if (0 != 0) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00d5, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00d6, code lost:
        r1 = null;
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00db A[SYNTHETIC, Splitter:B:29:0x00db] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x008f A[ExcHandler: Throwable (th java.lang.Throwable), Splitter:B:1:0x0001] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8642a() {
        /*
        // Method dump skipped, instructions count: 232
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.p093d.C1484i.mo8642a():void");
    }
}
