package com.umeng.analytics.p086a.p090d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.umeng.analytics.p086a.p087a.C1371a;
import com.umeng.analytics.p086a.p087a.C1372b;
import com.umeng.analytics.p086a.p088b.C1387a;
import com.umeng.analytics.p086a.p089c.C1391b;
import com.umeng.analytics.p086a.p089c.C1393d;
import com.umeng.p085a.C1346h;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.umeng.analytics.a.d.c */
/* compiled from: UMCCStorageManager */
public class C1415c {

    /* renamed from: a */
    private static Context f3342a;

    /* access modifiers changed from: private */
    /* renamed from: com.umeng.analytics.a.d.c$a */
    /* compiled from: UMCCStorageManager */
    public static final class C1417a {

        /* renamed from: a */
        private static final C1415c f3343a = new C1415c();

        private C1417a() {
        }
    }

    private C1415c() {
        if (f3342a != null) {
        }
    }

    /* renamed from: a */
    public static C1415c m5221a(Context context) {
        f3342a = context;
        return C1417a.f3343a;
    }

    /* renamed from: a */
    public void mo8480a(C1387a aVar) {
        try {
            SQLiteDatabase a = C1372b.m5089a(f3342a).mo8407a();
            String a2 = C1371a.m5073a(a);
            String a3 = C1419e.m5243a(System.currentTimeMillis());
            if (a2.equals("0")) {
                aVar.mo8391a("faild", false);
                return;
            }
            if (!a2.equals(a3)) {
                C1371a.m5079a(a, aVar);
            } else {
                C1371a.m5084b(a, aVar);
            }
            C1372b.m5089a(f3342a).mo8409c();
        } catch (Exception e) {
            aVar.mo8391a(false, false);
            C1346h.m5009e("load agg data error");
        } finally {
            C1372b.m5089a(f3342a).mo8409c();
        }
    }

    /* renamed from: a */
    public void mo8483a(C1387a aVar, Map<List<String>, C1391b> map) {
        try {
            C1371a.m5081a(C1372b.m5089a(f3342a).mo8408b(), map.values());
            aVar.mo8391a("success", false);
        } catch (Exception e) {
            C1346h.m5009e("save agg data error");
        } finally {
            C1372b.m5089a(f3342a).mo8409c();
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    public JSONObject mo8479a() {
        try {
            JSONObject b = C1371a.m5083b(C1372b.m5089a(f3342a).mo8407a());
            C1372b.m5089a(f3342a).mo8409c();
            return b;
        } catch (Exception e) {
            C1346h.m5009e("upload agg date error");
            C1372b.m5089a(f3342a).mo8409c();
            return null;
        } catch (Throwable th) {
            C1372b.m5089a(f3342a).mo8409c();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: b */
    public JSONObject mo8486b(C1387a aVar) {
        try {
            JSONObject a = C1371a.m5074a(aVar, C1372b.m5089a(f3342a).mo8407a());
            C1372b.m5089a(f3342a).mo8409c();
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            C1372b.m5089a(f3342a).mo8409c();
            return null;
        } catch (Throwable th) {
            C1372b.m5089a(f3342a).mo8409c();
            throw th;
        }
    }

    /* renamed from: a */
    public void mo8484a(C1387a aVar, boolean z) {
        try {
            C1371a.m5077a(C1372b.m5089a(f3342a).mo8408b(), z, aVar);
        } catch (Exception e) {
            C1346h.m5009e("notifyUploadSuccess error");
        } finally {
            C1372b.m5089a(f3342a).mo8409c();
        }
    }

    /* renamed from: a */
    public void mo8481a(C1387a aVar, String str, long j, long j2) {
        try {
            C1371a.m5075a(C1372b.m5089a(f3342a).mo8408b(), str, j, j2);
            aVar.mo8391a("success", false);
        } catch (Exception e) {
            C1346h.m5009e("package size to big or envelopeOverflowPackageCount exception");
        } finally {
            C1372b.m5089a(f3342a).mo8409c();
        }
    }

    /* renamed from: a */
    public void mo8482a(C1387a aVar, List<String> list) {
        try {
            C1371a.m5078a(aVar, C1372b.m5089a(f3342a).mo8408b(), list);
        } catch (Exception e) {
            C1346h.m5009e("saveToLimitCKTable exception");
        } finally {
            C1372b.m5089a(f3342a).mo8409c();
        }
    }

    /* renamed from: b */
    public void mo8487b(C1387a aVar, Map<String, C1393d> map) {
        try {
            C1371a.m5076a(C1372b.m5089a(f3342a).mo8408b(), map, aVar);
        } catch (Exception e) {
            C1346h.m5009e("arrgetated system buffer exception");
        } finally {
            C1372b.m5089a(f3342a).mo8409c();
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: b */
    public List<String> mo8485b() {
        try {
            List<String> c = C1371a.m5087c(C1372b.m5089a(f3342a).mo8407a());
            C1372b.m5089a(f3342a).mo8409c();
            return c;
        } catch (Exception e) {
            C1346h.m5009e("loadCKToMemory exception");
            C1372b.m5089a(f3342a).mo8409c();
            return null;
        } catch (Throwable th) {
            C1372b.m5089a(f3342a).mo8409c();
            throw th;
        }
    }

    /* renamed from: c */
    public void mo8488c(C1387a aVar, Map<List<String>, C1391b> map) {
        try {
            C1371a.m5082a(aVar, C1372b.m5089a(f3342a).mo8408b(), map.values());
        } catch (Exception e) {
            C1346h.m5009e("cacheToData error");
        } finally {
            C1372b.m5089a(f3342a).mo8409c();
        }
    }
}
