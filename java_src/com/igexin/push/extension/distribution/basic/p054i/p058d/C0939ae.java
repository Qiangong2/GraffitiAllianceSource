package com.igexin.push.extension.distribution.basic.p054i.p058d;

import com.igexin.push.extension.distribution.basic.p054i.p055a.C0802j;
import com.igexin.push.extension.distribution.basic.p054i.p055a.C0803k;
import com.igexin.push.extension.distribution.basic.p054i.p057c.C0837ap;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.basic.i.d.ae */
public class C0939ae {

    /* renamed from: a */
    private static final String[] f2480a = {MiPushClient.ACCEPT_TIME_SEPARATOR, SimpleComparison.GREATER_THAN_OPERATION, MqttTopic.SINGLE_LEVEL_WILDCARD, "~", " "};

    /* renamed from: b */
    private C0837ap f2481b;

    /* renamed from: c */
    private String f2482c;

    /* renamed from: d */
    private List<AbstractC0955g> f2483d = new ArrayList();

    private C0939ae(String str) {
        this.f2482c = str;
        this.f2481b = new C0837ap(str);
    }

    /* renamed from: a */
    public static AbstractC0955g m3862a(String str) {
        return new C0939ae(str).mo5562a();
    }

    /* renamed from: a */
    private void m3863a(char c) {
        AbstractC0955g dVar;
        boolean z;
        AbstractC0955g gVar;
        C0953e eVar;
        C0952d dVar2;
        this.f2481b.mo5465e();
        AbstractC0955g a = m3862a(m3865b());
        if (this.f2483d.size() == 1) {
            dVar = this.f2483d.get(0);
            if (!(dVar instanceof C0953e) || c == ',') {
                z = false;
                gVar = dVar;
            } else {
                z = true;
                gVar = dVar;
                dVar = ((C0953e) dVar).mo5569a();
            }
        } else {
            dVar = new C0952d(this.f2483d);
            z = false;
            gVar = dVar;
        }
        this.f2483d.clear();
        if (c == '>') {
            dVar2 = new C0952d(a, new C0944aj(dVar));
        } else if (c == ' ') {
            dVar2 = new C0952d(a, new C0947am(dVar));
        } else if (c == '+') {
            dVar2 = new C0952d(a, new C0945ak(dVar));
        } else if (c == '~') {
            dVar2 = new C0952d(a, new C0948an(dVar));
        } else if (c == ',') {
            if (dVar instanceof C0953e) {
                eVar = (C0953e) dVar;
                eVar.mo5572b(a);
            } else {
                C0953e eVar2 = new C0953e();
                eVar2.mo5572b(dVar);
                eVar2.mo5572b(a);
                eVar = eVar2;
            }
            dVar2 = eVar;
        } else {
            throw new C0941ag("Unknown combinator: " + c, new Object[0]);
        }
        if (z) {
            ((C0953e) gVar).mo5570a(dVar2);
        } else {
            gVar = dVar2;
        }
        this.f2483d.add(gVar);
    }

    /* renamed from: a */
    private void m3864a(boolean z) {
        this.f2481b.mo5460c(z ? ":containsOwn" : ":contains");
        String f = C0837ap.m3625f(this.f2481b.mo5452a('(', ')'));
        C0803k.m3396a(f, ":contains(text) query must not be empty");
        if (z) {
            this.f2483d.add(new C0967s(f));
        } else {
            this.f2483d.add(new C0968t(f));
        }
    }

