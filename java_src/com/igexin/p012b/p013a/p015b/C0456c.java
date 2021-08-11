package com.igexin.p012b.p013a.p015b;

import com.igexin.p012b.p013a.p020d.C0471e;
import com.igexin.p012b.p013a.p020d.p021a.AbstractC0462a;
import com.igexin.p012b.p013a.p020d.p021a.AbstractC0464c;
import com.igexin.p012b.p013a.p020d.p021a.AbstractC0467f;
import com.igexin.p012b.p022b.C0476a;
import java.util.concurrent.TimeUnit;

/* renamed from: com.igexin.b.a.b.c */
public class C0456c extends C0471e {

    /* renamed from: a */
    static C0456c f1078a;

    /* renamed from: b */
    public volatile long f1079b;

    /* renamed from: c */
    public volatile long f1080c;

    /* renamed from: d */
    public volatile long f1081d;

    /* renamed from: e */
    public volatile long f1082e;

    /* renamed from: f */
    AbstractC0462a<String, Integer, AbstractC0455b, AbstractC0458e> f1083f;

    /* renamed from: v */
    private byte[] f1084v;

    /* renamed from: w */
    private byte[] f1085w;

    /* renamed from: b */
    public static C0456c m1661b() {
        if (f1078a == null) {
            f1078a = new C0456c();
        }
        return f1078a;
    }

    /* renamed from: d */
    public static void m1662d() {
        f1078a.f1079b = 0;
        f1078a.f1081d = 0;
        f1078a.f1080c = 0;
        f1078a.f1082e = 0;
    }

    /* renamed from: a */
    public AbstractC0458e mo4163a(String str, int i, AbstractC0455b bVar, Object obj, boolean z) {
        return mo4164a(str, i, bVar, obj, z, -1, -1, (byte) 0, null, null);
    }

    /* renamed from: a */
    public AbstractC0458e mo4164a(String str, int i, AbstractC0455b bVar, Object obj, boolean z, int i2, long j, byte b, Object obj2, AbstractC0464c cVar) {
        return mo4165a(str, i, bVar, obj, z, i2, j, b, obj2, cVar, 0, null);
    }

    /* renamed from: a */
    public AbstractC0458e mo4165a(String str, int i, AbstractC0455b bVar, Object obj, boolean z, int i2, long j, byte b, Object obj2, AbstractC0464c cVar, int i3, AbstractC0467f fVar) {
        AbstractC0458e a;
        if (this.f1083f == null || (a = this.f1083f.mo4176a(str, Integer.valueOf(i), bVar)) == null || a.mo4204r()) {
            return null;
        }
        if (fVar != null) {
            a.mo4196a(i3, fVar);
        }
        mo4169a(a, obj, z, i2, j, b, obj2, cVar);
        return a;
    }

    /* renamed from: a */
    public AbstractC0458e mo4166a(String str, int i, AbstractC0455b bVar, Object obj, boolean z, int i2, AbstractC0467f fVar) {
        return mo4165a(str, i, bVar, obj, z, -1, -1, (byte) 0, null, null, i2, fVar);
    }

    /* renamed from: a */
    public void mo4167a(AbstractC0462a<String, Integer, AbstractC0455b, AbstractC0458e> aVar) {
        this.f1083f = aVar;
    }

    /* renamed from: a */
    public void mo4168a(byte[] bArr) {
        this.f1084v = bArr;
        this.f1085w = C0476a.m1775a(bArr);
        if (this.f1085w != null) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo4169a(AbstractC0458e eVar, Object obj, boolean z, int i, long j, byte b, Object obj2, AbstractC0464c cVar) {
        eVar.f1088c = obj;
        eVar.mo4193a(j, TimeUnit.MILLISECONDS);
        eVar.f1135x = i;
        eVar.mo4195a(b);
        eVar.f1114C = obj2;
        eVar.mo4197a(cVar);
        return mo4215a(eVar, z);
    }

    /* renamed from: a */
    public byte[] mo4170a() {
        return this.f1085w;
    }

    /* renamed from: c */
    public final void mo4171c() {
        mo4222f();
    }
}
