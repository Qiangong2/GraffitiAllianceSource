package com.igexin.push.extension.distribution.basic.stub;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.util.DisplayMetrics;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.p012b.p022b.C0476a;
import com.igexin.push.core.C0617f;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.p028a.AbstractC0521a;
import com.igexin.push.extension.distribution.basic.p037a.C0673a;
import com.igexin.push.extension.distribution.basic.p037a.C0678aa;
import com.igexin.push.extension.distribution.basic.p037a.C0679ab;
import com.igexin.push.extension.distribution.basic.p037a.C0680ac;
import com.igexin.push.extension.distribution.basic.p037a.C0681ad;
import com.igexin.push.extension.distribution.basic.p037a.C0687c;
import com.igexin.push.extension.distribution.basic.p037a.C0691e;
import com.igexin.push.extension.distribution.basic.p037a.C0692f;
import com.igexin.push.extension.distribution.basic.p037a.C0693g;
import com.igexin.push.extension.distribution.basic.p037a.C0694h;
import com.igexin.push.extension.distribution.basic.p037a.C0695i;
import com.igexin.push.extension.distribution.basic.p037a.C0696j;
import com.igexin.push.extension.distribution.basic.p037a.C0697k;
import com.igexin.push.extension.distribution.basic.p037a.C0698l;
import com.igexin.push.extension.distribution.basic.p037a.C0700n;
import com.igexin.push.extension.distribution.basic.p037a.C0701o;
import com.igexin.push.extension.distribution.basic.p037a.C0703q;
import com.igexin.push.extension.distribution.basic.p037a.C0705s;
import com.igexin.push.extension.distribution.basic.p037a.C0707u;
import com.igexin.push.extension.distribution.basic.p037a.C0708v;
import com.igexin.push.extension.distribution.basic.p037a.C0710x;
import com.igexin.push.extension.distribution.basic.p037a.C0711y;
import com.igexin.push.extension.distribution.basic.p037a.C0712z;
import com.igexin.push.extension.distribution.basic.p037a.p038a.C0674a;
import com.igexin.push.extension.distribution.basic.p037a.p039b.C0684a;
import com.igexin.push.extension.distribution.basic.p037a.p039b.C0686c;
import com.igexin.push.extension.distribution.basic.p037a.p040c.C0688a;
import com.igexin.push.extension.distribution.basic.p042c.C0741g;
import com.igexin.push.extension.distribution.basic.p042c.C0744j;
import com.igexin.push.extension.distribution.basic.p043d.C0747b;
import com.igexin.push.extension.distribution.basic.p044e.C0749b;
import com.igexin.push.extension.distribution.basic.p045f.C0750a;
import com.igexin.push.extension.stub.IPushExtension;
import com.umeng.analytics.C1370a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class PushExtension implements IPushExtension {

    /* renamed from: a */
    private static Map<String, AbstractC0521a> f2537a;

    /* renamed from: b */
    private static C0684a f2538b;

    public PushExtension() {
        f2537a = new HashMap();
        f2537a.put("notification", new C0701o());
        f2537a.put("popup", new C0703q());
        f2537a.put("popupweb", new C0705s());
        f2537a.put("reportbindapp", new C0693g());
        f2537a.put("reportaddphoneinfo", new C0693g());
        f2537a.put("reportapplist", new C0693g());
        f2537a.put("reportapp", new C0707u());
        f2537a.put("appdownload", new C0687c());
        f2537a.put("terminatetask", new C0678aa());
        f2537a.put("uploadlog", new C0680ac());
        f2537a.put("starthome", new C0688a());
        f2537a.put("checkversions", new C0674a());
        f2537a.put("reportrecentapplist", new C0708v());
        f2537a.put("startintent", new C0711y());
        f2537a.put("startmyactivity", new C0712z());
        f2537a.put("badge", new C0692f());
        f2537a.put("manifest", new C0700n());
        f2537a.put("startanyweb", new C0710x());
        f2537a.put("wakeupsdk", new C0681ad());
        f2537a.put("uploadservice", new C0679ab());
        f2537a.put("adsmonitor", new C0673a());
        f2537a.put("checklimit", new C0697k());
        f2537a.put("appfront", new C0691e());
        f2537a.put("checkappstatus", new C0695i());
        f2537a.put("checkdebug", new C0696j());
        f2537a.put("checkphoneuse", new C0698l());
        f2537a.put("checkappcount", new C0694h());
    }

    @Override // com.igexin.push.extension.stub.IPushExtension
    public boolean executeAction(PushTaskBean pushTaskBean, BaseAction baseAction) {
        AbstractC0521a aVar;
        if (pushTaskBean == null || baseAction == null || (aVar = f2537a.get(baseAction.getType())) == null || pushTaskBean.isStop()) {
            return false;
        }
        return aVar.mo4354b(pushTaskBean, baseAction);
    }

    @Override // com.igexin.push.extension.stub.IPushExtension
    public boolean init(Context context) {
        ActivityC0460a.m1698b("EXT-PushExtension|ext init ###");
        if (context == null) {
            ActivityC0460a.m1698b("EXT-PushExtension|context = null");
            return false;
        }
        C0744j.f2042a = context;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        if (i2 > i) {
            C0744j.f2043b = i2;
            C0744j.f2044c = i;
        } else {
            C0744j.f2043b = i;
            C0744j.f2044c = i2;
        }
        C0741g.m3010a().mo5027i();
        C0741g.m3010a().mo5024f();
        C0741g.m3010a().mo5025g();
        C0744j.f2048g = new C0750a(context);
        C0749b.m3038a().mo5038b();
        if (C0744j.f2045d == null) {
            C0744j.f2045d = C0476a.m1773a(C0618g.f1635f.getPackageName() + System.currentTimeMillis());
            C0749b.m3038a().mo5035a(4, C0744j.f2045d);
        }
        try {
            if (C0744j.f2047f && Build.VERSION.SDK_INT < 21) {
                C0744j.f2050i = true;
                new C0747b(C0744j.f2042a).mo5032a();
            }
        } catch (Throwable th) {
            ActivityC0460a.m1698b("EXT-PushExtension|daemon exception : " + th.toString());
        }
        if (C0618g.f1641l) {
            C0686c.m2673a().mo4767a(C0618g.f1641l);
        }
        f2538b = new C0684a();
        context.registerReceiver(f2538b, new IntentFilter("com.igexin.sdk.action." + C0618g.f1602a));
        if (System.currentTimeMillis() - C0744j.f2049h > C1370a.f3217i) {
            ActivityC0460a.m1698b("EXT-PushExtension|init addTimerTask getConfigTask result = " + C0617f.m2395a().mo4619a(new C0993a(this, 20000)));
        }
        ActivityC0460a.m1698b("EXT-PushExtension|init addTimerTask result = " + C0617f.m2395a().mo4619a(new C0994b(this, 180000)));
        if (context.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", context.getPackageName()) == 0) {
            return true;
        }
        C0744j.f2059r = context.getCacheDir() + "/ImgCache/";
        return true;
    }

    @Override // com.igexin.push.extension.stub.IPushExtension
    public boolean isActionSupported(String str) {
        return (str == null || f2537a.get(str) == null) ? false : true;
    }

    @Override // com.igexin.push.extension.stub.IPushExtension
    public void onDestroy() {
        C0741g.m3010a().mo5028j();
        try {
            if (f2538b != null && C0618g.f1635f != null) {
                C0618g.f1635f.unregisterReceiver(f2538b);
            }
        } catch (Exception e) {
        }
    }

    @Override // com.igexin.push.extension.stub.IPushExtension
    public BaseAction parseAction(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("type")) {
            try {
                AbstractC0521a aVar = f2537a.get(jSONObject.getString("type"));
                if (aVar != null) {
                    return aVar.mo4353a(jSONObject);
                }
            } catch (Exception e) {
            }
        }
        return null;
    }

    @Override // com.igexin.push.extension.stub.IPushExtension
    public EnumC0554b prepareExecuteAction(PushTaskBean pushTaskBean, BaseAction baseAction) {
        AbstractC0521a aVar;
        return (pushTaskBean == null || baseAction == null || (aVar = f2537a.get(baseAction.getType())) == null) ? EnumC0554b.stop : aVar.mo4352a(pushTaskBean, baseAction);
    }
}
