package com.igexin.push.extension.distribution.basic.p054i.p056b;

import com.igexin.push.extension.distribution.basic.p054i.p055a.C0802j;
import com.igexin.push.extension.distribution.basic.p054i.p055a.C0803k;
import com.igexin.push.extension.distribution.basic.p054i.p058d.AbstractC0938ad;
import com.igexin.push.extension.distribution.basic.p054i.p058d.C0937ac;
import com.tencent.qcloud.core.util.IOUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.igexin.push.extension.distribution.basic.i.b.l */
public abstract class AbstractC0816l implements Cloneable {

    /* renamed from: a */
    AbstractC0816l f2293a;

    /* renamed from: b */
    List<AbstractC0816l> f2294b;

    /* renamed from: c */
    C0806b f2295c;

    /* renamed from: d */
    String f2296d;

    /* renamed from: e */
    int f2297e;

    protected AbstractC0816l() {
        this.f2294b = Collections.emptyList();
        this.f2295c = null;
    }

    protected AbstractC0816l(String str) {
        this(str, new C0806b());
    }

    protected AbstractC0816l(String str, C0806b bVar) {
        C0803k.m3393a((Object) str);
        C0803k.m3393a(bVar);
        this.f2294b = new ArrayList(4);
        this.f2296d = str.trim();
        this.f2295c = bVar;
    }

    /* renamed from: a */
    private void mo5325a(AbstractC0816l lVar) {
        if (lVar.f2293a != null) {
            lVar.f2293a.mo5364e(lVar);
        }
        lVar.mo5363d(this);
    }

    /* renamed from: c */
    private void mo5309c() {
        for (int i = 0; i < this.f2294b.size(); i++) {
            this.f2294b.get(i).mo5360b(i);
        }
    }

    /* renamed from: d */
    private C0810f mo5311d() {
        return mo5371z() != null ? mo5371z().mo5311d() : new C0809e("").mo5311d();
    }

    /* renamed from: A */
    public void mo5352A() {
        C0803k.m3393a(this.f2293a);
        this.f2293a.mo5364e(this);
    }

    /* renamed from: B */
    public AbstractC0816l mo5353B() {
        if (this.f2293a == null) {
            return null;
        }
        List<AbstractC0816l> list = this.f2293a.f2294b;
        Integer valueOf = Integer.valueOf(mo5354C());
        C0803k.m3393a(valueOf);
        if (list.size() > valueOf.intValue() + 1) {
            return list.get(valueOf.intValue() + 1);
        }
        return null;
    }

    /* renamed from: C */
    public int mo5354C() {
        return this.f2297e;
    }

    /* renamed from: a */
    public AbstractC0816l mo5355a(int i) {
        return this.f2294b.get(i);
    }

    /* renamed from: a */
    public AbstractC0816l mo5356a(AbstractC0938ad adVar) {
        C0803k.m3393a(adVar);
        new C0937ac(adVar).mo5561a(this);
        return this;
    }

