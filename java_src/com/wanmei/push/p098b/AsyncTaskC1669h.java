package com.wanmei.push.p098b;

import android.content.Context;
import com.wanmei.push.C1645b;
import com.wanmei.push.bean.AppState;
import com.wanmei.push.bean.StandardBaseResult;
import com.wanmei.push.p100d.C1677a;
import com.wanmei.push.p101db.C1686d;
import com.wanmei.push.p102e.C1687a;
import com.wanmei.push.p104g.C1716h;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.wanmei.push.b.h */
public final class AsyncTaskC1669h extends AbstractAsyncTaskC1667f {

    /* renamed from: b */
    private Map<String, String> f4258b;

    /* renamed from: c */
    private Context f4259c;

    public AsyncTaskC1669h(Context context, Map<String, String> map) {
        super(context);
        this.f4258b = map;
        this.f4259c = context;
    }

    /* access modifiers changed from: protected */
    @Override // com.wanmei.push.p098b.AbstractAsyncTaskC1667f
    /* renamed from: a */
    public final void mo9209a() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            /* class com.wanmei.push.p098b.AsyncTaskC1669h.C16701 */

            public final void run() {
                new AsyncTaskC1669h(AsyncTaskC1669h.this.f4259c, AsyncTaskC1669h.this.f4258b).execute(new Object[]{0});
                timer.cancel();
            }
        }, 300000);
    }

    /* access modifiers changed from: protected */
    @Override // com.wanmei.push.p098b.AbstractAsyncTaskC1667f
    /* renamed from: a */
    public final void mo9210a(StandardBaseResult<?> standardBaseResult) {
        if (this.f4258b.containsKey(AppState.APP_ID)) {
            C1686d.m6314a(this.f4259c).mo9336a(this.f4258b.get(AppState.APP_ID), C1687a.f4297g);
        }
        C1645b.m6176a().mo9197c(this.f4259c, standardBaseResult);
    }

    /* access modifiers changed from: protected */
    @Override // com.wanmei.push.p098b.AbstractAsyncTaskC1667f
    /* renamed from: b */
    public final void mo9211b(StandardBaseResult<?> standardBaseResult) {
        C1645b.m6176a().mo9197c(this.f4259c, standardBaseResult);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final /* synthetic */ StandardBaseResult<?> doInBackground(Object[] objArr) {
        if (this.f4258b.containsKey(AppState.APP_ID) && this.f4258b.containsKey(AppState.PACKAGE_NAME) && this.f4258b.containsKey(AppState.STATE)) {
            C1686d.m6314a(this.f4259c).mo9335a(new AppState.Builder(this.f4258b.get(AppState.APP_ID), C1687a.f4297g).pkname(this.f4258b.get(AppState.PACKAGE_NAME)).state(this.f4258b.get(AppState.STATE)).build());
        }
        if (C1716h.m6385a(this.f4259c).mo9380b()) {
            C1677a.m6259a();
            return C1677a.m6258a(this.f4259c, this.f4258b);
        }
        StandardBaseResult standardBaseResult = new StandardBaseResult();
        standardBaseResult.setCode(-1);
        return standardBaseResult;
    }
}
