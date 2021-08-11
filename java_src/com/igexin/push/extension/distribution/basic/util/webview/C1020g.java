package com.igexin.push.extension.distribution.basic.util.webview;

import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.p012b.p013a.p020d.AbstractC0470d;
import com.igexin.p012b.p013a.p020d.C0471e;
import com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e;
import com.igexin.push.core.C0519a;
import com.igexin.push.extension.distribution.basic.p053h.AbstractC0773f;
import com.igexin.push.extension.distribution.basic.p053h.C0768a;
import java.io.File;
import java.io.FileNotFoundException;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.basic.util.webview.g */
public class C1020g {

    /* renamed from: a */
    static String f2594a = C0519a.f1338b;

    /* renamed from: b */
    static String f2595b = "1.html";

    /* renamed from: c */
    String f2596c;

    /* renamed from: d */
    String f2597d;

    /* renamed from: e */
    String f2598e;

    /* renamed from: f */
    String f2599f;

    /* renamed from: g */
    C0456c f2600g;

    /* renamed from: h */
    int f2601h;

    /* renamed from: i */
    AbstractC1018e f2602i;

    /* renamed from: j */
    int f2603j;

    /* renamed from: k */
    int f2604k;

    /* renamed from: l */
    int f2605l;

    /* renamed from: m */
    String f2606m;

    /* renamed from: n */
    boolean f2607n;

    C1020g(String str, String str2, String str3, String str4, C0456c cVar, int i, AbstractC1018e eVar) {
        this.f2596c = str;
        this.f2597d = str2;
        this.f2598e = str3;
        this.f2599f = str4;
        this.f2600g = cVar;
        this.f2601h = i;
        this.f2602i = eVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5664a(EnumC1019f fVar, Exception exc) {
        this.f2607n = true;
        this.f2602i.mo4779a(fVar, this.f2598e, this.f2599f, this.f2606m, this.f2596c, this.f2597d, exc);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5665a() {
        return this.f2607n;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5666a(AbstractC0466e eVar, C0471e eVar2) {
        switch (eVar.mo4136b()) {
            case -559105:
                C1016c cVar = (C1016c) eVar;
                this.f2606m = new File(cVar.f2579b, f2595b).getAbsolutePath();
                if (cVar.f2581d != null && !cVar.f2581d.isEmpty()) {
                    this.f2603j = cVar.f2581d.size();
                    this.f2605l = 0;
                    this.f2604k = 0;
                    for (C1014a aVar : cVar.f2581d) {
                        this.f2600g.mo4216a(new C0768a(new C1015b(aVar.f2573b, aVar.f2572a, this.f2598e, 1)), false, true);
                    }
                    break;
                } else {
                    mo5664a(EnumC1019f.OK, (Exception) null);
                    break;
                }
            case 559106:
                C1015b bVar = (C1015b) eVar;
                this.f2604k++;
                if (this.f2604k + this.f2605l >= this.f2603j) {
                    mo5664a(EnumC1019f.OK, (Exception) null);
                    break;
                }
                break;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5667a(AbstractC0470d dVar, C0471e eVar) {
        switch (dVar.mo4136b()) {
            case -2147483639:
                AbstractC0773f fVar = ((C0768a) dVar).f2128a;
                if (fVar != null) {
                    switch (fVar.mo4136b()) {
                        case 559106:
                            C1015b bVar = (C1015b) fVar;
                            if (bVar.f2577j < 3) {
                                this.f2600g.mo4216a(new C0768a(new C1015b(bVar.f2575h, bVar.f2574a, this.f2598e, bVar.f2577j + 1)), false, true);
                            } else {
                                this.f2605l++;
                            }
                            if (this.f2604k + this.f2605l >= this.f2603j) {
                                mo5664a(EnumC1019f.OK_SOME_RES_FAILED, (Exception) null);
                                break;
                            }
                            break;
                    }
                }
                break;
            case -559105:
                C1016c cVar = (C1016c) dVar;
                if (!(cVar.f1113B instanceof FileNotFoundException)) {
                    mo5664a(EnumC1019f.ERROR_HTTP, cVar.f1113B);
                    break;
                } else {
                    mo5664a(EnumC1019f.ERROR_FILE, cVar.f1113B);
                    break;
                }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5668b() {
        File file = new File(f2594a, String.valueOf(this.f2598e));
        File file2 = new File(file, "res/");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        this.f2600g.mo4216a(new C1016c(this.f2598e, this.f2599f, this.f2601h, file), false, true);
    }
}
