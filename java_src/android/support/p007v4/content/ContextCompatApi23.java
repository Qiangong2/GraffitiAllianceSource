package android.support.p007v4.content;

import android.content.Context;
import android.content.res.ColorStateList;

/* renamed from: android.support.v4.content.ContextCompatApi23 */
class ContextCompatApi23 {
    ContextCompatApi23() {
    }

    public static ColorStateList getColorStateList(Context context, int id) {
        return context.getColorStateList(id);
    }

    public static int getColor(Context context, int id) {
        return context.getColor(id);
    }
}