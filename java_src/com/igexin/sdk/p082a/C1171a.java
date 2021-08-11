package com.igexin.sdk.p082a;

import android.content.Context;
import com.igexin.push.core.stub.PushCore;
import com.igexin.sdk.IPushCore;

/* renamed from: com.igexin.sdk.a.a */
public class C1171a {

    /* renamed from: a */
    private static String f3058a = "PushSdk";

    /* renamed from: c */
    private static C1171a f3059c;

    /* renamed from: b */
    private IPushCore f3060b;

    private C1171a() {
    }

    /* renamed from: a */
    public static C1171a m4817a() {
        if (f3059c == null) {
            f3059c = new C1171a();
        }
        return f3059c;
    }

    /* renamed from: a */
    public void mo5962a(IPushCore iPushCore) {
        this.f3060b = iPushCore;
    }

    /* renamed from: a */
    public boolean mo5963a(Context context) {
        try {
            mo5962a(new PushCore());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: b */
    public IPushCore mo5964b() {
        return this.f3060b;
    }
}
