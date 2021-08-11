package com.xiaomi.smack.util;

import android.text.TextUtils;
import com.umeng.analytics.C1370a;
import com.umeng.analytics.p091b.C1447g;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.push.service.C1948ac;
import com.xiaomi.push.service.C1965c;
import com.xiaomi.push.service.C1987w;
import com.xiaomi.smack.AbstractC2002a;
import com.xiaomi.smack.C2015k;
import com.xiaomi.smack.C2023p;
import com.xiaomi.smack.packet.AbstractC2028d;
import com.xiaomi.smack.packet.C2024a;
import com.xiaomi.smack.packet.C2025b;
import com.xiaomi.smack.packet.C2027c;
import com.xiaomi.smack.packet.C2030f;
import com.xiaomi.smack.packet.C2033g;
import com.xiaomi.smack.packet.C2034h;
import com.xiaomi.smack.provider.C2038c;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: com.xiaomi.smack.util.c */
public class C2041c {

    /* renamed from: a */
    private static XmlPullParser f5457a = null;

    /* renamed from: a */
    public static C2024a m7686a(String str, String str2, XmlPullParser xmlPullParser) {
        Object a = C2038c.m7675a().mo10638a("all", "xm:chat");
        if (a == null || !(a instanceof C1965c)) {
            return null;
        }
        return ((C1965c) a).mo10405b(xmlPullParser);
    }

