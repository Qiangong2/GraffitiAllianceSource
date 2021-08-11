package com.wanmei.push.p098b;

import android.content.Context;
import com.wanmei.push.C1645b;
import com.wanmei.push.bean.Notice;
import com.wanmei.push.bean.StandardBaseResult;
import com.wanmei.push.p100d.C1677a;
import com.wanmei.push.p101db.C1686d;
import com.wanmei.push.p102e.C1687a;
import com.wanmei.push.p104g.C1716h;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.wanmei.push.b.b */
public final class AsyncTaskC1657b extends AbstractAsyncTaskC1667f {

    /* renamed from: b */
    private Map<String, String> f4236b;

    /* renamed from: c */
    private Context f4237c;

    public AsyncTaskC1657b(Context context, Map<String, String> map) {
        super(context);
        this.f4236b = map;
        this.f4237c = context;
    }

    /* access modifiers changed from: protected */
    @Override // com.wanmei.push.p098b.AbstractAsyncTaskC1667f
    /* renamed from: a */
    public final void mo9209a() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            /* class com.wanmei.push.p098b.AsyncTaskC1657b.C16581 */

            public final void run() {
                new AsyncTaskC1657b(AsyncTaskC1657b.this.f4237c, AsyncTaskC1657b.this.f4236b).execute(new Object[]{0});
                timer.cancel();
            }
        }, 300000);
    }

    /* access modifiers changed from: protected */
    @Override // com.wanmei.push.p098b.AbstractAsyncTaskC1667f
    /* renamed from: a */
    public final void mo9210a(StandardBaseResult<?> standardBaseResult) {
        if (this.f4236b.containsKey(Notice.MSG_ID)) {
            C1686d.m6314a(this.f4237c).mo9336a(this.f4236b.get(Notice.MSG_ID), C1687a.f4299i);
        }
        C1645b.m6176a().mo9200e(this.f4237c, standardBaseResult);
    }

    /* access modifiers changed from: protected */
    @Override // com.wanmei.push.p098b.AbstractAsyncTaskC1667f
    /* renamed from: b */
    public final void mo9211b(StandardBaseResult<?> standardBaseResult) {
        C1645b.m6176a().mo9200e(this.f4237c, standardBaseResult);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final /* synthetic */ StandardBaseResult<?> doInBackground(Object[] objArr) {
        if (this.f4236b.containsKey(Notice.MSG_ID)) {
            C1686d.m6314a(this.f4237c).mo9335a(new Notice.Builder(this.f4236b.get(Notice.MSG_ID), C1687a.f4299i).build());
        }
        if (C1716h.m6385a(this.f4237c).mo9380b()) {
            C1677a.m6259a();
            return C1677a.m6270e(this.f4237c, this.f4236b);
        }
        StandardBaseResult standardBaseResult = new StandardBaseResult();
        standardBaseResult.setCode(-1);
        return standardBaseResult;
    }
}
