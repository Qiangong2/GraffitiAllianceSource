package com.igexin.push.p026c;

import android.text.TextUtils;
import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.p012b.p013a.p015b.C0459f;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.config.C0514k;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.core.p029b.C0568g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.igexin.push.c.m */
public abstract class AbstractC0498m {

    /* renamed from: e */
    private static final String f1251e = AbstractC0498m.class.getName();

    /* renamed from: a */
    protected long f1252a;

    /* renamed from: b */
    protected final Map<String, C0501p> f1253b = new LinkedHashMap();

    /* renamed from: c */
    protected final Map<String, C0495j> f1254c = new HashMap();

    /* renamed from: d */
    protected C0486a f1255d = new C0486a();

    /* renamed from: f */
    private final Object f1256f = new Object();

    /* renamed from: g */
    private final Object f1257g = new Object();

    /* renamed from: h */
    private int f1258h;

    /* renamed from: i */
    private AtomicBoolean f1259i = new AtomicBoolean(false);

    /* renamed from: j */
    private final Comparator<Map.Entry<String, C0495j>> f1260j = new C0499n(this);

    /* renamed from: k */
    private int f1261k = m1883s();

    public AbstractC0498m(String str, String str2) {
        if (!C0494i.f1231a) {
            m1878b(str);
            m1880c(str2);
            return;
        }
        m1877a(false);
    }

    /* renamed from: a */
    private C0495j m1873a(JSONObject jSONObject) {
        if (!jSONObject.has("domain")) {
            return null;
        }
        C0495j jVar = new C0495j();
        jVar.mo4289a(jSONObject.getString("domain"));
        if (jSONObject.has("port")) {
            jVar.mo4287a(jSONObject.getInt("port"));
        }
        if (jSONObject.has("ip")) {
            jVar.mo4296b(jSONObject.getString("ip"));
        }
        if (jSONObject.has("consumeTime")) {
            jVar.mo4288a(jSONObject.getLong("consumeTime"));
        }
        if (jSONObject.has("detectSuccessTime")) {
            jVar.mo4295b(jSONObject.getLong("detectSuccessTime"));
        }
        if (jSONObject.has("isDomain")) {
            jVar.mo4291a(jSONObject.getBoolean("isDomain"));
        }
        if (!jSONObject.has("connectTryCnt")) {
            return jVar;
        }
        jVar.mo4294b(jSONObject.getInt("connectTryCnt"));
        return jVar;
    }

