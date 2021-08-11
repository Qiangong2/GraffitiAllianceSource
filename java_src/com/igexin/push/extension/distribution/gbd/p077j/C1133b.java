package com.igexin.push.extension.distribution.gbd.p077j;

import com.igexin.push.extension.distribution.gbd.p066b.C1066i;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.igexin.push.extension.distribution.gbd.p077j.p078a.C1132a;

/* renamed from: com.igexin.push.extension.distribution.gbd.j.b */
public class C1133b {
    /* renamed from: a */
    public static AbstractC1134c m4647a(C1066i iVar) {
        if (iVar.mo5787a().equalsIgnoreCase("f")) {
            return new C1132a();
        }
        C1115d.m4559b("GBD_XmlChainFactory", " type = " + iVar.mo5787a() + " not support yet");
        return null;
    }
}
