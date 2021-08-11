package android.support.p007v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.TextView;

/* renamed from: android.support.v4.widget.TextViewCompat */
public class TextViewCompat {
    static final TextViewCompatImpl IMPL;

    /* renamed from: android.support.v4.widget.TextViewCompat$TextViewCompatImpl */
    interface TextViewCompatImpl {
        int getMaxLines(TextView textView);

        int getMinLines(TextView textView);

        void setCompoundDrawablesRelative(@NonNull TextView textView, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4);

        void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView textView, int i, int i2, int i3, int i4);

        void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView textView, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4);
    }

    private TextViewCompat() {
    }

    /* renamed from: android.support.v4.widget.TextViewCompat$BaseTextViewCompatImpl */
    static class BaseTextViewCompatImpl implements TextViewCompatImpl {
        BaseTextViewCompatImpl() {
        }

        @Override // android.support.p007v4.widget.TextViewCompat.TextViewCompatImpl
        public void setCompoundDrawablesRelative(@NonNull TextView textView, @Nullable Drawable start, @Nullable Drawable top, @Nullable Drawable end, @Nullable Drawable bottom) {
            textView.setCompoundDrawables(start, top, end, bottom);
        }

        @Override // android.support.p007v4.widget.TextViewCompat.TextViewCompatImpl
        public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView textView, @Nullable Drawable start, @Nullable Drawable top, @Nullable Drawable end, @Nullable Drawable bottom) {
            textView.setCompoundDrawablesWithIntrinsicBounds(start, top, end, bottom);
        }

        @Override // android.support.p007v4.widget.TextViewCompat.TextViewCompatImpl
        public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView textView, int start, int top, int end, int bottom) {
            textView.setCompoundDrawablesWithIntrinsicBounds(start, top, end, bottom);
        }

        @Override // android.support.p007v4.widget.TextViewCompat.TextViewCompatImpl
        public int getMaxLines(TextView textView) {
            return TextViewCompatDonut.getMaxLines(textView);
        }

        @Override // android.support.p007v4.widget.TextViewCompat.TextViewCompatImpl
        public int getMinLines(TextView textView) {
            return TextViewCompatDonut.getMinLines(textView);
        }
    }

    /* renamed from: android.support.v4.widget.TextViewCompat$JbTextViewCompatImpl */
    static class JbTextViewCompatImpl extends BaseTextViewCompatImpl {
        JbTextViewCompatImpl() {
        }

        @Override // android.support.p007v4.widget.TextViewCompat.TextViewCompatImpl, android.support.p007v4.widget.TextViewCompat.BaseTextViewCompatImpl
        public int getMaxLines(TextView textView) {
            return TextViewCompatJb.getMaxLines(textView);
        }

        @Override // android.support.p007v4.widget.TextViewCompat.TextViewCompatImpl, android.support.p007v4.widget.TextViewCompat.BaseTextViewCompatImpl
        public int getMinLines(TextView textView) {
            return TextViewCompatJb.getMinLines(textView);
        }
    }

    /* renamed from: android.support.v4.widget.TextViewCompat$JbMr1TextViewCompatImpl */
    static class JbMr1TextViewCompatImpl extends JbTextViewCompatImpl {
        JbMr1TextViewCompatImpl() {
        }

        @Override // android.support.p007v4.widget.TextViewCompat.TextViewCompatImpl, android.support.p007v4.widget.TextViewCompat.BaseTextViewCompatImpl
        public void setCompoundDrawablesRelative(@NonNull TextView textView, @Nullable Drawable start, @Nullable Drawable top, @Nullable Drawable end, @Nullable Drawable bottom) {
            TextViewCompatJbMr1.setCompoundDrawablesRelative(textView, start, top, end, bottom);
        }

        @Override // android.support.p007v4.widget.TextViewCompat.TextViewCompatImpl, android.support.p007v4.widget.TextViewCompat.BaseTextViewCompatImpl
        public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView textView, @Nullable Drawable start, @Nullable Drawable top, @Nullable Drawable end, @Nullable Drawable bottom) {
            TextViewCompatJbMr1.setCompoundDrawablesRelativeWithIntrinsicBounds(textView, start, top, end, bottom);
        }

        @Override // android.support.p007v4.widget.TextViewCompat.TextViewCompatImpl, android.support.p007v4.widget.TextViewCompat.BaseTextViewCompatImpl
        public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView textView, int start, int top, int end, int bottom) {
            TextViewCompatJbMr1.setCompoundDrawablesRelativeWithIntrinsicBounds(textView, start, top, end, bottom);
        }
    }

    /* renamed from: android.support.v4.widget.TextViewCompat$JbMr2TextViewCompatImpl */
    static class JbMr2TextViewCompatImpl extends JbMr1TextViewCompatImpl {
        JbMr2TextViewCompatImpl() {
        }

        @Override // android.support.p007v4.widget.TextViewCompat.TextViewCompatImpl, android.support.p007v4.widget.TextViewCompat.BaseTextViewCompatImpl, android.support.p007v4.widget.TextViewCompat.JbMr1TextViewCompatImpl
        public void setCompoundDrawablesRelative(@NonNull TextView textView, @Nullable Drawable start, @Nullable Drawable top, @Nullable Drawable end, @Nullable Drawable bottom) {
            TextViewCompatJbMr2.setCompoundDrawablesRelative(textView, start, top, end, bottom);
        }

        @Override // android.support.p007v4.widget.TextViewCompat.TextViewCompatImpl, android.support.p007v4.widget.TextViewCompat.BaseTextViewCompatImpl, android.support.p007v4.widget.TextViewCompat.JbMr1TextViewCompatImpl
        public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView textView, @Nullable Drawable start, @Nullable Drawable top, @Nullable Drawable end, @Nullable Drawable bottom) {
            TextViewCompatJbMr2.setCompoundDrawablesRelativeWithIntrinsicBounds(textView, start, top, end, bottom);
        }

        @Override // android.support.p007v4.widget.TextViewCompat.TextViewCompatImpl, android.support.p007v4.widget.TextViewCompat.BaseTextViewCompatImpl, android.support.p007v4.widget.TextViewCompat.JbMr1TextViewCompatImpl
        public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView textView, int start, int top, int end, int bottom) {
            TextViewCompatJbMr2.setCompoundDrawablesRelativeWithIntrinsicBounds(textView, start, top, end, bottom);
        }
    }

    static {
        int version = Build.VERSION.SDK_INT;
        if (version >= 18) {
            IMPL = new JbMr2TextViewCompatImpl();
        } else if (version >= 17) {
            IMPL = new JbMr1TextViewCompatImpl();
        } else if (version >= 16) {
            IMPL = new JbTextViewCompatImpl();
        } else {
            IMPL = new BaseTextViewCompatImpl();
        }
    }

    public static void setCompoundDrawablesRelative(@NonNull TextView textView, @Nullable Drawable start, @Nullable Drawable top, @Nullable Drawable end, @Nullable Drawable bottom) {
        IMPL.setCompoundDrawablesRelative(textView, start, top, end, bottom);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView textView, @Nullable Drawable start, @Nullable Drawable top, @Nullable Drawable end, @Nullable Drawable bottom) {
        IMPL.setCompoundDrawablesRelativeWithIntrinsicBounds(textView, start, top, end, bottom);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView textView, int start, int top, int end, int bottom) {
        IMPL.setCompoundDrawablesRelativeWithIntrinsicBounds(textView, start, top, end, bottom);
    }

    public static int getMaxLines(@NonNull TextView textView) {
        return IMPL.getMaxLines(textView);
    }

    public static int getMinLines(@NonNull TextView textView) {
        return IMPL.getMinLines(textView);
    }
}
