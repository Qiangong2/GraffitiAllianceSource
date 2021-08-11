package com.igexin.push.extension.distribution.gbd.p069e.p070a;

import android.content.ContentValues;
import com.igexin.p012b.p022b.C0476a;
import com.igexin.push.extension.distribution.gbd.p067c.C1067a;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.push.extension.distribution.gbd.p074h.p075a.C1101c;
import com.igexin.push.extension.distribution.gbd.p074h.p075a.C1106h;
import com.igexin.push.extension.distribution.gbd.p074h.p075a.C1110l;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.igexin.sdk.PushBuildConfig;
import org.json.JSONObject;

/* renamed from: com.igexin.push.extension.distribution.gbd.e.a.a */
public class C1079a {

    /* renamed from: a */
    public static C1079a f2864a;

    /* renamed from: A */
    private boolean f2865A;

    /* renamed from: B */
    private boolean f2866B;

    /* renamed from: C */
    private int f2867C;

    /* renamed from: D */
    private int f2868D;

    /* renamed from: E */
    private boolean f2869E;

    /* renamed from: F */
    private String f2870F;

    /* renamed from: G */
    private int f2871G;

    /* renamed from: H */
    private String f2872H;

    /* renamed from: I */
    private boolean f2873I;

    /* renamed from: J */
    private String f2874J;

    /* renamed from: K */
    private boolean f2875K;

    /* renamed from: L */
    private boolean f2876L;

    /* renamed from: M */
    private boolean f2877M;

    /* renamed from: N */
    private long f2878N;

    /* renamed from: O */
    private int f2879O;

    /* renamed from: P */
    private int f2880P;

    /* renamed from: Q */
    private String f2881Q;

    /* renamed from: R */
    private String f2882R;

    /* renamed from: S */
    private String f2883S;

    /* renamed from: T */
    private long f2884T;

    /* renamed from: U */
    private long f2885U;

    /* renamed from: V */
    private boolean f2886V;

    /* renamed from: W */
    private boolean f2887W;

    /* renamed from: X */
    private int f2888X;

    /* renamed from: Y */
    private long f2889Y;

    /* renamed from: Z */
    private int f2890Z;

    /* renamed from: aa */
    private boolean f2891aa;

    /* renamed from: ab */
    private long f2892ab;

    /* renamed from: ac */
    private String f2893ac;

    /* renamed from: ad */
    private int f2894ad;

    /* renamed from: ae */
    private long f2895ae;

    /* renamed from: af */
    private boolean f2896af;

    /* renamed from: ag */
    private String f2897ag;

    /* renamed from: ah */
    private String f2898ah;

    /* renamed from: ai */
    private String f2899ai;

    /* renamed from: aj */
    private boolean f2900aj = true;

    /* renamed from: ak */
    private boolean f2901ak = true;

    /* renamed from: al */
    private boolean f2902al = false;

    /* renamed from: am */
    private String f2903am = PushBuildConfig.sdk_conf_debug_level;

    /* renamed from: an */
    private long f2904an;

    /* renamed from: b */
    private boolean f2905b;

    /* renamed from: c */
    private String f2906c;

    /* renamed from: d */
    private String f2907d;

    /* renamed from: e */
    private boolean f2908e;

    /* renamed from: f */
    private long f2909f;

    /* renamed from: g */
    private long f2910g;

    /* renamed from: h */
    private int f2911h;

    /* renamed from: i */
    private int f2912i;

    /* renamed from: j */
    private int f2913j;

    /* renamed from: k */
    private int f2914k;

    /* renamed from: l */
    private long f2915l;

    /* renamed from: m */
    private int f2916m;

    /* renamed from: n */
    private int f2917n;

    /* renamed from: o */
    private boolean f2918o;

    /* renamed from: p */
    private String f2919p;

    /* renamed from: q */
    private int f2920q;

    /* renamed from: r */
    private String f2921r;

    /* renamed from: s */
    private String f2922s;

    /* renamed from: t */
    private long f2923t;

    /* renamed from: u */
    private boolean f2924u;

    /* renamed from: v */
    private long f2925v;

    /* renamed from: w */
    private long f2926w;

    /* renamed from: x */
    private int f2927x;

    /* renamed from: y */
    private int f2928y;

    /* renamed from: z */
    private String f2929z;

    /* renamed from: a */
    public static C1079a m4384a() {
        if (f2864a == null) {
            f2864a = new C1079a();
        }
        return f2864a;
    }

    /* renamed from: a */
    private void m4385a(int i, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", Integer.valueOf(i));
        contentValues.put("value", str);
        C1069c.f2825b.mo5802a("config", (String) null, contentValues);
    }

