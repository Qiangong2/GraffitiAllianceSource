package com.xiaomi.network;

import org.json.JSONObject;

public class AccessHistory {

    /* renamed from: a */
    private int f4888a;

    /* renamed from: b */
    private long f4889b;

    /* renamed from: c */
    private long f4890c;

    /* renamed from: d */
    private String f4891d;

    /* renamed from: e */
    private long f4892e;

    public AccessHistory() {
        this(0, 0, 0, null);
    }

    public AccessHistory(int i, long j, long j2, Exception exc) {
        this.f4888a = i;
        this.f4889b = j;
        this.f4892e = j2;
        this.f4890c = System.currentTimeMillis();
        if (exc != null) {
            this.f4891d = exc.getClass().getSimpleName();
        }
    }

    /* renamed from: a */
    public int mo10218a() {
        return this.f4888a;
    }

    /* renamed from: a */
    public AccessHistory mo10219a(JSONObject jSONObject) {
        this.f4889b = jSONObject.getLong("cost");
        this.f4892e = jSONObject.getLong("size");
        this.f4890c = jSONObject.getLong("ts");
        this.f4888a = jSONObject.getInt("wt");
        this.f4891d = jSONObject.optString("expt");
        return this;
    }

    /* renamed from: b */
    public long mo10220b() {
        return this.f4889b;
    }

    /* renamed from: c */
    public long mo10221c() {
        return this.f4890c;
    }

    /* renamed from: d */
    public long mo10222d() {
        return this.f4892e;
    }

    /* renamed from: e */
    public String mo10223e() {
        return this.f4891d;
    }

    /* renamed from: f */
    public JSONObject mo10224f() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.f4889b);
        jSONObject.put("size", this.f4892e);
        jSONObject.put("ts", this.f4890c);
        jSONObject.put("wt", this.f4888a);
        jSONObject.put("expt", this.f4891d);
        return jSONObject;
    }
}
