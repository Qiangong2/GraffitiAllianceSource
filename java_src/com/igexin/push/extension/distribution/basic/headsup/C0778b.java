package com.igexin.push.extension.distribution.basic.headsup;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.igexin.push.core.C0618g;
import com.igexin.push.extension.distribution.basic.p060k.C0992l;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressLint({"ViewConstructor", "NewApi"})
/* renamed from: com.igexin.push.extension.distribution.basic.headsup.b */
public class C0778b extends LinearLayout {

    /* renamed from: h */
    public static WindowManager.LayoutParams f2161h = new WindowManager.LayoutParams();

    /* renamed from: A */
    private Handler f2162A;

    /* renamed from: B */
    private C0783g f2163B;

    /* renamed from: C */
    private int f2164C;

    /* renamed from: D */
    private int f2165D;

    /* renamed from: E */
    private int f2166E;

    /* renamed from: a */
    public LinearLayout f2167a;

    /* renamed from: b */
    public int f2168b;

    /* renamed from: c */
    public int f2169c;

    /* renamed from: d */
    public int f2170d;

    /* renamed from: e */
    public float f2171e;

    /* renamed from: f */
    ImageView f2172f;

    /* renamed from: g */
    ImageView f2173g;

    /* renamed from: i */
    View f2174i;

    /* renamed from: j */
    View f2175j;

    /* renamed from: k */
    WrapperView f2176k;

    /* renamed from: l */
    C0992l f2177l;

    /* renamed from: m */
    int f2178m;

    /* renamed from: n */
    int f2179n;

    /* renamed from: o */
    int f2180o;

    /* renamed from: p */
    private VelocityTracker f2181p;

    /* renamed from: q */
    private Context f2182q;

    /* renamed from: r */
    private EnumC0785i f2183r;

    /* renamed from: s */
    private EnumC0784h f2184s;

    /* renamed from: t */
    private int f2185t;

    /* renamed from: u */
    private boolean f2186u;

    /* renamed from: v */
    private GestureDetector f2187v;

    /* renamed from: w */
    private C0777a f2188w;

    /* renamed from: x */
    private GestureDetector.OnGestureListener f2189x;

    /* renamed from: y */
    private C0786j f2190y;

    /* renamed from: z */
    private long f2191z;

    public C0778b(Context context, int i) {
        super(context);
        this.f2182q = null;
        this.f2183r = EnumC0785i.NONE;
        this.f2184s = EnumC0784h.NONE;
        this.f2185t = 0;
        this.f2174i = null;
        this.f2175j = null;
        this.f2186u = false;
        this.f2176k = null;
        this.f2177l = null;
        this.f2188w = null;
        this.f2189x = new C0779c(this);
        this.f2162A = null;
        this.f2165D = 0;
        this.f2178m = 0;
        this.f2179n = 0;
        this.f2180o = 0;
        this.f2188w = new C0777a();
        this.f2177l = C0992l.m3982a(context);
        this.f2182q = context;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(Color.rgb(0, 0, 0));
        linearLayout.getBackground().setAlpha(230);
        this.f2168b = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        this.f2167a = linearLayout;
        addView(linearLayout);
        this.f2170d = context.getResources().getDisplayMetrics().widthPixels;
        this.f2171e = ((float) this.f2170d) / 2.0f;
        this.f2169c = 0;
        this.f2187v = new GestureDetector(C0618g.f1635f, this.f2189x);
    }

    /* renamed from: a */
    public static int m3228a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    /* renamed from: a */
    private void m3231a(MotionEvent motionEvent) {
        if (this.f2181p == null) {
            this.f2181p = VelocityTracker.obtain();
        }
        this.f2181p.addMovement(motionEvent);
    }

    /* renamed from: h */
    static /* synthetic */ long m3238h(C0778b bVar) {
        long j = bVar.f2191z;
        bVar.f2191z = j - 1;
        return j;
    }

