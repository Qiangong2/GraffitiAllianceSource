package com.wanmei.push;

import android.content.Context;
import android.text.TextUtils;
import com.wanmei.push.bean.AppInfo;
import com.wanmei.push.bean.DeviceInfo;
import com.wanmei.push.bean.OneSDKInfo;
import com.wanmei.push.bean.StandardBaseResult;
import com.wanmei.push.p100d.C1677a;
import com.wanmei.push.p100d.C1679c;
import com.wanmei.push.p104g.C1714f;
import com.wanmei.push.p104g.C1716h;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.wanmei.push.b */
public final class C1645b {

    /* renamed from: l */
    private static C1645b f4217l = new C1645b();

    /* renamed from: a */
    protected DeviceInfo f4218a;

    /* renamed from: b */
    protected OneSDKInfo f4219b;

    /* renamed from: c */
    protected AppInfo f4220c;

    /* renamed from: d */
    protected AbstractC1649c f4221d;

    /* renamed from: e */
    protected AbstractC1647a f4222e;

    /* renamed from: f */
    protected AbstractC1654h f4223f;

    /* renamed from: g */
    protected AbstractC1652f f4224g;

    /* renamed from: h */
    protected AbstractC1648b f4225h;

    /* renamed from: i */
    protected AbstractC1653g f4226i;

    /* renamed from: j */
    protected AbstractC1651e f4227j;

    /* renamed from: k */
    protected AbstractC1650d f4228k;

    /* renamed from: m */
    private AtomicInteger f4229m = new AtomicInteger(5);

    /* renamed from: com.wanmei.push.b$a */
    public interface AbstractC1647a {
        /* renamed from: a */
        void mo9160a();

        /* renamed from: a */
        void mo9161a(int i);
    }

    /* renamed from: com.wanmei.push.b$b */
    public interface AbstractC1648b {
        /* renamed from: a */
        void mo9166a(int i);

        /* renamed from: a */
        void mo9167a(String str, String str2);
    }

    /* renamed from: com.wanmei.push.b$c */
    public interface AbstractC1649c {
        /* renamed from: a */
        void mo9158a(int i);

        /* renamed from: a */
        void mo9159a(String str, String str2);
    }

    /* renamed from: com.wanmei.push.b$d */
    public interface AbstractC1650d {
        /* renamed from: a */
        void mo9203a();

        /* renamed from: b */
        void mo9204b();
    }

    /* renamed from: com.wanmei.push.b$e */
    public interface AbstractC1651e {
        /* renamed from: a */
        void mo9205a();

        /* renamed from: b */
        void mo9206b();
    }

    /* renamed from: com.wanmei.push.b$f */
    public interface AbstractC1652f {
        /* renamed from: a */
        void mo9164a();

        /* renamed from: a */
        void mo9165a(StandardBaseResult<?> standardBaseResult);
    }

    /* renamed from: com.wanmei.push.b$g */
    public interface AbstractC1653g {
        /* renamed from: a */
        void mo9207a();

        /* renamed from: b */
        void mo9208b();
    }

    /* renamed from: com.wanmei.push.b$h */
    public interface AbstractC1654h {
        /* renamed from: a */
        void mo9162a();

        /* renamed from: b */
        void mo9163b();
    }

    /* renamed from: a */
    public static C1645b m6176a() {
        return f4217l;
    }

