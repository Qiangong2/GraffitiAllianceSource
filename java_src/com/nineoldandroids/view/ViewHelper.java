package com.nineoldandroids.view;

import android.view.View;
import com.nineoldandroids.view.p084a.C1217a;

public final class ViewHelper {

    private static final class Honeycomb {
        private Honeycomb() {
        }

        static float getAlpha(View view) {
            return view.getAlpha();
        }

        static float getPivotX(View view) {
            return view.getPivotX();
        }

        static float getPivotY(View view) {
            return view.getPivotY();
        }

        static float getRotation(View view) {
            return view.getRotation();
        }

        static float getRotationX(View view) {
            return view.getRotationX();
        }

        static float getRotationY(View view) {
            return view.getRotationY();
        }

        static float getScaleX(View view) {
            return view.getScaleX();
        }

        static float getScaleY(View view) {
            return view.getScaleY();
        }

        static float getScrollX(View view) {
            return (float) view.getScrollX();
        }

        static float getScrollY(View view) {
            return (float) view.getScrollY();
        }

        static float getTranslationX(View view) {
            return view.getTranslationX();
        }

        static float getTranslationY(View view) {
            return view.getTranslationY();
        }

        static float getX(View view) {
            return view.getX();
        }

        static float getY(View view) {
            return view.getY();
        }

        static void setAlpha(View view, float alpha) {
            view.setAlpha(alpha);
        }

        static void setPivotX(View view, float pivotX) {
            view.setPivotX(pivotX);
        }

        static void setPivotY(View view, float pivotY) {
            view.setPivotY(pivotY);
        }

        static void setRotation(View view, float rotation) {
            view.setRotation(rotation);
        }

        static void setRotationX(View view, float rotationX) {
            view.setRotationX(rotationX);
        }

        static void setRotationY(View view, float rotationY) {
            view.setRotationY(rotationY);
        }

        static void setScaleX(View view, float scaleX) {
            view.setScaleX(scaleX);
        }

        static void setScaleY(View view, float scaleY) {
            view.setScaleY(scaleY);
        }

        static void setScrollX(View view, int scrollX) {
            view.setScrollX(scrollX);
        }

        static void setScrollY(View view, int scrollY) {
            view.setScrollY(scrollY);
        }

        static void setTranslationX(View view, float translationX) {
            view.setTranslationX(translationX);
        }

        static void setTranslationY(View view, float translationY) {
            view.setTranslationY(translationY);
        }

        static void setX(View view, float x) {
            view.setX(x);
        }

        static void setY(View view, float y) {
            view.setY(y);
        }
    }

    private ViewHelper() {
    }

    public static float getAlpha(View view) {
        return C1217a.f3095a ? C1217a.m4856a(view).mo7083a() : Honeycomb.getAlpha(view);
    }

    public static float getPivotX(View view) {
        return C1217a.f3095a ? C1217a.m4856a(view).mo7087b() : Honeycomb.getPivotX(view);
    }

    public static float getPivotY(View view) {
        return C1217a.f3095a ? C1217a.m4856a(view).mo7090c() : Honeycomb.getPivotY(view);
    }

    public static float getRotation(View view) {
        return C1217a.f3095a ? C1217a.m4856a(view).mo7092d() : Honeycomb.getRotation(view);
    }

    public static float getRotationX(View view) {
        return C1217a.f3095a ? C1217a.m4856a(view).mo7094e() : Honeycomb.getRotationX(view);
    }

    public static float getRotationY(View view) {
        return C1217a.f3095a ? C1217a.m4856a(view).mo7096f() : Honeycomb.getRotationY(view);
    }

    public static float getScaleX(View view) {
        return C1217a.f3095a ? C1217a.m4856a(view).mo7098g() : Honeycomb.getScaleX(view);
    }

    public static float getScaleY(View view) {
        return C1217a.f3095a ? C1217a.m4856a(view).mo7100h() : Honeycomb.getScaleY(view);
    }

    public static float getScrollX(View view) {
        return C1217a.f3095a ? (float) C1217a.m4856a(view).mo7102i() : Honeycomb.getScrollX(view);
    }

