package com.igexin.push.extension.distribution.gbd.p061a.p063b;

import android.app.ActivityManager;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.igexin.push.extension.distribution.gbd.p076i.C1116e;
import com.igexin.push.p079f.p081b.AbstractC1150h;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.gbd.a.b.j */
public final class C1038j extends AbstractC1150h {

    /* renamed from: a */
    final /* synthetic */ Map f2643a;

    /* renamed from: b */
    final /* synthetic */ int f2644b;

    /* renamed from: c */
    final /* synthetic */ int f2645c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1038j(long j, Map map, int i, int i2) {
        super(j);
        this.f2643a = map;
        this.f2644b = i;
        this.f2645c = i2;
    }

    /* access modifiers changed from: protected */
    @Override // com.igexin.push.p079f.p081b.AbstractC1150h
    /* renamed from: a */
    public void mo4304a() {
        try {
            List list = (List) this.f2643a.get("checkList");
            if (list != null) {
                List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) C1069c.f2824a.getSystemService("activity")).getRunningServices(2000);
                HashMap hashMap = new HashMap();
                for (int i = 0; i < list.size(); i++) {
                    hashMap.put(list.get(i), Boolean.valueOf(C1116e.m4573a((String) list.get(i), this.f2643a.get("pkgName").toString(), runningServices)));
                }
                C1115d.m4557a(this.f1093l, "runing service = " + hashMap.toString());
                if (hashMap.toString().contains("true")) {
                    C1069c.f2826c.post(new RunnableC1039k(this));
                } else if (this.f2645c == 0) {
                    C1037i.m4197a(this.f2643a, 1, this.f2644b);
                } else if (this.f2645c == 1) {
                    C1037i.m4197a(this.f2643a, 2, this.f2644b);
                } else {
                    C1115d.m4559b(this.f1093l, "guard failed type = " + this.f2644b + " pkg = " + this.f2643a.get("pkgName").toString());
                }
            }
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public int mo4136b() {
        return 0;
    }
}