    /* renamed from: a */
    public int mo5144a(String str) {
        int i = 0;
        if (str == null || str.length() <= 0) {
            return 0;
        }
        for (int length = str.length() - 1; length >= 0; length--) {
            char charAt = str.charAt(length);
            i = ((charAt < '0' || charAt > '9') && (charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) ? Character.isLetter(charAt) ? i + 2 : i + 1 : i + 1;
        }
        return i / 2;
    }

    /* renamed from: a */
    public C0786j mo5145a() {
        return this.f2190y;
    }

    /* renamed from: a */
    public void mo5146a(float f, float f2, float f3, float f4) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f2167a, "alpha", f3, f4);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f2167a, "translationX", f, f2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new C0780d(this, f4));
        animatorSet.start();
    }

    /* renamed from: a */
    public void mo5147a(int i) {
        float abs = 1.0f - (((float) Math.abs(this.f2166E)) / this.f2171e);
        float abs2 = 1.0f - (((float) Math.abs(i)) / this.f2171e);
        if (abs < 0.0f) {
            abs = 0.0f;
        }
        if (abs2 < 0.0f) {
            abs2 = 0.0f;
        }
        mo5146a((float) this.f2166E, (float) i, abs, abs2);
        this.f2166E = i;
    }

    /* renamed from: a */
    public void mo5148a(View view) {
        this.f2167a.addView(view);
    }

    /* renamed from: a */
    public void mo5149a(C0786j jVar) {
        this.f2190y = jVar;
        this.f2162A = new HandlerC0781e(this, jVar);
        this.f2191z = jVar.mo5184g();
        this.f2163B = new C0783g(this, null);
        this.f2163B.start();
        if (jVar.mo5189l() == null) {
            C0992l a = C0992l.m3982a(this.f2182q);
            View inflate = LayoutInflater.from(getContext()).inflate(a.mo5638a("getui_notification", "layout"), (ViewGroup) this.f2167a, false);
            this.f2167a.addView(inflate);
            int a2 = a.mo5638a("getui_notification_bg", "id");
            int a3 = a.mo5638a("getui_notification_icon", "id");
            int a4 = a.mo5638a("getui_notification_date", "id");
            int a5 = a.mo5638a("getui_notification_icon2", "id");
            int a6 = a.mo5638a("getui_notification_headsup", "id");
            inflate.findViewById(a2).setVisibility(8);
            inflate.findViewById(a3).setVisibility(8);
            inflate.findViewById(a4).setVisibility(8);
            inflate.findViewById(a5).setVisibility(8);
            inflate.findViewById(a6).setVisibility(0);
            int a7 = a.mo5638a("getui_icon_headsup", "id");
            int a8 = a.mo5638a("getui_title_headsup", "id");
            int a9 = a.mo5638a("getui_time_headsup", "id");
            int a10 = a.mo5638a("getui_message_headsup", "id");
            this.f2179n = a.mo5638a("getui_big_imageView_headsup", "id");
            int a11 = a.mo5638a("getui_headsup_banner", "id");
            this.f2180o = a.mo5638a("getui_big_text_headsup", "id");
            this.f2178m = a.mo5638a("getui_big_imageView_headsup2", "id");
            TextView textView = (TextView) inflate.findViewById(a9);
            ((ImageView) inflate.findViewById(a7)).setImageBitmap(jVar.mo5164a());
            ((TextView) inflate.findViewById(a8)).setText(jVar.mo5185h());
            ((TextView) inflate.findViewById(a10)).setText(jVar.mo5186i());
            if (jVar.mo5177b()) {
                textView.setText(new SimpleDateFormat("HH:mm").format(new Date()));
            }
            switch (C0782f.f2198b[jVar.mo5178c().ordinal()]) {
                case 1:
                    inflate.findViewById(a7).setVisibility(8);
                    inflate.findViewById(a8).setVisibility(8);
                    inflate.findViewById(a9).setVisibility(8);
                    inflate.findViewById(a10).setVisibility(8);
                    inflate.findViewById(this.f2179n).setVisibility(8);
                    ImageView imageView = (ImageView) inflate.findViewById(a11);
                    imageView.setVisibility(0);
                    imageView.setImageBitmap(jVar.mo5181d());
                    return;
                case 2:
                    this.f2186u = true;
                    this.f2183r = EnumC0785i.PICTURE;
                    ImageView imageView2 = (ImageView) inflate.findViewById(this.f2179n);
                    imageView2.setImageBitmap(jVar.mo5183f());
                    imageView2.setVisibility(0);
                    return;
                case 3:
                    this.f2186u = true;
                    this.f2183r = EnumC0785i.TEXT;
                    if (jVar.mo5182e() != null && !jVar.mo5182e().equals("")) {
                        TextView textView2 = (TextView) inflate.findViewById(this.f2180o);
                        textView2.setText(jVar.mo5182e());
                        textView2.setVisibility(0);
                        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
                        int width = windowManager.getDefaultDisplay().getWidth();
                        windowManager.getDefaultDisplay().getHeight();
                        try {
                            int a12 = mo5144a(textView2.getText().toString()) / ((width - 142) / ((int) textView2.getTextSize()));
                            if (a12 == 0) {
                                a12 = 1;
                            }
                            if (a12 != 0) {
                                a12++;
                            }
                            this.f2185t = (a12 * textView2.getLineHeight()) + 5;
                            textView2.setHeight(0);
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    } else {
                        return;
                    }
                case 4:
                    this.f2183r = EnumC0785i.BANNER;
                    this.f2186u = true;
                    inflate.findViewById(a7).setVisibility(8);
                    inflate.findViewById(a8).setVisibility(8);
                    inflate.findViewById(a9).setVisibility(8);
                    inflate.findViewById(a10).setVisibility(8);
                    inflate.findViewById(this.f2179n).setVisibility(8);
                    this.f2172f = (ImageView) inflate.findViewById(a11);
                    this.f2172f.setVisibility(0);
                    this.f2173g = (ImageView) inflate.findViewById(this.f2178m);
                    this.f2173g.setVisibility(0);
                    this.f2172f.setImageBitmap(jVar.mo5181d());
                    this.f2173g.setImageBitmap(jVar.mo5183f());
                    return;
                case 5:
                default:
                    return;
            }
        } else {
            mo5148a(jVar.mo5189l());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5150a(boolean z) {
        C0789m.m3318a(getContext()).mo5234c();
        if (z) {
            ((NotificationManager) C0618g.f1635f.getSystemService("notification")).cancel(this.f2190y.mo5190m());
        }
        this.f2191z = -1;
        this.f2163B.interrupt();
        if (this.f2181p != null) {
            try {
                this.f2181p.clear();
                this.f2181p.recycle();
            } catch (IllegalStateException e) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int abs;
        this.f2187v.onTouchEvent(motionEvent);
        this.f2188w.mo5130f(motionEvent.getRawX());
        this.f2188w.mo5132g(motionEvent.getRawY());
        m3231a(motionEvent);
        this.f2191z = this.f2190y.mo5184g();
        switch (motionEvent.getAction()) {
            case 0:
                this.f2188w.mo5126d(motionEvent.getX());
                this.f2188w.mo5134h(motionEvent.getRawY());
                this.f2164C = motionEvent.getPointerId(0);
                this.f2188w.mo5136i(motionEvent.getX());
                this.f2188w.mo5142l(motionEvent.getY());
                break;
            case 1:
                this.f2188w.mo5138j(motionEvent.getX());
                this.f2188w.mo5143m(motionEvent.getY());
                if (this.f2188w.mo5139k() - this.f2188w.mo5141l() > 50.0f && Math.abs(this.f2188w.mo5135i() - this.f2188w.mo5133h()) <= this.f2188w.mo5139k() - this.f2188w.mo5141l()) {
                    mo5150a(false);
                } else if (this.f2188w.mo5141l() - this.f2188w.mo5139k() <= 50.0f || Math.abs(this.f2188w.mo5135i() - this.f2188w.mo5133h()) > this.f2188w.mo5141l() - this.f2188w.mo5139k()) {
                    if (this.f2188w.mo5133h() - this.f2188w.mo5135i() > 50.0f && Math.abs(this.f2188w.mo5141l() - this.f2188w.mo5139k()) < this.f2188w.mo5133h() - this.f2188w.mo5135i()) {
                        mo5150a(true);
                    } else if (this.f2188w.mo5135i() - this.f2188w.mo5133h() > 50.0f && Math.abs(this.f2188w.mo5141l() - this.f2188w.mo5139k()) < this.f2188w.mo5135i() - this.f2188w.mo5133h()) {
                        mo5150a(true);
                    }
                }
                if (motionEvent.getPointerCount() == 1) {
                    this.f2181p.computeCurrentVelocity(1000, (float) this.f2168b);
                    int yVelocity = (int) this.f2181p.getYVelocity(this.f2164C);
                    if (this.f2166E > 0) {
                        abs = Math.abs(yVelocity) + this.f2166E;
                    } else {
                        abs = this.f2166E - Math.abs(yVelocity);
                    }
                    if (((float) abs) <= (-this.f2171e)) {
                        float abs2 = 1.0f - (((float) Math.abs(this.f2166E)) / this.f2171e);
                        if (abs2 < 0.0f) {
                            abs2 = 0.0f;
                        }
                        mo5146a((float) this.f2166E, -(this.f2171e + 10.0f), abs2, 0.0f);
                    } else if (((float) abs) <= this.f2171e) {
                        float abs3 = 1.0f - (((float) Math.abs(this.f2166E)) / this.f2171e);
                        if (abs3 < 0.0f) {
                            abs3 = 0.0f;
                        }
                        mo5146a((float) this.f2166E, 0.0f, abs3, 1.0f);
                    } else {
                        float abs4 = 1.0f - (((float) Math.abs(this.f2166E)) / this.f2171e);
                        if (abs4 < 0.0f) {
                            abs4 = 0.0f;
                        }
                        mo5146a((float) this.f2166E, this.f2171e + 10.0f, abs4, 0.0f);
                    }
                    this.f2166E = 0;
                    this.f2184s = EnumC0784h.NONE;
                    break;
                }
                break;
            case 2:
                this.f2188w.mo5140k(motionEvent.getX());
                this.f2188w.mo5120a(motionEvent.getY());
                if ((this.f2188w.mo5139k() - this.f2188w.mo5119a() <= 50.0f || Math.abs(this.f2188w.mo5137j() - this.f2188w.mo5133h()) > this.f2188w.mo5139k() - this.f2188w.mo5119a()) && (this.f2188w.mo5119a() - this.f2188w.mo5139k() <= 50.0f || Math.abs(this.f2188w.mo5137j() - this.f2188w.mo5133h()) > this.f2188w.mo5119a() - this.f2188w.mo5139k())) {
                    mo5147a((int) (this.f2188w.mo5127e() - this.f2188w.mo5123c()));
                } else {
                    mo5147a(0);
                }
                if (motionEvent.getPointerCount() == 1) {
                    switch (C0782f.f2197a[this.f2184s.ordinal()]) {
                        case 1:
                            if (Math.abs(this.f2188w.mo5127e() - this.f2188w.mo5123c()) <= 20.0f) {
                                if (this.f2188w.mo5131g() - this.f2188w.mo5129f() > 20.0f) {
                                    this.f2184s = EnumC0784h.VERTICAL;
                                    break;
                                }
                            } else {
                                this.f2184s = EnumC0784h.HORIZONTAL;
                                break;
                            }
                            break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }
}
