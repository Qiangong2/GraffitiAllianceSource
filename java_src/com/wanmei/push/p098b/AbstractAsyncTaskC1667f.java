package com.wanmei.push.p098b;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.wanmei.push.bean.StandardBaseResult;
import com.wanmei.push.p104g.C1714f;

/* renamed from: com.wanmei.push.b.f */
public abstract class AbstractAsyncTaskC1667f extends AsyncTask<Object, Object, StandardBaseResult<?>> {

    /* renamed from: a */
    public static final String f4254a = AbstractAsyncTaskC1667f.class.getSimpleName();

    /* renamed from: b */
    private Context f4255b;

    /* renamed from: c */
    private Dialog f4256c;

    public AbstractAsyncTaskC1667f(Context context) {
        this(context, (byte) 0);
    }

    private AbstractAsyncTaskC1667f(Context context, byte b) {
        this.f4255b = context;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9209a() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9210a(StandardBaseResult<?> standardBaseResult) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo9211b(StandardBaseResult<?> standardBaseResult) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public /* synthetic */ void onPostExecute(StandardBaseResult<?> standardBaseResult) {
        StandardBaseResult<?> standardBaseResult2 = standardBaseResult;
        if (this.f4256c != null && this.f4256c.isShowing()) {
            this.f4256c.dismiss();
        }
        if (this.f4255b == null) {
            return;
        }
        if (standardBaseResult2 == null) {
            mo9209a();
            return;
        }
        switch (standardBaseResult2.getCode()) {
            case -1:
                C1714f.m6376a(this.f4255b, "PERFECT_PUSH", "HttpResponseCode.NETWORK_ERROR");
                mo9209a();
                return;
            case 0:
            default:
                C1714f.m6376a(this.f4255b, "PERFECT_PUSH", "HttpResponseCode.default");
                if (standardBaseResult2 != null) {
                    TextUtils.isEmpty(standardBaseResult2.getMessage());
                }
                mo9211b(standardBaseResult2);
                return;
            case 1:
                C1714f.m6376a(this.f4255b, "PERFECT_PUSH", "HttpResponseCode.SUCCEED");
                mo9210a(standardBaseResult2);
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        if (this.f4255b == null) {
            cancel(true);
        }
    }
}
