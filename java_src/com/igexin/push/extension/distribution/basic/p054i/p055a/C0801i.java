package com.igexin.push.extension.distribution.basic.p054i.p055a;

import com.igexin.push.extension.distribution.basic.p054i.AbstractC0820c;
import com.igexin.push.extension.distribution.basic.p054i.AbstractC0975e;
import com.igexin.push.extension.distribution.basic.p054i.AbstractC0976f;
import com.igexin.push.extension.distribution.basic.p054i.EnumC0933d;
import com.igexin.push.extension.distribution.basic.p054i.p056b.C0809e;
import com.igexin.push.extension.distribution.basic.p054i.p057c.C0837ap;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* renamed from: com.igexin.push.extension.distribution.basic.i.a.i */
public class C0801i extends AbstractC0799g<AbstractC0976f> implements AbstractC0976f {

    /* renamed from: e */
    private int f2256e;

    /* renamed from: f */
    private String f2257f;

    /* renamed from: g */
    private ByteBuffer f2258g;

    /* renamed from: h */
    private String f2259h;

    /* renamed from: i */
    private String f2260i;

    /* renamed from: j */
    private boolean f2261j = false;

    /* renamed from: k */
    private int f2262k = 0;

    /* renamed from: l */
    private AbstractC0975e f2263l;

    C0801i() {
        super();
    }

    private C0801i(C0801i iVar) {
        super();
        if (iVar != null) {
            this.f2262k = iVar.f2262k + 1;
            if (this.f2262k >= 20) {
                throw new IOException(String.format("Too many redirects occurred trying to load URL %s", iVar.mo5256a()));
            }
        }
    }

