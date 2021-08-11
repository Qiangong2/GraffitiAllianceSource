package com.xiaomi.smack;

import android.text.TextUtils;
import com.igexin.assist.sdk.AssistPushConsts;
import com.umeng.analytics.p091b.C1447g;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.channel.commonutils.string.C1871b;
import com.xiaomi.push.service.C1987w;
import com.xiaomi.smack.packet.AbstractC2028d;
import com.xiaomi.smack.packet.C2024a;
import com.xiaomi.smack.packet.C2034h;
import com.xiaomi.smack.util.C2045g;
import java.util.HashMap;

/* renamed from: com.xiaomi.smack.k */
public class C2015k {

    /* renamed from: com.xiaomi.smack.k$a */
    public class C2016a extends AbstractC2028d {
        public C2016a(C1987w.C1989b bVar, String str, AbstractC2002a aVar) {
            String str2;
            String str3;
            HashMap hashMap = new HashMap();
            int i = aVar.mo10515i();
            hashMap.put("challenge", str);
            hashMap.put(AssistPushConsts.MSG_TYPE_TOKEN, bVar.f5129c);
            hashMap.put("chid", bVar.f5134h);
            hashMap.put("from", bVar.f5128b);
            hashMap.put("id", mo10609k());
            hashMap.put("to", "xiaomi.com");
            if (bVar.f5131e) {
                hashMap.put("kick", "1");
            } else {
                hashMap.put("kick", "0");
            }
            if (aVar.mo10517k() > 0) {
                String format = String.format("conn:%1$d,t:%2$d", Integer.valueOf(i), Long.valueOf(aVar.mo10517k()));
                hashMap.put("pf", format);
                aVar.mo10516j();
                aVar.mo10518l();
                str2 = format;
            } else {
                str2 = null;
            }
            if (!TextUtils.isEmpty(bVar.f5132f)) {
                hashMap.put("client_attrs", bVar.f5132f);
            } else {
                hashMap.put("client_attrs", "");
            }
            if (!TextUtils.isEmpty(bVar.f5133g)) {
                hashMap.put("cloud_attrs", bVar.f5133g);
            } else {
                hashMap.put("cloud_attrs", "");
            }
            if (bVar.f5130d.equals("XIAOMI-PASS") || bVar.f5130d.equals("XMPUSH-PASS")) {
                str3 = C1871b.m6777a(bVar.f5130d, null, hashMap, bVar.f5135i);
            } else {
                if (bVar.f5130d.equals("XIAOMI-SASL")) {
                }
                str3 = null;
            }
            mo10612l(bVar.f5134h);
            mo10616n(bVar.f5128b);
            mo10614m("xiaomi.com");
            mo10618o(bVar.f5127a);
            C2024a aVar2 = new C2024a(AssistPushConsts.MSG_TYPE_TOKEN, null, null, null);
            aVar2.mo10570b(bVar.f5129c);
            mo10606a(aVar2);
            C2024a aVar3 = new C2024a("kick", null, null, null);
            aVar3.mo10570b(bVar.f5131e ? "1" : "0");
            mo10606a(aVar3);
            C2024a aVar4 = new C2024a("sig", null, null, null);
            aVar4.mo10570b(str3);
            mo10606a(aVar4);
            C2024a aVar5 = new C2024a("method", null, null, null);
            if (!TextUtils.isEmpty(bVar.f5130d)) {
                aVar5.mo10570b(bVar.f5130d);
            } else {
                aVar5.mo10570b("XIAOMI-SASL");
            }
            mo10606a(aVar5);
            C2024a aVar6 = new C2024a("client_attrs", null, null, null);
            aVar6.mo10570b(bVar.f5132f == null ? "" : C2045g.m7700a(bVar.f5132f));
            mo10606a(aVar6);
            C2024a aVar7 = new C2024a("cloud_attrs", null, null, null);
            aVar7.mo10570b(bVar.f5133g == null ? "" : C2045g.m7700a(bVar.f5133g));
            mo10606a(aVar7);
            if (!TextUtils.isEmpty(str2)) {
                C2024a aVar8 = new C2024a("pf", null, null, null);
                aVar8.mo10570b(str2);
                mo10606a(aVar8);
            }
        }

        @Override // com.xiaomi.smack.packet.AbstractC2028d
        /* renamed from: a */
        public String mo10546a() {
            StringBuilder sb = new StringBuilder();
            sb.append("<bind ");
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
                sb.append("chid=\"").append(C2045g.m7700a(mo10611l())).append("\">");
            }
            if (mo10622q() != null) {
                for (C2024a aVar : mo10622q()) {
                    sb.append(aVar.mo10572d());
                }
            }
            sb.append("</bind>");
            return sb.toString();
        }
    }

    /* renamed from: com.xiaomi.smack.k$b */
    public static class C2017b extends AbstractC2028d {

        /* renamed from: a */
        private C2018a f5330a;

        /* renamed from: com.xiaomi.smack.k$b$a */
        public static class C2018a {

            /* renamed from: a */
            public static final C2018a f5331a = new C2018a("result");

            /* renamed from: b */
            public static final C2018a f5332b = new C2018a(C1447g.f3469aF);

            /* renamed from: c */
            private String f5333c;

            private C2018a(String str) {
                this.f5333c = str;
            }

            /* renamed from: a */
            public static C2018a m7565a(String str) {
                if (str == null) {
                    return null;
                }
                String lowerCase = str.toLowerCase();
                if (f5332b.toString().equals(lowerCase)) {
                    return f5332b;
                }
                if (f5331a.toString().equals(lowerCase)) {
                    return f5331a;
                }
                return null;
            }

            public String toString() {
                return this.f5333c;
            }
        }

        @Override // com.xiaomi.smack.packet.AbstractC2028d
        /* renamed from: a */
        public String mo10546a() {
            StringBuilder sb = new StringBuilder();
            sb.append("<bind ");
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
                sb.append(" chid=\"").append(C2045g.m7700a(mo10611l())).append("\" ");
            }
            if (this.f5330a == null) {
                sb.append("type=\"result\">");
            } else {
                sb.append("type=\"").append(mo10548b()).append("\">");
            }
            if (mo10622q() != null) {
                for (C2024a aVar : mo10622q()) {
                    sb.append(aVar.mo10572d());
                }
            }
            C2034h p = mo10620p();
            if (p != null) {
                sb.append(p.mo10634d());
            }
            sb.append("</bind>");
            return sb.toString();
        }

        /* renamed from: a */
        public void mo10547a(C2018a aVar) {
            if (aVar == null) {
                this.f5330a = C2018a.f5331a;
            } else {
                this.f5330a = aVar;
            }
        }

        /* renamed from: b */
        public C2018a mo10548b() {
            return this.f5330a;
        }
    }

    /* renamed from: a */
    public void mo10545a(C1987w.C1989b bVar, String str, AbstractC2002a aVar) {
        C2016a aVar2 = new C2016a(bVar, str, aVar);
        aVar.mo10499a(aVar2);
        AbstractC1855b.m6718a("SMACK: bind id=" + aVar2.mo10609k());
    }
}
