package com.umeng.analytics.p093d;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.p086a.p088b.C1387a;
import com.umeng.analytics.p086a.p089c.C1394e;
import com.umeng.analytics.p086a.p090d.C1395a;
import com.umeng.analytics.p086a.p090d.C1412b;
import com.umeng.analytics.p091b.C1443f;
import com.umeng.analytics.p091b.C1447g;
import com.umeng.p085a.AbstractRunnableC1359k;
import com.umeng.p085a.C1344f;
import com.umeng.p085a.C1346h;
import com.umeng.p085a.C1347i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.umeng.analytics.d.f */
/* compiled from: EventTracker */
public class C1479f {

    /* renamed from: a */
    private static final String f3659a = "fs_lc_tl";

    /* renamed from: b */
    private final int f3660b = 128;

    /* renamed from: c */
    private final int f3661c = 256;

    /* renamed from: d */
    private final int f3662d = 10;

    /* renamed from: e */
    private Context f3663e;

    /* renamed from: f */
    private C1474d f3664f = null;

    /* renamed from: g */
    private C1471c f3665g = null;

    /* renamed from: h */
    private JSONObject f3666h = null;

    /* renamed from: i */
    private C1474d f3667i;

    public C1479f(Context context) {
        if (context == null) {
            try {
                C1346h.m5009e("Context is null, can't track event");
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        this.f3667i = C1474d.m5473b(context);
        this.f3663e = context;
        this.f3664f = C1474d.m5473b(this.f3663e);
        this.f3665g = this.f3664f.mo8628a(this.f3663e);
        if (this.f3666h == null) {
            m5487a(context);
        }
    }

    /* renamed from: a */
    public void mo8635a(String str, Map<String, Object> map, long j) {
        try {
            if (m5490a(str) && m5493b(map)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", str);
                jSONObject.put("ts", System.currentTimeMillis());
                if (j > 0) {
                    jSONObject.put(C1447g.f3477aN, j);
                }
                jSONObject.put("__t", C1443f.f3422a);
                Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
                for (int i = 0; i < 10 && it.hasNext(); i++) {
                    Map.Entry<String, Object> next = it.next();
                    if (!C1447g.f3480aQ.equals(next.getKey()) && !C1447g.f3478aO.equals(next.getKey()) && !C1447g.f3477aN.equals(next.getKey()) && !"id".equals(next.getKey()) && !"ts".equals(next.getKey())) {
                        Object value = next.getValue();
                        if ((value instanceof String) || (value instanceof Integer) || (value instanceof Long)) {
                            jSONObject.put(next.getKey(), value);
                        }
                    }
                }
                jSONObject.put("__i", C1493p.m5543g(this.f3663e));
                jSONObject.put("_umpname", C1469b.f3617a);
                this.f3667i.mo8621a(jSONObject);
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    public void mo8633a(String str, String str2, long j, int i) {
        try {
            if (m5490a(str) && m5492b(str2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", str);
                jSONObject.put("ts", System.currentTimeMillis());
                if (j > 0) {
                    jSONObject.put(C1447g.f3477aN, j);
                }
                jSONObject.put("__t", C1443f.f3422a);
                if (str2 == null) {
                    str2 = "";
                }
                jSONObject.put(str, str2);
                jSONObject.put("__i", C1493p.m5543g(this.f3663e));
                jSONObject.put("_umpname", C1469b.f3617a);
                this.f3667i.mo8621a(jSONObject);
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    public void mo8634a(String str, Map<String, Object> map) {
    }

    /* renamed from: b */
    public void mo8637b(String str, Map<String, Object> map) {
        try {
            if (m5490a(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", str);
                jSONObject.put("ts", System.currentTimeMillis());
                jSONObject.put(C1447g.f3477aN, 0);
                jSONObject.put("__t", C1443f.f3423b);
                Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
                for (int i = 0; i < 10 && it.hasNext(); i++) {
                    Map.Entry<String, Object> next = it.next();
                    if (!C1447g.f3480aQ.equals(next.getKey()) && !C1447g.f3478aO.equals(next.getKey()) && !C1447g.f3477aN.equals(next.getKey()) && !"id".equals(next.getKey()) && !"ts".equals(next.getKey())) {
                        Object value = next.getValue();
                        if ((value instanceof String) || (value instanceof Integer) || (value instanceof Long)) {
                            jSONObject.put(next.getKey(), value);
                        }
                    }
                }
                jSONObject.put("__i", C1493p.m5543g(this.f3663e));
                this.f3667i.mo8621a(jSONObject);
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    public boolean mo8636a(List<String> list, int i, String str) {
        String str2;
        try {
            C1412b a = C1412b.m5211a();
            if (list == null) {
                C1346h.m5009e("cklist is null!");
            } else if (list.size() <= 0) {
                C1346h.m5009e("the KeyList is null!");
                return false;
            } else {
                ArrayList arrayList = new ArrayList(list);
                if (!a.mo8475b(arrayList.get(0))) {
                    C1346h.m5009e("Primary key Invalid!");
                    return false;
                }
                if (arrayList.size() > 8) {
                    arrayList.clear();
                    arrayList.add(arrayList.get(0));
                    arrayList.add("__cc");
                    arrayList.add("illegal");
                } else if (!a.mo8473a(arrayList)) {
                    arrayList.clear();
                    arrayList.add(arrayList.get(0));
                    arrayList.add("__cc");
                    arrayList.add("illegal");
                } else if (!a.mo8476b(arrayList)) {
                    arrayList.clear();
                    arrayList.add(arrayList.get(0));
                    arrayList.add("__cc");
                    arrayList.add("illegal");
                } else {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        String str3 = arrayList.get(i2);
                        if (str3.length() > 16) {
                            arrayList.remove(i2);
                            arrayList.add(i2, str3.substring(0, 16));
                        }
                    }
                }
                if (!a.mo8472a(str)) {
                    C1346h.m5009e("label  Invalid!");
                    str2 = "__illegal";
                } else {
                    str2 = str;
                }
                final HashMap hashMap = new HashMap();
                hashMap.put(arrayList, new C1394e(arrayList, (long) i, str2, System.currentTimeMillis()));
                C1347i.m5018b(new AbstractRunnableC1359k() {
                    /* class com.umeng.analytics.p093d.C1479f.C14801 */

                    @Override // com.umeng.p085a.AbstractRunnableC1359k
                    /* renamed from: a */
                    public void mo8374a() {
                        C1395a.m5162a(C1479f.this.f3663e).mo8462a(new C1387a() {
                            /* class com.umeng.analytics.p093d.C1479f.C14801.C14811 */

                            @Override // com.umeng.analytics.p086a.p088b.AbstractC1388b, com.umeng.analytics.p086a.p088b.C1387a
                            /* renamed from: a */
                            public void mo8391a(Object obj, boolean z) {
                                if (obj.equals("success")) {
                                }
                            }
                        }, hashMap);
                    }
                });
            }
        } catch (Exception e) {
        }
        return true;
    }

    /* renamed from: a */
    private void m5487a(Context context) {
        try {
            String string = C1488m.m5522a(context).getString(f3659a, null);
            if (!TextUtils.isEmpty(string)) {
                this.f3666h = new JSONObject(string);
            }
            m5486a();
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    private void m5486a() {
        int i = 0;
        try {
            if (!TextUtils.isEmpty(this.f3665g.f3627a)) {
                String[] split = this.f3665g.f3627a.split("!");
                JSONObject jSONObject = new JSONObject();
                if (this.f3666h != null) {
                    for (String str : split) {
                        String a = C1344f.m4974a(str, 128);
                        if (this.f3666h.has(a)) {
                            jSONObject.put(a, this.f3666h.get(a));
                        }
                    }
                }
                this.f3666h = new JSONObject();
                if (split.length >= 10) {
                    while (i < 10) {
                        m5488a(split[i], jSONObject);
                        i++;
                    }
                } else {
                    while (i < split.length) {
                        m5488a(split[i], jSONObject);
                        i++;
                    }
                }
                m5491b(this.f3663e);
                this.f3665g.f3627a = null;
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    private void m5488a(String str, JSONObject jSONObject) throws JSONException {
        String a = C1344f.m4974a(str, 128);
        if (jSONObject.has(a)) {
            m5489a(a, ((Boolean) jSONObject.get(a)).booleanValue());
        } else {
            m5489a(a, false);
        }
    }

    /* renamed from: a */
    private void m5489a(String str, boolean z) {
        try {
            if (!C1447g.f3480aQ.equals(str) && !C1447g.f3478aO.equals(str) && !C1447g.f3477aN.equals(str) && !"id".equals(str) && !"ts".equals(str) && !this.f3666h.has(str)) {
                this.f3666h.put(str, z);
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    private void m5491b(Context context) {
        try {
            if (this.f3666h != null) {
                C1488m.m5522a(this.f3663e).edit().putString(f3659a, this.f3666h.toString()).commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo8632a(Context context, List<String> list) {
        try {
            if (this.f3663e == null && context != null) {
                this.f3663e = context;
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    private JSONObject m5485a(Map<String, Object> map) {
        char[] cArr;
        short[] sArr;
        byte[] bArr;
        boolean[] zArr;
        float[] fArr;
        long[] jArr;
        double[] dArr;
        int[] iArr;
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                try {
                    String key = entry.getKey();
                    if (key != null) {
                        String a = C1344f.m4974a(key, 128);
                        Object value = entry.getValue();
                        if (value != null) {
                            if (value.getClass().isArray()) {
                                if (value instanceof int[]) {
                                    ArrayList arrayList = new ArrayList();
                                    for (int i : (int[]) value) {
                                        arrayList.add(Integer.valueOf(i));
                                    }
                                    jSONObject.put(a, arrayList);
                                } else if (value instanceof double[]) {
                                    ArrayList arrayList2 = new ArrayList();
                                    for (double d : (double[]) value) {
                                        arrayList2.add(Double.valueOf(d));
                                    }
                                    jSONObject.put(a, arrayList2);
                                } else if (value instanceof long[]) {
                                    ArrayList arrayList3 = new ArrayList();
                                    for (long j : (long[]) value) {
                                        arrayList3.add(Long.valueOf(j));
                                    }
                                    jSONObject.put(a, arrayList3);
                                } else if (value instanceof float[]) {
                                    ArrayList arrayList4 = new ArrayList();
                                    for (float f : (float[]) value) {
                                        arrayList4.add(Float.valueOf(f));
                                    }
                                    jSONObject.put(a, arrayList4);
                                } else if (value instanceof boolean[]) {
                                    ArrayList arrayList5 = new ArrayList();
                                    for (boolean z : (boolean[]) value) {
                                        arrayList5.add(Boolean.valueOf(z));
                                    }
                                    jSONObject.put(a, arrayList5);
                                } else if (value instanceof byte[]) {
                                    ArrayList arrayList6 = new ArrayList();
                                    for (byte b : (byte[]) value) {
                                        arrayList6.add(Byte.valueOf(b));
                                    }
                                    jSONObject.put(a, arrayList6);
                                } else if (value instanceof short[]) {
                                    ArrayList arrayList7 = new ArrayList();
                                    for (short s : (short[]) value) {
                                        arrayList7.add(Short.valueOf(s));
                                    }
                                    jSONObject.put(a, arrayList7);
                                } else if (value instanceof char[]) {
                                    ArrayList arrayList8 = new ArrayList();
                                    for (char c : (char[]) value) {
                                        arrayList8.add(Character.valueOf(c));
                                    }
                                    jSONObject.put(a, arrayList8);
                                } else {
                                    jSONObject.put(a, new ArrayList(Arrays.asList((Object[]) value)));
                                }
                            } else if (value instanceof String) {
                                jSONObject.put(a, C1344f.m4974a(value.toString(), 256));
                            } else {
                                jSONObject.put(a, value);
                            }
                        }
                    }
                } catch (Exception e) {
                    C1346h.m5013e(e);
                }
            }
        } catch (Exception e2) {
        }
        return jSONObject;
    }

    /* renamed from: a */
    private boolean m5490a(String str) {
        if (str != null) {
            try {
                int length = str.trim().getBytes().length;
                if (length > 0 && length <= 128) {
                    return true;
                }
            } catch (Exception e) {
            }
        }
        C1346h.m5009e("Event id is empty or too long in tracking Event");
        return false;
    }

    /* renamed from: b */
    private boolean m5492b(String str) {
        if (str == null) {
            return true;
        }
        try {
            if (str.trim().getBytes().length <= 256) {
                return true;
            }
            C1346h.m5009e("Event label or value is empty or too long in tracking Event");
            return false;
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    private boolean m5493b(Map<String, Object> map) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        if (!m5490a(entry.getKey())) {
                            return false;
                        }
                        if (entry.getValue() == null) {
                            return false;
                        }
                        if ((entry.getValue() instanceof String) && !m5492b(entry.getValue().toString())) {
                            return false;
                        }
                    }
                    return true;
                }
            } catch (Exception e) {
            }
        }
        C1346h.m5009e("map is null or empty in onEvent");
        return false;
    }
}
