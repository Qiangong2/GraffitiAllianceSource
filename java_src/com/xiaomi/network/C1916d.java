package com.xiaomi.network;

import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.common.logger.thrift.mfs.C1878b;
import com.xiaomi.network.UploadHostStatHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import org.apache.thrift.C2164f;

/* access modifiers changed from: package-private */
/* renamed from: com.xiaomi.network.d */
public class C1916d extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ UploadHostStatHelper f4924a;

    C1916d(UploadHostStatHelper uploadHostStatHelper) {
        this.f4924a = uploadHostStatHelper;
    }

    public void run() {
        ArrayList<UploadHostStatHelper.HttpRecordCallback> arrayList = new ArrayList();
        synchronized (this.f4924a) {
            arrayList.addAll(this.f4924a.f4914a);
        }
        for (UploadHostStatHelper.HttpRecordCallback httpRecordCallback : arrayList) {
            List<C1878b> a = httpRecordCallback.mo10293a();
            double b = httpRecordCallback.mo10294b();
            if (a != null) {
                try {
                    if (a.size() > 0) {
                        this.f4924a.m7080a((UploadHostStatHelper) a, (List) b);
                    }
                } catch (C2164f e) {
                    AbstractC1855b.m6718a("uploadHostStat exception" + e.toString());
                }
            }
        }
        this.f4924a.f4917d = false;
    }
}
