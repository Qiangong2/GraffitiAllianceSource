package com.xiaomi.network;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.xiaomi.network.e */
class C1917e implements Comparable<C1917e> {

    /* renamed from: a */
    String f4925a;

    /* renamed from: b */
    protected int f4926b;

    /* renamed from: c */
    private final LinkedList<AccessHistory> f4927c;

    /* renamed from: d */
    private long f4928d;

    public C1917e() {
        this(null, 0);
    }

    public C1917e(String str, int i) {
        this.f4927c = new LinkedList<>();
        this.f4928d = 0;
        this.f4925a = str;
        this.f4926b = i;
    }

    /* renamed from: a */
    public int compareTo(C1917e eVar) {
        if (eVar == null) {
            return 1;
        }
        return eVar.f4926b - this.f4926b;
    }

    /* renamed from: a */
    public synchronized C1917e mo10297a(JSONObject jSONObject) {
        this.f4928d = jSONObject.getLong("tt");
        this.f4926b = jSONObject.getInt("wt");
        this.f4925a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f4927c.add(new AccessHistory().mo10219a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    /* renamed from: a */
    public synchronized ArrayList<AccessHistory> mo10298a() {
        ArrayList<AccessHistory> arrayList;
        arrayList = new ArrayList<>();
        Iterator<AccessHistory> it = this.f4927c.iterator();
        while (it.hasNext()) {
            AccessHistory next = it.next();
            if (next.mo10221c() > this.f4928d) {
                arrayList.add(next);
            }
        }
        this.f4928d = System.currentTimeMillis();
        return arrayList;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public synchronized void mo10299a(AccessHistory accessHistory) {
        if (accessHistory != null) {
            UploadHostStatHelper.m7074a().mo10291b();
            this.f4927c.add(accessHistory);
            int a = accessHistory.mo10218a();
            if (a > 0) {
                this.f4926b += accessHistory.mo10218a();
            } else {
                int i = 0;
                int size = this.f4927c.size() - 1;
                while (size >= 0 && this.f4927c.get(size).mo10218a() < 0) {
                    i++;
                    size--;
                }
                this.f4926b += a * i;
            }
            if (this.f4927c.size() > 30) {
                this.f4926b -= this.f4927c.remove().mo10218a();
            }
        }
    }

    /* renamed from: b */
    public synchronized JSONObject mo10300b() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("tt", this.f4928d);
        jSONObject.put("wt", this.f4926b);
        jSONObject.put("host", this.f4925a);
        JSONArray jSONArray = new JSONArray();
        Iterator<AccessHistory> it = this.f4927c.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().mo10224f());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    public String toString() {
        return this.f4925a + ":" + this.f4926b;
    }
}
