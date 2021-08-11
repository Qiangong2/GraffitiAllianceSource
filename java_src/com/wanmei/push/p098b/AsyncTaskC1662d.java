package com.wanmei.push.p098b;

import android.content.Context;
import com.pwrd.google.gson.reflect.TypeToken;
import com.wanmei.push.C1645b;
import com.wanmei.push.bean.PullAppInfo;
import com.wanmei.push.bean.StandardBaseResult;
import com.wanmei.push.p100d.C1677a;
import com.wanmei.push.p102e.C1705e;
import com.wanmei.push.p104g.C1710b;
import com.wanmei.push.p104g.C1714f;
import com.wanmei.push.p104g.C1716h;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.wanmei.push.b.d */
public final class AsyncTaskC1662d extends AbstractAsyncTaskC1667f {

    /* renamed from: b */
    private Context f4244b;

    /* renamed from: c */
    private String f4245c;

    /* renamed from: d */
    private String f4246d;

    public AsyncTaskC1662d(Context context, String str, String str2) {
        super(context);
        this.f4244b = context;
        this.f4245c = str;
        this.f4246d = str2;
    }

    /* renamed from: a */
    private PullAppInfo m6231a(String str) {
        PullAppInfo pullAppInfo;
        PullAppInfo pullAppInfo2 = new PullAppInfo();
        if (str == null) {
            return pullAppInfo2;
        }
        try {
            pullAppInfo = (PullAppInfo) C1705e.m6357a(str, new TypeToken<PullAppInfo>() {
                /* class com.wanmei.push.p098b.AsyncTaskC1662d.C16631 */
            });
        } catch (Exception e) {
            C1714f.m6376a(this.f4244b, "PERFECT_PUSH", "sendStandardPostRequest " + e.getMessage());
            pullAppInfo = pullAppInfo2;
        }
        return pullAppInfo;
    }

    /* access modifiers changed from: protected */
    @Override // com.wanmei.push.p098b.AbstractAsyncTaskC1667f
    /* renamed from: a */
    public final void mo9209a() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            /* class com.wanmei.push.p098b.AsyncTaskC1662d.C16642 */

            public final void run() {
                new AsyncTaskC1662d(AsyncTaskC1662d.this.f4244b, AsyncTaskC1662d.this.f4245c, AsyncTaskC1662d.this.f4246d).execute(new Object[0]);
                timer.cancel();
            }
        }, 60000);
    }

    /* access modifiers changed from: protected */
    @Override // com.wanmei.push.p098b.AbstractAsyncTaskC1667f
    /* renamed from: a */
    public final void mo9210a(StandardBaseResult<?> standardBaseResult) {
        if (standardBaseResult.getResult() != null) {
            try {
                PullAppInfo pullAppInfo = (PullAppInfo) standardBaseResult.getResult();
                if (pullAppInfo == null) {
                    C1645b.m6176a().mo9181a(this.f4244b, standardBaseResult, (String) null, (String) null);
                } else {
                    C1645b.m6176a().mo9181a(this.f4244b, standardBaseResult, pullAppInfo.getPushAppId(), pullAppInfo.getPushAppKey());
                }
            } catch (Exception e) {
                C1714f.m6376a(this.f4244b, "PERFECT_PUSH", "PullPushInfoTask  onSuccess" + e.getMessage());
            }
        } else {
            C1645b.m6176a().mo9181a(this.f4244b, standardBaseResult, (String) null, (String) null);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.wanmei.push.p098b.AbstractAsyncTaskC1667f
    /* renamed from: b */
    public final void mo9211b(StandardBaseResult<?> standardBaseResult) {
        C1645b.m6176a().mo9181a(this.f4244b, standardBaseResult, (String) null, (String) null);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final /* synthetic */ StandardBaseResult<?> doInBackground(Object[] objArr) {
        StandardBaseResult standardBaseResult = new StandardBaseResult();
        if (!C1716h.m6385a(this.f4244b).mo9380b()) {
            standardBaseResult.setCode(-1);
            return standardBaseResult;
        }
        C1677a.m6259a();
        StandardBaseResult<String> b = C1677a.m6263b(this.f4244b, this.f4245c, this.f4246d);
        if (b.getCode() == 1) {
            PullAppInfo a = m6231a(C1710b.m6369a(this.f4246d, b.getResult().toString()));
            StandardBaseResult standardBaseResult2 = new StandardBaseResult();
            standardBaseResult2.setResult(a);
            standardBaseResult2.setCode(b.getCode());
            standardBaseResult2.setMessage(b.getMessage());
            return standardBaseResult2;
        }
        standardBaseResult.setCode(b.getCode());
        return standardBaseResult;
    }
}
