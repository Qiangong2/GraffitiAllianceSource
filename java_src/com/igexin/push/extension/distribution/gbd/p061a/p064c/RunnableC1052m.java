package com.igexin.push.extension.distribution.gbd.p061a.p064c;

import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.igexin.push.extension.distribution.gbd.p076i.C1116e;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.igexin.push.extension.distribution.gbd.a.c.m */
class RunnableC1052m implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1048i f2701a;

    /* renamed from: b */
    private List<String> f2702b;

    /* renamed from: c */
    private HashMap<String, String> f2703c;

    public RunnableC1052m(C1048i iVar, List<String> list, HashMap<String, String> hashMap) {
        this.f2701a = iVar;
        this.f2702b = list;
        this.f2703c = hashMap;
    }

    public void run() {
        try {
            if (this.f2702b != null) {
                for (String str : this.f2702b) {
                    if (C1116e.m4586c(str)) {
                        this.f2701a.f2697g.put(str, this.f2703c.get(str));
                    } else {
                        this.f2701a.f2698h.put(str, this.f2703c.get(str));
                    }
                }
            }
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
    }
}
