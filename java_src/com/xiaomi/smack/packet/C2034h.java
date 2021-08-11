package com.xiaomi.smack.packet;

import android.os.Bundle;
import android.os.Parcelable;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.xiaomi.smack.packet.h */
public class C2034h {

    /* renamed from: a */
    private int f5419a;

    /* renamed from: b */
    private String f5420b;

    /* renamed from: c */
    private String f5421c;

    /* renamed from: d */
    private String f5422d;

    /* renamed from: e */
    private String f5423e;

    /* renamed from: f */
    private List<C2024a> f5424f = null;

    /* renamed from: com.xiaomi.smack.packet.h$a */
    public static class C2035a {

        /* renamed from: a */
        public static final C2035a f5425a = new C2035a("internal-server-error");

        /* renamed from: b */
        public static final C2035a f5426b = new C2035a("forbidden");

        /* renamed from: c */
        public static final C2035a f5427c = new C2035a("bad-request");

        /* renamed from: d */
        public static final C2035a f5428d = new C2035a("conflict");

        /* renamed from: e */
        public static final C2035a f5429e = new C2035a("feature-not-implemented");

        /* renamed from: f */
        public static final C2035a f5430f = new C2035a("gone");

        /* renamed from: g */
        public static final C2035a f5431g = new C2035a("item-not-found");

        /* renamed from: h */
        public static final C2035a f5432h = new C2035a("jid-malformed");

        /* renamed from: i */
        public static final C2035a f5433i = new C2035a("not-acceptable");

        /* renamed from: j */
        public static final C2035a f5434j = new C2035a("not-allowed");

        /* renamed from: k */
        public static final C2035a f5435k = new C2035a("not-authorized");

        /* renamed from: l */
        public static final C2035a f5436l = new C2035a("payment-required");

        /* renamed from: m */
        public static final C2035a f5437m = new C2035a("recipient-unavailable");

        /* renamed from: n */
        public static final C2035a f5438n = new C2035a("redirect");

        /* renamed from: o */
        public static final C2035a f5439o = new C2035a("registration-required");

        /* renamed from: p */
        public static final C2035a f5440p = new C2035a("remote-server-error");

        /* renamed from: q */
        public static final C2035a f5441q = new C2035a("remote-server-not-found");

        /* renamed from: r */
        public static final C2035a f5442r = new C2035a("remote-server-timeout");

        /* renamed from: s */
        public static final C2035a f5443s = new C2035a("resource-constraint");

        /* renamed from: t */
        public static final C2035a f5444t = new C2035a("service-unavailable");

        /* renamed from: u */
        public static final C2035a f5445u = new C2035a("subscription-required");

        /* renamed from: v */
        public static final C2035a f5446v = new C2035a("undefined-condition");

        /* renamed from: w */
        public static final C2035a f5447w = new C2035a("unexpected-request");

        /* renamed from: x */
        public static final C2035a f5448x = new C2035a("request-timeout");

        /* renamed from: y */
        private String f5449y;

        public C2035a(String str) {
            this.f5449y = str;
        }

        public String toString() {
            return this.f5449y;
        }
    }

    public C2034h(int i, String str, String str2, String str3, String str4, List<C2024a> list) {
        this.f5419a = i;
        this.f5420b = str;
        this.f5422d = str2;
        this.f5421c = str3;
        this.f5423e = str4;
        this.f5424f = list;
    }

    public C2034h(Bundle bundle) {
        this.f5419a = bundle.getInt("ext_err_code");
        if (bundle.containsKey("ext_err_type")) {
            this.f5420b = bundle.getString("ext_err_type");
        }
        this.f5421c = bundle.getString("ext_err_cond");
        this.f5422d = bundle.getString("ext_err_reason");
        this.f5423e = bundle.getString("ext_err_msg");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f5424f = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                C2024a a = C2024a.m7595a((Bundle) parcelable);
                if (a != null) {
                    this.f5424f.add(a);
                }
            }
        }
    }

    public C2034h(C2035a aVar) {
        m7668a(aVar);
        this.f5423e = null;
    }

    /* renamed from: a */
    private void m7668a(C2035a aVar) {
        this.f5421c = aVar.f5449y;
    }

    /* renamed from: a */
    public String mo10631a() {
        return this.f5422d;
    }

    /* renamed from: b */
    public String mo10632b() {
        return this.f5420b;
    }

    /* renamed from: c */
    public Bundle mo10633c() {
        Bundle bundle = new Bundle();
        if (this.f5420b != null) {
            bundle.putString("ext_err_type", this.f5420b);
        }
        bundle.putInt("ext_err_code", this.f5419a);
        if (this.f5422d != null) {
            bundle.putString("ext_err_reason", this.f5422d);
        }
        if (this.f5421c != null) {
            bundle.putString("ext_err_cond", this.f5421c);
        }
        if (this.f5423e != null) {
            bundle.putString("ext_err_msg", this.f5423e);
        }
        if (this.f5424f != null) {
            Bundle[] bundleArr = new Bundle[this.f5424f.size()];
            int i = 0;
            for (C2024a aVar : this.f5424f) {
                Bundle e = aVar.mo10573e();
                if (e != null) {
                    i++;
                    bundleArr[i] = e;
                } else {
                    i = i;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    /* renamed from: d */
    public String mo10634d() {
        StringBuilder sb = new StringBuilder();
        sb.append("<error code=\"").append(this.f5419a).append("\"");
        if (this.f5420b != null) {
            sb.append(" type=\"");
            sb.append(this.f5420b);
            sb.append("\"");
        }
        if (this.f5422d != null) {
            sb.append(" reason=\"");
            sb.append(this.f5422d);
            sb.append("\"");
        }
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        if (this.f5421c != null) {
            sb.append(SimpleComparison.LESS_THAN_OPERATION).append(this.f5421c);
            sb.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
        }
        if (this.f5423e != null) {
            sb.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
            sb.append(this.f5423e);
            sb.append("</text>");
        }
        for (C2024a aVar : mo10635e()) {
            sb.append(aVar.mo10572d());
        }
        sb.append("</error>");
        return sb.toString();
    }

    /* renamed from: e */
    public synchronized List<C2024a> mo10635e() {
        return this.f5424f == null ? Collections.emptyList() : Collections.unmodifiableList(this.f5424f);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f5421c != null) {
            sb.append(this.f5421c);
        }
        sb.append("(").append(this.f5419a).append(")");
        if (this.f5423e != null) {
            sb.append(" ").append(this.f5423e);
        }
        return sb.toString();
    }
}
