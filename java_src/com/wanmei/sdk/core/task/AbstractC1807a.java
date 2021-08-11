package com.wanmei.sdk.core.task;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import com.pwrd.android.volley.Response;
import com.pwrd.android.volley.VolleyError;
import com.wanmei.sdk.core.bean.CommReq;
import com.wanmei.sdk.core.net.C1775e;
import com.wanmei.sdk.core.net.C1776f;
import com.wanmei.sdk.core.util.Toast;

/* renamed from: com.wanmei.sdk.core.task.a */
public abstract class AbstractC1807a<F> {

    /* renamed from: a */
    protected Activity f4509a;

    /* renamed from: b */
    protected C1776f f4510b = new C1776f(this.f4509a);

    /* renamed from: c */
    private ProgressDialog f4511c;

    /* renamed from: d */
    private String f4512d;

    /* renamed from: e */
    private Class<F> f4513e;

    public AbstractC1807a(Activity activity, String str, Class<F> cls, String str2) {
        this.f4509a = activity;
        this.f4512d = str;
        this.f4513e = cls;
        if (str2 != null) {
            this.f4511c = new ProgressDialog(this.f4509a);
            this.f4511c.setProgressStyle(0);
            this.f4511c.setMessage(str2);
            this.f4511c.setCanceledOnTouchOutside(false);
            this.f4511c.setOnCancelListener(new DialogInterface.OnCancelListener() {
                /* class com.wanmei.sdk.core.task.AbstractC1807a.DialogInterface$OnCancelListenerC18081 */

                public void onCancel(DialogInterface dialog) {
                    AbstractC1807a.this.f4510b.mo9584a();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: e */
    private void mo9826e() {
        if (this.f4511c != null && this.f4511c.isShowing() && !this.f4509a.isFinishing()) {
            this.f4511c.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9830a() {
        if (this.f4511c != null && !this.f4511c.isShowing() && !this.f4509a.isFinishing()) {
            this.f4511c.show();
        }
        if (C1775e.m6536a(this.f4509a).mo9582a() == -1) {
            mo9826e();
            Toast.makeToastOneSDKError(this.f4509a, "网络连接不可用，请检查您当前的网络连接是否正常", -10);
            mo9824a("网络连接不可用，请检查您当前的网络连接是否正常");
            return;
        }
        mo9831b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo9821a(VolleyError volleyError);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo9823a(F f);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo9824a(String str);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo9831b() {
        this.f4510b.mo9585a(this.f4512d, mo9825d(), this.f4513e, new Response.Listener<F>() {
            /* class com.wanmei.sdk.core.task.AbstractC1807a.C18092 */

            @Override // com.pwrd.android.volley.Response.Listener
            public void onResponse(F arg0) {
                AbstractC1807a.this.mo9826e();
                AbstractC1807a.this.mo9823a((Object) arg0);
            }
        }, new Response.ErrorListener() {
            /* class com.wanmei.sdk.core.task.AbstractC1807a.C18103 */

            @Override // com.pwrd.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError arg0) {
                AbstractC1807a.this.mo9826e();
                AbstractC1807a.this.mo9821a(arg0);
            }
        });
    }

    /* renamed from: c */
    public void mo9832c() {
        mo9830a();
    }

    /* renamed from: d */
    public abstract CommReq mo9825d();
}
