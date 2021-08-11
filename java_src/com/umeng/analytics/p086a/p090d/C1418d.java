package com.umeng.analytics.p086a.p090d;

import android.text.TextUtils;
import com.umeng.analytics.p086a.p088b.C1387a;
import com.umeng.analytics.p086a.p089c.C1393d;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.umeng.analytics.a.d.d */
/* compiled from: UMCCSystemBufferManager */
public class C1418d implements Serializable {

    /* renamed from: a */
    private static final long f3344a = 1;

    /* renamed from: b */
    private Map<String, C1393d> f3345b = new HashMap();

    /* renamed from: a */
    public void mo8490a(C1387a aVar, String str) {
        if (this.f3345b.containsKey(str)) {
            m5235c(str);
        } else {
            m5234b(str);
        }
        aVar.mo8391a(this, false);
    }

    /* renamed from: a */
    public Map<String, C1393d> mo8489a() {
        return this.f3345b;
    }

    /* renamed from: b */
    public void mo8494b() {
        this.f3345b.clear();
    }

    /* renamed from: a */
    public void mo8492a(Map<String, C1393d> map) {
        this.f3345b = map;
    }

    /* renamed from: a */
    public boolean mo8493a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (Map.Entry<String, C1393d> entry : this.f3345b.entrySet()) {
            if (entry.getKey().equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m5234b(String str) {
        this.f3345b.put(str, new C1393d(str, System.currentTimeMillis(), 1));
    }

    /* renamed from: c */
    private void m5235c(String str) {
        this.f3345b.put(str, this.f3345b.get(str).mo8447a());
    }

    /* renamed from: a */
    public void mo8491a(C1393d dVar) {
        if (mo8493a(dVar.mo8452c())) {
            m5233b(dVar);
        } else {
            this.f3345b.put(dVar.mo8452c(), dVar);
        }
    }

    /* renamed from: b */
    private void m5233b(C1393d dVar) {
        this.f3345b.put(dVar.mo8452c(), this.f3345b.get(dVar.mo8452c()).mo8448a(dVar));
    }
}