    /* renamed from: a */
    public abstract String mo5302a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5357a(int i, AbstractC0816l... lVarArr) {
        C0803k.m3399a((Object[]) lVarArr);
        for (int length = lVarArr.length - 1; length >= 0; length--) {
            AbstractC0816l lVar = lVarArr[length];
            mo5325a(lVar);
            this.f2294b.add(i, lVar);
        }
        mo5309c();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5358a(StringBuilder sb) {
        new C0937ac(new C0818n(sb, mo5311d())).mo5561a(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo5303a(StringBuilder sb, int i, C0810f fVar);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5359a(AbstractC0816l... lVarArr) {
        for (AbstractC0816l lVar : lVarArr) {
            mo5325a(lVar);
            this.f2294b.add(lVar);
            lVar.mo5360b(this.f2294b.size() - 1);
        }
    }

    /* renamed from: b */
    public AbstractC0816l mo5329b(String str, String str2) {
        this.f2295c.mo5291a(str, str2);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5360b(int i) {
        this.f2297e = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract void mo5305b(StringBuilder sb, int i, C0810f fVar);

    /* renamed from: c */
    public AbstractC0816l mo5331c(AbstractC0816l lVar) {
        C0803k.m3393a(lVar);
        C0803k.m3393a(this.f2293a);
        this.f2293a.mo5357a(mo5354C(), lVar);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo5361c(StringBuilder sb, int i, C0810f fVar) {
        sb.append(IOUtils.LINE_SEPARATOR_UNIX).append(C0802j.m3385a(fVar.mo5323e() * i));
    }

    /* renamed from: d */
    public String mo5362d(String str) {
        C0803k.m3393a((Object) str);
        return this.f2295c.mo5294b(str) ? this.f2295c.mo5288a(str) : str.toLowerCase().startsWith("abs:") ? mo5368g(str.substring("abs:".length())) : "";
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo5363d(AbstractC0816l lVar) {
        if (this.f2293a != null) {
            this.f2293a.mo5364e(this);
        }
        this.f2293a = lVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo5364e(AbstractC0816l lVar) {
        C0803k.m3397a(lVar.f2293a == this);
        this.f2294b.remove(lVar.mo5354C());
        mo5309c();
        lVar.f2293a = null;
    }

    /* renamed from: e */
    public boolean mo5365e(String str) {
        C0803k.m3393a((Object) str);
        if (str.toLowerCase().startsWith("abs:")) {
            String substring = str.substring("abs:".length());
            if (this.f2295c.mo5294b(substring) && !mo5368g(substring).equals("")) {
                return true;
            }
        }
        return this.f2295c.mo5294b(str);
    }

    /* renamed from: e_ */
    public String mo5313e_() {
        StringBuilder sb = new StringBuilder(128);
        mo5358a(sb);
        return sb.toString();
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public AbstractC0816l mo5366f(AbstractC0816l lVar) {
        try {
            AbstractC0816l lVar2 = (AbstractC0816l) super.clone();
            lVar2.f2293a = lVar;
            lVar2.f2297e = lVar == null ? 0 : this.f2297e;
            lVar2.f2295c = this.f2295c != null ? this.f2295c.clone() : null;
            lVar2.f2296d = this.f2296d;
            lVar2.f2294b = new ArrayList(this.f2294b.size());
            for (AbstractC0816l lVar3 : this.f2294b) {
                lVar2.f2294b.add(lVar3.mo5366f(lVar2));
            }
            return lVar2;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: f */
    public void mo5367f(String str) {
        C0803k.m3393a((Object) str);
        mo5356a(new C0817m(this, str));
    }

    /* renamed from: g */
    public AbstractC0816l clone() {
        return mo5366f((AbstractC0816l) null);
    }

    /* renamed from: g */
    public String mo5368g(String str) {
        C0803k.m3395a(str);
        String d = mo5362d(str);
        if (!mo5365e(str)) {
            return "";
        }
        try {
            URL url = new URL(this.f2296d);
            try {
                if (d.startsWith("?")) {
                    d = url.getPath() + d;
                }
                return new URL(url, d).toExternalForm();
            } catch (MalformedURLException e) {
                return "";
            }
        } catch (MalformedURLException e2) {
            return new URL(d).toExternalForm();
        }
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.f2293a != null ? this.f2293a.hashCode() : 0) * 31;
        if (this.f2295c != null) {
            i = this.f2295c.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return mo5313e_();
    }

    /* renamed from: w */
    public AbstractC0816l mo5350w() {
        return this.f2293a;
    }

    /* renamed from: x */
    public C0806b mo5369x() {
        return this.f2295c;
    }

    /* renamed from: y */
    public List<AbstractC0816l> mo5370y() {
        return Collections.unmodifiableList(this.f2294b);
    }

    /* renamed from: z */
    public C0809e mo5371z() {
        if (this instanceof C0809e) {
            return (C0809e) this;
        }
        if (this.f2293a == null) {
            return null;
        }
        return this.f2293a.mo5371z();
    }
}
