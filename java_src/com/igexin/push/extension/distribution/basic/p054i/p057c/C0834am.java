package com.igexin.push.extension.distribution.basic.p054i.p057c;

import com.igexin.push.extension.distribution.basic.p054i.p056b.C0806b;
import com.j256.ormlite.stmt.query.SimpleComparison;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.basic.i.c.am */
public class C0834am extends AbstractC0835an {
    C0834am() {
        this.f2327a = EnumC0836ao.StartTag;
    }

    C0834am(String str) {
        this();
        this.f2334b = str;
    }

    C0834am(String str, C0806b bVar) {
        this();
        this.f2334b = str;
        this.f2336d = bVar;
    }

    public String toString() {
        return SimpleComparison.LESS_THAN_OPERATION + mo5449o() + " " + this.f2336d.toString() + SimpleComparison.GREATER_THAN_OPERATION;
    }
}
