package com.xiaomi.network;

import android.content.Context;
import com.xiaomi.channel.commonutils.network.C1865d;
import com.xiaomi.channel.commonutils.string.C1870a;
import com.xiaomi.common.logger.thrift.C1874a;
import com.xiaomi.common.logger.thrift.mfs.C1878b;
import com.xiaomi.common.logger.thrift.mfs.C1880c;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TreeMap;
import org.apache.thrift.C2165g;
import org.apache.thrift.protocol.C2175b;

public class UploadHostStatHelper {

    /* renamed from: e */
    private static UploadHostStatHelper f4913e;

    /* renamed from: a */
    private List<HttpRecordCallback> f4914a = new ArrayList();

    /* renamed from: b */
    private final Random f4915b = new Random();

    /* renamed from: c */
    private Timer f4916c = new Timer("Upload Http Record Timer");

    /* renamed from: d */
    private boolean f4917d = false;

    /* renamed from: f */
    private Context f4918f = null;

    public interface HttpRecordCallback {
        /* renamed from: a */
        List<C1878b> mo10293a();

        /* renamed from: b */
        double mo10294b();
    }

    private UploadHostStatHelper(Context context) {
        this.f4918f = context.getApplicationContext();
    }

    /* renamed from: a */
    public static synchronized UploadHostStatHelper m7074a() {
        UploadHostStatHelper uploadHostStatHelper;
        synchronized (UploadHostStatHelper.class) {
            uploadHostStatHelper = f4913e;
        }
        return uploadHostStatHelper;
    }

    /* renamed from: a */
    private String m7075a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(m7082b(str));
            return String.format("%1$032X", new BigInteger(1, instance.digest()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public static synchronized void m7077a(Context context) {
        synchronized (UploadHostStatHelper.class) {
            if (f4913e == null) {
                f4913e = new UploadHostStatHelper(context);
            }
        }
    }

    /* renamed from: a */
    private void m7079a(String str, String str2) {
        String valueOf = String.valueOf(System.nanoTime());
        String valueOf2 = String.valueOf(System.currentTimeMillis());
        TreeMap treeMap = new TreeMap();
        treeMap.put("n", valueOf);
        treeMap.put("d", str2);
        treeMap.put("t", valueOf2);
        treeMap.put("s", m7075a(valueOf + str2 + valueOf2 + "56C6A520%$C99119A0&^229(!@2746C7"));
        C1865d.m6749a(this.f4918f, String.format("http://%1$s/diagnoses/v1/report", str), treeMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7080a(List<C1878b> list, double d) {
        for (C1878b bVar : list) {
            C1880c cVar = new C1880c();
            cVar.mo10004a("httpapi");
            cVar.mo10003a(bVar);
            cVar.mo10002a(new C1874a());
            String str = new String(C1870a.m6774a(new C2165g(new C2175b.C2176a()).mo12123a(cVar)));
            if (((double) this.f4915b.nextInt(10000)) < 10000.0d * d) {
                try {
                    m7079a("f3.mi-stat.gslb.mi-idc.com", str);
                } catch (IOException | Exception e) {
                }
            }
        }
    }

    /* renamed from: b */
    private byte[] m7082b(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            return str.getBytes();
        }
    }

    /* renamed from: a */
    public synchronized void mo10290a(HttpRecordCallback httpRecordCallback) {
        this.f4914a.add(httpRecordCallback);
    }

    /* renamed from: b */
    public void mo10291b() {
        if (!this.f4917d) {
            this.f4917d = true;
            this.f4916c.schedule(new C1916d(this), 60000);
        }
    }

    /* renamed from: b */
    public synchronized void mo10292b(HttpRecordCallback httpRecordCallback) {
        this.f4914a.remove(httpRecordCallback);
    }
}
