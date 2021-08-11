package com.igexin.push.extension.distribution.basic.p037a;

import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.C0618g;
import com.igexin.push.p079f.p081b.AbstractC1150h;
import java.util.Map;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.igexin.push.extension.distribution.basic.a.ae */
class C0682ae extends AbstractC1150h {

    /* renamed from: a */
    final /* synthetic */ Map f1842a;

    /* renamed from: b */
    final /* synthetic */ C0681ad f1843b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0682ae(C0681ad adVar, long j, Map map) {
        super(j);
        this.f1843b = adVar;
        this.f1842a = map;
    }

    /* access modifiers changed from: protected */
    @Override // com.igexin.push.p079f.p081b.AbstractC1150h
    /* renamed from: a */
    public void mo4304a() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(C0618g.f1635f.getPackageName());
            sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
            sb.append(C0681ad.m2649a(this.f1843b, (String) this.f1842a.get("pkgName")));
            sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
            sb.append((String) this.f1842a.get("pkgName"));
            sb.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
            sb.append((String) this.f1842a.get("serviceName"));
            sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
            if (C0681ad.m2657a((String) this.f1842a.get("pkgName"), (String) this.f1842a.get("serviceName"))) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            C0681ad.m2652a(this.f1843b, C0681ad.m2648a(this.f1843b), sb.toString(), (String) this.f1842a.get("messageId"), (String) this.f1842a.get("taskId"), (String) this.f1842a.get("id"));
            ActivityC0460a.m1698b("feedback actionId=" + C0681ad.m2648a(this.f1843b) + " result=" + sb.toString());
        } catch (Exception e) {
        }
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public int mo4136b() {
        return 0;
    }
}
