package com.xiaomi.push.log;

import android.util.Log;
import com.xiaomi.channel.commonutils.file.C1853c;
import com.xiaomi.channel.commonutils.misc.C1857b;

/* access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.log.g */
public class C1927g extends C1857b.AbstractC1859b {

    /* renamed from: a */
    final /* synthetic */ C1926f f4968a;

    C1927g(C1926f fVar) {
        this.f4968a = fVar;
    }

    @Override // com.xiaomi.channel.commonutils.misc.C1857b.AbstractC1859b
    /* renamed from: b */
    public void mo9932b() {
        if (!C1926f.f4965f.isEmpty()) {
            try {
                if (!C1853c.m6711d()) {
                    Log.w(this.f4968a.f4966d, "SDCard is unavailable.");
                } else {
                    this.f4968a.m7130b();
                }
            } catch (Exception e) {
                Log.e(this.f4968a.f4966d, "", e);
            }
        }
    }
}
