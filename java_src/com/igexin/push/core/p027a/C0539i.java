package com.igexin.push.core.p027a;

import android.content.Intent;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.C0618g;
import com.igexin.push.p079f.p081b.AbstractC1150h;
import org.pwrd.paho.client.mqttv3.internal.ClientDefaults;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.core.a.i */
public class C0539i extends AbstractC1150h {

    /* renamed from: a */
    final /* synthetic */ String f1372a;

    /* renamed from: b */
    final /* synthetic */ String f1373b;

    /* renamed from: c */
    final /* synthetic */ C0535e f1374c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0539i(C0535e eVar, long j, String str, String str2) {
        super(j);
        this.f1374c = eVar;
        this.f1372a = str;
        this.f1373b = str2;
    }

    /* access modifiers changed from: protected */
    @Override // com.igexin.push.p079f.p081b.AbstractC1150h
    /* renamed from: a */
    public void mo4304a() {
        boolean z = false;
        try {
            Intent intent = new Intent();
            intent.setClassName(this.f1372a, "com.igexin.sdk.GActivity");
            intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
            C0618g.f1635f.startActivity(intent);
            z = true;
            ActivityC0460a.m1698b(this.f1093l + "|startActivity success pkg = " + this.f1372a + " activityName = " + "com.igexin.sdk.GActivity");
        } catch (Exception e) {
            ActivityC0460a.m1698b(this.f1093l + "|startActivity exception pkg = " + this.f1372a + " activityName = " + "com.igexin.sdk.GActivity" + " " + e.toString());
        }
        if (!z) {
            this.f1374c.m2044e(this.f1372a, this.f1373b);
        }
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public int mo4136b() {
        return 0;
    }
}
