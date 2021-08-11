package com.igexin.push.core.p027a;

import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.p012b.p013a.p020d.AbstractC0470d;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.p032d.p035c.C0638a;
import com.igexin.push.p032d.p035c.C0640c;
import com.igexin.push.p079f.p081b.C1144b;

/* renamed from: com.igexin.push.core.a.d */
public class C0534d extends AbstractC0520a {
    /* renamed from: a */
    private void m2027a(String str, C0638a aVar) {
        if (str != null) {
            String substring = str.substring("CDN".length(), str.length());
            if (substring.contains("@")) {
                String[] split = substring.split("\\@");
                String str2 = split[0];
                if (split[1].contains("|")) {
                    String[] split2 = split[1].split("\\|");
                    String str3 = split2[0];
                    String str4 = split2[1];
                    if (str2 != null && str3 != null && str4 != null) {
                        PushTaskBean pushTaskBean = new PushTaskBean();
                        pushTaskBean.setAppid(C0618g.f1602a);
                        pushTaskBean.setMessageId(str2);
                        pushTaskBean.setTaskId(str3);
                        pushTaskBean.setId(str2);
                        pushTaskBean.setAppKey(C0618g.f1631b);
                        pushTaskBean.setCurrentActionid(1);
                        C0535e.m2034a().mo4367a(pushTaskBean);
                        C0535e.m2034a().mo4371a(str4, aVar, pushTaskBean);
                    }
                }
            }
        }
    }

    @Override // com.igexin.push.core.p027a.AbstractC0520a
    /* renamed from: a */
    public boolean mo4350a(AbstractC0470d dVar) {
        return super.mo4350a(dVar);
    }

    @Override // com.igexin.push.core.p027a.AbstractC0520a
    /* renamed from: a */
    public boolean mo4351a(Object obj) {
        C1144b e;
        if (!(obj instanceof C0638a)) {
            return true;
        }
        C0638a aVar = (C0638a) obj;
        if (aVar.f1696c == null) {
            return true;
        }
        String str = (String) aVar.f1696c;
        ActivityC0460a.m1698b("cdnpushmessage|" + str);
        if (str.startsWith("RCV")) {
            String substring = str.substring("RCV".length(), str.length());
            if (!C0618g.f1615ak.containsKey(substring)) {
                return true;
            }
            C0640c cVar = C0618g.f1615ak.get(substring);
            C0618g.f1615ak.remove(substring);
            if (cVar == null || (e = cVar.mo4692e()) == null) {
                return true;
            }
            e.mo4207u();
            return true;
        } else if (!str.contains("CDN")) {
            return true;
        } else {
            m2027a(str, aVar);
            return true;
        }
    }
}
