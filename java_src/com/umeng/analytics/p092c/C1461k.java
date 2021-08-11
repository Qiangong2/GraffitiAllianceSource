package com.umeng.analytics.p092c;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.p085a.C1341c;
import com.umeng.p085a.C1344f;
import java.io.File;

/* renamed from: com.umeng.analytics.c.k */
/* compiled from: OldUMIDTracker */
public class C1461k extends AbstractC1449a {

    /* renamed from: a */
    private static final String f3596a = "oldumid";

    /* renamed from: b */
    private Context f3597b;

    /* renamed from: c */
    private String f3598c = null;

    /* renamed from: d */
    private String f3599d = null;

    public C1461k(Context context) {
        super(f3596a);
        this.f3597b = context;
    }

    @Override // com.umeng.analytics.p092c.AbstractC1449a
    /* renamed from: f */
    public String mo8554f() {
        return this.f3598c;
    }

    /* renamed from: g */
    public boolean mo8601g() {
        return mo8602h();
    }

    /* renamed from: h */
    public boolean mo8602h() {
        this.f3599d = C1457h.m5380a(this.f3597b).mo8580b().mo8600g(null);
        if (!TextUtils.isEmpty(this.f3599d)) {
            this.f3599d = C1341c.m4920c(this.f3599d);
            String b = C1344f.m4978b(new File("/sdcard/Android/data/.um/sysid.dat"));
            String b2 = C1344f.m4978b(new File("/sdcard/Android/obj/.um/sysid.dat"));
            String b3 = C1344f.m4978b(new File("/data/local/tmp/.um/sysid.dat"));
            if (TextUtils.isEmpty(b)) {
                m5417l();
            } else if (!this.f3599d.equals(b)) {
                this.f3598c = b;
                return true;
            }
            if (TextUtils.isEmpty(b2)) {
                m5416k();
            } else if (!this.f3599d.equals(b2)) {
                this.f3598c = b2;
                return true;
            }
            if (TextUtils.isEmpty(b3)) {
                m5415j();
            } else if (!this.f3599d.equals(b3)) {
                this.f3598c = b3;
                return true;
            }
        }
        return false;
    }

    /* renamed from: i */
    public void mo8603i() {
        try {
            m5417l();
            m5416k();
            m5415j();
        } catch (Exception e) {
        }
    }

    /* renamed from: j */
    private void m5415j() {
        try {
            m5414b("/data/local/tmp/.um");
            C1344f.m4975a(new File("/data/local/tmp/.um/sysid.dat"), this.f3599d);
        } catch (Throwable th) {
        }
    }

    /* renamed from: k */
    private void m5416k() {
        try {
            m5414b("/sdcard/Android/obj/.um");
            C1344f.m4975a(new File("/sdcard/Android/obj/.um/sysid.dat"), this.f3599d);
        } catch (Throwable th) {
        }
    }

    /* renamed from: l */
    private void m5417l() {
        try {
            m5414b("/sdcard/Android/data/.um");
            C1344f.m4975a(new File("/sdcard/Android/data/.um/sysid.dat"), this.f3599d);
        } catch (Throwable th) {
        }
    }

    /* renamed from: b */
    private void m5414b(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
    }
}
