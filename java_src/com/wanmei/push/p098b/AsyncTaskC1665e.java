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

/* renamed from: com.wanmei.push.b.e */
public final class AsyncTaskC1665e extends AbstractAsyncTaskC1667f {

    /* renamed from: b */
    private Map<String, String> f4250b;

    /* renamed from: c */
    private Context f4251c;

    public AsyncTaskC1665e(Context context, Map<String, String> map) {
        super(context);
        this.f4250b = map;
        this.f4251c = context;
    }

    /* access modifiers changed from: protected */
    @Override // com.wanmei.push.p098b.AbstractAsyncTaskC1667f
    /* renamed from: a */
    public final void mo9209a() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            /* class com.wanmei.push.p098b.AsyncTaskC1665e.C16661 */

            public final void run() {
                new AsyncTaskC1665e(AsyncTaskC1665e.this.f4251c, AsyncTaskC1665e.this.f4250b).execute(new Object[]{0});
                timer.cancel();
            }
        }, 300000);
    }

    /* access modifiers changed from: protected */
    @Override // com.wanmei.push.p098b.AbstractAsyncTaskC1667f
    /* renamed from: a */
    public final void mo9210a(StandardBaseResult<?> standardBaseResult) {
        if (this.f4250b.containsKey(Notice.MSG_ID)) {
            C1686d.m6314a(this.f4251c).mo9336a(this.f4250b.get(Notice.MSG_ID), C1687a.f4298h);
        }
        C1645b.m6176a().mo9199d(this.f4251c, standardBaseResult);
    }

    /* access modifiers changed from: protected */
    @Override // com.wanmei.push.p098b.AbstractAsyncTaskC1667f
    /* renamed from: b */
    public final void mo9211b(StandardBaseResult<?> standardBaseResult) {
        C1645b.m6176a().mo9199d(this.f4251c, standardBaseResult);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final /* synthetic */ StandardBaseResult<?> doInBackground(Object[] objArr) {
        if (this.f4250b.containsKey(Notice.MSG_ID) && this.f4250b.containsKey(Notice.IS_OFFLINE)) {
            C1686d.m6314a(this.f4251c).mo9335a(new Notice.Builder(this.f4250b.get(Notice.MSG_ID), C1687a.f4298h).isoffline(this.f4250b.get(Notice.IS_OFFLINE)).build());
        }
        if (C1716h.m6385a(this.f4251c).mo9380b()) {
            C1677a.m6259a();
            return C1677a.m6266c(this.f4251c, this.f4250b);
        }
        StandardBaseResult standardBaseResult = new StandardBaseResult();
        standardBaseResult.setCode(-1);
        return standardBaseResult;
    }
}
