package com.xiaomi.push.log;

import com.xiaomi.channel.commonutils.file.C1853c;
import com.xiaomi.push.log.C1919b;
import java.io.File;
import java.util.Date;

/* renamed from: com.xiaomi.push.log.c */
class C1923c extends C1919b.C1921b {

    /* renamed from: a */
    File f4950a;

    /* renamed from: b */
    final /* synthetic */ int f4951b;

    /* renamed from: c */
    final /* synthetic */ Date f4952c;

    /* renamed from: d */
    final /* synthetic */ Date f4953d;

    /* renamed from: e */
    final /* synthetic */ String f4954e;

    /* renamed from: f */
    final /* synthetic */ String f4955f;

    /* renamed from: g */
    final /* synthetic */ boolean f4956g;

    /* renamed from: h */
    final /* synthetic */ C1919b f4957h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1923c(C1919b bVar, int i, Date date, Date date2, String str, String str2, boolean z) {
        super();
        this.f4957h = bVar;
        this.f4951b = i;
        this.f4952c = date;
        this.f4953d = date2;
        this.f4954e = str;
        this.f4955f = str2;
        this.f4956g = z;
    }

    @Override // com.xiaomi.push.log.C1919b.C1921b, com.xiaomi.channel.commonutils.misc.C1857b.AbstractC1859b
    /* renamed from: b */
    public void mo9932b() {
        if (C1853c.m6711d()) {
            try {
                File file = new File(C1919b.m7105a(this.f4957h).getExternalFilesDir(null) + "/.logcache");
                file.mkdirs();
                if (file.isDirectory()) {
                    C1918a aVar = new C1918a();
                    aVar.mo10306a(this.f4951b);
                    this.f4950a = aVar.mo10305a(C1919b.m7105a(this.f4957h), this.f4952c, this.f4953d, file);
                }
            } catch (NullPointerException e) {
            }
        }
    }

    @Override // com.xiaomi.channel.commonutils.misc.C1857b.AbstractC1859b
    /* renamed from: c */
    public void mo9933c() {
        if (this.f4950a != null && this.f4950a.exists()) {
            C1919b.m7109b(this.f4957h).add(new C1919b.C1922c(this.f4954e, this.f4955f, this.f4950a, this.f4956g));
        }
        C1919b.m7108a(this.f4957h, 0);
    }
}
