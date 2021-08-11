package com.xiaomi.smack.packet;

import android.os.Bundle;
import com.umeng.analytics.p091b.C1447g;
import com.xiaomi.smack.util.C2045g;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.smack.packet.b */
public class C2025b extends AbstractC2028d {

    /* renamed from: a */
    private C2026a f5364a = C2026a.f5366a;

    /* renamed from: d */
    private final Map<String, String> f5365d = new HashMap();

    /* renamed from: com.xiaomi.smack.packet.b$a */
    public static class C2026a {

        /* renamed from: a */
        public static final C2026a f5366a = new C2026a("get");

        /* renamed from: b */
        public static final C2026a f5367b = new C2026a("set");

        /* renamed from: c */
        public static final C2026a f5368c = new C2026a("result");

        /* renamed from: d */
        public static final C2026a f5369d = new C2026a(C1447g.f3469aF);

        /* renamed from: e */
        public static final C2026a f5370e = new C2026a("command");

        /* renamed from: f */
        private String f5371f;

        private C2026a(String str) {
            this.f5371f = str;
        }

        /* renamed from: a */
        public static C2026a m7614a(String str) {
            if (str == null) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            if (f5366a.toString().equals(lowerCase)) {
                return f5366a;
            }
            if (f5367b.toString().equals(lowerCase)) {
                return f5367b;
            }
            if (f5369d.toString().equals(lowerCase)) {
                return f5369d;
            }
            if (f5368c.toString().equals(lowerCase)) {
                return f5368c;
            }
            if (f5370e.toString().equals(lowerCase)) {
                return f5370e;
            }
            return null;
        }

        public String toString() {
            return this.f5371f;
        }
    }

    public C2025b() {
    }

    public C2025b(Bundle bundle) {
        super(bundle);
        if (bundle.containsKey("ext_iq_type")) {
            this.f5364a = C2026a.m7614a(bundle.getString("ext_iq_type"));
        }
    }

    @Override // com.xiaomi.smack.packet.AbstractC2028d
    /* renamed from: a */
    public String mo10546a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<iq ");
        if (mo10609k() != null) {
            sb.append("id=\"" + mo10609k() + "\" ");
        }
        if (mo10613m() != null) {
            sb.append("to=\"").append(C2045g.m7700a(mo10613m())).append("\" ");
        }
        if (mo10615n() != null) {
            sb.append("from=\"").append(C2045g.m7700a(mo10615n())).append("\" ");
        }
        if (mo10611l() != null) {
            sb.append("chid=\"").append(C2045g.m7700a(mo10611l())).append("\" ");
        }
        for (Map.Entry<String, String> entry : this.f5365d.entrySet()) {
            sb.append(C2045g.m7700a(entry.getKey())).append("=\"");
            sb.append(C2045g.m7700a(entry.getValue())).append("\" ");
        }
        if (this.f5364a == null) {
            sb.append("type=\"get\">");
        } else {
            sb.append("type=\"").append(mo10580b()).append("\">");
        }
        String d = mo10582d();
        if (d != null) {
            sb.append(d);
        }
        sb.append(mo10624s());
        C2034h p = mo10620p();
        if (p != null) {
            sb.append(p.mo10634d());
        }
        sb.append("</iq>");
        return sb.toString();
    }

    /* renamed from: a */
    public synchronized String mo10576a(String str) {
        return this.f5365d.get(str);
    }

    /* renamed from: a */
    public void mo10577a(C2026a aVar) {
        if (aVar == null) {
            this.f5364a = C2026a.f5366a;
        } else {
            this.f5364a = aVar;
        }
    }

    /* renamed from: a */
    public synchronized void mo10578a(String str, String str2) {
        this.f5365d.put(str, str2);
    }

    /* renamed from: a */
    public synchronized void mo10579a(Map<String, String> map) {
        this.f5365d.putAll(map);
    }

    /* renamed from: b */
    public C2026a mo10580b() {
        return this.f5364a;
    }

    @Override // com.xiaomi.smack.packet.AbstractC2028d
    /* renamed from: c */
    public Bundle mo10581c() {
        Bundle c = super.mo10581c();
        if (this.f5364a != null) {
            c.putString("ext_iq_type", this.f5364a.toString());
        }
        return c;
    }

    /* renamed from: d */
    public String mo10582d() {
        return null;
    }
}
