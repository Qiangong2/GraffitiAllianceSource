package com.wanmei.sdk.core.p106ui.floatview;

import android.content.Context;
import android.content.Intent;

/* renamed from: com.wanmei.sdk.core.ui.floatview.c */
public class C1839c {

    /* renamed from: a */
    private static volatile C1839c f4578a;

    /* renamed from: b */
    private boolean f4579b;

    /* renamed from: a */
    public static C1839c m6668a() {
        if (f4578a == null) {
            synchronized (C1839c.class) {
                if (f4578a == null) {
                    f4578a = new C1839c();
                }
            }
        }
        return f4578a;
    }

    /* renamed from: a */
    public void mo9907a(Context context) {
        if (this.f4579b) {
            Intent intent = new Intent(context, FloatViewService.class);
            intent.putExtra("floatViewAction", 1);
            context.startService(intent);
        }
    }

    /* renamed from: a */
    public void mo9908a(Context context, int i, FloatViewItem[] floatViewItemArr) {
        this.f4579b = true;
        if (this.f4579b) {
            Intent intent = new Intent(context, FloatViewService.class);
            intent.putExtra("floatViewPlace", i);
            intent.putExtra("floatViewAction", 0);
            FloatViewService.m6605a(floatViewItemArr);
            context.startService(intent);
        }
    }

    /* renamed from: b */
    public void mo9909b(Context context) {
        if (this.f4579b) {
            context.stopService(new Intent(context, FloatViewService.class));
            this.f4579b = false;
        }
    }
}
