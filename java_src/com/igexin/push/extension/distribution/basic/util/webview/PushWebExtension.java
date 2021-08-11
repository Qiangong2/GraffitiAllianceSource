package com.igexin.push.extension.distribution.basic.util.webview;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.extension.distribution.basic.p041b.C0714b;
import com.igexin.push.extension.distribution.basic.p042c.C0741g;
import com.igexin.push.extension.distribution.basic.p042c.C0744j;
import com.igexin.push.extension.distribution.basic.p046g.C0752a;
import com.igexin.push.extension.distribution.basic.p046g.p047a.C0753a;
import com.igexin.push.extension.distribution.basic.p046g.p049c.C0760a;
import com.igexin.push.extension.distribution.basic.p053h.C0768a;
import com.igexin.push.extension.distribution.basic.p053h.C0771d;
import com.igexin.push.extension.distribution.basic.util.C0997c;
import org.pwrd.paho.client.mqttv3.internal.ClientDefaults;

public class PushWebExtension {

    /* renamed from: a */
    Activity f2568a;

    /* renamed from: b */
    private PushTaskBean f2569b;

    /* renamed from: c */
    private String f2570c;

    /* renamed from: d */
    private String f2571d;

    public PushWebExtension(Activity activity, PushTaskBean pushTaskBean) {
        this.f2568a = activity;
        this.f2569b = pushTaskBean;
        this.f2570c = pushTaskBean.getTaskId();
        this.f2571d = pushTaskBean.getMessageId();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4073a(C0714b bVar) {
        if (bVar.mo4786a() != null) {
            C0752a a = C0752a.m3056a(C0744j.f2042a, "ext_download.db");
            C0753a aVar = new C0753a(new C0760a());
            aVar.mo5065a(bVar);
            a.mo5057a(aVar);
            C0535e.m2034a().mo4368a(this.f2569b, "10050");
        }
    }

    @JavascriptInterface
    public void appdownload(String str, String str2, String str3, String str4, boolean z, boolean z2) {
        try {
            C0714b bVar = new C0714b();
            bVar.mo4798d(str3);
            bVar.mo4789a(str);
            bVar.mo4792b(str2);
            bVar.setActionId("10050");
            bVar.mo4801e(str4);
            bVar.setDoActionId("100");
            bVar.mo4793b(z);
            bVar.mo4790a(z2);
            bVar.mo4802e(true);
            bVar.mo4803f(str4);
            bVar.setType("appdownload");
            bVar.mo4788a(this.f2569b);
            if (str2 == null || !str2.startsWith("http") || !C0741g.m3010a().mo5015a(str2).equals("")) {
                m4073a(bVar);
            } else {
                prepareExecuteAction(str2, this.f2570c, this.f2571d, bVar, 1);
            }
        } catch (Throwable th) {
        }
    }

    @JavascriptInterface
    public void close() {
        this.f2568a.finish();
    }

    @JavascriptInterface
    public void dial(String str) {
        try {
            Intent intent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + str));
            intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
            this.f2568a.startActivity(intent);
            C0535e.m2034a().mo4368a(this.f2569b, "10140");
        } catch (SecurityException e) {
        }
    }

    public void prepareExecuteAction(String str, String str2, String str3, BaseAction baseAction, int i) {
        C0768a aVar = new C0768a(new C0771d(str, str, str2, baseAction, i, new C1017d(this, baseAction, str, str2, str3, i)));
        ((C0714b) baseAction).mo4787a(((C0714b) baseAction).mo4813l() + 1);
        C0456c.m1661b().mo4216a(aVar, false, true);
    }

    @JavascriptInterface
    public void startapp(String str, boolean z, String str2, String str3) {
        boolean z2 = true;
        PackageManager packageManager = this.f2568a.getPackageManager();
        if (str.equals("")) {
            str = C0618g.f1602a;
        } else if (!C0618g.f1602a.equals(str)) {
            z2 = false;
        }
        if (z2) {
            C0535e.m2034a().mo4373a(this.f2570c, this.f2571d, str, str3);
            if (z) {
                this.f2568a.startActivity(packageManager.getLaunchIntentForPackage(this.f2568a.getPackageName()));
            }
        } else {
            C0535e.m2034a().mo4373a(this.f2570c, this.f2571d, str, str3);
            if (z && C0997c.m4004b(str2)) {
                C0618g.f1635f.startActivity(packageManager.getLaunchIntentForPackage(str2));
            }
        }
        C0535e.m2034a().mo4368a(this.f2569b, "10030");
    }

    @JavascriptInterface
    public void startweb(String str, boolean z) {
        if (z) {
            str = str.indexOf("?") > 0 ? str + "&cid=" + C0618g.f1647r : str + "?cid=" + C0618g.f1647r;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
            intent.setData(Uri.parse(str));
            this.f2568a.startActivity(intent);
        } catch (Exception e) {
        }
        C0535e.m2034a().mo4368a(this.f2569b, "10040");
    }
}
