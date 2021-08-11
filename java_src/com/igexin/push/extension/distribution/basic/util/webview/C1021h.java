package com.igexin.push.extension.distribution.basic.util.webview;

import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.p012b.p013a.p020d.AbstractC0470d;
import com.igexin.p012b.p013a.p020d.C0471e;
import com.igexin.p012b.p013a.p020d.p021a.AbstractC0463b;
import com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e;
import com.igexin.push.extension.distribution.basic.p053h.AbstractC0773f;
import com.igexin.push.extension.distribution.basic.p053h.C0768a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.igexin.push.extension.distribution.basic.util.webview.h */
public class C1021h implements AbstractC0463b {

    /* renamed from: a */
    private static C1021h f2608a;

    /* renamed from: b */
    private Map<String, C1020g> f2609b = new HashMap();

    /* renamed from: c */
    private C0456c f2610c;

    public C1021h(C0456c cVar) {
        this.f2610c = cVar;
        this.f2610c.mo4213a((AbstractC0463b) this);
    }

    /* renamed from: a */
    public static synchronized C1021h m4094a(C0456c cVar) {
        C1021h hVar;
        synchronized (C1021h.class) {
            if (f2608a == null) {
                f2608a = new C1021h(cVar);
            }
            hVar = f2608a;
        }
        return hVar;
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0463b
    /* renamed from: a */
    public boolean mo4177a(AbstractC0466e eVar, C0471e eVar2) {
        C1020g gVar;
        switch (eVar.mo4136b()) {
            case -559105:
                gVar = this.f2609b.get(((C1016c) eVar).f2578a);
                break;
            case 559106:
                gVar = this.f2609b.get(((C1015b) eVar).f2576i);
                break;
            default:
                gVar = null;
                break;
        }
        if (gVar == null) {
            return false;
        }
        boolean a = gVar.mo5666a(eVar, eVar2);
        if (!gVar.mo5665a()) {
            return a;
        }
        this.f2609b.remove(gVar.f2598e);
        return a;
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0463b
    /* renamed from: a */
    public boolean mo4178a(AbstractC0470d dVar, C0471e eVar) {
        C1020g gVar = null;
        switch (dVar.mo4136b()) {
            case -2147483639:
                AbstractC0773f fVar = ((C0768a) dVar).f2128a;
                if (fVar != null) {
                    switch (fVar.mo4136b()) {
                        case 559106:
                            gVar = this.f2609b.get(((C1015b) fVar).f2576i);
                            break;
                    }
                }
                break;
            case -559105:
                gVar = this.f2609b.get(((C1016c) dVar).f2578a);
                break;
        }
        if (gVar == null) {
            return false;
        }
        boolean a = gVar.mo5667a(dVar, eVar);
        if (!gVar.mo5665a()) {
            return a;
        }
        this.f2609b.remove(gVar.f2598e);
        return a;
    }

    /* renamed from: a */
    public boolean mo5669a(String str, String str2, String str3, String str4, int i, AbstractC1018e eVar) {
        C1020g gVar = new C1020g(str, str2, str3, str4, this.f2610c, i, eVar);
        gVar.mo5668b();
        if (this.f2609b.get(str3) != null) {
            return false;
        }
        this.f2609b.put(str3, gVar);
        return true;
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0463b
    /* renamed from: n */
    public boolean mo4179n() {
        return true;
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0463b
    /* renamed from: o */
    public long mo4180o() {
        return -79225;
    }
}
