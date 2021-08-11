package com.igexin.push.extension.distribution.basic.p054i.p057c;

import com.igexin.push.extension.distribution.basic.p054i.p055a.C0794b;
import com.igexin.push.extension.distribution.basic.p054i.p055a.C0802j;
import com.igexin.push.extension.distribution.basic.p054i.p055a.C0803k;
import com.igexin.push.extension.distribution.basic.p054i.p056b.AbstractC0816l;
import com.igexin.push.extension.distribution.basic.p054i.p056b.C0807c;
import com.igexin.push.extension.distribution.basic.p054i.p056b.C0808d;
import com.igexin.push.extension.distribution.basic.p054i.p056b.C0809e;
import com.igexin.push.extension.distribution.basic.p054i.p056b.C0813i;
import com.igexin.push.extension.distribution.basic.p054i.p056b.C0819o;
import com.umeng.analytics.C1370a;
import com.umeng.analytics.p091b.C1447g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.basic.i.c.b */
public class C0848b extends AbstractC0910dh {

    /* renamed from: a */
    static final /* synthetic */ boolean f2429a = (!C0848b.class.desiredAssertionStatus());

    /* renamed from: i */
    private EnumC0875c f2430i;

    /* renamed from: j */
    private EnumC0875c f2431j;

    /* renamed from: k */
    private boolean f2432k = false;

    /* renamed from: l */
    private C0813i f2433l;

    /* renamed from: m */
    private C0813i f2434m;

    /* renamed from: n */
    private C0813i f2435n;

    /* renamed from: o */
    private C0794b<C0813i> f2436o = new C0794b<>();

    /* renamed from: p */
    private List<C0829ah> f2437p = new ArrayList();

    /* renamed from: q */
    private boolean f2438q = true;

    /* renamed from: r */
    private boolean f2439r = false;

    /* renamed from: s */
    private boolean f2440s = false;

    C0848b() {
    }

    /* renamed from: a */
    private void m3677a(LinkedList<C0813i> linkedList, C0813i iVar, C0813i iVar2) {
        int lastIndexOf = linkedList.lastIndexOf(iVar);
        C0803k.m3397a(lastIndexOf != -1);
        linkedList.remove(lastIndexOf);
        linkedList.add(lastIndexOf, iVar2);
    }

