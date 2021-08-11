package com.igexin.push.core.p027a.p028a;

import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.C0618g;
import com.igexin.push.p079f.p081b.AbstractC1150h;
import java.util.Map;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.igexin.push.core.a.a.k */
class C0531k extends AbstractC1150h {

    /* renamed from: a */
    final /* synthetic */ Map f1361a;

    /* renamed from: b */
    final /* synthetic */ C0530j f1362b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0531k(C0530j jVar, long j, Map map) {
        super(j);
        this.f1362b = jVar;
        this.f1361a = map;
    }

    /* access modifiers changed from: protected */
    @Override // com.igexin.push.p079f.p081b.AbstractC1150h
    /* renamed from: a */
    public void mo4304a() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(C0618g.f1635f.getPackageName());
            sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
            sb.append(C0530j.m2006a(this.f1362b, (String) this.f1361a.get("pkgName")));
            sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
            sb.append((String) this.f1361a.get("pkgName"));
            sb.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
            sb.append((String) this.f1361a.get("serviceName"));
            sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
            if (C0530j.m2014a((String) this.f1361a.get("pkgName"), (String) this.f1361a.get("serviceName"))) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            C0530j.m2009a(this.f1362b, "30026", sb.toString(), (String) this.f1361a.get("messageId"), (String) this.f1361a.get("taskId"), (String) this.f1361a.get("id"));
            ActivityC0460a.m1698b("feedback actionId=30026 result=" + sb.toString());
        } catch (Throwable th) {
        }
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public int mo4136b() {
        return 0;
    }
}
