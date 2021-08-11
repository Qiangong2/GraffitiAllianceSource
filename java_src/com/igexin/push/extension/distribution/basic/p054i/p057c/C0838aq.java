package com.igexin.push.extension.distribution.basic.p054i.p057c;

import com.igexin.push.extension.distribution.basic.p054i.p055a.C0803k;
import com.igexin.push.extension.distribution.basic.p054i.p056b.C0814j;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.basic.i.c.aq */
public class C0838aq {

    /* renamed from: a */
    StringBuilder f2348a;

    /* renamed from: b */
    AbstractC0835an f2349b;

    /* renamed from: c */
    C0831aj f2350c;

    /* renamed from: d */
    C0830ai f2351d;

    /* renamed from: e */
    private C0821a f2352e;

    /* renamed from: f */
    private C0824ac f2353f;

    /* renamed from: g */
    private EnumC0839ar f2354g = EnumC0839ar.Data;

    /* renamed from: h */
    private AbstractC0827af f2355h;

    /* renamed from: i */
    private boolean f2356i = false;

    /* renamed from: j */
    private StringBuilder f2357j = new StringBuilder();

    /* renamed from: k */
    private C0834am f2358k;

    /* renamed from: l */
    private boolean f2359l = true;

    C0838aq(C0821a aVar, C0824ac acVar) {
        this.f2352e = aVar;
        this.f2353f = acVar;
    }

    /* renamed from: b */
    private void m3644b(String str) {
        if (this.f2353f.mo5405a()) {
            this.f2353f.add(new C0823ab(this.f2352e.mo5376a(), "Invalid character reference: %s", str));
        }
    }

    /* renamed from: c */
    private void m3645c(String str) {
        if (this.f2353f.mo5405a()) {
            this.f2353f.add(new C0823ab(this.f2352e.mo5376a(), str));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public AbstractC0827af mo5470a() {
        if (!this.f2359l) {
            m3645c("Self closing flag not acknowledged");
            this.f2359l = true;
        }
        while (!this.f2356i) {
            this.f2354g.mo5489a(this, this.f2352e);
        }
        if (this.f2357j.length() > 0) {
            String sb = this.f2357j.toString();
            this.f2357j.delete(0, this.f2357j.length());
            return new C0829ah(sb);
        }
        this.f2356i = false;
        return this.f2355h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public AbstractC0835an mo5471a(boolean z) {
        this.f2349b = z ? new C0834am() : new C0833al();
        return this.f2349b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Character mo5472a(Character ch, boolean z) {
        int i;
        if (this.f2352e.mo5380b()) {
            return null;
        }
        if (ch != null && ch.charValue() == this.f2352e.mo5384c()) {
            return null;
        }
        if (this.f2352e.mo5383b('\t', '\n', '\f', ' ', '<', '&')) {
            return null;
        }
        this.f2352e.mo5392g();
        if (this.f2352e.mo5387d(MqttTopic.MULTI_LEVEL_WILDCARD)) {
            boolean e = this.f2352e.mo5389e("X");
            String l = e ? this.f2352e.mo5397l() : this.f2352e.mo5398m();
            if (l.length() == 0) {
                m3644b("numeric reference with no numerals");
                this.f2352e.mo5393h();
                return null;
            }
            if (!this.f2352e.mo5387d(";")) {
                m3644b("missing semicolon");
            }
            try {
                i = Integer.valueOf(l, e ? 16 : 10).intValue();
            } catch (NumberFormatException e2) {
                i = -1;
            }
            if (i != -1 && ((i < 55296 || i > 57343) && i <= 1114111)) {
                return Character.valueOf((char) i);
            }
            m3644b("character outside of valid range");
            return 65533;
        }
        String k = this.f2352e.mo5396k();
        String str = new String(k);
        boolean b = this.f2352e.mo5381b(';');
        String str2 = k;
        boolean z2 = false;
        while (str2.length() > 0 && !z2) {
            if (C0814j.m3493a(str2)) {
                z2 = true;
            } else {
                str2 = str2.substring(0, str2.length() - 1);
                this.f2352e.mo5388e();
            }
        }
        if (!z2) {
            if (b) {
                m3644b(String.format("invalid named referenece '%s'", str));
            }
            this.f2352e.mo5393h();
            return null;
        } else if (!z || (!this.f2352e.mo5399n() && !this.f2352e.mo5400o() && !this.f2352e.mo5383b('=', '-', '_'))) {
            if (!this.f2352e.mo5387d(";")) {
                m3644b("missing semicolon");
            }
            return C0814j.m3494b(str2);
        } else {
            this.f2352e.mo5393h();
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5473a(char c) {
        this.f2357j.append(c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5474a(AbstractC0827af afVar) {
        C0803k.m3403b(this.f2356i, "There is an unread token pending!");
        this.f2355h = afVar;
        this.f2356i = true;
        if (afVar.f2327a == EnumC0836ao.StartTag) {
            C0834am amVar = (C0834am) afVar;
            this.f2358k = amVar;
            if (amVar.f2335c) {
                this.f2359l = false;
            }
        } else if (afVar.f2327a == EnumC0836ao.EndTag && ((C0833al) afVar).f2336d.mo5287a() > 0) {
            m3645c("Attributes incorrectly present on end tag");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5475a(EnumC0839ar arVar) {
        this.f2354g = arVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5476a(String str) {
        this.f2357j.append(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5477b() {
        this.f2359l = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5478b(EnumC0839ar arVar) {
        this.f2352e.mo5390f();
        this.f2354g = arVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5479c() {
        this.f2349b.mo5448n();
        mo5474a(this.f2349b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5480c(EnumC0839ar arVar) {
        if (this.f2353f.mo5405a()) {
            this.f2353f.add(new C0823ab(this.f2352e.mo5376a(), "Unexpected character '%s' in input state [%s]", Character.valueOf(this.f2352e.mo5384c()), arVar));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo5481d() {
        this.f2351d = new C0830ai();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo5482d(EnumC0839ar arVar) {
        if (this.f2353f.mo5405a()) {
            this.f2353f.add(new C0823ab(this.f2352e.mo5376a(), "Unexpectedly reached end of file (EOF) in input state [%s]", arVar));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo5483e() {
        mo5474a(this.f2351d);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo5484f() {
        this.f2350c = new C0831aj();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo5485g() {
        mo5474a(this.f2350c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo5486h() {
        this.f2348a = new StringBuilder();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo5487i() {
        if (this.f2358k == null) {
            return false;
        }
        return this.f2349b.f2334b.equals(this.f2358k.f2334b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public String mo5488j() {
        return this.f2358k.f2334b;
    }
}
