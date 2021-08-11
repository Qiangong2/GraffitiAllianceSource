package com.igexin.p012b.p013a.p015b;

/* renamed from: com.igexin.b.a.b.b */
public abstract class AbstractC0455b {

    /* renamed from: c */
    protected String f1074c;

    /* renamed from: d */
    protected AbstractC0455b f1075d;

    /* renamed from: e */
    protected AbstractC0455b f1076e;

    /* renamed from: f */
    protected boolean f1077f;

    public AbstractC0455b(String str, boolean z) {
        this.f1074c = str;
        this.f1077f = z;
    }

    /* renamed from: a */
    public abstract Object mo4158a(AbstractC0458e eVar, C0457d dVar, Object obj);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo4159a(AbstractC0455b bVar) {
        if (bVar != null) {
            AbstractC0455b bVar2 = bVar.f1075d;
            bVar.f1075d = this;
            this.f1076e = bVar;
            this.f1075d = bVar2;
        }
    }

    /* renamed from: a */
    public void mo4160a(boolean z) {
        if (!this.f1077f || z) {
            while (this.f1075d != null) {
                AbstractC0455b bVar = this.f1075d.f1075d;
                this.f1075d.f1075d = null;
                this.f1075d = bVar;
            }
        }
    }

    /* renamed from: c */
    public abstract Object mo4161c(AbstractC0458e eVar, C0457d dVar, Object obj);

    /* renamed from: d */
    public final Object mo4162d(AbstractC0458e eVar, C0457d dVar, Object obj) {
        if (obj == null) {
            throw new NullPointerException("Nothing to encode!");
        }
        if (this.f1075d != null) {
            obj = this.f1075d.mo4162d(eVar, dVar, obj);
        }
        return mo4158a(eVar, dVar, obj);
    }
}
