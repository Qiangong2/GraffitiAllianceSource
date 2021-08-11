package android.support.p007v4.text;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p007v4.view.MotionEventCompat;
import java.util.Locale;

/* renamed from: android.support.v4.text.TextUtilsCompat */
public class TextUtilsCompat {
    private static String ARAB_SCRIPT_SUBTAG = "Arab";
    private static String HEBR_SCRIPT_SUBTAG = "Hebr";
    private static final TextUtilsCompatImpl IMPL;
    public static final Locale ROOT = new Locale("", "");

    /* access modifiers changed from: private */
    /* renamed from: android.support.v4.text.TextUtilsCompat$TextUtilsCompatImpl */
    public static class TextUtilsCompatImpl {
        private TextUtilsCompatImpl() {
        }

        @NonNull
        public String htmlEncode(@NonNull String s) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                switch (c) {
                    case MotionEventCompat.AXIS_GENERIC_3 /*{ENCODED_INT: 34}*/:
                        sb.append("&quot;");
                        break;
                    case MotionEventCompat.AXIS_GENERIC_7 /*{ENCODED_INT: 38}*/:
                        sb.append("&amp;");
                        break;
                    case MotionEventCompat.AXIS_GENERIC_8 /*{ENCODED_INT: 39}*/:
                        sb.append("&#39;");
                        break;
                    case '<':
                        sb.append("&lt;");
                        break;
                    case '>':
                        sb.append("&gt;");
                        break;
                    default:
                        sb.append(c);
                        break;
                }
            }
            return sb.toString();
        }

        public int getLayoutDirectionFromLocale(@Nullable Locale locale) {
            if (locale != null && !locale.equals(TextUtilsCompat.ROOT)) {
                String scriptSubtag = ICUCompat.maximizeAndGetScript(locale);
                if (scriptSubtag == null) {
                    return getLayoutDirectionFromFirstChar(locale);
                }
                if (scriptSubtag.equalsIgnoreCase(TextUtilsCompat.ARAB_SCRIPT_SUBTAG) || scriptSubtag.equalsIgnoreCase(TextUtilsCompat.HEBR_SCRIPT_SUBTAG)) {
                    return 1;
                }
            }
            return 0;
        }

        private static int getLayoutDirectionFromFirstChar(@NonNull Locale locale) {
            switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
                case 1:
                case 2:
                    return 1;
                default:
                    return 0;
            }
        }
    }

    /* renamed from: android.support.v4.text.TextUtilsCompat$TextUtilsCompatJellybeanMr1Impl */
    private static class TextUtilsCompatJellybeanMr1Impl extends TextUtilsCompatImpl {
        private TextUtilsCompatJellybeanMr1Impl() {
            super();
        }

        @Override // android.support.p007v4.text.TextUtilsCompat.TextUtilsCompatImpl
        @NonNull
        public String htmlEncode(@NonNull String s) {
            return TextUtilsCompatJellybeanMr1.htmlEncode(s);
        }

        @Override // android.support.p007v4.text.TextUtilsCompat.TextUtilsCompatImpl
        public int getLayoutDirectionFromLocale(@Nullable Locale locale) {
            return TextUtilsCompatJellybeanMr1.getLayoutDirectionFromLocale(locale);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            IMPL = new TextUtilsCompatJellybeanMr1Impl();
        } else {
            IMPL = new TextUtilsCompatImpl();
        }
    }

    @NonNull
    public static String htmlEncode(@NonNull String s) {
        return IMPL.htmlEncode(s);
    }

    public static int getLayoutDirectionFromLocale(@Nullable Locale locale) {
        return IMPL.getLayoutDirectionFromLocale(locale);
    }
}