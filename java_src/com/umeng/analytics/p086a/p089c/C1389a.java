package com.umeng.analytics.p086a.p089c;

import com.umeng.analytics.p086a.p087a.C1376d;
import com.umeng.analytics.p086a.p088b.C1387a;
import com.umeng.p085a.C1346h;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.umeng.analytics.a.c.a */
/* compiled from: UMCCAggregatedListObject */
public class C1389a implements Serializable {

    /* renamed from: a */
    private static final long f3277a = 1;

    /* renamed from: b */
    private Map<List<String>, C1391b> f3278b = new HashMap();

    /* renamed from: c */
    private long f3279c = 0;

    /* renamed from: a */
    public Map<List<String>, C1391b> mo8417a() {
        return this.f3278b;
    }

    /* renamed from: a */
    public void mo8423a(Map<List<String>, C1391b> map) {
        if (this.f3278b.size() <= 0) {
            this.f3278b = map;
        } else {
            m5114b(map);
        }
    }

    /* renamed from: b */
    private void m5114b(Map<List<String>, C1391b> map) {
        new ArrayList();
        new ArrayList();
        Iterator<Map.Entry<List<String>, C1391b>> it = this.f3278b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<List<String>, C1391b> next = it.next();
            List<String> key = next.getKey();
            Iterator<Map.Entry<List<String>, C1391b>> it2 = this.f3278b.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<List<String>, C1391b> next2 = it2.next();
                List<String> key2 = next.getKey();
                if (!key.equals(key2)) {
                    this.f3278b.put(key2, next2.getValue());
                } else {
                    C1391b value = next2.getValue();
                    m5113a(next.getValue(), value);
                    this.f3278b.remove(key);
                    this.f3278b.put(key, value);
                }
            }
        }
    }

    /* renamed from: a */
    private void m5113a(C1391b bVar, C1391b bVar2) {
        bVar2.mo8440c(bVar2.mo8444g() + bVar.mo8444g());
        bVar2.mo8436b(bVar2.mo8443f() + bVar.mo8443f());
        bVar2.mo8430a(bVar2.mo8442e() + bVar.mo8442e());
        for (int i = 0; i < bVar.mo8441d().size(); i++) {
            bVar2.mo8433a(bVar.mo8441d().get(i));
        }
    }

    /* renamed from: b */
    public long mo8426b() {
        return this.f3279c;
    }

    /* renamed from: a */
    public void mo8418a(long j) {
        this.f3279c = j;
    }

    /* renamed from: a */
    public void mo8420a(final C1387a aVar, C1394e eVar) {
        try {
            if (mo8424a(eVar.mo8455a())) {
                C1391b bVar = this.f3278b.get(eVar.mo8455a());
                if (bVar != null) {
                    bVar.mo8431a(new C1387a() {
                        /* class com.umeng.analytics.p086a.p089c.C1389a.C13901 */

                        @Override // com.umeng.analytics.p086a.p088b.AbstractC1388b, com.umeng.analytics.p086a.p088b.C1387a
                        /* renamed from: a */
                        public void mo8391a(Object obj, boolean z) {
                            C1391b bVar = (C1391b) obj;
                            C1389a.this.f3278b.remove(bVar.mo8429a());
                            C1389a.this.f3278b.put(bVar.mo8435b(), bVar);
                            aVar.mo8391a(this, false);
                        }
                    }, eVar);
                } else {
                    mo8422a(aVar, eVar.mo8455a(), eVar);
                }
            } else {
                mo8422a(aVar, eVar.mo8455a(), eVar);
            }
        } catch (Exception e) {
            C1346h.m5009e("aggregated faild!");
        }
    }

    /* renamed from: a */
    public void mo8422a(C1387a aVar, List<String> list, C1394e eVar) {
        C1391b bVar = new C1391b();
        bVar.mo8432a(eVar);
        this.f3278b.put(list, bVar);
        aVar.mo8391a(this, false);
    }

    /* renamed from: a */
    public boolean mo8424a(List<?> list) {
        if (this.f3278b == null || !this.f3278b.containsKey(list)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public void mo8419a(C1387a aVar) {
        for (List<String> list : this.f3278b.keySet()) {
            if (!aVar.mo8416a()) {
                aVar.mo8391a(this.f3278b.get(list), false);
            } else {
                return;
            }
        }
    }

    /* renamed from: c */
    public int mo8427c() {
        if (this.f3278b != null) {
            return this.f3278b.size();
        }
        return 0;
    }

    /* renamed from: d */
    public void mo8428d() {
        this.f3278b.clear();
    }

    /* renamed from: a */
    public boolean mo8425a(List<String> list, List<String> list2) {
        if (list == null || list.size() == 0) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size() - 1; i++) {
            arrayList.add(C1376d.m5105b(list.get(i)));
        }
        if (list == null || list.size() == 0) {
            return false;
        }
        return arrayList.contains(list2);
    }

    /* renamed from: a */
    public void mo8421a(C1387a aVar, C1394e eVar, List<String> list, List<String> list2) {
        while (list.size() >= 1) {
            try {
                if (list.size() == 1) {
                    if (!mo8425a(list2, list)) {
                        aVar.mo8391a(false, false);
                        return;
                    } else {
                        m5112a(aVar, eVar, list);
                        return;
                    }
                } else if (mo8425a(list2, list)) {
                    m5112a(aVar, eVar, list);
                    return;
                } else {
                    list.remove(list.size() - 1);
                }
            } catch (Exception e) {
                C1346h.m5009e("overFlowAggregated faild");
                return;
            }
        }
    }

    /* renamed from: a */
    private void m5112a(C1387a aVar, C1394e eVar, List<String> list) {
        if (mo8424a(list)) {
            mo8420a(aVar, eVar);
        } else {
            mo8422a(aVar, list, eVar);
        }
    }
}
