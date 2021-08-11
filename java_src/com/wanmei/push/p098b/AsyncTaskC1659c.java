package com.wanmei.push.p098b;

import android.content.Context;
import com.pwrd.google.gson.reflect.TypeToken;
import com.wanmei.push.C1645b;
import com.wanmei.push.bean.CertificateInfo;
import com.wanmei.push.bean.StandardBaseResult;
import com.wanmei.push.p100d.C1677a;
import com.wanmei.push.p100d.C1679c;
import com.wanmei.push.p102e.C1705e;
import com.wanmei.push.p104g.C1710b;
import com.wanmei.push.p104g.C1714f;
import com.wanmei.push.p104g.C1716h;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.wanmei.push.b.c */
public final class AsyncTaskC1659c extends AbstractAsyncTaskC1667f {

    /* renamed from: b */
    private Context f4240b;

    public AsyncTaskC1659c(Context context) {
        super(context);
        this.f4240b = context;
    }

    /* renamed from: a */
    private CertificateInfo m6226a(String str) {
        CertificateInfo certificateInfo;
        CertificateInfo certificateInfo2 = new CertificateInfo();
        if (str == null) {
            return certificateInfo2;
        }
        try {
            certificateInfo = (CertificateInfo) C1705e.m6357a(str, new TypeToken<CertificateInfo>() {
                /* class com.wanmei.push.p098b.AsyncTaskC1659c.C16601 */
            });
        } catch (Exception e) {
            C1714f.m6376a(this.f4240b, "PERFECT_PUSH", "sendStandardPostRequest " + e.getMessage());
            certificateInfo = certificateInfo2;
        }
        return certificateInfo;
    }

    /* access modifiers changed from: protected */
    @Override // com.wanmei.push.p098b.AbstractAsyncTaskC1667f
    /* renamed from: a */
    public final void mo9209a() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            /* class com.wanmei.push.p098b.AsyncTaskC1659c.C16612 */

            public final void run() {
                new AsyncTaskC1659c(AsyncTaskC1659c.this.f4240b).execute(new Object[]{0});
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
                CertificateInfo certificateInfo = (CertificateInfo) standardBaseResult.getResult();
                if (certificateInfo == null) {
                    C1645b.m6176a().mo9196b(this.f4240b, standardBaseResult, null, null);
                } else {
                    C1645b.m6176a().mo9196b(this.f4240b, standardBaseResult, certificateInfo.getXmAppId(), certificateInfo.getXmAppKey());
                }
            } catch (Exception e) {
                C1714f.m6376a(this.f4240b, "PERFECT_PUSH", "PullCertificateTask  onSuccess" + e.getMessage());
            }
        } else {
            C1645b.m6176a().mo9196b(this.f4240b, standardBaseResult, null, null);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.wanmei.push.p098b.AbstractAsyncTaskC1667f
    /* renamed from: b */
    public final void mo9211b(StandardBaseResult<?> standardBaseResult) {
        C1645b.m6176a().mo9196b(this.f4240b, standardBaseResult, null, null);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final /* synthetic */ StandardBaseResult<?> doInBackground(Object[] objArr) {
        StandardBaseResult standardBaseResult = new StandardBaseResult();
        if (!C1716h.m6385a(this.f4240b).mo9380b()) {
            standardBaseResult.setCode(-1);
            return standardBaseResult;
        }
        C1677a.m6259a();
        StandardBaseResult<String> c = C1677a.m6265c(this.f4240b);
        if (c.getCode() == 1) {
            C1679c.m6277a();
            CertificateInfo a = m6226a(C1710b.m6369a(C1679c.m6283b(this.f4240b).getAppClientSecret(), c.getResult().toString()));
            StandardBaseResult standardBaseResult2 = new StandardBaseResult();
            standardBaseResult2.setResult(a);
            standardBaseResult2.setCode(c.getCode());
            standardBaseResult2.setMessage(c.getMessage());
            return standardBaseResult2;
        }
        standardBaseResult.setCode(c.getCode());
        return standardBaseResult;
    }
}
