package com.xiaomi.smack;

import com.umeng.analytics.p091b.C1447g;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.smack.AbstractC2002a;
import com.xiaomi.smack.packet.AbstractC2028d;
import com.xiaomi.smack.packet.C2025b;
import com.xiaomi.smack.util.C2041c;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: com.xiaomi.smack.g */
public class C2011g {

    /* renamed from: a */
    private Thread f5317a;

    /* renamed from: b */
    private C2019l f5318b;

    /* renamed from: c */
    private XmlPullParser f5319c;

    /* renamed from: d */
    private boolean f5320d;

    protected C2011g(C2019l lVar) {
        this.f5318b = lVar;
        mo10534a();
    }

    /* renamed from: a */
    private void m7540a(AbstractC2028d dVar) {
        if (dVar != null) {
            for (AbstractC2002a.C2003a aVar : this.f5318b.f5293e.values()) {
                aVar.mo10524a(dVar);
            }
        }
    }

    /* renamed from: e */
    private void m7541e() {
        this.f5319c = XmlPullParserFactory.newInstance().newPullParser();
        this.f5319c.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        this.f5319c.setInput(this.f5318b.f5296h);
    }

    /* access modifiers changed from: public */
    /* renamed from: f */
    private void m7542f() {
        try {
            m7541e();
            int eventType = this.f5319c.getEventType();
            String str = "";
            do {
                this.f5318b.mo10521o();
                if (eventType == 2) {
                    String name = this.f5319c.getName();
                    if (this.f5319c.getName().equals("message")) {
                        m7540a(C2041c.m7688a(this.f5319c));
                        str = name;
                    } else if (this.f5319c.getName().equals("iq")) {
                        m7540a(C2041c.m7687a(this.f5319c, this.f5318b));
                        str = name;
                    } else if (this.f5319c.getName().equals("presence")) {
                        m7540a(C2041c.m7690b(this.f5319c));
                        str = name;
                    } else if (this.f5319c.getName().equals("stream")) {
                        String str2 = "";
                        for (int i = 0; i < this.f5319c.getAttributeCount(); i++) {
                            if (this.f5319c.getAttributeName(i).equals("from")) {
                                this.f5318b.f5300l.mo10525a(this.f5319c.getAttributeValue(i));
                            } else if (this.f5319c.getAttributeName(i).equals("challenge")) {
                                str2 = this.f5319c.getAttributeValue(i);
                            } else if ("ps".equals(this.f5319c.getAttributeName(i))) {
                                String attributeValue = this.f5319c.getAttributeValue(i);
                                C2025b bVar = new C2025b();
                                bVar.mo10612l("0");
                                bVar.mo10610k("0");
                                bVar.mo10578a("ps", attributeValue);
                                bVar.mo10577a(C2025b.C2026a.f5367b);
                                m7540a(bVar);
                            }
                        }
                        this.f5318b.mo10501a(str2);
                        str = name;
                    } else if (this.f5319c.getName().equals(C1447g.f3469aF)) {
                        throw new C2023p(C2041c.m7692d(this.f5319c));
                    } else {
                        if (this.f5319c.getName().equals("warning")) {
                            this.f5319c.next();
                            if (this.f5319c.getName().equals("multi-login")) {
                                mo10535a(6, null);
                                str = name;
                            }
                        } else if (this.f5319c.getName().equals("bind")) {
                            m7540a(C2041c.m7691c(this.f5319c));
                            str = name;
                        }
                        str = name;
                    }
                } else if (eventType == 3 && this.f5319c.getName().equals("stream")) {
                    mo10535a(13, null);
                }
                eventType = this.f5319c.next();
                if (this.f5320d) {
                    break;
                }
            } while (eventType != 1);
            if (eventType == 1) {
                throw new Exception("SMACK: server close the connection or timeout happened, last element name=" + str + " host=" + this.f5318b.mo10509c());
            }
        } catch (Exception e) {
            AbstractC1855b.m6720a(e);
            if (!this.f5320d) {
                mo10535a(9, e);
            } else {
                AbstractC1855b.m6722c("reader is shutdown, ignore the exception.");
            }
        }
    }

    /* renamed from: a */
    public void mo10534a() {
        this.f5320d = false;
        this.f5317a = new C2012h(this, "Smack Packet Reader (" + this.f5318b.f5299k + ")");
    }

    /* renamed from: a */
    public void mo10535a(int i, Exception exc) {
        this.f5320d = true;
        this.f5318b.mo10550a(i, exc);
    }

    /* renamed from: b */
    public void mo10536b() {
        this.f5317a.start();
    }

    /* renamed from: c */
    public void mo10537c() {
        this.f5320d = true;
    }

    /* renamed from: d */
    public void mo10538d() {
        this.f5318b.f5293e.clear();
    }
}
