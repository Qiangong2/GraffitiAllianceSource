package com.igexin.push.extension.distribution.basic.util.webview;

import com.igexin.push.extension.distribution.basic.p053h.AbstractC0773f;
import java.io.FileOutputStream;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.basic.util.webview.b */
public class C1015b extends AbstractC0773f {

    /* renamed from: a */
    String f2574a;

    /* renamed from: h */
    String f2575h;

    /* renamed from: i */
    String f2576i;

    /* renamed from: j */
    int f2577j;

    public C1015b(String str, String str2, String str3, int i) {
        super(str);
        this.f2575h = str;
        this.f2574a = str2;
        this.f2576i = str3;
        this.f2577j = i;
    }

    @Override // com.igexin.push.extension.distribution.basic.p053h.AbstractC0773f
    /* renamed from: a */
    public void mo4764a(byte[] bArr) {
        this.f2145g = false;
        FileOutputStream fileOutputStream = new FileOutputStream(this.f2574a);
        fileOutputStream.write(bArr);
        fileOutputStream.flush();
        fileOutputStream.close();
        this.f2145g = true;
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public final int mo4136b() {
        return 559106;
    }
}
