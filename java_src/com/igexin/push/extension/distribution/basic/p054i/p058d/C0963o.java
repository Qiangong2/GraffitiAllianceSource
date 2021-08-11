package com.igexin.push.extension.distribution.basic.p054i.p058d;

import com.igexin.push.extension.distribution.basic.p054i.p056b.C0813i;
import java.util.regex.Pattern;

/* renamed from: com.igexin.push.extension.distribution.basic.i.d.o */
public final class C0963o extends AbstractC0955g {

    /* renamed from: a */
    String f2496a;

    /* renamed from: b */
    Pattern f2497b;

    public C0963o(String str, Pattern pattern) {
        this.f2496a = str.trim().toLowerCase();
        this.f2497b = pattern;
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p058d.AbstractC0955g
    /* renamed from: a */
    public boolean mo5558a(C0813i iVar, C0813i iVar2) {
        return iVar2.mo5365e(this.f2496a) && this.f2497b.matcher(iVar2.mo5362d(this.f2496a)).find();
    }

    public String toString() {
        return String.format("[%s~=%s]", this.f2496a, this.f2497b.toString());
    }
}
