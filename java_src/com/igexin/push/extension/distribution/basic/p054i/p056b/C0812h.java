package com.igexin.push.extension.distribution.basic.p054i.p056b;

import com.igexin.push.extension.distribution.basic.p054i.p055a.C0802j;
import com.igexin.push.extension.distribution.basic.p054i.p055a.C0803k;

/* renamed from: com.igexin.push.extension.distribution.basic.i.b.h */
public class C0812h extends AbstractC0816l {
    public C0812h(String str, String str2, String str3, String str4) {
        super(str4);
        C0803k.m3395a(str);
        mo5329b("name", str);
        mo5329b("publicId", str2);
        mo5329b("systemId", str3);
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p056b.AbstractC0816l
    /* renamed from: a */
    public String mo5302a() {
        return "#doctype";
    }

    /* access modifiers changed from: package-private */
    @Override // com.igexin.push.extension.distribution.basic.p054i.p056b.AbstractC0816l
    /* renamed from: a */
    public void mo5303a(StringBuilder sb, int i, C0810f fVar) {
        sb.append("<!DOCTYPE ").append(mo5362d("name"));
        if (!C0802j.m3388a(mo5362d("publicId"))) {
            sb.append(" PUBLIC \"").append(mo5362d("publicId")).append("\"");
        }
        if (!C0802j.m3388a(mo5362d("systemId"))) {
            sb.append(" \"").append(mo5362d("systemId")).append("\"");
        }
        sb.append('>');
    }

    /* access modifiers changed from: package-private */
    @Override // com.igexin.push.extension.distribution.basic.p054i.p056b.AbstractC0816l
    /* renamed from: b */
    public void mo5305b(StringBuilder sb, int i, C0810f fVar) {
    }
}
