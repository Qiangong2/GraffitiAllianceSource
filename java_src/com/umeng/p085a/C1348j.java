package com.umeng.p085a;

import android.content.Context;
import com.umeng.analytics.C1370a;
import com.umeng.analytics.p093d.C1494q;
import com.umeng.analytics.p094e.C1497b;

/* renamed from: com.umeng.a.j */
/* compiled from: ReportPolicy */
public class C1348j {

    /* renamed from: a */
    public static final int f3157a = 0;

    /* renamed from: b */
    public static final int f3158b = 1;

    /* renamed from: c */
    static final int f3159c = 2;

    /* renamed from: d */
    static final int f3160d = 3;

    /* renamed from: e */
    public static final int f3161e = 4;

    /* renamed from: f */
    public static final int f3162f = 5;

    /* renamed from: g */
    public static final int f3163g = 6;

    /* renamed from: h */
    public static final int f3164h = 8;

    /* renamed from: a */
    public static boolean m5020a(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 8:
                return true;
            case 7:
            default:
                return false;
        }
    }

    /* renamed from: com.umeng.a.j$h */
    /* compiled from: ReportPolicy */
    public static class C1356h {
        /* renamed from: a */
        public boolean mo8370a(boolean z) {
            return true;
        }

        /* renamed from: a */
        public boolean mo8371a() {
            return true;
        }
    }

    /* renamed from: com.umeng.a.j$g */
    /* compiled from: ReportPolicy */
    public static class C1355g extends C1356h {
        @Override // com.umeng.p085a.C1348j.C1356h
        /* renamed from: a */
        public boolean mo8370a(boolean z) {
            return true;
        }
    }

    /* renamed from: com.umeng.a.j$d */
    /* compiled from: ReportPolicy */
    public static class C1352d extends C1356h {
        @Override // com.umeng.p085a.C1348j.C1356h
        /* renamed from: a */
        public boolean mo8370a(boolean z) {
            return z;
        }
    }

    /* renamed from: com.umeng.a.j$e */
    /* compiled from: ReportPolicy */
    public static class C1353e extends C1356h {

        /* renamed from: a */
        private static long f3171a = 90000;

        /* renamed from: b */
        private static long f3172b = C1370a.f3217i;

        /* renamed from: c */
        private long f3173c;

        /* renamed from: d */
        private C1494q f3174d;

        public C1353e(C1494q qVar, long j) {
            this.f3174d = qVar;
            mo8372a(j);
        }

        @Override // com.umeng.p085a.C1348j.C1356h
        /* renamed from: a */
        public boolean mo8370a(boolean z) {
            if (System.currentTimeMillis() - this.f3174d.f3707c >= this.f3173c) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public void mo8372a(long j) {
            if (j < f3171a || j > f3172b) {
                this.f3173c = f3171a;
            } else {
                this.f3173c = j;
            }
        }

        /* renamed from: b */
        public long mo8373b() {
            return this.f3173c;
        }

        /* renamed from: a */
        public static boolean m5027a(int i) {
            if (((long) i) < f3171a) {
                return false;
            }
            return true;
        }
    }

    /* renamed from: com.umeng.a.j$f */
    /* compiled from: ReportPolicy */
    public static class C1354f extends C1356h {

        /* renamed from: a */
        private long f3175a = C1370a.f3217i;

        /* renamed from: b */
        private C1494q f3176b;

        public C1354f(C1494q qVar) {
            this.f3176b = qVar;
        }

        @Override // com.umeng.p085a.C1348j.C1356h
        /* renamed from: a */
        public boolean mo8370a(boolean z) {
            if (System.currentTimeMillis() - this.f3176b.f3707c >= this.f3175a) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: com.umeng.a.j$i */
    /* compiled from: ReportPolicy */
    public static class C1357i extends C1356h {

        /* renamed from: a */
        private Context f3177a = null;

        public C1357i(Context context) {
            this.f3177a = context;
        }

        @Override // com.umeng.p085a.C1348j.C1356h
        /* renamed from: a */
        public boolean mo8370a(boolean z) {
            return C1343e.m4955k(this.f3177a);
        }
    }

    /* renamed from: com.umeng.a.j$b */
    /* compiled from: ReportPolicy */
    public static class C1350b extends C1356h {

        /* renamed from: a */
        private C1497b f3167a;

        /* renamed from: b */
        private C1494q f3168b;

        public C1350b(C1494q qVar, C1497b bVar) {
            this.f3168b = qVar;
            this.f3167a = bVar;
        }

        @Override // com.umeng.p085a.C1348j.C1356h
        /* renamed from: a */
        public boolean mo8370a(boolean z) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f3168b.f3707c >= this.f3167a.mo8681b()) {
                return true;
            }
            return false;
        }

        @Override // com.umeng.p085a.C1348j.C1356h
        /* renamed from: a */
        public boolean mo8371a() {
            return this.f3167a.mo8683d();
        }
    }

    /* renamed from: com.umeng.a.j$c */
    /* compiled from: ReportPolicy */
    public static class C1351c extends C1356h {

        /* renamed from: a */
        private long f3169a;

        /* renamed from: b */
        private long f3170b = 0;

        public C1351c(int i) {
            this.f3169a = (long) i;
            this.f3170b = System.currentTimeMillis();
        }

        @Override // com.umeng.p085a.C1348j.C1356h
        /* renamed from: a */
        public boolean mo8370a(boolean z) {
            if (System.currentTimeMillis() - this.f3170b >= this.f3169a) {
                return true;
            }
            return false;
        }

        @Override // com.umeng.p085a.C1348j.C1356h
        /* renamed from: a */
        public boolean mo8371a() {
            return System.currentTimeMillis() - this.f3170b < this.f3169a;
        }
    }

    /* renamed from: com.umeng.a.j$j */
    /* compiled from: ReportPolicy */
    public static class C1358j extends C1356h {

        /* renamed from: a */
        private final long f3178a = 10800000;

        /* renamed from: b */
        private C1494q f3179b;

        public C1358j(C1494q qVar) {
            this.f3179b = qVar;
        }

        @Override // com.umeng.p085a.C1348j.C1356h
        /* renamed from: a */
        public boolean mo8370a(boolean z) {
            if (System.currentTimeMillis() - this.f3179b.f3707c >= 10800000) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: com.umeng.a.j$a */
    /* compiled from: ReportPolicy */
    public static class C1349a extends C1356h {

        /* renamed from: a */
        private final long f3165a = 15000;

        /* renamed from: b */
        private C1494q f3166b;

        public C1349a(C1494q qVar) {
            this.f3166b = qVar;
        }

        @Override // com.umeng.p085a.C1348j.C1356h
        /* renamed from: a */
        public boolean mo8370a(boolean z) {
            if (System.currentTimeMillis() - this.f3166b.f3707c >= 15000) {
                return true;
            }
            return false;
        }
    }
}
