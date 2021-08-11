package com.amap.loc;

import android.content.Context;
import android.text.TextUtils;
import java.net.URLDecoder;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.amap.loc.j */
/* compiled from: AuthConfigManager */
public class C0343j {

    /* renamed from: a */
    public static int f825a = -1;

    /* renamed from: b */
    public static String f826b = "";

    /* renamed from: com.amap.loc.j$a */
    /* compiled from: AuthConfigManager */
    public static class C0344a {

        /* renamed from: a */
        public String f827a;

        /* renamed from: b */
        public int f828b = -1;

        /* renamed from: c */
        public JSONObject f829c;

        /* renamed from: d */
        public JSONObject f830d;

        /* renamed from: e */
        public JSONObject f831e;

        /* renamed from: f */
        public JSONObject f832f;

        /* renamed from: g */
        public JSONObject f833g;

        /* renamed from: h */
        public JSONObject f834h;

        /* renamed from: i */
        public JSONObject f835i;

        /* renamed from: j */
        public JSONObject f836j;

        /* renamed from: k */
        public JSONObject f837k;

        /* renamed from: l */
        public JSONObject f838l;

        /* renamed from: m */
        public JSONObject f839m;

        /* renamed from: n */
        public JSONObject f840n;

        /* renamed from: o */
        public C0345a f841o;

        /* renamed from: p */
        public C0348d f842p;

        /* renamed from: q */
        public C0347c f843q;

        /* renamed from: r */
        public C0346b f844r;

        /* renamed from: s */
        public C0346b f845s;

        /* renamed from: t */
        public C0346b f846t;

        /* renamed from: u */
        public C0346b f847u;

        /* renamed from: com.amap.loc.j$a$a */
        /* compiled from: AuthConfigManager */
        public static class C0345a {

            /* renamed from: a */
            public boolean f848a;

            /* renamed from: b */
            public boolean f849b;
        }

        /* renamed from: com.amap.loc.j$a$b */
        /* compiled from: AuthConfigManager */
        public static class C0346b {

            /* renamed from: a */
            public boolean f850a;

            /* renamed from: b */
            public String f851b;

            /* renamed from: c */
            public String f852c;

            /* renamed from: d */
            public String f853d;
        }

        /* renamed from: com.amap.loc.j$a$c */
        /* compiled from: AuthConfigManager */
        public static class C0347c {

            /* renamed from: a */
            public String f854a;

            /* renamed from: b */
            public String f855b;
        }

        /* renamed from: com.amap.loc.j$a$d */
        /* compiled from: AuthConfigManager */
        public static class C0348d {

            /* renamed from: a */
            public String f856a;

            /* renamed from: b */
            public String f857b;

            /* renamed from: c */
            public String f858c;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.amap.loc.j$b */
    /* compiled from: AuthConfigManager */
    public static class C0349b extends AbstractC0277bg {

        /* renamed from: f */
        private String f859f;

        /* renamed from: g */
        private Map<String, String> f860g;

        C0349b(Context context, C0360q qVar, String str, Map<String, String> map) {
            super(context, qVar);
            this.f859f = str;
            this.f860g = map;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x00aa  */
        /* renamed from: k */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.util.Map<java.lang.String, java.lang.String> m1244k() {
            /*
            // Method dump skipped, instructions count: 199
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0343j.C0349b.m1244k():java.util.Map");
        }

        @Override // com.amap.loc.AbstractC0283bk
        /* renamed from: a */
        public Map<String, String> mo3696a() {
            return null;
        }

        @Override // com.amap.loc.AbstractC0277bg
        /* renamed from: a_ */
        public byte[] mo3752a_() {
            return null;
        }

        @Override // com.amap.loc.AbstractC0283bk
        /* renamed from: b */
        public String mo3697b() {
            return "https://restapi.amap.com/v3/iasdkauth";
        }

        @Override // com.amap.loc.AbstractC0277bg
        /* renamed from: b_ */
        public byte[] mo3753b_() {
            return C0363r.m1358a(C0363r.m1360b(m1244k()));
        }

        /* access modifiers changed from: protected */
        @Override // com.amap.loc.AbstractC0277bg
        /* renamed from: e */
        public String mo3755e() {
            return "3.0";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005e, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0075, code lost:
        throw new com.amap.loc.C0341h("未知的错误");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0077, code lost:
        r2 = null;
        r4 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0076 A[ExcHandler: IllegalBlockSizeException (e javax.crypto.IllegalBlockSizeException), Splitter:B:1:0x0007] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008d  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.amap.loc.C0343j.C0344a m1237a(android.content.Context r11, com.amap.loc.C0360q r12, java.lang.String r13, java.util.Map<java.lang.String, java.lang.String> r14) {
        /*
        // Method dump skipped, instructions count: 723
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0343j.m1237a(android.content.Context, com.amap.loc.q, java.lang.String, java.util.Map):com.amap.loc.j$a");
    }

    /* renamed from: a */
    public static String m1238a(JSONObject jSONObject, String str) throws JSONException {
        return (jSONObject != null && jSONObject.has(str) && !jSONObject.getString(str).equals("[]")) ? jSONObject.optString(str) : "";
    }

    /* renamed from: a */
    public static void m1239a(String str) {
        C0342i.m1231b(str);
    }

    /* renamed from: a */
    private static void m1240a(JSONObject jSONObject, C0344a.C0346b bVar) {
        if (bVar != null) {
            try {
                String a = m1238a(jSONObject, "m");
                String a2 = m1238a(jSONObject, "u");
                String a3 = m1238a(jSONObject, "v");
                String a4 = m1238a(jSONObject, "able");
                bVar.f852c = a;
                bVar.f851b = a2;
                bVar.f853d = a3;
                bVar.f850a = m1243a(a4, false);
            } catch (Throwable th) {
                C0365t.m1372a(th, "ConfigManager", "parsePluginEntity");
            }
        }
    }

    /* renamed from: a */
    private static void m1241a(JSONObject jSONObject, C0344a.C0347c cVar) {
        if (jSONObject != null) {
            try {
                String a = m1238a(jSONObject, "md5");
                String a2 = m1238a(jSONObject, "url");
                cVar.f855b = a;
                cVar.f854a = a2;
            } catch (Throwable th) {
                C0365t.m1372a(th, "ConfigManager", "parseSDKCoordinate");
            }
        }
    }

    /* renamed from: a */
    private static void m1242a(JSONObject jSONObject, C0344a.C0348d dVar) {
        if (jSONObject != null) {
            try {
                String a = m1238a(jSONObject, "md5");
                String a2 = m1238a(jSONObject, "url");
                String a3 = m1238a(jSONObject, "sdkversion");
                if (!TextUtils.isEmpty(a) && !TextUtils.isEmpty(a2) && !TextUtils.isEmpty(a3)) {
                    dVar.f856a = a2;
                    dVar.f857b = a;
                    dVar.f858c = a3;
                }
            } catch (Throwable th) {
                C0365t.m1372a(th, "ConfigManager", "parseSDKUpdate");
            }
        }
    }

    /* renamed from: a */
    public static boolean m1243a(String str, boolean z) {
        try {
            String[] split = URLDecoder.decode(str).split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
            return split[split.length + -1].charAt(4) % 2 == 1;
        } catch (Throwable th) {
            return z;
        }
    }
}
