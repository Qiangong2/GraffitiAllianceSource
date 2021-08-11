package com.wanmei.push.p102e;

import android.content.Context;
import android.os.Build;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.wanmei.push.p104g.C1716h;
import com.wanmei.push.p104g.C1719k;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.wanmei.push.e.d */
public final class C1702d {

    /* renamed from: a */
    private static AbstractC1704a f4322a = new AbstractC1704a() {
        /* class com.wanmei.push.p102e.C1702d.C17031 */

        @Override // com.wanmei.push.p102e.C1702d.AbstractC1704a
        /* renamed from: a */
        public final String mo9346a(Map<String, String> map) {
            if (map == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            for (String str : map.keySet()) {
                String str2 = map.get(str);
                if (!C1719k.m6394a(str2)) {
                    sb.append(str).append(SimpleComparison.EQUAL_TO_OPERATION).append(URLEncoder.encode(str2)).append("&");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }
    };

    /* renamed from: b */
    private String f4323b = "UTF-8";

    /* renamed from: c */
    private int f4324c = 25000;

    /* renamed from: d */
    private int f4325d = 25000;

    /* renamed from: e */
    private String f4326e = "application/x-www-form-urlencoded;charset=UTF-8";

    /* renamed from: f */
    private String f4327f = "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET4.0C; .NET4.0E)";

    /* renamed from: g */
    private String f4328g = "";

    /* renamed from: h */
    private String f4329h;

    /* renamed from: i */
    private short f4330i;

    /* renamed from: j */
    private Map<String, String> f4331j;

    /* renamed from: k */
    private HashMap<String, String> f4332k;

    /* renamed from: l */
    private String f4333l;

    /* renamed from: m */
    private Proxy f4334m;

    /* renamed from: n */
    private AbstractC1704a f4335n = f4322a;

    /* renamed from: o */
    private boolean f4336o;

    /* renamed from: com.wanmei.push.e.d$a */
    public interface AbstractC1704a {
        /* renamed from: a */
        String mo9346a(Map<String, String> map);
    }

    public C1702d(Context context, String str, Map<String, String> map) {
        this.f4329h = str;
        this.f4330i = 1;
        this.f4331j = map;
        C1716h a = C1716h.m6385a(context);
        if (a.mo9379a() != 0) {
            this.f4334m = null;
        } else if (Build.VERSION.SDK_INT <= 16) {
            InetSocketAddress c = a.mo9381c();
            if (c != null) {
                this.f4334m = new Proxy(Proxy.Type.HTTP, c);
            }
        } else {
            this.f4334m = null;
        }
    }

    /* renamed from: a */
    public final String mo9353a() {
        return this.f4333l;
    }

    /* renamed from: a */
    public final void mo9354a(AbstractC1704a aVar) {
        this.f4335n = aVar;
    }

    /* renamed from: a */
    public final void mo9355a(String str) {
        this.f4329h = str;
    }

    /* renamed from: a */
    public final void mo9356a(HashMap<String, String> hashMap) {
        this.f4332k = hashMap;
    }

    /* renamed from: b */
    public final HashMap<String, String> mo9357b() {
        return this.f4332k;
    }

    /* renamed from: b */
    public final void mo9358b(String str) {
        this.f4328g = str;
    }

    /* renamed from: c */
    public final String mo9359c() {
        return this.f4329h;
    }

    /* renamed from: d */
    public final short mo9360d() {
        return this.f4330i;
    }

    /* renamed from: e */
    public final Map<String, String> mo9361e() {
        return this.f4331j;
    }

    /* renamed from: f */
    public final int mo9362f() {
        return this.f4324c;
    }

    /* renamed from: g */
    public final int mo9363g() {
        return this.f4325d;
    }

    /* renamed from: h */
    public final Proxy mo9364h() {
        return this.f4334m;
    }

    /* renamed from: i */
    public final String mo9365i() {
        return this.f4328g;
    }

    /* renamed from: j */
    public final String mo9366j() {
        return this.f4335n.mo9346a(this.f4331j);
    }

    /* renamed from: k */
    public final boolean mo9367k() {
        return this.f4336o;
    }
}