    /* renamed from: b */
    private String m3865b() {
        StringBuilder sb = new StringBuilder();
        while (!this.f2481b.mo5453a()) {
            if (this.f2481b.mo5454a("(")) {
                sb.append("(").append(this.f2481b.mo5452a('(', ')')).append(")");
            } else if (this.f2481b.mo5454a("[")) {
                sb.append("[").append(this.f2481b.mo5452a('[', ']')).append("]");
            } else if (this.f2481b.mo5456a(f2480a)) {
                break;
            } else {
                sb.append(this.f2481b.mo5462d());
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    private void m3866b(boolean z) {
        this.f2481b.mo5460c(z ? ":matchesOwn" : ":matches");
        String a = this.f2481b.mo5452a('(', ')');
        C0803k.m3396a(a, ":matches(regex) query must not be empty");
        if (z) {
            this.f2483d.add(new C0935aa(Pattern.compile(a)));
        } else {
            this.f2483d.add(new C0974z(Pattern.compile(a)));
        }
    }

    /* renamed from: c */
    private void m3867c() {
        if (this.f2481b.mo5459b(MqttTopic.MULTI_LEVEL_WILDCARD)) {
            m3868d();
        } else if (this.f2481b.mo5459b(".")) {
            m3869e();
        } else if (this.f2481b.mo5461c()) {
            m3870f();
        } else if (this.f2481b.mo5454a("[")) {
            m3871g();
        } else if (this.f2481b.mo5459b("*")) {
            m3872h();
        } else if (this.f2481b.mo5459b(":lt(")) {
            m3873i();
        } else if (this.f2481b.mo5459b(":gt(")) {
            m3874j();
        } else if (this.f2481b.mo5459b(":eq(")) {
            m3875k();
        } else if (this.f2481b.mo5454a(":has(")) {
            m3877m();
        } else if (this.f2481b.mo5454a(":contains(")) {
            m3864a(false);
        } else if (this.f2481b.mo5454a(":containsOwn(")) {
            m3864a(true);
        } else if (this.f2481b.mo5454a(":matches(")) {
            m3866b(false);
        } else if (this.f2481b.mo5454a(":matchesOwn(")) {
            m3866b(true);
        } else if (this.f2481b.mo5454a(":not(")) {
            m3878n();
        } else {
            throw new C0941ag("Could not parse query '%s': unexpected token at '%s'", this.f2482c, this.f2481b.mo5468h());
        }
    }

    /* renamed from: d */
    private void m3868d() {
        String g = this.f2481b.mo5467g();
        C0803k.m3395a(g);
        this.f2483d.add(new C0969u(g));
    }

    /* renamed from: e */
    private void m3869e() {
        String g = this.f2481b.mo5467g();
        C0803k.m3395a(g);
        this.f2483d.add(new C0966r(g.trim().toLowerCase()));
    }

    /* renamed from: f */
    private void m3870f() {
        String f = this.f2481b.mo5466f();
        C0803k.m3395a(f);
        if (f.contains("|")) {
            f = f.replace("|", ":");
        }
        this.f2483d.add(new C0936ab(f.trim().toLowerCase()));
    }

    /* renamed from: g */
    private void m3871g() {
        C0837ap apVar = new C0837ap(this.f2481b.mo5452a('[', ']'));
        String b = apVar.mo5457b(SimpleComparison.EQUAL_TO_OPERATION, "!=", "^=", "$=", "*=", "~=");
        C0803k.m3395a(b);
        apVar.mo5465e();
        if (apVar.mo5453a()) {
            if (b.startsWith("^")) {
                this.f2483d.add(new C0959k(b.substring(1)));
            } else {
                this.f2483d.add(new C0957i(b));
            }
        } else if (apVar.mo5459b(SimpleComparison.EQUAL_TO_OPERATION)) {
            this.f2483d.add(new C0960l(b, apVar.mo5468h()));
        } else if (apVar.mo5459b("!=")) {
            this.f2483d.add(new C0964p(b, apVar.mo5468h()));
        } else if (apVar.mo5459b("^=")) {
            this.f2483d.add(new C0965q(b, apVar.mo5468h()));
        } else if (apVar.mo5459b("$=")) {
            this.f2483d.add(new C0962n(b, apVar.mo5468h()));
        } else if (apVar.mo5459b("*=")) {
            this.f2483d.add(new C0961m(b, apVar.mo5468h()));
        } else if (apVar.mo5459b("~=")) {
            this.f2483d.add(new C0963o(b, Pattern.compile(apVar.mo5468h())));
        } else {
            throw new C0941ag("Could not parse attribute query '%s': unexpected token at '%s'", this.f2482c, apVar.mo5468h());
        }
    }

    /* renamed from: h */
    private void m3872h() {
        this.f2483d.add(new C0956h());
    }

    /* renamed from: i */
    private void m3873i() {
        this.f2483d.add(new C0973y(m3876l()));
    }

    /* renamed from: j */
    private void m3874j() {
        this.f2483d.add(new C0972x(m3876l()));
    }

    /* renamed from: k */
    private void m3875k() {
        this.f2483d.add(new C0970v(m3876l()));
    }

    /* renamed from: l */
    private int m3876l() {
        String trim = this.f2481b.mo5464e(")").trim();
        C0803k.m3398a(C0802j.m3391b(trim), "Index must be numeric");
        return Integer.parseInt(trim);
    }

    /* renamed from: m */
    private void m3877m() {
        this.f2481b.mo5460c(":has");
        String a = this.f2481b.mo5452a('(', ')');
        C0803k.m3396a(a, ":has(el) subselect must not be empty");
        this.f2483d.add(new C0943ai(m3862a(a)));
    }

    /* renamed from: n */
    private void m3878n() {
        this.f2481b.mo5460c(":not");
        String a = this.f2481b.mo5452a('(', ')');
        C0803k.m3396a(a, ":not(selector) subselect must not be empty");
        this.f2483d.add(new C0946al(m3862a(a)));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public AbstractC0955g mo5562a() {
        this.f2481b.mo5465e();
        if (this.f2481b.mo5456a(f2480a)) {
            this.f2483d.add(new C0949ao());
            m3863a(this.f2481b.mo5462d());
        } else {
            m3867c();
        }
        while (!this.f2481b.mo5453a()) {
            boolean e = this.f2481b.mo5465e();
            if (this.f2481b.mo5456a(f2480a)) {
                m3863a(this.f2481b.mo5462d());
            } else if (e) {
                m3863a(' ');
            } else {
                m3867c();
            }
        }
        return this.f2483d.size() == 1 ? this.f2483d.get(0) : new C0952d(this.f2483d);
    }
}
