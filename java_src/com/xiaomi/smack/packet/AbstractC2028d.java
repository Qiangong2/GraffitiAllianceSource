package com.xiaomi.smack.packet;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.smack.util.C2045g;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.xiaomi.smack.packet.d */
public abstract class AbstractC2028d {

    /* renamed from: a */
    private static String f5385a = null;

    /* renamed from: b */
    protected static final String f5386b = Locale.getDefault().getLanguage().toLowerCase();

    /* renamed from: c */
    public static final DateFormat f5387c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    /* renamed from: d */
    private static String f5388d = (C2045g.m7699a(5) + "-");

    /* renamed from: e */
    private static long f5389e = 0;

    /* renamed from: f */
    private String f5390f = f5385a;

    /* renamed from: g */
    private String f5391g = null;

    /* renamed from: h */
    private String f5392h = null;

    /* renamed from: i */
    private String f5393i = null;

    /* renamed from: j */
    private String f5394j = null;

    /* renamed from: k */
    private String f5395k = null;

    /* renamed from: l */
    private List<C2024a> f5396l = new CopyOnWriteArrayList();

    /* renamed from: m */
    private final Map<String, Object> f5397m = new HashMap();

    /* renamed from: n */
    private C2034h f5398n = null;

    static {
        f5387c.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public AbstractC2028d() {
    }

    public AbstractC2028d(Bundle bundle) {
        this.f5392h = bundle.getString("ext_to");
        this.f5393i = bundle.getString("ext_from");
        this.f5394j = bundle.getString("ext_chid");
        this.f5391g = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f5396l = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                C2024a a = C2024a.m7595a((Bundle) parcelable);
                if (a != null) {
                    this.f5396l.add(a);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.f5398n = new C2034h(bundle2);
        }
    }

    /* renamed from: j */
    public static synchronized String m7637j() {
        String sb;
        synchronized (AbstractC2028d.class) {
            StringBuilder append = new StringBuilder().append(f5388d);
            long j = f5389e;
            f5389e = 1 + j;
            sb = append.append(Long.toString(j)).toString();
        }
        return sb;
    }

    /* renamed from: u */
    public static String m7638u() {
        return f5386b;
    }

    /* renamed from: a */
    public abstract String mo10546a();

    /* renamed from: a */
    public void mo10606a(C2024a aVar) {
        this.f5396l.add(aVar);
    }

    /* renamed from: a */
    public void mo10607a(C2034h hVar) {
        this.f5398n = hVar;
    }

    /* renamed from: b */
    public C2024a mo10608b(String str, String str2) {
        for (C2024a aVar : this.f5396l) {
            if ((str2 == null || str2.equals(aVar.mo10569b())) && str.equals(aVar.mo10567a())) {
                return aVar;
            }
        }
        return null;
    }

    /* renamed from: c */
    public Bundle mo10581c() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.f5390f)) {
            bundle.putString("ext_ns", this.f5390f);
        }
        if (!TextUtils.isEmpty(this.f5393i)) {
            bundle.putString("ext_from", this.f5393i);
        }
        if (!TextUtils.isEmpty(this.f5392h)) {
            bundle.putString("ext_to", this.f5392h);
        }
        if (!TextUtils.isEmpty(this.f5391g)) {
            bundle.putString("ext_pkt_id", this.f5391g);
        }
        if (!TextUtils.isEmpty(this.f5394j)) {
            bundle.putString("ext_chid", this.f5394j);
        }
        if (this.f5398n != null) {
            bundle.putBundle("ext_ERROR", this.f5398n.mo10633c());
        }
        if (this.f5396l != null) {
            Bundle[] bundleArr = new Bundle[this.f5396l.size()];
            int i = 0;
            for (C2024a aVar : this.f5396l) {
                Bundle e = aVar.mo10573e();
                if (e != null) {
                    i++;
                    bundleArr[i] = e;
                } else {
                    i = i;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractC2028d dVar = (AbstractC2028d) obj;
        if (this.f5398n != null) {
            if (!this.f5398n.equals(dVar.f5398n)) {
                return false;
            }
        } else if (dVar.f5398n != null) {
            return false;
        }
        if (this.f5393i != null) {
            if (!this.f5393i.equals(dVar.f5393i)) {
                return false;
            }
        } else if (dVar.f5393i != null) {
            return false;
        }
        if (!this.f5396l.equals(dVar.f5396l)) {
            return false;
        }
        if (this.f5391g != null) {
            if (!this.f5391g.equals(dVar.f5391g)) {
                return false;
            }
        } else if (dVar.f5391g != null) {
            return false;
        }
        if (this.f5394j != null) {
            if (!this.f5394j.equals(dVar.f5394j)) {
                return false;
            }
        } else if (dVar.f5394j != null) {
            return false;
        }
        if (this.f5397m != null) {
            if (!this.f5397m.equals(dVar.f5397m)) {
                return false;
            }
        } else if (dVar.f5397m != null) {
            return false;
        }
        if (this.f5392h != null) {
            if (!this.f5392h.equals(dVar.f5392h)) {
                return false;
            }
        } else if (dVar.f5392h != null) {
            return false;
        }
        if (this.f5390f == null ? dVar.f5390f != null : !this.f5390f.equals(dVar.f5390f)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((this.f5394j != null ? this.f5394j.hashCode() : 0) + (((this.f5393i != null ? this.f5393i.hashCode() : 0) + (((this.f5392h != null ? this.f5392h.hashCode() : 0) + (((this.f5391g != null ? this.f5391g.hashCode() : 0) + ((this.f5390f != null ? this.f5390f.hashCode() : 0) * 31)) * 31)) * 31)) * 31)) * 31) + this.f5396l.hashCode()) * 31) + this.f5397m.hashCode()) * 31;
        if (this.f5398n != null) {
            i = this.f5398n.hashCode();
        }
        return hashCode + i;
    }

    /* renamed from: k */
    public String mo10609k() {
        if ("ID_NOT_AVAILABLE".equals(this.f5391g)) {
            return null;
        }
        if (this.f5391g == null) {
            this.f5391g = m7637j();
        }
        return this.f5391g;
    }

    /* renamed from: k */
    public void mo10610k(String str) {
        this.f5391g = str;
    }

    /* renamed from: l */
    public String mo10611l() {
        return this.f5394j;
    }

    /* renamed from: l */
    public void mo10612l(String str) {
        this.f5394j = str;
    }

    /* renamed from: m */
    public String mo10613m() {
        return this.f5392h;
    }

    /* renamed from: m */
    public void mo10614m(String str) {
        this.f5392h = str;
    }

    /* renamed from: n */
    public String mo10615n() {
        return this.f5393i;
    }

    /* renamed from: n */
    public void mo10616n(String str) {
        this.f5393i = str;
    }

    /* renamed from: o */
    public String mo10617o() {
        return this.f5395k;
    }

    /* renamed from: o */
    public void mo10618o(String str) {
        this.f5395k = str;
    }

    /* renamed from: p */
    public C2024a mo10619p(String str) {
        return mo10608b(str, null);
    }

    /* renamed from: p */
    public C2034h mo10620p() {
        return this.f5398n;
    }

    /* renamed from: q */
    public synchronized Object mo10621q(String str) {
        return this.f5397m == null ? null : this.f5397m.get(str);
    }

    /* renamed from: q */
    public synchronized Collection<C2024a> mo10622q() {
        return this.f5396l == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(this.f5396l));
    }

    /* renamed from: r */
    public synchronized Collection<String> mo10623r() {
        return this.f5397m == null ? Collections.emptySet() : Collections.unmodifiableSet(new HashSet(this.f5397m.keySet()));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0129 A[SYNTHETIC, Splitter:B:54:0x0129] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x012e A[SYNTHETIC, Splitter:B:57:0x012e] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x013b A[SYNTHETIC, Splitter:B:63:0x013b] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0140 A[SYNTHETIC, Splitter:B:66:0x0140] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x007f A[SYNTHETIC] */
    /* renamed from: s */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String mo10624s() {
        /*
        // Method dump skipped, instructions count: 360
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smack.packet.AbstractC2028d.mo10624s():java.lang.String");
    }

    /* renamed from: t */
    public String mo10625t() {
        return this.f5390f;
    }
}