    /* renamed from: a */
    private void m4386a(int i, byte[] bArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", Integer.valueOf(i));
        contentValues.put("value", bArr);
        C1069c.f2825b.mo5802a("config", (String) null, contentValues);
    }

    /* renamed from: c */
    private void m4387c() {
        boolean z = false;
        C1115d.m4557a("GBD_ConfigDataManager", "saveAllData");
        if (C1067a.f2791b != this.f2905b) {
            C1067a.f2791b = this.f2905b;
            m4385a(0, String.valueOf(C1067a.f2791b));
        }
        if (!C1067a.f2792c.equals(this.f2906c)) {
            C1067a.f2792c = this.f2906c;
            m4386a(1, C0476a.m1776b(this.f2906c.getBytes()));
        }
        if (!C1067a.f2793d.equals(this.f2907d)) {
            C1067a.f2793d = this.f2907d;
            m4386a(2, C0476a.m1776b(this.f2907d.getBytes()));
        }
        if (C1067a.f2794e != this.f2908e) {
            C1067a.f2794e = this.f2908e;
            m4385a(3, String.valueOf(C1067a.f2794e));
        }
        if (C1067a.f2795f != this.f2909f) {
            C1067a.f2795f = this.f2909f;
            m4385a(4, String.valueOf(C1067a.f2795f));
            C1106h.m4527d().mo5874e();
        }
        if (C1067a.f2796g != this.f2910g) {
            C1067a.f2796g = this.f2910g;
            m4385a(5, String.valueOf(C1067a.f2796g));
            C1110l.m4543d().mo5871a(System.currentTimeMillis());
            C1110l.m4543d().mo5875e();
        }
        if (C1067a.f2797h != this.f2911h) {
            C1067a.f2797h = this.f2911h;
            m4385a(6, String.valueOf(C1067a.f2797h));
        }
        if (C1067a.f2798i != this.f2912i) {
            C1067a.f2798i = this.f2912i;
            m4385a(7, String.valueOf(C1067a.f2798i));
        }
        if (C1067a.f2799j != this.f2913j) {
            C1067a.f2799j = this.f2913j;
            m4385a(8, String.valueOf(C1067a.f2799j));
        }
        if (C1067a.f2800k != this.f2914k) {
            C1067a.f2800k = this.f2914k;
            m4385a(9, String.valueOf(C1067a.f2800k));
        }
        if (C1067a.f2801l != this.f2915l) {
            C1067a.f2801l = this.f2915l;
            m4385a(10, String.valueOf(C1067a.f2801l));
        }
        if (C1067a.f2802m != this.f2916m) {
            C1067a.f2802m = this.f2916m;
            m4385a(11, String.valueOf(C1067a.f2802m));
        }
        if (C1067a.f2804o != this.f2917n) {
            C1067a.f2804o = this.f2917n;
            m4385a(12, String.valueOf(C1067a.f2804o));
        }
        if ((!C1067a.f2806q) == this.f2918o) {
            C1067a.f2806q = this.f2918o;
            m4385a(14, String.valueOf(C1067a.f2806q));
        }
        if (!C1067a.f2807r.equals(this.f2919p)) {
            C1067a.f2807r = this.f2919p;
            m4386a(15, C0476a.m1776b(C1067a.f2807r.getBytes()));
        }
        if (C1067a.f2809t != this.f2920q) {
            C1067a.f2809t = this.f2920q;
            m4385a(16, String.valueOf(C1067a.f2809t));
        }
        if (!C1067a.f2811v.equals(this.f2922s)) {
            C1067a.f2811v = this.f2922s;
            m4386a(18, C0476a.m1776b(C1067a.f2811v.getBytes()));
        }
        if (!C1067a.f2811v.equals(this.f2921r)) {
            C1067a.f2810u = this.f2921r;
            m4386a(17, C0476a.m1776b(C1067a.f2810u.getBytes()));
        }
        if (C1067a.f2812w != this.f2923t) {
            C1067a.f2812w = this.f2923t;
            m4385a(19, String.valueOf(C1067a.f2812w));
        }
        if (!C1067a.f2805p) {
            z = true;
        }
        if (z == this.f2924u) {
            C1067a.f2805p = this.f2924u;
            m4385a(20, String.valueOf(C1067a.f2805p));
        }
        if (C1067a.f2814y != this.f2925v) {
            C1067a.f2814y = this.f2925v;
            m4385a(21, String.valueOf(C1067a.f2814y));
            C1101c.m4508d().mo5871a(System.currentTimeMillis());
            C1101c.m4508d().mo5873e();
        }
        if (C1067a.f2803n != this.f2926w) {
            C1067a.f2803n = this.f2926w;
            m4385a(22, String.valueOf(C1067a.f2803n));
        }
        if (C1067a.f2751B != this.f2927x) {
            C1067a.f2751B = this.f2927x;
            m4385a(27, String.valueOf(this.f2927x));
        }
        if (C1067a.f2752C != this.f2928y) {
            C1067a.f2752C = this.f2928y;
            m4385a(28, String.valueOf(this.f2928y));
        }
        if (C1067a.f2756G != this.f2865A) {
            C1067a.f2756G = this.f2865A;
            m4385a(30, String.valueOf(this.f2865A));
        }
        if (!C1067a.f2753D.equals(this.f2929z)) {
            C1067a.f2753D = this.f2929z;
            m4386a(29, C0476a.m1776b(C1067a.f2753D.getBytes()));
        }
        if (C1067a.f2760K != this.f2866B) {
            C1067a.f2760K = this.f2866B;
            m4385a(31, String.valueOf(this.f2866B));
        }
        if (C1067a.f2761L != this.f2867C) {
            C1067a.f2761L = this.f2867C;
            m4385a(32, String.valueOf(this.f2867C));
        }
        if (C1067a.f2762M != this.f2868D) {
            C1067a.f2762M = this.f2868D;
            m4385a(33, String.valueOf(this.f2868D));
        }
        if (C1067a.f2757H != this.f2869E) {
            C1067a.f2757H = this.f2869E;
            m4385a(34, String.valueOf(this.f2869E));
        }
        if (!C1067a.f2759J.equals(this.f2870F)) {
            C1067a.f2759J = this.f2870F;
            m4386a(35, C0476a.m1776b(C1067a.f2759J.getBytes()));
        }
        if (C1067a.f2758I != this.f2871G) {
            C1067a.f2758I = this.f2871G;
            m4385a(36, String.valueOf(this.f2871G));
        }
        if (!C1067a.f2808s.equals(this.f2872H)) {
            C1067a.f2808s = this.f2872H;
            m4386a(38, C0476a.m1776b(C1067a.f2808s.getBytes()));
        }
        if (C1067a.f2763N != this.f2873I) {
            C1067a.f2763N = this.f2873I;
            m4385a(39, String.valueOf(this.f2873I));
        }
        if (!C1067a.f2754E.equals(this.f2874J)) {
            C1067a.f2754E = this.f2874J;
            m4386a(41, C0476a.m1776b(C1067a.f2754E.getBytes()));
        }
        if (C1067a.f2764O != this.f2875K) {
            C1067a.f2764O = this.f2875K;
            m4385a(44, String.valueOf(this.f2875K));
        }
        if (C1067a.f2755F != this.f2876L) {
            C1067a.f2755F = this.f2876L;
            m4385a(46, String.valueOf(this.f2876L));
        }
        if (C1067a.f2765P != this.f2877M) {
            C1067a.f2765P = this.f2877M;
            m4385a(48, String.valueOf(this.f2877M));
        }
        if (C1067a.f2766Q != this.f2878N) {
            C1067a.f2766Q = this.f2878N;
            m4385a(49, String.valueOf(C1067a.f2766Q));
        }
        if (C1067a.f2767R != this.f2879O) {
            C1067a.f2767R = this.f2879O;
            m4385a(50, String.valueOf(C1067a.f2767R));
        }
        if (C1067a.f2768S != this.f2880P) {
            C1067a.f2768S = this.f2880P;
            m4385a(52, String.valueOf(C1067a.f2768S));
        }
        if (C1067a.f2765P != this.f2877M) {
            C1067a.f2765P = this.f2877M;
            m4385a(48, String.valueOf(this.f2877M));
        }
        if (C1067a.f2766Q != this.f2878N) {
            C1067a.f2766Q = this.f2878N;
            m4385a(49, String.valueOf(C1067a.f2766Q));
        }
        if (C1067a.f2767R != this.f2879O) {
            C1067a.f2767R = this.f2879O;
            m4385a(50, String.valueOf(C1067a.f2767R));
        }
        if (C1067a.f2768S != this.f2880P) {
            C1067a.f2768S = this.f2880P;
            m4385a(52, String.valueOf(C1067a.f2768S));
        }
        if (!C1067a.f2769T.equals(this.f2881Q)) {
            C1067a.f2769T = this.f2881Q;
            m4386a(53, C0476a.m1776b(C1067a.f2769T.getBytes()));
        }
        if (!C1067a.f2770U.equals(this.f2882R)) {
            C1067a.f2770U = this.f2882R;
            m4386a(70, C0476a.m1776b(C1067a.f2770U.getBytes()));
        }
        if (C1067a.f2773X != this.f2884T) {
            C1067a.f2773X = this.f2884T;
            m4385a(55, String.valueOf(C1067a.f2773X));
        }
        if (C1067a.f2774Y != this.f2885U) {
            C1067a.f2774Y = this.f2885U;
            m4385a(56, String.valueOf(C1067a.f2774Y));
        }
        if (!C1067a.f2772W.equals(this.f2883S)) {
            C1067a.f2772W = this.f2883S;
            m4385a(54, C1067a.f2772W);
        }
        if (C1067a.f2775Z != this.f2886V) {
            C1067a.f2775Z = this.f2886V;
            m4385a(57, String.valueOf(this.f2886V));
        }
        if (C1067a.f2777aa != this.f2887W) {
            C1067a.f2777aa = this.f2887W;
            m4385a(87, String.valueOf(this.f2887W));
        }
        if (C1067a.f2776a != this.f2888X) {
            C1067a.f2776a = this.f2888X;
            m4385a(88, String.valueOf(this.f2888X));
        }
        if (C1067a.f2781ae != this.f2889Y) {
            C1067a.f2781ae = this.f2889Y;
            m4385a(61, String.valueOf(this.f2889Y));
        }
        if (C1067a.f2782af != this.f2890Z) {
            C1067a.f2782af = this.f2890Z;
            m4385a(63, String.valueOf(this.f2890Z));
        }
        if (C1067a.f2815z != this.f2891aa) {
            C1067a.f2815z = this.f2891aa;
            m4385a(64, String.valueOf(C1067a.f2815z));
        }
        if (C1067a.f2750A != this.f2892ab) {
            C1067a.f2750A = this.f2892ab;
            m4385a(67, String.valueOf(C1067a.f2750A));
        }
        if (!C1067a.f2783ag.equals(this.f2893ac)) {
            C1067a.f2783ag = this.f2893ac;
            m4386a(71, C0476a.m1776b(C1067a.f2783ag.getBytes()));
        }
        if (C1067a.f2784ah != this.f2894ad) {
            mo5808a(true);
            C1067a.f2784ah = this.f2894ad;
            m4385a(72, String.valueOf(C1067a.f2784ah));
        }
        if (C1067a.f2778ab != this.f2895ae) {
            C1067a.f2778ab = this.f2895ae;
            m4385a(73, String.valueOf(C1067a.f2778ab));
        }
        if (C1067a.f2779ac != this.f2896af) {
            C1067a.f2779ac = this.f2896af;
            m4385a(74, String.valueOf(this.f2896af));
        }
        if (!C1067a.f2780ad.equals(this.f2897ag)) {
            C1067a.f2780ad = this.f2897ag;
            m4386a(75, C0476a.m1776b(C1067a.f2780ad.getBytes()));
        }
        if (!C1067a.f2771V.equals(this.f2899ai)) {
            C1067a.f2771V = this.f2899ai;
            m4386a(77, C0476a.m1776b(C1067a.f2771V.getBytes()));
        }
        if (C1067a.f2786aj != this.f2900aj) {
            C1067a.f2786aj = this.f2900aj;
            m4385a(78, String.valueOf(this.f2900aj));
        }
        if (C1067a.f2787ak != this.f2901ak) {
            C1067a.f2787ak = this.f2901ak;
            m4385a(79, String.valueOf(this.f2901ak));
        }
        if (C1067a.f2788al != this.f2902al) {
            C1067a.f2788al = this.f2902al;
            m4385a(80, String.valueOf(this.f2902al));
        }
        if (!C1067a.f2789am.equals(this.f2903am)) {
            C1067a.f2789am = this.f2903am;
            m4386a(81, C0476a.m1776b(C1067a.f2789am.getBytes()));
        }
        if (!C1067a.f2790an.equals(this.f2898ah)) {
            C1067a.f2790an = this.f2898ah;
            m4386a(85, C0476a.m1776b(C1067a.f2790an.getBytes()));
        }
        if (C1067a.f2813x != this.f2904an) {
            C1067a.f2813x = this.f2904an;
            m4385a(86, String.valueOf(C1067a.f2813x));
        }
    }

