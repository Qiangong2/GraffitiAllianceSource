package com.igexin.push.extension.distribution.gbd.p068d;

import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.push.extension.distribution.gbd.p071f.AbstractC1092c;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.tencent.qcloud.core.http.HttpConstants;
import com.umeng.analytics.C1370a;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.gbd.d.d */
public class C1073d implements AbstractC1092c {

    /* renamed from: a */
    final /* synthetic */ C1071b f2859a;

    C1073d(C1071b bVar) {
        this.f2859a = bVar;
    }

    @Override // com.igexin.push.extension.distribution.gbd.p071f.AbstractC1092c
    /* renamed from: a */
    public void mo5672a(Object obj) {
        List<String> list;
        if (!(obj == null || !(obj instanceof HashMap) || (list = (List) ((Map) ((HashMap) obj).get(C1370a.f3205A)).get(HttpConstants.Header.DATE)) == null)) {
            for (String str : list) {
                if (str.contains(":") && str.contains("GMT")) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy hh:mm:ss z", Locale.ENGLISH);
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                    long time = simpleDateFormat.parse(str).getTime();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis != time) {
                        C1069c.f2823E = time - currentTimeMillis;
                        C1115d.m4559b("GBD_Logic", "localTimeByServerTimeDiff  = " + C1069c.f2823E);
                    }
                }
            }
        }
    }
}
