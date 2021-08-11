package com.wanmei.sdk.core.net;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.wanmei.sdk.core.net.d */
public class C1772d {

    /* renamed from: o */
    private static AbstractC1774a f4467o = new AbstractC1774a() {
        /* class com.wanmei.sdk.core.net.C1772d.C17731 */

        @Override // com.wanmei.sdk.core.net.C1772d.AbstractC1774a
        /* renamed from: a */
        public String mo9581a(Map<String, String> map) {
            if (map == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            for (String str : map.keySet()) {
                String str2 = map.get(str);
                if (!TextUtils.isEmpty(str2)) {
                    sb.append(str).append(SimpleComparison.EQUAL_TO_OPERATION).append(str2).append("&");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }
    };

    /* renamed from: a */
    private String f4468a = "UTF-8";

    /* renamed from: b */
    private int f4469b = 10000;

    /* renamed from: c */
    private int f4470c = 10000;

    /* renamed from: d */
    private String f4471d = "application/x-www-form-urlencoded;charset=UTF-8";

    /* renamed from: e */
    private String f4472e = "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET4.0C; .NET4.0E)";

    /* renamed from: f */
    private String f4473f = "";

    /* renamed from: g */
    private String f4474g;

    /* renamed from: h */
    private short f4475h;

    /* renamed from: i */
    private String f4476i;

    /* renamed from: j */
    private HashMap<String, String> f4477j;

    /* renamed from: k */
    private String f4478k;

    /* renamed from: l */
    private Proxy f4479l;

    /* renamed from: m */
    private Map<String, String> f4480m;

    /* renamed from: n */
    private AbstractC1774a f4481n = f4467o;

    /* renamed from: com.wanmei.sdk.core.net.d$a */
    public interface AbstractC1774a {
        /* renamed from: a */
        String mo9581a(Map<String, String> map);
    }

    public C1772d(Context context, String str, short s) {
        this.f4474g = str;
        this.f4475h = s;
        this.f4476i = null;
        C1775e a = C1775e.m6536a(context);
        if (a.mo9582a() != 0) {
            this.f4479l = null;
        } else if (Build.VERSION.SDK_INT <= 16) {
            InetSocketAddress b = a.mo9583b();
            if (b != null) {
                this.f4479l = new Proxy(Proxy.Type.HTTP, b);
            }
        } else {
            this.f4479l = null;
        }
    }

    /* renamed from: a */
    public String mo9566a() {
        return this.f4478k;
    }

    /* renamed from: a */
    public void mo9567a(String str) {
        this.f4474g = str;
    }

    /* renamed from: a */
    public void mo9568a(HashMap<String, String> hashMap) {
        this.f4477j = hashMap;
    }

    /* renamed from: a */
    public void mo9569a(Map<String, String> map) {
        this.f4480m = map;
    }

    /* renamed from: b */
    public HashMap<String, String> mo9570b() {
        return this.f4477j;
    }

    /* renamed from: b */
    public void mo9571b(String str) {
        this.f4473f = str;
    }

    /* renamed from: c */
    public String mo9572c() {
        return this.f4474g;
    }

    /* renamed from: d */
    public short mo9573d() {
        return this.f4475h;
    }

    /* renamed from: e */
    public String mo9574e() {
        return this.f4476i;
    }

    /* renamed from: f */
    public int mo9575f() {
        return this.f4469b;
    }

    /* renamed from: g */
    public int mo9576g() {
        return this.f4470c;
    }

    /* renamed from: h */
    public Proxy mo9577h() {
        return this.f4479l;
    }

    /* renamed from: i */
    public String mo9578i() {
        return this.f4473f;
    }

    /* renamed from: j */
    public Map<String, String> mo9579j() {
        return this.f4480m;
    }

    /* renamed from: k */
    public String mo9580k() {
        return this.f4481n.mo9581a(this.f4480m);
    }
}
