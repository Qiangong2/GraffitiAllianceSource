package com.xiaomi.smack;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: com.xiaomi.smack.j */
public final class C2014j {

    /* renamed from: a */
    private static int f5324a;

    /* renamed from: b */
    private static int f5325b;

    /* renamed from: c */
    private static int f5326c = 300000;

    /* renamed from: d */
    private static int f5327d = 330000;

    /* renamed from: e */
    private static Vector<String> f5328e = new Vector<>();

    static {
        f5324a = 5000;
        f5325b = 330000;
        try {
            for (ClassLoader classLoader : m7559d()) {
                Enumeration<URL> resources = classLoader.getResources("META-INF/smack-config.xml");
                while (resources.hasMoreElements()) {
                    InputStream inputStream = null;
                    try {
                        InputStream openStream = resources.nextElement().openStream();
                        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                        newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                        newPullParser.setInput(openStream, "UTF-8");
                        int eventType = newPullParser.getEventType();
                        do {
                            if (eventType == 2) {
                                if (newPullParser.getName().equals("className")) {
                                    m7556a(newPullParser);
                                } else if (newPullParser.getName().equals("packetReplyTimeout")) {
                                    f5324a = m7554a(newPullParser, f5324a);
                                } else if (newPullParser.getName().equals("keepAliveInterval")) {
                                    f5325b = m7554a(newPullParser, f5325b);
                                } else if (newPullParser.getName().equals("mechName")) {
                                    f5328e.add(newPullParser.nextText());
                                }
                            }
                            eventType = newPullParser.next();
                        } while (eventType != 1);
                        try {
                            openStream.close();
                        } catch (Exception e) {
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        try {
                            inputStream.close();
                        } catch (Exception e3) {
                        }
                    } catch (Throwable th) {
                        try {
                            inputStream.close();
                        } catch (Exception e4) {
                        }
                        throw th;
                    }
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    private C2014j() {
    }

    /* renamed from: a */
    private static int m7554a(XmlPullParser xmlPullParser, int i) {
        try {
            return Integer.parseInt(xmlPullParser.nextText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return i;
        }
    }

    /* renamed from: a */
    public static String m7555a() {
        return "3.1.0";
    }

    /* renamed from: a */
    private static void m7556a(XmlPullParser xmlPullParser) {
        String nextText = xmlPullParser.nextText();
        try {
            Class.forName(nextText);
        } catch (ClassNotFoundException e) {
            System.err.println("Error! A startup class specified in smack-config.xml could not be loaded: " + nextText);
        }
    }

    /* renamed from: b */
    public static int m7557b() {
        return f5325b;
    }

    /* renamed from: c */
    public static int m7558c() {
        return f5326c;
    }

    /* renamed from: d */
    private static ClassLoader[] m7559d() {
        ClassLoader[] classLoaderArr = {C2014j.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        ArrayList arrayList = new ArrayList();
        for (ClassLoader classLoader : classLoaderArr) {
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }
}
