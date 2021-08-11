package com.nineoldandroids.animation;

import android.view.View;
import com.nineoldandroids.util.FloatProperty;
import com.nineoldandroids.util.IntProperty;
import com.nineoldandroids.util.Property;
import com.nineoldandroids.view.p084a.C1217a;

final class PreHoneycombCompat {
    static Property<View, Float> ALPHA = new FloatProperty<View>("alpha") {
        /* class com.nineoldandroids.animation.PreHoneycombCompat.C11941 */

        public Float get(View object) {
            return Float.valueOf(C1217a.m4856a(object).mo7083a());
        }

        public void setValue(View object, float value) {
            C1217a.m4856a(object).mo7084a(value);
        }
    };
    static Property<View, Float> PIVOT_X = new FloatProperty<View>("pivotX") {
        /* class com.nineoldandroids.animation.PreHoneycombCompat.C12002 */

        public Float get(View object) {
            return Float.valueOf(C1217a.m4856a(object).mo7087b());
        }

        public void setValue(View object, float value) {
            C1217a.m4856a(object).mo7088b(value);
        }
    };
    static Property<View, Float> PIVOT_Y = new FloatProperty<View>("pivotY") {
        /* class com.nineoldandroids.animation.PreHoneycombCompat.C12013 */

        public Float get(View object) {
            return Float.valueOf(C1217a.m4856a(object).mo7090c());
        }

        public void setValue(View object, float value) {
            C1217a.m4856a(object).mo7091c(value);
        }
    };
    static Property<View, Float> ROTATION = new FloatProperty<View>("rotation") {
        /* class com.nineoldandroids.animation.PreHoneycombCompat.C12046 */

        public Float get(View object) {
            return Float.valueOf(C1217a.m4856a(object).mo7092d());
        }

        public void setValue(View object, float value) {
            C1217a.m4856a(object).mo7093d(value);
        }
    };
    static Property<View, Float> ROTATION_X = new FloatProperty<View>("rotationX") {
        /* class com.nineoldandroids.animation.PreHoneycombCompat.C12057 */

        public Float get(View object) {
            return Float.valueOf(C1217a.m4856a(object).mo7094e());
        }

        public void setValue(View object, float value) {
            C1217a.m4856a(object).mo7095e(value);
        }
    };
    static Property<View, Float> ROTATION_Y = new FloatProperty<View>("rotationY") {
        /* class com.nineoldandroids.animation.PreHoneycombCompat.C12068 */

        public Float get(View object) {
            return Float.valueOf(C1217a.m4856a(object).mo7096f());
        }

        public void setValue(View object, float value) {
            C1217a.m4856a(object).mo7097f(value);
        }
    };
    static Property<View, Float> SCALE_X = new FloatProperty<View>("scaleX") {
        /* class com.nineoldandroids.animation.PreHoneycombCompat.C12079 */

        public Float get(View object) {
            return Float.valueOf(C1217a.m4856a(object).mo7098g());
        }

        public void setValue(View object, float value) {
            C1217a.m4856a(object).mo7099g(value);
        }
    };
    static Property<View, Float> SCALE_Y = new FloatProperty<View>("scaleY") {
        /* class com.nineoldandroids.animation.PreHoneycombCompat.C119510 */

        public Float get(View object) {
            return Float.valueOf(C1217a.m4856a(object).mo7100h());
        }

        public void setValue(View object, float value) {
            C1217a.m4856a(object).mo7101h(value);
        }
    };
    static Property<View, Integer> SCROLL_X = new IntProperty<View>("scrollX") {
        /* class com.nineoldandroids.animation.PreHoneycombCompat.C119611 */

        public Integer get(View object) {
            return Integer.valueOf(C1217a.m4856a(object).mo7102i());
        }

        public void setValue(View object, int value) {
            C1217a.m4856a(object).mo7085a(value);
        }
    };
    static Property<View, Integer> SCROLL_Y = new IntProperty<View>("scrollY") {
        /* class com.nineoldandroids.animation.PreHoneycombCompat.C119712 */

        public Integer get(View object) {
            return Integer.valueOf(C1217a.m4856a(object).mo7104j());
        }

        public void setValue(View object, int value) {
            C1217a.m4856a(object).mo7089b(value);
        }
    };
    static Property<View, Float> TRANSLATION_X = new FloatProperty<View>("translationX") {
        /* class com.nineoldandroids.animation.PreHoneycombCompat.C12024 */

        public Float get(View object) {
            return Float.valueOf(C1217a.m4856a(object).mo7106k());
        }

        public void setValue(View object, float value) {
            C1217a.m4856a(object).mo7103i(value);
        }
    };
    static Property<View, Float> TRANSLATION_Y = new FloatProperty<View>("translationY") {
        /* class com.nineoldandroids.animation.PreHoneycombCompat.C12035 */

        public Float get(View object) {
            return Float.valueOf(C1217a.m4856a(object).mo7108l());
        }

        public void setValue(View object, float value) {
            C1217a.m4856a(object).mo7105j(value);
        }
    };

    /* renamed from: X */
    static Property<View, Float> f3089X = new FloatProperty<View>("x") {
        /* class com.nineoldandroids.animation.PreHoneycombCompat.C119813 */

        public Float get(View object) {
            return Float.valueOf(C1217a.m4856a(object).mo7110m());
        }

        public void setValue(View object, float value) {
            C1217a.m4856a(object).mo7107k(value);
        }
    };

    /* renamed from: Y */
    static Property<View, Float> f3090Y = new FloatProperty<View>("y") {
        /* class com.nineoldandroids.animation.PreHoneycombCompat.C119914 */

        public Float get(View object) {
            return Float.valueOf(C1217a.m4856a(object).mo7111n());
        }

        public void setValue(View object, float value) {
            C1217a.m4856a(object).mo7109l(value);
        }
    };

    private PreHoneycombCompat() {
    }
}
