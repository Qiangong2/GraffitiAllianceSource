package com.igexin.push.core.p031d;

import android.content.Intent;
import com.igexin.push.core.C0618g;
import com.igexin.sdk.PushActivity;
import java.util.HashMap;
import java.util.Map;
import org.pwrd.paho.client.mqttv3.internal.ClientDefaults;

/* renamed from: com.igexin.push.core.d.b */
public class C0615b {

    /* renamed from: b */
    private static C0615b f1558b;

    /* renamed from: a */
    private Map<Long, AbstractC0614a> f1559a = new HashMap();

    private C0615b() {
    }

    /* renamed from: a */
    public static C0615b m2387a() {
        if (f1558b == null) {
            f1558b = new C0615b();
        }
        return f1558b;
    }

    /* renamed from: d */
    private void m2388d(AbstractC0614a aVar) {
        if (aVar != null) {
            this.f1559a.put(aVar.mo4595a(), aVar);
        }
    }

    /* renamed from: a */
    public AbstractC0614a mo4611a(Long l) {
        return this.f1559a.get(l);
    }

    /* renamed from: a */
    public void mo4612a(AbstractC0614a aVar) {
        if (aVar != null) {
            m2388d(aVar);
            Intent intent = new Intent(C0618g.f1635f, PushActivity.class);
            intent.putExtra("activityid", aVar.mo4595a());
            intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
            C0618g.f1635f.startActivity(intent);
        }
    }

    /* renamed from: b */
    public void mo4613b(AbstractC0614a aVar) {
        if (aVar != null) {
            aVar.mo4610i();
            mo4614c(aVar);
        }
    }

    /* renamed from: c */
    public void mo4614c(AbstractC0614a aVar) {
        if (aVar != null) {
            this.f1559a.remove(aVar.mo4595a());
        }
    }
}
