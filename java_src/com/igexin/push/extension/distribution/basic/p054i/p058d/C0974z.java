package com.igexin.push.extension.distribution.basic.p054i.p058d;

import com.igexin.push.extension.distribution.basic.p054i.p056b.C0813i;
import java.util.regex.Pattern;

/* renamed from: com.igexin.push.extension.distribution.basic.i.d.z */
public final class C0974z extends AbstractC0955g {

    /* renamed from: a */
    private Pattern f2503a;

    public C0974z(Pattern pattern) {
        this.f2503a = pattern;
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p058d.AbstractC0955g
    /* renamed from: a */
    public boolean mo5558a(C0813i iVar, C0813i iVar2) {
        return this.f2503a.matcher(iVar2.mo5344q()).find();
    }

    public String toString() {
        return String.format(":matches(%s", this.f2503a);
    }
}
