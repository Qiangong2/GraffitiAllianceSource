package com.xiaomi.push.service;

import com.xiaomi.smack.packet.C2024a;
import com.xiaomi.smack.provider.AbstractC2037b;
import com.xiaomi.smack.provider.C2038c;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: com.xiaomi.push.service.c */
public class C1965c implements AbstractC2037b {
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 127
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:72)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:46)
        */
    /* renamed from: a */
    public static com.xiaomi.smack.packet.C2024a m7311a(org.xmlpull.v1.XmlPullParser r9) {
        /*
        // Method dump skipped, instructions count: 111
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C1965c.m7311a(org.xmlpull.v1.XmlPullParser):com.xiaomi.smack.packet.a");
    }

    /* renamed from: a */
    public void mo10404a() {
        C2038c.m7675a().mo10639a("all", "xm:chat", this);
    }

    /* renamed from: b */
    public C2024a mo10405b(XmlPullParser xmlPullParser) {
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1 && eventType != 2) {
            eventType = xmlPullParser.next();
        }
        if (eventType == 2) {
            return m7311a(xmlPullParser);
        }
        return null;
    }
}