    /* renamed from: a */
    public static C2025b m7687a(XmlPullParser xmlPullParser, AbstractC2002a aVar) {
        String attributeValue = xmlPullParser.getAttributeValue("", "id");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "to");
        String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
        String attributeValue4 = xmlPullParser.getAttributeValue("", "chid");
        C2025b.C2026a a = C2025b.C2026a.m7614a(xmlPullParser.getAttributeValue("", "type"));
        HashMap hashMap = new HashMap();
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            hashMap.put(attributeName, xmlPullParser.getAttributeValue("", attributeName));
        }
        boolean z = false;
        C2034h hVar = null;
        C2025b bVar = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals(C1447g.f3469aF)) {
                    hVar = m7693e(xmlPullParser);
                } else {
                    bVar = new C2025b();
                    bVar.mo10606a(m7686a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("iq")) {
                z = true;
            }
            hVar = hVar;
            bVar = bVar;
            z = z;
        }
        if (bVar == null) {
            if (C2025b.C2026a.f5366a == a || C2025b.C2026a.f5367b == a) {
                C2042d dVar = new C2042d();
                dVar.mo10610k(attributeValue);
                dVar.mo10614m(attributeValue3);
                dVar.mo10616n(attributeValue2);
                dVar.mo10577a(C2025b.C2026a.f5369d);
                dVar.mo10612l(attributeValue4);
                dVar.mo10607a(new C2034h(C2034h.C2035a.f5429e));
                aVar.mo10499a(dVar);
                AbstractC1855b.m6723d("iq usage error. send packet in packet parser.");
                return null;
            }
            bVar = new C2043e();
        }
        bVar.mo10610k(attributeValue);
        bVar.mo10614m(attributeValue2);
        bVar.mo10612l(attributeValue4);
        bVar.mo10616n(attributeValue3);
        bVar.mo10577a(a);
        bVar.mo10607a(hVar);
        bVar.mo10579a(hashMap);
        return bVar;
    }

    /* renamed from: a */
    public static AbstractC2028d m7688a(XmlPullParser xmlPullParser) {
        String str;
        if ("1".equals(xmlPullParser.getAttributeValue("", "s"))) {
            String attributeValue = xmlPullParser.getAttributeValue("", "chid");
            String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
            String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
            String attributeValue4 = xmlPullParser.getAttributeValue("", "to");
            String attributeValue5 = xmlPullParser.getAttributeValue("", "type");
            C1987w.C1989b b = C1987w.m7406a().mo10435b(attributeValue, attributeValue4);
            C1987w.C1989b b2 = b == null ? C1987w.m7406a().mo10435b(attributeValue, attributeValue3) : b;
            if (b2 == null) {
                throw new C2023p("the channel id is wrong while receiving a encrypted message");
            }
            boolean z = false;
            AbstractC2028d dVar = null;
            while (!z) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    if (!"s".equals(xmlPullParser.getName())) {
                        throw new C2023p("error while receiving a encrypted message with wrong format");
                    } else if (xmlPullParser.next() != 4) {
                        throw new C2023p("error while receiving a encrypted message with wrong format");
                    } else {
                        String text = xmlPullParser.getText();
                        if ("5".equals(attributeValue) || "6".equals(attributeValue)) {
                            C2027c cVar = new C2027c();
                            cVar.mo10612l(attributeValue);
                            cVar.mo10589b(true);
                            cVar.mo10616n(attributeValue3);
                            cVar.mo10614m(attributeValue4);
                            cVar.mo10610k(attributeValue2);
                            cVar.mo10597f(attributeValue5);
                            C2024a aVar = new C2024a("s", null, null, null);
                            aVar.mo10570b(text);
                            cVar.mo10606a(aVar);
                            return cVar;
                        }
                        m7689a(C1948ac.m7263b(C1948ac.m7260a(b2.f5135i, attributeValue2), text));
                        f5457a.next();
                        dVar = m7688a(f5457a);
                    }
                } else if (next == 3 && xmlPullParser.getName().equals("message")) {
                    z = true;
                }
            }
            if (dVar != null) {
                return dVar;
            }
            throw new C2023p("error while receiving a encrypted message with wrong format");
        }
        C2027c cVar2 = new C2027c();
        String attributeValue6 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue6 == null) {
            attributeValue6 = "ID_NOT_AVAILABLE";
        }
        cVar2.mo10610k(attributeValue6);
        cVar2.mo10614m(xmlPullParser.getAttributeValue("", "to"));
        cVar2.mo10616n(xmlPullParser.getAttributeValue("", "from"));
        cVar2.mo10612l(xmlPullParser.getAttributeValue("", "chid"));
        cVar2.mo10584a(xmlPullParser.getAttributeValue("", "appid"));
        try {
            str = xmlPullParser.getAttributeValue("", "transient");
        } catch (Exception e) {
            str = null;
        }
        try {
            String attributeValue7 = xmlPullParser.getAttributeValue("", "seq");
            if (!TextUtils.isEmpty(attributeValue7)) {
                cVar2.mo10588b(attributeValue7);
            }
        } catch (Exception e2) {
        }
        try {
            String attributeValue8 = xmlPullParser.getAttributeValue("", "mseq");
            if (!TextUtils.isEmpty(attributeValue8)) {
                cVar2.mo10590c(attributeValue8);
            }
        } catch (Exception e3) {
        }
        try {
            String attributeValue9 = xmlPullParser.getAttributeValue("", "fseq");
            if (!TextUtils.isEmpty(attributeValue9)) {
                cVar2.mo10592d(attributeValue9);
            }
        } catch (Exception e4) {
        }
        try {
            String attributeValue10 = xmlPullParser.getAttributeValue("", "status");
            if (!TextUtils.isEmpty(attributeValue10)) {
                cVar2.mo10594e(attributeValue10);
            }
        } catch (Exception e5) {
        }
        cVar2.mo10586a(!TextUtils.isEmpty(str) && str.equalsIgnoreCase("true"));
        cVar2.mo10597f(xmlPullParser.getAttributeValue("", "type"));
        String g = m7695g(xmlPullParser);
        if (g == null || "".equals(g.trim())) {
            AbstractC2028d.m7638u();
        } else {
            cVar2.mo10605j(g);
        }
        String str2 = null;
        boolean z2 = false;
        while (!z2) {
            int next2 = xmlPullParser.next();
            if (next2 == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (TextUtils.isEmpty(namespace)) {
                    namespace = "xm";
                }
                if (name.equals("subject")) {
                    if (m7695g(xmlPullParser) == null) {
                    }
                    cVar2.mo10599g(m7694f(xmlPullParser));
                } else if (name.equals(C1370a.f3234z)) {
                    String attributeValue11 = xmlPullParser.getAttributeValue("", "encode");
                    String f = m7694f(xmlPullParser);
                    if (!TextUtils.isEmpty(attributeValue11)) {
                        cVar2.mo10585a(f, attributeValue11);
                    } else {
                        cVar2.mo10601h(f);
                    }
                } else if (name.equals("thread")) {
                    if (str2 == null) {
                        str2 = xmlPullParser.nextText();
                    }
                } else if (name.equals(C1447g.f3469aF)) {
                    cVar2.mo10607a(m7693e(xmlPullParser));
                } else {
                    cVar2.mo10606a(m7686a(name, namespace, xmlPullParser));
                }
            } else if (next2 == 3 && xmlPullParser.getName().equals("message")) {
                z2 = true;
            }
        }
        cVar2.mo10604i(str2);
        return cVar2;
    }

    /* renamed from: a */
    private static void m7689a(byte[] bArr) {
        if (f5457a == null) {
            try {
                f5457a = XmlPullParserFactory.newInstance().newPullParser();
                f5457a.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
        }
        f5457a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
    }

    /* renamed from: b */
    public static C2030f m7690b(XmlPullParser xmlPullParser) {
        C2030f.EnumC2032b bVar = C2030f.EnumC2032b.available;
        String attributeValue = xmlPullParser.getAttributeValue("", "type");
        if (attributeValue != null && !attributeValue.equals("")) {
            try {
                bVar = C2030f.EnumC2032b.valueOf(attributeValue);
            } catch (IllegalArgumentException e) {
                System.err.println("Found invalid presence type " + attributeValue);
            }
        }
        C2030f fVar = new C2030f(bVar);
        fVar.mo10614m(xmlPullParser.getAttributeValue("", "to"));
        fVar.mo10616n(xmlPullParser.getAttributeValue("", "from"));
        fVar.mo10612l(xmlPullParser.getAttributeValue("", "chid"));
        String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue2 == null) {
            attributeValue2 = "ID_NOT_AVAILABLE";
        }
        fVar.mo10610k(attributeValue2);
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("status")) {
                    fVar.mo10629a(xmlPullParser.nextText());
                } else if (name.equals("priority")) {
                    try {
                        fVar.mo10626a(Integer.parseInt(xmlPullParser.nextText()));
                    } catch (NumberFormatException e2) {
                    } catch (IllegalArgumentException e3) {
                        fVar.mo10626a(0);
                    }
                } else if (name.equals("show")) {
                    String nextText = xmlPullParser.nextText();
                    try {
                        fVar.mo10627a(C2030f.EnumC2031a.valueOf(nextText));
                    } catch (IllegalArgumentException e4) {
                        System.err.println("Found invalid presence mode " + nextText);
                    }
                } else if (name.equals(C1447g.f3469aF)) {
                    fVar.mo10607a(m7693e(xmlPullParser));
                } else {
                    fVar.mo10606a(m7686a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("presence")) {
                z = true;
            }
        }
        return fVar;
    }

    /* renamed from: c */
    public static C2015k.C2017b m7691c(XmlPullParser xmlPullParser) {
        C2015k.C2017b bVar = new C2015k.C2017b();
        String attributeValue = xmlPullParser.getAttributeValue("", "id");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "to");
        String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
        String attributeValue4 = xmlPullParser.getAttributeValue("", "chid");
        C2015k.C2017b.C2018a a = C2015k.C2017b.C2018a.m7565a(xmlPullParser.getAttributeValue("", "type"));
        bVar.mo10610k(attributeValue);
        bVar.mo10614m(attributeValue2);
        bVar.mo10616n(attributeValue3);
        bVar.mo10612l(attributeValue4);
        bVar.mo10547a(a);
        boolean z = false;
        C2034h hVar = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals(C1447g.f3469aF)) {
                    hVar = m7693e(xmlPullParser);
                }
            } else if (next == 3 && xmlPullParser.getName().equals("bind")) {
                z = true;
            }
        }
        bVar.mo10607a(hVar);
        return bVar;
    }

    /* renamed from: d */
    public static C2033g m7692d(XmlPullParser xmlPullParser) {
        C2033g gVar = null;
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                gVar = new C2033g(xmlPullParser.getName());
            } else if (next == 3 && xmlPullParser.getName().equals(C1447g.f3469aF)) {
                z = true;
            }
        }
        return gVar;
    }

    /* renamed from: e */
    public static C2034h m7693e(XmlPullParser xmlPullParser) {
        ArrayList arrayList = new ArrayList();
        String str = null;
        String str2 = null;
        String str3 = "-1";
        int i = 0;
        while (i < xmlPullParser.getAttributeCount()) {
            String attributeValue = xmlPullParser.getAttributeName(i).equals("code") ? xmlPullParser.getAttributeValue("", "code") : str3;
            String attributeValue2 = xmlPullParser.getAttributeName(i).equals("type") ? xmlPullParser.getAttributeValue("", "type") : str2;
            if (xmlPullParser.getAttributeName(i).equals("reason")) {
                str = xmlPullParser.getAttributeValue("", "reason");
            }
            i++;
            str2 = attributeValue2;
            str3 = attributeValue;
        }
        boolean z = false;
        String str4 = null;
        String str5 = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("text")) {
                    str5 = xmlPullParser.nextText();
                } else {
                    String name = xmlPullParser.getName();
                    String namespace = xmlPullParser.getNamespace();
                    if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(namespace)) {
                        str4 = name;
                    } else {
                        arrayList.add(m7686a(name, namespace, xmlPullParser));
                    }
                }
            } else if (next == 3) {
                if (xmlPullParser.getName().equals(C1447g.f3469aF)) {
                    z = true;
                }
            } else if (next == 4) {
                str5 = xmlPullParser.getText();
            }
        }
        return new C2034h(Integer.parseInt(str3), str2 == null ? "cancel" : str2, str, str4, str5, arrayList);
    }

    /* renamed from: f */
    private static String m7694f(XmlPullParser xmlPullParser) {
        String str = "";
        int depth = xmlPullParser.getDepth();
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getDepth() == depth) {
                return str;
            }
            str = str + xmlPullParser.getText();
        }
    }

    /* renamed from: g */
    private static String m7695g(XmlPullParser xmlPullParser) {
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if ("xml:lang".equals(attributeName) || ("lang".equals(attributeName) && "xml".equals(xmlPullParser.getAttributePrefix(i)))) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }
}
