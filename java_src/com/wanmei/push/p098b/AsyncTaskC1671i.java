package com.wanmei.push.p098b;

import android.content.Context;
import com.wanmei.push.C1645b;
import com.wanmei.push.bean.StandardBaseResult;
import com.wanmei.push.p100d.C1677a;
import com.wanmei.push.p104g.C1716h;

/* renamed from: com.wanmei.push.b.i */
public final class AsyncTaskC1671i extends AbstractAsyncTaskC1667f {

    /* renamed from: b */
    private Context f4262b;

    public AsyncTaskC1671i(Context context) {
        super(context);
        this.f4262b = context;
    }

    /* access modifiers changed from: protected */
    @Override // com.wanmei.push.p098b.AbstractAsyncTaskC1667f
    /* renamed from: a */
    public final void mo9210a(StandardBaseResult<?> standardBaseResult) {
        C1645b.m6176a().mo9195b(this.f4262b, standardBaseResult);
    }

    /* access modifiers changed from: protected */
    @Override // com.wanmei.push.p098b.AbstractAsyncTaskC1667f
    /* renamed from: b */
    public final void mo9211b(StandardBaseResult<?> standardBaseResult) {
        C1645b.m6176a().mo9195b(this.f4262b, standardBaseResult);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final /* synthetic */ StandardBaseResult<?> doInBackground(Object[] objArr) {
        if (C1716h.m6385a(this.f4262b).mo9380b()) {
            C1677a.m6259a();
            return C1677a.m6269e(this.f4262b);
        }
        StandardBaseResult standardBaseResult = new StandardBaseResult();
        standardBaseResult.setCode(-1);
        return standardBaseResult;
    }
}