    /* renamed from: a */
    public final DeviceInfo mo9179a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("getDeviceInfo's context is null");
        }
        if (this.f4218a == null) {
            C1679c.m6277a();
            this.f4218a = C1679c.m6276a(context);
        }
        return this.f4218a;
    }

    /* renamed from: a */
    public final void mo9180a(final Context context, StandardBaseResult<?> standardBaseResult) {
        int code = standardBaseResult.getCode();
        switch (code) {
            case 1:
                C1714f.m6376a(context, "PERFECT_PUSH", "ResponseCode.PLATFORM_AUTH_SUCCESS");
                break;
            default:
                C1714f.m6376a(context, "PERFECT_PUSH", "Default");
                break;
        }
        if (this.f4222e == null) {
            C1714f.m6383c(context, "PERFECT_PUSH", "OnAUTHListener is null");
        } else if (code == 1) {
            this.f4222e.mo9160a();
        } else if (this.f4229m.decrementAndGet() > 0) {
            final Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                /* class com.wanmei.push.C1645b.C16461 */

                public final void run() {
                    C1677a.m6259a();
                    C1677a.m6260a(context);
                    timer.cancel();
                }
            }, 30000);
        } else {
            this.f4222e.mo9161a(code);
        }
    }

    /* renamed from: a */
    public final void mo9181a(Context context, StandardBaseResult<?> standardBaseResult, String str, String str2) {
        int code = standardBaseResult.getCode();
        switch (code) {
            case 1:
                C1714f.m6376a(context, "PERFECT_PUSH", "ResponseCode.PLATFORM_PULL_APPINFO_SUCCESS");
                break;
            default:
                C1714f.m6376a(context, "PERFECT_PUSH", "Default");
                break;
        }
        if (this.f4221d == null) {
            C1714f.m6383c(context, "PERFECT_PUSH", "OnAUTHListener is null");
        } else if (code != 1 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            this.f4221d.mo9158a(code);
        } else {
            this.f4221d.mo9159a(str, str2);
        }
    }

    /* renamed from: a */
    public final void mo9182a(Context context, String str, String str2, String str3) {
        if (this.f4220c == null) {
            this.f4220c = new AppInfo();
        }
        this.f4220c.setAppClientId(str);
        this.f4220c.setAppClientSecret(str2);
        this.f4220c.setPackageName(str3);
        C1679c.m6277a();
        C1679c.m6279a(context, this.f4220c);
    }

    /* renamed from: a */
    public final void mo9183a(Context context, String str, String str2, String str3, String str4) {
        if (this.f4218a == null) {
            this.f4218a = new DeviceInfo();
        }
        this.f4218a.setDeviceId(str);
        this.f4218a.setDeviceName(str2);
        this.f4218a.setSysVersion(str3);
        this.f4218a.setResolution(str4);
        C1679c.m6277a();
        C1679c.m6280a(context, this.f4218a);
    }

    /* renamed from: a */
    public final void mo9184a(AbstractC1647a aVar) {
        if (aVar != null) {
            this.f4222e = aVar;
        }
    }

    /* renamed from: a */
    public final void mo9185a(AbstractC1648b bVar) {
        if (bVar != null) {
            this.f4225h = bVar;
        }
    }

    /* renamed from: a */
    public final void mo9186a(AbstractC1649c cVar) {
        if (cVar != null) {
            this.f4221d = cVar;
        }
    }

    /* renamed from: a */
    public final void mo9187a(AbstractC1650d dVar) {
        if (dVar != null) {
            this.f4228k = dVar;
        }
    }

    /* renamed from: a */
    public final void mo9188a(AbstractC1651e eVar) {
        if (eVar != null) {
            this.f4227j = eVar;
        }
    }

    /* renamed from: a */
    public final void mo9189a(AbstractC1652f fVar) {
        if (fVar != null) {
            this.f4224g = fVar;
        }
    }

    /* renamed from: a */
    public final void mo9190a(AbstractC1653g gVar) {
        if (gVar != null) {
            this.f4226i = gVar;
        }
    }

    /* renamed from: a */
    public final void mo9191a(AbstractC1654h hVar) {
        if (hVar != null) {
            this.f4223f = hVar;
        }
    }

    /* renamed from: a */
    public final void mo9192a(String str, String str2) {
        if (this.f4219b == null) {
            this.f4219b = new OneSDKInfo();
        }
        this.f4219b.setOneAppId(str);
        this.f4219b.setOneAppKey(str2);
    }

    /* renamed from: b */
    public final AppInfo mo9193b(Context context) {
        mo9198c(context);
        return this.f4220c;
    }

    /* renamed from: b */
    public final OneSDKInfo mo9194b() {
        return this.f4219b;
    }

    /* renamed from: b */
    public final void mo9195b(Context context, StandardBaseResult<?> standardBaseResult) {
        int code = standardBaseResult.getCode();
        switch (code) {
            case 1:
                C1714f.m6376a(context, "PERFECT_PUSH", "ResponseCode.PLATFORM_SUCCESS");
                C1716h.m6385a(context).mo9382d();
                break;
            default:
                C1714f.m6376a(context, "PERFECT_PUSH", "Default");
                break;
        }
        if (this.f4223f == null) {
            C1714f.m6383c(context, "PERFECT_PUSH", "OnListener is null");
        } else if (code == 1) {
            this.f4223f.mo9162a();
        } else {
            this.f4223f.mo9163b();
        }
    }

    /* renamed from: b */
    public final void mo9196b(Context context, StandardBaseResult<?> standardBaseResult, String str, String str2) {
        int code = standardBaseResult.getCode();
        switch (code) {
            case 1:
                C1714f.m6376a(context, "PERFECT_PUSH", "ResponseCode.PLATFORM_PULL_CERTIFICATE_SUCCESS");
                break;
            default:
                C1714f.m6376a(context, "PERFECT_PUSH", "Default");
                break;
        }
        if (this.f4225h == null) {
            C1714f.m6383c(context, "PERFECT_PUSH", "OnAUTHListener is null");
        } else if (code != 1 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            this.f4225h.mo9166a(code);
        } else {
            this.f4225h.mo9167a(str, str2);
        }
    }

    /* renamed from: c */
    public final void mo9197c(Context context, StandardBaseResult<?> standardBaseResult) {
        int code = standardBaseResult.getCode();
        switch (code) {
            case 1:
                C1714f.m6376a(context, "PERFECT_PUSH", "ResponseCode.PLATFORM_SUCCESS");
                C1716h.m6385a(context).mo9382d();
                break;
            default:
                C1714f.m6376a(context, "PERFECT_PUSH", "Default");
                break;
        }
        if (this.f4226i == null) {
            C1714f.m6383c(context, "PERFECT_PUSH", "OnListener is null");
        } else if (code == 1) {
            this.f4226i.mo9207a();
        } else {
            this.f4226i.mo9208b();
        }
    }

    /* renamed from: c */
    public final boolean mo9198c(Context context) {
        if (context == null) {
            C1714f.m6383c(context, "PERFECT_PUSH", "context is null");
            return false;
        }
        try {
            if (this.f4220c == null) {
                C1679c.m6277a();
                this.f4220c = C1679c.m6283b(context);
            }
            return this.f4220c != null;
        } catch (ClassCastException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: d */
    public final void mo9199d(Context context, StandardBaseResult<?> standardBaseResult) {
        int code = standardBaseResult.getCode();
        switch (code) {
            case 1:
                C1714f.m6376a(context, "PERFECT_PUSH", "ResponseCode.PLATFORM_SUCCESS");
                C1716h.m6385a(context).mo9382d();
                break;
            default:
                C1714f.m6376a(context, "PERFECT_PUSH", "Default");
                break;
        }
        if (this.f4227j == null) {
            C1714f.m6383c(context, "PERFECT_PUSH", "OnListener is null");
        } else if (code == 1) {
            this.f4227j.mo9205a();
        } else {
            this.f4227j.mo9206b();
        }
    }

    /* renamed from: e */
    public final void mo9200e(Context context, StandardBaseResult<?> standardBaseResult) {
        int code = standardBaseResult.getCode();
        switch (code) {
            case 1:
                C1714f.m6376a(context, "PERFECT_PUSH", "ResponseCode.PLATFORM_SUCCESS");
                C1716h.m6385a(context).mo9382d();
                break;
            default:
                C1714f.m6376a(context, "PERFECT_PUSH", "Default");
                break;
        }
        if (this.f4228k == null) {
            C1714f.m6383c(context, "PERFECT_PUSH", "OnListener is null");
        } else if (code == 1) {
            this.f4228k.mo9203a();
        } else {
            this.f4228k.mo9204b();
        }
    }

    /* renamed from: f */
    public final void mo9201f(Context context, StandardBaseResult<?> standardBaseResult) {
        int code = standardBaseResult.getCode();
        switch (code) {
            case 1:
                C1714f.m6376a(context, "PERFECT_PUSH", "ResponseCode.PLATFORM_SUCCESS");
                C1716h.m6385a(context).mo9382d();
                break;
            default:
                C1714f.m6376a(context, "PERFECT_PUSH", "Default");
                break;
        }
        if (this.f4224g == null) {
            C1714f.m6383c(context, "PERFECT_PUSH", "OnListener is null");
        } else if (code == 1) {
            this.f4224g.mo9165a(standardBaseResult);
        } else {
            this.f4224g.mo9164a();
        }
    }
}
