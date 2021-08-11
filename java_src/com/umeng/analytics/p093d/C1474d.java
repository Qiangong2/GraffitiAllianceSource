package com.umeng.analytics.p093d;

import android.content.Context;
import com.umeng.p085a.AbstractRunnableC1359k;
import com.umeng.p085a.C1347i;

/* renamed from: com.umeng.analytics.d.d */
/* compiled from: CacheService */
public final class C1474d implements AbstractC1482g {

    /* renamed from: c */
    private static C1474d f3650c;

    /* renamed from: a */
    private AbstractC1482g f3651a = new C1471c(this.f3652b);

    /* renamed from: b */
    private Context f3652b;

    private C1474d(Context context) {
        this.f3652b = context;
    }

    /* renamed from: a */
    public synchronized C1471c mo8628a(Context context) {
        return (C1471c) this.f3651a;
    }

    /* renamed from: b */
    public static synchronized C1474d m5473b(Context context) {
        C1474d dVar;
        synchronized (C1474d.class) {
            if (f3650c == null && context != null) {
                f3650c = new C1474d(context);
            }
            dVar = f3650c;
        }
        return dVar;
    }

    /* renamed from: a */
    public void mo8629a(AbstractC1482g gVar) {
        this.f3651a = gVar;
    }

    @Override // com.umeng.analytics.p093d.AbstractC1482g
    /* renamed from: a */
    public void mo8621a(final Object obj) {
        C1347i.m5018b(new AbstractRunnableC1359k() {
            /* class com.umeng.analytics.p093d.C1474d.C14751 */

            @Override // com.umeng.p085a.AbstractRunnableC1359k
            /* renamed from: a */
            public void mo8374a() {
                C1474d.this.f3651a.mo8621a(obj);
            }
        });
    }

    @Override // com.umeng.analytics.p093d.AbstractC1482g
    /* renamed from: a */
    public void mo8618a() {
        C1347i.m5018b(new AbstractRunnableC1359k() {
            /* class com.umeng.analytics.p093d.C1474d.C14762 */

            @Override // com.umeng.p085a.AbstractRunnableC1359k
            /* renamed from: a */
            public void mo8374a() {
                C1474d.this.f3651a.mo8618a();
            }
        });
    }

    @Override // com.umeng.analytics.p093d.AbstractC1482g
    /* renamed from: b */
    public void mo8623b() {
        C1347i.m5019c(new AbstractRunnableC1359k() {
            /* class com.umeng.analytics.p093d.C1474d.C14773 */

            @Override // com.umeng.p085a.AbstractRunnableC1359k
            /* renamed from: a */
            public void mo8374a() {
                C1474d.this.f3651a.mo8623b();
            }
        });
    }
}
