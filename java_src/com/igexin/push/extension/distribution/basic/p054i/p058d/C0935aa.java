package com.igexin.push.extension.distribution.basic.p054i.p058d;

import com.igexin.push.extension.distribution.basic.p054i.p056b.C0813i;
import java.util.regex.Pattern;

/* renamed from: com.igexin.push.extension.distribution.basic.i.d.aa */
public final class C0935aa extends AbstractC0955g {

    /* renamed from: a */
    private Pattern f2477a;

    public C0935aa(Pattern pattern) {
        this.f2477a = pattern;
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p058d.AbstractC0955g
    /* renamed from: a */
    public boolean mo5558a(C0813i iVar, C0813i iVar2) {
        return this.f2477a.matcher(iVar2.mo5345r()).find();
    }

    public String toString() {
        return String.format(":matchesOwn(%s", this.f2477a);
    }
}
