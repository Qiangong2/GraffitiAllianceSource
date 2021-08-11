package com.igexin.push.extension.distribution.basic.p046g.p047a;

import android.content.ContentValues;
import com.igexin.push.extension.distribution.basic.p041b.C0714b;
import com.igexin.push.extension.distribution.basic.p046g.p050d.AbstractC0762a;
import com.wanmei.push.bean.AppState;

/* renamed from: com.igexin.push.extension.distribution.basic.g.a.a */
public class C0753a {

    /* renamed from: a */
    private long f2086a;

    /* renamed from: b */
    private String f2087b;

    /* renamed from: c */
    private long f2088c = -1;

    /* renamed from: d */
    private long f2089d;

    /* renamed from: e */
    private int f2090e = 0;

    /* renamed from: f */
    private String f2091f;

    /* renamed from: g */
    private String f2092g;

    /* renamed from: h */
    private AbstractC0762a f2093h;

    /* renamed from: i */
    private String f2094i;

    /* renamed from: j */
    private int f2095j;

    /* renamed from: k */
    private C0714b f2096k;

    public C0753a(AbstractC0762a aVar) {
        this.f2093h = aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x009b, code lost:
        if (r6 != null) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x009d, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00aa, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00ab, code lost:
        if (r6 != null) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00ad, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b0, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00aa A[ExcHandler: all (r0v0 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x0005] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.igexin.push.extension.distribution.basic.p046g.p047a.C0753a> m3063a(android.database.Cursor r6) {
        /*
        // Method dump skipped, instructions count: 177
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.p046g.p047a.C0753a.m3063a(android.database.Cursor):java.util.List");
    }

    /* renamed from: a */
    public long mo5062a() {
        return this.f2086a;
    }

    /* renamed from: a */
    public void mo5063a(int i) {
        this.f2090e = i;
    }

    /* renamed from: a */
    public void mo5064a(long j) {
        this.f2086a = j;
    }

    /* renamed from: a */
    public void mo5065a(C0714b bVar) {
        this.f2096k = bVar;
        this.f2091f = bVar.mo4786a();
        this.f2087b = bVar.mo4797d();
    }

    /* renamed from: a */
    public void mo5066a(String str) {
        this.f2092g = str;
    }

    /* renamed from: b */
    public String mo5067b() {
        return this.f2087b;
    }

    /* renamed from: b */
    public void mo5068b(int i) {
        this.f2095j = i;
    }

    /* renamed from: b */
    public void mo5069b(long j) {
        this.f2088c = j;
    }

    /* renamed from: b */
    public void mo5070b(String str) {
        this.f2094i = str;
    }

    /* renamed from: c */
    public long mo5071c() {
        return this.f2088c;
    }

    /* renamed from: c */
    public void mo5072c(long j) {
        this.f2089d += j;
    }

    /* renamed from: d */
    public long mo5073d() {
        return this.f2089d;
    }

    /* renamed from: e */
    public int mo5074e() {
        return this.f2090e;
    }

    /* renamed from: f */
    public String mo5075f() {
        return this.f2091f;
    }

    /* renamed from: g */
    public String mo5076g() {
        return this.f2092g;
    }

    /* renamed from: h */
    public AbstractC0762a mo5077h() {
        return this.f2093h;
    }

    /* renamed from: i */
    public String mo5078i() {
        return this.f2094i;
    }

    /* renamed from: j */
    public int mo5079j() {
        return this.f2095j;
    }

    /* renamed from: k */
    public C0714b mo5080k() {
        return this.f2096k;
    }

    /* renamed from: l */
    public ContentValues mo5081l() {
        ContentValues contentValues = new ContentValues();
        try {
            contentValues.put("name", mo5067b());
            contentValues.put("url", mo5075f());
            contentValues.put("downloaded", Long.valueOf(mo5073d()));
            contentValues.put("etag", mo5078i());
            contentValues.put("size", Long.valueOf(mo5071c()));
            contentValues.put(AppState.STATE, Integer.valueOf(mo5074e()));
            contentValues.put("save_address", mo5076g());
            contentValues.put("failed_time", Integer.valueOf(mo5079j()));
            contentValues.put("listener", mo5077h().getClass().getCanonicalName());
        } catch (Throwable th) {
        }
        return contentValues;
    }
}