    public static float getScrollY(View view) {
        return C1217a.f3095a ? (float) C1217a.m4856a(view).mo7104j() : Honeycomb.getScrollY(view);
    }

    public static float getTranslationX(View view) {
        return C1217a.f3095a ? C1217a.m4856a(view).mo7106k() : Honeycomb.getTranslationX(view);
    }

    public static float getTranslationY(View view) {
        return C1217a.f3095a ? C1217a.m4856a(view).mo7108l() : Honeycomb.getTranslationY(view);
    }

    public static float getX(View view) {
        return C1217a.f3095a ? C1217a.m4856a(view).mo7110m() : Honeycomb.getX(view);
    }

    public static float getY(View view) {
        return C1217a.f3095a ? C1217a.m4856a(view).mo7111n() : Honeycomb.getY(view);
    }

    public static void setAlpha(View view, float alpha) {
        if (C1217a.f3095a) {
            C1217a.m4856a(view).mo7084a(alpha);
        } else {
            Honeycomb.setAlpha(view, alpha);
        }
    }

    public static void setPivotX(View view, float pivotX) {
        if (C1217a.f3095a) {
            C1217a.m4856a(view).mo7088b(pivotX);
        } else {
            Honeycomb.setPivotX(view, pivotX);
        }
    }

    public static void setPivotY(View view, float pivotY) {
        if (C1217a.f3095a) {
            C1217a.m4856a(view).mo7091c(pivotY);
        } else {
            Honeycomb.setPivotY(view, pivotY);
        }
    }

    public static void setRotation(View view, float rotation) {
        if (C1217a.f3095a) {
            C1217a.m4856a(view).mo7093d(rotation);
        } else {
            Honeycomb.setRotation(view, rotation);
        }
    }

    public static void setRotationX(View view, float rotationX) {
        if (C1217a.f3095a) {
            C1217a.m4856a(view).mo7095e(rotationX);
        } else {
            Honeycomb.setRotationX(view, rotationX);
        }
    }

    public static void setRotationY(View view, float rotationY) {
        if (C1217a.f3095a) {
            C1217a.m4856a(view).mo7097f(rotationY);
        } else {
            Honeycomb.setRotationY(view, rotationY);
        }
    }

    public static void setScaleX(View view, float scaleX) {
        if (C1217a.f3095a) {
            C1217a.m4856a(view).mo7099g(scaleX);
        } else {
            Honeycomb.setScaleX(view, scaleX);
        }
    }

    public static void setScaleY(View view, float scaleY) {
        if (C1217a.f3095a) {
            C1217a.m4856a(view).mo7101h(scaleY);
        } else {
            Honeycomb.setScaleY(view, scaleY);
        }
    }

    public static void setScrollX(View view, int scrollX) {
        if (C1217a.f3095a) {
            C1217a.m4856a(view).mo7085a(scrollX);
        } else {
            Honeycomb.setScrollX(view, scrollX);
        }
    }

    public static void setScrollY(View view, int scrollY) {
        if (C1217a.f3095a) {
            C1217a.m4856a(view).mo7089b(scrollY);
        } else {
            Honeycomb.setScrollY(view, scrollY);
        }
    }

    public static void setTranslationX(View view, float translationX) {
        if (C1217a.f3095a) {
            C1217a.m4856a(view).mo7103i(translationX);
        } else {
            Honeycomb.setTranslationX(view, translationX);
        }
    }

    public static void setTranslationY(View view, float translationY) {
        if (C1217a.f3095a) {
            C1217a.m4856a(view).mo7105j(translationY);
        } else {
            Honeycomb.setTranslationY(view, translationY);
        }
    }

    public static void setX(View view, float x) {
        if (C1217a.f3095a) {
            C1217a.m4856a(view).mo7107k(x);
        } else {
            Honeycomb.setX(view, x);
        }
    }

    public static void setY(View view, float y) {
        if (C1217a.f3095a) {
            C1217a.m4856a(view).mo7109l(y);
        } else {
            Honeycomb.setY(view, y);
        }
    }
}
