package com.xiaomi.smack.provider;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.xiaomi.smack.packet.AbstractC2029e;
import com.xiaomi.smack.packet.C2025b;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: com.xiaomi.smack.provider.c */
public class C2038c {

    /* renamed from: a */
    private static C2038c f5450a;

    /* renamed from: b */
    private Map<String, Object> f5451b = new ConcurrentHashMap();

    /* renamed from: c */
    private Map<String, Object> f5452c = new ConcurrentHashMap();

    private C2038c() {
        mo10640b();
    }

    /* renamed from: a */
    public static synchronized C2038c m7675a() {
        C2038c cVar;
        synchronized (C2038c.class) {
            if (f5450a == null) {
                f5450a = new C2038c();
            }
            cVar = f5450a;
        }
        return cVar;
    }

    /* renamed from: b */
    private String m7676b(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(SimpleComparison.LESS_THAN_OPERATION).append(str).append("/>");
        if (str != null) {
            sb.append(SimpleComparison.LESS_THAN_OPERATION).append(str2).append("/>");
        }
        return sb.toString();
    }

    /* renamed from: c */
    private ClassLoader[] m7677c() {
        ClassLoader[] classLoaderArr = {C2038c.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        ArrayList arrayList = new ArrayList();
        for (ClassLoader classLoader : classLoaderArr) {
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }

    /* renamed from: a */
    public Object mo10638a(String str, String str2) {
        return this.f5451b.get(m7676b(str, str2));
    }

    /* renamed from: a */
    public void mo10639a(String str, String str2, Object obj) {
        if ((obj instanceof AbstractC2037b) || (obj instanceof Class)) {
            this.f5451b.put(m7676b(str, str2), obj);
            return;
        }
        throw new IllegalArgumentException("Provider must be a PacketExtensionProvider or a Class instance.");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo10640b() {
        try {
            for (ClassLoader classLoader : m7677c()) {
                Enumeration<URL> resources = classLoader.getResources("META-INF/smack.providers");
                while (resources.hasMoreElements()) {
                    InputStream inputStream = null;
                    try {
                        inputStream = resources.nextElement().openStream();
                        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                        newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                        newPullParser.setInput(inputStream, "UTF-8");
                        int eventType = newPullParser.getEventType();
                        do {
                            if (eventType == 2) {
                                if (newPullParser.getName().equals("iqProvider")) {
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText = newPullParser.nextText();
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText2 = newPullParser.nextText();
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText3 = newPullParser.nextText();
                                    String b = m7676b(nextText, nextText2);
                                    if (!this.f5452c.containsKey(b)) {
                                        try {
                                            Class<?> cls = Class.forName(nextText3);
                                            if (AbstractC2036a.class.isAssignableFrom(cls)) {
                                                this.f5452c.put(b, cls.newInstance());
                                            } else if (C2025b.class.isAssignableFrom(cls)) {
                                                this.f5452c.put(b, cls);
                                            }
                                        } catch (ClassNotFoundException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                } else if (newPullParser.getName().equals("extensionProvider")) {
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText4 = newPullParser.nextText();
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText5 = newPullParser.nextText();
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText6 = newPullParser.nextText();
                                    String b2 = m7676b(nextText4, nextText5);
                                    if (!this.f5451b.containsKey(b2)) {
                                        try {
                                            Class<?> cls2 = Class.forName(nextText6);
                                            if (AbstractC2037b.class.isAssignableFrom(cls2)) {
                                                this.f5451b.put(b2, cls2.newInstance());
                                            } else if (AbstractC2029e.class.isAssignableFrom(cls2)) {
                                                this.f5451b.put(b2, cls2);
                                            }
                                        } catch (ClassNotFoundException e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                }
                            }
                            eventType = newPullParser.next();
                        } while (eventType != 1);
                    } finally {
                        try {
                            inputStream.close();
                        } catch (Exception e3) {
                        }
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
