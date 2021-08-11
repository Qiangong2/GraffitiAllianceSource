package com.igexin.p012b.p013a.p015b;

import com.igexin.p012b.p013a.p020d.AbstractC0470d;

/* renamed from: com.igexin.b.a.b.e */
public abstract class AbstractC0458e extends AbstractC0470d {

    /* renamed from: a */
    public String f1086a;

    /* renamed from: b */
    public AbstractC0455b f1087b;

    /* renamed from: c */
    public Object f1088c;

    /* renamed from: d */
    public C0457d f1089d;

    public AbstractC0458e(int i, String str, AbstractC0455b bVar) {
        super(i);
        if (str != null) {
            this.f1086a = m1673a(str);
        }
        this.f1087b = bVar;
    }

    public AbstractC0458e(String str, AbstractC0455b bVar) {
        this(0, str, bVar);
    }

    /* renamed from: a */
    private String m1673a(String str) {
        return C0459f.m1679a(C0459f.m1684a(str));
    }

    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: f */
    public void mo4138f() {
        if (this.f1087b != null) {
            this.f1087b.mo4160a(false);
        }
        this.f1087b = null;
        this.f1089d = null;
        this.f1088c = null;
        this.f1086a = null;
        super.mo4138f();
    }
}
