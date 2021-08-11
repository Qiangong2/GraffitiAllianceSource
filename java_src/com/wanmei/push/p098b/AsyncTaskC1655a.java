package com.wanmei.push.p098b;

import android.content.Context;
import com.wanmei.push.C1645b;
import com.wanmei.push.bean.StandardBaseResult;
import com.wanmei.push.p100d.C1677a;
import com.wanmei.push.p104g.C1716h;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.wanmei.push.b.a */
public final class AsyncTaskC1655a extends AbstractAsyncTaskC1667f {

    /* renamed from: b */
    private Context f4233b;

    public AsyncTaskC1655a(Context context) {
        super(context);
        this.f4233b = context;
    }

    /* access modifiers changed from: protected */
    @Override // com.wanmei.push.p098b.AbstractAsyncTaskC1667f
    /* renamed from: a */
    public final void mo9209a() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            /* class com.wanmei.push.p098b.AsyncTaskC1655a.C16561 */

            public final void run() {
                new AsyncTaskC1655a(AsyncTaskC1655a.this.f4233b).execute(new Object[]{0});
                timer.cancel();
            }
        }, 60000);
    }

    /* access modifiers changed from: protected */
    @Override // com.wanmei.push.p098b.AbstractAsyncTaskC1667f
    /* renamed from: a */
    public final void mo9210a(StandardBaseResult<?> standardBaseResult) {
        C1645b.m6176a().mo9180a(this.f4233b, standardBaseResult);
    }

    /* access modifiers changed from: protected */
    @Override // com.wanmei.push.p098b.AbstractAsyncTaskC1667f
    /* renamed from: b */
    public final void mo9211b(StandardBaseResult<?> standardBaseResult) {
        C1645b.m6176a().mo9180a(this.f4233b, standardBaseResult);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final /* synthetic */ StandardBaseResult<?> doInBackground(Object[] objArr) {
        if (C1716h.m6385a(this.f4233b).mo9380b()) {
            C1677a.m6259a();
            return C1677a.m6262b(this.f4233b);
        }
        StandardBaseResult standardBaseResult = new StandardBaseResult();
        standardBaseResult.setCode(-1);
        return standardBaseResult;
    }
}
