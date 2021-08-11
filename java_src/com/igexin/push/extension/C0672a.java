package com.igexin.push.extension;

import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.C0618g;
import com.igexin.push.extension.stub.IPushExtension;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.igexin.push.extension.a */
public class C0672a {

    /* renamed from: a */
    private static String f1823a = C0672a.class.getName();

    /* renamed from: c */
    private static C0672a f1824c;

    /* renamed from: b */
    private List<IPushExtension> f1825b = new ArrayList();

    private C0672a() {
    }

    /* renamed from: a */
    public static C0672a m2607a() {
        if (f1824c == null) {
            f1824c = new C0672a();
        }
        return f1824c;
    }

    /* renamed from: e */
    private void m2608e() {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("com.igexin.push.extension.distribution.basic.stub.PushExtension");
        arrayList.add("com.igexin.push.extension.distribution.gbd.stub.PushExtension");
        for (String str : arrayList) {
            try {
                IPushExtension iPushExtension = (IPushExtension) Class.forName(str).newInstance();
                iPushExtension.init(C0618g.f1635f);
                this.f1825b.add(iPushExtension);
                ActivityC0460a.m1698b("init " + str);
            } catch (Exception e) {
                ActivityC0460a.m1698b(f1823a + e.toString());
            }
        }
    }

    /* renamed from: b */
    public boolean mo4745b() {
        try {
            m2608e();
            return true;
        } catch (Throwable th) {
            ActivityC0460a.m1698b(f1823a + "|" + th.toString());
            return false;
        }
    }

    /* renamed from: c */
    public void mo4746c() {
        for (IPushExtension iPushExtension : this.f1825b) {
            try {
                iPushExtension.onDestroy();
            } catch (Throwable th) {
                ActivityC0460a.m1698b(f1823a + th.toString());
            }
        }
    }

    /* renamed from: d */
    public List<IPushExtension> mo4747d() {
        return this.f1825b;
    }
}
