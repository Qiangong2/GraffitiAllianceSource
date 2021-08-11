package com.xiaomi.network;

import android.text.TextUtils;
import com.tencent.qcloud.core.util.IOUtils;
import com.umeng.analytics.C1370a;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class Fallback {

    /* renamed from: a */
    public String f4893a;

    /* renamed from: b */
    public String f4894b;

    /* renamed from: c */
    public String f4895c;

    /* renamed from: d */
    public String f4896d;

    /* renamed from: e */
    public String f4897e;

    /* renamed from: f */
    public String f4898f;

    /* renamed from: g */
    public String f4899g;

    /* renamed from: h */
    protected String f4900h;

    /* renamed from: i */
    private long f4901i;

    /* renamed from: j */
    private ArrayList<C1917e> f4902j = new ArrayList<>();

    /* renamed from: k */
    private String f4903k;

    /* renamed from: l */
    private double f4904l = 0.1d;

    /* renamed from: m */
    private String f4905m = "s.mi1.cc";

    /* renamed from: n */
    private long f4906n = C1370a.f3217i;

    public Fallback(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f4901i = System.currentTimeMillis();
        this.f4902j.add(new C1917e(str, -1));
        this.f4893a = HostManager.getInstance().getActiveNetworkLabel();
        this.f4894b = str;
    }

    /* renamed from: c */
    private synchronized void m7030c(String str) {
        Iterator<C1917e> it = this.f4902j.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().f4925a, str)) {
                it.remove();
            }
        }
    }

    /* renamed from: a */
    public synchronized Fallback mo10225a(JSONObject jSONObject) {
        this.f4893a = jSONObject.optString("net");
        this.f4906n = jSONObject.getLong("ttl");
        this.f4904l = jSONObject.getDouble("pct");
        this.f4901i = jSONObject.getLong("ts");
        this.f4896d = jSONObject.optString("city");
        this.f4895c = jSONObject.optString("prv");
        this.f4899g = jSONObject.optString("cty");
        this.f4897e = jSONObject.optString("isp");
        this.f4898f = jSONObject.optString("ip");
        this.f4894b = jSONObject.optString("host");
        this.f4900h = jSONObject.optString("xf");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            mo10230a(new C1917e().mo10297a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    /* renamed from: a */
    public ArrayList<String> mo10226a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the url is empty.");
        }
        URL url = new URL(str);
        if (TextUtils.equals(url.getHost(), this.f4894b)) {
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<String> it = mo10227a(true).iterator();
            while (it.hasNext()) {
                Host a = Host.m7054a(it.next(), url.getPort());
                arrayList.add(new URL(url.getProtocol(), a.mo10258b(), a.mo10257a(), url.getFile()).toString());
            }
            return arrayList;
        }
        throw new IllegalArgumentException("the url is not supported by the fallback");
    }

    /* renamed from: a */
    public synchronized ArrayList<String> mo10227a(boolean z) {
        ArrayList<String> arrayList;
        synchronized (this) {
            C1917e[] eVarArr = new C1917e[this.f4902j.size()];
            this.f4902j.toArray(eVarArr);
            Arrays.sort(eVarArr);
            arrayList = new ArrayList<>();
            for (C1917e eVar : eVarArr) {
                if (z) {
                    arrayList.add(eVar.f4925a);
                } else {
                    int indexOf = eVar.f4925a.indexOf(":");
                    if (indexOf != -1) {
                        arrayList.add(eVar.f4925a.substring(0, indexOf));
                    } else {
                        arrayList.add(eVar.f4925a);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public void mo10228a(double d) {
        this.f4904l = d;
    }

    /* renamed from: a */
    public void mo10229a(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("the duration is invalid " + j);
        }
        this.f4906n = j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo10230a(C1917e eVar) {
        m7030c(eVar.f4925a);
        this.f4902j.add(eVar);
    }

    /* renamed from: a */
    public void mo10231a(String str, int i, long j, long j2, Exception exc) {
        mo10234a(str, new AccessHistory(i, j, j2, exc));
    }

    /* renamed from: a */
    public void mo10232a(String str, long j, long j2) {
        try {
            mo10239b(new URL(str).getHost(), j, j2);
        } catch (MalformedURLException e) {
        }
    }

    /* renamed from: a */
    public void mo10233a(String str, long j, long j2, Exception exc) {
        try {
            mo10240b(new URL(str).getHost(), j, j2, exc);
        } catch (MalformedURLException e) {
        }
    }

    /* renamed from: a */
    public synchronized void mo10234a(String str, AccessHistory accessHistory) {
        Iterator<C1917e> it = this.f4902j.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C1917e next = it.next();
            if (TextUtils.equals(str, next.f4925a)) {
                next.mo10299a(accessHistory);
                break;
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo10235a(String[] strArr) {
        for (int size = this.f4902j.size() - 1; size >= 0; size--) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (TextUtils.equals(this.f4902j.get(size).f4925a, strArr[i])) {
                    this.f4902j.remove(size);
                    break;
                }
                i++;
            }
        }
        Iterator<C1917e> it = this.f4902j.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            C1917e next = it.next();
            i2 = next.f4926b > i2 ? next.f4926b : i2;
        }
        for (int i3 = 0; i3 < strArr.length; i3++) {
            mo10230a(new C1917e(strArr[i3], (strArr.length + i2) - i3));
        }
    }

    /* renamed from: a */
    public boolean mo10236a() {
        return TextUtils.equals(this.f4893a, HostManager.getInstance().getActiveNetworkLabel());
    }

    /* renamed from: a */
    public boolean mo10237a(Fallback fallback) {
        return TextUtils.equals(this.f4893a, fallback.f4893a);
    }

    /* renamed from: b */
    public void mo10238b(String str) {
        this.f4905m = str;
    }

    /* renamed from: b */
    public void mo10239b(String str, long j, long j2) {
        mo10231a(str, 0, j, j2, null);
    }

    /* renamed from: b */
    public void mo10240b(String str, long j, long j2, Exception exc) {
        mo10231a(str, -1, j, j2, exc);
    }

    /* renamed from: b */
    public boolean mo10241b() {
        return System.currentTimeMillis() - this.f4901i < this.f4906n;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo10242c() {
        long j = 864000000;
        if (864000000 < this.f4906n) {
            j = this.f4906n;
        }
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis - this.f4901i > j || (currentTimeMillis - this.f4901i > this.f4906n && this.f4893a.startsWith("WIFI-"));
    }

    /* renamed from: d */
    public synchronized ArrayList<String> mo10243d() {
        return mo10227a(false);
    }

    /* renamed from: e */
    public synchronized String mo10244e() {
        String str;
        if (!TextUtils.isEmpty(this.f4903k)) {
            str = this.f4903k;
        } else if (TextUtils.isEmpty(this.f4897e)) {
            str = "hardcode_isp";
        } else {
            this.f4903k = HostManager.join(new String[]{this.f4897e, this.f4895c, this.f4896d, this.f4899g, this.f4898f}, "_");
            str = this.f4903k;
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public ArrayList<C1917e> mo10245f() {
        return this.f4902j;
    }

    /* renamed from: g */
    public double mo10246g() {
        if (this.f4904l < 1.0E-5d) {
            return 0.1d;
        }
        return this.f4904l;
    }

    /* renamed from: h */
    public synchronized JSONObject mo10247h() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("net", this.f4893a);
        jSONObject.put("ttl", this.f4906n);
        jSONObject.put("pct", this.f4904l);
        jSONObject.put("ts", this.f4901i);
        jSONObject.put("city", this.f4896d);
        jSONObject.put("prv", this.f4895c);
        jSONObject.put("cty", this.f4899g);
        jSONObject.put("isp", this.f4897e);
        jSONObject.put("ip", this.f4898f);
        jSONObject.put("host", this.f4894b);
        jSONObject.put("xf", this.f4900h);
        JSONArray jSONArray = new JSONArray();
        Iterator<C1917e> it = this.f4902j.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().mo10300b());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4893a);
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append(mo10244e());
        Iterator<C1917e> it = this.f4902j.iterator();
        while (it.hasNext()) {
            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            sb.append(it.next().toString());
        }
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        return sb.toString();
    }
}
