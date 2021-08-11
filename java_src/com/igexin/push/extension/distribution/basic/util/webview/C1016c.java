package com.igexin.push.extension.distribution.basic.util.webview;

import android.os.Process;
import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.p012b.p013a.p020d.AbstractC0470d;
import com.igexin.push.extension.distribution.basic.p054i.C0977g;
import com.igexin.push.extension.distribution.basic.p054i.p056b.C0809e;
import com.igexin.push.extension.distribution.basic.p054i.p056b.C0813i;
import com.igexin.push.extension.distribution.basic.p054i.p058d.C0954f;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.basic.util.webview.c */
public class C1016c extends AbstractC0470d {

    /* renamed from: a */
    String f2578a;

    /* renamed from: b */
    File f2579b;

    /* renamed from: c */
    String f2580c;

    /* renamed from: d */
    Queue<C1014a> f2581d;

    /* renamed from: e */
    int f2582e = 1;

    C1016c(String str, String str2, int i, File file) {
        super(i);
        this.f2578a = str;
        this.f2580c = str2;
        this.f2579b = file;
    }

    /* renamed from: a */
    private String m4077a(String str) {
        int lastIndexOf = str.lastIndexOf(47) + 1;
        if (lastIndexOf <= 0) {
            return null;
        }
        String substring = str.substring(lastIndexOf);
        String str2 = "";
        int lastIndexOf2 = substring.lastIndexOf(46) + 1;
        if (lastIndexOf2 >= 0) {
            int indexOf = substring.indexOf(63, lastIndexOf2);
            str2 = indexOf >= 0 ? substring.substring(lastIndexOf2, indexOf) : substring.substring(lastIndexOf2);
        }
        StringBuilder sb = new StringBuilder();
        int i = this.f2582e;
        this.f2582e = i + 1;
        return "res/" + sb.append(String.valueOf(i)).append("_").append(str2).toString();
    }

    /* renamed from: a */
    private void m4078a(C0809e eVar) {
        C0954f b = eVar.mo5330b("meta");
        int size = b.size();
        for (int i = 0; i < size; i++) {
            C0813i a = b.get(i);
            if (a.mo5365e("content")) {
                a.mo5329b("content", "text/html;charset=utf-8");
            }
        }
    }

    /* renamed from: a */
    private void m4079a(C0809e eVar, String str, String str2) {
        String g;
        String a;
        C0954f b = eVar.mo5330b(str);
        int size = b.size();
        for (int i = 0; i < size; i++) {
            C0813i a2 = b.get(i);
            if (!(a2.mo5362d(str2) == null || (a = m4077a((g = a2.mo5368g(str2)))) == null)) {
                a2.mo5329b(str2, a);
                this.f2581d.add(new C1014a(this.f2579b.getAbsolutePath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + a, g));
            }
        }
    }

    /* renamed from: b */
    private C0809e m4080b(String str) {
        try {
            return C0977g.m3930a(new URL(str), 60000);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: b */
    private void m4081b(C0809e eVar, String str, String str2) {
        String g;
        C0954f b = eVar.mo5330b(str);
        int size = b.size();
        for (int i = 0; i < size; i++) {
            C0813i a = b.get(i);
            String d = a.mo5362d(str2);
            if (!(d == null || d.startsWith("javascript:") || (g = a.mo5368g(str2)) == d)) {
                a.mo5329b(str2, g);
            }
        }
    }

    /* renamed from: g */
    private String m4082g() {
        C0809e b = m4080b(this.f2580c);
        if (b != null) {
            this.f2581d = new LinkedList();
            m4079a(b, "link", "href");
            m4079a(b, "img", "src");
            m4079a(b, "script", "src");
            m4081b(b, "a", "href");
            m4078a(b);
            return b.mo5313e_();
        }
        throw new IOException("getDocumentByUrl failed: " + this.f2580c);
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public final int mo4136b() {
        return -559105;
    }

    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: b_ */
    public void mo4137b_() {
        super.mo4137b_();
        Process.setThreadPriority(10);
        String g = m4082g();
        FileOutputStream fileOutputStream = new FileOutputStream(new File(this.f2579b, C1020g.f2595b));
        fileOutputStream.write(g.getBytes("utf-8"));
        fileOutputStream.flush();
        fileOutputStream.close();
        C0456c.m1661b().mo4218a(this);
        C0456c.m1661b().mo4171c();
    }

    /* access modifiers changed from: protected */
    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: e */
    public void mo4127e() {
    }
}
