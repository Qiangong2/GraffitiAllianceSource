package com.xiaomi.smack.packet;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.xiaomi.smack.util.C2045g;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* renamed from: com.xiaomi.smack.packet.a */
public class C2024a implements AbstractC2029e {

    /* renamed from: a */
    private String f5358a;

    /* renamed from: b */
    private String f5359b;

    /* renamed from: c */
    private String[] f5360c = null;

    /* renamed from: d */
    private String[] f5361d = null;

    /* renamed from: e */
    private String f5362e;

    /* renamed from: f */
    private List<C2024a> f5363f = null;

    public C2024a(String str, String str2, String[] strArr, String[] strArr2) {
        this.f5358a = str;
        this.f5359b = str2;
        this.f5360c = strArr;
        this.f5361d = strArr2;
    }

    public C2024a(String str, String str2, String[] strArr, String[] strArr2, String str3, List<C2024a> list) {
        this.f5358a = str;
        this.f5359b = str2;
        this.f5360c = strArr;
        this.f5361d = strArr2;
        this.f5362e = str3;
        this.f5363f = list;
    }

    /* renamed from: a */
    public static C2024a m7595a(Bundle bundle) {
        ArrayList arrayList;
        String string = bundle.getString("ext_ele_name");
        String string2 = bundle.getString("ext_ns");
        String string3 = bundle.getString("ext_text");
        Bundle bundle2 = bundle.getBundle("attributes");
        Set<String> keySet = bundle2.keySet();
        String[] strArr = new String[keySet.size()];
        String[] strArr2 = new String[keySet.size()];
        int i = 0;
        for (String str : keySet) {
            strArr[i] = str;
            strArr2[i] = bundle2.getString(str);
            i++;
        }
        if (bundle.containsKey("children")) {
            Parcelable[] parcelableArray = bundle.getParcelableArray("children");
            arrayList = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList.add(m7595a((Bundle) parcelable));
            }
        } else {
            arrayList = null;
        }
        return new C2024a(string, string2, strArr, strArr2, string3, arrayList);
    }

    /* renamed from: a */
    public static Parcelable[] m7596a(List<C2024a> list) {
        return m7597a((C2024a[]) list.toArray(new C2024a[list.size()]));
    }

    /* renamed from: a */
    public static Parcelable[] m7597a(C2024a[] aVarArr) {
        if (aVarArr == null) {
            return null;
        }
        Parcelable[] parcelableArr = new Parcelable[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            parcelableArr[i] = aVarArr[i].mo10574f();
        }
        return parcelableArr;
    }

    /* renamed from: a */
    public String mo10567a() {
        return this.f5358a;
    }

    /* renamed from: a */
    public String mo10568a(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if (this.f5360c != null) {
            for (int i = 0; i < this.f5360c.length; i++) {
                if (str.equals(this.f5360c[i])) {
                    return this.f5361d[i];
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    public String mo10569b() {
        return this.f5359b;
    }

    /* renamed from: b */
    public void mo10570b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f5362e = C2045g.m7700a(str);
        } else {
            this.f5362e = str;
        }
    }

    /* renamed from: c */
    public String mo10571c() {
        return !TextUtils.isEmpty(this.f5362e) ? C2045g.m7704b(this.f5362e) : this.f5362e;
    }

    @Override // com.xiaomi.smack.packet.AbstractC2029e
    /* renamed from: d */
    public String mo10572d() {
        StringBuilder sb = new StringBuilder();
        sb.append(SimpleComparison.LESS_THAN_OPERATION).append(this.f5358a);
        if (!TextUtils.isEmpty(this.f5359b)) {
            sb.append(" ").append("xmlns=").append("\"").append(this.f5359b).append("\"");
        }
        if (this.f5360c != null && this.f5360c.length > 0) {
            for (int i = 0; i < this.f5360c.length; i++) {
                if (!TextUtils.isEmpty(this.f5361d[i])) {
                    sb.append(" ").append(this.f5360c[i]).append("=\"").append(C2045g.m7700a(this.f5361d[i])).append("\"");
                }
            }
        }
        if (!TextUtils.isEmpty(this.f5362e)) {
            sb.append(SimpleComparison.GREATER_THAN_OPERATION).append(this.f5362e).append("</").append(this.f5358a).append(SimpleComparison.GREATER_THAN_OPERATION);
        } else if (this.f5363f == null || this.f5363f.size() <= 0) {
            sb.append("/>");
        } else {
            sb.append(SimpleComparison.GREATER_THAN_OPERATION);
            for (C2024a aVar : this.f5363f) {
                sb.append(aVar.mo10572d());
            }
            sb.append("</").append(this.f5358a).append(SimpleComparison.GREATER_THAN_OPERATION);
        }
        return sb.toString();
    }

    /* renamed from: e */
    public Bundle mo10573e() {
        Bundle bundle = new Bundle();
        bundle.putString("ext_ele_name", this.f5358a);
        bundle.putString("ext_ns", this.f5359b);
        bundle.putString("ext_text", this.f5362e);
        Bundle bundle2 = new Bundle();
        if (this.f5360c != null && this.f5360c.length > 0) {
            for (int i = 0; i < this.f5360c.length; i++) {
                bundle2.putString(this.f5360c[i], this.f5361d[i]);
            }
        }
        bundle.putBundle("attributes", bundle2);
        if (this.f5363f != null && this.f5363f.size() > 0) {
            bundle.putParcelableArray("children", m7596a(this.f5363f));
        }
        return bundle;
    }

    /* renamed from: f */
    public Parcelable mo10574f() {
        return mo10573e();
    }

    public String toString() {
        return mo10572d();
    }
}