    /* renamed from: a */
    static C0801i m3369a(AbstractC0975e eVar) {
        return m3370a(eVar, (C0801i) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x014f  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.igexin.push.extension.distribution.basic.p054i.p055a.C0801i m3370a(com.igexin.push.extension.distribution.basic.p054i.AbstractC0975e r6, com.igexin.push.extension.distribution.basic.p054i.p055a.C0801i r7) {
        /*
        // Method dump skipped, instructions count: 341
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.p054i.p055a.C0801i.m3370a(com.igexin.push.extension.distribution.basic.i.e, com.igexin.push.extension.distribution.basic.i.a.i):com.igexin.push.extension.distribution.basic.i.a.i");
    }

    /* renamed from: a */
    private void m3371a(HttpURLConnection httpURLConnection, AbstractC0976f fVar) {
        this.f2247b = null;
        if (httpURLConnection.getRequestMethod().equalsIgnoreCase("GET")) {
            this.f2247b = EnumC0933d.GET;
        } else {
            this.f2247b = EnumC0933d.POST;
        }
        this.f2246a = httpURLConnection.getURL();
        this.f2256e = httpURLConnection.getResponseCode();
        this.f2257f = httpURLConnection.getResponseMessage();
        this.f2260i = httpURLConnection.getContentType();
        mo5272a(httpURLConnection.getHeaderFields());
        if (fVar != null) {
            for (Map.Entry<String, String> entry : fVar.mo5262d().entrySet()) {
                if (!mo5263d(entry.getKey())) {
                    mo5253a(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    /* renamed from: a */
    private static void m3372a(Collection<AbstractC0820c> collection, OutputStream outputStream) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
        boolean z = true;
        for (AbstractC0820c cVar : collection) {
            if (!z) {
                outputStreamWriter.append('&');
            } else {
                z = false;
            }
            outputStreamWriter.write(URLEncoder.encode(cVar.mo5374a(), "UTF-8"));
            outputStreamWriter.write(61);
            outputStreamWriter.write(URLEncoder.encode(cVar.mo5375b(), "UTF-8"));
        }
        outputStreamWriter.close();
    }

    /* renamed from: b */
    private static HttpURLConnection m3373b(AbstractC0975e eVar) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) eVar.mo5256a().openConnection();
        httpURLConnection.setRequestMethod(eVar.mo5258b().name());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setConnectTimeout(eVar.mo5266e());
        httpURLConnection.setReadTimeout(eVar.mo5266e());
        if (eVar.mo5258b() == EnumC0933d.POST) {
            httpURLConnection.setDoOutput(true);
        }
        if (eVar.mo5262d().size() > 0) {
            httpURLConnection.addRequestProperty("Cookie", m3374c(eVar));
        }
        for (Map.Entry<String, String> entry : eVar.mo5261c().entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
        return httpURLConnection;
    }

    /* renamed from: c */
    private static String m3374c(AbstractC0975e eVar) {
        boolean z;
        StringBuilder sb = new StringBuilder();
        boolean z2 = true;
        for (Map.Entry<String, String> entry : eVar.mo5262d().entrySet()) {
            if (!z2) {
                sb.append("; ");
                z = z2;
            } else {
                z = false;
            }
            sb.append(entry.getKey()).append('=').append(entry.getValue());
            z2 = z;
        }
        return sb.toString();
    }

    /* renamed from: d */
    private static void m3375d(AbstractC0975e eVar) {
        URL a = eVar.mo5256a();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        sb.append(a.getProtocol()).append("://").append(a.getAuthority()).append(a.getPath()).append("?");
        if (a.getQuery() != null) {
            sb.append(a.getQuery());
            z = false;
        }
        boolean z2 = z;
        for (AbstractC0820c cVar : eVar.mo5270i()) {
            if (!z2) {
                sb.append('&');
            } else {
                z2 = false;
            }
            sb.append(URLEncoder.encode(cVar.mo5374a(), "UTF-8")).append('=').append(URLEncoder.encode(cVar.mo5375b(), "UTF-8"));
        }
        eVar.mo5254a(new URL(sb.toString()));
        eVar.mo5270i().clear();
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p055a.AbstractC0799g
    /* renamed from: a */
    public /* bridge */ /* synthetic */ String mo5255a(String str) {
        return super.mo5255a(str);
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p055a.AbstractC0799g, com.igexin.push.extension.distribution.basic.p054i.AbstractC0804b
    /* renamed from: a */
    public /* bridge */ /* synthetic */ URL mo5256a() {
        return super.mo5256a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5272a(Map<String, List<String>> map) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key != null) {
                List<String> value = entry.getValue();
                if (key.equalsIgnoreCase("Set-Cookie")) {
                    for (String str : value) {
                        if (str != null) {
                            C0837ap apVar = new C0837ap(str);
                            String trim = apVar.mo5464e(SimpleComparison.EQUAL_TO_OPERATION).trim();
                            String trim2 = apVar.mo5463d(";").trim();
                            if (trim2 == null) {
                                trim2 = "";
                            }
                            if (trim != null && trim.length() > 0) {
                                mo5253a(trim, trim2);
                            }
                        }
                    }
                } else if (!value.isEmpty()) {
                    mo5257b(key, value.get(0));
                }
            }
        }
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p055a.AbstractC0799g, com.igexin.push.extension.distribution.basic.p054i.AbstractC0804b
    /* renamed from: b */
    public /* bridge */ /* synthetic */ EnumC0933d mo5258b() {
        return super.mo5258b();
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p055a.AbstractC0799g
    /* renamed from: b */
    public /* bridge */ /* synthetic */ boolean mo5259b(String str) {
        return super.mo5259b(str);
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p055a.AbstractC0799g, com.igexin.push.extension.distribution.basic.p054i.AbstractC0804b
    /* renamed from: c */
    public /* bridge */ /* synthetic */ Map mo5261c() {
        return super.mo5261c();
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p055a.AbstractC0799g, com.igexin.push.extension.distribution.basic.p054i.AbstractC0804b
    /* renamed from: d */
    public /* bridge */ /* synthetic */ Map mo5262d() {
        return super.mo5262d();
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p055a.AbstractC0799g
    /* renamed from: d */
    public /* bridge */ /* synthetic */ boolean mo5263d(String str) {
        return super.mo5263d(str);
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.AbstractC0976f
    /* renamed from: e */
    public C0809e mo5273e() {
        C0803k.m3398a(this.f2261j, "Request must be executed (with .execute(), .get(), or .post() before parsing response");
        if (this.f2263l.mo5269h() || (this.f2260i != null && (this.f2260i.startsWith("text/") || this.f2260i.startsWith("application/xml") || this.f2260i.startsWith("application/xhtml+xml")))) {
            C0809e a = C0793a.m3332a(this.f2258g, this.f2259h, this.f2246a.toExternalForm(), this.f2263l.mo5271j());
            this.f2258g.rewind();
            this.f2259h = a.mo5311d().mo5319b().name();
            return a;
        }
        throw new IOException(String.format("Unhandled content type \"%s\" on URL %s. Must be text/*, application/xml, or application/xhtml+xml", this.f2260i, this.f2246a.toString()));
    }
}
