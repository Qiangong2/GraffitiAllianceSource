package com.xiaomi.network;

import com.xiaomi.common.logger.thrift.mfs.C1878b;
import com.xiaomi.network.UploadHostStatHelper;
import java.util.List;
import org.json.JSONException;

/* renamed from: com.xiaomi.network.a */
class C1913a implements UploadHostStatHelper.HttpRecordCallback {

    /* renamed from: a */
    final /* synthetic */ HostManager f4919a;

    C1913a(HostManager hostManager) {
        this.f4919a = hostManager;
    }

    @Override // com.xiaomi.network.UploadHostStatHelper.HttpRecordCallback
    /* renamed from: a */
    public List<C1878b> mo10293a() {
        try {
            return this.f4919a.generateHostStats();
        } catch (JSONException e) {
            return null;
        }
    }

    @Override // com.xiaomi.network.UploadHostStatHelper.HttpRecordCallback
    /* renamed from: b */
    public double mo10294b() {
        Fallback fallbacksByHost = this.f4919a.getFallbacksByHost("f3.mi-stat.gslb.mi-idc.com");
        if (fallbacksByHost != null) {
            return fallbacksByHost.mo10246g();
        }
        return 0.1d;
    }
}