    /* renamed from: a */
    private List<String> m1874a() {
        String[] xfrAddress = SDKUrlConfig.getXfrAddress();
        ArrayList arrayList = new ArrayList();
        for (String str : xfrAddress) {
            if (!arrayList.contains(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private List<String> m1875a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(jSONArray.getJSONObject(i).getString("domain"));
            } catch (Exception e) {
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void mo4308a(C0495j jVar) {
        C0501p pVar = new C0501p();
        pVar.mo4331a(mo4310c());
        pVar.mo4330a(jVar);
        synchronized (this.f1257g) {
            this.f1253b.put(jVar.mo4286a(), pVar);
        }
        C0456c.m1661b().mo4216a(pVar, true, true);
    }

    /* renamed from: a */
    private void m1877a(boolean z) {
        this.f1252a = 0;
        if (m1884t()) {
            if (C0618g.f1625au != null) {
                C0568g.m2192a().mo4449b("null", true);
            }
        } else if (C0618g.f1626av != null) {
            C0568g.m2192a().mo4449b("null", false);
        }
        List<String> a = m1874a();
        ArrayList arrayList = new ArrayList();
        for (String str : a) {
            C0495j jVar = new C0495j(str, Integer.parseInt(C0459f.m1684a(str)[2]));
            if (z) {
                mo4308a(jVar);
            }
            arrayList.add(jVar);
        }
        this.f1255d.mo4265b(arrayList);
        a.clear();
    }

    /* renamed from: b */
    private void m1878b(String str) {
        JSONObject jSONObject;
        JSONArray jSONArray = null;
        if (TextUtils.isEmpty(str)) {
            m1877a(true);
            return;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            jSONObject = null;
        }
        if (jSONObject == null || jSONObject.length() == 0) {
            m1877a(true);
            return;
        }
        if (jSONObject.has("lastDetectTime")) {
            try {
                this.f1252a = jSONObject.getLong("lastDetectTime");
            } catch (JSONException e2) {
            }
        }
        if (Math.abs(System.currentTimeMillis() - this.f1252a) >= C0491f.f1222a) {
            m1877a(true);
            return;
        }
        if (jSONObject.has("list")) {
            try {
                jSONArray = jSONObject.getJSONArray("list");
            } catch (JSONException e3) {
            }
        }
        if (jSONArray == null || jSONArray.length() == 0) {
            m1877a(true);
            return;
        }
        List<String> a = m1875a(jSONArray);
        if (a == null || a.isEmpty()) {
            m1877a(true);
            return;
        }
        List<String> a2 = m1874a();
        ArrayList arrayList = new ArrayList(a2);
        arrayList.retainAll(a);
        if (arrayList.size() != a.size()) {
            ActivityC0460a.m1698b(f1251e + " | db cache xfr != default, use default");
            arrayList.clear();
            a2.clear();
            a.clear();
            m1877a(true);
            return;
        }
        ActivityC0460a.m1698b(f1251e + " | db cache xfr == default, use cache");
        m1879b(jSONArray);
    }

    /* renamed from: b */
    private void m1879b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                C0495j a = m1873a(jSONObject);
                if (a != null) {
                    this.f1254c.put(a.mo4286a(), a);
                } else {
                    try {
                        a = m1881d(jSONObject.getString("domain"));
                    } catch (Exception e) {
                        ActivityC0460a.m1698b(f1251e + "|initWithCacheData exception " + e.toString());
                        this.f1254c.clear();
                        m1877a(true);
                        return;
                    }
                }
                if (a != null) {
                    mo4308a(a);
                    arrayList.add(a);
                }
            } catch (Exception e2) {
                ActivityC0460a.m1698b(f1251e + "|initWithCacheData exception " + e2.toString());
                return;
            }
        }
        this.f1255d.mo4265b(arrayList);
    }

    /* renamed from: c */
    private void m1880c(String str) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                jSONObject = null;
            }
            if (jSONObject != null && jSONObject.length() != 0) {
                if (jSONObject.has("detectFailedCnt")) {
                    try {
                        this.f1258h = jSONObject.getInt("detectFailedCnt");
                    } catch (JSONException e2) {
                    }
                }
                if (jSONObject.has("loginFailedlCnt")) {
                    try {
                        this.f1255d.f1200c = jSONObject.getInt("loginFailedlCnt");
                    } catch (JSONException e3) {
                    }
                }
                if (jSONObject.has("lastChange2BackupTime")) {
                    try {
                        this.f1255d.f1201d = jSONObject.getLong("lastChange2BackupTime");
                    } catch (JSONException e4) {
                    }
                }
                if (jSONObject.has("lastOfflineTime")) {
                    try {
                        this.f1255d.f1202e = jSONObject.getLong("lastOfflineTime");
                    } catch (JSONException e5) {
                    }
                }
                if (jSONObject.has("domainType")) {
                    try {
                        this.f1255d.f1198a = EnumC0489d.m1831a(jSONObject.getInt("domainType"));
                        if (this.f1255d.f1198a == EnumC0489d.BACKUP) {
                            this.f1255d.f1199b.set(true);
                        }
                    } catch (JSONException e6) {
                    }
                }
            }
        }
    }

    /* renamed from: d */
    private C0495j m1881d(String str) {
        C0495j jVar = new C0495j();
        String[] a = C0459f.m1684a(str);
        jVar.mo4289a(str);
        jVar.mo4287a(Integer.parseInt(a[2]));
        return jVar;
    }

    /* renamed from: r */
    private void m1882r() {
        synchronized (this.f1256f) {
            this.f1254c.clear();
        }
    }

    /* renamed from: s */
    private int m1883s() {
        return m1874a().size();
    }

    /* renamed from: t */
    private boolean m1884t() {
        return mo4309b() == EnumC0493h.MOBILE;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0501p mo4311a(String str) {
        C0501p pVar;
        synchronized (this.f1257g) {
            Iterator<Map.Entry<String, C0501p>> it = this.f1253b.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    pVar = null;
                    break;
                }
                Map.Entry<String, C0501p> next = it.next();
                if (next.getKey().equals(str)) {
                    pVar = next.getValue();
                    break;
                }
            }
        }
        return pVar;
    }

    /* renamed from: b */
    public abstract EnumC0493h mo4309b();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo4312b(C0495j jVar) {
        synchronized (this.f1256f) {
            this.f1254c.put(jVar.mo4286a(), jVar);
        }
        this.f1255d.mo4267d();
    }

    /* renamed from: c */
    public abstract AbstractC0500o mo4310c();

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo4313c(C0495j jVar) {
        return jVar.mo4286a() + "[" + jVar.mo4297c() + "] ";
    }

    /* renamed from: d */
    public void mo4314d() {
        if (!mo4323m()) {
            ActivityC0460a.m1698b(f1251e + "|startDetect detect = false, return !!!");
            return;
        }
        ActivityC0460a.m1698b(f1251e + "|startDetect detect = true, start detect !!!");
        this.f1259i.set(true);
        mo4320j();
    }

    /* renamed from: e */
    public void mo4315e() {
        synchronized (this.f1257g) {
            for (Map.Entry<String, C0501p> entry : this.f1253b.entrySet()) {
                entry.getValue().mo4331a((AbstractC0500o) null);
                entry.getValue().mo4334g();
            }
        }
    }

    /* renamed from: f */
    public void mo4316f() {
        this.f1259i.set(true);
        synchronized (this.f1257g) {
            for (Map.Entry<String, C0501p> entry : this.f1253b.entrySet()) {
                entry.getValue().mo4331a(mo4310c());
                entry.getValue().mo4332a(true);
            }
        }
    }

    /* renamed from: g */
    public C0495j mo4317g() {
        C0495j jVar;
        synchronized (this.f1256f) {
            if (this.f1254c.isEmpty()) {
                jVar = null;
            } else {
                ArrayList arrayList = new ArrayList(this.f1254c.entrySet());
                Collections.sort(arrayList, this.f1260j);
                jVar = (C0495j) ((Map.Entry) arrayList.get(0)).getValue();
            }
        }
        return jVar;
    }

    /* renamed from: h */
    public void mo4318h() {
        mo4315e();
        m1882r();
        List<String> a = m1874a();
        synchronized (this.f1257g) {
            int size = this.f1253b.size();
            if (a.size() < size) {
                int size2 = size - a.size();
                Iterator<Map.Entry<String, C0501p>> it = this.f1253b.entrySet().iterator();
                int i = 0;
                while (it.hasNext() && i < size2) {
                    it.next().getValue().mo4335h();
                    it.remove();
                    i++;
                }
            }
            ArrayList arrayList = new ArrayList(this.f1253b.values());
            this.f1253b.clear();
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < a.size(); i2++) {
                C0495j jVar = new C0495j();
                String[] a2 = C0459f.m1684a(a.get(i2));
                jVar.mo4289a(a.get(i2));
                jVar.mo4287a(Integer.parseInt(a2[2]));
                if (i2 < size) {
                    C0501p pVar = (C0501p) arrayList.get(i2);
                    pVar.mo4330a(jVar);
                    this.f1253b.put(jVar.mo4286a(), pVar);
                } else {
                    mo4308a(jVar);
                }
                arrayList2.add(jVar);
            }
            this.f1255d.mo4265b(arrayList2);
        }
    }

    /* renamed from: i */
    public void mo4319i() {
        mo4315e();
        m1882r();
        List<String> a = m1874a();
        synchronized (this.f1257g) {
            for (Map.Entry<String, C0501p> entry : this.f1253b.entrySet()) {
                entry.getValue().mo4335h();
            }
            this.f1253b.clear();
            ArrayList arrayList = new ArrayList();
            C0495j jVar = new C0495j();
            String[] a2 = C0459f.m1684a(a.get(0));
            jVar.mo4289a(a.get(0));
            jVar.mo4287a(Integer.parseInt(a2[2]));
            arrayList.add(jVar);
            this.f1255d.mo4265b(arrayList);
            arrayList.clear();
        }
    }

    /* renamed from: j */
    public void mo4320j() {
        this.f1252a = System.currentTimeMillis();
        synchronized (this.f1257g) {
            for (Map.Entry<String, C0501p> entry : this.f1253b.entrySet()) {
                entry.getValue().mo4331a(mo4310c());
                if (entry.getValue().mo4333d_() != null) {
                    entry.getValue().mo4333d_().mo4293b();
                }
                entry.getValue().mo4336i();
            }
        }
    }

    /* renamed from: k */
    public synchronized void mo4321k() {
        this.f1252a = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        synchronized (this.f1257g) {
            try {
                jSONObject.put("lastDetectTime", this.f1252a);
                jSONObject.put("list", jSONArray);
                for (Map.Entry<String, C0501p> entry : this.f1253b.entrySet()) {
                    JSONObject i = entry.getValue().mo4333d_().mo4303i();
                    if (i != null) {
                        jSONArray.put(i);
                    }
                }
            } catch (Exception e) {
            }
        }
        if (jSONObject.length() > 0) {
            if (m1884t()) {
                C0568g.m2192a().mo4449b(jSONObject.toString(), true);
            } else {
                C0568g.m2192a().mo4449b(jSONObject.toString(), false);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void mo4322l() {
        C0568g.m2192a().mo4449b("null", true);
        C0568g.m2192a().mo4449b("null", false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public boolean mo4323m() {
        long abs = Math.abs(System.currentTimeMillis() - this.f1252a);
        if (abs >= C0491f.f1222a - 3600) {
            ActivityC0460a.m1698b(f1251e + "|current time - last detect time > " + (C0491f.f1222a / 1000) + " s, detect = true");
            C0496k.f1245a.set(true);
            return true;
        }
        if (!C0496k.f1245a.getAndSet(true)) {
            long abs2 = Math.abs(C0491f.f1222a - abs);
            C0496k.m1863c_().mo4305a(abs2);
            ActivityC0460a.m1698b(f1251e + "|set next detect time = " + abs2);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public synchronized void mo4324n() {
        if (!C0618g.f1641l && this.f1259i.getAndSet(false)) {
            ActivityC0460a.m1698b(f1251e + "|online = false, reconnect");
            C0535e.m2034a().mo4401d(true);
        }
        if (this.f1258h != 0) {
            this.f1258h = 0;
            mo4326p();
        }
        this.f1255d.mo4268e();
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public synchronized void mo4325o() {
        this.f1258h++;
        ActivityC0460a.m1698b(f1251e + "|detect failed cnt = " + (this.f1258h / this.f1261k));
        int i = this.f1258h / this.f1261k;
        if (i <= C0514k.f1333y) {
            mo4326p();
        }
        if (i >= C0514k.f1333y && !this.f1255d.f1199b.get()) {
            ActivityC0460a.m1698b(f1251e + "|detect failed cnt = " + (this.f1258h / this.f1261k) + ", enter backup ++++++++");
            this.f1255d.mo4269f();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public synchronized void mo4326p() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("detectFailedCnt", this.f1258h);
            jSONObject.put("loginFailedlCnt", this.f1255d.f1200c);
            jSONObject.put("lastChange2BackupTime", this.f1255d.f1201d);
            jSONObject.put("lastOfflineTime", this.f1255d.f1202e);
            jSONObject.put("domainType", this.f1255d.f1198a.mo4276b());
        } catch (Exception e) {
        }
        if (jSONObject.length() > 0) {
            if (m1884t()) {
                C0568g.m2192a().mo4443a(jSONObject.toString(), true);
            } else {
                C0568g.m2192a().mo4443a(jSONObject.toString(), false);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public boolean mo4327q() {
        boolean z;
        synchronized (this.f1256f) {
            Iterator<Map.Entry<String, C0495j>> it = this.f1254c.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getValue().mo4299e() != 2147483647L) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
        }
        return z;
    }
}
