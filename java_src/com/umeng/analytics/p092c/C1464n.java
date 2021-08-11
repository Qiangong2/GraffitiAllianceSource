package com.umeng.analytics.p092c;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.C1370a;
import com.umeng.analytics.p093d.C1488m;

/* renamed from: com.umeng.analytics.c.n */
/* compiled from: UOPTracker */
public class C1464n extends AbstractC1449a {

    /* renamed from: a */
    private static final String f3603a = "uop";

    /* renamed from: b */
    private Context f3604b;

    public C1464n(Context context) {
        super(f3603a);
        this.f3604b = context;
    }

    @Override // com.umeng.analytics.p092c.AbstractC1449a
    /* renamed from: f */
    public String mo8554f() {
        SharedPreferences a = C1488m.m5522a(this.f3604b);
        if (a != null) {
            return a.getString(C1370a.f3226r, "");
        }
        return "";
    }
}
