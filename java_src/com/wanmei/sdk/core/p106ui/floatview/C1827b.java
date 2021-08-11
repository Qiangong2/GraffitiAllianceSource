package com.wanmei.sdk.core.p106ui.floatview;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.wanmei.sdk.core.p106ui.floatview.p107a.C1823b;

/* renamed from: com.wanmei.sdk.core.ui.floatview.b */
public class C1827b {

    /* renamed from: a */
    private Context f4551a;

    /* renamed from: b */
    private int f4552b;

    /* renamed from: c */
    private int f4553c;

    /* renamed from: d */
    private volatile boolean f4554d = true;

    /* renamed from: e */
    private int f4555e;

    /* renamed from: f */
    private C1821a f4556f;

    /* renamed from: g */
    private View.OnTouchListener f4557g = new View.OnTouchListener() {
        /* class com.wanmei.sdk.core.p106ui.floatview.C1827b.View$OnTouchListenerC18281 */

        public boolean onTouch(View v, MotionEvent event) {
            int rawX = (int) event.getRawX();
            int rawY = (int) event.getRawY();
            C1827b.this.f4560j = rawX - (C1827b.this.f4556f.mo9870c() / 2);
            C1827b.this.f4561k = rawY - (C1827b.this.f4556f.mo9871d() / 2);
            boolean z = Math.abs(((float) rawX) - C1827b.this.f4562l) >= 100.0f || Math.abs(((float) rawY) - C1827b.this.f4563m) >= 100.0f;
            switch (event.getAction() & 255) {
                case 0:
                    C1827b.this.f4562l = (float) ((int) event.getRawX());
                    C1827b.this.f4563m = (float) ((int) event.getRawY());
                    break;
                case 1:
                    C1827b.this.f4558h.mo9881d();
                    break;
                case 2:
                    if (z && C1827b.this.f4554d) {
                        C1827b.this.f4556f.mo9867a(C1827b.this.f4560j, C1827b.this.f4561k);
                        C1827b.this.f4558h.mo9880c();
                        break;
                    }
            }
            return false;
        }
    };

    /* renamed from: h */
    private C1823b f4558h;

    /* renamed from: i */
    private Handler f4559i = new Handler() {
        /* class com.wanmei.sdk.core.p106ui.floatview.C1827b.HandlerC18292 */

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    if (C1827b.this.f4560j <= C1827b.this.f4552b / 2) {
                        while (C1827b.this.f4560j > 0) {
                            C1827b.m6644i(C1827b.this);
                            C1827b.this.f4559i.postDelayed(new Runnable() {
                                /* class com.wanmei.sdk.core.p106ui.floatview.C1827b.HandlerC18292.RunnableC18301 */

                                public void run() {
                                    C1827b.this.f4556f.mo9867a(C1827b.this.f4560j, C1827b.this.f4561k);
                                }
                            }, 5);
                        }
                        return;
                    }
                    while (C1827b.this.f4560j < C1827b.this.f4552b) {
                        C1827b.m6646k(C1827b.this);
                        new Handler().postDelayed(new Runnable() {
                            /* class com.wanmei.sdk.core.p106ui.floatview.C1827b.HandlerC18292.RunnableC18312 */

                            public void run() {
                                C1827b.this.f4556f.mo9867a(C1827b.this.f4560j, C1827b.this.f4561k);
                            }
                        }, 5);
                    }
                    return;
                default:
                    return;
            }
        }
    };

    /* renamed from: j */
    private volatile int f4560j = 0;

    /* renamed from: k */
    private volatile int f4561k = 0;

    /* renamed from: l */
    private float f4562l = 0.0f;

    /* renamed from: m */
    private float f4563m = 0.0f;

    public C1827b(Context context, int i, FloatViewItem[] floatViewItemArr) {
        this.f4551a = context;
        this.f4555e = i;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this.f4552b = windowManager.getDefaultDisplay().getWidth();
        this.f4553c = windowManager.getDefaultDisplay().getHeight();
        this.f4556f = new C1821a(context, this.f4555e, floatViewItemArr);
        this.f4556f.mo9868a(this.f4557g);
        this.f4558h = C1823b.m6620a(this);
    }

    /* renamed from: i */
    static /* synthetic */ int m6644i(C1827b bVar) {
        int i = bVar.f4560j - 20;
        bVar.f4560j = i;
        return i;
    }

    /* renamed from: k */
    static /* synthetic */ int m6646k(C1827b bVar) {
        int i = bVar.f4560j + 20;
        bVar.f4560j = i;
        return i;
    }

    /* renamed from: a */
    public void mo9885a() {
        this.f4556f.mo9873f();
    }

    /* renamed from: a */
    public void mo9886a(int i) {
        this.f4556f.mo9866a(i);
    }

    /* renamed from: a */
    public void mo9887a(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this.f4552b = windowManager.getDefaultDisplay().getWidth();
        this.f4553c = windowManager.getDefaultDisplay().getHeight();
    }

    /* renamed from: a */
    public void mo9888a(boolean z) {
        this.f4554d = z;
    }

    /* renamed from: b */
    public void mo9889b() {
        this.f4556f.mo9874g();
    }

    /* renamed from: c */
    public void mo9890c() {
        this.f4556f.mo9875h();
    }

    /* renamed from: d */
    public void mo9891d() {
        this.f4556f.mo9865a();
    }

    /* renamed from: e */
    public void mo9892e() {
        this.f4556f.mo9869b();
    }

    /* renamed from: f */
    public Context mo9893f() {
        return this.f4551a;
    }

    /* renamed from: g */
    public Handler mo9894g() {
        return this.f4559i;
    }

    /* renamed from: h */
    public C1823b mo9895h() {
        return this.f4558h;
    }
}
