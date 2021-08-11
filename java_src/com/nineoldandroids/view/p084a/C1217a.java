package com.nineoldandroids.view.p084a;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* renamed from: com.nineoldandroids.view.a.a */
public final class C1217a extends Animation {

    /* renamed from: a */
    public static final boolean f3095a = (Integer.valueOf(Build.VERSION.SDK).intValue() < 11);

    /* renamed from: b */
    private static final WeakHashMap<View, C1217a> f3096b = new WeakHashMap<>();

    /* renamed from: c */
    private final WeakReference<View> f3097c;

    /* renamed from: d */
    private final Camera f3098d = new Camera();

    /* renamed from: e */
    private boolean f3099e;

    /* renamed from: f */
    private float f3100f = 1.0f;

    /* renamed from: g */
    private float f3101g;

    /* renamed from: h */
    private float f3102h;

    /* renamed from: i */
    private float f3103i;

    /* renamed from: j */
    private float f3104j;

    /* renamed from: k */
    private float f3105k;

    /* renamed from: l */
    private float f3106l = 1.0f;

    /* renamed from: m */
    private float f3107m = 1.0f;

    /* renamed from: n */
    private float f3108n;

    /* renamed from: o */
    private float f3109o;

    /* renamed from: p */
    private final RectF f3110p = new RectF();

    /* renamed from: q */
    private final RectF f3111q = new RectF();

    /* renamed from: r */
    private final Matrix f3112r = new Matrix();

    private C1217a(View view) {
        setDuration(0);
        setFillAfter(true);
        view.setAnimation(this);
        this.f3097c = new WeakReference<>(view);
    }

    /* renamed from: a */
    public static C1217a m4856a(View view) {
        C1217a aVar = f3096b.get(view);
        if (aVar != null && aVar == view.getAnimation()) {
            return aVar;
        }
        C1217a aVar2 = new C1217a(view);
        f3096b.put(view, aVar2);
        return aVar2;
    }