    /* renamed from: a */
    private boolean m3678a(C0794b<C0813i> bVar, C0813i iVar) {
        Iterator<C0813i> descendingIterator = bVar.descendingIterator();
        while (descendingIterator.hasNext()) {
            if (descendingIterator.next() == iVar) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m3679a(String str, String[] strArr, String[] strArr2) {
        return m3680a(new String[]{str}, strArr, strArr2);
    }

    /* renamed from: a */
    private boolean m3680a(String[] strArr, String[] strArr2, String[] strArr3) {
        Iterator descendingIterator = this.f2469e.descendingIterator();
        while (descendingIterator.hasNext()) {
            String a = ((C0813i) descendingIterator.next()).mo5302a();
            if (C0802j.m3389a(a, strArr)) {
                return true;
            }
            if (C0802j.m3389a(a, strArr2)) {
                return false;
            }
            if (strArr3 != null && C0802j.m3389a(a, strArr3)) {
                return false;
            }
        }
        C0803k.m3401b("Should not be reachable");
        return false;
    }

    /* renamed from: b */
    private void m3681b(AbstractC0816l lVar) {
        if (this.f2469e.size() == 0) {
            this.f2468d.mo5325a(lVar);
        } else if (mo5545o()) {
            mo5496a(lVar);
        } else {
            mo5556x().mo5325a(lVar);
        }
    }

    /* renamed from: c */
    private void m3682c(String... strArr) {
        Iterator descendingIterator = this.f2469e.descendingIterator();
        while (descendingIterator.hasNext()) {
            C0813i iVar = (C0813i) descendingIterator.next();
            if (!C0802j.m3389a(iVar.mo5302a(), strArr) && !iVar.mo5302a().equals("html")) {
                descendingIterator.remove();
            } else {
                return;
            }
        }
    }

    /* renamed from: d */
    private boolean m3683d(C0813i iVar, C0813i iVar2) {
        return iVar.mo5302a().equals(iVar2.mo5302a()) && iVar.mo5369x().equals(iVar2.mo5369x());
    }

    /* access modifiers changed from: package-private */
    @Override // com.igexin.push.extension.distribution.basic.p054i.p057c.AbstractC0910dh
    /* renamed from: a */
    public C0809e mo5490a(String str, String str2, C0824ac acVar) {
        this.f2430i = EnumC0875c.Initial;
        return super.mo5490a(str, str2, acVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0813i mo5491a(C0834am amVar) {
        if (!amVar.mo5450p() || C0826ae.m3586b(amVar.mo5449o())) {
            C0813i iVar = new C0813i(C0826ae.m3585a(amVar.mo5449o()), this.f2470f, amVar.f2336d);
            mo5508b(iVar);
            return iVar;
        }
        C0813i b = mo5505b(amVar);
        mo5502a(new C0833al(b.mo5334h()));
        return b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0813i mo5492a(String str) {
        C0813i iVar = new C0813i(C0826ae.m3585a(str), this.f2470f);
        mo5508b(iVar);
        return iVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public EnumC0875c mo5493a() {
        return this.f2430i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5494a(C0813i iVar) {
        if (!this.f2432k) {
            String g = iVar.mo5368g("href");
            if (g.length() != 0) {
                this.f2470f = g;
                this.f2432k = true;
                this.f2468d.mo5367f(g);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5495a(C0813i iVar, C0813i iVar2) {
        int lastIndexOf = this.f2469e.lastIndexOf(iVar);
        C0803k.m3397a(lastIndexOf != -1);
        this.f2469e.add(lastIndexOf + 1, iVar2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5496a(AbstractC0816l lVar) {
        C0813i iVar;
        boolean z;
        C0813i b = mo5506b("table");
        if (b == null) {
            iVar = (C0813i) this.f2469e.get(0);
            z = false;
        } else if (b.mo5350w() != null) {
            iVar = b.mo5350w();
            z = true;
        } else {
            iVar = mo5523f(b);
            z = false;
        }
        if (z) {
            C0803k.m3393a(b);
            b.mo5331c(lVar);
            return;
        }
        iVar.mo5325a(lVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5497a(C0829ah ahVar) {
        mo5556x().mo5325a(C0802j.m3389a(mo5556x().mo5334h(), new String[]{"script", C1447g.f3452P}) ? new C0808d(ahVar.mo5430m(), this.f2470f) : new C0819o(ahVar.mo5430m(), this.f2470f));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5498a(C0830ai aiVar) {
        m3681b(new C0807c(aiVar.mo5432m(), this.f2470f));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5499a(EnumC0875c cVar) {
        this.f2430i = cVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5500a(boolean z) {
        this.f2438q = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5501a(String... strArr) {
        Iterator descendingIterator = this.f2469e.descendingIterator();
        while (descendingIterator.hasNext()) {
            if (C0802j.m3389a(((C0813i) descendingIterator.next()).mo5302a(), strArr)) {
                descendingIterator.remove();
                return;
            }
            descendingIterator.remove();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.igexin.push.extension.distribution.basic.p054i.p057c.AbstractC0910dh
    /* renamed from: a */
    public boolean mo5502a(AbstractC0827af afVar) {
        this.f2471g = afVar;
        return this.f2430i.mo5402a(afVar, this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5503a(AbstractC0827af afVar, EnumC0875c cVar) {
        this.f2471g = afVar;
        return cVar.mo5402a(afVar, this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5504a(String str, String[] strArr) {
        return m3679a(str, new String[]{"applet", "caption", "html", "table", "td", "th", "marquee", "object"}, strArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C0813i mo5505b(C0834am amVar) {
        C0826ae a = C0826ae.m3585a(amVar.mo5449o());
        C0813i iVar = new C0813i(a, this.f2470f, amVar.f2336d);
        m3681b((AbstractC0816l) iVar);
        if (amVar.mo5450p()) {
            this.f2467c.mo5477b();
            if (!a.mo5412e()) {
                a.mo5415g();
            }
        }
        return iVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C0813i mo5506b(String str) {
        Iterator descendingIterator = this.f2469e.descendingIterator();
        while (descendingIterator.hasNext()) {
            C0813i iVar = (C0813i) descendingIterator.next();
            if (iVar.mo5302a().equals(str)) {
                return iVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5507b() {
        this.f2431j = this.f2430i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5508b(C0813i iVar) {
        m3681b((AbstractC0816l) iVar);
        this.f2469e.add(iVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5509b(C0813i iVar, C0813i iVar2) {
        m3677a(this.f2469e, iVar, iVar2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5510b(EnumC0875c cVar) {
        if (this.f2472h.mo5405a()) {
            this.f2472h.add(new C0823ab(this.f2466b.mo5376a(), "Unexpected token [%s] when in state [%s]", this.f2471g.mo5418a(), cVar));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5511b(boolean z) {
        this.f2439r = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo5512b(String[] strArr) {
        return m3680a(strArr, new String[]{"applet", "caption", "html", "table", "td", "th", "marquee", "object"}, (String[]) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public EnumC0875c mo5513c() {
        return this.f2431j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5514c(C0813i iVar) {
        this.f2469e.add(iVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5515c(C0813i iVar, C0813i iVar2) {
        m3677a(this.f2436o, iVar, iVar2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5516c(String str) {
        Iterator descendingIterator = this.f2469e.descendingIterator();
        while (descendingIterator.hasNext()) {
            if (((C0813i) descendingIterator.next()).mo5302a().equals(str)) {
                descendingIterator.remove();
                return;
            }
            descendingIterator.remove();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo5517d(String str) {
        Iterator descendingIterator = this.f2469e.descendingIterator();
        while (descendingIterator.hasNext() && !((C0813i) descendingIterator.next()).mo5302a().equals(str)) {
            descendingIterator.remove();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo5518d() {
        return this.f2438q;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo5519d(C0813i iVar) {
        return m3678a(this.f2469e, iVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public C0809e mo5520e() {
        return this.f2468d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo5521e(C0813i iVar) {
        Iterator descendingIterator = this.f2469e.descendingIterator();
        while (descendingIterator.hasNext()) {
            if (((C0813i) descendingIterator.next()) == iVar) {
                descendingIterator.remove();
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo5522e(String str) {
        return mo5504a(str, (String[]) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public C0813i mo5523f(C0813i iVar) {
        if (f2429a || mo5519d(iVar)) {
            Iterator descendingIterator = this.f2469e.descendingIterator();
            while (descendingIterator.hasNext()) {
                if (((C0813i) descendingIterator.next()) == iVar) {
                    return (C0813i) descendingIterator.next();
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public String mo5524f() {
        return this.f2470f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo5525f(String str) {
        return mo5504a(str, new String[]{"ol", "ul"});
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo5526g(C0813i iVar) {
        this.f2433l = iVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo5527g() {
        return this.f2440s;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo5528g(String str) {
        return mo5504a(str, new String[]{"button"});
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public C0813i mo5529h() {
        if (((C0813i) this.f2469e.peekLast()).mo5302a().equals("td") && !this.f2430i.name().equals("InCell")) {
            C0803k.m3403b(true, "pop td not in cell");
        }
        if (((C0813i) this.f2469e.peekLast()).mo5302a().equals("html")) {
            C0803k.m3403b(true, "popping html!");
        }
        return (C0813i) this.f2469e.pollLast();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo5530h(C0813i iVar) {
        this.f2434m = iVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo5531h(String str) {
        return m3679a(str, new String[]{"html", "table"}, (String[]) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public C0794b<C0813i> mo5532i() {
        return this.f2469e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo5533i(C0813i iVar) {
        return C0802j.m3389a(iVar.mo5302a(), "address", "applet", "area", "article", "aside", "base", "basefont", "bgsound", "blockquote", C1370a.f3234z, "br", "button", "caption", "center", "col", "colgroup", "command", "dd", "details", "dir", "div", "dl", "dt", "embed", "fieldset", "figcaption", "figure", "footer", "form", "frame", "frameset", "h1", "h2", "h3", "h4", "h5", "h6", "head", C1370a.f3205A, "hgroup", "hr", "html", "iframe", "img", "input", "isindex", "li", "link", "listing", "marquee", "menu", "meta", "nav", "noembed", "noframes", "noscript", "object", "ol", "p", "param", "plaintext", "pre", "script", "section", "select", C1447g.f3452P, "summary", "table", "tbody", "td", "textarea", "tfoot", "th", "thead", "title", "tr", "ul", "wbr", "xmp");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo5534i(String str) {
        Iterator descendingIterator = this.f2469e.descendingIterator();
        while (descendingIterator.hasNext()) {
            String a = ((C0813i) descendingIterator.next()).mo5302a();
            if (a.equals(str)) {
                return true;
            }
            if (!C0802j.m3389a(a, "optgroup", "option")) {
                return false;
            }
        }
        C0803k.m3401b("Should not be reachable");
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo5535j() {
        m3682c("table");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo5536j(C0813i iVar) {
        C0813i next;
        int i = 0;
        Iterator<C0813i> descendingIterator = this.f2436o.descendingIterator();
        while (true) {
            if (!descendingIterator.hasNext() || (next = descendingIterator.next()) == null) {
                break;
            }
            i = m3683d(iVar, next) ? i + 1 : i;
            if (i == 3) {
                descendingIterator.remove();
                break;
            }
        }
        this.f2436o.add(iVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo5537j(String str) {
        while (str != null && !mo5556x().mo5302a().equals(str)) {
            if (C0802j.m3389a(mo5556x().mo5302a(), "dd", "dt", "li", "option", "optgroup", "p", "rp", "rt")) {
                mo5529h();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public C0813i mo5538k(String str) {
        C0813i next;
        Iterator<C0813i> descendingIterator = this.f2436o.descendingIterator();
        while (descendingIterator.hasNext() && (next = descendingIterator.next()) != null) {
            if (next.mo5302a().equals(str)) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo5539k() {
        m3682c("tbody", "tfoot", "thead");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo5540k(C0813i iVar) {
        Iterator<C0813i> descendingIterator = this.f2436o.descendingIterator();
        while (descendingIterator.hasNext()) {
            if (descendingIterator.next() == iVar) {
                descendingIterator.remove();
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo5541l() {
        m3682c("tr");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public boolean mo5542l(C0813i iVar) {
        return m3678a(this.f2436o, iVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public void mo5543m() {
        C0813i iVar;
        boolean z = false;
        Iterator descendingIterator = this.f2469e.descendingIterator();
        while (descendingIterator.hasNext()) {
            C0813i iVar2 = (C0813i) descendingIterator.next();
            if (!descendingIterator.hasNext()) {
                z = true;
                iVar = this.f2435n;
            } else {
                z = z;
                iVar = iVar2;
            }
            String a = iVar.mo5302a();
            if ("select".equals(a)) {
                mo5499a(EnumC0875c.InSelect);
                return;
            } else if ("td".equals(a) || ("td".equals(a) && !z)) {
                mo5499a(EnumC0875c.InCell);
                return;
            } else if ("tr".equals(a)) {
                mo5499a(EnumC0875c.InRow);
                return;
            } else if ("tbody".equals(a) || "thead".equals(a) || "tfoot".equals(a)) {
                mo5499a(EnumC0875c.InTableBody);
                return;
            } else if ("caption".equals(a)) {
                mo5499a(EnumC0875c.InCaption);
                return;
            } else if ("colgroup".equals(a)) {
                mo5499a(EnumC0875c.InColumnGroup);
                return;
            } else if ("table".equals(a)) {
                mo5499a(EnumC0875c.InTable);
                return;
            } else if ("head".equals(a)) {
                mo5499a(EnumC0875c.InBody);
                return;
            } else if (C1370a.f3234z.equals(a)) {
                mo5499a(EnumC0875c.InBody);
                return;
            } else if ("frameset".equals(a)) {
                mo5499a(EnumC0875c.InFrameset);
                return;
            } else if ("html".equals(a)) {
                mo5499a(EnumC0875c.BeforeHead);
                return;
            } else if (z) {
                mo5499a(EnumC0875c.InBody);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public C0813i mo5544n() {
        return this.f2433l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public boolean mo5545o() {
        return this.f2439r;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public C0813i mo5546p() {
        return this.f2434m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public void mo5547q() {
        this.f2437p = new ArrayList();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public List<C0829ah> mo5548r() {
        return this.f2437p;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public void mo5549s() {
        mo5537j((String) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: t */
    public void mo5550t() {
        boolean z;
        C0813i iVar;
        int i;
        int size = this.f2436o.size();
        if (size != 0 && this.f2436o.getLast() != null && !mo5519d(this.f2436o.getLast())) {
            int i2 = size - 1;
            C0813i last = this.f2436o.getLast();
            while (true) {
                if (i2 == 0) {
                    i = i2;
                    iVar = last;
                    z = true;
                    break;
                }
                i2--;
                C0813i iVar2 = this.f2436o.get(i2);
                if (iVar2 == null) {
                    z = false;
                    iVar = iVar2;
                    i = i2;
                    break;
                } else if (mo5519d(iVar2)) {
                    z = false;
                    iVar = iVar2;
                    i = i2;
                    break;
                } else {
                    last = iVar2;
                }
            }
            while (true) {
                if (!z) {
                    int i3 = i + 1;
                    iVar = this.f2436o.get(i3);
                    i = i3;
                }
                C0803k.m3393a(iVar);
                C0813i a = mo5492a(iVar.mo5302a());
                a.mo5369x().mo5290a(iVar.mo5369x());
                this.f2436o.add(i, a);
                this.f2436o.remove(i + 1);
                if (i != size - 1) {
                    z = false;
                } else {
                    return;
                }
            }
        }
    }

    public String toString() {
        return "TreeBuilder{currentToken=" + this.f2471g + ", state=" + this.f2430i + ", currentElement=" + mo5556x() + '}';
    }

    /* access modifiers changed from: package-private */
    /* renamed from: u */
    public void mo5552u() {
        while (!this.f2436o.isEmpty()) {
            C0813i peekLast = this.f2436o.peekLast();
            this.f2436o.removeLast();
            if (peekLast == null) {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v */
    public void mo5553v() {
        this.f2436o.add(null);
    }
}
