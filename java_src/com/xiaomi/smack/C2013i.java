package com.xiaomi.smack;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.tencent.qcloud.core.util.IOUtils;
import com.xiaomi.smack.packet.AbstractC2028d;
import com.xiaomi.smack.util.C2045g;
import com.xiaomi.smack.util.C2046h;
import com.xiaomi.smack.util.C2049k;
import java.io.IOException;
import java.io.Writer;
import java.util.Locale;

/* access modifiers changed from: package-private */
/* renamed from: com.xiaomi.smack.i */
public class C2013i {

    /* renamed from: a */
    private Writer f5322a;

    /* renamed from: b */
    private C2019l f5323b;

    protected C2013i(C2019l lVar) {
        this.f5323b = lVar;
        this.f5322a = lVar.f5297i;
    }

    /* renamed from: b */
    private void m7548b(AbstractC2028d dVar) {
        synchronized (this.f5322a) {
            try {
                String a = dVar.mo10546a();
                this.f5322a.write(a + IOUtils.LINE_SEPARATOR_WINDOWS);
                this.f5322a.flush();
                String o = dVar.mo10617o();
                if (!TextUtils.isEmpty(o)) {
                    C2049k.m7718a(this.f5323b.f5301m, o, (long) C2049k.m7714a(a), false, System.currentTimeMillis());
                }
            } catch (IOException e) {
                throw new C2023p(e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10540a() {
        this.f5323b.f5294f.clear();
    }

    /* renamed from: a */
    public void mo10541a(AbstractC2028d dVar) {
        m7548b(dVar);
        this.f5323b.mo10508b(dVar);
    }

    /* renamed from: b */
    public void mo10542b() {
        synchronized (this.f5322a) {
            this.f5322a.write("</stream:stream>");
            this.f5322a.flush();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo10543c() {
        StringBuilder sb = new StringBuilder();
        sb.append("<stream:stream");
        sb.append(" xmlns=\"xm\"");
        sb.append(" xmlns:stream=\"xm\"");
        sb.append(" to=\"").append(this.f5323b.mo10505b()).append("\"");
        sb.append(" version=\"105\"");
        sb.append(" model=\"").append(C2045g.m7700a(Build.MODEL)).append("\"");
        sb.append(" os=\"").append(C2045g.m7700a(Build.VERSION.INCREMENTAL)).append("\"");
        String b = C2046h.m7708b();
        if (b != null) {
            sb.append(" uid=\"").append(b).append("\"");
        }
        sb.append(" sdk=\"").append(8).append("\"");
        sb.append(" connpt=\"").append(C2045g.m7700a(this.f5323b.mo10510d())).append("\"");
        sb.append(" host=\"").append(this.f5323b.mo10509c()).append("\"");
        sb.append(" locale=\"").append(C2045g.m7700a(Locale.getDefault().toString())).append("\"");
        byte[] a = this.f5323b.mo10494a().mo10394a();
        if (a != null) {
            sb.append(" ps=\"").append(Base64.encodeToString(a, 10)).append("\"");
        }
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        this.f5322a.write(sb.toString());
        this.f5322a.flush();
    }

    /* renamed from: d */
    public void mo10544d() {
        synchronized (this.f5322a) {
            try {
                this.f5322a.write(this.f5323b.mo10556t() + IOUtils.LINE_SEPARATOR_WINDOWS);
                this.f5322a.flush();
                this.f5323b.mo10558v();
            } catch (IOException e) {
                throw new C2023p(e);
            }
        }
    }
}