    /* renamed from: a */
    private void m4857a(Matrix matrix, View view) {
        float width = (float) view.getWidth();
        float height = (float) view.getHeight();
        boolean z = this.f3099e;
        float f = z ? this.f3101g : width / 2.0f;
        float f2 = z ? this.f3102h : height / 2.0f;
        float f3 = this.f3103i;
        float f4 = this.f3104j;
        float f5 = this.f3105k;
        if (!(f3 == 0.0f && f4 == 0.0f && f5 == 0.0f)) {
            Camera camera = this.f3098d;
            camera.save();
            camera.rotateX(f3);
            camera.rotateY(f4);
            camera.rotateZ(-f5);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f, -f2);
            matrix.postTranslate(f, f2);
        }
        float f6 = this.f3106l;
        float f7 = this.f3107m;
        if (!(f6 == 1.0f && f7 == 1.0f)) {
            matrix.postScale(f6, f7);
            matrix.postTranslate((-(f / width)) * ((f6 * width) - width), (-(f2 / height)) * ((f7 * height) - height));
        }
        matrix.postTranslate(this.f3108n, this.f3109o);
    }

    /* renamed from: a */
    private void m4858a(RectF rectF, View view) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        Matrix matrix = this.f3112r;
        matrix.reset();
        m4857a(matrix, view);
        this.f3112r.mapRect(rectF);
        rectF.offset((float) view.getLeft(), (float) view.getTop());
        if (rectF.right < rectF.left) {
            float f = rectF.right;
            rectF.right = rectF.left;
            rectF.left = f;
        }
        if (rectF.bottom < rectF.top) {
            float f2 = rectF.top;
            rectF.top = rectF.bottom;
            rectF.bottom = f2;
        }
    }

    /* renamed from: o */
    private void m4859o() {
        View view = this.f3097c.get();
        if (view != null) {
            m4858a(this.f3110p, view);
        }
    }

    /* renamed from: p */
    private void m4860p() {
        View view = this.f3097c.get();
        if (view != null && view.getParent() != null) {
            RectF rectF = this.f3111q;
            m4858a(rectF, view);
            rectF.union(this.f3110p);
            ((View) view.getParent()).invalidate((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
        }
    }

    /* renamed from: a */
    public float mo7083a() {
        return this.f3100f;
    }

    /* renamed from: a */
    public void mo7084a(float f) {
        if (this.f3100f != f) {
            this.f3100f = f;
            View view = this.f3097c.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    /* renamed from: a */
    public void mo7085a(int i) {
        View view = this.f3097c.get();
        if (view != null) {
            view.scrollTo(i, view.getScrollY());
        }
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float interpolatedTime, Transformation t) {
        View view = this.f3097c.get();
        if (view != null) {
            t.setAlpha(this.f3100f);
            m4857a(t.getMatrix(), view);
        }
    }

    /* renamed from: b */
    public float mo7087b() {
        return this.f3101g;
    }

    /* renamed from: b */
    public void mo7088b(float f) {
        if (!this.f3099e || this.f3101g != f) {
            m4859o();
            this.f3099e = true;
            this.f3101g = f;
            m4860p();
        }
    }

    /* renamed from: b */
    public void mo7089b(int i) {
        View view = this.f3097c.get();
        if (view != null) {
            view.scrollTo(view.getScrollX(), i);
        }
    }

    /* renamed from: c */
    public float mo7090c() {
        return this.f3102h;
    }

    /* renamed from: c */
    public void mo7091c(float f) {
        if (!this.f3099e || this.f3102h != f) {
            m4859o();
            this.f3099e = true;
            this.f3102h = f;
            m4860p();
        }
    }

    /* renamed from: d */
    public float mo7092d() {
        return this.f3105k;
    }

    /* renamed from: d */
    public void mo7093d(float f) {
        if (this.f3105k != f) {
            m4859o();
            this.f3105k = f;
            m4860p();
        }
    }

    /* renamed from: e */
    public float mo7094e() {
        return this.f3103i;
    }

    /* renamed from: e */
    public void mo7095e(float f) {
        if (this.f3103i != f) {
            m4859o();
            this.f3103i = f;
            m4860p();
        }
    }

    /* renamed from: f */
    public float mo7096f() {
        return this.f3104j;
    }

    /* renamed from: f */
    public void mo7097f(float f) {
        if (this.f3104j != f) {
            m4859o();
            this.f3104j = f;
            m4860p();
        }
    }

    /* renamed from: g */
    public float mo7098g() {
        return this.f3106l;
    }

    /* renamed from: g */
    public void mo7099g(float f) {
        if (this.f3106l != f) {
            m4859o();
            this.f3106l = f;
            m4860p();
        }
    }

    /* renamed from: h */
    public float mo7100h() {
        return this.f3107m;
    }

    /* renamed from: h */
    public void mo7101h(float f) {
        if (this.f3107m != f) {
            m4859o();
            this.f3107m = f;
            m4860p();
        }
    }

    /* renamed from: i */
    public int mo7102i() {
        View view = this.f3097c.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollX();
    }

    /* renamed from: i */
    public void mo7103i(float f) {
        if (this.f3108n != f) {
            m4859o();
            this.f3108n = f;
            m4860p();
        }
    }

    /* renamed from: j */
    public int mo7104j() {
        View view = this.f3097c.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollY();
    }

    /* renamed from: j */
    public void mo7105j(float f) {
        if (this.f3109o != f) {
            m4859o();
            this.f3109o = f;
            m4860p();
        }
    }

    /* renamed from: k */
    public float mo7106k() {
        return this.f3108n;
    }

    /* renamed from: k */
    public void mo7107k(float f) {
        View view = this.f3097c.get();
        if (view != null) {
            mo7103i(f - ((float) view.getLeft()));
        }
    }

    /* renamed from: l */
    public float mo7108l() {
        return this.f3109o;
    }

    /* renamed from: l */
    public void mo7109l(float f) {
        View view = this.f3097c.get();
        if (view != null) {
            mo7105j(f - ((float) view.getTop()));
        }
    }

    /* renamed from: m */
    public float mo7110m() {
        View view = this.f3097c.get();
        if (view == null) {
            return 0.0f;
        }
        return ((float) view.getLeft()) + this.f3108n;
    }

    /* renamed from: n */
    public float mo7111n() {
        View view = this.f3097c.get();
        if (view == null) {
            return 0.0f;
        }
        return ((float) view.getTop()) + this.f3109o;
    }
}
