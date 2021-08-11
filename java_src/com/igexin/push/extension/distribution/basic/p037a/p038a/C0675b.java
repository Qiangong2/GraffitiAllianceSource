package com.igexin.push.extension.distribution.basic.p037a.p038a;

import android.text.TextUtils;
import com.igexin.push.core.bean.BaseAction;
import org.json.JSONObject;

/* renamed from: com.igexin.push.extension.distribution.basic.a.a.b */
public class C0675b extends BaseAction {

    /* renamed from: a */
    private String f1827a;

    /* renamed from: b */
    private String f1828b;

    /* renamed from: c */
    private C0676c[] f1829c;

    /* renamed from: c */
    public static C0675b m2622c(String str) {
        C0675b bVar;
        String[] split;
        int length;
        EnumC0677d dVar;
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("versions") && (length = (split = jSONObject.getString("versions").split("\\,")).length) > 0) {
                C0676c[] cVarArr = new C0676c[length];
                for (int i = 0; i < length; i++) {
                    String trim = split[i].trim();
                    if (trim.length() <= 2) {
                        return null;
                    }
                    C0676c cVar = new C0676c();
                    if (trim.charAt(0) == 'A') {
                        dVar = EnumC0677d.A;
                    } else if (trim.charAt(0) == 'V') {
                        dVar = EnumC0677d.V;
                    } else if (trim.charAt(0) != 'S') {
                        return null;
                    } else {
                        dVar = EnumC0677d.S;
                    }
                    cVar.mo4757a(dVar);
                    if (trim.charAt(1) == '<') {
                        cVar.mo4756a(-1);
                    } else if (trim.charAt(1) != '=') {
                        return null;
                    } else {
                        cVar.mo4756a(0);
                    }
                    cVar.mo4758a(trim.substring(2));
                    cVarArr[i] = cVar;
                }
                bVar = new C0675b();
                bVar.mo4751a(cVarArr);
                if (jSONObject.has("actionid")) {
                    bVar.setActionId(jSONObject.getString("actionid"));
                }
                if (jSONObject.has("type")) {
                    bVar.setType(jSONObject.getString("type"));
                }
                if (jSONObject.has("do_match")) {
                    bVar.mo4750a(jSONObject.getString("do_match"));
                }
                if (jSONObject.has("do_dismatch")) {
                    bVar.mo4753b(jSONObject.getString("do_dismatch"));
                }
                if (jSONObject.has("do")) {
                    bVar.setDoActionId(jSONObject.getString("do"));
                }
                return bVar;
            }
        }
        bVar = null;
        return bVar;
    }

    /* renamed from: a */
    public String mo4749a() {
        return this.f1827a;
    }

    /* renamed from: a */
    public void mo4750a(String str) {
        this.f1827a = str;
    }

    /* renamed from: a */
    public void mo4751a(C0676c[] cVarArr) {
        this.f1829c = cVarArr;
    }

    /* renamed from: b */
    public String mo4752b() {
        return this.f1828b;
    }

    /* renamed from: b */
    public void mo4753b(String str) {
        this.f1828b = str;
    }

    /* renamed from: c */
    public C0676c[] mo4754c() {
        return this.f1829c;
    }
}