    /* renamed from: a */
    public void mo5808a(boolean z) {
        C1067a.f2785ai = z;
        m4385a(76, String.valueOf(C1067a.f2785ai));
    }

    /* renamed from: a */
    public void mo5809a(byte[] bArr) {
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            C1115d.m4559b("GBD_ConfigDataManager", "parse = " + jSONObject);
            C1083e.m4408a().mo5834h(System.currentTimeMillis());
            if (jSONObject.has("result") && "ok".equals(jSONObject.getString("result"))) {
                this.f2905b = C1067a.f2791b;
                this.f2906c = C1067a.f2792c;
                this.f2907d = C1067a.f2793d;
                this.f2908e = C1067a.f2794e;
                this.f2909f = C1067a.f2795f;
                this.f2910g = C1067a.f2796g;
                this.f2911h = C1067a.f2797h;
                this.f2912i = C1067a.f2798i;
                this.f2913j = C1067a.f2799j;
                this.f2914k = C1067a.f2800k;
                this.f2915l = C1067a.f2801l;
                this.f2916m = C1067a.f2802m;
                this.f2917n = C1067a.f2804o;
                this.f2918o = C1067a.f2806q;
                this.f2919p = C1067a.f2807r;
                this.f2920q = C1067a.f2809t;
                this.f2922s = C1067a.f2811v;
                this.f2921r = C1067a.f2810u;
                this.f2923t = C1067a.f2812w;
                this.f2924u = C1067a.f2805p;
                this.f2925v = C1067a.f2814y;
                this.f2926w = C1067a.f2803n;
                this.f2927x = C1067a.f2751B;
                this.f2928y = C1067a.f2752C;
                this.f2865A = C1067a.f2756G;
                this.f2929z = C1067a.f2753D;
                this.f2866B = C1067a.f2760K;
                this.f2867C = C1067a.f2761L;
                this.f2868D = C1067a.f2762M;
                this.f2869E = C1067a.f2757H;
                this.f2870F = C1067a.f2759J;
                this.f2871G = C1067a.f2758I;
                this.f2872H = C1067a.f2808s;
                this.f2873I = C1067a.f2763N;
                this.f2874J = C1067a.f2754E;
                this.f2875K = C1067a.f2764O;
                this.f2876L = C1067a.f2755F;
                this.f2877M = C1067a.f2765P;
                this.f2878N = C1067a.f2766Q;
                this.f2879O = C1067a.f2767R;
                this.f2880P = C1067a.f2768S;
                this.f2881Q = C1067a.f2769T;
                this.f2882R = C1067a.f2770U;
                this.f2883S = C1067a.f2772W;
                this.f2886V = C1067a.f2775Z;
                this.f2887W = C1067a.f2777aa;
                this.f2888X = C1067a.f2776a;
                this.f2884T = C1067a.f2773X;
                this.f2885U = C1067a.f2774Y;
                this.f2889Y = C1067a.f2781ae;
                this.f2890Z = C1067a.f2782af;
                this.f2891aa = C1067a.f2815z;
                this.f2892ab = C1067a.f2750A;
                this.f2893ac = C1067a.f2783ag;
                this.f2894ad = C1067a.f2784ah;
                this.f2896af = C1067a.f2779ac;
                this.f2895ae = C1067a.f2778ab;
                this.f2897ag = C1067a.f2780ad;
                this.f2899ai = C1067a.f2771V;
                this.f2900aj = C1067a.f2786aj;
                this.f2901ak = C1067a.f2787ak;
                this.f2902al = C1067a.f2788al;
                this.f2903am = C1067a.f2789am;
                this.f2898ah = C1067a.f2790an;
                this.f2904an = C1067a.f2813x;
                if (jSONObject.has("tag")) {
                    this.f2870F = jSONObject.getString("tag");
                }
                if (jSONObject.has("config")) {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.getString("config"));
                    if (jSONObject2.has("sdk.gbd.enable")) {
                        String string = jSONObject2.getString("sdk.gbd.enable");
                        if (string.equals("true") || string.equals("false")) {
                            this.f2905b = Boolean.valueOf(string).booleanValue();
                        }
                    }
                    if (jSONObject2.has("sdk.gbd.watchout.app")) {
                        this.f2906c = jSONObject2.getString("sdk.gbd.watchout.app");
                    }
                    if (jSONObject2.has("sdk.gbd.watchout.service")) {
                        this.f2907d = jSONObject2.getString("sdk.gbd.watchout.service");
                    }
                    if (jSONObject2.has("sdk.gbd.coordinate")) {
                        String string2 = jSONObject2.getString("sdk.gbd.coordinate");
                        if (string2.equals("true") || string2.equals("false")) {
                            this.f2908e = Boolean.valueOf(string2).booleanValue();
                        }
                    }
                    if (jSONObject2.has("sdk.gbd.freq")) {
                        this.f2909f = Long.parseLong(jSONObject2.getString("sdk.gbd.freq"));
                    }
                    if (jSONObject2.has("sdk.gbd.wifi.freq")) {
                        this.f2910g = Long.parseLong(jSONObject2.getString("sdk.gbd.wifi.freq"));
                    }
                    if (jSONObject2.has("sdk.gbd.wifi.level")) {
                        this.f2911h = Integer.parseInt(jSONObject2.getString("sdk.gbd.wifi.level"));
                    }
                    if (jSONObject2.has("sdk.gbd.wifi.timeout")) {
                        this.f2912i = Integer.parseInt(jSONObject2.getString("sdk.gbd.wifi.timeout"));
                    }
                    if (jSONObject2.has("sdk.gbd.wifi.size")) {
                        this.f2913j = Integer.parseInt(jSONObject2.getString("sdk.gbd.wifi.size"));
                    }
                    if (jSONObject2.has("sdk.gbd.wifi.changepercent")) {
                        this.f2914k = Integer.parseInt(jSONObject2.getString("sdk.gbd.wifi.changepercent"));
                    }
                    if (jSONObject2.has("sdk.gbd.gps.freq")) {
                        this.f2915l = (long) Integer.parseInt(jSONObject2.getString("sdk.gbd.gps.freq"));
                    }
                    if (jSONObject2.has("sdk.gbd.gps.distance")) {
                        this.f2916m = Integer.parseInt(jSONObject2.getString("sdk.gbd.gps.distance"));
                    }
                    if (jSONObject2.has("sdk.gbd.ral.size")) {
                        this.f2917n = Integer.parseInt(jSONObject2.getString("sdk.gbd.ral.size"));
                    }
                    if (jSONObject2.has("sdk.gbd.guard.enable")) {
                        this.f2918o = jSONObject2.getBoolean("sdk.gbd.guard.enable");
                    }
                    if (jSONObject2.has("sdk.gbd.guard.services")) {
                        this.f2919p = jSONObject2.getString("sdk.gbd.guard.services");
                    }
                    if (jSONObject2.has("sdk.gbd.guard.count")) {
                        this.f2920q = Integer.parseInt(jSONObject2.getString("sdk.gbd.guard.count"));
                    }
                    if (jSONObject2.has("sdk.gbd.guard.whitelist")) {
                        this.f2922s = jSONObject2.getString("sdk.gbd.guard.whitelist");
                    }
                    if (jSONObject2.has("sdk.gbd.guard.blacklist")) {
                        this.f2921r = jSONObject2.getString("sdk.gbd.guard.blacklist");
                    }
                    if (jSONObject2.has("gbd.guard.summary.duration")) {
                        this.f2923t = Long.parseLong(jSONObject2.getString("gbd.guard.summary.duration"));
                    }
                    if (jSONObject2.has("sdk.gbd.guardthirdparty.enable")) {
                        this.f2924u = jSONObject2.getBoolean("sdk.gbd.guardthirdparty.enable");
                    }
                    if (jSONObject2.has("sdk.gbd.guard.freq")) {
                        this.f2925v = Long.parseLong(jSONObject2.getString("sdk.gbd.guard.freq"));
                    }
                    if (jSONObject2.has("sdk.gbd.gps.interval")) {
                        this.f2926w = Long.parseLong(jSONObject2.getString("sdk.gbd.gps.interval"));
                    }
                    if (jSONObject2.has("sdk.gbd.sysmem.limit")) {
                        this.f2927x = Integer.parseInt(jSONObject2.getString("sdk.gbd.sysmem.limit"));
                    }
                    if (jSONObject2.has("sdk.gbd.appmem.limit")) {
                        this.f2928y = Integer.parseInt(jSONObject2.getString("sdk.gbd.appmem.limit"));
                    }
                    if (jSONObject2.has("sdk.gbd.recenttask.keyword")) {
                        this.f2929z = jSONObject2.getString("sdk.gbd.recenttask.keyword");
                    }
                    if (jSONObject2.has("sdk.gbd.recenttask.enable")) {
                        String string3 = jSONObject2.getString("sdk.gbd.recenttask.enable");
                        if (string3.equals("true") || string3.equals("false")) {
                            this.f2865A = Boolean.valueOf(string3).booleanValue();
                        }
                    }
                    if (jSONObject2.has("sdk.gbd.guardactivity.first")) {
                        String string4 = jSONObject2.getString("sdk.gbd.guardactivity.first");
                        if (string4.equals("true") || string4.equals("false")) {
                            this.f2866B = Boolean.valueOf(string4).booleanValue();
                        }
                    }
                    if (jSONObject2.has("sdk.gbd.guardtask.starttime")) {
                        this.f2867C = Integer.parseInt(jSONObject2.getString("sdk.gbd.guardtask.starttime"));
                    }
                    if (jSONObject2.has("sdk.gbd.guardtask.randomtime")) {
                        this.f2868D = Integer.parseInt(jSONObject2.getString("sdk.gbd.guardtask.randomtime"));
                    }
                    if (jSONObject2.has("sdk.gbd.locate.request")) {
                        String string5 = jSONObject2.getString("sdk.gbd.locate.request");
                        if (string5.equals("true") || string5.equals("false")) {
                            this.f2869E = Boolean.valueOf(string5).booleanValue();
                        }
                    }
                    if (jSONObject2.has("sdk.gbd.locate.requesttime")) {
                        this.f2871G = Integer.parseInt(jSONObject2.getString("sdk.gbd.locate.requesttime"));
                    }
                    if (jSONObject2.has("sdk.gbd.guard.intent")) {
                        this.f2872H = jSONObject2.getString("sdk.gbd.guard.intent");
                    }
                    if (jSONObject2.has("sdk.gbd.bluetooth.enable")) {
                        String string6 = jSONObject2.getString("sdk.gbd.bluetooth.enable");
                        if (string6.equals("true") || string6.equals("false")) {
                            this.f2873I = Boolean.valueOf(string6).booleanValue();
                        }
                    }
                    if (jSONObject2.has("sdk.gbd.systemapp.keyword")) {
                        this.f2874J = jSONObject2.getString("sdk.gbd.systemapp.keyword");
                    }
                    if (jSONObject2.has("sdk.gbd.guardlog.enable")) {
                        String string7 = jSONObject2.getString("sdk.gbd.guardlog.enable");
                        if (string7.equals("true") || string7.equals("false")) {
                            this.f2875K = Boolean.valueOf(string7).booleanValue();
                        }
                    }
                    if (jSONObject2.has("sdk.gbd.newrecenttask.enable")) {
                        String string8 = jSONObject2.getString("sdk.gbd.newrecenttask.enable");
                        if (string8.equals("true") || string8.equals("false")) {
                            this.f2876L = Boolean.valueOf(string8).booleanValue();
                        }
                    }
                    if (jSONObject2.has("sdk.gbd.mac.enable")) {
                        String string9 = jSONObject2.getString("sdk.gbd.mac.enable");
                        if (string9.equals("true") || string9.equals("false")) {
                            this.f2877M = Boolean.valueOf(string9).booleanValue();
                        }
                    }
                    if (jSONObject2.has("sdk.gbd.mac.interval")) {
                        this.f2878N = Long.parseLong(jSONObject2.getString("sdk.gbd.mac.interval"));
                    }
                    if (jSONObject2.has("sdk.gbd.mac.pingcount")) {
                        this.f2879O = Integer.parseInt(jSONObject2.getString("sdk.gbd.mac.pingcount"));
                    }
                    if (jSONObject2.has("sdk.gbd.mac.reportcount")) {
                        this.f2880P = Integer.parseInt(jSONObject2.getString("sdk.gbd.mac.reportcount"));
                    }
                    if (jSONObject2.has("sdk.gbd.guardgactivity.blacklist")) {
                        this.f2881Q = jSONObject2.getString("sdk.gbd.guardgactivity.blacklist");
                    }
                    if (jSONObject2.has("sdk.gbd.guard.romandsdkint.blacklist")) {
                        this.f2882R = jSONObject2.getString("sdk.gbd.guard.romandsdkint.blacklist");
                    }
                    if (jSONObject2.has("sdk.gbd.applist.enable")) {
                        String string10 = jSONObject2.getString("sdk.gbd.applist.enable");
                        if (string10.equals("true") || string10.equals("false")) {
                            this.f2886V = Boolean.valueOf(string10).booleanValue();
                        }
                    }
                    if (jSONObject2.has("sdk.gbd.sermd.enable")) {
                        String string11 = jSONObject2.getString("sdk.gbd.sermd.enable");
                        if (string11.equals("true") || string11.equals("false")) {
                            this.f2887W = Boolean.valueOf(string11).booleanValue();
                        }
                    }
                    if (jSONObject2.has("sdk.gbd.applist.runmax")) {
                        this.f2888X = Integer.parseInt(jSONObject2.getString("sdk.gbd.applist.runmax"));
                    }
                    if (jSONObject2.has("sdk.gbd.applist.interval")) {
                        this.f2884T = Long.parseLong(jSONObject2.getString("sdk.gbd.applist.interval"));
                    }
                    if (jSONObject2.has("sdk.gbd.applistreport.interval")) {
                        this.f2885U = Long.parseLong(jSONObject2.getString("sdk.gbd.applistreport.interval"));
                    }
                    if (jSONObject2.has("sdk.gbd.applist.channel")) {
                        this.f2883S = jSONObject2.getString("sdk.gbd.applist.channel");
                    }
                    if (jSONObject2.has("sdk.gbd.guardservice.interval")) {
                        this.f2889Y = Long.parseLong(jSONObject2.getString("sdk.gbd.guardservice.interval"));
                    }
                    if (jSONObject2.has("sdk.gbd.http.maxsize")) {
                        this.f2890Z = Integer.parseInt(jSONObject2.getString("sdk.gbd.http.maxsize"));
                    }
                    if (jSONObject2.has("sdk.gbd.lf_enable")) {
                        String string12 = jSONObject2.getString("sdk.gbd.lf_enable");
                        if (string12.equals("true") || string12.equals("false")) {
                            this.f2891aa = Boolean.valueOf(string12).booleanValue();
                        }
                    }
                    if (jSONObject2.has("sdk.gbd.lf_freq")) {
                        this.f2892ab = Long.parseLong(jSONObject2.getString("sdk.gbd.lf_freq"));
                    }
                    if (jSONObject2.has("sdk.gbd.app_list_url")) {
                        this.f2893ac = jSONObject2.getString("sdk.gbd.app_list_url");
                    }
                    if (jSONObject2.has("sdk.gbd.app_list_version")) {
                        this.f2894ad = Integer.parseInt(jSONObject2.getString("sdk.gbd.app_list_version"));
                    }
                    if (jSONObject2.has("sdk.gbd.target_app_list.enable")) {
                        String string13 = jSONObject2.getString("sdk.gbd.target_app_list.enable");
                        if (string13.equals("true") || string13.equals("false")) {
                            this.f2896af = Boolean.valueOf(string13).booleanValue();
                        }
                    }
                    if (jSONObject2.has("sdk.gbd.target_app_list.interval")) {
                        this.f2895ae = Long.parseLong(jSONObject2.getString("sdk.gbd.target_app_list.interval"));
                    }
                    if (jSONObject2.has("sdk.gbd.target_app_list")) {
                        this.f2897ag = jSONObject2.getString("sdk.gbd.target_app_list");
                    }
                    if (jSONObject2.has("sdk.gbd.pm_black_list")) {
                        this.f2899ai = jSONObject2.getString("sdk.gbd.pm_black_list");
                    }
                    if (jSONObject2.has("sdk.gbd.activity.enable")) {
                        String string14 = jSONObject2.getString("sdk.gbd.activity.enable");
                        if (string14.equals("true") || string14.equals("false")) {
                            this.f2900aj = Boolean.valueOf(string14).booleanValue();
                        }
                    }
                    if (jSONObject2.has("sdk.gbd.service.enable")) {
                        String string15 = jSONObject2.getString("sdk.gbd.service.enable");
                        if (string15.equals("true") || string15.equals("false")) {
                            this.f2901ak = Boolean.valueOf(string15).booleanValue();
                        }
                    }
                    if (jSONObject2.has("sdk.gbd.force.start")) {
                        String string16 = jSONObject2.getString("sdk.gbd.force.start");
                        if (string16.equals("true") || string16.equals("false")) {
                            this.f2902al = Boolean.valueOf(string16).booleanValue();
                        }
                    }
                    if (jSONObject2.has("sdk.gbd.force.start.target")) {
                        this.f2903am = jSONObject2.getString("sdk.gbd.force.start.target");
                    }
                    if (jSONObject2.has("sdk.gbd.permission.config")) {
                        this.f2898ah = jSONObject2.getString("sdk.gbd.permission.config");
                    }
                    if (jSONObject2.has("sdk.gbd.newrecent.interval")) {
                        this.f2904an = Long.parseLong(jSONObject2.getString("sdk.gbd.newrecent.interval"));
                    }
                    m4387c();
                }
            }
        } catch (Exception e) {
            C1115d.m4558a(e);
            C1115d.m4559b("GBD_ConfigDataManager", e.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:241:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ba  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo5810b() {
        /*
        // Method dump skipped, instructions count: 1222
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.gbd.p069e.p070a.C1079a.mo5810b():void");
    }
}
