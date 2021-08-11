package com.igexin.push.extension.distribution.basic.p060k;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p031d.AbstractC0614a;
import com.igexin.push.extension.distribution.basic.p041b.C0727o;
import com.igexin.push.extension.distribution.basic.util.C0997c;
import com.igexin.push.extension.distribution.basic.util.webview.PushWebExtension;

/* renamed from: com.igexin.push.extension.distribution.basic.k.i */
public class C0989i extends AbstractC0614a {

    /* renamed from: d */
    private WebView f2527d;

    /* renamed from: e */
    private PushTaskBean f2528e;

    /* renamed from: f */
    private C0727o f2529f;

    public C0989i(PushTaskBean pushTaskBean, C0727o oVar) {
        this.f2528e = pushTaskBean;
        this.f2529f = oVar;
        mo4599a((Long) 11111111L);
        mo4600a(pushTaskBean.getTaskId());
    }

    /* renamed from: j */
    private void m3970j() {
        this.f2527d = new WebView(this.f1556b.getApplicationContext());
        this.f2527d.setBackgroundResource(17170443);
        this.f1556b.setContentView(this.f2527d);
        this.f2527d.setScrollBarStyle(33554432);
        this.f2527d.setWebViewClient(new C0990j(this));
        this.f2527d.setOnKeyListener(new View$OnKeyListenerC0991k(this));
        WebSettings settings = this.f2527d.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        String a = this.f2529f.mo4971a();
        if (this.f2529f.mo4975b()) {
            a = this.f2529f.mo4976c();
        }
        this.f2527d.addJavascriptInterface(new PushWebExtension(this.f1556b, this.f2528e), "sdk");
        this.f2527d.loadUrl(a);
    }

    @Override // com.igexin.push.core.p031d.AbstractC0614a
    /* renamed from: a */
    public void mo4597a(Intent intent) {
    }

    @Override // com.igexin.push.core.p031d.AbstractC0614a
    /* renamed from: a */
    public void mo4598a(Configuration configuration) {
    }

    @Override // com.igexin.push.core.p031d.AbstractC0614a
    /* renamed from: a */
    public boolean mo4601a(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.igexin.push.core.p031d.AbstractC0614a
    /* renamed from: a */
    public boolean mo4602a(Menu menu) {
        return false;
    }

    @Override // com.igexin.push.core.p031d.AbstractC0614a
    /* renamed from: c */
    public void mo4604c() {
        m3970j();
    }

    @Override // com.igexin.push.core.p031d.AbstractC0614a
    /* renamed from: d */
    public void mo4605d() {
    }

    @Override // com.igexin.push.core.p031d.AbstractC0614a
    /* renamed from: e */
    public void mo4606e() {
    }

    @Override // com.igexin.push.core.p031d.AbstractC0614a
    /* renamed from: f */
    public void mo4607f() {
    }

    @Override // com.igexin.push.core.p031d.AbstractC0614a
    /* renamed from: g */
    public void mo4608g() {
        if (this.f1556b != null && !this.f1556b.isFinishing() && !C0997c.m4003b()) {
            this.f1556b.finish();
        }
    }

    @Override // com.igexin.push.core.p031d.AbstractC0614a
    /* renamed from: h */
    public void mo4609h() {
    }

    @Override // com.igexin.push.core.p031d.AbstractC0614a
    /* renamed from: i */
    public void mo4610i() {
        if (this.f1556b != null && !this.f1556b.isFinishing()) {
            this.f1556b.finish();
        }
    }
}
