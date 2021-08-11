package com.igexin.push.extension.distribution.gbd.p077j;

import android.text.TextUtils;
import com.igexin.push.extension.distribution.gbd.p066b.C1066i;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import java.io.ByteArrayInputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: com.igexin.push.extension.distribution.gbd.j.d */
public class C1135d {
    /* renamed from: a */
    public static C1066i m4650a(String str) {
        Exception e;
        C1066i iVar;
        C1066i iVar2 = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                newPullParser.setInput(new ByteArrayInputStream(str.getBytes()), "UTF-8");
                for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                    try {
                        String name = newPullParser.getName();
                        switch (eventType) {
                            case 0:
                                iVar = new C1066i();
                                break;
                            case 2:
                                if (!"id".equals(name)) {
                                    if (!"type".equals(name)) {
                                        if ("data".equals(name)) {
                                            iVar2.mo5790b(newPullParser.nextText());
                                            iVar = iVar2;
                                            break;
                                        }
                                    } else {
                                        iVar2.mo5789a(newPullParser.nextText());
                                        iVar = iVar2;
                                        break;
                                    }
                                } else {
                                    iVar2.mo5788a(Integer.parseInt(newPullParser.nextText()));
                                    iVar = iVar2;
                                    break;
                                }
                            case 1:
                            default:
                                iVar = iVar2;
                                break;
                            case 3:
                                iVar = iVar2;
                                break;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        C1115d.m4559b("GBD_XmlUtils", e.toString());
                        return iVar2;
                    }
                    try {
                        iVar2 = iVar;
                    } catch (Exception e3) {
                        iVar2 = iVar;
                        e = e3;
                        C1115d.m4559b("GBD_XmlUtils", e.toString());
                        return iVar2;
                    }
                }
            } catch (Exception e4) {
                C1115d.m4558a(e4);
                C1115d.m4559b("GBD_XmlUtils", e4.toString());
            }
        }
        return iVar2;
    }
}
